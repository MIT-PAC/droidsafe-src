package com.android.internal.net;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;

import javax.security.auth.x500.X500Principal;



public final class DNParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.322 -0400", hash_original_field = "567C996739EDFA1CDBAD4C55A80580DF", hash_generated_field = "3D2CB8429158C4900E9EA4B3985C38C4")

    private String dn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.322 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "C7D2E1B1F4403418CA216FC250689056")

    private int length;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.322 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.322 -0400", hash_original_field = "63A08F52A29E0F7A1F987F4495164AB0", hash_generated_field = "281969654EB14E15446253F1D771C5B0")

    private int beg;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.322 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "BDD622074D0B9CD7867B17F38BB0017C")

    private int end;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.322 -0400", hash_original_field = "B5FDDF1EF601E74DB01C1425561A38CB", hash_generated_field = "574083FEFFA006A1773B42DB36035D30")

    private int cur;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.322 -0400", hash_original_field = "B69D9BC635CCD79AD2C64BC862ABE3B4", hash_generated_field = "8CFCF0E96717F68959883591D279E158")

    private char[] chars;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.322 -0400", hash_original_method = "3E2925D928731F8540EF17AB0FA8675E", hash_generated_method = "11360DB6ACF8FCF3E98B2CD56253A240")
    public  DNParser(X500Principal principal) {
        this.dn = principal.getName(X500Principal.RFC2253);
        this.length = dn.length();
        // ---------- Original Method ----------
        //this.dn = principal.getName(X500Principal.RFC2253);
        //this.length = dn.length();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.323 -0400", hash_original_method = "FF4BEB2C3B52F01ACB9FD25F4CE8A230", hash_generated_method = "F3EBC385B48599B08CDCB7EF93136A83")
    private String nextAT() throws IOException {
for(;pos < length && chars[pos] == ' ';pos++)
        {
        } //End block
        if(pos == length)        
        {
String var540C13E9E156B687226421B24F2DF178_1939972726 =             null;
            var540C13E9E156B687226421B24F2DF178_1939972726.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1939972726;
        } //End block
        beg = pos;
        pos++;
for(;pos < length && chars[pos] != '=' && chars[pos] != ' ';pos++)
        {
        } //End block
        if(pos >= length)        
        {
            IOException var3C5391EA77D4408E3684E0C5A2602AD4_1259103412 = new IOException(ERROR_PARSE_ERROR);
            var3C5391EA77D4408E3684E0C5A2602AD4_1259103412.addTaint(taint);
            throw var3C5391EA77D4408E3684E0C5A2602AD4_1259103412;
        } //End block
        end = pos;
        if(chars[pos] == ' ')        
        {
for(;pos < length && chars[pos] != '=' && chars[pos] == ' ';pos++)
            {
            } //End block
            if(chars[pos] != '=' || pos == length)            
            {
                IOException var3C5391EA77D4408E3684E0C5A2602AD4_1321790648 = new IOException(ERROR_PARSE_ERROR);
                var3C5391EA77D4408E3684E0C5A2602AD4_1321790648.addTaint(taint);
                throw var3C5391EA77D4408E3684E0C5A2602AD4_1321790648;
            } //End block
        } //End block
        pos++;
for(;pos < length && chars[pos] == ' ';pos++)
        {
        } //End block
        if((end - beg > 4) && (chars[beg + 3] == '.')
                && (chars[beg] == 'O' || chars[beg] == 'o')
                && (chars[beg + 1] == 'I' || chars[beg + 1] == 'i')
                && (chars[beg + 2] == 'D' || chars[beg + 2] == 'd'))        
        {
            beg += 4;
        } //End block
String varA88CD4E826BB74E12B252BCF2CEC4945_614648331 =         new String(chars, beg, end - beg);
        varA88CD4E826BB74E12B252BCF2CEC4945_614648331.addTaint(taint);
        return varA88CD4E826BB74E12B252BCF2CEC4945_614648331;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.325 -0400", hash_original_method = "6CE0A226336916B0D0BD29FA44800404", hash_generated_method = "9E7CE86C5A0AA00709051B3A0C5348A6")
    private String quotedAV() throws IOException {
        pos++;
        beg = pos;
        end = beg;
        while
(true)        
        {
            if(pos == length)            
            {
                IOException var3C5391EA77D4408E3684E0C5A2602AD4_25000182 = new IOException(ERROR_PARSE_ERROR);
                var3C5391EA77D4408E3684E0C5A2602AD4_25000182.addTaint(taint);
                throw var3C5391EA77D4408E3684E0C5A2602AD4_25000182;
            } //End block
            if(chars[pos] == '"')            
            {
                pos++;
                break;
            } //End block
            else
            if(chars[pos] == '\\')            
            {
                chars[end] = getEscaped();
            } //End block
            else
            {
                chars[end] = chars[pos];
            } //End block
            pos++;
            end++;
        } //End block
for(;pos < length && chars[pos] == ' ';pos++)
        {
        } //End block
String varA88CD4E826BB74E12B252BCF2CEC4945_926636910 =         new String(chars, beg, end - beg);
        varA88CD4E826BB74E12B252BCF2CEC4945_926636910.addTaint(taint);
        return varA88CD4E826BB74E12B252BCF2CEC4945_926636910;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.328 -0400", hash_original_method = "F2971F3EEE8ADD1AC7CDED4BAC19B062", hash_generated_method = "160F595A50FD8061C60965D385BD15BD")
    private String hexAV() throws IOException {
        if(pos + 4 >= length)        
        {
            IOException var3C5391EA77D4408E3684E0C5A2602AD4_780827597 = new IOException(ERROR_PARSE_ERROR);
            var3C5391EA77D4408E3684E0C5A2602AD4_780827597.addTaint(taint);
            throw var3C5391EA77D4408E3684E0C5A2602AD4_780827597;
        } //End block
        beg = pos;
        pos++;
        while
(true)        
        {
            if(pos == length || chars[pos] == '+' || chars[pos] == ','
                    || chars[pos] == ';')            
            {
                end = pos;
                break;
            } //End block
            if(chars[pos] == ' ')            
            {
                end = pos;
                pos++;
for(;pos < length && chars[pos] == ' ';pos++)
                {
                } //End block
                break;
            } //End block
            else
            if(chars[pos] >= 'A' && chars[pos] <= 'F')            
            {
                chars[pos] += 32;
            } //End block
            pos++;
        } //End block
        int hexLen = end - beg;
        if(hexLen < 5 || (hexLen & 1) == 0)        
        {
            IOException var3C5391EA77D4408E3684E0C5A2602AD4_1984918506 = new IOException(ERROR_PARSE_ERROR);
            var3C5391EA77D4408E3684E0C5A2602AD4_1984918506.addTaint(taint);
            throw var3C5391EA77D4408E3684E0C5A2602AD4_1984918506;
        } //End block
        byte[] encoded = new byte[hexLen / 2];
for(int i = 0, p = beg + 1;i < encoded.length;p += 2,i++)
        {
            encoded[i] = (byte) getByte(p);
        } //End block
String varCC1247AAA5590D16A647B2E2A6BA7DE8_2049899936 =         new String(chars, beg, hexLen);
        varCC1247AAA5590D16A647B2E2A6BA7DE8_2049899936.addTaint(taint);
        return varCC1247AAA5590D16A647B2E2A6BA7DE8_2049899936;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.329 -0400", hash_original_method = "4DC639394A31828D7BD68247B83FBA07", hash_generated_method = "BD964D364D878C20E0656291530D6632")
    private String escapedAV() throws IOException {
        beg = pos;
        end = pos;
        while
(true)        
        {
            if(pos >= length)            
            {
String varA88CD4E826BB74E12B252BCF2CEC4945_1423485660 =                 new String(chars, beg, end - beg);
                varA88CD4E826BB74E12B252BCF2CEC4945_1423485660.addTaint(taint);
                return varA88CD4E826BB74E12B252BCF2CEC4945_1423485660;
            } //End block
switch(chars[pos]){
            case '+':
            case ',':
            case ';':
String varA88CD4E826BB74E12B252BCF2CEC4945_330149234 =             new String(chars, beg, end - beg);
            varA88CD4E826BB74E12B252BCF2CEC4945_330149234.addTaint(taint);
            return varA88CD4E826BB74E12B252BCF2CEC4945_330149234;
            case '\\':
            chars[end++] = getEscaped();
            pos++;
            break;
            case ' ':
            cur = end;
            pos++;
            chars[end++] = ' ';
for(;pos < length && chars[pos] == ' ';pos++)
            {
                chars[end++] = ' ';
            } //End block
            if(pos == length || chars[pos] == ',' || chars[pos] == '+'
                        || chars[pos] == ';')            
            {
String varF4AE4525652FA624971421628D52D24A_1196079737 =                 new String(chars, beg, cur - beg);
                varF4AE4525652FA624971421628D52D24A_1196079737.addTaint(taint);
                return varF4AE4525652FA624971421628D52D24A_1196079737;
            } //End block
            break;
            default:
            chars[end++] = chars[pos];
            pos++;
}
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.330 -0400", hash_original_method = "53196F6413879CFC1842AAE874B37E3B", hash_generated_method = "630A0AECE49A022CD3949C5608C33A55")
    private char getEscaped() throws IOException {
        pos++;
        if(pos == length)        
        {
            IOException var3C5391EA77D4408E3684E0C5A2602AD4_712038411 = new IOException(ERROR_PARSE_ERROR);
            var3C5391EA77D4408E3684E0C5A2602AD4_712038411.addTaint(taint);
            throw var3C5391EA77D4408E3684E0C5A2602AD4_712038411;
        } //End block
switch(chars[pos]){
        case '"':
        case '\\':
        case ',':
        case '=':
        case '+':
        case '<':
        case '>':
        case '#':
        case ';':
        case ' ':
        case '*':
        case '%':
        case '_':
        char var8BA167260B3B4A0A1E5DDCB657F950D1_1525531968 = (chars[pos]);
                char varA87DEB01C5F539E6BDA34829C8EF2368_1825735886 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1825735886;
        default:
        char var2E5C957BB5E9D2FF9D2B4FF469959575_1339228788 = (getUTF8());
                char varA87DEB01C5F539E6BDA34829C8EF2368_172871040 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_172871040;
}
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.332 -0400", hash_original_method = "1AF4B344FDDD447575D7BAE99B8C4CD1", hash_generated_method = "707D02B7DED8252617A20964E54F4936")
    private char getUTF8() throws IOException {
        int res = getByte(pos);
        pos++;
        if(res < 128)        
        {
            char var7C6A3B9F9EDA80A67C698BA55955EB3A_1197111684 = ((char) res);
                        char varA87DEB01C5F539E6BDA34829C8EF2368_138904186 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_138904186;
        } //End block
        else
        if(res >= 192 && res <= 247)        
        {
            int count;
            if(res <= 223)            
            {
                count = 1;
                res = res & 0x1F;
            } //End block
            else
            if(res <= 239)            
            {
                count = 2;
                res = res & 0x0F;
            } //End block
            else
            {
                count = 3;
                res = res & 0x07;
            } //End block
            int b;
for(int i = 0;i < count;i++)
            {
                pos++;
                if(pos == length || chars[pos] != '\\')                
                {
                    char var422322C3A3E199EB41D9E4FF6219421D_285427424 = (0x3F);
                                        char varA87DEB01C5F539E6BDA34829C8EF2368_1502500156 = getTaintChar();
                    return varA87DEB01C5F539E6BDA34829C8EF2368_1502500156;
                } //End block
                pos++;
                b = getByte(pos);
                pos++;
                if((b & 0xC0) != 0x80)                
                {
                    char var422322C3A3E199EB41D9E4FF6219421D_1304937524 = (0x3F);
                                        char varA87DEB01C5F539E6BDA34829C8EF2368_879856748 = getTaintChar();
                    return varA87DEB01C5F539E6BDA34829C8EF2368_879856748;
                } //End block
                res = (res << 6) + (b & 0x3F);
            } //End block
            char var7C6A3B9F9EDA80A67C698BA55955EB3A_1838650226 = ((char) res);
                        char varA87DEB01C5F539E6BDA34829C8EF2368_856047771 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_856047771;
        } //End block
        else
        {
            char var422322C3A3E199EB41D9E4FF6219421D_1199911825 = (0x3F);
                        char varA87DEB01C5F539E6BDA34829C8EF2368_209384682 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_209384682;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.335 -0400", hash_original_method = "2374C761E42CEC3E752725D6A1CCC05C", hash_generated_method = "17BE8BB590AEBC9E18257D6E3E8C0E3C")
    private int getByte(int position) throws IOException {
        addTaint(position);
        if((position + 1) >= length)        
        {
            IOException var3C5391EA77D4408E3684E0C5A2602AD4_200563680 = new IOException(ERROR_PARSE_ERROR);
            var3C5391EA77D4408E3684E0C5A2602AD4_200563680.addTaint(taint);
            throw var3C5391EA77D4408E3684E0C5A2602AD4_200563680;
        } //End block
        int b1;
        int b2;
        b1 = chars[position];
        if(b1 >= '0' && b1 <= '9')        
        {
            b1 = b1 - '0';
        } //End block
        else
        if(b1 >= 'a' && b1 <= 'f')        
        {
            b1 = b1 - 87;
        } //End block
        else
        if(b1 >= 'A' && b1 <= 'F')        
        {
            b1 = b1 - 55;
        } //End block
        else
        {
            IOException var3C5391EA77D4408E3684E0C5A2602AD4_967042490 = new IOException(ERROR_PARSE_ERROR);
            var3C5391EA77D4408E3684E0C5A2602AD4_967042490.addTaint(taint);
            throw var3C5391EA77D4408E3684E0C5A2602AD4_967042490;
        } //End block
        b2 = chars[position + 1];
        if(b2 >= '0' && b2 <= '9')        
        {
            b2 = b2 - '0';
        } //End block
        else
        if(b2 >= 'a' && b2 <= 'f')        
        {
            b2 = b2 - 87;
        } //End block
        else
        if(b2 >= 'A' && b2 <= 'F')        
        {
            b2 = b2 - 55;
        } //End block
        else
        {
            IOException var3C5391EA77D4408E3684E0C5A2602AD4_2110590604 = new IOException(ERROR_PARSE_ERROR);
            var3C5391EA77D4408E3684E0C5A2602AD4_2110590604.addTaint(taint);
            throw var3C5391EA77D4408E3684E0C5A2602AD4_2110590604;
        } //End block
        int var91352548C1A77C8ADCB3277772A6897D_1360640776 = ((b1 << 4) + b2);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1334852940 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1334852940;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.339 -0400", hash_original_method = "35FC8516F494B2993CB4F015ABFC8107", hash_generated_method = "20C03CE3477E2DD2EA51E082349B263B")
    public String find(String attributeType) {
        addTaint(attributeType.getTaint());
        try 
        {
            pos = 0;
            beg = 0;
            end = 0;
            cur = 0;
            chars = dn.toCharArray();
            String attType = nextAT();
            if(attType == null)            
            {
String var540C13E9E156B687226421B24F2DF178_1908732459 =                 null;
                var540C13E9E156B687226421B24F2DF178_1908732459.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1908732459;
            } //End block
            while
(true)            
            {
                String attValue = "";
                if(pos == length)                
                {
String var540C13E9E156B687226421B24F2DF178_2004545815 =                     null;
                    var540C13E9E156B687226421B24F2DF178_2004545815.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_2004545815;
                } //End block
switch(chars[pos]){
                case '"':
                attValue = quotedAV();
                break;
                case '#':
                attValue = hexAV();
                break;
                case '+':
                case ',':
                case ';':
                break;
                default:
                attValue = escapedAV();
}                if(attributeType.equalsIgnoreCase(attType))                
                {
String var808198ACDCDD83074E5A5E92A96CF11C_1353245415 =                     attValue;
                    var808198ACDCDD83074E5A5E92A96CF11C_1353245415.addTaint(taint);
                    return var808198ACDCDD83074E5A5E92A96CF11C_1353245415;
                } //End block
                if(pos >= length)                
                {
String var540C13E9E156B687226421B24F2DF178_1590055071 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1590055071.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1590055071;
                } //End block
                if(chars[pos] == ',' || chars[pos] == ';')                
                {
                } //End block
                else
                if(chars[pos] != '+')                
                {
                    IOException var3C5391EA77D4408E3684E0C5A2602AD4_584676604 = new IOException(ERROR_PARSE_ERROR);
                    var3C5391EA77D4408E3684E0C5A2602AD4_584676604.addTaint(taint);
                    throw var3C5391EA77D4408E3684E0C5A2602AD4_584676604;
                } //End block
                pos++;
                attType = nextAT();
                if(attType == null)                
                {
                    IOException var3C5391EA77D4408E3684E0C5A2602AD4_1931111815 = new IOException(ERROR_PARSE_ERROR);
                    var3C5391EA77D4408E3684E0C5A2602AD4_1931111815.addTaint(taint);
                    throw var3C5391EA77D4408E3684E0C5A2602AD4_1931111815;
                } //End block
            } //End block
        } //End block
        catch (IOException e)
        {
String var540C13E9E156B687226421B24F2DF178_751759823 =             null;
            var540C13E9E156B687226421B24F2DF178_751759823.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_751759823;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.340 -0400", hash_original_field = "6DAE49A6EC00A4949FEB1C9846028845", hash_generated_field = "8755658AF290FD110892EDFB73434ADB")

    private static final String TAG = "DNParser";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.340 -0400", hash_original_field = "88D1EAA420327EA474AE9B433B9E526C", hash_generated_field = "F6565CB51CDFFE700B2DBF94ED832F63")

    private static final String ERROR_PARSE_ERROR = "Failed to parse DN";
}

