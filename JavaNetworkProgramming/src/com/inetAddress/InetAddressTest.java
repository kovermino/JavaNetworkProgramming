package com.inetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * 포스팅 주소
 * https://blog.naver.com/jwyoon25/221305933898
 */

public class InetAddressTest {

	public static void main(String[] args) {
		
		try {
			// 네이버의 주소를 도메인으로 지정
			String domain = "www.naver.com";
			
			// 도메인(네이버)으로부터 호스트네임과 주소를 얻어온다.
			InetAddress inetAddr = InetAddress.getByName(domain);
			
			// 얻어온 InetAddress로부터 네이버의 호스트네임과 주소를 얻어온다.
			String hostName = inetAddr.getHostName();
			String hostAddress = inetAddr.getHostAddress();
			
			// 출력
			System.out.println("호스트네임: "+hostName);
			System.out.println("주소: "+hostAddress);
			
			// 로컬호스트(현재 컴퓨터)의 호스트네임과 주소를 얻어온다.
			InetAddress localHost = InetAddress.getLocalHost();
			
			// 얻어온 InetAddress로부터 로컬 호스트네임과 주소를 얻어온다.
			String localName = localHost.getHostName();
			String localAddress = localHost.getHostAddress();
			
			// 출력
			System.out.println("로컬호스트네임: "+localName);
			System.out.println("로컬주소: "+localAddress);
			
			// 바이트배열로 얻어올 수도 있다.
			byte[] bAddr = localHost.getAddress();
			System.out.println(bAddr.length+"개의 바이트 배열을 얻어왔다.");
			for(byte b: bAddr) {
				System.out.print((b<0?b+225:b)+".");
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}