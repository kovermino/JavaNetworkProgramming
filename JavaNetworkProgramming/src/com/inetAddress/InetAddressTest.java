package com.inetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * ������ �ּ�
 * https://blog.naver.com/jwyoon25/221305933898
 */

public class InetAddressTest {

	public static void main(String[] args) {
		
		try {
			// ���̹��� �ּҸ� ���������� ����
			String domain = "www.naver.com";
			
			// ������(���̹�)���κ��� ȣ��Ʈ���Ӱ� �ּҸ� ���´�.
			InetAddress inetAddr = InetAddress.getByName(domain);
			
			// ���� InetAddress�κ��� ���̹��� ȣ��Ʈ���Ӱ� �ּҸ� ���´�.
			String hostName = inetAddr.getHostName();
			String hostAddress = inetAddr.getHostAddress();
			
			// ���
			System.out.println("ȣ��Ʈ����: "+hostName);
			System.out.println("�ּ�: "+hostAddress);
			
			// ����ȣ��Ʈ(���� ��ǻ��)�� ȣ��Ʈ���Ӱ� �ּҸ� ���´�.
			InetAddress localHost = InetAddress.getLocalHost();
			
			// ���� InetAddress�κ��� ���� ȣ��Ʈ���Ӱ� �ּҸ� ���´�.
			String localName = localHost.getHostName();
			String localAddress = localHost.getHostAddress();
			
			// ���
			System.out.println("����ȣ��Ʈ����: "+localName);
			System.out.println("�����ּ�: "+localAddress);
			
			// ����Ʈ�迭�� ���� ���� �ִ�.
			byte[] bAddr = localHost.getAddress();
			System.out.println(bAddr.length+"���� ����Ʈ �迭�� ���Դ�.");
			for(byte b: bAddr) {
				System.out.print((b<0?b+225:b)+".");
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}