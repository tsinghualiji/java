package generic;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class PointDemo {
	public static void main(String[] args) {
		
		//使用泛型类
		//给定泛型类型的时候,只能给定引用类型,
		//创建一个带泛型的类的对象时,尽量保证编译类型的泛型和运行类型的泛型一致
		Point<Integer> p = new  Point<Integer>();
		p.setX(1);
		p.setY(1);	
		Point<Double> p2 = new Point<Double>();
		Double x = p2.getX();
		Point<String> p3 = new Point<String>();
		String x3 = p3.getX();
		//============================
		Set<String> s = new HashSet<String>();//创建一个容器对象,应该在创建的时候就明确是装什么的
		s.add("a");
		//s.add(1);//
		//此时就能保证集合里元素类型一致,
		Set<Integer> treeSet = new  TreeSet<Integer>();
		//规定key只能是String,value是Date
		Map<String,Date> map = new HashMap<String,Date>();
		// V put(K key, V value) 
		Date v = map.put("", new Date());
		//V get(Object key)  
		Date val = map.get("");
	}
}
