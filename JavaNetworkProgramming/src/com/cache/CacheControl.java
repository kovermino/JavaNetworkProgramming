package com.cache;

import java.util.Date;
import java.util.Locale;

/**
 * posting URL
 * https://blog.naver.com/jwyoon25/221310126138
 */

public class CacheControl {
	
	private Date maxAge = null;
	private Date sMaxAge = null;
	private boolean mustRevalidate = false;
	private boolean noCache = false;
	private boolean noStore = false;
	private boolean proxyRevalidate = false;
	private boolean publicCache = false;
	private boolean privateCache = false;
	
	// constructor
	public CacheControl(String s) {
		
		// basic policy
		if(s==null || !s.contains(":")) {
			return; 
		}
		
		String value = s.split(":")[0].trim();
		String[] components = value.split(",");
		
		// right now
		Date now = new Date();
		
		for(String component: components) {
			component = component.trim().toLowerCase(Locale.US);
			
			if(component.startsWith("max-age=")) {
				int secondsInTheFuture = Integer.parseInt(component.substring(8));
				maxAge = new Date(now.getTime()+1000*secondsInTheFuture);
			} else if(component.startsWith("s-maxage=")) {
				int secondsInTheFuture = Integer.parseInt(component.substring(9));
				sMaxAge = new Date(now.getTime()+1000*secondsInTheFuture);
			}else if(component.equals("must-revalidate")) {
				mustRevalidate = true;
			}else if(component.equals("proxy-revalidate=")) {
				proxyRevalidate = true;
			}else if(component.equals("no-cache")) {
				noCache = true;
			}else if(component.equals("public")) {
				publicCache = true;
			}else if(component.equals("private")) {
				privateCache = true;
			}
			
		}
	}
	
	public Date getMaxAge() {
		return maxAge;
	}
	public Date getsMaxAge() {
		return sMaxAge;
	}
	public boolean isMustRevalidate() {
		return mustRevalidate;
	}
	public boolean isNoCache() {
		return noCache;
	}
	public boolean isNoStore() {
		return noStore;
	}
	public boolean isProxyRevalidate() {
		return proxyRevalidate;
	}
	public boolean isPublicCache() {
		return publicCache;
	}
	public boolean isPrivateCache() {
		return privateCache;
	}
}
