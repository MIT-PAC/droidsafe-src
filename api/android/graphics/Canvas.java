package android.graphics;

import droidsafe.annotations.*;
import droidsafe.helpers.*;

public class Canvas {
	private DSTaintObject dsTaint = new DSTaintObject();
	
	@DSModeled(value = DSC.SAFE)
	public Canvas() {
		//Do Nothing
	}
	
	@DSModeled(DSC.SAFE)
	public void drawLine(float startX, float startY, float stopX, float stopY,
            Paint paint) {
		/*
		 * This method calls a native method that draws to a native canvas which
		 * is represented by the mNativeCanvas (a pointer/handle) value in the SDK 
		 * implementation the call will modify the bitmap managed by the native code.
		 * 
		 * DSFIXME:  Technically the underlying bitmap will be changed 
		 * (represented by the int mNativeCanvas).  It appears that this
		 * operation happens in real time, so tracking taint is difficult
		 * on the upflow.
		 */
		dsTaint.addTaints(startX, startY, stopX, stopY, paint);
	}
	
	@DSModeled(DSC.SAFE)
	public void drawColor(int i) {
		dsTaint.addTaints(i);
	}
	
	@DSModeled(DSC.SAFE)
	public int save(int i) {
		dsTaint.addTaint(i);
		return dsTaint.getTaintInt();
	}
}