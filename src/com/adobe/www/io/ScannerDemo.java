package com.adobe.www.io;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/*
 * 
 * 
 * */


public class ScannerDemo {
	public static void main(String[] args) throws IOException {
		
		/**
		 * �ı�ɨ����
		 */
		Scanner sc = new Scanner(System.in);//ɨ�����¼�������
		/**
		 * Scanner useDelimiter(String pattern)    ����ɨ�����ķָ�ģʽ����Ϊ��ָ�� String �����ģʽ�� 
		 */
		//sc.useDelimiter("\\d");
		/**
		 * Scanner(File source)  ����һ���µ� Scanner�������ɵ�ֵ�Ǵ�ָ���ļ�ɨ��ġ�
		 */
		System.setOut(new PrintStream("line.txt"));
		sc = new Scanner(new File("Scanner.txt"));
		int line = 1;
		while(sc.hasNextLine()){//�Ƿ�����һ��
			System.out.println(line +" " + sc.nextLine());//��ȡ��һ��
			line++;
		}
	}
	/**
	 * ��������Ϸ:
	 * 			1.	ϵͳ�������һ������[1,100];   					5
	 * 			2.  �Ӽ���¼��һ������,[1,100]   				4
	 * 			3.  �ж���������ֺ�������Ƚ�:
	 * 					����� > ������:������̫С��
	 * 					����� < ������:����̫����
	 * 					����� = ������: ��ϲŶ
	 */
	
	
}
