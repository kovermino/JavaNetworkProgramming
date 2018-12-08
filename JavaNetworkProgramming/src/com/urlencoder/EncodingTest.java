package com.urlencoder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * posting URL
 * https://blog.naver.com/jwyoon25/221307228979
 */

public class EncodingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String basic = "This string has spaces";
		String asterisk = basic.replace(" ", "*").replace("spaces", "asterisks");
		String percent = basic.replace(" ", "%").replace("spaces", "percents");
		String plus = basic.replace(" ", "+").replace("spaces", "pluses");
		String slash = basic.replace(" ", "/").replace("spaces", "slashes");
		String quote = basic.replace(" ", "\\").replace("spaces", "quotes");
		String colon = basic.replace(" ", ":").replace("spaces", "colons");
		String tilde = basic.replace(" ", "~").replace("spaces", "tildes");
		String parenthese = basic.replace(" ", "(").replace("spaces", "parentheses");
		String period = basic.replace(" ", ".").replace("spaces", "periods");
		String equal = basic.replace(" ", "=").replace("spaces", "equals");
		String ampersand = basic.replace(" ", "&").replace("spaces", "ampersands");
		String kor = "이 문자열은 한국어 입니다";
		
		try {
			System.out.println(basic);
			System.out.println(URLEncoder.encode(basic, "UTF-8"));
			System.out.println();
			
			System.out.println(asterisk);
			System.out.println(URLEncoder.encode(asterisk, "UTF-8"));
			System.out.println();
			
			System.out.println(percent);
			System.out.println(URLEncoder.encode(percent, "UTF-8"));
			System.out.println();
			
			System.out.println(plus);
			System.out.println(URLEncoder.encode(plus, "UTF-8"));
			System.out.println();
			
			System.out.println(slash);
			System.out.println(URLEncoder.encode(slash, "UTF-8"));
			System.out.println();
			
			System.out.println(quote);
			System.out.println(URLEncoder.encode(quote, "UTF-8"));
			System.out.println();
			
			System.out.println(colon);
			System.out.println(URLEncoder.encode(colon, "UTF-8"));
			System.out.println();
			
			System.out.println(tilde);
			System.out.println(URLEncoder.encode(tilde, "UTF-8"));
			System.out.println();
			
			System.out.println(parenthese);
			System.out.println(URLEncoder.encode(parenthese, "UTF-8"));
			System.out.println();
			
			System.out.println(period);
			System.out.println(URLEncoder.encode(period, "UTF-8"));
			System.out.println();
			
			System.out.println(equal);
			System.out.println(URLEncoder.encode(equal, "UTF-8"));
			System.out.println();
			
			System.out.println(ampersand);
			System.out.println(URLEncoder.encode(ampersand, "UTF-8"));
			System.out.println();
			
			System.out.println(kor);
			System.out.println(URLEncoder.encode(kor, "UTF-8"));
			System.out.println();
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}