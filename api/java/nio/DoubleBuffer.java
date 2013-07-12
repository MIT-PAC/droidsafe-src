package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;

public abstract class DoubleBuffer extends Buffer implements Comparable<DoubleBuffer> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.244 -0400", hash_original_method = "0AF8846C39B4C946E7DEA048FA516A89", hash_generated_method = "E632E4EC7764C222EF3E3833B184A64D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.245 -0400", hash_original_method = "A99B5F03AD18580EAA75CC7BA40FC0CE", hash_generated_method = "3738FBA67356DC73B23C91863DB3FC76")
    public final double[] array() {
        double[] var68B89E48382A0AA51B25AC59599E2EB0_502152860 = (protectedArray());
                double[] var74D44D7D9EE6FE6C3433D694F869E521_1972100729 = {getTaintDouble()};
        return var74D44D7D9EE6FE6C3433D694F869E521_1972100729;
        // ---------- Original Method ----------
        //return protectedArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.246 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "8E4A588440CD1312A684DE293840651E")
    public final int arrayOffset() {
        int var0B794CE56A38A9F3BFDD2D53E83BB109_1855547855 = (protectedArrayOffset());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_302752669 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_302752669;
        // ---------- Original Method ----------
        //return protectedArrayOffset();
    }

    
    public abstract DoubleBuffer asReadOnlyBuffer();

    
    public abstract DoubleBuffer compact();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.247 -0400", hash_original_method = "A9C47546143A1E2A817B74D1052E5DC9", hash_generated_method = "51739614F095D8FDC2E1FFCBBF88132C")
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
                int var13069EACA3657A7A151A440E0B39B59A_830680532 = (thisDouble < otherDouble ? -1 : 1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_908663466 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_908663466;
            } //End block
            thisPos++;
            otherPos++;
            compareRemaining--;
        } //End block
        int var1DC167191FBC7DAD3BADAE830552C692_160213988 = (remaining() - otherBuffer.remaining());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1576237715 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1576237715;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.250 -0400", hash_original_method = "80D65346F74BD859AA9774E55290B1E1", hash_generated_method = "334B88AF2316E9D849199E82E45813D9")
    @Override
    public boolean equals(Object other) {
        addTaint(other.getTaint());
    if(!(other instanceof DoubleBuffer))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1202914569 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_451326620 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_451326620;
        } //End block
        DoubleBuffer otherBuffer = (DoubleBuffer) other;
    if(remaining() != otherBuffer.remaining())        
        {
            boolean var68934A3E9455FA72420237EB05902327_2026117237 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1214321038 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1214321038;
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
        boolean var4A97EF18B93B276118DD50585250A586_1666753382 = (equalSoFar);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1895774275 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1895774275;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.251 -0400", hash_original_method = "9BEB92FAE64B1253EE6CA9009E99F3B4", hash_generated_method = "FB6B6FBF0B9FB6C18F91593EE10C8644")
    public DoubleBuffer get(double[] dst) {
        addTaint(dst[0]);
DoubleBuffer varAF8F268F60258FE30F192DE78F11CD4A_379716201 =         get(dst, 0, dst.length);
        varAF8F268F60258FE30F192DE78F11CD4A_379716201.addTaint(taint);
        return varAF8F268F60258FE30F192DE78F11CD4A_379716201;
        // ---------- Original Method ----------
        //return get(dst, 0, dst.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.252 -0400", hash_original_method = "38134BA6A99F502238B51F3879F810C3", hash_generated_method = "D4E0591CA265C29956F5B849DF7AB926")
    public DoubleBuffer get(double[] dst, int dstOffset, int doubleCount) {
        addTaint(doubleCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        Arrays.checkOffsetAndCount(dst.length, dstOffset, doubleCount);
    if(doubleCount > remaining())        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_1181494006 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_1181494006.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_1181494006;
        } //End block
for(int i = dstOffset;i < dstOffset + doubleCount;++i)
        {
            dst[i] = get();
        } //End block
DoubleBuffer var72A74007B2BE62B849F475C7BDA4658B_1808681806 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1808681806.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1808681806;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.252 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "6625A4C3D422DD3C6D0362985C7808A1")
    public final boolean hasArray() {
        boolean var55B7C03E3C1EBABD22606AD17EE923C3_2878915 = (protectedHasArray());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1907137938 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1907137938;
        // ---------- Original Method ----------
        //return protectedHasArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.253 -0400", hash_original_method = "BF88872009B539EF877B1EA5B03706BA", hash_generated_method = "4D1EB6374CE0E3D7CA8D1A0A983F2BE8")
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
        int var0800FC577294C34E0B28AD2839435945_1193857530 = (hash);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_925541982 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_925541982;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.255 -0400", hash_original_method = "93B6D9B754146968969402F4C9473429", hash_generated_method = "1FE478C0E324562E88D27E41B5901492")
    public final DoubleBuffer put(double[] src) {
        addTaint(src[0]);
DoubleBuffer var7D505613BED257805463C43ADCB4DBAD_220014231 =         put(src, 0, src.length);
        var7D505613BED257805463C43ADCB4DBAD_220014231.addTaint(taint);
        return var7D505613BED257805463C43ADCB4DBAD_220014231;
        // ---------- Original Method ----------
        //return put(src, 0, src.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.255 -0400", hash_original_method = "3E73039BF6DB142176253DE2263B83AD", hash_generated_method = "690418699EC0FE5977355D10E0F03348")
    public DoubleBuffer put(double[] src, int srcOffset, int doubleCount) {
        addTaint(doubleCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        Arrays.checkOffsetAndCount(src.length, srcOffset, doubleCount);
    if(doubleCount > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1711027450 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1711027450.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1711027450;
        } //End block
for(int i = srcOffset;i < srcOffset + doubleCount;++i)
        {
            put(src[i]);
        } //End block
DoubleBuffer var72A74007B2BE62B849F475C7BDA4658B_951080505 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_951080505.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_951080505;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.256 -0400", hash_original_method = "C52ECDE4782921BA374F433E41853287", hash_generated_method = "9B6B8BE42FE40313419FF57FC8558C5F")
    public DoubleBuffer put(DoubleBuffer src) {
        addTaint(src.getTaint());
    if(src == this)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_493445454 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_493445454.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_493445454;
        } //End block
    if(src.remaining() > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_871847052 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_871847052.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_871847052;
        } //End block
        double[] doubles = new double[src.remaining()];
        src.get(doubles);
        put(doubles);
DoubleBuffer var72A74007B2BE62B849F475C7BDA4658B_848638464 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_848638464.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_848638464;
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

