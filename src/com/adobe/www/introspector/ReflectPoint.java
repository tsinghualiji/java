package com.adobe.www.introspector;

public class ReflectPoint {


	public ReflectPoint(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	private int x;
	public int y;

	public String star1 = "ball";
	public String str2 = "basketball";
	public String str3 = "scene777";

	@Override
	public String toString() {
		return "ReflectPoint [star1=" + star1 + ", str2=" + str2 + ", str3="
				+ str3 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReflectPoint other = (ReflectPoint) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
}
