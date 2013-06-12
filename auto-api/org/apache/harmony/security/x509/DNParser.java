package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private final char[] chars;
    private boolean hasQE;
    private byte[] encoded;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.899 -0400", hash_original_method = "66B2F9736FABC0973929FB105735B82E", hash_generated_method = "5604407784954915025BD8646B23A8AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DNParser(String dn) throws IOException {
        dsTaint.addTaint(dn);
        chars = dn.toCharArray();
        // ---------- Original Method ----------
        //chars = dn.toCharArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.900 -0400", hash_original_method = "7D5C37EF81BA8B102CA672C27E3E2647", hash_generated_method = "DED9E34C5B26C4B3CC6940805A5FE108")
    @DSModeled(DSC.SAFE)
    private String nextAT() throws IOException {
        hasQE = false;
        beg = pos;
        pos++;
        {
        	if (DroidSafeAndroidRuntime.control) throw new IOException("Invalid distinguished name string");
        } //End block
        end = pos;
        {
            {
            	if (DroidSafeAndroidRuntime.control) throw new IOException("Invalid distinguished name string");
            } //End block
        } //End block
        pos++;
        {
            beg += 4;
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.900 -0400", hash_original_method = "5F9B58135FF863A8E24F4B2AD9DF48BE", hash_generated_method = "020865713F1FCBFDB71DE019EB787ED9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String quotedAV() throws IOException {
        pos++;
        beg = pos;
        end = beg;
        {
            {
            	if (DroidSafeAndroidRuntime.control) throw new IOException("Invalid distinguished name string");
            } //End block
            {
                pos++;
            } //End block
            {
                chars[end] = getEscaped();
            } //End block
            {
                chars[end] = chars[pos];
            } //End block
            pos++;
            end++;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.900 -0400", hash_original_method = "59E635302CD6807B36C1A45A26BE591E", hash_generated_method = "1890AAD3131DC2C96E1A8A80DFC2E73B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String hexAV() throws IOException {
        {
        	if (DroidSafeAndroidRuntime.control) throw new IOException("Invalid distinguished name string");
        } //End block
        beg = pos;
        pos++;
        {
            {
                end = pos;
            } //End block
            {
                end = pos;
                pos++;
            } //End block
            {
                chars[pos] += 32;
            } //End block
            pos++;
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
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.900 -0400", hash_original_method = "FC33535E1A62E80F93C12FF4F8D2E290", hash_generated_method = "DAA99442A9FF688B31000B42F7A37344")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String escapedAV() throws IOException {
        beg = pos;
        end = pos;
        {
            //Begin case '\\' 
            chars[end++] = getEscaped();
            //End case '\\' 
            //Begin case '\\' 
            pos++;
            //End case '\\' 
            //Begin case ' ' 
            int cur;
            cur = end;
            //End case ' ' 
            //Begin case ' ' 
            pos++;
            //End case ' ' 
            //Begin case ' ' 
            chars[end++] = ' ';
            //End case ' ' 
            //Begin case ' ' 
            {
                chars[end++] = ' ';
            } //End block
            //End case ' ' 
            //Begin case default 
            chars[end++] = chars[pos];
            //End case default 
            //Begin case default 
            pos++;
            //End case default 
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.900 -0400", hash_original_method = "1A89A1602A29634CB35E16E135F5FE74", hash_generated_method = "DDC6E2724BD30E20677482CD7DC19177")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private char getEscaped() throws IOException {
        pos++;
        {
        	if (DroidSafeAndroidRuntime.control) throw new IOException("Invalid distinguished name string");
        } //End block
        char ch;
        ch = chars[pos];
        //Begin case '"' '\\' 
        hasQE = true;
        //End case '"' '\\' 
        //Begin case default 
        char var6B59433B346D0CF4C614C82DD9B9249C_772671684 = (getUTF8());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.901 -0400", hash_original_method = "12C3774F0261E7D12FCB54FD470B78E6", hash_generated_method = "ADFF6D9BF1F87AC359B1854B0BCB6067")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected char getUTF8() throws IOException {
        int res;
        res = getByte(pos);
        pos++;
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
                    pos++;
                    pos++;
                    b = getByte(pos);
                    pos++;
                    res = (res << 6) + (b & 0x3F);
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.901 -0400", hash_original_method = "C98D163E17FC33654783E302104D54C8", hash_generated_method = "7F6EC3B24FAB35885367AA650DCABD5A")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.901 -0400", hash_original_method = "17512CE00D4450F012CF195B2D29239B", hash_generated_method = "709E0F391E77DD189644237615F5FB1C")
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
            pos++;
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


