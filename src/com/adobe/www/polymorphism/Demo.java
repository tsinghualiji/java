package com.adobe.www.polymorphism;

class Person {

}

class Student extends Person{

}

public class Demo{
	
	public static void main(String[] args){
		
		//继承是多态产生的前提
		Person P = new Student();
		//编译类型是Person，运行类型是Student，此时有多态。运行类型是对象实际的类型，也就是说是对象真正的类型。
		//把编译类型当做是，把对象看成什么类型。
		
		//一般在强制类型转换时，需要判断对象是否属于另外一个对象。可以用instanceof进行判断。
		//但是instanceof不能随便用，需判断对象A的类型与类型B是否时继承关系。
		System.out.println(Integer.toBinaryString(10));
		System.out.println(Integer.toHexString(10));
		System.out.println(Integer.toOctalString(10));
		System.out.println(Integer.toString(10));

	}
}

