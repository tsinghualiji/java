package com.adobe.www.inheritance;

public class Student extends Person{
	
	String sNum;

	public Student() {
		super();
	}
	
	public Student(String name, String gender, int age, String sNum){
		this(name, gender, age);
		this.sNum = sNum;
	}

	public Student(String name, String gender, int age) {
		super(name, gender, age);
	}

	public Student(String name, String gender) {
		super(name, gender);
	}

	public Student(String name) {
		super(name);
	}

	public String getsNum() {
		return sNum;
	}

	public void setsNum(String sNum) {
		this.sNum = sNum;
	}

}
