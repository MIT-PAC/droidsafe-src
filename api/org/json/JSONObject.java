package org.json;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;






public class JSONObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.377 -0400", hash_original_field = "1CF5E4F247CC69AF70109AE4475648CB", hash_generated_field = "4AEF8EB90733274F8DF38365152EB324")

    private Map<String, Object> nameValuePairs;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.377 -0400", hash_original_method = "B0BA44B1CBEEB832685DE1D9CC551D36", hash_generated_method = "8AB77AFCB9DCE98AE75372C152EFAE46")
    public  JSONObject() {
        nameValuePairs = new HashMap<String, Object>();
        // ---------- Original Method ----------
        //nameValuePairs = new HashMap<String, Object>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.378 -0400", hash_original_method = "64F11EBDF44BE4F1CBC516D3CD1F34E9", hash_generated_method = "14080611B4EE78B9DFBB4E03EB9EC207")
    public  JSONObject(Map copyFrom) {
        this();
        addTaint(copyFrom.getTaint());
        Map<?, ?> contentsTyped = (Map<?, ?>) copyFrom;
for(Map.Entry<?, ?> entry : contentsTyped.entrySet())
        {
            String key = (String) entry.getKey();
            if(key == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1709380015 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_1709380015.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_1709380015;
            } //End block
            nameValuePairs.put(key, entry.getValue());
        } //End block
        // ---------- Original Method ----------
        //Map<?, ?> contentsTyped = (Map<?, ?>) copyFrom;
        //for (Map.Entry<?, ?> entry : contentsTyped.entrySet()) {
            //String key = (String) entry.getKey();
            //if (key == null) {
                //throw new NullPointerException();
            //}
            //nameValuePairs.put(key, entry.getValue());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.382 -0400", hash_original_method = "E218F03BB03DC7D8503E0318225F7859", hash_generated_method = "E19BEC29D31A3AFF49C15A3FD79661FC")
    public  JSONObject(JSONTokener readFrom) throws JSONException {
        addTaint(readFrom.getTaint());
        Object object = readFrom.nextValue();
        if(object instanceof JSONObject)        
        {
            this.nameValuePairs = ((JSONObject) object).nameValuePairs;
        } //End block
        else
        {
            org.json.JSONException var90C9EBF3FED9A5CB53D4E04A4EF3A79E_918432893 = JSON.typeMismatch(object, "JSONObject");
            var90C9EBF3FED9A5CB53D4E04A4EF3A79E_918432893.addTaint(taint);
            throw var90C9EBF3FED9A5CB53D4E04A4EF3A79E_918432893;
        } //End block
        // ---------- Original Method ----------
        //Object object = readFrom.nextValue();
        //if (object instanceof JSONObject) {
            //this.nameValuePairs = ((JSONObject) object).nameValuePairs;
        //} else {
            //throw JSON.typeMismatch(object, "JSONObject");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.383 -0400", hash_original_method = "27B9491B51940DE15585B798AFD3D304", hash_generated_method = "64C04C1F10C31248B34728372555B741")
    public  JSONObject(String json) throws JSONException {
        this(new JSONTokener(json));
        addTaint(json.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.383 -0400", hash_original_method = "D555E6715A2E6E4EC106278BB66ED891", hash_generated_method = "6BC75BDB852C19D587B381DACC612A52")
    public  JSONObject(JSONObject copyFrom, String[] names) throws JSONException {
        this();
        addTaint(names[0].getTaint());
        addTaint(copyFrom.getTaint());
for(String name : names)
        {
            Object value = copyFrom.opt(name);
            if(value != null)            
            {
                nameValuePairs.put(name, value);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //for (String name : names) {
            //Object value = copyFrom.opt(name);
            //if (value != null) {
                //nameValuePairs.put(name, value);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.383 -0400", hash_original_method = "BB0C5A7042ADC1F8FC4BAA64EBFD2B52", hash_generated_method = "BB36707701042F80A90E8924EF1E90FC")
    public int length() {
        int var467D07E7C5E56858F17E6E5897393971_1731316042 = (nameValuePairs.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1225877714 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1225877714;
        // ---------- Original Method ----------
        //return nameValuePairs.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.384 -0400", hash_original_method = "43A124AF3EF8B2736A46103CC8729DE3", hash_generated_method = "DB659199DB8DC6333897467A454A6F0B")
    public JSONObject put(String name, boolean value) throws JSONException {
        addTaint(value);
        addTaint(name.getTaint());
        nameValuePairs.put(checkName(name), value);
JSONObject var72A74007B2BE62B849F475C7BDA4658B_1602111124 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1602111124.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1602111124;
        // ---------- Original Method ----------
        //nameValuePairs.put(checkName(name), value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.384 -0400", hash_original_method = "FF23ECF2F7B3A424BD0CA2B446E9E0DB", hash_generated_method = "21F5240151C14E995B8CBD482E430D5A")
    public JSONObject put(String name, double value) throws JSONException {
        addTaint(value);
        addTaint(name.getTaint());
        nameValuePairs.put(checkName(name), JSON.checkDouble(value));
JSONObject var72A74007B2BE62B849F475C7BDA4658B_688241814 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_688241814.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_688241814;
        // ---------- Original Method ----------
        //nameValuePairs.put(checkName(name), JSON.checkDouble(value));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.384 -0400", hash_original_method = "14B3109A64A28D2764163C4077CDC45D", hash_generated_method = "A77A2385FB103F977E964618990BD89C")
    public JSONObject put(String name, int value) throws JSONException {
        addTaint(value);
        addTaint(name.getTaint());
        nameValuePairs.put(checkName(name), value);
JSONObject var72A74007B2BE62B849F475C7BDA4658B_1019085710 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1019085710.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1019085710;
        // ---------- Original Method ----------
        //nameValuePairs.put(checkName(name), value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.384 -0400", hash_original_method = "0E78BCAD739042DC347A7959C52D188A", hash_generated_method = "83E259650AFF49283391DC95EE8DB919")
    public JSONObject put(String name, long value) throws JSONException {
        addTaint(value);
        addTaint(name.getTaint());
        nameValuePairs.put(checkName(name), value);
JSONObject var72A74007B2BE62B849F475C7BDA4658B_902412967 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_902412967.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_902412967;
        // ---------- Original Method ----------
        //nameValuePairs.put(checkName(name), value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.385 -0400", hash_original_method = "8B4C0C01745202135A0373E57DFB791E", hash_generated_method = "64231BD22446904EB0A5A5898A3A82E3")
    public JSONObject put(String name, Object value) throws JSONException {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        if(value == null)        
        {
            nameValuePairs.remove(name);
JSONObject var72A74007B2BE62B849F475C7BDA4658B_1634273868 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1634273868.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1634273868;
        } //End block
        if(value instanceof Number)        
        {
            JSON.checkDouble(((Number) value).doubleValue());
        } //End block
        nameValuePairs.put(checkName(name), value);
JSONObject var72A74007B2BE62B849F475C7BDA4658B_470609263 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_470609263.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_470609263;
        // ---------- Original Method ----------
        //if (value == null) {
            //nameValuePairs.remove(name);
            //return this;
        //}
        //if (value instanceof Number) {
            //JSON.checkDouble(((Number) value).doubleValue());
        //}
        //nameValuePairs.put(checkName(name), value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.385 -0400", hash_original_method = "D9589667A2509A719F9DF68E891B85DD", hash_generated_method = "F7B22ACD5DF1F75445F8138CF6DC3B9D")
    public JSONObject putOpt(String name, Object value) throws JSONException {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        if(name == null || value == null)        
        {
JSONObject var72A74007B2BE62B849F475C7BDA4658B_674472695 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_674472695.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_674472695;
        } //End block
JSONObject varF4258CA79FCE8127789B8A196F5E12F0_781859893 =         put(name, value);
        varF4258CA79FCE8127789B8A196F5E12F0_781859893.addTaint(taint);
        return varF4258CA79FCE8127789B8A196F5E12F0_781859893;
        // ---------- Original Method ----------
        //if (name == null || value == null) {
            //return this;
        //}
        //return put(name, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.386 -0400", hash_original_method = "5A758AD2B70A18447D6617A35807B03B", hash_generated_method = "27466EF3126C9A7A7FDF5A6C84FFD52B")
    public JSONObject accumulate(String name, Object value) throws JSONException {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        Object current = nameValuePairs.get(checkName(name));
        if(current == null)        
        {
JSONObject varF4258CA79FCE8127789B8A196F5E12F0_274151681 =             put(name, value);
            varF4258CA79FCE8127789B8A196F5E12F0_274151681.addTaint(taint);
            return varF4258CA79FCE8127789B8A196F5E12F0_274151681;
        } //End block
        if(value instanceof Number)        
        {
            JSON.checkDouble(((Number) value).doubleValue());
        } //End block
        if(current instanceof JSONArray)        
        {
            JSONArray array = (JSONArray) current;
            array.put(value);
        } //End block
        else
        {
            JSONArray array = new JSONArray();
            array.put(current);
            array.put(value);
            nameValuePairs.put(name, array);
        } //End block
JSONObject var72A74007B2BE62B849F475C7BDA4658B_404115485 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_404115485.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_404115485;
        // ---------- Original Method ----------
        //Object current = nameValuePairs.get(checkName(name));
        //if (current == null) {
            //return put(name, value);
        //}
        //if (value instanceof Number) {
            //JSON.checkDouble(((Number) value).doubleValue());
        //}
        //if (current instanceof JSONArray) {
            //JSONArray array = (JSONArray) current;
            //array.put(value);
        //} else {
            //JSONArray array = new JSONArray();
            //array.put(current);
            //array.put(value);
            //nameValuePairs.put(name, array);
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.387 -0400", hash_original_method = "1AA4BB08CA8C9DDACC6E60D58C017824", hash_generated_method = "C6CE66DE43AAFC2971DEE74C2100ADA8")
     String checkName(String name) throws JSONException {
        addTaint(name.getTaint());
        if(name == null)        
        {
            JSONException var9A1D8F2D16FCC2E33BC2C66F205FA660_1650424547 = new JSONException("Names must be non-null");
            var9A1D8F2D16FCC2E33BC2C66F205FA660_1650424547.addTaint(taint);
            throw var9A1D8F2D16FCC2E33BC2C66F205FA660_1650424547;
        } //End block
String varB017984728AC60AD1F0BF8734F33F15C_1374284069 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_1374284069.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_1374284069;
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new JSONException("Names must be non-null");
        //}
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.387 -0400", hash_original_method = "BEB5EB52101798DC8AC0FA25480A2C90", hash_generated_method = "557445D8167F6E834F6DA910912E8FAF")
    public Object remove(String name) {
        addTaint(name.getTaint());
Object var5C3FEDC697FE2142673642233C51611C_263737847 =         nameValuePairs.remove(name);
        var5C3FEDC697FE2142673642233C51611C_263737847.addTaint(taint);
        return var5C3FEDC697FE2142673642233C51611C_263737847;
        // ---------- Original Method ----------
        //return nameValuePairs.remove(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.388 -0400", hash_original_method = "A1CD692FA856D7FF90D2024A71E93EE6", hash_generated_method = "1EBA87AF6E542025924A87552BA4D589")
    public boolean isNull(String name) {
        addTaint(name.getTaint());
        Object value = nameValuePairs.get(name);
        boolean varDEFD64AE43306007731811C5F60CE9D5_2134457793 = (value == null || value == NULL);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_593993358 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_593993358;
        // ---------- Original Method ----------
        //Object value = nameValuePairs.get(name);
        //return value == null || value == NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.388 -0400", hash_original_method = "297E71AC76AEECD92DCC3FA05327BE46", hash_generated_method = "12D7F0376CAEEA094B822CBBE7033AC1")
    public boolean has(String name) {
        addTaint(name.getTaint());
        boolean varC31F79B949B7EFC4BCC33E5362FF7D9E_1484916427 = (nameValuePairs.containsKey(name));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_295090227 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_295090227;
        // ---------- Original Method ----------
        //return nameValuePairs.containsKey(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.389 -0400", hash_original_method = "C38AAF9284AEE2A94970713BC651F263", hash_generated_method = "AEAE6B6CB79E4EDCD538532B7AD8DA41")
    public Object get(String name) throws JSONException {
        addTaint(name.getTaint());
        Object result = nameValuePairs.get(name);
        if(result == null)        
        {
            JSONException var5FF827AAE76577AA6C59AD8913073D0F_912122171 = new JSONException("No value for " + name);
            var5FF827AAE76577AA6C59AD8913073D0F_912122171.addTaint(taint);
            throw var5FF827AAE76577AA6C59AD8913073D0F_912122171;
        } //End block
Object varDC838461EE2FA0CA4C9BBB70A15456B0_224009087 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_224009087.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_224009087;
        // ---------- Original Method ----------
        //Object result = nameValuePairs.get(name);
        //if (result == null) {
            //throw new JSONException("No value for " + name);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.389 -0400", hash_original_method = "05A351DC7DE639568132A573A6E2106E", hash_generated_method = "FC8F40258690D9289888C95AE58EE55A")
    public Object opt(String name) {
        addTaint(name.getTaint());
Object varB9044C5D5774441342719E1E55B7D84F_1092415309 =         nameValuePairs.get(name);
        varB9044C5D5774441342719E1E55B7D84F_1092415309.addTaint(taint);
        return varB9044C5D5774441342719E1E55B7D84F_1092415309;
        // ---------- Original Method ----------
        //return nameValuePairs.get(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.393 -0400", hash_original_method = "7B38D2B2DBA3C433303B4D117D86E4E0", hash_generated_method = "524BF292571CB26DC8F213A30E1FD630")
    public boolean getBoolean(String name) throws JSONException {
        addTaint(name.getTaint());
        Object object = get(name);
        Boolean result = JSON.toBoolean(object);
        if(result == null)        
        {
            org.json.JSONException varF58CE7A4254BFFEEFD830CD9FF78D7CC_1805092678 = JSON.typeMismatch(name, object, "boolean");
            varF58CE7A4254BFFEEFD830CD9FF78D7CC_1805092678.addTaint(taint);
            throw varF58CE7A4254BFFEEFD830CD9FF78D7CC_1805092678;
        } //End block
        boolean varB4A88417B3D0170D754C647C30B7216A_1614246570 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1177241422 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1177241422;
        // ---------- Original Method ----------
        //Object object = get(name);
        //Boolean result = JSON.toBoolean(object);
        //if (result == null) {
            //throw JSON.typeMismatch(name, object, "boolean");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.393 -0400", hash_original_method = "3DA4544CD80345F7570489979490BD16", hash_generated_method = "1CDD6FD2C447FB704E25CC105B02E21B")
    public boolean optBoolean(String name) {
        addTaint(name.getTaint());
        boolean varCA5EADA135CE663AA3ADC46C47E21C3D_30506604 = (optBoolean(name, false));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_129413731 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_129413731;
        // ---------- Original Method ----------
        //return optBoolean(name, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.393 -0400", hash_original_method = "C49CAFC4CC69BC825D274D7317108A68", hash_generated_method = "C543DA0F7AB7B4DD3F3A08795AFD4C24")
    public boolean optBoolean(String name, boolean fallback) {
        addTaint(fallback);
        addTaint(name.getTaint());
        Object object = opt(name);
        Boolean result = JSON.toBoolean(object);
        boolean varD432CC74B2878A4B571046B2CA3AAD1D_1606190919 = (result != null ? result : fallback);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_587955558 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_587955558;
        // ---------- Original Method ----------
        //Object object = opt(name);
        //Boolean result = JSON.toBoolean(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.400 -0400", hash_original_method = "0C60D6C72644A8965D87529BB9443348", hash_generated_method = "CCC3737B83F84B894A50F33C3CA8D97B")
    public double getDouble(String name) throws JSONException {
        addTaint(name.getTaint());
        Object object = get(name);
        Double result = JSON.toDouble(object);
        if(result == null)        
        {
            org.json.JSONException varDC64F5E217E93E52C55DC32B76E3DC6E_1111699924 = JSON.typeMismatch(name, object, "double");
            varDC64F5E217E93E52C55DC32B76E3DC6E_1111699924.addTaint(taint);
            throw varDC64F5E217E93E52C55DC32B76E3DC6E_1111699924;
        } //End block
        double varB4A88417B3D0170D754C647C30B7216A_1574367691 = (result);
                double varE8CD7DA078A86726031AD64F35F5A6C0_737827380 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_737827380;
        // ---------- Original Method ----------
        //Object object = get(name);
        //Double result = JSON.toDouble(object);
        //if (result == null) {
            //throw JSON.typeMismatch(name, object, "double");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.400 -0400", hash_original_method = "B9CFB7D5CC2BB58B8CACB29638DEE6A6", hash_generated_method = "EEC834CD08022700938F6DF558E01E66")
    public double optDouble(String name) {
        addTaint(name.getTaint());
        double varB835673D3752B5F2A3CCECC009044C56_1715535709 = (optDouble(name, Double.NaN));
                double varE8CD7DA078A86726031AD64F35F5A6C0_1553819055 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1553819055;
        // ---------- Original Method ----------
        //return optDouble(name, Double.NaN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.401 -0400", hash_original_method = "F525E9AC5AAC714EA253692C6DC9EE0E", hash_generated_method = "36DC953EB1CD37BDDA19BE3E896BC6A4")
    public double optDouble(String name, double fallback) {
        addTaint(fallback);
        addTaint(name.getTaint());
        Object object = opt(name);
        Double result = JSON.toDouble(object);
        double varD432CC74B2878A4B571046B2CA3AAD1D_871707238 = (result != null ? result : fallback);
                double varE8CD7DA078A86726031AD64F35F5A6C0_565269014 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_565269014;
        // ---------- Original Method ----------
        //Object object = opt(name);
        //Double result = JSON.toDouble(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.409 -0400", hash_original_method = "06DD6202AFC58B0F1BA6F9DBAA37C5F3", hash_generated_method = "319BC9F4C0B8706ADEE22E009923A1FE")
    public int getInt(String name) throws JSONException {
        addTaint(name.getTaint());
        Object object = get(name);
        Integer result = JSON.toInteger(object);
        if(result == null)        
        {
            org.json.JSONException var993B2EFD9D82DE5C324D7735C9A9E5F6_463937245 = JSON.typeMismatch(name, object, "int");
            var993B2EFD9D82DE5C324D7735C9A9E5F6_463937245.addTaint(taint);
            throw var993B2EFD9D82DE5C324D7735C9A9E5F6_463937245;
        } //End block
        int varB4A88417B3D0170D754C647C30B7216A_475988130 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2113183148 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2113183148;
        // ---------- Original Method ----------
        //Object object = get(name);
        //Integer result = JSON.toInteger(object);
        //if (result == null) {
            //throw JSON.typeMismatch(name, object, "int");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.410 -0400", hash_original_method = "CF8C56AE8C6952FAAA48007CA568A3BF", hash_generated_method = "E9C9D2CA8E63C4BF2C085AC19E70511F")
    public int optInt(String name) {
        addTaint(name.getTaint());
        int var84FC0CBFC698299AA22FFAC69E130380_235294982 = (optInt(name, 0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_831367102 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_831367102;
        // ---------- Original Method ----------
        //return optInt(name, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.411 -0400", hash_original_method = "FC3121A883EAF5555BD9C194D7925D34", hash_generated_method = "1123A85B4E1200A95914DEB166FC7E1E")
    public int optInt(String name, int fallback) {
        addTaint(fallback);
        addTaint(name.getTaint());
        Object object = opt(name);
        Integer result = JSON.toInteger(object);
        int varD432CC74B2878A4B571046B2CA3AAD1D_469841909 = (result != null ? result : fallback);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_673631492 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_673631492;
        // ---------- Original Method ----------
        //Object object = opt(name);
        //Integer result = JSON.toInteger(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.416 -0400", hash_original_method = "55ABC1042FFC5D7EF9272460461F1426", hash_generated_method = "2D3326FC9E25170BA726C3808055F1C6")
    public long getLong(String name) throws JSONException {
        addTaint(name.getTaint());
        Object object = get(name);
        Long result = JSON.toLong(object);
        if(result == null)        
        {
            org.json.JSONException var663EF30E21300B7BF6F0F99F89F7F327_1640256549 = JSON.typeMismatch(name, object, "long");
            var663EF30E21300B7BF6F0F99F89F7F327_1640256549.addTaint(taint);
            throw var663EF30E21300B7BF6F0F99F89F7F327_1640256549;
        } //End block
        long varB4A88417B3D0170D754C647C30B7216A_1468361258 = (result);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1848214953 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1848214953;
        // ---------- Original Method ----------
        //Object object = get(name);
        //Long result = JSON.toLong(object);
        //if (result == null) {
            //throw JSON.typeMismatch(name, object, "long");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.417 -0400", hash_original_method = "70DEF89A3C807E0937F5C9E9E3A1A203", hash_generated_method = "F89D0B134FC1DA8C472BF573FD965DD8")
    public long optLong(String name) {
        addTaint(name.getTaint());
        long varC5B1BB326733C74FD164F9452BD3B7C9_1382963286 = (optLong(name, 0L));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1446117992 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1446117992;
        // ---------- Original Method ----------
        //return optLong(name, 0L);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.417 -0400", hash_original_method = "C94BC7D2B7352E7323E9E58C53ACE476", hash_generated_method = "1BD424CDEDE14554BAA86096247879BC")
    public long optLong(String name, long fallback) {
        addTaint(fallback);
        addTaint(name.getTaint());
        Object object = opt(name);
        Long result = JSON.toLong(object);
        long varD432CC74B2878A4B571046B2CA3AAD1D_2046850081 = (result != null ? result : fallback);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_490246260 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_490246260;
        // ---------- Original Method ----------
        //Object object = opt(name);
        //Long result = JSON.toLong(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.423 -0400", hash_original_method = "CC649536AC568087B4414076D420F027", hash_generated_method = "AE90AE83790A2494734A146BF8F8D2D7")
    public String getString(String name) throws JSONException {
        addTaint(name.getTaint());
        Object object = get(name);
        String result = JSON.toString(object);
        if(result == null)        
        {
            org.json.JSONException var6EB12F9F79CDE0595AD32A2EB3D43164_713397382 = JSON.typeMismatch(name, object, "String");
            var6EB12F9F79CDE0595AD32A2EB3D43164_713397382.addTaint(taint);
            throw var6EB12F9F79CDE0595AD32A2EB3D43164_713397382;
        } //End block
String varDC838461EE2FA0CA4C9BBB70A15456B0_749520810 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_749520810.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_749520810;
        // ---------- Original Method ----------
        //Object object = get(name);
        //String result = JSON.toString(object);
        //if (result == null) {
            //throw JSON.typeMismatch(name, object, "String");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.423 -0400", hash_original_method = "8B81E5CBB6FE92C9270C8AE14E1D248D", hash_generated_method = "9B0273CEC78C95301EAF3A7FAE9582CE")
    public String optString(String name) {
        addTaint(name.getTaint());
String var0CE80B357AB5E5816978317628338B78_1543827360 =         optString(name, "");
        var0CE80B357AB5E5816978317628338B78_1543827360.addTaint(taint);
        return var0CE80B357AB5E5816978317628338B78_1543827360;
        // ---------- Original Method ----------
        //return optString(name, "");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.423 -0400", hash_original_method = "B4BBF2951ACCBF79FD3FE8AB17DCAE83", hash_generated_method = "9072BD782D987681E009DB8B01B10179")
    public String optString(String name, String fallback) {
        addTaint(fallback.getTaint());
        addTaint(name.getTaint());
        Object object = opt(name);
        String result = JSON.toString(object);
String varB29C31EA7BA163F0F2187995ADA1E48E_823678738 =         result != null ? result : fallback;
        varB29C31EA7BA163F0F2187995ADA1E48E_823678738.addTaint(taint);
        return varB29C31EA7BA163F0F2187995ADA1E48E_823678738;
        // ---------- Original Method ----------
        //Object object = opt(name);
        //String result = JSON.toString(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.431 -0400", hash_original_method = "1CE1CD2D1D65AA0859027B9575FA80C4", hash_generated_method = "88A3C5CBE8421F09C254FEBDF6998692")
    public JSONArray getJSONArray(String name) throws JSONException {
        addTaint(name.getTaint());
        Object object = get(name);
        if(object instanceof JSONArray)        
        {
JSONArray varA31A6C9B348464F1BAAA1B1373E54400_1530368862 =             (JSONArray) object;
            varA31A6C9B348464F1BAAA1B1373E54400_1530368862.addTaint(taint);
            return varA31A6C9B348464F1BAAA1B1373E54400_1530368862;
        } //End block
        else
        {
            org.json.JSONException varEAF21408DDD198DA03E57B84CD4AB662_803474271 = JSON.typeMismatch(name, object, "JSONArray");
            varEAF21408DDD198DA03E57B84CD4AB662_803474271.addTaint(taint);
            throw varEAF21408DDD198DA03E57B84CD4AB662_803474271;
        } //End block
        // ---------- Original Method ----------
        //Object object = get(name);
        //if (object instanceof JSONArray) {
            //return (JSONArray) object;
        //} else {
            //throw JSON.typeMismatch(name, object, "JSONArray");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.432 -0400", hash_original_method = "576EFB0CB9E2FA91FCF1D9A3EF1337C6", hash_generated_method = "3FEED0C2143DD90AA5E0891342CDAC45")
    public JSONArray optJSONArray(String name) {
        addTaint(name.getTaint());
        Object object = opt(name);
JSONArray var37D15C802F10CA15BA7D983DBF1DB879_1937215963 =         object instanceof JSONArray ? (JSONArray) object : null;
        var37D15C802F10CA15BA7D983DBF1DB879_1937215963.addTaint(taint);
        return var37D15C802F10CA15BA7D983DBF1DB879_1937215963;
        // ---------- Original Method ----------
        //Object object = opt(name);
        //return object instanceof JSONArray ? (JSONArray) object : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.438 -0400", hash_original_method = "5326315C93466A3B1E8C695224A5B5FD", hash_generated_method = "FA6A6491C77054129D769D29876B0662")
    public JSONObject getJSONObject(String name) throws JSONException {
        addTaint(name.getTaint());
        Object object = get(name);
        if(object instanceof JSONObject)        
        {
JSONObject varA963CC0194E284A145B65210ED1E5C63_807184412 =             (JSONObject) object;
            varA963CC0194E284A145B65210ED1E5C63_807184412.addTaint(taint);
            return varA963CC0194E284A145B65210ED1E5C63_807184412;
        } //End block
        else
        {
            org.json.JSONException var36B0E52DCB924D05CBFE61A301258646_755243527 = JSON.typeMismatch(name, object, "JSONObject");
            var36B0E52DCB924D05CBFE61A301258646_755243527.addTaint(taint);
            throw var36B0E52DCB924D05CBFE61A301258646_755243527;
        } //End block
        // ---------- Original Method ----------
        //Object object = get(name);
        //if (object instanceof JSONObject) {
            //return (JSONObject) object;
        //} else {
            //throw JSON.typeMismatch(name, object, "JSONObject");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.439 -0400", hash_original_method = "B736B3B7313026EC1CBB4CB1D3C2367D", hash_generated_method = "D29AEB023BC88F30DE15C8FAF35A4CAB")
    public JSONObject optJSONObject(String name) {
        addTaint(name.getTaint());
        Object object = opt(name);
JSONObject varE8B2189D470FA34838D00114FC8343E3_360463819 =         object instanceof JSONObject ? (JSONObject) object : null;
        varE8B2189D470FA34838D00114FC8343E3_360463819.addTaint(taint);
        return varE8B2189D470FA34838D00114FC8343E3_360463819;
        // ---------- Original Method ----------
        //Object object = opt(name);
        //return object instanceof JSONObject ? (JSONObject) object : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.439 -0400", hash_original_method = "1E876AFA246F164144A4BA68FB0C8527", hash_generated_method = "FD1C1AF3E81DE987FA265D62722C0443")
    public JSONArray toJSONArray(JSONArray names) throws JSONException {
        addTaint(names.getTaint());
        JSONArray result = new JSONArray();
        if(names == null)        
        {
JSONArray var540C13E9E156B687226421B24F2DF178_481313169 =             null;
            var540C13E9E156B687226421B24F2DF178_481313169.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_481313169;
        } //End block
        int length = names.length();
        if(length == 0)        
        {
JSONArray var540C13E9E156B687226421B24F2DF178_1633208443 =             null;
            var540C13E9E156B687226421B24F2DF178_1633208443.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1633208443;
        } //End block
for(int i = 0;i < length;i++)
        {
            String name = JSON.toString(names.opt(i));
            result.put(opt(name));
        } //End block
JSONArray varDC838461EE2FA0CA4C9BBB70A15456B0_1999075886 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1999075886.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1999075886;
        // ---------- Original Method ----------
        //JSONArray result = new JSONArray();
        //if (names == null) {
            //return null;
        //}
        //int length = names.length();
        //if (length == 0) {
            //return null;
        //}
        //for (int i = 0; i < length; i++) {
            //String name = JSON.toString(names.opt(i));
            //result.put(opt(name));
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.440 -0400", hash_original_method = "2D137981D66EA2E55940EA81187D393D", hash_generated_method = "ECCD2A49213B7BCECCFDDAA85B03E1AC")
    public Iterator keys() {
Iterator var90C1FF8CAFF3DBC174B2F12D3FF74ED5_1526000145 =         nameValuePairs.keySet().iterator();
        var90C1FF8CAFF3DBC174B2F12D3FF74ED5_1526000145.addTaint(taint);
        return var90C1FF8CAFF3DBC174B2F12D3FF74ED5_1526000145;
        // ---------- Original Method ----------
        //return nameValuePairs.keySet().iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.440 -0400", hash_original_method = "3ECE715C4DC492B6D08AC6D2EACB5C9C", hash_generated_method = "1F5D236A188F699D087C6CF7C0231E5D")
    public JSONArray names() {
JSONArray varC2F50F9E81BA5C7E6E5814BD9BD1AA90_2047855242 =         nameValuePairs.isEmpty()
                ? null
                : new JSONArray(new ArrayList<String>(nameValuePairs.keySet()));
        varC2F50F9E81BA5C7E6E5814BD9BD1AA90_2047855242.addTaint(taint);
        return varC2F50F9E81BA5C7E6E5814BD9BD1AA90_2047855242;
        // ---------- Original Method ----------
        //return nameValuePairs.isEmpty()
                //? null
                //: new JSONArray(new ArrayList<String>(nameValuePairs.keySet()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.441 -0400", hash_original_method = "CC6BE78472EEEAF64E530CA9F9B14BB5", hash_generated_method = "483FDF13296D006071FE3A886D9391E3")
    @Override
    public String toString() {
        try 
        {
            JSONStringer stringer = new JSONStringer();
            writeTo(stringer);
String varC93F6F7CA20C01E1D5F7833A2EB9AB40_537145062 =             stringer.toString();
            varC93F6F7CA20C01E1D5F7833A2EB9AB40_537145062.addTaint(taint);
            return varC93F6F7CA20C01E1D5F7833A2EB9AB40_537145062;
        } //End block
        catch (JSONException e)
        {
String var540C13E9E156B687226421B24F2DF178_1725918756 =             null;
            var540C13E9E156B687226421B24F2DF178_1725918756.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1725918756;
        } //End block
        // ---------- Original Method ----------
        //try {
            //JSONStringer stringer = new JSONStringer();
            //writeTo(stringer);
            //return stringer.toString();
        //} catch (JSONException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.441 -0400", hash_original_method = "161CBAA0F7E505CC65BF62A9F4C8490E", hash_generated_method = "86C637B885C13BC1D9DFAA47E02D4960")
    public String toString(int indentSpaces) throws JSONException {
        addTaint(indentSpaces);
        JSONStringer stringer = new JSONStringer(indentSpaces);
        writeTo(stringer);
String varC93F6F7CA20C01E1D5F7833A2EB9AB40_939484906 =         stringer.toString();
        varC93F6F7CA20C01E1D5F7833A2EB9AB40_939484906.addTaint(taint);
        return varC93F6F7CA20C01E1D5F7833A2EB9AB40_939484906;
        // ---------- Original Method ----------
        //JSONStringer stringer = new JSONStringer(indentSpaces);
        //writeTo(stringer);
        //return stringer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.442 -0400", hash_original_method = "4318203F3538DC271461FDA2F00ABD52", hash_generated_method = "80B7D4DEA6C8018B2B7F71E1139CBC9B")
     void writeTo(JSONStringer stringer) throws JSONException {
        addTaint(stringer.getTaint());
        stringer.object();
for(Map.Entry<String, Object> entry : nameValuePairs.entrySet())
        {
            stringer.key(entry.getKey()).value(entry.getValue());
        } //End block
        stringer.endObject();
        // ---------- Original Method ----------
        //stringer.object();
        //for (Map.Entry<String, Object> entry : nameValuePairs.entrySet()) {
            //stringer.key(entry.getKey()).value(entry.getValue());
        //}
        //stringer.endObject();
    }

    
    public static String numberToString(Number number) throws JSONException {
        if (number == null) {
            throw new JSONException("Number must be non-null");
        }
        double doubleValue = number.doubleValue();
        JSON.checkDouble(doubleValue);
        if (number.equals(NEGATIVE_ZERO)) {
            return "-0";
        }
        long longValue = number.longValue();
        if (doubleValue == (double) longValue) {
            return Long.toString(longValue);
        }
        return number.toString();
    }

    
    public static String quote(String data) {
        if (data == null) {
            return "\"\"";
        }
        try {
            JSONStringer stringer = new JSONStringer();
            stringer.open(JSONStringer.Scope.NULL, "");
            stringer.value(data);
            stringer.close(JSONStringer.Scope.NULL, JSONStringer.Scope.NULL, "");
            return stringer.toString();
        } catch (JSONException e) {
            throw new AssertionError();
        }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.443 -0400", hash_original_field = "4F8E83C95CFEE5158C01389EEFC269AA", hash_generated_field = "1DBE8D3C6A9A7131154428322A8B1823")

    private static final Double NEGATIVE_ZERO = -0d;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.299 -0400", hash_original_field = "69D6A2BFA9970459DEF9916A4A819505", hash_generated_field = "3F3D3946D0FBB086C49E80D158F100D9")

    public static final Object NULL = new Object() {
        @Override public boolean equals(Object o) {
            return o == this || o == null; 
        }
        @DSModeled(DSC.SAFE)
    @Override public String toString() {
            return "null";
        }
    };
    // orphaned legacy method
    @Override public boolean equals(Object o) {
            return o == this || o == null; 
        }
    
}

