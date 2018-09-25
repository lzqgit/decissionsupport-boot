package com.phy.decisionsupport.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

public class StringHelper {
    public static Date toDate(String str){
        Date date=new Date();
        try {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date=sdf.parse(str);
        }catch (Exception e){
            e.printStackTrace();
        }
        return date;
    }
}
