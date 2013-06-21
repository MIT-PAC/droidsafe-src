package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public abstract class FloatBuffer extends Buffer implements Comparable<FloatBuffer> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.715 -0400", hash_original_method = "40CC822379F71BDE2069817768983643", hash_generated_method = "68AEB2F9FD92259C70452CB4530E4652")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     FloatBuffer(int capacity) {
        super(2, capacity, null);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
        public static FloatBuffer allocate(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        return new ReadWriteFloatArrayBuffer(capacity);
    }

    
        public static FloatBuffer wrap(float[] array) {
        return wrap(array, 0, array.length);
    }

    
        public static FloatBuffer wrap(float[] array, int start, int floatCount) {
        Arrays.checkOffsetAndCount(array.length, start, floatCount);
        FloatBuffer buf = new ReadWriteFloatArrayBuffer(array);
        buf.position = start;
        buf.limit = start + floatCount;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.715 -0400", hash_original_method = "3D88E12435E8ECFF27E8491C8CFB38C5", hash_generated_method = "160E680B10F694FEA21B85FCDD136B45")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float[] array() {
        float[] varEA57FBC16B997AC0E679F048893AC79C_174821443 = (protectedArray());
        float[] retVal = new float[1];
        retVal[0] = dsTaint.getTaintFloat();
        return retVal;
        // ---------- Original Method ----------
        //return protectedArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.715 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "855710C68F2BD02EA2639127F9C44DC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int arrayOffset() {
        int var457EDFAA982472962568D68CBF588B38_1727983737 = (protectedArrayOffset());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return protectedArrayOffset();
    }

    
    public abstract FloatBuffer asReadOnlyBuffer();

    
    public abstract FloatBuffer compact();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.716 -0400", hash_original_method = "255AC25FE0773812484072E75724705E", hash_generated_method = "2D59BCBA837282F72B3275A34641B604")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(FloatBuffer otherBuffer) {
        dsTaint.addTaint(otherBuffer.dsTaint);
        int compareRemaining;
        boolean var4BCBF0874E5D33E29652A3CCB2245276_1374668403 = ((remaining() < otherBuffer.remaining()));
        compareRemaining = remaining();
        compareRemaining = otherBuffer.remaining();
        int thisPos;
        thisPos = position;
        int otherPos;
        otherPos = otherBuffer.position;
        float thisFloat, otherFloat;
        {
            thisFloat = get(thisPos);
            otherFloat = otherBuffer.get(otherPos);
        } //End block
        int var51CE6C8A0A6AF44D4BCA06BE06554AF8_208270667 = (remaining() - otherBuffer.remaining());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int compareRemaining = (remaining() < otherBuffer.remaining()) ? remaining()
                //: otherBuffer.remaining();
        //int thisPos = position;
        //int otherPos = otherBuffer.position;
        //float thisFloat, otherFloat;
        //while (compareRemaining > 0) {
            //thisFloat = get(thisPos);
            //otherFloat = otherBuffer.get(otherPos);
            //if ((thisFloat != otherFloat)
                    //&& ((thisFloat == thisFloat) || (otherFloat == otherFloat))) {
                //return thisFloat < otherFloat ? -1 : 1;
            //}
            //thisPos++;
            //otherPos++;
            //compareRemaining--;
        //}
        //return remaining() - otherBuffer.remaining();
    }

    
    public abstract FloatBuffer duplicate();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.717 -0400", hash_original_method = "962C433BA6F78C4BE1DF9C98AF3A7A4D", hash_generated_method = "7B30DCAD4111C7605CE50A161EC4213F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        FloatBuffer otherBuffer;
        otherBuffer = (FloatBuffer) other;
        {
            boolean var0A43D7921CE313B818348D8F01F0C8D5_99177362 = (remaining() != otherBuffer.remaining());
        } //End collapsed parenthetic
        int myPosition;
        myPosition = position;
        int otherPosition;
        otherPosition = otherBuffer.position;
        boolean equalSoFar;
        equalSoFar = true;
        {
            float a;
            a = get(myPosition++);
            float b;
            b = otherBuffer.get(otherPosition++);
            equalSoFar = a == b || (a != a && b != b);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!(other instanceof FloatBuffer)) {
            //return false;
        //}
        //FloatBuffer otherBuffer = (FloatBuffer) other;
        //if (remaining() != otherBuffer.remaining()) {
            //return false;
        //}
        //int myPosition = position;
        //int otherPosition = otherBuffer.position;
        //boolean equalSoFar = true;
        //while (equalSoFar && (myPosition < limit)) {
            //float a = get(myPosition++);
            //float b = otherBuffer.get(otherPosition++);
            //equalSoFar = a == b || (a != a && b != b);
        //}
        //return equalSoFar;
    }

    
    public abstract float get();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.717 -0400", hash_original_method = "5C1BC742B784E1F54201A6BFE04FB3C1", hash_generated_method = "A3025F9F4F4BA12688388DD1C61E7C31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FloatBuffer get(float[] dst) {
        dsTaint.addTaint(dst[0]);
        FloatBuffer var54C52896C1D21D17FF99C7DFE6939F7B_246472924 = (get(dst, 0, dst.length));
        return (FloatBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return get(dst, 0, dst.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.717 -0400", hash_original_method = "62E3FD5BE0E5A19BF5F39022D7154217", hash_generated_method = "F6F9803F1EB0FF690F1EC516B0CECD6D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FloatBuffer get(float[] dst, int dstOffset, int floatCount) {
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst[0]);
        dsTaint.addTaint(floatCount);
        Arrays.checkOffsetAndCount(dst.length, dstOffset, floatCount);
        {
            boolean varE021C2AFD91F3DCFB06333FB83FDE7E4_327851417 = (floatCount > remaining());
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
        return (FloatBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(dst.length, dstOffset, floatCount);
        //if (floatCount > remaining()) {
            //throw new BufferUnderflowException();
        //}
        //for (int i = dstOffset; i < dstOffset + floatCount; ++i) {
            //dst[i] = get();
        //}
        //return this;
    }

    
    public abstract float get(int index);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.718 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "26B5F8677C0F3E621A854E09C340D502")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasArray() {
        boolean varADF219B8DAB0ACF2FCC593A6A216A7F8_692558459 = (protectedHasArray());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return protectedHasArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.718 -0400", hash_original_method = "B144F8C59516E29D7B0EE6B79958F98A", hash_generated_method = "EB284D5F1A761C0E86EBC4852CCB4770")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int myPosition;
        myPosition = position;
        int hash;
        hash = 0;
        {
            hash = hash + Float.floatToIntBits(get(myPosition++));
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int myPosition = position;
        //int hash = 0;
        //while (myPosition < limit) {
            //hash = hash + Float.floatToIntBits(get(myPosition++));
        //}
        //return hash;
    }

    
    public abstract boolean isDirect();

    
    public abstract ByteOrder order();

    
    abstract float[] protectedArray();

    
    abstract int protectedArrayOffset();

    
    abstract boolean protectedHasArray();

    
    public abstract FloatBuffer put(float f);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.719 -0400", hash_original_method = "5B7E9D4E0A0B3CF72C892C67E2CB78B1", hash_generated_method = "8DD060B0705FFB6A1CCB71DC543398E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final FloatBuffer put(float[] src) {
        dsTaint.addTaint(src[0]);
        FloatBuffer var974D367CEDA780433BF9CC5389A430C6_460503113 = (put(src, 0, src.length));
        return (FloatBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return put(src, 0, src.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.719 -0400", hash_original_method = "DFC1F5A8B9B8E6C8478049F847BE00DC", hash_generated_method = "85A274375ABDC3C9C3A23787BAEBF014")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FloatBuffer put(float[] src, int srcOffset, int floatCount) {
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        dsTaint.addTaint(floatCount);
        Arrays.checkOffsetAndCount(src.length, srcOffset, floatCount);
        {
            boolean varE021C2AFD91F3DCFB06333FB83FDE7E4_521854045 = (floatCount > remaining());
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
        return (FloatBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(src.length, srcOffset, floatCount);
        //if (floatCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //for (int i = srcOffset; i < srcOffset + floatCount; ++i) {
            //put(src[i]);
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.720 -0400", hash_original_method = "338DD208CFE8C4AD7CB14619D9789866", hash_generated_method = "18F256403634A0BF8A28056704A8ACE3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FloatBuffer put(FloatBuffer src) {
        dsTaint.addTaint(src.dsTaint);
        {
            boolean var9C07FD71E9483B067CE073F58225A0C4_724542318 = (src == this);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var6E2E81EBCD4D9A6ACDDC12CE61513AA8_434223118 = (src.remaining() > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        float[] contents;
        contents = new float[src.remaining()];
        src.get(contents);
        put(contents);
        return (FloatBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (src == this) {
            //throw new IllegalArgumentException();
        //}
        //if (src.remaining() > remaining()) {
            //throw new BufferOverflowException();
        //}
        //float[] contents = new float[src.remaining()];
        //src.get(contents);
        //put(contents);
        //return this;
    }

    
    public abstract FloatBuffer put(int index, float f);

    
    public abstract FloatBuffer slice();

    
}

