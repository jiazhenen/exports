package cn.itcast.service.system;

import cn.itcast.domain.system.User;
import cn.itcast.domain.system.WxUser;
import cn.itcast.domain.systemback.Systemback;
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

    User findUserById(String id);


    User wxLogin(String code);

    void wxbangd(String code, String userid);

    WxUser findByUserid(String userid);

    void deleteByUserid(String id);
}
