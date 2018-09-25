package com.phy.decisionsupport.common;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ReadProperties {

	/**
	 * getProperties
	 * @描述: 读取properties文件的内容
	 * @作者: huangzhch
	 * @创建时间: 2016-12-28下午02:39:54
	 * 
	 * @修改描述: 无
	 * @修改人: huangzhch
	 * @修改时间: 2016-12-28下午02:39:54
	 * @param fileName 文件路径名
	 * @param keys  要读取的key值
	 * @return
	 */
	public static List<String> getProperties(String fileName, List<String> keys){
		List<String> list = new ArrayList<String>();
		InputStream inputStream = null;
		Properties property = new Properties();
		String temp = "";
		try{
			File ff = new File(fileName);
			
			inputStream = ReadProperties.class.getResourceAsStream(fileName);
			property.load(inputStream);
			for(int i = 0; i < keys.size(); i++){
				temp = property.getProperty(keys.get(i)).trim();
				if(temp != null && !temp.isEmpty()){
					list.add(temp);
				}
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
