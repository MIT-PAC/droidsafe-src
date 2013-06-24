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
		addTaint(i);
	}
	
	@DSModeled(DSC.SAFE)
	public StringBuilder(String str) {
		this();
		addTaint(str.getTaint());
	}
	
	@DSModeled(DSC.SAFE)
	public String toString() {
		//need a pta object and need to propagate information flow
		return new String(getTaintString());
	}

	@DSModeled(DSC.SAFE)
	public StringBuilder append(String str) {
		addTaint(str.getTaint());
		return this;
	}
	
	@DSModeled(DSC.SAFE)
	public StringBuilder append(Object obj) {
		addTaint(obj.toString().getTaint());
		return this;
	}
	
	@DSModeled(DSC.SAFE)
	public StringBuilder append(int obj) {
		addTaint(obj);
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
		addTaint(new String(buf).getTaint());
		addTaint(i);
		addTaint(left);
	}
	
}
