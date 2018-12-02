package com.url;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream in = null;
		
		try {
			// open url
			URL url = new URL("http://www.naver.com");
			in = url.openStream();
			
			// buffer for performance
			in = new BufferedInputStream(in);
			
			// connect InputStream to reader(chain)
			Reader r = new InputStreamReader(in);
			
			int c;
			while((c=r.read())!=-1) {
				System.out.print((char) c);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error occured");
		} finally {
			if(in!=null) {
				try {
					in.close();
				}catch (Exception e) {
					// TODO: handle exception
					// ignore.
				}
			}
		}
	}
}

