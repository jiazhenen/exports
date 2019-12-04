package cn.itcast.service.system;

import cn.itcast.domain.system.Module;
import cn.itcast.domain.system.User;
import com.github.pagehelper.PageInfo;
import java.util.List;

public interface ModuleService {

    public List<Module> findAll();

    void save(Module module);

    Module findById(String id);

    void update(Module module);

    void deleteById(String id);

    PageInfo findPage(int pageNum, int pageSize);

    List<String> findModulesByRoleId(String roleid);

    List<Module> findModuleListByUser(User user);
}
