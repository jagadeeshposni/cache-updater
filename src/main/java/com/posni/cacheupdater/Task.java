package com.posni.cacheupdater;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class Task implements Runnable{
	private int taskId;
	public Task(int id) {
		this.taskId = id;
	}
	@Override
	public void run() {
		CacheDemo cacheDemo = new CacheDemo();
		List<String> list = null;

		list = cacheDemo.getList(Thread.currentThread().getName());
		if(null != list) {
			list.forEach(e -> System.out.println(e + " "));
		}else {
			System.out.println("Cache is not present...");
		}
		
		Map<Integer, String> someMap = new HashMap<Integer, String>();
		someMap.entrySet().forEach( e -> e.getKey());
	}
}