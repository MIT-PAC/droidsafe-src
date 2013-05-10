package droidsafe.helpers;

import droidsafe.annotations.*;

public class DSTaintObject {
	private Object taint;
	
	@DSModeled(DSC.SAFE)
	public DSTaintObject() {
	}
	
	@DSModeled(DSC.SAFE)
	public void addTaints(Object... taints) {
		for (Object t : taints)
			addTaint(t);
	}
	
	@DSModeled(DSC.SAFE)
	public void addTaint(Object obj) {
		this.taint = obj;
	}
	
	@DSModeled(DSC.SAFE)
	public Object getTaint() {
		return null;
	}
	
	@DSModeled(DSC.SAFE)
	public int getTaintInt() {
		return 0;
	}
	
	@DSModeled(DSC.SAFE)
	public float getTaintFloat() {
		return 0f;
	}
	
	@DSModeled(DSC.SAFE)
	public String getTaintString() {
		return "";
	}
	
	@DSModeled(DSC.SAFE)
	public boolean getTaintBoolean() {
		return false;
	}	
}

