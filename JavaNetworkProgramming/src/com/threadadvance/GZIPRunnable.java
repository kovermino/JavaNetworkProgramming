package com.threadadvance;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/**
 * posting URL
 * https://blog.naver.com/jwyoon25/221313921663
 */

public class GZIPRunnable implements Runnable {
	
	private final File input;
	
	public GZIPRunnable(File input) {
		this.input = input;
	}

	@Override
	public void run() {
		
		// 이미 압축된 파일을 다시 압축하지 않도록 한다.
		if(!input.getName().endsWith(".gz")) {
			File output = new File(input.getParent(), input.getName()+".gz");
			
			// 이미 존재하는 압축파일에 덮어쓰지 않도록 한다.(try-with-resources)
			if(!output.exists()) {
				try (InputStream in = new BufferedInputStream(new FileInputStream(input));
					 OutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(output)));){
					
					int b;
					while((b=in.read()) != -1) {
						out.write(b);
					}
					out.flush();
					
				} catch (Exception e) {
					System.err.println(e);
				} 	
			}
		}
	}
}