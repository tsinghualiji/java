package com.adobe.www.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamDemo {
	public static void main(String[] args) throws IOException {
		
		//1,找到数据源
		File src = new File("day21.txt");
		//2. 创建输入流的管道,并和源连接上
		InputStream is = new FileInputStream(src);
		//3. 读取操作
		/*for (int i = 0; i < 100; i++) {
			System.out.println((char)is.read());
		}*/
		//存储读入数据的缓冲区
		byte[] buff = new byte[1024];//定义一个1024个字节的缓冲区
		int len = 0;//表示这一次,读了多个各字节,  若len == -1表示读完了
		while((len= is.read(buff)) != -1){
			//String(byte[] bytes, int offset, int length)  构造一个新的 String。
			
			//去缓冲区获取数据
			String data = new String(buff,0,len);
			System.out.println(data);
			System.out.println("========================================");
		}
		//4.关闭操作
		is.close();
	}
}
