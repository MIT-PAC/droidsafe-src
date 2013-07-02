package java.lang;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.840 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "C068225E28B5BE74066BE5338158F76B")

    private char[] value;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.840 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "EA4C80BAC452228E60AC0DA2D3E0C953")

    private int offset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.840 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "82CC849FCF58347832EA6BB917282DBE")

    private int count;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.840 -0400", hash_original_field = "550D1CC054A1B23A411DDDA46FD64811", hash_generated_field = "38607001336EF9DE010EF92F750652A2")

    private int hashCode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.840 -0400", hash_original_method = "F65E96A775698E2C256BB1E903F5D8A6", hash_generated_method = "B4FE7A30CB86B25991ECB034EA74BE0F")
    public  String() {
        value = EmptyArray.CHAR;
        offset = 0;
        count = 0;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.841 -0400", hash_original_method = "8A258D0AF74DE6E118252D0EA5531366", hash_generated_method = "A11432EA568E66AD1DE5D8C05C5AB870")
    @SuppressWarnings("unused")
    private  String(String s, char c) {
        offset = 0;
        value = new char[s.count + 1];
        count = s.count + 1;
        System.arraycopy(s.value, s.offset, value, 0, s.count);
        value[s.count] = c;
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.841 -0400", hash_original_method = "3CF6472F1EAFF36B200903831BC9D282", hash_generated_method = "D9B2763DAEC3FA911416976C82B626C0")
    @FindBugsSuppressWarnings("DM_DEFAULT_ENCODING")
    public  String(byte[] data) {
        this(data, 0, data.length);
        addTaint(data[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.841 -0400", hash_original_method = "94FE9BFA8A903BE49DF8F4E82A84C713", hash_generated_method = "9663CF0FEB97BF7EB6580F530C6B724A")
    @Deprecated
    public  String(byte[] data, int high) {
        this(data, high, 0, data.length);
        addTaint(data[0]);
        addTaint(high);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.842 -0400", hash_original_method = "9C5B9D3903B08C7F386C9C307D28A8D8", hash_generated_method = "422F7F2467B1A6F44F2BD5E97673527F")
    public  String(byte[] data, int offset, int byteCount) {
        {
            if (DroidSafeAndroidRuntime.control) throw failedBoundsCheck(data.length, offset, byteCount);
        } 
        CharBuffer cb = Charset.defaultCharset().decode(ByteBuffer.wrap(data, offset, byteCount));
        this.count = cb.length();
        this.offset = 0;
        {
            value = cb.array();
        } 
        {
            value = EmptyArray.CHAR;
        } 
        addTaint(data[0]);
        addTaint(byteCount);
        
        
            
        
        
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.842 -0400", hash_original_method = "22A6AFB2E643FB23D243CAF5D019E325", hash_generated_method = "881C040C407878FE7E6EE5F09228DCA5")
    @Deprecated
    public  String(byte[] data, int high, int offset, int byteCount) {
        {
            if (DroidSafeAndroidRuntime.control) throw failedBoundsCheck(data.length, offset, byteCount);
        } 
        this.offset = 0;
        this.value = new char[byteCount];
        this.count = byteCount;
        high <<= 8;
        {
            int i = 0;
            {
                value[i] = (char) (high + (data[offset++] & 0xff));
            } 
        } 
        
        
            
        
        
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.842 -0400", hash_original_method = "D35F458D65648B05442A41C1A12F30CA", hash_generated_method = "EEB0BC209E58B40BE8E9ECC5AE799192")
    public  String(byte[] data, int offset, int byteCount, String charsetName) throws UnsupportedEncodingException {
        this(data, offset, byteCount, Charset.forNameUEE(charsetName));
        addTaint(data[0]);
        addTaint(offset);
        addTaint(byteCount);
        addTaint(charsetName.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.843 -0400", hash_original_method = "11FE032D0B0EBCDEFC4E4C2065489303", hash_generated_method = "E50E134873024BEA11DDDECA122E3C10")
    public  String(byte[] data, String charsetName) throws UnsupportedEncodingException {
        this(data, 0, data.length, Charset.forNameUEE(charsetName));
        addTaint(data[0]);
        addTaint(charsetName.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.845 -0400", hash_original_method = "230168F72CB2A0A48AA9F4A7AFCECA03", hash_generated_method = "1FEC5C601A59E741FA47908DC8683CCF")
    public  String(byte[] data, int offset, int byteCount, Charset charset) {
        {
            if (DroidSafeAndroidRuntime.control) throw failedBoundsCheck(data.length, offset, byteCount);
        } 
        String canonicalCharsetName = charset.name();
        {
            boolean var0E259348489811E6C7821E4884476552_1465278296 = (canonicalCharsetName.equals("UTF-8"));
            {
                byte[] d = data;
                char[] v = new char[byteCount];
                int idx = offset;
                int last = offset + byteCount;
                int s = 0;
                {
                    byte b0 = d[idx++];
                    {
                        int val = b0 & 0xff;
                        v[s++] = (char) val;
                    } 
                    {
                        int utfCount = 1;
                        utfCount = 2;
                        utfCount = 3;
                        utfCount = 4;
                        utfCount = 5;
                        {
                            v[s++] = REPLACEMENT_CHAR;
                        } 
                        int val = b0 & (0x1f >> (utfCount - 1));
                        {
                            int i = 0;
                            {
                                byte b = d[idx++];
                                {
                                    v[s++] = REPLACEMENT_CHAR;
                                } 
                                val <<= 6;
                                val |= b & 0x3f;
                            } 
                        } 
                        {
                            v[s++] = REPLACEMENT_CHAR;
                        } 
                        {
                            v[s++] = REPLACEMENT_CHAR;
                        } 
                        {
                            v[s++] = (char) val;
                        } 
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
                    {
                        v[s++] = REPLACEMENT_CHAR;
                    } 
                } 
                {
                    this.offset = 0;
                    this.value = v;
                    this.count = s;
                } 
                {
                    this.offset = 0;
                    this.value = new char[s];
                    this.count = s;
                    System.arraycopy(v, 0, value, 0, s);
                } 
            } 
            {
                boolean var2031B49659F344E6C3E3DB6AFAE490EC_1767574675 = (canonicalCharsetName.equals("ISO-8859-1"));
                {
                    this.offset = 0;
                    this.value = new char[byteCount];
                    this.count = byteCount;
                    Charsets.isoLatin1BytesToChars(data, offset, byteCount, value);
                } 
                {
                    boolean var0569C8B22675C76A7219D23CD23689EC_498976251 = (canonicalCharsetName.equals("US-ASCII"));
                    {
                        this.offset = 0;
                        this.value = new char[byteCount];
                        this.count = byteCount;
                        Charsets.asciiBytesToChars(data, offset, byteCount, value);
                    } 
                    {
                        CharBuffer cb = charset.decode(ByteBuffer.wrap(data, offset, byteCount));
                        this.offset = 0;
                        this.count = cb.length();
                        {
                            this.value = new char[count];
                            System.arraycopy(cb.array(), 0, value, 0, count);
                        } 
                        {
                            this.value = EmptyArray.CHAR;
                        } 
                    } 
                } 
            } 
        } 
        addTaint(data[0]);
        addTaint(charset.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.846 -0400", hash_original_method = "9D77FFE69AA84BF1048ED5CBD8EE386C", hash_generated_method = "391D2D3517ED818DAA8D1BF2C89D0149")
    public  String(byte[] data, Charset charset) {
        this(data, 0, data.length, charset);
        addTaint(data[0]);
        addTaint(charset.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.846 -0400", hash_original_method = "84FF2A14EA759DC7C1F299809C55E832", hash_generated_method = "941AD48499B8A325EBF754DD62D23EFF")
    public  String(char[] data) {
        this(data, 0, data.length);
        addTaint(data[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.846 -0400", hash_original_method = "14BFB40845511D49F067DB0E6AC711FE", hash_generated_method = "9711FDD928545CD562C5F1FC976AE316")
    public  String(char[] data, int offset, int charCount) {
        {
            if (DroidSafeAndroidRuntime.control) throw failedBoundsCheck(data.length, offset, charCount);
        } 
        this.offset = 0;
        this.value = new char[charCount];
        this.count = charCount;
        System.arraycopy(data, offset, value, 0, count);
        addTaint(data[0]);
        
        
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.846 -0400", hash_original_method = "6AA52B72AD5521C733ED3E9463435DD5", hash_generated_method = "99D51D061C47D5C074A83E94BF3BA236")
      String(int offset, int charCount, char[] chars) {
        this.value = chars;
        this.offset = offset;
        this.count = charCount;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.847 -0400", hash_original_method = "7D7AE898849737A5DE2F771028ADD293", hash_generated_method = "7FE6513FD8F04FE77BE3B65E244B762D")
    public  String(String toCopy) {
        value = (toCopy.value.length == toCopy.count)
                ? toCopy.value
                : Arrays.copyOfRange(toCopy.value, toCopy.offset, toCopy.offset + toCopy.length());
        offset = 0;
        count = value.length;
        
        
                
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.847 -0400", hash_original_method = "8B59C74FD130D5556CE63A5F3CE74139", hash_generated_method = "FD34902ACA3ED9507797C78D651C9587")
    @SuppressWarnings( { "unused", "nls" })
    private  String(String s1, String s2) {
        {
            s1 = "null";
        } 
        {
            s2 = "null";
        } 
        count = s1.count + s2.count;
        value = new char[count];
        offset = 0;
        System.arraycopy(s1.value, s1.offset, value, 0, s1.count);
        System.arraycopy(s2.value, s2.offset, value, s1.count, s2.count);
        
        
            
        
        
            
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.848 -0400", hash_original_method = "E07460C3146BC4727C3E888CAC21772A", hash_generated_method = "DA75623189E000AB10E1F76F16862FFB")
    @SuppressWarnings( { "unused", "nls" })
    private  String(String s1, String s2, String s3) {
        {
            s1 = "null";
        } 
        {
            s2 = "null";
        } 
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.848 -0400", hash_original_method = "C3DEF5F256BD0FFA01404830FE1A0B0E", hash_generated_method = "92DDD0018AB3F17B668EEFFDDDAA343E")
    public  String(StringBuffer stringBuffer) {
        offset = 0;
        {
            value = stringBuffer.shareValue();
            count = stringBuffer.length();
        } 
        
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.849 -0400", hash_original_method = "DE744DAB842D7A0BE4BC8C7648E27967", hash_generated_method = "E202A8D6E1933AD3A4C5F3624395DC55")
    public  String(int[] codePoints, int offset, int count) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw failedBoundsCheck(codePoints.length, offset, count);
        } 
        this.offset = 0;
        this.value = new char[count * 2];
        int end = offset + count;
        int c = 0;
        {
            int i = offset;
            {
                c += Character.toChars(codePoints[i], this.value, c);
            } 
        } 
        this.count = c;
        addTaint(codePoints[0]);
        
        
            
        
        
            
        
        
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.849 -0400", hash_original_method = "1A43E0983F964C9F4090DA81181B802F", hash_generated_method = "1A854E0B2080EFC30E2ABD8E801E7118")
    public  String(StringBuilder stringBuilder) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("stringBuilder == null");
        } 
        this.offset = 0;
        this.count = stringBuilder.length();
        this.value = new char[this.count];
        stringBuilder.getChars(0, this.count, this.value, 0);
        
        
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.850 -0400", hash_original_method = "8767608BAC25DDC267BEC70B13CF72A3", hash_generated_method = "B8286A0E67E636EDF3A30E946A2CC073")
    @SuppressWarnings("unused")
    private  String(String s1, int v1) {
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
        addTaint(s1.getTaint());
        addTaint(v1);
        
        
            
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.850 -0400", hash_original_method = "87185450AF15BAF9DFFE5741D5928D9B", hash_generated_method = "A4ED9DA0653F0B326D209330EB1583DD")
    public char charAt(int index) {
        char varA87DEB01C5F539E6BDA34829C8EF2368_1935859544 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1935859544;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.850 -0400", hash_original_method = "00E4125D0AA58BE2E1232BB5FC2C4846", hash_generated_method = "7AB291E3C15F71928CD72C5D3C710C9E")
    private StringIndexOutOfBoundsException indexAndLength(int index) {
        
        addTaint(index);
        throw new StringIndexOutOfBoundsException(this, index);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.851 -0400", hash_original_method = "C5BE1ED07127E02665146DD0ACED99A5", hash_generated_method = "06ACD7700CBBB17F93B3C1C6892432FD")
    private StringIndexOutOfBoundsException startEndAndLength(int start, int end) {

        addTaint(start);
        addTaint(end);
        throw new StringIndexOutOfBoundsException(this, start, end - start);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.851 -0400", hash_original_method = "FABF855F22C4847A4FF9FC56E0D56C67", hash_generated_method = "E5EBE079CC06EC87E395099037376628")
    private StringIndexOutOfBoundsException failedBoundsCheck(int arrayLength, int offset, int count) {
        
        addTaint(arrayLength);
        addTaint(offset);
        addTaint(count);
        throw new StringIndexOutOfBoundsException(arrayLength, offset, count);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.852 -0400", hash_original_method = "1D42C2C4BD065BE4935C25058CB25A0E", hash_generated_method = "B9D1809FF65639BB123204C2EC8253E4")
    private char foldCase(char ch) {
        char var9B0B758EFD0A99F7034CDAE5D13E5009_641715743 = (Character.toLowerCase(Character.toUpperCase(ch)));
        addTaint(ch);
        char varA87DEB01C5F539E6BDA34829C8EF2368_2057584643 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_2057584643;
        
        
            
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.852 -0400", hash_original_method = "E601A465E2566ECC4B972E253D5CFD79", hash_generated_method = "2C2E73128CEBD9260730547B605C63BE")
    public int compareTo(String string) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1188905946 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1188905946;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.853 -0400", hash_original_method = "1A9A71EFE325E55C19A2B451F1A9B9E2", hash_generated_method = "BE4AA4C57100A1097FD3FC7E9C38BA1E")
    public int compareToIgnoreCase(String string) {
        int o1 = offset;
        int o2 = string.offset;
        int result;
        int end = offset + (count < string.count ? count : string.count);
        char c1;
        char c2;
        char[] target = string.value;
        {
            {
                boolean var2E9E8AD3BCB62DCA1A9EF12A54A2335D_936285828 = ((c1 = value[o1++]) == (c2 = target[o2++]));
            } 
            c1 = foldCase(c1);
            c2 = foldCase(c2);
            {
                boolean var14CE4A2902BB903E7AFCF8659D231EE2_951191646 = ((result = c1 - c2) != 0);
            } 
        } 
        addTaint(string.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1155184639 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1155184639;
        
        
        
        
        
        
            
                
            
            
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.855 -0400", hash_original_method = "F488471D994E6AC017026A4A172508CF", hash_generated_method = "C5B8C428DEACA19BD6EF3DE1E087931F")
    public String concat(String string) {
        String varB4EAC82CA7396A68D541C85D26508E83_1943160604 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_16907835 = null; 
        {
            char[] buffer = new char[count + string.count];
            System.arraycopy(value, offset, buffer, 0, count);
            System.arraycopy(string.value, string.offset, buffer, count, string.count);
            varB4EAC82CA7396A68D541C85D26508E83_1943160604 = new String(0, buffer.length, buffer);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_16907835 = count == 0 ? string : this;
        addTaint(string.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1274519369; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1274519369 = varB4EAC82CA7396A68D541C85D26508E83_1943160604;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1274519369 = varB4EAC82CA7396A68D541C85D26508E83_16907835;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1274519369.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1274519369;
        
        
            
            
            
            
        
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.859 -0400", hash_original_method = "3B37EFF40C149A7A244BFEF0002B2C93", hash_generated_method = "0E727C60EFBD113672BBDB741FA5750E")
    public boolean endsWith(String suffix) {
        boolean var76E82A4292B5A1451345CC76AEDF9E15_1950482850 = (regionMatches(count - suffix.count, suffix, 0, suffix.count));
        addTaint(suffix.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2050282208 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2050282208;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.860 -0400", hash_original_method = "84733F87EF08EE029ED9292B40928CC1", hash_generated_method = "6DC370F55DF4B5442913B03A7564721E")
    @Override
    public boolean equals(Object object) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_994746545 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_994746545;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.861 -0400", hash_original_method = "2D6A09B1457D58571ED784483A3E54F2", hash_generated_method = "628AA917EB8F6B4BB4E5F299B7A81C5B")
    @FindBugsSuppressWarnings("ES_COMPARING_PARAMETER_STRING_WITH_EQ")
    public boolean equalsIgnoreCase(String string) {
        {
            boolean var1A493DD12B2DD12B14C7BFE23A6D6C8D_857497647 = (string == this);
        } 
        int o1 = offset;
        int o2 = string.offset;
        int end = offset + count;
        char[] target = string.value;
        {
            char c1 = value[o1++];
            char c2 = target[o2++];
            {
                boolean var43349C3464A5FA3039AFB5B028B91212_1023135946 = (c1 != c2 && foldCase(c1) != foldCase(c2));
            } 
        } 
        addTaint(string.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_191385308 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_191385308;
        
        
            
        
        
            
        
        
        
        
        
            
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.862 -0400", hash_original_method = "628C355D58441C62D711BC1C2A898A67", hash_generated_method = "89362501DE4487A1E7E76AFE0493AA3F")
    @Deprecated
    public void getBytes(int start, int end, byte[] data, int index) {
        {
            end += offset;
            try 
            {
                {
                    int i = offset + start;
                    {
                        data[index++] = (byte) value[i];
                    } 
                } 
            } 
            catch (ArrayIndexOutOfBoundsException ignored)
            {
                if (DroidSafeAndroidRuntime.control) throw failedBoundsCheck(data.length, index, end - start);
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw startEndAndLength(start, end);
        } 
        addTaint(start);
        addTaint(end);
        addTaint(data[0]);
        addTaint(index);
        
        
            
            
                
                    
                
            
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.863 -0400", hash_original_method = "2E4CA200D3933E45C3FC02936B120C89", hash_generated_method = "32EC442B197298925AB32DC59E943A84")
    public byte[] getBytes() {
        byte[] var7AC26898B1876959AE0198114C4F4FA9_456292969 = (getBytes(Charset.defaultCharset()));
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1104036608 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1104036608;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.863 -0400", hash_original_method = "D1476A765D84241818C22751CEBD7DE3", hash_generated_method = "C345CC1E174089228D155B37EB65D154")
    public byte[] getBytes(String charsetName) throws UnsupportedEncodingException {
        byte[] var41B1FB585A68731BDFB62182D33FDD75_384844143 = (getBytes(Charset.forNameUEE(charsetName)));
        addTaint(charsetName.getTaint());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_457432496 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_457432496;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.864 -0400", hash_original_method = "56FDAE3B6641018546E6C6674268142D", hash_generated_method = "A382AF454386AD75F95913B15B1FD87E")
    public byte[] getBytes(Charset charset) {
        String canonicalCharsetName = charset.name();
        {
            boolean var0E259348489811E6C7821E4884476552_539405975 = (canonicalCharsetName.equals("UTF-8"));
            {
                byte[] var9984FE416A6160547A4291CF12EF5977_936898221 = (Charsets.toUtf8Bytes(value, offset, count));
            } 
            {
                boolean var2031B49659F344E6C3E3DB6AFAE490EC_2064037822 = (canonicalCharsetName.equals("ISO-8859-1"));
                {
                    byte[] var06F12C18AB207C990E645C1634999BCA_187984135 = (Charsets.toIsoLatin1Bytes(value, offset, count));
                } 
                {
                    boolean var0569C8B22675C76A7219D23CD23689EC_1093772856 = (canonicalCharsetName.equals("US-ASCII"));
                    {
                        byte[] var5EE1291BC0FFD1569DC7607C427C86B6_1584351913 = (Charsets.toAsciiBytes(value, offset, count));
                    } 
                    {
                        boolean var0EE7227B231600ECBF464F0787D46244_1971507315 = (canonicalCharsetName.equals("UTF-16BE"));
                        {
                            byte[] varE1DCEC963687DDFBF9CF1214AE9B988C_2131137931 = (Charsets.toBigEndianUtf16Bytes(value, offset, count));
                        } 
                        {
                            CharBuffer chars = CharBuffer.wrap(this.value, this.offset, this.count);
                            ByteBuffer buffer = charset.encode(chars.asReadOnlyBuffer());
                            byte[] bytes = new byte[buffer.limit()];
                            buffer.get(bytes);
                        } 
                    } 
                } 
            } 
        } 
        addTaint(charset.getTaint());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2043118985 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2043118985;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.864 -0400", hash_original_method = "D443F19C798F5645F696FD1973BB47C6", hash_generated_method = "2F954EDE4E6FF8CC0CF77F27DB17902F")
    public void getChars(int start, int end, char[] buffer, int index) {
        {
            System.arraycopy(value, start + offset, buffer, index, end - start);
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw startEndAndLength(start, end);
        } 
        addTaint(start);
        addTaint(end);
        addTaint(buffer[0]);
        addTaint(index);
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.865 -0400", hash_original_method = "25FFBBE7056EE87BB826458DBC43764C", hash_generated_method = "BC6509E5F5F3A4E23CFFDEBC23B1C41D")
     void _getChars(int start, int end, char[] buffer, int index) {
        System.arraycopy(value, start + offset, buffer, index, end - start);
        addTaint(start);
        addTaint(end);
        addTaint(buffer[0]);
        addTaint(index);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.865 -0400", hash_original_method = "19D1106FC463FB90112A6C6293D6F5CF", hash_generated_method = "1FD8E27C2A94C89C9BC94D04CAF577A7")
    @Override
    public int hashCode() {
        int hash = hashCode;
        {
            final int end = count + offset;
            final char[] chars = value;
            {
                int i = offset;
                {
                    hash = 31*hash + chars[i];
                } 
            } 
            hashCode = hash;
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2027518543 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2027518543;
        
        
        
            
                
            
            
            
            
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.866 -0400", hash_original_method = "C183CC13D668537DB52873A8A3264758", hash_generated_method = "29DC655485D0619CFAC847A9D4B4616D")
    public int indexOf(int c) {
        {
            int var5F851632D6BAA470138E8E6B8CF03AB6_1174689102 = (indexOfSupplementary(c, 0));
        } 
        int varBDF102D3B3DB28ED5C430C6E4DC71DED_1594321894 = (fastIndexOf(c, 0));
        addTaint(c);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_994434734 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_994434734;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.867 -0400", hash_original_method = "A9B16E70D2A4A056B33DA4268AACFBA9", hash_generated_method = "DAB15CD9ABACB8BDAF23679F56BE6BC7")
    public int indexOf(int c, int start) {
        {
            int var5B650999CF272FFC32489F6C46D5030B_1546777620 = (indexOfSupplementary(c, start));
        } 
        int varF6149B4A88E68FEA46885B131E2A52C3_1499564387 = (fastIndexOf(c, start));
        addTaint(c);
        addTaint(start);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_702485863 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_702485863;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.868 -0400", hash_original_method = "158E0BDE7178D291CA067E7481407A6C", hash_generated_method = "5FBBB9859C36B9B73AA06D44C1802DC9")
    private int fastIndexOf(int c, int start) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_37896317 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_37896317;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.868 -0400", hash_original_method = "9DA1418F8A10F302F688A26755CAB088", hash_generated_method = "9B00A283E698AA00F6891CF84E490BAC")
    private int indexOfSupplementary(int c, int start) {
        {
            boolean var1055287EA357B1E539F33F3672FA88F7_726779549 = (!Character.isSupplementaryCodePoint(c));
        } 
        char[] chars = Character.toChars(c);
        String needle = new String(0, chars.length, chars);
        int var6E5631C6B9EDE9258144E71393C64491_720048384 = (indexOf(needle, start));
        addTaint(c);
        addTaint(start);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1653316664 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1653316664;
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.869 -0400", hash_original_method = "AC187DA6A9C2600FBA62EFD5097D8F4D", hash_generated_method = "A942DE956185707833B2437EB99C55EA")
    public int indexOf(String string) {
        int start = 0;
        int subCount = string.count;
        int _count = count;
        {
            char[] target = string.value;
            int subOffset = string.offset;
            char firstChar = target[subOffset];
            int end = subOffset + subCount;
            {
                int i = indexOf(firstChar, start);
                int o1 = offset + i;
                int o2 = subOffset;
                char[] _value = value;
                start = i + 1;
            } 
        } 
        addTaint(string.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_713307514 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_713307514;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.870 -0400", hash_original_method = "30C77F2F1070D21229A0301D2E3C23FC", hash_generated_method = "EF4CE5C2E917913C466B9A63A2492BEE")
    public int indexOf(String subString, int start) {
        {
            start = 0;
        } 
        int subCount = subString.count;
        int _count = count;
        {
            char[] target = subString.value;
            int subOffset = subString.offset;
            char firstChar = target[subOffset];
            int end = subOffset + subCount;
            {
                int i = indexOf(firstChar, start);
                int o1 = offset + i;
                int o2 = subOffset;
                char[] _value = value;
                start = i + 1;
            } 
        } 
        addTaint(subString.getTaint());
        addTaint(start);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1583011137 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1583011137;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.870 -0400", hash_original_method = "8D834ED1699A050AD62397187973DE2A", hash_generated_method = "D27768EE08A87AC5AC201AAF7BA53F8D")
    public String intern() {
        
    	return new String();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.870 -0400", hash_original_method = "9B1CCC3AB82A9C7B7A46C788921405FB", hash_generated_method = "8D0482BCB2FBF60F3F9DEB0A7AB7D0E6")
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_655754125 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_655754125;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.870 -0400", hash_original_method = "B7458CFA700437DC398BF47C5A311056", hash_generated_method = "E3DA4C35C0EAB1CDDB3329A0C573C348")
    public int lastIndexOf(int c) {
        {
            int varBD342ABA258412F8C448797D2A456C93_698792374 = (lastIndexOfSupplementary(c, Integer.MAX_VALUE));
        } 
        int _count = count;
        int _offset = offset;
        char[] _value = value;
        {
            int i = _offset + _count - 1;
        } 
        addTaint(c);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2129513017 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2129513017;
        
        
            
        
        
        
        
        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.871 -0400", hash_original_method = "438C7E0E01B0881067FA33086AF4D678", hash_generated_method = "0732056C1F1C2FDDFC148508596225BD")
    public int lastIndexOf(int c, int start) {
        {
            int var6EE07AE0B8AD5BD57E677DC6C0B33723_826319541 = (lastIndexOfSupplementary(c, start));
        } 
        int _count = count;
        int _offset = offset;
        char[] _value = value;
        {
            {
                start = _count - 1;
            } 
            {
                int i = _offset + start;
            } 
        } 
        addTaint(c);
        addTaint(start);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1679542268 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1679542268;
        
        
            
        
        
        
        
        
            
                
            
            
                
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.871 -0400", hash_original_method = "ECC6B0EDCC4F01358439BB31BFF21134", hash_generated_method = "A1FBE98D28EEB1D579628ADF9EA1FD1A")
    private int lastIndexOfSupplementary(int c, int start) {
        {
            boolean var1055287EA357B1E539F33F3672FA88F7_809956215 = (!Character.isSupplementaryCodePoint(c));
        } 
        char[] chars = Character.toChars(c);
        String needle = new String(0, chars.length, chars);
        int varB6048C8F2399670687E5E6BB049C087D_237961285 = (lastIndexOf(needle, start));
        addTaint(c);
        addTaint(start);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_7909202 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_7909202;
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.872 -0400", hash_original_method = "692347B4AF93950259A2DA740A39B258", hash_generated_method = "D4AB1805E0D008AFCE75A64FAA9A44FD")
    public int lastIndexOf(String string) {
        int var629483EEC7DE422E0B8E730771A3942E_1585383532 = (lastIndexOf(string, count));
        addTaint(string.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_128488939 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_128488939;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.872 -0400", hash_original_method = "08D5FBAA11FAAE0244D1BD87258C05E0", hash_generated_method = "21CD7E79D3963798976B31973DD052F8")
    public int lastIndexOf(String subString, int start) {
        int subCount = subString.count;
        {
            {
                {
                    start = count - subCount;
                } 
                char[] target = subString.value;
                int subOffset = subString.offset;
                char firstChar = target[subOffset];
                int end = subOffset + subCount;
                {
                    int i = lastIndexOf(firstChar, start);
                    int o1 = offset + i;
                    int o2 = subOffset;
                    start = i - 1;
                } 
            } 
        } 
        addTaint(subString.getTaint());
        addTaint(start);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1443051295 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1443051295;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.872 -0400", hash_original_method = "026D3AE6EA7284BA85CF864429138595", hash_generated_method = "C6CEABF0BC7A98FDD37374EA809B1FFA")
    public int length() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_471119927 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_471119927;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.873 -0400", hash_original_method = "8EA3BFAB97A4D4877FC2554FB493C6C0", hash_generated_method = "14CA066F04C961A97450DF839F8B2A9D")
    public boolean regionMatches(int thisStart, String string, int start, int length) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        int o1 = offset + thisStart;
        int o2 = string.offset + start;
        char[] value1 = value;
        char[] value2 = string.value;
        {
            int i = 0;
        } 
        addTaint(thisStart);
        addTaint(string.getTaint());
        addTaint(start);
        addTaint(length);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_591564704 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_591564704;
        
        
            
        
        
            
        
        
            
        
        
            
        
        
        
        
        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.874 -0400", hash_original_method = "5098FC46543D7D1A735E08AA962F8003", hash_generated_method = "B66BC5D2CD32C969E91C741EB82386A1")
    public boolean regionMatches(boolean ignoreCase, int thisStart, String string, int start, int length) {
        {
            boolean var6F73B44E0EF89A3667DD4B1125A02E25_36481219 = (regionMatches(thisStart, string, start, length));
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("string == null");
        } 
        thisStart += offset;
        start += string.offset;
        int end = thisStart + length;
        char[] target = string.value;
        {
            char c1 = value[thisStart++];
            char c2 = target[start++];
            {
                boolean var43349C3464A5FA3039AFB5B028B91212_1805611302 = (c1 != c2 && foldCase(c1) != foldCase(c2));
            } 
        } 
        addTaint(ignoreCase);
        addTaint(thisStart);
        addTaint(string.getTaint());
        addTaint(start);
        addTaint(length);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_351456032 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_351456032;
        
        
            
        
        
            
        
        
            
        
        
            
        
        
        
        
        
        
            
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.875 -0400", hash_original_method = "52751D07523F52C15F0E15149B768BF7", hash_generated_method = "596BD108175778DC9EDF09FDF7C1EBB8")
    public String replace(char oldChar, char newChar) {
        String varB4EAC82CA7396A68D541C85D26508E83_134087156 = null; 
        char[] buffer = value;
        int _offset = offset;
        int _count = count;
        int idx = _offset;
        int last = _offset + _count;
        boolean copied = false;
        {
            {
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
        } 
        varB4EAC82CA7396A68D541C85D26508E83_134087156 = copied ? new String(0, count, buffer) : this;
        addTaint(oldChar);
        addTaint(newChar);
        varB4EAC82CA7396A68D541C85D26508E83_134087156.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_134087156;
        
        
        
        
        
        
        
        
            
                
                    
                    
                    
                    
                    
                    
                
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.876 -0400", hash_original_method = "226EAAC156D556D42E48670E64FEC4E8", hash_generated_method = "E1A655089D8F647C4E8832A97F1ED39D")
    public String replace(CharSequence target, CharSequence replacement) {
        String varB4EAC82CA7396A68D541C85D26508E83_1755472808 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_293623047 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_632289377 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("target == null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("replacement == null");
        } 
        String targetString = target.toString();
        int matchStart = indexOf(targetString, 0);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1755472808 = this;
        } 
        String replacementString = replacement.toString();
        int targetLength = targetString.length();
        {
            int resultLength = (count + 2) * replacementString.length();
            StringBuilder result = new StringBuilder(resultLength);
            result.append(replacementString);
            {
                int i = offset;
                {
                    result.append(value[i]);
                    result.append(replacementString);
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_293623047 = result.toString();
        } 
        StringBuilder result = new StringBuilder(count);
        int searchStart = 0;
        {
            result.append(value, offset + searchStart, matchStart - searchStart);
            result.append(replacementString);
            searchStart = matchStart + targetLength;
        } 
        {
            boolean varDF5B9E27CB5E1F6FE60A3DAF131B74C7_1807087288 = ((matchStart = indexOf(targetString, searchStart)) != -1);
        } 
        result.append(value, offset + searchStart, count - searchStart);
        varB4EAC82CA7396A68D541C85D26508E83_632289377 = result.toString();
        addTaint(target.getTaint());
        addTaint(replacement.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1891449349; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1891449349 = varB4EAC82CA7396A68D541C85D26508E83_1755472808;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1891449349 = varB4EAC82CA7396A68D541C85D26508E83_293623047;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1891449349 = varB4EAC82CA7396A68D541C85D26508E83_632289377;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1891449349.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1891449349;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.877 -0400", hash_original_method = "8508513C5D9E5D7A42B020CFB91803A3", hash_generated_method = "357C8DEE576D593E7FC5C04A0C759AA1")
    public boolean startsWith(String prefix) {
        boolean varE400B78CFCF899225EE690557CD93052_2131786850 = (startsWith(prefix, 0));
        addTaint(prefix.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1400882774 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1400882774;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.877 -0400", hash_original_method = "DCA59D254EE64B3144EDF9B3ACB43A45", hash_generated_method = "F6A9890CFF20D6E43FEE0A8BCFBE8B49")
    public boolean startsWith(String prefix, int start) {
        boolean varA8E1CDADA007E83510DD5CFA9EE42F80_1102759802 = (regionMatches(start, prefix, 0, prefix.count));
        addTaint(prefix.getTaint());
        addTaint(start);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_232168166 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_232168166;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.879 -0400", hash_original_method = "CB27750752A8934950488E0046CA5119", hash_generated_method = "5E3AD61EDDAFD465B4145DF29C287B74")
    public String substring(int start) {
        String varB4EAC82CA7396A68D541C85D26508E83_437422253 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_267471632 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_437422253 = this;
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_267471632 = new String(offset + start, count - start, value);
        } 
        if (DroidSafeAndroidRuntime.control) throw indexAndLength(start);
        addTaint(start);
        String varA7E53CE21691AB073D9660D615818899_928520119; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_928520119 = varB4EAC82CA7396A68D541C85D26508E83_437422253;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_928520119 = varB4EAC82CA7396A68D541C85D26508E83_267471632;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_928520119.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_928520119;
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.880 -0400", hash_original_method = "FA273138383309E9BFDA8AAE2A7C6025", hash_generated_method = "E2E4290E6CEC8F61C516FCC33E89CF7E")
    public String substring(int start, int end) {
        String varB4EAC82CA7396A68D541C85D26508E83_1849347231 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1214438824 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1849347231 = this;
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1214438824 = new String(offset + start, end - start, value);
        } 
        if (DroidSafeAndroidRuntime.control) throw startEndAndLength(start, end);
        addTaint(start);
        addTaint(end);
        String varA7E53CE21691AB073D9660D615818899_1614298595; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1614298595 = varB4EAC82CA7396A68D541C85D26508E83_1849347231;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1614298595 = varB4EAC82CA7396A68D541C85D26508E83_1214438824;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1614298595.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1614298595;
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.882 -0400", hash_original_method = "66BAEF040BB5FDC80731F9B16CD33C32", hash_generated_method = "C8AF57E684BDF73BFDEE75C719DA7E68")
    public char[] toCharArray() {
        char[] buffer = new char[count];
        System.arraycopy(value, offset, buffer, 0, count);
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_1557427277 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1557427277;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.884 -0400", hash_original_method = "1FBB4BF6938E55C9E24FEC1EE0A95252", hash_generated_method = "F459BE82A0EA6CABF0C183918BDECB8F")
    public String toLowerCase() {
        String varB4EAC82CA7396A68D541C85D26508E83_999860379 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_999860379 = CaseMapper.toLowerCase(Locale.getDefault(), this, value, offset, count);
        varB4EAC82CA7396A68D541C85D26508E83_999860379.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_999860379;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.886 -0400", hash_original_method = "3BCA227A64DF8F05552679E5E357BCF1", hash_generated_method = "5E22A88311EEA9BD1B0D0A571240A6FC")
    public String toLowerCase(Locale locale) {
        String varB4EAC82CA7396A68D541C85D26508E83_112543282 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_112543282 = CaseMapper.toLowerCase(locale, this, value, offset, count);
        addTaint(locale.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_112543282.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_112543282;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.887 -0400", hash_original_method = "068E2EE4236B85776135405F1B66AD49", hash_generated_method = "8A75BB9BFE89E7BE3D0F0B8F4362174F")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1100079241 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1100079241 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1100079241.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1100079241;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.888 -0400", hash_original_method = "8DEC33A26AFC2829CCCCE108ECEB9551", hash_generated_method = "F10DE1CC4596950903A20F338DE4CAC0")
    public String toUpperCase() {
        String varB4EAC82CA7396A68D541C85D26508E83_1751176457 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1751176457 = CaseMapper.toUpperCase(Locale.getDefault(), this, value, offset, count);
        varB4EAC82CA7396A68D541C85D26508E83_1751176457.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1751176457;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.889 -0400", hash_original_method = "11C711663B7D81E6BD865533BF51B442", hash_generated_method = "4F6695CE1A4A762FCA1C8D5C7CCCD276")
    public String toUpperCase(Locale locale) {
        String varB4EAC82CA7396A68D541C85D26508E83_614969320 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_614969320 = CaseMapper.toUpperCase(locale, this, value, offset, count);
        addTaint(locale.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_614969320.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_614969320;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.891 -0400", hash_original_method = "5AB01C88F799E5B54FF71EE82B91E811", hash_generated_method = "2DB50FCA40B5B0CFE7AD88931FF2CFBC")
    public String trim() {
        String varB4EAC82CA7396A68D541C85D26508E83_1334475510 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_888700719 = null; 
        int start = offset;
        int last = offset + count - 1;
        int end = last;
        {
            varB4EAC82CA7396A68D541C85D26508E83_1334475510 = this;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_888700719 = new String(start, end - start + 1, value);
        String varA7E53CE21691AB073D9660D615818899_1846738867; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1846738867 = varB4EAC82CA7396A68D541C85D26508E83_1334475510;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1846738867 = varB4EAC82CA7396A68D541C85D26508E83_888700719;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1846738867.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1846738867;
        
        
        
        
            
        
        
            
        
        
            
        
        
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

    
    public static String valueOf(boolean value) {
        return value ? "true" : "false";
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.893 -0400", hash_original_method = "233CB676C051D9EE76740A9343D1B467", hash_generated_method = "C68F07A8D40638239A7F18826AB30516")
    public boolean contentEquals(StringBuffer strbuf) {
        {
            int size = strbuf.length();
            boolean var8AD291071900A808E3CDC7318D3290C1_2032246980 = (regionMatches(0, new String(0, size, strbuf.getValue()), 0,
                    size));
        } 
        addTaint(strbuf.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_930552217 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_930552217;
        
        
            
            
                
            
            
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.894 -0400", hash_original_method = "733340B51AD84F3351AE4177729AE631", hash_generated_method = "DAA3533168E8D6DDD8C7CAD3524B1AF7")
    public boolean contentEquals(CharSequence cs) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        int len = cs.length();
        boolean var4A8EFCED17558E2F34148C8126361B5F_1363371379 = (regionMatches(0, cs.toString(), 0, len));
        addTaint(cs.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1582024095 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1582024095;
        
        
            
        
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.894 -0400", hash_original_method = "54546B1154273B2EF815CC4641C4AF95", hash_generated_method = "95E7C9BC518FE12A36DFB4A6C53E23D1")
    public boolean matches(String regularExpression) {
        boolean var1D596A9C37FF533C6DBD6EF8C6FD418B_1137628992 = (Pattern.matches(regularExpression, this));
        addTaint(regularExpression.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1944323937 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1944323937;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.894 -0400", hash_original_method = "85FB9291CC087326BB42DD27D5FF2770", hash_generated_method = "D38D184A2914BA5DD9DCF487BF728BCF")
    public String replaceAll(String regularExpression, String replacement) {
        String varB4EAC82CA7396A68D541C85D26508E83_574742730 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_574742730 = Pattern.compile(regularExpression).matcher(this).replaceAll(replacement);
        addTaint(regularExpression.getTaint());
        addTaint(replacement.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_574742730.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_574742730;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.895 -0400", hash_original_method = "B1F6469D7EA429A7B60DE2A4BC9D1B18", hash_generated_method = "367D8FA4B028BFC8D251F368EEB93866")
    public String replaceFirst(String regularExpression, String replacement) {
        String varB4EAC82CA7396A68D541C85D26508E83_1165650582 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1165650582 = Pattern.compile(regularExpression).matcher(this).replaceFirst(replacement);
        addTaint(regularExpression.getTaint());
        addTaint(replacement.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1165650582.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1165650582;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.896 -0400", hash_original_method = "0ADD043F2AA11242F9B6645F9D3630BF", hash_generated_method = "2EF88D3AC14D579D56BCF0F07B0CD544")
    public String[] split(String regularExpression) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_683774957 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_683774957 = split(regularExpression, 0);
        addTaint(regularExpression.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_683774957.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_683774957;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.896 -0400", hash_original_method = "4FB3AE192250E9EE292BE09F829C7FA4", hash_generated_method = "3FB78FD88F182B91749F75FE6D11E1B5")
    public String[] split(String regularExpression, int limit) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_475578549 = null; 
        String[] result = java.util.regex.Splitter.fastSplit(regularExpression, this, limit);
        varB4EAC82CA7396A68D541C85D26508E83_475578549 = result != null ? result : Pattern.compile(regularExpression).split(this, limit);
        addTaint(regularExpression.getTaint());
        addTaint(limit);
        varB4EAC82CA7396A68D541C85D26508E83_475578549.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_475578549;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.897 -0400", hash_original_method = "30B2B5AAE6BF00B7B5DE2415CD1C93C0", hash_generated_method = "5FB33D0D5A0F253D92143968D9712CA5")
    public CharSequence subSequence(int start, int end) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1338950096 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1338950096 = substring(start, end);
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_1338950096.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1338950096;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.897 -0400", hash_original_method = "C7D49B0E887DD351A54FAD0BD917A973", hash_generated_method = "67252A2B0A8246F36CD794C525844068")
    public int codePointAt(int index) {
        {
            if (DroidSafeAndroidRuntime.control) throw indexAndLength(index);
        } 
        int var91459A9F7713DB06A5C91858CFACEC5A_1098858130 = (Character.codePointAt(value, offset + index, offset + count));
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_861474619 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_861474619;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.898 -0400", hash_original_method = "45488902F6B74F4C7EAF8C828C18FB65", hash_generated_method = "6B4C7075686A3DB9512E5813D6D3F4B0")
    public int codePointBefore(int index) {
        {
            if (DroidSafeAndroidRuntime.control) throw indexAndLength(index);
        } 
        int varF97594D4D0200951C1EDA2EC22454DCA_2029804577 = (Character.codePointBefore(value, offset + index, offset));
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_914340551 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_914340551;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.898 -0400", hash_original_method = "B50CCA2DE0C54B693E25540AFEB12014", hash_generated_method = "737A4A6A2FDCBB8D7A796ABDE1D0231E")
    public int codePointCount(int start, int end) {
        {
            if (DroidSafeAndroidRuntime.control) throw startEndAndLength(start, end);
        } 
        int varCDB29150FACB3F645BFF42DCED3004F1_2106465022 = (Character.codePointCount(value, offset + start, end - start));
        addTaint(start);
        addTaint(end);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1512696657 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1512696657;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.899 -0400", hash_original_method = "994533EB4329C14FF0C3B68A297AD053", hash_generated_method = "E87380183E11C293FBD89FE9DB9494F0")
    public boolean contains(CharSequence cs) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        boolean varBD86DE7AF63F37539131A6619268C3BC_907162476 = (indexOf(cs.toString()) >= 0);
        addTaint(cs.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1131363939 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1131363939;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.899 -0400", hash_original_method = "3AF353F7691F77FE6437135BD27DAE4A", hash_generated_method = "A270CDBF2E60E165E00086974B50E455")
    public int offsetByCodePoints(int index, int codePointOffset) {
        int s = index + offset;
        int r = Character.offsetByCodePoints(value, offset, count, s, codePointOffset);
        addTaint(index);
        addTaint(codePointOffset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_808354320 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_808354320;
        
        
        
        
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
    @FindBugsSuppressWarnings("UPM_UNCALLED_PRIVATE_METHOD")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.901 -0400", hash_original_method = "4085F5B81BF948B4B3F485D1409A9E33", hash_generated_method = "4085F5B81BF948B4B3F485D1409A9E33")
        public CaseInsensitiveComparator ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.902 -0400", hash_original_method = "10AFFFE45F62C15CA0052EB0BB14A8D3", hash_generated_method = "9788F9511D03F982CCC00C30107B8CB2")
        public int compare(String o1, String o2) {
            int var85510175C4EBB5C1D8819E1DE2BF7041_1156486091 = (o1.compareToIgnoreCase(o2));
            addTaint(o1.getTaint());
            addTaint(o2.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_372420794 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_372420794;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.902 -0400", hash_original_field = "0EB82A8A770CC5893BCFA5E3CA9054B4", hash_generated_field = "094B85F4F683BB296AFE95E1161C88EE")

        private static final long serialVersionUID = 8575799808933029326L;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.902 -0400", hash_original_field = "8F7391E387537113A816F6DA1882EB25", hash_generated_field = "94C8E35BF1C6D0DCD0C640C5B7214BD5")

    private static final long serialVersionUID = -6849794470754667710L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.902 -0400", hash_original_field = "0FA65C778E1E664ED6228A9A8F5E327D", hash_generated_field = "44CEA20EA4711232CF026CC7232D685C")

    private static final char REPLACEMENT_CHAR = (char) 0xfffd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.902 -0400", hash_original_field = "A9AC076FB042F483811BBF9499C903BE", hash_generated_field = "A2069D0DAA8806E284E1501E715FFAC8")

    public static final Comparator<String> CASE_INSENSITIVE_ORDER = new CaseInsensitiveComparator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.902 -0400", hash_original_field = "D2CD8253361A9C732D21CA1D336599CC", hash_generated_field = "6699F3B26E20D4AC1415724EB8FB9705")

    private static char[] ASCII;
    static {
        ASCII = new char[128];
        for (int i = 0; i < ASCII.length; ++i) {
            ASCII[i] = (char) i;
        }
    }
    
}

