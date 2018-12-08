package com.thread;

import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

/**
 * posting URL
 * https://blog.naver.com/jwyoon25/221313149487
 */

public class DigestThread extends Thread {
	
	private String filename;
	public DigestThread() {}
	public DigestThread(String filename) {
		this.filename = filename;
	}
	
	@Override
	public void run() {
		
		try {
			FileInputStream in = new FileInputStream(filename);
			MessageDigest sha = MessageDigest.getInstance("SHA-256");
			
			// FilterStream - calculate SHA digest from file
			DigestInputStream din = new DigestInputStream(in, sha);
			while(din.read() != -1);
			din.close();
			byte[] digest = sha.digest();
			
			// create string for print
			StringBuilder result = new StringBuilder(filename);
			result.append(": ");
			result.append(DatatypeConverter.printHexBinary(digest));
			System.out.println(result);
		} catch (Exception e) {
			System.err.println(e);
		} 
	}

	public static void main(String[] args) {
		String[] filenames = {"C:\\hello.txt","C:\\setup.log"};
		for(String filename: filenames) {
			Thread t = new DigestThread(filename);
			t.start();
		}
	}
}
