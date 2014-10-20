package com.adobe.www.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamDemo {
	public static void main(String[] args) throws IOException {
		
		//1.找到流的目标
		String filename = "stream.txt";
		//2. 创建输出流的管道,并连接上目标l,os就是输出管道
		OutputStream os = new FileOutputStream(filename,true);
		//3. 输出操作
		os.write('\n');
		for (int i =65; i < 91; i++) {
			os.write(i);
		}
		String  data = "adobe";//程序提供的数据
		byte[] b= data.getBytes();//得到字节类型的数据
		os.write(b);
		os.write('\n');
		os.write(b,2,2);//得到 "cditcast"的 "it"
		//4. 关闭操作
		os.close();//字节流没有使用缓冲区,
		
	}
}
