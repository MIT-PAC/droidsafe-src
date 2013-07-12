package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.harmony.security.x501.AttributeTypeAndValue;
import org.apache.harmony.security.x501.AttributeValue;

public final class DNParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.830 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.830 -0400", hash_original_field = "63A08F52A29E0F7A1F987F4495164AB0", hash_generated_field = "281969654EB14E15446253F1D771C5B0")

    private int beg;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.830 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "BDD622074D0B9CD7867B17F38BB0017C")

    private int end;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.830 -0400", hash_original_field = "B69D9BC635CCD79AD2C64BC862ABE3B4", hash_generated_field = "8CFCF0E96717F68959883591D279E158")

    private char[] chars;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.830 -0400", hash_original_field = "EC32FC5A9FC36F29B6B89F4826B648EF", hash_generated_field = "790BB9C226E70D863513D01FB9E5249C")

    private boolean hasQE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.830 -0400", hash_original_field = "4B719ACEE4A1D5E30577F59E80D06205", hash_generated_field = "ED95B2E967E3B561D98D41FC80663441")

    private byte[] encoded;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.830 -0400", hash_original_method = "66B2F9736FABC0973929FB105735B82E", hash_generated_method = "5286CFA825BD8D2CE0A88F3464588C97")
    public  DNParser(String dn) throws IOException {
        chars = dn.toCharArray();
        // ---------- Original Method ----------
        //chars = dn.toCharArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.832 -0400", hash_original_method = "7D5C37EF81BA8B102CA672C27E3E2647", hash_generated_method = "5C2CCA8DE5F05630D31953C9C6A8AB62")
    private String nextAT() throws IOException {
        hasQE = false;
for(;pos < chars.length && chars[pos] == ' ';pos++)
        {
        } //End block
    if(pos == chars.length)        
        {
String var540C13E9E156B687226421B24F2DF178_235296803 =             null;
            var540C13E9E156B687226421B24F2DF178_235296803.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_235296803;
        } //End block
        beg = pos;
        pos++;
for(;pos < chars.length && chars[pos] != '=' && chars[pos] != ' ';pos++)
        {
        } //End block
    if(pos >= chars.length)        
        {
            IOException varCB24907B6F6A1E6239279D8AD69D0070_749155084 = new IOException("Invalid distinguished name string");
            varCB24907B6F6A1E6239279D8AD69D0070_749155084.addTaint(taint);
            throw varCB24907B6F6A1E6239279D8AD69D0070_749155084;
        } //End block
        end = pos;
    if(chars[pos] == ' ')        
        {
for(;pos < chars.length && chars[pos] != '=' && chars[pos] == ' ';pos++)
            {
            } //End block
    if(chars[pos] != '=' || pos == chars.length)            
            {
                IOException varCB24907B6F6A1E6239279D8AD69D0070_1672852971 = new IOException("Invalid distinguished name string");
                varCB24907B6F6A1E6239279D8AD69D0070_1672852971.addTaint(taint);
                throw varCB24907B6F6A1E6239279D8AD69D0070_1672852971;
            } //End block
        } //End block
        pos++;
for(;pos < chars.length && chars[pos] == ' ';pos++)
        {
        } //End block
    if((end - beg > 4) && (chars[beg + 3] == '.')
                && (chars[beg] == 'O' || chars[beg] == 'o')
                && (chars[beg + 1] == 'I' || chars[beg + 1] == 'i')
                && (chars[beg + 2] == 'D' || chars[beg + 2] == 'd'))        
        {
            beg += 4;
        } //End block
String varA88CD4E826BB74E12B252BCF2CEC4945_1462360760 =         new String(chars, beg, end - beg);
        varA88CD4E826BB74E12B252BCF2CEC4945_1462360760.addTaint(taint);
        return varA88CD4E826BB74E12B252BCF2CEC4945_1462360760;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.833 -0400", hash_original_method = "5F9B58135FF863A8E24F4B2AD9DF48BE", hash_generated_method = "619E5CBE93DE27715CC92DDED003B5ED")
    private String quotedAV() throws IOException {
        pos++;
        beg = pos;
        end = beg;
        while
(true)        
        {
    if(pos == chars.length)            
            {
                IOException varCB24907B6F6A1E6239279D8AD69D0070_1354804030 = new IOException("Invalid distinguished name string");
                varCB24907B6F6A1E6239279D8AD69D0070_1354804030.addTaint(taint);
                throw varCB24907B6F6A1E6239279D8AD69D0070_1354804030;
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
for(;pos < chars.length && chars[pos] == ' ';pos++)
        {
        } //End block
String varA88CD4E826BB74E12B252BCF2CEC4945_1576505027 =         new String(chars, beg, end - beg);
        varA88CD4E826BB74E12B252BCF2CEC4945_1576505027.addTaint(taint);
        return varA88CD4E826BB74E12B252BCF2CEC4945_1576505027;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.834 -0400", hash_original_method = "59E635302CD6807B36C1A45A26BE591E", hash_generated_method = "F3575F239512848C1709AA537ED88E30")
    private String hexAV() throws IOException {
    if(pos + 4 >= chars.length)        
        {
            IOException varCB24907B6F6A1E6239279D8AD69D0070_1913962146 = new IOException("Invalid distinguished name string");
            varCB24907B6F6A1E6239279D8AD69D0070_1913962146.addTaint(taint);
            throw varCB24907B6F6A1E6239279D8AD69D0070_1913962146;
        } //End block
        beg = pos;
        pos++;
        while
(true)        
        {
    if(pos == chars.length || chars[pos] == '+' || chars[pos] == ','
                    || chars[pos] == ';')            
            {
                end = pos;
                break;
            } //End block
    if(chars[pos] == ' ')            
            {
                end = pos;
                pos++;
for(;pos < chars.length && chars[pos] == ' ';pos++)
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
            IOException varCB24907B6F6A1E6239279D8AD69D0070_344395025 = new IOException("Invalid distinguished name string");
            varCB24907B6F6A1E6239279D8AD69D0070_344395025.addTaint(taint);
            throw varCB24907B6F6A1E6239279D8AD69D0070_344395025;
        } //End block
        encoded = new byte[hexLen / 2];
for(int i = 0, p = beg + 1;i < encoded.length;p += 2,i++)
        {
            encoded[i] = (byte) getByte(p);
        } //End block
String varCC1247AAA5590D16A647B2E2A6BA7DE8_453968503 =         new String(chars, beg, hexLen);
        varCC1247AAA5590D16A647B2E2A6BA7DE8_453968503.addTaint(taint);
        return varCC1247AAA5590D16A647B2E2A6BA7DE8_453968503;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.836 -0400", hash_original_method = "FC33535E1A62E80F93C12FF4F8D2E290", hash_generated_method = "9F585E31CAB54CFDC63C8DF77FA6C469")
    private String escapedAV() throws IOException {
        beg = pos;
        end = pos;
        while
(true)        
        {
    if(pos >= chars.length)            
            {
String varA88CD4E826BB74E12B252BCF2CEC4945_636939642 =                 new String(chars, beg, end - beg);
                varA88CD4E826BB74E12B252BCF2CEC4945_636939642.addTaint(taint);
                return varA88CD4E826BB74E12B252BCF2CEC4945_636939642;
            } //End block
switch(chars[pos]){
            case '+':
            case ',':
            case ';':
String varA88CD4E826BB74E12B252BCF2CEC4945_1386048768 =             new String(chars, beg, end - beg);
            varA88CD4E826BB74E12B252BCF2CEC4945_1386048768.addTaint(taint);
            return varA88CD4E826BB74E12B252BCF2CEC4945_1386048768;
            case '\\':
            chars[end++] = getEscaped();
            pos++;
            break;
            case ' ':
            int cur = end;
            pos++;
            chars[end++] = ' ';
for(;pos < chars.length && chars[pos] == ' ';pos++)
            {
                chars[end++] = ' ';
            } //End block
    if(pos == chars.length || chars[pos] == ',' || chars[pos] == '+'
                        || chars[pos] == ';')            
            {
String varF4AE4525652FA624971421628D52D24A_78248932 =                 new String(chars, beg, cur - beg);
                varF4AE4525652FA624971421628D52D24A_78248932.addTaint(taint);
                return varF4AE4525652FA624971421628D52D24A_78248932;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.837 -0400", hash_original_method = "1A89A1602A29634CB35E16E135F5FE74", hash_generated_method = "965F069DAB1D22A4D639A6AAF4C91633")
    private char getEscaped() throws IOException {
        pos++;
    if(pos == chars.length)        
        {
            IOException varCB24907B6F6A1E6239279D8AD69D0070_896153833 = new IOException("Invalid distinguished name string");
            varCB24907B6F6A1E6239279D8AD69D0070_896153833.addTaint(taint);
            throw varCB24907B6F6A1E6239279D8AD69D0070_896153833;
        } //End block
        char ch = chars[pos];
switch(ch){
        case '"':
        case '\\':
        hasQE = true;
        char varD88FC6EDF21EA464D35FF76288B84103_740757015 = (ch);
                char varA87DEB01C5F539E6BDA34829C8EF2368_219558146 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_219558146;
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
        char varD88FC6EDF21EA464D35FF76288B84103_1516944492 = (ch);
                char varA87DEB01C5F539E6BDA34829C8EF2368_708745511 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_708745511;
        default:
        char var2E5C957BB5E9D2FF9D2B4FF469959575_545311093 = (getUTF8());
                char varA87DEB01C5F539E6BDA34829C8EF2368_125955541 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_125955541;
}
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.838 -0400", hash_original_method = "12C3774F0261E7D12FCB54FD470B78E6", hash_generated_method = "D11DB8482A49225A75C307FA937A58C8")
    protected char getUTF8() throws IOException {
        int res = getByte(pos);
        pos++;
    if(res < 128)        
        {
            char var7C6A3B9F9EDA80A67C698BA55955EB3A_1775289258 = ((char) res);
                        char varA87DEB01C5F539E6BDA34829C8EF2368_1161011143 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1161011143;
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
    if(pos == chars.length || chars[pos] != '\\')                
                {
                    char var422322C3A3E199EB41D9E4FF6219421D_1653093400 = (0x3F);
                                        char varA87DEB01C5F539E6BDA34829C8EF2368_1942774104 = getTaintChar();
                    return varA87DEB01C5F539E6BDA34829C8EF2368_1942774104;
                } //End block
                pos++;
                b = getByte(pos);
                pos++;
    if((b & 0xC0) != 0x80)                
                {
                    char var422322C3A3E199EB41D9E4FF6219421D_714049219 = (0x3F);
                                        char varA87DEB01C5F539E6BDA34829C8EF2368_1476615650 = getTaintChar();
                    return varA87DEB01C5F539E6BDA34829C8EF2368_1476615650;
                } //End block
                res = (res << 6) + (b & 0x3F);
            } //End block
            char var7C6A3B9F9EDA80A67C698BA55955EB3A_1355309295 = ((char) res);
                        char varA87DEB01C5F539E6BDA34829C8EF2368_784555 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_784555;
        } //End block
        else
        {
            char var422322C3A3E199EB41D9E4FF6219421D_2056606393 = (0x3F);
                        char varA87DEB01C5F539E6BDA34829C8EF2368_823459902 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_823459902;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.840 -0400", hash_original_method = "C98D163E17FC33654783E302104D54C8", hash_generated_method = "B6F9702C91B304A1A4B87EA30A144BD3")
    private int getByte(int position) throws IOException {
        addTaint(position);
    if((position + 1) >= chars.length)        
        {
            IOException varCB24907B6F6A1E6239279D8AD69D0070_1502233012 = new IOException("Invalid distinguished name string");
            varCB24907B6F6A1E6239279D8AD69D0070_1502233012.addTaint(taint);
            throw varCB24907B6F6A1E6239279D8AD69D0070_1502233012;
        } //End block
        int b1 = chars[position];
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
            IOException varCB24907B6F6A1E6239279D8AD69D0070_108360831 = new IOException("Invalid distinguished name string");
            varCB24907B6F6A1E6239279D8AD69D0070_108360831.addTaint(taint);
            throw varCB24907B6F6A1E6239279D8AD69D0070_108360831;
        } //End block
        int b2 = chars[position + 1];
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
            IOException varCB24907B6F6A1E6239279D8AD69D0070_1400907878 = new IOException("Invalid distinguished name string");
            varCB24907B6F6A1E6239279D8AD69D0070_1400907878.addTaint(taint);
            throw varCB24907B6F6A1E6239279D8AD69D0070_1400907878;
        } //End block
        int var91352548C1A77C8ADCB3277772A6897D_213972543 = ((b1 << 4) + b2);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2049953936 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2049953936;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.842 -0400", hash_original_method = "17512CE00D4450F012CF195B2D29239B", hash_generated_method = "0E9301F26EB7259A8202316B6EB85C27")
    public List<List<AttributeTypeAndValue>> parse() throws IOException {
        List<List<AttributeTypeAndValue>> list = new ArrayList<List<AttributeTypeAndValue>>();
        String attType = nextAT();
    if(attType == null)        
        {
List<List<AttributeTypeAndValue>> varED12C351C2E8CA4F85F097DDC7E77B4D_1669326123 =             list;
            varED12C351C2E8CA4F85F097DDC7E77B4D_1669326123.addTaint(taint);
            return varED12C351C2E8CA4F85F097DDC7E77B4D_1669326123;
        } //End block
        List<AttributeTypeAndValue> atav = new ArrayList<AttributeTypeAndValue>();
        while
(true)        
        {
    if(pos == chars.length)            
            {
                atav.add(new AttributeTypeAndValue(attType, new AttributeValue("", false)));
                list.add(0, atav);
List<List<AttributeTypeAndValue>> varED12C351C2E8CA4F85F097DDC7E77B4D_1984753869 =                 list;
                varED12C351C2E8CA4F85F097DDC7E77B4D_1984753869.addTaint(taint);
                return varED12C351C2E8CA4F85F097DDC7E77B4D_1984753869;
            } //End block
switch(chars[pos]){
            case '"':
            atav.add(new AttributeTypeAndValue(attType, new AttributeValue(quotedAV(), hasQE)));
            break;
            case '#':
            atav.add(new AttributeTypeAndValue(attType, new AttributeValue(hexAV(), encoded)));
            break;
            case '+':
            case ',':
            case ';':
            atav.add(new AttributeTypeAndValue(attType, new AttributeValue("", false)));
            break;
            default:
            atav.add(new AttributeTypeAndValue(attType, new AttributeValue(
                        escapedAV(), hasQE)));
}    if(pos >= chars.length)            
            {
                list.add(0, atav);
List<List<AttributeTypeAndValue>> varED12C351C2E8CA4F85F097DDC7E77B4D_1583949348 =                 list;
                varED12C351C2E8CA4F85F097DDC7E77B4D_1583949348.addTaint(taint);
                return varED12C351C2E8CA4F85F097DDC7E77B4D_1583949348;
            } //End block
    if(chars[pos] == ',' || chars[pos] == ';')            
            {
                list.add(0, atav);
                atav = new ArrayList<AttributeTypeAndValue>();
            } //End block
            else
    if(chars[pos] != '+')            
            {
                IOException varCB24907B6F6A1E6239279D8AD69D0070_1226996331 = new IOException("Invalid distinguished name string");
                varCB24907B6F6A1E6239279D8AD69D0070_1226996331.addTaint(taint);
                throw varCB24907B6F6A1E6239279D8AD69D0070_1226996331;
            } //End block
            pos++;
            attType = nextAT();
    if(attType == null)            
            {
                IOException varCB24907B6F6A1E6239279D8AD69D0070_179993550 = new IOException("Invalid distinguished name string");
                varCB24907B6F6A1E6239279D8AD69D0070_179993550.addTaint(taint);
                throw varCB24907B6F6A1E6239279D8AD69D0070_179993550;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

