package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.util.Arrays;

public abstract class CharBuffer extends Buffer implements Comparable<CharBuffer>, CharSequence, Appendable, Readable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.029 -0400", hash_original_method = "295C6F316A1C76C71107A06FE21F48B5", hash_generated_method = "856FDA6EDC6BF7740B409AA337EC184E")
      CharBuffer(int capacity) {
        super(1, capacity, null);
        addTaint(capacity);
        
    }

    
        public static CharBuffer allocate(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        return new ReadWriteCharArrayBuffer(capacity);
    }

    
        public static CharBuffer wrap(char[] array) {
        return wrap(array, 0, array.length);
    }

    
        public static CharBuffer wrap(char[] array, int start, int charCount) {
        Arrays.checkOffsetAndCount(array.length, start, charCount);
        CharBuffer buf = new ReadWriteCharArrayBuffer(array);
        buf.position = start;
        buf.limit = start + charCount;
        return buf;
    }

    
        public static CharBuffer wrap(CharSequence chseq) {
        return new CharSequenceAdapter(chseq);
    }

    
        public static CharBuffer wrap(CharSequence cs, int start, int end) {
        if (start < 0 || end < start || end > cs.length()) {
            throw new IndexOutOfBoundsException("cs.length()=" + cs.length() + ", start=" + start + ", end=" + end);
        }
        CharBuffer result = new CharSequenceAdapter(cs);
        result.position = start;
        result.limit = end;
        return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.031 -0400", hash_original_method = "B8788BC8872EF40BE08078E90206AB2A", hash_generated_method = "C556BA11D933EB04FC826CC717F06F65")
    public final char[] array() {
        char[] var68B89E48382A0AA51B25AC59599E2EB0_971712007 = (protectedArray());
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_1228575567 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1228575567;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.031 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "A1D0D900032B6AC1415AE46AA066C8A7")
    public final int arrayOffset() {
        int var0B794CE56A38A9F3BFDD2D53E83BB109_1972938741 = (protectedArrayOffset());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1819094323 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1819094323;
        
        
    }

    
    public abstract CharBuffer asReadOnlyBuffer();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.032 -0400", hash_original_method = "064ED2665DC7B0A0ED1B4C93428755B4", hash_generated_method = "35A15D5476DF69EC862A9AC00C9CFE45")
    public final char charAt(int index) {
        addTaint(index);
    if(index < 0 || index >= remaining())        
        {
            IndexOutOfBoundsException var7EDBAAD1EBDE2B517419CD574EFB00C6_1292738425 = new IndexOutOfBoundsException("index=" + index + ", remaining()=" + remaining());
            var7EDBAAD1EBDE2B517419CD574EFB00C6_1292738425.addTaint(taint);
            throw var7EDBAAD1EBDE2B517419CD574EFB00C6_1292738425;
        } 
        char var2571BF635708C79B1D5368209BC3ED18_1913521877 = (get(position + index));
                char varA87DEB01C5F539E6BDA34829C8EF2368_1011514352 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1011514352;
        
        
            
        
        
    }

    
    public abstract CharBuffer compact();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.033 -0400", hash_original_method = "726E488C44BA42D1E85B63DB9E089EB1", hash_generated_method = "1C25360B55B81B360FEC93404958C66B")
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
                int var0D4D283E60262FF52C1A7D956005837E_990346904 = (thisByte < otherByte ? -1 : 1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_325052673 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_325052673;
            } 
            thisPos++;
            otherPos++;
            compareRemaining--;
        } 
        int var1DC167191FBC7DAD3BADAE830552C692_285991551 = (remaining() - otherBuffer.remaining());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1816828682 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1816828682;
        
        
                
        
        
        
        
            
            
            
                
            
            
            
            
        
        
    }

    
    public abstract CharBuffer duplicate();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.034 -0400", hash_original_method = "43FFCFC26BAE21B80C74493A78B534C8", hash_generated_method = "9F7AFF06F455074CCC1EBA04F54E69ED")
    @Override
    public boolean equals(Object other) {
        addTaint(other.getTaint());
    if(!(other instanceof CharBuffer))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1767170693 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_343242812 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_343242812;
        } 
        CharBuffer otherBuffer = (CharBuffer) other;
    if(remaining() != otherBuffer.remaining())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1032282056 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1760787919 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1760787919;
        } 
        int myPosition = position;
        int otherPosition = otherBuffer.position;
        boolean equalSoFar = true;
        while
