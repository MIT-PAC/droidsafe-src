package java.util;

import java.io.Serializable;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class Random implements Serializable {
	private static final long serialVersionUID = 3905348978240129619L;
	private static final long multiplier = 0x5deece66dL;
	private boolean haveNextNextGaussian;
	private long seed;
	private double nextNextGaussian;
	    
	@DSModeled(DSC.SAFE)
	public Random() {
		//setSeed(System.currentTimeMillis() + System.identityHashCode(this));
	}
	
	public int nextInt() {
		return getTaintInt();
		// return next(32);
	}
	
	public int nextInt(int n) {
        addTaint(n);
		return getTaintInt();
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
	
	public boolean nextBoolean() {
        return next(1) != 0;
    }
	
	@DSModeled(DSC.SAFE)
    protected synchronized int next(int bits) {
        addTaint(bits);
        seed = (seed * multiplier + 0xbL) & ((1L << 48) - 1);
        return getTaintInt();
        // ---------- Original Method ----------
        //seed = (seed * multiplier + 0xbL) & ((1L << 48) - 1);
        //return (int) (seed >>> (48 - bits));
    }
}
