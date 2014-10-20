package com.adobe.www.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 *		内存流可以不用关闭 
 *
 */
public class ByteStreamDemo {
	public static void main(String[] args) throws IOException {
		
		String data  = "java,i love you!";
		//保存到内存中去.//程序-->内存 
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		bos.write(data.getBytes());
		//内存 -->  程序 	byte[] toByteArray() 创建一个新分配的 byte 数组
		byte[] bys = bos.toByteArray();//真正的数据
		ByteArrayInputStream bis = new  ByteArrayInputStream(bys);
		byte[] b= new byte[1024];
		int len = 0;
		while((len = bis.read(b)) != -1){
			String str = new String(b,0,len);
			System.out.println(str);
		}
	}
}
