package com.adobe.www.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy {
	public static void main(String[] args) {
		if (args.length == 2) {
			String sPath = args[0];
			String dPath = args[1];
			FileInputStream input = null;
			FileOutputStream output = null;
			try {
				input = new FileInputStream(sPath);
				output = new FileOutputStream(dPath);

				byte[] bys = new byte[1024];
				int len = 0;

				while ((len = input.read(bys)) != -1) {
					output.write(bys, 0, len);
				}
				System.out.println("copy Ok");
			} catch (FileNotFoundException e) {
				System.out.println("文件不存在");
				System.exit(0);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (output != null) {
					try {
						output.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (input != null) {
					try {
						input.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
