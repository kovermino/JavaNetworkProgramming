package com.nonblock;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;

/**
 * posting URL
 * https://blog.naver.com/jwyoon25/221319527919
 */

public class ChargenClient {
	
	public static int PORT = 19;

	public static void main(String[] args) {
		int port = PORT;
		
		try {
			SocketAddress address = new InetSocketAddress("localhost", PORT);
			SocketChannel client = SocketChannel.open();
			ByteBuffer buffer = ByteBuffer.allocate(74);
			WritableByteChannel out = Channels.newChannel(System.out);
			
			while(client.read(buffer)!=-1) {
				buffer.flip();
				out.write(buffer);
				buffer.clear();
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}