package org.apache.http.message;

import org.apache.http.NameValuePair;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSTaintObject;

public class BasicNameValuePair implements NameValuePair, Cloneable {

	private DSTaintObject taint = new DSTaintObject();
	
	@DSModeled(DSC.SAFE)
	public BasicNameValuePair(final String name, final String value) {
		taint.addTaint(name);
		taint.addTaint(value);
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
