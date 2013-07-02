package org.json;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JSONStringer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.320 -0400", hash_original_field = "EB6AB58F1561677E9297620615127CB9", hash_generated_field = "A0CBD6F499FC0AC1E6545290B568BB70")

    final StringBuilder out = new StringBuilder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.320 -0400", hash_original_field = "74731791CC82427D8113859CCB1EC950", hash_generated_field = "28EC373715B6F8CAC037841941695683")

    private final List<Scope> stack = new ArrayList<Scope>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.320 -0400", hash_original_field = "EAD60A4FE9E35D6E4F9F3E8EBDF32D02", hash_generated_field = "7D7A545AD595A13E474956B04BBDC653")

    private String indent;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.321 -0400", hash_original_method = "98D853100F79BF96F83BA7B441C56113", hash_generated_method = "7D824AED16B4CDA872B4C17138D3CF3B")
    public  JSONStringer() {
        indent = null;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.321 -0400", hash_original_method = "3DA6CD526A78C194327021A156DBFACA", hash_generated_method = "34C5693B246FE6E8615B33445ACD4EAB")
      JSONStringer(int indentSpaces) {
        char[] indentChars = new char[indentSpaces];
        Arrays.fill(indentChars, ' ');
        indent = new String(indentChars);
        addTaint(indentSpaces);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.321 -0400", hash_original_method = "2E37A32AF13C3DB4BD8A6EB72023C7E4", hash_generated_method = "F15C165151E3938A1A80851C2421FB72")
    public JSONStringer array() throws JSONException {
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_1482357587 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1482357587 = open(Scope.EMPTY_ARRAY, "[");
        varB4EAC82CA7396A68D541C85D26508E83_1482357587.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1482357587;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.322 -0400", hash_original_method = "6A2E08939F192DB9BEF6B9CE1D1800F8", hash_generated_method = "2194F2040FA8EDDFD2751A9553E840FA")
    public JSONStringer endArray() throws JSONException {
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_1191800847 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1191800847 = close(Scope.EMPTY_ARRAY, Scope.NONEMPTY_ARRAY, "]");
        varB4EAC82CA7396A68D541C85D26508E83_1191800847.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1191800847;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.322 -0400", hash_original_method = "CFE0E3CA762AC926F745749CF2134248", hash_generated_method = "CE65473E471AA8E0AF6DB08859BDCD5E")
    public JSONStringer object() throws JSONException {
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_1595333274 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1595333274 = open(Scope.EMPTY_OBJECT, "{");
        varB4EAC82CA7396A68D541C85D26508E83_1595333274.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1595333274;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.323 -0400", hash_original_method = "04277D36A4D54D9CF9D1FF565E2D8229", hash_generated_method = "DC2BB64A96C5B67652E1BCDBDDD94015")
    public JSONStringer endObject() throws JSONException {
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_285752321 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_285752321 = close(Scope.EMPTY_OBJECT, Scope.NONEMPTY_OBJECT, "}");
        varB4EAC82CA7396A68D541C85D26508E83_285752321.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_285752321;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.324 -0400", hash_original_method = "FE9B399F97E79B5140A06EB88BCEBC31", hash_generated_method = "8CCFFE48E66C353ADA4D0A768391BFFF")
     JSONStringer open(Scope empty, String openBracket) throws JSONException {
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_700364943 = null; 
        {
            boolean varF66FD470DE70ECC708BD20F163C41BFC_1066047080 = (stack.isEmpty() && out.length() > 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new JSONException("Nesting problem: multiple top-level roots");
            } 
        } 
        beforeValue();
        stack.add(empty);
        out.append(openBracket);
        varB4EAC82CA7396A68D541C85D26508E83_700364943 = this;
        addTaint(empty.getTaint());
        addTaint(openBracket.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_700364943.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_700364943;
        
        
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.325 -0400", hash_original_method = "6B42F025815F6D5CF3C9CA43230A22B6", hash_generated_method = "A5B55C18BA0A5EBFD96B5AA469A0C6A3")
     JSONStringer close(Scope empty, Scope nonempty, String closeBracket) throws JSONException {
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_1336734030 = null; 
        Scope context = peek();
        {
            if (DroidSafeAndroidRuntime.control) throw new JSONException("Nesting problem");
        } 
        stack.remove(stack.size() - 1);
        {
            newline();
        } 
        out.append(closeBracket);
        varB4EAC82CA7396A68D541C85D26508E83_1336734030 = this;
        addTaint(empty.getTaint());
        addTaint(nonempty.getTaint());
        addTaint(closeBracket.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1336734030.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1336734030;
        
        
        
            
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.325 -0400", hash_original_method = "8F2C7ADB42C2C89CD99F5BA7F29697D3", hash_generated_method = "5686A58F402B551C061454273DAAA8D3")
    private Scope peek() throws JSONException {
        Scope varB4EAC82CA7396A68D541C85D26508E83_419392964 = null; 
        {
            boolean var257FC7566C7252BFC7678488AA1C434D_577644015 = (stack.isEmpty());
            {
                if (DroidSafeAndroidRuntime.control) throw new JSONException("Nesting problem");
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_419392964 = stack.get(stack.size() - 1);
        varB4EAC82CA7396A68D541C85D26508E83_419392964.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_419392964;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.326 -0400", hash_original_method = "06C25D9275C46608400AACFE7B687C39", hash_generated_method = "7D7333E38C96E5A4A64954003E0C7D2B")
    private void replaceTop(Scope topOfStack) {
        stack.set(stack.size() - 1, topOfStack);
        addTaint(topOfStack.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.327 -0400", hash_original_method = "71F86DA89D5C1CA3A74E1957819F40E1", hash_generated_method = "BF8E2596173AB48CD57A2A54F9740360")
    public JSONStringer value(Object value) throws JSONException {
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_1148328163 = null; 
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_1092351632 = null; 
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_1787592092 = null; 
        {
            boolean var257FC7566C7252BFC7678488AA1C434D_635149973 = (stack.isEmpty());
            {
                if (DroidSafeAndroidRuntime.control) throw new JSONException("Nesting problem");
            } 
        } 
        {
            ((JSONArray) value).writeTo(this);
            varB4EAC82CA7396A68D541C85D26508E83_1148328163 = this;
        } 
        {
            ((JSONObject) value).writeTo(this);
            varB4EAC82CA7396A68D541C85D26508E83_1092351632 = this;
        } 
        beforeValue();
        {
            out.append(value);
        } 
        {
            out.append(JSONObject.numberToString((Number) value));
        } 
        {
            string(value.toString());
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1787592092 = this;
        addTaint(value.getTaint());
        JSONStringer varA7E53CE21691AB073D9660D615818899_1023655140; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1023655140 = varB4EAC82CA7396A68D541C85D26508E83_1148328163;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1023655140 = varB4EAC82CA7396A68D541C85D26508E83_1092351632;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1023655140 = varB4EAC82CA7396A68D541C85D26508E83_1787592092;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1023655140.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1023655140;
        
        
            
        
        
            
            
        
            
            
        
        
        
                
                
            
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.327 -0400", hash_original_method = "FCFB4EBC72F92C82B8A5BB74120390AB", hash_generated_method = "02A8E3FEFBB407E94E945A1BC415D612")
    public JSONStringer value(boolean value) throws JSONException {
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_1595046950 = null; 
        {
            boolean var257FC7566C7252BFC7678488AA1C434D_549756660 = (stack.isEmpty());
            {
                if (DroidSafeAndroidRuntime.control) throw new JSONException("Nesting problem");
            } 
        } 
        beforeValue();
        out.append(value);
        varB4EAC82CA7396A68D541C85D26508E83_1595046950 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1595046950.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1595046950;
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.328 -0400", hash_original_method = "B92957EDC8605AA2DADE9F77E64B9066", hash_generated_method = "383F443B105C76C442944D048FBA49D8")
    public JSONStringer value(double value) throws JSONException {
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_1126012021 = null; 
        {
            boolean var257FC7566C7252BFC7678488AA1C434D_851029328 = (stack.isEmpty());
            {
                if (DroidSafeAndroidRuntime.control) throw new JSONException("Nesting problem");
            } 
        } 
        beforeValue();
        out.append(JSONObject.numberToString(value));
        varB4EAC82CA7396A68D541C85D26508E83_1126012021 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1126012021.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1126012021;
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.328 -0400", hash_original_method = "9F8BADDEDC1CE205B7B8CDF7A0DB9A85", hash_generated_method = "130BD57F9EECB4EF3FF3F6CD5678E418")
    public JSONStringer value(long value) throws JSONException {
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_1448859788 = null; 
        {
            boolean var257FC7566C7252BFC7678488AA1C434D_660972130 = (stack.isEmpty());
            {
                if (DroidSafeAndroidRuntime.control) throw new JSONException("Nesting problem");
            } 
        } 
        beforeValue();
        out.append(value);
        varB4EAC82CA7396A68D541C85D26508E83_1448859788 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1448859788.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1448859788;
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.329 -0400", hash_original_method = "E6F73466C6FDC5C4F374E57C86CB98DF", hash_generated_method = "84F3A15CDA1509658E28A7ED449204BC")
    private void string(String value) {
        out.append("\"");
        {
            int i = 0;
            int length = value.length();
            {
                char c = value.charAt(i);
                
                out.append('\\').append(c);
                
                
                out.append("\\t");
                
                
                out.append("\\b");
                
                
                out.append("\\n");
                
                
                out.append("\\r");
                
                
                out.append("\\f");
                
                
                {
                    out.append(String.format("\\u%04x", (int) c));
                } 
                {
                    out.append(c);
                } 
                
            } 
        } 
        out.append("\"");
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.329 -0400", hash_original_method = "A1C4E39B6594D26F11F448F86F922EBA", hash_generated_method = "0CC53F7E93792AE34FFE551768D7A82F")
    private void newline() {
        out.append("\n");
        {
            int i = 0;
            boolean var27767A5D6B7F9D70131EB003026B67CA_1658391472 = (i < stack.size());
            {
                out.append(indent);
            } 
        } 
        
        
            
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.330 -0400", hash_original_method = "473489656459EE056EBCFF443DF4BB5C", hash_generated_method = "42EE18C635D4A12000DF90E23EA7451B")
    public JSONStringer key(String name) throws JSONException {
        JSONStringer varB4EAC82CA7396A68D541C85D26508E83_1019982287 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new JSONException("Names must be non-null");
        } 
        beforeKey();
        string(name);
        varB4EAC82CA7396A68D541C85D26508E83_1019982287 = this;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1019982287.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1019982287;
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.330 -0400", hash_original_method = "2432D2D31ED521C760D918E6DCE1C6CE", hash_generated_method = "36EE13A0CE3E51273AF5211D52D34317")
    private void beforeKey() throws JSONException {
        Scope context = peek();
        {
            out.append(',');
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new JSONException("Nesting problem");
        } 
        newline();
        replaceTop(Scope.DANGLING_KEY);
        
        
        
            
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.331 -0400", hash_original_method = "9CA1703B701EBBFA9C513149EAF6F304", hash_generated_method = "F5F5394BDD54ABB8572055A6BD2E73AB")
    private void beforeValue() throws JSONException {
        {
            boolean var257FC7566C7252BFC7678488AA1C434D_658173529 = (stack.isEmpty());
        } 
        Scope context = peek();
        {
            replaceTop(Scope.NONEMPTY_ARRAY);
            newline();
        } 
        {
            out.append(',');
            newline();
        } 
        {
            out.append(indent == null ? ":" : ": ");
            replaceTop(Scope.NONEMPTY_OBJECT);
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new JSONException("Nesting problem");
        } 
        
        
            
        
        
        
            
            
        
            
            
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.332 -0400", hash_original_method = "84F418CD08C16D699E3DC2920B2AB795", hash_generated_method = "D8068FA4DAB39395AE213CBE025DC345")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_755905583 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_755905583 = out.length() == 0 ? null : out.toString();
        varB4EAC82CA7396A68D541C85D26508E83_755905583.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_755905583;
        
        
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

