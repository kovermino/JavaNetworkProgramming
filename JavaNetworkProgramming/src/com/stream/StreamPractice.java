package com.stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 포스팅 주소
 * https://blog.naver.com/jwyoon25/221300691133
 */

public class StreamPractice {

	public static void main(String[] args) {

		// 저장할 객체와 파일이 저장된 경로
		NestedClass nc = new NestedClass();
		String path = "C:\\nc.java";
			
		// FileOutputStream:  파일에 바이트 단위로 쓴다.
		// ObjectOutputStream: FileOutputStream에 객체단위로 쓴다.
		try (FileOutputStream fs = new FileOutputStream(path);
			 ObjectOutputStream os = new ObjectOutputStream(fs)) {

			// 객체를 저장
			os.writeObject(nc);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public static class NestedClass implements Serializable{
		private static final long serialVersionUID = 1L;
		String name = "nestedClass";
		int data = 0;
	}

}

