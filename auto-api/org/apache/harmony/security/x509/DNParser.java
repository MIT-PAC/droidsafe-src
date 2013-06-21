package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.harmony.security.x501.AttributeTypeAndValue;
import org.apache.harmony.security.x501.AttributeValue;

public final class DNParser {
    private int pos;
    private int beg;
    private int end;
    private char[] chars;
    private boolean hasQE;
    private byte[] encoded;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.628 -0400", hash_original_method = "66B2F9736FABC0973929FB105735B82E", hash_generated_method = "D72965F3E1866D4691B6137D1BAADAE1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DNParser(String dn) throws IOException {
        dsTaint.addTaint(dn);
        chars = dn.toCharArray();
        // ---------- Original Method ----------
        //chars = dn.toCharArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.628 -0400", hash_original_method = "7D5C37EF81BA8B102CA672C27E3E2647", hash_generated_method = "61390AC96D9F001545C2991AD3CAD460")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String nextAT() throws IOException {
        hasQE = false;
        beg = pos;
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Invalid distinguished name string");
        } //End block
        end = pos;
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Invalid distinguished name string");
            } //End block
        } //End block
        {
            beg += 4;
        } //End block
        String var0400BACEB4DCDFFFD96F8F041C31470F_1942925288 = (new String(chars, beg, end - beg));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.629 -0400", hash_original_method = "5F9B58135FF863A8E24F4B2AD9DF48BE", hash_generated_method = "BB40DAA32E676EFDCE3750B7AFC13319")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String quotedAV() throws IOException {
        beg = pos;
        end = beg;
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Invalid distinguished name string");
            } //End block
            {
                chars[end] = getEscaped();
            } //End block
            {
                chars[end] = chars[pos];
            } //End block
        } //End block
        String var0400BACEB4DCDFFFD96F8F041C31470F_1504586525 = (new String(chars, beg, end - beg));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //pos++;
        //beg = pos;
        //end = beg;
        //while (true) {
            //if (pos == chars.length) {
                //throw new IOException("Invalid distinguished name string");
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
        //for (; pos < chars.length && chars[pos] == ' '; pos++) {
        //}
        //return new String(chars, beg, end - beg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.629 -0400", hash_original_method = "59E635302CD6807B36C1A45A26BE591E", hash_generated_method = "B2A562B2FDE3F7F6AF34D1177B4E9F6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String hexAV() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Invalid distinguished name string");
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
            if (DroidSafeAndroidRuntime.control) throw new IOException("Invalid distinguished name string");
        } //End block
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
        String varA08C5BD6C809188234D1750FD7D77E28_2000585613 = (new String(chars, beg, hexLen));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.630 -0400", hash_original_method = "FC33535E1A62E80F93C12FF4F8D2E290", hash_generated_method = "4990178C0652359F6779EAE47497BE92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String escapedAV() throws IOException {
        beg = pos;
        end = pos;
        {
            {
                String var927BED3135A2D08AB21C5F490FDEFB0D_67755181 = (new String(chars, beg, end - beg));
            } //End block
            //Begin case '+' ',' ';' 
            String var7065A5E5E676F697BD5B3879B32F2464_904089710 = (new String(chars, beg, end - beg));
            //End case '+' ',' ';' 
            //Begin case '\\' 
            chars[end++] = getEscaped();
            //End case '\\' 
            //Begin case ' ' 
            int cur;
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
                String var1F723E037F940D01AF13AC29E2DCF338_1641873354 = (new String(chars, beg, cur - beg));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.630 -0400", hash_original_method = "1A89A1602A29634CB35E16E135F5FE74", hash_generated_method = "BF3F704EF63081C82F527E4A6230BEFD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private char getEscaped() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Invalid distinguished name string");
        } //End block
        char ch;
        ch = chars[pos];
        //Begin case '"' '\\' 
        hasQE = true;
        //End case '"' '\\' 
        //Begin case default 
        char var6B59433B346D0CF4C614C82DD9B9249C_465009020 = (getUTF8());
        //End case default 
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //pos++;
        //if (pos == chars.length) {
            //throw new IOException("Invalid distinguished name string");
        //}
        //char ch = chars[pos];
        //switch (ch) {
        //case '"':
        //case '\\':
            //hasQE = true;
            //return ch;
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
            //return ch;
        //default:
            //return getUTF8();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.631 -0400", hash_original_method = "12C3774F0261E7D12FCB54FD470B78E6", hash_generated_method = "5DE6F5C5C9A38968BF55709E3581AD93")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected char getUTF8() throws IOException {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.631 -0400", hash_original_method = "C98D163E17FC33654783E302104D54C8", hash_generated_method = "37C9B591A77337C435BB0AE7594189FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getByte(int position) throws IOException {
        dsTaint.addTaint(position);
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Invalid distinguished name string");
        } //End block
        int b1;
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
            if (DroidSafeAndroidRuntime.control) throw new IOException("Invalid distinguished name string");
        } //End block
        int b2;
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
            if (DroidSafeAndroidRuntime.control) throw new IOException("Invalid distinguished name string");
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.632 -0400", hash_original_method = "17512CE00D4450F012CF195B2D29239B", hash_generated_method = "965B054AD1DB95315E25AE286213BF80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<List<AttributeTypeAndValue>> parse() throws IOException {
        List<List<AttributeTypeAndValue>> list;
        list = new ArrayList<List<AttributeTypeAndValue>>();
        String attType;
        attType = nextAT();
        List<AttributeTypeAndValue> atav;
        atav = new ArrayList<AttributeTypeAndValue>();
        {
            {
                atav.add(new AttributeTypeAndValue(attType, new AttributeValue("", false)));
                list.add(0, atav);
            } //End block
            //Begin case '"' 
            atav.add(new AttributeTypeAndValue(attType, new AttributeValue(quotedAV(), hasQE)));
            //End case '"' 
            //Begin case '#' 
            atav.add(new AttributeTypeAndValue(attType, new AttributeValue(hexAV(), encoded)));
            //End case '#' 
            //Begin case '+' ',' ';' 
            atav.add(new AttributeTypeAndValue(attType, new AttributeValue("", false)));
            //End case '+' ',' ';' 
            //Begin case default 
            atav.add(new AttributeTypeAndValue(attType, new AttributeValue(
                        escapedAV(), hasQE)));
            //End case default 
            {
                list.add(0, atav);
            } //End block
            {
                list.add(0, atav);
                atav = new ArrayList<AttributeTypeAndValue>();
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Invalid distinguished name string");
            } //End block
            attType = nextAT();
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Invalid distinguished name string");
            } //End block
        } //End block
        return (List<List<AttributeTypeAndValue>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

