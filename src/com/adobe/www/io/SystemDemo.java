package com.adobe.www.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;

public class SystemDemo {
	public static void main(String[] args) throws IOException {
		
		/**
		 * ��׼��:
		 * 		��׼������:  System.in   Ĭ�ϱ�ʾ���Ǽ���¼��
		 * 		��׼�����:  System.out  Ĭ�ϱ�ʾ������Ļ���
		 * 		����������������ӡ����Ļ��,��ô��?
		 * 		�������Ҳ���ͨ��������¼������,����ô��?		 * 
		 * 		�����ض���:
		 * 		static void setOut(PrintStream out)     ���·��䡰��׼��������� 
		 * 		static void setIn(InputStream in)  ���·��䡰��׼���������� 
		 */
		System.out.println("12123");
		System.out.println("----end-----");
		System.err.println("12123");
		//����Ļ����ض���setOut.txt,�Ժ�Ĵ�ӡ�Ͳ����ӡ����Ļ����,���Ǵ�ӡ��setOut.txt�ļ�����
		System.setOut(new PrintStream("setOut.txt"));
		System.out.println("AAAA");
		System.out.println("BBBB");
		//===================================
		int  i = System.in.read();//���ܴӼ������������
		System.out.println("����¼��������=  "+(char)i);
		System.out.println("---------------------------");
		/**
		 * ���·��� �����Դ,ԭ���Ǽ���,���ڸĳ� day21��ϰ.txt�ļ�
		 */
		System.setIn(new FileInputStream("day21��ϰ.txt"));
		
		byte[] buff = new byte[1024];
		int len = 0;
		while((len = System.in.read(buff)) != -1){
			System.out.println(new String(buff,0,len));
		}
	}
}
