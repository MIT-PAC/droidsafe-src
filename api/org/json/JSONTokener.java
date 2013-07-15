package org.json;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class JSONTokener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.781 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "955F96F6D73BCB070D987B819612F71F")

    private String in;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.781 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.782 -0400", hash_original_method = "F6CFC64A950C47985AB98A953B97554C", hash_generated_method = "AB48A8F5DD21BB2D1141F92C64561B86")
    public  JSONTokener(String in) {
    if(in != null && in.startsWith("\ufeff"))        
        {
            in = in.substring(1);
        } //End block
        this.in = in;
        // ---------- Original Method ----------
        //if (in != null && in.startsWith("\ufeff")) {
            //in = in.substring(1);
        //}
        //this.in = in;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.787 -0400", hash_original_method = "B349C062BB24F17BF02BDCB43C03970C", hash_generated_method = "E4B580BE0E20BD2C1D0DCA9F4F900CBA")
    public Object nextValue() throws JSONException {
        int c = nextCleanInternal();
switch(c){
        case -1:
        org.json.JSONException varBCEF22B08EE707F0BFD12FC70F503B74_657154540 = syntaxError("End of input");
        varBCEF22B08EE707F0BFD12FC70F503B74_657154540.addTaint(taint);
        throw varBCEF22B08EE707F0BFD12FC70F503B74_657154540;
        case '{':
Object varF3F0612D883DA5260F4D671ED7A9B8AB_1604086804 =         readObject();
        varF3F0612D883DA5260F4D671ED7A9B8AB_1604086804.addTaint(taint);
        return varF3F0612D883DA5260F4D671ED7A9B8AB_1604086804;
        case '[':
Object var84E34782B6B1B8CBF2EF1B87A050401E_841619429 =         readArray();
        var84E34782B6B1B8CBF2EF1B87A050401E_841619429.addTaint(taint);
        return var84E34782B6B1B8CBF2EF1B87A050401E_841619429;
        case '\'':
        case '"':
Object var1B0819E4177701BCFDEBFFA1637A2E6E_1412811309 =         nextString((char) c);
        var1B0819E4177701BCFDEBFFA1637A2E6E_1412811309.addTaint(taint);
        return var1B0819E4177701BCFDEBFFA1637A2E6E_1412811309;
        default:
        pos--;
Object var4ADAB184192CA9F9224C13214DADE59A_812652426 =         readLiteral();
        var4ADAB184192CA9F9224C13214DADE59A_812652426.addTaint(taint);
        return var4ADAB184192CA9F9224C13214DADE59A_812652426;
}
        // ---------- Original Method ----------
        //int c = nextCleanInternal();
        //switch (c) {
            //case -1:
                //throw syntaxError("End of input");
            //case '{':
                //return readObject();
            //case '[':
                //return readArray();
            //case '\'':
            //case '"':
                //return nextString((char) c);
            //default:
                //pos--;
                //return readLiteral();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.792 -0400", hash_original_method = "1C1094F3B0EBF3FC35F6CA7F4976DC54", hash_generated_method = "18C8608458F6FD5A48CB7F410D153433")
    private int nextCleanInternal() throws JSONException {
        while
(pos < in.length())        
        {
            int c = in.charAt(pos++);
switch(c){
            case '\t':
            case ' ':
            case '\n':
            case '\r':
            continue;
            case '/':
    if(pos == in.length())            
            {
                int var4A8A08F09D37B73795649038408B5F33_495610990 = (c);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2120647524 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2120647524;
            } //End block
            char peek = in.charAt(pos);
switch(peek){
            case '*':
            pos++;
            int commentEnd = in.indexOf("*/", pos);
    if(commentEnd == -1)            
            {
                org.json.JSONException var759984733AEA5C68D6F52A8C060A7304_2099327346 = syntaxError("Unterminated comment");
                var759984733AEA5C68D6F52A8C060A7304_2099327346.addTaint(taint);
                throw var759984733AEA5C68D6F52A8C060A7304_2099327346;
            } //End block
            pos = commentEnd + 2;
            continue;
            case '/':
            pos++;
            skipToEndOfLine();
            continue;
            default:
            int var4A8A08F09D37B73795649038408B5F33_1565486674 = (c);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_936507893 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_936507893;
}            case '#':
            skipToEndOfLine();
            continue;
            default:
            int var4A8A08F09D37B73795649038408B5F33_161860898 = (c);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_769790889 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_769790889;
}
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1740862236 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1886150377 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1886150377;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.792 -0400", hash_original_method = "A96A54ECB7E0243FC9401A9259237DF7", hash_generated_method = "08D985BA552FDDA1AE8EBC4B5DF68DDA")
    private void skipToEndOfLine() {
for(;pos < in.length();pos++)
        {
            char c = in.charAt(pos);
    if(c == '\r' || c == '\n')            
            {
                pos++;
                break;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //for (; pos < in.length(); pos++) {
            //char c = in.charAt(pos);
            //if (c == '\r' || c == '\n') {
                //pos++;
                //break;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.801 -0400", hash_original_method = "7B01D454BE0369CA1502DDC9AB2083EB", hash_generated_method = "0235A030F18EC154553C262782FD044B")
    public String nextString(char quote) throws JSONException {
        addTaint(quote);
        StringBuilder builder = null;
        int start = pos;
        while
(pos < in.length())        
        {
            int c = in.charAt(pos++);
    if(c == quote)            
            {
    if(builder == null)                
                {
String var74E20F6623454DD52EED40D93D70CC28_1029495721 =                     new String(in.substring(start, pos - 1));
                    var74E20F6623454DD52EED40D93D70CC28_1029495721.addTaint(taint);
                    return var74E20F6623454DD52EED40D93D70CC28_1029495721;
                } //End block
                else
                {
                    builder.append(in, start, pos - 1);
String varF4CF030572656354ACFDF83FEE21D7A6_591150138 =                     builder.toString();
                    varF4CF030572656354ACFDF83FEE21D7A6_591150138.addTaint(taint);
                    return varF4CF030572656354ACFDF83FEE21D7A6_591150138;
                } //End block
            } //End block
    if(c == '\\')            
            {
    if(pos == in.length())                
                {
                    org.json.JSONException var7ABDD3C2D05FDE982B78D2274CAA119D_1472182582 = syntaxError("Unterminated escape sequence");
                    var7ABDD3C2D05FDE982B78D2274CAA119D_1472182582.addTaint(taint);
                    throw var7ABDD3C2D05FDE982B78D2274CAA119D_1472182582;
                } //End block
    if(builder == null)                
                {
                    builder = new StringBuilder();
                } //End block
                builder.append(in, start, pos - 1);
                builder.append(readEscapeCharacter());
                start = pos;
            } //End block
        } //End block
        org.json.JSONException var677F65C7062C6EB69C61423631301E62_893636202 = syntaxError("Unterminated string");
        var677F65C7062C6EB69C61423631301E62_893636202.addTaint(taint);
        throw var677F65C7062C6EB69C61423631301E62_893636202;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.810 -0400", hash_original_method = "A0F5694EA3978EBF3A8A4E5207628E80", hash_generated_method = "574EAED35B4C95070FF984E8DE5CFEA1")
    private char readEscapeCharacter() throws JSONException {
        char escaped = in.charAt(pos++);
switch(escaped){
        case 'u':
    if(pos + 4 > in.length())        
        {
            org.json.JSONException var7ABDD3C2D05FDE982B78D2274CAA119D_178542137 = syntaxError("Unterminated escape sequence");
            var7ABDD3C2D05FDE982B78D2274CAA119D_178542137.addTaint(taint);
            throw var7ABDD3C2D05FDE982B78D2274CAA119D_178542137;
        } //End block
        String hex = in.substring(pos, pos + 4);
        pos += 4;
        char var4930A4F8B5E811D99E27D6DCA9356757_937925809 = ((char) Integer.parseInt(hex, 16));
                char varA87DEB01C5F539E6BDA34829C8EF2368_1248699795 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1248699795;
        case 't':
        char var477AA82CF60D6DCB4DCED19347941E67_1794022841 = ('\t');
                char varA87DEB01C5F539E6BDA34829C8EF2368_764375683 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_764375683;
        case 'b':
        char var662C86ECA84593EC435AE1912DA7102B_802641590 = ('\b');
                char varA87DEB01C5F539E6BDA34829C8EF2368_472240121 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_472240121;
        case 'n':
        char var11B282E345A74511901532F5C84B59EE_683315913 = ('\n');
                char varA87DEB01C5F539E6BDA34829C8EF2368_251887480 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_251887480;
        case 'r':
        char var1E4108231A762B143144B47FBBE5CEAB_1865905113 = ('\r');
                char varA87DEB01C5F539E6BDA34829C8EF2368_2116051191 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_2116051191;
        case 'f':
        char varD39F9AF5563A1A27C3E79FBC26556848_1991177462 = ('\f');
                char varA87DEB01C5F539E6BDA34829C8EF2368_2018196084 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_2018196084;
        case '\'':
        case '"':
        case '\\':
        default:
        char varBAFBB2FABBFF5876F8BF7834F802936B_1056816434 = (escaped);
                char varA87DEB01C5F539E6BDA34829C8EF2368_653203681 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_653203681;
}
        // ---------- Original Method ----------
        //char escaped = in.charAt(pos++);
        //switch (escaped) {
            //case 'u':
                //if (pos + 4 > in.length()) {
                    //throw syntaxError("Unterminated escape sequence");
                //}
                //String hex = in.substring(pos, pos + 4);
                //pos += 4;
                //return (char) Integer.parseInt(hex, 16);
            //case 't':
                //return '\t';
            //case 'b':
                //return '\b';
            //case 'n':
                //return '\n';
            //case 'r':
                //return '\r';
            //case 'f':
                //return '\f';
            //case '\'':
            //case '"':
            //case '\\':
            //default:
                //return escaped;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.820 -0400", hash_original_method = "921E97B7A015080CE0A01C361479BF49", hash_generated_method = "5101DACEEADDCD8BEFA3EAC94E52C7E2")
    private Object readLiteral() throws JSONException {
        String literal = nextToInternal("{}[]/\\:,=;# \t\f");
    if(literal.length() == 0)        
        {
            org.json.JSONException var2F09F556B427AA1AC185DDBECAE44AD4_1287599954 = syntaxError("Expected literal value");
            var2F09F556B427AA1AC185DDBECAE44AD4_1287599954.addTaint(taint);
            throw var2F09F556B427AA1AC185DDBECAE44AD4_1287599954;
        } //End block
        else
    if("null".equalsIgnoreCase(literal))        
        {
Object varDE1E8B10D40F425119DF3D62F44E803A_2114853757 =             JSONObject.NULL;
            varDE1E8B10D40F425119DF3D62F44E803A_2114853757.addTaint(taint);
            return varDE1E8B10D40F425119DF3D62F44E803A_2114853757;
        } //End block
        else
    if("true".equalsIgnoreCase(literal))        
        {
Object varA0859487E5CB2E75775DF67E6DA72EE1_1539626470 =             Boolean.TRUE;
            varA0859487E5CB2E75775DF67E6DA72EE1_1539626470.addTaint(taint);
            return varA0859487E5CB2E75775DF67E6DA72EE1_1539626470;
        } //End block
        else
    if("false".equalsIgnoreCase(literal))        
        {
Object var33A5A714C164AB3D0DEA28EF1768B6A3_1952691853 =             Boolean.FALSE;
            var33A5A714C164AB3D0DEA28EF1768B6A3_1952691853.addTaint(taint);
            return var33A5A714C164AB3D0DEA28EF1768B6A3_1952691853;
        } //End block
    if(literal.indexOf('.') == -1)        
        {
            int base = 10;
            String number = literal;
    if(number.startsWith("0x") || number.startsWith("0X"))            
            {
                number = number.substring(2);
                base = 16;
            } //End block
            else
    if(number.startsWith("0") && number.length() > 1)            
            {
                number = number.substring(1);
                base = 8;
            } //End block
            try 
            {
                long longValue = Long.parseLong(number, base);
    if(longValue <= Integer.MAX_VALUE && longValue >= Integer.MIN_VALUE)                
                {
Object varEC41B88575F4E1CCD68E3EE291ABE048_1698423911 =                     (int) longValue;
                    varEC41B88575F4E1CCD68E3EE291ABE048_1698423911.addTaint(taint);
                    return varEC41B88575F4E1CCD68E3EE291ABE048_1698423911;
                } //End block
                else
                {
Object var19DFF79F8F976763FF3DE73481A2BEEA_1953388166 =                     longValue;
                    var19DFF79F8F976763FF3DE73481A2BEEA_1953388166.addTaint(taint);
                    return var19DFF79F8F976763FF3DE73481A2BEEA_1953388166;
                } //End block
            } //End block
            catch (NumberFormatException e)
            {
            } //End block
        } //End block
        try 
        {
Object var9BF58BF26E1F99737EB4E03CE495E9B9_1243438521 =             Double.valueOf(literal);
            var9BF58BF26E1F99737EB4E03CE495E9B9_1243438521.addTaint(taint);
            return var9BF58BF26E1F99737EB4E03CE495E9B9_1243438521;
        } //End block
        catch (NumberFormatException ignored)
        {
        } //End block
Object var504FB0EB6DB538B769C3E7F0E01CD58F_1288201095 =         new String(literal);
        var504FB0EB6DB538B769C3E7F0E01CD58F_1288201095.addTaint(taint);
        return var504FB0EB6DB538B769C3E7F0E01CD58F_1288201095;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.821 -0400", hash_original_method = "593B1F2EF0668764A615A5DB85CFDCCD", hash_generated_method = "AF4B3E690B50A1B658572AA272C84AC0")
    private String nextToInternal(String excluded) {
        addTaint(excluded.getTaint());
        int start = pos;
for(;pos < in.length();pos++)
        {
            char c = in.charAt(pos);
    if(c == '\r' || c == '\n' || excluded.indexOf(c) != -1)            
            {
String var4554F743C711848490A1B56A8D4F9BB0_1042802756 =                 in.substring(start, pos);
                var4554F743C711848490A1B56A8D4F9BB0_1042802756.addTaint(taint);
                return var4554F743C711848490A1B56A8D4F9BB0_1042802756;
            } //End block
        } //End block
String var92605759E550AE8D37EAF6CB6CE70F3A_179030402 =         in.substring(start);
        var92605759E550AE8D37EAF6CB6CE70F3A_179030402.addTaint(taint);
        return var92605759E550AE8D37EAF6CB6CE70F3A_179030402;
        // ---------- Original Method ----------
        //int start = pos;
        //for (; pos < in.length(); pos++) {
            //char c = in.charAt(pos);
            //if (c == '\r' || c == '\n' || excluded.indexOf(c) != -1) {
                //return in.substring(start, pos);
            //}
        //}
        //return in.substring(start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.828 -0400", hash_original_method = "D694401380EAF5A76DF87137C67448EA", hash_generated_method = "7F4769436E7A0FAB33FD352859B5421A")
    private JSONObject readObject() throws JSONException {
        JSONObject result = new JSONObject();
        int first = nextCleanInternal();
    if(first == '}')        
        {
JSONObject varDC838461EE2FA0CA4C9BBB70A15456B0_1986225773 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1986225773.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1986225773;
        } //End block
        else
    if(first != -1)        
        {
            pos--;
        } //End block
        while
(true)        
        {
            Object name = nextValue();
    if(!(name instanceof String))            
            {
    if(name == null)                
                {
                    org.json.JSONException varA4CD7124B4A7E5FD11514CF81E807244_1244303866 = syntaxError("Names cannot be null");
                    varA4CD7124B4A7E5FD11514CF81E807244_1244303866.addTaint(taint);
                    throw varA4CD7124B4A7E5FD11514CF81E807244_1244303866;
                } //End block
                else
                {
                    org.json.JSONException var223BFF6E38678D88E059B91825E64D81_1396958162 = syntaxError("Names must be strings, but " + name
                            + " is of type " + name.getClass().getName());
                    var223BFF6E38678D88E059B91825E64D81_1396958162.addTaint(taint);
                    throw var223BFF6E38678D88E059B91825E64D81_1396958162;
                } //End block
            } //End block
            int separator = nextCleanInternal();
    if(separator != ':' && separator != '=')            
            {
                org.json.JSONException var8F3B98F8B1D7086E6B52B27FBAC895A5_38637711 = syntaxError("Expected ':' after " + name);
                var8F3B98F8B1D7086E6B52B27FBAC895A5_38637711.addTaint(taint);
                throw var8F3B98F8B1D7086E6B52B27FBAC895A5_38637711;
            } //End block
    if(pos < in.length() && in.charAt(pos) == '>')            
            {
                pos++;
            } //End block
            result.put((String) name, nextValue());
switch(nextCleanInternal()){
            case '}':
JSONObject varDC838461EE2FA0CA4C9BBB70A15456B0_1635955332 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1635955332.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1635955332;
            case ';':
            case ',':
            continue;
            default:
            org.json.JSONException varE71B5780D94E878B1F2A195846072439_838532748 = syntaxError("Unterminated object");
            varE71B5780D94E878B1F2A195846072439_838532748.addTaint(taint);
            throw varE71B5780D94E878B1F2A195846072439_838532748;
}
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.834 -0400", hash_original_method = "E76B205E92636F1E7B3FC6B2B934FE47", hash_generated_method = "3E531957A1EB893BAD6D671A1FF17349")
    private JSONArray readArray() throws JSONException {
        JSONArray result = new JSONArray();
        boolean hasTrailingSeparator = false;
        while
(true)        
        {
switch(nextCleanInternal()){
            case -1:
            org.json.JSONException var0A5A431CAD4B0E215028CAD44C96809C_168835962 = syntaxError("Unterminated array");
            var0A5A431CAD4B0E215028CAD44C96809C_168835962.addTaint(taint);
            throw var0A5A431CAD4B0E215028CAD44C96809C_168835962;
            case ']':
    if(hasTrailingSeparator)            
            {
                result.put(null);
            } //End block
JSONArray varDC838461EE2FA0CA4C9BBB70A15456B0_745667587 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_745667587.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_745667587;
            case ',':
            case ';':
            result.put(null);
            hasTrailingSeparator = true;
            continue;
            default:
            pos--;
}            result.put(nextValue());
switch(nextCleanInternal()){
            case ']':
JSONArray varDC838461EE2FA0CA4C9BBB70A15456B0_793992007 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_793992007.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_793992007;
            case ',':
            case ';':
            hasTrailingSeparator = true;
            continue;
            default:
            org.json.JSONException var0A5A431CAD4B0E215028CAD44C96809C_1388763582 = syntaxError("Unterminated array");
            var0A5A431CAD4B0E215028CAD44C96809C_1388763582.addTaint(taint);
            throw var0A5A431CAD4B0E215028CAD44C96809C_1388763582;
}
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.835 -0400", hash_original_method = "33F4C16D40F1C908E16B89E59A552BE8", hash_generated_method = "0F9A9CCF2128DF28DA6555FE7717A3D1")
    public JSONException syntaxError(String message) {
        addTaint(message.getTaint());
JSONException var1C6A9F01159463AF7BEB8A6B0954C165_1537759461 =         new JSONException(message + this);
        var1C6A9F01159463AF7BEB8A6B0954C165_1537759461.addTaint(taint);
        return var1C6A9F01159463AF7BEB8A6B0954C165_1537759461;
        // ---------- Original Method ----------
        //return new JSONException(message + this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.835 -0400", hash_original_method = "D61A5D8B8E38C1530E1AB8F6DB368DAC", hash_generated_method = "BE8345909F7100852270E7983087E54D")
    @Override
    public String toString() {
String varFF4D3465C1564E8B608C0C70E1BC48AA_1558328624 =         " at character " + pos + " of " + in;
        varFF4D3465C1564E8B608C0C70E1BC48AA_1558328624.addTaint(taint);
        return varFF4D3465C1564E8B608C0C70E1BC48AA_1558328624;
        // ---------- Original Method ----------
        //return " at character " + pos + " of " + in;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.836 -0400", hash_original_method = "6281E295952C34947D74AA92CC697B16", hash_generated_method = "27CA1717273F9A358B6549C0F0B56ACB")
    public boolean more() {
        boolean var00ABE09DB79FC8FBE569A02726AD20CE_1557771069 = (pos < in.length());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1464319947 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1464319947;
        // ---------- Original Method ----------
        //return pos < in.length();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.836 -0400", hash_original_method = "213D34FB491711CFF086DB4B25220A73", hash_generated_method = "1D5857AACE64460F4FEC932BD004EBB7")
    public char next() {
        char var1394684E19C04F7798D7948E9B939256_1430658784 = (pos < in.length() ? in.charAt(pos++) : '\0');
                char varA87DEB01C5F539E6BDA34829C8EF2368_765644330 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_765644330;
        // ---------- Original Method ----------
        //return pos < in.length() ? in.charAt(pos++) : '\0';
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.841 -0400", hash_original_method = "95912FB15799A75254D0EFB27A4965DA", hash_generated_method = "20E742D2A11658AD9BD4DEECF85C7E76")
    public char next(char c) throws JSONException {
        addTaint(c);
        char result = next();
    if(result != c)        
        {
            org.json.JSONException varDA7EA6F0AE14A6D89BF3F1B443C88D3E_479489235 = syntaxError("Expected " + c + " but was " + result);
            varDA7EA6F0AE14A6D89BF3F1B443C88D3E_479489235.addTaint(taint);
            throw varDA7EA6F0AE14A6D89BF3F1B443C88D3E_479489235;
        } //End block
        char varB4A88417B3D0170D754C647C30B7216A_1180593702 = (result);
                char varA87DEB01C5F539E6BDA34829C8EF2368_588204480 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_588204480;
        // ---------- Original Method ----------
        //char result = next();
        //if (result != c) {
            //throw syntaxError("Expected " + c + " but was " + result);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.841 -0400", hash_original_method = "8888AACA46E7314FC33FB1B59D843324", hash_generated_method = "37E6D54B07E8A60EF9665925E48C2105")
    public char nextClean() throws JSONException {
        int nextCleanInt = nextCleanInternal();
        char var59ED382EC64047A1389B93B4D7F6656E_1582998380 = (nextCleanInt == -1 ? '\0' : (char) nextCleanInt);
                char varA87DEB01C5F539E6BDA34829C8EF2368_954640901 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_954640901;
        // ---------- Original Method ----------
        //int nextCleanInt = nextCleanInternal();
        //return nextCleanInt == -1 ? '\0' : (char) nextCleanInt;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.847 -0400", hash_original_method = "9816A4D386531BCA80B95E34249E012D", hash_generated_method = "E8CBA376A17EAE286609EC6C91C0C194")
    public String next(int length) throws JSONException {
    if(pos + length > in.length())        
        {
            org.json.JSONException varC3863990F0908DB4013DD21EA4CE1B54_1993303515 = syntaxError(length + " is out of bounds");
            varC3863990F0908DB4013DD21EA4CE1B54_1993303515.addTaint(taint);
            throw varC3863990F0908DB4013DD21EA4CE1B54_1993303515;
        } //End block
        String result = in.substring(pos, pos + length);
        pos += length;
String varDC838461EE2FA0CA4C9BBB70A15456B0_1470177577 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1470177577.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1470177577;
        // ---------- Original Method ----------
        //if (pos + length > in.length()) {
            //throw syntaxError(length + " is out of bounds");
        //}
        //String result = in.substring(pos, pos + length);
        //pos += length;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.849 -0400", hash_original_method = "EA130CCB3E2CFC0C10CD8E8D4F88F4FA", hash_generated_method = "1B2720E80D51BC425FF2A0EA01032D0D")
    public String nextTo(String excluded) {
        addTaint(excluded.getTaint());
    if(excluded == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_969365444 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_969365444.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_969365444;
        } //End block
String var5CA9FC6F8810FF918657E0703132E0D5_1292294269 =         nextToInternal(excluded).trim();
        var5CA9FC6F8810FF918657E0703132E0D5_1292294269.addTaint(taint);
        return var5CA9FC6F8810FF918657E0703132E0D5_1292294269;
        // ---------- Original Method ----------
        //if (excluded == null) {
            //throw new NullPointerException();
        //}
        //return nextToInternal(excluded).trim();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.850 -0400", hash_original_method = "9F2D4FCC02E225188C000422795F1B2D", hash_generated_method = "665BE6FFE9B69B047C94CE831B8E9489")
    public String nextTo(char excluded) {
        addTaint(excluded);
String var1D0F72A80D62E96CEA3D7B6E37C980FA_1862723491 =         nextToInternal(String.valueOf(excluded)).trim();
        var1D0F72A80D62E96CEA3D7B6E37C980FA_1862723491.addTaint(taint);
        return var1D0F72A80D62E96CEA3D7B6E37C980FA_1862723491;
        // ---------- Original Method ----------
        //return nextToInternal(String.valueOf(excluded)).trim();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.850 -0400", hash_original_method = "705EE299D0C421425210CB39FE7F29B9", hash_generated_method = "B2B1ACF8EB2757FC38F81E6EFBD0A715")
    public void skipPast(String thru) {
        int thruStart = in.indexOf(thru, pos);
        pos = thruStart == -1 ? in.length() : (thruStart + thru.length());
        // ---------- Original Method ----------
        //int thruStart = in.indexOf(thru, pos);
        //pos = thruStart == -1 ? in.length() : (thruStart + thru.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.851 -0400", hash_original_method = "A067EA373EE4201A369E9BCAA7E25460", hash_generated_method = "63239C0986F315E85BB5F17EAA3A23BA")
    public char skipTo(char to) {
        addTaint(to);
        int index = in.indexOf(to, pos);
    if(index != -1)        
        {
            pos = index;
            char var01B6E20344B68835C5ED1DDEDF20D531_2069603832 = (to);
                        char varA87DEB01C5F539E6BDA34829C8EF2368_1027902700 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1027902700;
        } //End block
        else
        {
            char var2FD040853066E22941CBCC768B6AFCE6_238954386 = ('\0');
                        char varA87DEB01C5F539E6BDA34829C8EF2368_834583932 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_834583932;
        } //End block
        // ---------- Original Method ----------
        //int index = in.indexOf(to, pos);
        //if (index != -1) {
            //pos = index;
            //return to;
        //} else {
            //return '\0';
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.852 -0400", hash_original_method = "8E6F2519C4EF5016C5BDFABD97F81370", hash_generated_method = "84B39920C06747FE079741075FDBA024")
    public void back() {
    if(--pos == -1)        
        {
            pos = 0;
        } //End block
        // ---------- Original Method ----------
        //if (--pos == -1) {
            //pos = 0;
        //}
    }

    
        @DSModeled(DSC.SAFE)
    public static int dehexchar(char hex) {
        if (hex >= '0' && hex <= '9') {
            return hex - '0';
        } else if (hex >= 'A' && hex <= 'F') {
            return hex - 'A' + 10;
        } else if (hex >= 'a' && hex <= 'f') {
            return hex - 'a' + 10;
        } else {
            return -1;
        }
    }

    
}

