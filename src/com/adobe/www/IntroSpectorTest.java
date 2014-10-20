package com.adobe.www;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class IntroSpectorTest {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		ReflectPoint pt1 = new ReflectPoint(3,5);
		String propetyName = "x";
		Object retVal = getProperty(pt1, propetyName);
		System.out.println(retVal);
	}

	private static Object getProperty(Object pt1, String propetyName)
			throws IntrospectionException, IllegalAccessException,
			InvocationTargetException {
/*		PropertyDescriptor pd = new PropertyDescriptor(propetyName,pt1.getClass());
		Method methodGetX = pd.getReadMethod();
		Object retVal =  methodGetX.invoke(pt1);*/
		
		BeanInfo beanInfo = Introspector.getBeanInfo(pt1.getClass());
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		Object retVal = null;
		for(PropertyDescriptor pd : pds){
			if(pd.getName().equals(propetyName)){
				Method methodGetX = pd.getReadMethod();
				retVal = methodGetX.invoke(pt1);
				break;
			}
		}
		return retVal;
	}

}
