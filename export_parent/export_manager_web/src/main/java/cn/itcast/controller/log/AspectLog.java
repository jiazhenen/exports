package cn.itcast.controller.log;

import cn.itcast.domain.system.SysLog;
import cn.itcast.domain.system.User;
import cn.itcast.service.system.SysLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

/**
 * 通知类，专门用来记录操作日志
 */
@Component
@Aspect
public class AspectLog {

    @Autowired
    private SysLogService sysLogService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpSession session;

    @Around("execution(* cn.itcast.controller.*.*.*(..))")
    public Object saveLog(ProceedingJoinPoint pjp) throws Throwable {
        SysLog sysLog = new SysLog();

        sysLog.setTime(new Date()); //当前时间
        sysLog.setIp(request.getRemoteAddr()); //操作人的ip地址
        sysLog.setId(UUID.randomUUID().toString());

        User user = (User) session.getAttribute("loginUser");
        if(user!=null){
            sysLog.setUserName(user.getUserName()); //从当前登录人中获取
            sysLog.setCompanyName(user.getCompanyName()); //从当前登录人中获取
            sysLog.setCompanyId(user.getCompanyId());  //从当前登录人中获取
        }

        MethodSignature signature = (MethodSignature) pjp.getSignature(); //获取 方法签名 = 方法+注解
        Method method = signature.getMethod(); //从方法签名中获取方法对象
        String name = method.getName(); //方法名
        sysLog.setMethod(name);  //操作方法名

//        判断方法上是否有此RequestMapping注解
        if(method.isAnnotationPresent(RequestMapping.class)){
//            获取注解
            RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
            String name1 = requestMapping.name();
            sysLog.setAction(name1);  //方法上RequestMapping注解的name值
        }
        sysLogService.save(sysLog);
        return pjp.proceed();//运行原方法
    }

}
