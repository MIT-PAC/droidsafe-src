package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;

public abstract class ShortBuffer extends Buffer implements Comparable<ShortBuffer> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.335 -0400", hash_original_method = "EAB92A092C9FEE1EEAB86C6A6FABA79C", hash_generated_method = "6318691CE755B9046B333B497AB15184")
      ShortBuffer(int capacity) {
        super(1, capacity, null);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
        public static ShortBuffer allocate(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        return new ReadWriteShortArrayBuffer(capacity);
    }

    
        public static ShortBuffer wrap(short[] array) {
        return wrap(array, 0, array.length);
    }

    
        public static ShortBuffer wrap(short[] array, int start, int shortCount) {
        Arrays.checkOffsetAndCount(array.length, start, shortCount);
        ShortBuffer buf = new ReadWriteShortArrayBuffer(array);
        buf.position = start;
        buf.limit = start + shortCount;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.336 -0400", hash_original_method = "0A1B03C776C1004F61482923BC618EF6", hash_generated_method = "A07D35AACF794DA8EF2FE2812D5E3D80")
    public final short[] array() {
        short[] var68B89E48382A0AA51B25AC59599E2EB0_729015653 = (protectedArray());
                short[] var48EE7E2DDF8A83602BC526873BD0F875_38416558 = {getTaintShort()};
        return var48EE7E2DDF8A83602BC526873BD0F875_38416558;
        // ---------- Original Method ----------
        //return protectedArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.336 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "3B996B903EC72F457ECCF74E78C8C1E3")
    public final int arrayOffset() {
        int var0B794CE56A38A9F3BFDD2D53E83BB109_624143128 = (protectedArrayOffset());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_25100743 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_25100743;
        // ---------- Original Method ----------
        //return protectedArrayOffset();
    }

    
    public abstract ShortBuffer asReadOnlyBuffer();

    
    public abstract ShortBuffer compact();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.337 -0400", hash_original_method = "F5228E310614FF7F70EC616A5A8F6CEB", hash_generated_method = "79E746AF0ADB25BBB9A1EF3D0049ED50")
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
                int var0D4D283E60262FF52C1A7D956005837E_774377950 = (thisByte < otherByte ? -1 : 1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1838008401 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1838008401;
            } //End block
            thisPos++;
            otherPos++;
            compareRemaining--;
        } //End block
        int var1DC167191FBC7DAD3BADAE830552C692_1444088563 = (remaining() - otherBuffer.remaining());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_510194558 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_510194558;
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

    
    public abstract ShortBuffer duplicate();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.338 -0400", hash_original_method = "5B31F4285E964D7BDABED3BB847D41AA", hash_generated_method = "282E663D6EF46305F6FD14A13299502E")
    @Override
    public boolean equals(Object other) {
        addTaint(other.getTaint());
    if(!(other instanceof ShortBuffer))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1326144325 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_782459444 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_782459444;
        } //End block
        ShortBuffer otherBuffer = (ShortBuffer) other;
    if(remaining() != otherBuffer.remaining())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1236640409 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1354071254 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1354071254;
        } //End block
        int myPosition = position;
        int otherPosition = otherBuffer.position;
        boolean equalSoFar = true;
        while
(equalSoFar && (myPosition < limit))        
        {
            equalSoFar = get(myPosition++) == otherBuffer.get(otherPosition++);
        } //End block
        boolean var4A97EF18B93B276118DD50585250A586_1620106581 = (equalSoFar);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1308407049 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1308407049;
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

    
    public abstract short get();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.339 -0400", hash_original_method = "68406DA953A1F3530F74FC6FE1C452A7", hash_generated_method = "5BB60B024AE7FF6A35DEA0DA49F1598C")
    public ShortBuffer get(short[] dst) {
        addTaint(dst[0]);
ShortBuffer varAF8F268F60258FE30F192DE78F11CD4A_462922269 =         get(dst, 0, dst.length);
        varAF8F268F60258FE30F192DE78F11CD4A_462922269.addTaint(taint);
        return varAF8F268F60258FE30F192DE78F11CD4A_462922269;
        // ---------- Original Method ----------
        //return get(dst, 0, dst.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.340 -0400", hash_original_method = "DE4C5284FF189AE8B07194EE8C193F03", hash_generated_method = "3D03F08A33D839729E093C0FA9BF1BBB")
    public ShortBuffer get(short[] dst, int dstOffset, int shortCount) {
        addTaint(shortCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        Arrays.checkOffsetAndCount(dst.length, dstOffset, shortCount);
    if(shortCount > remaining())        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_1126536207 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_1126536207.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_1126536207;
        } //End block
for(int i = dstOffset;i < dstOffset + shortCount;++i)
        {
            dst[i] = get();
        } //End block
ShortBuffer var72A74007B2BE62B849F475C7BDA4658B_1880025305 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1880025305.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1880025305;
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

    
    public abstract short get(int index);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.340 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "1092BE7B85B76373BEEF4FDA7B2DD754")
    public final boolean hasArray() {
        boolean var55B7C03E3C1EBABD22606AD17EE923C3_861151065 = (protectedHasArray());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1614906131 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1614906131;
        // ---------- Original Method ----------
        //return protectedHasArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.341 -0400", hash_original_method = "371FAD0CF0C9AC8E78075F4EA52336BD", hash_generated_method = "9A68C4EB78A11A128DEAB4B6AF5F5723")
    @Override
    public int hashCode() {
        int myPosition = position;
        int hash = 0;
        while
(myPosition < limit)        
        {
            hash = hash + get(myPosition++);
        } //End block
        int var0800FC577294C34E0B28AD2839435945_1419344017 = (hash);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_799313909 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_799313909;
        // ---------- Original Method ----------
        //int myPosition = position;
        //int hash = 0;
        //while (myPosition < limit) {
            //hash = hash + get(myPosition++);
        //}
        //return hash;
    }

    
    public abstract boolean isDirect();

    
    public abstract ByteOrder order();

    
    abstract short[] protectedArray();

    
    abstract int protectedArrayOffset();

    
    abstract boolean protectedHasArray();

    
    public abstract ShortBuffer put(short s);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.342 -0400", hash_original_method = "47A309F7D8F6DC58E14B9D901E5CA4EB", hash_generated_method = "D2722661FDDC43E3FBADB7C02B0CCD1F")
    public final ShortBuffer put(short[] src) {
        addTaint(src[0]);
ShortBuffer var7D505613BED257805463C43ADCB4DBAD_1232597552 =         put(src, 0, src.length);
        var7D505613BED257805463C43ADCB4DBAD_1232597552.addTaint(taint);
        return var7D505613BED257805463C43ADCB4DBAD_1232597552;
        // ---------- Original Method ----------
        //return put(src, 0, src.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.343 -0400", hash_original_method = "F4EA1FDC39DA95E004DECB204CC15A47", hash_generated_method = "05253F3FB9D4DCE90C9795C5467B38D7")
    public ShortBuffer put(short[] src, int srcOffset, int shortCount) {
        addTaint(shortCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        Arrays.checkOffsetAndCount(src.length, srcOffset, shortCount);
    if(shortCount > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_146710286 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_146710286.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_146710286;
        } //End block
for(int i = srcOffset;i < srcOffset + shortCount;++i)
        {
            put(src[i]);
        } //End block
ShortBuffer var72A74007B2BE62B849F475C7BDA4658B_1754260443 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1754260443.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1754260443;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.344 -0400", hash_original_method = "1D8FC7647B57D46D94B3AA0BA31269DF", hash_generated_method = "782DD836E31AA1C04C7A41014B4911EC")
    public ShortBuffer put(ShortBuffer src) {
        addTaint(src.getTaint());
    if(src == this)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_983358075 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_983358075.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_983358075;
        } //End block
    if(src.remaining() > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_271668523 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_271668523.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_271668523;
        } //End block
        short[] contents = new short[src.remaining()];
        src.get(contents);
        put(contents);
ShortBuffer var72A74007B2BE62B849F475C7BDA4658B_1387452466 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1387452466.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1387452466;
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

    
    public abstract ShortBuffer put(int index, short s);

    
    public abstract ShortBuffer slice();

    
}

