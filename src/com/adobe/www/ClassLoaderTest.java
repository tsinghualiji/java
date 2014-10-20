package com.adobe.www;

public class ClassLoaderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(ClassLoaderTest.class.getClassLoader().getClass().getName());
		System.out.println(System.class.getClassLoader());
	}

}
