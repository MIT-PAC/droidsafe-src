package android.graphics;

import droidsafe.annotations.*;
import droidsafe.helpers.*;

public class Canvas {
	private DSTaintObject dsTaint = new DSTaintObject();
	
	private Bitmap  mBitmap;
	
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
		dsTaint.addTaint(i);
	}
	
	@DSModeled(DSC.SAFE)
	public int save(int i) {
		dsTaint.addTaint(i);
		return dsTaint.getTaintInt();
	}
	
	@DSModeled(value = DSC.SAFE)
	public int getDensity() {
		return dsTaint.getTaintInt();
		//return mDensity;
    }
	
	@DSModeled(value = DSC.SAFE)
	public void setDensity(int density) {
		dsTaint.addTaint(density);  //Density is saved both here and in the bitmap
		mBitmap.setDensity(density);  //setDensity will track the taint in the Bitmap object
		/*
        if (mBitmap != null) {
            mBitmap.setDensity(density);
        }
        mDensity = density;
        */
	}
	
	@DSModeled(value = DSC.SAFE)
	public void setBitmap(Bitmap bitmap) {
		dsTaint.addTaint(bitmap);
		dsTaint.addTaint(bitmap.getDensity()); //getDensity will return a tainted value
		/*
        if (isHardwareAccelerated()) {
            throw new RuntimeException("Can't set a bitmap device on a GL canvas");
        }

        int pointer = 0;
        if (bitmap != null) {
            if (!bitmap.isMutable()) {
                throw new IllegalStateException();
            }
            throwIfRecycled(bitmap);
            mDensity = bitmap.mDensity;
            pointer = bitmap.ni();
        }

        native_setBitmap(mNativeCanvas, pointer);
        mBitmap = bitmap;
        */
    }
}