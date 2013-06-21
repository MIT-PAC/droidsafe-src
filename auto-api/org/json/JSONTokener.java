package org.json;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class JSONTokener {
    private String in;
    private int pos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.221 -0400", hash_original_method = "F6CFC64A950C47985AB98A953B97554C", hash_generated_method = "04EAF62B2D91AFACB5A5F2C32CFC01E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONTokener(String in) {
        dsTaint.addTaint(in);
        {
            boolean var0916A8AD1454CFA7BBC4BD929FFC95F8_1785462872 = (in != null && in.startsWith("\ufeff"));
            {
                in = in.substring(1);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (in != null && in.startsWith("\ufeff")) {
            //in = in.substring(1);
        //}
        //this.in = in;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.221 -0400", hash_original_method = "B349C062BB24F17BF02BDCB43C03970C", hash_generated_method = "D4F663F06F4FA411369AF49F67BB5026")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object nextValue() throws JSONException {
        int c;
        c = nextCleanInternal();
        //Begin case -1 
        if (DroidSafeAndroidRuntime.control) throw syntaxError("End of input");
        //End case -1 
        //Begin case '{' 
        Object var0F7B7189E6D34A50A760244DCACBBB03_1617184711 = (readObject());
        //End case '{' 
        //Begin case '[' 
        Object var36631BAF11CD2804EE736F545CAE27B6_215227165 = (readArray());
        //End case '[' 
        //Begin case '\'' '"' 
        Object var16C61374F5DA2402BFA2EBA9A72EFBDD_1121807877 = (nextString((char) c));
        //End case '\'' '"' 
        //Begin case default 
        Object var20A0A529005B204A4026EF129499EA8A_488660772 = (readLiteral());
        //End case default 
        return (Object)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.221 -0400", hash_original_method = "1C1094F3B0EBF3FC35F6CA7F4976DC54", hash_generated_method = "97706CDB107FB973426A47353A7278AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nextCleanInternal() throws JSONException {
        {
            boolean var06047043A614DB892241E06898F33574_2015419945 = (pos < in.length());
            {
                int c;
                c = in.charAt(pos++);
                //Begin case '/' 
                {
                    boolean varF346F04719233B0A8AE8FE49F5B4F786_1548434945 = (pos == in.length());
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.222 -0400", hash_original_method = "A96A54ECB7E0243FC9401A9259237DF7", hash_generated_method = "29963C8159D6E755B5D3205097FD5E63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void skipToEndOfLine() {
        {
            boolean var06047043A614DB892241E06898F33574_22983325 = (pos < in.length());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.222 -0400", hash_original_method = "7B01D454BE0369CA1502DDC9AB2083EB", hash_generated_method = "1AD800E58EBEE8CD9D550CF77D5FAFE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String nextString(char quote) throws JSONException {
        dsTaint.addTaint(quote);
        StringBuilder builder;
        builder = null;
        int start;
        start = pos;
        {
            boolean var06047043A614DB892241E06898F33574_55923981 = (pos < in.length());
            {
                int c;
                c = in.charAt(pos++);
                {
                    {
                        String varB3158F935C380262E08709A7D0A2151C_2014171709 = (new String(in.substring(start, pos - 1)));
                    } //End block
                    {
                        builder.append(in, start, pos - 1);
                        String var6A24CCC1CFE3D93416D53FFFFAEED471_2085469614 = (builder.toString());
                    } //End block
                } //End block
                {
                    {
                        boolean varBE34942D29178E1181139C06D7AE7E8D_781641701 = (pos == in.length());
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
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.222 -0400", hash_original_method = "A0F5694EA3978EBF3A8A4E5207628E80", hash_generated_method = "6704ECAB7AD275F392B3FCC242772D24")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private char readEscapeCharacter() throws JSONException {
        char escaped;
        escaped = in.charAt(pos++);
        //Begin case 'u' 
        {
            boolean var424D936A921E9F5F188D1F0C63AC336E_271593618 = (pos + 4 > in.length());
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
        char varD7BED12C29043F5FF01B529F3028A604_758055181 = ((char) Integer.parseInt(hex, 16));
        //End case 'u' 
        return dsTaint.getTaintChar();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.223 -0400", hash_original_method = "921E97B7A015080CE0A01C361479BF49", hash_generated_method = "434D5A74C2542A1BD8DC5513B2D1D684")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Object readLiteral() throws JSONException {
        String literal;
        literal = nextToInternal("{}[]/\\:,=;# \t\f");
        {
            boolean var2226B848A2ABD4303CB67E9A8790E325_1024259447 = (literal.length() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw syntaxError("Expected literal value");
            } //End block
            {
                boolean varE7B73990E47CA66757AE976486FA066E_1692542305 = ("null".equalsIgnoreCase(literal));
                {
                    boolean var0F62A1A944013BA459EE135E16EB4002_2063222289 = ("true".equalsIgnoreCase(literal));
                    {
                        boolean var250365B2F3AE6CA4568AA76CE00BEEEE_1562335540 = ("false".equalsIgnoreCase(literal));
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            boolean varFF6E99342D1FEA616C0B8E78FAFB13F8_1141383693 = (literal.indexOf('.') == -1);
            {
                int base;
                base = 10;
                String number;
                number = literal;
                {
                    boolean var23DA3B05608ECFB50FED05F3B5EFE228_510609235 = (number.startsWith("0x") || number.startsWith("0X"));
                    {
                        number = number.substring(2);
                        base = 16;
                    } //End block
                    {
                        boolean varECB1F3363AA5C8D13B35551E8BC5CC45_1250465870 = (number.startsWith("0") && number.length() > 1);
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
                } //End block
                catch (NumberFormatException e)
                { }
            } //End block
        } //End collapsed parenthetic
        try 
        {
            Object var54295E44F40F289AB292C2BD8C947969_2033387997 = (Double.valueOf(literal));
        } //End block
        catch (NumberFormatException ignored)
        { }
        Object var4E6A8641C89AA28D8F71D75AB7B85BD1_524277231 = (new String(literal));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.223 -0400", hash_original_method = "593B1F2EF0668764A615A5DB85CFDCCD", hash_generated_method = "6384AB6A8234298C5864F6D1D795ECC3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String nextToInternal(String excluded) {
        dsTaint.addTaint(excluded);
        int start;
        start = pos;
        {
            boolean var06047043A614DB892241E06898F33574_1670830329 = (pos < in.length());
            {
                char c;
                c = in.charAt(pos);
                {
                    boolean var3AFBB0EA2C2EAC586FE2A5174EE77C31_335979091 = (c == '\r' || c == '\n' || excluded.indexOf(c) != -1);
                    {
                        String var92EE274B7530C03493B2A8E46A64DFD8_314365080 = (in.substring(start, pos));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        String varD0FD7DF7057448243726F297ED7506FB_1177323173 = (in.substring(start));
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.224 -0400", hash_original_method = "D694401380EAF5A76DF87137C67448EA", hash_generated_method = "14EB2D16278969AF28C2722DF1952D61")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private JSONObject readObject() throws JSONException {
        JSONObject result;
        result = new JSONObject();
        int first;
        first = nextCleanInternal();
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
                boolean var72E5C3E39CDD2006881A0D60EC0E1A1E_881892756 = (pos < in.length() && in.charAt(pos) == '>');
            } //End collapsed parenthetic
            result.put((String) name, nextValue());
            {
                Object var35407F991950AD5200888229B2F0259B_632035955 = (nextCleanInternal());
                //Begin case default 
                if (DroidSafeAndroidRuntime.control) throw syntaxError("Unterminated object");
                //End case default 
            } //End collapsed parenthetic
        } //End block
        return (JSONObject)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.225 -0400", hash_original_method = "E76B205E92636F1E7B3FC6B2B934FE47", hash_generated_method = "46BA399F5D4425F45810ACE693888550")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private JSONArray readArray() throws JSONException {
        JSONArray result;
        result = new JSONArray();
        boolean hasTrailingSeparator;
        hasTrailingSeparator = false;
        {
            {
                Object var35407F991950AD5200888229B2F0259B_1226686426 = (nextCleanInternal());
                //Begin case -1 
                if (DroidSafeAndroidRuntime.control) throw syntaxError("Unterminated array");
                //End case -1 
                //Begin case ']' 
                {
                    result.put(null);
                } //End block
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
                Object var35407F991950AD5200888229B2F0259B_88954669 = (nextCleanInternal());
                //Begin case ',' ';' 
                hasTrailingSeparator = true;
                //End case ',' ';' 
                //Begin case default 
                if (DroidSafeAndroidRuntime.control) throw syntaxError("Unterminated array");
                //End case default 
            } //End collapsed parenthetic
        } //End block
        return (JSONArray)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.226 -0400", hash_original_method = "33F4C16D40F1C908E16B89E59A552BE8", hash_generated_method = "ECE7E81BE9F7F8D06D732EE26EF21386")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONException syntaxError(String message) {
        dsTaint.addTaint(message);
        JSONException varAAF8B95366EA4A9590B57C1732148581_793760801 = (new JSONException(message + this));
        return (JSONException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new JSONException(message + this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.226 -0400", hash_original_method = "D61A5D8B8E38C1530E1AB8F6DB368DAC", hash_generated_method = "3F36830927D6B9FBB9CE265572B29AE7")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return " at character " + pos + " of " + in;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.226 -0400", hash_original_method = "6281E295952C34947D74AA92CC697B16", hash_generated_method = "5A6CD841D7F9AEA30CE37DA32B8609F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean more() {
        boolean varB462DE0FE1ED2D0144387DE6CF6946AC_234589600 = (pos < in.length());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return pos < in.length();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.226 -0400", hash_original_method = "213D34FB491711CFF086DB4B25220A73", hash_generated_method = "13E8A514C80192A31C9D7701DD681FF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char next() {
        {
            boolean var06047043A614DB892241E06898F33574_1555572587 = (pos < in.length());
            Object varB9A5BCC79F60EF8E6A70D7A0EC39D139_1133126451 = (in.charAt(pos++));
        } //End flattened ternary
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return pos < in.length() ? in.charAt(pos++) : '\0';
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.227 -0400", hash_original_method = "95912FB15799A75254D0EFB27A4965DA", hash_generated_method = "5473FB3BB0BE70C02A3370AE2FDDEB98")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char next(char c) throws JSONException {
        dsTaint.addTaint(c);
        char result;
        result = next();
        {
            if (DroidSafeAndroidRuntime.control) throw syntaxError("Expected " + c + " but was " + result);
        } //End block
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //char result = next();
        //if (result != c) {
            //throw syntaxError("Expected " + c + " but was " + result);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.227 -0400", hash_original_method = "8888AACA46E7314FC33FB1B59D843324", hash_generated_method = "EAA2686304004C556BB42968BAF73012")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char nextClean() throws JSONException {
        int nextCleanInt;
        nextCleanInt = nextCleanInternal();
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //int nextCleanInt = nextCleanInternal();
        //return nextCleanInt == -1 ? '\0' : (char) nextCleanInt;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.227 -0400", hash_original_method = "9816A4D386531BCA80B95E34249E012D", hash_generated_method = "496E248E6EB26A1D7ACA183DA59A73EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String next(int length) throws JSONException {
        dsTaint.addTaint(length);
        {
            boolean var1500402172E845F1F47FE7DDAF72FD84_531941260 = (pos + length > in.length());
            {
                if (DroidSafeAndroidRuntime.control) throw syntaxError(length + " is out of bounds");
            } //End block
        } //End collapsed parenthetic
        String result;
        result = in.substring(pos, pos + length);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (pos + length > in.length()) {
            //throw syntaxError(length + " is out of bounds");
        //}
        //String result = in.substring(pos, pos + length);
        //pos += length;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.227 -0400", hash_original_method = "EA130CCB3E2CFC0C10CD8E8D4F88F4FA", hash_generated_method = "D3922F4EFA719784F0FE6322E60C4BD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String nextTo(String excluded) {
        dsTaint.addTaint(excluded);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        String varEB4178EBECDF2376A9C0EE4B6FEF1287_731269713 = (nextToInternal(excluded).trim());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (excluded == null) {
            //throw new NullPointerException();
        //}
        //return nextToInternal(excluded).trim();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.227 -0400", hash_original_method = "9F2D4FCC02E225188C000422795F1B2D", hash_generated_method = "39FC30C376CA1F72F08DF14A7C0A1D26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String nextTo(char excluded) {
        dsTaint.addTaint(excluded);
        String var92E7336111D508B70F6769EF4BF4A030_92781617 = (nextToInternal(String.valueOf(excluded)).trim());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return nextToInternal(String.valueOf(excluded)).trim();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.228 -0400", hash_original_method = "705EE299D0C421425210CB39FE7F29B9", hash_generated_method = "1243D74CF7A76A989D0D0FC53DBAEFF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void skipPast(String thru) {
        dsTaint.addTaint(thru);
        int thruStart;
        thruStart = in.indexOf(thru, pos);
        pos = thruStart == -1 ? in.length() : (thruStart + thru.length());
        // ---------- Original Method ----------
        //int thruStart = in.indexOf(thru, pos);
        //pos = thruStart == -1 ? in.length() : (thruStart + thru.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.228 -0400", hash_original_method = "A067EA373EE4201A369E9BCAA7E25460", hash_generated_method = "27BAD69DBE73C3F65757E9155103D2F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char skipTo(char to) {
        dsTaint.addTaint(to);
        int index;
        index = in.indexOf(to, pos);
        {
            pos = index;
        } //End block
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //int index = in.indexOf(to, pos);
        //if (index != -1) {
            //pos = index;
            //return to;
        //} else {
            //return '\0';
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.228 -0400", hash_original_method = "8E6F2519C4EF5016C5BDFABD97F81370", hash_generated_method = "E69C5655DD65275250CBBCF1D432F901")
    @DSModeled(DSC.SAFE)
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

