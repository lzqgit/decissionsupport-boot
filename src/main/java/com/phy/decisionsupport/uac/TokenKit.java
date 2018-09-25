package com.phy.decisionsupport.uac;

import com.alibaba.fastjson.JSON;
import com.c503.sc.utils.response.ResultMessage;
import com.phy.decisionsupport.config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import sc.c503.authclient.model.ApiUserEntity;
import sc.c503.authclient.service.splitImpl.ApiUserService;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * Class title: 应用 Token 工具类 <br/>
 * Describe: <br/>
 * Date : 2018/6/8 09:03 <br/>
 * Project : asoco-zhyy-nav <br/>
 *
 * @author konbluesky <br/>
 */

@Component
public class TokenKit {
    
    private static Logger log = LoggerFactory.getLogger(TokenKit.class);

    @Autowired
    AppConfig appConfig;
    public AppConfig getAppConfig() {
        return appConfig;
    }
    @Autowired
    StringRedisTemplate redisTemplate;
    /**
     * 验证令牌
     *
     * @param token
     * @return
     * @throws IllegalArgumentException
     */
    public AppToken checkToken(String token) {
        if(appConfig.getDevModel()){  //如果是开发者模式
            UACServiceFactory.GOD();
        }
        ApiUserService userService = UACServiceFactory.apiUserService(token);
        ResultMessage message=  userService.authToken();
        if(message==null){
            log.error("uac is error,please repair it!");
            return null;
        }
        //token从UAC验证失败
        if(message.getCode()!=0){
           deleteToken(token);
            log.warn("uac token Auth failed,please login again !");
           return null;
        }
        String key = new StringBuilder(appConfig.getApiKeyName()).append("-").append(token).toString();
        String val = redisTemplate.opsForValue().get(key);
        log.info("check uac:{}", token);
        if(val==null){
            ApiUserEntity user = userService.getUserInfo();
            if(user!=null){
                AppToken newToken =new AppToken(token,user.getAccount(),user.getId(),user.getName());
                saveToken(newToken);
                return newToken;
            }
        }
        return JSON.parseObject(val, AppToken.class);

    }
    /**
     * 保存token到redis
     *
     * @param tokenObj
     * @throws IllegalArgumentException
     */
    public void saveToken(AppToken tokenObj) {
        String key = new StringBuilder(appConfig.getApiKeyName()).append("-").append(tokenObj.getToken()).toString();
        redisTemplate.opsForValue().set(key, JSON.toJSONString(tokenObj), appConfig.getExpired(),
                                        TimeUnit.DAYS);
    }
    public void deleteToken(AppToken token) {
        String key = new StringBuilder(appConfig.getApiKeyName()).append("-").append(token.getToken()).toString();
        redisTemplate.delete(key);
    }
    private void deleteToken(String token) {
        String key = new StringBuilder(appConfig.getApiKeyName()).append("-").append(token).toString();
        redisTemplate.delete(key);
    }
    /**
     * 从当前request中获取token
     * @return
     */
    public AppToken getToken(){
        HttpServletRequest request=((ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes())).getRequest();
        String token=String.valueOf(request.getHeader(appConfig.getApiKeyName()));
        if(token==null||"null".equals(token)||"".equals(token)){
            return null;
        }
        return checkToken(token);
    }
}
