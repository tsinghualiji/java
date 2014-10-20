package com.adobe.www.annotation;

@MyAnnotation(color="RED",value="123",arrayAttr={1,2,3})
public class AnnotationTest {

	public static void main(String[] args) {

		System.out.println(AnnotationTest.class.isAnnotationPresent(MyAnnotation.class));
		MyAnnotation mAnnotation = (MyAnnotation)AnnotationTest.class.getAnnotation(MyAnnotation.class);
		System.out.println(mAnnotation.value());
		System.out.println(mAnnotation.color());
		System.out.println(mAnnotation.arrayAttr());
		
	}

}
