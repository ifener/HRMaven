package com.ken.interceptor;

import com.ken.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by it on 09/04/2017.
 */
public class AuthorizationInterceptor implements HandlerInterceptor {

    private List<String> excludeUrl;

    public void setExcludeUrl(List<String> excludeUrl) {
        this.excludeUrl = excludeUrl;
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        boolean flag = false;
        String servletPath = httpServletRequest.getServletPath();

        if(excludeUrl.contains(servletPath)){
            flag = true;
        }

        if(!flag){
            User user = (User)httpServletRequest.getSession().getAttribute("user");
            if (user==null){
                httpServletRequest.setAttribute("msg","请先登录");
                httpServletRequest.getRequestDispatcher("/loginForm").forward(httpServletRequest,httpServletResponse);
                return flag;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
