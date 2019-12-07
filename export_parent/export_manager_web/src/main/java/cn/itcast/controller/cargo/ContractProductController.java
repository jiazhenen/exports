package cn.itcast.controller.cargo;

import cn.itcast.controller.BaseController;
import cn.itcast.domain.cargo.*;
import cn.itcast.service.cargo.ContractProductService;
import cn.itcast.service.cargo.FactoryService;
import cn.itcast.utils.FileUploadUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
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

///
@Controller
@RequestMapping("/cargo/contractProduct")
public class ContractProductController extends BaseController {

    @Reference
    private FactoryService factoryService;

    @Reference
    private ContractProductService contractProductService;

    @Autowired
    private FileUploadUtil fileUploadUtil;

    @RequestMapping(value = "/list", name = "展示货物")
    public String list(String contractId, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        //设置合同ID
        request.setAttribute("contractId", contractId);
        //展示生产厂家
        FactoryExample exampleFactory = new FactoryExample();
        exampleFactory.createCriteria().andCtypeEqualTo("货物");
        List<Factory> factoryList = factoryService.findAll(exampleFactory);
        request.setAttribute("factoryList", factoryList);
        //货物列表
        //根据合同ID查询货物
        ContractProductExample example = new ContractProductExample();
        example.createCriteria().andContractIdEqualTo(contractId);
        PageInfo pageInfo = contractProductService.findAll(example, page, size);
        request.setAttribute("page", pageInfo);
        return "cargo/product/product-list";
    }

    @RequestMapping(value = "/toUpdate", name = "进入更新合同页面")
    public String toUpdate(String id) {
        //生产货物的工厂
        FactoryExample exampleFactory = new FactoryExample();
        exampleFactory.createCriteria().andCtypeEqualTo("货物");
        List<Factory> factoryList = factoryService.findAll(exampleFactory);
        request.setAttribute("factoryList", factoryList);
        //货物对象
        ContractProduct contractProduct = contractProductService.findById(id);
        request.setAttribute("contractProduct", contractProduct);
        return "cargo/product/product-update";
    }

    @RequestMapping(value = "/edit", name = "保存合同的方法")
    public String edit(ContractProduct contractProduct, MultipartFile productPhoto) {
        if (StringUtils.isEmpty(contractProduct.getId())) {
            try {
                String upload = fileUploadUtil.upload(productPhoto);
                contractProduct.setProductImage(upload);//把七牛云返回的url地址存入到货物数据库
            } catch (Exception e) {
                e.printStackTrace();
            }
            contractProduct.setId(UUID.randomUUID().toString());
            contractProduct.setCreateTime(new Date());
            contractProductService.save(contractProduct);
        } else {
            contractProduct.setUpdateTime(new Date());
            contractProductService.update(contractProduct);
        }
        //重定向到列表页面
        return "redirect:/cargo/contractProduct/list.do?contractId=" + contractProduct.getContractId();
    }

    @RequestMapping(value = "/delete", name = "删除合同页面")
    //id:货物ID，contractId：合同ID
    public String delete(String id, String contractId) {
        contractProductService.delete(id);
        return "redirect:/cargo/contractProduct/list.do?contractId=" + contractId;
    }

    @RequestMapping(value = "/toImport", name = "上传货物页面")
    //contractId：合同ID
    public String toImport(String contractId) {
        request.setAttribute("contractId", contractId);
        return "cargo/product/product-import";
    }

    @RequestMapping(value = "/import", name = "上传货物方法")
    //contractId：合同ID
    public String importXls(String contractId, MultipartFile file) throws Exception {
        //完成导入方法
        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);//第一个sheet
        Cell cell = null;

        List<ContractProduct> list = new ArrayList<>();

        ContractProduct contractProduct = null;
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            contractProduct = new ContractProduct();

            cell = sheet.getRow(i).getCell(1);
            String factoryName = cell.getStringCellValue();
            contractProduct.setFactoryName(factoryName);//生产厂家

            cell = sheet.getRow(i).getCell(2);
            String productNo = cell.getStringCellValue();
            contractProduct.setProductNo(productNo);//货号

            cell = sheet.getRow(i).getCell(3);
            Double cnumber = cell.getNumericCellValue();
            contractProduct.setCnumber(cnumber.intValue());//数量

            cell = sheet.getRow(i).getCell(4);
            String packingUnit = cell.getStringCellValue();
            contractProduct.setPackingUnit(packingUnit);//包装单位

            cell = sheet.getRow(i).getCell(5);
            Double loadingRate = cell.getNumericCellValue();
            contractProduct.setLoadingRate(loadingRate.toString());//装率

            cell = sheet.getRow(i).getCell(6);
            Double boxNum = cell.getNumericCellValue();
            contractProduct.setBoxNum(boxNum.intValue());//箱数

            cell = sheet.getRow(i).getCell(7);
            Double price = cell.getNumericCellValue();
            contractProduct.setPrice(price);//单价

            cell = sheet.getRow(i).getCell(8);
            String productDesc = cell.getStringCellValue();
            contractProduct.setProductDesc(productDesc);//货描

            cell = sheet.getRow(i).getCell(9);
            String productRequest = cell.getStringCellValue();
            contractProduct.setProductRequest(productRequest);//货描
            //合同ID
            contractProduct.setId(UUID.randomUUID().toString());
            contractProduct.setCreateTime(new Date());
            contractProduct.setContractId(contractId);
            //保存到list集合
            list.add(contractProduct);
        }

        contractProductService.saveList(list);
        return "redirect:/cargo/contractProduct/list.do?contractId=" + contractId;
    }

}
