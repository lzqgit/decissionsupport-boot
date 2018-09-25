package com.phy.decisionsupport.user.controller;

import com.c503.sc.utils.response.ResultMessage;
import com.phy.decisionsupport.uac.AppToken;
import com.phy.decisionsupport.uac.TokenKit;
import com.phy.decisionsupport.core.controller.BaseController;
import com.phy.decisionsupport.uac.JsonResult;
import com.phy.decisionsupport.uac.UACServiceFactory;
import com.phy.decisionsupport.config.AppConfig;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sc.c503.authclient.service.impl.ApiLoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "user")
public class UserController extends BaseController{
	@Autowired
	private TokenKit tokenKit;
	@Autowired
	AppConfig appConfig;

	@RequestMapping(value = "/checkToken",method = RequestMethod.POST)
	@ResponseBody
	public JsonResult checkToken(HttpServletRequest request, HttpServletResponse response){
		return  new JsonResult(0,"成功",tokenKit.getToken());
	}
	@RequestMapping(value = "/logout",method = RequestMethod.POST)
	@ResponseBody
	public JsonResult  logout(HttpServletRequest request, HttpServletResponse response) {
		AppToken token = tokenKit.getToken();
		if(token!=null){
			ApiLoginService service = UACServiceFactory.apiLoginService();
			ResultMessage message = service.logout(token.getToken(), token.getUserId());
			tokenKit.deleteToken(token);
		}
		JSONObject obj =new JSONObject();
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		obj.put("authUrl",appConfig.getAuthUrl()+basePath);
		return new JsonResult(0,"退出成功！",obj);
	}

	@RequestMapping(value = "/nav",method =RequestMethod.POST)
	@ResponseBody
	public String getNavPath(){
		return appConfig.getNavPath();
	}
}
