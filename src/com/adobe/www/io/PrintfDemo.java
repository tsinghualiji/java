package com.adobe.www.io;

public class PrintfDemo {
	public static void main(String[] args) {
		
		String name = "Will";
		int age = 17;
		char score = 'A';
		//名字= XX,年龄=xx,分数=xx
		System.out.println("名字=" + name +",年龄=" + age +",分数=" + score);
		//格式  %占位符
		//String format = "名字= %s,年龄=%d,分数=%c";
		String format = "名字= %s,年龄=%s,分数=%s";
		System.out.printf(format, name,age,score);
		/**
		 * 打印十进制,八进制,十六进制
		 */
		System.out.println();
		int num = 20;
		System.out.printf("八进制=%o, 十六进制=%x",num,num);
		System.out.println();
		System.out.println(Integer.toOctalString(num));
		System.out.println(Integer.toHexString(num));
	}
}
