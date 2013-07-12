package java.lang;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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

public final class String implements Serializable, Comparable<String>, CharSequence {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.638 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "C068225E28B5BE74066BE5338158F76B")

    private char[] value;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.638 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "EA4C80BAC452228E60AC0DA2D3E0C953")

    private int offset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.638 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "82CC849FCF58347832EA6BB917282DBE")

    private int count;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.638 -0400", hash_original_field = "550D1CC054A1B23A411DDDA46FD64811", hash_generated_field = "38607001336EF9DE010EF92F750652A2")

    private int hashCode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.639 -0400", hash_original_method = "F65E96A775698E2C256BB1E903F5D8A6", hash_generated_method = "B4FE7A30CB86B25991ECB034EA74BE0F")
    public  String() {
        value = EmptyArray.CHAR;
        offset = 0;
        count = 0;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.640 -0400", hash_original_method = "8A258D0AF74DE6E118252D0EA5531366", hash_generated_method = "A11432EA568E66AD1DE5D8C05C5AB870")
    @SuppressWarnings("unused")
    private  String(String s, char c) {
        offset = 0;
        value = new char[s.count + 1];
        count = s.count + 1;
        System.arraycopy(s.value, s.offset, value, 0, s.count);
        value[s.count] = c;
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.641 -0400", hash_original_method = "3CF6472F1EAFF36B200903831BC9D282", hash_generated_method = "4D4C07B858AC27A3595A4F1ED164415E")
    public  String(byte[] data) {
        this(data, 0, data.length);
        addTaint(data[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.641 -0400", hash_original_method = "94FE9BFA8A903BE49DF8F4E82A84C713", hash_generated_method = "96F2149D8F428069C3C87AA58538065E")
    @Deprecated
    public  String(byte[] data, int high) {
        this(data, high, 0, data.length);
        addTaint(high);
        addTaint(data[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.652 -0400", hash_original_method = "9C5B9D3903B08C7F386C9C307D28A8D8", hash_generated_method = "D6439CB90D6545AC7AC3C86073E9F0E9")
    public  String(byte[] data, int offset, int byteCount) {
        addTaint(byteCount);
        addTaint(data[0]);
    if((offset | byteCount) < 0 || byteCount > data.length - offset)        
        {
            StringIndexOutOfBoundsException var418E2BA1E64B83D51B250BCD9933A252_948252395 = failedBoundsCheck(data.length, offset, byteCount);
            var418E2BA1E64B83D51B250BCD9933A252_948252395.addTaint(taint);
            throw var418E2BA1E64B83D51B250BCD9933A252_948252395;
        } 
        CharBuffer cb = Charset.defaultCharset().decode(ByteBuffer.wrap(data, offset, byteCount));
        this.count = cb.length();
        this.offset = 0;
    if(count > 0)        
        {
            value = cb.array();
        } 
        else
        {
            value = EmptyArray.CHAR;
        } 
        
        
            
        
        
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.695 -0400", hash_original_method = "22A6AFB2E643FB23D243CAF5D019E325", hash_generated_method = "79A975FB90AD0ECD193D044E40A8EEB8")
    @Deprecated
    public  String(byte[] data, int high, int offset, int byteCount) {
    if((offset | byteCount) < 0 || byteCount > data.length - offset)        
        {
    		StringIndexOutOfBoundsException var418E2BA1E64B83D51B250BCD9933A252_1421954499 = failedBoundsCheck(data.length, offset, byteCount);
            var418E2BA1E64B83D51B250BCD9933A252_1421954499.addTaint(taint);
            throw var418E2BA1E64B83D51B250BCD9933A252_1421954499;
        } 
        this.offset = 0;
        this.value = new char[byteCount];
        this.count = byteCount;
        high <<= 8;
for(int i = 0;i < count;i++)
        {
            value[i] = (char) (high + (data[offset++] & 0xff));
        } 
        
        
            
        
        
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.696 -0400", hash_original_method = "D35F458D65648B05442A41C1A12F30CA", hash_generated_method = "3CEEE872B2C15AD5D826CC9768AE132D")
    public  String(byte[] data, int offset, int byteCount, String charsetName) throws UnsupportedEncodingException {
        this(data, offset, byteCount, Charset.forNameUEE(charsetName));
        addTaint(charsetName.getTaint());
        addTaint(byteCount);
        addTaint(offset);
        addTaint(data[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.697 -0400", hash_original_method = "11FE032D0B0EBCDEFC4E4C2065489303", hash_generated_method = "E5BE82FCBB454F307F1387B9FE1B9C0E")
    public  String(byte[] data, String charsetName) throws UnsupportedEncodingException {
        this(data, 0, data.length, Charset.forNameUEE(charsetName));
        addTaint(charsetName.getTaint());
        addTaint(data[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.813 -0400", hash_original_method = "230168F72CB2A0A48AA9F4A7AFCECA03", hash_generated_method = "5CF85473A930BD9609F6F58C62C97D46")
    public  String(byte[] data, int offset, int byteCount, Charset charset) {
        addTaint(charset.getTaint());
        addTaint(data[0]);
    if((offset | byteCount) < 0 || byteCount > data.length - offset)        
        {
    		StringIndexOutOfBoundsException var418E2BA1E64B83D51B250BCD9933A252_1070100322 = failedBoundsCheck(data.length, offset, byteCount);
            var418E2BA1E64B83D51B250BCD9933A252_1070100322.addTaint(taint);
            throw var418E2BA1E64B83D51B250BCD9933A252_1070100322;
        } 
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
                } 
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
                    } 
                    int val = b0 & (0x1f >> (utfCount - 1));
for(int i = 0;i < utfCount;i++)
                    {
                        byte b = d[idx++];
    if((b & 0xC0) != 0x80)                        
                        {
                            v[s++] = REPLACEMENT_CHAR;
                            idx--;
                            continue outer;
                        } 
                        val <<= 6;
                        val |= b & 0x3f;
                    } 
    if((utfCount != 2) && (val >= 0xD800) && (val <= 0xDFFF))                    
                    {
                        v[s++] = REPLACEMENT_CHAR;
                        continue;
                    } 
    if(val > 0x10FFFF)                    
                    {
                        v[s++] = REPLACEMENT_CHAR;
                        continue;
                    } 
    if(val < 0x10000)                    
                    {
                        v[s++] = (char) val;
                    } 
                    else
                    {
                        int x = val & 0xffff;
                        int u = (val >> 16) & 0x1f;
                        int w = (u - 1) & 0xffff;
                        int hi = 0xd800 | (w << 6) | (x >> 10);
                        int lo = 0xdc00 | (x & 0x3ff);
                        v[s++] = (char) hi;
                        v[s++] = (char) lo;
                    } 
                } 
                else
                {
                    v[s++] = REPLACEMENT_CHAR;
                } 
            } 
    if(s == byteCount)            
            {
                this.offset = 0;
                this.value = v;
                this.count = s;
            } 
            else
            {
                this.offset = 0;
                this.value = new char[s];
                this.count = s;
                System.arraycopy(v, 0, value, 0, s);
            } 
        } 
        else
    if(canonicalCharsetName.equals("ISO-8859-1"))        
        {
            this.offset = 0;
            this.value = new char[byteCount];
            this.count = byteCount;
            Charsets.isoLatin1BytesToChars(data, offset, byteCount, value);
        } 
        else
    if(canonicalCharsetName.equals("US-ASCII"))        
        {
            this.offset = 0;
            this.value = new char[byteCount];
            this.count = byteCount;
            Charsets.asciiBytesToChars(data, offset, byteCount, value);
        } 
        else
        {
            CharBuffer cb = charset.decode(ByteBuffer.wrap(data, offset, byteCount));
            this.offset = 0;
            this.count = cb.length();
    if(count > 0)            
            {
                this.value = new char[count];
                System.arraycopy(cb.array(), 0, value, 0, count);
            } 
            else
            {
                this.value = EmptyArray.CHAR;
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.815 -0400", hash_original_method = "9D77FFE69AA84BF1048ED5CBD8EE386C", hash_generated_method = "6C134F8B1B500206BC50C4890F003080")
    public  String(byte[] data, Charset charset) {
        this(data, 0, data.length, charset);
        addTaint(charset.getTaint());
        addTaint(data[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.815 -0400", hash_original_method = "84FF2A14EA759DC7C1F299809C55E832", hash_generated_method = "941AD48499B8A325EBF754DD62D23EFF")
    public  String(char[] data) {
        this(data, 0, data.length);
        addTaint(data[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.828 -0400", hash_original_method = "14BFB40845511D49F067DB0E6AC711FE", hash_generated_method = "971E3234E4344BD64B6C546645470DD3")
    public  String(char[] data, int offset, int charCount) {
        addTaint(data[0]);
    if((offset | charCount) < 0 || charCount > data.length - offset)        
        {
    		StringIndexOutOfBoundsException var2D5E1C324B1811ED1BEE61F6C6CD87C2_678970883 = failedBoundsCheck(data.length, offset, charCount);
            var2D5E1C324B1811ED1BEE61F6C6CD87C2_678970883.addTaint(taint);
            throw var2D5E1C324B1811ED1BEE61F6C6CD87C2_678970883;
        } 
        this.offset = 0;
        this.value = new char[charCount];
        this.count = charCount;
        System.arraycopy(data, offset, value, 0, count);
        
        
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.830 -0400", hash_original_method = "6AA52B72AD5521C733ED3E9463435DD5", hash_generated_method = "99D51D061C47D5C074A83E94BF3BA236")
      String(int offset, int charCount, char[] chars) {
        this.value = chars;
        this.offset = offset;
        this.count = charCount;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.832 -0400", hash_original_method = "7D7AE898849737A5DE2F771028ADD293", hash_generated_method = "7FE6513FD8F04FE77BE3B65E244B762D")
    public  String(String toCopy) {
        value = (toCopy.value.length == toCopy.count)
                ? toCopy.value
                : Arrays.copyOfRange(toCopy.value, toCopy.offset, toCopy.offset + toCopy.length());
        offset = 0;
        count = value.length;
        
        
                
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.834 -0400", hash_original_method = "8B59C74FD130D5556CE63A5F3CE74139", hash_generated_method = "08126433ED54CCD02F64DEF6C42B8545")
    @SuppressWarnings( { "unused", "nls" })
    private  String(String s1, String s2) {
    if(s1 == null)        
        {
            s1 = "null";
        } 
    if(s2 == null)        
        {
            s2 = "null";
        } 
        count = s1.count + s2.count;
        value = new char[count];
        offset = 0;
        System.arraycopy(s1.value, s1.offset, value, 0, s1.count);
        System.arraycopy(s2.value, s2.offset, value, s1.count, s2.count);
        
        
            
        
        
            
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.836 -0400", hash_original_method = "E07460C3146BC4727C3E888CAC21772A", hash_generated_method = "73ACD6CE76E5E989647928EAA1950CB1")
    @SuppressWarnings( { "unused", "nls" })
    private  String(String s1, String s2, String s3) {
    if(s1 == null)        
        {
            s1 = "null";
        } 
    if(s2 == null)        
        {
            s2 = "null";
        } 
    if(s3 == null)        
        {
            s3 = "null";
        } 
        count = s1.count + s2.count + s3.count;
        value = new char[count];
        offset = 0;
        System.arraycopy(s1.value, s1.offset, value, 0, s1.count);
        System.arraycopy(s2.value, s2.offset, value, s1.count, s2.count);
        System.arraycopy(s3.value, s3.offset, value, s1.count + s2.count, s3.count);
        
        
            
        
        
            
        
        
            
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.844 -0400", hash_original_method = "C3DEF5F256BD0FFA01404830FE1A0B0E", hash_generated_method = "9D73BD38C4E1C34F746D9E60AA5559EA")
    public  String(StringBuffer stringBuffer) {
        offset = 0;
        synchronized
(stringBuffer)        {
            value = stringBuffer.shareValue();
            count = stringBuffer.length();
        } 
        
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.865 -0400", hash_original_method = "DE744DAB842D7A0BE4BC8C7648E27967", hash_generated_method = "A4716F806D0CB47D314F039D1EE5E331")
    public  String(int[] codePoints, int offset, int count) {
        addTaint(codePoints[0]);
    if(codePoints == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1224186338 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1224186338.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1224186338;
        } 
    if((offset | count) < 0 || count > codePoints.length - offset)        
        {
    		StringIndexOutOfBoundsException varA2C80B735EE8B9656E28477449237B7F_176723695 = failedBoundsCheck(codePoints.length, offset, count);
            varA2C80B735EE8B9656E28477449237B7F_176723695.addTaint(taint);
            throw varA2C80B735EE8B9656E28477449237B7F_176723695;
        } 
        this.offset = 0;
        this.value = new char[count * 2];
        int end = offset + count;
        int c = 0;
for(int i = offset;i < end;i++)
        {
            c += Character.toChars(codePoints[i], this.value, c);
        } 
        this.count = c;
        
        
            
        
        
            
        
        
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.866 -0400", hash_original_method = "1A43E0983F964C9F4090DA81181B802F", hash_generated_method = "7E5B9FDFA1C4CDCDDA082F7287071AD9")
    public  String(StringBuilder stringBuilder) {
    if(stringBuilder == null)        
        {
            NullPointerException var22BD5F599DD56650EFDED1601FFD0DC3_1297874172 = new NullPointerException("stringBuilder == null");
            var22BD5F599DD56650EFDED1601FFD0DC3_1297874172.addTaint(taint);
            throw var22BD5F599DD56650EFDED1601FFD0DC3_1297874172;
        } 
        this.offset = 0;
        this.count = stringBuilder.length();
        this.value = new char[this.count];
        stringBuilder.getChars(0, this.count, this.value, 0);
        
        
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.868 -0400", hash_original_method = "8767608BAC25DDC267BEC70B13CF72A3", hash_generated_method = "23EDDAB7C39C6B71B48112C650C2BBBB")
    @SuppressWarnings("unused")
    private  String(String s1, int v1) {
        addTaint(v1);
        addTaint(s1.getTaint());
    if(s1 == null)        
        {
            s1 = "null";
        } 
        String s2 = String.valueOf(v1);
        int len = s1.count + s2.count;
        value = new char[len];
        offset = 0;
        System.arraycopy(s1.value, s1.offset, value, 0, s1.count);
        System.arraycopy(s2.value, s2.offset, value, s1.count, s2.count);
        count = len;
        
        
            
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.869 -0400", hash_original_method = "87185450AF15BAF9DFFE5741D5928D9B", hash_generated_method = "8F6B5A83B0F89D74AE41EAF80D53BA3E")
    public char charAt(int index) {
        char varA87DEB01C5F539E6BDA34829C8EF2368_445190880 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_445190880;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.870 -0400", hash_original_method = "00E4125D0AA58BE2E1232BB5FC2C4846", hash_generated_method = "968C1661F8BBF717C5C0E027875CD398")
    private StringIndexOutOfBoundsException indexAndLength(int index) {
        addTaint(index);
        StringIndexOutOfBoundsException var136F60598ADA7E3673E6817775EB8A33_2126953024 = new StringIndexOutOfBoundsException(this, index);
        var136F60598ADA7E3673E6817775EB8A33_2126953024.addTaint(taint);
        throw var136F60598ADA7E3673E6817775EB8A33_2126953024;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.871 -0400", hash_original_method = "C5BE1ED07127E02665146DD0ACED99A5", hash_generated_method = "CC9ABEA4C754CBA57820AE8EFBBF70E5")
    private StringIndexOutOfBoundsException startEndAndLength(int start, int end) {
        addTaint(end);
        addTaint(start);
        StringIndexOutOfBoundsException varABD3BBDB2615D50CC54BA74D32A5E4F6_1852584536 = new StringIndexOutOfBoundsException(this, start, end - start);
        varABD3BBDB2615D50CC54BA74D32A5E4F6_1852584536.addTaint(taint);
        throw varABD3BBDB2615D50CC54BA74D32A5E4F6_1852584536;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.872 -0400", hash_original_method = "FABF855F22C4847A4FF9FC56E0D56C67", hash_generated_method = "B37135BBB6DEB42E4057582E1E5574B6")
    private StringIndexOutOfBoundsException failedBoundsCheck(int arrayLength, int offset, int count) {
        addTaint(count);
        addTaint(offset);
        addTaint(arrayLength);
        StringIndexOutOfBoundsException var4FAD7FC2D125C8A8D11F38CCD1F26725_1867526033 = new StringIndexOutOfBoundsException(arrayLength, offset, count);
        var4FAD7FC2D125C8A8D11F38CCD1F26725_1867526033.addTaint(taint);
        throw var4FAD7FC2D125C8A8D11F38CCD1F26725_1867526033;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.873 -0400", hash_original_method = "1D42C2C4BD065BE4935C25058CB25A0E", hash_generated_method = "B90C97F82A6236C04E6BD947E730EF1C")
    private char foldCase(char ch) {
        addTaint(ch);
    if(ch < 128)        
        {
    if('A' <= ch && ch <= 'Z')            
            {
                char varB5D6DE35E3B68E46A9D6DAF9509D6149_2136873707 = ((char) (ch + ('a' - 'A')));
                                char varA87DEB01C5F539E6BDA34829C8EF2368_1390760631 = getTaintChar();
                return varA87DEB01C5F539E6BDA34829C8EF2368_1390760631;
            } 
            char varD88FC6EDF21EA464D35FF76288B84103_1709145845 = (ch);
                        char varA87DEB01C5F539E6BDA34829C8EF2368_490498503 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_490498503;
        } 
        char var1A18DA882D946DB0067AB53FB250DB6B_1706525786 = (Character.toLowerCase(Character.toUpperCase(ch)));
                char varA87DEB01C5F539E6BDA34829C8EF2368_1195094728 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1195094728;
        
        
            
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.880 -0400", hash_original_method = "E601A465E2566ECC4B972E253D5CFD79", hash_generated_method = "ABD533955CECA4745B6FCC88E572A13D")
    public int compareTo(String string) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2102522673 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2102522673;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.882 -0400", hash_original_method = "1A9A71EFE325E55C19A2B451F1A9B9E2", hash_generated_method = "1EDFDB278D5725BC1206A115ACCF83B5")
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
            } 
            c1 = foldCase(c1);
            c2 = foldCase(c2);
    if((result = c1 - c2) != 0)            
            {
                int varB4A88417B3D0170D754C647C30B7216A_137742271 = (result);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1692133650 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1692133650;
            } 
        } 
        int varAF9D08BE17F109038AD9DBFBDBA98163_614669434 = (count - string.count);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_840398194 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_840398194;
        
        
        
        
        
        
            
                
            
            
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.887 -0400", hash_original_method = "F488471D994E6AC017026A4A172508CF", hash_generated_method = "11140EF33B5053C98C20302D36D0428D")
    public String concat(String string) {
        addTaint(string.getTaint());
    if(string.count > 0 && count > 0)        
        {
            char[] buffer = new char[count + string.count];
            System.arraycopy(value, offset, buffer, 0, count);
            System.arraycopy(string.value, string.offset, buffer, count, string.count);
String varE9BB9A2D22B7506011EAD9776484D5F2_496841510 =             new String(0, buffer.length, buffer);
            varE9BB9A2D22B7506011EAD9776484D5F2_496841510.addTaint(taint);
            return varE9BB9A2D22B7506011EAD9776484D5F2_496841510;
        } 
String varA2304E2602C032397F1C392C6B6B259F_559634071 =         count == 0 ? string : this;
        varA2304E2602C032397F1C392C6B6B259F_559634071.addTaint(taint);
        return varA2304E2602C032397F1C392C6B6B259F_559634071;
        
        
            
            
            
            
        
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.889 -0400", hash_original_method = "3B37EFF40C149A7A244BFEF0002B2C93", hash_generated_method = "61687FE7DCF820385FFE6BC309A14149")
    public boolean endsWith(String suffix) {
        addTaint(suffix.getTaint());
        boolean varEE1D16D5742820344C10CDBFC5FEC4A1_1723998485 = (regionMatches(count - suffix.count, suffix, 0, suffix.count));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_75257372 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_75257372;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.890 -0400", hash_original_method = "84733F87EF08EE029ED9292B40928CC1", hash_generated_method = "48D9E50F32B7FCDD42B75ECB51B59D0A")
    @Override
    public boolean equals(Object object) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_583031363 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_583031363;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.896 -0400", hash_original_method = "2D6A09B1457D58571ED784483A3E54F2", hash_generated_method = "F063E46D8938240D9DB3F9EB1491982C")
    public boolean equalsIgnoreCase(String string) {
        addTaint(string.getTaint());
    if(string == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_685961554 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_444546395 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_444546395;
        } 
    if(string == null || count != string.count)        
        {
            boolean var68934A3E9455FA72420237EB05902327_375466045 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1541555099 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1541555099;
        } 
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
                boolean var68934A3E9455FA72420237EB05902327_1081534126 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_370705015 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_370705015;
            } 
        } 
        boolean varB326B5062B2F0E69046810717534CB09_1745581796 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_933086538 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_933086538;
        
        
            
        
        
            
        
        
        
        
        
            
            
            
                
            
        
        
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
                } 
            } 
            catch (ArrayIndexOutOfBoundsException ignored)
            {
            	StringIndexOutOfBoundsException varD87E3E0DEDBE23D233BE92E396080AE4_1181737688 = failedBoundsCheck(data.length, index, end - start);
                varD87E3E0DEDBE23D233BE92E396080AE4_1181737688.addTaint(taint);
                throw varD87E3E0DEDBE23D233BE92E396080AE4_1181737688;
            } 
        } 
        else
        {
        	StringIndexOutOfBoundsException varD4320BED3007B31B0BCB1B90CDC7325C_794172148 = startEndAndLength(start, end);
            varD4320BED3007B31B0BCB1B90CDC7325C_794172148.addTaint(taint);
            throw varD4320BED3007B31B0BCB1B90CDC7325C_794172148;
        } 
        
        
            
            
                
                    
                
            
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.960 -0400", hash_original_method = "2E4CA200D3933E45C3FC02936B120C89", hash_generated_method = "6991E80407945AA8F4F5EA929621E0C7")
    public byte[] getBytes() {
        byte[] var40B8AAFFEF4AB9778617CA924F87E408_1007349871 = (getBytes(Charset.defaultCharset()));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1813925708 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1813925708;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.961 -0400", hash_original_method = "D1476A765D84241818C22751CEBD7DE3", hash_generated_method = "05BED1E83E566F047D0B63E942274683")
    public byte[] getBytes(String charsetName) throws UnsupportedEncodingException {
        addTaint(charsetName.getTaint());
        byte[] varD79457387769865B64DBACF6E31D0CEE_967812969 = (getBytes(Charset.forNameUEE(charsetName)));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_471340547 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_471340547;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.962 -0400", hash_original_method = "56FDAE3B6641018546E6C6674268142D", hash_generated_method = "065E7762B7E848B3A2A3AD1F84CEC179")
    public byte[] getBytes(Charset charset) {
        addTaint(charset.getTaint());
        String canonicalCharsetName = charset.name();
    if(canonicalCharsetName.equals("UTF-8"))        
        {
            byte[] varA674360BA4F69EF4538856FD4E7DA4E5_762213886 = (Charsets.toUtf8Bytes(value, offset, count));
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1515761149 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1515761149;
        } 
        else
    if(canonicalCharsetName.equals("ISO-8859-1"))        
        {
            byte[] var57953CB2C002567E8B819B70AC3A61A3_511998317 = (Charsets.toIsoLatin1Bytes(value, offset, count));
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_380138617 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_380138617;
        } 
        else
    if(canonicalCharsetName.equals("US-ASCII"))        
        {
            byte[] varB57B592532935D5283F0CB1F052612DB_740415142 = (Charsets.toAsciiBytes(value, offset, count));
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_343888977 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_343888977;
        } 
        else
    if(canonicalCharsetName.equals("UTF-16BE"))        
        {
            byte[] var61071EDD934136B6F916D86F92F54AFA_301114323 = (Charsets.toBigEndianUtf16Bytes(value, offset, count));
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1459764897 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1459764897;
        } 
        else
        {
            CharBuffer chars = CharBuffer.wrap(this.value, this.offset, this.count);
            ByteBuffer buffer = charset.encode(chars.asReadOnlyBuffer());
            byte[] bytes = new byte[buffer.limit()];
            buffer.get(bytes);
            byte[] var4B3A6218BB3E3A7303E8A171A60FCF92_1437527813 = (bytes);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_227721443 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_227721443;
        } 
        
        
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
        } 
        else
        {
        	StringIndexOutOfBoundsException varD4320BED3007B31B0BCB1B90CDC7325C_1302296784 = startEndAndLength(start, end);
            varD4320BED3007B31B0BCB1B90CDC7325C_1302296784.addTaint(taint);
            throw varD4320BED3007B31B0BCB1B90CDC7325C_1302296784;
        } 
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.990 -0400", hash_original_method = "25FFBBE7056EE87BB826458DBC43764C", hash_generated_method = "7F61143154BA5A768C3BBB71E6097C02")
     void _getChars(int start, int end, char[] buffer, int index) {
        addTaint(index);
        addTaint(buffer[0]);
        addTaint(end);
        addTaint(start);
        System.arraycopy(value, start + offset, buffer, index, end - start);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.991 -0400", hash_original_method = "19D1106FC463FB90112A6C6293D6F5CF", hash_generated_method = "C74DD23DC1EFC5073E3CB3720C40352B")
    @Override
    public int hashCode() {
        int hash = hashCode;
    if(hash == 0)        
        {
    if(count == 0)            
            {
                int varCFCD208495D565EF66E7DFF9F98764DA_1522800309 = (0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_115849124 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_115849124;
            } 
            final int end = count + offset;
            final char[] chars = value;
for(int i = offset;i < end;++i)
            {
                hash = 31*hash + chars[i];
            } 
            hashCode = hash;
        } 
        int var0800FC577294C34E0B28AD2839435945_656453542 = (hash);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1089696377 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1089696377;
        
        
        
            
                
            
            
            
            
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.992 -0400", hash_original_method = "C183CC13D668537DB52873A8A3264758", hash_generated_method = "CC03093E4AE2AD70E6B0D1DAABD18398")
    public int indexOf(int c) {
        addTaint(c);
    if(c > 0xffff)        
        {
            int varD3CEBDA0F7ECC1F176D803F0D96220B6_749830899 = (indexOfSupplementary(c, 0));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_929475760 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_929475760;
        } 
        int varE1D822CA7B919C6036F4B2FC85E37827_1480343203 = (fastIndexOf(c, 0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_180240659 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_180240659;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.992 -0400", hash_original_method = "A9B16E70D2A4A056B33DA4268AACFBA9", hash_generated_method = "8293E68F72B855401ABFF185212F3783")
    public int indexOf(int c, int start) {
        addTaint(start);
        addTaint(c);
    if(c > 0xffff)        
        {
            int varA0C83F59E94CDB5B58621787EE400BD8_1218889369 = (indexOfSupplementary(c, start));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_213747261 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_213747261;
        } 
        int varAEFCD9F4AA8873588CB6C0CCD17FC320_1063610964 = (fastIndexOf(c, start));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1770526292 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1770526292;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.993 -0400", hash_original_method = "158E0BDE7178D291CA067E7481407A6C", hash_generated_method = "09F4340B3A66B6E7D4726D876566E515")
    private int fastIndexOf(int c, int start) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1070719470 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1070719470;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.994 -0400", hash_original_method = "9DA1418F8A10F302F688A26755CAB088", hash_generated_method = "3FEB0ADDD227A968D421D69A4D0274B8")
    private int indexOfSupplementary(int c, int start) {
        addTaint(start);
        addTaint(c);
    if(!Character.isSupplementaryCodePoint(c))        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_986751866 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1208284888 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1208284888;
        } 
        char[] chars = Character.toChars(c);
        String needle = new String(0, chars.length, chars);
        int var4D6FA9B54EECF201E001C5B99EBBA47A_563313376 = (indexOf(needle, start));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1132355986 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1132355986;
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.995 -0400", hash_original_method = "AC187DA6A9C2600FBA62EFD5097D8F4D", hash_generated_method = "761C0D1E2ABA3398E6E7D7D72E980EF8")
    public int indexOf(String string) {
        addTaint(string.getTaint());
        int start = 0;
        int subCount = string.count;
        int _count = count;
    if(subCount > 0)        
        {
    if(subCount > _count)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_738339535 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1591220902 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1591220902;
            } 
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
                    int var6BB61E3B7BCE0931DA574D19D1D82C88_559565910 = (-1);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_254908810 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_254908810;
                } 
                int o1 = offset + i;
                int o2 = subOffset;
                char[] _value = value;
                while
(++o2 < end && _value[++o1] == target[o2])                
                {
                } 
    if(o2 == end)                
                {
                    int var865C0C0B4AB0E063E5CAA3387C1A8741_2028965900 = (i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_511801312 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_511801312;
                } 
                start = i + 1;
            } 
        } 
        int varADAFC68F8BEE4E16FDF8D4A6C2A12389_559656654 = (start < _count ? start : _count);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1769418435 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1769418435;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.996 -0400", hash_original_method = "30C77F2F1070D21229A0301D2E3C23FC", hash_generated_method = "6A30E846CD98649A44675F4A9066BA30")
    public int indexOf(String subString, int start) {
        addTaint(start);
        addTaint(subString.getTaint());
    if(start < 0)        
        {
            start = 0;
        } 
        int subCount = subString.count;
        int _count = count;
    if(subCount > 0)        
        {
    if(subCount + start > _count)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_298011595 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2088094525 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2088094525;
            } 
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
                    int var6BB61E3B7BCE0931DA574D19D1D82C88_666394655 = (-1);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1132743897 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1132743897;
                } 
                int o1 = offset + i;
                int o2 = subOffset;
                char[] _value = value;
                while
(++o2 < end && _value[++o1] == target[o2])                
                {
                } 
    if(o2 == end)                
                {
                    int var865C0C0B4AB0E063E5CAA3387C1A8741_475323845 = (i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_352726407 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_352726407;
                } 
                start = i + 1;
            } 
        } 
        int varADAFC68F8BEE4E16FDF8D4A6C2A12389_80191144 = (start < _count ? start : _count);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_929614483 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_929614483;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.870 -0400", hash_original_method = "8D834ED1699A050AD62397187973DE2A", hash_generated_method = "D27768EE08A87AC5AC201AAF7BA53F8D")
    public String intern() {
    	return new String();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.997 -0400", hash_original_method = "9B1CCC3AB82A9C7B7A46C788921405FB", hash_generated_method = "764EDB068900546E2EF1950DC9C673CF")
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1427494045 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1427494045;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.998 -0400", hash_original_method = "B7458CFA700437DC398BF47C5A311056", hash_generated_method = "A0603BAFB7FD2A97D664335E1BCCB10F")
    public int lastIndexOf(int c) {
        addTaint(c);
    if(c > 0xffff)        
        {
            int var6E5770380FEEE7FD6DD2799DB6A9AD81_483732227 = (lastIndexOfSupplementary(c, Integer.MAX_VALUE));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_623368800 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_623368800;
        } 
        int _count = count;
        int _offset = offset;
        char[] _value = value;
for(int i = _offset + _count - 1;i >= _offset;--i)
        {
    if(_value[i] == c)            
            {
                int var5337D1DABEE183C1C63FE794773606DE_1226261296 = (i - _offset);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1031555385 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1031555385;
            } 
        } 
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1734185671 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_473774091 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_473774091;
        
        
            
        
        
        
        
        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.999 -0400", hash_original_method = "438C7E0E01B0881067FA33086AF4D678", hash_generated_method = "F604305CE3DD05C3F8DE4AD244319720")
    public int lastIndexOf(int c, int start) {
        addTaint(start);
        addTaint(c);
    if(c > 0xffff)        
        {
            int varF4A58EFA790A6736D48CC1F5D71659F2_1460276015 = (lastIndexOfSupplementary(c, start));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1565719332 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1565719332;
        } 
        int _count = count;
        int _offset = offset;
        char[] _value = value;
    if(start >= 0)        
        {
    if(start >= _count)            
            {
                start = _count - 1;
            } 
for(int i = _offset + start;i >= _offset;--i)
            {
    if(_value[i] == c)                
                {
                    int var5337D1DABEE183C1C63FE794773606DE_167854379 = (i - _offset);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_914926801 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_914926801;
                } 
            } 
        } 
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1528598503 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_822694574 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_822694574;
        
        
            
        
        
        
        
        
            
                
            
            
                
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.000 -0400", hash_original_method = "ECC6B0EDCC4F01358439BB31BFF21134", hash_generated_method = "BBE3E31C9B2A35FD9F5E72982D39BC43")
    private int lastIndexOfSupplementary(int c, int start) {
        addTaint(start);
        addTaint(c);
    if(!Character.isSupplementaryCodePoint(c))        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_83109621 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1968301122 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1968301122;
        } 
        char[] chars = Character.toChars(c);
        String needle = new String(0, chars.length, chars);
        int var276BC97A9352F9AA9C2C20C10ADF746E_183700221 = (lastIndexOf(needle, start));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_317546971 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_317546971;
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.000 -0400", hash_original_method = "692347B4AF93950259A2DA740A39B258", hash_generated_method = "7888F5318637EA432BF6BB2AEFA468A6")
    public int lastIndexOf(String string) {
        addTaint(string.getTaint());
        int var9D74F68960E009CAC27271987951F701_900877925 = (lastIndexOf(string, count));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_681807428 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_681807428;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.001 -0400", hash_original_method = "08D5FBAA11FAAE0244D1BD87258C05E0", hash_generated_method = "37D79CA30BFAF8EA0568058C9D6E8A41")
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
                } 
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
                        int var6BB61E3B7BCE0931DA574D19D1D82C88_538611980 = (-1);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_732921699 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_732921699;
                    } 
                    int o1 = offset + i;
                    int o2 = subOffset;
                    while
(++o2 < end && value[++o1] == target[o2])                    
                    {
                    } 
    if(o2 == end)                    
                    {
                        int var865C0C0B4AB0E063E5CAA3387C1A8741_639803663 = (i);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1800251595 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1800251595;
                    } 
                    start = i - 1;
                } 
            } 
            int var0FFB83E5F2423119ED71A6AA9F842533_236240709 = (start < count ? start : count);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2082670522 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2082670522;
        } 
        int var6BB61E3B7BCE0931DA574D19D1D82C88_81612934 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2009131615 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2009131615;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.002 -0400", hash_original_method = "026D3AE6EA7284BA85CF864429138595", hash_generated_method = "DBAFA13C5905E84284335E22BBFBAA36")
    public int length() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1626004647 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1626004647;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.003 -0400", hash_original_method = "8EA3BFAB97A4D4877FC2554FB493C6C0", hash_generated_method = "3A59A52D47F381CA6F323A816740F08A")
    public boolean regionMatches(int thisStart, String string, int start, int length) {
        addTaint(length);
        addTaint(start);
        addTaint(string.getTaint());
        addTaint(thisStart);
    if(string == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_942247369 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_942247369.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_942247369;
        } 
    if(start < 0 || string.count - start < length)        
        {
            boolean var68934A3E9455FA72420237EB05902327_38676870 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1146040814 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1146040814;
        } 
    if(thisStart < 0 || count - thisStart < length)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1303898218 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2019958237 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2019958237;
        } 
    if(length <= 0)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_377758130 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1855807523 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1855807523;
        } 
        int o1 = offset + thisStart;
        int o2 = string.offset + start;
        char[] value1 = value;
        char[] value2 = string.value;
for(int i = 0;i < length;++i)
        {
    if(value1[o1 + i] != value2[o2 + i])            
            {
                boolean var68934A3E9455FA72420237EB05902327_499526660 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_313442782 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_313442782;
            } 
        } 
        boolean varB326B5062B2F0E69046810717534CB09_236392583 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_387666849 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_387666849;
        
        
            
        
        
            
        
        
            
        
        
            
        
        
        
        
        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.005 -0400", hash_original_method = "5098FC46543D7D1A735E08AA962F8003", hash_generated_method = "DAE297E3724585D48DB172AE9E9DB06A")
    public boolean regionMatches(boolean ignoreCase, int thisStart, String string, int start, int length) {
        addTaint(length);
        addTaint(start);
        addTaint(string.getTaint());
        addTaint(thisStart);
        addTaint(ignoreCase);
    if(!ignoreCase)        
        {
            boolean var2189525ECA24E85E0448401995CDE08C_1895802193 = (regionMatches(thisStart, string, start, length));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_260821874 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_260821874;
        } 
    if(string == null)        
        {
            NullPointerException var5776BA98BE2EEDBB80F0AAA5C4D7B456_1574599008 = new NullPointerException("string == null");
            var5776BA98BE2EEDBB80F0AAA5C4D7B456_1574599008.addTaint(taint);
            throw var5776BA98BE2EEDBB80F0AAA5C4D7B456_1574599008;
        } 
    if(thisStart < 0 || length > count - thisStart)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1211117814 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1150266434 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1150266434;
        } 
    if(start < 0 || length > string.count - start)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1558493095 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_530212520 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_530212520;
        } 
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
                boolean var68934A3E9455FA72420237EB05902327_1485075545 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_904159087 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_904159087;
            } 
        } 
        boolean varB326B5062B2F0E69046810717534CB09_214618937 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1945877325 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1945877325;
        
        
            
        
        
            
        
        
            
        
        
            
        
        
        
        
        
        
            
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.007 -0400", hash_original_method = "52751D07523F52C15F0E15149B768BF7", hash_generated_method = "450AF341A333003093176F1DAF7BCC85")
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
                } 
                buffer[idx] = newChar;
            } 
            idx++;
        } 
String var21DC98D17784CFD779867A4B4E93FDC2_2065958839 =         copied ? new String(0, count, buffer) : this;
        var21DC98D17784CFD779867A4B4E93FDC2_2065958839.addTaint(taint);
        return var21DC98D17784CFD779867A4B4E93FDC2_2065958839;
        
        
        
        
        
        
        
        
            
                
                    
                    
                    
                    
                    
                    
                
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.008 -0400", hash_original_method = "226EAAC156D556D42E48670E64FEC4E8", hash_generated_method = "A016251225CCF8387FE2689213B2C8B7")
    public String replace(CharSequence target, CharSequence replacement) {
        addTaint(replacement.getTaint());
        addTaint(target.getTaint());
    if(target == null)        
        {
            NullPointerException var0DB6377415E5B25FCBED699A3836CC18_1816970433 = new NullPointerException("target == null");
            var0DB6377415E5B25FCBED699A3836CC18_1816970433.addTaint(taint);
            throw var0DB6377415E5B25FCBED699A3836CC18_1816970433;
        } 
    if(replacement == null)        
        {
            NullPointerException var6ECD5DD11CA7B1724ECEB1D26AE441C2_900215841 = new NullPointerException("replacement == null");
            var6ECD5DD11CA7B1724ECEB1D26AE441C2_900215841.addTaint(taint);
            throw var6ECD5DD11CA7B1724ECEB1D26AE441C2_900215841;
        } 
        String targetString = target.toString();
        int matchStart = indexOf(targetString, 0);
    if(matchStart == -1)        
        {
String var72A74007B2BE62B849F475C7BDA4658B_1090422653 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1090422653.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1090422653;
        } 
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
            } 
String varE65B3A02759122992CB82C0E651AD408_2048192352 =             result.toString();
            varE65B3A02759122992CB82C0E651AD408_2048192352.addTaint(taint);
            return varE65B3A02759122992CB82C0E651AD408_2048192352;
        } 
        StringBuilder result = new StringBuilder(count);
        int searchStart = 0;
        do {
            {
                result.append(value, offset + searchStart, matchStart - searchStart);
                result.append(replacementString);
                searchStart = matchStart + targetLength;
            } 
} while ((matchStart = indexOf(targetString, searchStart)) != -1);
        result.append(value, offset + searchStart, count - searchStart);
String varE65B3A02759122992CB82C0E651AD408_1059924309 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_1059924309.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_1059924309;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.009 -0400", hash_original_method = "8508513C5D9E5D7A42B020CFB91803A3", hash_generated_method = "8A34D7E695CF8B1249870CF281986009")
    public boolean startsWith(String prefix) {
        addTaint(prefix.getTaint());
        boolean varB2B8CC9FB05263CFCC376EFAC155326D_1511538739 = (startsWith(prefix, 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1890426291 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1890426291;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.010 -0400", hash_original_method = "DCA59D254EE64B3144EDF9B3ACB43A45", hash_generated_method = "B04CCC8DF98278E539C893F47B9AA80E")
    public boolean startsWith(String prefix, int start) {
        addTaint(start);
        addTaint(prefix.getTaint());
        boolean var524D3DB2C2708210A1134A37BDC13952_1510173326 = (regionMatches(start, prefix, 0, prefix.count));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2028972331 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2028972331;
        
        
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
        } 
    if(start >= 0 && start <= count)        
        {
String var2B0D1736DD1B19490531C381A1416ABB_1242432222 =             new String(offset + start, count - start, value);
            var2B0D1736DD1B19490531C381A1416ABB_1242432222.addTaint(taint);
            return var2B0D1736DD1B19490531C381A1416ABB_1242432222;
        } 
    	StringIndexOutOfBoundsException varC9C52284361B891C0CBD2284A6FE0828_1101455365 = indexAndLength(start);
        varC9C52284361B891C0CBD2284A6FE0828_1101455365.addTaint(taint);
        throw varC9C52284361B891C0CBD2284A6FE0828_1101455365;
        
        
            
        
        
            
        
        
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
        } 
    if(start >= 0 && start <= end && end <= count)        
        {
String var2511EA3E5FEAAD0D48B436EB1999CC85_1798446020 =             new String(offset + start, end - start, value);
            var2511EA3E5FEAAD0D48B436EB1999CC85_1798446020.addTaint(taint);
            return var2511EA3E5FEAAD0D48B436EB1999CC85_1798446020;
        } 
    	StringIndexOutOfBoundsException varD4320BED3007B31B0BCB1B90CDC7325C_134150222 = startEndAndLength(start, end);
        varD4320BED3007B31B0BCB1B90CDC7325C_134150222.addTaint(taint);
        throw varD4320BED3007B31B0BCB1B90CDC7325C_134150222;
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.050 -0400", hash_original_method = "66BAEF040BB5FDC80731F9B16CD33C32", hash_generated_method = "21BCC689908B6F6A0A836290EE56AA4D")
    public char[] toCharArray() {
        char[] buffer = new char[count];
        System.arraycopy(value, offset, buffer, 0, count);
        char[] var7F2DB423A49B305459147332FB01CF87_180944411 = (buffer);
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_744848473 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_744848473;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.050 -0400", hash_original_method = "1FBB4BF6938E55C9E24FEC1EE0A95252", hash_generated_method = "4D018BC1E4DE4FA8B3C3575C59C38A57")
    public String toLowerCase() {
String varC7E95AB710071E5387F1F7434BE3B06A_511566022 =         CaseMapper.toLowerCase(Locale.getDefault(), this, value, offset, count);
        varC7E95AB710071E5387F1F7434BE3B06A_511566022.addTaint(taint);
        return varC7E95AB710071E5387F1F7434BE3B06A_511566022;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.051 -0400", hash_original_method = "3BCA227A64DF8F05552679E5E357BCF1", hash_generated_method = "242C5098F8FEE5422A51EAA76E268495")
    public String toLowerCase(Locale locale) {
        addTaint(locale.getTaint());
String var66112C226335D29F28D767C8BADE9A5D_1501353068 =         CaseMapper.toLowerCase(locale, this, value, offset, count);
        var66112C226335D29F28D767C8BADE9A5D_1501353068.addTaint(taint);
        return var66112C226335D29F28D767C8BADE9A5D_1501353068;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.052 -0400", hash_original_method = "068E2EE4236B85776135405F1B66AD49", hash_generated_method = "52F21EB40675A5DF322C09AF548BF198")
    @Override
    public String toString() {
String var72A74007B2BE62B849F475C7BDA4658B_2054383802 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2054383802.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2054383802;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.052 -0400", hash_original_method = "8DEC33A26AFC2829CCCCE108ECEB9551", hash_generated_method = "FA8C10FB4AD4F58A597F080B5E14F652")
    public String toUpperCase() {
String var739E07D85DF1A71755B19B0014421FE8_1647985505 =         CaseMapper.toUpperCase(Locale.getDefault(), this, value, offset, count);
        var739E07D85DF1A71755B19B0014421FE8_1647985505.addTaint(taint);
        return var739E07D85DF1A71755B19B0014421FE8_1647985505;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.053 -0400", hash_original_method = "11C711663B7D81E6BD865533BF51B442", hash_generated_method = "E7FA7CE31F62448BC9ACD18B195D51F8")
    public String toUpperCase(Locale locale) {
        addTaint(locale.getTaint());
String var82F6F2D929DCCB4BC26C1A03BB63616B_1325879977 =         CaseMapper.toUpperCase(locale, this, value, offset, count);
        var82F6F2D929DCCB4BC26C1A03BB63616B_1325879977.addTaint(taint);
        return var82F6F2D929DCCB4BC26C1A03BB63616B_1325879977;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.054 -0400", hash_original_method = "5AB01C88F799E5B54FF71EE82B91E811", hash_generated_method = "AF39530DC1689CCFAA9A30FDBB02EA24")
    public String trim() {
        int start = offset;
        int last = offset + count - 1;
        int end = last;
        while
((start <= end) && (value[start] <= ' '))        
        {
            start++;
        } 
        while
((end >= start) && (value[end] <= ' '))        
        {
            end--;
        } 
    if(start == offset && end == last)        
        {
String var72A74007B2BE62B849F475C7BDA4658B_1191712914 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1191712914.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1191712914;
        } 
String var354324DED16A0B9E2EC7A1041A7B3943_854668777 =         new String(start, end - start + 1, value);
        var354324DED16A0B9E2EC7A1041A7B3943_854668777.addTaint(taint);
        return var354324DED16A0B9E2EC7A1041A7B3943_854668777;
        
        
        
        
            
        
        
            
        
        
            
        
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.059 -0400", hash_original_method = "233CB676C051D9EE76740A9343D1B467", hash_generated_method = "02C0FBE99BE84623DC5F10881B9237EF")
    public boolean contentEquals(StringBuffer strbuf) {
        addTaint(strbuf.getTaint());
        synchronized
(strbuf)        {
            int size = strbuf.length();
    if(count != size)            
            {
                boolean var68934A3E9455FA72420237EB05902327_2124499034 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2077050481 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2077050481;
            } 
            boolean var7202922E8F4091534B32D730FE9BE69D_1004170298 = (regionMatches(0, new String(0, size, strbuf.getValue()), 0,
                    size));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2060002634 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2060002634;
        } 
        
        
            
            
                
            
            
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.060 -0400", hash_original_method = "733340B51AD84F3351AE4177729AE631", hash_generated_method = "E5FEA12A6554401BBF700D51FE116E68")
    public boolean contentEquals(CharSequence cs) {
        addTaint(cs.getTaint());
    if(cs == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1530098563 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1530098563.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1530098563;
        } 
        int len = cs.length();
    if(len != count)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1240420206 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_372512651 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_372512651;
        } 
    if(len == 0 && count == 0)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1083279283 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_576554784 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_576554784;
        } 
        boolean var7C4767DF1C65C9CDC55D862CFB49D497_1009522168 = (regionMatches(0, cs.toString(), 0, len));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1330522419 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1330522419;
        
        
            
        
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.061 -0400", hash_original_method = "54546B1154273B2EF815CC4641C4AF95", hash_generated_method = "CBCEBD4C4FF4002CE0C7B3B53FE8E610")
    public boolean matches(String regularExpression) {
        addTaint(regularExpression.getTaint());
        boolean varB9296B2D318A0B882DC46DD2C1860438_1195414246 = (Pattern.matches(regularExpression, this));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1269752517 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1269752517;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.062 -0400", hash_original_method = "85FB9291CC087326BB42DD27D5FF2770", hash_generated_method = "B63A73572B52906B28D68EFB146A005A")
    public String replaceAll(String regularExpression, String replacement) {
        addTaint(replacement.getTaint());
        addTaint(regularExpression.getTaint());
String varEA33858F860192EE40401D6896743D98_1974842715 =         Pattern.compile(regularExpression).matcher(this).replaceAll(replacement);
        varEA33858F860192EE40401D6896743D98_1974842715.addTaint(taint);
        return varEA33858F860192EE40401D6896743D98_1974842715;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.063 -0400", hash_original_method = "B1F6469D7EA429A7B60DE2A4BC9D1B18", hash_generated_method = "8172CD8FA9F410FAEC925A834E81D7FB")
    public String replaceFirst(String regularExpression, String replacement) {
        addTaint(replacement.getTaint());
        addTaint(regularExpression.getTaint());
String var75A5EDF99A2ECD5BEBD87C014F3D9601_1814155341 =         Pattern.compile(regularExpression).matcher(this).replaceFirst(replacement);
        var75A5EDF99A2ECD5BEBD87C014F3D9601_1814155341.addTaint(taint);
        return var75A5EDF99A2ECD5BEBD87C014F3D9601_1814155341;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.064 -0400", hash_original_method = "0ADD043F2AA11242F9B6645F9D3630BF", hash_generated_method = "226BF62F133085580A4F6DA9A8F1F62C")
    public String[] split(String regularExpression) {
        addTaint(regularExpression.getTaint());
String[] varEDE2F586F6135C3B9F67684709630D11_438494039 =         split(regularExpression, 0);
        varEDE2F586F6135C3B9F67684709630D11_438494039.addTaint(taint);
        return varEDE2F586F6135C3B9F67684709630D11_438494039;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.064 -0400", hash_original_method = "4FB3AE192250E9EE292BE09F829C7FA4", hash_generated_method = "40732B47D552EB53222CED198FB02F4D")
    public String[] split(String regularExpression, int limit) {
        addTaint(limit);
        addTaint(regularExpression.getTaint());
        String[] result = java.util.regex.Splitter.fastSplit(regularExpression, this, limit);
String[] varBF10FBBC5ED524E4E4C738A6CDC5996A_1549477930 =         result != null ? result : Pattern.compile(regularExpression).split(this, limit);
        varBF10FBBC5ED524E4E4C738A6CDC5996A_1549477930.addTaint(taint);
        return varBF10FBBC5ED524E4E4C738A6CDC5996A_1549477930;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.065 -0400", hash_original_method = "30B2B5AAE6BF00B7B5DE2415CD1C93C0", hash_generated_method = "D5DC353B63312C97AF492918BAE79C32")
    public CharSequence subSequence(int start, int end) {
        addTaint(end);
        addTaint(start);
CharSequence var14116236EC4BC8D62F0E86641118EABD_458525488 =         substring(start, end);
        var14116236EC4BC8D62F0E86641118EABD_458525488.addTaint(taint);
        return var14116236EC4BC8D62F0E86641118EABD_458525488;
        
        
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
        } 
        int varEE8BC5793D2C542E0A836DB30841DA8A_1658467558 = (Character.codePointAt(value, offset + index, offset + count));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_148219104 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_148219104;
        
        
            
        
        
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
        } 
        int var4AB76CEFEA1FB0DE48F3964B1821A4C6_1597611864 = (Character.codePointBefore(value, offset + index, offset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_674809760 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_674809760;
        
        
            
        
        
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
        } 
        int varC15299B150726000BD0A690208962788_992060442 = (Character.codePointCount(value, offset + start, end - start));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1762269847 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1762269847;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.143 -0400", hash_original_method = "994533EB4329C14FF0C3B68A297AD053", hash_generated_method = "207B0F8AACC5F1643AA23AA5655DF8E0")
    public boolean contains(CharSequence cs) {
        addTaint(cs.getTaint());
    if(cs == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1202467987 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1202467987.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1202467987;
        } 
        boolean var5C186F39D60DCFA62F9A0E9A4BD2945E_1853167501 = (indexOf(cs.toString()) >= 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_83174940 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_83174940;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.144 -0400", hash_original_method = "3AF353F7691F77FE6437135BD27DAE4A", hash_generated_method = "446D615C31163BA7CC438B746F297620")
    public int offsetByCodePoints(int index, int codePointOffset) {
        addTaint(codePointOffset);
        addTaint(index);
        int s = index + offset;
        int r = Character.offsetByCodePoints(value, offset, count, s, codePointOffset);
        int varE8B06F4D76690CC3F44FECD52F7081B0_2005140534 = (r - offset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2137575851 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2137575851;
        
        
        
        
    }

    
        public static String format(String format, Object... args) {
        return format(Locale.getDefault(), format, args);
    }

    
        public static String format(Locale locale, String format, Object... args) {
        if (format == null) {
            throw new NullPointerException("null format argument");
        }
        int bufferSize = format.length() + (args == null ? 0 : args.length * 10);
        Formatter f = new Formatter(new StringBuilder(bufferSize), locale);
        return f.format(format, args).toString();
    }

    
        @DSModeled(DSC.SAFE)
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.148 -0400", hash_original_method = "4085F5B81BF948B4B3F485D1409A9E33", hash_generated_method = "4085F5B81BF948B4B3F485D1409A9E33")
        public CaseInsensitiveComparator ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.148 -0400", hash_original_method = "10AFFFE45F62C15CA0052EB0BB14A8D3", hash_generated_method = "33D046C4796C99E36627257D5B926B55")
        public int compare(String o1, String o2) {
            addTaint(o2.getTaint());
            addTaint(o1.getTaint());
            int var2E5A2ED2039C940598A7F8437778CA84_1311361690 = (o1.compareToIgnoreCase(o2));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_583922572 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_583922572;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.149 -0400", hash_original_field = "0EB82A8A770CC5893BCFA5E3CA9054B4", hash_generated_field = "094B85F4F683BB296AFE95E1161C88EE")

        private static final long serialVersionUID = 8575799808933029326L;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.149 -0400", hash_original_field = "8F7391E387537113A816F6DA1882EB25", hash_generated_field = "94C8E35BF1C6D0DCD0C640C5B7214BD5")

    private static final long serialVersionUID = -6849794470754667710L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.149 -0400", hash_original_field = "0FA65C778E1E664ED6228A9A8F5E327D", hash_generated_field = "44CEA20EA4711232CF026CC7232D685C")

    private static final char REPLACEMENT_CHAR = (char) 0xfffd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.150 -0400", hash_original_field = "A9AC076FB042F483811BBF9499C903BE", hash_generated_field = "A2069D0DAA8806E284E1501E715FFAC8")

    public static final Comparator<String> CASE_INSENSITIVE_ORDER = new CaseInsensitiveComparator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.150 -0400", hash_original_field = "D2CD8253361A9C732D21CA1D336599CC", hash_generated_field = "6699F3B26E20D4AC1415724EB8FB9705")

    private static char[] ASCII;
    static {
        ASCII = new char[128];
        for (int i = 0; i < ASCII.length; ++i) {
            ASCII[i] = (char) i;
        }
    }
    
}

