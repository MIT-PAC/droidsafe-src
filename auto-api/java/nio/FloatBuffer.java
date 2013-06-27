package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public abstract class FloatBuffer extends Buffer implements Comparable<FloatBuffer> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.476 -0400", hash_original_method = "40CC822379F71BDE2069817768983643", hash_generated_method = "9E533343D88E64736D05E2F347F6068D")
      FloatBuffer(int capacity) {
        super(2, capacity, null);
        addTaint(capacity);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.477 -0400", hash_original_method = "3D88E12435E8ECFF27E8491C8CFB38C5", hash_generated_method = "8D18B3E6B1B75F289819EB0D347D11A5")
    public final float[] array() {
        float[] varEA57FBC16B997AC0E679F048893AC79C_602376136 = (protectedArray());
        float[] varB2C245003BAB9224CFB496218F7DAFE0_1349584797 = {getTaintFloat()};
        return varB2C245003BAB9224CFB496218F7DAFE0_1349584797;
        // ---------- Original Method ----------
        //return protectedArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.477 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "46424D2F46AFB2B44D784781C54458D9")
    public final int arrayOffset() {
        int var457EDFAA982472962568D68CBF588B38_613031462 = (protectedArrayOffset());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_277801149 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_277801149;
        // ---------- Original Method ----------
        //return protectedArrayOffset();
    }

    
    public abstract FloatBuffer asReadOnlyBuffer();

    
    public abstract FloatBuffer compact();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.479 -0400", hash_original_method = "255AC25FE0773812484072E75724705E", hash_generated_method = "53A7B5056FF6BA61B078C64F9B9B9F46")
    public int compareTo(FloatBuffer otherBuffer) {
        int compareRemaining;
        boolean var4BCBF0874E5D33E29652A3CCB2245276_582987886 = ((remaining() < otherBuffer.remaining()));
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
        int var51CE6C8A0A6AF44D4BCA06BE06554AF8_121257598 = (remaining() - otherBuffer.remaining());
        addTaint(otherBuffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_100389382 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_100389382;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.575 -0400", hash_original_method = "962C433BA6F78C4BE1DF9C98AF3A7A4D", hash_generated_method = "F1DE28272154EA16D032E63B156BEF98")
    @Override
    public boolean equals(Object other) {
        FloatBuffer otherBuffer;
        otherBuffer = (FloatBuffer) other;
        {
            boolean var0A43D7921CE313B818348D8F01F0C8D5_2042133522 = (remaining() != otherBuffer.remaining());
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
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1040673730 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1040673730;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.576 -0400", hash_original_method = "5C1BC742B784E1F54201A6BFE04FB3C1", hash_generated_method = "8EE98BDB48203A576DFF9F323B91BFA7")
    public FloatBuffer get(float[] dst) {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_430212325 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_430212325 = get(dst, 0, dst.length);
        addTaint(dst[0]);
        varB4EAC82CA7396A68D541C85D26508E83_430212325.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_430212325;
        // ---------- Original Method ----------
        //return get(dst, 0, dst.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.577 -0400", hash_original_method = "62E3FD5BE0E5A19BF5F39022D7154217", hash_generated_method = "A6DB625785CA0D7F1F2BF4E0AA0828BC")
    public FloatBuffer get(float[] dst, int dstOffset, int floatCount) {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_1253131030 = null; //Variable for return #1
        Arrays.checkOffsetAndCount(dst.length, dstOffset, floatCount);
        {
            boolean varE021C2AFD91F3DCFB06333FB83FDE7E4_1513519894 = (floatCount > remaining());
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
        varB4EAC82CA7396A68D541C85D26508E83_1253131030 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(floatCount);
        varB4EAC82CA7396A68D541C85D26508E83_1253131030.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1253131030;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.583 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "D3F8F29A5E7BD795B5F5CC70E74720FF")
    public final boolean hasArray() {
        boolean varADF219B8DAB0ACF2FCC593A6A216A7F8_143185765 = (protectedHasArray());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1376862317 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1376862317;
        // ---------- Original Method ----------
        //return protectedHasArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.584 -0400", hash_original_method = "B144F8C59516E29D7B0EE6B79958F98A", hash_generated_method = "B8C60432F27C1726D603A6951C73B1BC")
    @Override
    public int hashCode() {
        int myPosition;
        myPosition = position;
        int hash;
        hash = 0;
        {
            hash = hash + Float.floatToIntBits(get(myPosition++));
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_80268885 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_80268885;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.592 -0400", hash_original_method = "5B7E9D4E0A0B3CF72C892C67E2CB78B1", hash_generated_method = "AC6BCB45E74CB6054C8BD823BCAD8E2D")
    public final FloatBuffer put(float[] src) {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_1092843615 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1092843615 = put(src, 0, src.length);
        addTaint(src[0]);
        varB4EAC82CA7396A68D541C85D26508E83_1092843615.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1092843615;
        // ---------- Original Method ----------
        //return put(src, 0, src.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.618 -0400", hash_original_method = "DFC1F5A8B9B8E6C8478049F847BE00DC", hash_generated_method = "BCBF1C671EC1238B5DCFDA305CB95ABB")
    public FloatBuffer put(float[] src, int srcOffset, int floatCount) {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_1447743294 = null; //Variable for return #1
        Arrays.checkOffsetAndCount(src.length, srcOffset, floatCount);
        {
            boolean varE021C2AFD91F3DCFB06333FB83FDE7E4_1821802769 = (floatCount > remaining());
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
        varB4EAC82CA7396A68D541C85D26508E83_1447743294 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(floatCount);
        varB4EAC82CA7396A68D541C85D26508E83_1447743294.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1447743294;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.621 -0400", hash_original_method = "338DD208CFE8C4AD7CB14619D9789866", hash_generated_method = "BEA781462D810A2160E29D49F6866623")
    public FloatBuffer put(FloatBuffer src) {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_1313007184 = null; //Variable for return #1
        {
            boolean var9C07FD71E9483B067CE073F58225A0C4_2051243761 = (src == this);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var6E2E81EBCD4D9A6ACDDC12CE61513AA8_1550578925 = (src.remaining() > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        float[] contents;
        contents = new float[src.remaining()];
        src.get(contents);
        put(contents);
        varB4EAC82CA7396A68D541C85D26508E83_1313007184 = this;
        addTaint(src.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1313007184.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1313007184;
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

