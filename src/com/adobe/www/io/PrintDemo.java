package com.adobe.www.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PrintDemo {
	public static void main(String[] args) throws IOException {
		PrintStream ps = new PrintStream("out.txt");
		ps.write('A');
		// ps.print();
		ps.print(false);
		ps.print(true);
		ps.println();
		ps.println("Will");
		ps.println(113);
		ps.println(false);
		ps = System.out;
		System.out.println("");
		PrintWriter pw = new PrintWriter("out2.txt");
		// PrintWriter(Writer out, boolean autoFlush)
		// �� PrintStream �಻ͬ������������Զ�ˢ�£���ֻ���ڵ��� println��printf �� format
		// ������һ������ʱ�ſ�����ɴ˲���
		//pw = new PrintWriter(new FileWriter("out3.txt"), true);
		pw = new PrintWriter(System.out,true);
		pw.println("����������");
		pw.println(false);
		// pw.close();
	}
}
