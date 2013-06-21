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
    StringBuilder out = new StringBuilder();
    private List<Scope> stack = new ArrayList<Scope>();
    private String indent;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.187 -0400", hash_original_method = "98D853100F79BF96F83BA7B441C56113", hash_generated_method = "7D824AED16B4CDA872B4C17138D3CF3B")
    @DSModeled(DSC.SAFE)
    public JSONStringer() {
        indent = null;
        // ---------- Original Method ----------
        //indent = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.188 -0400", hash_original_method = "3DA6CD526A78C194327021A156DBFACA", hash_generated_method = "175481D01F07E09EB79D40309878679F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     JSONStringer(int indentSpaces) {
        dsTaint.addTaint(indentSpaces);
        char[] indentChars;
        indentChars = new char[indentSpaces];
        Arrays.fill(indentChars, ' ');
        indent = new String(indentChars);
        // ---------- Original Method ----------
        //char[] indentChars = new char[indentSpaces];
        //Arrays.fill(indentChars, ' ');
        //indent = new String(indentChars);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.188 -0400", hash_original_method = "2E37A32AF13C3DB4BD8A6EB72023C7E4", hash_generated_method = "D1C23C969465054633A576026ACFF2A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONStringer array() throws JSONException {
        JSONStringer var0C6383C75DD1ED0FE4E0D9E1DB1D4DFB_1351503388 = (open(Scope.EMPTY_ARRAY, "["));
        return (JSONStringer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return open(Scope.EMPTY_ARRAY, "[");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.188 -0400", hash_original_method = "6A2E08939F192DB9BEF6B9CE1D1800F8", hash_generated_method = "87943F76686488D1BC72E076192D969E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONStringer endArray() throws JSONException {
        JSONStringer var2FAD1C99B8638A37C5DABBFE447C21D0_699754667 = (close(Scope.EMPTY_ARRAY, Scope.NONEMPTY_ARRAY, "]"));
        return (JSONStringer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return close(Scope.EMPTY_ARRAY, Scope.NONEMPTY_ARRAY, "]");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.188 -0400", hash_original_method = "CFE0E3CA762AC926F745749CF2134248", hash_generated_method = "FAEFBF775490864B2751986FAEC6C65B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONStringer object() throws JSONException {
        JSONStringer var93CFF63AEFC67CCC1BE9C56363851168_1942008229 = (open(Scope.EMPTY_OBJECT, "{"));
        return (JSONStringer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return open(Scope.EMPTY_OBJECT, "{");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.189 -0400", hash_original_method = "04277D36A4D54D9CF9D1FF565E2D8229", hash_generated_method = "CC6587B3B13BBE2852462F8766F301EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONStringer endObject() throws JSONException {
        JSONStringer varCBA878D765E3A9F47E64359045A2C443_943390658 = (close(Scope.EMPTY_OBJECT, Scope.NONEMPTY_OBJECT, "}"));
        return (JSONStringer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return close(Scope.EMPTY_OBJECT, Scope.NONEMPTY_OBJECT, "}");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.189 -0400", hash_original_method = "FE9B399F97E79B5140A06EB88BCEBC31", hash_generated_method = "5463FEEE9AB0C9975CB45E07C6575DE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     JSONStringer open(Scope empty, String openBracket) throws JSONException {
        dsTaint.addTaint(openBracket);
        dsTaint.addTaint(empty.dsTaint);
        {
            boolean varF66FD470DE70ECC708BD20F163C41BFC_1453544800 = (stack.isEmpty() && out.length() > 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new JSONException("Nesting problem: multiple top-level roots");
            } //End block
        } //End collapsed parenthetic
        beforeValue();
        stack.add(empty);
        out.append(openBracket);
        return (JSONStringer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (stack.isEmpty() && out.length() > 0) {
            //throw new JSONException("Nesting problem: multiple top-level roots");
        //}
        //beforeValue();
        //stack.add(empty);
        //out.append(openBracket);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.189 -0400", hash_original_method = "6B42F025815F6D5CF3C9CA43230A22B6", hash_generated_method = "B64D346F16F55950DDC55FD646A02B47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     JSONStringer close(Scope empty, Scope nonempty, String closeBracket) throws JSONException {
        dsTaint.addTaint(nonempty.dsTaint);
        dsTaint.addTaint(empty.dsTaint);
        dsTaint.addTaint(closeBracket);
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
        return (JSONStringer)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.189 -0400", hash_original_method = "8F2C7ADB42C2C89CD99F5BA7F29697D3", hash_generated_method = "3942AC1E03B400E8CCD8934DA89D2BB3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Scope peek() throws JSONException {
        {
            boolean var257FC7566C7252BFC7678488AA1C434D_99742667 = (stack.isEmpty());
            {
                if (DroidSafeAndroidRuntime.control) throw new JSONException("Nesting problem");
            } //End block
        } //End collapsed parenthetic
        Scope var296F51BECFE0DD7D9E53EFCF8B9413B8_594829520 = (stack.get(stack.size() - 1));
        return (Scope)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (stack.isEmpty()) {
            //throw new JSONException("Nesting problem");
        //}
        //return stack.get(stack.size() - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.190 -0400", hash_original_method = "06C25D9275C46608400AACFE7B687C39", hash_generated_method = "BA85F698FB22449DD540660328A7C3D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void replaceTop(Scope topOfStack) {
        dsTaint.addTaint(topOfStack.dsTaint);
        stack.set(stack.size() - 1, topOfStack);
        // ---------- Original Method ----------
        //stack.set(stack.size() - 1, topOfStack);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.190 -0400", hash_original_method = "71F86DA89D5C1CA3A74E1957819F40E1", hash_generated_method = "32396A69B76B9FFAB31F4633D3BA1C26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONStringer value(Object value) throws JSONException {
        dsTaint.addTaint(value.dsTaint);
        {
            boolean var257FC7566C7252BFC7678488AA1C434D_1367228659 = (stack.isEmpty());
            {
                if (DroidSafeAndroidRuntime.control) throw new JSONException("Nesting problem");
            } //End block
        } //End collapsed parenthetic
        {
            ((JSONArray) value).writeTo(this);
        } //End block
        {
            ((JSONObject) value).writeTo(this);
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
        return (JSONStringer)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.190 -0400", hash_original_method = "FCFB4EBC72F92C82B8A5BB74120390AB", hash_generated_method = "C4BDC0E642786F96E10A49BBDAB99272")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONStringer value(boolean value) throws JSONException {
        dsTaint.addTaint(value);
        {
            boolean var257FC7566C7252BFC7678488AA1C434D_1027086788 = (stack.isEmpty());
            {
                if (DroidSafeAndroidRuntime.control) throw new JSONException("Nesting problem");
            } //End block
        } //End collapsed parenthetic
        beforeValue();
        out.append(value);
        return (JSONStringer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (stack.isEmpty()) {
            //throw new JSONException("Nesting problem");
        //}
        //beforeValue();
        //out.append(value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.190 -0400", hash_original_method = "B92957EDC8605AA2DADE9F77E64B9066", hash_generated_method = "A417029FF1A9E2222B00364BD04528AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONStringer value(double value) throws JSONException {
        dsTaint.addTaint(value);
        {
            boolean var257FC7566C7252BFC7678488AA1C434D_2032846409 = (stack.isEmpty());
            {
                if (DroidSafeAndroidRuntime.control) throw new JSONException("Nesting problem");
            } //End block
        } //End collapsed parenthetic
        beforeValue();
        out.append(JSONObject.numberToString(value));
        return (JSONStringer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (stack.isEmpty()) {
            //throw new JSONException("Nesting problem");
        //}
        //beforeValue();
        //out.append(JSONObject.numberToString(value));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.191 -0400", hash_original_method = "9F8BADDEDC1CE205B7B8CDF7A0DB9A85", hash_generated_method = "98368A0679A482094FD8EFFC7BE8BC47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONStringer value(long value) throws JSONException {
        dsTaint.addTaint(value);
        {
            boolean var257FC7566C7252BFC7678488AA1C434D_255421956 = (stack.isEmpty());
            {
                if (DroidSafeAndroidRuntime.control) throw new JSONException("Nesting problem");
            } //End block
        } //End collapsed parenthetic
        beforeValue();
        out.append(value);
        return (JSONStringer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (stack.isEmpty()) {
            //throw new JSONException("Nesting problem");
        //}
        //beforeValue();
        //out.append(value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.191 -0400", hash_original_method = "E6F73466C6FDC5C4F374E57C86CB98DF", hash_generated_method = "2DFA929989746A6FEF14B25FF69592D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void string(String value) {
        dsTaint.addTaint(value);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.191 -0400", hash_original_method = "A1C4E39B6594D26F11F448F86F922EBA", hash_generated_method = "4F455E54695F77DAB607BF64EEF7595F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void newline() {
        out.append("\n");
        {
            int i;
            i = 0;
            boolean var27767A5D6B7F9D70131EB003026B67CA_2042840708 = (i < stack.size());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.191 -0400", hash_original_method = "473489656459EE056EBCFF443DF4BB5C", hash_generated_method = "546FB84E841C76A1DC7B2AB5569E1727")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONStringer key(String name) throws JSONException {
        dsTaint.addTaint(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new JSONException("Names must be non-null");
        } //End block
        beforeKey();
        string(name);
        return (JSONStringer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new JSONException("Names must be non-null");
        //}
        //beforeKey();
        //string(name);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.192 -0400", hash_original_method = "2432D2D31ED521C760D918E6DCE1C6CE", hash_generated_method = "C031D270887144150AC8DE6448EEBB7C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.192 -0400", hash_original_method = "9CA1703B701EBBFA9C513149EAF6F304", hash_generated_method = "6394634D1C49A9C000C73F64A0FB3001")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void beforeValue() throws JSONException {
        {
            boolean var257FC7566C7252BFC7678488AA1C434D_1581268705 = (stack.isEmpty());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.192 -0400", hash_original_method = "84F418CD08C16D699E3DC2920B2AB795", hash_generated_method = "A215C57E42DF0C3E50B5335ABB1FE240")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        {
            boolean var8C00D6026DCA60A37283F33AC61F3313_563104452 = (out.length() == 0);
            Object var59D25E26BA0E025B8E448D3C6CE15DF5_1798626525 = (out.toString());
        } //End flattened ternary
        return dsTaint.getTaintString();
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

