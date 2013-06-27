package java.util;

import java.io.Serializable;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class Random implements Serializable {
	@DSModeled(DSC.SAFE)
	public Random() {
		//setSeed(System.currentTimeMillis() + System.identityHashCode(this));
	}
	
	public int nextInt() {
		return 0;
		// return next(32);
	}
	
	public int nextInt(int n) {
		return 0;
		/*
		if (n > 0) {
            if ((n & -n) == n) {
                return (int) ((n * (long) next(31)) >> 31);
            }
            int bits, val;
            do {
                bits = next(31);
                val = bits % n;
            } while (bits - val + (n - 1) < 0);
            return val;
        }
        throw new IllegalArgumentException();
        */
	}
}
