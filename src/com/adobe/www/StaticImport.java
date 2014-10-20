package com.adobe.www;
import static java.lang.Math.*;

public class StaticImport {

	public static void main(String[] args){
		
		
		String s1 = new String("abc");
		String s2 = new String("abc");
		Integer i1 = 127;
		Integer i2 = 127;
		System.out.println(s1 == s2);
		System.out.println(i1 == i2);
		
		int x = 1;
		x++;
		System.out.println(add(1,2,3,4,5));
	}
		
	public static int add(int arg,int ...args){
		  int sum=arg;
		  for(int i=0;i<args.length;i++){
		   sum+=args[i];
		  }
		  return sum;
	}
	
	
	
	
	
}
