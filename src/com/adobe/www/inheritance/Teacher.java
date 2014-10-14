package com.adobe.www.inheritance;

public class Teacher extends Person{

	String tNum;

	public Teacher() {
		super();
	}
	
	public Teacher(String name, String gender, int age, String tNum){
		super(name, gender, age);
		this.tNum = tNum;
	}

	public Teacher(String name, String gender, int age) {
		super(name, gender, age);
	}

	public Teacher(String name, String gender) {
		super(name, gender);
	}

	public Teacher(String name) {
		super(name);
		System.out.println("SubClass.constructor.....");
	}

	public String gettNum() {
		return tNum;
	}

	public void settNum(String tNum) {
		this.tNum = tNum;
	}
	
	public String toString(){
		
		return "Teacher";
	}
	
}
