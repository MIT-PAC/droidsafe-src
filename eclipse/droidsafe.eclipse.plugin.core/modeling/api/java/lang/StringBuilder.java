package java.lang;

import droidsafe.annotations.*;
import droidsafe.helpers.*;

public class StringBuilder {
	private DSTaintObject taint;
	
	@DSModeled(DSC.SAFE)
	public StringBuilder() {
		taint = new DSTaintObject();
	}
	
	@DSModeled(DSC.SAFE)
	public StringBuilder(int i) {
		this();
		taint.addTaint(i);
	}
	
	@DSModeled(DSC.SAFE)
	public StringBuilder(String str) {
		this();
		taint.addTaint(str);
	}
	
	@DSModeled(DSC.SAFE)
	public String toString() {
		//need a pta object and need to propagate information flow
		String ret = new String();
		ret += taint.getTaintString();
		return ret;
	}

	@DSModeled(DSC.SAFE)
	public StringBuilder append(String str) {
		taint.addTaint(str);
		return this;
	}
	
	@DSModeled(DSC.SAFE)
	public StringBuilder append(Object obj) {
		taint.addTaint(obj);
		return this;
	}
	
	@DSModeled(DSC.SAFE)
	public StringBuilder append(int obj) {
		taint.addTaint(obj);
		return this;
	}
	
}
