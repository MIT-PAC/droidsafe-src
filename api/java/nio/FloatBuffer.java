package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;

public abstract class FloatBuffer extends Buffer implements Comparable<FloatBuffer> {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.532 -0400", hash_original_method = "40CC822379F71BDE2069817768983643", hash_generated_method = "9E533343D88E64736D05E2F347F6068D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.533 -0400", hash_original_method = "3D88E12435E8ECFF27E8491C8CFB38C5", hash_generated_method = "71A105515ED2DAA930CEB1C2C8A57296")
    public final float[] array() {
        float[] var68B89E48382A0AA51B25AC59599E2EB0_1383755950 = (protectedArray());
                float[] varB2C245003BAB9224CFB496218F7DAFE0_2021357322 = {getTaintFloat()};
        return varB2C245003BAB9224CFB496218F7DAFE0_2021357322;
        // ---------- Original Method ----------
        //return protectedArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.533 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "AB6ED3EC4BC60B3694A191B21011A429")
    public final int arrayOffset() {
        int var0B794CE56A38A9F3BFDD2D53E83BB109_260493791 = (protectedArrayOffset());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_876691808 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_876691808;
        // ---------- Original Method ----------
        //return protectedArrayOffset();
    }

    
    public abstract FloatBuffer asReadOnlyBuffer();

    
    public abstract FloatBuffer compact();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.534 -0400", hash_original_method = "255AC25FE0773812484072E75724705E", hash_generated_method = "9B964915AD470523204350FCDF05BE5E")
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
                int varC85F1A8B33FB73B6BB38C92945B2E25C_120100821 = (thisFloat < otherFloat ? -1 : 1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1008660230 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1008660230;
            } //End block
            thisPos++;
            otherPos++;
            compareRemaining--;
        } //End block
        int var1DC167191FBC7DAD3BADAE830552C692_479207865 = (remaining() - otherBuffer.remaining());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_460214192 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_460214192;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.536 -0400", hash_original_method = "962C433BA6F78C4BE1DF9C98AF3A7A4D", hash_generated_method = "B94DB7E4C4A6161F8E1029239067262E")
    @Override
    public boolean equals(Object other) {
        addTaint(other.getTaint());
    if(!(other instanceof FloatBuffer))        
        {
            boolean var68934A3E9455FA72420237EB05902327_143392920 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1587132953 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1587132953;
        } //End block
        FloatBuffer otherBuffer = (FloatBuffer) other;
    if(remaining() != otherBuffer.remaining())        
        {
            boolean var68934A3E9455FA72420237EB05902327_2121572986 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_251020223 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_251020223;
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
        boolean var4A97EF18B93B276118DD50585250A586_842446815 = (equalSoFar);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_40477975 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_40477975;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.536 -0400", hash_original_method = "5C1BC742B784E1F54201A6BFE04FB3C1", hash_generated_method = "994CB6D76594A55D9C15807FA9FF6694")
    public FloatBuffer get(float[] dst) {
        addTaint(dst[0]);
FloatBuffer varAF8F268F60258FE30F192DE78F11CD4A_358582306 =         get(dst, 0, dst.length);
        varAF8F268F60258FE30F192DE78F11CD4A_358582306.addTaint(taint);
        return varAF8F268F60258FE30F192DE78F11CD4A_358582306;
        // ---------- Original Method ----------
        //return get(dst, 0, dst.length);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.537 -0400", hash_original_method = "62E3FD5BE0E5A19BF5F39022D7154217", hash_generated_method = "4E384F4C1BBFF8277D6ADBA1D9B53BA8")
    public FloatBuffer get(float[] dst, int dstOffset, int floatCount) {
        addTaint(floatCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        Arrays.checkOffsetAndCount(dst.length, dstOffset, floatCount);
    if(floatCount > remaining())        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_905554678 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_905554678.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_905554678;
        } //End block
for(int i = dstOffset;i < dstOffset + floatCount;++i)
        {
            dst[i] = get();
        } //End block
FloatBuffer var72A74007B2BE62B849F475C7BDA4658B_409674209 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_409674209.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_409674209;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.538 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "9036CBD78DCA442F134C0BE6B43500B8")
    public final boolean hasArray() {
        boolean var55B7C03E3C1EBABD22606AD17EE923C3_1318219826 = (protectedHasArray());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1597076164 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1597076164;
        // ---------- Original Method ----------
        //return protectedHasArray();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.539 -0400", hash_original_method = "B144F8C59516E29D7B0EE6B79958F98A", hash_generated_method = "C1F463155AFB06B74AD067FA15B2E85B")
    @Override
    public int hashCode() {
        int myPosition = position;
        int hash = 0;
        while
(myPosition < limit)        
        {
            hash = hash + Float.floatToIntBits(get(myPosition++));
        } //End block
        int var0800FC577294C34E0B28AD2839435945_740638908 = (hash);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_531584945 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_531584945;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.541 -0400", hash_original_method = "5B7E9D4E0A0B3CF72C892C67E2CB78B1", hash_generated_method = "33A5678E34C049DDDD6A478213E2676C")
    public final FloatBuffer put(float[] src) {
        addTaint(src[0]);
FloatBuffer var7D505613BED257805463C43ADCB4DBAD_1097579588 =         put(src, 0, src.length);
        var7D505613BED257805463C43ADCB4DBAD_1097579588.addTaint(taint);
        return var7D505613BED257805463C43ADCB4DBAD_1097579588;
        // ---------- Original Method ----------
        //return put(src, 0, src.length);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.541 -0400", hash_original_method = "DFC1F5A8B9B8E6C8478049F847BE00DC", hash_generated_method = "1B2B6CD709E18E77B7F5B5F5C0183FB9")
    public FloatBuffer put(float[] src, int srcOffset, int floatCount) {
        addTaint(floatCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        Arrays.checkOffsetAndCount(src.length, srcOffset, floatCount);
    if(floatCount > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1653770454 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1653770454.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1653770454;
        } //End block
for(int i = srcOffset;i < srcOffset + floatCount;++i)
        {
            put(src[i]);
        } //End block
FloatBuffer var72A74007B2BE62B849F475C7BDA4658B_1249632567 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1249632567.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1249632567;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.542 -0400", hash_original_method = "338DD208CFE8C4AD7CB14619D9789866", hash_generated_method = "001FCAEBE0488AE7543403CE94DC6DFF")
    public FloatBuffer put(FloatBuffer src) {
        addTaint(src.getTaint());
    if(src == this)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1952080064 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1952080064.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1952080064;
        } //End block
    if(src.remaining() > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_337071682 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_337071682.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_337071682;
        } //End block
        float[] contents = new float[src.remaining()];
        src.get(contents);
        put(contents);
FloatBuffer var72A74007B2BE62B849F475C7BDA4658B_209597173 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_209597173.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_209597173;
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

