package com.adobe.www.io;

public class PrintfDemo {
	public static void main(String[] args) {
		
		String name = "Will";
		int age = 17;
		char score = 'A';
		//����= XX,����=xx,����=xx
		System.out.println("����=" + name +",����=" + age +",����=" + score);
		//��ʽ  %ռλ��
		//String format = "����= %s,����=%d,����=%c";
		String format = "����= %s,����=%s,����=%s";
		System.out.printf(format, name,age,score);
		/**
		 * ��ӡʮ����,�˽���,ʮ������
		 */
		System.out.println();
		int num = 20;
		System.out.printf("�˽���=%o, ʮ������=%x",num,num);
		System.out.println();
		System.out.println(Integer.toOctalString(num));
		System.out.println(Integer.toHexString(num));
	}
}
