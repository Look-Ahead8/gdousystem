package com.gdou.gdousystem.filter;

import com.alibaba.fastjson.JSONObject;
import com.gdou.gdousystem.bean.Teacher;
import com.gdou.gdousystem.message.Message;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Meng
 * @date 2019/12/23
 */
public class ShiroPermsFilter extends PermissionsAuthorizationFilter {
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String requestedWith = httpServletRequest.getHeader("X-Requested-With");
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        //解决一下跨域问题
        httpServletResponse.setHeader("Access-Control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "HEAD, POST, GET, OPTIONS, DELETE, PUT");
        httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpServletResponse.setHeader("XDomainRequestAllowed","1");
        httpServletResponse.getWriter().write(JSONObject.toJSONString(Message.forbidden()));
        httpServletResponse.getWriter().flush();
        httpServletResponse.getWriter().close();
        return false;
    }
}

