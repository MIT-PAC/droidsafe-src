package org.json;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class JSONTokener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.079 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "955F96F6D73BCB070D987B819612F71F")

    private String in;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.079 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.079 -0400", hash_original_method = "F6CFC64A950C47985AB98A953B97554C", hash_generated_method = "1A4CBA63519C05F493148976E29BE971")
    public  JSONTokener(String in) {
        {
            boolean var0916A8AD1454CFA7BBC4BD929FFC95F8_383089840 = (in != null && in.startsWith("\ufeff"));
            {
                in = in.substring(1);
            } //End block
        } //End collapsed parenthetic
        this.in = in;
        // ---------- Original Method ----------
        //if (in != null && in.startsWith("\ufeff")) {
            //in = in.substring(1);
        //}
        //this.in = in;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.080 -0400", hash_original_method = "B349C062BB24F17BF02BDCB43C03970C", hash_generated_method = "C53EF528C69406926A9631B4AA452B90")
    public Object nextValue() throws JSONException {
        Object varB4EAC82CA7396A68D541C85D26508E83_2017096914 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_565086388 = null; //Variable for return #2
        Object varB4EAC82CA7396A68D541C85D26508E83_255351976 = null; //Variable for return #3
        Object varB4EAC82CA7396A68D541C85D26508E83_17120441 = null; //Variable for return #4
        int c;
        c = nextCleanInternal();
        //Begin case -1 
        if (DroidSafeAndroidRuntime.control) throw syntaxError("End of input");
        //End case -1 
        //Begin case '{' 
        varB4EAC82CA7396A68D541C85D26508E83_2017096914 = readObject();
        //End case '{' 
        //Begin case '[' 
        varB4EAC82CA7396A68D541C85D26508E83_565086388 = readArray();
        //End case '[' 
        //Begin case '\'' '"' 
        varB4EAC82CA7396A68D541C85D26508E83_255351976 = nextString((char) c);
        //End case '\'' '"' 
        //Begin case default 
        varB4EAC82CA7396A68D541C85D26508E83_17120441 = readLiteral();
        //End case default 
        Object varA7E53CE21691AB073D9660D615818899_818712832; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_818712832 = varB4EAC82CA7396A68D541C85D26508E83_2017096914;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_818712832 = varB4EAC82CA7396A68D541C85D26508E83_565086388;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_818712832 = varB4EAC82CA7396A68D541C85D26508E83_255351976;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_818712832 = varB4EAC82CA7396A68D541C85D26508E83_17120441;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_818712832.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_818712832;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.081 -0400", hash_original_method = "1C1094F3B0EBF3FC35F6CA7F4976DC54", hash_generated_method = "32D617CE8C0DB302E6E0B5C031AB69C2")
    private int nextCleanInternal() throws JSONException {
        {
            boolean var06047043A614DB892241E06898F33574_2124917725 = (pos < in.length());
            {
                int c;
                c = in.charAt(pos++);
                //Begin case '/' 
                {
                    boolean varF346F04719233B0A8AE8FE49F5B4F786_1901255438 = (pos == in.length());
                } //End collapsed parenthetic
                //End case '/' 
                //Begin case '/' 
                char peek;
                peek = in.charAt(pos);
                //End case '/' 
                //Begin case '/' 
                //Begin case '*' 
                int commentEnd;
                commentEnd = in.indexOf("*/", pos);
                //End case '*' 
                //Begin case '*' 
                {
                    if (DroidSafeAndroidRuntime.control) throw syntaxError("Unterminated comment");
                } //End block
                //End case '*' 
                //Begin case '*' 
                pos = commentEnd + 2;
                //End case '*' 
                //Begin case '/' 
                skipToEndOfLine();
                //End case '/' 
                //End case '/' 
                //Begin case '#' 
                skipToEndOfLine();
                //End case '#' 
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_221389594 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_221389594;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.087 -0400", hash_original_method = "A96A54ECB7E0243FC9401A9259237DF7", hash_generated_method = "D53CAB4E29112E72C4D39AC34BA47062")
    private void skipToEndOfLine() {
        {
            boolean var06047043A614DB892241E06898F33574_576843829 = (pos < in.length());
            {
                char c;
                c = in.charAt(pos);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (; pos < in.length(); pos++) {
            //char c = in.charAt(pos);
            //if (c == '\r' || c == '\n') {
                //pos++;
                //break;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.088 -0400", hash_original_method = "7B01D454BE0369CA1502DDC9AB2083EB", hash_generated_method = "7C4CC958F7FB82E69989C610F2DB6D34")
    public String nextString(char quote) throws JSONException {
        String varB4EAC82CA7396A68D541C85D26508E83_1132940715 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_479291241 = null; //Variable for return #2
        StringBuilder builder;
        builder = null;
        int start;
        start = pos;
        {
            boolean var06047043A614DB892241E06898F33574_644481363 = (pos < in.length());
            {
                int c;
                c = in.charAt(pos++);
                {
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1132940715 = new String(in.substring(start, pos - 1));
                    } //End block
                    {
                        builder.append(in, start, pos - 1);
                        varB4EAC82CA7396A68D541C85D26508E83_479291241 = builder.toString();
                    } //End block
                } //End block
                {
                    {
                        boolean varBE34942D29178E1181139C06D7AE7E8D_627948212 = (pos == in.length());
                        {
                            if (DroidSafeAndroidRuntime.control) throw syntaxError("Unterminated escape sequence");
                        } //End block
                    } //End collapsed parenthetic
                    {
                        builder = new StringBuilder();
                    } //End block
                    builder.append(in, start, pos - 1);
                    builder.append(readEscapeCharacter());
                    start = pos;
                } //End block
            } //End block
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw syntaxError("Unterminated string");
        addTaint(quote);
        String varA7E53CE21691AB073D9660D615818899_39514502; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_39514502 = varB4EAC82CA7396A68D541C85D26508E83_1132940715;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_39514502 = varB4EAC82CA7396A68D541C85D26508E83_479291241;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_39514502.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_39514502;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.088 -0400", hash_original_method = "A0F5694EA3978EBF3A8A4E5207628E80", hash_generated_method = "DD6010C7AE9D1F8AE1E2166D930F0B20")
    private char readEscapeCharacter() throws JSONException {
        char escaped;
        escaped = in.charAt(pos++);
        //Begin case 'u' 
        {
            boolean var424D936A921E9F5F188D1F0C63AC336E_1265415165 = (pos + 4 > in.length());
            {
                if (DroidSafeAndroidRuntime.control) throw syntaxError("Unterminated escape sequence");
            } //End block
        } //End collapsed parenthetic
        //End case 'u' 
        //Begin case 'u' 
        String hex;
        hex = in.substring(pos, pos + 4);
        //End case 'u' 
        //Begin case 'u' 
        pos += 4;
        //End case 'u' 
        //Begin case 'u' 
        char varD7BED12C29043F5FF01B529F3028A604_1894832330 = ((char) Integer.parseInt(hex, 16));
        //End case 'u' 
        char varA87DEB01C5F539E6BDA34829C8EF2368_1733484626 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1733484626;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.093 -0400", hash_original_method = "921E97B7A015080CE0A01C361479BF49", hash_generated_method = "73D3FAF3EE62A0BDA9317EE19FD090CF")
    private Object readLiteral() throws JSONException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1437642311 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1023596370 = null; //Variable for return #2
        Object varB4EAC82CA7396A68D541C85D26508E83_1525449003 = null; //Variable for return #3
        Object varB4EAC82CA7396A68D541C85D26508E83_570128481 = null; //Variable for return #4
        Object varB4EAC82CA7396A68D541C85D26508E83_1136408967 = null; //Variable for return #5
        Object varB4EAC82CA7396A68D541C85D26508E83_746436115 = null; //Variable for return #6
        Object varB4EAC82CA7396A68D541C85D26508E83_1162591498 = null; //Variable for return #7
        String literal;
        literal = nextToInternal("{}[]/\\:,=;# \t\f");
        {
            boolean var2226B848A2ABD4303CB67E9A8790E325_1790007408 = (literal.length() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw syntaxError("Expected literal value");
            } //End block
            {
                boolean varE7B73990E47CA66757AE976486FA066E_1102024054 = ("null".equalsIgnoreCase(literal));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1437642311 = JSONObject.NULL;
                } //End block
                {
                    boolean var0F62A1A944013BA459EE135E16EB4002_486314528 = ("true".equalsIgnoreCase(literal));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1023596370 = Boolean.TRUE;
                    } //End block
                    {
                        boolean var250365B2F3AE6CA4568AA76CE00BEEEE_398442980 = ("false".equalsIgnoreCase(literal));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1525449003 = Boolean.FALSE;
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            boolean varFF6E99342D1FEA616C0B8E78FAFB13F8_668623636 = (literal.indexOf('.') == -1);
            {
                int base;
                base = 10;
                String number;
                number = literal;
                {
                    boolean var23DA3B05608ECFB50FED05F3B5EFE228_101010566 = (number.startsWith("0x") || number.startsWith("0X"));
                    {
                        number = number.substring(2);
                        base = 16;
                    } //End block
                    {
                        boolean varECB1F3363AA5C8D13B35551E8BC5CC45_1395405915 = (number.startsWith("0") && number.length() > 1);
                        {
                            number = number.substring(1);
                            base = 8;
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
                try 
                {
                    long longValue;
                    longValue = Long.parseLong(number, base);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_570128481 = (int) longValue;
                    } //End block
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1136408967 = longValue;
                    } //End block
                } //End block
                catch (NumberFormatException e)
                { }
            } //End block
        } //End collapsed parenthetic
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_746436115 = Double.valueOf(literal);
        } //End block
        catch (NumberFormatException ignored)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1162591498 = new String(literal);
        Object varA7E53CE21691AB073D9660D615818899_1215033651; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1215033651 = varB4EAC82CA7396A68D541C85D26508E83_1437642311;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1215033651 = varB4EAC82CA7396A68D541C85D26508E83_1023596370;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1215033651 = varB4EAC82CA7396A68D541C85D26508E83_1525449003;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1215033651 = varB4EAC82CA7396A68D541C85D26508E83_570128481;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1215033651 = varB4EAC82CA7396A68D541C85D26508E83_1136408967;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_1215033651 = varB4EAC82CA7396A68D541C85D26508E83_746436115;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1215033651 = varB4EAC82CA7396A68D541C85D26508E83_1162591498;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1215033651.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1215033651;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.104 -0400", hash_original_method = "593B1F2EF0668764A615A5DB85CFDCCD", hash_generated_method = "4E24FFF6A4E5636761BD8B72E06BC4ED")
    private String nextToInternal(String excluded) {
        String varB4EAC82CA7396A68D541C85D26508E83_514113039 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_927715666 = null; //Variable for return #2
        int start;
        start = pos;
        {
            boolean var06047043A614DB892241E06898F33574_1261508018 = (pos < in.length());
            {
                char c;
                c = in.charAt(pos);
                {
                    boolean var3AFBB0EA2C2EAC586FE2A5174EE77C31_1695808033 = (c == '\r' || c == '\n' || excluded.indexOf(c) != -1);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_514113039 = in.substring(start, pos);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_927715666 = in.substring(start);
        addTaint(excluded.getTaint());
        String varA7E53CE21691AB073D9660D615818899_27539690; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_27539690 = varB4EAC82CA7396A68D541C85D26508E83_514113039;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_27539690 = varB4EAC82CA7396A68D541C85D26508E83_927715666;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_27539690.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_27539690;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.105 -0400", hash_original_method = "D694401380EAF5A76DF87137C67448EA", hash_generated_method = "D58CF840C269ED8B399BFAB6FAC0A29B")
    private JSONObject readObject() throws JSONException {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_1682287953 = null; //Variable for return #1
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_539372014 = null; //Variable for return #2
        JSONObject result;
        result = new JSONObject();
        int first;
        first = nextCleanInternal();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1682287953 = result;
        } //End block
        {
            Object name;
            name = nextValue();
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw syntaxError("Names cannot be null");
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw syntaxError("Names must be strings, but " + name
                            + " is of type " + name.getClass().getName());
                } //End block
            } //End block
            int separator;
            separator = nextCleanInternal();
            {
                if (DroidSafeAndroidRuntime.control) throw syntaxError("Expected ':' after " + name);
            } //End block
            {
                boolean var72E5C3E39CDD2006881A0D60EC0E1A1E_1816969381 = (pos < in.length() && in.charAt(pos) == '>');
            } //End collapsed parenthetic
            result.put((String) name, nextValue());
            {
                Object var35407F991950AD5200888229B2F0259B_765014167 = (nextCleanInternal());
                //Begin case '}' 
                varB4EAC82CA7396A68D541C85D26508E83_539372014 = result;
                //End case '}' 
                //Begin case default 
                if (DroidSafeAndroidRuntime.control) throw syntaxError("Unterminated object");
                //End case default 
            } //End collapsed parenthetic
        } //End block
        JSONObject varA7E53CE21691AB073D9660D615818899_527749385; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_527749385 = varB4EAC82CA7396A68D541C85D26508E83_1682287953;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_527749385 = varB4EAC82CA7396A68D541C85D26508E83_539372014;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_527749385.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_527749385;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.112 -0400", hash_original_method = "E76B205E92636F1E7B3FC6B2B934FE47", hash_generated_method = "9CD7B00D5D8FA1CCB471C6887CD88F35")
    private JSONArray readArray() throws JSONException {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_598985754 = null; //Variable for return #1
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_2140358375 = null; //Variable for return #2
        JSONArray result;
        result = new JSONArray();
        boolean hasTrailingSeparator;
        hasTrailingSeparator = false;
        {
            {
                Object var35407F991950AD5200888229B2F0259B_1467122571 = (nextCleanInternal());
                //Begin case -1 
                if (DroidSafeAndroidRuntime.control) throw syntaxError("Unterminated array");
                //End case -1 
                //Begin case ']' 
                {
                    result.put(null);
                } //End block
                //End case ']' 
                //Begin case ']' 
                varB4EAC82CA7396A68D541C85D26508E83_598985754 = result;
                //End case ']' 
                //Begin case ',' ';' 
                result.put(null);
                //End case ',' ';' 
                //Begin case ',' ';' 
                hasTrailingSeparator = true;
                //End case ',' ';' 
            } //End collapsed parenthetic
            result.put(nextValue());
            {
                Object var35407F991950AD5200888229B2F0259B_115945937 = (nextCleanInternal());
                //Begin case ']' 
                varB4EAC82CA7396A68D541C85D26508E83_2140358375 = result;
                //End case ']' 
                //Begin case ',' ';' 
                hasTrailingSeparator = true;
                //End case ',' ';' 
                //Begin case default 
                if (DroidSafeAndroidRuntime.control) throw syntaxError("Unterminated array");
                //End case default 
            } //End collapsed parenthetic
        } //End block
        JSONArray varA7E53CE21691AB073D9660D615818899_454322417; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_454322417 = varB4EAC82CA7396A68D541C85D26508E83_598985754;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_454322417 = varB4EAC82CA7396A68D541C85D26508E83_2140358375;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_454322417.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_454322417;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.121 -0400", hash_original_method = "33F4C16D40F1C908E16B89E59A552BE8", hash_generated_method = "772BE6FE19163E285D12F9AF62A1DCC1")
    public JSONException syntaxError(String message) {
        JSONException varB4EAC82CA7396A68D541C85D26508E83_898987269 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_898987269 = new JSONException(message + this);
        addTaint(message.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_898987269.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_898987269;
        // ---------- Original Method ----------
        //return new JSONException(message + this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.124 -0400", hash_original_method = "D61A5D8B8E38C1530E1AB8F6DB368DAC", hash_generated_method = "C87F75438EC408C7124B322BFDBAB01F")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1106431009 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1106431009 = " at character " + pos + " of " + in;
        varB4EAC82CA7396A68D541C85D26508E83_1106431009.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1106431009;
        // ---------- Original Method ----------
        //return " at character " + pos + " of " + in;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.124 -0400", hash_original_method = "6281E295952C34947D74AA92CC697B16", hash_generated_method = "72CAF0D2FDFF6932043245A24D841D79")
    public boolean more() {
        boolean varB462DE0FE1ED2D0144387DE6CF6946AC_408189766 = (pos < in.length());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_715691203 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_715691203;
        // ---------- Original Method ----------
        //return pos < in.length();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.125 -0400", hash_original_method = "213D34FB491711CFF086DB4B25220A73", hash_generated_method = "1C5F8CEFFE512F7950BE84A6626FA2E8")
    public char next() {
        {
            boolean var06047043A614DB892241E06898F33574_1512267300 = (pos < in.length());
            Object varB9A5BCC79F60EF8E6A70D7A0EC39D139_393829895 = (in.charAt(pos++));
        } //End flattened ternary
        char varA87DEB01C5F539E6BDA34829C8EF2368_684811533 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_684811533;
        // ---------- Original Method ----------
        //return pos < in.length() ? in.charAt(pos++) : '\0';
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.126 -0400", hash_original_method = "95912FB15799A75254D0EFB27A4965DA", hash_generated_method = "5E92B0783D42AA85CBFC45D14BBD002B")
    public char next(char c) throws JSONException {
        char result;
        result = next();
        {
            if (DroidSafeAndroidRuntime.control) throw syntaxError("Expected " + c + " but was " + result);
        } //End block
        addTaint(c);
        char varA87DEB01C5F539E6BDA34829C8EF2368_336519434 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_336519434;
        // ---------- Original Method ----------
        //char result = next();
        //if (result != c) {
            //throw syntaxError("Expected " + c + " but was " + result);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.133 -0400", hash_original_method = "8888AACA46E7314FC33FB1B59D843324", hash_generated_method = "597DFD23C173CBAA3FAC21758D81FA0A")
    public char nextClean() throws JSONException {
        int nextCleanInt;
        nextCleanInt = nextCleanInternal();
        char varA87DEB01C5F539E6BDA34829C8EF2368_1383693741 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1383693741;
        // ---------- Original Method ----------
        //int nextCleanInt = nextCleanInternal();
        //return nextCleanInt == -1 ? '\0' : (char) nextCleanInt;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.142 -0400", hash_original_method = "9816A4D386531BCA80B95E34249E012D", hash_generated_method = "959C704C612D5CA6021EAF4A5BA7F0C6")
    public String next(int length) throws JSONException {
        String varB4EAC82CA7396A68D541C85D26508E83_2079742566 = null; //Variable for return #1
        {
            boolean var1500402172E845F1F47FE7DDAF72FD84_1706861585 = (pos + length > in.length());
            {
                if (DroidSafeAndroidRuntime.control) throw syntaxError(length + " is out of bounds");
            } //End block
        } //End collapsed parenthetic
        String result;
        result = in.substring(pos, pos + length);
        pos += length;
        varB4EAC82CA7396A68D541C85D26508E83_2079742566 = result;
        varB4EAC82CA7396A68D541C85D26508E83_2079742566.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2079742566;
        // ---------- Original Method ----------
        //if (pos + length > in.length()) {
            //throw syntaxError(length + " is out of bounds");
        //}
        //String result = in.substring(pos, pos + length);
        //pos += length;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.143 -0400", hash_original_method = "EA130CCB3E2CFC0C10CD8E8D4F88F4FA", hash_generated_method = "6AB7D2DDFE5DF4A6A0FB4746FD713307")
    public String nextTo(String excluded) {
        String varB4EAC82CA7396A68D541C85D26508E83_1215371364 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1215371364 = nextToInternal(excluded).trim();
        addTaint(excluded.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1215371364.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1215371364;
        // ---------- Original Method ----------
        //if (excluded == null) {
            //throw new NullPointerException();
        //}
        //return nextToInternal(excluded).trim();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.144 -0400", hash_original_method = "9F2D4FCC02E225188C000422795F1B2D", hash_generated_method = "44D9D98EFBB506B0A0E74F1CB61EE723")
    public String nextTo(char excluded) {
        String varB4EAC82CA7396A68D541C85D26508E83_555521856 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_555521856 = nextToInternal(String.valueOf(excluded)).trim();
        addTaint(excluded);
        varB4EAC82CA7396A68D541C85D26508E83_555521856.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_555521856;
        // ---------- Original Method ----------
        //return nextToInternal(String.valueOf(excluded)).trim();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.159 -0400", hash_original_method = "705EE299D0C421425210CB39FE7F29B9", hash_generated_method = "E05B6C7FA0E950D01CAB849AFB6EA96F")
    public void skipPast(String thru) {
        int thruStart;
        thruStart = in.indexOf(thru, pos);
        pos = thruStart == -1 ? in.length() : (thruStart + thru.length());
        // ---------- Original Method ----------
        //int thruStart = in.indexOf(thru, pos);
        //pos = thruStart == -1 ? in.length() : (thruStart + thru.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.164 -0400", hash_original_method = "A067EA373EE4201A369E9BCAA7E25460", hash_generated_method = "D6737746E6110BEC51A352292722F2B4")
    public char skipTo(char to) {
        int index;
        index = in.indexOf(to, pos);
        {
            pos = index;
        } //End block
        addTaint(to);
        char varA87DEB01C5F539E6BDA34829C8EF2368_488582827 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_488582827;
        // ---------- Original Method ----------
        //int index = in.indexOf(to, pos);
        //if (index != -1) {
            //pos = index;
            //return to;
        //} else {
            //return '\0';
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.164 -0400", hash_original_method = "8E6F2519C4EF5016C5BDFABD97F81370", hash_generated_method = "E69C5655DD65275250CBBCF1D432F901")
    public void back() {
        {
            pos = 0;
        } //End block
        // ---------- Original Method ----------
        //if (--pos == -1) {
            //pos = 0;
        //}
    }

    
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

