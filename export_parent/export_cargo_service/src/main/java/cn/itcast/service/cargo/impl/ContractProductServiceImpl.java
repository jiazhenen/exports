package cn.itcast.service.cargo.impl;

import cn.itcast.dao.cargo.ContractDao;
import cn.itcast.dao.cargo.ContractProductDao;
import cn.itcast.dao.cargo.ExtCproductDao;
import cn.itcast.domain.cargo.Contract;
import cn.itcast.domain.cargo.ContractProduct;
import cn.itcast.domain.cargo.ContractProductExample;
import cn.itcast.domain.cargo.ExtCproduct;
import cn.itcast.service.cargo.ContractProductService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ContractProductServiceImpl implements ContractProductService {

    @Autowired
    private ContractProductDao contractProductDao;
    @Autowired
    private ContractDao contractDao;
    @Autowired
    private ExtCproductDao extCproductDao;
    @Override
    public void save(ContractProduct contractProduct) {
////        1、单价 * 数量 = 计算出小计金额
        Double price = contractProduct.getPrice();
        Integer cnumber = contractProduct.getCnumber();
        Double amount = price*cnumber;
        contractProduct.setAmount(amount);

        String contractId = contractProduct.getContractId();//合同id
//        根据合同id查询合同对象
        Contract contract = contractDao.selectByPrimaryKey(contractId);
       /*
        2、修改合同数据
                 2.1 货物数量  直接+1
                 2.2 总金额  = 原来总金额+小计金额
      */
        contract.setProNum(contract.getProNum()+1); //货物数量  直接+1
        contract.setTotalAmount(contract.getTotalAmount()+amount);  //总金额  = 原来总金额+小计金额
        contractDao.updateByPrimaryKeySelective(contract); //更新到表中

        contractProductDao.insertSelective(contractProduct);
    }

    @Override
    public void update(ContractProduct contractProduct) {

        String productId = contractProduct.getId();
        ContractProduct contractProduct_old = contractProductDao.selectByPrimaryKey(productId);
        Double amount_old = contractProduct_old.getAmount();

        //        1、单价 * 数量 = 计算出小计金额
        Double price = contractProduct.getPrice();
        Integer cnumber = contractProduct.getCnumber();
        Double amount_new = price*cnumber;
        contractProduct.setAmount(amount_new);
        String contractId = contractProduct.getContractId();//合同id
//        根据合同id查询合同对象
        Contract contract = contractDao.selectByPrimaryKey(contractId);
        contract.setTotalAmount(contract.getTotalAmount()-amount_old+amount_new);// =总金额-货物旧的小计金额+货物新的小计金额
        contractDao.updateByPrimaryKeySelective(contract); //更新到表中

        contractProductDao.updateByPrimaryKeySelective(contractProduct);
    }

    @Override
    public void delete(String id) {
        //        1、删除货物
//        2、删除此货物下的附件  delete from co_ext_cproduct where product_id=?
//        3、修改合同的货物数量 货物数量直接-1
//        4、修改合同的附件数量 附件数量-此货物下的附件数
//        5、修改合同的总金额   总金额-货物的小计金额-（此货物下所有附件的小计金额）
        
        ContractProduct contractProduct = contractProductDao.selectByPrimaryKey(id);
        Double amount = contractProduct.getAmount();//小计金额
//        根据货物查询此货物下的附件 select * from co_ext_cproduct where product_id=?
        List<ExtCproduct> extCproducts = contractProduct.getExtCproducts(); //dao的映射文件中已经有了一对多的查询映射
        Double extTotalAmount = 0.0;
        for (ExtCproduct extCproduct : extCproducts) {
            extTotalAmount+=extCproduct.getAmount();//每个附件的小计金额
            extCproductDao.deleteByPrimaryKey(extCproduct.getId());//删除此货物下的附件
        }
        String contractId = contractProduct.getContractId();
//        根据合同id查询合同对象
        Contract contract = contractDao.selectByPrimaryKey(contractId);
        contract.setProNum(contract.getProNum()-1);//修改合同的货物数量 货物数量直接-1
        contract.setExtNum(contract.getExtNum()-extCproducts.size());//修改合同的附件数量 附件数量-此货物下的附件数
        contract.setTotalAmount(contract.getTotalAmount()-contractProduct.getAmount()-extTotalAmount); //修改合同的总金额   总金额-货物的小计金额-（此货物下所有附件的小计金额）
        contractDao.updateByPrimaryKeySelective(contract); //更新到表中

        contractProductDao.deleteByPrimaryKey(id);//删除货物
    }

    @Override
    public ContractProduct findById(String id) {
        return contractProductDao.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo findAll(ContractProductExample example, int page, int size) {
        PageHelper.startPage(page,size);
        List<ContractProduct> list = contractProductDao.selectByExample(example);
        return new PageInfo(list);
    }

    @Override
    public void saveList(List<ContractProduct> productList) {
        for (ContractProduct contractProduct : productList) {
           this.save(contractProduct);//保存货物数据
        }
    }
}
