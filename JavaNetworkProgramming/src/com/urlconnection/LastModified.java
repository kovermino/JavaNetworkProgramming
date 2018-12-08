package com.urlconnection;

import java.io.IOException;
import java.net.*;
import java.util.Date;

/**
 * posting URL
 * https://blog.naver.com/jwyoon25/221310387416
 */

public class LastModified {

	public static void main(String[] args) {

		String domain = "http://www.naver.com";
		try {
			URL u = new URL(domain);
			HttpURLConnection http = (HttpURLConnection) u.openConnection();
			http.setRequestMethod("HEAD");
			System.out.println(u+" was last modified at "+new Date(http.getLastModified()));
		} catch (MalformedURLException e) {
			System.out.println(domain+" is not a URL I understand");
		} catch (IOException e) {
		}
	}
}
