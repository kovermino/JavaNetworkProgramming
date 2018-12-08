package com.urlencoder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * posting URL
 * https://blog.naver.com/jwyoon25/221307228979
 */

public class QueryString {
	
	private StringBuilder query = new StringBuilder();
	
	public QueryString() {}
	
	public synchronized void encode(String name, String value) {
		try {
			query.append(URLEncoder.encode(name, "UTF-8"));
			query.append('=');
			query.append(URLEncoder.encode(value, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Broken VM does not support UTF-8");
		}
	}
	
	public synchronized void add(String name, String value) {
		query.append('&');
		encode(name, value);
	}
	
	public synchronized String getQuery() {
		return query.toString();
	}
	
}
