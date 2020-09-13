package com.posni.cacheupdater;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.Test;


public class CacheDemoTest {
	
	@Test
	public void HmmTest() throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(100);
	    IntStream.range(0, 20).forEach(i -> {
	    	service.submit(new Tasku(i));
	    });
	}

}


final class Tasku implements Runnable{
	private int taskId;
	public Tasku(int id) {
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