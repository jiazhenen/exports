package cn.itcast.controller.cargo;

import cn.itcast.controller.BaseController;
import cn.itcast.domain.cargo.*;
import cn.itcast.service.cargo.ContractProductService;
import cn.itcast.service.cargo.ExtCproductService;
import cn.itcast.service.cargo.FactoryService;
import cn.itcast.utils.FileUploadUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/cargo/extCproduct")
public class ExtCproductController extends BaseController {

    @Reference
    private ExtCproductService extCproductService;
    @Reference
    private FactoryService factoryService;
    @Reference
    private ContractProductService contractProductService;

    @Autowired
    private FileUploadUtil fileUploadUtil;

    @RequestMapping(value = "/list", name = "展示货物下附件")
    public String list(String contractId, String contractProductId,@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        //设置合同ID
        request.setAttribute("contractId", contractId);
        //设置货物ID
        request.setAttribute("contractProductId",contractProductId);
        //展示生产厂家
        FactoryExample exampleFactory = new FactoryExample();
        exampleFactory.createCriteria().andCtypeEqualTo("附件");
        List<Factory> factoryList = factoryService.findAll(exampleFactory);
        request.setAttribute("factoryList", factoryList);
        //设置附件
        ExtCproductExample extCproductExample = new ExtCproductExample();
        extCproductExample.createCriteria().andContractIdEqualTo(contractId);
        PageInfo pageInfo = extCproductService.findAll(extCproductExample, page, size);
        request.setAttribute("page", pageInfo);
        return "cargo/extc/extc-list";
    }

    @RequestMapping(value = "/toUpdate", name = "进入更新货物下附件页面")
    public String toUpdate(String id,String contractId, String contractProductId) {
        //生产附件的工厂
        FactoryExample exampleFactory = new FactoryExample();
        exampleFactory.createCriteria().andCtypeEqualTo("附件");
        List<Factory> factoryList = factoryService.findAll(exampleFactory);
        request.setAttribute("factoryList", factoryList);
        //附件对象
        ExtCproduct extCproduct = extCproductService.findById(id);
        request.setAttribute("extCproduct", extCproduct);
        //设置隐藏域
        request.setAttribute("contractId",contractId);
        request.setAttribute("contractProductId",contractProductId);
        return "cargo/extc/extc-update";
    }

    @RequestMapping(value = "/edit", name = "保存货物下附件的方法")
    public String edit(ExtCproduct extCproduct,MultipartFile productPhoto) {
        //文件的保存 七牛云
        try {
            String upload = fileUploadUtil.upload(productPhoto);
            extCproduct.setProductImage(upload); //把七牛云返回的url设置到表中
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (StringUtils.isEmpty(extCproduct.getId())) {
            extCproduct.setId(UUID.randomUUID().toString());
            extCproduct.setCreateTime(new Date());
            extCproductService.save(extCproduct);
        } else {
            extCproduct.setUpdateTime(new Date());
            extCproductService.update(extCproduct);
        }
        //重定向到列表页面
        return "redirect:/cargo/extCproduct/list.do?contractId=" + extCproduct.getContractId() + "&contractProductId="+extCproduct.getContractProductId();
    }

    @RequestMapping(value = "/delete", name = "删除货物下附件页面")
    //id:货物ID，contractId：合同ID
    public String delete(String id,String contractId,String contractProductId) {
        extCproductService.delete(id);
        return "redirect:/cargo/extCproduct/list.do?contractId=" + contractId + "&contractProductId="+contractProductId;
    }
}
