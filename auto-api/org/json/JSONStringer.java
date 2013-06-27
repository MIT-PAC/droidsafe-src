package org.json;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JSONStringer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.547 -0400", hash_original_field = "EB6AB58F1561677E9297620615127CB9", hash_generated_field = "9554BB4AB1E316BAC076E8B4D17E52B3")

    StringBuilder out = new StringBuilder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.547 -0400", hash_original_field = "74731791CC82427D8113859CCB1EC950", hash_generated_field = "9E626780FA157B1FB8E8D06E1BBA8CA5")

    private List<Scope> stack = new ArrayList<Scope>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.547 -0400", hash_original_field = "EAD60A4FE9E35D6E4F9F3E8EBDF32D02", hash_generated_field = "7D7A545AD595A13E474956B04BBDC653")

    private String indent;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.547 -0400", hash_original_method = "98D853100F79BF96F83BA7B441C56113", hash_generated_method = "7D824AED16B4CDA872B4C17138D3CF3B")
    public  JSONStringer() {
        indent = null;
        // ---------- Original Method ----------
        //indent = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.548 -0400", hash_original_method = "3DA6CD526A78C194327021A156DBFACA", hash_generated_method = "15E723A10AE29DF91EBAC7454BB7AAF0")
      JSONStringer(int indentSpaces) {
        char[] indentChars;
        indentChars = new char[indentSpaces];
        Arrays.fill(indentChars, ' ');
        indent = new String(indentChars);
        addTaint(indentSpaces);
        // ---------- Original Method ----------
        //char[] indentChars = new char[indentSpaces];
        //Arrays.fill(indentChars, ' ');
        //indent = new String(indentChars);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.548 -0400", hash_original_method = "2E37A32AF13C3DB4BD8A6EB72023C7E4", hash_generated_method = "844C3AAE9303D4C08DB253A1E394B655")
    public JSONStringer array() throws JSONException {
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_697235779 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_697235779 = open(Scope.EMPTY_ARRAY, "[");
        varB4EAC82CA7396A68D541C85D26508E83_697235779.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_697235779;
        // ---------- Original Method ----------
        //return open(Scope.EMPTY_ARRAY, "[");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.549 -0400", hash_original_method = "6A2E08939F192DB9BEF6B9CE1D1800F8", hash_generated_method = "D81F936F408FA49F893F9E2F8295E919")
    public JSONStringer endArray() throws JSONException {
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_480218963 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_480218963 = close(Scope.EMPTY_ARRAY, Scope.NONEMPTY_ARRAY, "]");
        varB4EAC82CA7396A68D541C85D26508E83_480218963.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_480218963;
        // ---------- Original Method ----------
        //return close(Scope.EMPTY_ARRAY, Scope.NONEMPTY_ARRAY, "]");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.549 -0400", hash_original_method = "CFE0E3CA762AC926F745749CF2134248", hash_generated_method = "DC9075D640A511C0530F905701FDA43E")
    public JSONStringer object() throws JSONException {
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_1410754019 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1410754019 = open(Scope.EMPTY_OBJECT, "{");
        varB4EAC82CA7396A68D541C85D26508E83_1410754019.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1410754019;
        // ---------- Original Method ----------
        //return open(Scope.EMPTY_OBJECT, "{");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.549 -0400", hash_original_method = "04277D36A4D54D9CF9D1FF565E2D8229", hash_generated_method = "786F1ACE8711662A8F22DD6BE606E73A")
    public JSONStringer endObject() throws JSONException {
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_2002676772 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2002676772 = close(Scope.EMPTY_OBJECT, Scope.NONEMPTY_OBJECT, "}");
        varB4EAC82CA7396A68D541C85D26508E83_2002676772.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2002676772;
        // ---------- Original Method ----------
        //return close(Scope.EMPTY_OBJECT, Scope.NONEMPTY_OBJECT, "}");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.558 -0400", hash_original_method = "FE9B399F97E79B5140A06EB88BCEBC31", hash_generated_method = "2084A1004FF6B939CA17DD4F945801F5")
     JSONStringer open(Scope empty, String openBracket) throws JSONException {
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_47806705 = null; //Variable for return #1
        {
            boolean varF66FD470DE70ECC708BD20F163C41BFC_624958207 = (stack.isEmpty() && out.length() > 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new JSONException("Nesting problem: multiple top-level roots");
            } //End block
        } //End collapsed parenthetic
        beforeValue();
        stack.add(empty);
        out.append(openBracket);
        varB4EAC82CA7396A68D541C85D26508E83_47806705 = this;
        addTaint(empty.getTaint());
        addTaint(openBracket.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_47806705.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_47806705;
        // ---------- Original Method ----------
        //if (stack.isEmpty() && out.length() > 0) {
            //throw new JSONException("Nesting problem: multiple top-level roots");
        //}
        //beforeValue();
        //stack.add(empty);
        //out.append(openBracket);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.559 -0400", hash_original_method = "6B42F025815F6D5CF3C9CA43230A22B6", hash_generated_method = "681A8AE7C938B600CD7FB99457B23F93")
     JSONStringer close(Scope empty, Scope nonempty, String closeBracket) throws JSONException {
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_186139554 = null; //Variable for return #1
        Scope context;
        context = peek();
        {
            if (DroidSafeAndroidRuntime.control) throw new JSONException("Nesting problem");
        } //End block
        stack.remove(stack.size() - 1);
        {
            newline();
        } //End block
        out.append(closeBracket);
        varB4EAC82CA7396A68D541C85D26508E83_186139554 = this;
        addTaint(empty.getTaint());
        addTaint(nonempty.getTaint());
        addTaint(closeBracket.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_186139554.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_186139554;
        // ---------- Original Method ----------
        //Scope context = peek();
        //if (context != nonempty && context != empty) {
            //throw new JSONException("Nesting problem");
        //}
        //stack.remove(stack.size() - 1);
        //if (context == nonempty) {
            //newline();
        //}
        //out.append(closeBracket);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.559 -0400", hash_original_method = "8F2C7ADB42C2C89CD99F5BA7F29697D3", hash_generated_method = "F6C17B920D5ED37D6E13F83B9B8228EF")
    private Scope peek() throws JSONException {
        Scope varB4EAC82CA7396A68D541C85D26508E83_1014041458 = null; //Variable for return #1
        {
            boolean var257FC7566C7252BFC7678488AA1C434D_1687657728 = (stack.isEmpty());
            {
                if (DroidSafeAndroidRuntime.control) throw new JSONException("Nesting problem");
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1014041458 = stack.get(stack.size() - 1);
        varB4EAC82CA7396A68D541C85D26508E83_1014041458.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1014041458;
        // ---------- Original Method ----------
        //if (stack.isEmpty()) {
            //throw new JSONException("Nesting problem");
        //}
        //return stack.get(stack.size() - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.559 -0400", hash_original_method = "06C25D9275C46608400AACFE7B687C39", hash_generated_method = "7D7333E38C96E5A4A64954003E0C7D2B")
    private void replaceTop(Scope topOfStack) {
        stack.set(stack.size() - 1, topOfStack);
        addTaint(topOfStack.getTaint());
        // ---------- Original Method ----------
        //stack.set(stack.size() - 1, topOfStack);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.560 -0400", hash_original_method = "71F86DA89D5C1CA3A74E1957819F40E1", hash_generated_method = "4E1039740B07816590EF024A774652D1")
    public JSONStringer value(Object value) throws JSONException {
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_53197159 = null; //Variable for return #1
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_1640066119 = null; //Variable for return #2
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_1160786029 = null; //Variable for return #3
        {
            boolean var257FC7566C7252BFC7678488AA1C434D_88754012 = (stack.isEmpty());
            {
                if (DroidSafeAndroidRuntime.control) throw new JSONException("Nesting problem");
            } //End block
        } //End collapsed parenthetic
        {
            ((JSONArray) value).writeTo(this);
            varB4EAC82CA7396A68D541C85D26508E83_53197159 = this;
        } //End block
        {
            ((JSONObject) value).writeTo(this);
            varB4EAC82CA7396A68D541C85D26508E83_1640066119 = this;
        } //End block
        beforeValue();
        {
            out.append(value);
        } //End block
        {
            out.append(JSONObject.numberToString((Number) value));
        } //End block
        {
            string(value.toString());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1160786029 = this;
        addTaint(value.getTaint());
        JSONStringer varA7E53CE21691AB073D9660D615818899_1459974373; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1459974373 = varB4EAC82CA7396A68D541C85D26508E83_53197159;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1459974373 = varB4EAC82CA7396A68D541C85D26508E83_1640066119;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1459974373 = varB4EAC82CA7396A68D541C85D26508E83_1160786029;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1459974373.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1459974373;
        // ---------- Original Method ----------
        //if (stack.isEmpty()) {
            //throw new JSONException("Nesting problem");
        //}
        //if (value instanceof JSONArray) {
            //((JSONArray) value).writeTo(this);
            //return this;
        //} else if (value instanceof JSONObject) {
            //((JSONObject) value).writeTo(this);
            //return this;
        //}
        //beforeValue();
        //if (value == null
                //|| value instanceof Boolean
                //|| value == JSONObject.NULL) {
            //out.append(value);
        //} else if (value instanceof Number) {
            //out.append(JSONObject.numberToString((Number) value));
        //} else {
            //string(value.toString());
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.571 -0400", hash_original_method = "FCFB4EBC72F92C82B8A5BB74120390AB", hash_generated_method = "52AB5E0DBADA572CFF932655AC5FECFC")
    public JSONStringer value(boolean value) throws JSONException {
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_1328942320 = null; //Variable for return #1
        {
            boolean var257FC7566C7252BFC7678488AA1C434D_927599605 = (stack.isEmpty());
            {
                if (DroidSafeAndroidRuntime.control) throw new JSONException("Nesting problem");
            } //End block
        } //End collapsed parenthetic
        beforeValue();
        out.append(value);
        varB4EAC82CA7396A68D541C85D26508E83_1328942320 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1328942320.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1328942320;
        // ---------- Original Method ----------
        //if (stack.isEmpty()) {
            //throw new JSONException("Nesting problem");
        //}
        //beforeValue();
        //out.append(value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.571 -0400", hash_original_method = "B92957EDC8605AA2DADE9F77E64B9066", hash_generated_method = "756444960B43F9DD30BD5485926D1082")
    public JSONStringer value(double value) throws JSONException {
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_1455962722 = null; //Variable for return #1
        {
            boolean var257FC7566C7252BFC7678488AA1C434D_1191910214 = (stack.isEmpty());
            {
                if (DroidSafeAndroidRuntime.control) throw new JSONException("Nesting problem");
            } //End block
        } //End collapsed parenthetic
        beforeValue();
        out.append(JSONObject.numberToString(value));
        varB4EAC82CA7396A68D541C85D26508E83_1455962722 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1455962722.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1455962722;
        // ---------- Original Method ----------
        //if (stack.isEmpty()) {
            //throw new JSONException("Nesting problem");
        //}
        //beforeValue();
        //out.append(JSONObject.numberToString(value));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.572 -0400", hash_original_method = "9F8BADDEDC1CE205B7B8CDF7A0DB9A85", hash_generated_method = "30969F9D6C355C30BEED18D4F4D10BDF")
    public JSONStringer value(long value) throws JSONException {
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_1539656668 = null; //Variable for return #1
        {
            boolean var257FC7566C7252BFC7678488AA1C434D_715622265 = (stack.isEmpty());
            {
                if (DroidSafeAndroidRuntime.control) throw new JSONException("Nesting problem");
            } //End block
        } //End collapsed parenthetic
        beforeValue();
        out.append(value);
        varB4EAC82CA7396A68D541C85D26508E83_1539656668 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1539656668.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1539656668;
        // ---------- Original Method ----------
        //if (stack.isEmpty()) {
            //throw new JSONException("Nesting problem");
        //}
        //beforeValue();
        //out.append(value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.573 -0400", hash_original_method = "E6F73466C6FDC5C4F374E57C86CB98DF", hash_generated_method = "61645866546572284ED7D5D452F5C3E8")
    private void string(String value) {
        out.append("\"");
        {
            int i, length;
            i = 0;
            length = value.length();
            {
                char c;
                c = value.charAt(i);
                //Begin case '"' '\\' '/' 
                out.append('\\').append(c);
                //End case '"' '\\' '/' 
                //Begin case '\t' 
                out.append("\\t");
                //End case '\t' 
                //Begin case '\b' 
                out.append("\\b");
                //End case '\b' 
                //Begin case '\n' 
                out.append("\\n");
                //End case '\n' 
                //Begin case '\r' 
                out.append("\\r");
                //End case '\r' 
                //Begin case '\f' 
                out.append("\\f");
                //End case '\f' 
                //Begin case default 
                {
                    out.append(String.format("\\u%04x", (int) c));
                } //End block
                {
                    out.append(c);
                } //End block
                //End case default 
            } //End block
        } //End collapsed parenthetic
        out.append("\"");
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.573 -0400", hash_original_method = "A1C4E39B6594D26F11F448F86F922EBA", hash_generated_method = "E239AF8A35232D00016927FEE434FF06")
    private void newline() {
        out.append("\n");
        {
            int i;
            i = 0;
            boolean var27767A5D6B7F9D70131EB003026B67CA_476990382 = (i < stack.size());
            {
                out.append(indent);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (indent == null) {
            //return;
        //}
        //out.append("\n");
        //for (int i = 0; i < stack.size(); i++) {
            //out.append(indent);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.577 -0400", hash_original_method = "473489656459EE056EBCFF443DF4BB5C", hash_generated_method = "8237D9601657CA618B174CECAEA25563")
    public JSONStringer key(String name) throws JSONException {
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_1730170569 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new JSONException("Names must be non-null");
        } //End block
        beforeKey();
        string(name);
        varB4EAC82CA7396A68D541C85D26508E83_1730170569 = this;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1730170569.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1730170569;
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new JSONException("Names must be non-null");
        //}
        //beforeKey();
        //string(name);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.578 -0400", hash_original_method = "2432D2D31ED521C760D918E6DCE1C6CE", hash_generated_method = "C031D270887144150AC8DE6448EEBB7C")
    private void beforeKey() throws JSONException {
        Scope context;
        context = peek();
        {
            out.append(',');
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new JSONException("Nesting problem");
        } //End block
        newline();
        replaceTop(Scope.DANGLING_KEY);
        // ---------- Original Method ----------
        //Scope context = peek();
        //if (context == Scope.NONEMPTY_OBJECT) { 
            //out.append(',');
        //} else if (context != Scope.EMPTY_OBJECT) { 
            //throw new JSONException("Nesting problem");
        //}
        //newline();
        //replaceTop(Scope.DANGLING_KEY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.578 -0400", hash_original_method = "9CA1703B701EBBFA9C513149EAF6F304", hash_generated_method = "B33EBB599E75118164FD3E1C0DA9CE20")
    private void beforeValue() throws JSONException {
        {
            boolean var257FC7566C7252BFC7678488AA1C434D_1626332761 = (stack.isEmpty());
        } //End collapsed parenthetic
        Scope context;
        context = peek();
        {
            replaceTop(Scope.NONEMPTY_ARRAY);
            newline();
        } //End block
        {
            out.append(',');
            newline();
        } //End block
        {
            out.append(indent == null ? ":" : ": ");
            replaceTop(Scope.NONEMPTY_OBJECT);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new JSONException("Nesting problem");
        } //End block
        // ---------- Original Method ----------
        //if (stack.isEmpty()) {
            //return;
        //}
        //Scope context = peek();
        //if (context == Scope.EMPTY_ARRAY) { 
            //replaceTop(Scope.NONEMPTY_ARRAY);
            //newline();
        //} else if (context == Scope.NONEMPTY_ARRAY) { 
            //out.append(',');
            //newline();
        //} else if (context == Scope.DANGLING_KEY) { 
            //out.append(indent == null ? ":" : ": ");
            //replaceTop(Scope.NONEMPTY_OBJECT);
        //} else if (context != Scope.NULL) {
            //throw new JSONException("Nesting problem");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.591 -0400", hash_original_method = "84F418CD08C16D699E3DC2920B2AB795", hash_generated_method = "FBC36CD36BE68AE5E299C9687894F5F4")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_957550069 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_957550069 = out.length() == 0 ? null : out.toString();
        varB4EAC82CA7396A68D541C85D26508E83_957550069.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_957550069;
        // ---------- Original Method ----------
        //return out.length() == 0 ? null : out.toString();
    }

    
    enum Scope {
        EMPTY_ARRAY,
        NONEMPTY_ARRAY,
        EMPTY_OBJECT,
        DANGLING_KEY,
        NONEMPTY_OBJECT,
        NULL,
    }

    
}

