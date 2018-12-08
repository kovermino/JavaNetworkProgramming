package com.thread;

import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

/**
 * posting URL
 * https://blog.naver.com/jwyoon25/221313149487
 */

public class ReturnDigest extends Thread {
	
	private String filename;
	private byte[] digest;
	
	public ReturnDigest(String filename) {
		this.filename = filename;
	}

	@Override
	public void run() {
		try {
			FileInputStream in = new FileInputStream(filename);
			MessageDigest sha = MessageDigest.getInstance("SHA-256");
			
			// FilterStream = calculate SHA digest from file
			DigestInputStream din = new DigestInputStream(in, sha);
			while(din.read() != -1);
			din.close();
			digest = sha.digest();
		} catch (Exception e) {
			System.err.println(e);
		} 
	}
	
	public byte[] getDigest() {
		return digest;
	}
}
