package com.thread;

import javax.xml.bind.DatatypeConverter;

/**
 * posting URL
 * https://blog.naver.com/jwyoon25/221313149487
 */

public class ReturnDigestUserInterface {

	public static void main(String[] args) {
		String[] filenames = {"C:\\hello.txt","C:\\setup.log"};
		
		for(String filename: filenames) {
			ReturnDigest dr = new ReturnDigest(filename);
			dr.start();
			
			// print result
			StringBuilder result = new StringBuilder(filename);
			result.append(": ");
			byte[] digest = dr.getDigest();
			result.append(DatatypeConverter.printHexBinary(digest));
			System.out.println(result);
		}
	}
}
