package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public abstract class DoubleBuffer extends Buffer implements Comparable<DoubleBuffer> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.302 -0400", hash_original_method = "0AF8846C39B4C946E7DEA048FA516A89", hash_generated_method = "E632E4EC7764C222EF3E3833B184A64D")
      DoubleBuffer(int capacity) {
        super(3, capacity, null);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
        public static DoubleBuffer allocate(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        return new ReadWriteDoubleArrayBuffer(capacity);
    }

    
        public static DoubleBuffer wrap(double[] array) {
        return wrap(array, 0, array.length);
    }

    
        public static DoubleBuffer wrap(double[] array, int start, int doubleCount) {
        Arrays.checkOffsetAndCount(array.length, start, doubleCount);
        DoubleBuffer buf = new ReadWriteDoubleArrayBuffer(array);
        buf.position = start;
        buf.limit = start + doubleCount;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.303 -0400", hash_original_method = "A99B5F03AD18580EAA75CC7BA40FC0CE", hash_generated_method = "0AB80DE03A438CC9ACD44AE984728705")
    public final double[] array() {
        double[] varEA57FBC16B997AC0E679F048893AC79C_835566715 = (protectedArray());
        double[] var74D44D7D9EE6FE6C3433D694F869E521_1241824701 = {getTaintDouble()};
        return var74D44D7D9EE6FE6C3433D694F869E521_1241824701;
        // ---------- Original Method ----------
        //return protectedArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.303 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "0E7DA7DDEBBC79ADCFD7FF2A76B2179F")
    public final int arrayOffset() {
        int var457EDFAA982472962568D68CBF588B38_191940969 = (protectedArrayOffset());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_378208139 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_378208139;
        // ---------- Original Method ----------
        //return protectedArrayOffset();
    }

    
    public abstract DoubleBuffer asReadOnlyBuffer();

    
    public abstract DoubleBuffer compact();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.304 -0400", hash_original_method = "A9C47546143A1E2A817B74D1052E5DC9", hash_generated_method = "C969E05055B5C4770D6E7B0DE1C5394C")
    public int compareTo(DoubleBuffer otherBuffer) {
        int compareRemaining;
        boolean var4BCBF0874E5D33E29652A3CCB2245276_1304999102 = ((remaining() < otherBuffer.remaining()));
        compareRemaining = remaining();
        compareRemaining = otherBuffer.remaining();
        int thisPos;
        thisPos = position;
        int otherPos;
        otherPos = otherBuffer.position;
        double thisDouble, otherDouble;
        {
            thisDouble = get(thisPos);
            otherDouble = otherBuffer.get(otherPos);
        } //End block
        int var51CE6C8A0A6AF44D4BCA06BE06554AF8_1643375889 = (remaining() - otherBuffer.remaining());
        addTaint(otherBuffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_827618217 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_827618217;
        // ---------- Original Method ----------
        //int compareRemaining = (remaining() < otherBuffer.remaining()) ? remaining()
                //: otherBuffer.remaining();
        //int thisPos = position;
        //int otherPos = otherBuffer.position;
        //double thisDouble, otherDouble;
        //while (compareRemaining > 0) {
            //thisDouble = get(thisPos);
            //otherDouble = otherBuffer.get(otherPos);
            //if ((thisDouble != otherDouble)
                    //&& ((thisDouble == thisDouble) || (otherDouble == otherDouble))) {
                //return thisDouble < otherDouble ? -1 : 1;
            //}
            //thisPos++;
            //otherPos++;
            //compareRemaining--;
        //}
        //return remaining() - otherBuffer.remaining();
    }

    
    public abstract DoubleBuffer duplicate();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.304 -0400", hash_original_method = "80D65346F74BD859AA9774E55290B1E1", hash_generated_method = "131807008D94C955B9E8FC18D84871F0")
    @Override
    public boolean equals(Object other) {
        DoubleBuffer otherBuffer;
        otherBuffer = (DoubleBuffer) other;
        {
            boolean var0A43D7921CE313B818348D8F01F0C8D5_1903652604 = (remaining() != otherBuffer.remaining());
        } //End collapsed parenthetic
        int myPosition;
        myPosition = position;
        int otherPosition;
        otherPosition = otherBuffer.position;
        boolean equalSoFar;
        equalSoFar = true;
        {
            double a;
            a = get(myPosition++);
            double b;
            b = otherBuffer.get(otherPosition++);
            equalSoFar = a == b || (a != a && b != b);
        } //End block
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1858242885 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1858242885;
        // ---------- Original Method ----------
        //if (!(other instanceof DoubleBuffer)) {
            //return false;
        //}
        //DoubleBuffer otherBuffer = (DoubleBuffer) other;
        //if (remaining() != otherBuffer.remaining()) {
            //return false;
        //}
        //int myPosition = position;
        //int otherPosition = otherBuffer.position;
        //boolean equalSoFar = true;
        //while (equalSoFar && (myPosition < limit)) {
            //double a = get(myPosition++);
            //double b = otherBuffer.get(otherPosition++);
            //equalSoFar = a == b || (a != a && b != b);
        //}
        //return equalSoFar;
    }

    
    public abstract double get();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.307 -0400", hash_original_method = "9BEB92FAE64B1253EE6CA9009E99F3B4", hash_generated_method = "610606669EABEA64A56AE9108F994337")
    public DoubleBuffer get(double[] dst) {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_510329561 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_510329561 = get(dst, 0, dst.length);
        addTaint(dst[0]);
        varB4EAC82CA7396A68D541C85D26508E83_510329561.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_510329561;
        // ---------- Original Method ----------
        //return get(dst, 0, dst.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.307 -0400", hash_original_method = "38134BA6A99F502238B51F3879F810C3", hash_generated_method = "D72A79D189EC2EE3C6C268C08CC138C3")
    public DoubleBuffer get(double[] dst, int dstOffset, int doubleCount) {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_1014364367 = null; //Variable for return #1
        Arrays.checkOffsetAndCount(dst.length, dstOffset, doubleCount);
        {
            boolean var74C0A42AB3BAE67C7C3CC56E2CA2CC6D_1439867543 = (doubleCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
            } //End block
        } //End collapsed parenthetic
        {
            int i;
            i = dstOffset;
            {
                dst[i] = get();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1014364367 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(doubleCount);
        varB4EAC82CA7396A68D541C85D26508E83_1014364367.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1014364367;
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(dst.length, dstOffset, doubleCount);
        //if (doubleCount > remaining()) {
            //throw new BufferUnderflowException();
        //}
        //for (int i = dstOffset; i < dstOffset + doubleCount; ++i) {
            //dst[i] = get();
        //}
        //return this;
    }

    
    public abstract double get(int index);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.308 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "87B07FAAF3A07A49B4D7F8E57C5F1C7C")
    public final boolean hasArray() {
        boolean varADF219B8DAB0ACF2FCC593A6A216A7F8_793359046 = (protectedHasArray());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1298323274 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1298323274;
        // ---------- Original Method ----------
        //return protectedHasArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.309 -0400", hash_original_method = "BF88872009B539EF877B1EA5B03706BA", hash_generated_method = "7D140ADFB4BD9A8B2DDD4377995E578D")
    @Override
    public int hashCode() {
        int myPosition;
        myPosition = position;
        int hash;
        hash = 0;
        long l;
        {
            l = Double.doubleToLongBits(get(myPosition++));
            hash = hash + ((int) l) ^ ((int) (l >> 32));
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_726463935 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_726463935;
        // ---------- Original Method ----------
        //int myPosition = position;
        //int hash = 0;
        //long l;
        //while (myPosition < limit) {
            //l = Double.doubleToLongBits(get(myPosition++));
            //hash = hash + ((int) l) ^ ((int) (l >> 32));
        //}
        //return hash;
    }

    
    public abstract boolean isDirect();

    
    public abstract ByteOrder order();

    
    abstract double[] protectedArray();

    
    abstract int protectedArrayOffset();

    
    abstract boolean protectedHasArray();

    
    public abstract DoubleBuffer put(double d);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.333 -0400", hash_original_method = "93B6D9B754146968969402F4C9473429", hash_generated_method = "B901ACF222C52A5824AB640DFCE5C48B")
    public final DoubleBuffer put(double[] src) {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_1752711447 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1752711447 = put(src, 0, src.length);
        addTaint(src[0]);
        varB4EAC82CA7396A68D541C85D26508E83_1752711447.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1752711447;
        // ---------- Original Method ----------
        //return put(src, 0, src.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.334 -0400", hash_original_method = "3E73039BF6DB142176253DE2263B83AD", hash_generated_method = "CB65A8AA80B8FC5CAA5D23231C062B00")
    public DoubleBuffer put(double[] src, int srcOffset, int doubleCount) {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_1434268842 = null; //Variable for return #1
        Arrays.checkOffsetAndCount(src.length, srcOffset, doubleCount);
        {
            boolean var74C0A42AB3BAE67C7C3CC56E2CA2CC6D_248321932 = (doubleCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        {
            int i;
            i = srcOffset;
            {
                put(src[i]);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1434268842 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(doubleCount);
        varB4EAC82CA7396A68D541C85D26508E83_1434268842.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1434268842;
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(src.length, srcOffset, doubleCount);
        //if (doubleCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //for (int i = srcOffset; i < srcOffset + doubleCount; ++i) {
            //put(src[i]);
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.355 -0400", hash_original_method = "C52ECDE4782921BA374F433E41853287", hash_generated_method = "78B0339F2BF2088A04ABB340ECCC2410")
    public DoubleBuffer put(DoubleBuffer src) {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_1702366056 = null; //Variable for return #1
        {
            boolean var9C07FD71E9483B067CE073F58225A0C4_2099963358 = (src == this);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var6E2E81EBCD4D9A6ACDDC12CE61513AA8_1905351547 = (src.remaining() > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        double[] doubles;
        doubles = new double[src.remaining()];
        src.get(doubles);
        put(doubles);
        varB4EAC82CA7396A68D541C85D26508E83_1702366056 = this;
        addTaint(src.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1702366056.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1702366056;
        // ---------- Original Method ----------
        //if (src == this) {
            //throw new IllegalArgumentException();
        //}
        //if (src.remaining() > remaining()) {
            //throw new BufferOverflowException();
        //}
        //double[] doubles = new double[src.remaining()];
        //src.get(doubles);
        //put(doubles);
        //return this;
    }

    
    public abstract DoubleBuffer put(int index, double d);

    
    public abstract DoubleBuffer slice();

    
}

