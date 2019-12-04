package cn.itcast.controller.system;

import cn.itcast.controller.BaseController;
import cn.itcast.domain.system.Dept;
import cn.itcast.domain.system.Module;
import cn.itcast.domain.system.Role;
import cn.itcast.service.system.DeptService;
import cn.itcast.service.system.ModuleService;
import cn.itcast.service.system.RoleService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.apache.zookeeper.data.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/system/role")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private DeptService deptService;
    @Autowired
    private ModuleService moduleService;

    @RequestMapping(value = "/list" ,name = "展示角色列表数据")
    public String findAll(@RequestParam(name="page" ,defaultValue = "1") int pageNum, @RequestParam(name="pageSize" ,defaultValue = "10")int pageSize){
        PageInfo page = roleService.findPage(getCompanyId(),pageNum,pageSize);
        request.setAttribute("page",page);
        return "system/role/role-list";
    }

    @RequestMapping(value = "/toAdd" ,name = "进入新增角色页面")
    public String toAdd(){
        return "system/role/role-add";
    }


    @RequestMapping(value = "/edit" ,name = "保存角色数据")
    public String edit(Role role){
//        判断新增还是修改的依据是：role中是否有id值
        if(StringUtils.isEmpty(role.getId())){
//            新增 insert
            role.setId(UUID.randomUUID().toString()); //设置角色id
            role.setCompanyId(getCompanyId());
            role.setCompanyName(getCompanyName());
            role.setCreateTime(new Date());
            roleService.save(role);
        }else{
//            修改 update
            role.setUpdateTime(new Date());
            roleService.update(role);
        }
//        重定向到列表页面
        return "redirect:/system/role/list.do";
    }

    @RequestMapping(value = "/toUpdate" ,name = "进入修改角色页面")
    public String toUpdate(String id){
        Role role = roleService.findById(id);
        request.setAttribute("role",role);
        return "system/role/role-add";
    }


    @RequestMapping(value = "/delete" ,name = "删除角色数据")
    public String delete(String id){
        roleService.deleteById(id);
//        重定向到列表页面
        return "redirect:/system/role/list.do";
    }
    @RequestMapping(value = "/roleModule" ,name = "进入到角色分配权限页面")
    public String roleModule(String roleid){
        Role role = roleService.findById(roleid);
        request.setAttribute("role",role);
        return "system/role/role-module";
    }
    @RequestMapping(value = "/getZtreeNodes" ,name = "获取ztree需要的数据节点")
    @ResponseBody // 1、转json字符串  2、直接返回到浏览器
    public List<Map> getZtreeNodes(String roleid){
//        查询此角色拥有的菜单权限  select module_id from pe_role_module where role_id=?
       List<String> moduleIdList = moduleService.findModulesByRoleId(roleid);
//        [{id:1,pId:0,name:"XXXXX"},{}]
//查询所有module数据
        List<Module> moduleList = moduleService.findAll();
//        1、所需要的数据是来自于moduleList  2、pId属性名对应不上  3、moduleList中有很多多余的属性
//        id  pId  name  map
        List<Map> listMap = new ArrayList<>();//用来接收返回的数据
        Map map = null;
        for (Module module : moduleList) {
            map = new HashMap();
            map.put("id",module.getId());
            map.put("pId",module.getParentId());
            map.put("name",module.getName());
//            判断moduleIdList集合中是否包含module.getId()
            if(moduleIdList.contains(module.getId())){
                map.put("checked",true);    //此角色是否有module权限
            }
            listMap.add(map);
        }
        return listMap;
    }
    @RequestMapping(value = "/updateRoleModule" ,name = "给角色分配权限方法")
    public String updateRoleModule(String roleid,String moduleIds){ // moduleIds: "2,201,202,204"
        roleService.updateRoleModule(roleid,moduleIds);
        return "redirect:/system/role/list.do"; //重定向到角色列表页面
    }

}
