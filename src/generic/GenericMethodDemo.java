package generic;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


class  A{
	
}
public class GenericMethodDemo {
	public static void main(String[] args) {
		//���÷�����ʱ��,����ȷ�������������
		show(1);
		show("");	
		show(new A());
		//====================
		System.out.println("-->"+show2(1).getClass());
		System.out.println("-->"+show2(new Date()).getClass());
		System.out.println("-->"+show2(new int[]{}).getClass());
		//=======================
		//Arrays :static <T> List<T> asList(T... a)  ����һ���̶���С���б? 	
		int[] arr   = {1,2,3};
		List<int[]> list = Arrays.asList(arr);
		System.out.println("list==" + list);
		for (int[] is : list) {
			System.out.println("--->>>"+is);
			for (int i : is) {
				System.out.println(i);
			}
		}
		//================
		Integer[] arr2 = {7,8,9};
		List<Integer> list2  = Arrays.asList(arr2);
		System.out.println("-list2-->"+list2);
		for (Integer i : list2) {
			System.out.println(i);
		}	
		//========�ɱ����========
		list2 = Arrays.asList(1,2,3,4);
		List<String> s  = Arrays.asList("","","");
	}
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public static <T> T show2(T t) {
		return t;
	}
	
	/**
	 * <T>��ʾ����ʹ�� T ��ʾһ������, ����������ڸ÷�����
	 * @param t
	 */
	public static <T> void show(T t) {
		System.out.println(t.getClass());//��ö������������
	}
}
