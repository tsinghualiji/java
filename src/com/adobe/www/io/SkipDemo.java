package com.adobe.www.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class SkipDemo {
	public static void main(String[] args) throws IOException {
		
		Reader r = new FileReader("stream.txt");
		
		long i = r.skip(3);
		System.out.println(i);
		
		char c = (char)r.read();
		System.out.println(c);
	}
}
