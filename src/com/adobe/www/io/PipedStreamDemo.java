package com.adobe.www.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 管道输出流
 */
class Man implements Runnable {

	private PipedOutputStream pos = new PipedOutputStream();
	
	public  PipedOutputStream getPos(){
		return pos;
	}

	public void run() {
		try {
			pos.write("爱老虎油".getBytes());
		} catch (IOException e) {

		} finally {
			if (pos != null) {
				try {
					pos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

/**
 * 管道输入流,接受数据
 */
class Woman implements Runnable {

	private PipedInputStream pis = new PipedInputStream();

	
	public PipedInputStream getPis(){
		return  pis;
	}
	public void run() {
		try {
			byte[] bys = new byte[1024];
			int len = 0;

			while ((len = pis.read(bys)) != -1) {
				System.out.println(new String(bys, 0, len));
			}

		} catch (IOException e) {

		} finally {
			if (pis != null) {
				try {
					pis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

/**
 * 管道流用于两个线程之间交互数据
 * 
 * Man线程对 Woman线程说,爱老虎油,Woman线程 接受到该信息并打印出来
 */
public class PipedStreamDemo {
	public static void main(String[] args) throws IOException {
		/**
		 * 两个线程对象,还需要连接,管道
		 */
		
		Man man = new Man();
		Woman woman   = new Woman();
		
		/*
		 * 建立管道连接
		 */
		//man.getPos().connect(woman.getPis());
		woman.getPis().connect(man.getPos());
		new Thread(man).start();
		new Thread(woman).start();
		
	}
}
