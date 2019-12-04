package cn.itcast.service.cargo.impl;

import cn.itcast.dao.cargo.*;
import cn.itcast.domain.cargo.*;
import cn.itcast.service.cargo.ExportService;
import cn.itcast.vo.ExportProductResult;
import cn.itcast.vo.ExportResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class ExportServiceImpl implements ExportService {

    @Autowired
    private ExportDao exportDao;
    @Autowired
    private ContractDao contractDao;
    @Autowired
    private ContractProductDao contractProductDao;
    @Autowired
    private ExportProductDao exportProductDao;
    @Autowired
    private ExtEproductDao extEproductDao;
    @Override
    public Export findById(String id) {
        return exportDao.selectByPrimaryKey(id);
    }

    @Override
    public void save(Export export) {
         /* 1、关联6张表
        2、保存3张表的数据
        3、货物和附件数据其实就是数据转移*/

        String contractIds = export.getContractIds();//contractIds= "b8cefb8d-142a-4dda-9246-034fc0f43edc,544f5200-4294-4e53-ada5-f1cc03c2bd0e"
//        保存货物
//        先查询购销合同下的货物数据 select * from co_contract_product where contract_ids in ("b8cefb8d-142a-4dda-9246-034fc0f43edc,544f5200-4294-4e53-ada5-f1cc03c2bd0e")
        ContractProductExample productExample = new ContractProductExample();
//        contractIds.split(",");先根据逗号切割成数组

        List<String> contractIdList = Arrays.asList(contractIds.split(","));
        productExample.createCriteria().andContractIdIn(contractIdList);
        List<ContractProduct> contractProductList = contractProductDao.selectByExample(productExample);
//        根据合同下的货物数据向报运单下的货物表中插入数据

        for (ContractProduct contractProduct : contractProductList) {
            ExportProduct exportProduct = new ExportProduct();
//            发现两个对象中的属性值有很多一样的，所以可以直接使用一个工具类赋值
            BeanUtils.copyProperties(contractProduct,exportProduct);
            exportProduct.setExportId(export.getId());//关联报运单id
            exportProductDao.insertSelective(exportProduct);

            List<ExtCproduct> extCproducts = contractProduct.getExtCproducts(); //根据一对多管理而获取的
//            根据货物的附件生成报运单的附件插入到表中
            for (ExtCproduct extCproduct : extCproducts) {
                ExtEproduct extEproduct = new ExtEproduct();
//            发现两个对象中的属性值有很多一样的，所以可以直接使用一个工具类赋值
                BeanUtils.copyProperties(extCproduct,extEproduct);
                extEproduct.setExportId(export.getId());
                extEproduct.setExportProductId(exportProduct.getId());
                extEproductDao.insertSelective(extEproduct);
            }

        }
        ContractExample example = new ContractExample();
        example.createCriteria().andIdIn(contractIdList); //select * from co_contract where id in();
        List<Contract> contracts = contractDao.selectByExample(example);
        Integer totalProNum = 0;
        Integer totalExtNum = 0;
        StringBuffer sb = new StringBuffer("");
        for (Contract contract : contracts) {
            totalProNum+=contract.getProNum();
            totalExtNum+=contract.getExtNum();
            sb.append(contract.getCustomName()).append(" ");
            contract.setState(2);
            contractDao.updateByPrimaryKeySelective(contract);
        }
//        保存报运单之前还需要 货物总数、附件总数、客户名称使用空格连接
        export.setProNum(totalProNum);
        export.setExtNum(totalExtNum);
        export.setCustomerContract(sb.toString());
        exportDao.insertSelective(export); //保存报运单

    }

    @Override
    public void update(Export export) {
//        涉及到两张表的修改
//     1、报运单 1个 export
        exportDao.updateByPrimaryKeySelective(export);
//     2、报运单货物 多个 export.getExportProducts()
        List<ExportProduct> exportProducts = export.getExportProducts();
        if(exportProducts!=null&&exportProducts.size()>0){
            for (ExportProduct exportProduct : exportProducts) {
                exportProductDao.updateByPrimaryKeySelective(exportProduct);
            }
        }
    }

    @Override
    public void delete(String id) {
        exportDao.deleteByPrimaryKey(id);
    }

    @Override
    public PageInfo findAll(ExportExample example, int page, int size) {
        PageHelper.startPage(page,size);
        List<Export> list = exportDao.selectByExample(example);
        return new PageInfo(list);
    }

    @Override
    public void updateE(ExportResult exportResult) {
        //把海关返回的数据更新到我们的表中  报运单表  报运单货物表
        String exportId = exportResult.getExportId();
//        Export export = exportDao.selectByPrimaryKey(exportId);
        Export export = new Export();
        export.setId(exportId);
        export.setState(exportResult.getState());
        export.setRemark(exportResult.getRemark());
        exportDao.updateByPrimaryKeySelective(export);
//        报运单货物表
        Set<ExportProductResult> products = exportResult.getProducts();
        ExportProduct exportProduct = null;
        for (ExportProductResult product : products) {
            exportProduct = new ExportProduct();
            exportProduct.setId( product.getExportProductId());
            exportProduct.setTax( product.getTax());
            exportProductDao.updateByPrimaryKeySelective(exportProduct);
        }
    }
}
