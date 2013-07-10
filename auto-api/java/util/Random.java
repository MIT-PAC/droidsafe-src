package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.Serializable;

public class Random implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.512 -0400", hash_original_field = "098917E951EDF368FAB5CC67DB95AE5F", hash_generated_field = "A0E7DD206941887D2E6CA8DF3E4D9ABA")

    private boolean haveNextNextGaussian;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.512 -0400", hash_original_field = "FE4C0F30AA359C41D9F9A5F69C8C4192", hash_generated_field = "0A68B6B74A0B1CC3A4B82347BF535A0F")

    private long seed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.512 -0400", hash_original_field = "45E921D8CDB9978D8C2D3AE9606074E4", hash_generated_field = "4242C7D6216524A8B0CAD6576C1275B5")

    private double nextNextGaussian;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.512 -0400", hash_original_method = "3173C51AF7594D647EC1C2CFA488A448", hash_generated_method = "973708C9D1F059DB74B65B6DA7E473CF")
    public  Random() {
        setSeed(System.currentTimeMillis() + System.identityHashCode(this));
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.513 -0400", hash_original_method = "D88C1F5B76368386940C522DAEBBB898", hash_generated_method = "DE4F8F6B0E3D77072D858F03D7C83476")
    public  Random(long seed) {
        setSeed(seed);
        addTaint(seed);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.513 -0400", hash_original_method = "9E0494734DCD804B33C2E0A263F97885", hash_generated_method = "129C580D73055DCBBB3C2054771C6C41")
    protected synchronized int next(int bits) {
        seed = (seed * multiplier + 0xbL) & ((1L << 48) - 1);
        addTaint(bits);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_739980924 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_739980924;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.513 -0400", hash_original_method = "D8D2D3A52478C6F30DF9DDCAD352622E", hash_generated_method = "B4D6A63558692419AD5CDA89C8A7D46A")
    public boolean nextBoolean() {
        boolean varE5ACCBA47091347A8BDFF4D5327FEC5D_1328751898 = (next(1) != 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_639037312 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_639037312;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.514 -0400", hash_original_method = "43464E5BE3E8DA331BE8CD0E59C0FE2A", hash_generated_method = "FE7EB8D9F8CE1C199318751A49B72A60")
    public void nextBytes(byte[] buf) {
        int rand = 0;
        int count = 0;
        int loop = 0;
        {
            {
                rand = nextInt();
                loop = 3;
            } 
            buf[count++] = (byte) rand;
            rand >>= 8;
        } 
        addTaint(buf[0]);
        
        
        
            
                
                
            
                
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.514 -0400", hash_original_method = "B5A1D72A0CE7841EEF7745ACB102A3D0", hash_generated_method = "03022C0FF2F88BC33EEF60B89A1724CC")
    public double nextDouble() {
        double varC8DBCDB2F76D24AB1BE15CC823BFFACE_752062133 = (((((long) next(26) << 27) + next(27)) / (double) (1L << 53)));
        double varE8CD7DA078A86726031AD64F35F5A6C0_1955105172 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1955105172;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.515 -0400", hash_original_method = "D1E3B2B06AA527A72663F03AD501BB2B", hash_generated_method = "C2739F9CAD30C0FF500A749D3FBB7BB6")
    public float nextFloat() {
        float varBCCD376348376BED7CB4BDAAF9F93BD5_1274172339 = ((next(24) / 16777216f));
        float var546ADE640B6EDFBC8A086EF31347E768_1912564222 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1912564222;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.516 -0400", hash_original_method = "ABAEC318233CC46845A76D8E695280DE", hash_generated_method = "AA699D8135688D2ACC6358C1F5D1C99C")
    public synchronized double nextGaussian() {
        {
            haveNextNextGaussian = false;
        } 
        double v1;
        double v2;
        double s;
        {
            v1 = 2 * nextDouble() - 1;
            v2 = 2 * nextDouble() - 1;
            s = v1 * v1 + v2 * v2;
        } 
        double norm = Math.sqrt(-2 * Math.log(s) / s);
        nextNextGaussian = v2 * norm;
        haveNextNextGaussian = true;
        double varE8CD7DA078A86726031AD64F35F5A6C0_133904603 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_133904603;
        
        
            
            
        
        
        
            
            
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.517 -0400", hash_original_method = "82F6347EB6C4A01CB76B611DAE5AF092", hash_generated_method = "0127320CFBDE6E1DFEE5BE1F796B7106")
    public int nextInt() {
        int var7C0A77E74215A5F7316622DD5618A3D6_757842225 = (next(32));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1450834487 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1450834487;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.518 -0400", hash_original_method = "173DEE1A34208F3BEEC0CED47E74657B", hash_generated_method = "512E3A4ED4BCE47C5D1FA5A9814BE010")
    public int nextInt(int n) {
        {
            {
                int varA79DB788DD9B958F0570240FEE805296_432344930 = ((int) ((n * (long) next(31)) >> 31));
            } 
            int bits;
            int val;
            {
                bits = next(31);
                val = bits % n;
            } 
        } 
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        addTaint(n);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1989328295 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1989328295;
        
        
            
                
            
            
            
                
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.519 -0400", hash_original_method = "A03CC01D80C9639D8965955A7EA1BA6B", hash_generated_method = "A12CB030166A962D6AFE3063CD9A98EE")
    public long nextLong() {
        long varBF611F33B152C4A9A72A301CE07D6614_1829200525 = (((long) next(32) << 32) + next(32));
        long var0F5264038205EDFB1AC05FBB0E8C5E94_548257783 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_548257783;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.519 -0400", hash_original_method = "7BB21D33F15BE2B6645BBF6EE498410D", hash_generated_method = "698784A92CF20D1A4151BF7CEB8BC18D")
    public synchronized void setSeed(long seed) {
        this.seed = (seed ^ multiplier) & ((1L << 48) - 1);
        haveNextNextGaussian = false;
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.519 -0400", hash_original_field = "F94298D80F9A452820EFABF62115395F", hash_generated_field = "63446CA233A38FF14BDAECA22D4F71C5")

    private static final long serialVersionUID = 3905348978240129619L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.519 -0400", hash_original_field = "2D2084C307AA9B0DDB4C1E8F39C2204D", hash_generated_field = "4AD8AC8BB1A82B02783A527C57BED92C")

    private static final long multiplier = 0x5deece66dL;
}

