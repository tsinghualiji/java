package com.adobe.www.aopframework;

import java.lang.reflect.Method;


public class MyAdvice implements Advice {

	@Override
	public void beforeMethod(Method method) {
		// TODO Auto-generated method stub
		System.out.println(method.getName()+"  doing before method.......");
	}

	@Override
	public void afterMethod(Method method) {
		// TODO Auto-generated method stub
		System.out.println(method.getName()+"  doing after method.......");
	}

}
