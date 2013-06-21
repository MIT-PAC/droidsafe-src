package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public abstract class DoubleBuffer extends Buffer implements Comparable<DoubleBuffer> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.640 -0400", hash_original_method = "0AF8846C39B4C946E7DEA048FA516A89", hash_generated_method = "CCC2DE75DBE50655FCEEC2FCBF6DDA7C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     DoubleBuffer(int capacity) {
        super(3, capacity, null);
        dsTaint.addTaint(capacity);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.641 -0400", hash_original_method = "A99B5F03AD18580EAA75CC7BA40FC0CE", hash_generated_method = "9F2F2AE660AC2BC824B2E51F38D94F22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final double[] array() {
        double[] varEA57FBC16B997AC0E679F048893AC79C_460771448 = (protectedArray());
        double[] retVal = new double[1];
        retVal[0] = dsTaint.getTaintFloat();
        return retVal;
        // ---------- Original Method ----------
        //return protectedArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.641 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "B82B0450FC8F8737216764C522F83BD3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int arrayOffset() {
        int var457EDFAA982472962568D68CBF588B38_357714349 = (protectedArrayOffset());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return protectedArrayOffset();
    }

    
    public abstract DoubleBuffer asReadOnlyBuffer();

    
    public abstract DoubleBuffer compact();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.642 -0400", hash_original_method = "A9C47546143A1E2A817B74D1052E5DC9", hash_generated_method = "30ACA8B3232E5F3D33ABB59B2041AC65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(DoubleBuffer otherBuffer) {
        dsTaint.addTaint(otherBuffer.dsTaint);
        int compareRemaining;
        boolean var4BCBF0874E5D33E29652A3CCB2245276_1006189272 = ((remaining() < otherBuffer.remaining()));
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
        int var51CE6C8A0A6AF44D4BCA06BE06554AF8_411068430 = (remaining() - otherBuffer.remaining());
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.642 -0400", hash_original_method = "80D65346F74BD859AA9774E55290B1E1", hash_generated_method = "CEDC41ADADFA3DDED8D1222DAE9F1EFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        DoubleBuffer otherBuffer;
        otherBuffer = (DoubleBuffer) other;
        {
            boolean var0A43D7921CE313B818348D8F01F0C8D5_1014382665 = (remaining() != otherBuffer.remaining());
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.643 -0400", hash_original_method = "9BEB92FAE64B1253EE6CA9009E99F3B4", hash_generated_method = "D470E1DC28E62F5DFAC6089510DD2F1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DoubleBuffer get(double[] dst) {
        dsTaint.addTaint(dst[0]);
        DoubleBuffer var54C52896C1D21D17FF99C7DFE6939F7B_1188192750 = (get(dst, 0, dst.length));
        return (DoubleBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return get(dst, 0, dst.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.643 -0400", hash_original_method = "38134BA6A99F502238B51F3879F810C3", hash_generated_method = "C3CD3E93909E1CD7E66A62FE811F03CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DoubleBuffer get(double[] dst, int dstOffset, int doubleCount) {
        dsTaint.addTaint(doubleCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst[0]);
        Arrays.checkOffsetAndCount(dst.length, dstOffset, doubleCount);
        {
            boolean var74C0A42AB3BAE67C7C3CC56E2CA2CC6D_1496259586 = (doubleCount > remaining());
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
        return (DoubleBuffer)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.643 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "0AB9FB337D907E82D9C09623133D90E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasArray() {
        boolean varADF219B8DAB0ACF2FCC593A6A216A7F8_855714534 = (protectedHasArray());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return protectedHasArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.643 -0400", hash_original_method = "BF88872009B539EF877B1EA5B03706BA", hash_generated_method = "A3F6A380CF0B275C005E492989DEC56C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.644 -0400", hash_original_method = "93B6D9B754146968969402F4C9473429", hash_generated_method = "5121C585441C1E89608047318CF3D189")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final DoubleBuffer put(double[] src) {
        dsTaint.addTaint(src[0]);
        DoubleBuffer var974D367CEDA780433BF9CC5389A430C6_384151298 = (put(src, 0, src.length));
        return (DoubleBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return put(src, 0, src.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.645 -0400", hash_original_method = "3E73039BF6DB142176253DE2263B83AD", hash_generated_method = "BDF5DF8665A603F9C952493C2BC41816")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DoubleBuffer put(double[] src, int srcOffset, int doubleCount) {
        dsTaint.addTaint(doubleCount);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        Arrays.checkOffsetAndCount(src.length, srcOffset, doubleCount);
        {
            boolean var74C0A42AB3BAE67C7C3CC56E2CA2CC6D_1969189373 = (doubleCount > remaining());
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
        return (DoubleBuffer)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.645 -0400", hash_original_method = "C52ECDE4782921BA374F433E41853287", hash_generated_method = "C4DD72D51B771D9258B1FAF8031AE33A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DoubleBuffer put(DoubleBuffer src) {
        dsTaint.addTaint(src.dsTaint);
        {
            boolean var9C07FD71E9483B067CE073F58225A0C4_718105113 = (src == this);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var6E2E81EBCD4D9A6ACDDC12CE61513AA8_176875340 = (src.remaining() > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        double[] doubles;
        doubles = new double[src.remaining()];
        src.get(doubles);
        put(doubles);
        return (DoubleBuffer)dsTaint.getTaint();
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

