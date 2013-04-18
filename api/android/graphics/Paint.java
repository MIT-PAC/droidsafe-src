package android.graphics;

import droidsafe.annotations.*;
import droidsafe.helpers.*;

/*
 * Refactored the original Paint model to be more streamlined.  Also cut over the native
 * getter/setter methods to non-native and added taint tracking to them.
 * 
 * @author sgraf
 */

public class Paint {
	private DSTaintObject dsTaint = new DSTaintObject();
	
	@DSModeled(DSC.SAFE)
    public void setFlags(int flags) {  //Originally a native method, converted over
		dsTaint.addTaint(flags);
	}
	
	@DSModeled(value = DSC.SAFE)
	public int getFlags() {  //Originally a native method, converted over
		return dsTaint.getTaintInt();
	}
	
	@DSModeled(DSC.SAFE)
    public Paint(int flags) {
		setFlags(flags);
		/*
        mNativePaint = native_init();
        setFlags(flags | DEFAULT_PAINT_FLAGS);
        mCompatScaling = mInvCompatScaling = 1;
        */
    }
	
	@DSModeled(DSC.SAFE)
    public Paint() {
        //this(0);  No real need to flow down into second constructor which would track taint, since it's a fixed value
    }
	
	@DSModeled(value = DSC.SAFE)
	public void setColor(int color) { //Originally a native method, converted over
		dsTaint.addTaint(color);
	}
	
	@DSModeled(value = DSC.SAFE)
	public int getColor() {  //Originall a native method, converted over
		return dsTaint.getTaintInt();
	}
}
