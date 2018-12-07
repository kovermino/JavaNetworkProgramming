package com.serversocket;

import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.concurrent.*;

/**
 * posting URL
 * https://blog.naver.com/jwyoon25/221312274526
 */

public class MultithreadedTestJavaServer {
	
	public final static int PORT = 13;

	public static void main(String[] args) {
		
		ExecutorService pool = Executors.newFixedThreadPool(50);
		
		try(ServerSocket server = new ServerSocket(PORT);) {
			while(true) {
				try {
					Socket socket = server.accept();
					Callable<Void> task = new TestJavaThread(socket);
					pool.submit(task);
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		} catch (Exception e) {
			System.err.println(e);
		}

	}
	
	private static class TestJavaThread implements Callable<Void>{
		private Socket socket;

		public TestJavaThread(Socket socket) {
			super();
			this.socket = socket;
		}

		@Override
		public Void call() throws Exception {
			try {
				OutputStream out = socket.getOutputStream();
				Writer writer = new OutputStreamWriter(out);
				Date now = new Date();
				writer.write(now.toString()+"\r\n");
				writer.flush();
				System.out.println(socket.getInetAddress().getHostAddress()+"에게 날짜를 전송했습니다.");
			} catch (Exception e) {
				System.err.println(e);
			} finally {
				try {
					socket.close();
				} catch (IOException e) {
					// ignore
				}
			}
			return null;
		}	
	}
}
