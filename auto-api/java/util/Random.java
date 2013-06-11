package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.Serializable;

public class Random implements Serializable {
    private static final long serialVersionUID = 3905348978240129619L;
    private static final long multiplier = 0x5deece66dL;
    private boolean haveNextNextGaussian;
    private long seed;
    private double nextNextGaussian;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.816 -0400", hash_original_method = "3173C51AF7594D647EC1C2CFA488A448", hash_generated_method = "C869C0929D32101439BDA079DCA2A944")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Random() {
        setSeed(System.currentTimeMillis() + System.identityHashCode(this));
        // ---------- Original Method ----------
        //setSeed(System.currentTimeMillis() + System.identityHashCode(this));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.816 -0400", hash_original_method = "D88C1F5B76368386940C522DAEBBB898", hash_generated_method = "5670086485A5AC97E40C3AC00CA55E8E")
    @DSModeled(DSC.SAFE)
    public Random(long seed) {
        dsTaint.addTaint(seed);
        setSeed(seed);
        // ---------- Original Method ----------
        //setSeed(seed);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.816 -0400", hash_original_method = "9E0494734DCD804B33C2E0A263F97885", hash_generated_method = "43A299B9D455EB27263C2A7C49A107B2")
    @DSModeled(DSC.SAFE)
    protected synchronized int next(int bits) {
        dsTaint.addTaint(bits);
        seed = (seed * multiplier + 0xbL) & ((1L << 48) - 1);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //seed = (seed * multiplier + 0xbL) & ((1L << 48) - 1);
        //return (int) (seed >>> (48 - bits));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.816 -0400", hash_original_method = "D8D2D3A52478C6F30DF9DDCAD352622E", hash_generated_method = "D0BA83C00D7E48A09D99F17655CCCDC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean nextBoolean() {
        boolean varE5ACCBA47091347A8BDFF4D5327FEC5D_584483647 = (next(1) != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return next(1) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.816 -0400", hash_original_method = "43464E5BE3E8DA331BE8CD0E59C0FE2A", hash_generated_method = "E8BEFE8514A276D40515F05E5B371074")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void nextBytes(byte[] buf) {
        dsTaint.addTaint(buf);
        int rand, count, loop;
        rand = 0;
        count = 0;
        loop = 0;
        {
            {
                rand = nextInt();
                loop = 3;
            } //End block
            {
                loop--;
            } //End block
            buf[count++] = (byte) rand;
            rand >>= 8;
        } //End block
        // ---------- Original Method ----------
        //int rand = 0, count = 0, loop = 0;
        //while (count < buf.length) {
            //if (loop == 0) {
                //rand = nextInt();
                //loop = 3;
            //} else {
                //loop--;
            //}
            //buf[count++] = (byte) rand;
            //rand >>= 8;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.816 -0400", hash_original_method = "B5A1D72A0CE7841EEF7745ACB102A3D0", hash_generated_method = "A4CDCE13AAEAB0624E64A744B78A96DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public double nextDouble() {
        double varC8DBCDB2F76D24AB1BE15CC823BFFACE_181453680 = (((((long) next(26) << 27) + next(27)) / (double) (1L << 53)));
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return ((((long) next(26) << 27) + next(27)) / (double) (1L << 53));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.816 -0400", hash_original_method = "D1E3B2B06AA527A72663F03AD501BB2B", hash_generated_method = "69626627EB9DD7850DFF83E17929077B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float nextFloat() {
        float varBCCD376348376BED7CB4BDAAF9F93BD5_1043544359 = ((next(24) / 16777216f));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return (next(24) / 16777216f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.816 -0400", hash_original_method = "ABAEC318233CC46845A76D8E695280DE", hash_generated_method = "BC4FC1FA469310F7CDD4E8D0D40E89F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized double nextGaussian() {
        {
            haveNextNextGaussian = false;
        } //End block
        double v1, v2, s;
        {
            v1 = 2 * nextDouble() - 1;
            v2 = 2 * nextDouble() - 1;
            s = v1 * v1 + v2 * v2;
        } //End block
        double norm;
        norm = Math.sqrt(-2 * Math.log(s) / s);
        nextNextGaussian = v2 * norm;
        haveNextNextGaussian = true;
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //if (haveNextNextGaussian) { 
            //haveNextNextGaussian = false;
            //return nextNextGaussian;
        //}
        //double v1, v2, s;
        //do {
            //v1 = 2 * nextDouble() - 1; 
            //v2 = 2 * nextDouble() - 1;
            //s = v1 * v1 + v2 * v2;
        //} while (s >= 1);
        //double norm = Math.sqrt(-2 * Math.log(s) / s);
        //nextNextGaussian = v2 * norm;
        //haveNextNextGaussian = true;
        //return v1 * norm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.817 -0400", hash_original_method = "82F6347EB6C4A01CB76B611DAE5AF092", hash_generated_method = "527386F12F1080DAF732F98035995F96")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int nextInt() {
        int var7C0A77E74215A5F7316622DD5618A3D6_1211016129 = (next(32));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return next(32);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.817 -0400", hash_original_method = "173DEE1A34208F3BEEC0CED47E74657B", hash_generated_method = "C1FE1E9139F29E7FA1B4F27D3880FDE3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int nextInt(int n) {
        dsTaint.addTaint(n);
        {
            {
                int varA79DB788DD9B958F0570240FEE805296_1858857211 = ((int) ((n * (long) next(31)) >> 31));
            } //End block
            int bits, val;
            {
                bits = next(31);
                val = bits % n;
            } //End block
        } //End block
        if (DroidSafeAndroidRuntime.control) {
        	throw new IllegalArgumentException();
        }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (n > 0) {
            //if ((n & -n) == n) {
                //return (int) ((n * (long) next(31)) >> 31);
            //}
            //int bits, val;
            //do {
                //bits = next(31);
                //val = bits % n;
            //} while (bits - val + (n - 1) < 0);
            //return val;
        //}
        //throw new IllegalArgumentException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.817 -0400", hash_original_method = "A03CC01D80C9639D8965955A7EA1BA6B", hash_generated_method = "7EFBDB41349D4443D6FC05518B2FF38C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long nextLong() {
        long varBF611F33B152C4A9A72A301CE07D6614_1047552362 = (((long) next(32) << 32) + next(32));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return ((long) next(32) << 32) + next(32);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.817 -0400", hash_original_method = "7BB21D33F15BE2B6645BBF6EE498410D", hash_generated_method = "855B6281AF0B4B829377AF9BDCB177E4")
    @DSModeled(DSC.SAFE)
    public synchronized void setSeed(long seed) {
        dsTaint.addTaint(seed);
        this.seed = (seed ^ multiplier) & ((1L << 48) - 1);
        haveNextNextGaussian = false;
        // ---------- Original Method ----------
        //this.seed = (seed ^ multiplier) & ((1L << 48) - 1);
        //haveNextNextGaussian = false;
    }

    
}


