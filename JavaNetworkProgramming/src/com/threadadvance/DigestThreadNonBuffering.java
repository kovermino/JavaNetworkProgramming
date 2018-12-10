package com.threadadvance;

import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

import javax.xml.bind.DatatypeConverter;

/**
 * posting URL
 * https://blog.naver.com/jwyoon25/221313921663
 */

public class DigestThreadNonBuffering implements Runnable {
	
	private String filename;
	
	public DigestThreadNonBuffering(String filename) {
		this.filename = filename;
	}
	
	@Override
	public void run() {
		
		try {
			//일단 파일 이름 찍고 계산 시작
			System.out.print(filename+": ");
			
			FileInputStream in = new FileInputStream(filename);
			MessageDigest sha = MessageDigest.getInstance("SHA-256");
			
			// 필터 스트림 - 파일을 읽어서 SHA 다이제스트를 계산
			DigestInputStream din = new DigestInputStream(in, sha);
			while(din.read() != -1);
			din.close();
			byte[] digest = sha.digest();
			
			// 다이제스트 출력
			System.out.print(DatatypeConverter.printHexBinary(digest));
			System.out.println();
		} catch (Exception e) {
			System.err.println(e);
		} 
	}

	public static void main(String[] args) {
		String[] filenames = {"C:\\script2.txt","C:\\script.txt","C:\\setup.log","C:\\javatest.txt"};
		for(String filename: filenames) {
			// 여기서 Runnable을 새로 만든 구현체로 바꿔줘야 했다.
            DigestThreadNonBuffering dr = new DigestThreadNonBuffering(filename);
			Thread t = new Thread(dr);
			t.start();
		}
	}	
}
