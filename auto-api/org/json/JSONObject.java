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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.511 -0400", hash_original_field = "1CF5E4F247CC69AF70109AE4475648CB", hash_generated_field = "4AEF8EB90733274F8DF38365152EB324")

    private Map<String, Object> nameValuePairs;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.519 -0400", hash_original_method = "B0BA44B1CBEEB832685DE1D9CC551D36", hash_generated_method = "8AB77AFCB9DCE98AE75372C152EFAE46")
    public  JSONObject() {
        nameValuePairs = new HashMap<String, Object>();
        // ---------- Original Method ----------
        //nameValuePairs = new HashMap<String, Object>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.522 -0400", hash_original_method = "64F11EBDF44BE4F1CBC516D3CD1F34E9", hash_generated_method = "0DD588210D279066BAD51B68AB163F36")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.523 -0400", hash_original_method = "E218F03BB03DC7D8503E0318225F7859", hash_generated_method = "DD6D211BB274906FE1177FEAE409B769")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.523 -0400", hash_original_method = "27B9491B51940DE15585B798AFD3D304", hash_generated_method = "64C04C1F10C31248B34728372555B741")
    public  JSONObject(String json) throws JSONException {
        this(new JSONTokener(json));
        addTaint(json.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.552 -0400", hash_original_method = "D555E6715A2E6E4EC106278BB66ED891", hash_generated_method = "617D9B43DBC3009415E8FB81C2F9809A")
    public  JSONObject(JSONObject copyFrom, String[] names) throws JSONException {
        this();
        {
            Iterator<String> var0B4471083E71D104FA84944F144C9814_192208672 = (names).iterator();
            var0B4471083E71D104FA84944F144C9814_192208672.hasNext();
            String name = var0B4471083E71D104FA84944F144C9814_192208672.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.557 -0400", hash_original_method = "BB0C5A7042ADC1F8FC4BAA64EBFD2B52", hash_generated_method = "B26FC2A86FA12484D0A70F5EBED3F800")
    public int length() {
        int var5BCA4F4CB72BD4E013D6A2FD0A5A950A_1205733125 = (nameValuePairs.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1560656653 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1560656653;
        // ---------- Original Method ----------
        //return nameValuePairs.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.563 -0400", hash_original_method = "43A124AF3EF8B2736A46103CC8729DE3", hash_generated_method = "127E2560B8DE1F6CE1C9A4051508BF80")
    public JSONObject put(String name, boolean value) throws JSONException {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_1826475287 = null; //Variable for return #1
        nameValuePairs.put(checkName(name), value);
        varB4EAC82CA7396A68D541C85D26508E83_1826475287 = this;
        addTaint(name.getTaint());
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1826475287.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1826475287;
        // ---------- Original Method ----------
        //nameValuePairs.put(checkName(name), value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.563 -0400", hash_original_method = "FF23ECF2F7B3A424BD0CA2B446E9E0DB", hash_generated_method = "ADD301333B0246145E6A68DA9B7609E7")
    public JSONObject put(String name, double value) throws JSONException {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_573284350 = null; //Variable for return #1
        nameValuePairs.put(checkName(name), JSON.checkDouble(value));
        varB4EAC82CA7396A68D541C85D26508E83_573284350 = this;
        addTaint(name.getTaint());
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_573284350.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_573284350;
        // ---------- Original Method ----------
        //nameValuePairs.put(checkName(name), JSON.checkDouble(value));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.564 -0400", hash_original_method = "14B3109A64A28D2764163C4077CDC45D", hash_generated_method = "AE06B1E29FF041559D67094D498AEACB")
    public JSONObject put(String name, int value) throws JSONException {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_457445948 = null; //Variable for return #1
        nameValuePairs.put(checkName(name), value);
        varB4EAC82CA7396A68D541C85D26508E83_457445948 = this;
        addTaint(name.getTaint());
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_457445948.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_457445948;
        // ---------- Original Method ----------
        //nameValuePairs.put(checkName(name), value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.564 -0400", hash_original_method = "0E78BCAD739042DC347A7959C52D188A", hash_generated_method = "3FC0178D68194F63A69728CEDABE0748")
    public JSONObject put(String name, long value) throws JSONException {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_1333252908 = null; //Variable for return #1
        nameValuePairs.put(checkName(name), value);
        varB4EAC82CA7396A68D541C85D26508E83_1333252908 = this;
        addTaint(name.getTaint());
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1333252908.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1333252908;
        // ---------- Original Method ----------
        //nameValuePairs.put(checkName(name), value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.579 -0400", hash_original_method = "8B4C0C01745202135A0373E57DFB791E", hash_generated_method = "CDA69795C6CCDA3E1F9C5D2C350DCF45")
    public JSONObject put(String name, Object value) throws JSONException {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_732183648 = null; //Variable for return #1
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_1197366080 = null; //Variable for return #2
        {
            nameValuePairs.remove(name);
            varB4EAC82CA7396A68D541C85D26508E83_732183648 = this;
        } //End block
        {
            JSON.checkDouble(((Number) value).doubleValue());
        } //End block
        nameValuePairs.put(checkName(name), value);
        varB4EAC82CA7396A68D541C85D26508E83_1197366080 = this;
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        JSONObject varA7E53CE21691AB073D9660D615818899_987764545; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_987764545 = varB4EAC82CA7396A68D541C85D26508E83_732183648;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_987764545 = varB4EAC82CA7396A68D541C85D26508E83_1197366080;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_987764545.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_987764545;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.579 -0400", hash_original_method = "D9589667A2509A719F9DF68E891B85DD", hash_generated_method = "27A8ADCCAD1E7CB896828AE70AF9F19C")
    public JSONObject putOpt(String name, Object value) throws JSONException {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_1953224742 = null; //Variable for return #1
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_1443294736 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1953224742 = this;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1443294736 = put(name, value);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        JSONObject varA7E53CE21691AB073D9660D615818899_1645055338; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1645055338 = varB4EAC82CA7396A68D541C85D26508E83_1953224742;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1645055338 = varB4EAC82CA7396A68D541C85D26508E83_1443294736;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1645055338.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1645055338;
        // ---------- Original Method ----------
        //if (name == null || value == null) {
            //return this;
        //}
        //return put(name, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.596 -0400", hash_original_method = "5A758AD2B70A18447D6617A35807B03B", hash_generated_method = "09510D156B4A58CCD1A46D3C73E7A249")
    public JSONObject accumulate(String name, Object value) throws JSONException {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_1650972183 = null; //Variable for return #1
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_557169733 = null; //Variable for return #2
        Object current;
        current = nameValuePairs.get(checkName(name));
        {
            varB4EAC82CA7396A68D541C85D26508E83_1650972183 = put(name, value);
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
        varB4EAC82CA7396A68D541C85D26508E83_557169733 = this;
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        JSONObject varA7E53CE21691AB073D9660D615818899_420905956; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_420905956 = varB4EAC82CA7396A68D541C85D26508E83_1650972183;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_420905956 = varB4EAC82CA7396A68D541C85D26508E83_557169733;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_420905956.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_420905956;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.597 -0400", hash_original_method = "1AA4BB08CA8C9DDACC6E60D58C017824", hash_generated_method = "D7B24498100F9D9FE13545B019348955")
     String checkName(String name) throws JSONException {
        String varB4EAC82CA7396A68D541C85D26508E83_1570829103 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new JSONException("Names must be non-null");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1570829103 = name;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1570829103.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1570829103;
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new JSONException("Names must be non-null");
        //}
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.597 -0400", hash_original_method = "BEB5EB52101798DC8AC0FA25480A2C90", hash_generated_method = "F0EB762E30AFA71870F6C9C858A15CC5")
    public Object remove(String name) {
        Object varB4EAC82CA7396A68D541C85D26508E83_861614863 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_861614863 = nameValuePairs.remove(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_861614863.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_861614863;
        // ---------- Original Method ----------
        //return nameValuePairs.remove(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.598 -0400", hash_original_method = "A1CD692FA856D7FF90D2024A71E93EE6", hash_generated_method = "BFC4C6B00A6318A1B667D1FCDC6684C6")
    public boolean isNull(String name) {
        Object value;
        value = nameValuePairs.get(name);
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1661627130 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1661627130;
        // ---------- Original Method ----------
        //Object value = nameValuePairs.get(name);
        //return value == null || value == NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.598 -0400", hash_original_method = "297E71AC76AEECD92DCC3FA05327BE46", hash_generated_method = "B3973CF6DE4C99E0D9A821313FE4E61F")
    public boolean has(String name) {
        boolean varAECCD7AE3813DBC2EAACB91C7BEDAB3D_424558285 = (nameValuePairs.containsKey(name));
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1345451935 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1345451935;
        // ---------- Original Method ----------
        //return nameValuePairs.containsKey(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.601 -0400", hash_original_method = "C38AAF9284AEE2A94970713BC651F263", hash_generated_method = "F5E98CB9E12CCD87A388665CC1C62C64")
    public Object get(String name) throws JSONException {
        Object varB4EAC82CA7396A68D541C85D26508E83_101060645 = null; //Variable for return #1
        Object result;
        result = nameValuePairs.get(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new JSONException("No value for " + name);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_101060645 = result;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_101060645.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_101060645;
        // ---------- Original Method ----------
        //Object result = nameValuePairs.get(name);
        //if (result == null) {
            //throw new JSONException("No value for " + name);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.601 -0400", hash_original_method = "05A351DC7DE639568132A573A6E2106E", hash_generated_method = "7360BB3F300F8D4F0018CF503F0BB99D")
    public Object opt(String name) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1295660477 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1295660477 = nameValuePairs.get(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1295660477.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1295660477;
        // ---------- Original Method ----------
        //return nameValuePairs.get(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.603 -0400", hash_original_method = "7B38D2B2DBA3C433303B4D117D86E4E0", hash_generated_method = "CA244804F48B188341F896A7DA6FC35E")
    public boolean getBoolean(String name) throws JSONException {
        Object object;
        object = get(name);
        Boolean result;
        result = JSON.toBoolean(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(name, object, "boolean");
        } //End block
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1482918133 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1482918133;
        // ---------- Original Method ----------
        //Object object = get(name);
        //Boolean result = JSON.toBoolean(object);
        //if (result == null) {
            //throw JSON.typeMismatch(name, object, "boolean");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.603 -0400", hash_original_method = "3DA4544CD80345F7570489979490BD16", hash_generated_method = "0390736102BC1A0C41994D809279B071")
    public boolean optBoolean(String name) {
        boolean var8BE80B6E9846B5FE1784886B30F81C14_128085822 = (optBoolean(name, false));
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1928927016 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1928927016;
        // ---------- Original Method ----------
        //return optBoolean(name, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.604 -0400", hash_original_method = "C49CAFC4CC69BC825D274D7317108A68", hash_generated_method = "134AB12CC5213FB7EB564AD7AD4D985E")
    public boolean optBoolean(String name, boolean fallback) {
        Object object;
        object = opt(name);
        Boolean result;
        result = JSON.toBoolean(object);
        addTaint(name.getTaint());
        addTaint(fallback);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_82552146 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_82552146;
        // ---------- Original Method ----------
        //Object object = opt(name);
        //Boolean result = JSON.toBoolean(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.663 -0400", hash_original_method = "0C60D6C72644A8965D87529BB9443348", hash_generated_method = "1FA6B2A4AC340E500DFB944ADD40C88F")
    public double getDouble(String name) throws JSONException {
        Object object;
        object = get(name);
        Double result;
        result = JSON.toDouble(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(name, object, "double");
        } //End block
        addTaint(name.getTaint());
        double varE8CD7DA078A86726031AD64F35F5A6C0_404260374 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_404260374;
        // ---------- Original Method ----------
        //Object object = get(name);
        //Double result = JSON.toDouble(object);
        //if (result == null) {
            //throw JSON.typeMismatch(name, object, "double");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.664 -0400", hash_original_method = "B9CFB7D5CC2BB58B8CACB29638DEE6A6", hash_generated_method = "B68BED05E4D198E529DD46467B732241")
    public double optDouble(String name) {
        double varC56F0B477EEE0A41E1A76F177E961C03_770441670 = (optDouble(name, Double.NaN));
        addTaint(name.getTaint());
        double varE8CD7DA078A86726031AD64F35F5A6C0_1367110939 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1367110939;
        // ---------- Original Method ----------
        //return optDouble(name, Double.NaN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.664 -0400", hash_original_method = "F525E9AC5AAC714EA253692C6DC9EE0E", hash_generated_method = "8D803A83DA38A6A39788DD3CE7241CEC")
    public double optDouble(String name, double fallback) {
        Object object;
        object = opt(name);
        Double result;
        result = JSON.toDouble(object);
        addTaint(name.getTaint());
        addTaint(fallback);
        double varE8CD7DA078A86726031AD64F35F5A6C0_1224232946 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1224232946;
        // ---------- Original Method ----------
        //Object object = opt(name);
        //Double result = JSON.toDouble(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.664 -0400", hash_original_method = "06DD6202AFC58B0F1BA6F9DBAA37C5F3", hash_generated_method = "FEF638E94BC2EBBB2AD171BC6D05022F")
    public int getInt(String name) throws JSONException {
        Object object;
        object = get(name);
        Integer result;
        result = JSON.toInteger(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(name, object, "int");
        } //End block
        addTaint(name.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1076750785 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1076750785;
        // ---------- Original Method ----------
        //Object object = get(name);
        //Integer result = JSON.toInteger(object);
        //if (result == null) {
            //throw JSON.typeMismatch(name, object, "int");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.665 -0400", hash_original_method = "CF8C56AE8C6952FAAA48007CA568A3BF", hash_generated_method = "2E051EE246E8982417D87A7A014ACCF2")
    public int optInt(String name) {
        int var9479CC3C6E3D661742F54067B614174E_1151681676 = (optInt(name, 0));
        addTaint(name.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_124889392 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_124889392;
        // ---------- Original Method ----------
        //return optInt(name, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.665 -0400", hash_original_method = "FC3121A883EAF5555BD9C194D7925D34", hash_generated_method = "BFB7A4387E42C1B2288D9268B0AF9695")
    public int optInt(String name, int fallback) {
        Object object;
        object = opt(name);
        Integer result;
        result = JSON.toInteger(object);
        addTaint(name.getTaint());
        addTaint(fallback);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_791917932 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_791917932;
        // ---------- Original Method ----------
        //Object object = opt(name);
        //Integer result = JSON.toInteger(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.665 -0400", hash_original_method = "55ABC1042FFC5D7EF9272460461F1426", hash_generated_method = "23979C1937660FC817817155AA96347E")
    public long getLong(String name) throws JSONException {
        Object object;
        object = get(name);
        Long result;
        result = JSON.toLong(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(name, object, "long");
        } //End block
        addTaint(name.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1972705607 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1972705607;
        // ---------- Original Method ----------
        //Object object = get(name);
        //Long result = JSON.toLong(object);
        //if (result == null) {
            //throw JSON.typeMismatch(name, object, "long");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.666 -0400", hash_original_method = "70DEF89A3C807E0937F5C9E9E3A1A203", hash_generated_method = "CF1B2A97A7255C3749760386E54E2693")
    public long optLong(String name) {
        long var4E3DB8E77FB5DFAD161FC7022FC765A8_107868650 = (optLong(name, 0L));
        addTaint(name.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_916101924 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_916101924;
        // ---------- Original Method ----------
        //return optLong(name, 0L);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.666 -0400", hash_original_method = "C94BC7D2B7352E7323E9E58C53ACE476", hash_generated_method = "508BBC0ACEDB668BEFE6C4FB9B2B42D3")
    public long optLong(String name, long fallback) {
        Object object;
        object = opt(name);
        Long result;
        result = JSON.toLong(object);
        addTaint(name.getTaint());
        addTaint(fallback);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_922168276 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_922168276;
        // ---------- Original Method ----------
        //Object object = opt(name);
        //Long result = JSON.toLong(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.666 -0400", hash_original_method = "CC649536AC568087B4414076D420F027", hash_generated_method = "53D4589E7B02246BFE509DE21528BEDD")
    public String getString(String name) throws JSONException {
        String varB4EAC82CA7396A68D541C85D26508E83_660305345 = null; //Variable for return #1
        Object object;
        object = get(name);
        String result;
        result = JSON.toString(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(name, object, "String");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_660305345 = result;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_660305345.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_660305345;
        // ---------- Original Method ----------
        //Object object = get(name);
        //String result = JSON.toString(object);
        //if (result == null) {
            //throw JSON.typeMismatch(name, object, "String");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.683 -0400", hash_original_method = "8B81E5CBB6FE92C9270C8AE14E1D248D", hash_generated_method = "480BA8B81EA86CA83A480CDCBD1B01EE")
    public String optString(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_1734414139 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1734414139 = optString(name, "");
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1734414139.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1734414139;
        // ---------- Original Method ----------
        //return optString(name, "");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.684 -0400", hash_original_method = "B4BBF2951ACCBF79FD3FE8AB17DCAE83", hash_generated_method = "6D97DD4D4492F0B00E756D020CA69B0E")
    public String optString(String name, String fallback) {
        String varB4EAC82CA7396A68D541C85D26508E83_479132355 = null; //Variable for return #1
        Object object;
        object = opt(name);
        String result;
        result = JSON.toString(object);
        varB4EAC82CA7396A68D541C85D26508E83_479132355 = result != null ? result : fallback;
        addTaint(name.getTaint());
        addTaint(fallback.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_479132355.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_479132355;
        // ---------- Original Method ----------
        //Object object = opt(name);
        //String result = JSON.toString(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.685 -0400", hash_original_method = "1CE1CD2D1D65AA0859027B9575FA80C4", hash_generated_method = "8A7B212F8F22A9D3A490F2BE87DEB5DE")
    public JSONArray getJSONArray(String name) throws JSONException {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_7029888 = null; //Variable for return #1
        Object object;
        object = get(name);
        {
            varB4EAC82CA7396A68D541C85D26508E83_7029888 = (JSONArray) object;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(name, object, "JSONArray");
        } //End block
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_7029888.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_7029888;
        // ---------- Original Method ----------
        //Object object = get(name);
        //if (object instanceof JSONArray) {
            //return (JSONArray) object;
        //} else {
            //throw JSON.typeMismatch(name, object, "JSONArray");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.686 -0400", hash_original_method = "576EFB0CB9E2FA91FCF1D9A3EF1337C6", hash_generated_method = "A7D53CBA365FE3795A0873D2331D2900")
    public JSONArray optJSONArray(String name) {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_429227521 = null; //Variable for return #1
        Object object;
        object = opt(name);
        varB4EAC82CA7396A68D541C85D26508E83_429227521 = object instanceof JSONArray ? (JSONArray) object : null;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_429227521.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_429227521;
        // ---------- Original Method ----------
        //Object object = opt(name);
        //return object instanceof JSONArray ? (JSONArray) object : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.691 -0400", hash_original_method = "5326315C93466A3B1E8C695224A5B5FD", hash_generated_method = "0F1E40BD2C9D4571E000C6A70371AFDA")
    public JSONObject getJSONObject(String name) throws JSONException {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_1134253819 = null; //Variable for return #1
        Object object;
        object = get(name);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1134253819 = (JSONObject) object;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(name, object, "JSONObject");
        } //End block
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1134253819.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1134253819;
        // ---------- Original Method ----------
        //Object object = get(name);
        //if (object instanceof JSONObject) {
            //return (JSONObject) object;
        //} else {
            //throw JSON.typeMismatch(name, object, "JSONObject");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.692 -0400", hash_original_method = "B736B3B7313026EC1CBB4CB1D3C2367D", hash_generated_method = "7D59D66FFFEA02DCFC2FB9A268EDAC39")
    public JSONObject optJSONObject(String name) {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_1279213778 = null; //Variable for return #1
        Object object;
        object = opt(name);
        varB4EAC82CA7396A68D541C85D26508E83_1279213778 = object instanceof JSONObject ? (JSONObject) object : null;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1279213778.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1279213778;
        // ---------- Original Method ----------
        //Object object = opt(name);
        //return object instanceof JSONObject ? (JSONObject) object : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.711 -0400", hash_original_method = "1E876AFA246F164144A4BA68FB0C8527", hash_generated_method = "F6F0D73E513928970E87E74B836CC8A2")
    public JSONArray toJSONArray(JSONArray names) throws JSONException {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_1190656684 = null; //Variable for return #1
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_799169989 = null; //Variable for return #2
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_421136775 = null; //Variable for return #3
        JSONArray result;
        result = new JSONArray();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1190656684 = null;
        } //End block
        int length;
        length = names.length();
        {
            varB4EAC82CA7396A68D541C85D26508E83_799169989 = null;
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
        varB4EAC82CA7396A68D541C85D26508E83_421136775 = result;
        addTaint(names.getTaint());
        JSONArray varA7E53CE21691AB073D9660D615818899_1983942871; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1983942871 = varB4EAC82CA7396A68D541C85D26508E83_1190656684;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1983942871 = varB4EAC82CA7396A68D541C85D26508E83_799169989;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1983942871 = varB4EAC82CA7396A68D541C85D26508E83_421136775;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1983942871.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1983942871;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.712 -0400", hash_original_method = "2D137981D66EA2E55940EA81187D393D", hash_generated_method = "8EEFA838C867C6AC4E4B4C1712824339")
    public Iterator keys() {
        Iterator varB4EAC82CA7396A68D541C85D26508E83_1158009939 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1158009939 = nameValuePairs.keySet().iterator();
        varB4EAC82CA7396A68D541C85D26508E83_1158009939.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1158009939;
        // ---------- Original Method ----------
        //return nameValuePairs.keySet().iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.712 -0400", hash_original_method = "3ECE715C4DC492B6D08AC6D2EACB5C9C", hash_generated_method = "F53730CAA35DC892AEDC42B1FB49556F")
    public JSONArray names() {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_789460563 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_789460563 = nameValuePairs.isEmpty()
                ? null
                : new JSONArray(new ArrayList<String>(nameValuePairs.keySet()));
        varB4EAC82CA7396A68D541C85D26508E83_789460563.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_789460563;
        // ---------- Original Method ----------
        //return nameValuePairs.isEmpty()
                //? null
                //: new JSONArray(new ArrayList<String>(nameValuePairs.keySet()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.713 -0400", hash_original_method = "CC6BE78472EEEAF64E530CA9F9B14BB5", hash_generated_method = "238683B4AAA4295D8BEBA1E896ACBF27")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_108768714 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1657644406 = null; //Variable for return #2
        try 
        {
            JSONStringer stringer;
            stringer = new JSONStringer();
            writeTo(stringer);
            varB4EAC82CA7396A68D541C85D26508E83_108768714 = stringer.toString();
        } //End block
        catch (JSONException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1657644406 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_83546047; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_83546047 = varB4EAC82CA7396A68D541C85D26508E83_108768714;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_83546047 = varB4EAC82CA7396A68D541C85D26508E83_1657644406;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_83546047.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_83546047;
        // ---------- Original Method ----------
        //try {
            //JSONStringer stringer = new JSONStringer();
            //writeTo(stringer);
            //return stringer.toString();
        //} catch (JSONException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.713 -0400", hash_original_method = "161CBAA0F7E505CC65BF62A9F4C8490E", hash_generated_method = "06032AAF379E04967BFE6A0A865F3AF4")
    public String toString(int indentSpaces) throws JSONException {
        String varB4EAC82CA7396A68D541C85D26508E83_898602174 = null; //Variable for return #1
        JSONStringer stringer;
        stringer = new JSONStringer(indentSpaces);
        writeTo(stringer);
        varB4EAC82CA7396A68D541C85D26508E83_898602174 = stringer.toString();
        addTaint(indentSpaces);
        varB4EAC82CA7396A68D541C85D26508E83_898602174.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_898602174;
        // ---------- Original Method ----------
        //JSONStringer stringer = new JSONStringer(indentSpaces);
        //writeTo(stringer);
        //return stringer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.761 -0400", hash_original_method = "4318203F3538DC271461FDA2F00ABD52", hash_generated_method = "4EA57C44AF2B2C8D13D1D7EEDAC79F71")
     void writeTo(JSONStringer stringer) throws JSONException {
        stringer.object();
        {
            Iterator<Map.Entry<String, Object>> varAC53BD32903113FD541755067191E1E9_1988306422 = (nameValuePairs.entrySet()).iterator();
            varAC53BD32903113FD541755067191E1E9_1988306422.hasNext();
            Map.Entry<String, Object> entry = varAC53BD32903113FD541755067191E1E9_1988306422.next();
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.762 -0400", hash_original_field = "4F8E83C95CFEE5158C01389EEFC269AA", hash_generated_field = "619FB37967C1A8607A60ED714D99DE91")

    private static Double NEGATIVE_ZERO = -0d;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.762 -0400", hash_original_field = "69D6A2BFA9970459DEF9916A4A819505", hash_generated_field = "3F3D3946D0FBB086C49E80D158F100D9")

    public static final Object NULL = new Object() {
        @Override public boolean equals(Object o) {
            return o == this || o == null; 
        }
        @Override public String toString() {
            return "null";
        }
    };
}

