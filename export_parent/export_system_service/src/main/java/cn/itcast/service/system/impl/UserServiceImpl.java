package cn.itcast.service.system.impl;

import cn.itcast.dao.system.UserDao;
import cn.itcast.domain.system.User;
import cn.itcast.domain.system.WxUser;
import cn.itcast.service.system.UserService;
import cn.itcast.utils.HttpUtils;
import cn.itcast.utils.MailUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiniu.util.Md5;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll(String companyId) {
        return userDao.findAll(companyId);
    }

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void save(User user) {
        String password_ming = user.getPassword();
        String password = user.getPassword(); //明文的
//        md5高级加密方式用到3个参数  p1:原密码  p2：加的盐   p3:加几次
        password = new Md5Hash(password,user.getEmail(),2).toString();
        user.setPassword(password);
        userDao.save(user);

        Map<String,String> map = new HashMap();
        map.put("to",user.getEmail());
        map.put("subject","恭喜新员工");
        map.put("content","您现在可以使用SaaS货代云平台了，登录密码是："+password_ming);
        amqpTemplate.convertAndSend("user.insert",map);  //d(String routingKey, Object object)
//        发送邮件的任务放入到MQ中
//        try {
//            MailUtil.sendMsg(user.getEmail(),"恭喜新员工","您现在可以使用SaaS货代云平台了，登录密码是："+password_ming);
//        } catch (Exception e) {
//            System.out.println("邮件发送失败");
//        }
    }

    @Override
    public User findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void deleteById(String id) {
        userDao.deleteById(id);
    }



    public PageInfo findPage(String companyId,int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userDao.findAll(companyId); //表面上是查询所有，但是在执行select查询之前会根据分页拦截器把sql语句做了处理，
//        1、分页带上了limit关键字 2、还执行了count
        return new PageInfo(list,5);
    }


    //TODO 2019-11-18 立下flag  5天后去网站 https://www.cmd5.com  查询此密码b9624cad1a4c522e9d458f42c6c6183f



    @Override
    public void changeRole(String userid, String[] roleIds) {
//        删除之前用户的角色数据 delete from pe_role_user where user_id=?
        userDao.deleteRoleAndUserByUserId(userid);
//        向中间表中插入数据
        for (String roleid : roleIds) {
            userDao.saveUserAndRole(userid,roleid);
        }
    }

    @Override
    public List<String> findRoleIdsByUserId(String userid) {
        return userDao.findRoleIdsByUserId(userid);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public User findUserById(String id) {
        User user = userDao.findById(id);
        return user;

    }
    //AppID : wx3bdb1192c22883f3
    //AppSecret : db9d6b88821df403e5ff11742e799105
    private String appid = "wx3bdb1192c22883f3";
    private String secret = "db9d6b88821df403e5ff11742e799105";
    private String accessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token";
    private String wxInfoUrl = "https://api.weixin.qq.com/sns/oauth2/access_token";

    @Override
    public User wxLogin(String code) {
        WxUser wxuser = null;
        User user = null;
        //1.根据code获取access_token和openId
        String atUtl = accessTokenUrl + "?code="+code+"&appid="+appid+"&secret="+secret+"&grant_type=authorization_code";
        System.out.println(atUtl);
        Map<String, Object> map1 = HttpUtils.sendGet(atUtl);
        Object access_token = map1.get("access_token");
        Object openid = map1.get("openid").toString();
        if(access_token == null && openid == null) {
            return user;
        }
        wxuser = userDao.findByOpenid(openid.toString());
        if(wxuser != null) {
            System.out.println("返回数据库中的用户对象");
            //3.如果用户存在返回用户信息
            return userDao.findById(wxuser.getUserid());
        }
        return user;
    }

    @Override
    public void wxbangd(String code,String userid) {
        WxUser wxUser = new WxUser();
        //1.根据code获取access_token和openId
        String atUtl = accessTokenUrl + "?code="+code+"&appid="+appid+"&secret="+secret+"&grant_type=authorization_code";
        System.out.println(atUtl);
        Map<String, Object> map1 = HttpUtils.sendGet(atUtl);
        Object access_token = map1.get("access_token");
        Object openid = map1.get("openid").toString();
        wxUser.setOpenid(openid.toString());
        wxUser.setUserid(userid);
        userDao.saveWxuser(wxUser);
    }
    @Override
    public WxUser findByUserid(String userid) {
        return userDao.findByUserid(userid);
    }

    @Override
    public void deleteByUserid(String id) {
        userDao.deleteByIda(id);
    }

    public static void main(String[] args) {
        System.out.println(new Md5Hash("123456","admin@export.com",2).toString());
        System.out.println(new Md5Hash("123456","laowang@export.com",2).toString());
        System.out.println(new Md5Hash("123456","xiaowang@export.com",2).toString());
        System.out.println(new Md5Hash("123456","xiaoer@export.com",2).toString());
    }


}
