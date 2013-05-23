package android.content.res;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSTaintObject;

/*
 * A stub class
 */
public class TypedArray {

	private DSTaintObject taint = new DSTaintObject();
	
	// GITI Modeled
	@DSModeled(DSC.SAFE)
	public String getString(int fragmentName) {
		taint.addTaint(fragmentName);
		return new String();
	}

	// GITI Modeled
	@DSModeled(DSC.SAFE)
	public int getResourceId(int fragmentId, int i) {
		taint.addTaints(fragmentId, i);
		return 0;
	}

	// GITI Modeled
	@DSModeled(DSC.SAFE)
	public void recycle() {
		
	}

}