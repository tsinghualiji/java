package com.adobe.www.generic;

public class CodeSegement {

	{
		System.out.println("我是构造代码快");
	}

	public CodeSegement(){
		System.out.println("我是构造函数");
	}
	
	static{
		System.out.println("我是静态代码块");
	}
	
	public static void main(String[] args) {
		
		System.out.println("我是主函数");
		new CodeSegement();
	}

}
