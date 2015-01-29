package org.apache.http.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

import org.apache.http.Header;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class StringEntity extends AbstractHttpEntity {
	
	// DSModeled - changed type from char[] to String.
	protected final String content;
	
	@DSModeled(DSC.SPEC)
	public StringEntity(final String string) {
		this.content = string;
    }

	public StringEntity(final String string, final Charset charset) {
        this(string, ContentType.create(ContentType.TEXT_PLAIN.getMimeType(), charset));
    }

	public StringEntity(final String string, final ContentType contentType) {
        this.content = string;
        setContentType(contentType.toString());
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
