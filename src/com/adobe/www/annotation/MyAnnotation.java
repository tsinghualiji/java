package com.adobe.www.annotation;

import com.adobe.www.EnumTest;
import java.awt.Color;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.lang.model.element.Element;

@Retention(RetentionPolicy.RUNTIME)//注解的生命周期，存在于source, class 或者 runtime
@Target(ElementType.TYPE)//注解的作用范围：是方法，类，包之类的。
public @interface MyAnnotation {
	
	String color() default "blue";
	String value();
	int[] arrayAttr() default {10,20,30};
	
}
