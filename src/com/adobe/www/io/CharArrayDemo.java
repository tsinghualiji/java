package com.adobe.www.io;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

/**
 * �ڴ������ùر�
 */
public class CharArrayDemo {
	public static void main(String[] args) throws IOException {
		String data = "I love CUMTB";
		//����  -> �ڴ�
		CharArrayWriter cw = new  CharArrayWriter();
		cw.write(data);//FileOutputStream
		char[] cs = cw.toCharArray();//ȡ���ڴ������������
		System.out.println(cs.length);
		//���ڴ������   --->  ����
		CharArrayReader cr = new CharArrayReader(cs);
		char[] buff = new char[1024];
		int len = 0;
		while((len = cr.read(buff)) != -1){
			System.out.println(new String(buff,0,len));
		}
		
	}
}
