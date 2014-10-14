package com.adobe.www.generic;

public class PointDemo {

	public static void main(String[] args) {

		//制定范型时只能用包装类或者引用类型
		//创建一个带范型的对象时，尽量保证编译类型和运行范型保持一致
		Point<Integer> point = new Point<Integer>();
		point.setX(1);
		point.setY(2);
		
		Point<Double> point2 = new Point<Double>();
		point2.setX(1.23);
		point2.setY(2.45);
		
		System.out.println(point);
		System.out.println(point2);
		
		
		
		
		
		
		
		
		
	}

}
