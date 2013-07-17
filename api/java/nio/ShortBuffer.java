package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;

public abstract class ShortBuffer extends Buffer implements Comparable<ShortBuffer> {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.987 -0400", hash_original_method = "EAB92A092C9FEE1EEAB86C6A6FABA79C", hash_generated_method = "6318691CE755B9046B333B497AB15184")
      ShortBuffer(int capacity) {
        super(1, capacity, null);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public static ShortBuffer allocate(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        return new ReadWriteShortArrayBuffer(capacity);
    }

    
    @DSModeled(DSC.SAFE)
    public static ShortBuffer wrap(short[] array) {
        return wrap(array, 0, array.length);
    }

    
    @DSModeled(DSC.SAFE)
    public static ShortBuffer wrap(short[] array, int start, int shortCount) {
        Arrays.checkOffsetAndCount(array.length, start, shortCount);
        ShortBuffer buf = new ReadWriteShortArrayBuffer(array);
        buf.position = start;
        buf.limit = start + shortCount;
        return buf;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.988 -0400", hash_original_method = "0A1B03C776C1004F61482923BC618EF6", hash_generated_method = "98DD42722F8507699F8E0254CA6D062B")
    public final short[] array() {
        short[] var68B89E48382A0AA51B25AC59599E2EB0_2005391723 = (protectedArray());
                short[] var48EE7E2DDF8A83602BC526873BD0F875_1446023110 = {getTaintShort()};
        return var48EE7E2DDF8A83602BC526873BD0F875_1446023110;
        // ---------- Original Method ----------
        //return protectedArray();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.989 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "C6E0DC87AAD0E6046496B3407BAFCAF1")
    public final int arrayOffset() {
        int var0B794CE56A38A9F3BFDD2D53E83BB109_1680568485 = (protectedArrayOffset());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2065457175 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2065457175;
        // ---------- Original Method ----------
        //return protectedArrayOffset();
    }

    
    @DSModeled(DSC.SAFE)
    public abstract ShortBuffer asReadOnlyBuffer();

    
    @DSModeled(DSC.SAFE)
    public abstract ShortBuffer compact();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.990 -0400", hash_original_method = "F5228E310614FF7F70EC616A5A8F6CEB", hash_generated_method = "CC4B58E6DCD6EBDDB482D97586D71835")
    public int compareTo(ShortBuffer otherBuffer) {
        addTaint(otherBuffer.getTaint());
        int compareRemaining = (remaining() < otherBuffer.remaining()) ? remaining()
                : otherBuffer.remaining();
        int thisPos = position;
        int otherPos = otherBuffer.position;
        short thisByte;
        short otherByte;
        while
(compareRemaining > 0)        
        {
            thisByte = get(thisPos);
            otherByte = otherBuffer.get(otherPos);
            if(thisByte != otherByte)            
            {
                int var0D4D283E60262FF52C1A7D956005837E_2126187794 = (thisByte < otherByte ? -1 : 1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2046522335 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2046522335;
            } //End block
            thisPos++;
            otherPos++;
            compareRemaining--;
        } //End block
        int var1DC167191FBC7DAD3BADAE830552C692_2111765937 = (remaining() - otherBuffer.remaining());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1008624493 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1008624493;
        // ---------- Original Method ----------
        //int compareRemaining = (remaining() < otherBuffer.remaining()) ? remaining()
                //: otherBuffer.remaining();
        //int thisPos = position;
        //int otherPos = otherBuffer.position;
        //short thisByte, otherByte;
        //while (compareRemaining > 0) {
            //thisByte = get(thisPos);
            //otherByte = otherBuffer.get(otherPos);
            //if (thisByte != otherByte) {
                //return thisByte < otherByte ? -1 : 1;
            //}
            //thisPos++;
            //otherPos++;
            //compareRemaining--;
        //}
        //return remaining() - otherBuffer.remaining();
    }

    
    @DSModeled(DSC.SAFE)
    public abstract ShortBuffer duplicate();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.991 -0400", hash_original_method = "5B31F4285E964D7BDABED3BB847D41AA", hash_generated_method = "6F5CE1B4E79FD41A9E0535929CBE567C")
    @Override
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        if(!(other instanceof ShortBuffer))        
        {
            boolean var68934A3E9455FA72420237EB05902327_2016831118 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1674941644 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1674941644;
        } //End block
        ShortBuffer otherBuffer = (ShortBuffer) other;
        if(remaining() != otherBuffer.remaining())        
        {
            boolean var68934A3E9455FA72420237EB05902327_89753107 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1117759356 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1117759356;
        } //End block
        int myPosition = position;
        int otherPosition = otherBuffer.position;
        boolean equalSoFar = true;
        while
(equalSoFar && (myPosition < limit))        
        {
            equalSoFar = get(myPosition++) == otherBuffer.get(otherPosition++);
        } //End block
        boolean var4A97EF18B93B276118DD50585250A586_703765397 = (equalSoFar);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1308513237 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1308513237;
        // ---------- Original Method ----------
        //if (!(other instanceof ShortBuffer)) {
            //return false;
        //}
        //ShortBuffer otherBuffer = (ShortBuffer) other;
        //if (remaining() != otherBuffer.remaining()) {
            //return false;
        //}
        //int myPosition = position;
        //int otherPosition = otherBuffer.position;
        //boolean equalSoFar = true;
        //while (equalSoFar && (myPosition < limit)) {
            //equalSoFar = get(myPosition++) == otherBuffer.get(otherPosition++);
        //}
        //return equalSoFar;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract short get();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.992 -0400", hash_original_method = "68406DA953A1F3530F74FC6FE1C452A7", hash_generated_method = "E6A8B0A228F511C0B8F2AF60A3B3E08F")
    public ShortBuffer get(short[] dst) {
        addTaint(dst[0]);
ShortBuffer varAF8F268F60258FE30F192DE78F11CD4A_1160801342 =         get(dst, 0, dst.length);
        varAF8F268F60258FE30F192DE78F11CD4A_1160801342.addTaint(taint);
        return varAF8F268F60258FE30F192DE78F11CD4A_1160801342;
        // ---------- Original Method ----------
        //return get(dst, 0, dst.length);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.992 -0400", hash_original_method = "DE4C5284FF189AE8B07194EE8C193F03", hash_generated_method = "F06FC16CFB0E8F7BA70A1B4238A4A0D0")
    public ShortBuffer get(short[] dst, int dstOffset, int shortCount) {
        addTaint(shortCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        Arrays.checkOffsetAndCount(dst.length, dstOffset, shortCount);
        if(shortCount > remaining())        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_1130688308 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_1130688308.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_1130688308;
        } //End block
for(int i = dstOffset;i < dstOffset + shortCount;++i)
        {
            dst[i] = get();
        } //End block
ShortBuffer var72A74007B2BE62B849F475C7BDA4658B_1023722495 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1023722495.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1023722495;
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(dst.length, dstOffset, shortCount);
        //if (shortCount > remaining()) {
            //throw new BufferUnderflowException();
        //}
        //for (int i = dstOffset; i < dstOffset + shortCount; ++i) {
            //dst[i] = get();
        //}
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract short get(int index);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.993 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "C14D6DF407414F1C0FD6991B0AA8A4DC")
    public final boolean hasArray() {
        boolean var55B7C03E3C1EBABD22606AD17EE923C3_1355576793 = (protectedHasArray());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_748895945 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_748895945;
        // ---------- Original Method ----------
        //return protectedHasArray();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.993 -0400", hash_original_method = "371FAD0CF0C9AC8E78075F4EA52336BD", hash_generated_method = "CF4340CC0B3087A85DCEE20C818FD489")
    @Override
    public int hashCode() {
        int myPosition = position;
        int hash = 0;
        while
(myPosition < limit)        
        {
            hash = hash + get(myPosition++);
        } //End block
        int var0800FC577294C34E0B28AD2839435945_1462197693 = (hash);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_487978537 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_487978537;
        // ---------- Original Method ----------
        //int myPosition = position;
        //int hash = 0;
        //while (myPosition < limit) {
            //hash = hash + get(myPosition++);
        //}
        //return hash;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract boolean isDirect();

    
    @DSModeled(DSC.SAFE)
    public abstract ByteOrder order();

    
    @DSModeled(DSC.SAFE)
    abstract short[] protectedArray();

    
    @DSModeled(DSC.SAFE)
    abstract int protectedArrayOffset();

    
    @DSModeled(DSC.SAFE)
    abstract boolean protectedHasArray();

    
    @DSModeled(DSC.SAFE)
    public abstract ShortBuffer put(short s);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.995 -0400", hash_original_method = "47A309F7D8F6DC58E14B9D901E5CA4EB", hash_generated_method = "0409FA7E1D5480CAEEBE89E8192671A5")
    public final ShortBuffer put(short[] src) {
        addTaint(src[0]);
ShortBuffer var7D505613BED257805463C43ADCB4DBAD_36542312 =         put(src, 0, src.length);
        var7D505613BED257805463C43ADCB4DBAD_36542312.addTaint(taint);
        return var7D505613BED257805463C43ADCB4DBAD_36542312;
        // ---------- Original Method ----------
        //return put(src, 0, src.length);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.995 -0400", hash_original_method = "F4EA1FDC39DA95E004DECB204CC15A47", hash_generated_method = "54E797116F980CEA83F4EF535F282641")
    public ShortBuffer put(short[] src, int srcOffset, int shortCount) {
        addTaint(shortCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        Arrays.checkOffsetAndCount(src.length, srcOffset, shortCount);
        if(shortCount > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1871680638 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1871680638.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1871680638;
        } //End block
for(int i = srcOffset;i < srcOffset + shortCount;++i)
        {
            put(src[i]);
        } //End block
ShortBuffer var72A74007B2BE62B849F475C7BDA4658B_1524953398 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1524953398.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1524953398;
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(src.length, srcOffset, shortCount);
        //if (shortCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //for (int i = srcOffset; i < srcOffset + shortCount; ++i) {
            //put(src[i]);
        //}
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.996 -0400", hash_original_method = "1D8FC7647B57D46D94B3AA0BA31269DF", hash_generated_method = "4D66E4039BDF4A805C4C77C62C1260CA")
    public ShortBuffer put(ShortBuffer src) {
        addTaint(src.getTaint());
        if(src == this)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1713868047 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1713868047.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1713868047;
        } //End block
        if(src.remaining() > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1523585618 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1523585618.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1523585618;
        } //End block
        short[] contents = new short[src.remaining()];
        src.get(contents);
        put(contents);
ShortBuffer var72A74007B2BE62B849F475C7BDA4658B_1156442666 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1156442666.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1156442666;
        // ---------- Original Method ----------
        //if (src == this) {
            //throw new IllegalArgumentException();
        //}
        //if (src.remaining() > remaining()) {
            //throw new BufferOverflowException();
        //}
        //short[] contents = new short[src.remaining()];
        //src.get(contents);
        //put(contents);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract ShortBuffer put(int index, short s);

    
    @DSModeled(DSC.SAFE)
    public abstract ShortBuffer slice();

    
}

