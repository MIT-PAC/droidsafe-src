package droidsafe.helpers;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class DSTaintObject {
	private Object taint;
	
	@DSModeled(DSC.BAN)
	public DSTaintObject() {
	}
	
	/* Do not use this anymore because we associate taint with fields
	 * and primitives, and this generic call can confuse.
	@DSModeled(DSC.BAN)
	public void addTaints(Object... taints) {
		for (Object t : taints)
			addTaint(t);
	}
	*/
	
	@DSModeled(DSC.BAN)
	public void addTaint(float i) {
		this.taint = new Float(i);
	}
	
	@DSModeled(DSC.BAN)
	public void addTaint(boolean i) {
		this.taint = new Boolean(i);
	}
	
	@DSModeled(DSC.BAN)
	public void addTaint(String s) {
		this.taint = new String(s);
	}
	
	@DSModeled(DSC.BAN)
	public void addTaint(int i) {
		this.taint = new Integer(i);
	}
	
	@DSModeled(DSC.BAN)
	public void addTaint(DSTaintObject obj) {
		this.taint = obj;
	}
	
	@DSModeled(DSC.BAN)
	public Object getTaint() {
		return null;
	}
	
	@DSModeled(DSC.BAN)
	public int getTaintInt() {
		return 0;
	}
	
	@DSModeled(DSC.BAN)
	public float getTaintFloat() {
		return 0f;
	}
	
	@DSModeled(DSC.BAN)
	public String getTaintString() {
		return "";
	}
	
	@DSModeled(DSC.BAN)
	public boolean getTaintBoolean() {
		return false;
	}	
}

