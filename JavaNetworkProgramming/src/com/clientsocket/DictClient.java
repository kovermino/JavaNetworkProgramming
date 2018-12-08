package com.clientsocket;

import java.io.*;
import java.net.*;

/**
 * posting URL
 * https://blog.naver.com/jwyoon25/221311581310
 */

public class DictClient {
	
	public static final String SERVER = "dict.org";
	public static final int port = 2628;
	public static final int TIMEOUT = 30000;

	public static void main(String[] args) {
		
		try(Socket socket = new Socket(SERVER, port)){
			// 타임아웃 설정
			socket.setSoTimeout(TIMEOUT);
			
			// 데이터를 쓰기위한 작업
			OutputStream out = socket.getOutputStream();
			Writer writer = new OutputStreamWriter(out);
			writer = new BufferedWriter(writer);
			
			// 데이터를 읽기 위한 작업
			InputStream in = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			
			String word = "gold";
			
			// 쓰기
			writer.write("DEFINE eng-lat "+word+"\r\n");
			writer.flush();
			
			for(String line = reader.readLine();line!=null;line=reader.readLine()) {
				if(line.startsWith("250 ")) {
					return;
				}else if(line.startsWith("552 ")) {
					System.out.println("No definition found for "+word);
					return;
				}else if(line.matches("\\d\\d\\d .*")) continue;
				else if(line.trim().equals(".")) continue;
				else System.out.println(line);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}