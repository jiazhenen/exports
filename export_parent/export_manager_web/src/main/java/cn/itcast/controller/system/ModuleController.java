package cn.itcast.controller.system;

import cn.itcast.controller.BaseController;
import cn.itcast.domain.system.Module;
import cn.itcast.service.system.ModuleService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/system/module")
public class ModuleController extends BaseController {

    @Autowired
    private ModuleService moduleService;

    @RequestMapping(value = "/list" ,name = "展示模块列表数据")
    public String findAll(@RequestParam(name="page" ,defaultValue = "1") int pageNum, @RequestParam(name="pageSize" ,defaultValue = "10")int pageSize){
        PageInfo page = moduleService.findPage(pageNum,pageSize);
        request.setAttribute("page",page);
        return "system/module/module-list";
    }

    @RequestMapping(value = "/toAdd" ,name = "进入新增模块页面")
    public String toAdd( ){
//        查询菜单数据，以供页面上的选择
        List<Module> moduleList = moduleService.findAll();
        request.setAttribute("menus",moduleList);
        return "system/module/module-add";
    }


    @RequestMapping(value = "/edit" ,name = "保存模块数据")
    public String edit(Module module){
//        判断新增还是修改的依据是：module中是否有id值
        if(StringUtils.isEmpty(module.getId())){
//            新增 insert
            module.setId(UUID.randomUUID().toString()); //设置模块id
            moduleService.save(module);
        }else{
//            修改 update
            moduleService.update(module);
        }
//        重定向到列表页面
        return "redirect:/system/module/list.do";
    }

    @RequestMapping(value = "/toUpdate" ,name = "进入修改模块页面")
    public String toUpdate(String id){
        Module module = moduleService.findById(id);
        request.setAttribute("module",module);
        //        查询菜单数据，以供页面上的选择
        List<Module> moduleList = moduleService.findAll();
        request.setAttribute("menus",moduleList);
        return "system/module/module-add";
    }


    @RequestMapping(value = "/delete" ,name = "删除模块数据")
    public String delete(String id){
        moduleService.deleteById(id);
//        重定向到列表页面
        return "redirect:/system/module/list.do";
    }
}
