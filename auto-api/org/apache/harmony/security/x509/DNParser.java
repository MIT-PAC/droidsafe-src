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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.749 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.749 -0400", hash_original_field = "63A08F52A29E0F7A1F987F4495164AB0", hash_generated_field = "281969654EB14E15446253F1D771C5B0")

    private int beg;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.749 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "BDD622074D0B9CD7867B17F38BB0017C")

    private int end;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.749 -0400", hash_original_field = "B69D9BC635CCD79AD2C64BC862ABE3B4", hash_generated_field = "8CFCF0E96717F68959883591D279E158")

    private char[] chars;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.749 -0400", hash_original_field = "EC32FC5A9FC36F29B6B89F4826B648EF", hash_generated_field = "790BB9C226E70D863513D01FB9E5249C")

    private boolean hasQE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.749 -0400", hash_original_field = "4B719ACEE4A1D5E30577F59E80D06205", hash_generated_field = "ED95B2E967E3B561D98D41FC80663441")

    private byte[] encoded;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.756 -0400", hash_original_method = "66B2F9736FABC0973929FB105735B82E", hash_generated_method = "5286CFA825BD8D2CE0A88F3464588C97")
    public  DNParser(String dn) throws IOException {
        chars = dn.toCharArray();
        // ---------- Original Method ----------
        //chars = dn.toCharArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.757 -0400", hash_original_method = "7D5C37EF81BA8B102CA672C27E3E2647", hash_generated_method = "97E0B45D3A0D19130A11194EF02C07C9")
    private String nextAT() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_962882496 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1263320984 = null; //Variable for return #2
        hasQE = false;
        {
            varB4EAC82CA7396A68D541C85D26508E83_962882496 = null;
        } //End block
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
        varB4EAC82CA7396A68D541C85D26508E83_1263320984 = new String(chars, beg, end - beg);
        String varA7E53CE21691AB073D9660D615818899_1633816644; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1633816644 = varB4EAC82CA7396A68D541C85D26508E83_962882496;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1633816644 = varB4EAC82CA7396A68D541C85D26508E83_1263320984;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1633816644.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1633816644;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.758 -0400", hash_original_method = "5F9B58135FF863A8E24F4B2AD9DF48BE", hash_generated_method = "F77A05A8C5127CA95413054D7373148E")
    private String quotedAV() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_609998704 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_609998704 = new String(chars, beg, end - beg);
        varB4EAC82CA7396A68D541C85D26508E83_609998704.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_609998704;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.770 -0400", hash_original_method = "59E635302CD6807B36C1A45A26BE591E", hash_generated_method = "2A29F1E62110960912505ADEDE521515")
    private String hexAV() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_1017742109 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1017742109 = new String(chars, beg, hexLen);
        varB4EAC82CA7396A68D541C85D26508E83_1017742109.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1017742109;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.771 -0400", hash_original_method = "FC33535E1A62E80F93C12FF4F8D2E290", hash_generated_method = "2DCAF8E7C323177C567E51EAA5110B74")
    private String escapedAV() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_1405262067 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_110426524 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_947510509 = null; //Variable for return #3
        beg = pos;
        end = pos;
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_1405262067 = new String(chars, beg, end - beg);
            } //End block
            //Begin case '+' ',' ';' 
            varB4EAC82CA7396A68D541C85D26508E83_110426524 = new String(chars, beg, end - beg);
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
                varB4EAC82CA7396A68D541C85D26508E83_947510509 = new String(chars, beg, cur - beg);
            } //End block
            //End case ' ' 
            //Begin case default 
            chars[end++] = chars[pos];
            //End case default 
        } //End block
        String varA7E53CE21691AB073D9660D615818899_795948678; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_795948678 = varB4EAC82CA7396A68D541C85D26508E83_1405262067;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_795948678 = varB4EAC82CA7396A68D541C85D26508E83_110426524;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_795948678 = varB4EAC82CA7396A68D541C85D26508E83_947510509;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_795948678.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_795948678;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.779 -0400", hash_original_method = "1A89A1602A29634CB35E16E135F5FE74", hash_generated_method = "441D0E7106DC4975A0C474720EF87436")
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
        char var6B59433B346D0CF4C614C82DD9B9249C_907459916 = (getUTF8());
        //End case default 
        char varA87DEB01C5F539E6BDA34829C8EF2368_1089052570 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1089052570;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.781 -0400", hash_original_method = "12C3774F0261E7D12FCB54FD470B78E6", hash_generated_method = "61D3E9A86A79119507D1E5871F5BBC1B")
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
        char varA87DEB01C5F539E6BDA34829C8EF2368_897172652 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_897172652;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.790 -0400", hash_original_method = "C98D163E17FC33654783E302104D54C8", hash_generated_method = "C5472CBEF37BB6D621158480B9E73711")
    private int getByte(int position) throws IOException {
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
        addTaint(position);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2130105316 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2130105316;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.792 -0400", hash_original_method = "17512CE00D4450F012CF195B2D29239B", hash_generated_method = "5C77AA2417376F29ADB37AE08E400E8E")
    public List<List<AttributeTypeAndValue>> parse() throws IOException {
        List<List<AttributeTypeAndValue>> varB4EAC82CA7396A68D541C85D26508E83_1758899069 = null; //Variable for return #1
        List<List<AttributeTypeAndValue>> varB4EAC82CA7396A68D541C85D26508E83_1933088578 = null; //Variable for return #2
        List<List<AttributeTypeAndValue>> varB4EAC82CA7396A68D541C85D26508E83_1469637736 = null; //Variable for return #3
        List<List<AttributeTypeAndValue>> list;
        list = new ArrayList<List<AttributeTypeAndValue>>();
        String attType;
        attType = nextAT();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1758899069 = list;
        } //End block
        List<AttributeTypeAndValue> atav;
        atav = new ArrayList<AttributeTypeAndValue>();
        {
            {
                atav.add(new AttributeTypeAndValue(attType, new AttributeValue("", false)));
                list.add(0, atav);
                varB4EAC82CA7396A68D541C85D26508E83_1933088578 = list;
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
                varB4EAC82CA7396A68D541C85D26508E83_1469637736 = list;
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
        List<List<AttributeTypeAndValue>> varA7E53CE21691AB073D9660D615818899_1476182410; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1476182410 = varB4EAC82CA7396A68D541C85D26508E83_1758899069;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1476182410 = varB4EAC82CA7396A68D541C85D26508E83_1933088578;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1476182410 = varB4EAC82CA7396A68D541C85D26508E83_1469637736;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1476182410.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1476182410;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

