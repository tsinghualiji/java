package com.adobe.www;

public class LocalVariable {

	/**
	 * @param args
	 * 局部变量，当他们执行完成后，变量将会被销毁
	 * 局部变量是在栈上分配的。
	 * 局部变量没有默认值，所以局部变量是被声明后，必须经过初始化，才可以使用。
	 */
	public void pupAge(){
		int age = 0;
	    age = age + 7;
	    System.out.println("Puppy age is : " + age);
	}

	public static void main(String args[]){
		LocalVariable test = new LocalVariable();
	    test.pupAge();
	}
}
