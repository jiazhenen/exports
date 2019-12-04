package cn.itcast.exception;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 统一异常处理器  捕获Controller层抛出的异常，跳转到一个公共的页面error.jsp
 */
public class SaaSException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
//        需求：如果捕获的是UnauthorizedException异常，跳转到unauthorized.jsp
        ModelAndView mv = new ModelAndView();
        if(ex instanceof UnauthorizedException){  //如果捕获的是UnauthorizedException异常
//            跳转到unauthorized.jsp
            mv.setViewName("forward:/unauthorized.jsp"); //不通过视图解析器的
        }else{
            mv.setViewName("error");
        }
        mv.addObject("errorMsg",ex.getMessage());
        return mv;
    }
}
