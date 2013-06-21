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
    private char[] value;
    private int offset;
    private int count;
    private int hashCode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.168 -0400", hash_original_method = "F65E96A775698E2C256BB1E903F5D8A6", hash_generated_method = "B4FE7A30CB86B25991ECB034EA74BE0F")
    @DSModeled(DSC.SAFE)
    public String() {
        value = EmptyArray.CHAR;
        offset = 0;
        count = 0;
        // ---------- Original Method ----------
        //value = EmptyArray.CHAR;
        //offset = 0;
        //count = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.168 -0400", hash_original_method = "8A258D0AF74DE6E118252D0EA5531366", hash_generated_method = "6277D18184C4E9F4BF61CEDF741B6B0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unused")
    private String(String s, char c) {
        dsTaint.addTaint(s);
        dsTaint.addTaint(c);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.168 -0400", hash_original_method = "3CF6472F1EAFF36B200903831BC9D282", hash_generated_method = "0A9A72E0C3431B8CF7BAB2897A57BB71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @FindBugsSuppressWarnings("DM_DEFAULT_ENCODING")
    public String(byte[] data) {
        this(data, 0, data.length);
        dsTaint.addTaint(data[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.168 -0400", hash_original_method = "94FE9BFA8A903BE49DF8F4E82A84C713", hash_generated_method = "43A979D57B377E2E3119CA8DED2E966A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public String(byte[] data, int high) {
        this(data, high, 0, data.length);
        dsTaint.addTaint(data[0]);
        dsTaint.addTaint(high);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.169 -0400", hash_original_method = "9C5B9D3903B08C7F386C9C307D28A8D8", hash_generated_method = "F31858EBD66DDDE860100CA49483E368")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String(byte[] data, int offset, int byteCount) {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(data[0]);
        dsTaint.addTaint(offset);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.169 -0400", hash_original_method = "22A6AFB2E643FB23D243CAF5D019E325", hash_generated_method = "F506CF2ADD29CEE92D2C7CBAC467F0ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public String(byte[] data, int high, int offset, int byteCount) {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(data[0]);
        dsTaint.addTaint(high);
        dsTaint.addTaint(offset);
        {
            if (DroidSafeAndroidRuntime.control) throw failedBoundsCheck(data.length, offset, byteCount);
        } //End block
        this.offset = 0;
        this.value = new char[byteCount];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.170 -0400", hash_original_method = "D35F458D65648B05442A41C1A12F30CA", hash_generated_method = "BAC80B20D23E54DEF058D564A539CD38")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String(byte[] data, int offset, int byteCount, String charsetName) throws UnsupportedEncodingException {
        this(data, offset, byteCount, Charset.forNameUEE(charsetName));
        dsTaint.addTaint(charsetName);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(data[0]);
        dsTaint.addTaint(offset);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.170 -0400", hash_original_method = "11FE032D0B0EBCDEFC4E4C2065489303", hash_generated_method = "99D2E86180E0CB2E8703F1F26A3549FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String(byte[] data, String charsetName) throws UnsupportedEncodingException {
        this(data, 0, data.length, Charset.forNameUEE(charsetName));
        dsTaint.addTaint(charsetName);
        dsTaint.addTaint(data[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.172 -0400", hash_original_method = "230168F72CB2A0A48AA9F4A7AFCECA03", hash_generated_method = "969DF267D8187FB84A22666E41F49E8E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String(byte[] data, int offset, int byteCount, Charset charset) {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(data[0]);
        dsTaint.addTaint(charset.dsTaint);
        dsTaint.addTaint(offset);
        {
            if (DroidSafeAndroidRuntime.control) throw failedBoundsCheck(data.length, offset, byteCount);
        } //End block
        String canonicalCharsetName;
        canonicalCharsetName = charset.name();
        {
            boolean var0E259348489811E6C7821E4884476552_306849842 = (canonicalCharsetName.equals("UTF-8"));
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
                boolean var2031B49659F344E6C3E3DB6AFAE490EC_1802864083 = (canonicalCharsetName.equals("ISO-8859-1"));
                {
                    this.offset = 0;
                    this.value = new char[byteCount];
                    Charsets.isoLatin1BytesToChars(data, offset, byteCount, value);
                } //End block
                {
                    boolean var0569C8B22675C76A7219D23CD23689EC_1072770556 = (canonicalCharsetName.equals("US-ASCII"));
                    {
                        this.offset = 0;
                        this.value = new char[byteCount];
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.172 -0400", hash_original_method = "9D77FFE69AA84BF1048ED5CBD8EE386C", hash_generated_method = "68A3603C90226FE4056CC4102A20A8FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String(byte[] data, Charset charset) {
        this(data, 0, data.length, charset);
        dsTaint.addTaint(data[0]);
        dsTaint.addTaint(charset.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.173 -0400", hash_original_method = "84FF2A14EA759DC7C1F299809C55E832", hash_generated_method = "4DC2C0055A9CC19D05576F07283ACE0C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String(char[] data) {
        this(data, 0, data.length);
        dsTaint.addTaint(data[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.173 -0400", hash_original_method = "14BFB40845511D49F067DB0E6AC711FE", hash_generated_method = "01C9573FE0030ABA71A602EBDCCF8023")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String(char[] data, int offset, int charCount) {
        dsTaint.addTaint(data[0]);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(charCount);
        {
            if (DroidSafeAndroidRuntime.control) throw failedBoundsCheck(data.length, offset, charCount);
        } //End block
        this.offset = 0;
        this.value = new char[charCount];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.173 -0400", hash_original_method = "6AA52B72AD5521C733ED3E9463435DD5", hash_generated_method = "5F9F813B9E5CC5D108CAFDD98643D03C")
    @DSModeled(DSC.SAFE)
     String(int offset, int charCount, char[] chars) {
        dsTaint.addTaint(chars[0]);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(charCount);
        // ---------- Original Method ----------
        //this.value = chars;
        //this.offset = offset;
        //this.count = charCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.173 -0400", hash_original_method = "7D7AE898849737A5DE2F771028ADD293", hash_generated_method = "2E0A8CA6392B69CB2379A97F07FD2AE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String(String toCopy) {
        dsTaint.addTaint(toCopy);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.174 -0400", hash_original_method = "8B59C74FD130D5556CE63A5F3CE74139", hash_generated_method = "2083A26C8F1B62260729AF9A10137FF6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings( { "unused", "nls" })
    private String(String s1, String s2) {
        dsTaint.addTaint(s2);
        dsTaint.addTaint(s1);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.174 -0400", hash_original_method = "E07460C3146BC4727C3E888CAC21772A", hash_generated_method = "97897941AF209CFFAD90818BC6D3E790")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings( { "unused", "nls" })
    private String(String s1, String s2, String s3) {
        dsTaint.addTaint(s2);
        dsTaint.addTaint(s1);
        dsTaint.addTaint(s3);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.174 -0400", hash_original_method = "C3DEF5F256BD0FFA01404830FE1A0B0E", hash_generated_method = "3BDB35F440A14F3D95DB5C4ACE7D82B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String(StringBuffer stringBuffer) {
        dsTaint.addTaint(stringBuffer.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.175 -0400", hash_original_method = "DE744DAB842D7A0BE4BC8C7648E27967", hash_generated_method = "1BAAD8E181E2272CCF2EFDD33A328F67")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String(int[] codePoints, int offset, int count) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(codePoints[0]);
        dsTaint.addTaint(offset);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.175 -0400", hash_original_method = "1A43E0983F964C9F4090DA81181B802F", hash_generated_method = "B4EF08BF389E88945DEC852260CD7D3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String(StringBuilder stringBuilder) {
        dsTaint.addTaint(stringBuilder.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.176 -0400", hash_original_method = "8767608BAC25DDC267BEC70B13CF72A3", hash_generated_method = "A75B647F875D299D205225656E9DBECA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unused")
    private String(String s1, int v1) {
        dsTaint.addTaint(v1);
        dsTaint.addTaint(s1);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.176 -0400", hash_original_method = "87185450AF15BAF9DFFE5741D5928D9B", hash_generated_method = "81D1A396AB7FF6EF943B8D509FCA0588")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char charAt(int index) {
        dsTaint.addTaint(index);
        return dsTaint.getTaintChar();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.176 -0400", hash_original_method = "00E4125D0AA58BE2E1232BB5FC2C4846", hash_generated_method = "A044538CEF98D69F9B4FA441D0774838")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private StringIndexOutOfBoundsException indexAndLength(int index) {
        dsTaint.addTaint(index);
        if (DroidSafeAndroidRuntime.control) throw new StringIndexOutOfBoundsException(this, index);
        return (StringIndexOutOfBoundsException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new StringIndexOutOfBoundsException(this, index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.177 -0400", hash_original_method = "C5BE1ED07127E02665146DD0ACED99A5", hash_generated_method = "8764C58E4D0579BFA09913A9D4A0A759")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private StringIndexOutOfBoundsException startEndAndLength(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        if (DroidSafeAndroidRuntime.control) throw new StringIndexOutOfBoundsException(this, start, end - start);
        return (StringIndexOutOfBoundsException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new StringIndexOutOfBoundsException(this, start, end - start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.177 -0400", hash_original_method = "FABF855F22C4847A4FF9FC56E0D56C67", hash_generated_method = "7A632307135E8A5BDCA59F5684520CF7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private StringIndexOutOfBoundsException failedBoundsCheck(int arrayLength, int offset, int count) {
        dsTaint.addTaint(arrayLength);
        dsTaint.addTaint(count);
        dsTaint.addTaint(offset);
        if (DroidSafeAndroidRuntime.control) throw new StringIndexOutOfBoundsException(arrayLength, offset, count);
        return (StringIndexOutOfBoundsException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new StringIndexOutOfBoundsException(arrayLength, offset, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.177 -0400", hash_original_method = "1D42C2C4BD065BE4935C25058CB25A0E", hash_generated_method = "51516FE80D4EFD27D74F883B1EB43ABD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private char foldCase(char ch) {
        dsTaint.addTaint(ch);
        char var9B0B758EFD0A99F7034CDAE5D13E5009_571139106 = (Character.toLowerCase(Character.toUpperCase(ch)));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //if (ch < 128) {
            //if ('A' <= ch && ch <= 'Z') {
                //return (char) (ch + ('a' - 'A'));
            //}
            //return ch;
        //}
        //return Character.toLowerCase(Character.toUpperCase(ch));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.178 -0400", hash_original_method = "E601A465E2566ECC4B972E253D5CFD79", hash_generated_method = "E0822EEB5DB79CCB11E2F8D1070D8503")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(String string) {
        dsTaint.addTaint(string);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.179 -0400", hash_original_method = "1A9A71EFE325E55C19A2B451F1A9B9E2", hash_generated_method = "D9A90648E63A09EF39F7041B23835693")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareToIgnoreCase(String string) {
        dsTaint.addTaint(string);
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
                boolean var2E9E8AD3BCB62DCA1A9EF12A54A2335D_1625251466 = ((c1 = value[o1++]) == (c2 = target[o2++]));
            } //End collapsed parenthetic
            c1 = foldCase(c1);
            c2 = foldCase(c2);
            {
                boolean var14CE4A2902BB903E7AFCF8659D231EE2_1252949213 = ((result = c1 - c2) != 0);
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.180 -0400", hash_original_method = "F488471D994E6AC017026A4A172508CF", hash_generated_method = "A31D95E0D3746F7F47B2041A6DC9549D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String concat(String string) {
        dsTaint.addTaint(string);
        {
            char[] buffer;
            buffer = new char[count + string.count];
            System.arraycopy(value, offset, buffer, 0, count);
            System.arraycopy(string.value, string.offset, buffer, count, string.count);
            String var77FBAE1B2334669FE00CD7647C7AD1F5_599027453 = (new String(0, buffer.length, buffer));
        } //End block
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.180 -0400", hash_original_method = "3B37EFF40C149A7A244BFEF0002B2C93", hash_generated_method = "7E4C1A08E7DDB144E6F458258FC3054C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean endsWith(String suffix) {
        dsTaint.addTaint(suffix);
        boolean var76E82A4292B5A1451345CC76AEDF9E15_525315085 = (regionMatches(count - suffix.count, suffix, 0, suffix.count));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return regionMatches(count - suffix.count, suffix, 0, suffix.count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.181 -0400", hash_original_method = "84733F87EF08EE029ED9292B40928CC1", hash_generated_method = "61B7CBEBEBC3DFF2619A2EA6D953D035")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.181 -0400", hash_original_method = "2D6A09B1457D58571ED784483A3E54F2", hash_generated_method = "9B76F1BDBC12BF79BA2DACE70F112741")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @FindBugsSuppressWarnings("ES_COMPARING_PARAMETER_STRING_WITH_EQ")
    public boolean equalsIgnoreCase(String string) {
        dsTaint.addTaint(string);
        {
            boolean var1A493DD12B2DD12B14C7BFE23A6D6C8D_424003830 = (string == this);
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
                boolean var43349C3464A5FA3039AFB5B028B91212_865792743 = (c1 != c2 && foldCase(c1) != foldCase(c2));
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.181 -0400", hash_original_method = "628C355D58441C62D711BC1C2A898A67", hash_generated_method = "29A3DE06AF154596E53BC86EB409E26C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public void getBytes(int start, int end, byte[] data, int index) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(start);
        dsTaint.addTaint(data[0]);
        dsTaint.addTaint(end);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.182 -0400", hash_original_method = "2E4CA200D3933E45C3FC02936B120C89", hash_generated_method = "045A09E8E9152B2A36D6D1423155D479")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getBytes() {
        byte[] var7AC26898B1876959AE0198114C4F4FA9_1950447623 = (getBytes(Charset.defaultCharset()));
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return getBytes(Charset.defaultCharset());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.182 -0400", hash_original_method = "D1476A765D84241818C22751CEBD7DE3", hash_generated_method = "5F6A1C457DB2FCFAB327315E7D894FE6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getBytes(String charsetName) throws UnsupportedEncodingException {
        dsTaint.addTaint(charsetName);
        byte[] var41B1FB585A68731BDFB62182D33FDD75_501373280 = (getBytes(Charset.forNameUEE(charsetName)));
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return getBytes(Charset.forNameUEE(charsetName));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.182 -0400", hash_original_method = "56FDAE3B6641018546E6C6674268142D", hash_generated_method = "256ADC08F623D8177B6C0591AE18643F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getBytes(Charset charset) {
        dsTaint.addTaint(charset.dsTaint);
        String canonicalCharsetName;
        canonicalCharsetName = charset.name();
        {
            boolean var0E259348489811E6C7821E4884476552_89233593 = (canonicalCharsetName.equals("UTF-8"));
            {
                byte[] var9984FE416A6160547A4291CF12EF5977_366628948 = (Charsets.toUtf8Bytes(value, offset, count));
            } //End block
            {
                boolean var2031B49659F344E6C3E3DB6AFAE490EC_1465201248 = (canonicalCharsetName.equals("ISO-8859-1"));
                {
                    byte[] var06F12C18AB207C990E645C1634999BCA_1836236128 = (Charsets.toIsoLatin1Bytes(value, offset, count));
                } //End block
                {
                    boolean var0569C8B22675C76A7219D23CD23689EC_122167323 = (canonicalCharsetName.equals("US-ASCII"));
                    {
                        byte[] var5EE1291BC0FFD1569DC7607C427C86B6_977417665 = (Charsets.toAsciiBytes(value, offset, count));
                    } //End block
                    {
                        boolean var0EE7227B231600ECBF464F0787D46244_1417711892 = (canonicalCharsetName.equals("UTF-16BE"));
                        {
                            byte[] varE1DCEC963687DDFBF9CF1214AE9B988C_1582398108 = (Charsets.toBigEndianUtf16Bytes(value, offset, count));
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
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.182 -0400", hash_original_method = "D443F19C798F5645F696FD1973BB47C6", hash_generated_method = "5500CD2DE59601828997FDC3A3DBC711")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getChars(int start, int end, char[] buffer, int index) {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(index);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        {
            System.arraycopy(value, start + offset, buffer, index, end - start);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw startEndAndLength(start, end);
        } //End block
        // ---------- Original Method ----------
        //if (start >= 0 && start <= end && end <= count) {
            //System.arraycopy(value, start + offset, buffer, index, end - start);
        //} else {
            //throw startEndAndLength(start, end);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.183 -0400", hash_original_method = "25FFBBE7056EE87BB826458DBC43764C", hash_generated_method = "A3FDC784AC12C94C1D92C1C465B88C16")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void _getChars(int start, int end, char[] buffer, int index) {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(index);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        System.arraycopy(value, start + offset, buffer, index, end - start);
        // ---------- Original Method ----------
        //System.arraycopy(value, start + offset, buffer, index, end - start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.183 -0400", hash_original_method = "19D1106FC463FB90112A6C6293D6F5CF", hash_generated_method = "FCF917476B43AAED2582E2BF5063B054")
    @DSModeled(DSC.SAFE)
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.184 -0400", hash_original_method = "C183CC13D668537DB52873A8A3264758", hash_generated_method = "74F88B57FC01100950FB6AEF651EC13D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int indexOf(int c) {
        dsTaint.addTaint(c);
        {
            int var5F851632D6BAA470138E8E6B8CF03AB6_1296240296 = (indexOfSupplementary(c, 0));
        } //End block
        int varBDF102D3B3DB28ED5C430C6E4DC71DED_370647745 = (fastIndexOf(c, 0));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (c > 0xffff) {
            //return indexOfSupplementary(c, 0);
        //}
        //return fastIndexOf(c, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.184 -0400", hash_original_method = "A9B16E70D2A4A056B33DA4268AACFBA9", hash_generated_method = "66989A796E8993A8E6D743E282AE80DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int indexOf(int c, int start) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(c);
        {
            int var5B650999CF272FFC32489F6C46D5030B_357590926 = (indexOfSupplementary(c, start));
        } //End block
        int varF6149B4A88E68FEA46885B131E2A52C3_362440633 = (fastIndexOf(c, start));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (c > 0xffff) {
            //return indexOfSupplementary(c, start);
        //}
        //return fastIndexOf(c, start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.185 -0400", hash_original_method = "158E0BDE7178D291CA067E7481407A6C", hash_generated_method = "8699D72442B72C861DE499D10DB080A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int fastIndexOf(int c, int start) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(c);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.185 -0400", hash_original_method = "9DA1418F8A10F302F688A26755CAB088", hash_generated_method = "3FB098D1B896F5D000391755CE11161F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int indexOfSupplementary(int c, int start) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(c);
        {
            boolean var1055287EA357B1E539F33F3672FA88F7_1264669814 = (!Character.isSupplementaryCodePoint(c));
        } //End collapsed parenthetic
        char[] chars;
        chars = Character.toChars(c);
        String needle;
        needle = new String(0, chars.length, chars);
        int var6E5631C6B9EDE9258144E71393C64491_293843301 = (indexOf(needle, start));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (!Character.isSupplementaryCodePoint(c)) {
            //return -1;
        //}
        //char[] chars = Character.toChars(c);
        //String needle = new String(0, chars.length, chars);
        //return indexOf(needle, start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.186 -0400", hash_original_method = "AC187DA6A9C2600FBA62EFD5097D8F4D", hash_generated_method = "E822775CD0DF536236DEEF21CE8A55F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int indexOf(String string) {
        dsTaint.addTaint(string);
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.186 -0400", hash_original_method = "30C77F2F1070D21229A0301D2E3C23FC", hash_generated_method = "AD75F20DED5843C30D6A29AD8E79A8FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int indexOf(String subString, int start) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(subString);
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.187 -0400", hash_original_method = "8D834ED1699A050AD62397187973DE2A", hash_generated_method = "B95BAF2F4CFAFE8973490A0C44B324C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String intern() {
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.187 -0400", hash_original_method = "9B1CCC3AB82A9C7B7A46C788921405FB", hash_generated_method = "980C3CA394064A1D9FE11B9568A552C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEmpty() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.187 -0400", hash_original_method = "B7458CFA700437DC398BF47C5A311056", hash_generated_method = "79F890EAB6F74947972C050B656ADE81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int lastIndexOf(int c) {
        dsTaint.addTaint(c);
        {
            int varBD342ABA258412F8C448797D2A456C93_1011509753 = (lastIndexOfSupplementary(c, Integer.MAX_VALUE));
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.188 -0400", hash_original_method = "438C7E0E01B0881067FA33086AF4D678", hash_generated_method = "6506EA081A8DB0A79465F1C168A171D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int lastIndexOf(int c, int start) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(c);
        {
            int var6EE07AE0B8AD5BD57E677DC6C0B33723_777282394 = (lastIndexOfSupplementary(c, start));
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.189 -0400", hash_original_method = "ECC6B0EDCC4F01358439BB31BFF21134", hash_generated_method = "CF9F2C2502337C3F2393DA464C576BC3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int lastIndexOfSupplementary(int c, int start) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(c);
        {
            boolean var1055287EA357B1E539F33F3672FA88F7_398711204 = (!Character.isSupplementaryCodePoint(c));
        } //End collapsed parenthetic
        char[] chars;
        chars = Character.toChars(c);
        String needle;
        needle = new String(0, chars.length, chars);
        int varB6048C8F2399670687E5E6BB049C087D_1247800275 = (lastIndexOf(needle, start));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (!Character.isSupplementaryCodePoint(c)) {
            //return -1;
        //}
        //char[] chars = Character.toChars(c);
        //String needle = new String(0, chars.length, chars);
        //return lastIndexOf(needle, start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.189 -0400", hash_original_method = "692347B4AF93950259A2DA740A39B258", hash_generated_method = "303F9E6E2F3D070E2A647CD7A985A72D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int lastIndexOf(String string) {
        dsTaint.addTaint(string);
        int var629483EEC7DE422E0B8E730771A3942E_766576621 = (lastIndexOf(string, count));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return lastIndexOf(string, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.190 -0400", hash_original_method = "08D5FBAA11FAAE0244D1BD87258C05E0", hash_generated_method = "66FF3D882CC95B4ACD31EC34EA3D46C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int lastIndexOf(String subString, int start) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(subString);
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.190 -0400", hash_original_method = "026D3AE6EA7284BA85CF864429138595", hash_generated_method = "E25C0FBBB29F1CD3F5C25928BEF2E085")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int length() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.190 -0400", hash_original_method = "8EA3BFAB97A4D4877FC2554FB493C6C0", hash_generated_method = "475A6D886A75FDB908C480AE25B2F9E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean regionMatches(int thisStart, String string, int start, int length) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(string);
        dsTaint.addTaint(thisStart);
        dsTaint.addTaint(length);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.191 -0400", hash_original_method = "5098FC46543D7D1A735E08AA962F8003", hash_generated_method = "8AFD03A8761160A16C2FCADAF1280742")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean regionMatches(boolean ignoreCase, int thisStart, String string, int start, int length) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(string);
        dsTaint.addTaint(thisStart);
        dsTaint.addTaint(length);
        dsTaint.addTaint(ignoreCase);
        {
            boolean var6F73B44E0EF89A3667DD4B1125A02E25_1961786724 = (regionMatches(thisStart, string, start, length));
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
                boolean var43349C3464A5FA3039AFB5B028B91212_686342510 = (c1 != c2 && foldCase(c1) != foldCase(c2));
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.191 -0400", hash_original_method = "52751D07523F52C15F0E15149B768BF7", hash_generated_method = "D175B1F113F7865EC70379658BE6B468")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String replace(char oldChar, char newChar) {
        dsTaint.addTaint(oldChar);
        dsTaint.addTaint(newChar);
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
        {
            Object varDA1C584D30C4DEC699D9E344B716521F_854740754 = (new String(0, count, buffer));
        } //End flattened ternary
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.192 -0400", hash_original_method = "226EAAC156D556D42E48670E64FEC4E8", hash_generated_method = "320F2407AA5952A88AF92658D8D3FE9E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String replace(CharSequence target, CharSequence replacement) {
        dsTaint.addTaint(replacement);
        dsTaint.addTaint(target);
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
            String varEC2CAD6F4392C35EA2158E6C5520B613_196505409 = (result.toString());
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
            boolean varDF5B9E27CB5E1F6FE60A3DAF131B74C7_439433256 = ((matchStart = indexOf(targetString, searchStart)) != -1);
        } //End collapsed parenthetic
        result.append(value, offset + searchStart, count - searchStart);
        String varEA70154FDA28CC59402440C6317B57EF_306922349 = (result.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.192 -0400", hash_original_method = "8508513C5D9E5D7A42B020CFB91803A3", hash_generated_method = "CDCA571EA4A95747434511460371FE96")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean startsWith(String prefix) {
        dsTaint.addTaint(prefix);
        boolean varE400B78CFCF899225EE690557CD93052_774683369 = (startsWith(prefix, 0));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return startsWith(prefix, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.192 -0400", hash_original_method = "DCA59D254EE64B3144EDF9B3ACB43A45", hash_generated_method = "73BC6E59433C08E7CA679E380E34E6D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean startsWith(String prefix, int start) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(prefix);
        boolean varA8E1CDADA007E83510DD5CFA9EE42F80_443830557 = (regionMatches(start, prefix, 0, prefix.count));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return regionMatches(start, prefix, 0, prefix.count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.193 -0400", hash_original_method = "CB27750752A8934950488E0046CA5119", hash_generated_method = "82567B8BE1180CD9BD01D795C3D078AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String substring(int start) {
        dsTaint.addTaint(start);
        {
            String varEAC2BCFA3DF7FD925B160E041A5B8DBD_1511758098 = (new String(offset + start, count - start, value));
        } //End block
        if (DroidSafeAndroidRuntime.control) throw indexAndLength(start);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (start == 0) {
            //return this;
        //}
        //if (start >= 0 && start <= count) {
            //return new String(offset + start, count - start, value);
        //}
        //throw indexAndLength(start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.193 -0400", hash_original_method = "FA273138383309E9BFDA8AAE2A7C6025", hash_generated_method = "C861456F38B7345A0EFC7549E0B2D5E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String substring(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        {
            String var3DCF4729D740F42B54BCCF9013A04AD4_866001077 = (new String(offset + start, end - start, value));
        } //End block
        if (DroidSafeAndroidRuntime.control) throw startEndAndLength(start, end);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (start == 0 && end == count) {
            //return this;
        //}
        //if (start >= 0 && start <= end && end <= count) {
            //return new String(offset + start, end - start, value);
        //}
        //throw startEndAndLength(start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.195 -0400", hash_original_method = "66BAEF040BB5FDC80731F9B16CD33C32", hash_generated_method = "8071C9232C2418DC1C0A914EA02E26CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char[] toCharArray() {
        char[] buffer;
        buffer = new char[count];
        System.arraycopy(value, offset, buffer, 0, count);
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
        // ---------- Original Method ----------
        //char[] buffer = new char[count];
        //System.arraycopy(value, offset, buffer, 0, count);
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.195 -0400", hash_original_method = "1FBB4BF6938E55C9E24FEC1EE0A95252", hash_generated_method = "F54C78913C9F88EC586FC8ECBE0909CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toLowerCase() {
        String var64CBE5573E71B31BED13978E4C7005B5_1763375901 = (CaseMapper.toLowerCase(Locale.getDefault(), this, value, offset, count));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return CaseMapper.toLowerCase(Locale.getDefault(), this, value, offset, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.195 -0400", hash_original_method = "3BCA227A64DF8F05552679E5E357BCF1", hash_generated_method = "59D3932F518443CA489187C03C1692E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toLowerCase(Locale locale) {
        dsTaint.addTaint(locale.dsTaint);
        String var4E2DBF3918E0615B14D675268D8A00AF_759052259 = (CaseMapper.toLowerCase(locale, this, value, offset, count));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return CaseMapper.toLowerCase(locale, this, value, offset, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.195 -0400", hash_original_method = "068E2EE4236B85776135405F1B66AD49", hash_generated_method = "3D60F27BBC407E4509F1A91DFB92A2CC")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.195 -0400", hash_original_method = "8DEC33A26AFC2829CCCCE108ECEB9551", hash_generated_method = "B19BEBD555C51C2127047D6C01A25C27")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toUpperCase() {
        String var8E9645C921F10C8A7448402D2B14568C_1769997477 = (CaseMapper.toUpperCase(Locale.getDefault(), this, value, offset, count));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return CaseMapper.toUpperCase(Locale.getDefault(), this, value, offset, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.196 -0400", hash_original_method = "11C711663B7D81E6BD865533BF51B442", hash_generated_method = "271F437289A044DF524E476EF811B124")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toUpperCase(Locale locale) {
        dsTaint.addTaint(locale.dsTaint);
        String var041A1D5CCEFA71908AFFB695A32DC09C_1019231098 = (CaseMapper.toUpperCase(locale, this, value, offset, count));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return CaseMapper.toUpperCase(locale, this, value, offset, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.196 -0400", hash_original_method = "5AB01C88F799E5B54FF71EE82B91E811", hash_generated_method = "C6143F61938C3D413710CF5E750FA592")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String trim() {
        int start, last;
        start = offset;
        last = offset + count - 1;
        int end;
        end = last;
        String var311DD06085C5B8F53646E8178C77DA50_1836441373 = (new String(start, end - start + 1, value));
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.198 -0400", hash_original_method = "233CB676C051D9EE76740A9343D1B467", hash_generated_method = "583CB24504509B1FFA6D5EB42CF0F23B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean contentEquals(StringBuffer strbuf) {
        dsTaint.addTaint(strbuf.dsTaint);
        {
            int size;
            size = strbuf.length();
            boolean var8AD291071900A808E3CDC7318D3290C1_1574178841 = (regionMatches(0, new String(0, size, strbuf.getValue()), 0,
                    size));
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.198 -0400", hash_original_method = "733340B51AD84F3351AE4177729AE631", hash_generated_method = "4EC50633CE29B92B783A893947170E52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean contentEquals(CharSequence cs) {
        dsTaint.addTaint(cs);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        int len;
        len = cs.length();
        boolean var4A8EFCED17558E2F34148C8126361B5F_531969792 = (regionMatches(0, cs.toString(), 0, len));
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.198 -0400", hash_original_method = "54546B1154273B2EF815CC4641C4AF95", hash_generated_method = "F157A54402F79A891BD277C1CCF6FAB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean matches(String regularExpression) {
        dsTaint.addTaint(regularExpression);
        boolean var1D596A9C37FF533C6DBD6EF8C6FD418B_1277475205 = (Pattern.matches(regularExpression, this));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return Pattern.matches(regularExpression, this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.199 -0400", hash_original_method = "85FB9291CC087326BB42DD27D5FF2770", hash_generated_method = "0F638B22E7339DC4621B0836F976EEB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String replaceAll(String regularExpression, String replacement) {
        dsTaint.addTaint(replacement);
        dsTaint.addTaint(regularExpression);
        String var8200163060C4FB23BBA099C591F629E3_1463659770 = (Pattern.compile(regularExpression).matcher(this).replaceAll(replacement));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return Pattern.compile(regularExpression).matcher(this).replaceAll(replacement);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.199 -0400", hash_original_method = "B1F6469D7EA429A7B60DE2A4BC9D1B18", hash_generated_method = "4DE5B72975E25F1B5B70EDE9FD53BE76")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String replaceFirst(String regularExpression, String replacement) {
        dsTaint.addTaint(replacement);
        dsTaint.addTaint(regularExpression);
        String varD3978D0F46F553C29AA67C6621F52FDE_272147878 = (Pattern.compile(regularExpression).matcher(this).replaceFirst(replacement));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return Pattern.compile(regularExpression).matcher(this).replaceFirst(replacement);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.199 -0400", hash_original_method = "0ADD043F2AA11242F9B6645F9D3630BF", hash_generated_method = "528B56EF33532C9E3A3937F4D7692528")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] split(String regularExpression) {
        dsTaint.addTaint(regularExpression);
        String[] var7535273CACCB815CB5E54901C6AF308A_133066721 = (split(regularExpression, 0));
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return split(regularExpression, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.199 -0400", hash_original_method = "4FB3AE192250E9EE292BE09F829C7FA4", hash_generated_method = "A667CEF798C12472BDB019EE8D0FDE9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] split(String regularExpression, int limit) {
        dsTaint.addTaint(limit);
        dsTaint.addTaint(regularExpression);
        String[] result;
        result = java.util.regex.Splitter.fastSplit(regularExpression, this, limit);
        {
            Object var1D4671BF407EE5474FA0D6122AEA04DD_1936776456 = (Pattern.compile(regularExpression).split(this, limit));
        } //End flattened ternary
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //String[] result = java.util.regex.Splitter.fastSplit(regularExpression, this, limit);
        //return result != null ? result : Pattern.compile(regularExpression).split(this, limit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.200 -0400", hash_original_method = "30B2B5AAE6BF00B7B5DE2415CD1C93C0", hash_generated_method = "7C3C45E66253C224FB5CD9C1B871E476")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence subSequence(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        CharSequence varC847D8C41835030B7BEFF7774EE43A1F_169732838 = (substring(start, end));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return substring(start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.200 -0400", hash_original_method = "C7D49B0E887DD351A54FAD0BD917A973", hash_generated_method = "7B6401EF5D654293CAAF63B0ECE51A5D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int codePointAt(int index) {
        dsTaint.addTaint(index);
        {
            if (DroidSafeAndroidRuntime.control) throw indexAndLength(index);
        } //End block
        int var91459A9F7713DB06A5C91858CFACEC5A_886832956 = (Character.codePointAt(value, offset + index, offset + count));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (index < 0 || index >= count) {
            //throw indexAndLength(index);
        //}
        //return Character.codePointAt(value, offset + index, offset + count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.200 -0400", hash_original_method = "45488902F6B74F4C7EAF8C828C18FB65", hash_generated_method = "9F5E6081921A6624C00F4109D8968BD1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int codePointBefore(int index) {
        dsTaint.addTaint(index);
        {
            if (DroidSafeAndroidRuntime.control) throw indexAndLength(index);
        } //End block
        int varF97594D4D0200951C1EDA2EC22454DCA_891150776 = (Character.codePointBefore(value, offset + index, offset));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (index < 1 || index > count) {
            //throw indexAndLength(index);
        //}
        //return Character.codePointBefore(value, offset + index, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.201 -0400", hash_original_method = "B50CCA2DE0C54B693E25540AFEB12014", hash_generated_method = "41BF18F7910B3374A0B4F3FD8D23C11A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int codePointCount(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        {
            if (DroidSafeAndroidRuntime.control) throw startEndAndLength(start, end);
        } //End block
        int varCDB29150FACB3F645BFF42DCED3004F1_1794161369 = (Character.codePointCount(value, offset + start, end - start));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (start < 0 || end > count || start > end) {
            //throw startEndAndLength(start, end);
        //}
        //return Character.codePointCount(value, offset + start, end - start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.201 -0400", hash_original_method = "994533EB4329C14FF0C3B68A297AD053", hash_generated_method = "1C787760CB73BBF3F27A944084A61346")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean contains(CharSequence cs) {
        dsTaint.addTaint(cs);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        boolean varBD86DE7AF63F37539131A6619268C3BC_928132752 = (indexOf(cs.toString()) >= 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (cs == null) {
            //throw new NullPointerException();
        //}
        //return indexOf(cs.toString()) >= 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.201 -0400", hash_original_method = "3AF353F7691F77FE6437135BD27DAE4A", hash_generated_method = "B2CDDBFC9102FB3015CBC6414AC920C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int offsetByCodePoints(int index, int codePointOffset) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(codePointOffset);
        int s;
        s = index + offset;
        int r;
        r = Character.offsetByCodePoints(value, offset, count, s, codePointOffset);
        return dsTaint.getTaintInt();
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.202 -0400", hash_original_method = "398E0F5616EDD3EE099DC9E4C0803B95", hash_generated_method = "398E0F5616EDD3EE099DC9E4C0803B95")
                public CaseInsensitiveComparator ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.202 -0400", hash_original_method = "10AFFFE45F62C15CA0052EB0BB14A8D3", hash_generated_method = "F7082209DF1143E7F0DE2CB026B3E726")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int compare(String o1, String o2) {
            dsTaint.addTaint(o2);
            dsTaint.addTaint(o1);
            int var85510175C4EBB5C1D8819E1DE2BF7041_524757699 = (o1.compareToIgnoreCase(o2));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return o1.compareToIgnoreCase(o2);
        }

        
        private static final long serialVersionUID = 8575799808933029326L;
    }


    
    private static final long serialVersionUID = -6849794470754667710L;
    private static final char REPLACEMENT_CHAR = (char) 0xfffd;
    public static final Comparator<String> CASE_INSENSITIVE_ORDER = new CaseInsensitiveComparator();
    private static final char[] ASCII;
    static {
        ASCII = new char[128];
        for (int i = 0; i < ASCII.length; ++i) {
            ASCII[i] = (char) i;
        }
    }
    
}

