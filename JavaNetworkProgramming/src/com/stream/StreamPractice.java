package com.stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * ������ �ּ�
 * https://blog.naver.com/jwyoon25/221300691133
 */

public class StreamPractice {

	public static void main(String[] args) {

		// ������ ��ü�� ������ ����� ���
		NestedClass nc = new NestedClass();
		String path = "C:\\nc.java";
			
		// FileOutputStream:  ���Ͽ� ����Ʈ ������ ����.
		// ObjectOutputStream: FileOutputStream�� ��ü������ ����.
		try (FileOutputStream fs = new FileOutputStream(path);
			 ObjectOutputStream os = new ObjectOutputStream(fs)) {

			// ��ü�� ����
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

