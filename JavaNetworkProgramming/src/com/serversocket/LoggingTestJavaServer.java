package com.serversocket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * posting URL
 * https://blog.naver.com/jwyoon25/221312274526
 */

public class LoggingTestJavaServer {

	public final static int PORT = 15;
	private final static Logger auditLogger = Logger.getLogger("requests");
	private final static Logger errorLogger = Logger.getLogger("errors");

	public static void main(String[] args) {
		
		ExecutorService pool = Executors.newFixedThreadPool(50);
		
		try(ServerSocket server = new ServerSocket(PORT);) {
			while(true) {
				try {
					Socket socket = server.accept();
					Callable<Void> task = new TestJavaThread(socket);
					pool.submit(task);
				} catch (IOException e) {
					errorLogger.log(Level.SEVERE, "accept error", e);
				} catch (RuntimeException re) {
					errorLogger.log(Level.SEVERE, "unexpected error "+re.getMessage(), re);
				}
			}
		} catch (IOException e) {
			errorLogger.log(Level.SEVERE, "Couldn't start server", e);
		} catch (RuntimeException re) {
			errorLogger.log(Level.SEVERE, "Couldn't start server"+re.getMessage(), re);
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
				Date now = new Date();
				
				// request log
				auditLogger.info(now+" "+socket.getRemoteSocketAddress());
				OutputStream out = socket.getOutputStream();
				Writer writer = new OutputStreamWriter(out);
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
