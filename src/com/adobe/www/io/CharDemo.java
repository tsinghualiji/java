package com.adobe.www.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/*
 * 	1.��Դ��Ŀ��
 * 	2.�����ܵ�����Դ��Ŀ��������
 * 	3.IO����
 * 	4.�ر���Դ
 */

/**
 * �����ַ����ֽ���:�����ǹܵ����Ͳ�һ���Ͳ����ĵ�λ��һ��
 * 
 * @author will
 * 
 */
public class CharDemo {

	/**
	 * ʹ���ַ�������ȡ��ȡ����
	 * 
	 * @param srcF
	 */
	public static void read(File srcFile) {
		Reader reader = null;
		try {
			reader = new FileReader(srcFile);
			// IO����

			char[] buff = new char[1024];// ����һ����СΪ1024���ַ��Ļ�����

			int len = 0;// ��ʾ��ȡ���ַ�����
			while ((len = reader.read(buff)) != -1) {
				// ������Ȼ�ڻ�������
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

		w.write("���ϻ���".toCharArray());

		w.write("����������������,������,�ǺǺ�");
		w.write("\n");
		w.write("��������������������,");
		w.write("\n");
		w.write("�ɶ��е������ϲ��,");
		w.write("\n");
		w.write("վ�ڸ�¥������:");
		w.write("\n");
		w.write("�Ұ���,�Ĵ�!");
		w.write("\n");

		// w.flush();
		w.close();
	}

	public static void main(String[] args) throws IOException {
		// File srcFile = new File("src/io/CharDemo.java");
		// read(srcFile);

		// write(new File("SpringBrother.java"));
		
		//copy("src/io/CharDemo.java","src/io/CharDemo2.java");
		copy("ps.jpg","��˿.jpg");
	}

	public static void copy(String src, String dest) {

		try (
		// ����Դ
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
