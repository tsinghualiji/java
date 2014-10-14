package com.adobe.www.exception;

public class TryCatchFinnally {

	public static void main(String[] args) {
		try{
			int a = 1/0;
			System.out.println("try");
		}catch(Exception e){
			System.out.println("catch");
		}finally{
			System.out.println("finnaly");
		}
		System.out.println("ending");
	}

}
