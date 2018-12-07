package com.serversocket;

import java.io.*;
import java.net.*;
import java.util.Date;

/**
 * posting URL
 * https://blog.naver.com/jwyoon25/221312274526
 */

public class TestJavaServer {
	
	public final static int PORT = 13;

	public static void main(String[] args) {
		try(ServerSocket server = new ServerSocket(PORT)){
			while(true) {
				try(Socket socket = server.accept()) {
					Writer out = new OutputStreamWriter(socket.getOutputStream());
					Date now = new Date();
					out.write(now.toString()+"\r\n");
					out.flush();
				} catch (IOException e) {
					System.err.println("problem occurs when transfering data");
				}
			}
		} catch (IOException e) {
			System.err.println("problem occurs when making connection");
		}
	}
}
