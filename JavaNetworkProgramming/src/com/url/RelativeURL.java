package com.url;

import java.net.MalformedURLException;
import java.net.URL;


/*
 * ������ �ּ�
 * https://blog.naver.com/jwyoon25/221306419938
 */

public class RelativeURL {
	
	public static void main(String[] args) {
		try {
			URL u1 = new URL("http://www.ibiblio.org/javafaq/index.html");
			URL u2 = new URL(u1, "mailinglists.html");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("���� ����");
		}
	}
}
