package com.adobe.www.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;

public class SystemDemo {
	public static void main(String[] args) throws IOException {
		
		/**
		 * 标准流:
		 * 		标准输入流:  System.in   默认表示的是键盘录入
		 * 		标准输出流:  System.out  默认表示的是屏幕输出
		 * 		若现在我输出不想打印在屏幕上,怎么办?
		 * 		若现在我不想通过键盘来录入数据,有怎么办?		 * 
		 * 		流的重定向:
		 * 		static void setOut(PrintStream out)     重新分配“标准”输出流。 
		 * 		static void setIn(InputStream in)  重新分配“标准”输入流。 
		 */
		System.out.println("12123");
		System.out.println("----end-----");
		System.err.println("12123");
		//把屏幕输出重定向到setOut.txt,以后的打印就不会打印在屏幕上了,而是打印在setOut.txt文件里面
		System.setOut(new PrintStream("setOut.txt"));
		System.out.println("AAAA");
		System.out.println("BBBB");
		//===================================
		int  i = System.in.read();//接受从键盘输入的数据
		System.out.println("键盘录入数据是=  "+(char)i);
		System.out.println("---------------------------");
		/**
		 * 重新分配 输入的源,原本是键盘,现在改成 day21复习.txt文件
		 */
		System.setIn(new FileInputStream("day21复习.txt"));
		
		byte[] buff = new byte[1024];
		int len = 0;
		while((len = System.in.read(buff)) != -1){
			System.out.println(new String(buff,0,len));
		}
	}
}
