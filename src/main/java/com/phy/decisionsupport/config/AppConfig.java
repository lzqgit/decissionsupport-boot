package com.phy.decisionsupport.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:app.properties")
public class AppConfig {
    @Value("${devModel}")
    private Boolean devModel;
    @Value("${apiKeyName}")
    private String apiKeyName;
    @Value("${expired}")
    private int expired;
    @Value("${authUrl}")
    private String authUrl;
    @Value("${navPath}")
    private String navPath;

    public Boolean getDevModel() {
        return devModel;
    }

    public void setDevModel(Boolean devModel) {
        this.devModel = devModel;
    }

    public String getApiKeyName() {
        return apiKeyName;
    }

    public void setApiKeyName(String apiKeyName) {
        this.apiKeyName = apiKeyName;
    }

    public int getExpired() {
        return expired;
    }

    public void setExpired(int expired) {
        this.expired = expired;
    }

    public String getAuthUrl() {
        return authUrl;
    }

    public void setAuthUrl(String authUrl) {
        this.authUrl = authUrl;
    }

    public String getNavPath() {
        return navPath;
    }

    public void setNavPath(String navPath) {
        this.navPath = navPath;
    }
}
