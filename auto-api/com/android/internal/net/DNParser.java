package com.android.internal.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Log;
import java.io.IOException;
import javax.security.auth.x500.X500Principal;

public final class DNParser {
    private String dn;
    private int length;
    private int pos, beg, end;
    private int cur;
    private char[] chars;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.145 -0400", hash_original_method = "3E2925D928731F8540EF17AB0FA8675E", hash_generated_method = "C6AE420095EB518BA367737D31CB9D9A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DNParser(X500Principal principal) {
        dsTaint.addTaint(principal.dsTaint);
        this.dn = principal.getName(X500Principal.RFC2253);
        this.length = dn.length();
        // ---------- Original Method ----------
        //this.dn = principal.getName(X500Principal.RFC2253);
        //this.length = dn.length();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.146 -0400", hash_original_method = "FF4BEB2C3B52F01ACB9FD25F4CE8A230", hash_generated_method = "0B649E855B5E439FD18FC0D9628B9DDE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String nextAT() throws IOException {
        beg = pos;
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException(ERROR_PARSE_ERROR);
        } //End block
        end = pos;
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException(ERROR_PARSE_ERROR);
            } //End block
        } //End block
        {
            beg += 4;
        } //End block
        String var0400BACEB4DCDFFFD96F8F041C31470F_1835767268 = (new String(chars, beg, end - beg));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.146 -0400", hash_original_method = "6CE0A226336916B0D0BD29FA44800404", hash_generated_method = "917C76E22DB693BA8B6BA33E7444C116")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String quotedAV() throws IOException {
        beg = pos;
        end = beg;
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException(ERROR_PARSE_ERROR);
            } //End block
            {
                chars[end] = getEscaped();
            } //End block
            {
                chars[end] = chars[pos];
            } //End block
        } //End block
        String var0400BACEB4DCDFFFD96F8F041C31470F_558327779 = (new String(chars, beg, end - beg));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //pos++;
        //beg = pos;
        //end = beg;
        //while (true) {
            //if (pos == length) {
                //throw new IOException(ERROR_PARSE_ERROR);
            //}
            //if (chars[pos] == '"') {
                //pos++;
                //break;
            //} else if (chars[pos] == '\\') {
                //chars[end] = getEscaped();
            //} else {
                //chars[end] = chars[pos];
            //}
            //pos++;
            //end++;
        //}
        //for (; pos < length && chars[pos] == ' '; pos++) {
        //}
        //return new String(chars, beg, end - beg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.147 -0400", hash_original_method = "F2971F3EEE8ADD1AC7CDED4BAC19B062", hash_generated_method = "21D94E09B21529A3B6D2BCB89453AE52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String hexAV() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException(ERROR_PARSE_ERROR);
        } //End block
        beg = pos;
        {
            {
                end = pos;
            } //End block
            {
                end = pos;
            } //End block
            {
                chars[pos] += 32;
            } //End block
        } //End block
        int hexLen;
        hexLen = end - beg;
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException(ERROR_PARSE_ERROR);
        } //End block
        byte[] encoded;
        encoded = new byte[hexLen / 2];
        {
            int i, p;
            i = 0;
            p = beg + 1;
            p += 2;
            {
                encoded[i] = (byte) getByte(p);
            } //End block
        } //End collapsed parenthetic
        String varA08C5BD6C809188234D1750FD7D77E28_700105377 = (new String(chars, beg, hexLen));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.147 -0400", hash_original_method = "4DC639394A31828D7BD68247B83FBA07", hash_generated_method = "28AC8CDE24335F7F8BEAF1A380A7A909")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String escapedAV() throws IOException {
        beg = pos;
        end = pos;
        {
            {
                String var927BED3135A2D08AB21C5F490FDEFB0D_665066057 = (new String(chars, beg, end - beg));
            } //End block
            //Begin case '+' ',' ';' 
            String var7065A5E5E676F697BD5B3879B32F2464_1512732381 = (new String(chars, beg, end - beg));
            //End case '+' ',' ';' 
            //Begin case '\\' 
            chars[end++] = getEscaped();
            //End case '\\' 
            //Begin case ' ' 
            cur = end;
            //End case ' ' 
            //Begin case ' ' 
            chars[end++] = ' ';
            //End case ' ' 
            //Begin case ' ' 
            {
                chars[end++] = ' ';
            } //End block
            //End case ' ' 
            //Begin case ' ' 
            {
                String var1F723E037F940D01AF13AC29E2DCF338_1556612529 = (new String(chars, beg, cur - beg));
            } //End block
            //End case ' ' 
            //Begin case default 
            chars[end++] = chars[pos];
            //End case default 
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.147 -0400", hash_original_method = "53196F6413879CFC1842AAE874B37E3B", hash_generated_method = "4B5DF2D7D7F4280EED7C0A69E1842949")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private char getEscaped() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException(ERROR_PARSE_ERROR);
        } //End block
        //Begin case default 
        char var6B59433B346D0CF4C614C82DD9B9249C_278862709 = (getUTF8());
        //End case default 
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //pos++;
        //if (pos == length) {
            //throw new IOException(ERROR_PARSE_ERROR);
        //}
        //switch (chars[pos]) {
        //case '"':
        //case '\\':
        //case ',':
        //case '=':
        //case '+':
        //case '<':
        //case '>':
        //case '#':
        //case ';':
        //case ' ':
        //case '*':
        //case '%':
        //case '_':
            //return chars[pos];
        //default:
            //return getUTF8();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.148 -0400", hash_original_method = "1AF4B344FDDD447575D7BAE99B8C4CD1", hash_generated_method = "99DC4A8387B0E064F219BB83735A28E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private char getUTF8() throws IOException {
        int res;
        res = getByte(pos);
        {
            int count;
            {
                count = 1;
                res = res & 0x1F;
            } //End block
            {
                count = 2;
                res = res & 0x0F;
            } //End block
            {
                count = 3;
                res = res & 0x07;
            } //End block
            int b;
            {
                int i;
                i = 0;
                {
                    b = getByte(pos);
                    res = (res << 6) + (b & 0x3F);
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.148 -0400", hash_original_method = "2374C761E42CEC3E752725D6A1CCC05C", hash_generated_method = "33BAD73EB63AD892DE88BFAAF27223C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getByte(int position) throws IOException {
        dsTaint.addTaint(position);
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException(ERROR_PARSE_ERROR);
        } //End block
        int b1, b2;
        b1 = chars[position];
        {
            b1 = b1 - '0';
        } //End block
        {
            b1 = b1 - 87;
        } //End block
        {
            b1 = b1 - 55;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException(ERROR_PARSE_ERROR);
        } //End block
        b2 = chars[position + 1];
        {
            b2 = b2 - '0';
        } //End block
        {
            b2 = b2 - 87;
        } //End block
        {
            b2 = b2 - 55;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException(ERROR_PARSE_ERROR);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if ((position + 1) >= length) {
            //throw new IOException(ERROR_PARSE_ERROR);
        //}
        //int b1, b2;
        //b1 = chars[position];
        //if (b1 >= '0' && b1 <= '9') {
            //b1 = b1 - '0';
        //} else if (b1 >= 'a' && b1 <= 'f') {
            //b1 = b1 - 87; 
        //} else if (b1 >= 'A' && b1 <= 'F') {
            //b1 = b1 - 55; 
        //} else {
            //throw new IOException(ERROR_PARSE_ERROR);
        //}
        //b2 = chars[position + 1];
        //if (b2 >= '0' && b2 <= '9') {
            //b2 = b2 - '0';
        //} else if (b2 >= 'a' && b2 <= 'f') {
            //b2 = b2 - 87; 
        //} else if (b2 >= 'A' && b2 <= 'F') {
            //b2 = b2 - 55; 
        //} else {
            //throw new IOException(ERROR_PARSE_ERROR);
        //}
        //return (b1 << 4) + b2;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.149 -0400", hash_original_method = "35FC8516F494B2993CB4F015ABFC8107", hash_generated_method = "5304FCED82321BBC8E548E9E281A9C21")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String find(String attributeType) {
        dsTaint.addTaint(attributeType);
        try 
        {
            pos = 0;
            beg = 0;
            end = 0;
            cur = 0;
            chars = dn.toCharArray();
            String attType;
            attType = nextAT();
            {
                String attValue;
                attValue = "";
                //Begin case '"' 
                attValue = quotedAV();
                //End case '"' 
                //Begin case '#' 
                attValue = hexAV();
                //End case '#' 
                //Begin case default 
                attValue = escapedAV();
                //End case default 
                {
                    boolean var44AEC70A73EE84F9DA3DC9B3F47DAE8A_1063522554 = (attributeType.equalsIgnoreCase(attType));
                } //End collapsed parenthetic
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException(ERROR_PARSE_ERROR);
                } //End block
                attType = nextAT();
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException(ERROR_PARSE_ERROR);
                } //End block
            } //End block
        } //End block
        catch (IOException e)
        { }
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static final String TAG = "DNParser";
    private static final String ERROR_PARSE_ERROR = "Failed to parse DN";
}

