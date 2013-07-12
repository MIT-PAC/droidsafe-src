package com.android.internal.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.Log;
import java.io.IOException;
import javax.security.auth.x500.X500Principal;

public final class DNParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.746 -0400", hash_original_field = "567C996739EDFA1CDBAD4C55A80580DF", hash_generated_field = "3D2CB8429158C4900E9EA4B3985C38C4")

    private String dn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.746 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "C7D2E1B1F4403418CA216FC250689056")

    private int length;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.746 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.746 -0400", hash_original_field = "63A08F52A29E0F7A1F987F4495164AB0", hash_generated_field = "281969654EB14E15446253F1D771C5B0")

    private int beg;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.747 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "BDD622074D0B9CD7867B17F38BB0017C")

    private int end;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.747 -0400", hash_original_field = "B5FDDF1EF601E74DB01C1425561A38CB", hash_generated_field = "574083FEFFA006A1773B42DB36035D30")

    private int cur;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.747 -0400", hash_original_field = "B69D9BC635CCD79AD2C64BC862ABE3B4", hash_generated_field = "8CFCF0E96717F68959883591D279E158")

    private char[] chars;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.747 -0400", hash_original_method = "3E2925D928731F8540EF17AB0FA8675E", hash_generated_method = "11360DB6ACF8FCF3E98B2CD56253A240")
    public  DNParser(X500Principal principal) {
        this.dn = principal.getName(X500Principal.RFC2253);
        this.length = dn.length();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.749 -0400", hash_original_method = "FF4BEB2C3B52F01ACB9FD25F4CE8A230", hash_generated_method = "2B0E851B976DED866C139FA1E5968F40")
    private String nextAT() throws IOException {
for(;pos < length && chars[pos] == ' ';pos++)
        {
        } 
    if(pos == length)        
        {
String var540C13E9E156B687226421B24F2DF178_2107710261 =             null;
            var540C13E9E156B687226421B24F2DF178_2107710261.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2107710261;
        } 
        beg = pos;
        pos++;
for(;pos < length && chars[pos] != '=' && chars[pos] != ' ';pos++)
        {
        } 
    if(pos >= length)        
        {
            IOException var3C5391EA77D4408E3684E0C5A2602AD4_1852009751 = new IOException(ERROR_PARSE_ERROR);
            var3C5391EA77D4408E3684E0C5A2602AD4_1852009751.addTaint(taint);
            throw var3C5391EA77D4408E3684E0C5A2602AD4_1852009751;
        } 
        end = pos;
    if(chars[pos] == ' ')        
        {
for(;pos < length && chars[pos] != '=' && chars[pos] == ' ';pos++)
            {
            } 
    if(chars[pos] != '=' || pos == length)            
            {
                IOException var3C5391EA77D4408E3684E0C5A2602AD4_700998881 = new IOException(ERROR_PARSE_ERROR);
                var3C5391EA77D4408E3684E0C5A2602AD4_700998881.addTaint(taint);
                throw var3C5391EA77D4408E3684E0C5A2602AD4_700998881;
            } 
        } 
        pos++;
for(;pos < length && chars[pos] == ' ';pos++)
        {
        } 
    if((end - beg > 4) && (chars[beg + 3] == '.')
                && (chars[beg] == 'O' || chars[beg] == 'o')
                && (chars[beg + 1] == 'I' || chars[beg + 1] == 'i')
                && (chars[beg + 2] == 'D' || chars[beg + 2] == 'd'))        
        {
            beg += 4;
        } 
String varA88CD4E826BB74E12B252BCF2CEC4945_671010177 =         new String(chars, beg, end - beg);
        varA88CD4E826BB74E12B252BCF2CEC4945_671010177.addTaint(taint);
        return varA88CD4E826BB74E12B252BCF2CEC4945_671010177;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.750 -0400", hash_original_method = "6CE0A226336916B0D0BD29FA44800404", hash_generated_method = "CEB712246EA97A055A71CAD369A5B3B6")
    private String quotedAV() throws IOException {
        pos++;
        beg = pos;
        end = beg;
        while
(true)        
        {
    if(pos == length)            
            {
                IOException var3C5391EA77D4408E3684E0C5A2602AD4_880055429 = new IOException(ERROR_PARSE_ERROR);
                var3C5391EA77D4408E3684E0C5A2602AD4_880055429.addTaint(taint);
                throw var3C5391EA77D4408E3684E0C5A2602AD4_880055429;
            } 
    if(chars[pos] == '"')            
            {
                pos++;
                break;
            } 
            else
    if(chars[pos] == '\\')            
            {
                chars[end] = getEscaped();
            } 
            else
            {
                chars[end] = chars[pos];
            } 
            pos++;
            end++;
        } 
for(;pos < length && chars[pos] == ' ';pos++)
        {
        } 
String varA88CD4E826BB74E12B252BCF2CEC4945_193440843 =         new String(chars, beg, end - beg);
        varA88CD4E826BB74E12B252BCF2CEC4945_193440843.addTaint(taint);
        return varA88CD4E826BB74E12B252BCF2CEC4945_193440843;
        
        
        
        
        
            
                
            
            
                
                
            
                
            
                
            
            
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.752 -0400", hash_original_method = "F2971F3EEE8ADD1AC7CDED4BAC19B062", hash_generated_method = "C286B1B5F0A183432DE69246E66D9002")
    private String hexAV() throws IOException {
    if(pos + 4 >= length)        
        {
            IOException var3C5391EA77D4408E3684E0C5A2602AD4_1431395129 = new IOException(ERROR_PARSE_ERROR);
            var3C5391EA77D4408E3684E0C5A2602AD4_1431395129.addTaint(taint);
            throw var3C5391EA77D4408E3684E0C5A2602AD4_1431395129;
        } 
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
            } 
    if(chars[pos] == ' ')            
            {
                end = pos;
                pos++;
for(;pos < length && chars[pos] == ' ';pos++)
                {
                } 
                break;
            } 
            else
    if(chars[pos] >= 'A' && chars[pos] <= 'F')            
            {
                chars[pos] += 32;
            } 
            pos++;
        } 
        int hexLen = end - beg;
    if(hexLen < 5 || (hexLen & 1) == 0)        
        {
            IOException var3C5391EA77D4408E3684E0C5A2602AD4_1565140039 = new IOException(ERROR_PARSE_ERROR);
            var3C5391EA77D4408E3684E0C5A2602AD4_1565140039.addTaint(taint);
            throw var3C5391EA77D4408E3684E0C5A2602AD4_1565140039;
        } 
        byte[] encoded = new byte[hexLen / 2];
for(int i = 0, p = beg + 1;i < encoded.length;p += 2,i++)
        {
            encoded[i] = (byte) getByte(p);
        } 
String varCC1247AAA5590D16A647B2E2A6BA7DE8_681435456 =         new String(chars, beg, hexLen);
        varCC1247AAA5590D16A647B2E2A6BA7DE8_681435456.addTaint(taint);
        return varCC1247AAA5590D16A647B2E2A6BA7DE8_681435456;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.772 -0400", hash_original_method = "4DC639394A31828D7BD68247B83FBA07", hash_generated_method = "9D736F77EAAA89B3E0BF87A911FA2001")
    private String escapedAV() throws IOException {
        beg = pos;
        end = pos;
        while
(true)        
        {
    if(pos >= length)            
            {
String varA88CD4E826BB74E12B252BCF2CEC4945_105445929 =                 new String(chars, beg, end - beg);
                varA88CD4E826BB74E12B252BCF2CEC4945_105445929.addTaint(taint);
                return varA88CD4E826BB74E12B252BCF2CEC4945_105445929;
            } 
switch(chars[pos]){
            case '+':
            case ',':
            case ';':
String varA88CD4E826BB74E12B252BCF2CEC4945_11347893 =             new String(chars, beg, end - beg);
            varA88CD4E826BB74E12B252BCF2CEC4945_11347893.addTaint(taint);
            return varA88CD4E826BB74E12B252BCF2CEC4945_11347893;
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
            } 
    if(pos == length || chars[pos] == ',' || chars[pos] == '+'
                        || chars[pos] == ';')            
            {
String varF4AE4525652FA624971421628D52D24A_346774616 =                 new String(chars, beg, cur - beg);
                varF4AE4525652FA624971421628D52D24A_346774616.addTaint(taint);
                return varF4AE4525652FA624971421628D52D24A_346774616;
            } 
            break;
            default:
            chars[end++] = chars[pos];
            pos++;
}
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.772 -0400", hash_original_method = "53196F6413879CFC1842AAE874B37E3B", hash_generated_method = "12B5D6A1AD23D5CC481DAF2A52CAA8AC")
    private char getEscaped() throws IOException {
        pos++;
    if(pos == length)        
        {
            IOException var3C5391EA77D4408E3684E0C5A2602AD4_2106790444 = new IOException(ERROR_PARSE_ERROR);
            var3C5391EA77D4408E3684E0C5A2602AD4_2106790444.addTaint(taint);
            throw var3C5391EA77D4408E3684E0C5A2602AD4_2106790444;
        } 
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
        char var8BA167260B3B4A0A1E5DDCB657F950D1_746474150 = (chars[pos]);
                char varA87DEB01C5F539E6BDA34829C8EF2368_1826966225 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1826966225;
        default:
        char var2E5C957BB5E9D2FF9D2B4FF469959575_718361227 = (getUTF8());
                char varA87DEB01C5F539E6BDA34829C8EF2368_1785671499 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1785671499;
}
        
        
        
            
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.772 -0400", hash_original_method = "1AF4B344FDDD447575D7BAE99B8C4CD1", hash_generated_method = "8590F03C51573AD1E1E8B161967C2571")
    private char getUTF8() throws IOException {
        int res = getByte(pos);
        pos++;
    if(res < 128)        
        {
            char var7C6A3B9F9EDA80A67C698BA55955EB3A_243813234 = ((char) res);
                        char varA87DEB01C5F539E6BDA34829C8EF2368_742688963 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_742688963;
        } 
        else
    if(res >= 192 && res <= 247)        
        {
            int count;
    if(res <= 223)            
            {
                count = 1;
                res = res & 0x1F;
            } 
            else
    if(res <= 239)            
            {
                count = 2;
                res = res & 0x0F;
            } 
            else
            {
                count = 3;
                res = res & 0x07;
            } 
            int b;
for(int i = 0;i < count;i++)
            {
                pos++;
    if(pos == length || chars[pos] != '\\')                
                {
                    char var422322C3A3E199EB41D9E4FF6219421D_1708926504 = (0x3F);
                                        char varA87DEB01C5F539E6BDA34829C8EF2368_1425823960 = getTaintChar();
                    return varA87DEB01C5F539E6BDA34829C8EF2368_1425823960;
                } 
                pos++;
                b = getByte(pos);
                pos++;
    if((b & 0xC0) != 0x80)                
                {
                    char var422322C3A3E199EB41D9E4FF6219421D_1228848024 = (0x3F);
                                        char varA87DEB01C5F539E6BDA34829C8EF2368_1075583290 = getTaintChar();
                    return varA87DEB01C5F539E6BDA34829C8EF2368_1075583290;
                } 
                res = (res << 6) + (b & 0x3F);
            } 
            char var7C6A3B9F9EDA80A67C698BA55955EB3A_835585295 = ((char) res);
                        char varA87DEB01C5F539E6BDA34829C8EF2368_213453189 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_213453189;
        } 
        else
        {
            char var422322C3A3E199EB41D9E4FF6219421D_1594990985 = (0x3F);
                        char varA87DEB01C5F539E6BDA34829C8EF2368_562003947 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_562003947;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.773 -0400", hash_original_method = "2374C761E42CEC3E752725D6A1CCC05C", hash_generated_method = "1E3CB481DDA56EEA5F051A144E0405BC")
    private int getByte(int position) throws IOException {
        addTaint(position);
    if((position + 1) >= length)        
        {
            IOException var3C5391EA77D4408E3684E0C5A2602AD4_179427105 = new IOException(ERROR_PARSE_ERROR);
            var3C5391EA77D4408E3684E0C5A2602AD4_179427105.addTaint(taint);
            throw var3C5391EA77D4408E3684E0C5A2602AD4_179427105;
        } 
        int b1;
        int b2;
        b1 = chars[position];
    if(b1 >= '0' && b1 <= '9')        
        {
            b1 = b1 - '0';
        } 
        else
    if(b1 >= 'a' && b1 <= 'f')        
        {
            b1 = b1 - 87;
        } 
        else
    if(b1 >= 'A' && b1 <= 'F')        
        {
            b1 = b1 - 55;
        } 
        else
        {
            IOException var3C5391EA77D4408E3684E0C5A2602AD4_1109256794 = new IOException(ERROR_PARSE_ERROR);
            var3C5391EA77D4408E3684E0C5A2602AD4_1109256794.addTaint(taint);
            throw var3C5391EA77D4408E3684E0C5A2602AD4_1109256794;
        } 
        b2 = chars[position + 1];
    if(b2 >= '0' && b2 <= '9')        
        {
            b2 = b2 - '0';
        } 
        else
    if(b2 >= 'a' && b2 <= 'f')        
        {
            b2 = b2 - 87;
        } 
        else
    if(b2 >= 'A' && b2 <= 'F')        
        {
            b2 = b2 - 55;
        } 
        else
        {
            IOException var3C5391EA77D4408E3684E0C5A2602AD4_536413256 = new IOException(ERROR_PARSE_ERROR);
            var3C5391EA77D4408E3684E0C5A2602AD4_536413256.addTaint(taint);
            throw var3C5391EA77D4408E3684E0C5A2602AD4_536413256;
        } 
        int var91352548C1A77C8ADCB3277772A6897D_1919381202 = ((b1 << 4) + b2);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_342647381 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_342647381;
        
        
            
        
        
        
        
            
        
            
        
            
        
            
        
        
        
            
        
            
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.774 -0400", hash_original_method = "35FC8516F494B2993CB4F015ABFC8107", hash_generated_method = "809952683B73CBB67C60EE39CA9282D7")
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
String var540C13E9E156B687226421B24F2DF178_972473108 =                 null;
                var540C13E9E156B687226421B24F2DF178_972473108.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_972473108;
            } 
            while
(true)            
            {
                String attValue = "";
    if(pos == length)                
                {
String var540C13E9E156B687226421B24F2DF178_1718321488 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1718321488.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1718321488;
                } 
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
}    if(attributeType.equalsIgnoreCase(attType))                
                {
String var808198ACDCDD83074E5A5E92A96CF11C_1215409860 =                     attValue;
                    var808198ACDCDD83074E5A5E92A96CF11C_1215409860.addTaint(taint);
                    return var808198ACDCDD83074E5A5E92A96CF11C_1215409860;
                } 
    if(pos >= length)                
                {
String var540C13E9E156B687226421B24F2DF178_956387399 =                     null;
                    var540C13E9E156B687226421B24F2DF178_956387399.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_956387399;
                } 
    if(chars[pos] == ',' || chars[pos] == ';')                
                {
                } 
                else
    if(chars[pos] != '+')                
                {
                    IOException var3C5391EA77D4408E3684E0C5A2602AD4_1891977662 = new IOException(ERROR_PARSE_ERROR);
                    var3C5391EA77D4408E3684E0C5A2602AD4_1891977662.addTaint(taint);
                    throw var3C5391EA77D4408E3684E0C5A2602AD4_1891977662;
                } 
                pos++;
                attType = nextAT();
    if(attType == null)                
                {
                    IOException var3C5391EA77D4408E3684E0C5A2602AD4_1998493815 = new IOException(ERROR_PARSE_ERROR);
                    var3C5391EA77D4408E3684E0C5A2602AD4_1998493815.addTaint(taint);
                    throw var3C5391EA77D4408E3684E0C5A2602AD4_1998493815;
                } 
            } 
        } 
        catch (IOException e)
        {
String var540C13E9E156B687226421B24F2DF178_1523091897 =             null;
            var540C13E9E156B687226421B24F2DF178_1523091897.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1523091897;
        } 
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.774 -0400", hash_original_field = "6DAE49A6EC00A4949FEB1C9846028845", hash_generated_field = "8755658AF290FD110892EDFB73434ADB")

    private static final String TAG = "DNParser";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.774 -0400", hash_original_field = "88D1EAA420327EA474AE9B433B9E526C", hash_generated_field = "F6565CB51CDFFE700B2DBF94ED832F63")

    private static final String ERROR_PARSE_ERROR = "Failed to parse DN";
}

