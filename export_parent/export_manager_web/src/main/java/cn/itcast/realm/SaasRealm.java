package cn.itcast.realm;

import cn.itcast.domain.system.Module;
import cn.itcast.domain.system.User;
import cn.itcast.service.system.ModuleService;
import cn.itcast.service.system.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 自定义的realm，和数据库交互的
 */
public class SaasRealm extends AuthorizingRealm {


    @Autowired
    private UserService userService;

    @Autowired
    private ModuleService moduleService;

    /**
     * 认证方法
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
//        判断email和password‘
//        先根据email查询用户
//        根据用户的password和页面上输入的password比较
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String email = token.getUsername();
        char[] password = token.getPassword();
        String password_page = new String(password);  //password_page密文的
        User user = userService.findByEmail(email);
        if(user!=null){
            String password_db = user.getPassword(); //password_db 密文
            if(password_db.equals(password_page)){
//                Object principal  主角, Object credentials 密码和UsernamePasswordToken中的密码一致, String realmName 当前类名
                return new SimpleAuthenticationInfo(user,password_db,getName());
            }
        }
        return null; //LoginController中的登录方法就会出异常
    }

    /**
     * 授权方法
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("-------------------------------------------------------------");
//        判断当前登录人有哪些权限，需要告诉shiro框架
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

//        User user = (User) SecurityUtils.getSubject().getPrincipal();
        User user = (User) principalCollection.getPrimaryPrincipal();
        List<Module> moduleList = moduleService.findModuleListByUser(user);
        for (Module module : moduleList) {
            info.addStringPermission(module.getName());
        }
        return info;
    }
}
