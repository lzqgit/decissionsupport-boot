package com.phy.decisionsupport.utils;

/**
 * @author liaow
 *
 */
public class ResultObject {
	
	private String stateCode;
	
	private Object data;
	
	public void setStateCode(String stateCode){
		this.stateCode = stateCode;
	}
	
	public String getStateCode(){
		return this.stateCode;
	}
	
	public void setData(Object data){
		this.data = data;
	}
	
	public Object getData(){
		return this.data;
	}
}
