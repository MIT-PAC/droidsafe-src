package org.apache.http.client.entity;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.http.entity.StringEntity;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class UrlEncodedFormEntity extends StringEntity {

	
	@DSModeled(DSC.SAFE)
	public UrlEncodedFormEntity(String string) {
		super(string);
		dsTaint.addTaint(string);
	}
	
	@DSModeled(DSC.SAFE)
	public UrlEncodedFormEntity (
	        final List parameters) throws UnsupportedEncodingException {
		super(parameters.toString(), (Charset) null);
	}

	
}
