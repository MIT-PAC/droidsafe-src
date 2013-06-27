package org.json;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class JSONTokener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.861 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "955F96F6D73BCB070D987B819612F71F")

    private String in;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.861 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.871 -0400", hash_original_method = "F6CFC64A950C47985AB98A953B97554C", hash_generated_method = "AB718541FA7269D44A9033EDC32404DF")
    public  JSONTokener(String in) {
        {
            boolean var0916A8AD1454CFA7BBC4BD929FFC95F8_17833276 = (in != null && in.startsWith("\ufeff"));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.871 -0400", hash_original_method = "B349C062BB24F17BF02BDCB43C03970C", hash_generated_method = "F853AAB6DFD4EA51869698170503B749")
    public Object nextValue() throws JSONException {
        Object varB4EAC82CA7396A68D541C85D26508E83_141459 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1347400447 = null; //Variable for return #2
        Object varB4EAC82CA7396A68D541C85D26508E83_648009284 = null; //Variable for return #3
        Object varB4EAC82CA7396A68D541C85D26508E83_54631313 = null; //Variable for return #4
        int c;
        c = nextCleanInternal();
        //Begin case -1 
        if (DroidSafeAndroidRuntime.control) throw syntaxError("End of input");
        //End case -1 
        //Begin case '{' 
        varB4EAC82CA7396A68D541C85D26508E83_141459 = readObject();
        //End case '{' 
        //Begin case '[' 
        varB4EAC82CA7396A68D541C85D26508E83_1347400447 = readArray();
        //End case '[' 
        //Begin case '\'' '"' 
        varB4EAC82CA7396A68D541C85D26508E83_648009284 = nextString((char) c);
        //End case '\'' '"' 
        //Begin case default 
        varB4EAC82CA7396A68D541C85D26508E83_54631313 = readLiteral();
        //End case default 
        Object varA7E53CE21691AB073D9660D615818899_943278740; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_943278740 = varB4EAC82CA7396A68D541C85D26508E83_141459;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_943278740 = varB4EAC82CA7396A68D541C85D26508E83_1347400447;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_943278740 = varB4EAC82CA7396A68D541C85D26508E83_648009284;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_943278740 = varB4EAC82CA7396A68D541C85D26508E83_54631313;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_943278740.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_943278740;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.872 -0400", hash_original_method = "1C1094F3B0EBF3FC35F6CA7F4976DC54", hash_generated_method = "6B31C18E1F6B7843B045E71BBAB5A7E6")
    private int nextCleanInternal() throws JSONException {
        {
            boolean var06047043A614DB892241E06898F33574_1666597332 = (pos < in.length());
            {
                int c;
                c = in.charAt(pos++);
                //Begin case '/' 
                {
                    boolean varF346F04719233B0A8AE8FE49F5B4F786_1032607777 = (pos == in.length());
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_511887030 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_511887030;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.876 -0400", hash_original_method = "A96A54ECB7E0243FC9401A9259237DF7", hash_generated_method = "1055D16D08F542FC901BDAC9EEE74511")
    private void skipToEndOfLine() {
        {
            boolean var06047043A614DB892241E06898F33574_385378943 = (pos < in.length());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.879 -0400", hash_original_method = "7B01D454BE0369CA1502DDC9AB2083EB", hash_generated_method = "4E1F7EBE58D345BFFDF91871B87411B8")
    public String nextString(char quote) throws JSONException {
        String varB4EAC82CA7396A68D541C85D26508E83_1974721964 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_944017226 = null; //Variable for return #2
        StringBuilder builder;
        builder = null;
        int start;
        start = pos;
        {
            boolean var06047043A614DB892241E06898F33574_1894660693 = (pos < in.length());
            {
                int c;
                c = in.charAt(pos++);
                {
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1974721964 = new String(in.substring(start, pos - 1));
                    } //End block
                    {
                        builder.append(in, start, pos - 1);
                        varB4EAC82CA7396A68D541C85D26508E83_944017226 = builder.toString();
                    } //End block
                } //End block
                {
                    {
                        boolean varBE34942D29178E1181139C06D7AE7E8D_1789461253 = (pos == in.length());
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
        String varA7E53CE21691AB073D9660D615818899_1406003789; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1406003789 = varB4EAC82CA7396A68D541C85D26508E83_1974721964;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1406003789 = varB4EAC82CA7396A68D541C85D26508E83_944017226;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1406003789.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1406003789;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.880 -0400", hash_original_method = "A0F5694EA3978EBF3A8A4E5207628E80", hash_generated_method = "7F7367D0F02FB3367A94827157E609F8")
    private char readEscapeCharacter() throws JSONException {
        char escaped;
        escaped = in.charAt(pos++);
        //Begin case 'u' 
        {
            boolean var424D936A921E9F5F188D1F0C63AC336E_947050186 = (pos + 4 > in.length());
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
        char varD7BED12C29043F5FF01B529F3028A604_1683887794 = ((char) Integer.parseInt(hex, 16));
        //End case 'u' 
        char varA87DEB01C5F539E6BDA34829C8EF2368_1690708613 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1690708613;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.889 -0400", hash_original_method = "921E97B7A015080CE0A01C361479BF49", hash_generated_method = "2229518A91B81DD480D972F35ECF0376")
    private Object readLiteral() throws JSONException {
        Object varB4EAC82CA7396A68D541C85D26508E83_660029271 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1058900026 = null; //Variable for return #2
        Object varB4EAC82CA7396A68D541C85D26508E83_765551706 = null; //Variable for return #3
        Object varB4EAC82CA7396A68D541C85D26508E83_1465404440 = null; //Variable for return #4
        Object varB4EAC82CA7396A68D541C85D26508E83_2069730464 = null; //Variable for return #5
        Object varB4EAC82CA7396A68D541C85D26508E83_2096713389 = null; //Variable for return #6
        Object varB4EAC82CA7396A68D541C85D26508E83_402153054 = null; //Variable for return #7
        String literal;
        literal = nextToInternal("{}[]/\\:,=;# \t\f");
        {
            boolean var2226B848A2ABD4303CB67E9A8790E325_455019709 = (literal.length() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw syntaxError("Expected literal value");
            } //End block
            {
                boolean varE7B73990E47CA66757AE976486FA066E_1649028552 = ("null".equalsIgnoreCase(literal));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_660029271 = JSONObject.NULL;
                } //End block
                {
                    boolean var0F62A1A944013BA459EE135E16EB4002_1780192599 = ("true".equalsIgnoreCase(literal));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1058900026 = Boolean.TRUE;
                    } //End block
                    {
                        boolean var250365B2F3AE6CA4568AA76CE00BEEEE_989747521 = ("false".equalsIgnoreCase(literal));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_765551706 = Boolean.FALSE;
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            boolean varFF6E99342D1FEA616C0B8E78FAFB13F8_146307912 = (literal.indexOf('.') == -1);
            {
                int base;
                base = 10;
                String number;
                number = literal;
                {
                    boolean var23DA3B05608ECFB50FED05F3B5EFE228_906552393 = (number.startsWith("0x") || number.startsWith("0X"));
                    {
                        number = number.substring(2);
                        base = 16;
                    } //End block
                    {
                        boolean varECB1F3363AA5C8D13B35551E8BC5CC45_1201462456 = (number.startsWith("0") && number.length() > 1);
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
                        varB4EAC82CA7396A68D541C85D26508E83_1465404440 = (int) longValue;
                    } //End block
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_2069730464 = longValue;
                    } //End block
                } //End block
                catch (NumberFormatException e)
                { }
            } //End block
        } //End collapsed parenthetic
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2096713389 = Double.valueOf(literal);
        } //End block
        catch (NumberFormatException ignored)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_402153054 = new String(literal);
        Object varA7E53CE21691AB073D9660D615818899_206287068; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_206287068 = varB4EAC82CA7396A68D541C85D26508E83_660029271;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_206287068 = varB4EAC82CA7396A68D541C85D26508E83_1058900026;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_206287068 = varB4EAC82CA7396A68D541C85D26508E83_765551706;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_206287068 = varB4EAC82CA7396A68D541C85D26508E83_1465404440;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_206287068 = varB4EAC82CA7396A68D541C85D26508E83_2069730464;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_206287068 = varB4EAC82CA7396A68D541C85D26508E83_2096713389;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_206287068 = varB4EAC82CA7396A68D541C85D26508E83_402153054;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_206287068.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_206287068;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.890 -0400", hash_original_method = "593B1F2EF0668764A615A5DB85CFDCCD", hash_generated_method = "2E078FF89053B910F8C8C8E9971C989B")
    private String nextToInternal(String excluded) {
        String varB4EAC82CA7396A68D541C85D26508E83_1936455613 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1546740147 = null; //Variable for return #2
        int start;
        start = pos;
        {
            boolean var06047043A614DB892241E06898F33574_1298596200 = (pos < in.length());
            {
                char c;
                c = in.charAt(pos);
                {
                    boolean var3AFBB0EA2C2EAC586FE2A5174EE77C31_2065573136 = (c == '\r' || c == '\n' || excluded.indexOf(c) != -1);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1936455613 = in.substring(start, pos);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1546740147 = in.substring(start);
        addTaint(excluded.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1843664088; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1843664088 = varB4EAC82CA7396A68D541C85D26508E83_1936455613;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1843664088 = varB4EAC82CA7396A68D541C85D26508E83_1546740147;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1843664088.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1843664088;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.892 -0400", hash_original_method = "D694401380EAF5A76DF87137C67448EA", hash_generated_method = "66B366C12CB00D85993210EFDC785B48")
    private JSONObject readObject() throws JSONException {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_1961868010 = null; //Variable for return #1
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_1688917313 = null; //Variable for return #2
        JSONObject result;
        result = new JSONObject();
        int first;
        first = nextCleanInternal();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1961868010 = result;
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
                boolean var72E5C3E39CDD2006881A0D60EC0E1A1E_1289591872 = (pos < in.length() && in.charAt(pos) == '>');
            } //End collapsed parenthetic
            result.put((String) name, nextValue());
            {
                Object var35407F991950AD5200888229B2F0259B_1070283787 = (nextCleanInternal());
                //Begin case '}' 
                varB4EAC82CA7396A68D541C85D26508E83_1688917313 = result;
                //End case '}' 
                //Begin case default 
                if (DroidSafeAndroidRuntime.control) throw syntaxError("Unterminated object");
                //End case default 
            } //End collapsed parenthetic
        } //End block
        JSONObject varA7E53CE21691AB073D9660D615818899_1095750764; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1095750764 = varB4EAC82CA7396A68D541C85D26508E83_1961868010;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1095750764 = varB4EAC82CA7396A68D541C85D26508E83_1688917313;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1095750764.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1095750764;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.894 -0400", hash_original_method = "E76B205E92636F1E7B3FC6B2B934FE47", hash_generated_method = "C6DBC55DDE2824296CAC0ECF1E6C0061")
    private JSONArray readArray() throws JSONException {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_550516938 = null; //Variable for return #1
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_1352767541 = null; //Variable for return #2
        JSONArray result;
        result = new JSONArray();
        boolean hasTrailingSeparator;
        hasTrailingSeparator = false;
        {
            {
                Object var35407F991950AD5200888229B2F0259B_898629869 = (nextCleanInternal());
                //Begin case -1 
                if (DroidSafeAndroidRuntime.control) throw syntaxError("Unterminated array");
                //End case -1 
                //Begin case ']' 
                {
                    result.put(null);
                } //End block
                //End case ']' 
                //Begin case ']' 
                varB4EAC82CA7396A68D541C85D26508E83_550516938 = result;
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
                Object var35407F991950AD5200888229B2F0259B_330143806 = (nextCleanInternal());
                //Begin case ']' 
                varB4EAC82CA7396A68D541C85D26508E83_1352767541 = result;
                //End case ']' 
                //Begin case ',' ';' 
                hasTrailingSeparator = true;
                //End case ',' ';' 
                //Begin case default 
                if (DroidSafeAndroidRuntime.control) throw syntaxError("Unterminated array");
                //End case default 
            } //End collapsed parenthetic
        } //End block
        JSONArray varA7E53CE21691AB073D9660D615818899_1998179463; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1998179463 = varB4EAC82CA7396A68D541C85D26508E83_550516938;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1998179463 = varB4EAC82CA7396A68D541C85D26508E83_1352767541;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1998179463.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1998179463;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.894 -0400", hash_original_method = "33F4C16D40F1C908E16B89E59A552BE8", hash_generated_method = "BA7305C9D75B258F9AD0B8906FA9CE23")
    public JSONException syntaxError(String message) {
        JSONException varB4EAC82CA7396A68D541C85D26508E83_12257683 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_12257683 = new JSONException(message + this);
        addTaint(message.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_12257683.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_12257683;
        // ---------- Original Method ----------
        //return new JSONException(message + this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.904 -0400", hash_original_method = "D61A5D8B8E38C1530E1AB8F6DB368DAC", hash_generated_method = "1CC78BC034326199FCC36087F1E5EC97")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1637553001 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1637553001 = " at character " + pos + " of " + in;
        varB4EAC82CA7396A68D541C85D26508E83_1637553001.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1637553001;
        // ---------- Original Method ----------
        //return " at character " + pos + " of " + in;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.904 -0400", hash_original_method = "6281E295952C34947D74AA92CC697B16", hash_generated_method = "AEE411BA8DEF896EED27509C0AB47813")
    public boolean more() {
        boolean varB462DE0FE1ED2D0144387DE6CF6946AC_2126325248 = (pos < in.length());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1450733137 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1450733137;
        // ---------- Original Method ----------
        //return pos < in.length();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.905 -0400", hash_original_method = "213D34FB491711CFF086DB4B25220A73", hash_generated_method = "0C2AF65C3AAF5567EBAAE200D8B4C65F")
    public char next() {
        {
            boolean var06047043A614DB892241E06898F33574_75095003 = (pos < in.length());
            Object varB9A5BCC79F60EF8E6A70D7A0EC39D139_1747294544 = (in.charAt(pos++));
        } //End flattened ternary
        char varA87DEB01C5F539E6BDA34829C8EF2368_1881740227 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1881740227;
        // ---------- Original Method ----------
        //return pos < in.length() ? in.charAt(pos++) : '\0';
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.905 -0400", hash_original_method = "95912FB15799A75254D0EFB27A4965DA", hash_generated_method = "E5CF783BE12CE2DCA1FF161BCC229C39")
    public char next(char c) throws JSONException {
        char result;
        result = next();
        {
            if (DroidSafeAndroidRuntime.control) throw syntaxError("Expected " + c + " but was " + result);
        } //End block
        addTaint(c);
        char varA87DEB01C5F539E6BDA34829C8EF2368_945891377 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_945891377;
        // ---------- Original Method ----------
        //char result = next();
        //if (result != c) {
            //throw syntaxError("Expected " + c + " but was " + result);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.905 -0400", hash_original_method = "8888AACA46E7314FC33FB1B59D843324", hash_generated_method = "FD6BB4B34D076D86775D2D9236F1B8C9")
    public char nextClean() throws JSONException {
        int nextCleanInt;
        nextCleanInt = nextCleanInternal();
        char varA87DEB01C5F539E6BDA34829C8EF2368_1511579551 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1511579551;
        // ---------- Original Method ----------
        //int nextCleanInt = nextCleanInternal();
        //return nextCleanInt == -1 ? '\0' : (char) nextCleanInt;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.906 -0400", hash_original_method = "9816A4D386531BCA80B95E34249E012D", hash_generated_method = "7320246E22E926A55A3DE99B848986C5")
    public String next(int length) throws JSONException {
        String varB4EAC82CA7396A68D541C85D26508E83_1147226015 = null; //Variable for return #1
        {
            boolean var1500402172E845F1F47FE7DDAF72FD84_1436800446 = (pos + length > in.length());
            {
                if (DroidSafeAndroidRuntime.control) throw syntaxError(length + " is out of bounds");
            } //End block
        } //End collapsed parenthetic
        String result;
        result = in.substring(pos, pos + length);
        pos += length;
        varB4EAC82CA7396A68D541C85D26508E83_1147226015 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1147226015.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1147226015;
        // ---------- Original Method ----------
        //if (pos + length > in.length()) {
            //throw syntaxError(length + " is out of bounds");
        //}
        //String result = in.substring(pos, pos + length);
        //pos += length;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.907 -0400", hash_original_method = "EA130CCB3E2CFC0C10CD8E8D4F88F4FA", hash_generated_method = "91595CEA5183B54DAA3A6AE289468E2D")
    public String nextTo(String excluded) {
        String varB4EAC82CA7396A68D541C85D26508E83_302285050 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_302285050 = nextToInternal(excluded).trim();
        addTaint(excluded.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_302285050.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_302285050;
        // ---------- Original Method ----------
        //if (excluded == null) {
            //throw new NullPointerException();
        //}
        //return nextToInternal(excluded).trim();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.907 -0400", hash_original_method = "9F2D4FCC02E225188C000422795F1B2D", hash_generated_method = "1F0F202F57E53921CCD55483457F6F12")
    public String nextTo(char excluded) {
        String varB4EAC82CA7396A68D541C85D26508E83_1538296307 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1538296307 = nextToInternal(String.valueOf(excluded)).trim();
        addTaint(excluded);
        varB4EAC82CA7396A68D541C85D26508E83_1538296307.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1538296307;
        // ---------- Original Method ----------
        //return nextToInternal(String.valueOf(excluded)).trim();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.912 -0400", hash_original_method = "705EE299D0C421425210CB39FE7F29B9", hash_generated_method = "E05B6C7FA0E950D01CAB849AFB6EA96F")
    public void skipPast(String thru) {
        int thruStart;
        thruStart = in.indexOf(thru, pos);
        pos = thruStart == -1 ? in.length() : (thruStart + thru.length());
        // ---------- Original Method ----------
        //int thruStart = in.indexOf(thru, pos);
        //pos = thruStart == -1 ? in.length() : (thruStart + thru.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.917 -0400", hash_original_method = "A067EA373EE4201A369E9BCAA7E25460", hash_generated_method = "57F6BCD194405AF9E743BA542161F364")
    public char skipTo(char to) {
        int index;
        index = in.indexOf(to, pos);
        {
            pos = index;
        } //End block
        addTaint(to);
        char varA87DEB01C5F539E6BDA34829C8EF2368_1638660020 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1638660020;
        // ---------- Original Method ----------
        //int index = in.indexOf(to, pos);
        //if (index != -1) {
            //pos = index;
            //return to;
        //} else {
            //return '\0';
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.918 -0400", hash_original_method = "8E6F2519C4EF5016C5BDFABD97F81370", hash_generated_method = "E69C5655DD65275250CBBCF1D432F901")
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

