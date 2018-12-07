package com.serversocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * posting URL
 * https://blog.naver.com/jwyoon25/221312274526
 */

public class TestJavaClient {

	public static void main(String[] args) {
		String host = "localhost";
		
		try {
			Socket socket = new Socket(host, 13);
			//socket.setSoTimeout(1000);
			InputStream in = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(in, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String line;
			while((line=br.readLine())!=null) {
				System.out.println(line);
			}
				
			System.out.println("There is a server on port 13 of "+host);
			socket.close();
		} catch (UnknownHostException e) {
			System.err.println(e);
		} catch (IOException e) {
			// no server running at this port
		}
	}
}
