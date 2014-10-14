package com.adobe.www.inheritance;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class Person {

	String name;
	String gender;
	int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Person(){}

	public Person(String name){
		this.name = name;
		System.out.println("SuperClass.constructor....");
	}
	
	public Person(String name, String gender){
		this(name);
		this.gender = gender;
	}
	
	public Person(String name, String gender, int age) {
		this(name,gender);
		this.age = age;
	}

}
