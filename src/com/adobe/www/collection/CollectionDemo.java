package com.adobe.www.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*在集合中存储的永远都是对象的存储地址*/
public class CollectionDemo {

	public static void main(String[] args) {
		
		/*黄色警告式因为这里推荐使用范型Generic*/
		Collection<Object> c = new ArrayList<Object>();
		/*在集合中存储的永远都是对象的存储地址*/
		c.add("A");
		StringBuilder sb = new StringBuilder("ABC");
		c.add(sb);
		System.out.println(c);
		sb.append("DE");
		System.out.println(c);

		for(Object o : c){
			System.out.println(o);
		}
		Iterator it = null;
		/*老外喜欢用的一种写法，因为iterator实例在for循环结束时就被gc回收了，此时it的生命周期短一些*/
		for(it = c.iterator(); it.hasNext();){
			System.out.println(it.next());
		}
		
	}

}
