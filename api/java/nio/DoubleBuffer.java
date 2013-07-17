package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;

public abstract class DoubleBuffer extends Buffer implements Comparable<DoubleBuffer> {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.589 -0400", hash_original_method = "0AF8846C39B4C946E7DEA048FA516A89", hash_generated_method = "E632E4EC7764C222EF3E3833B184A64D")
      DoubleBuffer(int capacity) {
        super(3, capacity, null);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public static DoubleBuffer allocate(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        return new ReadWriteDoubleArrayBuffer(capacity);
    }

    
    @DSModeled(DSC.SAFE)
    public static DoubleBuffer wrap(double[] array) {
        return wrap(array, 0, array.length);
    }

    
    @DSModeled(DSC.SAFE)
    public static DoubleBuffer wrap(double[] array, int start, int doubleCount) {
        Arrays.checkOffsetAndCount(array.length, start, doubleCount);
        DoubleBuffer buf = new ReadWriteDoubleArrayBuffer(array);
        buf.position = start;
        buf.limit = start + doubleCount;
        return buf;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.591 -0400", hash_original_method = "A99B5F03AD18580EAA75CC7BA40FC0CE", hash_generated_method = "CD9F63C5EDD7F11D4096F19E94F6B13D")
    public final double[] array() {
        double[] var68B89E48382A0AA51B25AC59599E2EB0_152552845 = (protectedArray());
                double[] var74D44D7D9EE6FE6C3433D694F869E521_1560335538 = {getTaintDouble()};
        return var74D44D7D9EE6FE6C3433D694F869E521_1560335538;
        // ---------- Original Method ----------
        //return protectedArray();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.591 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "ED610C5A5769BE8C69C3F75508615EBB")
    public final int arrayOffset() {
        int var0B794CE56A38A9F3BFDD2D53E83BB109_429151270 = (protectedArrayOffset());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_575637968 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_575637968;
        // ---------- Original Method ----------
        //return protectedArrayOffset();
    }

    
    @DSModeled(DSC.SAFE)
    public abstract DoubleBuffer asReadOnlyBuffer();

    
    @DSModeled(DSC.SAFE)
    public abstract DoubleBuffer compact();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.592 -0400", hash_original_method = "A9C47546143A1E2A817B74D1052E5DC9", hash_generated_method = "B956B989F6DD1CA8FD02E80453B96886")
    public int compareTo(DoubleBuffer otherBuffer) {
        addTaint(otherBuffer.getTaint());
        int compareRemaining = (remaining() < otherBuffer.remaining()) ? remaining()
                : otherBuffer.remaining();
        int thisPos = position;
        int otherPos = otherBuffer.position;
        double thisDouble;
        double otherDouble;
        while
(compareRemaining > 0)        
        {
            thisDouble = get(thisPos);
            otherDouble = otherBuffer.get(otherPos);
            if((thisDouble != otherDouble)
                    && ((thisDouble == thisDouble) || (otherDouble == otherDouble)))            
            {
                int var13069EACA3657A7A151A440E0B39B59A_34883306 = (thisDouble < otherDouble ? -1 : 1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_445420519 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_445420519;
            } //End block
            thisPos++;
            otherPos++;
            compareRemaining--;
        } //End block
        int var1DC167191FBC7DAD3BADAE830552C692_1335453365 = (remaining() - otherBuffer.remaining());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1447856655 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1447856655;
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

    
    @DSModeled(DSC.SAFE)
    public abstract DoubleBuffer duplicate();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.593 -0400", hash_original_method = "80D65346F74BD859AA9774E55290B1E1", hash_generated_method = "59412BB03D05F933E07A4A5255EF4116")
    @Override
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        if(!(other instanceof DoubleBuffer))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1326206595 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1447845619 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1447845619;
        } //End block
        DoubleBuffer otherBuffer = (DoubleBuffer) other;
        if(remaining() != otherBuffer.remaining())        
        {
            boolean var68934A3E9455FA72420237EB05902327_148212402 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_904209116 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_904209116;
        } //End block
        int myPosition = position;
        int otherPosition = otherBuffer.position;
        boolean equalSoFar = true;
        while
(equalSoFar && (myPosition < limit))        
        {
            double a = get(myPosition++);
            double b = otherBuffer.get(otherPosition++);
            equalSoFar = a == b || (a != a && b != b);
        } //End block
        boolean var4A97EF18B93B276118DD50585250A586_1384249830 = (equalSoFar);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1645595683 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1645595683;
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

    
    @DSModeled(DSC.SAFE)
    public abstract double get();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.594 -0400", hash_original_method = "9BEB92FAE64B1253EE6CA9009E99F3B4", hash_generated_method = "EB008445E8EC3AC304076478A2A0925F")
    public DoubleBuffer get(double[] dst) {
        addTaint(dst[0]);
DoubleBuffer varAF8F268F60258FE30F192DE78F11CD4A_1525035232 =         get(dst, 0, dst.length);
        varAF8F268F60258FE30F192DE78F11CD4A_1525035232.addTaint(taint);
        return varAF8F268F60258FE30F192DE78F11CD4A_1525035232;
        // ---------- Original Method ----------
        //return get(dst, 0, dst.length);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.594 -0400", hash_original_method = "38134BA6A99F502238B51F3879F810C3", hash_generated_method = "2C3E6E1CB632DFE763F6BA500B41C656")
    public DoubleBuffer get(double[] dst, int dstOffset, int doubleCount) {
        addTaint(doubleCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        Arrays.checkOffsetAndCount(dst.length, dstOffset, doubleCount);
        if(doubleCount > remaining())        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_767738784 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_767738784.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_767738784;
        } //End block
for(int i = dstOffset;i < dstOffset + doubleCount;++i)
        {
            dst[i] = get();
        } //End block
DoubleBuffer var72A74007B2BE62B849F475C7BDA4658B_306853375 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_306853375.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_306853375;
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

    
    @DSModeled(DSC.SAFE)
    public abstract double get(int index);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.595 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "7FD7D18142CDFD54D3EA738C099027C5")
    public final boolean hasArray() {
        boolean var55B7C03E3C1EBABD22606AD17EE923C3_1431606553 = (protectedHasArray());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1956064896 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1956064896;
        // ---------- Original Method ----------
        //return protectedHasArray();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.595 -0400", hash_original_method = "BF88872009B539EF877B1EA5B03706BA", hash_generated_method = "B651409381F4CAC2552857AC9E6A41BB")
    @Override
    public int hashCode() {
        int myPosition = position;
        int hash = 0;
        long l;
        while
(myPosition < limit)        
        {
            l = Double.doubleToLongBits(get(myPosition++));
            hash = hash + ((int) l) ^ ((int) (l >> 32));
        } //End block
        int var0800FC577294C34E0B28AD2839435945_2057468585 = (hash);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1455040333 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1455040333;
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

    
    @DSModeled(DSC.SAFE)
    public abstract boolean isDirect();

    
    @DSModeled(DSC.SAFE)
    public abstract ByteOrder order();

    
    @DSModeled(DSC.SAFE)
    abstract double[] protectedArray();

    
    @DSModeled(DSC.SAFE)
    abstract int protectedArrayOffset();

    
    @DSModeled(DSC.SAFE)
    abstract boolean protectedHasArray();

    
    @DSModeled(DSC.SAFE)
    public abstract DoubleBuffer put(double d);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.597 -0400", hash_original_method = "93B6D9B754146968969402F4C9473429", hash_generated_method = "832877890426DBED9D3DBC870C398A15")
    public final DoubleBuffer put(double[] src) {
        addTaint(src[0]);
DoubleBuffer var7D505613BED257805463C43ADCB4DBAD_1440294287 =         put(src, 0, src.length);
        var7D505613BED257805463C43ADCB4DBAD_1440294287.addTaint(taint);
        return var7D505613BED257805463C43ADCB4DBAD_1440294287;
        // ---------- Original Method ----------
        //return put(src, 0, src.length);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.597 -0400", hash_original_method = "3E73039BF6DB142176253DE2263B83AD", hash_generated_method = "5888DC14B11E55F7EEA92AE3BF66391F")
    public DoubleBuffer put(double[] src, int srcOffset, int doubleCount) {
        addTaint(doubleCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        Arrays.checkOffsetAndCount(src.length, srcOffset, doubleCount);
        if(doubleCount > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1021258665 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1021258665.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1021258665;
        } //End block
for(int i = srcOffset;i < srcOffset + doubleCount;++i)
        {
            put(src[i]);
        } //End block
DoubleBuffer var72A74007B2BE62B849F475C7BDA4658B_350447748 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_350447748.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_350447748;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.598 -0400", hash_original_method = "C52ECDE4782921BA374F433E41853287", hash_generated_method = "9382F845A2C3D9F5F0B73673755DD9F7")
    public DoubleBuffer put(DoubleBuffer src) {
        addTaint(src.getTaint());
        if(src == this)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1316031244 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1316031244.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1316031244;
        } //End block
        if(src.remaining() > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_672442951 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_672442951.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_672442951;
        } //End block
        double[] doubles = new double[src.remaining()];
        src.get(doubles);
        put(doubles);
DoubleBuffer var72A74007B2BE62B849F475C7BDA4658B_1506123572 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1506123572.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1506123572;
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

    
    @DSModeled(DSC.SAFE)
    public abstract DoubleBuffer put(int index, double d);

    
    @DSModeled(DSC.SAFE)
    public abstract DoubleBuffer slice();

    
}

