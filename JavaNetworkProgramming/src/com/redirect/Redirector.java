package com.redirect;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Logger;

/**
 * posting URL
 * https://blog.naver.com/jwyoon25/221320810929
 */

public class Redirector {
	
	private static final Logger logger = Logger.getLogger("Redirector");
	
	private final int port;
	private final String newSite;
	
	public Redirector(String newSite, int port) {
		this.port = port;
		this.newSite = newSite;
	}
	
	public void start() {
		
		try (ServerSocket server = new ServerSocket(port)) {
			logger.info("Redirecting connections on port");
			
			while(true) {
				Socket s = server.accept();
				Thread t = new RedirectThread(s);
				t.start();
			}
		} catch (IOException e) {
			System.err.println(e);
		}
		
	}
	
	private class RedirectThread extends Thread{
		private final Socket connection;
		
		RedirectThread(Socket s){
			this.connection = s;
		}

		@Override
		public void run() {
			try  {
				Writer out = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream(),"US-ASCII"));
				Reader in = new BufferedReader(new InputStreamReader(connection.getInputStream(),"US-ASCII"));
				StringBuilder request = new StringBuilder(80);
				
				while(true) {
					int c = in.read();
					if(c=='\r' || c=='\n' || c==-1) break;
					request.append((char)c);
				}
				
				String get = request.toString();
				System.out.println(get);
				String[] pieces = get.split("\\w*"); // 정규표현식 \w : 단어 영문자+숫자+_(밑줄)
				String theFile = pieces[1];
				if(get.indexOf("naverRedirect") != -1) {
					System.out.println(newSite+theFile);
					out.write("HTTP/1.0 302 FOUND\r\n");
					Date now = new Date();
					out.write("Date: "+now+"\r\n");
					out.write("Server: Redirector 1.1\r\n");
					out.write("Location: "+newSite+theFile+"\r\n");
					out.write("Content-type: text/html\r\n\r\n");
					out.flush();
				}else {
					out.write("<HTML><HEAD><TITLE>Document moved</TITLE></HEAD>\r\n");
					out.write("<BODY><H1>Document moved</H1>\r\n");
					out.write("The document "+theFile+" has moved to\r\n"
							+"<a href=\""+newSite+theFile+"\">"+newSite+theFile+"</a>"
							+".\r\n please update bookmarks<p>");
					out.write("</BODY></HTML>\r\n");
					out.flush();
				}
				
			} catch (UnsupportedEncodingException e) {
			} catch (IOException e) {
			} finally {
				try {
					connection.close();
				} catch (IOException e) {
					System.err.println(e);
				}
			}
			
			super.run();
		}
	}

	public static void main(String[] args) {
		
		int thePort = 90;
		String theSite = "http://www.naver.com";
		
		Redirector r = new Redirector(theSite, thePort);
		r.start();
	}
}