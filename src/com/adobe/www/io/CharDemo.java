package com.adobe.www.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/*
 * 	1.找源或目标
 * 	2.创建管道并和源或目标连接上
 * 	3.IO操作
 * 	4.关闭资源
 */

/**
 * 操作字符和字节流:仅仅是管道类型不一样和操作的单位不一样
 * 
 * @author will
 * 
 */
public class CharDemo {

	/**
	 * 使用字符输入流取读取数据
	 * 
	 * @param srcF
	 */
	public static void read(File srcFile) {
		Reader reader = null;
		try {
			reader = new FileReader(srcFile);
			// IO操作

			char[] buff = new char[1024];// 创建一个大小为1024个字符的缓冲区

			int len = 0;// 表示读取的字符长度
			while ((len = reader.read(buff)) != -1) {
				// 数据依然在缓冲区里
				String data = new String(buff, 0, len);
				System.out.println(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void write(File destFile) throws IOException {
		Writer w = new FileWriter(destFile);

		w.write("爱老虎油".toCharArray());

		w.write("哈哈哈哈哈哈哈哈,嘻嘻嘻,呵呵呵");
		w.write("\n");
		w.write("青羊区的天是艳阳的天,");
		w.write("\n");
		w.write("成都市的人民好喜欢,");
		w.write("\n");
		w.write("站在高楼大声喊:");
		w.write("\n");
		w.write("我爱你,四川!");
		w.write("\n");

		// w.flush();
		w.close();
	}

	public static void main(String[] args) throws IOException {
		// File srcFile = new File("src/io/CharDemo.java");
		// read(srcFile);

		// write(new File("SpringBrother.java"));
		
		//copy("src/io/CharDemo.java","src/io/CharDemo2.java");
		copy("ps.jpg","钓丝.jpg");
	}

	public static void copy(String src, String dest) {

		try (
		// 打开资源
				Reader r = new FileReader(src);
				Writer w = new FileWriter(dest);) 
			{
			char[] buff = new char[1024];
			int len = 0;
			while ((len = r.read(buff)) != -1) {
				w.write(buff, 0, len);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
