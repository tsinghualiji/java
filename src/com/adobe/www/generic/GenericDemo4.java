package generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 搞泛型类的时候,只能写泛型上限,不能写下线
 * 
 * @param <T>
 */
class Emp<T extends Number> {

	T value;

	T get() {
		return value;
	}
}

public class GenericDemo4 {
	public static void main(String[] args) {
		/**
		 * 允许在使用带泛型声明的类时不指定类型参数，若没有为这个泛型类指定类型参数则该类型参数被称做一个原始类型，默认是该声明参数时指定的最上限类型
		 * ；
		 */
		Object o = new Emp().get();
		Number n = new Emp().get();
		//==============================
		//泛型擦除
		List<Integer> l1 = new ArrayList<Integer>(); 
		l1.add(1);
		l1.add(2);
		Integer val = l1.get(0);
		List l2  = l1;//把带有泛型信息的对象付给不带泛型信息的变量,//泛型擦除
		//=============
		List<String> l3 = new ArrayList<String>();
		l3 = l2;//造成堆污染
		l3.add("A");
		System.out.println(l3.size());
		//java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
		//String ret = l3.get(0);//好比String s = 1;//ERROR
		String ret = l3.get(2);//YES	
		System.out.println(ret);	
	}
}
