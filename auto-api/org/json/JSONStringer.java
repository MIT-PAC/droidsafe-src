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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.566 -0400", hash_original_field = "EB6AB58F1561677E9297620615127CB9", hash_generated_field = "9554BB4AB1E316BAC076E8B4D17E52B3")

    StringBuilder out = new StringBuilder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.566 -0400", hash_original_field = "74731791CC82427D8113859CCB1EC950", hash_generated_field = "9E626780FA157B1FB8E8D06E1BBA8CA5")

    private List<Scope> stack = new ArrayList<Scope>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.566 -0400", hash_original_field = "EAD60A4FE9E35D6E4F9F3E8EBDF32D02", hash_generated_field = "7D7A545AD595A13E474956B04BBDC653")

    private String indent;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.581 -0400", hash_original_method = "98D853100F79BF96F83BA7B441C56113", hash_generated_method = "7D824AED16B4CDA872B4C17138D3CF3B")
    public  JSONStringer() {
        indent = null;
        // ---------- Original Method ----------
        //indent = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.581 -0400", hash_original_method = "3DA6CD526A78C194327021A156DBFACA", hash_generated_method = "15E723A10AE29DF91EBAC7454BB7AAF0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.582 -0400", hash_original_method = "2E37A32AF13C3DB4BD8A6EB72023C7E4", hash_generated_method = "7BDB9F8562959469FC606FACA61C91E1")
    public JSONStringer array() throws JSONException {
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_1733631049 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1733631049 = open(Scope.EMPTY_ARRAY, "[");
        varB4EAC82CA7396A68D541C85D26508E83_1733631049.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1733631049;
        // ---------- Original Method ----------
        //return open(Scope.EMPTY_ARRAY, "[");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.586 -0400", hash_original_method = "6A2E08939F192DB9BEF6B9CE1D1800F8", hash_generated_method = "DA6B883CCFC78394582C432E486853A2")
    public JSONStringer endArray() throws JSONException {
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_3964195 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_3964195 = close(Scope.EMPTY_ARRAY, Scope.NONEMPTY_ARRAY, "]");
        varB4EAC82CA7396A68D541C85D26508E83_3964195.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_3964195;
        // ---------- Original Method ----------
        //return close(Scope.EMPTY_ARRAY, Scope.NONEMPTY_ARRAY, "]");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.587 -0400", hash_original_method = "CFE0E3CA762AC926F745749CF2134248", hash_generated_method = "9FA6C71D3C03861AE9B9057C52BED00C")
    public JSONStringer object() throws JSONException {
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_488857607 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_488857607 = open(Scope.EMPTY_OBJECT, "{");
        varB4EAC82CA7396A68D541C85D26508E83_488857607.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_488857607;
        // ---------- Original Method ----------
        //return open(Scope.EMPTY_OBJECT, "{");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.588 -0400", hash_original_method = "04277D36A4D54D9CF9D1FF565E2D8229", hash_generated_method = "1B70157C888AA6E481693237500514C6")
    public JSONStringer endObject() throws JSONException {
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_1736109447 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1736109447 = close(Scope.EMPTY_OBJECT, Scope.NONEMPTY_OBJECT, "}");
        varB4EAC82CA7396A68D541C85D26508E83_1736109447.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1736109447;
        // ---------- Original Method ----------
        //return close(Scope.EMPTY_OBJECT, Scope.NONEMPTY_OBJECT, "}");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.594 -0400", hash_original_method = "FE9B399F97E79B5140A06EB88BCEBC31", hash_generated_method = "9ED1A68ACCF8AEBFBA493C7BAE2E0132")
     JSONStringer open(Scope empty, String openBracket) throws JSONException {
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_1733397348 = null; //Variable for return #1
        {
            boolean varF66FD470DE70ECC708BD20F163C41BFC_212964132 = (stack.isEmpty() && out.length() > 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new JSONException("Nesting problem: multiple top-level roots");
            } //End block
        } //End collapsed parenthetic
        beforeValue();
        stack.add(empty);
        out.append(openBracket);
        varB4EAC82CA7396A68D541C85D26508E83_1733397348 = this;
        addTaint(empty.getTaint());
        addTaint(openBracket.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1733397348.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1733397348;
        // ---------- Original Method ----------
        //if (stack.isEmpty() && out.length() > 0) {
            //throw new JSONException("Nesting problem: multiple top-level roots");
        //}
        //beforeValue();
        //stack.add(empty);
        //out.append(openBracket);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.597 -0400", hash_original_method = "6B42F025815F6D5CF3C9CA43230A22B6", hash_generated_method = "7D52D8F678712DC60B759A85966F48A1")
     JSONStringer close(Scope empty, Scope nonempty, String closeBracket) throws JSONException {
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_1531561539 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1531561539 = this;
        addTaint(empty.getTaint());
        addTaint(nonempty.getTaint());
        addTaint(closeBracket.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1531561539.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1531561539;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.607 -0400", hash_original_method = "8F2C7ADB42C2C89CD99F5BA7F29697D3", hash_generated_method = "44233AA5A7392315C8B1AD3BB5F4C6D1")
    private Scope peek() throws JSONException {
        Scope varB4EAC82CA7396A68D541C85D26508E83_1811262990 = null; //Variable for return #1
        {
            boolean var257FC7566C7252BFC7678488AA1C434D_128305954 = (stack.isEmpty());
            {
                if (DroidSafeAndroidRuntime.control) throw new JSONException("Nesting problem");
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1811262990 = stack.get(stack.size() - 1);
        varB4EAC82CA7396A68D541C85D26508E83_1811262990.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1811262990;
        // ---------- Original Method ----------
        //if (stack.isEmpty()) {
            //throw new JSONException("Nesting problem");
        //}
        //return stack.get(stack.size() - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.607 -0400", hash_original_method = "06C25D9275C46608400AACFE7B687C39", hash_generated_method = "7D7333E38C96E5A4A64954003E0C7D2B")
    private void replaceTop(Scope topOfStack) {
        stack.set(stack.size() - 1, topOfStack);
        addTaint(topOfStack.getTaint());
        // ---------- Original Method ----------
        //stack.set(stack.size() - 1, topOfStack);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.612 -0400", hash_original_method = "71F86DA89D5C1CA3A74E1957819F40E1", hash_generated_method = "5EF63472D73BDA6200D75175D621F705")
    public JSONStringer value(Object value) throws JSONException {
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_751546278 = null; //Variable for return #1
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_695743859 = null; //Variable for return #2
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_461889534 = null; //Variable for return #3
        {
            boolean var257FC7566C7252BFC7678488AA1C434D_654472422 = (stack.isEmpty());
            {
                if (DroidSafeAndroidRuntime.control) throw new JSONException("Nesting problem");
            } //End block
        } //End collapsed parenthetic
        {
            ((JSONArray) value).writeTo(this);
            varB4EAC82CA7396A68D541C85D26508E83_751546278 = this;
        } //End block
        {
            ((JSONObject) value).writeTo(this);
            varB4EAC82CA7396A68D541C85D26508E83_695743859 = this;
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
        varB4EAC82CA7396A68D541C85D26508E83_461889534 = this;
        addTaint(value.getTaint());
        JSONStringer varA7E53CE21691AB073D9660D615818899_1807954396; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1807954396 = varB4EAC82CA7396A68D541C85D26508E83_751546278;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1807954396 = varB4EAC82CA7396A68D541C85D26508E83_695743859;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1807954396 = varB4EAC82CA7396A68D541C85D26508E83_461889534;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1807954396.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1807954396;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.613 -0400", hash_original_method = "FCFB4EBC72F92C82B8A5BB74120390AB", hash_generated_method = "4E410626C5140EB517CACD6F58C18BFF")
    public JSONStringer value(boolean value) throws JSONException {
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_1551121831 = null; //Variable for return #1
        {
            boolean var257FC7566C7252BFC7678488AA1C434D_904049676 = (stack.isEmpty());
            {
                if (DroidSafeAndroidRuntime.control) throw new JSONException("Nesting problem");
            } //End block
        } //End collapsed parenthetic
        beforeValue();
        out.append(value);
        varB4EAC82CA7396A68D541C85D26508E83_1551121831 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1551121831.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1551121831;
        // ---------- Original Method ----------
        //if (stack.isEmpty()) {
            //throw new JSONException("Nesting problem");
        //}
        //beforeValue();
        //out.append(value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.614 -0400", hash_original_method = "B92957EDC8605AA2DADE9F77E64B9066", hash_generated_method = "2FE118041782EAC35C71FCC302A9A613")
    public JSONStringer value(double value) throws JSONException {
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_1247912387 = null; //Variable for return #1
        {
            boolean var257FC7566C7252BFC7678488AA1C434D_502660231 = (stack.isEmpty());
            {
                if (DroidSafeAndroidRuntime.control) throw new JSONException("Nesting problem");
            } //End block
        } //End collapsed parenthetic
        beforeValue();
        out.append(JSONObject.numberToString(value));
        varB4EAC82CA7396A68D541C85D26508E83_1247912387 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1247912387.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1247912387;
        // ---------- Original Method ----------
        //if (stack.isEmpty()) {
            //throw new JSONException("Nesting problem");
        //}
        //beforeValue();
        //out.append(JSONObject.numberToString(value));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.614 -0400", hash_original_method = "9F8BADDEDC1CE205B7B8CDF7A0DB9A85", hash_generated_method = "9F4ACD13138291993519326F52F41B5C")
    public JSONStringer value(long value) throws JSONException {
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_273303017 = null; //Variable for return #1
        {
            boolean var257FC7566C7252BFC7678488AA1C434D_724832251 = (stack.isEmpty());
            {
                if (DroidSafeAndroidRuntime.control) throw new JSONException("Nesting problem");
            } //End block
        } //End collapsed parenthetic
        beforeValue();
        out.append(value);
        varB4EAC82CA7396A68D541C85D26508E83_273303017 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_273303017.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_273303017;
        // ---------- Original Method ----------
        //if (stack.isEmpty()) {
            //throw new JSONException("Nesting problem");
        //}
        //beforeValue();
        //out.append(value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.619 -0400", hash_original_method = "E6F73466C6FDC5C4F374E57C86CB98DF", hash_generated_method = "61645866546572284ED7D5D452F5C3E8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.619 -0400", hash_original_method = "A1C4E39B6594D26F11F448F86F922EBA", hash_generated_method = "77975DC574597CD5ADCFAD8EC9AC1B8D")
    private void newline() {
        out.append("\n");
        {
            int i;
            i = 0;
            boolean var27767A5D6B7F9D70131EB003026B67CA_1814326975 = (i < stack.size());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.620 -0400", hash_original_method = "473489656459EE056EBCFF443DF4BB5C", hash_generated_method = "5B43A29780874A6B17241949E20BE1C7")
    public JSONStringer key(String name) throws JSONException {
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_846078744 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new JSONException("Names must be non-null");
        } //End block
        beforeKey();
        string(name);
        varB4EAC82CA7396A68D541C85D26508E83_846078744 = this;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_846078744.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_846078744;
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new JSONException("Names must be non-null");
        //}
        //beforeKey();
        //string(name);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.620 -0400", hash_original_method = "2432D2D31ED521C760D918E6DCE1C6CE", hash_generated_method = "C031D270887144150AC8DE6448EEBB7C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.631 -0400", hash_original_method = "9CA1703B701EBBFA9C513149EAF6F304", hash_generated_method = "47A94DAD332544725661C809FB54AF56")
    private void beforeValue() throws JSONException {
        {
            boolean var257FC7566C7252BFC7678488AA1C434D_357568307 = (stack.isEmpty());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.632 -0400", hash_original_method = "84F418CD08C16D699E3DC2920B2AB795", hash_generated_method = "33AD8B2BD9C9BCF57BCFEEB8BD075B1B")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_955661856 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_955661856 = out.length() == 0 ? null : out.toString();
        varB4EAC82CA7396A68D541C85D26508E83_955661856.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_955661856;
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

