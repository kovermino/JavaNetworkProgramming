package com.url;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 포스팅 주소
 * https://blog.naver.com/jwyoon25/221306419938
 */

public class ProtocolTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 하이퍼텍스트 전송 프로토콜
		testProtocol("http://www.abc.org");
		
		// 보안 http
		testProtocol("http://www.amazon.com/exec/obidos/order2/");
		
		// 파일 전송 프로토콜
		testProtocol("ftp://ibiblio.org/pub/languages/java/javafaq/");
		
		// 간이 메일 전송 프로토콜
		testProtocol("mailto:elharo@ibiblio.org");
		
		// 텔넷
		testProtocol("telnet://dibner.poly.edu/");
		
		// 로컬 파일 접근
		testProtocol("file:///etc/passwd");
		
		// gopher
		testProtocol("gopher://gopher.anc.org.za/");
		
		// LDAP : 경량 디렉토리 접근 프로토콜
		testProtocol("ldap://ldap.itd.umich.edu/o=University%20of%20Michigan,c=US?postalAddress");
		
		// JAR
		testProtocol("jar:http://cafeaulait.org/books/javaio/ioexamples/javaio.jar!"
				+"/com/macfaq/io/StreamCopier.class");
		
		// NFS : 네트워크 파일 시스템
		testProtocol("nfs://utopia.poly.edu/usr/tmp");
		
		// JDBC를 위한 사용자 정의 프로토콜
		testProtocol("jdbc:mysql://luna.ibiblio.org:3306/NEWS");
		
		// rmi : 원격 메서드 호출을 위한 사용자 정의 프로토콜
		testProtocol("rmi://ibiblio.org/RenderEngine");
		
		// Hotjava를 위한 사용자 정의 프로토콜
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

