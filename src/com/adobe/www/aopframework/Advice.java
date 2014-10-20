package com.adobe.www.aopframework;

import java.lang.reflect.Method;
/*
 * 这就是面向切面编程，将在指定方法运行前或后面运行其他的方法，这里将这些其他的方法封装成对象。
 * */
public interface Advice {

	void beforeMethod(Method method);
	void afterMethod(Method method);
	
}
