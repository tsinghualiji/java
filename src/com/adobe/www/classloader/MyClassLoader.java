package com.adobe.www.classloader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class MyClassLoader extends ClassLoader{

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		String srcPath = args[0];
		String destPath = args[1];
		FileInputStream fiStream = new FileInputStream(srcPath);
		FileOutputStream foStream = new FileOutputStream(destPath);
		cypher(fiStream, foStream);
		fiStream.close();
		foStream.close();
		
	}
	
	private static void cypher(InputStream in, OutputStream out)throws Exception{
		
		int b = 0;
		while((b = in.read()) != -1){
			out.write( b^ 0xff);
		}
		
	}
	
	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return super.loadClass(name);
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		//找到class文件存放的目录
		
		//FileInputStream加载class文件
		
		//un-cypher
		
		//defineClass
		return null;
	}

	public MyClassLoader(){}
	
	public MyClassLoader(String classpath){
		this.classpath = classpath;
	}
	
	public String classpath;
	
}
