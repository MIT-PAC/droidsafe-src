package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static final long serialVersionUID = -6849794470754667710L;
    private static final char REPLACEMENT_CHAR = (char) 0xfffd;
    public static final Comparator<String> CASE_INSENSITIVE_ORDER = new CaseInsensitiveComparator();
    private static final char[] ASCII;
    private final char[] value;
    private final int offset;
    private final int count;
    private int hashCode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.925 -0400", hash_original_method = "F65E96A775698E2C256BB1E903F5D8A6", hash_generated_method = "D9629FBE30968CBB226C8938E31472F1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.925 -0400", hash_original_method = "8A258D0AF74DE6E118252D0EA5531366", hash_generated_method = "4846D8119FC373C651590419BBA06FA6")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.925 -0400", hash_original_method = "3CF6472F1EAFF36B200903831BC9D282", hash_generated_method = "F269FF24B758566E7DA3E62A96D0ED3D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @FindBugsSuppressWarnings("DM_DEFAULT_ENCODING")
    public String(byte[] data) {
        this(data, 0, data.length);
        dsTaint.addTaint(data);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.925 -0400", hash_original_method = "94FE9BFA8A903BE49DF8F4E82A84C713", hash_generated_method = "62C2DA147DA7E6FE24826DAE9E4D6E3D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public String(byte[] data, int high) {
        this(data, high, 0, data.length);
        dsTaint.addTaint(data);
        dsTaint.addTaint(high);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.925 -0400", hash_original_method = "9C5B9D3903B08C7F386C9C307D28A8D8", hash_generated_method = "320AF248C5D895AD2CD3C55174637A13")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String(byte[] data, int offset, int byteCount) {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(data);
        dsTaint.addTaint(offset);
        {
            throw failedBoundsCheck(data.length, offset, byteCount);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.925 -0400", hash_original_method = "22A6AFB2E643FB23D243CAF5D019E325", hash_generated_method = "2C29DE7BFEA3BC1C0F01D74F30FDC993")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public String(byte[] data, int high, int offset, int byteCount) {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(data);
        dsTaint.addTaint(high);
        dsTaint.addTaint(offset);
        {
            throw failedBoundsCheck(data.length, offset, byteCount);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.925 -0400", hash_original_method = "D35F458D65648B05442A41C1A12F30CA", hash_generated_method = "A40D3B0C803364F338CB2E9715CD36B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String(byte[] data, int offset, int byteCount, String charsetName) throws UnsupportedEncodingException {
        this(data, offset, byteCount, Charset.forNameUEE(charsetName));
        dsTaint.addTaint(charsetName);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(data);
        dsTaint.addTaint(offset);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.925 -0400", hash_original_method = "11FE032D0B0EBCDEFC4E4C2065489303", hash_generated_method = "CC4D8862658ADE0631C6C98255016348")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String(byte[] data, String charsetName) throws UnsupportedEncodingException {
        this(data, 0, data.length, Charset.forNameUEE(charsetName));
        dsTaint.addTaint(charsetName);
        dsTaint.addTaint(data);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.926 -0400", hash_original_method = "230168F72CB2A0A48AA9F4A7AFCECA03", hash_generated_method = "2AD4C83025AA159538B880C079BB0EA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String(byte[] data, int offset, int byteCount, Charset charset) {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(data);
        dsTaint.addTaint(charset.dsTaint);
        dsTaint.addTaint(offset);
        {
            throw failedBoundsCheck(data.length, offset, byteCount);
        } //End block
        String canonicalCharsetName;
        canonicalCharsetName = charset.name();
        {
            boolean var0E259348489811E6C7821E4884476552_1493625154 = (canonicalCharsetName.equals("UTF-8"));
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
                                    idx--;
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
                boolean var2031B49659F344E6C3E3DB6AFAE490EC_2054318081 = (canonicalCharsetName.equals("ISO-8859-1"));
                {
                    this.offset = 0;
                    this.value = new char[byteCount];
                    Charsets.isoLatin1BytesToChars(data, offset, byteCount, value);
                } //End block
                {
                    boolean var0569C8B22675C76A7219D23CD23689EC_341338064 = (canonicalCharsetName.equals("US-ASCII"));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.926 -0400", hash_original_method = "9D77FFE69AA84BF1048ED5CBD8EE386C", hash_generated_method = "B589325787500235F6E689EF86DDEAC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String(byte[] data, Charset charset) {
        this(data, 0, data.length, charset);
        dsTaint.addTaint(data);
        dsTaint.addTaint(charset.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.926 -0400", hash_original_method = "84FF2A14EA759DC7C1F299809C55E832", hash_generated_method = "302183C6CDD8F0F1F371090C447D918C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String(char[] data) {
        this(data, 0, data.length);
        dsTaint.addTaint(data);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.927 -0400", hash_original_method = "14BFB40845511D49F067DB0E6AC711FE", hash_generated_method = "5645E4CA6DE1A2BBE3BC9E251D86B972")
    @DSModeled(DSC.SAFE)
    public String(char[] data, int offset, int charCount) {
        dsTaint.addTaint(data);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(charCount);
        {
            throw failedBoundsCheck(data.length, offset, charCount);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.927 -0400", hash_original_method = "6AA52B72AD5521C733ED3E9463435DD5", hash_generated_method = "047C5144B6CAD197527E23A48C826C15")
    @DSModeled(DSC.SAFE)
     String(int offset, int charCount, char[] chars) {
        dsTaint.addTaint(chars);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(charCount);
        // ---------- Original Method ----------
        //this.value = chars;
        //this.offset = offset;
        //this.count = charCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.927 -0400", hash_original_method = "7D7AE898849737A5DE2F771028ADD293", hash_generated_method = "68A979C87105A6A538ADFADBD5F53771")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.927 -0400", hash_original_method = "8B59C74FD130D5556CE63A5F3CE74139", hash_generated_method = "1AC2AA378E44439E73E7A027D5CAD3B3")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.927 -0400", hash_original_method = "E07460C3146BC4727C3E888CAC21772A", hash_generated_method = "11B83384349CB2F7FD860780EE1984CF")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.927 -0400", hash_original_method = "C3DEF5F256BD0FFA01404830FE1A0B0E", hash_generated_method = "2936F65DAC719F5E04510241535A7839")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.927 -0400", hash_original_method = "DE744DAB842D7A0BE4BC8C7648E27967", hash_generated_method = "7633D5BB2CE20AF54BFB028F513F24C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String(int[] codePoints, int offset, int count) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(codePoints);
        dsTaint.addTaint(offset);
        {
            throw new NullPointerException();
        } //End block
        {
            throw failedBoundsCheck(codePoints.length, offset, count);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.927 -0400", hash_original_method = "1A43E0983F964C9F4090DA81181B802F", hash_generated_method = "C268F4B16B5F9D0F71C82D4742DB5BF3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String(StringBuilder stringBuilder) {
        dsTaint.addTaint(stringBuilder.dsTaint);
        {
            throw new NullPointerException("stringBuilder == null");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.928 -0400", hash_original_method = "8767608BAC25DDC267BEC70B13CF72A3", hash_generated_method = "31334C9D854AC60F989E92A9A1F86E74")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.928 -0400", hash_original_method = "87185450AF15BAF9DFFE5741D5928D9B", hash_generated_method = "F99EAAD7693E02569698173C105BBC87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char charAt(int index) {
        dsTaint.addTaint(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.928 -0400", hash_original_method = "00E4125D0AA58BE2E1232BB5FC2C4846", hash_generated_method = "5C5C32B3A54D94EC5249B5639797DBCC")
    @DSModeled(DSC.SAFE)
    private StringIndexOutOfBoundsException indexAndLength(int index) {
        dsTaint.addTaint(index);
        throw new StringIndexOutOfBoundsException(this, index);
        return (StringIndexOutOfBoundsException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new StringIndexOutOfBoundsException(this, index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.928 -0400", hash_original_method = "C5BE1ED07127E02665146DD0ACED99A5", hash_generated_method = "F62E09E769B5FB97BA61D8990B4452FB")
    @DSModeled(DSC.SAFE)
    private StringIndexOutOfBoundsException startEndAndLength(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        throw new StringIndexOutOfBoundsException(this, start, end - start);
        return (StringIndexOutOfBoundsException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new StringIndexOutOfBoundsException(this, start, end - start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.928 -0400", hash_original_method = "FABF855F22C4847A4FF9FC56E0D56C67", hash_generated_method = "010530D70A66A814DD30C68AFFC3DF8E")
    @DSModeled(DSC.SAFE)
    private StringIndexOutOfBoundsException failedBoundsCheck(int arrayLength, int offset, int count) {
        dsTaint.addTaint(arrayLength);
        dsTaint.addTaint(count);
        dsTaint.addTaint(offset);
        throw new StringIndexOutOfBoundsException(arrayLength, offset, count);
        return (StringIndexOutOfBoundsException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new StringIndexOutOfBoundsException(arrayLength, offset, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.928 -0400", hash_original_method = "1D42C2C4BD065BE4935C25058CB25A0E", hash_generated_method = "993E506EC6FE6FDF3A96BFF714665537")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private char foldCase(char ch) {
        dsTaint.addTaint(ch);
        char var9B0B758EFD0A99F7034CDAE5D13E5009_29550280 = (Character.toLowerCase(Character.toUpperCase(ch)));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.928 -0400", hash_original_method = "E601A465E2566ECC4B972E253D5CFD79", hash_generated_method = "2E736FA4B0AE58C2D98E59421B77A6AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(String string) {
        dsTaint.addTaint(string);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.928 -0400", hash_original_method = "1A9A71EFE325E55C19A2B451F1A9B9E2", hash_generated_method = "17D04593684BAA24BA12FAB23CD7F602")
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
                boolean var2E9E8AD3BCB62DCA1A9EF12A54A2335D_483011147 = ((c1 = value[o1++]) == (c2 = target[o2++]));
            } //End collapsed parenthetic
            c1 = foldCase(c1);
            c2 = foldCase(c2);
            {
                boolean var14CE4A2902BB903E7AFCF8659D231EE2_2091786125 = ((result = c1 - c2) != 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.928 -0400", hash_original_method = "F488471D994E6AC017026A4A172508CF", hash_generated_method = "A9C007C0029B590E5F8C9DBEA54A4CFA")
    @DSModeled(DSC.SAFE)
    public String concat(String string) {
        dsTaint.addTaint(string);
        {
            char[] buffer;
            buffer = new char[count + string.count];
            System.arraycopy(value, offset, buffer, 0, count);
            System.arraycopy(string.value, string.offset, buffer, count, string.count);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.928 -0400", hash_original_method = "5D1D071EC3D763C118809FF93B3AD7D2", hash_generated_method = "54629D8B18A57A2E1721D58027EED67E")
    public static String copyValueOf(char[] data) {
        return new String(data, 0, data.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.928 -0400", hash_original_method = "3093818BF79083B0FD2B917354862E11", hash_generated_method = "1C060EFB703FE482F85284AE10D6F2E9")
    public static String copyValueOf(char[] data, int start, int length) {
        return new String(data, start, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.928 -0400", hash_original_method = "3B37EFF40C149A7A244BFEF0002B2C93", hash_generated_method = "A3685D2B640EC82450B0FE121C3E8AE3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean endsWith(String suffix) {
        dsTaint.addTaint(suffix);
        boolean var76E82A4292B5A1451345CC76AEDF9E15_145592914 = (regionMatches(count - suffix.count, suffix, 0, suffix.count));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return regionMatches(count - suffix.count, suffix, 0, suffix.count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.928 -0400", hash_original_method = "84733F87EF08EE029ED9292B40928CC1", hash_generated_method = "47D8A5C69EAAE9AF51C8627E085D3734")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.929 -0400", hash_original_method = "2D6A09B1457D58571ED784483A3E54F2", hash_generated_method = "1627423C0192DB1091BE7766C6CEB79B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @FindBugsSuppressWarnings("ES_COMPARING_PARAMETER_STRING_WITH_EQ")
    public boolean equalsIgnoreCase(String string) {
        dsTaint.addTaint(string);
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
                boolean var43349C3464A5FA3039AFB5B028B91212_1389342714 = (c1 != c2 && foldCase(c1) != foldCase(c2));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.929 -0400", hash_original_method = "628C355D58441C62D711BC1C2A898A67", hash_generated_method = "38BCBBF1DDD2FF35CECF3E1007E36879")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void getBytes(int start, int end, byte[] data, int index) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(start);
        dsTaint.addTaint(data);
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
                throw failedBoundsCheck(data.length, index, end - start);
            } //End block
        } //End block
        {
            throw startEndAndLength(start, end);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.929 -0400", hash_original_method = "2E4CA200D3933E45C3FC02936B120C89", hash_generated_method = "486713166DA6034A03F567F9BCE355F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getBytes() {
        byte[] var7AC26898B1876959AE0198114C4F4FA9_711614665 = (getBytes(Charset.defaultCharset()));
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return getBytes(Charset.defaultCharset());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.929 -0400", hash_original_method = "D1476A765D84241818C22751CEBD7DE3", hash_generated_method = "D8F01063E333ADD095A58B287CD2CB85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getBytes(String charsetName) throws UnsupportedEncodingException {
        dsTaint.addTaint(charsetName);
        byte[] var41B1FB585A68731BDFB62182D33FDD75_354045221 = (getBytes(Charset.forNameUEE(charsetName)));
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return getBytes(Charset.forNameUEE(charsetName));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.929 -0400", hash_original_method = "56FDAE3B6641018546E6C6674268142D", hash_generated_method = "E71F510489E46BE9D9A688AD053E3652")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getBytes(Charset charset) {
        dsTaint.addTaint(charset.dsTaint);
        String canonicalCharsetName;
        canonicalCharsetName = charset.name();
        {
            boolean var0E259348489811E6C7821E4884476552_14768195 = (canonicalCharsetName.equals("UTF-8"));
            {
                byte[] var9984FE416A6160547A4291CF12EF5977_1116961958 = (Charsets.toUtf8Bytes(value, offset, count));
            } //End block
            {
                boolean var2031B49659F344E6C3E3DB6AFAE490EC_1075598265 = (canonicalCharsetName.equals("ISO-8859-1"));
                {
                    byte[] var06F12C18AB207C990E645C1634999BCA_2133985763 = (Charsets.toIsoLatin1Bytes(value, offset, count));
                } //End block
                {
                    boolean var0569C8B22675C76A7219D23CD23689EC_1147758543 = (canonicalCharsetName.equals("US-ASCII"));
                    {
                        byte[] var5EE1291BC0FFD1569DC7607C427C86B6_575771903 = (Charsets.toAsciiBytes(value, offset, count));
                    } //End block
                    {
                        boolean var0EE7227B231600ECBF464F0787D46244_1733619913 = (canonicalCharsetName.equals("UTF-16BE"));
                        {
                            byte[] varE1DCEC963687DDFBF9CF1214AE9B988C_1366412869 = (Charsets.toBigEndianUtf16Bytes(value, offset, count));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.929 -0400", hash_original_method = "D443F19C798F5645F696FD1973BB47C6", hash_generated_method = "638DE9139CDC2B0D2612575429454015")
    @DSModeled(DSC.SAFE)
    public void getChars(int start, int end, char[] buffer, int index) {
        dsTaint.addTaint(buffer);
        dsTaint.addTaint(index);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        {
            System.arraycopy(value, start + offset, buffer, index, end - start);
        } //End block
        {
            throw startEndAndLength(start, end);
        } //End block
        // ---------- Original Method ----------
        //if (start >= 0 && start <= end && end <= count) {
            //System.arraycopy(value, start + offset, buffer, index, end - start);
        //} else {
            //throw startEndAndLength(start, end);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.929 -0400", hash_original_method = "25FFBBE7056EE87BB826458DBC43764C", hash_generated_method = "CC1BC37117B8D81911A918C88CEA4A8A")
    @DSModeled(DSC.SAFE)
     void _getChars(int start, int end, char[] buffer, int index) {
        dsTaint.addTaint(buffer);
        dsTaint.addTaint(index);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        System.arraycopy(value, start + offset, buffer, index, end - start);
        // ---------- Original Method ----------
        //System.arraycopy(value, start + offset, buffer, index, end - start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.930 -0400", hash_original_method = "19D1106FC463FB90112A6C6293D6F5CF", hash_generated_method = "7A1DDA1A1A8C95D97900F820F4D9A779")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        int hash;
        hash = hashCode;
        {
            final int end;
            end = count + offset;
            final char[] chars;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.930 -0400", hash_original_method = "C183CC13D668537DB52873A8A3264758", hash_generated_method = "8A32169C67B8229166CB56EE796597A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int indexOf(int c) {
        dsTaint.addTaint(c);
        {
            int var5F851632D6BAA470138E8E6B8CF03AB6_1850907990 = (indexOfSupplementary(c, 0));
        } //End block
        int varBDF102D3B3DB28ED5C430C6E4DC71DED_1295400155 = (fastIndexOf(c, 0));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (c > 0xffff) {
            //return indexOfSupplementary(c, 0);
        //}
        //return fastIndexOf(c, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.930 -0400", hash_original_method = "A9B16E70D2A4A056B33DA4268AACFBA9", hash_generated_method = "01743D3FDE2F6CCB61039E6419060491")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int indexOf(int c, int start) {
        dsTaint.addTaint(c);
        dsTaint.addTaint(start);
        {
            int var5B650999CF272FFC32489F6C46D5030B_1864238896 = (indexOfSupplementary(c, start));
        } //End block
        int varF6149B4A88E68FEA46885B131E2A52C3_497145320 = (fastIndexOf(c, start));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (c > 0xffff) {
            //return indexOfSupplementary(c, start);
        //}
        //return fastIndexOf(c, start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.930 -0400", hash_original_method = "158E0BDE7178D291CA067E7481407A6C", hash_generated_method = "39D932F049F33182C36CB453695615D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int fastIndexOf(int c, int start) {
        dsTaint.addTaint(c);
        dsTaint.addTaint(start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.930 -0400", hash_original_method = "9DA1418F8A10F302F688A26755CAB088", hash_generated_method = "0914854D06888598707D6BA24BA38D70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int indexOfSupplementary(int c, int start) {
        dsTaint.addTaint(c);
        dsTaint.addTaint(start);
        {
            boolean var1055287EA357B1E539F33F3672FA88F7_1875559441 = (!Character.isSupplementaryCodePoint(c));
        } //End collapsed parenthetic
        char[] chars;
        chars = Character.toChars(c);
        String needle;
        needle = new String(0, chars.length, chars);
        int var6E5631C6B9EDE9258144E71393C64491_528413868 = (indexOf(needle, start));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (!Character.isSupplementaryCodePoint(c)) {
            //return -1;
        //}
        //char[] chars = Character.toChars(c);
        //String needle = new String(0, chars.length, chars);
        //return indexOf(needle, start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.930 -0400", hash_original_method = "AC187DA6A9C2600FBA62EFD5097D8F4D", hash_generated_method = "352183FA3CC1FA56F26E55A5F2D5289B")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.930 -0400", hash_original_method = "30C77F2F1070D21229A0301D2E3C23FC", hash_generated_method = "A63C601F7EB0945324B133A420BEC6D9")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.930 -0400", hash_original_method = "8D834ED1699A050AD62397187973DE2A", hash_generated_method = "90DC457E2EEF78DEDFB646BFE5D03A85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String intern() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.930 -0400", hash_original_method = "9B1CCC3AB82A9C7B7A46C788921405FB", hash_generated_method = "4E74ADDF216264F808BE80126788B2B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEmpty() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.930 -0400", hash_original_method = "B7458CFA700437DC398BF47C5A311056", hash_generated_method = "0042B699628FADA1881986AF51FD34D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int lastIndexOf(int c) {
        dsTaint.addTaint(c);
        {
            int varBD342ABA258412F8C448797D2A456C93_99086983 = (lastIndexOfSupplementary(c, Integer.MAX_VALUE));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.931 -0400", hash_original_method = "438C7E0E01B0881067FA33086AF4D678", hash_generated_method = "32537D83702EEA61F3C356938F449C5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int lastIndexOf(int c, int start) {
        dsTaint.addTaint(c);
        dsTaint.addTaint(start);
        {
            int var6EE07AE0B8AD5BD57E677DC6C0B33723_1304001945 = (lastIndexOfSupplementary(c, start));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.931 -0400", hash_original_method = "ECC6B0EDCC4F01358439BB31BFF21134", hash_generated_method = "D7CC4858F7274E0760D29C102A4BF0CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int lastIndexOfSupplementary(int c, int start) {
        dsTaint.addTaint(c);
        dsTaint.addTaint(start);
        {
            boolean var1055287EA357B1E539F33F3672FA88F7_1255782624 = (!Character.isSupplementaryCodePoint(c));
        } //End collapsed parenthetic
        char[] chars;
        chars = Character.toChars(c);
        String needle;
        needle = new String(0, chars.length, chars);
        int varB6048C8F2399670687E5E6BB049C087D_1551776460 = (lastIndexOf(needle, start));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (!Character.isSupplementaryCodePoint(c)) {
            //return -1;
        //}
        //char[] chars = Character.toChars(c);
        //String needle = new String(0, chars.length, chars);
        //return lastIndexOf(needle, start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.931 -0400", hash_original_method = "692347B4AF93950259A2DA740A39B258", hash_generated_method = "0DABDA21D5B381B6C9CC262B0587F902")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int lastIndexOf(String string) {
        dsTaint.addTaint(string);
        int var629483EEC7DE422E0B8E730771A3942E_1109593352 = (lastIndexOf(string, count));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return lastIndexOf(string, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.931 -0400", hash_original_method = "08D5FBAA11FAAE0244D1BD87258C05E0", hash_generated_method = "90D5B0A9EAA15C08FF66C421102BEE9E")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.931 -0400", hash_original_method = "026D3AE6EA7284BA85CF864429138595", hash_generated_method = "EA2D0EF13B6CFB6425C025AD54FEA223")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int length() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.931 -0400", hash_original_method = "8EA3BFAB97A4D4877FC2554FB493C6C0", hash_generated_method = "F87000FBFD198B065E6A2FCA64D6E813")
    @DSModeled(DSC.SAFE)
    public boolean regionMatches(int thisStart, String string, int start, int length) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(start);
        dsTaint.addTaint(thisStart);
        dsTaint.addTaint(string);
        dsTaint.addTaint(length);
        {
            throw new NullPointerException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.931 -0400", hash_original_method = "5098FC46543D7D1A735E08AA962F8003", hash_generated_method = "4F3BDDEEC15A6B8DE8349548A95B7576")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean regionMatches(boolean ignoreCase, int thisStart, String string, int start, int length) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(start);
        dsTaint.addTaint(thisStart);
        dsTaint.addTaint(string);
        dsTaint.addTaint(length);
        dsTaint.addTaint(ignoreCase);
        {
            boolean var6F73B44E0EF89A3667DD4B1125A02E25_519273083 = (regionMatches(thisStart, string, start, length));
        } //End block
        {
            throw new NullPointerException("string == null");
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
                boolean var43349C3464A5FA3039AFB5B028B91212_199921461 = (c1 != c2 && foldCase(c1) != foldCase(c2));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.932 -0400", hash_original_method = "52751D07523F52C15F0E15149B768BF7", hash_generated_method = "E13BAFFEDB932C12995FA24829FF1A82")
    @DSModeled(DSC.SAFE)
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
            idx++;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.932 -0400", hash_original_method = "226EAAC156D556D42E48670E64FEC4E8", hash_generated_method = "C051968E6EF0F4CC99F9C8EA85930327")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String replace(CharSequence target, CharSequence replacement) {
        dsTaint.addTaint(replacement);
        dsTaint.addTaint(target);
        {
            throw new NullPointerException("target == null");
        } //End block
        {
            throw new NullPointerException("replacement == null");
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
            String varEC2CAD6F4392C35EA2158E6C5520B613_26674812 = (result.toString());
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
            boolean varDF5B9E27CB5E1F6FE60A3DAF131B74C7_395456008 = ((matchStart = indexOf(targetString, searchStart)) != -1);
        } //End collapsed parenthetic
        result.append(value, offset + searchStart, count - searchStart);
        String varEA70154FDA28CC59402440C6317B57EF_391335883 = (result.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.932 -0400", hash_original_method = "8508513C5D9E5D7A42B020CFB91803A3", hash_generated_method = "E015E9A68DDFA676E8CD63887664F65F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean startsWith(String prefix) {
        dsTaint.addTaint(prefix);
        boolean varE400B78CFCF899225EE690557CD93052_1121067046 = (startsWith(prefix, 0));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return startsWith(prefix, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.932 -0400", hash_original_method = "DCA59D254EE64B3144EDF9B3ACB43A45", hash_generated_method = "3708183B3B091BEC6DCA24C5D8D6E699")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean startsWith(String prefix, int start) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(prefix);
        boolean varA8E1CDADA007E83510DD5CFA9EE42F80_843527538 = (regionMatches(start, prefix, 0, prefix.count));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return regionMatches(start, prefix, 0, prefix.count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.932 -0400", hash_original_method = "CB27750752A8934950488E0046CA5119", hash_generated_method = "03109593702E10E329940ED779D26CE1")
    @DSModeled(DSC.SAFE)
    public String substring(int start) {
        dsTaint.addTaint(start);
        throw indexAndLength(start);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.932 -0400", hash_original_method = "FA273138383309E9BFDA8AAE2A7C6025", hash_generated_method = "BE18F80E73EEEBC6469D481DFA2516C5")
    @DSModeled(DSC.SAFE)
    public String substring(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        throw startEndAndLength(start, end);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.932 -0400", hash_original_method = "66BAEF040BB5FDC80731F9B16CD33C32", hash_generated_method = "3B32AE62C87C7338537A3020E6CAE669")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.932 -0400", hash_original_method = "1FBB4BF6938E55C9E24FEC1EE0A95252", hash_generated_method = "CF6449FA0A9E9819D2AB1096E47C4B13")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toLowerCase() {
        String var64CBE5573E71B31BED13978E4C7005B5_580180012 = (CaseMapper.toLowerCase(Locale.getDefault(), this, value, offset, count));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return CaseMapper.toLowerCase(Locale.getDefault(), this, value, offset, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.933 -0400", hash_original_method = "3BCA227A64DF8F05552679E5E357BCF1", hash_generated_method = "C160454161F16D840ADCE0862A50D225")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toLowerCase(Locale locale) {
        dsTaint.addTaint(locale.dsTaint);
        String var4E2DBF3918E0615B14D675268D8A00AF_432941253 = (CaseMapper.toLowerCase(locale, this, value, offset, count));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return CaseMapper.toLowerCase(locale, this, value, offset, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.933 -0400", hash_original_method = "068E2EE4236B85776135405F1B66AD49", hash_generated_method = "EEA4BBBA6EC8172657C5383001E75DC8")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.933 -0400", hash_original_method = "8DEC33A26AFC2829CCCCE108ECEB9551", hash_generated_method = "E6B0D5271FE5637D588FBD38C9313E06")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toUpperCase() {
        String var8E9645C921F10C8A7448402D2B14568C_642317437 = (CaseMapper.toUpperCase(Locale.getDefault(), this, value, offset, count));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return CaseMapper.toUpperCase(Locale.getDefault(), this, value, offset, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.933 -0400", hash_original_method = "11C711663B7D81E6BD865533BF51B442", hash_generated_method = "A44B6EECBA9012D15DC40DF096FE172F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toUpperCase(Locale locale) {
        dsTaint.addTaint(locale.dsTaint);
        String var041A1D5CCEFA71908AFFB695A32DC09C_1435248456 = (CaseMapper.toUpperCase(locale, this, value, offset, count));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return CaseMapper.toUpperCase(locale, this, value, offset, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.933 -0400", hash_original_method = "5AB01C88F799E5B54FF71EE82B91E811", hash_generated_method = "2AD0122C33B3C9AD98A625D9808218D7")
    @DSModeled(DSC.SAFE)
    public String trim() {
        int start, last;
        start = offset;
        last = offset + count - 1;
        int end;
        end = last;
        {
            start++;
        } //End block
        {
            end--;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.933 -0400", hash_original_method = "2AD282CF508D37D852086ADCE714282E", hash_generated_method = "776F4278129F815F7D3D233435C9582D")
    public static String valueOf(char[] data) {
        return new String(data, 0, data.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.933 -0400", hash_original_method = "1671E7A24B213A5C550B79186B0002D8", hash_generated_method = "D8D832B7B9642A12311BA120932EEB0C")
    public static String valueOf(char[] data, int start, int length) {
        return new String(data, start, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.933 -0400", hash_original_method = "E7EDEB2BF9CD79B50B8CB74658BC8C20", hash_generated_method = "839E58FC55C9841E5D7E21929ABC3E81")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.933 -0400", hash_original_method = "4A643EE28A4F78CB638222A80F5F07F5", hash_generated_method = "C8C2AA6B7D7DE849B5B81FEC769496B0")
    public static String valueOf(double value) {
        return Double.toString(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.933 -0400", hash_original_method = "A7339CF0A1845E47429F861771033D8B", hash_generated_method = "CF7DB5FFCBA3D0CB08B7AE31583B8A92")
    public static String valueOf(float value) {
        return Float.toString(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.933 -0400", hash_original_method = "7472D0A01C250CDB4203128D331B50ED", hash_generated_method = "AE763BADC02EAD29BBA2436A031207CD")
    public static String valueOf(int value) {
        return Integer.toString(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.933 -0400", hash_original_method = "D1AF4635F236F26EDAA4AC997AD8C09A", hash_generated_method = "2288A665FEBE4EF35DE6B0C0BF9BCD7C")
    public static String valueOf(long value) {
        return Long.toString(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.933 -0400", hash_original_method = "29C79BCB300036CC1B9D463111BC50FD", hash_generated_method = "8DAED21ABAC747A4DC39D23D809B5F9B")
    public static String valueOf(Object value) {
        return value != null ? value.toString() : "null";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.933 -0400", hash_original_method = "B6848F35FD27983F085C8CD99AB771A5", hash_generated_method = "1CFE3D87A36EDF4565701FA2D6B59E4A")
    public static String valueOf(boolean value) {
        return value ? "true" : "false";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.933 -0400", hash_original_method = "233CB676C051D9EE76740A9343D1B467", hash_generated_method = "D7B86482B93614B59381147CC89C5D18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean contentEquals(StringBuffer strbuf) {
        dsTaint.addTaint(strbuf.dsTaint);
        {
            int size;
            size = strbuf.length();
            boolean var8AD291071900A808E3CDC7318D3290C1_1716858099 = (regionMatches(0, new String(0, size, strbuf.getValue()), 0,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.933 -0400", hash_original_method = "733340B51AD84F3351AE4177729AE631", hash_generated_method = "3E9A2F1DB58C48A4ED2EC031990FCE9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean contentEquals(CharSequence cs) {
        dsTaint.addTaint(cs);
        {
            throw new NullPointerException();
        } //End block
        int len;
        len = cs.length();
        boolean var4A8EFCED17558E2F34148C8126361B5F_752212354 = (regionMatches(0, cs.toString(), 0, len));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.933 -0400", hash_original_method = "54546B1154273B2EF815CC4641C4AF95", hash_generated_method = "A4E34081559DF7D0FE0E1FB9C81F1ABC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean matches(String regularExpression) {
        dsTaint.addTaint(regularExpression);
        boolean var1D596A9C37FF533C6DBD6EF8C6FD418B_1558021729 = (Pattern.matches(regularExpression, this));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return Pattern.matches(regularExpression, this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.933 -0400", hash_original_method = "85FB9291CC087326BB42DD27D5FF2770", hash_generated_method = "AC60CECC14A7226C9CFC333AABEE76BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String replaceAll(String regularExpression, String replacement) {
        dsTaint.addTaint(replacement);
        dsTaint.addTaint(regularExpression);
        String var8200163060C4FB23BBA099C591F629E3_680960328 = (Pattern.compile(regularExpression).matcher(this).replaceAll(replacement));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return Pattern.compile(regularExpression).matcher(this).replaceAll(replacement);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.934 -0400", hash_original_method = "B1F6469D7EA429A7B60DE2A4BC9D1B18", hash_generated_method = "DBC17CD10874CD69EF9A6DBE633B4DB0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String replaceFirst(String regularExpression, String replacement) {
        dsTaint.addTaint(replacement);
        dsTaint.addTaint(regularExpression);
        String varD3978D0F46F553C29AA67C6621F52FDE_226723875 = (Pattern.compile(regularExpression).matcher(this).replaceFirst(replacement));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return Pattern.compile(regularExpression).matcher(this).replaceFirst(replacement);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.934 -0400", hash_original_method = "0ADD043F2AA11242F9B6645F9D3630BF", hash_generated_method = "35A970122F2876C113CD48EEEA4377CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] split(String regularExpression) {
        dsTaint.addTaint(regularExpression);
        String[] var7535273CACCB815CB5E54901C6AF308A_518179258 = (split(regularExpression, 0));
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return split(regularExpression, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.934 -0400", hash_original_method = "4FB3AE192250E9EE292BE09F829C7FA4", hash_generated_method = "A8215474E99F35EBE440B74001FC3660")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] split(String regularExpression, int limit) {
        dsTaint.addTaint(limit);
        dsTaint.addTaint(regularExpression);
        String[] result;
        result = java.util.regex.Splitter.fastSplit(regularExpression, this, limit);
        {
            Object var1D4671BF407EE5474FA0D6122AEA04DD_1466214530 = (Pattern.compile(regularExpression).split(this, limit));
        } //End flattened ternary
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //String[] result = java.util.regex.Splitter.fastSplit(regularExpression, this, limit);
        //return result != null ? result : Pattern.compile(regularExpression).split(this, limit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.934 -0400", hash_original_method = "30B2B5AAE6BF00B7B5DE2415CD1C93C0", hash_generated_method = "0CF6B02BDAF89EC22F68DAD03C57C792")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence subSequence(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        CharSequence varC847D8C41835030B7BEFF7774EE43A1F_1961380091 = (substring(start, end));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return substring(start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.934 -0400", hash_original_method = "C7D49B0E887DD351A54FAD0BD917A973", hash_generated_method = "22A899B510A385B2DC60BD4271AA9905")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int codePointAt(int index) {
        dsTaint.addTaint(index);
        {
            throw indexAndLength(index);
        } //End block
        int var91459A9F7713DB06A5C91858CFACEC5A_219690131 = (Character.codePointAt(value, offset + index, offset + count));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (index < 0 || index >= count) {
            //throw indexAndLength(index);
        //}
        //return Character.codePointAt(value, offset + index, offset + count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.934 -0400", hash_original_method = "45488902F6B74F4C7EAF8C828C18FB65", hash_generated_method = "C732FA7D4D11DE1E70C4AF75CCA3834D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int codePointBefore(int index) {
        dsTaint.addTaint(index);
        {
            throw indexAndLength(index);
        } //End block
        int varF97594D4D0200951C1EDA2EC22454DCA_2059470139 = (Character.codePointBefore(value, offset + index, offset));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (index < 1 || index > count) {
            //throw indexAndLength(index);
        //}
        //return Character.codePointBefore(value, offset + index, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.934 -0400", hash_original_method = "B50CCA2DE0C54B693E25540AFEB12014", hash_generated_method = "3414F36C375F1581F2E8475BB64C74A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int codePointCount(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        {
            throw startEndAndLength(start, end);
        } //End block
        int varCDB29150FACB3F645BFF42DCED3004F1_1581196589 = (Character.codePointCount(value, offset + start, end - start));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (start < 0 || end > count || start > end) {
            //throw startEndAndLength(start, end);
        //}
        //return Character.codePointCount(value, offset + start, end - start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.934 -0400", hash_original_method = "994533EB4329C14FF0C3B68A297AD053", hash_generated_method = "7537B41088E60466882846CAE834B249")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean contains(CharSequence cs) {
        dsTaint.addTaint(cs);
        {
            throw new NullPointerException();
        } //End block
        boolean varBD86DE7AF63F37539131A6619268C3BC_692402363 = (indexOf(cs.toString()) >= 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (cs == null) {
            //throw new NullPointerException();
        //}
        //return indexOf(cs.toString()) >= 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.934 -0400", hash_original_method = "3AF353F7691F77FE6437135BD27DAE4A", hash_generated_method = "E7591C9873218A4FA9A7E6CB36B521B3")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.934 -0400", hash_original_method = "4C2FD221C22BC395CCF88A6A55BE98AD", hash_generated_method = "E5991F4FE9E9869A1E27A9D3B810AA76")
    public static String format(String format, Object... args) {
        return format(Locale.getDefault(), format, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.934 -0400", hash_original_method = "E957BA4807F1E0C30CA952954DA50144", hash_generated_method = "28E9802C1EC3687D9B95807B64B944A8")
    public static String format(Locale locale, String format, Object... args) {
        if (format == null) {
            throw new NullPointerException("null format argument");
        }
        int bufferSize = format.length() + (args == null ? 0 : args.length * 10);
        Formatter f = new Formatter(new StringBuilder(bufferSize), locale);
        return f.format(format, args).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.934 -0400", hash_original_method = "22B32FEEB55C55BB6E6C36B65473E566", hash_generated_method = "D7CB1AC8FEA0128C6B82B8491B1759C5")
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
        private static final long serialVersionUID = 8575799808933029326L;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.934 -0400", hash_original_method = "10AFFFE45F62C15CA0052EB0BB14A8D3", hash_generated_method = "15D660169E086C147CC4A0C3224FE378")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int compare(String o1, String o2) {
            dsTaint.addTaint(o2);
            dsTaint.addTaint(o1);
            int var85510175C4EBB5C1D8819E1DE2BF7041_1243219936 = (o1.compareToIgnoreCase(o2));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return o1.compareToIgnoreCase(o2);
        }

        
    }


    
    static {
        ASCII = new char[128];
        for (int i = 0; i < ASCII.length; ++i) {
            ASCII[i] = (char) i;
        }
    }
    
}


