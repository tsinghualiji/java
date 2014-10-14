package com.adobe.www.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Axe {

	public void work(){
		System.out.println("Cutting");
	}

}

/*map 实现缓存*/
public class CacheDemo {

	public static void main(String[] args) {

		Axe axe = null;
		
		Map<String, Axe> cacheMap = new HashMap<String, Axe>();
		if(!cacheMap.containsKey("myAxe")){
			
			System.out.println("putting");
			cacheMap.put("myAxe", new Axe());
		
		}else{
			axe = (Axe)cacheMap.get("myAxe");
			System.out.println("getting");
		}
		
		cacheMap.get("myAxe");
	}

}
