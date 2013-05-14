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
		return taint;
	}
	
	@DSModeled(DSC.SAFE)
	public int getTaintInt() {
		return taint.hashCode();
	}
	
	@DSModeled(DSC.SAFE)
	public float getTaintFloat() {
		return (float)getTaintInt();
	}
	
	@DSModeled(DSC.SAFE)
	public String getTaintString() {
		return taint.toString();
	}
	
	@DSModeled(DSC.SAFE)
	public boolean getTaintBoolean() {
		return taint.equals(null);
	}
}
