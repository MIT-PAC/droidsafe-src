package java.nio;

// Droidsafe Imports
import java.io.IOException;
import java.util.Arrays;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class CharBuffer extends Buffer implements Comparable<CharBuffer>, CharSequence, Appendable, Readable {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.341 -0400", hash_original_method = "295C6F316A1C76C71107A06FE21F48B5", hash_generated_method = "856FDA6EDC6BF7740B409AA337EC184E")
      CharBuffer(int capacity) {
        super(1, capacity, null);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public static CharBuffer allocate(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        return new ReadWriteCharArrayBuffer(capacity);
    }

    
    @DSModeled(DSC.SAFE)
    public static CharBuffer wrap(char[] array) {
        return wrap(array, 0, array.length);
    }

    
    @DSModeled(DSC.SAFE)
    public static CharBuffer wrap(char[] array, int start, int charCount) {
        Arrays.checkOffsetAndCount(array.length, start, charCount);
        CharBuffer buf = new ReadWriteCharArrayBuffer(array);
        buf.position = start;
        buf.limit = start + charCount;
        return buf;
    }

    
    @DSModeled(DSC.SAFE)
    public static CharBuffer wrap(CharSequence chseq) {
        return new CharSequenceAdapter(chseq);
    }

    
    @DSModeled(DSC.SAFE)
    public static CharBuffer wrap(CharSequence cs, int start, int end) {
        if (start < 0 || end < start || end > cs.length()) {
            throw new IndexOutOfBoundsException("cs.length()=" + cs.length() + ", start=" + start + ", end=" + end);
        }
        CharBuffer result = new CharSequenceAdapter(cs);
        result.position = start;
        result.limit = end;
        return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.343 -0400", hash_original_method = "B8788BC8872EF40BE08078E90206AB2A", hash_generated_method = "4B3EB7C5A7339B4751BA6AD79FFA4959")
    public final char[] array() {
        char[] var68B89E48382A0AA51B25AC59599E2EB0_1721196672 = (protectedArray());
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_1969673569 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1969673569;
        // ---------- Original Method ----------
        //return protectedArray();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.343 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "5AFCA57E3D990504305579858CB063A1")
    public final int arrayOffset() {
        int var0B794CE56A38A9F3BFDD2D53E83BB109_561538584 = (protectedArrayOffset());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1038302813 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1038302813;
        // ---------- Original Method ----------
        //return protectedArrayOffset();
    }

    
    @DSModeled(DSC.SAFE)
    public abstract CharBuffer asReadOnlyBuffer();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.344 -0400", hash_original_method = "064ED2665DC7B0A0ED1B4C93428755B4", hash_generated_method = "635113519BFFD581A3FCED197832E942")
    public final char charAt(int index) {
        addTaint(index);
        if(index < 0 || index >= remaining())        
        {
            IndexOutOfBoundsException var7EDBAAD1EBDE2B517419CD574EFB00C6_849597861 = new IndexOutOfBoundsException("index=" + index + ", remaining()=" + remaining());
            var7EDBAAD1EBDE2B517419CD574EFB00C6_849597861.addTaint(taint);
            throw var7EDBAAD1EBDE2B517419CD574EFB00C6_849597861;
        } //End block
        char var2571BF635708C79B1D5368209BC3ED18_1458887957 = (get(position + index));
                char varA87DEB01C5F539E6BDA34829C8EF2368_1415896501 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1415896501;
        // ---------- Original Method ----------
        //if (index < 0 || index >= remaining()) {
            //throw new IndexOutOfBoundsException("index=" + index + ", remaining()=" + remaining());
        //}
        //return get(position + index);
    }

    
    @DSModeled(DSC.SAFE)
    public abstract CharBuffer compact();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.345 -0400", hash_original_method = "726E488C44BA42D1E85B63DB9E089EB1", hash_generated_method = "50F105E97B253066219A974E9AE572E3")
    public int compareTo(CharBuffer otherBuffer) {
        addTaint(otherBuffer.getTaint());
        int compareRemaining = (remaining() < otherBuffer.remaining()) ? remaining()
                : otherBuffer.remaining();
        int thisPos = position;
        int otherPos = otherBuffer.position;
        char thisByte;
        char otherByte;
        while
(compareRemaining > 0)        
        {
            thisByte = get(thisPos);
            otherByte = otherBuffer.get(otherPos);
            if(thisByte != otherByte)            
            {
                int var0D4D283E60262FF52C1A7D956005837E_101692304 = (thisByte < otherByte ? -1 : 1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1112632500 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1112632500;
            } //End block
            thisPos++;
            otherPos++;
            compareRemaining--;
        } //End block
        int var1DC167191FBC7DAD3BADAE830552C692_781950470 = (remaining() - otherBuffer.remaining());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1072964364 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1072964364;
        // ---------- Original Method ----------
        //int compareRemaining = (remaining() < otherBuffer.remaining()) ? remaining()
                //: otherBuffer.remaining();
        //int thisPos = position;
        //int otherPos = otherBuffer.position;
        //char thisByte, otherByte;
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
    public abstract CharBuffer duplicate();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.346 -0400", hash_original_method = "43FFCFC26BAE21B80C74493A78B534C8", hash_generated_method = "90002019A8F12DE0026029590B39ADE3")
    @Override
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        if(!(other instanceof CharBuffer))        
        {
            boolean var68934A3E9455FA72420237EB05902327_538680156 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1847823645 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1847823645;
        } //End block
        CharBuffer otherBuffer = (CharBuffer) other;
        if(remaining() != otherBuffer.remaining())        
        {
            boolean var68934A3E9455FA72420237EB05902327_950202515 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_437730477 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_437730477;
        } //End block
        int myPosition = position;
        int otherPosition = otherBuffer.position;
        boolean equalSoFar = true;
        while
(equalSoFar && (myPosition < limit))        
        {
            equalSoFar = get(myPosition++) == otherBuffer.get(otherPosition++);
        } //End block
        boolean var4A97EF18B93B276118DD50585250A586_192037190 = (equalSoFar);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_891624576 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_891624576;
        // ---------- Original Method ----------
        //if (!(other instanceof CharBuffer)) {
            //return false;
        //}
        //CharBuffer otherBuffer = (CharBuffer) other;
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
    public abstract char get();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.347 -0400", hash_original_method = "CCEA164926296D5352A245D12A0C46F5", hash_generated_method = "2DD293CDD8970D658810D73A6E5D68BA")
    public CharBuffer get(char[] dst) {
        addTaint(dst[0]);
CharBuffer varAF8F268F60258FE30F192DE78F11CD4A_558160443 =         get(dst, 0, dst.length);
        varAF8F268F60258FE30F192DE78F11CD4A_558160443.addTaint(taint);
        return varAF8F268F60258FE30F192DE78F11CD4A_558160443;
        // ---------- Original Method ----------
        //return get(dst, 0, dst.length);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.347 -0400", hash_original_method = "098FD190C217FD14B547D1BC38021C90", hash_generated_method = "83EC632CB48766C9F2F5FF2D1FE27CDC")
    public CharBuffer get(char[] dst, int dstOffset, int charCount) {
        addTaint(charCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        Arrays.checkOffsetAndCount(dst.length, dstOffset, charCount);
        if(charCount > remaining())        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_1444515625 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_1444515625.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_1444515625;
        } //End block
for(int i = dstOffset;i < dstOffset + charCount;++i)
        {
            dst[i] = get();
        } //End block
CharBuffer var72A74007B2BE62B849F475C7BDA4658B_432142668 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_432142668.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_432142668;
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(dst.length, dstOffset, charCount);
        //if (charCount > remaining()) {
            //throw new BufferUnderflowException();
        //}
        //for (int i = dstOffset; i < dstOffset + charCount; ++i) {
            //dst[i] = get();
        //}
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract char get(int index);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.348 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "56EF58C76B4ADF7CCBE8E9FE8771782A")
    public final boolean hasArray() {
        boolean var55B7C03E3C1EBABD22606AD17EE923C3_1334326882 = (protectedHasArray());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_575046059 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_575046059;
        // ---------- Original Method ----------
        //return protectedHasArray();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.348 -0400", hash_original_method = "371FAD0CF0C9AC8E78075F4EA52336BD", hash_generated_method = "0FD2E8051D66FEFB709B21A4D7BFD50A")
    @Override
    public int hashCode() {
        int myPosition = position;
        int hash = 0;
        while
(myPosition < limit)        
        {
            hash = hash + get(myPosition++);
        } //End block
        int var0800FC577294C34E0B28AD2839435945_1081459387 = (hash);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1933085996 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1933085996;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.348 -0400", hash_original_method = "C49AE9EB347B20902074CA3EBA57FA96", hash_generated_method = "853D5F2E07CC9E7C205D722F989B4D3B")
    public final int length() {
        int varDDC5A90D80216ADD8FAE07957BE5782C_1396683064 = (remaining());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_860598744 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_860598744;
        // ---------- Original Method ----------
        //return remaining();
    }

    
    @DSModeled(DSC.SAFE)
    public abstract ByteOrder order();

    
    @DSModeled(DSC.SAFE)
    abstract char[] protectedArray();

    
    @DSModeled(DSC.SAFE)
    abstract int protectedArrayOffset();

    
    @DSModeled(DSC.SAFE)
    abstract boolean protectedHasArray();

    
    @DSModeled(DSC.SAFE)
    public abstract CharBuffer put(char c);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.348 -0400", hash_original_method = "470B54D034ECB079323054E5FA7FB003", hash_generated_method = "D94461FCC1893D02B546A333278CE5F2")
    public final CharBuffer put(char[] src) {
        addTaint(src[0]);
CharBuffer var7D505613BED257805463C43ADCB4DBAD_1166144060 =         put(src, 0, src.length);
        var7D505613BED257805463C43ADCB4DBAD_1166144060.addTaint(taint);
        return var7D505613BED257805463C43ADCB4DBAD_1166144060;
        // ---------- Original Method ----------
        //return put(src, 0, src.length);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.349 -0400", hash_original_method = "022BE284F152CDC3C1FB1410D39A7C9D", hash_generated_method = "DB0EBBA3E5648280329464E49EB8FF93")
    public CharBuffer put(char[] src, int srcOffset, int charCount) {
        addTaint(charCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        Arrays.checkOffsetAndCount(src.length, srcOffset, charCount);
        if(charCount > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1864075854 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1864075854.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1864075854;
        } //End block
for(int i = srcOffset;i < srcOffset + charCount;++i)
        {
            put(src[i]);
        } //End block
CharBuffer var72A74007B2BE62B849F475C7BDA4658B_1552854205 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1552854205.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1552854205;
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(src.length, srcOffset, charCount);
        //if (charCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //for (int i = srcOffset; i < srcOffset + charCount; ++i) {
            //put(src[i]);
        //}
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.349 -0400", hash_original_method = "37C3423DFAF6E5EC51AB38006AB488BA", hash_generated_method = "E4FAAEAAFDD4CB0E16E4681307A2E9EA")
    public CharBuffer put(CharBuffer src) {
        addTaint(src.getTaint());
        if(src == this)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1130122132 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1130122132.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1130122132;
        } //End block
        if(src.remaining() > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1509138623 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1509138623.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1509138623;
        } //End block
        char[] contents = new char[src.remaining()];
        src.get(contents);
        put(contents);
CharBuffer var72A74007B2BE62B849F475C7BDA4658B_98317293 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_98317293.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_98317293;
        // ---------- Original Method ----------
        //if (src == this) {
            //throw new IllegalArgumentException();
        //}
        //if (src.remaining() > remaining()) {
            //throw new BufferOverflowException();
        //}
        //char[] contents = new char[src.remaining()];
        //src.get(contents);
        //put(contents);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract CharBuffer put(int index, char c);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.349 -0400", hash_original_method = "E7006B831E6768B620311924466DB7A4", hash_generated_method = "FB743D1E23D119BD8F97C4B7EBF14B38")
    public final CharBuffer put(String str) {
        addTaint(str.getTaint());
CharBuffer var80E016D18018A9A6110F6C1B5F9ADE1F_370800662 =         put(str, 0, str.length());
        var80E016D18018A9A6110F6C1B5F9ADE1F_370800662.addTaint(taint);
        return var80E016D18018A9A6110F6C1B5F9ADE1F_370800662;
        // ---------- Original Method ----------
        //return put(str, 0, str.length());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.349 -0400", hash_original_method = "D2CD34EAF4E6074C289823E8F75291E2", hash_generated_method = "2C933084FFBBEBCAACA4EF81B695E8BE")
    public CharBuffer put(String str, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(str.getTaint());
        if(start < 0 || end < start || end > str.length())        
        {
            IndexOutOfBoundsException var85E786FB40E8A812D6BA58B12716CB8A_1170382809 = new IndexOutOfBoundsException("str.length()=" + str.length() +
                    ", start=" + start + ", end=" + end);
            var85E786FB40E8A812D6BA58B12716CB8A_1170382809.addTaint(taint);
            throw var85E786FB40E8A812D6BA58B12716CB8A_1170382809;
        } //End block
        if(end - start > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1788228624 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1788228624.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1788228624;
        } //End block
for(int i = start;i < end;i++)
        {
            put(str.charAt(i));
        } //End block
CharBuffer var72A74007B2BE62B849F475C7BDA4658B_184787133 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_184787133.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_184787133;
        // ---------- Original Method ----------
        //if (start < 0 || end < start || end > str.length()) {
            //throw new IndexOutOfBoundsException("str.length()=" + str.length() +
                    //", start=" + start + ", end=" + end);
        //}
        //if (end - start > remaining()) {
            //throw new BufferOverflowException();
        //}
        //for (int i = start; i < end; i++) {
            //put(str.charAt(i));
        //}
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract CharBuffer slice();

    
    @DSModeled(DSC.SAFE)
    public abstract CharSequence subSequence(int start, int end);

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.350 -0400", hash_original_method = "7C6B898DBE310393A5687B676A637050", hash_generated_method = "B8515CAB401AFC924057D3AB32607EEC")
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(limit - position);
for(int i = position;i < limit;i++)
        {
            result.append(get(i));
        } //End block
String varE65B3A02759122992CB82C0E651AD408_1138615381 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_1138615381.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_1138615381;
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder(limit - position);
        //for (int i = position; i < limit; i++) {
            //result.append(get(i));
        //}
        //return result.toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.350 -0400", hash_original_method = "B2B921133AE3BAD544E239EA4D0BB16C", hash_generated_method = "7FEE7DF9EF0DE824F605D2054178655B")
    public CharBuffer append(char c) {
        addTaint(c);
CharBuffer var2B6273DE4DE54F57140B73EE93BBE5BC_1581357939 =         put(c);
        var2B6273DE4DE54F57140B73EE93BBE5BC_1581357939.addTaint(taint);
        return var2B6273DE4DE54F57140B73EE93BBE5BC_1581357939;
        // ---------- Original Method ----------
        //return put(c);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.350 -0400", hash_original_method = "832DE990D6C4F53D8F1E55F3872916C2", hash_generated_method = "005F4782F31021462AFF278D401118EE")
    public CharBuffer append(CharSequence csq) {
        addTaint(csq.getTaint());
        if(csq != null)        
        {
CharBuffer var201AE26096F56A0C3091616FFDB02190_1100093094 =             put(csq.toString());
            var201AE26096F56A0C3091616FFDB02190_1100093094.addTaint(taint);
            return var201AE26096F56A0C3091616FFDB02190_1100093094;
        } //End block
CharBuffer var377E45898C2B390206A4ADB7EC4B7A33_1571861885 =         put("null");
        var377E45898C2B390206A4ADB7EC4B7A33_1571861885.addTaint(taint);
        return var377E45898C2B390206A4ADB7EC4B7A33_1571861885;
        // ---------- Original Method ----------
        //if (csq != null) {
            //return put(csq.toString());
        //}
        //return put("null");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.350 -0400", hash_original_method = "006D95454A8B407A6CE6A3881397CD6E", hash_generated_method = "D96FA03359C682DEC878076585178D7B")
    public CharBuffer append(CharSequence csq, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(csq.getTaint());
        if(csq == null)        
        {
            csq = "null";
        } //End block
        CharSequence cs = csq.subSequence(start, end);
        if(cs.length() > 0)        
        {
CharBuffer var67C6B63C38225F64455A2BCE48BC6CA7_196663998 =             put(cs.toString());
            var67C6B63C38225F64455A2BCE48BC6CA7_196663998.addTaint(taint);
            return var67C6B63C38225F64455A2BCE48BC6CA7_196663998;
        } //End block
CharBuffer var72A74007B2BE62B849F475C7BDA4658B_2125179719 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2125179719.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2125179719;
        // ---------- Original Method ----------
        //if (csq == null) {
            //csq = "null";
        //}
        //CharSequence cs = csq.subSequence(start, end);
        //if (cs.length() > 0) {
            //return put(cs.toString());
        //}
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.351 -0400", hash_original_method = "412283507A99EDD12D2C7BFEC4EFD5FB", hash_generated_method = "C92AAEC1E587E1B305F1FD48A184D4F1")
    public int read(CharBuffer target) throws IOException {
        addTaint(target.getTaint());
        int remaining = remaining();
        if(target == this)        
        {
            if(remaining == 0)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_1033204555 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1349066435 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1349066435;
            } //End block
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_573308269 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_573308269.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_573308269;
        } //End block
        if(remaining == 0)        
        {
            int varEDED0BA610ADD42446DF1159D678D6EF_1143799141 = (limit > 0 && target.remaining() == 0 ? 0 : -1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1283563920 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1283563920;
        } //End block
        remaining = Math.min(target.remaining(), remaining);
        if(remaining > 0)        
        {
            char[] chars = new char[remaining];
            get(chars);
            target.put(chars);
        } //End block
        int var2626772C17D90CF46BE4FE981FF30AC8_1284045805 = (remaining);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_309199013 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_309199013;
        // ---------- Original Method ----------
        //int remaining = remaining();
        //if (target == this) {
            //if (remaining == 0) {
                //return -1;
            //}
            //throw new IllegalArgumentException();
        //}
        //if (remaining == 0) {
            //return limit > 0 && target.remaining() == 0 ? 0 : -1;
        //}
        //remaining = Math.min(target.remaining(), remaining);
        //if (remaining > 0) {
            //char[] chars = new char[remaining];
            //get(chars);
            //target.put(chars);
        //}
        //return remaining;
    }

    
}

