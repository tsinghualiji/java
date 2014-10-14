package com.adobe.www.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapDemo {

	public static void main(String[] args) {

		Map map = new HashMap();
		map.put("1", "male");
		map.put("2", "female");
		map.put("3", "female");
		map.put(null, null);
		
		Set keySet = map.keySet();
		for (Iterator iterator = keySet.iterator();iterator.hasNext();){
			System.out.println(iterator.next());
		}

		Collection valueSet = map.values();
		for (Iterator iterator = valueSet.iterator(); iterator.hasNext();){
			System.out.println(iterator.next());
		}
		
		Set entry = map.entrySet();
		for(Object object : entry){
			if(object instanceof Map.Entry){
				Map.Entry en = (Map.Entry)object;
				System.out.println(en.getKey() + " ====" + en.getValue());
				System.out.println("en.hashCode:" + en.hashCode());			
			}
		}
		
		System.out.println(map.containsKey("2"));
		System.out.println(map.containsValue("male"));
		System.out.println(map.size());
		System.out.println(map.toString());
		
	}

}
