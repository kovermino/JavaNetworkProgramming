package com.inetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * posting URL
 * https://blog.naver.com/jwyoon25/221305933898
 */

public class InetAddressTest {

	public static void main(String[] args) {
		
		try {
			// declare domain address with naver homepage
			String domain = "www.naver.com";
			
			// get hostname and address from domain(naver) -> InetAddress
			InetAddress inetAddr = InetAddress.getByName(domain);
			
			// get hostname and address of naver homepage from InetAddress 
			String hostName = inetAddr.getHostName();
			String hostAddress = inetAddr.getHostAddress();
			
			// print
			System.out.println("hostname: "+hostName);
			System.out.println("address: "+hostAddress);
			
			// get hostname and address of localhost(this computer)
			InetAddress localHost = InetAddress.getLocalHost();
			
			// get hostname and address of localhost from InetAddress
			String localName = localHost.getHostName();
			String localAddress = localHost.getHostAddress();
			
			// print
			System.out.println("localname: "+localName);
			System.out.println("local address "+localAddress);
			
			// we can also get address of localhost with byte array
			byte[] bAddr = localHost.getAddress();
			System.out.println("We get "+bAddr.length+" of byte array");
			for(byte b: bAddr) {
				System.out.print((b<0?b+225:b)+".");
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}