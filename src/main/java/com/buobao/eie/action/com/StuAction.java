package com.buobao.eie.action.com;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by dqf on 2015/10/19.
 */
public class StuAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,ServletContextAware{
    private HttpServletRequest httpServletRequest;
    private HttpServletResponse httpServletResponse;
    private ServletContext servletContext;

    public void setServletContext(ServletContext context) {
        servletContext = context;
    }

    public void setServletRequest(HttpServletRequest request) {
        httpServletRequest = request;
    }

    public void setServletResponse(HttpServletResponse response) {
        httpServletResponse = response;
    }
}
