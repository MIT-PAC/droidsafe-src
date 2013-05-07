package org.apache.http.message;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpMessage;
import org.apache.http.ProtocolVersion;
import org.apache.http.params.HttpParams;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class AbstractHttpMessage implements HttpMessage {
	
	@DSModeled(DSC.SPEC)
	public AbstractHttpMessage() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addHeader(Header arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addHeader(String arg0, String arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean containsHeader(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Header[] getAllHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header getFirstHeader(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header[] getHeaders(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header getLastHeader(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpParams getParams() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProtocolVersion getProtocolVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HeaderIterator headerIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HeaderIterator headerIterator(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeHeader(Header arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeHeaders(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setHeader(Header arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setHeader(String arg0, String arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setHeaders(Header[] arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setParams(HttpParams arg0) {
		// TODO Auto-generated method stub

	}

}
