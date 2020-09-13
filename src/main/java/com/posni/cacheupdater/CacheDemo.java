package com.posni.cacheupdater;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class CacheDemo{
	
	private static HealthCheckResultCache<List<String>> cache = new HealthCheckResultCache<List<String>>(1);
	
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



