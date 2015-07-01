package com.adobe.www.aopframework;

/**
 * 此类主要用来生产代理的 proxy bean
 */
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactoryBean {

	public Advice getAdive() {
		return advice;
	}

	public void setAdive(Advice advice) {
		this.advice = advice;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	private Advice advice;
	private Object target;
	
	public Object getProxy() {
		Object proxy = Proxy.newProxyInstance(
				target.getClass().getClassLoader(),
				target.getClass().getInterfaces(),
				new InvocationHandler(){
					@Override
					public Object invoke(Object proxy, Method method,
							Object[] args) throws Throwable {
						advice.beforeMethod(method);
						Object retVal = method.invoke(target, args);
						System.out.println(method.getName());
						advice.afterMethod(method);
						return retVal;
					}
				}
				);
		return proxy;
	}

}
