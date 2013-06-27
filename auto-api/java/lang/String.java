package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.660 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "C068225E28B5BE74066BE5338158F76B")

    private char[] value;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.660 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "EA4C80BAC452228E60AC0DA2D3E0C953")

    private int offset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.660 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "82CC849FCF58347832EA6BB917282DBE")

    private int count;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.660 -0400", hash_original_field = "550D1CC054A1B23A411DDDA46FD64811", hash_generated_field = "38607001336EF9DE010EF92F750652A2")

    private int hashCode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.661 -0400", hash_original_method = "F65E96A775698E2C256BB1E903F5D8A6", hash_generated_method = "B4FE7A30CB86B25991ECB034EA74BE0F")
    public  String() {
        value = EmptyArray.CHAR;
        offset = 0;
        count = 0;
        // ---------- Original Method ----------
        //value = EmptyArray.CHAR;
        //offset = 0;
        //count = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.684 -0400", hash_original_method = "8A258D0AF74DE6E118252D0EA5531366", hash_generated_method = "A11432EA568E66AD1DE5D8C05C5AB870")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.685 -0400", hash_original_method = "3CF6472F1EAFF36B200903831BC9D282", hash_generated_method = "D9B2763DAEC3FA911416976C82B626C0")
    @FindBugsSuppressWarnings("DM_DEFAULT_ENCODING")
    public  String(byte[] data) {
        this(data, 0, data.length);
        addTaint(data[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.685 -0400", hash_original_method = "94FE9BFA8A903BE49DF8F4E82A84C713", hash_generated_method = "9663CF0FEB97BF7EB6580F530C6B724A")
    @Deprecated
    public  String(byte[] data, int high) {
        this(data, high, 0, data.length);
        addTaint(data[0]);
        addTaint(high);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.686 -0400", hash_original_method = "9C5B9D3903B08C7F386C9C307D28A8D8", hash_generated_method = "D640F92BB2EF7F8CBEA024FBD3CEDA02")
    public  String(byte[] data, int offset, int byteCount) {
        {
            if (DroidSafeAndroidRuntime.control) throw failedBoundsCheck(data.length, offset, byteCount);
        } //End block
        CharBuffer cb;
        cb = Charset.defaultCharset().decode(ByteBuffer.wrap(data, offset, byteCount));
        this.count = cb.length();
        this.offset = 0;
        {
            value = cb.array();
        } //End block
        {
            value = EmptyArray.CHAR;
        } //End block
        addTaint(data[0]);
        addTaint(byteCount);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.700 -0400", hash_original_method = "22A6AFB2E643FB23D243CAF5D019E325", hash_generated_method = "25FCB97C7D31665BF82C7D1341BA4E62")
    @Deprecated
    public  String(byte[] data, int high, int offset, int byteCount) {
        {
            if (DroidSafeAndroidRuntime.control) throw failedBoundsCheck(data.length, offset, byteCount);
        } //End block
        this.offset = 0;
        this.value = new char[byteCount];
        this.count = byteCount;
        high <<= 8;
        {
            int i;
            i = 0;
            {
                value[i] = (char) (high + (data[offset++] & 0xff));
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.706 -0400", hash_original_method = "D35F458D65648B05442A41C1A12F30CA", hash_generated_method = "EEB0BC209E58B40BE8E9ECC5AE799192")
    public  String(byte[] data, int offset, int byteCount, String charsetName) throws UnsupportedEncodingException {
        this(data, offset, byteCount, Charset.forNameUEE(charsetName));
        addTaint(data[0]);
        addTaint(offset);
        addTaint(byteCount);
        addTaint(charsetName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.707 -0400", hash_original_method = "11FE032D0B0EBCDEFC4E4C2065489303", hash_generated_method = "E50E134873024BEA11DDDECA122E3C10")
    public  String(byte[] data, String charsetName) throws UnsupportedEncodingException {
        this(data, 0, data.length, Charset.forNameUEE(charsetName));
        addTaint(data[0]);
        addTaint(charsetName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.710 -0400", hash_original_method = "230168F72CB2A0A48AA9F4A7AFCECA03", hash_generated_method = "E0F5E36001DA0C8F3017008317081A8D")
    public  String(byte[] data, int offset, int byteCount, Charset charset) {
        {
            if (DroidSafeAndroidRuntime.control) throw failedBoundsCheck(data.length, offset, byteCount);
        } //End block
        String canonicalCharsetName;
        canonicalCharsetName = charset.name();
        {
            boolean var0E259348489811E6C7821E4884476552_585782976 = (canonicalCharsetName.equals("UTF-8"));
            {
                byte[] d;
                d = data;
                char[] v;
                v = new char[byteCount];
                int idx;
                idx = offset;
                int last;
                last = offset + byteCount;
                int s;
                s = 0;
                {
                    byte b0;
                    b0 = d[idx++];
                    {
                        int val;
                        val = b0 & 0xff;
                        v[s++] = (char) val;
                    } //End block
                    {
                        int utfCount;
                        utfCount = 1;
                        utfCount = 2;
                        utfCount = 3;
                        utfCount = 4;
                        utfCount = 5;
                        {
                            v[s++] = REPLACEMENT_CHAR;
                        } //End block
                        int val;
                        val = b0 & (0x1f >> (utfCount - 1));
                        {
                            int i;
                            i = 0;
                            {
                                byte b;
                                b = d[idx++];
                                {
                                    v[s++] = REPLACEMENT_CHAR;
                                } //End block
                                val <<= 6;
                                val |= b & 0x3f;
                            } //End block
                        } //End collapsed parenthetic
                        {
                            v[s++] = REPLACEMENT_CHAR;
                        } //End block
                        {
                            v[s++] = REPLACEMENT_CHAR;
                        } //End block
                        {
                            v[s++] = (char) val;
                        } //End block
                        {
                            int x;
                            x = val & 0xffff;
                            int u;
                            u = (val >> 16) & 0x1f;
                            int w;
                            w = (u - 1) & 0xffff;
                            int hi;
                            hi = 0xd800 | (w << 6) | (x >> 10);
                            int lo;
                            lo = 0xdc00 | (x & 0x3ff);
                            v[s++] = (char) hi;
                            v[s++] = (char) lo;
                        } //End block
                    } //End block
                    {
                        v[s++] = REPLACEMENT_CHAR;
                    } //End block
                } //End block
                {
                    this.offset = 0;
                    this.value = v;
                    this.count = s;
                } //End block
                {
                    this.offset = 0;
                    this.value = new char[s];
                    this.count = s;
                    System.arraycopy(v, 0, value, 0, s);
                } //End block
            } //End block
            {
                boolean var2031B49659F344E6C3E3DB6AFAE490EC_211263538 = (canonicalCharsetName.equals("ISO-8859-1"));
                {
                    this.offset = 0;
                    this.value = new char[byteCount];
                    this.count = byteCount;
                    Charsets.isoLatin1BytesToChars(data, offset, byteCount, value);
                } //End block
                {
                    boolean var0569C8B22675C76A7219D23CD23689EC_213555602 = (canonicalCharsetName.equals("US-ASCII"));
                    {
                        this.offset = 0;
                        this.value = new char[byteCount];
                        this.count = byteCount;
                        Charsets.asciiBytesToChars(data, offset, byteCount, value);
                    } //End block
                    {
                        CharBuffer cb;
                        cb = charset.decode(ByteBuffer.wrap(data, offset, byteCount));
                        this.offset = 0;
                        this.count = cb.length();
                        {
                            this.value = new char[count];
                            System.arraycopy(cb.array(), 0, value, 0, count);
                        } //End block
                        {
                            this.value = EmptyArray.CHAR;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(data[0]);
        addTaint(charset.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.716 -0400", hash_original_method = "9D77FFE69AA84BF1048ED5CBD8EE386C", hash_generated_method = "391D2D3517ED818DAA8D1BF2C89D0149")
    public  String(byte[] data, Charset charset) {
        this(data, 0, data.length, charset);
        addTaint(data[0]);
        addTaint(charset.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.717 -0400", hash_original_method = "84FF2A14EA759DC7C1F299809C55E832", hash_generated_method = "941AD48499B8A325EBF754DD62D23EFF")
    public  String(char[] data) {
        this(data, 0, data.length);
        addTaint(data[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.717 -0400", hash_original_method = "14BFB40845511D49F067DB0E6AC711FE", hash_generated_method = "9711FDD928545CD562C5F1FC976AE316")
    public  String(char[] data, int offset, int charCount) {
        {
            if (DroidSafeAndroidRuntime.control) throw failedBoundsCheck(data.length, offset, charCount);
        } //End block
        this.offset = 0;
        this.value = new char[charCount];
        this.count = charCount;
        System.arraycopy(data, offset, value, 0, count);
        addTaint(data[0]);
        // ---------- Original Method ----------
        //if ((offset | charCount) < 0 || charCount > data.length - offset) {
            //throw failedBoundsCheck(data.length, offset, charCount);
        //}
        //this.offset = 0;
        //this.value = new char[charCount];
        //this.count = charCount;
        //System.arraycopy(data, offset, value, 0, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.718 -0400", hash_original_method = "6AA52B72AD5521C733ED3E9463435DD5", hash_generated_method = "99D51D061C47D5C074A83E94BF3BA236")
      String(int offset, int charCount, char[] chars) {
        this.value = chars;
        this.offset = offset;
        this.count = charCount;
        // ---------- Original Method ----------
        //this.value = chars;
        //this.offset = offset;
        //this.count = charCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.718 -0400", hash_original_method = "7D7AE898849737A5DE2F771028ADD293", hash_generated_method = "7FE6513FD8F04FE77BE3B65E244B762D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.734 -0400", hash_original_method = "8B59C74FD130D5556CE63A5F3CE74139", hash_generated_method = "FD34902ACA3ED9507797C78D651C9587")
    @SuppressWarnings( { "unused", "nls" })
    private  String(String s1, String s2) {
        {
            s1 = "null";
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.736 -0400", hash_original_method = "E07460C3146BC4727C3E888CAC21772A", hash_generated_method = "DA75623189E000AB10E1F76F16862FFB")
    @SuppressWarnings( { "unused", "nls" })
    private  String(String s1, String s2, String s3) {
        {
            s1 = "null";
        } //End block
        {
            s2 = "null";
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.749 -0400", hash_original_method = "C3DEF5F256BD0FFA01404830FE1A0B0E", hash_generated_method = "92DDD0018AB3F17B668EEFFDDDAA343E")
    public  String(StringBuffer stringBuffer) {
        offset = 0;
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.750 -0400", hash_original_method = "DE744DAB842D7A0BE4BC8C7648E27967", hash_generated_method = "DF7A6E9CF4DF69ADD3567365B4131093")
    public  String(int[] codePoints, int offset, int count) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw failedBoundsCheck(codePoints.length, offset, count);
        } //End block
        this.offset = 0;
        this.value = new char[count * 2];
        int end;
        end = offset + count;
        int c;
        c = 0;
        {
            int i;
            i = offset;
            {
                c += Character.toChars(codePoints[i], this.value, c);
            } //End block
        } //End collapsed parenthetic
        this.count = c;
        addTaint(codePoints[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.750 -0400", hash_original_method = "1A43E0983F964C9F4090DA81181B802F", hash_generated_method = "1A854E0B2080EFC30E2ABD8E801E7118")
    public  String(StringBuilder stringBuilder) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("stringBuilder == null");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.751 -0400", hash_original_method = "8767608BAC25DDC267BEC70B13CF72A3", hash_generated_method = "4511FDD95A606055DA3C7E9BE5CE0718")
    @SuppressWarnings("unused")
    private  String(String s1, int v1) {
        {
            s1 = "null";
        } //End block
        String s2;
        s2 = String.valueOf(v1);
        int len;
        len = s1.count + s2.count;
        value = new char[len];
        offset = 0;
        System.arraycopy(s1.value, s1.offset, value, 0, s1.count);
        System.arraycopy(s2.value, s2.offset, value, s1.count, s2.count);
        count = len;
        addTaint(s1.getTaint());
        addTaint(v1);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.751 -0400", hash_original_method = "87185450AF15BAF9DFFE5741D5928D9B", hash_generated_method = "8E801B0C1799255B182F9C8F62A15922")
    public char charAt(int index) {
        char varA87DEB01C5F539E6BDA34829C8EF2368_1569367545 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1569367545;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.751 -0400", hash_original_method = "00E4125D0AA58BE2E1232BB5FC2C4846", hash_generated_method = "7AB291E3C15F71928CD72C5D3C710C9E")
    private StringIndexOutOfBoundsException indexAndLength(int index) {
        if (DroidSafeAndroidRuntime.control) throw new StringIndexOutOfBoundsException(this, index);
        addTaint(index);
        // ---------- Original Method ----------
        //throw new StringIndexOutOfBoundsException(this, index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.762 -0400", hash_original_method = "C5BE1ED07127E02665146DD0ACED99A5", hash_generated_method = "06ACD7700CBBB17F93B3C1C6892432FD")
    private StringIndexOutOfBoundsException startEndAndLength(int start, int end) {
        if (DroidSafeAndroidRuntime.control) throw new StringIndexOutOfBoundsException(this, start, end - start);
        addTaint(start);
        addTaint(end);
        // ---------- Original Method ----------
        //throw new StringIndexOutOfBoundsException(this, start, end - start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.763 -0400", hash_original_method = "FABF855F22C4847A4FF9FC56E0D56C67", hash_generated_method = "E5EBE079CC06EC87E395099037376628")
    private StringIndexOutOfBoundsException failedBoundsCheck(int arrayLength, int offset, int count) {
        if (DroidSafeAndroidRuntime.control) throw new StringIndexOutOfBoundsException(arrayLength, offset, count);
        addTaint(arrayLength);
        addTaint(offset);
        addTaint(count);
        // ---------- Original Method ----------
        //throw new StringIndexOutOfBoundsException(arrayLength, offset, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.763 -0400", hash_original_method = "1D42C2C4BD065BE4935C25058CB25A0E", hash_generated_method = "041170F19CCDFE18B4A1EA7E73953BB9")
    private char foldCase(char ch) {
        char var9B0B758EFD0A99F7034CDAE5D13E5009_1260045892 = (Character.toLowerCase(Character.toUpperCase(ch)));
        addTaint(ch);
        char varA87DEB01C5F539E6BDA34829C8EF2368_2053429911 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_2053429911;
        // ---------- Original Method ----------
        //if (ch < 128) {
            //if ('A' <= ch && ch <= 'Z') {
                //return (char) (ch + ('a' - 'A'));
            //}
            //return ch;
        //}
        //return Character.toLowerCase(Character.toUpperCase(ch));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.764 -0400", hash_original_method = "E601A465E2566ECC4B972E253D5CFD79", hash_generated_method = "D710EA6688D363D4CBED63F8282D8F5E")
    public int compareTo(String string) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1233547166 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1233547166;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.764 -0400", hash_original_method = "1A9A71EFE325E55C19A2B451F1A9B9E2", hash_generated_method = "2D92B765915D14AB20A3BB810ADF21AA")
    public int compareToIgnoreCase(String string) {
        int o1, o2, result;
        o1 = offset;
        o2 = string.offset;
        int end;
        end = offset + (count < string.count ? count : string.count);//DSFIXME:  CODE0008: Nested ternary operator in expression
        char c1, c2;
        char[] target;
        target = string.value;
        {
            {
                boolean var2E9E8AD3BCB62DCA1A9EF12A54A2335D_1832830866 = ((c1 = value[o1++]) == (c2 = target[o2++]));
            } //End collapsed parenthetic
            c1 = foldCase(c1);
            c2 = foldCase(c2);
            {
                boolean var14CE4A2902BB903E7AFCF8659D231EE2_1565464541 = ((result = c1 - c2) != 0);
            } //End collapsed parenthetic
        } //End block
        addTaint(string.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_64387166 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_64387166;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.768 -0400", hash_original_method = "F488471D994E6AC017026A4A172508CF", hash_generated_method = "2D267A6E6A4506477BEEE47D711FDF0C")
    public String concat(String string) {
        String varB4EAC82CA7396A68D541C85D26508E83_204398738 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1043765691 = null; //Variable for return #2
        {
            char[] buffer;
            buffer = new char[count + string.count];
            System.arraycopy(value, offset, buffer, 0, count);
            System.arraycopy(string.value, string.offset, buffer, count, string.count);
            varB4EAC82CA7396A68D541C85D26508E83_204398738 = new String(0, buffer.length, buffer);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1043765691 = count == 0 ? string : this;
        addTaint(string.getTaint());
        String varA7E53CE21691AB073D9660D615818899_652730773; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_652730773 = varB4EAC82CA7396A68D541C85D26508E83_204398738;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_652730773 = varB4EAC82CA7396A68D541C85D26508E83_1043765691;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_652730773.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_652730773;
        // ---------- Original Method ----------
        //if (string.count > 0 && count > 0) {
            //char[] buffer = new char[count + string.count];
            //System.arraycopy(value, offset, buffer, 0, count);
            //System.arraycopy(string.value, string.offset, buffer, count, string.count);
            //return new String(0, buffer.length, buffer);
        //}
        //return count == 0 ? string : this;
    }

    
        public static String copyValueOf(char[] data) {
        return new String(data, 0, data.length);
    }

    
        public static String copyValueOf(char[] data, int start, int length) {
        return new String(data, start, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.774 -0400", hash_original_method = "3B37EFF40C149A7A244BFEF0002B2C93", hash_generated_method = "D95CCE7B36A43AC9CE9A1F8678C6D717")
    public boolean endsWith(String suffix) {
        boolean var76E82A4292B5A1451345CC76AEDF9E15_1416058419 = (regionMatches(count - suffix.count, suffix, 0, suffix.count));
        addTaint(suffix.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1962532003 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1962532003;
        // ---------- Original Method ----------
        //return regionMatches(count - suffix.count, suffix, 0, suffix.count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.779 -0400", hash_original_method = "84733F87EF08EE029ED9292B40928CC1", hash_generated_method = "E8856F7584B56705667E3F6219F87329")
    @Override
    public boolean equals(Object object) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_338322234 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_338322234;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.779 -0400", hash_original_method = "2D6A09B1457D58571ED784483A3E54F2", hash_generated_method = "50C674AF1314B16A2D1D36AC5F0E313E")
    @FindBugsSuppressWarnings("ES_COMPARING_PARAMETER_STRING_WITH_EQ")
    public boolean equalsIgnoreCase(String string) {
        {
            boolean var1A493DD12B2DD12B14C7BFE23A6D6C8D_1414617172 = (string == this);
        } //End collapsed parenthetic
        int o1, o2;
        o1 = offset;
        o2 = string.offset;
        int end;
        end = offset + count;
        char[] target;
        target = string.value;
        {
            char c1;
            c1 = value[o1++];
            char c2;
            c2 = target[o2++];
            {
                boolean var43349C3464A5FA3039AFB5B028B91212_760696073 = (c1 != c2 && foldCase(c1) != foldCase(c2));
            } //End collapsed parenthetic
        } //End block
        addTaint(string.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_572389889 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_572389889;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.781 -0400", hash_original_method = "628C355D58441C62D711BC1C2A898A67", hash_generated_method = "DF88B7796CC3E316283698CB9DD27B3D")
    @Deprecated
    public void getBytes(int start, int end, byte[] data, int index) {
        {
            end += offset;
            try 
            {
                {
                    int i;
                    i = offset + start;
                    {
                        data[index++] = (byte) value[i];
                    } //End block
                } //End collapsed parenthetic
            } //End block
            catch (ArrayIndexOutOfBoundsException ignored)
            {
                if (DroidSafeAndroidRuntime.control) throw failedBoundsCheck(data.length, index, end - start);
            } //End block
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw startEndAndLength(start, end);
        } //End block
        addTaint(start);
        addTaint(end);
        addTaint(data[0]);
        addTaint(index);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.781 -0400", hash_original_method = "2E4CA200D3933E45C3FC02936B120C89", hash_generated_method = "954F09EA2017EA806EAF97842EA09948")
    public byte[] getBytes() {
        byte[] var7AC26898B1876959AE0198114C4F4FA9_1900477980 = (getBytes(Charset.defaultCharset()));
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1010455249 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1010455249;
        // ---------- Original Method ----------
        //return getBytes(Charset.defaultCharset());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.781 -0400", hash_original_method = "D1476A765D84241818C22751CEBD7DE3", hash_generated_method = "E5E6B9C89F94D6561AB1018B7DB85407")
    public byte[] getBytes(String charsetName) throws UnsupportedEncodingException {
        byte[] var41B1FB585A68731BDFB62182D33FDD75_949052833 = (getBytes(Charset.forNameUEE(charsetName)));
        addTaint(charsetName.getTaint());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1377639498 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1377639498;
        // ---------- Original Method ----------
        //return getBytes(Charset.forNameUEE(charsetName));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.839 -0400", hash_original_method = "56FDAE3B6641018546E6C6674268142D", hash_generated_method = "4C09097EFCDCEB107461B87820A68983")
    public byte[] getBytes(Charset charset) {
        String canonicalCharsetName;
        canonicalCharsetName = charset.name();
        {
            boolean var0E259348489811E6C7821E4884476552_189166148 = (canonicalCharsetName.equals("UTF-8"));
            {
                byte[] var9984FE416A6160547A4291CF12EF5977_2135140737 = (Charsets.toUtf8Bytes(value, offset, count));
            } //End block
            {
                boolean var2031B49659F344E6C3E3DB6AFAE490EC_1015865966 = (canonicalCharsetName.equals("ISO-8859-1"));
                {
                    byte[] var06F12C18AB207C990E645C1634999BCA_1727598725 = (Charsets.toIsoLatin1Bytes(value, offset, count));
                } //End block
                {
                    boolean var0569C8B22675C76A7219D23CD23689EC_1718282824 = (canonicalCharsetName.equals("US-ASCII"));
                    {
                        byte[] var5EE1291BC0FFD1569DC7607C427C86B6_592605363 = (Charsets.toAsciiBytes(value, offset, count));
                    } //End block
                    {
                        boolean var0EE7227B231600ECBF464F0787D46244_2042752988 = (canonicalCharsetName.equals("UTF-16BE"));
                        {
                            byte[] varE1DCEC963687DDFBF9CF1214AE9B988C_1847117896 = (Charsets.toBigEndianUtf16Bytes(value, offset, count));
                        } //End block
                        {
                            CharBuffer chars;
                            chars = CharBuffer.wrap(this.value, this.offset, this.count);
                            ByteBuffer buffer;
                            buffer = charset.encode(chars.asReadOnlyBuffer());
                            byte[] bytes;
                            bytes = new byte[buffer.limit()];
                            buffer.get(bytes);
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(charset.getTaint());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1681509899 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1681509899;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.840 -0400", hash_original_method = "D443F19C798F5645F696FD1973BB47C6", hash_generated_method = "2F954EDE4E6FF8CC0CF77F27DB17902F")
    public void getChars(int start, int end, char[] buffer, int index) {
        {
            System.arraycopy(value, start + offset, buffer, index, end - start);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw startEndAndLength(start, end);
        } //End block
        addTaint(start);
        addTaint(end);
        addTaint(buffer[0]);
        addTaint(index);
        // ---------- Original Method ----------
        //if (start >= 0 && start <= end && end <= count) {
            //System.arraycopy(value, start + offset, buffer, index, end - start);
        //} else {
            //throw startEndAndLength(start, end);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.840 -0400", hash_original_method = "25FFBBE7056EE87BB826458DBC43764C", hash_generated_method = "BC6509E5F5F3A4E23CFFDEBC23B1C41D")
     void _getChars(int start, int end, char[] buffer, int index) {
        System.arraycopy(value, start + offset, buffer, index, end - start);
        addTaint(start);
        addTaint(end);
        addTaint(buffer[0]);
        addTaint(index);
        // ---------- Original Method ----------
        //System.arraycopy(value, start + offset, buffer, index, end - start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.840 -0400", hash_original_method = "19D1106FC463FB90112A6C6293D6F5CF", hash_generated_method = "23287E823070CC32D7382EDC760DC93A")
    @Override
    public int hashCode() {
        int hash;
        hash = hashCode;
        {
            int end;
            end = count + offset;
            char[] chars;
            chars = value;
            {
                int i;
                i = offset;
                {
                    hash = 31*hash + chars[i];
                } //End block
            } //End collapsed parenthetic
            hashCode = hash;
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1148416932 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1148416932;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.841 -0400", hash_original_method = "C183CC13D668537DB52873A8A3264758", hash_generated_method = "F935B7EB3EFE0C3298C7CFF3213394E5")
    public int indexOf(int c) {
        {
            int var5F851632D6BAA470138E8E6B8CF03AB6_1585200639 = (indexOfSupplementary(c, 0));
        } //End block
        int varBDF102D3B3DB28ED5C430C6E4DC71DED_1131350053 = (fastIndexOf(c, 0));
        addTaint(c);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2071605361 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2071605361;
        // ---------- Original Method ----------
        //if (c > 0xffff) {
            //return indexOfSupplementary(c, 0);
        //}
        //return fastIndexOf(c, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.841 -0400", hash_original_method = "A9B16E70D2A4A056B33DA4268AACFBA9", hash_generated_method = "B7D0B1FD6FE1E1A4DDD0B0BC974C96B6")
    public int indexOf(int c, int start) {
        {
            int var5B650999CF272FFC32489F6C46D5030B_769192919 = (indexOfSupplementary(c, start));
        } //End block
        int varF6149B4A88E68FEA46885B131E2A52C3_1049436562 = (fastIndexOf(c, start));
        addTaint(c);
        addTaint(start);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_229076281 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_229076281;
        // ---------- Original Method ----------
        //if (c > 0xffff) {
            //return indexOfSupplementary(c, start);
        //}
        //return fastIndexOf(c, start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.841 -0400", hash_original_method = "158E0BDE7178D291CA067E7481407A6C", hash_generated_method = "15D758892B5D474E1F835B1A0796AB0E")
    private int fastIndexOf(int c, int start) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1959383370 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1959383370;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.842 -0400", hash_original_method = "9DA1418F8A10F302F688A26755CAB088", hash_generated_method = "8F53F4DFB601852E25A8676022B14E70")
    private int indexOfSupplementary(int c, int start) {
        {
            boolean var1055287EA357B1E539F33F3672FA88F7_2086201450 = (!Character.isSupplementaryCodePoint(c));
        } //End collapsed parenthetic
        char[] chars;
        chars = Character.toChars(c);
        String needle;
        needle = new String(0, chars.length, chars);
        int var6E5631C6B9EDE9258144E71393C64491_1562005558 = (indexOf(needle, start));
        addTaint(c);
        addTaint(start);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_531047355 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_531047355;
        // ---------- Original Method ----------
        //if (!Character.isSupplementaryCodePoint(c)) {
            //return -1;
        //}
        //char[] chars = Character.toChars(c);
        //String needle = new String(0, chars.length, chars);
        //return indexOf(needle, start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.843 -0400", hash_original_method = "AC187DA6A9C2600FBA62EFD5097D8F4D", hash_generated_method = "8CE6F31EB7DD470A87DA9A64DE3F0AFF")
    public int indexOf(String string) {
        int start;
        start = 0;
        int subCount;
        subCount = string.count;
        int _count;
        _count = count;
        {
            char[] target;
            target = string.value;
            int subOffset;
            subOffset = string.offset;
            char firstChar;
            firstChar = target[subOffset];
            int end;
            end = subOffset + subCount;
            {
                int i;
                i = indexOf(firstChar, start);
                int o1, o2;
                o1 = offset + i;
                o2 = subOffset;
                char[] _value;
                _value = value;
                start = i + 1;
            } //End block
        } //End block
        addTaint(string.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_268707478 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_268707478;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.860 -0400", hash_original_method = "30C77F2F1070D21229A0301D2E3C23FC", hash_generated_method = "8F85C42A75E1A02400993C0EEF2F0BF2")
    public int indexOf(String subString, int start) {
        {
            start = 0;
        } //End block
        int subCount;
        subCount = subString.count;
        int _count;
        _count = count;
        {
            char[] target;
            target = subString.value;
            int subOffset;
            subOffset = subString.offset;
            char firstChar;
            firstChar = target[subOffset];
            int end;
            end = subOffset + subCount;
            {
                int i;
                i = indexOf(firstChar, start);
                int o1, o2;
                o1 = offset + i;
                o2 = subOffset;
                char[] _value;
                _value = value;
                start = i + 1;
            } //End block
        } //End block
        addTaint(subString.getTaint());
        addTaint(start);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_414141921 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_414141921;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.861 -0400", hash_original_method = "8D834ED1699A050AD62397187973DE2A", hash_generated_method = "D27768EE08A87AC5AC201AAF7BA53F8D")
    public String intern() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.861 -0400", hash_original_method = "9B1CCC3AB82A9C7B7A46C788921405FB", hash_generated_method = "BC3BCEE0208B199010012DFA7A2DD331")
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_94779987 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_94779987;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.861 -0400", hash_original_method = "B7458CFA700437DC398BF47C5A311056", hash_generated_method = "417A21BEC1E1E638973EBCC4A48C58BA")
    public int lastIndexOf(int c) {
        {
            int varBD342ABA258412F8C448797D2A456C93_329963075 = (lastIndexOfSupplementary(c, Integer.MAX_VALUE));
        } //End block
        int _count;
        _count = count;
        int _offset;
        _offset = offset;
        char[] _value;
        _value = value;
        {
            int i;
            i = _offset + _count - 1;
        } //End collapsed parenthetic
        addTaint(c);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_115970868 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_115970868;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.862 -0400", hash_original_method = "438C7E0E01B0881067FA33086AF4D678", hash_generated_method = "890B485F0AD9BB7864E8B6E050DFB73B")
    public int lastIndexOf(int c, int start) {
        {
            int var6EE07AE0B8AD5BD57E677DC6C0B33723_1238341618 = (lastIndexOfSupplementary(c, start));
        } //End block
        int _count;
        _count = count;
        int _offset;
        _offset = offset;
        char[] _value;
        _value = value;
        {
            {
                start = _count - 1;
            } //End block
            {
                int i;
                i = _offset + start;
            } //End collapsed parenthetic
        } //End block
        addTaint(c);
        addTaint(start);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1877568299 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1877568299;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.863 -0400", hash_original_method = "ECC6B0EDCC4F01358439BB31BFF21134", hash_generated_method = "CF065F047A35BF3DC446895FFE38821D")
    private int lastIndexOfSupplementary(int c, int start) {
        {
            boolean var1055287EA357B1E539F33F3672FA88F7_529299716 = (!Character.isSupplementaryCodePoint(c));
        } //End collapsed parenthetic
        char[] chars;
        chars = Character.toChars(c);
        String needle;
        needle = new String(0, chars.length, chars);
        int varB6048C8F2399670687E5E6BB049C087D_878170347 = (lastIndexOf(needle, start));
        addTaint(c);
        addTaint(start);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_468532748 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_468532748;
        // ---------- Original Method ----------
        //if (!Character.isSupplementaryCodePoint(c)) {
            //return -1;
        //}
        //char[] chars = Character.toChars(c);
        //String needle = new String(0, chars.length, chars);
        //return lastIndexOf(needle, start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.863 -0400", hash_original_method = "692347B4AF93950259A2DA740A39B258", hash_generated_method = "E9D581D1DFD9E21C42614A679F37928C")
    public int lastIndexOf(String string) {
        int var629483EEC7DE422E0B8E730771A3942E_392749255 = (lastIndexOf(string, count));
        addTaint(string.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_238051237 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_238051237;
        // ---------- Original Method ----------
        //return lastIndexOf(string, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.865 -0400", hash_original_method = "08D5FBAA11FAAE0244D1BD87258C05E0", hash_generated_method = "F63A4E821DE07AD5C15233484F4B6577")
    public int lastIndexOf(String subString, int start) {
        int subCount;
        subCount = subString.count;
        {
            {
                {
                    start = count - subCount;
                } //End block
                char[] target;
                target = subString.value;
                int subOffset;
                subOffset = subString.offset;
                char firstChar;
                firstChar = target[subOffset];
                int end;
                end = subOffset + subCount;
                {
                    int i;
                    i = lastIndexOf(firstChar, start);
                    int o1, o2;
                    o1 = offset + i;
                    o2 = subOffset;
                    start = i - 1;
                } //End block
            } //End block
        } //End block
        addTaint(subString.getTaint());
        addTaint(start);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2120878028 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2120878028;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.865 -0400", hash_original_method = "026D3AE6EA7284BA85CF864429138595", hash_generated_method = "CD8719E12992CF6DD27CA40A60EC3980")
    public int length() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1797855051 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1797855051;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.866 -0400", hash_original_method = "8EA3BFAB97A4D4877FC2554FB493C6C0", hash_generated_method = "B9412F057454DC4334A32DDBDCB4C066")
    public boolean regionMatches(int thisStart, String string, int start, int length) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        int o1, o2;
        o1 = offset + thisStart;
        o2 = string.offset + start;
        char[] value1;
        value1 = value;
        char[] value2;
        value2 = string.value;
        {
            int i;
            i = 0;
        } //End collapsed parenthetic
        addTaint(thisStart);
        addTaint(string.getTaint());
        addTaint(start);
        addTaint(length);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_662113911 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_662113911;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.869 -0400", hash_original_method = "5098FC46543D7D1A735E08AA962F8003", hash_generated_method = "4AAE1A93B9BEA792E7837C92E71CA476")
    public boolean regionMatches(boolean ignoreCase, int thisStart, String string, int start, int length) {
        {
            boolean var6F73B44E0EF89A3667DD4B1125A02E25_138845940 = (regionMatches(thisStart, string, start, length));
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("string == null");
        } //End block
        thisStart += offset;
        start += string.offset;
        int end;
        end = thisStart + length;
        char[] target;
        target = string.value;
        {
            char c1;
            c1 = value[thisStart++];
            char c2;
            c2 = target[start++];
            {
                boolean var43349C3464A5FA3039AFB5B028B91212_312983999 = (c1 != c2 && foldCase(c1) != foldCase(c2));
            } //End collapsed parenthetic
        } //End block
        addTaint(ignoreCase);
        addTaint(thisStart);
        addTaint(string.getTaint());
        addTaint(start);
        addTaint(length);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_239742384 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_239742384;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.870 -0400", hash_original_method = "52751D07523F52C15F0E15149B768BF7", hash_generated_method = "93F404E7F692BD3D385DA5FBB243B35A")
    public String replace(char oldChar, char newChar) {
        String varB4EAC82CA7396A68D541C85D26508E83_266730225 = null; //Variable for return #1
        char[] buffer;
        buffer = value;
        int _offset;
        _offset = offset;
        int _count;
        _count = count;
        int idx;
        idx = _offset;
        int last;
        last = _offset + _count;
        boolean copied;
        copied = false;
        {
            {
                {
                    char[] newBuffer;
                    newBuffer = new char[_count];
                    System.arraycopy(buffer, _offset, newBuffer, 0, _count);
                    buffer = newBuffer;
                    idx -= _offset;
                    last -= _offset;
                    copied = true;
                } //End block
                buffer[idx] = newChar;
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_266730225 = copied ? new String(0, count, buffer) : this;
        addTaint(oldChar);
        addTaint(newChar);
        varB4EAC82CA7396A68D541C85D26508E83_266730225.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_266730225;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.884 -0400", hash_original_method = "226EAAC156D556D42E48670E64FEC4E8", hash_generated_method = "6FD3DF097882BB9C11C4AAD0A463D052")
    public String replace(CharSequence target, CharSequence replacement) {
        String varB4EAC82CA7396A68D541C85D26508E83_414583793 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1062407250 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_641118694 = null; //Variable for return #3
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("target == null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("replacement == null");
        } //End block
        String targetString;
        targetString = target.toString();
        int matchStart;
        matchStart = indexOf(targetString, 0);
        {
            varB4EAC82CA7396A68D541C85D26508E83_414583793 = this;
        } //End block
        String replacementString;
        replacementString = replacement.toString();
        int targetLength;
        targetLength = targetString.length();
        {
            int resultLength;
            resultLength = (count + 2) * replacementString.length();
            StringBuilder result;
            result = new StringBuilder(resultLength);
            result.append(replacementString);
            {
                int i;
                i = offset;
                {
                    result.append(value[i]);
                    result.append(replacementString);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1062407250 = result.toString();
        } //End block
        StringBuilder result;
        result = new StringBuilder(count);
        int searchStart;
        searchStart = 0;
        {
            result.append(value, offset + searchStart, matchStart - searchStart);
            result.append(replacementString);
            searchStart = matchStart + targetLength;
        } //End block
        {
            boolean varDF5B9E27CB5E1F6FE60A3DAF131B74C7_1466730354 = ((matchStart = indexOf(targetString, searchStart)) != -1);
        } //End collapsed parenthetic
        result.append(value, offset + searchStart, count - searchStart);
        varB4EAC82CA7396A68D541C85D26508E83_641118694 = result.toString();
        addTaint(target.getTaint());
        addTaint(replacement.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1287751846; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1287751846 = varB4EAC82CA7396A68D541C85D26508E83_414583793;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1287751846 = varB4EAC82CA7396A68D541C85D26508E83_1062407250;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1287751846 = varB4EAC82CA7396A68D541C85D26508E83_641118694;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1287751846.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1287751846;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.885 -0400", hash_original_method = "8508513C5D9E5D7A42B020CFB91803A3", hash_generated_method = "6983CDBBE1A55EAC2D6A53984C4787D8")
    public boolean startsWith(String prefix) {
        boolean varE400B78CFCF899225EE690557CD93052_1403475821 = (startsWith(prefix, 0));
        addTaint(prefix.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1777497183 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1777497183;
        // ---------- Original Method ----------
        //return startsWith(prefix, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.885 -0400", hash_original_method = "DCA59D254EE64B3144EDF9B3ACB43A45", hash_generated_method = "5A165F2B8775935F616FD8195A53B2AF")
    public boolean startsWith(String prefix, int start) {
        boolean varA8E1CDADA007E83510DD5CFA9EE42F80_1663242922 = (regionMatches(start, prefix, 0, prefix.count));
        addTaint(prefix.getTaint());
        addTaint(start);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1570946394 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1570946394;
        // ---------- Original Method ----------
        //return regionMatches(start, prefix, 0, prefix.count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.886 -0400", hash_original_method = "CB27750752A8934950488E0046CA5119", hash_generated_method = "B5E8786A23A1E7F9B99DE5EE15DA0514")
    public String substring(int start) {
        String varB4EAC82CA7396A68D541C85D26508E83_119422061 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_397220597 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_119422061 = this;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_397220597 = new String(offset + start, count - start, value);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw indexAndLength(start);
        addTaint(start);
        String varA7E53CE21691AB073D9660D615818899_2099545570; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2099545570 = varB4EAC82CA7396A68D541C85D26508E83_119422061;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2099545570 = varB4EAC82CA7396A68D541C85D26508E83_397220597;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2099545570.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2099545570;
        // ---------- Original Method ----------
        //if (start == 0) {
            //return this;
        //}
        //if (start >= 0 && start <= count) {
            //return new String(offset + start, count - start, value);
        //}
        //throw indexAndLength(start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.887 -0400", hash_original_method = "FA273138383309E9BFDA8AAE2A7C6025", hash_generated_method = "7C32D9E0469D8AC72444707FB0ECFF4D")
    public String substring(int start, int end) {
        String varB4EAC82CA7396A68D541C85D26508E83_1271598791 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1630767168 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1271598791 = this;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1630767168 = new String(offset + start, end - start, value);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw startEndAndLength(start, end);
        addTaint(start);
        addTaint(end);
        String varA7E53CE21691AB073D9660D615818899_833815040; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_833815040 = varB4EAC82CA7396A68D541C85D26508E83_1271598791;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_833815040 = varB4EAC82CA7396A68D541C85D26508E83_1630767168;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_833815040.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_833815040;
        // ---------- Original Method ----------
        //if (start == 0 && end == count) {
            //return this;
        //}
        //if (start >= 0 && start <= end && end <= count) {
            //return new String(offset + start, end - start, value);
        //}
        //throw startEndAndLength(start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.887 -0400", hash_original_method = "66BAEF040BB5FDC80731F9B16CD33C32", hash_generated_method = "3336C24DFB7659573EB7922D244350BE")
    public char[] toCharArray() {
        char[] buffer;
        buffer = new char[count];
        System.arraycopy(value, offset, buffer, 0, count);
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_1373763304 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1373763304;
        // ---------- Original Method ----------
        //char[] buffer = new char[count];
        //System.arraycopy(value, offset, buffer, 0, count);
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.902 -0400", hash_original_method = "1FBB4BF6938E55C9E24FEC1EE0A95252", hash_generated_method = "1723EF2649CCC142A9DA3029A1001619")
    public String toLowerCase() {
        String varB4EAC82CA7396A68D541C85D26508E83_1803892352 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1803892352 = CaseMapper.toLowerCase(Locale.getDefault(), this, value, offset, count);
        varB4EAC82CA7396A68D541C85D26508E83_1803892352.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1803892352;
        // ---------- Original Method ----------
        //return CaseMapper.toLowerCase(Locale.getDefault(), this, value, offset, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.902 -0400", hash_original_method = "3BCA227A64DF8F05552679E5E357BCF1", hash_generated_method = "95CB406B73E8917B7878399996548072")
    public String toLowerCase(Locale locale) {
        String varB4EAC82CA7396A68D541C85D26508E83_856681558 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_856681558 = CaseMapper.toLowerCase(locale, this, value, offset, count);
        addTaint(locale.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_856681558.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_856681558;
        // ---------- Original Method ----------
        //return CaseMapper.toLowerCase(locale, this, value, offset, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.903 -0400", hash_original_method = "068E2EE4236B85776135405F1B66AD49", hash_generated_method = "4E2E6F724A6159A855C199FFADFF9CE6")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1028349419 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1028349419 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1028349419.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1028349419;
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.903 -0400", hash_original_method = "8DEC33A26AFC2829CCCCE108ECEB9551", hash_generated_method = "07808B47A70B8D4B1091C8CB799BD212")
    public String toUpperCase() {
        String varB4EAC82CA7396A68D541C85D26508E83_531541864 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_531541864 = CaseMapper.toUpperCase(Locale.getDefault(), this, value, offset, count);
        varB4EAC82CA7396A68D541C85D26508E83_531541864.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_531541864;
        // ---------- Original Method ----------
        //return CaseMapper.toUpperCase(Locale.getDefault(), this, value, offset, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.905 -0400", hash_original_method = "11C711663B7D81E6BD865533BF51B442", hash_generated_method = "96DB1064B9B1A27D65EB957EDB8F0E33")
    public String toUpperCase(Locale locale) {
        String varB4EAC82CA7396A68D541C85D26508E83_602283849 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_602283849 = CaseMapper.toUpperCase(locale, this, value, offset, count);
        addTaint(locale.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_602283849.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_602283849;
        // ---------- Original Method ----------
        //return CaseMapper.toUpperCase(locale, this, value, offset, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.906 -0400", hash_original_method = "5AB01C88F799E5B54FF71EE82B91E811", hash_generated_method = "37EE01A468E8D3CED9D5CF9DE1F7CDEF")
    public String trim() {
        String varB4EAC82CA7396A68D541C85D26508E83_74512814 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1599280934 = null; //Variable for return #2
        int start, last;
        start = offset;
        last = offset + count - 1;
        int end;
        end = last;
        {
            varB4EAC82CA7396A68D541C85D26508E83_74512814 = this;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1599280934 = new String(start, end - start + 1, value);
        String varA7E53CE21691AB073D9660D615818899_858193291; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_858193291 = varB4EAC82CA7396A68D541C85D26508E83_74512814;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_858193291 = varB4EAC82CA7396A68D541C85D26508E83_1599280934;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_858193291.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_858193291;
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

    
        public static String valueOf(char[] data) {
        return new String(data, 0, data.length);
    }

    
        public static String valueOf(char[] data, int start, int length) {
        return new String(data, start, length);
    }

    
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

    
        public static String valueOf(double value) {
        return Double.toString(value);
    }

    
        public static String valueOf(float value) {
        return Float.toString(value);
    }

    
        public static String valueOf(int value) {
        return Integer.toString(value);
    }

    
        public static String valueOf(long value) {
        return Long.toString(value);
    }

    
        public static String valueOf(Object value) {
        return value != null ? value.toString() : "null";
    }

    
        public static String valueOf(boolean value) {
        return value ? "true" : "false";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.918 -0400", hash_original_method = "233CB676C051D9EE76740A9343D1B467", hash_generated_method = "611F769272C422977D596A530AF072E9")
    public boolean contentEquals(StringBuffer strbuf) {
        {
            int size;
            size = strbuf.length();
            boolean var8AD291071900A808E3CDC7318D3290C1_638334352 = (regionMatches(0, new String(0, size, strbuf.getValue()), 0,
                    size));
        } //End block
        addTaint(strbuf.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1532264135 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1532264135;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.931 -0400", hash_original_method = "733340B51AD84F3351AE4177729AE631", hash_generated_method = "708D9B8FFF294CE7F5651FBECE55E50A")
    public boolean contentEquals(CharSequence cs) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        int len;
        len = cs.length();
        boolean var4A8EFCED17558E2F34148C8126361B5F_758794683 = (regionMatches(0, cs.toString(), 0, len));
        addTaint(cs.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_100454517 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_100454517;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.932 -0400", hash_original_method = "54546B1154273B2EF815CC4641C4AF95", hash_generated_method = "1B3505B0826C4C567F659E4097ACF6BA")
    public boolean matches(String regularExpression) {
        boolean var1D596A9C37FF533C6DBD6EF8C6FD418B_271847521 = (Pattern.matches(regularExpression, this));
        addTaint(regularExpression.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1469236930 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1469236930;
        // ---------- Original Method ----------
        //return Pattern.matches(regularExpression, this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.932 -0400", hash_original_method = "85FB9291CC087326BB42DD27D5FF2770", hash_generated_method = "88644E260F4E222AE1B945C02B7CE3A4")
    public String replaceAll(String regularExpression, String replacement) {
        String varB4EAC82CA7396A68D541C85D26508E83_1126743634 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1126743634 = Pattern.compile(regularExpression).matcher(this).replaceAll(replacement);
        addTaint(regularExpression.getTaint());
        addTaint(replacement.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1126743634.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1126743634;
        // ---------- Original Method ----------
        //return Pattern.compile(regularExpression).matcher(this).replaceAll(replacement);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.933 -0400", hash_original_method = "B1F6469D7EA429A7B60DE2A4BC9D1B18", hash_generated_method = "31EB2E6281CF11BBBA70F7183E034985")
    public String replaceFirst(String regularExpression, String replacement) {
        String varB4EAC82CA7396A68D541C85D26508E83_1422435170 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1422435170 = Pattern.compile(regularExpression).matcher(this).replaceFirst(replacement);
        addTaint(regularExpression.getTaint());
        addTaint(replacement.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1422435170.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1422435170;
        // ---------- Original Method ----------
        //return Pattern.compile(regularExpression).matcher(this).replaceFirst(replacement);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.941 -0400", hash_original_method = "0ADD043F2AA11242F9B6645F9D3630BF", hash_generated_method = "CE1E94D83183AEA81D003849D101DB92")
    public String[] split(String regularExpression) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_2072859779 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2072859779 = split(regularExpression, 0);
        addTaint(regularExpression.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2072859779.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2072859779;
        // ---------- Original Method ----------
        //return split(regularExpression, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.945 -0400", hash_original_method = "4FB3AE192250E9EE292BE09F829C7FA4", hash_generated_method = "E596B6BC994D9505D66B5029CAB95FFD")
    public String[] split(String regularExpression, int limit) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_2002378521 = null; //Variable for return #1
        String[] result;
        result = java.util.regex.Splitter.fastSplit(regularExpression, this, limit);
        varB4EAC82CA7396A68D541C85D26508E83_2002378521 = result != null ? result : Pattern.compile(regularExpression).split(this, limit);
        addTaint(regularExpression.getTaint());
        addTaint(limit);
        varB4EAC82CA7396A68D541C85D26508E83_2002378521.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2002378521;
        // ---------- Original Method ----------
        //String[] result = java.util.regex.Splitter.fastSplit(regularExpression, this, limit);
        //return result != null ? result : Pattern.compile(regularExpression).split(this, limit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.950 -0400", hash_original_method = "30B2B5AAE6BF00B7B5DE2415CD1C93C0", hash_generated_method = "E0DC5FCB1FBE1BA2BBDD2E74ED155A64")
    public CharSequence subSequence(int start, int end) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_923953448 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_923953448 = substring(start, end);
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_923953448.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_923953448;
        // ---------- Original Method ----------
        //return substring(start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.951 -0400", hash_original_method = "C7D49B0E887DD351A54FAD0BD917A973", hash_generated_method = "0E96BB38D4B309FA5CD29EC77337ED6D")
    public int codePointAt(int index) {
        {
            if (DroidSafeAndroidRuntime.control) throw indexAndLength(index);
        } //End block
        int var91459A9F7713DB06A5C91858CFACEC5A_42312511 = (Character.codePointAt(value, offset + index, offset + count));
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1929707576 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1929707576;
        // ---------- Original Method ----------
        //if (index < 0 || index >= count) {
            //throw indexAndLength(index);
        //}
        //return Character.codePointAt(value, offset + index, offset + count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.957 -0400", hash_original_method = "45488902F6B74F4C7EAF8C828C18FB65", hash_generated_method = "6800186E2F7908E9BF9FFB3526238B9C")
    public int codePointBefore(int index) {
        {
            if (DroidSafeAndroidRuntime.control) throw indexAndLength(index);
        } //End block
        int varF97594D4D0200951C1EDA2EC22454DCA_1811700130 = (Character.codePointBefore(value, offset + index, offset));
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1418566300 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1418566300;
        // ---------- Original Method ----------
        //if (index < 1 || index > count) {
            //throw indexAndLength(index);
        //}
        //return Character.codePointBefore(value, offset + index, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.967 -0400", hash_original_method = "B50CCA2DE0C54B693E25540AFEB12014", hash_generated_method = "FF434D05607C92DF964DAF6C51CE33A5")
    public int codePointCount(int start, int end) {
        {
            if (DroidSafeAndroidRuntime.control) throw startEndAndLength(start, end);
        } //End block
        int varCDB29150FACB3F645BFF42DCED3004F1_414066795 = (Character.codePointCount(value, offset + start, end - start));
        addTaint(start);
        addTaint(end);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1117350565 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1117350565;
        // ---------- Original Method ----------
        //if (start < 0 || end > count || start > end) {
            //throw startEndAndLength(start, end);
        //}
        //return Character.codePointCount(value, offset + start, end - start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.968 -0400", hash_original_method = "994533EB4329C14FF0C3B68A297AD053", hash_generated_method = "62AA3890ACF3A0CA229074072DAD66E7")
    public boolean contains(CharSequence cs) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        boolean varBD86DE7AF63F37539131A6619268C3BC_62283789 = (indexOf(cs.toString()) >= 0);
        addTaint(cs.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1023725096 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1023725096;
        // ---------- Original Method ----------
        //if (cs == null) {
            //throw new NullPointerException();
        //}
        //return indexOf(cs.toString()) >= 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.968 -0400", hash_original_method = "3AF353F7691F77FE6437135BD27DAE4A", hash_generated_method = "C8F97E57A7D8DA615FEF2CC896F0EE51")
    public int offsetByCodePoints(int index, int codePointOffset) {
        int s;
        s = index + offset;
        int r;
        r = Character.offsetByCodePoints(value, offset, count, s, codePointOffset);
        addTaint(index);
        addTaint(codePointOffset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2122957125 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2122957125;
        // ---------- Original Method ----------
        //int s = index + offset;
        //int r = Character.offsetByCodePoints(value, offset, count, s, codePointOffset);
        //return r - offset;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.969 -0400", hash_original_method = "4085F5B81BF948B4B3F485D1409A9E33", hash_generated_method = "4085F5B81BF948B4B3F485D1409A9E33")
        public CaseInsensitiveComparator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.970 -0400", hash_original_method = "10AFFFE45F62C15CA0052EB0BB14A8D3", hash_generated_method = "11366D0ED199C791754E51C3AD63C55A")
        public int compare(String o1, String o2) {
            int var85510175C4EBB5C1D8819E1DE2BF7041_1239136441 = (o1.compareToIgnoreCase(o2));
            addTaint(o1.getTaint());
            addTaint(o2.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_904695025 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_904695025;
            // ---------- Original Method ----------
            //return o1.compareToIgnoreCase(o2);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.970 -0400", hash_original_field = "0EB82A8A770CC5893BCFA5E3CA9054B4", hash_generated_field = "995A12B7BCF0A70DC59E2D35FEE7A84A")

        private static long serialVersionUID = 8575799808933029326L;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.970 -0400", hash_original_field = "8F7391E387537113A816F6DA1882EB25", hash_generated_field = "4AA00D2B3DAC50878809779F15F2116B")

    private static long serialVersionUID = -6849794470754667710L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.970 -0400", hash_original_field = "0FA65C778E1E664ED6228A9A8F5E327D", hash_generated_field = "6FD455D91531D4279D6AC3DD0A171518")

    private static char REPLACEMENT_CHAR = (char) 0xfffd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.977 -0400", hash_original_field = "A9AC076FB042F483811BBF9499C903BE", hash_generated_field = "A2069D0DAA8806E284E1501E715FFAC8")

    public static final Comparator<String> CASE_INSENSITIVE_ORDER = new CaseInsensitiveComparator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.977 -0400", hash_original_field = "D2CD8253361A9C732D21CA1D336599CC", hash_generated_field = "6699F3B26E20D4AC1415724EB8FB9705")

    private static char[] ASCII;
    static {
        ASCII = new char[128];
        for (int i = 0; i < ASCII.length; ++i) {
            ASCII[i] = (char) i;
        }
    }
    
}

