package com.phy.decisionsupport.uac;

import com.phy.decisionsupport.config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class title: 权限验证拦截器
 * Describe: <br/>
 * Date : 2018/6/6 16:25 <br/>
 * Project : asoco-zhyy-nav <br/>
 *
 * @author konbluesky
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {

    private static Logger log = LoggerFactory.getLogger(AuthInterceptor.class);

    @Autowired
    AppConfig appConfig;

    @Autowired
    TokenKit tokenKit;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("进入了控制器！！！！");
        AppToken token =tokenKit.getToken();
        if(token==null || "".equals(token)){
            String path = request.getContextPath();
            String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
            response.setHeader("REDIRECT","REDIRECT");
            response.setHeader("CONTENTPATH",appConfig.getAuthUrl()+basePath);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {
    }
}
