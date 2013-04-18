package android.graphics;

import android.os.Parcel;
import android.os.Parcelable;
/*
import android.util.DisplayMetrics;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
*/

import droidsafe.annotations.*;
import droidsafe.helpers.*;

public final class Bitmap implements Parcelable {
	private DSTaintObject dsTaint = new DSTaintObject();
	
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		
	}

	@DSModeled(value = DSC.SAFE)
	public void setDensity(int density) {
		dsTaint.addTaint(density);
        //mDensity = density;
    }
	
	@DSModeled(value = DSC.SAFE)
	public int getDensity() {
		return dsTaint.getTaintInt();
        //return mDensity;
    }
}
