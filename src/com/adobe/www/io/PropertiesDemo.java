package com.adobe.www.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Properties;

public class PropertiesDemo {
	
	private static  Properties p = null;
	private static String filename = "xx.properties"; 
	
	static{
		p = new Properties();
		
		InputStream inStream = null;
		try{
			//	inStream = new FileInputStream(filename);
			
			//从classpath的根路径取加载
			
			/**
			 * 1.先获得类加载器
			 * 2.得到加载器对象之后,调用 getResourceAsStream()
			 */
			
			inStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
			p.load(inStream);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		
		/**
		 *  void load(InputStream inStream) 
          			从输入流中读取属性列表（键和元素对）。 
 			void load(Reader reader) 
          			按简单的面向行的格式从输入字符流中读取属性列表（键和元素对）。 
          			
          	void list(PrintStream out) 
          		将属性列表输出到指定的输出流。 
 			void list(PrintWriter out) 
          		
          		将属性列表输出到指定的输出流。 
          		
          	void store(OutputStream out, String comments) 
          			以适合使用 load(InputStream) 方法加载到 Properties 表中的格式，将此 Properties 表中的属性列表（键和元素对）写入输出流。 
 			void store(Writer writer, String comments) 
          		以适合使用 load(Reader) 方法的格式，将此 Properties 表中的属性列表（键和元素对）写入输出字符。 
			
			void storeToXML(OutputStream os, String comment) 
          		发出一个表示此表中包含的所有属性的 XML 文档。 
		 */
		
		
		System.out.println(p);
		
		p.list(System.out);//列出到控制台
		p.list(new PrintStream("87.java"));
		
		p.store(new FileOutputStream("输出.properties"), "不知道是啥");
		
		//p.storeToXML(new FileOutputStream("xml.xml"), "注视内容");
		
		p.loadFromXML(new FileInputStream("xml.xml"));
		System.out.println("--"+p);
	}
}
