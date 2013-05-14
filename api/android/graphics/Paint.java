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
	DSTaintObject dsTaint = new DSTaintObject();
	
	
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
	public int getColor() {  //Originally a native method, converted over
		return dsTaint.getTaintInt();
	}
	
	@DSModeled(value = DSC.SAFE)
	public float measureText(char[] text, int index, int count) {
		return 0;  //Is purely a computational function and doesn't appear to change any values/state
		/*
        if (text == null) {
            throw new IllegalArgumentException("text cannot be null");
        }
        if ((index | count) < 0 || index + count > text.length) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (text.length == 0 || count == 0) {
            return 0f;
        }
        if (!mHasCompatScaling) {
            return native_measureText(text, index, count);
        }

        final float oldSize = getTextSize();
        setTextSize(oldSize*mCompatScaling);
        float w = native_measureText(text, index, count);
        setTextSize(oldSize);
        return w*mInvCompatScaling;
        */
    }
	
	@DSModeled(value = DSC.SAFE)
	public float measureText(String text) {
		return 0;  //Is purely a computational function and doesn't appear to change any values/state
		/*
        if (text == null) {
            throw new IllegalArgumentException("text cannot be null");
        }

        if (text.length() == 0) {
            return 0f;
        }

        if (!mHasCompatScaling) return native_measureText(text);
        final float oldSize = getTextSize();
        setTextSize(oldSize*mCompatScaling);
        float w = native_measureText(text);
        setTextSize(oldSize);
        return w*mInvCompatScaling;
        */
    }
	
	@DSModeled(DSC.SAFE)
	public void setAntiAlias(boolean aa) {
		//Helper for setFlags(), setting or clearing the ANTI_ALIAS_FLAG bit
		dsTaint.addTaint(aa);
	}
	
	public void setFilterBitmap(boolean filter) {
		//Don't think we need to perform any tainting
		//filter true to set the FILTER_BITMAP_FLAG bit in the paint's flags, false to clear it.
	}
	
	@DSModeled(DSC.SAFE)
	@Override
    protected void finalize() throws Throwable {
		super.finalize();
		/*
        try {
            finalizer(mNativePaint);
        } finally {
            super.finalize();
        }
        */
    }
}
