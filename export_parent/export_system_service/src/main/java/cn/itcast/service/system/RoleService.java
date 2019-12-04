package cn.itcast.service.system;

import cn.itcast.domain.system.Role;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface RoleService {

    public List<Role> findAll(String companyId);

    void save(Role role);

    Role findById(String id);

    void update(Role role);

    void deleteById(String id);

    PageInfo findPage(String companyId, int pageNum, int pageSize);

    void updateRoleModule(String roleid, String moduleIds);
}
