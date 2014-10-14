package com.adobe.www.singleton;

/*
 * 单例模式： 1.饿汉模式
 * 			2.懒汉模式
 */
class Singleton{

	//饿汉模式， 在类加载时会损失一些性能。
	//把构造方法私有化，不允许外界再创建对象
	private Singleton(){}
	
	private static final Singleton instance = new Singleton();
	
	public static Singleton getInstance(){
		return instance;
	}
}

class Singleton2{
	
	//懒汉模式，在使用时才会创建，线程不安全。
	private static Singleton2 instance;
	
	public static Singleton2 getInstance(){
		
		if(instance == null){
			instance = new Singleton2();
		}
		
		return instance;
	}
	
	private Singleton2(){}

}

public class SingletonDemo {

	public static void main(String[] args){
		
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s1 == s2);
		
	}

}
