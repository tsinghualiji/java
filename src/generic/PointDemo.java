package generic;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class PointDemo {
	public static void main(String[] args) {
		
		//ʹ�÷�����
		//�������͵�ʱ��,ֻ�ܸ���������,
		//����һ�����͵���Ķ���ʱ,������֤�������͵ķ��ͺ��������͵ķ���һ��
		Point<Integer> p = new  Point<Integer>();
		p.setX(1);
		p.setY(1);	
		Point<Double> p2 = new Point<Double>();
		Double x = p2.getX();
		Point<String> p3 = new Point<String>();
		String x3 = p3.getX();
		//============================
		Set<String> s = new HashSet<String>();//����һ����������,Ӧ���ڴ�����ʱ�����ȷ��װʲô��
		s.add("a");
		//s.add(1);//
		//��ʱ���ܱ�֤������Ԫ������һ��,
		Set<Integer> treeSet = new  TreeSet<Integer>();
		//�涨keyֻ����String,value��Date
		Map<String,Date> map = new HashMap<String,Date>();
		// V put(K key, V value) 
		Date v = map.put("", new Date());
		//V get(Object key)  
		Date val = map.get("");
	}
}
