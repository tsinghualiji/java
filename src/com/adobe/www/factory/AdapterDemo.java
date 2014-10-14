package com.adobe.www.factory;
/**
 * 适配器模式
 */
interface IWindow{
	void max();
	void min();
	void close();
}
//使用abstract修饰，目的时为了保证别人不能创造适配器对象
abstract class WindowAdaptor implements IWindow{
	public void max(){}
	public void min(){}
	public void close(){}
}

class MyWindow extends WindowAdaptor{
	public void close(){
		System.out.println("MyWindow is closing");
	}
}

public class AdapterDemo {

	public static void main(String[] args){
		IWindow myWindow = new MyWindow();
		myWindow.close();
	}
}
