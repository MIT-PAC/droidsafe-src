package org.apache.http.client.entity;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.entity.StringEntity;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSTaintObject;

public class UrlEncodedFormEntity extends StringEntity {

	private DSTaintObject taint = new DSTaintObject();
	
	@DSModeled(DSC.SPEC)
	public UrlEncodedFormEntity(String string) {
		super(string);
		taint.addTaint(string);
	}
	
	@DSModeled(DSC.SPEC)
	public UrlEncodedFormEntity (
	        final List parameters) throws UnsupportedEncodingException {
		super(null);
		taint.addTaint(parameters);
	}

}
