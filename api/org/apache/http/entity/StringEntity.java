package org.apache.http.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.http.Header;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSTaintObject;

public class StringEntity extends AbstractHttpEntity {
	private DSTaintObject taint = new DSTaintObject();
	
	@DSModeled(DSC.SPEC)
	public StringEntity(final String string) {
		taint.addTaint(string);
    }

	@Override
	public InputStream getContent() throws IOException, IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getContentLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isRepeatable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isStreaming() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void writeTo(OutputStream arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void consumeContent() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Header getContentEncoding() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isChunked() {
		// TODO Auto-generated method stub
		return false;
	}

}
