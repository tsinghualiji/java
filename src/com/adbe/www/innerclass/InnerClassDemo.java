package com.adbe.www.innerclass;

class Outer1
{
	private String name =  "outer";
	class Inner//非静态内部类
	{
		private String name = "inner";
		public void test()
		{
			String name = "test";
			System.out.println(name);//test
			System.out.println(this.name);//inner
			System.out.println(new Outer1().name);//outer
			System.out.println(Outer1.this.name);//outer
		}
	}

	public void show()
	{	
		//在外部类之内访问内部类
		//this.test();//ERROR
		//想执行内部类的test方法
		new Inner().test();
	}	
}

public class InnerDemo
{
	public static void main(String[] args)
	{
		new Outer1().show();
		//想在外部类之外来访问内部类,内部类不能私有
		/*
			非静态内部类访问:

				外部类.内部类  变量 = 外部类实例.new Inner();
		*/
		Outer1 out = new Outer1();//外部类对象
		Outer1.Inner in = out.new Inner();//通过外部类对象,来创建内部类对象,因为 非静态内部类属于外部类的对象
		in.test();
		new Outer1().new Inner().test();
	}
}