(equalSoFar && (myPosition < limit))        
        {
            equalSoFar = get(myPosition++) == otherBuffer.get(otherPosition++);
        } 
        boolean var4A97EF18B93B276118DD50585250A586_1912201156 = (equalSoFar);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1775949991 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1775949991;
        
        
            
        
        
        
            
        
        
        
        
        
            
        
        
    }

    
    public abstract char get();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.035 -0400", hash_original_method = "CCEA164926296D5352A245D12A0C46F5", hash_generated_method = "1057D239B25B57720C418E516F62596D")
    public CharBuffer get(char[] dst) {
        addTaint(dst[0]);
CharBuffer varAF8F268F60258FE30F192DE78F11CD4A_641140830 =         get(dst, 0, dst.length);
        varAF8F268F60258FE30F192DE78F11CD4A_641140830.addTaint(taint);
        return varAF8F268F60258FE30F192DE78F11CD4A_641140830;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.035 -0400", hash_original_method = "098FD190C217FD14B547D1BC38021C90", hash_generated_method = "036A3E77CFC751C3F89966A084F06F0E")
    public CharBuffer get(char[] dst, int dstOffset, int charCount) {
        addTaint(charCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        Arrays.checkOffsetAndCount(dst.length, dstOffset, charCount);
    if(charCount > remaining())        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_558778582 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_558778582.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_558778582;
        } 
for(int i = dstOffset;i < dstOffset + charCount;++i)
        {
            dst[i] = get();
        } 
CharBuffer var72A74007B2BE62B849F475C7BDA4658B_2015378192 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2015378192.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2015378192;
        
        
        
            
        
        
            
        
        
    }

    
    public abstract char get(int index);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.036 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "49813ADB2659F4A7CA4F6B493B3205D0")
    public final boolean hasArray() {
        boolean var55B7C03E3C1EBABD22606AD17EE923C3_1151675970 = (protectedHasArray());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_28627833 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_28627833;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.036 -0400", hash_original_method = "371FAD0CF0C9AC8E78075F4EA52336BD", hash_generated_method = "081A4FA50A7E03D847A11FC613567C56")
    @Override
    public int hashCode() {
        int myPosition = position;
        int hash = 0;
        while
(myPosition < limit)        
        {
            hash = hash + get(myPosition++);
        } 
        int var0800FC577294C34E0B28AD2839435945_841973324 = (hash);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_852303178 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_852303178;
        
        
        
        
            
        
        
    }

    
    public abstract boolean isDirect();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.037 -0400", hash_original_method = "C49AE9EB347B20902074CA3EBA57FA96", hash_generated_method = "5F22B47C511C302B703F32E6662C96F8")
    public final int length() {
        int varDDC5A90D80216ADD8FAE07957BE5782C_2109468281 = (remaining());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_497536101 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_497536101;
        
        
    }

    
    public abstract ByteOrder order();

    
    abstract char[] protectedArray();

    
    abstract int protectedArrayOffset();

    
    abstract boolean protectedHasArray();

    
    public abstract CharBuffer put(char c);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.038 -0400", hash_original_method = "470B54D034ECB079323054E5FA7FB003", hash_generated_method = "F3649F06D8A8A015CF0DBB5836DB4904")
    public final CharBuffer put(char[] src) {
        addTaint(src[0]);
CharBuffer var7D505613BED257805463C43ADCB4DBAD_946973252 =         put(src, 0, src.length);
        var7D505613BED257805463C43ADCB4DBAD_946973252.addTaint(taint);
        return var7D505613BED257805463C43ADCB4DBAD_946973252;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.039 -0400", hash_original_method = "022BE284F152CDC3C1FB1410D39A7C9D", hash_generated_method = "F5B1DD80A728D5F1296920C3C51058E9")
    public CharBuffer put(char[] src, int srcOffset, int charCount) {
        addTaint(charCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        Arrays.checkOffsetAndCount(src.length, srcOffset, charCount);
    if(charCount > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_992963369 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_992963369.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_992963369;
        } 
for(int i = srcOffset;i < srcOffset + charCount;++i)
        {
            put(src[i]);
        } 
CharBuffer var72A74007B2BE62B849F475C7BDA4658B_1327837837 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1327837837.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1327837837;
        
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.039 -0400", hash_original_method = "37C3423DFAF6E5EC51AB38006AB488BA", hash_generated_method = "A7497C385FF2662792DB57C8598A7A37")
    public CharBuffer put(CharBuffer src) {
        addTaint(src.getTaint());
    if(src == this)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1442664828 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1442664828.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1442664828;
        } 
    if(src.remaining() > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_29797350 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_29797350.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_29797350;
        } 
        char[] contents = new char[src.remaining()];
        src.get(contents);
        put(contents);
CharBuffer var72A74007B2BE62B849F475C7BDA4658B_1283654747 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1283654747.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1283654747;
        
        
            
        
        
            
        
        
        
        
        
    }

    
    public abstract CharBuffer put(int index, char c);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.040 -0400", hash_original_method = "E7006B831E6768B620311924466DB7A4", hash_generated_method = "7A01C777B04E2767F01554FE5287C565")
    public final CharBuffer put(String str) {
        addTaint(str.getTaint());
CharBuffer var80E016D18018A9A6110F6C1B5F9ADE1F_42397603 =         put(str, 0, str.length());
        var80E016D18018A9A6110F6C1B5F9ADE1F_42397603.addTaint(taint);
        return var80E016D18018A9A6110F6C1B5F9ADE1F_42397603;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.041 -0400", hash_original_method = "D2CD34EAF4E6074C289823E8F75291E2", hash_generated_method = "A50E3E90CED92E8DC6EC5925DCA763FD")
    public CharBuffer put(String str, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(str.getTaint());
    if(start < 0 || end < start || end > str.length())        
        {
            IndexOutOfBoundsException var85E786FB40E8A812D6BA58B12716CB8A_83156081 = new IndexOutOfBoundsException("str.length()=" + str.length() +
                    ", start=" + start + ", end=" + end);
            var85E786FB40E8A812D6BA58B12716CB8A_83156081.addTaint(taint);
            throw var85E786FB40E8A812D6BA58B12716CB8A_83156081;
        } 
    if(end - start > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_298062260 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_298062260.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_298062260;
        } 
for(int i = start;i < end;i++)
        {
            put(str.charAt(i));
        } 
CharBuffer var72A74007B2BE62B849F475C7BDA4658B_1824936176 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1824936176.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1824936176;
        
        
            
                    
        
        
            
        
        
            
        
        
    }

    
    public abstract CharBuffer slice();

    
    public abstract CharSequence subSequence(int start, int end);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.041 -0400", hash_original_method = "7C6B898DBE310393A5687B676A637050", hash_generated_method = "9D9CB02E837C5D31A4C8F974931E6ED5")
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(limit - position);
for(int i = position;i < limit;i++)
        {
            result.append(get(i));
        } 
String varE65B3A02759122992CB82C0E651AD408_487963075 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_487963075.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_487963075;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.042 -0400", hash_original_method = "B2B921133AE3BAD544E239EA4D0BB16C", hash_generated_method = "5A666748225BA15C01872E723A708592")
    public CharBuffer append(char c) {
        addTaint(c);
CharBuffer var2B6273DE4DE54F57140B73EE93BBE5BC_866986772 =         put(c);
        var2B6273DE4DE54F57140B73EE93BBE5BC_866986772.addTaint(taint);
        return var2B6273DE4DE54F57140B73EE93BBE5BC_866986772;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.042 -0400", hash_original_method = "832DE990D6C4F53D8F1E55F3872916C2", hash_generated_method = "790ACC0EB43D425137B9E6DE7B43AD07")
    public CharBuffer append(CharSequence csq) {
        addTaint(csq.getTaint());
    if(csq != null)        
        {
CharBuffer var201AE26096F56A0C3091616FFDB02190_314568755 =             put(csq.toString());
            var201AE26096F56A0C3091616FFDB02190_314568755.addTaint(taint);
            return var201AE26096F56A0C3091616FFDB02190_314568755;
        } 
CharBuffer var377E45898C2B390206A4ADB7EC4B7A33_915357448 =         put("null");
        var377E45898C2B390206A4ADB7EC4B7A33_915357448.addTaint(taint);
        return var377E45898C2B390206A4ADB7EC4B7A33_915357448;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.043 -0400", hash_original_method = "006D95454A8B407A6CE6A3881397CD6E", hash_generated_method = "139EC74C28643645C8EA4F2F23373AB0")
    public CharBuffer append(CharSequence csq, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(csq.getTaint());
    if(csq == null)        
        {
            csq = "null";
        } 
        CharSequence cs = csq.subSequence(start, end);
    if(cs.length() > 0)        
        {
CharBuffer var67C6B63C38225F64455A2BCE48BC6CA7_45659774 =             put(cs.toString());
            var67C6B63C38225F64455A2BCE48BC6CA7_45659774.addTaint(taint);
            return var67C6B63C38225F64455A2BCE48BC6CA7_45659774;
        } 
CharBuffer var72A74007B2BE62B849F475C7BDA4658B_1813076640 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1813076640.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1813076640;
        
        
            
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.044 -0400", hash_original_method = "412283507A99EDD12D2C7BFEC4EFD5FB", hash_generated_method = "00B39CD4E9600D210BE99DA02C72A1A8")
    public int read(CharBuffer target) throws IOException {
        addTaint(target.getTaint());
        int remaining = remaining();
    if(target == this)        
        {
    if(remaining == 0)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_273421039 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1159668330 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1159668330;
            } 
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_397528353 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_397528353.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_397528353;
        } 
    if(remaining == 0)        
        {
            int varEDED0BA610ADD42446DF1159D678D6EF_358812224 = (limit > 0 && target.remaining() == 0 ? 0 : -1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_546839393 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_546839393;
        } 
        remaining = Math.min(target.remaining(), remaining);
    if(remaining > 0)        
        {
            char[] chars = new char[remaining];
            get(chars);
            target.put(chars);
        } 
        int var2626772C17D90CF46BE4FE981FF30AC8_1827344057 = (remaining);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_697553905 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_697553905;
        
        
        
            
                
            
            
        
        
            
        
        
        
            
            
            
        
        
    }

    
}

