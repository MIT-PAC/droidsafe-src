package org.json;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JSONObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.497 -0400", hash_original_field = "1CF5E4F247CC69AF70109AE4475648CB", hash_generated_field = "4AEF8EB90733274F8DF38365152EB324")

    private Map<String, Object> nameValuePairs;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.498 -0400", hash_original_method = "B0BA44B1CBEEB832685DE1D9CC551D36", hash_generated_method = "8AB77AFCB9DCE98AE75372C152EFAE46")
    public  JSONObject() {
        nameValuePairs = new HashMap<String, Object>();
        // ---------- Original Method ----------
        //nameValuePairs = new HashMap<String, Object>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.512 -0400", hash_original_method = "64F11EBDF44BE4F1CBC516D3CD1F34E9", hash_generated_method = "0DD588210D279066BAD51B68AB163F36")
    public  JSONObject(Map copyFrom) {
        this();
        Map<?, ?> contentsTyped;
        contentsTyped = (Map<?, ?>) copyFrom;
        {
            contentsTyped.entrySet().iterator().hasNext();
            Map.Entry<?, ?> entry = contentsTyped.entrySet().iterator().next();
            {
                String key;
                key = (String) entry.getKey();
                {
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
                } //End block
                nameValuePairs.put(key, entry.getValue());
            } //End block
        } //End collapsed parenthetic
        addTaint(copyFrom.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.512 -0400", hash_original_method = "E218F03BB03DC7D8503E0318225F7859", hash_generated_method = "DD6D211BB274906FE1177FEAE409B769")
    public  JSONObject(JSONTokener readFrom) throws JSONException {
        Object object;
        object = readFrom.nextValue();
        {
            this.nameValuePairs = ((JSONObject) object).nameValuePairs;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(object, "JSONObject");
        } //End block
        addTaint(readFrom.getTaint());
        // ---------- Original Method ----------
        //Object object = readFrom.nextValue();
        //if (object instanceof JSONObject) {
            //this.nameValuePairs = ((JSONObject) object).nameValuePairs;
        //} else {
            //throw JSON.typeMismatch(object, "JSONObject");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.530 -0400", hash_original_method = "27B9491B51940DE15585B798AFD3D304", hash_generated_method = "64C04C1F10C31248B34728372555B741")
    public  JSONObject(String json) throws JSONException {
        this(new JSONTokener(json));
        addTaint(json.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.559 -0400", hash_original_method = "D555E6715A2E6E4EC106278BB66ED891", hash_generated_method = "5E0F9BEE1495EAEBFEAA8A4CD27B0B8F")
    public  JSONObject(JSONObject copyFrom, String[] names) throws JSONException {
        this();
        {
            Iterator<String> var0B4471083E71D104FA84944F144C9814_448155609 = (names).iterator();
            var0B4471083E71D104FA84944F144C9814_448155609.hasNext();
            String name = var0B4471083E71D104FA84944F144C9814_448155609.next();
            {
                Object value;
                value = copyFrom.opt(name);
                {
                    nameValuePairs.put(name, value);
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(copyFrom.getTaint());
        addTaint(names[0].getTaint());
        // ---------- Original Method ----------
        //for (String name : names) {
            //Object value = copyFrom.opt(name);
            //if (value != null) {
                //nameValuePairs.put(name, value);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.560 -0400", hash_original_method = "BB0C5A7042ADC1F8FC4BAA64EBFD2B52", hash_generated_method = "0E40554A4E37614ACE1445226B9A4B2D")
    public int length() {
        int var5BCA4F4CB72BD4E013D6A2FD0A5A950A_67475536 = (nameValuePairs.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_218110262 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_218110262;
        // ---------- Original Method ----------
        //return nameValuePairs.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.561 -0400", hash_original_method = "43A124AF3EF8B2736A46103CC8729DE3", hash_generated_method = "5600E6BA9A9F97DAE8F578DB7DE8EBD7")
    public JSONObject put(String name, boolean value) throws JSONException {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_1073452461 = null; //Variable for return #1
        nameValuePairs.put(checkName(name), value);
        varB4EAC82CA7396A68D541C85D26508E83_1073452461 = this;
        addTaint(name.getTaint());
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1073452461.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1073452461;
        // ---------- Original Method ----------
        //nameValuePairs.put(checkName(name), value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.561 -0400", hash_original_method = "FF23ECF2F7B3A424BD0CA2B446E9E0DB", hash_generated_method = "0EEA6B2E6A6080068BCEA28F718953F9")
    public JSONObject put(String name, double value) throws JSONException {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_107051704 = null; //Variable for return #1
        nameValuePairs.put(checkName(name), JSON.checkDouble(value));
        varB4EAC82CA7396A68D541C85D26508E83_107051704 = this;
        addTaint(name.getTaint());
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_107051704.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_107051704;
        // ---------- Original Method ----------
        //nameValuePairs.put(checkName(name), JSON.checkDouble(value));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.562 -0400", hash_original_method = "14B3109A64A28D2764163C4077CDC45D", hash_generated_method = "3AD2486B4F8AA6B5B646A4C733F8E127")
    public JSONObject put(String name, int value) throws JSONException {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_1507380363 = null; //Variable for return #1
        nameValuePairs.put(checkName(name), value);
        varB4EAC82CA7396A68D541C85D26508E83_1507380363 = this;
        addTaint(name.getTaint());
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1507380363.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1507380363;
        // ---------- Original Method ----------
        //nameValuePairs.put(checkName(name), value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.566 -0400", hash_original_method = "0E78BCAD739042DC347A7959C52D188A", hash_generated_method = "7E0F008AD0B9775DF01E1752755CDAC3")
    public JSONObject put(String name, long value) throws JSONException {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_1074722482 = null; //Variable for return #1
        nameValuePairs.put(checkName(name), value);
        varB4EAC82CA7396A68D541C85D26508E83_1074722482 = this;
        addTaint(name.getTaint());
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1074722482.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1074722482;
        // ---------- Original Method ----------
        //nameValuePairs.put(checkName(name), value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.586 -0400", hash_original_method = "8B4C0C01745202135A0373E57DFB791E", hash_generated_method = "854954722F14B5E9DE6D6CDDA3852A07")
    public JSONObject put(String name, Object value) throws JSONException {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_827921158 = null; //Variable for return #1
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_2136991756 = null; //Variable for return #2
        {
            nameValuePairs.remove(name);
            varB4EAC82CA7396A68D541C85D26508E83_827921158 = this;
        } //End block
        {
            JSON.checkDouble(((Number) value).doubleValue());
        } //End block
        nameValuePairs.put(checkName(name), value);
        varB4EAC82CA7396A68D541C85D26508E83_2136991756 = this;
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        JSONObject varA7E53CE21691AB073D9660D615818899_1570024564; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1570024564 = varB4EAC82CA7396A68D541C85D26508E83_827921158;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1570024564 = varB4EAC82CA7396A68D541C85D26508E83_2136991756;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1570024564.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1570024564;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.587 -0400", hash_original_method = "D9589667A2509A719F9DF68E891B85DD", hash_generated_method = "8AC372DF13EB6E405094111E4B650CDE")
    public JSONObject putOpt(String name, Object value) throws JSONException {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_123721336 = null; //Variable for return #1
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_1968020942 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_123721336 = this;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1968020942 = put(name, value);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        JSONObject varA7E53CE21691AB073D9660D615818899_1821847600; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1821847600 = varB4EAC82CA7396A68D541C85D26508E83_123721336;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1821847600 = varB4EAC82CA7396A68D541C85D26508E83_1968020942;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1821847600.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1821847600;
        // ---------- Original Method ----------
        //if (name == null || value == null) {
            //return this;
        //}
        //return put(name, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.589 -0400", hash_original_method = "5A758AD2B70A18447D6617A35807B03B", hash_generated_method = "E05F391AA2035C956DB883C53E030ED2")
    public JSONObject accumulate(String name, Object value) throws JSONException {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_1819945603 = null; //Variable for return #1
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_865143974 = null; //Variable for return #2
        Object current;
        current = nameValuePairs.get(checkName(name));
        {
            varB4EAC82CA7396A68D541C85D26508E83_1819945603 = put(name, value);
        } //End block
        {
            JSON.checkDouble(((Number) value).doubleValue());
        } //End block
        {
            JSONArray array;
            array = (JSONArray) current;
            array.put(value);
        } //End block
        {
            JSONArray array;
            array = new JSONArray();
            array.put(current);
            array.put(value);
            nameValuePairs.put(name, array);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_865143974 = this;
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        JSONObject varA7E53CE21691AB073D9660D615818899_832931459; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_832931459 = varB4EAC82CA7396A68D541C85D26508E83_1819945603;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_832931459 = varB4EAC82CA7396A68D541C85D26508E83_865143974;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_832931459.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_832931459;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.591 -0400", hash_original_method = "1AA4BB08CA8C9DDACC6E60D58C017824", hash_generated_method = "7972B3DAE5C36E0E1EFBB37072880703")
     String checkName(String name) throws JSONException {
        String varB4EAC82CA7396A68D541C85D26508E83_364349412 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new JSONException("Names must be non-null");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_364349412 = name;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_364349412.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_364349412;
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new JSONException("Names must be non-null");
        //}
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.592 -0400", hash_original_method = "BEB5EB52101798DC8AC0FA25480A2C90", hash_generated_method = "CAFF72E0C22670C987E9B1F93B24E4BC")
    public Object remove(String name) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1049174764 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1049174764 = nameValuePairs.remove(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1049174764.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1049174764;
        // ---------- Original Method ----------
        //return nameValuePairs.remove(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.592 -0400", hash_original_method = "A1CD692FA856D7FF90D2024A71E93EE6", hash_generated_method = "BF3C5C004A7DFD0F19FB45A2249EA7FB")
    public boolean isNull(String name) {
        Object value;
        value = nameValuePairs.get(name);
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1117108629 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1117108629;
        // ---------- Original Method ----------
        //Object value = nameValuePairs.get(name);
        //return value == null || value == NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.593 -0400", hash_original_method = "297E71AC76AEECD92DCC3FA05327BE46", hash_generated_method = "CBF4321B834A051F63D9A754B5E49525")
    public boolean has(String name) {
        boolean varAECCD7AE3813DBC2EAACB91C7BEDAB3D_762309600 = (nameValuePairs.containsKey(name));
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_572784567 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_572784567;
        // ---------- Original Method ----------
        //return nameValuePairs.containsKey(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.603 -0400", hash_original_method = "C38AAF9284AEE2A94970713BC651F263", hash_generated_method = "7C3FD5B76871F7CC33D733FBBDA03AA0")
    public Object get(String name) throws JSONException {
        Object varB4EAC82CA7396A68D541C85D26508E83_889529122 = null; //Variable for return #1
        Object result;
        result = nameValuePairs.get(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new JSONException("No value for " + name);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_889529122 = result;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_889529122.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_889529122;
        // ---------- Original Method ----------
        //Object result = nameValuePairs.get(name);
        //if (result == null) {
            //throw new JSONException("No value for " + name);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.604 -0400", hash_original_method = "05A351DC7DE639568132A573A6E2106E", hash_generated_method = "3AEBBF6B72DCE3574A812CCFF8061EDA")
    public Object opt(String name) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1640993743 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1640993743 = nameValuePairs.get(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1640993743.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1640993743;
        // ---------- Original Method ----------
        //return nameValuePairs.get(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.605 -0400", hash_original_method = "7B38D2B2DBA3C433303B4D117D86E4E0", hash_generated_method = "69AA99B8400F26A3235E8E83F03B4B80")
    public boolean getBoolean(String name) throws JSONException {
        Object object;
        object = get(name);
        Boolean result;
        result = JSON.toBoolean(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(name, object, "boolean");
        } //End block
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1265594862 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1265594862;
        // ---------- Original Method ----------
        //Object object = get(name);
        //Boolean result = JSON.toBoolean(object);
        //if (result == null) {
            //throw JSON.typeMismatch(name, object, "boolean");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.605 -0400", hash_original_method = "3DA4544CD80345F7570489979490BD16", hash_generated_method = "0DEF5C0FFD0BDC0B4681FA1FA6C35F38")
    public boolean optBoolean(String name) {
        boolean var8BE80B6E9846B5FE1784886B30F81C14_2103507905 = (optBoolean(name, false));
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2119008500 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2119008500;
        // ---------- Original Method ----------
        //return optBoolean(name, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.605 -0400", hash_original_method = "C49CAFC4CC69BC825D274D7317108A68", hash_generated_method = "D1FB2C685C4DC684596CBBEC3059B2EA")
    public boolean optBoolean(String name, boolean fallback) {
        Object object;
        object = opt(name);
        Boolean result;
        result = JSON.toBoolean(object);
        addTaint(name.getTaint());
        addTaint(fallback);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_746880362 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_746880362;
        // ---------- Original Method ----------
        //Object object = opt(name);
        //Boolean result = JSON.toBoolean(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.616 -0400", hash_original_method = "0C60D6C72644A8965D87529BB9443348", hash_generated_method = "E71F1C8A1C6F3E03148848CC0C3413BD")
    public double getDouble(String name) throws JSONException {
        Object object;
        object = get(name);
        Double result;
        result = JSON.toDouble(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(name, object, "double");
        } //End block
        addTaint(name.getTaint());
        double varE8CD7DA078A86726031AD64F35F5A6C0_584032804 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_584032804;
        // ---------- Original Method ----------
        //Object object = get(name);
        //Double result = JSON.toDouble(object);
        //if (result == null) {
            //throw JSON.typeMismatch(name, object, "double");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.616 -0400", hash_original_method = "B9CFB7D5CC2BB58B8CACB29638DEE6A6", hash_generated_method = "A7745108AC63DB9E0150BF7B3EE37464")
    public double optDouble(String name) {
        double varC56F0B477EEE0A41E1A76F177E961C03_962314190 = (optDouble(name, Double.NaN));
        addTaint(name.getTaint());
        double varE8CD7DA078A86726031AD64F35F5A6C0_635100356 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_635100356;
        // ---------- Original Method ----------
        //return optDouble(name, Double.NaN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.616 -0400", hash_original_method = "F525E9AC5AAC714EA253692C6DC9EE0E", hash_generated_method = "6477E93EDFEF2E890C0F701C366ABEB0")
    public double optDouble(String name, double fallback) {
        Object object;
        object = opt(name);
        Double result;
        result = JSON.toDouble(object);
        addTaint(name.getTaint());
        addTaint(fallback);
        double varE8CD7DA078A86726031AD64F35F5A6C0_1165257024 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1165257024;
        // ---------- Original Method ----------
        //Object object = opt(name);
        //Double result = JSON.toDouble(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.617 -0400", hash_original_method = "06DD6202AFC58B0F1BA6F9DBAA37C5F3", hash_generated_method = "29E74EF4F7B595D8271273A850BE0E48")
    public int getInt(String name) throws JSONException {
        Object object;
        object = get(name);
        Integer result;
        result = JSON.toInteger(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(name, object, "int");
        } //End block
        addTaint(name.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1238070477 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1238070477;
        // ---------- Original Method ----------
        //Object object = get(name);
        //Integer result = JSON.toInteger(object);
        //if (result == null) {
            //throw JSON.typeMismatch(name, object, "int");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.617 -0400", hash_original_method = "CF8C56AE8C6952FAAA48007CA568A3BF", hash_generated_method = "943E3EBFC39ECE0E11082EEA2EEB6E8F")
    public int optInt(String name) {
        int var9479CC3C6E3D661742F54067B614174E_1622991183 = (optInt(name, 0));
        addTaint(name.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_547341063 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_547341063;
        // ---------- Original Method ----------
        //return optInt(name, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.626 -0400", hash_original_method = "FC3121A883EAF5555BD9C194D7925D34", hash_generated_method = "0701A943ABD6D186F3A00F5978212CC4")
    public int optInt(String name, int fallback) {
        Object object;
        object = opt(name);
        Integer result;
        result = JSON.toInteger(object);
        addTaint(name.getTaint());
        addTaint(fallback);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1755695240 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1755695240;
        // ---------- Original Method ----------
        //Object object = opt(name);
        //Integer result = JSON.toInteger(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.626 -0400", hash_original_method = "55ABC1042FFC5D7EF9272460461F1426", hash_generated_method = "C5DFD451A5F7FB67BC55173E4AB15103")
    public long getLong(String name) throws JSONException {
        Object object;
        object = get(name);
        Long result;
        result = JSON.toLong(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(name, object, "long");
        } //End block
        addTaint(name.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_810937882 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_810937882;
        // ---------- Original Method ----------
        //Object object = get(name);
        //Long result = JSON.toLong(object);
        //if (result == null) {
            //throw JSON.typeMismatch(name, object, "long");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.630 -0400", hash_original_method = "70DEF89A3C807E0937F5C9E9E3A1A203", hash_generated_method = "9860AE3F9A5F2FC87B1640083B926775")
    public long optLong(String name) {
        long var4E3DB8E77FB5DFAD161FC7022FC765A8_1213501548 = (optLong(name, 0L));
        addTaint(name.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_807831537 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_807831537;
        // ---------- Original Method ----------
        //return optLong(name, 0L);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.630 -0400", hash_original_method = "C94BC7D2B7352E7323E9E58C53ACE476", hash_generated_method = "5DBC20D83523D347DD8DEAA374ABDD6C")
    public long optLong(String name, long fallback) {
        Object object;
        object = opt(name);
        Long result;
        result = JSON.toLong(object);
        addTaint(name.getTaint());
        addTaint(fallback);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1218265519 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1218265519;
        // ---------- Original Method ----------
        //Object object = opt(name);
        //Long result = JSON.toLong(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.631 -0400", hash_original_method = "CC649536AC568087B4414076D420F027", hash_generated_method = "D912A04EFEE4612F092DEEDA8C15CB11")
    public String getString(String name) throws JSONException {
        String varB4EAC82CA7396A68D541C85D26508E83_379822961 = null; //Variable for return #1
        Object object;
        object = get(name);
        String result;
        result = JSON.toString(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(name, object, "String");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_379822961 = result;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_379822961.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_379822961;
        // ---------- Original Method ----------
        //Object object = get(name);
        //String result = JSON.toString(object);
        //if (result == null) {
            //throw JSON.typeMismatch(name, object, "String");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.636 -0400", hash_original_method = "8B81E5CBB6FE92C9270C8AE14E1D248D", hash_generated_method = "A989A990AA1215FFB2F1652F78766480")
    public String optString(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_1321900736 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1321900736 = optString(name, "");
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1321900736.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1321900736;
        // ---------- Original Method ----------
        //return optString(name, "");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.636 -0400", hash_original_method = "B4BBF2951ACCBF79FD3FE8AB17DCAE83", hash_generated_method = "6E819A162D5935C01C33B28C35939873")
    public String optString(String name, String fallback) {
        String varB4EAC82CA7396A68D541C85D26508E83_1761730200 = null; //Variable for return #1
        Object object;
        object = opt(name);
        String result;
        result = JSON.toString(object);
        varB4EAC82CA7396A68D541C85D26508E83_1761730200 = result != null ? result : fallback;
        addTaint(name.getTaint());
        addTaint(fallback.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1761730200.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1761730200;
        // ---------- Original Method ----------
        //Object object = opt(name);
        //String result = JSON.toString(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.647 -0400", hash_original_method = "1CE1CD2D1D65AA0859027B9575FA80C4", hash_generated_method = "AB942994BAF3131717876C2C6F8B6751")
    public JSONArray getJSONArray(String name) throws JSONException {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_1791562837 = null; //Variable for return #1
        Object object;
        object = get(name);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1791562837 = (JSONArray) object;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(name, object, "JSONArray");
        } //End block
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1791562837.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1791562837;
        // ---------- Original Method ----------
        //Object object = get(name);
        //if (object instanceof JSONArray) {
            //return (JSONArray) object;
        //} else {
            //throw JSON.typeMismatch(name, object, "JSONArray");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.648 -0400", hash_original_method = "576EFB0CB9E2FA91FCF1D9A3EF1337C6", hash_generated_method = "FD78BCB8B0F7B318690D4DBD56DE98B7")
    public JSONArray optJSONArray(String name) {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_214213918 = null; //Variable for return #1
        Object object;
        object = opt(name);
        varB4EAC82CA7396A68D541C85D26508E83_214213918 = object instanceof JSONArray ? (JSONArray) object : null;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_214213918.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_214213918;
        // ---------- Original Method ----------
        //Object object = opt(name);
        //return object instanceof JSONArray ? (JSONArray) object : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.648 -0400", hash_original_method = "5326315C93466A3B1E8C695224A5B5FD", hash_generated_method = "09AC1779D526E5FDB4035DA3D1D3C39D")
    public JSONObject getJSONObject(String name) throws JSONException {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_534236876 = null; //Variable for return #1
        Object object;
        object = get(name);
        {
            varB4EAC82CA7396A68D541C85D26508E83_534236876 = (JSONObject) object;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(name, object, "JSONObject");
        } //End block
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_534236876.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_534236876;
        // ---------- Original Method ----------
        //Object object = get(name);
        //if (object instanceof JSONObject) {
            //return (JSONObject) object;
        //} else {
            //throw JSON.typeMismatch(name, object, "JSONObject");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.649 -0400", hash_original_method = "B736B3B7313026EC1CBB4CB1D3C2367D", hash_generated_method = "F226ED3D68E8306C81E152883EA68287")
    public JSONObject optJSONObject(String name) {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_198034713 = null; //Variable for return #1
        Object object;
        object = opt(name);
        varB4EAC82CA7396A68D541C85D26508E83_198034713 = object instanceof JSONObject ? (JSONObject) object : null;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_198034713.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_198034713;
        // ---------- Original Method ----------
        //Object object = opt(name);
        //return object instanceof JSONObject ? (JSONObject) object : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.649 -0400", hash_original_method = "1E876AFA246F164144A4BA68FB0C8527", hash_generated_method = "0FD97F0F7F05AFB9B9FD06F106B34851")
    public JSONArray toJSONArray(JSONArray names) throws JSONException {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_1528796896 = null; //Variable for return #1
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_1605445258 = null; //Variable for return #2
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_581214306 = null; //Variable for return #3
        JSONArray result;
        result = new JSONArray();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1528796896 = null;
        } //End block
        int length;
        length = names.length();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1605445258 = null;
        } //End block
        {
            int i;
            i = 0;
            {
                String name;
                name = JSON.toString(names.opt(i));
                result.put(opt(name));
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_581214306 = result;
        addTaint(names.getTaint());
        JSONArray varA7E53CE21691AB073D9660D615818899_727325145; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_727325145 = varB4EAC82CA7396A68D541C85D26508E83_1528796896;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_727325145 = varB4EAC82CA7396A68D541C85D26508E83_1605445258;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_727325145 = varB4EAC82CA7396A68D541C85D26508E83_581214306;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_727325145.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_727325145;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.660 -0400", hash_original_method = "2D137981D66EA2E55940EA81187D393D", hash_generated_method = "9851E340709637EE4E2F0B973F8BBF66")
    public Iterator keys() {
        Iterator varB4EAC82CA7396A68D541C85D26508E83_397589771 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_397589771 = nameValuePairs.keySet().iterator();
        varB4EAC82CA7396A68D541C85D26508E83_397589771.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_397589771;
        // ---------- Original Method ----------
        //return nameValuePairs.keySet().iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.663 -0400", hash_original_method = "3ECE715C4DC492B6D08AC6D2EACB5C9C", hash_generated_method = "57197634CA9EE3B8DE625EFA3D9BE9F1")
    public JSONArray names() {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_1476864065 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1476864065 = nameValuePairs.isEmpty()
                ? null
                : new JSONArray(new ArrayList<String>(nameValuePairs.keySet()));
        varB4EAC82CA7396A68D541C85D26508E83_1476864065.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1476864065;
        // ---------- Original Method ----------
        //return nameValuePairs.isEmpty()
                //? null
                //: new JSONArray(new ArrayList<String>(nameValuePairs.keySet()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.669 -0400", hash_original_method = "CC6BE78472EEEAF64E530CA9F9B14BB5", hash_generated_method = "41CBDCAEB741AB32EF87536C2CB63AB1")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_354338068 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_213412991 = null; //Variable for return #2
        try 
        {
            JSONStringer stringer;
            stringer = new JSONStringer();
            writeTo(stringer);
            varB4EAC82CA7396A68D541C85D26508E83_354338068 = stringer.toString();
        } //End block
        catch (JSONException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_213412991 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_430905633; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_430905633 = varB4EAC82CA7396A68D541C85D26508E83_354338068;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_430905633 = varB4EAC82CA7396A68D541C85D26508E83_213412991;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_430905633.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_430905633;
        // ---------- Original Method ----------
        //try {
            //JSONStringer stringer = new JSONStringer();
            //writeTo(stringer);
            //return stringer.toString();
        //} catch (JSONException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.672 -0400", hash_original_method = "161CBAA0F7E505CC65BF62A9F4C8490E", hash_generated_method = "9E29300BD12A2124E976A5E63A2E8544")
    public String toString(int indentSpaces) throws JSONException {
        String varB4EAC82CA7396A68D541C85D26508E83_1551970203 = null; //Variable for return #1
        JSONStringer stringer;
        stringer = new JSONStringer(indentSpaces);
        writeTo(stringer);
        varB4EAC82CA7396A68D541C85D26508E83_1551970203 = stringer.toString();
        addTaint(indentSpaces);
        varB4EAC82CA7396A68D541C85D26508E83_1551970203.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1551970203;
        // ---------- Original Method ----------
        //JSONStringer stringer = new JSONStringer(indentSpaces);
        //writeTo(stringer);
        //return stringer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.711 -0400", hash_original_method = "4318203F3538DC271461FDA2F00ABD52", hash_generated_method = "0595ECD8D1EB820E2F0A1B830C180349")
     void writeTo(JSONStringer stringer) throws JSONException {
        stringer.object();
        {
            Iterator<Map.Entry<String, Object>> varAC53BD32903113FD541755067191E1E9_702839049 = (nameValuePairs.entrySet()).iterator();
            varAC53BD32903113FD541755067191E1E9_702839049.hasNext();
            Map.Entry<String, Object> entry = varAC53BD32903113FD541755067191E1E9_702839049.next();
            {
                stringer.key(entry.getKey()).value(entry.getValue());
            } //End block
        } //End collapsed parenthetic
        stringer.endObject();
        addTaint(stringer.getTaint());
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.711 -0400", hash_original_field = "4F8E83C95CFEE5158C01389EEFC269AA", hash_generated_field = "619FB37967C1A8607A60ED714D99DE91")

    private static Double NEGATIVE_ZERO = -0d;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.711 -0400", hash_original_field = "69D6A2BFA9970459DEF9916A4A819505", hash_generated_field = "3F3D3946D0FBB086C49E80D158F100D9")

    public static final Object NULL = new Object() {
        @Override public boolean equals(Object o) {
            return o == this || o == null; 
        }
        @Override public String toString() {
            return "null";
        }
    };
}

