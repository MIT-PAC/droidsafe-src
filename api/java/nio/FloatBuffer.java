package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;

public abstract class FloatBuffer extends Buffer implements Comparable<FloatBuffer> {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.020 -0400", hash_original_method = "40CC822379F71BDE2069817768983643", hash_generated_method = "9E533343D88E64736D05E2F347F6068D")
      FloatBuffer(int capacity) {
        super(2, capacity, null);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public static FloatBuffer allocate(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        return new ReadWriteFloatArrayBuffer(capacity);
    }

    
    @DSModeled(DSC.SAFE)
    public static FloatBuffer wrap(float[] array) {
        return wrap(array, 0, array.length);
    }

    
    @DSModeled(DSC.SAFE)
    public static FloatBuffer wrap(float[] array, int start, int floatCount) {
        Arrays.checkOffsetAndCount(array.length, start, floatCount);
        FloatBuffer buf = new ReadWriteFloatArrayBuffer(array);
        buf.position = start;
        buf.limit = start + floatCount;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.022 -0400", hash_original_method = "3D88E12435E8ECFF27E8491C8CFB38C5", hash_generated_method = "8B3175E2360BCE7F3CA6CFD835D96CEF")
    public final float[] array() {
        float[] var68B89E48382A0AA51B25AC59599E2EB0_1688382316 = (protectedArray());
                float[] varB2C245003BAB9224CFB496218F7DAFE0_1039686227 = {getTaintFloat()};
        return varB2C245003BAB9224CFB496218F7DAFE0_1039686227;
        // ---------- Original Method ----------
        //return protectedArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.022 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "2D4C3EE9544DD6D7A28D2A68B77507ED")
    public final int arrayOffset() {
        int var0B794CE56A38A9F3BFDD2D53E83BB109_1999778145 = (protectedArrayOffset());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1564503954 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1564503954;
        // ---------- Original Method ----------
        //return protectedArrayOffset();
    }

    
    public abstract FloatBuffer asReadOnlyBuffer();

    
    public abstract FloatBuffer compact();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.023 -0400", hash_original_method = "255AC25FE0773812484072E75724705E", hash_generated_method = "15C87038626D16339864CAF9AE1170AE")
    public int compareTo(FloatBuffer otherBuffer) {
        addTaint(otherBuffer.getTaint());
        int compareRemaining = (remaining() < otherBuffer.remaining()) ? remaining()
                : otherBuffer.remaining();
        int thisPos = position;
        int otherPos = otherBuffer.position;
        float thisFloat;
        float otherFloat;
        while
(compareRemaining > 0)        
        {
            thisFloat = get(thisPos);
            otherFloat = otherBuffer.get(otherPos);
            if((thisFloat != otherFloat)
                    && ((thisFloat == thisFloat) || (otherFloat == otherFloat)))            
            {
                int varC85F1A8B33FB73B6BB38C92945B2E25C_1046140455 = (thisFloat < otherFloat ? -1 : 1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_754407812 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_754407812;
            } //End block
            thisPos++;
            otherPos++;
            compareRemaining--;
        } //End block
        int var1DC167191FBC7DAD3BADAE830552C692_176603627 = (remaining() - otherBuffer.remaining());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_157233860 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_157233860;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.024 -0400", hash_original_method = "962C433BA6F78C4BE1DF9C98AF3A7A4D", hash_generated_method = "DFFB08CF068CE579DFCF96BDEB3BEFAA")
    @Override
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        if(!(other instanceof FloatBuffer))        
        {
            boolean var68934A3E9455FA72420237EB05902327_82474250 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1293196909 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1293196909;
        } //End block
        FloatBuffer otherBuffer = (FloatBuffer) other;
        if(remaining() != otherBuffer.remaining())        
        {
            boolean var68934A3E9455FA72420237EB05902327_2116843270 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1456995615 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1456995615;
        } //End block
        int myPosition = position;
        int otherPosition = otherBuffer.position;
        boolean equalSoFar = true;
        while
(equalSoFar && (myPosition < limit))        
        {
            float a = get(myPosition++);
            float b = otherBuffer.get(otherPosition++);
            equalSoFar = a == b || (a != a && b != b);
        } //End block
        boolean var4A97EF18B93B276118DD50585250A586_576356179 = (equalSoFar);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1353323224 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1353323224;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.025 -0400", hash_original_method = "5C1BC742B784E1F54201A6BFE04FB3C1", hash_generated_method = "47715B7AD4C761EEBB4AAEA5F6DC4684")
    public FloatBuffer get(float[] dst) {
        addTaint(dst[0]);
FloatBuffer varAF8F268F60258FE30F192DE78F11CD4A_1947380277 =         get(dst, 0, dst.length);
        varAF8F268F60258FE30F192DE78F11CD4A_1947380277.addTaint(taint);
        return varAF8F268F60258FE30F192DE78F11CD4A_1947380277;
        // ---------- Original Method ----------
        //return get(dst, 0, dst.length);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.025 -0400", hash_original_method = "62E3FD5BE0E5A19BF5F39022D7154217", hash_generated_method = "982AF9CC2B236B1A4D76664CC5B434F2")
    public FloatBuffer get(float[] dst, int dstOffset, int floatCount) {
        addTaint(floatCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        Arrays.checkOffsetAndCount(dst.length, dstOffset, floatCount);
        if(floatCount > remaining())        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_1631727496 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_1631727496.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_1631727496;
        } //End block
for(int i = dstOffset;i < dstOffset + floatCount;++i)
        {
            dst[i] = get();
        } //End block
FloatBuffer var72A74007B2BE62B849F475C7BDA4658B_67169878 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_67169878.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_67169878;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.026 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "37398856BC447DF6828C8CE0AD4DA746")
    public final boolean hasArray() {
        boolean var55B7C03E3C1EBABD22606AD17EE923C3_1893339618 = (protectedHasArray());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1871960732 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1871960732;
        // ---------- Original Method ----------
        //return protectedHasArray();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.026 -0400", hash_original_method = "B144F8C59516E29D7B0EE6B79958F98A", hash_generated_method = "5F1F55A8B28F2A3073C3AF72C53D8EA4")
    @Override
    public int hashCode() {
        int myPosition = position;
        int hash = 0;
        while
(myPosition < limit)        
        {
            hash = hash + Float.floatToIntBits(get(myPosition++));
        } //End block
        int var0800FC577294C34E0B28AD2839435945_98064562 = (hash);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1864146816 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1864146816;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.027 -0400", hash_original_method = "5B7E9D4E0A0B3CF72C892C67E2CB78B1", hash_generated_method = "CD79BF50F97AF2FC41B34D566EC52262")
    public final FloatBuffer put(float[] src) {
        addTaint(src[0]);
FloatBuffer var7D505613BED257805463C43ADCB4DBAD_1887267415 =         put(src, 0, src.length);
        var7D505613BED257805463C43ADCB4DBAD_1887267415.addTaint(taint);
        return var7D505613BED257805463C43ADCB4DBAD_1887267415;
        // ---------- Original Method ----------
        //return put(src, 0, src.length);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.028 -0400", hash_original_method = "DFC1F5A8B9B8E6C8478049F847BE00DC", hash_generated_method = "0D0D725CCC926F636FE25D787952521A")
    public FloatBuffer put(float[] src, int srcOffset, int floatCount) {
        addTaint(floatCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        Arrays.checkOffsetAndCount(src.length, srcOffset, floatCount);
        if(floatCount > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1222393504 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1222393504.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1222393504;
        } //End block
for(int i = srcOffset;i < srcOffset + floatCount;++i)
        {
            put(src[i]);
        } //End block
FloatBuffer var72A74007B2BE62B849F475C7BDA4658B_1148659578 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1148659578.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1148659578;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.028 -0400", hash_original_method = "338DD208CFE8C4AD7CB14619D9789866", hash_generated_method = "5ECC2A217A93DA5BAC564FF59FE1926B")
    public FloatBuffer put(FloatBuffer src) {
        addTaint(src.getTaint());
        if(src == this)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_121379887 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_121379887.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_121379887;
        } //End block
        if(src.remaining() > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_521175172 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_521175172.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_521175172;
        } //End block
        float[] contents = new float[src.remaining()];
        src.get(contents);
        put(contents);
FloatBuffer var72A74007B2BE62B849F475C7BDA4658B_1075699204 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1075699204.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1075699204;
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

