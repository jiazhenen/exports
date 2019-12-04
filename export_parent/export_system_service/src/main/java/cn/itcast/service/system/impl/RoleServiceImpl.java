package cn.itcast.service.system.impl;

import cn.itcast.dao.system.RoleDao;
import cn.itcast.domain.system.Role;
import cn.itcast.service.system.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> findAll(String companyId) {
        return roleDao.findAll(companyId);
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public Role findById(String id) {
        return roleDao.findById(id);
    }

    @Override
    public void update(Role role) {
        roleDao.update(role);
    }

    @Override
    public void deleteById(String id) {
        roleDao.deleteById(id);
    }



    public PageInfo findPage(String companyId,int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Role> list = roleDao.findAll(companyId); //表面上是查询所有，但是在执行select查询之前会根据分页拦截器把sql语句做了处理，
//        1、分页带上了limit关键字 2、还执行了count
        return new PageInfo(list,5);
    }

//    保存角色和权限的关系，数据的本质上就是向中间表中添加数据
    @Override
    public void updateRoleModule(String roleid, String moduleIds) {  //moduleIds "2,20,345"
//        1、先删除此角色之前的权限
        roleDao.deleteRoleAndModuleByRoleId(roleid);

//       2、再重新添加新的权限
        String[] mIds = moduleIds.split(",");
        for (String moduleid : mIds) {
            roleDao.saveRoleAndModule(roleid,moduleid);
        }
//
    }

    //TODO 2019-11-18 立下flag  5天后去网站 https://www.cmd5.com  查询此密码b9624cad1a4c522e9d458f42c6c6183f
}
