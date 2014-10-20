package com.adobe.www.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 *		�ڴ������Բ��ùر� 
 *
 */
public class ByteStreamDemo {
	public static void main(String[] args) throws IOException {
		
		String data  = "java,i love you!";
		//���浽�ڴ���ȥ.//����-->�ڴ� 
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		bos.write(data.getBytes());
		//�ڴ� -->  ���� 	byte[] toByteArray() ����һ���·���� byte ����
		byte[] bys = bos.toByteArray();//����������
		ByteArrayInputStream bis = new  ByteArrayInputStream(bys);
		byte[] b= new byte[1024];
		int len = 0;
		while((len = bis.read(b)) != -1){
			String str = new String(b,0,len);
			System.out.println(str);
		}
	}
}
