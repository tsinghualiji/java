package com.adobe.www.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamDemo {
	public static void main(String[] args) throws IOException {
		
		//1,�ҵ�����Դ
		File src = new File("day21.txt");
		//2. �����������Ĺܵ�,����Դ������
		InputStream is = new FileInputStream(src);
		//3. ��ȡ����
		/*for (int i = 0; i < 100; i++) {
			System.out.println((char)is.read());
		}*/
		//�洢�������ݵĻ�����
		byte[] buff = new byte[1024];//����һ��1024���ֽڵĻ�����
		int len = 0;//��ʾ��һ��,���˶�����ֽ�,  ��len == -1��ʾ������
		while((len= is.read(buff)) != -1){
			//String(byte[] bytes, int offset, int length)  ����һ���µ� String��
			
			//ȥ��������ȡ����
			String data = new String(buff,0,len);
			System.out.println(data);
			System.out.println("========================================");
		}
		//4.�رղ���
		is.close();
	}
}
