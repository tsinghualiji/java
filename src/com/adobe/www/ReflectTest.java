package com.adobe.www;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//获取Class文件的3种方法
		String str1 = "abc";
		Class cls1 = str1.getClass();
		Class cls2 = String.class;
		Class cls3 = Class.forName("java.lang.String");
		System.out.println(cls1 == cls2);
		System.out.println(cls3 == cls2);
		
		System.out.println(cls1.isPrimitive());
		System.out.println(int.class.isPrimitive());
		
		ReflectPoint pt1 = new ReflectPoint(3,5);
		Field filedY = pt1.getClass().getField("y");
		//fieldY的值是多少？filedY不是对象身上的变量，而是类上的，要用它去取某个对象的值。
		System.out.println(filedY.get(pt1));
		
		Field filedX = pt1.getClass().getDeclaredField("x");
		filedX.setAccessible(true);
		System.out.println(filedX.get(pt1));
		
		changeStringValue(pt1);
		System.out.println(pt1);
		//先取出String这个类的class中的charAt方法的字节码，然后用这个字节码去作用在str1这个对象上去。
		Method methodCharAt = String.class.getMethod("charAt", int.class);
		//methodCharAt可以理解成一个方法对象。
		System.out.println(methodCharAt.invoke(str1, 1));
		//如果传递给Method对象的invoke方法的第一个参数为null,则说明该Method对象对应的是一个静态方法。
		//TestArguments.main(new String[]{"123","345"});
		String startClassName = args[0];
		Method mainMethod = Class.forName(startClassName).getMethod("main", String[].class);
		mainMethod.invoke(null, (Object)new String[]{"111","222","333"});
	}

	private static void changeStringValue(Object obj) throws Exception {
		// TODO Auto-generated method stub
		Field[] fields = obj.getClass().getFields();
		for(Field field: fields){
			//这里应该用==，不应该用equals,因为是同一份字节码
			if(field.getType() == String.class){
				String oldValue = (String)field.get(obj);
				String newValue = oldValue.replace('b', 'a');
				field.set(obj, newValue);
			}
		}
	}
}

class TestArguments{
	
	public static void main(String args[]){
		
		for(String arg : args){
			System.out.println(arg);
		}
	}
}




