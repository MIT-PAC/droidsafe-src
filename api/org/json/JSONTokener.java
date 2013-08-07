package org.json;

// Droidsafe Imports
import droidsafe.annotations.*;





public class JSONTokener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.544 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "955F96F6D73BCB070D987B819612F71F")

    private String in;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.544 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.544 -0400", hash_original_method = "F6CFC64A950C47985AB98A953B97554C", hash_generated_method = "AB48A8F5DD21BB2D1141F92C64561B86")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.549 -0400", hash_original_method = "B349C062BB24F17BF02BDCB43C03970C", hash_generated_method = "B317F31B7C840A568D0F263925987ECB")
    public Object nextValue() throws JSONException {
        int c = nextCleanInternal();
switch(c){
        case -1:
        org.json.JSONException varBCEF22B08EE707F0BFD12FC70F503B74_1855749185 = syntaxError("End of input");
        varBCEF22B08EE707F0BFD12FC70F503B74_1855749185.addTaint(taint);
        throw varBCEF22B08EE707F0BFD12FC70F503B74_1855749185;
        case '{':
Object varF3F0612D883DA5260F4D671ED7A9B8AB_729313456 =         readObject();
        varF3F0612D883DA5260F4D671ED7A9B8AB_729313456.addTaint(taint);
        return varF3F0612D883DA5260F4D671ED7A9B8AB_729313456;
        case '[':
Object var84E34782B6B1B8CBF2EF1B87A050401E_801376075 =         readArray();
        var84E34782B6B1B8CBF2EF1B87A050401E_801376075.addTaint(taint);
        return var84E34782B6B1B8CBF2EF1B87A050401E_801376075;
        case '\'':
        case '"':
Object var1B0819E4177701BCFDEBFFA1637A2E6E_40840596 =         nextString((char) c);
        var1B0819E4177701BCFDEBFFA1637A2E6E_40840596.addTaint(taint);
        return var1B0819E4177701BCFDEBFFA1637A2E6E_40840596;
        default:
        pos--;
Object var4ADAB184192CA9F9224C13214DADE59A_1292748072 =         readLiteral();
        var4ADAB184192CA9F9224C13214DADE59A_1292748072.addTaint(taint);
        return var4ADAB184192CA9F9224C13214DADE59A_1292748072;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.581 -0400", hash_original_method = "1C1094F3B0EBF3FC35F6CA7F4976DC54", hash_generated_method = "1312F9BAA97CE162CE906BDB2D2CAE36")
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
                int var4A8A08F09D37B73795649038408B5F33_1204961456 = (c);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1170266504 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1170266504;
            } //End block
            char peek = in.charAt(pos);
switch(peek){
            case '*':
            pos++;
            int commentEnd = in.indexOf("*/", pos);
            if(commentEnd == -1)            
            {
                org.json.JSONException var759984733AEA5C68D6F52A8C060A7304_1289124623 = syntaxError("Unterminated comment");
                var759984733AEA5C68D6F52A8C060A7304_1289124623.addTaint(taint);
                throw var759984733AEA5C68D6F52A8C060A7304_1289124623;
            } //End block
            pos = commentEnd + 2;
            continue;
            case '/':
            pos++;
            skipToEndOfLine();
            continue;
            default:
            int var4A8A08F09D37B73795649038408B5F33_169742692 = (c);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1001637503 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1001637503;
}            case '#':
            skipToEndOfLine();
            continue;
            default:
            int var4A8A08F09D37B73795649038408B5F33_1298741012 = (c);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_400337387 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_400337387;
}
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1721855402 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_62402143 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_62402143;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.582 -0400", hash_original_method = "A96A54ECB7E0243FC9401A9259237DF7", hash_generated_method = "08D985BA552FDDA1AE8EBC4B5DF68DDA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.651 -0400", hash_original_method = "7B01D454BE0369CA1502DDC9AB2083EB", hash_generated_method = "D95371E2441F1B13BCF75E70F6CF023C")
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
String var74E20F6623454DD52EED40D93D70CC28_1021187861 =                     new String(in.substring(start, pos - 1));
                    var74E20F6623454DD52EED40D93D70CC28_1021187861.addTaint(taint);
                    return var74E20F6623454DD52EED40D93D70CC28_1021187861;
                } //End block
                else
                {
                    builder.append(in, start, pos - 1);
String varF4CF030572656354ACFDF83FEE21D7A6_1724938424 =                     builder.toString();
                    varF4CF030572656354ACFDF83FEE21D7A6_1724938424.addTaint(taint);
                    return varF4CF030572656354ACFDF83FEE21D7A6_1724938424;
                } //End block
            } //End block
            if(c == '\\')            
            {
                if(pos == in.length())                
                {
                    org.json.JSONException var7ABDD3C2D05FDE982B78D2274CAA119D_1060352733 = syntaxError("Unterminated escape sequence");
                    var7ABDD3C2D05FDE982B78D2274CAA119D_1060352733.addTaint(taint);
                    throw var7ABDD3C2D05FDE982B78D2274CAA119D_1060352733;
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
        org.json.JSONException var677F65C7062C6EB69C61423631301E62_1336611099 = syntaxError("Unterminated string");
        var677F65C7062C6EB69C61423631301E62_1336611099.addTaint(taint);
        throw var677F65C7062C6EB69C61423631301E62_1336611099;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.685 -0400", hash_original_method = "A0F5694EA3978EBF3A8A4E5207628E80", hash_generated_method = "9A5D75E3EE5007938DD79FF074126C2A")
    private char readEscapeCharacter() throws JSONException {
        char escaped = in.charAt(pos++);
switch(escaped){
        case 'u':
        if(pos + 4 > in.length())        
        {
            org.json.JSONException var7ABDD3C2D05FDE982B78D2274CAA119D_2079364505 = syntaxError("Unterminated escape sequence");
            var7ABDD3C2D05FDE982B78D2274CAA119D_2079364505.addTaint(taint);
            throw var7ABDD3C2D05FDE982B78D2274CAA119D_2079364505;
        } //End block
        String hex = in.substring(pos, pos + 4);
        pos += 4;
        char var4930A4F8B5E811D99E27D6DCA9356757_162142344 = ((char) Integer.parseInt(hex, 16));
                char varA87DEB01C5F539E6BDA34829C8EF2368_56117885 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_56117885;
        case 't':
        char var477AA82CF60D6DCB4DCED19347941E67_869980027 = ('\t');
                char varA87DEB01C5F539E6BDA34829C8EF2368_1064139726 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1064139726;
        case 'b':
        char var662C86ECA84593EC435AE1912DA7102B_1352222161 = ('\b');
                char varA87DEB01C5F539E6BDA34829C8EF2368_721927033 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_721927033;
        case 'n':
        char var11B282E345A74511901532F5C84B59EE_303319940 = ('\n');
                char varA87DEB01C5F539E6BDA34829C8EF2368_691410869 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_691410869;
        case 'r':
        char var1E4108231A762B143144B47FBBE5CEAB_631726285 = ('\r');
                char varA87DEB01C5F539E6BDA34829C8EF2368_208969839 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_208969839;
        case 'f':
        char varD39F9AF5563A1A27C3E79FBC26556848_2059158644 = ('\f');
                char varA87DEB01C5F539E6BDA34829C8EF2368_1081048244 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1081048244;
        case '\'':
        case '"':
        case '\\':
        default:
        char varBAFBB2FABBFF5876F8BF7834F802936B_1740360310 = (escaped);
                char varA87DEB01C5F539E6BDA34829C8EF2368_1478899864 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1478899864;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.718 -0400", hash_original_method = "921E97B7A015080CE0A01C361479BF49", hash_generated_method = "C6BC82EF090C7FF139A99020E1F39468")
    private Object readLiteral() throws JSONException {
        String literal = nextToInternal("{}[]/\\:,=;# \t\f");
        if(literal.length() == 0)        
        {
            org.json.JSONException var2F09F556B427AA1AC185DDBECAE44AD4_930544373 = syntaxError("Expected literal value");
            var2F09F556B427AA1AC185DDBECAE44AD4_930544373.addTaint(taint);
            throw var2F09F556B427AA1AC185DDBECAE44AD4_930544373;
        } //End block
        else
        if("null".equalsIgnoreCase(literal))        
        {
Object varDE1E8B10D40F425119DF3D62F44E803A_436093042 =             JSONObject.NULL;
            varDE1E8B10D40F425119DF3D62F44E803A_436093042.addTaint(taint);
            return varDE1E8B10D40F425119DF3D62F44E803A_436093042;
        } //End block
        else
        if("true".equalsIgnoreCase(literal))        
        {
Object varA0859487E5CB2E75775DF67E6DA72EE1_774215015 =             Boolean.TRUE;
            varA0859487E5CB2E75775DF67E6DA72EE1_774215015.addTaint(taint);
            return varA0859487E5CB2E75775DF67E6DA72EE1_774215015;
        } //End block
        else
        if("false".equalsIgnoreCase(literal))        
        {
Object var33A5A714C164AB3D0DEA28EF1768B6A3_1771006351 =             Boolean.FALSE;
            var33A5A714C164AB3D0DEA28EF1768B6A3_1771006351.addTaint(taint);
            return var33A5A714C164AB3D0DEA28EF1768B6A3_1771006351;
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
Object varEC41B88575F4E1CCD68E3EE291ABE048_1116476272 =                     (int) longValue;
                    varEC41B88575F4E1CCD68E3EE291ABE048_1116476272.addTaint(taint);
                    return varEC41B88575F4E1CCD68E3EE291ABE048_1116476272;
                } //End block
                else
                {
Object var19DFF79F8F976763FF3DE73481A2BEEA_61809771 =                     longValue;
                    var19DFF79F8F976763FF3DE73481A2BEEA_61809771.addTaint(taint);
                    return var19DFF79F8F976763FF3DE73481A2BEEA_61809771;
                } //End block
            } //End block
            catch (NumberFormatException e)
            {
            } //End block
        } //End block
        try 
        {
Object var9BF58BF26E1F99737EB4E03CE495E9B9_1649192572 =             Double.valueOf(literal);
            var9BF58BF26E1F99737EB4E03CE495E9B9_1649192572.addTaint(taint);
            return var9BF58BF26E1F99737EB4E03CE495E9B9_1649192572;
        } //End block
        catch (NumberFormatException ignored)
        {
        } //End block
Object var504FB0EB6DB538B769C3E7F0E01CD58F_2063109877 =         new String(literal);
        var504FB0EB6DB538B769C3E7F0E01CD58F_2063109877.addTaint(taint);
        return var504FB0EB6DB538B769C3E7F0E01CD58F_2063109877;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.720 -0400", hash_original_method = "593B1F2EF0668764A615A5DB85CFDCCD", hash_generated_method = "778A4C1F3140C0DD3F8A87B2DBF6DEFC")
    private String nextToInternal(String excluded) {
        addTaint(excluded.getTaint());
        int start = pos;
for(;pos < in.length();pos++)
        {
            char c = in.charAt(pos);
            if(c == '\r' || c == '\n' || excluded.indexOf(c) != -1)            
            {
String var4554F743C711848490A1B56A8D4F9BB0_238026145 =                 in.substring(start, pos);
                var4554F743C711848490A1B56A8D4F9BB0_238026145.addTaint(taint);
                return var4554F743C711848490A1B56A8D4F9BB0_238026145;
            } //End block
        } //End block
String var92605759E550AE8D37EAF6CB6CE70F3A_2042422604 =         in.substring(start);
        var92605759E550AE8D37EAF6CB6CE70F3A_2042422604.addTaint(taint);
        return var92605759E550AE8D37EAF6CB6CE70F3A_2042422604;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.736 -0400", hash_original_method = "D694401380EAF5A76DF87137C67448EA", hash_generated_method = "860620602C17A303FD43BC4334A25D74")
    private JSONObject readObject() throws JSONException {
        JSONObject result = new JSONObject();
        int first = nextCleanInternal();
        if(first == '}')        
        {
JSONObject varDC838461EE2FA0CA4C9BBB70A15456B0_894382131 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_894382131.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_894382131;
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
                    org.json.JSONException varA4CD7124B4A7E5FD11514CF81E807244_464208037 = syntaxError("Names cannot be null");
                    varA4CD7124B4A7E5FD11514CF81E807244_464208037.addTaint(taint);
                    throw varA4CD7124B4A7E5FD11514CF81E807244_464208037;
                } //End block
                else
                {
                    org.json.JSONException var223BFF6E38678D88E059B91825E64D81_211357946 = syntaxError("Names must be strings, but " + name
                            + " is of type " + name.getClass().getName());
                    var223BFF6E38678D88E059B91825E64D81_211357946.addTaint(taint);
                    throw var223BFF6E38678D88E059B91825E64D81_211357946;
                } //End block
            } //End block
            int separator = nextCleanInternal();
            if(separator != ':' && separator != '=')            
            {
                org.json.JSONException var8F3B98F8B1D7086E6B52B27FBAC895A5_1507835059 = syntaxError("Expected ':' after " + name);
                var8F3B98F8B1D7086E6B52B27FBAC895A5_1507835059.addTaint(taint);
                throw var8F3B98F8B1D7086E6B52B27FBAC895A5_1507835059;
            } //End block
            if(pos < in.length() && in.charAt(pos) == '>')            
            {
                pos++;
            } //End block
            result.put((String) name, nextValue());
switch(nextCleanInternal()){
            case '}':
JSONObject varDC838461EE2FA0CA4C9BBB70A15456B0_1119572946 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1119572946.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1119572946;
            case ';':
            case ',':
            continue;
            default:
            org.json.JSONException varE71B5780D94E878B1F2A195846072439_18923433 = syntaxError("Unterminated object");
            varE71B5780D94E878B1F2A195846072439_18923433.addTaint(taint);
            throw varE71B5780D94E878B1F2A195846072439_18923433;
}
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.747 -0400", hash_original_method = "E76B205E92636F1E7B3FC6B2B934FE47", hash_generated_method = "24EB628C57A2174DF43A5FD2D2036403")
    private JSONArray readArray() throws JSONException {
        JSONArray result = new JSONArray();
        boolean hasTrailingSeparator = false;
        while
(true)        
        {
switch(nextCleanInternal()){
            case -1:
            org.json.JSONException var0A5A431CAD4B0E215028CAD44C96809C_980944925 = syntaxError("Unterminated array");
            var0A5A431CAD4B0E215028CAD44C96809C_980944925.addTaint(taint);
            throw var0A5A431CAD4B0E215028CAD44C96809C_980944925;
            case ']':
            if(hasTrailingSeparator)            
            {
                result.put(null);
            } //End block
JSONArray varDC838461EE2FA0CA4C9BBB70A15456B0_897707667 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_897707667.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_897707667;
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
JSONArray varDC838461EE2FA0CA4C9BBB70A15456B0_99328500 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_99328500.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_99328500;
            case ',':
            case ';':
            hasTrailingSeparator = true;
            continue;
            default:
            org.json.JSONException var0A5A431CAD4B0E215028CAD44C96809C_74005686 = syntaxError("Unterminated array");
            var0A5A431CAD4B0E215028CAD44C96809C_74005686.addTaint(taint);
            throw var0A5A431CAD4B0E215028CAD44C96809C_74005686;
}
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.748 -0400", hash_original_method = "33F4C16D40F1C908E16B89E59A552BE8", hash_generated_method = "1F984DA890CEAE83D2B52E165746F0C9")
    public JSONException syntaxError(String message) {
        addTaint(message.getTaint());
JSONException var1C6A9F01159463AF7BEB8A6B0954C165_2106695044 =         new JSONException(message + this);
        var1C6A9F01159463AF7BEB8A6B0954C165_2106695044.addTaint(taint);
        return var1C6A9F01159463AF7BEB8A6B0954C165_2106695044;
        // ---------- Original Method ----------
        //return new JSONException(message + this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.748 -0400", hash_original_method = "D61A5D8B8E38C1530E1AB8F6DB368DAC", hash_generated_method = "24901026951446DCA8CB4641505EB750")
    @Override
    public String toString() {
String varFF4D3465C1564E8B608C0C70E1BC48AA_1485902365 =         " at character " + pos + " of " + in;
        varFF4D3465C1564E8B608C0C70E1BC48AA_1485902365.addTaint(taint);
        return varFF4D3465C1564E8B608C0C70E1BC48AA_1485902365;
        // ---------- Original Method ----------
        //return " at character " + pos + " of " + in;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.749 -0400", hash_original_method = "6281E295952C34947D74AA92CC697B16", hash_generated_method = "1700618446274CED9515CC285360CBA9")
    public boolean more() {
        boolean var00ABE09DB79FC8FBE569A02726AD20CE_88207506 = (pos < in.length());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1642167535 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1642167535;
        // ---------- Original Method ----------
        //return pos < in.length();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.749 -0400", hash_original_method = "213D34FB491711CFF086DB4B25220A73", hash_generated_method = "B6E796D2ACD93D4D85480B1980352931")
    public char next() {
        char var1394684E19C04F7798D7948E9B939256_306522279 = (pos < in.length() ? in.charAt(pos++) : '\0');
                char varA87DEB01C5F539E6BDA34829C8EF2368_1878142445 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1878142445;
        // ---------- Original Method ----------
        //return pos < in.length() ? in.charAt(pos++) : '\0';
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.758 -0400", hash_original_method = "95912FB15799A75254D0EFB27A4965DA", hash_generated_method = "D039848D5EC6B3005463C7075EE4919A")
    public char next(char c) throws JSONException {
        addTaint(c);
        char result = next();
        if(result != c)        
        {
            org.json.JSONException varDA7EA6F0AE14A6D89BF3F1B443C88D3E_734121017 = syntaxError("Expected " + c + " but was " + result);
            varDA7EA6F0AE14A6D89BF3F1B443C88D3E_734121017.addTaint(taint);
            throw varDA7EA6F0AE14A6D89BF3F1B443C88D3E_734121017;
        } //End block
        char varB4A88417B3D0170D754C647C30B7216A_1582449533 = (result);
                char varA87DEB01C5F539E6BDA34829C8EF2368_1735928150 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1735928150;
        // ---------- Original Method ----------
        //char result = next();
        //if (result != c) {
            //throw syntaxError("Expected " + c + " but was " + result);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.758 -0400", hash_original_method = "8888AACA46E7314FC33FB1B59D843324", hash_generated_method = "EBBF074904C3205351880F122FA6CA25")
    public char nextClean() throws JSONException {
        int nextCleanInt = nextCleanInternal();
        char var59ED382EC64047A1389B93B4D7F6656E_1601233448 = (nextCleanInt == -1 ? '\0' : (char) nextCleanInt);
                char varA87DEB01C5F539E6BDA34829C8EF2368_774890887 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_774890887;
        // ---------- Original Method ----------
        //int nextCleanInt = nextCleanInternal();
        //return nextCleanInt == -1 ? '\0' : (char) nextCleanInt;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.769 -0400", hash_original_method = "9816A4D386531BCA80B95E34249E012D", hash_generated_method = "F371456C676B37D847516330A0B81FA1")
    public String next(int length) throws JSONException {
        if(pos + length > in.length())        
        {
            org.json.JSONException varC3863990F0908DB4013DD21EA4CE1B54_1520993474 = syntaxError(length + " is out of bounds");
            varC3863990F0908DB4013DD21EA4CE1B54_1520993474.addTaint(taint);
            throw varC3863990F0908DB4013DD21EA4CE1B54_1520993474;
        } //End block
        String result = in.substring(pos, pos + length);
        pos += length;
String varDC838461EE2FA0CA4C9BBB70A15456B0_500401354 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_500401354.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_500401354;
        // ---------- Original Method ----------
        //if (pos + length > in.length()) {
            //throw syntaxError(length + " is out of bounds");
        //}
        //String result = in.substring(pos, pos + length);
        //pos += length;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.770 -0400", hash_original_method = "EA130CCB3E2CFC0C10CD8E8D4F88F4FA", hash_generated_method = "2E3241E240DAEE872F48464D53951795")
    public String nextTo(String excluded) {
        addTaint(excluded.getTaint());
        if(excluded == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_933475452 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_933475452.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_933475452;
        } //End block
String var5CA9FC6F8810FF918657E0703132E0D5_1970049706 =         nextToInternal(excluded).trim();
        var5CA9FC6F8810FF918657E0703132E0D5_1970049706.addTaint(taint);
        return var5CA9FC6F8810FF918657E0703132E0D5_1970049706;
        // ---------- Original Method ----------
        //if (excluded == null) {
            //throw new NullPointerException();
        //}
        //return nextToInternal(excluded).trim();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.771 -0400", hash_original_method = "9F2D4FCC02E225188C000422795F1B2D", hash_generated_method = "A1F3417DAEDF875EB5AC8DC2A3F43424")
    public String nextTo(char excluded) {
        addTaint(excluded);
String var1D0F72A80D62E96CEA3D7B6E37C980FA_2117918200 =         nextToInternal(String.valueOf(excluded)).trim();
        var1D0F72A80D62E96CEA3D7B6E37C980FA_2117918200.addTaint(taint);
        return var1D0F72A80D62E96CEA3D7B6E37C980FA_2117918200;
        // ---------- Original Method ----------
        //return nextToInternal(String.valueOf(excluded)).trim();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.771 -0400", hash_original_method = "705EE299D0C421425210CB39FE7F29B9", hash_generated_method = "B2B1ACF8EB2757FC38F81E6EFBD0A715")
    public void skipPast(String thru) {
        int thruStart = in.indexOf(thru, pos);
        pos = thruStart == -1 ? in.length() : (thruStart + thru.length());
        // ---------- Original Method ----------
        //int thruStart = in.indexOf(thru, pos);
        //pos = thruStart == -1 ? in.length() : (thruStart + thru.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.772 -0400", hash_original_method = "A067EA373EE4201A369E9BCAA7E25460", hash_generated_method = "20421B63DF62B607EE93B32428139232")
    public char skipTo(char to) {
        addTaint(to);
        int index = in.indexOf(to, pos);
        if(index != -1)        
        {
            pos = index;
            char var01B6E20344B68835C5ED1DDEDF20D531_617205619 = (to);
                        char varA87DEB01C5F539E6BDA34829C8EF2368_367681033 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_367681033;
        } //End block
        else
        {
            char var2FD040853066E22941CBCC768B6AFCE6_1256992343 = ('\0');
                        char varA87DEB01C5F539E6BDA34829C8EF2368_99077958 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_99077958;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.773 -0400", hash_original_method = "8E6F2519C4EF5016C5BDFABD97F81370", hash_generated_method = "84B39920C06747FE079741075FDBA024")
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

