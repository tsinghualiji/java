package com.adobe.www.io;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

/**
 * 内存流不用关闭
 */
public class CharArrayDemo {
	public static void main(String[] args) throws IOException {
		String data = "I love CUMTB";
		//程序  -> 内存
		CharArrayWriter cw = new  CharArrayWriter();
		cw.write(data);//FileOutputStream
		char[] cs = cw.toCharArray();//取出内存输出流的数据
		System.out.println(cs.length);
		//把内存的数据   --->  程序
		CharArrayReader cr = new CharArrayReader(cs);
		char[] buff = new char[1024];
		int len = 0;
		while((len = cr.read(buff)) != -1){
			System.out.println(new String(buff,0,len));
		}
		
	}
}
