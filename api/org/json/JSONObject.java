package org.json;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JSONObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.551 -0400", hash_original_field = "1CF5E4F247CC69AF70109AE4475648CB", hash_generated_field = "4AEF8EB90733274F8DF38365152EB324")

    private Map<String, Object> nameValuePairs;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.552 -0400", hash_original_method = "B0BA44B1CBEEB832685DE1D9CC551D36", hash_generated_method = "8AB77AFCB9DCE98AE75372C152EFAE46")
    public  JSONObject() {
        nameValuePairs = new HashMap<String, Object>();
        // ---------- Original Method ----------
        //nameValuePairs = new HashMap<String, Object>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.552 -0400", hash_original_method = "64F11EBDF44BE4F1CBC516D3CD1F34E9", hash_generated_method = "1308B1FE71F4AEF4DC48C203C50EFC24")
    public  JSONObject(Map copyFrom) {
        this();
        addTaint(copyFrom.getTaint());
        Map<?, ?> contentsTyped = (Map<?, ?>) copyFrom;
for(Map.Entry<?, ?> entry : contentsTyped.entrySet())
        {
            String key = (String) entry.getKey();
    if(key == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1464463895 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_1464463895.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_1464463895;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.558 -0400", hash_original_method = "E218F03BB03DC7D8503E0318225F7859", hash_generated_method = "C4263EF5B66C3A8C7E911DEA39D3D368")
    public  JSONObject(JSONTokener readFrom) throws JSONException {
        addTaint(readFrom.getTaint());
        Object object = readFrom.nextValue();
    if(object instanceof JSONObject)        
        {
            this.nameValuePairs = ((JSONObject) object).nameValuePairs;
        } //End block
        else
        {
            org.json.JSONException var90C9EBF3FED9A5CB53D4E04A4EF3A79E_543594911 = JSON.typeMismatch(object, "JSONObject");
            var90C9EBF3FED9A5CB53D4E04A4EF3A79E_543594911.addTaint(taint);
            throw var90C9EBF3FED9A5CB53D4E04A4EF3A79E_543594911;
        } //End block
        // ---------- Original Method ----------
        //Object object = readFrom.nextValue();
        //if (object instanceof JSONObject) {
            //this.nameValuePairs = ((JSONObject) object).nameValuePairs;
        //} else {
            //throw JSON.typeMismatch(object, "JSONObject");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.559 -0400", hash_original_method = "27B9491B51940DE15585B798AFD3D304", hash_generated_method = "64C04C1F10C31248B34728372555B741")
    public  JSONObject(String json) throws JSONException {
        this(new JSONTokener(json));
        addTaint(json.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.559 -0400", hash_original_method = "D555E6715A2E6E4EC106278BB66ED891", hash_generated_method = "6BC75BDB852C19D587B381DACC612A52")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.560 -0400", hash_original_method = "BB0C5A7042ADC1F8FC4BAA64EBFD2B52", hash_generated_method = "8C9FB3B1DC0EED78E4DC0D0DDE35CF8D")
    public int length() {
        int var467D07E7C5E56858F17E6E5897393971_822826392 = (nameValuePairs.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1400508996 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1400508996;
        // ---------- Original Method ----------
        //return nameValuePairs.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.560 -0400", hash_original_method = "43A124AF3EF8B2736A46103CC8729DE3", hash_generated_method = "C98A08903B367EBDB36477324B51EDBE")
    public JSONObject put(String name, boolean value) throws JSONException {
        addTaint(value);
        addTaint(name.getTaint());
        nameValuePairs.put(checkName(name), value);
JSONObject var72A74007B2BE62B849F475C7BDA4658B_1743208179 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1743208179.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1743208179;
        // ---------- Original Method ----------
        //nameValuePairs.put(checkName(name), value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.560 -0400", hash_original_method = "FF23ECF2F7B3A424BD0CA2B446E9E0DB", hash_generated_method = "DEB9704DF8EB6482D255B9A336B29CE7")
    public JSONObject put(String name, double value) throws JSONException {
        addTaint(value);
        addTaint(name.getTaint());
        nameValuePairs.put(checkName(name), JSON.checkDouble(value));
JSONObject var72A74007B2BE62B849F475C7BDA4658B_1866911157 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1866911157.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1866911157;
        // ---------- Original Method ----------
        //nameValuePairs.put(checkName(name), JSON.checkDouble(value));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.561 -0400", hash_original_method = "14B3109A64A28D2764163C4077CDC45D", hash_generated_method = "787A4F2917C803FD439593CCDCCA4F42")
    public JSONObject put(String name, int value) throws JSONException {
        addTaint(value);
        addTaint(name.getTaint());
        nameValuePairs.put(checkName(name), value);
JSONObject var72A74007B2BE62B849F475C7BDA4658B_363852557 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_363852557.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_363852557;
        // ---------- Original Method ----------
        //nameValuePairs.put(checkName(name), value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.561 -0400", hash_original_method = "0E78BCAD739042DC347A7959C52D188A", hash_generated_method = "70048C34496FA9E2982E974C09CB70E5")
    public JSONObject put(String name, long value) throws JSONException {
        addTaint(value);
        addTaint(name.getTaint());
        nameValuePairs.put(checkName(name), value);
JSONObject var72A74007B2BE62B849F475C7BDA4658B_264636251 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_264636251.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_264636251;
        // ---------- Original Method ----------
        //nameValuePairs.put(checkName(name), value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.561 -0400", hash_original_method = "8B4C0C01745202135A0373E57DFB791E", hash_generated_method = "B3F6ACE97F6C5D79CCDB6C4CCBC743CF")
    public JSONObject put(String name, Object value) throws JSONException {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
    if(value == null)        
        {
            nameValuePairs.remove(name);
JSONObject var72A74007B2BE62B849F475C7BDA4658B_703185857 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_703185857.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_703185857;
        } //End block
    if(value instanceof Number)        
        {
            JSON.checkDouble(((Number) value).doubleValue());
        } //End block
        nameValuePairs.put(checkName(name), value);
JSONObject var72A74007B2BE62B849F475C7BDA4658B_1878693012 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1878693012.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1878693012;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.562 -0400", hash_original_method = "D9589667A2509A719F9DF68E891B85DD", hash_generated_method = "D0057D246C3D2A4AC7FF53FB7B268F13")
    public JSONObject putOpt(String name, Object value) throws JSONException {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
    if(name == null || value == null)        
        {
JSONObject var72A74007B2BE62B849F475C7BDA4658B_352950631 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_352950631.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_352950631;
        } //End block
JSONObject varF4258CA79FCE8127789B8A196F5E12F0_935968944 =         put(name, value);
        varF4258CA79FCE8127789B8A196F5E12F0_935968944.addTaint(taint);
        return varF4258CA79FCE8127789B8A196F5E12F0_935968944;
        // ---------- Original Method ----------
        //if (name == null || value == null) {
            //return this;
        //}
        //return put(name, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.562 -0400", hash_original_method = "5A758AD2B70A18447D6617A35807B03B", hash_generated_method = "FEF225846C09104BF99626C3E38BABC2")
    public JSONObject accumulate(String name, Object value) throws JSONException {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        Object current = nameValuePairs.get(checkName(name));
    if(current == null)        
        {
JSONObject varF4258CA79FCE8127789B8A196F5E12F0_687063421 =             put(name, value);
            varF4258CA79FCE8127789B8A196F5E12F0_687063421.addTaint(taint);
            return varF4258CA79FCE8127789B8A196F5E12F0_687063421;
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
JSONObject var72A74007B2BE62B849F475C7BDA4658B_46505807 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_46505807.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_46505807;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.562 -0400", hash_original_method = "1AA4BB08CA8C9DDACC6E60D58C017824", hash_generated_method = "06E009E5B3EECAAFD40E961B5F6E9F81")
     String checkName(String name) throws JSONException {
        addTaint(name.getTaint());
    if(name == null)        
        {
            JSONException var9A1D8F2D16FCC2E33BC2C66F205FA660_549476096 = new JSONException("Names must be non-null");
            var9A1D8F2D16FCC2E33BC2C66F205FA660_549476096.addTaint(taint);
            throw var9A1D8F2D16FCC2E33BC2C66F205FA660_549476096;
        } //End block
String varB017984728AC60AD1F0BF8734F33F15C_540300896 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_540300896.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_540300896;
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new JSONException("Names must be non-null");
        //}
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.563 -0400", hash_original_method = "BEB5EB52101798DC8AC0FA25480A2C90", hash_generated_method = "B864CDF84FB22DECCD2C42C6C1B958E2")
    public Object remove(String name) {
        addTaint(name.getTaint());
Object var5C3FEDC697FE2142673642233C51611C_1351181988 =         nameValuePairs.remove(name);
        var5C3FEDC697FE2142673642233C51611C_1351181988.addTaint(taint);
        return var5C3FEDC697FE2142673642233C51611C_1351181988;
        // ---------- Original Method ----------
        //return nameValuePairs.remove(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.563 -0400", hash_original_method = "A1CD692FA856D7FF90D2024A71E93EE6", hash_generated_method = "351C6F20A6820102FCC19666F82F7EFA")
    public boolean isNull(String name) {
        addTaint(name.getTaint());
        Object value = nameValuePairs.get(name);
        boolean varDEFD64AE43306007731811C5F60CE9D5_2076662087 = (value == null || value == NULL);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1830921365 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1830921365;
        // ---------- Original Method ----------
        //Object value = nameValuePairs.get(name);
        //return value == null || value == NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.563 -0400", hash_original_method = "297E71AC76AEECD92DCC3FA05327BE46", hash_generated_method = "0AE4FC165905B1A20BC8602E2A68C395")
    public boolean has(String name) {
        addTaint(name.getTaint());
        boolean varC31F79B949B7EFC4BCC33E5362FF7D9E_953782191 = (nameValuePairs.containsKey(name));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1703529796 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1703529796;
        // ---------- Original Method ----------
        //return nameValuePairs.containsKey(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.564 -0400", hash_original_method = "C38AAF9284AEE2A94970713BC651F263", hash_generated_method = "36B1CB94ECD39EA04584223EE1BD0202")
    public Object get(String name) throws JSONException {
        addTaint(name.getTaint());
        Object result = nameValuePairs.get(name);
    if(result == null)        
        {
            JSONException var5FF827AAE76577AA6C59AD8913073D0F_1982519448 = new JSONException("No value for " + name);
            var5FF827AAE76577AA6C59AD8913073D0F_1982519448.addTaint(taint);
            throw var5FF827AAE76577AA6C59AD8913073D0F_1982519448;
        } //End block
Object varDC838461EE2FA0CA4C9BBB70A15456B0_1448922752 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1448922752.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1448922752;
        // ---------- Original Method ----------
        //Object result = nameValuePairs.get(name);
        //if (result == null) {
            //throw new JSONException("No value for " + name);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.564 -0400", hash_original_method = "05A351DC7DE639568132A573A6E2106E", hash_generated_method = "CB1EBD70E4C5487A3BD3E992EEBBC352")
    public Object opt(String name) {
        addTaint(name.getTaint());
Object varB9044C5D5774441342719E1E55B7D84F_1137899335 =         nameValuePairs.get(name);
        varB9044C5D5774441342719E1E55B7D84F_1137899335.addTaint(taint);
        return varB9044C5D5774441342719E1E55B7D84F_1137899335;
        // ---------- Original Method ----------
        //return nameValuePairs.get(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.570 -0400", hash_original_method = "7B38D2B2DBA3C433303B4D117D86E4E0", hash_generated_method = "F69AF111B5FA5AF868B597E33A17CD19")
    public boolean getBoolean(String name) throws JSONException {
        addTaint(name.getTaint());
        Object object = get(name);
        Boolean result = JSON.toBoolean(object);
    if(result == null)        
        {
            org.json.JSONException varF58CE7A4254BFFEEFD830CD9FF78D7CC_1504898179 = JSON.typeMismatch(name, object, "boolean");
            varF58CE7A4254BFFEEFD830CD9FF78D7CC_1504898179.addTaint(taint);
            throw varF58CE7A4254BFFEEFD830CD9FF78D7CC_1504898179;
        } //End block
        boolean varB4A88417B3D0170D754C647C30B7216A_307423325 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_66915304 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_66915304;
        // ---------- Original Method ----------
        //Object object = get(name);
        //Boolean result = JSON.toBoolean(object);
        //if (result == null) {
            //throw JSON.typeMismatch(name, object, "boolean");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.570 -0400", hash_original_method = "3DA4544CD80345F7570489979490BD16", hash_generated_method = "B8766DD8FFCB93B3C5EA64649A709260")
    public boolean optBoolean(String name) {
        addTaint(name.getTaint());
        boolean varCA5EADA135CE663AA3ADC46C47E21C3D_1579736992 = (optBoolean(name, false));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1616154199 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1616154199;
        // ---------- Original Method ----------
        //return optBoolean(name, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.571 -0400", hash_original_method = "C49CAFC4CC69BC825D274D7317108A68", hash_generated_method = "A35B413D20F7643180F01287167069A6")
    public boolean optBoolean(String name, boolean fallback) {
        addTaint(fallback);
        addTaint(name.getTaint());
        Object object = opt(name);
        Boolean result = JSON.toBoolean(object);
        boolean varD432CC74B2878A4B571046B2CA3AAD1D_1919723130 = (result != null ? result : fallback);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1591299754 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1591299754;
        // ---------- Original Method ----------
        //Object object = opt(name);
        //Boolean result = JSON.toBoolean(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.575 -0400", hash_original_method = "0C60D6C72644A8965D87529BB9443348", hash_generated_method = "CC2722B86D77E415ECDAA5B6DCCFD75A")
    public double getDouble(String name) throws JSONException {
        addTaint(name.getTaint());
        Object object = get(name);
        Double result = JSON.toDouble(object);
    if(result == null)        
        {
            org.json.JSONException varDC64F5E217E93E52C55DC32B76E3DC6E_373095455 = JSON.typeMismatch(name, object, "double");
            varDC64F5E217E93E52C55DC32B76E3DC6E_373095455.addTaint(taint);
            throw varDC64F5E217E93E52C55DC32B76E3DC6E_373095455;
        } //End block
        double varB4A88417B3D0170D754C647C30B7216A_482307343 = (result);
                double varE8CD7DA078A86726031AD64F35F5A6C0_870382628 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_870382628;
        // ---------- Original Method ----------
        //Object object = get(name);
        //Double result = JSON.toDouble(object);
        //if (result == null) {
            //throw JSON.typeMismatch(name, object, "double");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.576 -0400", hash_original_method = "B9CFB7D5CC2BB58B8CACB29638DEE6A6", hash_generated_method = "7857D9391B7333DCC1D924C34766DB3A")
    public double optDouble(String name) {
        addTaint(name.getTaint());
        double varB835673D3752B5F2A3CCECC009044C56_2002439674 = (optDouble(name, Double.NaN));
                double varE8CD7DA078A86726031AD64F35F5A6C0_1295531226 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1295531226;
        // ---------- Original Method ----------
        //return optDouble(name, Double.NaN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.576 -0400", hash_original_method = "F525E9AC5AAC714EA253692C6DC9EE0E", hash_generated_method = "4B33302949A4BAA7BC310FFFF95B4A48")
    public double optDouble(String name, double fallback) {
        addTaint(fallback);
        addTaint(name.getTaint());
        Object object = opt(name);
        Double result = JSON.toDouble(object);
        double varD432CC74B2878A4B571046B2CA3AAD1D_494980481 = (result != null ? result : fallback);
                double varE8CD7DA078A86726031AD64F35F5A6C0_1776827185 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1776827185;
        // ---------- Original Method ----------
        //Object object = opt(name);
        //Double result = JSON.toDouble(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.582 -0400", hash_original_method = "06DD6202AFC58B0F1BA6F9DBAA37C5F3", hash_generated_method = "EC84D0ADB9CF1FD4E819D627255B1E63")
    public int getInt(String name) throws JSONException {
        addTaint(name.getTaint());
        Object object = get(name);
        Integer result = JSON.toInteger(object);
    if(result == null)        
        {
            org.json.JSONException var993B2EFD9D82DE5C324D7735C9A9E5F6_1865402870 = JSON.typeMismatch(name, object, "int");
            var993B2EFD9D82DE5C324D7735C9A9E5F6_1865402870.addTaint(taint);
            throw var993B2EFD9D82DE5C324D7735C9A9E5F6_1865402870;
        } //End block
        int varB4A88417B3D0170D754C647C30B7216A_1838460156 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_178812107 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_178812107;
        // ---------- Original Method ----------
        //Object object = get(name);
        //Integer result = JSON.toInteger(object);
        //if (result == null) {
            //throw JSON.typeMismatch(name, object, "int");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.583 -0400", hash_original_method = "CF8C56AE8C6952FAAA48007CA568A3BF", hash_generated_method = "F1923AD94DBF2A1365BEFC59FD9A5812")
    public int optInt(String name) {
        addTaint(name.getTaint());
        int var84FC0CBFC698299AA22FFAC69E130380_1037427601 = (optInt(name, 0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1191852610 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1191852610;
        // ---------- Original Method ----------
        //return optInt(name, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.583 -0400", hash_original_method = "FC3121A883EAF5555BD9C194D7925D34", hash_generated_method = "5B4F6CA02142B9EF531D06431771F3E7")
    public int optInt(String name, int fallback) {
        addTaint(fallback);
        addTaint(name.getTaint());
        Object object = opt(name);
        Integer result = JSON.toInteger(object);
        int varD432CC74B2878A4B571046B2CA3AAD1D_2059031305 = (result != null ? result : fallback);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1500973460 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1500973460;
        // ---------- Original Method ----------
        //Object object = opt(name);
        //Integer result = JSON.toInteger(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.591 -0400", hash_original_method = "55ABC1042FFC5D7EF9272460461F1426", hash_generated_method = "6C997D2E2A100F249CA81515C3545BBF")
    public long getLong(String name) throws JSONException {
        addTaint(name.getTaint());
        Object object = get(name);
        Long result = JSON.toLong(object);
    if(result == null)        
        {
            org.json.JSONException var663EF30E21300B7BF6F0F99F89F7F327_609706095 = JSON.typeMismatch(name, object, "long");
            var663EF30E21300B7BF6F0F99F89F7F327_609706095.addTaint(taint);
            throw var663EF30E21300B7BF6F0F99F89F7F327_609706095;
        } //End block
        long varB4A88417B3D0170D754C647C30B7216A_371717140 = (result);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_371823880 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_371823880;
        // ---------- Original Method ----------
        //Object object = get(name);
        //Long result = JSON.toLong(object);
        //if (result == null) {
            //throw JSON.typeMismatch(name, object, "long");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.591 -0400", hash_original_method = "70DEF89A3C807E0937F5C9E9E3A1A203", hash_generated_method = "A82687B0FCA376752CB7EA789F97436F")
    public long optLong(String name) {
        addTaint(name.getTaint());
        long varC5B1BB326733C74FD164F9452BD3B7C9_1529895684 = (optLong(name, 0L));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_665911779 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_665911779;
        // ---------- Original Method ----------
        //return optLong(name, 0L);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.592 -0400", hash_original_method = "C94BC7D2B7352E7323E9E58C53ACE476", hash_generated_method = "55D765A179711D0103F6D02E2185EC0A")
    public long optLong(String name, long fallback) {
        addTaint(fallback);
        addTaint(name.getTaint());
        Object object = opt(name);
        Long result = JSON.toLong(object);
        long varD432CC74B2878A4B571046B2CA3AAD1D_798071694 = (result != null ? result : fallback);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_965351636 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_965351636;
        // ---------- Original Method ----------
        //Object object = opt(name);
        //Long result = JSON.toLong(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.599 -0400", hash_original_method = "CC649536AC568087B4414076D420F027", hash_generated_method = "642BD3E0A4681EA516D59C1E74FAE597")
    public String getString(String name) throws JSONException {
        addTaint(name.getTaint());
        Object object = get(name);
        String result = JSON.toString(object);
    if(result == null)        
        {
            org.json.JSONException var6EB12F9F79CDE0595AD32A2EB3D43164_1750344479 = JSON.typeMismatch(name, object, "String");
            var6EB12F9F79CDE0595AD32A2EB3D43164_1750344479.addTaint(taint);
            throw var6EB12F9F79CDE0595AD32A2EB3D43164_1750344479;
        } //End block
String varDC838461EE2FA0CA4C9BBB70A15456B0_596902225 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_596902225.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_596902225;
        // ---------- Original Method ----------
        //Object object = get(name);
        //String result = JSON.toString(object);
        //if (result == null) {
            //throw JSON.typeMismatch(name, object, "String");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.600 -0400", hash_original_method = "8B81E5CBB6FE92C9270C8AE14E1D248D", hash_generated_method = "1514F3520C08E5C3B4F2105F96484FB5")
    public String optString(String name) {
        addTaint(name.getTaint());
String var0CE80B357AB5E5816978317628338B78_378227885 =         optString(name, "");
        var0CE80B357AB5E5816978317628338B78_378227885.addTaint(taint);
        return var0CE80B357AB5E5816978317628338B78_378227885;
        // ---------- Original Method ----------
        //return optString(name, "");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.600 -0400", hash_original_method = "B4BBF2951ACCBF79FD3FE8AB17DCAE83", hash_generated_method = "8DF646D50F856A0645790C8E52C6F0F6")
    public String optString(String name, String fallback) {
        addTaint(fallback.getTaint());
        addTaint(name.getTaint());
        Object object = opt(name);
        String result = JSON.toString(object);
String varB29C31EA7BA163F0F2187995ADA1E48E_1633321034 =         result != null ? result : fallback;
        varB29C31EA7BA163F0F2187995ADA1E48E_1633321034.addTaint(taint);
        return varB29C31EA7BA163F0F2187995ADA1E48E_1633321034;
        // ---------- Original Method ----------
        //Object object = opt(name);
        //String result = JSON.toString(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.609 -0400", hash_original_method = "1CE1CD2D1D65AA0859027B9575FA80C4", hash_generated_method = "67E809D17FFBD76AFEC1BE4F363E1F71")
    public JSONArray getJSONArray(String name) throws JSONException {
        addTaint(name.getTaint());
        Object object = get(name);
    if(object instanceof JSONArray)        
        {
JSONArray varA31A6C9B348464F1BAAA1B1373E54400_1620291757 =             (JSONArray) object;
            varA31A6C9B348464F1BAAA1B1373E54400_1620291757.addTaint(taint);
            return varA31A6C9B348464F1BAAA1B1373E54400_1620291757;
        } //End block
        else
        {
            org.json.JSONException varEAF21408DDD198DA03E57B84CD4AB662_1799758762 = JSON.typeMismatch(name, object, "JSONArray");
            varEAF21408DDD198DA03E57B84CD4AB662_1799758762.addTaint(taint);
            throw varEAF21408DDD198DA03E57B84CD4AB662_1799758762;
        } //End block
        // ---------- Original Method ----------
        //Object object = get(name);
        //if (object instanceof JSONArray) {
            //return (JSONArray) object;
        //} else {
            //throw JSON.typeMismatch(name, object, "JSONArray");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.610 -0400", hash_original_method = "576EFB0CB9E2FA91FCF1D9A3EF1337C6", hash_generated_method = "E09A258391213C6102379337A54165C9")
    public JSONArray optJSONArray(String name) {
        addTaint(name.getTaint());
        Object object = opt(name);
JSONArray var37D15C802F10CA15BA7D983DBF1DB879_217499875 =         object instanceof JSONArray ? (JSONArray) object : null;
        var37D15C802F10CA15BA7D983DBF1DB879_217499875.addTaint(taint);
        return var37D15C802F10CA15BA7D983DBF1DB879_217499875;
        // ---------- Original Method ----------
        //Object object = opt(name);
        //return object instanceof JSONArray ? (JSONArray) object : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.626 -0400", hash_original_method = "5326315C93466A3B1E8C695224A5B5FD", hash_generated_method = "C8219E2AE71B077F1A635DDF4FC2D9E0")
    public JSONObject getJSONObject(String name) throws JSONException {
        addTaint(name.getTaint());
        Object object = get(name);
    if(object instanceof JSONObject)        
        {
JSONObject varA963CC0194E284A145B65210ED1E5C63_183320468 =             (JSONObject) object;
            varA963CC0194E284A145B65210ED1E5C63_183320468.addTaint(taint);
            return varA963CC0194E284A145B65210ED1E5C63_183320468;
        } //End block
        else
        {
            org.json.JSONException var36B0E52DCB924D05CBFE61A301258646_822707794 = JSON.typeMismatch(name, object, "JSONObject");
            var36B0E52DCB924D05CBFE61A301258646_822707794.addTaint(taint);
            throw var36B0E52DCB924D05CBFE61A301258646_822707794;
        } //End block
        // ---------- Original Method ----------
        //Object object = get(name);
        //if (object instanceof JSONObject) {
            //return (JSONObject) object;
        //} else {
            //throw JSON.typeMismatch(name, object, "JSONObject");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.626 -0400", hash_original_method = "B736B3B7313026EC1CBB4CB1D3C2367D", hash_generated_method = "0A3861E4E6E5665A359A71B8FDF6554C")
    public JSONObject optJSONObject(String name) {
        addTaint(name.getTaint());
        Object object = opt(name);
JSONObject varE8B2189D470FA34838D00114FC8343E3_1318311293 =         object instanceof JSONObject ? (JSONObject) object : null;
        varE8B2189D470FA34838D00114FC8343E3_1318311293.addTaint(taint);
        return varE8B2189D470FA34838D00114FC8343E3_1318311293;
        // ---------- Original Method ----------
        //Object object = opt(name);
        //return object instanceof JSONObject ? (JSONObject) object : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.626 -0400", hash_original_method = "1E876AFA246F164144A4BA68FB0C8527", hash_generated_method = "CB299E958C6AADC03006683C4640DC9B")
    public JSONArray toJSONArray(JSONArray names) throws JSONException {
        addTaint(names.getTaint());
        JSONArray result = new JSONArray();
    if(names == null)        
        {
JSONArray var540C13E9E156B687226421B24F2DF178_1476462175 =             null;
            var540C13E9E156B687226421B24F2DF178_1476462175.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1476462175;
        } //End block
        int length = names.length();
    if(length == 0)        
        {
JSONArray var540C13E9E156B687226421B24F2DF178_1282732628 =             null;
            var540C13E9E156B687226421B24F2DF178_1282732628.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1282732628;
        } //End block
for(int i = 0;i < length;i++)
        {
            String name = JSON.toString(names.opt(i));
            result.put(opt(name));
        } //End block
JSONArray varDC838461EE2FA0CA4C9BBB70A15456B0_680356067 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_680356067.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_680356067;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.626 -0400", hash_original_method = "2D137981D66EA2E55940EA81187D393D", hash_generated_method = "3C134D0AB34E001C18A5C5E64AF05469")
    public Iterator keys() {
Iterator var90C1FF8CAFF3DBC174B2F12D3FF74ED5_1100979877 =         nameValuePairs.keySet().iterator();
        var90C1FF8CAFF3DBC174B2F12D3FF74ED5_1100979877.addTaint(taint);
        return var90C1FF8CAFF3DBC174B2F12D3FF74ED5_1100979877;
        // ---------- Original Method ----------
        //return nameValuePairs.keySet().iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.626 -0400", hash_original_method = "3ECE715C4DC492B6D08AC6D2EACB5C9C", hash_generated_method = "A028CCED9417D7C6139B1C4B296D6DB5")
    public JSONArray names() {
JSONArray varC2F50F9E81BA5C7E6E5814BD9BD1AA90_951649472 =         nameValuePairs.isEmpty()
                ? null
                : new JSONArray(new ArrayList<String>(nameValuePairs.keySet()));
        varC2F50F9E81BA5C7E6E5814BD9BD1AA90_951649472.addTaint(taint);
        return varC2F50F9E81BA5C7E6E5814BD9BD1AA90_951649472;
        // ---------- Original Method ----------
        //return nameValuePairs.isEmpty()
                //? null
                //: new JSONArray(new ArrayList<String>(nameValuePairs.keySet()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.626 -0400", hash_original_method = "CC6BE78472EEEAF64E530CA9F9B14BB5", hash_generated_method = "3747AEAEB351CF5AC76B261F2676607B")
    @Override
    public String toString() {
        try 
        {
            JSONStringer stringer = new JSONStringer();
            writeTo(stringer);
String varC93F6F7CA20C01E1D5F7833A2EB9AB40_1143822623 =             stringer.toString();
            varC93F6F7CA20C01E1D5F7833A2EB9AB40_1143822623.addTaint(taint);
            return varC93F6F7CA20C01E1D5F7833A2EB9AB40_1143822623;
        } //End block
        catch (JSONException e)
        {
String var540C13E9E156B687226421B24F2DF178_1095727315 =             null;
            var540C13E9E156B687226421B24F2DF178_1095727315.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1095727315;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.627 -0400", hash_original_method = "161CBAA0F7E505CC65BF62A9F4C8490E", hash_generated_method = "785E4A1E3709414EE3F7418577FC492C")
    public String toString(int indentSpaces) throws JSONException {
        addTaint(indentSpaces);
        JSONStringer stringer = new JSONStringer(indentSpaces);
        writeTo(stringer);
String varC93F6F7CA20C01E1D5F7833A2EB9AB40_2118374913 =         stringer.toString();
        varC93F6F7CA20C01E1D5F7833A2EB9AB40_2118374913.addTaint(taint);
        return varC93F6F7CA20C01E1D5F7833A2EB9AB40_2118374913;
        // ---------- Original Method ----------
        //JSONStringer stringer = new JSONStringer(indentSpaces);
        //writeTo(stringer);
        //return stringer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.627 -0400", hash_original_method = "4318203F3538DC271461FDA2F00ABD52", hash_generated_method = "80B7D4DEA6C8018B2B7F71E1139CBC9B")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.627 -0400", hash_original_field = "4F8E83C95CFEE5158C01389EEFC269AA", hash_generated_field = "1DBE8D3C6A9A7131154428322A8B1823")

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

