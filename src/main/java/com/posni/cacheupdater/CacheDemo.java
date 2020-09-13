package com.posni.cacheupdater;

import java.util.ArrayList;
import java.util.List;

public class CacheDemo{
	
	private static Cache<List<String>> cache = new Cache<List<String>>(1);
	
	public List<String> getList(String string){		
		
		List result = cache.get();
		if (null != result) {
			System.out.println("====>>>>>>Cache hit....");
			return result;
		}
		System.out.println("OOOOOOOOO  Cache miss...");
		result = getFruits();
		cache.set(result);
		return cache.get();
	
		
	}
	
	private List getFruits() {
		List<String> fruits = new ArrayList<String>();
		fruits.add(Thread.currentThread().getName());
		return fruits;
	}
	
}



