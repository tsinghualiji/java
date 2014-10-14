package com.adobe.www.generic;

public class Point <T>{//定义一个类的适合，采用T表示一种类型，仅仅表示占位符,但是此时真正的类型尚未确定，使用时才能确定。

	private T x;
	public T getX() {
		return x;
	}
	public void setX(T x) {
		this.x = x;
	}
	public T getY() {
		return y;
	}
	public void setY(T y) {
		this.y = y;
	}
	private T y;

}
