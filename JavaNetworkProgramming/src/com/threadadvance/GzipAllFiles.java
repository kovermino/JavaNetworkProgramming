package com.threadadvance;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * posting URL
 * https://blog.naver.com/jwyoon25/221313921663
 */

public class GzipAllFiles {
	
	public final static int THREAD_COUNT=4;

	public static void main(String[] args) {
		
		ExecutorService pool = Executors.newFixedThreadPool(THREAD_COUNT);
		String[] directory = {"C:\\zip","C:\\zip2"};
		
		for(String filename: directory) {
			File f = new File(filename);
			
			if(f.exists()) {
				if(f.isDirectory()) {
					File[] files = f.listFiles();
					for(int i=0;i<files.length;i++) {
						if(!files[i].isDirectory()) {
							Runnable task = new GZIPRunnable(files[i]);
							pool.submit(task);
						}
					}
				} else {
					Runnable task = new GZIPRunnable(f);
					pool.submit(task);
				}
			} 
		}
		pool.shutdown();
	}
}