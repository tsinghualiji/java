package com.adobe.www.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamDemo {
	public static void main(String[] args) throws IOException {
		
		//1.�ҵ�����Ŀ��
		String filename = "stream.txt";
		//2. ����������Ĺܵ�,��������Ŀ��l,os��������ܵ�
		OutputStream os = new FileOutputStream(filename,true);
		//3. �������
		os.write('\n');
		for (int i =65; i < 91; i++) {
			os.write(i);
		}
		String  data = "adobe";//�����ṩ������
		byte[] b= data.getBytes();//�õ��ֽ����͵�����
		os.write(b);
		os.write('\n');
		os.write(b,2,2);//�õ� "cditcast"�� "it"
		//4. �رղ���
		os.close();//�ֽ���û��ʹ�û�����,
		
	}
}
