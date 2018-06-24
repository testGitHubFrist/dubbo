package com.dubbo.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;

public class FileHelper {

	public FileHelper(){
		
	}
	
	public static String getFileBuffer(String fileName){
		StringBuilder sb=new StringBuilder();
		BufferedReader reader=null;
		try {
			FileInputStream fis=new FileInputStream(fileName);
			InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
			reader=new BufferedReader(isr);
			String line=null;
			while((line=reader.readLine())!=null){
				sb.append(line);
				sb.append("\r\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public static boolean create(String filePath,String content ) throws IOException{
		File file=new File(filePath);
		if(!file.exists()){
			boolean sucess=file.createNewFile();
			if(!sucess){
				return false;
			}
		}
		FileOutputStream fileOutput=new FileOutputStream(file);
		PrintWriter fileWriter =new PrintWriter(new OutputStreamWriter(fileOutput,"UTF-8"));
		BufferedWriter  bufferedWriter =new BufferedWriter(fileWriter);
		bufferedWriter.write(content);
		bufferedWriter.close();
		return true;
	}
	
	public static String getClassPath(){
		URL url =FileHelper.class.getResource("/");
		String classpath=url.getPath();
		return classpath;
	}
}
