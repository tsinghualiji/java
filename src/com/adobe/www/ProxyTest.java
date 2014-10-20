package com.adobe.www;

import java.util.ArrayList;
import java.util.Collection;
import java.lang.reflect.*;

import com.adobe.www.aopframework.Advice;
import com.adobe.www.aopframework.MyAdvice;

public class ProxyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class clazzProxy1 = Proxy.getProxyClass(Collection.class.getClassLoader(),Collection.class);
		System.out.println(clazzProxy1.getName());
		
		System.out.println("begin constructor list.......");
		Constructor[] constructors = clazzProxy1.getConstructors();
		for(Constructor constructor : constructors){
			String name = constructor.getName();
			StringBuilder sBuilder = new StringBuilder(name);
			sBuilder.append('(');
			Class[] clazzParas = constructor.getParameterTypes();
			for(Class clazzPara : clazzParas){
				sBuilder.append(clazzPara.getName()).append(',') ;
			}
			sBuilder.append(')');
			System.out.println(sBuilder.toString());
		}
		
		System.out.println("begin method list.......");
		Method[] methods = clazzProxy1.getMethods();
		for(Method method : methods){
			String name = method.getName();
			StringBuilder sBuilder = new StringBuilder(name);
			sBuilder.append('(');
			Class[] clazzParas = method.getParameterTypes();
			for(Class clazzPara : clazzParas){
				sBuilder.append(clazzPara.getName()).append(',') ;
			}
			sBuilder.append(')');
			System.out.println(sBuilder.toString());
		}
		
		System.out.println("begin create instance object.......");
		//这个会调用不带参数的构造方法clazzProxy1.newInstance();
		Constructor constructor = clazzProxy1.getConstructor(InvocationHandler.class);
		
		class MyInvocationHandler1 implements InvocationHandler{

			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				// TODO Auto-generated method stub
				return null;
			}
		}
		
		Collection proxy1 = (Collection)constructor.newInstance(new MyInvocationHandler1());
		System.out.println(proxy1);
		proxy1.clear();
		//proxy1.size();
		
		Collection proxy2 = (Collection)constructor.newInstance(new InvocationHandler(){

			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				// TODO Auto-generated method stub
				return null;
			}
		});
		
		//内部类访问外部类的局部变量需加final关键字
		final ArrayList target = new ArrayList();	
		Collection proxy3 = (Collection)getProxy(target, new MyAdvice());
		proxy3.add("ray");
		proxy3.add("cong");		
		proxy3.add("jun");
		System.out.println(proxy3.size());

	}

	private static Object getProxy(final Object target, final Advice advice) {
		Object proxy3 = Proxy.newProxyInstance(target.getClass().getClassLoader(),
				/*new Class[]{Collection.class},*/
				target.getClass().getInterfaces(),
				new InvocationHandler(){
					@Override
					public Object invoke(Object proxy, Method method,
							Object[] args) throws Throwable {
/*						// TODO Auto-generated method stub
						//此处可加代码doBefore();
						Object retVal = method.invoke(target, args);
						//doAfter();
						System.out.println(method.getName());
						return retVal;*/
						advice.beforeMethod(method);
						Object retVal = method.invoke(target, args);
						advice.afterMethod(method);
						System.out.println(method.getName());
						return retVal;
					}
				}
				);
		return proxy3;
	}
  
}
