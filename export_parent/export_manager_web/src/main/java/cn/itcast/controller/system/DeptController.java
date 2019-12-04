package cn.itcast.controller.system;

import cn.itcast.controller.BaseController;
import cn.itcast.domain.system.Dept;
import cn.itcast.service.system.DeptService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/system/dept")
public class DeptController extends BaseController {

    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/list" ,name = "展示部门列表数据")
    public String findAll(@RequestParam(name="page" ,defaultValue = "1") int pageNum, @RequestParam(name="pageSize" ,defaultValue = "10")int pageSize){
//        List<Dept> deptList = deptService.findAll();
//        PageBean page = deptService.findPage(pageNum,pageSize);
        PageInfo page = deptService.findPage(getCompanyId(),pageNum,pageSize);
        request.setAttribute("page",page);  //别忘了修改页面上的list----->page.list
        return "system/dept/dept-list";
    }

    @RequestMapping(value = "/toAdd" ,name = "进入新增部门页面")
    @RequiresPermissions("新增部门")
    public String toAdd( ){
//        查询所有本企业的部门
      List<Dept> deptList = deptService.findAll(getCompanyId());
      request.setAttribute("deptList",deptList);
        return "system/dept/dept-add";
    }


    @RequestMapping(value = "/edit" ,name = "保存部门数据")
    public String edit(Dept dept){
        if(dept.getParent().getId().equals("")){//如果没有选择父部门就把parent的id设置成null
            dept.getParent().setId(null);
        }
//        判断新增还是修改的依据是：dept中是否有id值
        if(StringUtils.isEmpty(dept.getId())){
//            新增 insert
            dept.setId(UUID.randomUUID().toString()); //设置部门id
            dept.setCompanyId(getCompanyId());
            dept.setCompanyName(getCompanyName());
            deptService.save(dept);
        }else{
//            修改 update
            deptService.update(dept);
        }
//        重定向到列表页面
        return "redirect:/system/dept/list.do";
    }

    @RequestMapping(value = "/toUpdate" ,name = "进入修改部门页面")
    public String toUpdate(String id){
        Dept dept = deptService.findById(id);
        request.setAttribute("dept",dept);

        //        查询所有本企业的部门
        List<Dept> deptList = deptService.findAll(getCompanyId());
        request.setAttribute("deptList",deptList);
        return "system/dept/dept-add";
    }


    @RequestMapping(value = "/delete" ,name = "删除部门数据")
    public String delete(String id){
        deptService.deleteById(id);
//        重定向到列表页面
        return "redirect:/system/dept/list.do";
    }
}
