package com.urlconnection;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * posting URL
 * https://blog.naver.com/jwyoon25/221310125414
 */

public class URLConnectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			URL u = new URL("https://www.naver.com/");
			URLConnection uc = u.openConnection();
			try(InputStream raw = uc.getInputStream()){
				InputStream buffer = new BufferedInputStream(raw);
				Reader reader = new InputStreamReader(buffer);
				int c;
				while((c=reader.read())!=-1) {
					System.out.print((char)c);
				}
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
