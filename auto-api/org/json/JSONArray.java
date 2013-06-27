package org.json;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JSONArray {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.467 -0400", hash_original_field = "F09CC7EE3A9A93273F4B80601CAFB00C", hash_generated_field = "76A4FC356F020E02D923B1E56C39C10C")

    private List<Object> values;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.475 -0400", hash_original_method = "1427CA478AAC933787CA982EEEA58E55", hash_generated_method = "C0E1FE19CFD6C8C417EA7BEBD218CAB1")
    public  JSONArray() {
        values = new ArrayList<Object>();
        // ---------- Original Method ----------
        //values = new ArrayList<Object>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.476 -0400", hash_original_method = "805B0E8915A04C6C98723D3A60FEDF41", hash_generated_method = "4B9D9EC2F4D14E333AE5079990B38FA7")
    public  JSONArray(Collection copyFrom) {
        this();
        Collection<?> copyFromTyped;
        copyFromTyped = (Collection<?>) copyFrom;
        values.addAll(copyFromTyped);
        addTaint(copyFrom.getTaint());
        // ---------- Original Method ----------
        //Collection<?> copyFromTyped = (Collection<?>) copyFrom;
        //values.addAll(copyFromTyped);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.476 -0400", hash_original_method = "7582B79BE7678565BA45DD0B34B6A75F", hash_generated_method = "F57944023DEEA39B90899AF0F1D8A9C6")
    public  JSONArray(JSONTokener readFrom) throws JSONException {
        Object object;
        object = readFrom.nextValue();
        {
            values = ((JSONArray) object).values;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(object, "JSONArray");
        } //End block
        addTaint(readFrom.getTaint());
        // ---------- Original Method ----------
        //Object object = readFrom.nextValue();
        //if (object instanceof JSONArray) {
            //values = ((JSONArray) object).values;
        //} else {
            //throw JSON.typeMismatch(object, "JSONArray");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.476 -0400", hash_original_method = "FBB8D188E5327545CDAACE0ACBE68DD3", hash_generated_method = "9DFE658011D3DBAD15ECDD1AD977929B")
    public  JSONArray(String json) throws JSONException {
        this(new JSONTokener(json));
        addTaint(json.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.480 -0400", hash_original_method = "2C5D59A27A6C313C8872AC341D9D75C0", hash_generated_method = "3EA717065751BCF41E3A390846B72073")
    public int length() {
        int varFE0BF0CE0C99947CFE3CAA895B4887C8_219334403 = (values.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2101917373 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2101917373;
        // ---------- Original Method ----------
        //return values.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.481 -0400", hash_original_method = "F9CCA0A17EFD82FAE33507862E5A944E", hash_generated_method = "E5585EE6D68FBD92B2EE43FF884120AD")
    public JSONArray put(boolean value) {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_1948480084 = null; //Variable for return #1
        values.add(value);
        varB4EAC82CA7396A68D541C85D26508E83_1948480084 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1948480084.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1948480084;
        // ---------- Original Method ----------
        //values.add(value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.481 -0400", hash_original_method = "632D5AC8096954F0909B9EEBB1192731", hash_generated_method = "7E9B5DAE16697470FB6783C72D6C5289")
    public JSONArray put(double value) throws JSONException {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_1233076383 = null; //Variable for return #1
        values.add(JSON.checkDouble(value));
        varB4EAC82CA7396A68D541C85D26508E83_1233076383 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1233076383.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1233076383;
        // ---------- Original Method ----------
        //values.add(JSON.checkDouble(value));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.482 -0400", hash_original_method = "324220FCD4B61377969B5003ED2C32CE", hash_generated_method = "987A93CCE6652510638EDE1022696E70")
    public JSONArray put(int value) {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_1330350658 = null; //Variable for return #1
        values.add(value);
        varB4EAC82CA7396A68D541C85D26508E83_1330350658 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1330350658.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1330350658;
        // ---------- Original Method ----------
        //values.add(value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.492 -0400", hash_original_method = "4C6CD72BE64F436E9F52C8D610641FF3", hash_generated_method = "0A04B2475D1C96201A3E8D9C86EEDCAE")
    public JSONArray put(long value) {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_2052727320 = null; //Variable for return #1
        values.add(value);
        varB4EAC82CA7396A68D541C85D26508E83_2052727320 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_2052727320.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2052727320;
        // ---------- Original Method ----------
        //values.add(value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.492 -0400", hash_original_method = "1D7645A229713F67337A58F8FF42D21C", hash_generated_method = "2F4315104CC5A304646F1704D3877862")
    public JSONArray put(Object value) {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_408503646 = null; //Variable for return #1
        values.add(value);
        varB4EAC82CA7396A68D541C85D26508E83_408503646 = this;
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_408503646.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_408503646;
        // ---------- Original Method ----------
        //values.add(value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.493 -0400", hash_original_method = "A8D9FD0A2FF792A00A29218BCE37DF7B", hash_generated_method = "1C6A3B5520949DCC6FD9CD32BE50B7B3")
    public JSONArray put(int index, boolean value) throws JSONException {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_561449261 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_561449261 = put(index, (Boolean) value);
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_561449261.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_561449261;
        // ---------- Original Method ----------
        //return put(index, (Boolean) value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.494 -0400", hash_original_method = "EB27801A89D2451AEBF6D71C639BF890", hash_generated_method = "6655DAD6DA23BB88A1E09042C99911AD")
    public JSONArray put(int index, double value) throws JSONException {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_2032518962 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2032518962 = put(index, (Double) value);
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_2032518962.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2032518962;
        // ---------- Original Method ----------
        //return put(index, (Double) value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.494 -0400", hash_original_method = "95364EFCBA8D50C1E1F228177A921191", hash_generated_method = "FC13CF198A15BA0C2299626F1DD78E7E")
    public JSONArray put(int index, int value) throws JSONException {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_1800917429 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1800917429 = put(index, (Integer) value);
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1800917429.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1800917429;
        // ---------- Original Method ----------
        //return put(index, (Integer) value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.494 -0400", hash_original_method = "3F2291B7B045A442A1A296D04FF74C3B", hash_generated_method = "494D1681CA5DCCF7C90F51EE07A47D33")
    public JSONArray put(int index, long value) throws JSONException {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_1165053530 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1165053530 = put(index, (Long) value);
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1165053530.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1165053530;
        // ---------- Original Method ----------
        //return put(index, (Long) value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.495 -0400", hash_original_method = "965F91AFDF1516EF58CC39AD3E1136B7", hash_generated_method = "CF54BEBC6582CF4B90CC82888F815618")
    public JSONArray put(int index, Object value) throws JSONException {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_1755377462 = null; //Variable for return #1
        {
            JSON.checkDouble(((Number) value).doubleValue());
        } //End block
        {
            boolean var2B4B6857AFAECD928119D2C5979FA85A_790541906 = (values.size() <= index);
            {
                values.add(null);
            } //End block
        } //End collapsed parenthetic
        values.set(index, value);
        varB4EAC82CA7396A68D541C85D26508E83_1755377462 = this;
        addTaint(index);
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1755377462.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1755377462;
        // ---------- Original Method ----------
        //if (value instanceof Number) {
            //JSON.checkDouble(((Number) value).doubleValue());
        //}
        //while (values.size() <= index) {
            //values.add(null);
        //}
        //values.set(index, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.495 -0400", hash_original_method = "075BEAC25684C4B47CFBC04F9272F423", hash_generated_method = "1953351AEC126945F68E35CAF68448EE")
    public boolean isNull(int index) {
        Object value;
        value = opt(index);
        addTaint(index);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1505057369 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1505057369;
        // ---------- Original Method ----------
        //Object value = opt(index);
        //return value == null || value == JSONObject.NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.496 -0400", hash_original_method = "2917FB45D7E32294FB2932AB5B08992C", hash_generated_method = "6E9781027007BD515E5F81143C9EBFB2")
    public Object get(int index) throws JSONException {
        Object varB4EAC82CA7396A68D541C85D26508E83_2091694532 = null; //Variable for return #1
        try 
        {
            Object value;
            value = values.get(index);
            {
                if (DroidSafeAndroidRuntime.control) throw new JSONException("Value at " + index + " is null.");
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_2091694532 = value;
        } //End block
        catch (IndexOutOfBoundsException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new JSONException("Index " + index + " out of range [0.." + values.size() + ")");
        } //End block
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_2091694532.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2091694532;
        // ---------- Original Method ----------
        //try {
            //Object value = values.get(index);
            //if (value == null) {
                //throw new JSONException("Value at " + index + " is null.");
            //}
            //return value;
        //} catch (IndexOutOfBoundsException e) {
            //throw new JSONException("Index " + index + " out of range [0.." + values.size() + ")");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.516 -0400", hash_original_method = "3B6F9D3E5AFD1AB6175A8B6BF8959553", hash_generated_method = "1BF3527C7DB72EA720CCDB7569777623")
    public Object opt(int index) {
        Object varB4EAC82CA7396A68D541C85D26508E83_279898809 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_521226845 = null; //Variable for return #2
        {
            boolean var132C4C95984B2E0FF5E13EAAE18B9F13_1154839784 = (index < 0 || index >= values.size());
            {
                varB4EAC82CA7396A68D541C85D26508E83_279898809 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_521226845 = values.get(index);
        addTaint(index);
        Object varA7E53CE21691AB073D9660D615818899_1366137070; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1366137070 = varB4EAC82CA7396A68D541C85D26508E83_279898809;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1366137070 = varB4EAC82CA7396A68D541C85D26508E83_521226845;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1366137070.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1366137070;
        // ---------- Original Method ----------
        //if (index < 0 || index >= values.size()) {
            //return null;
        //}
        //return values.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.516 -0400", hash_original_method = "24E6A67B676FCC7270A02518A61B22A2", hash_generated_method = "04820122EAD0882A0AEF4CEB727FFEE5")
    public boolean getBoolean(int index) throws JSONException {
        Object object;
        object = get(index);
        Boolean result;
        result = JSON.toBoolean(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(index, object, "boolean");
        } //End block
        addTaint(index);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_646792693 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_646792693;
        // ---------- Original Method ----------
        //Object object = get(index);
        //Boolean result = JSON.toBoolean(object);
        //if (result == null) {
            //throw JSON.typeMismatch(index, object, "boolean");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.517 -0400", hash_original_method = "A304D16233AC57FB2DDAD429570460E8", hash_generated_method = "E6FF97C68BE6B831641591748F2A428B")
    public boolean optBoolean(int index) {
        boolean var4B8DE6C9BC9DF2A597FF887DEEFA1EE5_428026813 = (optBoolean(index, false));
        addTaint(index);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_28897262 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_28897262;
        // ---------- Original Method ----------
        //return optBoolean(index, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.517 -0400", hash_original_method = "D837DFEA35C0469693745E1088FDEE2E", hash_generated_method = "90BF2ACE295896E6E53F1ACE74A801ED")
    public boolean optBoolean(int index, boolean fallback) {
        Object object;
        object = opt(index);
        Boolean result;
        result = JSON.toBoolean(object);
        addTaint(index);
        addTaint(fallback);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2032881366 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2032881366;
        // ---------- Original Method ----------
        //Object object = opt(index);
        //Boolean result = JSON.toBoolean(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.517 -0400", hash_original_method = "6D74AEBF7F111E364BD2DB0E7727FAF6", hash_generated_method = "58496FD5F414EA88CBAF473AA23A0230")
    public double getDouble(int index) throws JSONException {
        Object object;
        object = get(index);
        Double result;
        result = JSON.toDouble(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(index, object, "double");
        } //End block
        addTaint(index);
        double varE8CD7DA078A86726031AD64F35F5A6C0_1262728108 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1262728108;
        // ---------- Original Method ----------
        //Object object = get(index);
        //Double result = JSON.toDouble(object);
        //if (result == null) {
            //throw JSON.typeMismatch(index, object, "double");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.518 -0400", hash_original_method = "6ACFD4932D58B1B1AAD30FC39935EAD2", hash_generated_method = "E7E3980B9FB7177619FF29D34FB6B39D")
    public double optDouble(int index) {
        double var2F77D8BD61B508531C2B6A152C657B91_2135808325 = (optDouble(index, Double.NaN));
        addTaint(index);
        double varE8CD7DA078A86726031AD64F35F5A6C0_1647914774 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1647914774;
        // ---------- Original Method ----------
        //return optDouble(index, Double.NaN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.518 -0400", hash_original_method = "0BBC192CCA032D1199B25DAD0E3977E8", hash_generated_method = "FB0A387697C1AB185640D583018F27B4")
    public double optDouble(int index, double fallback) {
        Object object;
        object = opt(index);
        Double result;
        result = JSON.toDouble(object);
        addTaint(index);
        addTaint(fallback);
        double varE8CD7DA078A86726031AD64F35F5A6C0_1078121155 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1078121155;
        // ---------- Original Method ----------
        //Object object = opt(index);
        //Double result = JSON.toDouble(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.538 -0400", hash_original_method = "853222C548896141F9D1D8AF0338F5C4", hash_generated_method = "FD3905A5C35BED69E780CD90DE56B94B")
    public int getInt(int index) throws JSONException {
        Object object;
        object = get(index);
        Integer result;
        result = JSON.toInteger(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(index, object, "int");
        } //End block
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1630169399 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1630169399;
        // ---------- Original Method ----------
        //Object object = get(index);
        //Integer result = JSON.toInteger(object);
        //if (result == null) {
            //throw JSON.typeMismatch(index, object, "int");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.539 -0400", hash_original_method = "7CF76FC4FBEA846C37B11EB5D3437F82", hash_generated_method = "125732C378F56B1B62883B3C9709908E")
    public int optInt(int index) {
        int varD8D9D2BD4A82A82653E187AF20B76514_1807626001 = (optInt(index, 0));
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1882167396 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1882167396;
        // ---------- Original Method ----------
        //return optInt(index, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.539 -0400", hash_original_method = "5DB279774D0456981D1F7F001BBC18BA", hash_generated_method = "C56057FAC274789685B88C67BB94F72B")
    public int optInt(int index, int fallback) {
        Object object;
        object = opt(index);
        Integer result;
        result = JSON.toInteger(object);
        addTaint(index);
        addTaint(fallback);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_702422028 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_702422028;
        // ---------- Original Method ----------
        //Object object = opt(index);
        //Integer result = JSON.toInteger(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.539 -0400", hash_original_method = "56F71130ADC070DD70D4CA02CA42F381", hash_generated_method = "35976030DB432E2EF68ECB5B587ECD46")
    public long getLong(int index) throws JSONException {
        Object object;
        object = get(index);
        Long result;
        result = JSON.toLong(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(index, object, "long");
        } //End block
        addTaint(index);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_845788942 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_845788942;
        // ---------- Original Method ----------
        //Object object = get(index);
        //Long result = JSON.toLong(object);
        //if (result == null) {
            //throw JSON.typeMismatch(index, object, "long");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.540 -0400", hash_original_method = "2BBCBA9E354F863B816F565C8B8E92CB", hash_generated_method = "EF259B876CDA6EE63CF608ADF87FBDFC")
    public long optLong(int index) {
        long varAF24B1D10932CD296BDC344232BE5ECF_585870399 = (optLong(index, 0L));
        addTaint(index);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_901487311 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_901487311;
        // ---------- Original Method ----------
        //return optLong(index, 0L);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.540 -0400", hash_original_method = "81CF1715684C5D206C6FD7331990B13E", hash_generated_method = "DE54B9DA71DFA18A37AD449230CCD11E")
    public long optLong(int index, long fallback) {
        Object object;
        object = opt(index);
        Long result;
        result = JSON.toLong(object);
        addTaint(index);
        addTaint(fallback);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_464812452 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_464812452;
        // ---------- Original Method ----------
        //Object object = opt(index);
        //Long result = JSON.toLong(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.540 -0400", hash_original_method = "7F7D1138F84D636CF19BD9329533631C", hash_generated_method = "1114074CC59F17060167AB5484327840")
    public String getString(int index) throws JSONException {
        String varB4EAC82CA7396A68D541C85D26508E83_1517508253 = null; //Variable for return #1
        Object object;
        object = get(index);
        String result;
        result = JSON.toString(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(index, object, "String");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1517508253 = result;
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1517508253.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1517508253;
        // ---------- Original Method ----------
        //Object object = get(index);
        //String result = JSON.toString(object);
        //if (result == null) {
            //throw JSON.typeMismatch(index, object, "String");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.541 -0400", hash_original_method = "C31202553EDC4F0A1E4B21CAD06ABEC4", hash_generated_method = "9C8D5F54D3DCFAB234053639ED113B17")
    public String optString(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1107169297 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1107169297 = optString(index, "");
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1107169297.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1107169297;
        // ---------- Original Method ----------
        //return optString(index, "");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.541 -0400", hash_original_method = "97366D23F93DD4ABD9E565325F7585B9", hash_generated_method = "FD3B62F8F4773C6AABA62A9C515E2BB8")
    public String optString(int index, String fallback) {
        String varB4EAC82CA7396A68D541C85D26508E83_2059485890 = null; //Variable for return #1
        Object object;
        object = opt(index);
        String result;
        result = JSON.toString(object);
        varB4EAC82CA7396A68D541C85D26508E83_2059485890 = result != null ? result : fallback;
        addTaint(index);
        addTaint(fallback.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2059485890.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2059485890;
        // ---------- Original Method ----------
        //Object object = opt(index);
        //String result = JSON.toString(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.542 -0400", hash_original_method = "173A28EF43B750DEF6376D4E3E2F6DD2", hash_generated_method = "CB95ADA28396739586838A1AEDA9FCBF")
    public JSONArray getJSONArray(int index) throws JSONException {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_1449539507 = null; //Variable for return #1
        Object object;
        object = get(index);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1449539507 = (JSONArray) object;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(index, object, "JSONArray");
        } //End block
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1449539507.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1449539507;
        // ---------- Original Method ----------
        //Object object = get(index);
        //if (object instanceof JSONArray) {
            //return (JSONArray) object;
        //} else {
            //throw JSON.typeMismatch(index, object, "JSONArray");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.542 -0400", hash_original_method = "CBF30564657B4CB07ABBCF29084A5653", hash_generated_method = "B64FD760F441282275F820DBEACFB9F0")
    public JSONArray optJSONArray(int index) {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_1940434197 = null; //Variable for return #1
        Object object;
        object = opt(index);
        varB4EAC82CA7396A68D541C85D26508E83_1940434197 = object instanceof JSONArray ? (JSONArray) object : null;
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1940434197.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1940434197;
        // ---------- Original Method ----------
        //Object object = opt(index);
        //return object instanceof JSONArray ? (JSONArray) object : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.543 -0400", hash_original_method = "EA5692C9D71198B472B917468564A78A", hash_generated_method = "5DBDD3DF00CCF485297EF20097761DB0")
    public JSONObject getJSONObject(int index) throws JSONException {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_1731438895 = null; //Variable for return #1
        Object object;
        object = get(index);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1731438895 = (JSONObject) object;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(index, object, "JSONObject");
        } //End block
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1731438895.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1731438895;
        // ---------- Original Method ----------
        //Object object = get(index);
        //if (object instanceof JSONObject) {
            //return (JSONObject) object;
        //} else {
            //throw JSON.typeMismatch(index, object, "JSONObject");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.543 -0400", hash_original_method = "871DF64EA3EF0F09C790BD6ABB0AB209", hash_generated_method = "1B6ADC82676850AD89CD4BB225CD6C11")
    public JSONObject optJSONObject(int index) {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_1224988358 = null; //Variable for return #1
        Object object;
        object = opt(index);
        varB4EAC82CA7396A68D541C85D26508E83_1224988358 = object instanceof JSONObject ? (JSONObject) object : null;
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1224988358.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1224988358;
        // ---------- Original Method ----------
        //Object object = opt(index);
        //return object instanceof JSONObject ? (JSONObject) object : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.544 -0400", hash_original_method = "CEEBF6D79C62E432FE9EF262922223A6", hash_generated_method = "83DA92B6B2CCF8798AAB37A0782E1F59")
    public JSONObject toJSONObject(JSONArray names) throws JSONException {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_115441881 = null; //Variable for return #1
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_1798080404 = null; //Variable for return #2
        JSONObject result;
        result = new JSONObject();
        int length;
        length = Math.min(names.length(), values.size());
        {
            varB4EAC82CA7396A68D541C85D26508E83_115441881 = null;
        } //End block
        {
            int i;
            i = 0;
            {
                String name;
                name = JSON.toString(names.opt(i));
                result.put(name, opt(i));
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1798080404 = result;
        addTaint(names.getTaint());
        JSONObject varA7E53CE21691AB073D9660D615818899_458286282; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_458286282 = varB4EAC82CA7396A68D541C85D26508E83_115441881;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_458286282 = varB4EAC82CA7396A68D541C85D26508E83_1798080404;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_458286282.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_458286282;
        // ---------- Original Method ----------
        //JSONObject result = new JSONObject();
        //int length = Math.min(names.length(), values.size());
        //if (length == 0) {
            //return null;
        //}
        //for (int i = 0; i < length; i++) {
            //String name = JSON.toString(names.opt(i));
            //result.put(name, opt(i));
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.545 -0400", hash_original_method = "818E08743989593DA274993EAEC63482", hash_generated_method = "C842D328BD80AB8E24C44E2EAC46A134")
    public String join(String separator) throws JSONException {
        String varB4EAC82CA7396A68D541C85D26508E83_1226395072 = null; //Variable for return #1
        JSONStringer stringer;
        stringer = new JSONStringer();
        stringer.open(JSONStringer.Scope.NULL, "");
        {
            int i, size;
            i = 0;
            size = values.size();
            {
                {
                    stringer.out.append(separator);
                } //End block
                stringer.value(values.get(i));
            } //End block
        } //End collapsed parenthetic
        stringer.close(JSONStringer.Scope.NULL, JSONStringer.Scope.NULL, "");
        varB4EAC82CA7396A68D541C85D26508E83_1226395072 = stringer.out.toString();
        addTaint(separator.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1226395072.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1226395072;
        // ---------- Original Method ----------
        //JSONStringer stringer = new JSONStringer();
        //stringer.open(JSONStringer.Scope.NULL, "");
        //for (int i = 0, size = values.size(); i < size; i++) {
            //if (i > 0) {
                //stringer.out.append(separator);
            //}
            //stringer.value(values.get(i));
        //}
        //stringer.close(JSONStringer.Scope.NULL, JSONStringer.Scope.NULL, "");
        //return stringer.out.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.546 -0400", hash_original_method = "CC6BE78472EEEAF64E530CA9F9B14BB5", hash_generated_method = "8716F1621B640B409BEA4B61895CF789")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_433320104 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1897862901 = null; //Variable for return #2
        try 
        {
            JSONStringer stringer;
            stringer = new JSONStringer();
            writeTo(stringer);
            varB4EAC82CA7396A68D541C85D26508E83_433320104 = stringer.toString();
        } //End block
        catch (JSONException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1897862901 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1149318511; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1149318511 = varB4EAC82CA7396A68D541C85D26508E83_433320104;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1149318511 = varB4EAC82CA7396A68D541C85D26508E83_1897862901;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1149318511.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1149318511;
        // ---------- Original Method ----------
        //try {
            //JSONStringer stringer = new JSONStringer();
            //writeTo(stringer);
            //return stringer.toString();
        //} catch (JSONException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.546 -0400", hash_original_method = "161CBAA0F7E505CC65BF62A9F4C8490E", hash_generated_method = "D960FBCA0A14274724468D8C13EB347B")
    public String toString(int indentSpaces) throws JSONException {
        String varB4EAC82CA7396A68D541C85D26508E83_2056355365 = null; //Variable for return #1
        JSONStringer stringer;
        stringer = new JSONStringer(indentSpaces);
        writeTo(stringer);
        varB4EAC82CA7396A68D541C85D26508E83_2056355365 = stringer.toString();
        addTaint(indentSpaces);
        varB4EAC82CA7396A68D541C85D26508E83_2056355365.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2056355365;
        // ---------- Original Method ----------
        //JSONStringer stringer = new JSONStringer(indentSpaces);
        //writeTo(stringer);
        //return stringer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.595 -0400", hash_original_method = "07D36EC028565C954CCF4CA47905C766", hash_generated_method = "BA7EBA2D57A9A7EB5D6F85397E4AACF0")
     void writeTo(JSONStringer stringer) throws JSONException {
        stringer.array();
        {
            Iterator<Object> var130A2A32E1B03BFE017093C104B0D8C2_284808827 = (values).iterator();
            var130A2A32E1B03BFE017093C104B0D8C2_284808827.hasNext();
            Object value = var130A2A32E1B03BFE017093C104B0D8C2_284808827.next();
            {
                stringer.value(value);
            } //End block
        } //End collapsed parenthetic
        stringer.endArray();
        addTaint(stringer.getTaint());
        // ---------- Original Method ----------
        //stringer.array();
        //for (Object value : values) {
            //stringer.value(value);
        //}
        //stringer.endArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.595 -0400", hash_original_method = "BF4C72A1D6E8FA2592A6106FA9BE5FDF", hash_generated_method = "7F2CC9213803C69AB8815DACE02CAC66")
    @Override
    public boolean equals(Object o) {
        boolean var55ECC7CEA4332693419A47B87C1FDC1B_1283506836 = (o instanceof JSONArray && ((JSONArray) o).values.equals(values));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_141149432 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_141149432;
        // ---------- Original Method ----------
        //return o instanceof JSONArray && ((JSONArray) o).values.equals(values);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.596 -0400", hash_original_method = "5391F86F0DF47CDF0FABD2AA1BAE9E60", hash_generated_method = "5489B87846497243C94F5D1154AFCCA0")
    @Override
    public int hashCode() {
        int var3FF07D23466C64F67CC15CC69EEE9A22_382379698 = (values.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1733707762 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1733707762;
        // ---------- Original Method ----------
        //return values.hashCode();
    }

    
}

