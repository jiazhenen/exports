package cn.itcast.dao.system;

import cn.itcast.domain.system.User;
import cn.itcast.domain.system.WxUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    public List<User> findAll(String companyId);

    void save(User user);

    User findById(String id);

    void update(User user);

    void deleteById(String id);

    List<String> findRoleIdsByUserId(String userid);

    void saveUserAndRole(@Param("userid") String userid,@Param("roleid")  String roleid);

    void deleteRoleAndUserByUserId(String userid);

    User findByEmail(String email);

    WxUser findByOpenid(String toString);

    void saveWxuser(WxUser wxUser);

    WxUser findByUserid(String userid);

    void deleteByIda(String id);
}
