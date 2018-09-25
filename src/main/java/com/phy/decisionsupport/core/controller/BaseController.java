package com.phy.decisionsupport.core.controller;

import com.phy.decisionsupport.utils.ResultObject;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {
	protected ResultObject getResult(Object data,String stateCode){
		ResultObject result = new ResultObject();
		result.setData(data);
		result.setStateCode(stateCode);
		return result;
		
	}
	
}
