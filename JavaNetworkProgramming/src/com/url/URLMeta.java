package com.url;

import java.net.MalformedURLException;
import java.net.URL;

public class URLMeta {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			URL url = new URL("http://www.google.com/index.html");
			System.out.println(url.getProtocol());
			System.out.println(url.getDefaultPort());
			System.out.println(url.getHost());
			System.out.println(url.getFile());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("create fail");
		}
	}
}

