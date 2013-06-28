package org.json;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class JSONTokener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.390 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "955F96F6D73BCB070D987B819612F71F")

    private String in;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.390 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.391 -0400", hash_original_method = "F6CFC64A950C47985AB98A953B97554C", hash_generated_method = "90925A6481B9C128C5D1645466E105CA")
    public  JSONTokener(String in) {
        {
            boolean var0916A8AD1454CFA7BBC4BD929FFC95F8_426148848 = (in != null && in.startsWith("\ufeff"));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.392 -0400", hash_original_method = "B349C062BB24F17BF02BDCB43C03970C", hash_generated_method = "97FB56E60AE256608CA615603805CE2A")
    public Object nextValue() throws JSONException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1445127618 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1079779561 = null; //Variable for return #2
        Object varB4EAC82CA7396A68D541C85D26508E83_1294139627 = null; //Variable for return #3
        Object varB4EAC82CA7396A68D541C85D26508E83_970641802 = null; //Variable for return #4
        int c = nextCleanInternal();
        //Begin case -1 
        if (DroidSafeAndroidRuntime.control) throw syntaxError("End of input");
        //End case -1 
        //Begin case '{' 
        varB4EAC82CA7396A68D541C85D26508E83_1445127618 = readObject();
        //End case '{' 
        //Begin case '[' 
        varB4EAC82CA7396A68D541C85D26508E83_1079779561 = readArray();
        //End case '[' 
        //Begin case '\'' '"' 
        varB4EAC82CA7396A68D541C85D26508E83_1294139627 = nextString((char) c);
        //End case '\'' '"' 
        //Begin case default 
        varB4EAC82CA7396A68D541C85D26508E83_970641802 = readLiteral();
        //End case default 
        Object varA7E53CE21691AB073D9660D615818899_1691554272; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1691554272 = varB4EAC82CA7396A68D541C85D26508E83_1445127618;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1691554272 = varB4EAC82CA7396A68D541C85D26508E83_1079779561;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1691554272 = varB4EAC82CA7396A68D541C85D26508E83_1294139627;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1691554272 = varB4EAC82CA7396A68D541C85D26508E83_970641802;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1691554272.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1691554272;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.392 -0400", hash_original_method = "1C1094F3B0EBF3FC35F6CA7F4976DC54", hash_generated_method = "282857D2D0439660BD58E6F22686D08A")
    private int nextCleanInternal() throws JSONException {
        {
            boolean var06047043A614DB892241E06898F33574_2070438316 = (pos < in.length());
            {
                int c = in.charAt(pos++);
                //Begin case '/' 
                {
                    boolean varF346F04719233B0A8AE8FE49F5B4F786_966309706 = (pos == in.length());
                } //End collapsed parenthetic
                //End case '/' 
                //Begin case '/' 
                char peek = in.charAt(pos);
                //End case '/' 
                //Begin case '/' 
                //Begin case '*' 
                int commentEnd = in.indexOf("*/", pos);
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1297095070 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1297095070;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.393 -0400", hash_original_method = "A96A54ECB7E0243FC9401A9259237DF7", hash_generated_method = "4DA1CB47AEB0EB344B4C94FC802526B0")
    private void skipToEndOfLine() {
        {
            boolean var06047043A614DB892241E06898F33574_771802281 = (pos < in.length());
            {
                char c = in.charAt(pos);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.395 -0400", hash_original_method = "7B01D454BE0369CA1502DDC9AB2083EB", hash_generated_method = "E03830FE5753952D0AEE9B3FC5B7ABE1")
    public String nextString(char quote) throws JSONException {
        String varB4EAC82CA7396A68D541C85D26508E83_193199422 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_568372803 = null; //Variable for return #2
        StringBuilder builder = null;
        int start = pos;
        {
            boolean var06047043A614DB892241E06898F33574_537977649 = (pos < in.length());
            {
                int c = in.charAt(pos++);
                {
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_193199422 = new String(in.substring(start, pos - 1));
                    } //End block
                    {
                        builder.append(in, start, pos - 1);
                        varB4EAC82CA7396A68D541C85D26508E83_568372803 = builder.toString();
                    } //End block
                } //End block
                {
                    {
                        boolean varBE34942D29178E1181139C06D7AE7E8D_450386709 = (pos == in.length());
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
        String varA7E53CE21691AB073D9660D615818899_469990333; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_469990333 = varB4EAC82CA7396A68D541C85D26508E83_193199422;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_469990333 = varB4EAC82CA7396A68D541C85D26508E83_568372803;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_469990333.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_469990333;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.395 -0400", hash_original_method = "A0F5694EA3978EBF3A8A4E5207628E80", hash_generated_method = "9EEBB9916920202F6D9145E09B32B932")
    private char readEscapeCharacter() throws JSONException {
        char escaped = in.charAt(pos++);
        //Begin case 'u' 
        {
            boolean var424D936A921E9F5F188D1F0C63AC336E_502983583 = (pos + 4 > in.length());
            {
                if (DroidSafeAndroidRuntime.control) throw syntaxError("Unterminated escape sequence");
            } //End block
        } //End collapsed parenthetic
        //End case 'u' 
        //Begin case 'u' 
        String hex = in.substring(pos, pos + 4);
        //End case 'u' 
        //Begin case 'u' 
        pos += 4;
        //End case 'u' 
        //Begin case 'u' 
        char varD7BED12C29043F5FF01B529F3028A604_1757680569 = ((char) Integer.parseInt(hex, 16));
        //End case 'u' 
        char varA87DEB01C5F539E6BDA34829C8EF2368_410801302 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_410801302;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.398 -0400", hash_original_method = "921E97B7A015080CE0A01C361479BF49", hash_generated_method = "30F38CC8DC40ADD5A4BB8AADF54F17DF")
    private Object readLiteral() throws JSONException {
        Object varB4EAC82CA7396A68D541C85D26508E83_2092970618 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1306469924 = null; //Variable for return #2
        Object varB4EAC82CA7396A68D541C85D26508E83_421806999 = null; //Variable for return #3
        Object varB4EAC82CA7396A68D541C85D26508E83_127130272 = null; //Variable for return #4
        Object varB4EAC82CA7396A68D541C85D26508E83_1282013944 = null; //Variable for return #5
        Object varB4EAC82CA7396A68D541C85D26508E83_558237046 = null; //Variable for return #6
        Object varB4EAC82CA7396A68D541C85D26508E83_178242386 = null; //Variable for return #7
        String literal = nextToInternal("{}[]/\\:,=;# \t\f");
        {
            boolean var2226B848A2ABD4303CB67E9A8790E325_166591256 = (literal.length() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw syntaxError("Expected literal value");
            } //End block
            {
                boolean varE7B73990E47CA66757AE976486FA066E_1427367097 = ("null".equalsIgnoreCase(literal));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_2092970618 = JSONObject.NULL;
                } //End block
                {
                    boolean var0F62A1A944013BA459EE135E16EB4002_2133805658 = ("true".equalsIgnoreCase(literal));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1306469924 = Boolean.TRUE;
                    } //End block
                    {
                        boolean var250365B2F3AE6CA4568AA76CE00BEEEE_1268348417 = ("false".equalsIgnoreCase(literal));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_421806999 = Boolean.FALSE;
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            boolean varFF6E99342D1FEA616C0B8E78FAFB13F8_1380878389 = (literal.indexOf('.') == -1);
            {
                int base = 10;
                String number = literal;
                {
                    boolean var23DA3B05608ECFB50FED05F3B5EFE228_400712847 = (number.startsWith("0x") || number.startsWith("0X"));
                    {
                        number = number.substring(2);
                        base = 16;
                    } //End block
                    {
                        boolean varECB1F3363AA5C8D13B35551E8BC5CC45_1761169427 = (number.startsWith("0") && number.length() > 1);
                        {
                            number = number.substring(1);
                            base = 8;
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
                try 
                {
                    long longValue = Long.parseLong(number, base);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_127130272 = (int) longValue;
                    } //End block
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1282013944 = longValue;
                    } //End block
                } //End block
                catch (NumberFormatException e)
                { }
            } //End block
        } //End collapsed parenthetic
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_558237046 = Double.valueOf(literal);
        } //End block
        catch (NumberFormatException ignored)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_178242386 = new String(literal);
        Object varA7E53CE21691AB073D9660D615818899_541577127; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_541577127 = varB4EAC82CA7396A68D541C85D26508E83_2092970618;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_541577127 = varB4EAC82CA7396A68D541C85D26508E83_1306469924;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_541577127 = varB4EAC82CA7396A68D541C85D26508E83_421806999;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_541577127 = varB4EAC82CA7396A68D541C85D26508E83_127130272;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_541577127 = varB4EAC82CA7396A68D541C85D26508E83_1282013944;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_541577127 = varB4EAC82CA7396A68D541C85D26508E83_558237046;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_541577127 = varB4EAC82CA7396A68D541C85D26508E83_178242386;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_541577127.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_541577127;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.399 -0400", hash_original_method = "593B1F2EF0668764A615A5DB85CFDCCD", hash_generated_method = "A8D7D10128090452FF2CB1FAF6B8C505")
    private String nextToInternal(String excluded) {
        String varB4EAC82CA7396A68D541C85D26508E83_879709593 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1133291820 = null; //Variable for return #2
        int start = pos;
        {
            boolean var06047043A614DB892241E06898F33574_1820807985 = (pos < in.length());
            {
                char c = in.charAt(pos);
                {
                    boolean var3AFBB0EA2C2EAC586FE2A5174EE77C31_1951416495 = (c == '\r' || c == '\n' || excluded.indexOf(c) != -1);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_879709593 = in.substring(start, pos);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1133291820 = in.substring(start);
        addTaint(excluded.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1550799444; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1550799444 = varB4EAC82CA7396A68D541C85D26508E83_879709593;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1550799444 = varB4EAC82CA7396A68D541C85D26508E83_1133291820;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1550799444.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1550799444;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.400 -0400", hash_original_method = "D694401380EAF5A76DF87137C67448EA", hash_generated_method = "57C74E00AE5D4EED3E57A0256A0F3861")
    private JSONObject readObject() throws JSONException {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_775301560 = null; //Variable for return #1
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_1630914220 = null; //Variable for return #2
        JSONObject result = new JSONObject();
        int first = nextCleanInternal();
        {
            varB4EAC82CA7396A68D541C85D26508E83_775301560 = result;
        } //End block
        {
            Object name = nextValue();
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw syntaxError("Names cannot be null");
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw syntaxError("Names must be strings, but " + name
                            + " is of type " + name.getClass().getName());
                } //End block
            } //End block
            int separator = nextCleanInternal();
            {
                if (DroidSafeAndroidRuntime.control) throw syntaxError("Expected ':' after " + name);
            } //End block
            {
                boolean var72E5C3E39CDD2006881A0D60EC0E1A1E_159130027 = (pos < in.length() && in.charAt(pos) == '>');
            } //End collapsed parenthetic
            result.put((String) name, nextValue());
            {
                Object var35407F991950AD5200888229B2F0259B_1267118301 = (nextCleanInternal());
                //Begin case '}' 
                varB4EAC82CA7396A68D541C85D26508E83_1630914220 = result;
                //End case '}' 
                //Begin case default 
                if (DroidSafeAndroidRuntime.control) throw syntaxError("Unterminated object");
                //End case default 
            } //End collapsed parenthetic
        } //End block
        JSONObject varA7E53CE21691AB073D9660D615818899_1068779444; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1068779444 = varB4EAC82CA7396A68D541C85D26508E83_775301560;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1068779444 = varB4EAC82CA7396A68D541C85D26508E83_1630914220;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1068779444.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1068779444;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.400 -0400", hash_original_method = "E76B205E92636F1E7B3FC6B2B934FE47", hash_generated_method = "CD4D9DF50200CE0820673A4DAD7EED79")
    private JSONArray readArray() throws JSONException {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_1210331329 = null; //Variable for return #1
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_1174330308 = null; //Variable for return #2
        JSONArray result = new JSONArray();
        boolean hasTrailingSeparator = false;
        {
            {
                Object var35407F991950AD5200888229B2F0259B_1122347969 = (nextCleanInternal());
                //Begin case -1 
                if (DroidSafeAndroidRuntime.control) throw syntaxError("Unterminated array");
                //End case -1 
                //Begin case ']' 
                {
                    result.put(null);
                } //End block
                //End case ']' 
                //Begin case ']' 
                varB4EAC82CA7396A68D541C85D26508E83_1210331329 = result;
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
                Object var35407F991950AD5200888229B2F0259B_445580539 = (nextCleanInternal());
                //Begin case ']' 
                varB4EAC82CA7396A68D541C85D26508E83_1174330308 = result;
                //End case ']' 
                //Begin case ',' ';' 
                hasTrailingSeparator = true;
                //End case ',' ';' 
                //Begin case default 
                if (DroidSafeAndroidRuntime.control) throw syntaxError("Unterminated array");
                //End case default 
            } //End collapsed parenthetic
        } //End block
        JSONArray varA7E53CE21691AB073D9660D615818899_1807399630; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1807399630 = varB4EAC82CA7396A68D541C85D26508E83_1210331329;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1807399630 = varB4EAC82CA7396A68D541C85D26508E83_1174330308;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1807399630.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1807399630;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.401 -0400", hash_original_method = "33F4C16D40F1C908E16B89E59A552BE8", hash_generated_method = "7EAD31613B7E6530971C18EF996E2C41")
    public JSONException syntaxError(String message) {
        JSONException varB4EAC82CA7396A68D541C85D26508E83_2122335435 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2122335435 = new JSONException(message + this);
        addTaint(message.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2122335435.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2122335435;
        // ---------- Original Method ----------
        //return new JSONException(message + this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.402 -0400", hash_original_method = "D61A5D8B8E38C1530E1AB8F6DB368DAC", hash_generated_method = "353571A35BCC0181ACFED0E089ADE895")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1658284168 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1658284168 = " at character " + pos + " of " + in;
        varB4EAC82CA7396A68D541C85D26508E83_1658284168.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1658284168;
        // ---------- Original Method ----------
        //return " at character " + pos + " of " + in;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.403 -0400", hash_original_method = "6281E295952C34947D74AA92CC697B16", hash_generated_method = "A1F13EB59DF1AE7A0603A384D4C92699")
    public boolean more() {
        boolean varB462DE0FE1ED2D0144387DE6CF6946AC_2057386932 = (pos < in.length());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1966527206 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1966527206;
        // ---------- Original Method ----------
        //return pos < in.length();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.404 -0400", hash_original_method = "213D34FB491711CFF086DB4B25220A73", hash_generated_method = "7BF4D580546786A941D8C02E7182B471")
    public char next() {
        {
            boolean var06047043A614DB892241E06898F33574_331521970 = (pos < in.length());
            Object varB9A5BCC79F60EF8E6A70D7A0EC39D139_848661867 = (in.charAt(pos++));
        } //End flattened ternary
        char varA87DEB01C5F539E6BDA34829C8EF2368_1331786984 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1331786984;
        // ---------- Original Method ----------
        //return pos < in.length() ? in.charAt(pos++) : '\0';
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.405 -0400", hash_original_method = "95912FB15799A75254D0EFB27A4965DA", hash_generated_method = "DB1B061DDE48264F2193B2086FFD7701")
    public char next(char c) throws JSONException {
        char result = next();
        {
            if (DroidSafeAndroidRuntime.control) throw syntaxError("Expected " + c + " but was " + result);
        } //End block
        addTaint(c);
        char varA87DEB01C5F539E6BDA34829C8EF2368_1694558699 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1694558699;
        // ---------- Original Method ----------
        //char result = next();
        //if (result != c) {
            //throw syntaxError("Expected " + c + " but was " + result);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.406 -0400", hash_original_method = "8888AACA46E7314FC33FB1B59D843324", hash_generated_method = "4B12E01E1B87B97767191F256CD89F1F")
    public char nextClean() throws JSONException {
        int nextCleanInt = nextCleanInternal();
        char varA87DEB01C5F539E6BDA34829C8EF2368_1795933969 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1795933969;
        // ---------- Original Method ----------
        //int nextCleanInt = nextCleanInternal();
        //return nextCleanInt == -1 ? '\0' : (char) nextCleanInt;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.407 -0400", hash_original_method = "9816A4D386531BCA80B95E34249E012D", hash_generated_method = "F052B4A9A72A1F208B79AD3BF77B534F")
    public String next(int length) throws JSONException {
        String varB4EAC82CA7396A68D541C85D26508E83_1175185769 = null; //Variable for return #1
        {
            boolean var1500402172E845F1F47FE7DDAF72FD84_1192228051 = (pos + length > in.length());
            {
                if (DroidSafeAndroidRuntime.control) throw syntaxError(length + " is out of bounds");
            } //End block
        } //End collapsed parenthetic
        String result = in.substring(pos, pos + length);
        pos += length;
        varB4EAC82CA7396A68D541C85D26508E83_1175185769 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1175185769.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1175185769;
        // ---------- Original Method ----------
        //if (pos + length > in.length()) {
            //throw syntaxError(length + " is out of bounds");
        //}
        //String result = in.substring(pos, pos + length);
        //pos += length;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.409 -0400", hash_original_method = "EA130CCB3E2CFC0C10CD8E8D4F88F4FA", hash_generated_method = "B0488B2E7C7C1BC29505A80881EBE221")
    public String nextTo(String excluded) {
        String varB4EAC82CA7396A68D541C85D26508E83_443359811 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_443359811 = nextToInternal(excluded).trim();
        addTaint(excluded.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_443359811.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_443359811;
        // ---------- Original Method ----------
        //if (excluded == null) {
            //throw new NullPointerException();
        //}
        //return nextToInternal(excluded).trim();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.413 -0400", hash_original_method = "9F2D4FCC02E225188C000422795F1B2D", hash_generated_method = "18093573B38036EF7342ADEB7849BEF4")
    public String nextTo(char excluded) {
        String varB4EAC82CA7396A68D541C85D26508E83_2003367148 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2003367148 = nextToInternal(String.valueOf(excluded)).trim();
        addTaint(excluded);
        varB4EAC82CA7396A68D541C85D26508E83_2003367148.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2003367148;
        // ---------- Original Method ----------
        //return nextToInternal(String.valueOf(excluded)).trim();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.414 -0400", hash_original_method = "705EE299D0C421425210CB39FE7F29B9", hash_generated_method = "B2B1ACF8EB2757FC38F81E6EFBD0A715")
    public void skipPast(String thru) {
        int thruStart = in.indexOf(thru, pos);
        pos = thruStart == -1 ? in.length() : (thruStart + thru.length());
        // ---------- Original Method ----------
        //int thruStart = in.indexOf(thru, pos);
        //pos = thruStart == -1 ? in.length() : (thruStart + thru.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.415 -0400", hash_original_method = "A067EA373EE4201A369E9BCAA7E25460", hash_generated_method = "21FCDBFADD5E194E027B37834B531689")
    public char skipTo(char to) {
        int index = in.indexOf(to, pos);
        {
            pos = index;
        } //End block
        addTaint(to);
        char varA87DEB01C5F539E6BDA34829C8EF2368_629312043 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_629312043;
        // ---------- Original Method ----------
        //int index = in.indexOf(to, pos);
        //if (index != -1) {
            //pos = index;
            //return to;
        //} else {
            //return '\0';
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.416 -0400", hash_original_method = "8E6F2519C4EF5016C5BDFABD97F81370", hash_generated_method = "E69C5655DD65275250CBBCF1D432F901")
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

