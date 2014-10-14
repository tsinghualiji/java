package com.adobe.www.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamDemo {

	public static void main(String[] args) throws IOException {
		OutputStream os = new FileOutputStream("test.txt",true);
		for (int i = 65; i< 91; i++){
		os.write(i);
		//字节流没有使用缓冲区
		}
		String string = "字节流没有使用缓冲区";
		byte[] bytes = string.getBytes();
		os.write(bytes);
	}
}
