package com.adobe.www.aopframework;

import java.io.InputStream;
import java.util.Collection;

public class AopFramworkTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream ips = AopFramworkTest.class.getResourceAsStream("config.properties");
		Object bean = new BeanFactory(ips).getBean("xxx");
		System.out.println(bean.getClass().getName());
		((Collection)bean).add(new Object());
	}

}
