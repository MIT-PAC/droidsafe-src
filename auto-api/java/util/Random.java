package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public class Random implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.845 -0400", hash_original_field = "098917E951EDF368FAB5CC67DB95AE5F", hash_generated_field = "A0E7DD206941887D2E6CA8DF3E4D9ABA")

    private boolean haveNextNextGaussian;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.845 -0400", hash_original_field = "FE4C0F30AA359C41D9F9A5F69C8C4192", hash_generated_field = "0A68B6B74A0B1CC3A4B82347BF535A0F")

    private long seed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.845 -0400", hash_original_field = "45E921D8CDB9978D8C2D3AE9606074E4", hash_generated_field = "4242C7D6216524A8B0CAD6576C1275B5")

    private double nextNextGaussian;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.845 -0400", hash_original_method = "3173C51AF7594D647EC1C2CFA488A448", hash_generated_method = "973708C9D1F059DB74B65B6DA7E473CF")
    public  Random() {
        setSeed(System.currentTimeMillis() + System.identityHashCode(this));
        // ---------- Original Method ----------
        //setSeed(System.currentTimeMillis() + System.identityHashCode(this));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.846 -0400", hash_original_method = "D88C1F5B76368386940C522DAEBBB898", hash_generated_method = "DE4F8F6B0E3D77072D858F03D7C83476")
    public  Random(long seed) {
        setSeed(seed);
        addTaint(seed);
        // ---------- Original Method ----------
        //setSeed(seed);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.846 -0400", hash_original_method = "9E0494734DCD804B33C2E0A263F97885", hash_generated_method = "CAB97FE4F56A324DC52038F530DB30FB")
    protected synchronized int next(int bits) {
        seed = (seed * multiplier + 0xbL) & ((1L << 48) - 1);
        addTaint(bits);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1839175777 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1839175777;
        // ---------- Original Method ----------
        //seed = (seed * multiplier + 0xbL) & ((1L << 48) - 1);
        //return (int) (seed >>> (48 - bits));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.846 -0400", hash_original_method = "D8D2D3A52478C6F30DF9DDCAD352622E", hash_generated_method = "C8B366E865854BBF71ABFD6756307AF0")
    public boolean nextBoolean() {
        boolean varE5ACCBA47091347A8BDFF4D5327FEC5D_1772477312 = (next(1) != 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_505726722 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_505726722;
        // ---------- Original Method ----------
        //return next(1) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.856 -0400", hash_original_method = "43464E5BE3E8DA331BE8CD0E59C0FE2A", hash_generated_method = "193B3E3AAC334A34526D80F90B79C082")
    public void nextBytes(byte[] buf) {
        int rand, count, loop;
        rand = 0;
        count = 0;
        loop = 0;
        {
            {
                rand = nextInt();
                loop = 3;
            } //End block
            buf[count++] = (byte) rand;
            rand >>= 8;
        } //End block
        addTaint(buf[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.857 -0400", hash_original_method = "B5A1D72A0CE7841EEF7745ACB102A3D0", hash_generated_method = "3AEFC9012446A47070AE56F615B416B2")
    public double nextDouble() {
        double varC8DBCDB2F76D24AB1BE15CC823BFFACE_2088215964 = (((((long) next(26) << 27) + next(27)) / (double) (1L << 53)));
        double varE8CD7DA078A86726031AD64F35F5A6C0_491719465 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_491719465;
        // ---------- Original Method ----------
        //return ((((long) next(26) << 27) + next(27)) / (double) (1L << 53));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.857 -0400", hash_original_method = "D1E3B2B06AA527A72663F03AD501BB2B", hash_generated_method = "AC6B11730528A734F0C340C27BD69F7F")
    public float nextFloat() {
        float varBCCD376348376BED7CB4BDAAF9F93BD5_1550951758 = ((next(24) / 16777216f));
        float var546ADE640B6EDFBC8A086EF31347E768_405019929 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_405019929;
        // ---------- Original Method ----------
        //return (next(24) / 16777216f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.858 -0400", hash_original_method = "ABAEC318233CC46845A76D8E695280DE", hash_generated_method = "444AEDD4465AB1FDE842E7ACE1C557F1")
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
        double varE8CD7DA078A86726031AD64F35F5A6C0_637175467 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_637175467;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.858 -0400", hash_original_method = "82F6347EB6C4A01CB76B611DAE5AF092", hash_generated_method = "AFD98247397A9F8FDD6F0310C505D3BF")
    public int nextInt() {
        int var7C0A77E74215A5F7316622DD5618A3D6_200276471 = (next(32));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_325404262 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_325404262;
        // ---------- Original Method ----------
        //return next(32);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.859 -0400", hash_original_method = "173DEE1A34208F3BEEC0CED47E74657B", hash_generated_method = "D37E94EA213932C333B030E24F2401C1")
    public int nextInt(int n) {
        {
            {
                int varA79DB788DD9B958F0570240FEE805296_365488463 = ((int) ((n * (long) next(31)) >> 31));
            } //End block
            int bits, val;
            {
                bits = next(31);
                val = bits % n;
            } //End block
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        addTaint(n);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_115506568 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_115506568;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.859 -0400", hash_original_method = "A03CC01D80C9639D8965955A7EA1BA6B", hash_generated_method = "3705B713C45E68FA336CD40A8DD284C1")
    public long nextLong() {
        long varBF611F33B152C4A9A72A301CE07D6614_1043830994 = (((long) next(32) << 32) + next(32));
        long var0F5264038205EDFB1AC05FBB0E8C5E94_220371458 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_220371458;
        // ---------- Original Method ----------
        //return ((long) next(32) << 32) + next(32);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.870 -0400", hash_original_method = "7BB21D33F15BE2B6645BBF6EE498410D", hash_generated_method = "698784A92CF20D1A4151BF7CEB8BC18D")
    public synchronized void setSeed(long seed) {
        this.seed = (seed ^ multiplier) & ((1L << 48) - 1);
        haveNextNextGaussian = false;
        // ---------- Original Method ----------
        //this.seed = (seed ^ multiplier) & ((1L << 48) - 1);
        //haveNextNextGaussian = false;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.870 -0400", hash_original_field = "F94298D80F9A452820EFABF62115395F", hash_generated_field = "CAFD7760181DE139485B7FF8F49552D6")

    private static long serialVersionUID = 3905348978240129619L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.871 -0400", hash_original_field = "2D2084C307AA9B0DDB4C1E8F39C2204D", hash_generated_field = "73533FCCD5DAF9253990BD9FBCF233F5")

    private static long multiplier = 0x5deece66dL;
}

