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
			
			//��classpath�ĸ�·��ȡ����
			
			/**
			 * 1.�Ȼ���������
			 * 2.�õ�����������֮��,���� getResourceAsStream()
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
          			���������ж�ȡ�����б�����Ԫ�ضԣ��� 
 			void load(Reader reader) 
          			���򵥵������еĸ�ʽ�������ַ����ж�ȡ�����б�����Ԫ�ضԣ��� 
          			
          	void list(PrintStream out) 
          		�������б������ָ����������� 
 			void list(PrintWriter out) 
          		
          		�������б������ָ����������� 
          		
          	void store(OutputStream out, String comments) 
          			���ʺ�ʹ�� load(InputStream) �������ص� Properties ���еĸ�ʽ������ Properties ���е������б�����Ԫ�ضԣ�д��������� 
 			void store(Writer writer, String comments) 
          		���ʺ�ʹ�� load(Reader) �����ĸ�ʽ������ Properties ���е������б�����Ԫ�ضԣ�д������ַ��� 
			
			void storeToXML(OutputStream os, String comment) 
          		����һ����ʾ�˱��а������������Ե� XML �ĵ��� 
		 */
		
		
		System.out.println(p);
		
		p.list(System.out);//�г�������̨
		p.list(new PrintStream("87.java"));
		
		p.store(new FileOutputStream("���.properties"), "��֪����ɶ");
		
		//p.storeToXML(new FileOutputStream("xml.xml"), "ע������");
		
		p.loadFromXML(new FileInputStream("xml.xml"));
		System.out.println("--"+p);
	}
}
