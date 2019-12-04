package cn.itcast.controller.cargo;

import cn.itcast.controller.BaseController;
import cn.itcast.domain.cargo.*;
import cn.itcast.service.cargo.ContractProductService;
import cn.itcast.service.cargo.ContractService;
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
    private ContractService contractService;
    @Reference
    private FactoryService factoryService;
    @Reference
    private ContractProductService contractProductService;
    @Reference
    private ExtCproductService  extCproductService;

    @RequestMapping(value = "/list",name = "进入添加货物的附件页面")
    public String findPage(String contractId,String contractProductId,@RequestParam(name="page",defaultValue = "1") int pageNum,@RequestParam(defaultValue = "10")  int size){
//        需要向request中放的数据：生成附件的厂家、此货物下的附件列表数据
        FactoryExample example = new FactoryExample();
        example.createCriteria().andCtypeEqualTo("附件");
        List<Factory> factoryList = factoryService.findAll(example);
        request.setAttribute("factoryList",factoryList);

//        根据货物id查询附件 select * from co_ext_cproduct where contract_product_id=?
        ExtCproductExample example1 = new ExtCproductExample();
        example1.createCriteria().andContractProductIdEqualTo(contractProductId);
        PageInfo page = extCproductService.findAll(example1, pageNum, size);
        request.setAttribute("page",page);

//        还需要把contractId和contractProductId放到request中
        request.setAttribute("contractId",contractId);
        request.setAttribute("contractProductId",contractProductId);
        return "cargo/extc/extc-list";
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "cargo/contract/contract-add";
    }

//    id=de8416b0-8115-4a9f-afc3-bf3348e0799b&contractId=b1a6078d-1b1e-4fc4-9492-542b0ff9c860&contractProductId=0d0617f3-2309-47b2-8de5-b5a6776493d9
    @RequestMapping(value = "/toUpdate",name = "进入修改货物下附件页面")
    public String toUpdate(String id,String contractId,String contractProductId){
//        当前附件对象
        ExtCproduct extCproduct = extCproductService.findById(id);
        request.setAttribute("extCproduct",extCproduct);
//        生成附件的工厂
        FactoryExample example = new FactoryExample();
        example.createCriteria().andCtypeEqualTo("附件");
        List<Factory> factoryList = factoryService.findAll(example);
        request.setAttribute("factoryList",factoryList);

        request.setAttribute("contractId",contractId);
        request.setAttribute("contractProductId",contractProductId);
        return "cargo/extc/extc-update";
    }

    @Autowired
    private FileUploadUtil fileUploadUtil;

    @RequestMapping(value = "/edit",name = "保存货物下附件的方法")
    public String edit(ExtCproduct extCproduct, MultipartFile productPhoto){
//        文件的保存 七牛云
        try {
            String upload = fileUploadUtil.upload(productPhoto);
            extCproduct.setProductImage(upload); //把七牛云返回的url设置到表中
        } catch (Exception e) {
            e.printStackTrace();
        }
//        还是根据是否有id判断保存还是修改
        if(StringUtils.isEmpty(extCproduct.getId())){ //新增
            extCproduct.setId(UUID.randomUUID().toString());
            extCproduct.setCreateTime(new Date()); //创建时间
            extCproductService.save(extCproduct);
        }else{
            extCproduct.setUpdateTime(new Date());
            extCproductService.update(extCproduct);
        }
        return "redirect:/cargo/extCproduct/list.do?contractId="+extCproduct.getContractId()+"&contractProductId="+extCproduct.getContractProductId(); //重定向到列表页面
    }


    @RequestMapping(value = "/delete",name = "删除货物下的附件方法")
    public String delete(String id,String contractId,String contractProductId){
        extCproductService.delete(id);
        return "redirect:/cargo/extc/list.do?contractId="+contractId+"&contractProductId="+contractProductId ; //重定向到列表页面
    }
}
