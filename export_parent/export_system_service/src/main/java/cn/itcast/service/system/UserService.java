package cn.itcast.service.system;

import cn.itcast.domain.system.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {

    public List<User> findAll(String companyId);

    void save(User user);

    User findById(String id);

    void update(User user);

    void deleteById(String id);

    PageInfo findPage(String companyId, int pageNum, int pageSize);

    void changeRole(String userid, String[] roleIds);

    List<String> findRoleIdsByUserId(String id);

    User findByEmail(String email);
}
