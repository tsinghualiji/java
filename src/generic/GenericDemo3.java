package generic;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo3 {
	public static void main(String[] args) {
		
		/**
		List<?> l = new  ArrayList<Integer>();
		l.add(1);//ERROR
		
		*/
		
		List<Integer> l1 = new ArrayList<>();//new ArrayList<Integer>();
		
		show(l1);
		List<String> l2 = new ArrayList<>();
		show(l2);
		List<Double> l3 = new ArrayList<>();
		show(l3);	
		List<Number> l4 = new ArrayList<>();
		show(l4);	
		List<Object> l5 = new ArrayList<>();
		show(l5);
		//========================			
		up(l1);
		up(l3);
		up(l4);
		//up(l2);//ERROR		
		//=================		
		//down(l1); //ERROR
		//down(l2); //ERROR
		//down(l3); //ERROR
		down(l4);
		down(l5);				
		//û�м̳й�ϵ
		//Point<Number> p   = new Point<Integer>();//ERROR
	}
	
	/**
	 * 
	 * 	? <= Number
	 * ���÷��Ͷ��������ʹ��extends,��ʾ��������ֻ���Ǹ����ͻ�����͵����ࣺ
	 */
	public static void up(List<? extends Number> l){
		for (Object object : l) {
			System.out.println(object);
		}
	}
	
	/**
	 * 	? >= Number
	 * ���÷��Ͷ��������ʹ��super,��ʾ��������ֻ���Ǹ����ͻ�����͵ĸ��ࣺ
	 */
	public static void down(List<? super Number> l){
		for (Object object : l) {
			System.out.println(object);
		}
	}
	
	public static void show(List<?> l){
		//l.add(?)
		for (Object object : l) {
			System.out.println(object);
		}
	}
}
