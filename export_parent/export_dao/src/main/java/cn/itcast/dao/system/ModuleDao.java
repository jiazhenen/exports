package cn.itcast.dao.system;

import cn.itcast.domain.system.Module;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ModuleDao {
    public List<Module> findAll();

    void save(Module module);

    Module findById(String id);

    void update(Module module);

    void deleteById(String id);

    List<String> findModulesByRoleId(String roleid);

    List<Module> findByBelong(int belong);

    List<Module> findByUserId(String userId);
}
