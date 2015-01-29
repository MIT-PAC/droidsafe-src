package org.apache.http.message;

import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class BasicHeaderElementIterator implements HeaderElementIterator {

	@DSModeled(DSC.SAFE)
	@Override
	public Object next() {
		// TODO Auto-generated method stub
		return new Object();
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

	@DSModeled(DSC.SAFE)
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public HeaderElement nextElement() {
		// TODO Auto-generated method stub
		return null;
	}

}
