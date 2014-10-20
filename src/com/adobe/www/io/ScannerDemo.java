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
		 * 文本扫描器
		 */
		Scanner sc = new Scanner(System.in);//扫描键盘录入的数据
		/**
		 * Scanner useDelimiter(String pattern)    将此扫描器的分隔模式设置为从指定 String 构造的模式。 
		 */
		//sc.useDelimiter("\\d");
		/**
		 * Scanner(File source)  构造一个新的 Scanner，它生成的值是从指定文件扫描的。
		 */
		System.setOut(new PrintStream("line.txt"));
		sc = new Scanner(new File("Scanner.txt"));
		int line = 1;
		while(sc.hasNextLine()){//是否有下一行
			System.out.println(line +" " + sc.nextLine());//读取下一行
			line++;
		}
	}
	/**
	 * 猜数字游戏:
	 * 			1.	系统随机生成一个数字[1,100];   					5
	 * 			2.  从键盘录入一个数字,[1,100]   				4
	 * 			3.  判断输入的数字和随机数比较:
	 * 					随机数 > 输入数:你输入太小了
	 * 					随机数 < 输入数:输入太大了
	 * 					随机数 = 输入数: 恭喜哦
	 */
	
	
}
