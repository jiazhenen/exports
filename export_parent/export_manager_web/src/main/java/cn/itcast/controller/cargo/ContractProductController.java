package cn.itcast.controller.cargo;

import cn.itcast.controller.BaseController;
import cn.itcast.domain.cargo.*;
import cn.itcast.service.cargo.ContractProductService;
import cn.itcast.service.cargo.ContractService;
import cn.itcast.service.cargo.FactoryService;
import cn.itcast.utils.FileUploadUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/cargo/contractProduct")
public class ContractProductController extends BaseController {

    @Reference
    private ContractService contractService;
    @Reference
    private FactoryService factoryService;
    @Reference
    private ContractProductService contractProductService;

    @RequestMapping(value = "/list",name = "进入添加合同下货物的页面")
    public String findPage(String contractId,@RequestParam(name="page",defaultValue = "1") int pageNum,@RequestParam(defaultValue = "10")  int size){
//        需要向request中放的数据：生成货物的厂家、此合同下的货物列表数据
        FactoryExample example = new FactoryExample();
        example.createCriteria().andCtypeEqualTo("货物");
        List<Factory> factoryList = factoryService.findAll(example);
        request.setAttribute("factoryList",factoryList);

//        根据合同id查询货物 select * from co_contract_product where contract_id=?
        ContractProductExample example1 = new ContractProductExample();
        example1.createCriteria().andContractIdEqualTo(contractId);
        PageInfo page = contractProductService.findAll(example1, pageNum, size);
        request.setAttribute("page",page);

//        还需要把contractId放到request中
        request.setAttribute("contractId",contractId);

        return "cargo/product/product-list";
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "cargo/contract/contract-add";
    }
    @RequestMapping(value = "/toUpdate",name = "今天修改合同下货物页面")
    public String toUpdate(String id){
//        当前货物对象
        ContractProduct contractProduct = contractProductService.findById(id);
        request.setAttribute("contractProduct",contractProduct);
//        生成货物的工厂
        FactoryExample example = new FactoryExample();
        example.createCriteria().andCtypeEqualTo("货物");
        List<Factory> factoryList = factoryService.findAll(example);
        request.setAttribute("factoryList",factoryList);
        return "cargo/product/product-update";
    }

    @Autowired
    private FileUploadUtil fileUploadUtil;

    @RequestMapping(value = "/edit",name = "保存合同下货物的方法")
    public String edit(ContractProduct contractProduct, MultipartFile productPhoto){
//        文件的保存 七牛云
        try {
            String upload = fileUploadUtil.upload(productPhoto);
            contractProduct.setProductImage(upload); //把七牛云返回的url设置到表中
        } catch (Exception e) {
            e.printStackTrace();
        }

//        还是根据是否有id判断保存还是修改
        if(StringUtils.isEmpty(contractProduct.getId())){ //新增
            contractProduct.setId(UUID.randomUUID().toString());
            contractProduct.setCreateTime(new Date()); //创建时间
            contractProductService.save(contractProduct);
        }else{
            contractProduct.setUpdateTime(new Date());
            contractProductService.update(contractProduct);
        }
        return "redirect:/cargo/contractProduct/list.do?contractId="+contractProduct.getContractId(); //重定向到列表页面
    }


    @RequestMapping(value = "/delete",name = "删除合同下的货物方法")
    public String delete(String id,String contractId){
        contractProductService.delete(id);
        return "redirect:/cargo/contractProduct/list.do?contractId="+contractId ; //重定向到列表页面
    }

    @RequestMapping(value = "/toImport",name = "进入给合同上传货物的页面")
    public String toImport(String contractId){
        request.setAttribute("contractId",contractId);
        return "cargo/product/product-import" ; //重定向到列表页面
    }
    @RequestMapping(value = "/import",name = "合同上传货物的方法")
    public String importXls(String contractId,MultipartFile file) throws Exception{
//        完成导入的方法
//        读取excel中的内容，把内容转成对象向数据库中插入
        Workbook workbook = new XSSFWorkbook(file.getInputStream());
//        读取第一个sheet
        Sheet sheet = workbook.getSheetAt(0);
        int lastRowIndex = sheet.getLastRowNum();//获取最后一行的索引值

        List<ContractProduct> productList = new ArrayList<>(); //准备接收用来保存的货物对象
        ContractProduct contractProduct = null;
        Row row = null;
        for (int i = 1; i <= lastRowIndex; i++) {
            contractProduct = new ContractProduct();
            row = sheet.getRow(i);
//            读取每一行的内容
//            生产厂家	货号	数量	包装单位(PCS/SETS)	装率	箱数	单价	货物描述	要求
            String factoryName = row.getCell(1).getStringCellValue();
            contractProduct.setFactoryName(factoryName);//生产厂家

            String productNo = row.getCell(2).getStringCellValue();
            contractProduct.setProductNo(productNo);//货号

            Double cnumber = row.getCell(3).getNumericCellValue(); //是数值型，取到的数值型其实是Double
            contractProduct.setCnumber(cnumber.intValue());//数量

            String packingUnit = row.getCell(4).getStringCellValue();
            contractProduct.setPackingUnit(packingUnit);// 包装单位(PCS/SETS)

            Double loadingRate = row.getCell(5).getNumericCellValue();
            contractProduct.setLoadingRate(loadingRate.toString());//装率

            Double boxNum = row.getCell(6).getNumericCellValue();
            contractProduct.setBoxNum(boxNum.intValue());//箱数

            Double price  = row.getCell(7).getNumericCellValue();
            contractProduct.setPrice(price);//单价

            String productDesc = row.getCell(8).getStringCellValue();
            contractProduct.setProductDesc(productDesc);//货物描述

            String productRequest = row.getCell(9).getStringCellValue();
            contractProduct.setProductRequest(productRequest);//要求

            contractProduct.setId(UUID.randomUUID().toString());
            contractProduct.setContractId(contractId);
            contractProduct.setCreateTime(new Date()); //创建时间
            productList.add(contractProduct);

        }
        contractProductService.saveList(productList);

        return "redirect:/cargo/contractProduct/list.do?contractId="+contractId ; //重定向到列表页面
    }

}
