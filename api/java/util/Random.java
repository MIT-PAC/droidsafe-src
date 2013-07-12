package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Serializable;

public class Random implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.395 -0400", hash_original_field = "098917E951EDF368FAB5CC67DB95AE5F", hash_generated_field = "A0E7DD206941887D2E6CA8DF3E4D9ABA")

    private boolean haveNextNextGaussian;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.396 -0400", hash_original_field = "FE4C0F30AA359C41D9F9A5F69C8C4192", hash_generated_field = "0A68B6B74A0B1CC3A4B82347BF535A0F")

    private long seed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.396 -0400", hash_original_field = "45E921D8CDB9978D8C2D3AE9606074E4", hash_generated_field = "4242C7D6216524A8B0CAD6576C1275B5")

    private double nextNextGaussian;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.396 -0400", hash_original_method = "3173C51AF7594D647EC1C2CFA488A448", hash_generated_method = "973708C9D1F059DB74B65B6DA7E473CF")
    public  Random() {
        setSeed(System.currentTimeMillis() + System.identityHashCode(this));
        // ---------- Original Method ----------
        //setSeed(System.currentTimeMillis() + System.identityHashCode(this));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.396 -0400", hash_original_method = "D88C1F5B76368386940C522DAEBBB898", hash_generated_method = "56786C405BAD68607F8B6A822C989807")
    public  Random(long seed) {
        addTaint(seed);
        setSeed(seed);
        // ---------- Original Method ----------
        //setSeed(seed);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.396 -0400", hash_original_method = "9E0494734DCD804B33C2E0A263F97885", hash_generated_method = "131B072C7E6B40C4AD58239C17A7BCDE")
    protected synchronized int next(int bits) {
        addTaint(bits);
        seed = (seed * multiplier + 0xbL) & ((1L << 48) - 1);
        int var0D811253535D8E3752530DA5DE7DEC73_763939715 = ((int) (seed >>> (48 - bits)));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_153034540 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_153034540;
        // ---------- Original Method ----------
        //seed = (seed * multiplier + 0xbL) & ((1L << 48) - 1);
        //return (int) (seed >>> (48 - bits));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.397 -0400", hash_original_method = "D8D2D3A52478C6F30DF9DDCAD352622E", hash_generated_method = "9AAC1E3CB898B8F232484D5B14F13932")
    public boolean nextBoolean() {
        boolean varCA8861120F0AB941311FD606936AD1E5_1154875379 = (next(1) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1572547108 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1572547108;
        // ---------- Original Method ----------
        //return next(1) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.397 -0400", hash_original_method = "43464E5BE3E8DA331BE8CD0E59C0FE2A", hash_generated_method = "E9ECC67DEADF617B8F2DD9375940BA04")
    public void nextBytes(byte[] buf) {
        addTaint(buf[0]);
        int rand = 0;
        int count = 0;
        int loop = 0;
        while
(count < buf.length)        
        {
    if(loop == 0)            
            {
                rand = nextInt();
                loop = 3;
            } //End block
            else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.397 -0400", hash_original_method = "B5A1D72A0CE7841EEF7745ACB102A3D0", hash_generated_method = "554C5271871A57398B337F7491030B40")
    public double nextDouble() {
        double varD27B6CEA75917D0FF15F2CFB3386F105_1642359510 = (((((long) next(26) << 27) + next(27)) / (double) (1L << 53)));
                double varE8CD7DA078A86726031AD64F35F5A6C0_1139754117 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1139754117;
        // ---------- Original Method ----------
        //return ((((long) next(26) << 27) + next(27)) / (double) (1L << 53));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.397 -0400", hash_original_method = "D1E3B2B06AA527A72663F03AD501BB2B", hash_generated_method = "F0A04B9031939C73E2822F28CBCE94ED")
    public float nextFloat() {
        float varE1AE47DB80FF00F3FF88DE1244CB9468_822637563 = ((next(24) / 16777216f));
                float var546ADE640B6EDFBC8A086EF31347E768_1632384452 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1632384452;
        // ---------- Original Method ----------
        //return (next(24) / 16777216f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.398 -0400", hash_original_method = "ABAEC318233CC46845A76D8E695280DE", hash_generated_method = "BE8BEC6B4A4EF768FB899C9C43C74CE1")
    public synchronized double nextGaussian() {
    if(haveNextNextGaussian)        
        {
            haveNextNextGaussian = false;
            double var45E921D8CDB9978D8C2D3AE9606074E4_143397760 = (nextNextGaussian);
                        double varE8CD7DA078A86726031AD64F35F5A6C0_1474767444 = getTaintDouble();
            return varE8CD7DA078A86726031AD64F35F5A6C0_1474767444;
        } //End block
        double v1;
        double v2;
        double s;
        do {
            {
                v1 = 2 * nextDouble() - 1;
                v2 = 2 * nextDouble() - 1;
                s = v1 * v1 + v2 * v2;
            } //End block
} while (s >= 1);
        double norm = Math.sqrt(-2 * Math.log(s) / s);
        nextNextGaussian = v2 * norm;
        haveNextNextGaussian = true;
        double varACD8D1EB0E2B0F77FB24AE889B51B89D_965701572 = (v1 * norm);
                double varE8CD7DA078A86726031AD64F35F5A6C0_245686792 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_245686792;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.398 -0400", hash_original_method = "82F6347EB6C4A01CB76B611DAE5AF092", hash_generated_method = "28FB1138F7F5EA0DDC0F48C84E28E6E2")
    public int nextInt() {
        int var8B0AC68F59BC17A78A9F256008379710_643016228 = (next(32));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2102693644 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2102693644;
        // ---------- Original Method ----------
        //return next(32);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.398 -0400", hash_original_method = "173DEE1A34208F3BEEC0CED47E74657B", hash_generated_method = "AF843E51DBC4090F13967C02AE5AC416")
    public int nextInt(int n) {
        addTaint(n);
    if(n > 0)        
        {
    if((n & -n) == n)            
            {
                int varF3CE8BE9086D3D111FA2FA41E1490A59_1855284366 = ((int) ((n * (long) next(31)) >> 31));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_833786613 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_833786613;
            } //End block
            int bits;
            int val;
            do {
                {
                    bits = next(31);
                    val = bits % n;
                } //End block
} while (bits - val + (n - 1) < 0);
            int var3A6D0284E743DC4A9B86F97D6DD1A3BF_1401839538 = (val);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_761607521 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_761607521;
        } //End block
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1713159149 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_1713159149.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_1713159149;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.399 -0400", hash_original_method = "A03CC01D80C9639D8965955A7EA1BA6B", hash_generated_method = "247C32715084435AF796FD7DE5ADFD1B")
    public long nextLong() {
        long var962C6FCA0D63E465F54D35D48BD9AD0A_2066765862 = (((long) next(32) << 32) + next(32));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_272661436 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_272661436;
        // ---------- Original Method ----------
        //return ((long) next(32) << 32) + next(32);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.399 -0400", hash_original_method = "7BB21D33F15BE2B6645BBF6EE498410D", hash_generated_method = "698784A92CF20D1A4151BF7CEB8BC18D")
    public synchronized void setSeed(long seed) {
        this.seed = (seed ^ multiplier) & ((1L << 48) - 1);
        haveNextNextGaussian = false;
        // ---------- Original Method ----------
        //this.seed = (seed ^ multiplier) & ((1L << 48) - 1);
        //haveNextNextGaussian = false;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.399 -0400", hash_original_field = "F94298D80F9A452820EFABF62115395F", hash_generated_field = "63446CA233A38FF14BDAECA22D4F71C5")

    private static final long serialVersionUID = 3905348978240129619L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.399 -0400", hash_original_field = "2D2084C307AA9B0DDB4C1E8F39C2204D", hash_generated_field = "4AD8AC8BB1A82B02783A527C57BED92C")

    private static final long multiplier = 0x5deece66dL;
}

