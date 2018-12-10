package com.nonblock;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * posting URL
 * https://blog.naver.com/jwyoon25/221319527919
 */

public class ChargenServer {
	
	public static int PORT = 19;

	public static void main(String[] args) {
		
		int port = PORT;
		
		byte[] rotation = new byte[95*2];
		for(byte i=' ';i<='~';i++) {
			rotation[i-' '] = i;
			rotation[i-' '+95]=i;
		}
		
		ServerSocketChannel serverChannel = null;
		Selector selector = null;
		
		try {
			// 서버 채널 및 소켓 설정
			serverChannel = ServerSocketChannel.open();					// 서버 채널 생성
			ServerSocket ss = serverChannel.socket();					// 소켓 생성
			InetSocketAddress address = new InetSocketAddress(port);	// adress 생성
			ss.bind(address);											// 19번 포트에 바인딩(여기서 리스닝이 시작된다)
			serverChannel.configureBlocking(false);						// 서버 채널을 논블록으로 만든다.
			
			// 셀렉터 설정 및 등록
			selector = Selector.open();									// 처리할 준비가 된 연결만을 찾아서 반복적으로 처리하게 해주는 역할
			serverChannel.register(selector, SelectionKey.OP_ACCEPT);	// 서버 채널에 셀렉터를 등록(연결을 수용할 준비가 되었는지에만 관심)
		} catch (IOException e) {
			System.err.println(e);
		}
		
		// 리스닝
		while(true) {
			// 처리될 준비가 된 연결을 선택
			try {
				selector.select();
			} catch (IOException e) {
				System.err.println(e);
				break;
			}
			
			// 선택된 키 셋을 가져와서 반복처리
			Set<SelectionKey> readKeys = selector.selectedKeys();
			Iterator<SelectionKey> iterator = readKeys.iterator();
			while(iterator.hasNext()) {
				SelectionKey key = iterator.next();
				iterator.remove();
				try {
					if(key.isAcceptable()) {
						ServerSocketChannel server = (ServerSocketChannel) key.channel();
						SocketChannel client;
						client = server.accept();
						System.out.println("Accepted connection from "+client);
						client.configureBlocking(false);
						SelectionKey key2 = client.register(selector, SelectionKey.OP_WRITE);
						ByteBuffer buffer = ByteBuffer.allocate(74);
						buffer.put(rotation, 0, 72);
						buffer.put((byte)'\r');
						buffer.put((byte)'\n');
						buffer.flip();
						key2.attach(buffer);
					}else if(key.isWritable()) {
						SocketChannel client = (SocketChannel) key.channel();
						ByteBuffer buffer = (ByteBuffer) key.attachment();
						if(!buffer.hasRemaining()) {
							buffer.rewind();
							int first = buffer.get();
							buffer.rewind();
							int position = first-' '+1;
							buffer.put(rotation, position, 72);
							buffer.put((byte)'\r');
							buffer.put((byte)'\n');
							buffer.flip();
						}
						client.write(buffer);
						
					}
				} catch (IOException e) {
					key.cancel();
					try {
						key.channel().close();
					} catch (IOException e1) {
						System.err.println(e1);
					}
				}
			}
		}
	}
}