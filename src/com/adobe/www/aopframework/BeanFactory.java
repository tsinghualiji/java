package com.adobe.www.aopframework;

/**
 * BeanFactory用来获取bean. 实际上就是用来获取Proxy
 */
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BeanFactory {
	
	Properties props = new Properties();
	public BeanFactory(InputStream ips){
		try {
			props.load(ips);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Object getBean(String name){
		String className = props.getProperty(name);
		Class clazz = null;
		Object bean = null;
		try {
			clazz = Class.forName(className);
			bean = clazz.newInstance();//调用无参的构造方法
		} catch (Exception e) {
			e.printStackTrace();
		} 
		if(bean instanceof ProxyFactoryBean){
			Object proxy = null;
			ProxyFactoryBean proxyFactoryBean = (ProxyFactoryBean)bean;
			try {
				Advice advice = (Advice)Class.forName(props.getProperty(name + ".advice")).newInstance();
				Object target = Class.forName(props.getProperty(name + ".target")).newInstance();
				proxyFactoryBean.setAdive(advice);
				proxyFactoryBean.setTarget(target);
				proxy = proxyFactoryBean.getProxy();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return proxy;
		}
		return bean;
	}
}
