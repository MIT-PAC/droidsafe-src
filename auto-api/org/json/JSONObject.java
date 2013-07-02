package org.json;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JSONObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.245 -0400", hash_original_field = "1CF5E4F247CC69AF70109AE4475648CB", hash_generated_field = "4AEF8EB90733274F8DF38365152EB324")

    private Map<String, Object> nameValuePairs;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.246 -0400", hash_original_method = "B0BA44B1CBEEB832685DE1D9CC551D36", hash_generated_method = "8AB77AFCB9DCE98AE75372C152EFAE46")
    public  JSONObject() {
        nameValuePairs = new HashMap<String, Object>();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.249 -0400", hash_original_method = "64F11EBDF44BE4F1CBC516D3CD1F34E9", hash_generated_method = "9F92DAAEB007F89A0622D1FEF6712AA8")
    public  JSONObject(Map copyFrom) {
        this();
        Map<?, ?> contentsTyped = (Map<?, ?>) copyFrom;
        {
            contentsTyped.entrySet().iterator().hasNext();
            Map.Entry<?, ?> entry = contentsTyped.entrySet().iterator().next();
            {
                String key = (String) entry.getKey();
                {
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
                } 
                nameValuePairs.put(key, entry.getValue());
            } 
        } 
        addTaint(copyFrom.getTaint());
        
        
        
            
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.250 -0400", hash_original_method = "E218F03BB03DC7D8503E0318225F7859", hash_generated_method = "86E62E1D3821BEB224773FFC57ED9B06")
    public  JSONObject(JSONTokener readFrom) throws JSONException {
        Object object = readFrom.nextValue();
        {
            this.nameValuePairs = ((JSONObject) object).nameValuePairs;
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(object, "JSONObject");
        } 
        addTaint(readFrom.getTaint());
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.250 -0400", hash_original_method = "27B9491B51940DE15585B798AFD3D304", hash_generated_method = "64C04C1F10C31248B34728372555B741")
    public  JSONObject(String json) throws JSONException {
        this(new JSONTokener(json));
        addTaint(json.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.253 -0400", hash_original_method = "D555E6715A2E6E4EC106278BB66ED891", hash_generated_method = "448A0F738F553671816A43F8C720CF9F")
    public  JSONObject(JSONObject copyFrom, String[] names) throws JSONException {
        this();
        {
            String name = names[0];
            {
                Object value = copyFrom.opt(name);
                {
                    nameValuePairs.put(name, value);
                } 
            } 
        } 
        addTaint(copyFrom.getTaint());
        addTaint(names[0].getTaint());
        
        
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.253 -0400", hash_original_method = "BB0C5A7042ADC1F8FC4BAA64EBFD2B52", hash_generated_method = "B6E3F4AA80BED6DC447864F6424C8C8C")
    public int length() {
        int var5BCA4F4CB72BD4E013D6A2FD0A5A950A_68170779 = (nameValuePairs.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1111526204 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1111526204;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.254 -0400", hash_original_method = "43A124AF3EF8B2736A46103CC8729DE3", hash_generated_method = "78943B8116A83F93113D561B4FE013D4")
    public JSONObject put(String name, boolean value) throws JSONException {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_335461189 = null; 
        nameValuePairs.put(checkName(name), value);
        varB4EAC82CA7396A68D541C85D26508E83_335461189 = this;
        addTaint(name.getTaint());
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_335461189.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_335461189;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.255 -0400", hash_original_method = "FF23ECF2F7B3A424BD0CA2B446E9E0DB", hash_generated_method = "98A047DB67C599351732AFC82AF0925B")
    public JSONObject put(String name, double value) throws JSONException {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_1339256119 = null; 
        nameValuePairs.put(checkName(name), JSON.checkDouble(value));
        varB4EAC82CA7396A68D541C85D26508E83_1339256119 = this;
        addTaint(name.getTaint());
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1339256119.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1339256119;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.256 -0400", hash_original_method = "14B3109A64A28D2764163C4077CDC45D", hash_generated_method = "3B3B26450C42E269BB887535675B4E66")
    public JSONObject put(String name, int value) throws JSONException {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_1239323639 = null; 
        nameValuePairs.put(checkName(name), value);
        varB4EAC82CA7396A68D541C85D26508E83_1239323639 = this;
        addTaint(name.getTaint());
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1239323639.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1239323639;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.256 -0400", hash_original_method = "0E78BCAD739042DC347A7959C52D188A", hash_generated_method = "0E568502E2EA1D07719FE388709669C7")
    public JSONObject put(String name, long value) throws JSONException {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_560323806 = null; 
        nameValuePairs.put(checkName(name), value);
        varB4EAC82CA7396A68D541C85D26508E83_560323806 = this;
        addTaint(name.getTaint());
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_560323806.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_560323806;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.258 -0400", hash_original_method = "8B4C0C01745202135A0373E57DFB791E", hash_generated_method = "8A3AB92BD8E9CDB7B97E975D97463B13")
    public JSONObject put(String name, Object value) throws JSONException {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_71644995 = null; 
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_1896455663 = null; 
        {
            nameValuePairs.remove(name);
            varB4EAC82CA7396A68D541C85D26508E83_71644995 = this;
        } 
        {
            JSON.checkDouble(((Number) value).doubleValue());
        } 
        nameValuePairs.put(checkName(name), value);
        varB4EAC82CA7396A68D541C85D26508E83_1896455663 = this;
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        JSONObject varA7E53CE21691AB073D9660D615818899_1076530072; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1076530072 = varB4EAC82CA7396A68D541C85D26508E83_71644995;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1076530072 = varB4EAC82CA7396A68D541C85D26508E83_1896455663;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1076530072.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1076530072;
        
        
            
            
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.261 -0400", hash_original_method = "D9589667A2509A719F9DF68E891B85DD", hash_generated_method = "5CC750B8B8A11916D51A210DEF2CD03A")
    public JSONObject putOpt(String name, Object value) throws JSONException {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_802879368 = null; 
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_582792162 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_802879368 = this;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_582792162 = put(name, value);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        JSONObject varA7E53CE21691AB073D9660D615818899_8100051; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_8100051 = varB4EAC82CA7396A68D541C85D26508E83_802879368;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_8100051 = varB4EAC82CA7396A68D541C85D26508E83_582792162;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_8100051.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_8100051;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.264 -0400", hash_original_method = "5A758AD2B70A18447D6617A35807B03B", hash_generated_method = "B8F64C35FC176E4946D2FE4B3E6D24EE")
    public JSONObject accumulate(String name, Object value) throws JSONException {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_414561770 = null; 
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_1474913090 = null; 
        Object current = nameValuePairs.get(checkName(name));
        {
            varB4EAC82CA7396A68D541C85D26508E83_414561770 = put(name, value);
        } 
        {
            JSON.checkDouble(((Number) value).doubleValue());
        } 
        {
            JSONArray array = (JSONArray) current;
            array.put(value);
        } 
        {
            JSONArray array = new JSONArray();
            array.put(current);
            array.put(value);
            nameValuePairs.put(name, array);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1474913090 = this;
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        JSONObject varA7E53CE21691AB073D9660D615818899_858638701; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_858638701 = varB4EAC82CA7396A68D541C85D26508E83_414561770;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_858638701 = varB4EAC82CA7396A68D541C85D26508E83_1474913090;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_858638701.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_858638701;
        
        
        
            
        
        
            
        
        
            
            
        
            
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.265 -0400", hash_original_method = "1AA4BB08CA8C9DDACC6E60D58C017824", hash_generated_method = "AAAA97869772F57B920F79F9F756E292")
     String checkName(String name) throws JSONException {
        String varB4EAC82CA7396A68D541C85D26508E83_435806287 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new JSONException("Names must be non-null");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_435806287 = name;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_435806287.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_435806287;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.266 -0400", hash_original_method = "BEB5EB52101798DC8AC0FA25480A2C90", hash_generated_method = "EBB1D6AF6CFA48BCA76BC2C2EB040F81")
    public Object remove(String name) {
        Object varB4EAC82CA7396A68D541C85D26508E83_443555416 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_443555416 = nameValuePairs.remove(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_443555416.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_443555416;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.267 -0400", hash_original_method = "A1CD692FA856D7FF90D2024A71E93EE6", hash_generated_method = "C2B1B80F0738AC26DAA1DC6153F3E842")
    public boolean isNull(String name) {
        Object value = nameValuePairs.get(name);
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1510277079 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1510277079;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.268 -0400", hash_original_method = "297E71AC76AEECD92DCC3FA05327BE46", hash_generated_method = "F420FB9CA2AF4EB2B882CEB95AD5613E")
    public boolean has(String name) {
        boolean varAECCD7AE3813DBC2EAACB91C7BEDAB3D_416482823 = (nameValuePairs.containsKey(name));
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1988825448 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1988825448;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.269 -0400", hash_original_method = "C38AAF9284AEE2A94970713BC651F263", hash_generated_method = "F4A8BCC56EC0038A3D0FE4C2794CF2CD")
    public Object get(String name) throws JSONException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1676054670 = null; 
        Object result = nameValuePairs.get(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new JSONException("No value for " + name);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1676054670 = result;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1676054670.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1676054670;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.269 -0400", hash_original_method = "05A351DC7DE639568132A573A6E2106E", hash_generated_method = "26BE8D6F52D9B8BDFEE59D47F070D08A")
    public Object opt(String name) {
        Object varB4EAC82CA7396A68D541C85D26508E83_552002978 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_552002978 = nameValuePairs.get(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_552002978.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_552002978;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.270 -0400", hash_original_method = "7B38D2B2DBA3C433303B4D117D86E4E0", hash_generated_method = "99B53A4E1ADC703EE301360E6E7016F3")
    public boolean getBoolean(String name) throws JSONException {
        Object object = get(name);
        Boolean result = JSON.toBoolean(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(name, object, "boolean");
        } 
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1648066840 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1648066840;
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.270 -0400", hash_original_method = "3DA4544CD80345F7570489979490BD16", hash_generated_method = "4521CDD539D9E57FDFC7109F39660397")
    public boolean optBoolean(String name) {
        boolean var8BE80B6E9846B5FE1784886B30F81C14_1518261956 = (optBoolean(name, false));
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1867783748 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1867783748;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.271 -0400", hash_original_method = "C49CAFC4CC69BC825D274D7317108A68", hash_generated_method = "42313478833BDAD88B465069E976D3EB")
    public boolean optBoolean(String name, boolean fallback) {
        Object object = opt(name);
        Boolean result = JSON.toBoolean(object);
        addTaint(name.getTaint());
        addTaint(fallback);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_779475065 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_779475065;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.271 -0400", hash_original_method = "0C60D6C72644A8965D87529BB9443348", hash_generated_method = "A7C3321FFED542924AE9B74C651DFBBF")
    public double getDouble(String name) throws JSONException {
        Object object = get(name);
        Double result = JSON.toDouble(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(name, object, "double");
        } 
        addTaint(name.getTaint());
        double varE8CD7DA078A86726031AD64F35F5A6C0_446705857 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_446705857;
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.272 -0400", hash_original_method = "B9CFB7D5CC2BB58B8CACB29638DEE6A6", hash_generated_method = "FA8FFA7C8CFEEF2EDB710CF44AA5F386")
    public double optDouble(String name) {
        double varC56F0B477EEE0A41E1A76F177E961C03_213080590 = (optDouble(name, Double.NaN));
        addTaint(name.getTaint());
        double varE8CD7DA078A86726031AD64F35F5A6C0_118566363 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_118566363;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.273 -0400", hash_original_method = "F525E9AC5AAC714EA253692C6DC9EE0E", hash_generated_method = "D6AAF085F8DCACB19541F1DEBDFE3F05")
    public double optDouble(String name, double fallback) {
        Object object = opt(name);
        Double result = JSON.toDouble(object);
        addTaint(name.getTaint());
        addTaint(fallback);
        double varE8CD7DA078A86726031AD64F35F5A6C0_2046487653 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_2046487653;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.273 -0400", hash_original_method = "06DD6202AFC58B0F1BA6F9DBAA37C5F3", hash_generated_method = "D3D179828C4BB9C155D5A2110F5B6F87")
    public int getInt(String name) throws JSONException {
        Object object = get(name);
        Integer result = JSON.toInteger(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(name, object, "int");
        } 
        addTaint(name.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1881122596 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1881122596;
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.274 -0400", hash_original_method = "CF8C56AE8C6952FAAA48007CA568A3BF", hash_generated_method = "1E18A81E9D184D7F6A98B7A8C9D595CE")
    public int optInt(String name) {
        int var9479CC3C6E3D661742F54067B614174E_628342518 = (optInt(name, 0));
        addTaint(name.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_118085881 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_118085881;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.274 -0400", hash_original_method = "FC3121A883EAF5555BD9C194D7925D34", hash_generated_method = "9479CB9F4E19D47F7E71DD0E0707AC52")
    public int optInt(String name, int fallback) {
        Object object = opt(name);
        Integer result = JSON.toInteger(object);
        addTaint(name.getTaint());
        addTaint(fallback);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1771563004 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1771563004;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.275 -0400", hash_original_method = "55ABC1042FFC5D7EF9272460461F1426", hash_generated_method = "A80542EB2656CCA893D47F3E42AE6320")
    public long getLong(String name) throws JSONException {
        Object object = get(name);
        Long result = JSON.toLong(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(name, object, "long");
        } 
        addTaint(name.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1843117184 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1843117184;
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.275 -0400", hash_original_method = "70DEF89A3C807E0937F5C9E9E3A1A203", hash_generated_method = "B723772746F32D5E2C11C00FDA3FBF5D")
    public long optLong(String name) {
        long var4E3DB8E77FB5DFAD161FC7022FC765A8_1944248761 = (optLong(name, 0L));
        addTaint(name.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_499402849 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_499402849;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.276 -0400", hash_original_method = "C94BC7D2B7352E7323E9E58C53ACE476", hash_generated_method = "52479198AB8BB94F185FDD8FE19AFF8E")
    public long optLong(String name, long fallback) {
        Object object = opt(name);
        Long result = JSON.toLong(object);
        addTaint(name.getTaint());
        addTaint(fallback);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1028934030 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1028934030;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.277 -0400", hash_original_method = "CC649536AC568087B4414076D420F027", hash_generated_method = "1BFAB5F7524FF153FA62C9BAFE0EF991")
    public String getString(String name) throws JSONException {
        String varB4EAC82CA7396A68D541C85D26508E83_1200061799 = null; 
        Object object = get(name);
        String result = JSON.toString(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(name, object, "String");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1200061799 = result;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1200061799.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1200061799;
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.278 -0400", hash_original_method = "8B81E5CBB6FE92C9270C8AE14E1D248D", hash_generated_method = "49BFFDFE0A82896EC958B4BA89B78B9D")
    public String optString(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_1110632132 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1110632132 = optString(name, "");
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1110632132.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1110632132;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.279 -0400", hash_original_method = "B4BBF2951ACCBF79FD3FE8AB17DCAE83", hash_generated_method = "853EE96BB449B39077474C187A45A2C4")
    public String optString(String name, String fallback) {
        String varB4EAC82CA7396A68D541C85D26508E83_531903119 = null; 
        Object object = opt(name);
        String result = JSON.toString(object);
        varB4EAC82CA7396A68D541C85D26508E83_531903119 = result != null ? result : fallback;
        addTaint(name.getTaint());
        addTaint(fallback.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_531903119.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_531903119;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.279 -0400", hash_original_method = "1CE1CD2D1D65AA0859027B9575FA80C4", hash_generated_method = "6B1BDD639EBCDA480EF91C5FA43B0E5A")
    public JSONArray getJSONArray(String name) throws JSONException {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_580091994 = null; 
        Object object = get(name);
        {
            varB4EAC82CA7396A68D541C85D26508E83_580091994 = (JSONArray) object;
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(name, object, "JSONArray");
        } 
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_580091994.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_580091994;
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.281 -0400", hash_original_method = "576EFB0CB9E2FA91FCF1D9A3EF1337C6", hash_generated_method = "AD048853EF980F72C60A555200ADF727")
    public JSONArray optJSONArray(String name) {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_1761641368 = null; 
        Object object = opt(name);
        varB4EAC82CA7396A68D541C85D26508E83_1761641368 = object instanceof JSONArray ? (JSONArray) object : null;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1761641368.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1761641368;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.282 -0400", hash_original_method = "5326315C93466A3B1E8C695224A5B5FD", hash_generated_method = "08707F2466AEF81CA0BE634A5A221E2A")
    public JSONObject getJSONObject(String name) throws JSONException {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_385592447 = null; 
        Object object = get(name);
        {
            varB4EAC82CA7396A68D541C85D26508E83_385592447 = (JSONObject) object;
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(name, object, "JSONObject");
        } 
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_385592447.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_385592447;
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.284 -0400", hash_original_method = "B736B3B7313026EC1CBB4CB1D3C2367D", hash_generated_method = "F36434DD18F603B98AC6CF10E5116866")
    public JSONObject optJSONObject(String name) {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_724145350 = null; 
        Object object = opt(name);
        varB4EAC82CA7396A68D541C85D26508E83_724145350 = object instanceof JSONObject ? (JSONObject) object : null;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_724145350.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_724145350;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.288 -0400", hash_original_method = "1E876AFA246F164144A4BA68FB0C8527", hash_generated_method = "37850F20114F80CC9A9B93CEA056CAC4")
    public JSONArray toJSONArray(JSONArray names) throws JSONException {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_1379347425 = null; 
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_1846555544 = null; 
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_291922586 = null; 
        JSONArray result = new JSONArray();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1379347425 = null;
        } 
        int length = names.length();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1846555544 = null;
        } 
        {
            int i = 0;
            {
                String name = JSON.toString(names.opt(i));
                result.put(opt(name));
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_291922586 = result;
        addTaint(names.getTaint());
        JSONArray varA7E53CE21691AB073D9660D615818899_1515625872; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1515625872 = varB4EAC82CA7396A68D541C85D26508E83_1379347425;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1515625872 = varB4EAC82CA7396A68D541C85D26508E83_1846555544;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1515625872 = varB4EAC82CA7396A68D541C85D26508E83_291922586;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1515625872.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1515625872;
        
        
        
            
        
        
        
            
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.290 -0400", hash_original_method = "2D137981D66EA2E55940EA81187D393D", hash_generated_method = "85A13FC7942615FA60CA7908ED6D1561")
    public Iterator keys() {
        Iterator varB4EAC82CA7396A68D541C85D26508E83_730728319 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_730728319 = nameValuePairs.keySet().iterator();
        varB4EAC82CA7396A68D541C85D26508E83_730728319.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_730728319;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.291 -0400", hash_original_method = "3ECE715C4DC492B6D08AC6D2EACB5C9C", hash_generated_method = "34851AD3D303F35BF60858E55B980875")
    public JSONArray names() {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_1300728514 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1300728514 = nameValuePairs.isEmpty()
                ? null
                : new JSONArray(new ArrayList<String>(nameValuePairs.keySet()));
        varB4EAC82CA7396A68D541C85D26508E83_1300728514.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1300728514;
        
        
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @Override public String toString() {
            return "null";
        }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.292 -0400", hash_original_method = "161CBAA0F7E505CC65BF62A9F4C8490E", hash_generated_method = "16AC83AAF840B7980833D7A3217EE941")
    public String toString(int indentSpaces) throws JSONException {
        String varB4EAC82CA7396A68D541C85D26508E83_483980649 = null; 
        JSONStringer stringer = new JSONStringer(indentSpaces);
        writeTo(stringer);
        varB4EAC82CA7396A68D541C85D26508E83_483980649 = stringer.toString();
        addTaint(indentSpaces);
        varB4EAC82CA7396A68D541C85D26508E83_483980649.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_483980649;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.298 -0400", hash_original_method = "4318203F3538DC271461FDA2F00ABD52", hash_generated_method = "F06F1A84AD35FB4EDD1090E2C6DB1E1A")
     void writeTo(JSONStringer stringer) throws JSONException {
        stringer.object();
        {
            Iterator<Map.Entry<String, Object>> varAC53BD32903113FD541755067191E1E9_6343729 = (nameValuePairs.entrySet()).iterator();
            varAC53BD32903113FD541755067191E1E9_6343729.hasNext();
            Map.Entry<String, Object> entry = varAC53BD32903113FD541755067191E1E9_6343729.next();
            {
                stringer.key(entry.getKey()).value(entry.getValue());
            } 
        } 
        stringer.endObject();
        addTaint(stringer.getTaint());
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.299 -0400", hash_original_field = "4F8E83C95CFEE5158C01389EEFC269AA", hash_generated_field = "1DBE8D3C6A9A7131154428322A8B1823")

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
    
    @Override public boolean equals(Object o) {
            return o == this || o == null; 
        }
    
}

