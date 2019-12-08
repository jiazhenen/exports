package cn.itcast.controller.product;

import cn.itcast.controller.BaseController;
import cn.itcast.domain.cargo.Factory;
import cn.itcast.domain.cargo.FactoryExample;
import cn.itcast.domain.cargo.Product;
import cn.itcast.service.cargo.FactoryService;
import cn.itcast.service.cargo.ProductService;
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
@RequestMapping("/product")
public class ProductController extends BaseController {

    @Reference
    private ProductService productService;

    @Reference
    private FactoryService factoryService;

    @Autowired
    private FileUploadUtil fileUploadUtil;

    @RequestMapping(value = "/list",name = "展示货物列表数据")
    public String findAll(@RequestParam(name="page" ,defaultValue = "1") int pageNum, @RequestParam(name="pageSize" ,defaultValue = "10")int pageSize){

        PageInfo page = productService.findPage(pageNum,pageSize);
        request.setAttribute("page",page);  //别忘了修改页面上的list----->page.list
        return "product/product-list";
    }

    @RequestMapping(value = "/toAdd" ,name = "进入新增货物页面")
        public String toAdd( ){
            //生成货物的工厂
            FactoryExample example = new FactoryExample();
            example.createCriteria().andCtypeEqualTo("货物");
            List<Factory> factoryList = factoryService.findAll(example);
            request.setAttribute("factoryList",factoryList);
            return "product/product-add";
    }

    @RequestMapping(value = "/toUpdate" ,name = "进入修改货物页面")
    public String toUpdate(String id){
        //生成货物的工厂
        FactoryExample example = new FactoryExample();
        example.createCriteria().andCtypeEqualTo("货物");
        List<Factory> factoryList = factoryService.findAll(example);
        request.setAttribute("factoryList",factoryList);
        Product product = productService.selectByPrimaryKey(id);
        System.out.println(product.getFactoryname());
        request.setAttribute("product",product);
        return "product/product-add";
    }

    @RequestMapping(value = "/edit",name = "保存货物数据")
    public String edit(Product product ,MultipartFile productPhoto){

        //        文件的保存 七牛云
        try {
            String upload = fileUploadUtil.upload(productPhoto);
            product.setPhoto(upload); //把七牛云返回的url设置到表中
        } catch (Exception e) {
            e.printStackTrace();
        }
        //判断是新增还是修改
        if (StringUtils.isEmpty(product.getId())){
            //新增Id
            product.setId(UUID.randomUUID().toString());
            product.setEntry(new Date());
            product.setCreator(getUser().getId());
            product.setCreatedept(getUser().getDeptName());
            product.setCreatedate(new Date());
            productService.insertSelective(product);
        }else{
            //修改
            product.setCreator(getUser().getId());
            product.setEntry(new Date());
            productService.updateByPrimaryKeySelective(product);
        }
        //重定向到列表页面
        return "redirect:/product/list.do";
    }

    @RequestMapping(value = "/delete" ,name = "删除货物数据")
    public String delete(String id){
        productService.deleteByPrimaryKey(id);
//        重定向到列表页面
        return "redirect:/product/list.do";
    }
}
