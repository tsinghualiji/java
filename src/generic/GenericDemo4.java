package generic;

import java.util.ArrayList;
import java.util.List;

/**
 * �㷺�����ʱ��,ֻ��д��������,����д����
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
		 * ������ʹ�ô�����������ʱ��ָ�����Ͳ�����û��Ϊ���������ָ�����Ͳ���������Ͳ������һ��ԭʼ���ͣ�Ĭ���Ǹ���������ʱָ��������������
		 * ��
		 */
		Object o = new Emp().get();
		Number n = new Emp().get();
		//==============================
		//���Ͳ���
		List<Integer> l1 = new ArrayList<Integer>(); 
		l1.add(1);
		l1.add(2);
		Integer val = l1.get(0);
		List l2  = l1;//�Ѵ��з�����Ϣ�Ķ��󸶸������Ϣ�ı���,//���Ͳ���
		//=============
		List<String> l3 = new ArrayList<String>();
		l3 = l2;//��ɶ���Ⱦ
		l3.add("A");
		System.out.println(l3.size());
		//java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
		//String ret = l3.get(0);//�ñ�String s = 1;//ERROR
		String ret = l3.get(2);//YES	
		System.out.println(ret);	
	}
}
