package com.cookie;

import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.URI;

/**
 * posting URL
 * https://blog.naver.com/jwyoon25/221308504203
 */

public class NoGovermentCookie implements CookiePolicy {
	@Override
	public boolean shouldAccept(URI uri, HttpCookie cookie) {
		// TODO Auto-generated method stub
		if(uri.getAuthority().toLowerCase().endsWith(".gov")
				|| cookie.getDomain().toLowerCase().endsWith(".gov")) {
			return false;
		}
		return true;
	}
}