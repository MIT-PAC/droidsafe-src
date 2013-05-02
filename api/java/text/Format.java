package java.text;

import java.io.Serializable;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSTaintObject;

public class Format implements Serializable, Cloneable {

	protected DSTaintObject taint = new DSTaintObject();
	
	@DSModeled(DSC.SAFE)
	protected Format() {
    }
	
	@DSModeled(DSC.SAFE)
	public final String format(Object object) {
		taint.addTaint(object);
		return new String();
	}
}
