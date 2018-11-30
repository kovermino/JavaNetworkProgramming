package com.url;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * ������ �ּ�
 * https://blog.naver.com/jwyoon25/221306419938
 */

public class ProtocolTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// �������ؽ�Ʈ ���� ��������
		testProtocol("http://www.abc.org");
		
		// ���� http
		testProtocol("http://www.amazon.com/exec/obidos/order2/");
		
		// ���� ���� ��������
		testProtocol("ftp://ibiblio.org/pub/languages/java/javafaq/");
		
		// ���� ���� ���� ��������
		testProtocol("mailto:elharo@ibiblio.org");
		
		// �ڳ�
		testProtocol("telnet://dibner.poly.edu/");
		
		// ���� ���� ����
		testProtocol("file:///etc/passwd");
		
		// gopher
		testProtocol("gopher://gopher.anc.org.za/");
		
		// LDAP : �淮 ���丮 ���� ��������
		testProtocol("ldap://ldap.itd.umich.edu/o=University%20of%20Michigan,c=US?postalAddress");
		
		// JAR
		testProtocol("jar:http://cafeaulait.org/books/javaio/ioexamples/javaio.jar!"
				+"/com/macfaq/io/StreamCopier.class");
		
		// NFS : ��Ʈ��ũ ���� �ý���
		testProtocol("nfs://utopia.poly.edu/usr/tmp");
		
		// JDBC�� ���� ����� ���� ��������
		testProtocol("jdbc:mysql://luna.ibiblio.org:3306/NEWS");
		
		// rmi : ���� �޼��� ȣ���� ���� ����� ���� ��������
		testProtocol("rmi://ibiblio.org/RenderEngine");
		
		// Hotjava�� ���� ����� ���� ��������
		testProtocol("doc:/UserGuide/release.html");
		testProtocol("netdoc:/UserGuide/release.html");
		testProtocol("systemresource://www.adc.org/+/index.html");
		testProtocol("verbatim:http://www.adc.org");
	}
	
	private static void testProtocol(String url) {
		try {
			URL u = new URL(url);
			System.out.println(u.getProtocol()+" is supported");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			String protocol = url.substring(0, url.indexOf(':'));
			System.out.println(protocol+" is not supported");
		}
	}

}

