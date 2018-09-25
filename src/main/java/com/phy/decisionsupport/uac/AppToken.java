package com.phy.decisionsupport.uac;

import org.apache.commons.lang3.StringUtils;

/**
 *  token实体
 * Date : 2018/6/8 09:46 <br/>
 * Project : asoco-zhyy-nav <br/>
 *
 * @author konbluesky <br/>
 */
public class AppToken {
    
    String token;
    String userid;
    String username;
    String loginid;
    
    public AppToken() {
    }
    
    public AppToken(String token, String loginid, String userid, String username) {
        this.token = token;
        this.loginid = loginid;
        this.userid = userid;
        this.username = username;
    }
    
    public String getToken() {
        return token;
    }
    
    public void setToken(String token) {
        this.token = token;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getUserId() {
        return userid;
    }
    
    public void setUserid(String userid) {
        this.userid = userid;
    }
    
    public String getLoginid() {
        return loginid;
    }
    
    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }
    
    public boolean isOk() {
        //任意一值为空 视为无效token
        return !(StringUtils.isEmpty(token) || StringUtils.isEmpty(userid) || StringUtils.isEmpty(username));
    }

    @Override
    public String toString() {
        return "AppToken{" +
                "token='" + token + '\'' +
                ", userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", loginid='" + loginid + '\'' +
                '}';
    }
}
