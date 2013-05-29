package android.graphics;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class Color {
	@DSModeled(value = DSC.SAFE)
	public static int argb(int alpha, int red, int green, int blue) {
		return 0;  //Value doesn't really matter
        //return (alpha << 24) | (red << 16) | (green << 8) | blue;
    }
}
