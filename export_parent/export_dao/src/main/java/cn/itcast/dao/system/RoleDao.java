package cn.itcast.dao.system;

import cn.itcast.domain.system.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {
    public List<Role> findAll(String companyId);

    void save(Role role);

    Role findById(String id);

    void update(Role role);

    void deleteById(String id);

    void saveRoleAndModule(@Param("roleid") String roleid, @Param("moduleid") String moduleid);

    void deleteRoleAndModuleByRoleId(String roleid);
}
