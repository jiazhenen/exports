package cn.itcast.service.system.impl;

import cn.itcast.dao.system.ModuleDao;
import cn.itcast.domain.system.Module;
import cn.itcast.domain.system.User;
import cn.itcast.service.system.ModuleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private ModuleDao moduleDao;

    @Override
    public List<Module> findAll() {
        return moduleDao.findAll();
    }

    @Override
    public void save(Module module) {
        moduleDao.save(module);
    }

    @Override
    public Module findById(String id) {
        return moduleDao.findById(id);
    }

    @Override
    public void update(Module module) {
        moduleDao.update(module);
    }

    @Override
    public void deleteById(String id) {
        moduleDao.deleteById(id);
    }

    public PageInfo findPage(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Module> list = moduleDao.findAll();
        return new PageInfo(list,5);
    }

    @Override
    public List<String> findModulesByRoleId(String roleid) {
        return moduleDao.findModulesByRoleId(roleid);
    }

    /**
     * （1） SaaS管理员
     * SELECT * FROM ss_module WHERE belong = 0
     * （2） 租户企业管理员
     * SELECT * FROM ss_module WHERE belong = 1
     * （3）普通用户
     *    select  distinct m.* from pe_user u,pe_role_user ru, pe_role r,pe_role_module rm , ss_module m
     *           where u.user_id=ru.user_id and ru.role_id=r.role_id and r.role_id=rm.role_id and rm.module_id=m.module_id
     *         and u.user_id=#{userid}
     * @param user
     * @return
     */
    @Override
    public List<Module> findModuleListByUser(User user) {
//        根据用户的级别判断使用哪个sql
        Integer degree = user.getDegree();
        List<Module> moduleList = null;
        if(degree==0){
            moduleList = moduleDao.findByBelong(0);
        }else if(degree==1){
            moduleList = moduleDao.findByBelong(1);
        }else{
            moduleList = moduleDao.findByUserId(user.getId());
        }
        return moduleList;
    }
}
