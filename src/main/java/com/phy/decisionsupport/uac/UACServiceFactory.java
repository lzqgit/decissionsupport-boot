package com.phy.decisionsupport.uac;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sc.c503.authclient.service.impl.ApiLoginService;
import sc.c503.authclient.service.splitImpl.ApiDynamicLoginService;
import sc.c503.authclient.service.splitImpl.ApiRelationService;
import sc.c503.authclient.service.splitImpl.ApiUserService;

/**
 * Class title: UAC Service 构建工厂 <br/>
 * Describe:
 * <pre>
 * 该工厂使用静态工厂方法,同时全局hold住UAC超级实例,也就是实例方法与静态方法共存
 * 静态方法作为普通场景使用,通过god实例运行的就是上帝;
 * 主要服务场景:
 *     1.手机+验证码登录
 *     2.人脸识别登录
 * </pre>
 * Date : 2018/6/14 14:53 <br/>
 * Project : asoco-zhyy-nav <br/>
 *
 * @author konbluesky <br/>
 */
public class UACServiceFactory {
    
    private static Logger log = LoggerFactory.getLogger(UACServiceFactory.class);
    
    public static final String LOGIN_TYPE_MOBILE="9";
    public static final String LOGIN_TYPE_FACE="8";
    
    private static String GOD_TOKEN="zjhthj2018";
    private String TOKEN;
    
    public UACServiceFactory(String token) {
        this.TOKEN=token;
    }
    
    /**
     * UAC超级隐藏token,具有上帝权限,可以为所欲为
     */
    private static UACServiceFactory INSTANCE_GOD ;
    public static UACServiceFactory GOD(){
        if(INSTANCE_GOD==null){
            INSTANCE_GOD=new UACServiceFactory(GOD_TOKEN);
        }
        return INSTANCE_GOD;
    }
    
    public static ApiLoginService apiLoginService() {
        return new ApiLoginService();
    }
    
    public static ApiDynamicLoginService apiDynamicLoginService() {
        return new ApiDynamicLoginService();
    }
    
    public static ApiUserService apiUserService(String token) {
        return new UACServiceFactory(token).GapiUserService();
    }
    
    public static ApiRelationService apiRelationService(String token) {
        return new UACServiceFactory(token).GapiRelationService();
    }
    
    /**
     * 实例方法
     * @return
     */
    public ApiUserService GapiUserService(){
        return new ApiUserService(TOKEN);
    }
    
    public ApiRelationService GapiRelationService(){
        return new ApiRelationService(TOKEN);
    }

}
