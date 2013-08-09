package java.lang;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.Charsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Formatter;
import java.util.Locale;
import java.util.regex.Pattern;

import libcore.util.EmptyArray;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class String implements Serializable, Comparable<String>, CharSequence {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.792 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "C068225E28B5BE74066BE5338158F76B")

    private char[] value;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.792 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "EA4C80BAC452228E60AC0DA2D3E0C953")

    private int offset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.792 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "82CC849FCF58347832EA6BB917282DBE")

    private int count;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.792 -0400", hash_original_field = "550D1CC054A1B23A411DDDA46FD64811", hash_generated_field = "38607001336EF9DE010EF92F750652A2")

    private int hashCode;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.792 -0400", hash_original_method = "F65E96A775698E2C256BB1E903F5D8A6", hash_generated_method = "B4FE7A30CB86B25991ECB034EA74BE0F")
    public  String() {
        value = EmptyArray.CHAR;
        offset = 0;
        count = 0;
        // ---------- Original Method ----------
        //value = EmptyArray.CHAR;
        //offset = 0;
        //count = 0;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.792 -0400", hash_original_method = "8A258D0AF74DE6E118252D0EA5531366", hash_generated_method = "A11432EA568E66AD1DE5D8C05C5AB870")
    @SuppressWarnings("unused")
    private  String(String s, char c) {
        offset = 0;
        value = new char[s.count + 1];
        count = s.count + 1;
        System.arraycopy(s.value, s.offset, value, 0, s.count);
        value[s.count] = c;
        // ---------- Original Method ----------
        //offset = 0;
        //value = new char[s.count + 1];
        //count = s.count + 1;
        //System.arraycopy(s.value, s.offset, value, 0, s.count);
        //value[s.count] = c;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.792 -0400", hash_original_method = "3CF6472F1EAFF36B200903831BC9D282", hash_generated_method = "4D4C07B858AC27A3595A4F1ED164415E")
    public  String(byte[] data) {
        this(data, 0, data.length);
        addTaint(data[0]);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.792 -0400", hash_original_method = "94FE9BFA8A903BE49DF8F4E82A84C713", hash_generated_method = "96F2149D8F428069C3C87AA58538065E")
    @Deprecated
    public  String(byte[] data, int high) {
        this(data, high, 0, data.length);
        addTaint(high);
        addTaint(data[0]);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.652 -0400", hash_original_method = "9C5B9D3903B08C7F386C9C307D28A8D8", hash_generated_method = "D6439CB90D6545AC7AC3C86073E9F0E9")
    public  String(byte[] data, int offset, int byteCount) {
        addTaint(byteCount);
        addTaint(data[0]);
    if((offset | byteCount) < 0 || byteCount > data.length - offset)        
        {
            StringIndexOutOfBoundsException var418E2BA1E64B83D51B250BCD9933A252_948252395 = failedBoundsCheck(data.length, offset, byteCount);
            var418E2BA1E64B83D51B250BCD9933A252_948252395.addTaint(taint);
            throw var418E2BA1E64B83D51B250BCD9933A252_948252395;
        } //End block
        CharBuffer cb = Charset.defaultCharset().decode(ByteBuffer.wrap(data, offset, byteCount));
        this.count = cb.length();
        this.offset = 0;
    if(count > 0)        
        {
            value = cb.array();
        } //End block
        else
        {
            value = EmptyArray.CHAR;
        } //End block
        // ---------- Original Method ----------
        //if ((offset | byteCount) < 0 || byteCount > data.length - offset) {
            //throw failedBoundsCheck(data.length, offset, byteCount);
        //}
        //CharBuffer cb = Charset.defaultCharset().decode(ByteBuffer.wrap(data, offset, byteCount));
        //this.count = cb.length();
        //this.offset = 0;
        //if (count > 0) {
            //value = cb.array();
        //} else {
            //value = EmptyArray.CHAR;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.695 -0400", hash_original_method = "22A6AFB2E643FB23D243CAF5D019E325", hash_generated_method = "79A975FB90AD0ECD193D044E40A8EEB8")
    @Deprecated
    public  String(byte[] data, int high, int offset, int byteCount) {
    if((offset | byteCount) < 0 || byteCount > data.length - offset)        
        {
    		StringIndexOutOfBoundsException var418E2BA1E64B83D51B250BCD9933A252_1421954499 = failedBoundsCheck(data.length, offset, byteCount);
            var418E2BA1E64B83D51B250BCD9933A252_1421954499.addTaint(taint);
            throw var418E2BA1E64B83D51B250BCD9933A252_1421954499;
        } //End block
        this.offset = 0;
        this.value = new char[byteCount];
        this.count = byteCount;
        high <<= 8;
for(int i = 0;i < count;i++)
        {
            value[i] = (char) (high + (data[offset++] & 0xff));
        } //End block
        // ---------- Original Method ----------
        //if ((offset | byteCount) < 0 || byteCount > data.length - offset) {
            //throw failedBoundsCheck(data.length, offset, byteCount);
        //}
        //this.offset = 0;
        //this.value = new char[byteCount];
        //this.count = byteCount;
        //high <<= 8;
        //for (int i = 0; i < count; i++) {
            //value[i] = (char) (high + (data[offset++] & 0xff));
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.807 -0400", hash_original_method = "D35F458D65648B05442A41C1A12F30CA", hash_generated_method = "3CEEE872B2C15AD5D826CC9768AE132D")
    public  String(byte[] data, int offset, int byteCount, String charsetName) throws UnsupportedEncodingException {
        this(data, offset, byteCount, Charset.forNameUEE(charsetName));
        addTaint(charsetName.getTaint());
        addTaint(byteCount);
        addTaint(offset);
        addTaint(data[0]);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.807 -0400", hash_original_method = "11FE032D0B0EBCDEFC4E4C2065489303", hash_generated_method = "E5BE82FCBB454F307F1387B9FE1B9C0E")
    public  String(byte[] data, String charsetName) throws UnsupportedEncodingException {
        this(data, 0, data.length, Charset.forNameUEE(charsetName));
        addTaint(charsetName.getTaint());
        addTaint(data[0]);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.813 -0400", hash_original_method = "230168F72CB2A0A48AA9F4A7AFCECA03", hash_generated_method = "5CF85473A930BD9609F6F58C62C97D46")
    public  String(byte[] data, int offset, int byteCount, Charset charset) {
        addTaint(charset.getTaint());
        addTaint(data[0]);
    if((offset | byteCount) < 0 || byteCount > data.length - offset)        
        {
    		StringIndexOutOfBoundsException var418E2BA1E64B83D51B250BCD9933A252_1070100322 = failedBoundsCheck(data.length, offset, byteCount);
            var418E2BA1E64B83D51B250BCD9933A252_1070100322.addTaint(taint);
            throw var418E2BA1E64B83D51B250BCD9933A252_1070100322;
        } //End block
        String canonicalCharsetName = charset.name();
    if(canonicalCharsetName.equals("UTF-8"))        
        {
            byte[] d = data;
            char[] v = new char[byteCount];
            int idx = offset;
            int last = offset + byteCount;
            int s = 0;
    outer            :
            while
(idx < last)            
            {
                byte b0 = d[idx++];
    if((b0 & 0x80) == 0)                
                {
                    int val = b0 & 0xff;
                    v[s++] = (char) val;
                } //End block
                else
    if(((b0 & 0xe0) == 0xc0) || ((b0 & 0xf0) == 0xe0) ||
                        ((b0 & 0xf8) == 0xf0) || ((b0 & 0xfc) == 0xf8) || ((b0 & 0xfe) == 0xfc))                
                {
                    int utfCount = 1;
    if((b0 & 0xf0) == 0xe0)                    
                    utfCount = 2;
                    else
    if((b0 & 0xf8) == 0xf0)                    
                    utfCount = 3;
                    else
    if((b0 & 0xfc) == 0xf8)                    
                    utfCount = 4;
                    else
    if((b0 & 0xfe) == 0xfc)                    
                    utfCount = 5;
    if(idx + utfCount > last)                    
                    {
                        v[s++] = REPLACEMENT_CHAR;
                        break;
                    } //End block
                    int val = b0 & (0x1f >> (utfCount - 1));
for(int i = 0;i < utfCount;i++)
                    {
                        byte b = d[idx++];
    if((b & 0xC0) != 0x80)                        
                        {
                            v[s++] = REPLACEMENT_CHAR;
                            idx--;
                            continue outer;
                        } //End block
                        val <<= 6;
                        val |= b & 0x3f;
                    } //End block
    if((utfCount != 2) && (val >= 0xD800) && (val <= 0xDFFF))                    
                    {
                        v[s++] = REPLACEMENT_CHAR;
                        continue;
                    } //End block
    if(val > 0x10FFFF)                    
                    {
                        v[s++] = REPLACEMENT_CHAR;
                        continue;
                    } //End block
    if(val < 0x10000)                    
                    {
                        v[s++] = (char) val;
                    } //End block
                    else
                    {
                        int x = val & 0xffff;
                        int u = (val >> 16) & 0x1f;
                        int w = (u - 1) & 0xffff;
                        int hi = 0xd800 | (w << 6) | (x >> 10);
                        int lo = 0xdc00 | (x & 0x3ff);
                        v[s++] = (char) hi;
                        v[s++] = (char) lo;
                    } //End block
                } //End block
                else
                {
                    v[s++] = REPLACEMENT_CHAR;
                } //End block
            } //End block
    if(s == byteCount)            
            {
                this.offset = 0;
                this.value = v;
                this.count = s;
            } //End block
            else
            {
                this.offset = 0;
                this.value = new char[s];
                this.count = s;
                System.arraycopy(v, 0, value, 0, s);
            } //End block
        } //End block
        else
    if(canonicalCharsetName.equals("ISO-8859-1"))        
        {
            this.offset = 0;
            this.value = new char[byteCount];
            this.count = byteCount;
            Charsets.isoLatin1BytesToChars(data, offset, byteCount, value);
        } //End block
        else
    if(canonicalCharsetName.equals("US-ASCII"))        
        {
            this.offset = 0;
            this.value = new char[byteCount];
            this.count = byteCount;
            Charsets.asciiBytesToChars(data, offset, byteCount, value);
        } //End block
        else
        {
            CharBuffer cb = charset.decode(ByteBuffer.wrap(data, offset, byteCount));
            this.offset = 0;
            this.count = cb.length();
    if(count > 0)            
            {
                this.value = new char[count];
                System.arraycopy(cb.array(), 0, value, 0, count);
            } //End block
            else
            {
                this.value = EmptyArray.CHAR;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.907 -0400", hash_original_method = "9D77FFE69AA84BF1048ED5CBD8EE386C", hash_generated_method = "6C134F8B1B500206BC50C4890F003080")
    public  String(byte[] data, Charset charset) {
        this(data, 0, data.length, charset);
        addTaint(charset.getTaint());
        addTaint(data[0]);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.907 -0400", hash_original_method = "84FF2A14EA759DC7C1F299809C55E832", hash_generated_method = "941AD48499B8A325EBF754DD62D23EFF")
    public  String(char[] data) {
        this(data, 0, data.length);
        addTaint(data[0]);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.828 -0400", hash_original_method = "14BFB40845511D49F067DB0E6AC711FE", hash_generated_method = "971E3234E4344BD64B6C546645470DD3")
    public  String(char[] data, int offset, int charCount) {
        addTaint(data[0]);
    if((offset | charCount) < 0 || charCount > data.length - offset)        
        {
    		StringIndexOutOfBoundsException var2D5E1C324B1811ED1BEE61F6C6CD87C2_678970883 = failedBoundsCheck(data.length, offset, charCount);
            var2D5E1C324B1811ED1BEE61F6C6CD87C2_678970883.addTaint(taint);
            throw var2D5E1C324B1811ED1BEE61F6C6CD87C2_678970883;
        } //End block
        this.offset = 0;
        this.value = new char[charCount];
        this.count = charCount;
        System.arraycopy(data, offset, value, 0, count);
        // ---------- Original Method ----------
        //if ((offset | charCount) < 0 || charCount > data.length - offset) {
            //throw failedBoundsCheck(data.length, offset, charCount);
        //}
        //this.offset = 0;
        //this.value = new char[charCount];
        //this.count = charCount;
        //System.arraycopy(data, offset, value, 0, count);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.918 -0400", hash_original_method = "6AA52B72AD5521C733ED3E9463435DD5", hash_generated_method = "99D51D061C47D5C074A83E94BF3BA236")
      String(int offset, int charCount, char[] chars) {
        this.value = chars;
        this.offset = offset;
        this.count = charCount;
        // ---------- Original Method ----------
        //this.value = chars;
        //this.offset = offset;
        //this.count = charCount;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.921 -0400", hash_original_method = "7D7AE898849737A5DE2F771028ADD293", hash_generated_method = "7FE6513FD8F04FE77BE3B65E244B762D")
    public  String(String toCopy) {
        value = (toCopy.value.length == toCopy.count)
                ? toCopy.value
                : Arrays.copyOfRange(toCopy.value, toCopy.offset, toCopy.offset + toCopy.length());
        offset = 0;
        count = value.length;
        // ---------- Original Method ----------
        //value = (toCopy.value.length == toCopy.count)
                //? toCopy.value
                //: Arrays.copyOfRange(toCopy.value, toCopy.offset, toCopy.offset + toCopy.length());
        //offset = 0;
        //count = value.length;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.923 -0400", hash_original_method = "8B59C74FD130D5556CE63A5F3CE74139", hash_generated_method = "08126433ED54CCD02F64DEF6C42B8545")
    @SuppressWarnings( { "unused", "nls" })
    private  String(String s1, String s2) {
        if(s1 == null)        
        {
            s1 = "null";
        } //End block
        if(s2 == null)        
        {
            s2 = "null";
        } //End block
        count = s1.count + s2.count;
        value = new char[count];
        offset = 0;
        System.arraycopy(s1.value, s1.offset, value, 0, s1.count);
        System.arraycopy(s2.value, s2.offset, value, s1.count, s2.count);
        // ---------- Original Method ----------
        //if (s1 == null) {
            //s1 = "null";
        //}
        //if (s2 == null) {
            //s2 = "null";
        //}
        //count = s1.count + s2.count;
        //value = new char[count];
        //offset = 0;
        //System.arraycopy(s1.value, s1.offset, value, 0, s1.count);
        //System.arraycopy(s2.value, s2.offset, value, s1.count, s2.count);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.926 -0400", hash_original_method = "E07460C3146BC4727C3E888CAC21772A", hash_generated_method = "73ACD6CE76E5E989647928EAA1950CB1")
    @SuppressWarnings( { "unused", "nls" })
    private  String(String s1, String s2, String s3) {
        if(s1 == null)        
        {
            s1 = "null";
        } //End block
        if(s2 == null)        
        {
            s2 = "null";
        } //End block
        if(s3 == null)        
        {
            s3 = "null";
        } //End block
        count = s1.count + s2.count + s3.count;
        value = new char[count];
        offset = 0;
        System.arraycopy(s1.value, s1.offset, value, 0, s1.count);
        System.arraycopy(s2.value, s2.offset, value, s1.count, s2.count);
        System.arraycopy(s3.value, s3.offset, value, s1.count + s2.count, s3.count);
        // ---------- Original Method ----------
        //if (s1 == null) {
            //s1 = "null";
        //}
        //if (s2 == null) {
            //s2 = "null";
        //}
        //if (s3 == null) {
            //s3 = "null";
        //}
        //count = s1.count + s2.count + s3.count;
        //value = new char[count];
        //offset = 0;
        //System.arraycopy(s1.value, s1.offset, value, 0, s1.count);
        //System.arraycopy(s2.value, s2.offset, value, s1.count, s2.count);
        //System.arraycopy(s3.value, s3.offset, value, s1.count + s2.count, s3.count);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.927 -0400", hash_original_method = "C3DEF5F256BD0FFA01404830FE1A0B0E", hash_generated_method = "9D73BD38C4E1C34F746D9E60AA5559EA")
    public  String(StringBuffer stringBuffer) {
        offset = 0;
        synchronized
(stringBuffer)        {
            value = stringBuffer.shareValue();
            count = stringBuffer.length();
        } //End block
        // ---------- Original Method ----------
        //offset = 0;
        //synchronized (stringBuffer) {
            //value = stringBuffer.shareValue();
            //count = stringBuffer.length();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.865 -0400", hash_original_method = "DE744DAB842D7A0BE4BC8C7648E27967", hash_generated_method = "A4716F806D0CB47D314F039D1EE5E331")
    public  String(int[] codePoints, int offset, int count) {
        addTaint(codePoints[0]);
    if(codePoints == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1224186338 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1224186338.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1224186338;
        } //End block
    if((offset | count) < 0 || count > codePoints.length - offset)        
        {
    		StringIndexOutOfBoundsException varA2C80B735EE8B9656E28477449237B7F_176723695 = failedBoundsCheck(codePoints.length, offset, count);
            varA2C80B735EE8B9656E28477449237B7F_176723695.addTaint(taint);
            throw varA2C80B735EE8B9656E28477449237B7F_176723695;
        } //End block
        this.offset = 0;
        this.value = new char[count * 2];
        int end = offset + count;
        int c = 0;
for(int i = offset;i < end;i++)
        {
            c += Character.toChars(codePoints[i], this.value, c);
        } //End block
        this.count = c;
        // ---------- Original Method ----------
        //if (codePoints == null) {
            //throw new NullPointerException();
        //}
        //if ((offset | count) < 0 || count > codePoints.length - offset) {
            //throw failedBoundsCheck(codePoints.length, offset, count);
        //}
        //this.offset = 0;
        //this.value = new char[count * 2];
        //int end = offset + count;
        //int c = 0;
        //for (int i = offset; i < end; i++) {
            //c += Character.toChars(codePoints[i], this.value, c);
        //}
        //this.count = c;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.943 -0400", hash_original_method = "1A43E0983F964C9F4090DA81181B802F", hash_generated_method = "A04CDE20EE449AD7D77C6060913CF95D")
    public  String(StringBuilder stringBuilder) {
        if(stringBuilder == null)        
        {
            NullPointerException var22BD5F599DD56650EFDED1601FFD0DC3_465719014 = new NullPointerException("stringBuilder == null");
            var22BD5F599DD56650EFDED1601FFD0DC3_465719014.addTaint(taint);
            throw var22BD5F599DD56650EFDED1601FFD0DC3_465719014;
        } //End block
        this.offset = 0;
        this.count = stringBuilder.length();
        this.value = new char[this.count];
        stringBuilder.getChars(0, this.count, this.value, 0);
        // ---------- Original Method ----------
        //if (stringBuilder == null) {
            //throw new NullPointerException("stringBuilder == null");
        //}
        //this.offset = 0;
        //this.count = stringBuilder.length();
        //this.value = new char[this.count];
        //stringBuilder.getChars(0, this.count, this.value, 0);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.946 -0400", hash_original_method = "8767608BAC25DDC267BEC70B13CF72A3", hash_generated_method = "23EDDAB7C39C6B71B48112C650C2BBBB")
    @SuppressWarnings("unused")
    private  String(String s1, int v1) {
        addTaint(v1);
        addTaint(s1.getTaint());
        if(s1 == null)        
        {
            s1 = "null";
        } //End block
        String s2 = String.valueOf(v1);
        int len = s1.count + s2.count;
        value = new char[len];
        offset = 0;
        System.arraycopy(s1.value, s1.offset, value, 0, s1.count);
        System.arraycopy(s2.value, s2.offset, value, s1.count, s2.count);
        count = len;
        // ---------- Original Method ----------
        //if (s1 == null) {
            //s1 = "null";
        //}
        //String s2 = String.valueOf(v1);
        //int len = s1.count + s2.count;
        //value = new char[len];
        //offset = 0;
        //System.arraycopy(s1.value, s1.offset, value, 0, s1.count);
        //System.arraycopy(s2.value, s2.offset, value, s1.count, s2.count);
        //count = len;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.947 -0400", hash_original_method = "87185450AF15BAF9DFFE5741D5928D9B", hash_generated_method = "8DEE937D6861FC95B4E7DAF9EA4CC9D1")
    public char charAt(int index) {
        char varA87DEB01C5F539E6BDA34829C8EF2368_2072945692 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_2072945692;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.947 -0400", hash_original_method = "00E4125D0AA58BE2E1232BB5FC2C4846", hash_generated_method = "F020748DDC5F8E883B209AB0EDF462FD")
    private StringIndexOutOfBoundsException indexAndLength(int index) {
        addTaint(index);
        StringIndexOutOfBoundsException var136F60598ADA7E3673E6817775EB8A33_957711953 = new StringIndexOutOfBoundsException(this, index);
        var136F60598ADA7E3673E6817775EB8A33_957711953.addTaint(taint);
        throw var136F60598ADA7E3673E6817775EB8A33_957711953;
        // ---------- Original Method ----------
        //throw new StringIndexOutOfBoundsException(this, index);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.948 -0400", hash_original_method = "C5BE1ED07127E02665146DD0ACED99A5", hash_generated_method = "94B09C20B0DE569BBF0E89074113E16A")
    private StringIndexOutOfBoundsException startEndAndLength(int start, int end) {
        addTaint(end);
        addTaint(start);
        StringIndexOutOfBoundsException varABD3BBDB2615D50CC54BA74D32A5E4F6_1319332645 = new StringIndexOutOfBoundsException(this, start, end - start);
        varABD3BBDB2615D50CC54BA74D32A5E4F6_1319332645.addTaint(taint);
        throw varABD3BBDB2615D50CC54BA74D32A5E4F6_1319332645;
        // ---------- Original Method ----------
        //throw new StringIndexOutOfBoundsException(this, start, end - start);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.948 -0400", hash_original_method = "FABF855F22C4847A4FF9FC56E0D56C67", hash_generated_method = "974AF8CFA1C811A9B4DCD2CD323DBD14")
    private StringIndexOutOfBoundsException failedBoundsCheck(int arrayLength, int offset, int count) {
        addTaint(count);
        addTaint(offset);
        addTaint(arrayLength);
        StringIndexOutOfBoundsException var4FAD7FC2D125C8A8D11F38CCD1F26725_2046414142 = new StringIndexOutOfBoundsException(arrayLength, offset, count);
        var4FAD7FC2D125C8A8D11F38CCD1F26725_2046414142.addTaint(taint);
        throw var4FAD7FC2D125C8A8D11F38CCD1F26725_2046414142;
        // ---------- Original Method ----------
        //throw new StringIndexOutOfBoundsException(arrayLength, offset, count);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.949 -0400", hash_original_method = "1D42C2C4BD065BE4935C25058CB25A0E", hash_generated_method = "963E7C6B4EC4B4E4B6CB5B75B3EB0E00")
    private char foldCase(char ch) {
        addTaint(ch);
        if(ch < 128)        
        {
            if('A' <= ch && ch <= 'Z')            
            {
                char varB5D6DE35E3B68E46A9D6DAF9509D6149_676772299 = ((char) (ch + ('a' - 'A')));
                                char varA87DEB01C5F539E6BDA34829C8EF2368_186079128 = getTaintChar();
                return varA87DEB01C5F539E6BDA34829C8EF2368_186079128;
            } //End block
            char varD88FC6EDF21EA464D35FF76288B84103_914764682 = (ch);
                        char varA87DEB01C5F539E6BDA34829C8EF2368_1552161406 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1552161406;
        } //End block
        char var1A18DA882D946DB0067AB53FB250DB6B_930985260 = (Character.toLowerCase(Character.toUpperCase(ch)));
                char varA87DEB01C5F539E6BDA34829C8EF2368_736024645 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_736024645;
        // ---------- Original Method ----------
        //if (ch < 128) {
            //if ('A' <= ch && ch <= 'Z') {
                //return (char) (ch + ('a' - 'A'));
            //}
            //return ch;
        //}
        //return Character.toLowerCase(Character.toUpperCase(ch));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.950 -0400", hash_original_method = "E601A465E2566ECC4B972E253D5CFD79", hash_generated_method = "41AA8E49C5D9B1201E8F51B633FBBE0D")
    public int compareTo(String string) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_612973454 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_612973454;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.951 -0400", hash_original_method = "1A9A71EFE325E55C19A2B451F1A9B9E2", hash_generated_method = "134A68B4F350597BDFFDD13879E8D426")
    public int compareToIgnoreCase(String string) {
        addTaint(string.getTaint());
        int o1 = offset;
        int o2 = string.offset;
        int result;
        int end = offset + (count < string.count ? count : string.count);
        char c1;
        char c2;
        char[] target = string.value;
        while
(o1 < end)        
        {
            if((c1 = value[o1++]) == (c2 = target[o2++]))            
            {
                continue;
            } //End block
            c1 = foldCase(c1);
            c2 = foldCase(c2);
            if((result = c1 - c2) != 0)            
            {
                int varB4A88417B3D0170D754C647C30B7216A_569480856 = (result);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1555201567 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1555201567;
            } //End block
        } //End block
        int varAF9D08BE17F109038AD9DBFBDBA98163_726817259 = (count - string.count);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_697224070 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_697224070;
        // ---------- Original Method ----------
        //int o1 = offset, o2 = string.offset, result;
        //int end = offset + (count < string.count ? count : string.count);
        //char c1, c2;
        //char[] target = string.value;
        //while (o1 < end) {
            //if ((c1 = value[o1++]) == (c2 = target[o2++])) {
                //continue;
            //}
            //c1 = foldCase(c1);
            //c2 = foldCase(c2);
            //if ((result = c1 - c2) != 0) {
                //return result;
            //}
        //}
        //return count - string.count;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.952 -0400", hash_original_method = "F488471D994E6AC017026A4A172508CF", hash_generated_method = "DBE9769AB6FF89CC85ED62BDC01795EC")
    public String concat(String string) {
        addTaint(string.getTaint());
        if(string.count > 0 && count > 0)        
        {
            char[] buffer = new char[count + string.count];
            System.arraycopy(value, offset, buffer, 0, count);
            System.arraycopy(string.value, string.offset, buffer, count, string.count);
String varE9BB9A2D22B7506011EAD9776484D5F2_48856802 =             new String(0, buffer.length, buffer);
            varE9BB9A2D22B7506011EAD9776484D5F2_48856802.addTaint(taint);
            return varE9BB9A2D22B7506011EAD9776484D5F2_48856802;
        } //End block
String varA2304E2602C032397F1C392C6B6B259F_1157715901 =         count == 0 ? string : this;
        varA2304E2602C032397F1C392C6B6B259F_1157715901.addTaint(taint);
        return varA2304E2602C032397F1C392C6B6B259F_1157715901;
        // ---------- Original Method ----------
        //if (string.count > 0 && count > 0) {
            //char[] buffer = new char[count + string.count];
            //System.arraycopy(value, offset, buffer, 0, count);
            //System.arraycopy(string.value, string.offset, buffer, count, string.count);
            //return new String(0, buffer.length, buffer);
        //}
        //return count == 0 ? string : this;
    }

    
    @DSModeled(DSC.SAFE)
    public static String copyValueOf(char[] data) {
        return new String(data, 0, data.length);
    }

    
    @DSModeled(DSC.SAFE)
    public static String copyValueOf(char[] data, int start, int length) {
        return new String(data, start, length);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.953 -0400", hash_original_method = "3B37EFF40C149A7A244BFEF0002B2C93", hash_generated_method = "5922FD5D0A73CBA64C28472D3C192EDA")
    public boolean endsWith(String suffix) {
        addTaint(suffix.getTaint());
        boolean varEE1D16D5742820344C10CDBFC5FEC4A1_602035692 = (regionMatches(count - suffix.count, suffix, 0, suffix.count));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1892542898 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1892542898;
        // ---------- Original Method ----------
        //return regionMatches(count - suffix.count, suffix, 0, suffix.count);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.954 -0400", hash_original_method = "84733F87EF08EE029ED9292B40928CC1", hash_generated_method = "2FC6180972CEE571B3973F9BCF24EB26")
    @Override
    public boolean equals(Object object) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_991767489 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_991767489;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.955 -0400", hash_original_method = "2D6A09B1457D58571ED784483A3E54F2", hash_generated_method = "106B873132775A92639C71788C37CE9B")
    public boolean equalsIgnoreCase(String string) {
        addTaint(string.getTaint());
        if(string == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1451150734 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1186545313 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1186545313;
        } //End block
        if(string == null || count != string.count)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1698669885 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1189821909 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1189821909;
        } //End block
        int o1 = offset;
        int o2 = string.offset;
        int end = offset + count;
        char[] target = string.value;
        while
(o1 < end)        
        {
            char c1 = value[o1++];
            char c2 = target[o2++];
            if(c1 != c2 && foldCase(c1) != foldCase(c2))            
            {
                boolean var68934A3E9455FA72420237EB05902327_2114563145 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1382515950 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1382515950;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_2063564724 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_577766573 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_577766573;
        // ---------- Original Method ----------
        //if (string == this) {
            //return true;
        //}
        //if (string == null || count != string.count) {
            //return false;
        //}
        //int o1 = offset, o2 = string.offset;
        //int end = offset + count;
        //char[] target = string.value;
        //while (o1 < end) {
            //char c1 = value[o1++];
            //char c2 = target[o2++];
            //if (c1 != c2 && foldCase(c1) != foldCase(c2)) {
                //return false;
            //}
        //}
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.952 -0400", hash_original_method = "628C355D58441C62D711BC1C2A898A67", hash_generated_method = "96F0117EE797C83FEB58E8D326BFF607")
    @Deprecated
    public void getBytes(int start, int end, byte[] data, int index) {
        addTaint(index);
        addTaint(data[0]);
        addTaint(end);
        addTaint(start);
    if(start >= 0 && start <= end && end <= count)        
        {
            end += offset;
            try 
            {
for(int i = offset + start;i < end;i++)
                {
                    data[index++] = (byte) value[i];
                } //End block
            } //End block
            catch (ArrayIndexOutOfBoundsException ignored)
            {
            	StringIndexOutOfBoundsException varD87E3E0DEDBE23D233BE92E396080AE4_1181737688 = failedBoundsCheck(data.length, index, end - start);
                varD87E3E0DEDBE23D233BE92E396080AE4_1181737688.addTaint(taint);
                throw varD87E3E0DEDBE23D233BE92E396080AE4_1181737688;
            } //End block
        } //End block
        else
        {
        	StringIndexOutOfBoundsException varD4320BED3007B31B0BCB1B90CDC7325C_794172148 = startEndAndLength(start, end);
            varD4320BED3007B31B0BCB1B90CDC7325C_794172148.addTaint(taint);
            throw varD4320BED3007B31B0BCB1B90CDC7325C_794172148;
        } //End block
        // ---------- Original Method ----------
        //if (start >= 0 && start <= end && end <= count) {
            //end += offset;
            //try {
                //for (int i = offset + start; i < end; i++) {
                    //data[index++] = (byte) value[i];
                //}
            //} catch (ArrayIndexOutOfBoundsException ignored) {
                //throw failedBoundsCheck(data.length, index, end - start);
            //}
        //} else {
            //throw startEndAndLength(start, end);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.976 -0400", hash_original_method = "2E4CA200D3933E45C3FC02936B120C89", hash_generated_method = "E0073CF5497F35240530482C40DCAF29")
    public byte[] getBytes() {
        byte[] var40B8AAFFEF4AB9778617CA924F87E408_1597173450 = (getBytes(Charset.defaultCharset()));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_210867429 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_210867429;
        // ---------- Original Method ----------
        //return getBytes(Charset.defaultCharset());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.977 -0400", hash_original_method = "D1476A765D84241818C22751CEBD7DE3", hash_generated_method = "658F004F3CBDD32CBE8DD85B9F530879")
    public byte[] getBytes(String charsetName) throws UnsupportedEncodingException {
        addTaint(charsetName.getTaint());
        byte[] varD79457387769865B64DBACF6E31D0CEE_585808102 = (getBytes(Charset.forNameUEE(charsetName)));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_235375876 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_235375876;
        // ---------- Original Method ----------
        //return getBytes(Charset.forNameUEE(charsetName));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.978 -0400", hash_original_method = "56FDAE3B6641018546E6C6674268142D", hash_generated_method = "33AFD5BF1E8317D7C25483DE5932D3F5")
    public byte[] getBytes(Charset charset) {
        addTaint(charset.getTaint());
        String canonicalCharsetName = charset.name();
        if(canonicalCharsetName.equals("UTF-8"))        
        {
            byte[] varA674360BA4F69EF4538856FD4E7DA4E5_472348145 = (Charsets.toUtf8Bytes(value, offset, count));
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_23877931 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_23877931;
        } //End block
        else
        if(canonicalCharsetName.equals("ISO-8859-1"))        
        {
            byte[] var57953CB2C002567E8B819B70AC3A61A3_1338782534 = (Charsets.toIsoLatin1Bytes(value, offset, count));
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1141621859 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1141621859;
        } //End block
        else
        if(canonicalCharsetName.equals("US-ASCII"))        
        {
            byte[] varB57B592532935D5283F0CB1F052612DB_338970471 = (Charsets.toAsciiBytes(value, offset, count));
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2092457264 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_2092457264;
        } //End block
        else
        if(canonicalCharsetName.equals("UTF-16BE"))        
        {
            byte[] var61071EDD934136B6F916D86F92F54AFA_1646813252 = (Charsets.toBigEndianUtf16Bytes(value, offset, count));
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_916752848 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_916752848;
        } //End block
        else
        {
            CharBuffer chars = CharBuffer.wrap(this.value, this.offset, this.count);
            ByteBuffer buffer = charset.encode(chars.asReadOnlyBuffer());
            byte[] bytes = new byte[buffer.limit()];
            buffer.get(bytes);
            byte[] var4B3A6218BB3E3A7303E8A171A60FCF92_27950145 = (bytes);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1895463511 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1895463511;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.989 -0400", hash_original_method = "D443F19C798F5645F696FD1973BB47C6", hash_generated_method = "168F6E3DA50E280535B3342B42AF704F")
    public void getChars(int start, int end, char[] buffer, int index) {
        addTaint(index);
        addTaint(buffer[0]);
        addTaint(end);
        addTaint(start);
    if(start >= 0 && start <= end && end <= count)        
        {
            System.arraycopy(value, start + offset, buffer, index, end - start);
        } //End block
        else
        {
        	StringIndexOutOfBoundsException varD4320BED3007B31B0BCB1B90CDC7325C_1302296784 = startEndAndLength(start, end);
            varD4320BED3007B31B0BCB1B90CDC7325C_1302296784.addTaint(taint);
            throw varD4320BED3007B31B0BCB1B90CDC7325C_1302296784;
        } //End block
        // ---------- Original Method ----------
        //if (start >= 0 && start <= end && end <= count) {
            //System.arraycopy(value, start + offset, buffer, index, end - start);
        //} else {
            //throw startEndAndLength(start, end);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.993 -0400", hash_original_method = "25FFBBE7056EE87BB826458DBC43764C", hash_generated_method = "7F61143154BA5A768C3BBB71E6097C02")
     void _getChars(int start, int end, char[] buffer, int index) {
        addTaint(index);
        addTaint(buffer[0]);
        addTaint(end);
        addTaint(start);
        System.arraycopy(value, start + offset, buffer, index, end - start);
        // ---------- Original Method ----------
        //System.arraycopy(value, start + offset, buffer, index, end - start);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.995 -0400", hash_original_method = "19D1106FC463FB90112A6C6293D6F5CF", hash_generated_method = "1EDF965C794B1E9A9380AD8DF1992A2E")
    @Override
    public int hashCode() {
        int hash = hashCode;
        if(hash == 0)        
        {
            if(count == 0)            
            {
                int varCFCD208495D565EF66E7DFF9F98764DA_1181573492 = (0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_992251171 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_992251171;
            } //End block
            final int end = count + offset;
            final char[] chars = value;
for(int i = offset;i < end;++i)
            {
                hash = 31*hash + chars[i];
            } //End block
            hashCode = hash;
        } //End block
        int var0800FC577294C34E0B28AD2839435945_1276224580 = (hash);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1081894260 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1081894260;
        // ---------- Original Method ----------
        //int hash = hashCode;
        //if (hash == 0) {
            //if (count == 0) {
                //return 0;
            //}
            //final int end = count + offset;
            //final char[] chars = value;
            //for (int i = offset; i < end; ++i) {
                //hash = 31*hash + chars[i];
            //}
            //hashCode = hash;
        //}
        //return hash;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.995 -0400", hash_original_method = "C183CC13D668537DB52873A8A3264758", hash_generated_method = "21146D9ED18A1B71E8D3F4EB240EEE02")
    public int indexOf(int c) {
        addTaint(c);
        if(c > 0xffff)        
        {
            int varD3CEBDA0F7ECC1F176D803F0D96220B6_156644271 = (indexOfSupplementary(c, 0));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2111984997 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2111984997;
        } //End block
        int varE1D822CA7B919C6036F4B2FC85E37827_2056555754 = (fastIndexOf(c, 0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_52510516 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_52510516;
        // ---------- Original Method ----------
        //if (c > 0xffff) {
            //return indexOfSupplementary(c, 0);
        //}
        //return fastIndexOf(c, 0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.996 -0400", hash_original_method = "A9B16E70D2A4A056B33DA4268AACFBA9", hash_generated_method = "5260FAD8D507414C49592861E2B279F8")
    public int indexOf(int c, int start) {
        addTaint(start);
        addTaint(c);
        if(c > 0xffff)        
        {
            int varA0C83F59E94CDB5B58621787EE400BD8_758699605 = (indexOfSupplementary(c, start));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1365875482 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1365875482;
        } //End block
        int varAEFCD9F4AA8873588CB6C0CCD17FC320_1421632563 = (fastIndexOf(c, start));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1390694470 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1390694470;
        // ---------- Original Method ----------
        //if (c > 0xffff) {
            //return indexOfSupplementary(c, start);
        //}
        //return fastIndexOf(c, start);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.996 -0400", hash_original_method = "158E0BDE7178D291CA067E7481407A6C", hash_generated_method = "608BA9A113A1C424CF6E43F3194751EF")
    private int fastIndexOf(int c, int start) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_850899079 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_850899079;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.997 -0400", hash_original_method = "9DA1418F8A10F302F688A26755CAB088", hash_generated_method = "8C369D3FC3788786966452B4CB522A60")
    private int indexOfSupplementary(int c, int start) {
        addTaint(start);
        addTaint(c);
        if(!Character.isSupplementaryCodePoint(c))        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_96328086 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1233461065 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1233461065;
        } //End block
        char[] chars = Character.toChars(c);
        String needle = new String(0, chars.length, chars);
        int var4D6FA9B54EECF201E001C5B99EBBA47A_563839932 = (indexOf(needle, start));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1064605929 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1064605929;
        // ---------- Original Method ----------
        //if (!Character.isSupplementaryCodePoint(c)) {
            //return -1;
        //}
        //char[] chars = Character.toChars(c);
        //String needle = new String(0, chars.length, chars);
        //return indexOf(needle, start);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.998 -0400", hash_original_method = "AC187DA6A9C2600FBA62EFD5097D8F4D", hash_generated_method = "31C53F0D5FF44F1D0DC0C27CA5CB8F4E")
    public int indexOf(String string) {
        addTaint(string.getTaint());
        int start = 0;
        int subCount = string.count;
        int _count = count;
        if(subCount > 0)        
        {
            if(subCount > _count)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_21784165 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1884092060 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1884092060;
            } //End block
            char[] target = string.value;
            int subOffset = string.offset;
            char firstChar = target[subOffset];
            int end = subOffset + subCount;
            while
(true)            
            {
                int i = indexOf(firstChar, start);
                if(i == -1 || subCount + i > _count)                
                {
                    int var6BB61E3B7BCE0931DA574D19D1D82C88_1378283064 = (-1);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2007136828 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2007136828;
                } //End block
                int o1 = offset + i;
                int o2 = subOffset;
                char[] _value = value;
                while
(++o2 < end && _value[++o1] == target[o2])                
                {
                } //End block
                if(o2 == end)                
                {
                    int var865C0C0B4AB0E063E5CAA3387C1A8741_1460523881 = (i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_666126290 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_666126290;
                } //End block
                start = i + 1;
            } //End block
        } //End block
        int varADAFC68F8BEE4E16FDF8D4A6C2A12389_721017947 = (start < _count ? start : _count);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_93631025 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_93631025;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.000 -0400", hash_original_method = "30C77F2F1070D21229A0301D2E3C23FC", hash_generated_method = "30616A344970042DC452CAC8BF34F403")
    public int indexOf(String subString, int start) {
        addTaint(start);
        addTaint(subString.getTaint());
        if(start < 0)        
        {
            start = 0;
        } //End block
        int subCount = subString.count;
        int _count = count;
        if(subCount > 0)        
        {
            if(subCount + start > _count)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_658165498 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1337074240 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1337074240;
            } //End block
            char[] target = subString.value;
            int subOffset = subString.offset;
            char firstChar = target[subOffset];
            int end = subOffset + subCount;
            while
(true)            
            {
                int i = indexOf(firstChar, start);
                if(i == -1 || subCount + i > _count)                
                {
                    int var6BB61E3B7BCE0931DA574D19D1D82C88_2082397169 = (-1);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1206014081 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1206014081;
                } //End block
                int o1 = offset + i;
                int o2 = subOffset;
                char[] _value = value;
                while
(++o2 < end && _value[++o1] == target[o2])                
                {
                } //End block
                if(o2 == end)                
                {
                    int var865C0C0B4AB0E063E5CAA3387C1A8741_1928078136 = (i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1761378268 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1761378268;
                } //End block
                start = i + 1;
            } //End block
        } //End block
        int varADAFC68F8BEE4E16FDF8D4A6C2A12389_1401705506 = (start < _count ? start : _count);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_729398146 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_729398146;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.870 -0400", hash_original_method = "8D834ED1699A050AD62397187973DE2A", hash_generated_method = "D27768EE08A87AC5AC201AAF7BA53F8D")
    public String intern() {
    	return new String();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.001 -0400", hash_original_method = "9B1CCC3AB82A9C7B7A46C788921405FB", hash_generated_method = "FD8EA024D2EB82F0924BE99C3C43E3AC")
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_158781853 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_158781853;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.001 -0400", hash_original_method = "B7458CFA700437DC398BF47C5A311056", hash_generated_method = "F0573CD15060AB41DC5F9DAFCFBAEA9E")
    public int lastIndexOf(int c) {
        addTaint(c);
        if(c > 0xffff)        
        {
            int var6E5770380FEEE7FD6DD2799DB6A9AD81_1036927966 = (lastIndexOfSupplementary(c, Integer.MAX_VALUE));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_918765881 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_918765881;
        } //End block
        int _count = count;
        int _offset = offset;
        char[] _value = value;
for(int i = _offset + _count - 1;i >= _offset;--i)
        {
            if(_value[i] == c)            
            {
                int var5337D1DABEE183C1C63FE794773606DE_2103403227 = (i - _offset);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_58251476 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_58251476;
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_250770919 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1241596800 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1241596800;
        // ---------- Original Method ----------
        //if (c > 0xffff) {
            //return lastIndexOfSupplementary(c, Integer.MAX_VALUE);
        //}
        //int _count = count;
        //int _offset = offset;
        //char[] _value = value;
        //for (int i = _offset + _count - 1; i >= _offset; --i) {
            //if (_value[i] == c) {
                //return i - _offset;
            //}
        //}
        //return -1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.002 -0400", hash_original_method = "438C7E0E01B0881067FA33086AF4D678", hash_generated_method = "DAAC5AC2CF4EEC2357FBA6CB2E510A5B")
    public int lastIndexOf(int c, int start) {
        addTaint(start);
        addTaint(c);
        if(c > 0xffff)        
        {
            int varF4A58EFA790A6736D48CC1F5D71659F2_1512933905 = (lastIndexOfSupplementary(c, start));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1400775883 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1400775883;
        } //End block
        int _count = count;
        int _offset = offset;
        char[] _value = value;
        if(start >= 0)        
        {
            if(start >= _count)            
            {
                start = _count - 1;
            } //End block
for(int i = _offset + start;i >= _offset;--i)
            {
                if(_value[i] == c)                
                {
                    int var5337D1DABEE183C1C63FE794773606DE_1049637129 = (i - _offset);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2088292808 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2088292808;
                } //End block
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_2002326717 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_215708881 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_215708881;
        // ---------- Original Method ----------
        //if (c > 0xffff) {
            //return lastIndexOfSupplementary(c, start);
        //}
        //int _count = count;
        //int _offset = offset;
        //char[] _value = value;
        //if (start >= 0) {
            //if (start >= _count) {
                //start = _count - 1;
            //}
            //for (int i = _offset + start; i >= _offset; --i) {
                //if (_value[i] == c) {
                    //return i - _offset;
                //}
            //}
        //}
        //return -1;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.003 -0400", hash_original_method = "ECC6B0EDCC4F01358439BB31BFF21134", hash_generated_method = "5B2138642F978379EF8D1D6EE1C1C878")
    private int lastIndexOfSupplementary(int c, int start) {
        addTaint(start);
        addTaint(c);
        if(!Character.isSupplementaryCodePoint(c))        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_558317165 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2062827878 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2062827878;
        } //End block
        char[] chars = Character.toChars(c);
        String needle = new String(0, chars.length, chars);
        int var276BC97A9352F9AA9C2C20C10ADF746E_621748195 = (lastIndexOf(needle, start));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_975870401 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_975870401;
        // ---------- Original Method ----------
        //if (!Character.isSupplementaryCodePoint(c)) {
            //return -1;
        //}
        //char[] chars = Character.toChars(c);
        //String needle = new String(0, chars.length, chars);
        //return lastIndexOf(needle, start);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.003 -0400", hash_original_method = "692347B4AF93950259A2DA740A39B258", hash_generated_method = "D5CA5DCE0B0EE07A8145F564C16BF508")
    public int lastIndexOf(String string) {
        addTaint(string.getTaint());
        int var9D74F68960E009CAC27271987951F701_1301820266 = (lastIndexOf(string, count));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_283226766 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_283226766;
        // ---------- Original Method ----------
        //return lastIndexOf(string, count);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.004 -0400", hash_original_method = "08D5FBAA11FAAE0244D1BD87258C05E0", hash_generated_method = "40B645BB077BEAC8BD14D2203D60863E")
    public int lastIndexOf(String subString, int start) {
        addTaint(start);
        addTaint(subString.getTaint());
        int subCount = subString.count;
        if(subCount <= count && start >= 0)        
        {
            if(subCount > 0)            
            {
                if(start > count - subCount)                
                {
                    start = count - subCount;
                } //End block
                char[] target = subString.value;
                int subOffset = subString.offset;
                char firstChar = target[subOffset];
                int end = subOffset + subCount;
                while
(true)                
                {
                    int i = lastIndexOf(firstChar, start);
                    if(i == -1)                    
                    {
                        int var6BB61E3B7BCE0931DA574D19D1D82C88_549405109 = (-1);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_633741348 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_633741348;
                    } //End block
                    int o1 = offset + i;
                    int o2 = subOffset;
                    while
(++o2 < end && value[++o1] == target[o2])                    
                    {
                    } //End block
                    if(o2 == end)                    
                    {
                        int var865C0C0B4AB0E063E5CAA3387C1A8741_1064174910 = (i);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_985958436 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_985958436;
                    } //End block
                    start = i - 1;
                } //End block
            } //End block
            int var0FFB83E5F2423119ED71A6AA9F842533_1853665226 = (start < count ? start : count);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1074988155 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1074988155;
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_203110598 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1862866125 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1862866125;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.004 -0400", hash_original_method = "026D3AE6EA7284BA85CF864429138595", hash_generated_method = "F569A44B30B5D48329EDDFB633920A7C")
    public int length() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1763310747 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1763310747;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.005 -0400", hash_original_method = "8EA3BFAB97A4D4877FC2554FB493C6C0", hash_generated_method = "0B1E6836AF37657E31B7082ECDC07378")
    public boolean regionMatches(int thisStart, String string, int start, int length) {
        addTaint(length);
        addTaint(start);
        addTaint(string.getTaint());
        addTaint(thisStart);
        if(string == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1986800333 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1986800333.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1986800333;
        } //End block
        if(start < 0 || string.count - start < length)        
        {
            boolean var68934A3E9455FA72420237EB05902327_14885229 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_48192055 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_48192055;
        } //End block
        if(thisStart < 0 || count - thisStart < length)        
        {
            boolean var68934A3E9455FA72420237EB05902327_582635669 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_429576292 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_429576292;
        } //End block
        if(length <= 0)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1916244619 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_472757427 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_472757427;
        } //End block
        int o1 = offset + thisStart;
        int o2 = string.offset + start;
        char[] value1 = value;
        char[] value2 = string.value;
for(int i = 0;i < length;++i)
        {
            if(value1[o1 + i] != value2[o2 + i])            
            {
                boolean var68934A3E9455FA72420237EB05902327_192286505 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_950231381 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_950231381;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1556740818 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1716056438 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1716056438;
        // ---------- Original Method ----------
        //if (string == null) {
            //throw new NullPointerException();
        //}
        //if (start < 0 || string.count - start < length) {
            //return false;
        //}
        //if (thisStart < 0 || count - thisStart < length) {
            //return false;
        //}
        //if (length <= 0) {
            //return true;
        //}
        //int o1 = offset + thisStart, o2 = string.offset + start;
        //char[] value1 = value;
        //char[] value2 = string.value;
        //for (int i = 0; i < length; ++i) {
            //if (value1[o1 + i] != value2[o2 + i]) {
                //return false;
            //}
        //}
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.007 -0400", hash_original_method = "5098FC46543D7D1A735E08AA962F8003", hash_generated_method = "6DB52D0A34708B907B31C1FD047C7B50")
    public boolean regionMatches(boolean ignoreCase, int thisStart, String string, int start, int length) {
        addTaint(length);
        addTaint(start);
        addTaint(string.getTaint());
        addTaint(thisStart);
        addTaint(ignoreCase);
        if(!ignoreCase)        
        {
            boolean var2189525ECA24E85E0448401995CDE08C_911086023 = (regionMatches(thisStart, string, start, length));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2028785766 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2028785766;
        } //End block
        if(string == null)        
        {
            NullPointerException var5776BA98BE2EEDBB80F0AAA5C4D7B456_2128220120 = new NullPointerException("string == null");
            var5776BA98BE2EEDBB80F0AAA5C4D7B456_2128220120.addTaint(taint);
            throw var5776BA98BE2EEDBB80F0AAA5C4D7B456_2128220120;
        } //End block
        if(thisStart < 0 || length > count - thisStart)        
        {
            boolean var68934A3E9455FA72420237EB05902327_331665373 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2015969424 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2015969424;
        } //End block
        if(start < 0 || length > string.count - start)        
        {
            boolean var68934A3E9455FA72420237EB05902327_875916715 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_156310713 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_156310713;
        } //End block
        thisStart += offset;
        start += string.offset;
        int end = thisStart + length;
        char[] target = string.value;
        while
(thisStart < end)        
        {
            char c1 = value[thisStart++];
            char c2 = target[start++];
            if(c1 != c2 && foldCase(c1) != foldCase(c2))            
            {
                boolean var68934A3E9455FA72420237EB05902327_1182512396 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1956261329 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1956261329;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_81902960 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1483390464 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1483390464;
        // ---------- Original Method ----------
        //if (!ignoreCase) {
            //return regionMatches(thisStart, string, start, length);
        //}
        //if (string == null) {
            //throw new NullPointerException("string == null");
        //}
        //if (thisStart < 0 || length > count - thisStart) {
            //return false;
        //}
        //if (start < 0 || length > string.count - start) {
            //return false;
        //}
        //thisStart += offset;
        //start += string.offset;
        //int end = thisStart + length;
        //char[] target = string.value;
        //while (thisStart < end) {
            //char c1 = value[thisStart++];
            //char c2 = target[start++];
            //if (c1 != c2 && foldCase(c1) != foldCase(c2)) {
                //return false;
            //}
        //}
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.010 -0400", hash_original_method = "52751D07523F52C15F0E15149B768BF7", hash_generated_method = "0B132EA5600725793FDE464D7F2F8891")
    public String replace(char oldChar, char newChar) {
        addTaint(newChar);
        addTaint(oldChar);
        char[] buffer = value;
        int _offset = offset;
        int _count = count;
        int idx = _offset;
        int last = _offset + _count;
        boolean copied = false;
        while
(idx < last)        
        {
            if(buffer[idx] == oldChar)            
            {
                if(!copied)                
                {
                    char[] newBuffer = new char[_count];
                    System.arraycopy(buffer, _offset, newBuffer, 0, _count);
                    buffer = newBuffer;
                    idx -= _offset;
                    last -= _offset;
                    copied = true;
                } //End block
                buffer[idx] = newChar;
            } //End block
            idx++;
        } //End block
String var21DC98D17784CFD779867A4B4E93FDC2_856282155 =         copied ? new String(0, count, buffer) : this;
        var21DC98D17784CFD779867A4B4E93FDC2_856282155.addTaint(taint);
        return var21DC98D17784CFD779867A4B4E93FDC2_856282155;
        // ---------- Original Method ----------
        //char[] buffer = value;
        //int _offset = offset;
        //int _count = count;
        //int idx = _offset;
        //int last = _offset + _count;
        //boolean copied = false;
        //while (idx < last) {
            //if (buffer[idx] == oldChar) {
                //if (!copied) {
                    //char[] newBuffer = new char[_count];
                    //System.arraycopy(buffer, _offset, newBuffer, 0, _count);
                    //buffer = newBuffer;
                    //idx -= _offset;
                    //last -= _offset;
                    //copied = true;
                //}
                //buffer[idx] = newChar;
            //}
            //idx++;
        //}
        //return copied ? new String(0, count, buffer) : this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.011 -0400", hash_original_method = "226EAAC156D556D42E48670E64FEC4E8", hash_generated_method = "B5D31EB37DE33520A509F23BA062A381")
    public String replace(CharSequence target, CharSequence replacement) {
        addTaint(replacement.getTaint());
        addTaint(target.getTaint());
        if(target == null)        
        {
            NullPointerException var0DB6377415E5B25FCBED699A3836CC18_1005305935 = new NullPointerException("target == null");
            var0DB6377415E5B25FCBED699A3836CC18_1005305935.addTaint(taint);
            throw var0DB6377415E5B25FCBED699A3836CC18_1005305935;
        } //End block
        if(replacement == null)        
        {
            NullPointerException var6ECD5DD11CA7B1724ECEB1D26AE441C2_1038828529 = new NullPointerException("replacement == null");
            var6ECD5DD11CA7B1724ECEB1D26AE441C2_1038828529.addTaint(taint);
            throw var6ECD5DD11CA7B1724ECEB1D26AE441C2_1038828529;
        } //End block
        String targetString = target.toString();
        int matchStart = indexOf(targetString, 0);
        if(matchStart == -1)        
        {
String var72A74007B2BE62B849F475C7BDA4658B_240988836 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_240988836.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_240988836;
        } //End block
        String replacementString = replacement.toString();
        int targetLength = targetString.length();
        if(targetLength == 0)        
        {
            int resultLength = (count + 2) * replacementString.length();
            StringBuilder result = new StringBuilder(resultLength);
            result.append(replacementString);
for(int i = offset;i < count;++i)
            {
                result.append(value[i]);
                result.append(replacementString);
            } //End block
String varE65B3A02759122992CB82C0E651AD408_1339001417 =             result.toString();
            varE65B3A02759122992CB82C0E651AD408_1339001417.addTaint(taint);
            return varE65B3A02759122992CB82C0E651AD408_1339001417;
        } //End block
        StringBuilder result = new StringBuilder(count);
        int searchStart = 0;
        do {
            {
                result.append(value, offset + searchStart, matchStart - searchStart);
                result.append(replacementString);
                searchStart = matchStart + targetLength;
            } //End block
} while ((matchStart = indexOf(targetString, searchStart)) != -1);
        result.append(value, offset + searchStart, count - searchStart);
String varE65B3A02759122992CB82C0E651AD408_718974986 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_718974986.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_718974986;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.012 -0400", hash_original_method = "8508513C5D9E5D7A42B020CFB91803A3", hash_generated_method = "DE00CD3710DB50FB711F69C1562C1A3D")
    public boolean startsWith(String prefix) {
        addTaint(prefix.getTaint());
        boolean varB2B8CC9FB05263CFCC376EFAC155326D_2078863598 = (startsWith(prefix, 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_809377189 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_809377189;
        // ---------- Original Method ----------
        //return startsWith(prefix, 0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.013 -0400", hash_original_method = "DCA59D254EE64B3144EDF9B3ACB43A45", hash_generated_method = "AD3344F000DA53B68D44BE34BB3E051D")
    public boolean startsWith(String prefix, int start) {
        addTaint(start);
        addTaint(prefix.getTaint());
        boolean var524D3DB2C2708210A1134A37BDC13952_263791470 = (regionMatches(start, prefix, 0, prefix.count));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1844209770 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1844209770;
        // ---------- Original Method ----------
        //return regionMatches(start, prefix, 0, prefix.count);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.029 -0400", hash_original_method = "CB27750752A8934950488E0046CA5119", hash_generated_method = "33066E8AA094172FFF0CEC5E486EDCD6")
    public String substring(int start) {
        addTaint(start);
    if(start == 0)        
        {
String var72A74007B2BE62B849F475C7BDA4658B_2102003325 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_2102003325.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_2102003325;
        } //End block
    if(start >= 0 && start <= count)        
        {
String var2B0D1736DD1B19490531C381A1416ABB_1242432222 =             new String(offset + start, count - start, value);
            var2B0D1736DD1B19490531C381A1416ABB_1242432222.addTaint(taint);
            return var2B0D1736DD1B19490531C381A1416ABB_1242432222;
        } //End block
    	StringIndexOutOfBoundsException varC9C52284361B891C0CBD2284A6FE0828_1101455365 = indexAndLength(start);
        varC9C52284361B891C0CBD2284A6FE0828_1101455365.addTaint(taint);
        throw varC9C52284361B891C0CBD2284A6FE0828_1101455365;
        // ---------- Original Method ----------
        //if (start == 0) {
            //return this;
        //}
        //if (start >= 0 && start <= count) {
            //return new String(offset + start, count - start, value);
        //}
        //throw indexAndLength(start);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.049 -0400", hash_original_method = "FA273138383309E9BFDA8AAE2A7C6025", hash_generated_method = "0A4B172CD2951ABC21C7191BBBED5414")
    public String substring(int start, int end) {
        addTaint(end);
        addTaint(start);
    if(start == 0 && end == count)        
        {
String var72A74007B2BE62B849F475C7BDA4658B_93020799 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_93020799.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_93020799;
        } //End block
    if(start >= 0 && start <= end && end <= count)        
        {
String var2511EA3E5FEAAD0D48B436EB1999CC85_1798446020 =             new String(offset + start, end - start, value);
            var2511EA3E5FEAAD0D48B436EB1999CC85_1798446020.addTaint(taint);
            return var2511EA3E5FEAAD0D48B436EB1999CC85_1798446020;
        } //End block
    	StringIndexOutOfBoundsException varD4320BED3007B31B0BCB1B90CDC7325C_134150222 = startEndAndLength(start, end);
        varD4320BED3007B31B0BCB1B90CDC7325C_134150222.addTaint(taint);
        throw varD4320BED3007B31B0BCB1B90CDC7325C_134150222;
        // ---------- Original Method ----------
        //if (start == 0 && end == count) {
            //return this;
        //}
        //if (start >= 0 && start <= end && end <= count) {
            //return new String(offset + start, end - start, value);
        //}
        //throw startEndAndLength(start, end);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.034 -0400", hash_original_method = "66BAEF040BB5FDC80731F9B16CD33C32", hash_generated_method = "B5169257B38DD0F17F60D8634C774276")
    public char[] toCharArray() {
        char[] buffer = new char[count];
        System.arraycopy(value, offset, buffer, 0, count);
        char[] var7F2DB423A49B305459147332FB01CF87_1922080415 = (buffer);
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_132816978 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_132816978;
        // ---------- Original Method ----------
        //char[] buffer = new char[count];
        //System.arraycopy(value, offset, buffer, 0, count);
        //return buffer;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.035 -0400", hash_original_method = "1FBB4BF6938E55C9E24FEC1EE0A95252", hash_generated_method = "6998483BBB6DB89D0FCF2A38C7BD1493")
    public String toLowerCase() {
String varC7E95AB710071E5387F1F7434BE3B06A_1852663874 =         CaseMapper.toLowerCase(Locale.getDefault(), this, value, offset, count);
        varC7E95AB710071E5387F1F7434BE3B06A_1852663874.addTaint(taint);
        return varC7E95AB710071E5387F1F7434BE3B06A_1852663874;
        // ---------- Original Method ----------
        //return CaseMapper.toLowerCase(Locale.getDefault(), this, value, offset, count);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.035 -0400", hash_original_method = "3BCA227A64DF8F05552679E5E357BCF1", hash_generated_method = "796E3C169FACE582A3EB6CAB5D202D0F")
    public String toLowerCase(Locale locale) {
        addTaint(locale.getTaint());
String var66112C226335D29F28D767C8BADE9A5D_895939898 =         CaseMapper.toLowerCase(locale, this, value, offset, count);
        var66112C226335D29F28D767C8BADE9A5D_895939898.addTaint(taint);
        return var66112C226335D29F28D767C8BADE9A5D_895939898;
        // ---------- Original Method ----------
        //return CaseMapper.toLowerCase(locale, this, value, offset, count);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.035 -0400", hash_original_method = "068E2EE4236B85776135405F1B66AD49", hash_generated_method = "329D9AF3CADCCCCC050F37975B2FDD7D")
    @Override
    public String toString() {
String var72A74007B2BE62B849F475C7BDA4658B_1078171028 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1078171028.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1078171028;
        // ---------- Original Method ----------
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.035 -0400", hash_original_method = "8DEC33A26AFC2829CCCCE108ECEB9551", hash_generated_method = "FD646F29A536B22D869B25D1A483F9A9")
    public String toUpperCase() {
String var739E07D85DF1A71755B19B0014421FE8_849144839 =         CaseMapper.toUpperCase(Locale.getDefault(), this, value, offset, count);
        var739E07D85DF1A71755B19B0014421FE8_849144839.addTaint(taint);
        return var739E07D85DF1A71755B19B0014421FE8_849144839;
        // ---------- Original Method ----------
        //return CaseMapper.toUpperCase(Locale.getDefault(), this, value, offset, count);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.036 -0400", hash_original_method = "11C711663B7D81E6BD865533BF51B442", hash_generated_method = "9476C448D1BF090F1936AEF95CFB2AF4")
    public String toUpperCase(Locale locale) {
        addTaint(locale.getTaint());
String var82F6F2D929DCCB4BC26C1A03BB63616B_496316805 =         CaseMapper.toUpperCase(locale, this, value, offset, count);
        var82F6F2D929DCCB4BC26C1A03BB63616B_496316805.addTaint(taint);
        return var82F6F2D929DCCB4BC26C1A03BB63616B_496316805;
        // ---------- Original Method ----------
        //return CaseMapper.toUpperCase(locale, this, value, offset, count);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.036 -0400", hash_original_method = "5AB01C88F799E5B54FF71EE82B91E811", hash_generated_method = "BDB536CDD94BAA1EDBF3FD3B9F49F5D5")
    public String trim() {
        int start = offset;
        int last = offset + count - 1;
        int end = last;
        while
((start <= end) && (value[start] <= ' '))        
        {
            start++;
        } //End block
        while
((end >= start) && (value[end] <= ' '))        
        {
            end--;
        } //End block
        if(start == offset && end == last)        
        {
String var72A74007B2BE62B849F475C7BDA4658B_42524111 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_42524111.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_42524111;
        } //End block
String var354324DED16A0B9E2EC7A1041A7B3943_1600767136 =         new String(start, end - start + 1, value);
        var354324DED16A0B9E2EC7A1041A7B3943_1600767136.addTaint(taint);
        return var354324DED16A0B9E2EC7A1041A7B3943_1600767136;
        // ---------- Original Method ----------
        //int start = offset, last = offset + count - 1;
        //int end = last;
        //while ((start <= end) && (value[start] <= ' ')) {
            //start++;
        //}
        //while ((end >= start) && (value[end] <= ' ')) {
            //end--;
        //}
        //if (start == offset && end == last) {
            //return this;
        //}
        //return new String(start, end - start + 1, value);
    }

    
    @DSModeled(DSC.SAFE)
    public static String valueOf(char[] data) {
        return new String(data, 0, data.length);
    }

    
    @DSModeled(DSC.SAFE)
    public static String valueOf(char[] data, int start, int length) {
        return new String(data, start, length);
    }

    
    @DSModeled(DSC.SAFE)
    public static String valueOf(char value) {
        String s;
        if (value < 128) {
            s = new String(value, 1, ASCII);
        } else {
            s = new String(0, 1, new char[] { value });
        }
        s.hashCode = value;
        return s;
    }

    
    @DSModeled(DSC.SAFE)
    public static String valueOf(double value) {
        return Double.toString(value);
    }

    
    @DSModeled(DSC.SAFE)
    public static String valueOf(float value) {
        return Float.toString(value);
    }

    @DSModeled(DSC.SAFE)
    public static String valueOf(int value) {
        return Integer.toString(value);
    }

    
    @DSModeled(DSC.SAFE)
    public static String valueOf(long value) {
        return Long.toString(value);
    }

    
    @DSModeled(DSC.SAFE)
    public static String valueOf(Object value) {
        return value != null ? value.toString() : "null";
    }

    
    @DSModeled(DSC.SAFE)
    public static String valueOf(boolean value) {
        return value ? "true" : "false";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.038 -0400", hash_original_method = "233CB676C051D9EE76740A9343D1B467", hash_generated_method = "77E89DFA46153F8E6461DCC49744E78D")
    public boolean contentEquals(StringBuffer strbuf) {
        addTaint(strbuf.getTaint());
        synchronized
(strbuf)        {
            int size = strbuf.length();
            if(count != size)            
            {
                boolean var68934A3E9455FA72420237EB05902327_320992844 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_119242363 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_119242363;
            } //End block
            boolean var7202922E8F4091534B32D730FE9BE69D_1030456224 = (regionMatches(0, new String(0, size, strbuf.getValue()), 0,
                    size));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1602854785 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1602854785;
        } //End block
        // ---------- Original Method ----------
        //synchronized (strbuf) {
            //int size = strbuf.length();
            //if (count != size) {
                //return false;
            //}
            //return regionMatches(0, new String(0, size, strbuf.getValue()), 0,
                    //size);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.039 -0400", hash_original_method = "733340B51AD84F3351AE4177729AE631", hash_generated_method = "6A166C8F2160586F4D65DF16DD6C930A")
    public boolean contentEquals(CharSequence cs) {
        addTaint(cs.getTaint());
        if(cs == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1952046139 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1952046139.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1952046139;
        } //End block
        int len = cs.length();
        if(len != count)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1066920036 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1091667922 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1091667922;
        } //End block
        if(len == 0 && count == 0)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_489237500 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1493675639 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1493675639;
        } //End block
        boolean var7C4767DF1C65C9CDC55D862CFB49D497_1742858412 = (regionMatches(0, cs.toString(), 0, len));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2034858102 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2034858102;
        // ---------- Original Method ----------
        //if (cs == null) {
            //throw new NullPointerException();
        //}
        //int len = cs.length();
        //if (len != count) {
            //return false;
        //}
        //if (len == 0 && count == 0) {
            //return true; 
        //}
        //return regionMatches(0, cs.toString(), 0, len);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.039 -0400", hash_original_method = "54546B1154273B2EF815CC4641C4AF95", hash_generated_method = "9DACEF70DF80417DEFCFDB3340083DD7")
    public boolean matches(String regularExpression) {
        addTaint(regularExpression.getTaint());
        boolean varB9296B2D318A0B882DC46DD2C1860438_326676436 = (Pattern.matches(regularExpression, this));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_324610429 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_324610429;
        // ---------- Original Method ----------
        //return Pattern.matches(regularExpression, this);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.039 -0400", hash_original_method = "85FB9291CC087326BB42DD27D5FF2770", hash_generated_method = "B46BC6586724C9833D0E976DF08F2AB5")
    public String replaceAll(String regularExpression, String replacement) {
        addTaint(replacement.getTaint());
        addTaint(regularExpression.getTaint());
String varEA33858F860192EE40401D6896743D98_1151280762 =         Pattern.compile(regularExpression).matcher(this).replaceAll(replacement);
        varEA33858F860192EE40401D6896743D98_1151280762.addTaint(taint);
        return varEA33858F860192EE40401D6896743D98_1151280762;
        // ---------- Original Method ----------
        //return Pattern.compile(regularExpression).matcher(this).replaceAll(replacement);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.040 -0400", hash_original_method = "B1F6469D7EA429A7B60DE2A4BC9D1B18", hash_generated_method = "CCD44251FC50BF39D24CBE81A302C274")
    public String replaceFirst(String regularExpression, String replacement) {
        addTaint(replacement.getTaint());
        addTaint(regularExpression.getTaint());
String var75A5EDF99A2ECD5BEBD87C014F3D9601_833255159 =         Pattern.compile(regularExpression).matcher(this).replaceFirst(replacement);
        var75A5EDF99A2ECD5BEBD87C014F3D9601_833255159.addTaint(taint);
        return var75A5EDF99A2ECD5BEBD87C014F3D9601_833255159;
        // ---------- Original Method ----------
        //return Pattern.compile(regularExpression).matcher(this).replaceFirst(replacement);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.040 -0400", hash_original_method = "0ADD043F2AA11242F9B6645F9D3630BF", hash_generated_method = "E18D5C9670687CCAF3BEB91178FA3A9F")
    public String[] split(String regularExpression) {
        addTaint(regularExpression.getTaint());
String[] varEDE2F586F6135C3B9F67684709630D11_1162785683 =         split(regularExpression, 0);
        varEDE2F586F6135C3B9F67684709630D11_1162785683.addTaint(taint);
        return varEDE2F586F6135C3B9F67684709630D11_1162785683;
        // ---------- Original Method ----------
        //return split(regularExpression, 0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.040 -0400", hash_original_method = "4FB3AE192250E9EE292BE09F829C7FA4", hash_generated_method = "E4196A066EC5D826B503B63CA5E73605")
    public String[] split(String regularExpression, int limit) {
        addTaint(limit);
        addTaint(regularExpression.getTaint());
        String[] result = java.util.regex.Splitter.fastSplit(regularExpression, this, limit);
String[] varBF10FBBC5ED524E4E4C738A6CDC5996A_1297952310 =         result != null ? result : Pattern.compile(regularExpression).split(this, limit);
        varBF10FBBC5ED524E4E4C738A6CDC5996A_1297952310.addTaint(taint);
        return varBF10FBBC5ED524E4E4C738A6CDC5996A_1297952310;
        // ---------- Original Method ----------
        //String[] result = java.util.regex.Splitter.fastSplit(regularExpression, this, limit);
        //return result != null ? result : Pattern.compile(regularExpression).split(this, limit);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.040 -0400", hash_original_method = "30B2B5AAE6BF00B7B5DE2415CD1C93C0", hash_generated_method = "AFE141B19C1FDD488E5449307B019A5E")
    public CharSequence subSequence(int start, int end) {
        addTaint(end);
        addTaint(start);
CharSequence var14116236EC4BC8D62F0E86641118EABD_1649835730 =         substring(start, end);
        var14116236EC4BC8D62F0E86641118EABD_1649835730.addTaint(taint);
        return var14116236EC4BC8D62F0E86641118EABD_1649835730;
        // ---------- Original Method ----------
        //return substring(start, end);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.090 -0400", hash_original_method = "C7D49B0E887DD351A54FAD0BD917A973", hash_generated_method = "4AA0D970F53A5437960DBB5362FF8172")
    public int codePointAt(int index) {
        addTaint(index);
    if(index < 0 || index >= count)        
        {
    	StringIndexOutOfBoundsException var31A81F65A9D9C0D123C8BD6CC0A6023B_617343388 = indexAndLength(index);
            var31A81F65A9D9C0D123C8BD6CC0A6023B_617343388.addTaint(taint);
            throw var31A81F65A9D9C0D123C8BD6CC0A6023B_617343388;
        } //End block
        int varEE8BC5793D2C542E0A836DB30841DA8A_1658467558 = (Character.codePointAt(value, offset + index, offset + count));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_148219104 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_148219104;
        // ---------- Original Method ----------
        //if (index < 0 || index >= count) {
            //throw indexAndLength(index);
        //}
        //return Character.codePointAt(value, offset + index, offset + count);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.114 -0400", hash_original_method = "45488902F6B74F4C7EAF8C828C18FB65", hash_generated_method = "E474A1580CC8AB31224E1CF48558880A")
    public int codePointBefore(int index) {
        addTaint(index);
    if(index < 1 || index > count)        
        {
    	StringIndexOutOfBoundsException var31A81F65A9D9C0D123C8BD6CC0A6023B_1409268217 = indexAndLength(index);
            var31A81F65A9D9C0D123C8BD6CC0A6023B_1409268217.addTaint(taint);
            throw var31A81F65A9D9C0D123C8BD6CC0A6023B_1409268217;
        } //End block
        int var4AB76CEFEA1FB0DE48F3964B1821A4C6_1597611864 = (Character.codePointBefore(value, offset + index, offset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_674809760 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_674809760;
        // ---------- Original Method ----------
        //if (index < 1 || index > count) {
            //throw indexAndLength(index);
        //}
        //return Character.codePointBefore(value, offset + index, offset);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.142 -0400", hash_original_method = "B50CCA2DE0C54B693E25540AFEB12014", hash_generated_method = "641A2FDB54DC47F97CC5C57D56F8065A")
    public int codePointCount(int start, int end) {
        addTaint(end);
        addTaint(start);
    if(start < 0 || end > count || start > end)        
        {
    	StringIndexOutOfBoundsException varD4320BED3007B31B0BCB1B90CDC7325C_1760037970 = startEndAndLength(start, end);
            varD4320BED3007B31B0BCB1B90CDC7325C_1760037970.addTaint(taint);
            throw varD4320BED3007B31B0BCB1B90CDC7325C_1760037970;
        } //End block
        int varC15299B150726000BD0A690208962788_992060442 = (Character.codePointCount(value, offset + start, end - start));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1762269847 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1762269847;
        // ---------- Original Method ----------
        //if (start < 0 || end > count || start > end) {
            //throw startEndAndLength(start, end);
        //}
        //return Character.codePointCount(value, offset + start, end - start);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.207 -0400", hash_original_method = "994533EB4329C14FF0C3B68A297AD053", hash_generated_method = "964098297A17BA396217CC82A332B954")
    public boolean contains(CharSequence cs) {
        addTaint(cs.getTaint());
        if(cs == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_168201924 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_168201924.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_168201924;
        } //End block
        boolean var5C186F39D60DCFA62F9A0E9A4BD2945E_450641927 = (indexOf(cs.toString()) >= 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2097020565 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2097020565;
        // ---------- Original Method ----------
        //if (cs == null) {
            //throw new NullPointerException();
        //}
        //return indexOf(cs.toString()) >= 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.207 -0400", hash_original_method = "3AF353F7691F77FE6437135BD27DAE4A", hash_generated_method = "3DBCCFD4958BAFF29B7BB0E9B6577608")
    public int offsetByCodePoints(int index, int codePointOffset) {
        addTaint(codePointOffset);
        addTaint(index);
        int s = index + offset;
        int r = Character.offsetByCodePoints(value, offset, count, s, codePointOffset);
        int varE8B06F4D76690CC3F44FECD52F7081B0_141447667 = (r - offset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1938785863 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1938785863;
        // ---------- Original Method ----------
        //int s = index + offset;
        //int r = Character.offsetByCodePoints(value, offset, count, s, codePointOffset);
        //return r - offset;
    }

    
    @DSModeled(DSC.SAFE)
    public static String format(String format, Object... args) {
        return format(Locale.getDefault(), format, args);
    }

    
    @DSModeled(DSC.SAFE)
    public static String format(Locale locale, String format, Object... args) {
        if (format == null) {
            throw new NullPointerException("null format argument");
        }
        int bufferSize = format.length() + (args == null ? 0 : args.length * 10);
        Formatter f = new Formatter(new StringBuilder(bufferSize), locale);
        return f.format(format, args).toString();
    }

    
    @DSModeled(DSC.BAN)
    @SuppressWarnings("unused")
    private static int indexOf(String haystackString, String needleString,
            int cache, int md2, char lastChar) {
        char[] haystack = haystackString.value;
        int haystackOffset = haystackString.offset;
        int haystackLength = haystackString.count;
        char[] needle = needleString.value;
        int needleOffset = needleString.offset;
        int needleLength = needleString.count;
        int needleLengthMinus1 = needleLength - 1;
        int haystackEnd = haystackOffset + haystackLength;
        outer_loop: for (int i = haystackOffset + needleLengthMinus1; i < haystackEnd;) {
            if (lastChar == haystack[i]) {
                for (int j = 0; j < needleLengthMinus1; ++j) {
                    if (needle[j + needleOffset] != haystack[i + j
                            - needleLengthMinus1]) {
                        int skip = 1;
                        if ((cache & (1 << haystack[i])) == 0) {
                            skip += j;
                        }
                        i += Math.max(md2, skip);
                        continue outer_loop;
                    }
                }
                return i - needleLengthMinus1 - haystackOffset;
            }
            if ((cache & (1 << haystack[i])) == 0) {
                i += needleLengthMinus1;
            }
            i++;
        }
        return -1;
    }

    
    private static final class CaseInsensitiveComparator implements Comparator<String>, Serializable {
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.207 -0400", hash_original_method = "4085F5B81BF948B4B3F485D1409A9E33", hash_generated_method = "4085F5B81BF948B4B3F485D1409A9E33")
        public CaseInsensitiveComparator ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.207 -0400", hash_original_method = "10AFFFE45F62C15CA0052EB0BB14A8D3", hash_generated_method = "AD3D1CD9BD682D87B22E6DD13FC925DE")
        public int compare(String o1, String o2) {
            addTaint(o2.getTaint());
            addTaint(o1.getTaint());
            int var2E5A2ED2039C940598A7F8437778CA84_1934433287 = (o1.compareToIgnoreCase(o2));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_787714457 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_787714457;
            // ---------- Original Method ----------
            //return o1.compareToIgnoreCase(o2);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.207 -0400", hash_original_field = "0EB82A8A770CC5893BCFA5E3CA9054B4", hash_generated_field = "094B85F4F683BB296AFE95E1161C88EE")

        private static final long serialVersionUID = 8575799808933029326L;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.207 -0400", hash_original_field = "8F7391E387537113A816F6DA1882EB25", hash_generated_field = "94C8E35BF1C6D0DCD0C640C5B7214BD5")

    private static final long serialVersionUID = -6849794470754667710L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.207 -0400", hash_original_field = "0FA65C778E1E664ED6228A9A8F5E327D", hash_generated_field = "44CEA20EA4711232CF026CC7232D685C")

    private static final char REPLACEMENT_CHAR = (char) 0xfffd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.207 -0400", hash_original_field = "A9AC076FB042F483811BBF9499C903BE", hash_generated_field = "A2069D0DAA8806E284E1501E715FFAC8")

    public static final Comparator<String> CASE_INSENSITIVE_ORDER = new CaseInsensitiveComparator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.208 -0400", hash_original_field = "D2CD8253361A9C732D21CA1D336599CC", hash_generated_field = "6699F3B26E20D4AC1415724EB8FB9705")

    private static char[] ASCII;
    static {
        ASCII = new char[128];
        for (int i = 0; i < ASCII.length; ++i) {
            ASCII[i] = (char) i;
        }
    }
}

