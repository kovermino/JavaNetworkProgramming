package com.thread;

import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

/**
 * posting URL
 * https://blog.naver.com/jwyoon25/221313149487
 */

public class CallbackDigest implements Runnable {
	
	private String filename;
	
	public CallbackDigest(String filename) {
		this.filename = filename;
	}

	@Override
	public void run() {
		try {
			FileInputStream in = new FileInputStream(filename);
			MessageDigest sha = MessageDigest.getInstance("SHA-256");
			DigestInputStream din = new DigestInputStream(in, sha);
			while(din.read() != -1);
			din.close();
			byte[] digest = sha.digest();
			CallbackDigestUserInterface.recieveDigest(digest, filename);
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}

