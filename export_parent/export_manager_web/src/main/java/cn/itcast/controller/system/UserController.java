package cn.itcast.controller.system;

import cn.itcast.controller.BaseController;
import cn.itcast.domain.system.Dept;
import cn.itcast.domain.system.Role;
import cn.itcast.domain.system.SysLog;
import cn.itcast.domain.system.User;
import cn.itcast.service.system.DeptService;
import cn.itcast.service.system.RoleService;
import cn.itcast.service.system.UserService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/system/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;
    @Autowired
    private DeptService deptService;
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/list" ,name = "展示用户列表数据")
    public String findAll(@RequestParam(name="page" ,defaultValue = "1") int pageNum, @RequestParam(name="pageSize" ,defaultValue = "10")int pageSize){
        PageInfo page = userService.findPage(getCompanyId(),pageNum,pageSize);
        request.setAttribute("page",page);
        return "system/user/user-list";
    }

    @RequestMapping(value = "/toAdd" ,name = "进入新增用户页面")
    public String toAdd(){
//        查询本企业的所有部门

      List<Dept> deptList = deptService.findAll(getCompanyId());
      request.setAttribute("deptList",deptList);
        return "system/user/user-add";
    }


    @RequestMapping(value = "/edit" ,name = "保存用户数据")
    public String edit(User user){
//        判断新增还是修改的依据是：user中是否有id值
        if(StringUtils.isEmpty(user.getId())){
//            新增 insert
            user.setId(UUID.randomUUID().toString()); //设置用户id
            user.setCompanyId(getCompanyId());
            user.setCompanyName(getCompanyName());
            user.setCreateTime(new Date());
            userService.save(user);
        }else{
//            修改 update
            user.setUpdateTime(new Date());
            userService.update(user);
        }
//        重定向到列表页面
        return "redirect:/system/user/list.do";
    }

    @RequestMapping(value = "/toUpdate" ,name = "进入修改用户页面")
    public String toUpdate(String id){
        User user = userService.findById(id);
        request.setAttribute("user",user);

        //        查询本企业的所有部门
        List<Dept> deptList = deptService.findAll(getCompanyId());
        request.setAttribute("deptList",deptList);
        return "system/user/user-add";
    }


    @RequestMapping(value = "/delete" ,name = "删除用户数据")
    public String delete(String id){
        userService.deleteById(id);
//        重定向到列表页面
        return "redirect:/system/user/list.do";
    }
    @RequestMapping(value = "/roleList" ,name = "进入给用户分配角色页面")
    public String roleList(String id){  //id :用户id
//        1、本企业的所有角色
        List<Role> roleList = roleService.findAll(getCompanyId());
        request.setAttribute("roleList",roleList);
//        2、当前用户对象
        User user = userService.findById(id);
        request.setAttribute("user",user);
//        3、当前用户拥有的角色ids字符串
        List<String> roleIdList  = userService.findRoleIdsByUserId(id);
//        把集合转成字符串
//        String userRoleStr="";
//        for (String s : roleIdList) {
//            userRoleStr+=s+",";
//        }
        String userRoleStr = roleIdList.stream().collect(Collectors.joining(",")); //流式编程

        request.setAttribute("userRoleStr",userRoleStr);

        return "system/user/user-role";
    }
    @RequestMapping(value = "/changeRole" ,name = "给用户分配角色方法")
//    roleIds: 4028a1cd4ee2d9d6014ee2df4c6a0003
//    roleIds: 4028a1cd4ee2d9d6014ee2df4c6a0004
//    String roleIds  List<String> roleIds  String[] roleIds
    public String changeRole( String userid,String[] roleIds){
         userService.changeRole(userid,roleIds);
//         重定向到用户列表
        return "redirect:/system/user/list.do";
    }
}
