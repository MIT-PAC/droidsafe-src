package java.lang;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class StringBuilder {
	
	@DSModeled(DSC.SAFE)
	public StringBuilder() {
	}
	
	@DSModeled(DSC.SAFE)
	public StringBuilder(int i) {
		this();
		dsTaint.addTaint(i);
	}
	
	@DSModeled(DSC.SAFE)
	public StringBuilder(String str) {
		this();
		dsTaint.addTaint(str);
	}
	
	@DSModeled(DSC.SAFE)
	public String toString() {
		//need a pta object and need to propagate information flow
		return new String(dsTaint.getTaintString());
	}

	@DSModeled(DSC.SAFE)
	public StringBuilder append(String str) {
		dsTaint.addTaint(str);
		return this;
	}
	
	@DSModeled(DSC.SAFE)
	public StringBuilder append(Object obj) {
		dsTaint.addTaint(obj.toString());
		return this;
	}
	
	@DSModeled(DSC.SAFE)
	public StringBuilder append(int obj) {
		dsTaint.addTaint(obj);
		return this;
	}

	// GITI DSModeled
	@DSModeled(DSC.SAFE)
	public String substring(int start, int end) {
		return new String();
	}

	// GITI DSModeled
	@DSModeled(DSC.SAFE)
	public void append(char[] buf, int i, int left) {
		dsTaint.addTaint(new String(buf));
		dsTaint.addTaint(i);
		dsTaint.addTaint(left);
	}
	
}
