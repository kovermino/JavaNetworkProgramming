package com.thread;

import javax.xml.bind.DatatypeConverter;

/**
 * posting URL
 * https://blog.naver.com/jwyoon25/221313149487
 */

public class InstanceCallbackDigestUserInterface {
	
	private String filename;
	private byte[] digest;
	
	public InstanceCallbackDigestUserInterface(String filename) {
		this.filename = filename;
	}
	
	public void calculateDigest() {
		InstanceCallbackDigest cb = new InstanceCallbackDigest(filename, this);
		Thread t = new Thread(cb);
		t.start();
	}
	
	public void recieveDigest(byte[] digest) {
		String result = filename+": ";
		if(digest != null) {
			result += DatatypeConverter.printHexBinary(digest);
		}else {
			result += "digest not available";
		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		String[] filenames = {"C:\\hello.txt","C:\\setup.log"};
		for(String filename: filenames) {
			InstanceCallbackDigestUserInterface d = new InstanceCallbackDigestUserInterface(filename);
			d.calculateDigest();
		}
	}
}
