package com.thread;

import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

/**
 * posting URL
 * https://blog.naver.com/jwyoon25/221313149487
 */

public class InstanceCallbackDigest implements Runnable{
	
	private String filename;
	private InstanceCallbackDigestUserInterface callback;
	
	public InstanceCallbackDigest(String filename, InstanceCallbackDigestUserInterface callback) {
		super();
		this.filename = filename;
		this.callback = callback;
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
			callback.recieveDigest(digest);
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
