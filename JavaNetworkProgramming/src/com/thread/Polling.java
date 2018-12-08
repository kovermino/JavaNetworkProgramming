package com.thread;

import javax.xml.bind.DatatypeConverter;

/**
 * posting URL
 * https://blog.naver.com/jwyoon25/221313149487
 */

public class Polling {

	public static void main(String[] args) {
		String[] filenames = {"C:\\hello.txt","C:\\setup.log"};
		ReturnDigest[] digests = new ReturnDigest[filenames.length];
		
		for(int i=0;i<filenames.length;i++) {
			digests[i] = new ReturnDigest(filenames[i]);
			digests[i].start();
		}
		
		for(int i=0;i<filenames.length;i++) {
			while(true) {
				byte[] digest = digests[i].getDigest();
				if(digest!=null) {
					StringBuilder result = new StringBuilder(filenames[i]);
					result.append(": ");
					result.append(DatatypeConverter.printHexBinary(digest));
					System.out.println(result);
					break;
				}
			}
		}
	}
}
