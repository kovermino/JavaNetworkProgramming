package com.clientsocket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * posting URL
 * https://blog.naver.com/jwyoon25/221311581310
 */

public class LowPortScanner {

	public static void main(String[] args) {
		String host = "localhost";
		
		for(int i=1;i<1024;i++) {
			try {
				Socket socket = new Socket(host, i);
				//socket.setSoTimeout(1000);
				System.out.println("There is a server on port "+i+" of "+host);
				socket.close();
			} catch (UnknownHostException e) {
				System.err.println(e);
				break;
			} catch (IOException e) {
				// no server running at this port
				System.err.println("no server running at "+i+" port");
			}
		}
	}
}