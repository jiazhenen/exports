package cn.itcast.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class MyPermsFilter extends AuthorizationFilter {

    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {

        Subject subject = getSubject(request, response);
        String[] perms = (String[]) mappedValue;
//      perms =  ["部门管理","删除部门"]
//        数组中的权限，当前登录中只有有其中的一个就放行 return true
        if (perms != null && perms.length > 0) {
            for (String perm : perms) {
               if(subject.isPermitted(perm)) { //判断当前登录人是由有此权限
                   return true;
               }
            }
            return false;
        }else{
//            perms为空
            return true;
        }
    }
}