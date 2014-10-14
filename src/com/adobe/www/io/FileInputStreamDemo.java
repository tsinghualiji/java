package com.adobe.www.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.naming.InitialContext;

public class FileInputStreamDemo {

	public static void main(String[] args) throws IOException {

		InputStream iStream = new FileInputStream("test.txt");
		byte[] bytes = new byte[1024];
		int len = 0;
		while( (len = iStream.read(bytes) )!= -1){
			String dataString = new String(bytes);
			System.out.println(dataString);
		}
		
	}

}
