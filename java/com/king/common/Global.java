package com.king.common;

import java.util.Map;

import com.google.common.collect.Maps;
import com.king.common.utils.PropertiesLoader;

/**
 * 全局配置类
 * @author KING
 *
 */
public class Global {
	
	/**
	 * 保存全局属性值
	 */
	private static Map<String, String> map =Maps.newHashMap();
	
	/**
	 * 属性文件加载对象
	 */
	private static PropertiesLoader propertiesLoader =new PropertiesLoader("application.properties");
	
	/**
	 * 获取配置
	 * @param key
	 * @return
	 */
	public static String getConfig(String key){
		String value=map.get(key);
		if(value==null){
			value =propertiesLoader.getValue(key);
			map.put(key, value);
		}
		
		return value;
	}
}
	
	