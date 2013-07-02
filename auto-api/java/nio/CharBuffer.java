package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.util.Arrays;

public abstract class CharBuffer extends Buffer implements Comparable<CharBuffer>, CharSequence, Appendable, Readable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.904 -0400", hash_original_method = "295C6F316A1C76C71107A06FE21F48B5", hash_generated_method = "856FDA6EDC6BF7740B409AA337EC184E")
      CharBuffer(int capacity) {
        super(1, capacity, null);
        addTaint(capacity);
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.906 -0400", hash_original_method = "B8788BC8872EF40BE08078E90206AB2A", hash_generated_method = "0BEB009AA0C8E828F48521967C063A14")
    public final char[] array() {
        char[] varEA57FBC16B997AC0E679F048893AC79C_252980272 = (protectedArray());
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_532967914 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_532967914;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.906 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "C7A96EACB91FA992090CCF7767279F55")
    public final int arrayOffset() {
        int var457EDFAA982472962568D68CBF588B38_30163827 = (protectedArrayOffset());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1220228336 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1220228336;
        
        
    }

    
    public abstract CharBuffer asReadOnlyBuffer();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.906 -0400", hash_original_method = "064ED2665DC7B0A0ED1B4C93428755B4", hash_generated_method = "1D4AEAF1118F233EE760DEFCD688A8DA")
    public final char charAt(int index) {
        {
            boolean var4ECF37DCE46CD97026588B8CEB8EE405_1850178419 = (index < 0 || index >= remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("index=" + index + ", remaining()=" + remaining());
            } 
        } 
        char varC2865EDF4A02BF97D1DEE96A531B3DC7_1102413255 = (get(position + index));
        addTaint(index);
        char varA87DEB01C5F539E6BDA34829C8EF2368_346608643 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_346608643;
        
        
            
        
        
    }

    
    public abstract CharBuffer compact();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.908 -0400", hash_original_method = "726E488C44BA42D1E85B63DB9E089EB1", hash_generated_method = "5D8E3FE6AE608EDC6CB4700138FEFD6D")
    public int compareTo(CharBuffer otherBuffer) {
        int compareRemaining;
        boolean var4BCBF0874E5D33E29652A3CCB2245276_78790726 = ((remaining() < otherBuffer.remaining()));
        compareRemaining = remaining();
        compareRemaining = otherBuffer.remaining();
        int thisPos = position;
        int otherPos = otherBuffer.position;
        char thisByte;
        char otherByte;
        {
            thisByte = get(thisPos);
            otherByte = otherBuffer.get(otherPos);
        } 
        int var51CE6C8A0A6AF44D4BCA06BE06554AF8_627385256 = (remaining() - otherBuffer.remaining());
        addTaint(otherBuffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1632285900 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1632285900;
        
        
                
        
        
        
        
            
            
            
                
            
            
            
            
        
        
    }

    
    public abstract CharBuffer duplicate();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.909 -0400", hash_original_method = "43FFCFC26BAE21B80C74493A78B534C8", hash_generated_method = "B485DAD7A1899046A02FBBE4FEA7AFE7")
    @Override
    public boolean equals(Object other) {
        CharBuffer otherBuffer = (CharBuffer) other;
        {
            boolean var0A43D7921CE313B818348D8F01F0C8D5_721105783 = (remaining() != otherBuffer.remaining());
        } 
        int myPosition = position;
        int otherPosition = otherBuffer.position;
        boolean equalSoFar = true;
        {
            equalSoFar = get(myPosition++) == otherBuffer.get(otherPosition++);
        } 
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1112660287 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1112660287;
        
        
            
        
        
        
            
        
        
        
        
        
            
        
        
    }

    
    public abstract char get();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.909 -0400", hash_original_method = "CCEA164926296D5352A245D12A0C46F5", hash_generated_method = "4A007CF744A11CEC6E46C04BD552E4BF")
    public CharBuffer get(char[] dst) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_814465193 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_814465193 = get(dst, 0, dst.length);
        addTaint(dst[0]);
        varB4EAC82CA7396A68D541C85D26508E83_814465193.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_814465193;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.910 -0400", hash_original_method = "098FD190C217FD14B547D1BC38021C90", hash_generated_method = "A81C70F6C2B6B4F4B4A1837B6E7D9B2F")
    public CharBuffer get(char[] dst, int dstOffset, int charCount) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_38822272 = null; 
        Arrays.checkOffsetAndCount(dst.length, dstOffset, charCount);
        {
            boolean varD6CE167C3592D038C7B14F59C84C4F0D_332586242 = (charCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
            } 
        } 
        {
            int i = dstOffset;
            {
                dst[i] = get();
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_38822272 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(charCount);
        varB4EAC82CA7396A68D541C85D26508E83_38822272.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_38822272;
        
        
        
            
        
        
            
        
        
    }

    
    public abstract char get(int index);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.911 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "267E95C46B399E560B68A09003C23361")
    public final boolean hasArray() {
        boolean varADF219B8DAB0ACF2FCC593A6A216A7F8_914808841 = (protectedHasArray());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1448449743 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1448449743;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.911 -0400", hash_original_method = "371FAD0CF0C9AC8E78075F4EA52336BD", hash_generated_method = "51D20CD66ADC1014E6D9BEC8B940C7F4")
    @Override
    public int hashCode() {
        int myPosition = position;
        int hash = 0;
        {
            hash = hash + get(myPosition++);
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_638115079 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_638115079;
        
        
        
        
            
        
        
    }

    
    public abstract boolean isDirect();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.911 -0400", hash_original_method = "C49AE9EB347B20902074CA3EBA57FA96", hash_generated_method = "42FB7CB620AA47DB9989B292E1BE66D8")
    public final int length() {
        int var5DBBE6ED518DFC3A55716B7433B673CB_143778520 = (remaining());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2000138649 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2000138649;
        
        
    }

    
    public abstract ByteOrder order();

    
    abstract char[] protectedArray();

    
    abstract int protectedArrayOffset();

    
    abstract boolean protectedHasArray();

    
    public abstract CharBuffer put(char c);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.912 -0400", hash_original_method = "470B54D034ECB079323054E5FA7FB003", hash_generated_method = "68F24842822690B611809D32D05C934F")
    public final CharBuffer put(char[] src) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_340128411 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_340128411 = put(src, 0, src.length);
        addTaint(src[0]);
        varB4EAC82CA7396A68D541C85D26508E83_340128411.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_340128411;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.913 -0400", hash_original_method = "022BE284F152CDC3C1FB1410D39A7C9D", hash_generated_method = "0FD09E32C9DB3CACA498167651B3FF11")
    public CharBuffer put(char[] src, int srcOffset, int charCount) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1485298181 = null; 
        Arrays.checkOffsetAndCount(src.length, srcOffset, charCount);
        {
            boolean varD6CE167C3592D038C7B14F59C84C4F0D_672762963 = (charCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } 
        } 
        {
            int i = srcOffset;
            {
                put(src[i]);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1485298181 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(charCount);
        varB4EAC82CA7396A68D541C85D26508E83_1485298181.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1485298181;
        
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.914 -0400", hash_original_method = "37C3423DFAF6E5EC51AB38006AB488BA", hash_generated_method = "8B491E008B760E5C0E7253688566B14B")
    public CharBuffer put(CharBuffer src) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_905141856 = null; 
        {
            boolean var9C07FD71E9483B067CE073F58225A0C4_1146880975 = (src == this);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } 
        } 
        {
            boolean var6E2E81EBCD4D9A6ACDDC12CE61513AA8_1818473319 = (src.remaining() > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } 
        } 
        char[] contents = new char[src.remaining()];
        src.get(contents);
        put(contents);
        varB4EAC82CA7396A68D541C85D26508E83_905141856 = this;
        addTaint(src.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_905141856.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_905141856;
        
        
            
        
        
            
        
        
        
        
        
    }

    
    public abstract CharBuffer put(int index, char c);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.914 -0400", hash_original_method = "E7006B831E6768B620311924466DB7A4", hash_generated_method = "6B14802523617D209B9440F075B9B90B")
    public final CharBuffer put(String str) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1556692815 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1556692815 = put(str, 0, str.length());
        addTaint(str.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1556692815.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1556692815;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.915 -0400", hash_original_method = "D2CD34EAF4E6074C289823E8F75291E2", hash_generated_method = "26EFAC6DBDC77FF19467B1F4CA07E6E5")
    public CharBuffer put(String str, int start, int end) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_32912411 = null; 
        {
            boolean varAA8B509CC93457664907255BA5D18238_561451451 = (start < 0 || end < start || end > str.length());
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("str.length()=" + str.length() +
                    ", start=" + start + ", end=" + end);
            } 
        } 
        {
            boolean var844D30051199F41003AA89FFC0C4F8E0_1119078257 = (end - start > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } 
        } 
        {
            int i = start;
            {
                put(str.charAt(i));
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_32912411 = this;
        addTaint(str.getTaint());
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_32912411.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_32912411;
        
        
            
                    
        
        
            
        
        
            
        
        
    }

    
    public abstract CharBuffer slice();

    
    public abstract CharSequence subSequence(int start, int end);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.916 -0400", hash_original_method = "7C6B898DBE310393A5687B676A637050", hash_generated_method = "47C0BA9B5919C3851314E8710989E378")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2083665711 = null; 
        StringBuilder result = new StringBuilder(limit - position);
        {
            int i = position;
            {
                result.append(get(i));
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2083665711 = result.toString();
        varB4EAC82CA7396A68D541C85D26508E83_2083665711.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2083665711;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.916 -0400", hash_original_method = "B2B921133AE3BAD544E239EA4D0BB16C", hash_generated_method = "D137C1E41FF13D036AAA3A207B685FA7")
    public CharBuffer append(char c) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_507384432 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_507384432 = put(c);
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_507384432.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_507384432;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.917 -0400", hash_original_method = "832DE990D6C4F53D8F1E55F3872916C2", hash_generated_method = "F8C667CF04AEB610BD366408A20F076C")
    public CharBuffer append(CharSequence csq) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1161689312 = null; 
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1685018145 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1161689312 = put(csq.toString());
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1685018145 = put("null");
        addTaint(csq.getTaint());
        CharBuffer varA7E53CE21691AB073D9660D615818899_898560495; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_898560495 = varB4EAC82CA7396A68D541C85D26508E83_1161689312;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_898560495 = varB4EAC82CA7396A68D541C85D26508E83_1685018145;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_898560495.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_898560495;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.918 -0400", hash_original_method = "006D95454A8B407A6CE6A3881397CD6E", hash_generated_method = "61CE3F79FD9DAA06CD3C05C187847499")
    public CharBuffer append(CharSequence csq, int start, int end) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1892268085 = null; 
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_489210061 = null; 
        {
            csq = "null";
        } 
        CharSequence cs = csq.subSequence(start, end);
        {
            boolean varB311465800DC0596CEA6EA9DA57DCEE0_1228637733 = (cs.length() > 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1892268085 = put(cs.toString());
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_489210061 = this;
        addTaint(csq.getTaint());
        addTaint(start);
        addTaint(end);
        CharBuffer varA7E53CE21691AB073D9660D615818899_1376115389; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1376115389 = varB4EAC82CA7396A68D541C85D26508E83_1892268085;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1376115389 = varB4EAC82CA7396A68D541C85D26508E83_489210061;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1376115389.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1376115389;
        
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.921 -0400", hash_original_method = "412283507A99EDD12D2C7BFEC4EFD5FB", hash_generated_method = "6DF1D85A9A92BB603D20D8F456B7A0C4")
    public int read(CharBuffer target) throws IOException {
        int remaining = remaining();
        {
            boolean var47D0651F82DAAD38F2B0DC43BE2747A5_65462265 = (target == this);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } 
        } 
        {
            {
                boolean var19F2B3013B13D8C68161600448C63B08_1288678926 = (limit > 0 && target.remaining() == 0);
            } 
        } 
        remaining = Math.min(target.remaining(), remaining);
        {
            char[] chars = new char[remaining];
            get(chars);
            target.put(chars);
        } 
        addTaint(target.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_87959558 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_87959558;
        
        
        
            
                
            
            
        
        
            
        
        
        
            
            
            
        
        
    }

    
}

