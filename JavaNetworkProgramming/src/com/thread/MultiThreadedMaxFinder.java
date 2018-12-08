package com.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * posting URL
 * https://blog.naver.com/jwyoon25/221313149487
 */

public class MultiThreadedMaxFinder {

	public static int max(int[] data) throws InterruptedException, ExecutionException {
		
		if(data.length==1) {
			return data[0];
		}else if(data.length==0) {
			throw new IllegalArgumentException();
		}
		
		// spliting work into two part
		FindMaxTask task1 = new FindMaxTask(data, 0, data.length/2);
		FindMaxTask task2 = new FindMaxTask(data, data.length/2, data.length);
		
		// create 2 thread
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		Future<Integer> future1 = service.submit(task1);
		Future<Integer> future2 = service.submit(task2);
		
		return Math.max(future1.get(), future2.get());
	}
}
