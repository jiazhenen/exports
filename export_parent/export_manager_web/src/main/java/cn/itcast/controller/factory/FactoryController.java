package cn.itcast.controller.factory;

import cn.itcast.controller.BaseController;
import cn.itcast.domain.cargo.Factory;
import cn.itcast.domain.company.Company;
import cn.itcast.service.cargo.FactoryService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.apache.xmlbeans.XmlByte;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/factory")
public class FactoryController extends BaseController {

    @Reference
    private FactoryService factoryService;

    @RequestMapping(value = "/list",name = "展示工厂列表数据")
    public String findAll(@RequestParam(name="page" ,defaultValue = "1") int pageNum, @RequestParam(name="pageSize" ,defaultValue = "10")int pageSize){

        PageInfo page = factoryService.findPage(pageNum,pageSize);
        request.setAttribute("page",page);  //别忘了修改页面上的list----->page.list
        return "factory/factory-list";
    }

    @RequestMapping(value = "/toAdd" ,name = "进入新增工厂页面")
    public String toAdd( ){
        return "factory/factory-add";
    }

    @RequestMapping(value = "/toUpdate" ,name = "进入修改工厂页面")
    public String toUpdate(String id){
        Factory factory = factoryService.findById(id);
        request.setAttribute("factory",factory);
        return "factory/factory-add";
    }

    @RequestMapping(value = "edit",name = "保存工厂数据")
    public String edit(Factory factory ){
        //判断是新增还是修改
        if (StringUtils.isEmpty(factory.getId())){
            //新增Id
            factory.setId(UUID.randomUUID().toString());
            factory.setCreateTime(new Date());
            factory.setUpdateTime(new Date());
            factoryService.save(factory);
        }else{
            //修改
            factory.setUpdateBy(getUser().getId());
            factory.setUpdateTime(new Date());
            factoryService.update(factory);
        }
        //重定向到列表页面
        return "redirect:/factory/list.do";
    }

    @RequestMapping(value = "/delete" ,name = "删除工厂数据")
    public String delete(String id){
        factoryService.delete(id);
//        重定向到列表页面
        return "redirect:/factory/list.do";
    }


}
