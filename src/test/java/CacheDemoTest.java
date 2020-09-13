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
	    	service.submit(new Task(i));
	    });
	}

}


