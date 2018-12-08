package com.urlconnection;

import java.io.*;
import java.net.*;
import com.urlencoder.QueryString;

/**
 * posting URL
 * https://blog.naver.com/jwyoon25/221310125414
 */

public class FormPoster {
	
	private URL url;
	private QueryString query = new QueryString();
	
	public FormPoster() {}

	public FormPoster(URL url) {
		if(!url.getProtocol().toLowerCase().startsWith("http")) {
			throw new IllegalArgumentException("Posting only works for http URLs");
		}
		this.url = url;
	}
	
	public void add(String name, String value) {
		query.add(name, value);
	}
	
	public URL getURL() {
		return this.url;
	}
	
	public InputStream post() throws IOException{
		
		// open connection to transfer with POST method
		URLConnection uc = url.openConnection();
		uc.setDoOutput(true);
		try(OutputStreamWriter out = new OutputStreamWriter(uc.getOutputStream(),"UTF-8")){
			
			// POST line, Content-type header, Content-length header will be sent by URLConnection
			// so we have to send data only
			out.write(query.toString());
			out.write("\r\n"); // carrage return + line feed
			out.flush();
		}
		
		// return response of server
		return uc.getInputStream();
	}

	public static void main(String[] args) {
		try {
			URL url = new URL("http://www.naver.com/");
			FormPoster poster = new FormPoster(url);
			poster.add("name", "Benny");
			poster.add("email", "jwyoon25@naver.com");
			
			try(InputStream in = poster.post()){
				Reader r = new InputStreamReader(in);
				int c;
				while((c=r.read()) != -1) {
					System.out.print((char) c);
				}
			} catch (IOException e) {
				System.out.println("error occurs during read data");
			}
		} catch (MalformedURLException e) {
			System.out.println("error occurs during connect to URL");
		}
	}
}
