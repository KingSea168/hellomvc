package com.king.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * Properties文件载入工具类
 * 可载入多个properties文件，
 * 相同的属性在最后载入的文件中的值将会覆盖之前的值，
 * 但以System的Property优先
 * @author KING
 *
 */
public class PropertiesLoader {
	private static Logger logger =LoggerFactory.getLogger(PropertiesLoader.class);
	
	private static ResourceLoader resourceLoader = new DefaultResourceLoader();
	
	private final Properties properties;
	public Properties getProperties() {
		return properties;
	}
	
	public PropertiesLoader(String... resourcePaths) {
		properties =loadProperties(resourcePaths); 
	}
	
	/**
	 * 取property,以system的property优先,取不到返回空字符串
	 * @param key
	 * @return
	 */
	public String getValue(String key){
		String sysProperty = System.getProperty(key);
		if(sysProperty!=null){
			return sysProperty;
		}
		
		if(properties.containsKey(key)){
			return properties.getProperty(key);
		}
		
		return "";
	}

	/**
	 * 载入多个文件，文件路径使用Spring Resource格式
	 * @param resourcePaths
	 * @return
	 */
	private Properties loadProperties(String[] resourcePaths) {
		Properties props=new Properties();
		for (String path : resourcePaths) {
			InputStream is=null;
			try {
				Resource resource =resourceLoader.getResource(path);
				is=resource.getInputStream();
				props.load(is);
			}catch(IOException e){
				logger.info("Could not load properties from path:"+path+","+e.getMessage());
			}finally {
				IOUtils.closeQuietly(is);
			}
		}
		
		return props;
	}
}
