package generic;

/**
 * 坐标点
 */
public class Point<T> {//定义一个类的时候,采用T来表示一种类型,仅仅表示占位符;,但是此时真正的类型尚未确定,使用的时候才确定
	
	private T x;
	private T y;
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
}
