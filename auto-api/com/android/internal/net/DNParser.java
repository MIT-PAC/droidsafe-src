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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:13.706 -0400", hash_original_field = "567C996739EDFA1CDBAD4C55A80580DF", hash_generated_field = "3D2CB8429158C4900E9EA4B3985C38C4")

    private String dn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:13.706 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "C7D2E1B1F4403418CA216FC250689056")

    private int length;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:13.706 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:13.706 -0400", hash_original_field = "63A08F52A29E0F7A1F987F4495164AB0", hash_generated_field = "281969654EB14E15446253F1D771C5B0")

    private int beg;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:13.706 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "BDD622074D0B9CD7867B17F38BB0017C")

    private int end;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:13.706 -0400", hash_original_field = "B5FDDF1EF601E74DB01C1425561A38CB", hash_generated_field = "574083FEFFA006A1773B42DB36035D30")

    private int cur;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:13.706 -0400", hash_original_field = "B69D9BC635CCD79AD2C64BC862ABE3B4", hash_generated_field = "8CFCF0E96717F68959883591D279E158")

    private char[] chars;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:13.715 -0400", hash_original_method = "3E2925D928731F8540EF17AB0FA8675E", hash_generated_method = "11360DB6ACF8FCF3E98B2CD56253A240")
    public  DNParser(X500Principal principal) {
        this.dn = principal.getName(X500Principal.RFC2253);
        this.length = dn.length();
        // ---------- Original Method ----------
        //this.dn = principal.getName(X500Principal.RFC2253);
        //this.length = dn.length();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:13.740 -0400", hash_original_method = "FF4BEB2C3B52F01ACB9FD25F4CE8A230", hash_generated_method = "242C4866B5087C03975592F3431210E8")
    private String nextAT() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_347993059 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1790455863 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_347993059 = null;
        } //End block
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
        varB4EAC82CA7396A68D541C85D26508E83_1790455863 = new String(chars, beg, end - beg);
        String varA7E53CE21691AB073D9660D615818899_1162689911; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1162689911 = varB4EAC82CA7396A68D541C85D26508E83_347993059;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1162689911 = varB4EAC82CA7396A68D541C85D26508E83_1790455863;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1162689911.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1162689911;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:13.742 -0400", hash_original_method = "6CE0A226336916B0D0BD29FA44800404", hash_generated_method = "B8AB7EDCFB0D308D4FE58D41CE03FBAC")
    private String quotedAV() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_1180788693 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1180788693 = new String(chars, beg, end - beg);
        varB4EAC82CA7396A68D541C85D26508E83_1180788693.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1180788693;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:13.747 -0400", hash_original_method = "F2971F3EEE8ADD1AC7CDED4BAC19B062", hash_generated_method = "3F0DB975E95F95D50C66BDB4A4FEB37D")
    private String hexAV() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_1444039297 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1444039297 = new String(chars, beg, hexLen);
        varB4EAC82CA7396A68D541C85D26508E83_1444039297.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1444039297;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:13.765 -0400", hash_original_method = "4DC639394A31828D7BD68247B83FBA07", hash_generated_method = "1860CBBBA8BBD9ADD051EC747F05156C")
    private String escapedAV() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_557957559 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1706547271 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1481730395 = null; //Variable for return #3
        beg = pos;
        end = pos;
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_557957559 = new String(chars, beg, end - beg);
            } //End block
            //Begin case '+' ',' ';' 
            varB4EAC82CA7396A68D541C85D26508E83_1706547271 = new String(chars, beg, end - beg);
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
                varB4EAC82CA7396A68D541C85D26508E83_1481730395 = new String(chars, beg, cur - beg);
            } //End block
            //End case ' ' 
            //Begin case default 
            chars[end++] = chars[pos];
            //End case default 
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1657150831; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1657150831 = varB4EAC82CA7396A68D541C85D26508E83_557957559;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1657150831 = varB4EAC82CA7396A68D541C85D26508E83_1706547271;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1657150831 = varB4EAC82CA7396A68D541C85D26508E83_1481730395;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1657150831.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1657150831;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:13.775 -0400", hash_original_method = "53196F6413879CFC1842AAE874B37E3B", hash_generated_method = "56F288B38E8F6C15A7BE46A75107875C")
    private char getEscaped() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException(ERROR_PARSE_ERROR);
        } //End block
        //Begin case default 
        char var6B59433B346D0CF4C614C82DD9B9249C_333127231 = (getUTF8());
        //End case default 
        char varA87DEB01C5F539E6BDA34829C8EF2368_2037597144 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_2037597144;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:13.780 -0400", hash_original_method = "1AF4B344FDDD447575D7BAE99B8C4CD1", hash_generated_method = "A270C95C8C341B9360E1EB3C249307B6")
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
        char varA87DEB01C5F539E6BDA34829C8EF2368_149553946 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_149553946;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:13.781 -0400", hash_original_method = "2374C761E42CEC3E752725D6A1CCC05C", hash_generated_method = "13F4235836A109BF74111688A22C41A0")
    private int getByte(int position) throws IOException {
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
        addTaint(position);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1263457440 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1263457440;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:13.796 -0400", hash_original_method = "35FC8516F494B2993CB4F015ABFC8107", hash_generated_method = "1C1D68520B86CC42997023D531F13AAC")
    public String find(String attributeType) {
        String varB4EAC82CA7396A68D541C85D26508E83_2020595309 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1403042229 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1132208276 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_522213300 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_1730426754 = null; //Variable for return #5
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
                varB4EAC82CA7396A68D541C85D26508E83_2020595309 = null;
            } //End block
            {
                String attValue;
                attValue = "";
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1403042229 = null;
                } //End block
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
                    boolean var44AEC70A73EE84F9DA3DC9B3F47DAE8A_246484688 = (attributeType.equalsIgnoreCase(attType));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1132208276 = attValue;
                    } //End block
                } //End collapsed parenthetic
                {
                    varB4EAC82CA7396A68D541C85D26508E83_522213300 = null;
                } //End block
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
        {
            varB4EAC82CA7396A68D541C85D26508E83_1730426754 = null;
        } //End block
        addTaint(attributeType.getTaint());
        String varA7E53CE21691AB073D9660D615818899_584846194; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_584846194 = varB4EAC82CA7396A68D541C85D26508E83_2020595309;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_584846194 = varB4EAC82CA7396A68D541C85D26508E83_1403042229;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_584846194 = varB4EAC82CA7396A68D541C85D26508E83_1132208276;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_584846194 = varB4EAC82CA7396A68D541C85D26508E83_522213300;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_584846194 = varB4EAC82CA7396A68D541C85D26508E83_1730426754;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_584846194.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_584846194;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:13.796 -0400", hash_original_field = "6DAE49A6EC00A4949FEB1C9846028845", hash_generated_field = "58FF1A439D47E6C41F63886B6C328B96")

    private static String TAG = "DNParser";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:13.796 -0400", hash_original_field = "88D1EAA420327EA474AE9B433B9E526C", hash_generated_field = "821FBA12893FDEC157499BA41725E870")

    private static String ERROR_PARSE_ERROR = "Failed to parse DN";
}

