package droidsafe.helpers;

import droidsafe.annotations.*;

public class DSTaintObject {
	private Object taint;
	
	@DSModeled
	public DSTaintObject() {
	}
	
	@DSModeled
	public void addTaints(Object... taints) {
		for (Object t : taints)
			addTaint(t);
	}
	
	@DSModeled
	public void addTaint(Object obj) {
		this.taint = obj;
	}
	
	@DSModeled
	public Object getTaint() {
		return taint;
	}
	
	public int getTaintInt() {
		return taint.hashCode();
	}
}
