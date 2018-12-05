package com.cache;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.CacheRequest;

/**
 * posting URL
 * https://blog.naver.com/jwyoon25/221310126138
 */

public class SimpleCacheRequest extends CacheRequest{
	
	private ByteArrayOutputStream out = new ByteArrayOutputStream();

	@Override
	public OutputStream getBody() throws IOException {
		return out;
	}

	@Override
	public void abort() {
		out.reset();
	}
	
	public byte[] getData() {
		return out.size()==0 ? null : out.toByteArray();
	}
}
