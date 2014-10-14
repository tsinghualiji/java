package com.adobe.www.inheritance;

public class InheritanceDemo {

	public static void main(String[] args){

		Teacher teacher = new Teacher("A","male",25,"1234");
		System.out.println(teacher.toString());
		//子类对象访问实例成员的时候，是先在子类里找，要是找不到就去父类中查找。
		System.out.println(new Teacher("B").name);
	}
}
