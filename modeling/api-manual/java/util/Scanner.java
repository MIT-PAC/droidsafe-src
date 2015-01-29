package java.util;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class Scanner implements Iterator {

	@Override
	@DSModeled(DSC.SAFE)
	public boolean hasNext() {
		return false;
	}

	@Override
	@DSModeled(DSC.SAFE)
	public Object next() {
		return new Object();
	}

	@Override
	@DSModeled(DSC.SAFE)
	public void remove() {
		// No op
	}

}
