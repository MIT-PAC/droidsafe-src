package org.json;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JSONStringer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.651 -0400", hash_original_field = "EB6AB58F1561677E9297620615127CB9", hash_generated_field = "A0CBD6F499FC0AC1E6545290B568BB70")

    final StringBuilder out = new StringBuilder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.651 -0400", hash_original_field = "74731791CC82427D8113859CCB1EC950", hash_generated_field = "28EC373715B6F8CAC037841941695683")

    private final List<Scope> stack = new ArrayList<Scope>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.651 -0400", hash_original_field = "EAD60A4FE9E35D6E4F9F3E8EBDF32D02", hash_generated_field = "7D7A545AD595A13E474956B04BBDC653")

    private String indent;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.651 -0400", hash_original_method = "98D853100F79BF96F83BA7B441C56113", hash_generated_method = "7D824AED16B4CDA872B4C17138D3CF3B")
    public  JSONStringer() {
        indent = null;
        // ---------- Original Method ----------
        //indent = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.652 -0400", hash_original_method = "3DA6CD526A78C194327021A156DBFACA", hash_generated_method = "B12BE336B381F32630313E7BB63BDA29")
      JSONStringer(int indentSpaces) {
        addTaint(indentSpaces);
        char[] indentChars = new char[indentSpaces];
        Arrays.fill(indentChars, ' ');
        indent = new String(indentChars);
        // ---------- Original Method ----------
        //char[] indentChars = new char[indentSpaces];
        //Arrays.fill(indentChars, ' ');
        //indent = new String(indentChars);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.652 -0400", hash_original_method = "2E37A32AF13C3DB4BD8A6EB72023C7E4", hash_generated_method = "EA9B5F4D7FF37DD5F93A3EF826963DF6")
    public JSONStringer array() throws JSONException {
JSONStringer varE2D913F27CEAD4EDD8195967C303C50D_1728447443 =         open(Scope.EMPTY_ARRAY, "[");
        varE2D913F27CEAD4EDD8195967C303C50D_1728447443.addTaint(taint);
        return varE2D913F27CEAD4EDD8195967C303C50D_1728447443;
        // ---------- Original Method ----------
        //return open(Scope.EMPTY_ARRAY, "[");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.652 -0400", hash_original_method = "6A2E08939F192DB9BEF6B9CE1D1800F8", hash_generated_method = "819B5787DE491BB5674532D85DAAC8F7")
    public JSONStringer endArray() throws JSONException {
JSONStringer var3421C3B880CB17BF1CEF0BB32AD70DA2_1746615021 =         close(Scope.EMPTY_ARRAY, Scope.NONEMPTY_ARRAY, "]");
        var3421C3B880CB17BF1CEF0BB32AD70DA2_1746615021.addTaint(taint);
        return var3421C3B880CB17BF1CEF0BB32AD70DA2_1746615021;
        // ---------- Original Method ----------
        //return close(Scope.EMPTY_ARRAY, Scope.NONEMPTY_ARRAY, "]");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.652 -0400", hash_original_method = "CFE0E3CA762AC926F745749CF2134248", hash_generated_method = "9DD305C8F20592D2B6D75A4CB87F94F4")
    public JSONStringer object() throws JSONException {
JSONStringer var9F1003779294EC55D6DFAE23766A46CF_645727467 =         open(Scope.EMPTY_OBJECT, "{");
        var9F1003779294EC55D6DFAE23766A46CF_645727467.addTaint(taint);
        return var9F1003779294EC55D6DFAE23766A46CF_645727467;
        // ---------- Original Method ----------
        //return open(Scope.EMPTY_OBJECT, "{");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.652 -0400", hash_original_method = "04277D36A4D54D9CF9D1FF565E2D8229", hash_generated_method = "BF622A35AEF76A81E81F7AF029D63151")
    public JSONStringer endObject() throws JSONException {
JSONStringer varAF20B7BEA60954198642AE0B7AD4210A_456955088 =         close(Scope.EMPTY_OBJECT, Scope.NONEMPTY_OBJECT, "}");
        varAF20B7BEA60954198642AE0B7AD4210A_456955088.addTaint(taint);
        return varAF20B7BEA60954198642AE0B7AD4210A_456955088;
        // ---------- Original Method ----------
        //return close(Scope.EMPTY_OBJECT, Scope.NONEMPTY_OBJECT, "}");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.652 -0400", hash_original_method = "FE9B399F97E79B5140A06EB88BCEBC31", hash_generated_method = "65602D9D7C319F01C3179E921E93ED1D")
     JSONStringer open(Scope empty, String openBracket) throws JSONException {
        addTaint(openBracket.getTaint());
        addTaint(empty.getTaint());
    if(stack.isEmpty() && out.length() > 0)        
        {
            JSONException varFCBBADB5B22E04A09F670CF58362A693_1487225591 = new JSONException("Nesting problem: multiple top-level roots");
            varFCBBADB5B22E04A09F670CF58362A693_1487225591.addTaint(taint);
            throw varFCBBADB5B22E04A09F670CF58362A693_1487225591;
        } //End block
        beforeValue();
        stack.add(empty);
        out.append(openBracket);
JSONStringer var72A74007B2BE62B849F475C7BDA4658B_910429557 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_910429557.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_910429557;
        // ---------- Original Method ----------
        //if (stack.isEmpty() && out.length() > 0) {
            //throw new JSONException("Nesting problem: multiple top-level roots");
        //}
        //beforeValue();
        //stack.add(empty);
        //out.append(openBracket);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.653 -0400", hash_original_method = "6B42F025815F6D5CF3C9CA43230A22B6", hash_generated_method = "FF3723E869E129AB9D59C351D636FF12")
     JSONStringer close(Scope empty, Scope nonempty, String closeBracket) throws JSONException {
        addTaint(closeBracket.getTaint());
        addTaint(nonempty.getTaint());
        addTaint(empty.getTaint());
        Scope context = peek();
    if(context != nonempty && context != empty)        
        {
            JSONException var2C2A6860B2733F98954DC21FFC98A831_1588374470 = new JSONException("Nesting problem");
            var2C2A6860B2733F98954DC21FFC98A831_1588374470.addTaint(taint);
            throw var2C2A6860B2733F98954DC21FFC98A831_1588374470;
        } //End block
        stack.remove(stack.size() - 1);
    if(context == nonempty)        
        {
            newline();
        } //End block
        out.append(closeBracket);
JSONStringer var72A74007B2BE62B849F475C7BDA4658B_507132542 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_507132542.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_507132542;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.653 -0400", hash_original_method = "8F2C7ADB42C2C89CD99F5BA7F29697D3", hash_generated_method = "33B79C4B6E79C094E40DD01B4B4B4886")
    private Scope peek() throws JSONException {
    if(stack.isEmpty())        
        {
            JSONException var2C2A6860B2733F98954DC21FFC98A831_542728587 = new JSONException("Nesting problem");
            var2C2A6860B2733F98954DC21FFC98A831_542728587.addTaint(taint);
            throw var2C2A6860B2733F98954DC21FFC98A831_542728587;
        } //End block
Scope var0C13C1874AA5E05BC89B862E007E5C49_1121510936 =         stack.get(stack.size() - 1);
        var0C13C1874AA5E05BC89B862E007E5C49_1121510936.addTaint(taint);
        return var0C13C1874AA5E05BC89B862E007E5C49_1121510936;
        // ---------- Original Method ----------
        //if (stack.isEmpty()) {
            //throw new JSONException("Nesting problem");
        //}
        //return stack.get(stack.size() - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.653 -0400", hash_original_method = "06C25D9275C46608400AACFE7B687C39", hash_generated_method = "51CE78FA73CA4F56B9EFDBA5648DCE9D")
    private void replaceTop(Scope topOfStack) {
        addTaint(topOfStack.getTaint());
        stack.set(stack.size() - 1, topOfStack);
        // ---------- Original Method ----------
        //stack.set(stack.size() - 1, topOfStack);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.653 -0400", hash_original_method = "71F86DA89D5C1CA3A74E1957819F40E1", hash_generated_method = "5DF0A9E77F3AE3EAAD9DD197D82C7F0C")
    public JSONStringer value(Object value) throws JSONException {
        addTaint(value.getTaint());
    if(stack.isEmpty())        
        {
            JSONException var2C2A6860B2733F98954DC21FFC98A831_230646967 = new JSONException("Nesting problem");
            var2C2A6860B2733F98954DC21FFC98A831_230646967.addTaint(taint);
            throw var2C2A6860B2733F98954DC21FFC98A831_230646967;
        } //End block
    if(value instanceof JSONArray)        
        {
            ((JSONArray) value).writeTo(this);
JSONStringer var72A74007B2BE62B849F475C7BDA4658B_929280646 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_929280646.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_929280646;
        } //End block
        else
    if(value instanceof JSONObject)        
        {
            ((JSONObject) value).writeTo(this);
JSONStringer var72A74007B2BE62B849F475C7BDA4658B_307862511 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_307862511.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_307862511;
        } //End block
        beforeValue();
    if(value == null
                || value instanceof Boolean
                || value == JSONObject.NULL)        
        {
            out.append(value);
        } //End block
        else
    if(value instanceof Number)        
        {
            out.append(JSONObject.numberToString((Number) value));
        } //End block
        else
        {
            string(value.toString());
        } //End block
JSONStringer var72A74007B2BE62B849F475C7BDA4658B_1444231346 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1444231346.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1444231346;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.653 -0400", hash_original_method = "FCFB4EBC72F92C82B8A5BB74120390AB", hash_generated_method = "7EA88CBC5086CE76E134EC542DA46708")
    public JSONStringer value(boolean value) throws JSONException {
        addTaint(value);
    if(stack.isEmpty())        
        {
            JSONException var2C2A6860B2733F98954DC21FFC98A831_1208127635 = new JSONException("Nesting problem");
            var2C2A6860B2733F98954DC21FFC98A831_1208127635.addTaint(taint);
            throw var2C2A6860B2733F98954DC21FFC98A831_1208127635;
        } //End block
        beforeValue();
        out.append(value);
JSONStringer var72A74007B2BE62B849F475C7BDA4658B_216265259 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_216265259.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_216265259;
        // ---------- Original Method ----------
        //if (stack.isEmpty()) {
            //throw new JSONException("Nesting problem");
        //}
        //beforeValue();
        //out.append(value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.654 -0400", hash_original_method = "B92957EDC8605AA2DADE9F77E64B9066", hash_generated_method = "96CB562E4A46095B5E1EFA2324ED7BEB")
    public JSONStringer value(double value) throws JSONException {
        addTaint(value);
    if(stack.isEmpty())        
        {
            JSONException var2C2A6860B2733F98954DC21FFC98A831_145892620 = new JSONException("Nesting problem");
            var2C2A6860B2733F98954DC21FFC98A831_145892620.addTaint(taint);
            throw var2C2A6860B2733F98954DC21FFC98A831_145892620;
        } //End block
        beforeValue();
        out.append(JSONObject.numberToString(value));
JSONStringer var72A74007B2BE62B849F475C7BDA4658B_1950361704 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1950361704.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1950361704;
        // ---------- Original Method ----------
        //if (stack.isEmpty()) {
            //throw new JSONException("Nesting problem");
        //}
        //beforeValue();
        //out.append(JSONObject.numberToString(value));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.654 -0400", hash_original_method = "9F8BADDEDC1CE205B7B8CDF7A0DB9A85", hash_generated_method = "FEEA3C3C693D257BB0FC562A6FAB8F42")
    public JSONStringer value(long value) throws JSONException {
        addTaint(value);
    if(stack.isEmpty())        
        {
            JSONException var2C2A6860B2733F98954DC21FFC98A831_1907708979 = new JSONException("Nesting problem");
            var2C2A6860B2733F98954DC21FFC98A831_1907708979.addTaint(taint);
            throw var2C2A6860B2733F98954DC21FFC98A831_1907708979;
        } //End block
        beforeValue();
        out.append(value);
JSONStringer var72A74007B2BE62B849F475C7BDA4658B_660084128 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_660084128.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_660084128;
        // ---------- Original Method ----------
        //if (stack.isEmpty()) {
            //throw new JSONException("Nesting problem");
        //}
        //beforeValue();
        //out.append(value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.654 -0400", hash_original_method = "E6F73466C6FDC5C4F374E57C86CB98DF", hash_generated_method = "F073B1E91438EFE5914C81F71582F62E")
    private void string(String value) {
        addTaint(value.getTaint());
        out.append("\"");
for(int i = 0, length = value.length();i < length;i++)
        {
            char c = value.charAt(i);
switch(c){
            case '"':
            case '\\':
            case '/':
            out.append('\\').append(c);
            break;
            case '\t':
            out.append("\\t");
            break;
            case '\b':
            out.append("\\b");
            break;
            case '\n':
            out.append("\\n");
            break;
            case '\r':
            out.append("\\r");
            break;
            case '\f':
            out.append("\\f");
            break;
            default:
    if(c <= 0x1F)            
            {
                out.append(String.format("\\u%04x", (int) c));
            } //End block
            else
            {
                out.append(c);
            } //End block
            break;
}
        } //End block
        out.append("\"");
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.654 -0400", hash_original_method = "A1C4E39B6594D26F11F448F86F922EBA", hash_generated_method = "053E40E5E5499CCB1EFA3B7F06D2503D")
    private void newline() {
    if(indent == null)        
        {
            return;
        } //End block
        out.append("\n");
for(int i = 0;i < stack.size();i++)
        {
            out.append(indent);
        } //End block
        // ---------- Original Method ----------
        //if (indent == null) {
            //return;
        //}
        //out.append("\n");
        //for (int i = 0; i < stack.size(); i++) {
            //out.append(indent);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.655 -0400", hash_original_method = "473489656459EE056EBCFF443DF4BB5C", hash_generated_method = "ADC78148D5FE406C32C8798D13B6BB36")
    public JSONStringer key(String name) throws JSONException {
        addTaint(name.getTaint());
    if(name == null)        
        {
            JSONException var9A1D8F2D16FCC2E33BC2C66F205FA660_40734977 = new JSONException("Names must be non-null");
            var9A1D8F2D16FCC2E33BC2C66F205FA660_40734977.addTaint(taint);
            throw var9A1D8F2D16FCC2E33BC2C66F205FA660_40734977;
        } //End block
        beforeKey();
        string(name);
JSONStringer var72A74007B2BE62B849F475C7BDA4658B_1482511179 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1482511179.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1482511179;
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new JSONException("Names must be non-null");
        //}
        //beforeKey();
        //string(name);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.655 -0400", hash_original_method = "2432D2D31ED521C760D918E6DCE1C6CE", hash_generated_method = "68483268F03FB97CB7BCF9C1917994F0")
    private void beforeKey() throws JSONException {
        Scope context = peek();
    if(context == Scope.NONEMPTY_OBJECT)        
        {
            out.append(',');
        } //End block
        else
    if(context != Scope.EMPTY_OBJECT)        
        {
            JSONException var2C2A6860B2733F98954DC21FFC98A831_1195598113 = new JSONException("Nesting problem");
            var2C2A6860B2733F98954DC21FFC98A831_1195598113.addTaint(taint);
            throw var2C2A6860B2733F98954DC21FFC98A831_1195598113;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.655 -0400", hash_original_method = "9CA1703B701EBBFA9C513149EAF6F304", hash_generated_method = "77A4A9770A19E771EED2B1444BDDADFC")
    private void beforeValue() throws JSONException {
    if(stack.isEmpty())        
        {
            return;
        } //End block
        Scope context = peek();
    if(context == Scope.EMPTY_ARRAY)        
        {
            replaceTop(Scope.NONEMPTY_ARRAY);
            newline();
        } //End block
        else
    if(context == Scope.NONEMPTY_ARRAY)        
        {
            out.append(',');
            newline();
        } //End block
        else
    if(context == Scope.DANGLING_KEY)        
        {
            out.append(indent == null ? ":" : ": ");
            replaceTop(Scope.NONEMPTY_OBJECT);
        } //End block
        else
    if(context != Scope.NULL)        
        {
            JSONException var2C2A6860B2733F98954DC21FFC98A831_1986798338 = new JSONException("Nesting problem");
            var2C2A6860B2733F98954DC21FFC98A831_1986798338.addTaint(taint);
            throw var2C2A6860B2733F98954DC21FFC98A831_1986798338;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.656 -0400", hash_original_method = "84F418CD08C16D699E3DC2920B2AB795", hash_generated_method = "E2DDBCC70E6D1F84A94BE26C1939D6A8")
    @Override
    public String toString() {
String varEF63D206C061F9C8D806233235C41E35_1496240015 =         out.length() == 0 ? null : out.toString();
        varEF63D206C061F9C8D806233235C41E35_1496240015.addTaint(taint);
        return varEF63D206C061F9C8D806233235C41E35_1496240015;
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

