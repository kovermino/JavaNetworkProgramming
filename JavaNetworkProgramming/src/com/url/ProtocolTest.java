package com.url;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * posting URL
 * https://blog.naver.com/jwyoon25/221306419938
 */

public class ProtocolTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// hypertext transfer protocol
		testProtocol("http://www.abc.org");
		
		// secure http
		testProtocol("http://www.amazon.com/exec/obidos/order2/");
		
		// file transfer protocol
		testProtocol("ftp://ibiblio.org/pub/languages/java/javafaq/");
		
		// mail transfer protocol
		testProtocol("mailto:elharo@ibiblio.org");
		
		// telnet
		testProtocol("telnet://dibner.poly.edu/");
		
		// local file access
		testProtocol("file:///etc/passwd");
		
		// gopher
		testProtocol("gopher://gopher.anc.org.za/");
		
		// LDAP : light weight directory access protocol
		testProtocol("ldap://ldap.itd.umich.edu/o=University%20of%20Michigan,c=US?postalAddress");
		
		// JAR
		testProtocol("jar:http://cafeaulait.org/books/javaio/ioexamples/javaio.jar!"
				+"/com/macfaq/io/StreamCopier.class");
		
		// NFS : network file system
		testProtocol("nfs://utopia.poly.edu/usr/tmp");
		
		// user defined protocol for JDBC
		testProtocol("jdbc:mysql://luna.ibiblio.org:3306/NEWS");
		
		// rmi : user defined protocol for remote method invoke 
		testProtocol("rmi://ibiblio.org/RenderEngine");
		
		// user defined protocol for Hotjava
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

