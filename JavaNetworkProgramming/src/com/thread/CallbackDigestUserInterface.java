package com.thread;

import javax.xml.bind.DatatypeConverter;

/**
 * posting URL
 * https://blog.naver.com/jwyoon25/221313149487
 */

public class CallbackDigestUserInterface {
	
	public static void recieveDigest(byte[] digest, String name) {
		StringBuilder result = new StringBuilder(name);
		result.append(": ");
		result.append(DatatypeConverter.printHexBinary(digest));
		System.out.println(result);
	}

	public static void main(String[] args) {
		String[] filenames = {"C:\\hello.txt","C:\\setup.log"};
		for(String filename: filenames) {
			CallbackDigest cb = new CallbackDigest(filename);
			Thread t = new Thread(cb);
			t.start();
		}
	}
}