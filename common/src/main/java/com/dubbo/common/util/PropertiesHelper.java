package com.dubbo.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesHelper {

	public PropertiesHelper(){
		
	}
	
	public static Object getEnvProperties(String key,String proFileName){
		String classPath=FileHelper.getClassPath();
		File file=new File(classPath+"conf/custom/notenv"+proFileName+".properties");
		Properties pro=new Properties();
		FileInputStream is=null;
		String var7;
		try {
			is=new FileInputStream(file);
			pro.load(is);
			return pro.getProperty(key);
		} catch (Exception e) {
			var7="null";
		}finally{
			if(is!=null){
				try {
					is.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		return var7; 
	}
}
