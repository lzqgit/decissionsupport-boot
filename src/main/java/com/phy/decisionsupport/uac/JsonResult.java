package com.phy.decisionsupport.uac;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by Administrator on 2018/8/29.
 */
public class JsonResult<T> {
    private Integer code;
    private String message;
    private T data;


    public JsonResult(Integer code, String message) {
        this.code=code;
        this.message=message;
    }
    public JsonResult(Integer code, String message,T data) {
        this.code=code;
        this.message=message;
        this.data=data;
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    @Override
    public String toString() {
        JSONObject map = new JSONObject();
        map.put( "code",code);
        map.put( "message",message);
        map.put( "data",data);
        return map.toJSONString();
    }

}
