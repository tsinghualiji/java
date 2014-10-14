package com.adobe.www.innerclass;

//非静态内部类
class Outer{
	public String name = "outer";
	class Inner{
		public String name = "inner";
		public void test(){
			String name = "test";
			System.out.println("inner.test......");
		}
	}
	public void show() {
		new Inner().test();
	}
}

public class InnerClassDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.new Inner().test();
		new Outer().new Inner().test();
	}
}
