package com.cache;

import java.io.IOException;
import java.net.CacheRequest;
import java.net.CacheResponse;
import java.net.ResponseCache;
import java.net.URI;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * posting URL
 * https://blog.naver.com/jwyoon25/221310126138
 */

public class MemoryCache extends ResponseCache {
	
	private final Map<URI, SimpleCacheResponse> responses = new ConcurrentHashMap<URI, SimpleCacheResponse>();
	private final int maxEntries;
	
	public MemoryCache(int maxEntries) {
		this.maxEntries = maxEntries;
	}
	
	public MemoryCache() {
		this(100);
	}

	@Override
	public CacheResponse get(URI uri, String requestMethod, Map<String, List<String>> requestHeaders) throws IOException {
		if("GET".equals(requestMethod)) {
			SimpleCacheResponse response = responses.get(uri);
			
			// 만료일 확인
			if(response != null && response.isExpired()) {
				responses.remove(response);
				response = null;
			}
			
			return response;
		} else {
			return null;
		}
	}

	@Override
	public CacheRequest put(URI uri, URLConnection conn) throws IOException {
		if(responses.size()>=maxEntries) {
			return null;
		}
		
		CacheControl control = new CacheControl(conn.getHeaderField("Cache-Control"));
		
		if(control.isNoStore()) {
			return null;
		}else if(!conn.getHeaderField(0).startsWith("GET ")) {
			// get 방식만 캐시
			return null;
		}
		
		SimpleCacheRequest request = new SimpleCacheRequest();
		SimpleCacheResponse response = new SimpleCacheResponse(conn, request, control);
		
		responses.put(uri, response);
		
		return request;
	}
}
