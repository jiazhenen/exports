package cn.itcast.controller;

import cn.itcast.domain.system.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BaseController {
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected HttpServletResponse response;
    @Autowired
    protected HttpSession session;

    /**
     * 获取当前登录人信息
     * @return
     */
    protected User getUser(){
        return (User) session.getAttribute("loginUser");
    }
    /**
     * 获取当前登录人的企业id
     * @return
     */
    protected String getCompanyId(){
        if(getUser()!=null){
            return getUser().getCompanyId();
        }
        return null;
    }
    /**
     * 获取当前登录人的企业名称
     * @return
     */
    protected String getCompanyName(){
        if(getUser()!=null){
            return getUser().getCompanyName();
        }
        return null;
    }

}
