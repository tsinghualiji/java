package generic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * ����Ƕ��
 */
public class MapDemo {
	public static void main(String[] args) {
			
		Map<Integer,String> map = new HashMap<>();
		
		map.put(1, "A");
		map.put(2, "B");
		map.put(3, "C");
		map.put(4, "D");
		
		//����Map���ÿһ��key �� value
		
		Set<Map.Entry<Integer,String>> entrys = map.entrySet();
		Iterator<Map.Entry<Integer, String>> it = entrys.iterator();
		while(it.hasNext()){
			
			Map.Entry<Integer, String> entry = it.next();//ÿһ��Enter
			
			Integer key = entry.getKey();
			String value = entry.getValue();
		}
	}
}
