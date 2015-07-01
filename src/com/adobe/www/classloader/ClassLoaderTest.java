package com.adobe.www.classloader;

public class ClassLoaderTest throws Exception{

	//1. Null(BootStrap rt.jar) --> 2. Extension ClassLoader(jre/lib/ext)--> 3. AppClassLoader classpath
	public static void main(String[] args) {

		System.out.println(ClassLoaderTest.class.getClassLoader().getClass().getName());
		System.out.println(System.class.getClassLoader());
		
		ClassLoader loader = ClassLoaderTest.class.getClassLoader();
		while(loader != null){
			System.out.println(loader.getClass().getName());
			loader = loader.getParent();
		}
		System.out.println(loader);
		
		Class clazzClass = new MyClassLoader("adobe").loadClass("ClassLoaderAttachment");
	}
}
}