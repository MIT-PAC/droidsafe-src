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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.183 -0400", hash_original_field = "F09CC7EE3A9A93273F4B80601CAFB00C", hash_generated_field = "76A4FC356F020E02D923B1E56C39C10C")

    private List<Object> values;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.184 -0400", hash_original_method = "1427CA478AAC933787CA982EEEA58E55", hash_generated_method = "C0E1FE19CFD6C8C417EA7BEBD218CAB1")
    public  JSONArray() {
        values = new ArrayList<Object>();
        // ---------- Original Method ----------
        //values = new ArrayList<Object>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.184 -0400", hash_original_method = "805B0E8915A04C6C98723D3A60FEDF41", hash_generated_method = "4DCC9740099BF359895DE335D5D08458")
    public  JSONArray(Collection copyFrom) {
        this();
        Collection<?> copyFromTyped = (Collection<?>) copyFrom;
        values.addAll(copyFromTyped);
        addTaint(copyFrom.getTaint());
        // ---------- Original Method ----------
        //Collection<?> copyFromTyped = (Collection<?>) copyFrom;
        //values.addAll(copyFromTyped);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.184 -0400", hash_original_method = "7582B79BE7678565BA45DD0B34B6A75F", hash_generated_method = "0B7D1D944ABC7A53BC0EE5EB215CD759")
    public  JSONArray(JSONTokener readFrom) throws JSONException {
        Object object = readFrom.nextValue();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.185 -0400", hash_original_method = "FBB8D188E5327545CDAACE0ACBE68DD3", hash_generated_method = "9DFE658011D3DBAD15ECDD1AD977929B")
    public  JSONArray(String json) throws JSONException {
        this(new JSONTokener(json));
        addTaint(json.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.185 -0400", hash_original_method = "2C5D59A27A6C313C8872AC341D9D75C0", hash_generated_method = "68C0E0D15CCD241B72D0DE0E5173A7A4")
    public int length() {
        int varFE0BF0CE0C99947CFE3CAA895B4887C8_302567651 = (values.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_38570570 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_38570570;
        // ---------- Original Method ----------
        //return values.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.185 -0400", hash_original_method = "F9CCA0A17EFD82FAE33507862E5A944E", hash_generated_method = "A40F1BFE4E8806148AFC45CF9FF23FBB")
    public JSONArray put(boolean value) {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_986687229 = null; //Variable for return #1
        values.add(value);
        varB4EAC82CA7396A68D541C85D26508E83_986687229 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_986687229.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_986687229;
        // ---------- Original Method ----------
        //values.add(value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.186 -0400", hash_original_method = "632D5AC8096954F0909B9EEBB1192731", hash_generated_method = "D8B87BACED883436C3551D3F634E43C2")
    public JSONArray put(double value) throws JSONException {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_171808655 = null; //Variable for return #1
        values.add(JSON.checkDouble(value));
        varB4EAC82CA7396A68D541C85D26508E83_171808655 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_171808655.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_171808655;
        // ---------- Original Method ----------
        //values.add(JSON.checkDouble(value));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.186 -0400", hash_original_method = "324220FCD4B61377969B5003ED2C32CE", hash_generated_method = "6D9D91B34584A069DBCFCCB746FAF487")
    public JSONArray put(int value) {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_611361094 = null; //Variable for return #1
        values.add(value);
        varB4EAC82CA7396A68D541C85D26508E83_611361094 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_611361094.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_611361094;
        // ---------- Original Method ----------
        //values.add(value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.187 -0400", hash_original_method = "4C6CD72BE64F436E9F52C8D610641FF3", hash_generated_method = "83F595A518CABFE799084A5BEFB863DD")
    public JSONArray put(long value) {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_1133999444 = null; //Variable for return #1
        values.add(value);
        varB4EAC82CA7396A68D541C85D26508E83_1133999444 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1133999444.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1133999444;
        // ---------- Original Method ----------
        //values.add(value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.188 -0400", hash_original_method = "1D7645A229713F67337A58F8FF42D21C", hash_generated_method = "77C241B8E5AC2B419BF5EFC989728D64")
    public JSONArray put(Object value) {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_634434965 = null; //Variable for return #1
        values.add(value);
        varB4EAC82CA7396A68D541C85D26508E83_634434965 = this;
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_634434965.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_634434965;
        // ---------- Original Method ----------
        //values.add(value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.188 -0400", hash_original_method = "A8D9FD0A2FF792A00A29218BCE37DF7B", hash_generated_method = "9C5E1D4DC62852C5745ADD94651FB677")
    public JSONArray put(int index, boolean value) throws JSONException {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_315884189 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_315884189 = put(index, (Boolean) value);
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_315884189.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_315884189;
        // ---------- Original Method ----------
        //return put(index, (Boolean) value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.189 -0400", hash_original_method = "EB27801A89D2451AEBF6D71C639BF890", hash_generated_method = "41CC3DBF7B1136808EBE280569C2E887")
    public JSONArray put(int index, double value) throws JSONException {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_1242782131 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1242782131 = put(index, (Double) value);
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1242782131.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1242782131;
        // ---------- Original Method ----------
        //return put(index, (Double) value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.190 -0400", hash_original_method = "95364EFCBA8D50C1E1F228177A921191", hash_generated_method = "963A99CD80744996D8DAF9D688302E3B")
    public JSONArray put(int index, int value) throws JSONException {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_1539674544 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1539674544 = put(index, (Integer) value);
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1539674544.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1539674544;
        // ---------- Original Method ----------
        //return put(index, (Integer) value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.190 -0400", hash_original_method = "3F2291B7B045A442A1A296D04FF74C3B", hash_generated_method = "029B3C5109294858BEF3E2CAA73F7209")
    public JSONArray put(int index, long value) throws JSONException {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_599419296 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_599419296 = put(index, (Long) value);
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_599419296.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_599419296;
        // ---------- Original Method ----------
        //return put(index, (Long) value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.190 -0400", hash_original_method = "965F91AFDF1516EF58CC39AD3E1136B7", hash_generated_method = "FB65135812212E8ABC5512E61B5E0EA5")
    public JSONArray put(int index, Object value) throws JSONException {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_1620732329 = null; //Variable for return #1
        {
            JSON.checkDouble(((Number) value).doubleValue());
        } //End block
        {
            boolean var2B4B6857AFAECD928119D2C5979FA85A_470025463 = (values.size() <= index);
            {
                values.add(null);
            } //End block
        } //End collapsed parenthetic
        values.set(index, value);
        varB4EAC82CA7396A68D541C85D26508E83_1620732329 = this;
        addTaint(index);
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1620732329.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1620732329;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.191 -0400", hash_original_method = "075BEAC25684C4B47CFBC04F9272F423", hash_generated_method = "84A492FF8E38035B1194AB365A1DE826")
    public boolean isNull(int index) {
        Object value = opt(index);
        addTaint(index);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_402861203 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_402861203;
        // ---------- Original Method ----------
        //Object value = opt(index);
        //return value == null || value == JSONObject.NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.191 -0400", hash_original_method = "2917FB45D7E32294FB2932AB5B08992C", hash_generated_method = "5170B3D514F75F06261B86C0AFCBA4BF")
    public Object get(int index) throws JSONException {
        Object varB4EAC82CA7396A68D541C85D26508E83_2083727312 = null; //Variable for return #1
        try 
        {
            Object value = values.get(index);
            {
                if (DroidSafeAndroidRuntime.control) throw new JSONException("Value at " + index + " is null.");
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_2083727312 = value;
        } //End block
        catch (IndexOutOfBoundsException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new JSONException("Index " + index + " out of range [0.." + values.size() + ")");
        } //End block
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_2083727312.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2083727312;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.192 -0400", hash_original_method = "3B6F9D3E5AFD1AB6175A8B6BF8959553", hash_generated_method = "11B290C903AC8E5ED78F28A41FB07779")
    public Object opt(int index) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1135104899 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_347022932 = null; //Variable for return #2
        {
            boolean var132C4C95984B2E0FF5E13EAAE18B9F13_49660703 = (index < 0 || index >= values.size());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1135104899 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_347022932 = values.get(index);
        addTaint(index);
        Object varA7E53CE21691AB073D9660D615818899_1993720551; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1993720551 = varB4EAC82CA7396A68D541C85D26508E83_1135104899;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1993720551 = varB4EAC82CA7396A68D541C85D26508E83_347022932;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1993720551.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1993720551;
        // ---------- Original Method ----------
        //if (index < 0 || index >= values.size()) {
            //return null;
        //}
        //return values.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.192 -0400", hash_original_method = "24E6A67B676FCC7270A02518A61B22A2", hash_generated_method = "FB13B980558BA5F3E159385247B455CD")
    public boolean getBoolean(int index) throws JSONException {
        Object object = get(index);
        Boolean result = JSON.toBoolean(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(index, object, "boolean");
        } //End block
        addTaint(index);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1059592780 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1059592780;
        // ---------- Original Method ----------
        //Object object = get(index);
        //Boolean result = JSON.toBoolean(object);
        //if (result == null) {
            //throw JSON.typeMismatch(index, object, "boolean");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.192 -0400", hash_original_method = "A304D16233AC57FB2DDAD429570460E8", hash_generated_method = "DAE10201FCFC74054663709A635964CC")
    public boolean optBoolean(int index) {
        boolean var4B8DE6C9BC9DF2A597FF887DEEFA1EE5_983661381 = (optBoolean(index, false));
        addTaint(index);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1891145311 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1891145311;
        // ---------- Original Method ----------
        //return optBoolean(index, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.193 -0400", hash_original_method = "D837DFEA35C0469693745E1088FDEE2E", hash_generated_method = "DE0DC2AD5B9C2683585E05C8A386282E")
    public boolean optBoolean(int index, boolean fallback) {
        Object object = opt(index);
        Boolean result = JSON.toBoolean(object);
        addTaint(index);
        addTaint(fallback);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_221964332 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_221964332;
        // ---------- Original Method ----------
        //Object object = opt(index);
        //Boolean result = JSON.toBoolean(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.193 -0400", hash_original_method = "6D74AEBF7F111E364BD2DB0E7727FAF6", hash_generated_method = "62AA149E09FDAC004BC2C50DD86C7B9B")
    public double getDouble(int index) throws JSONException {
        Object object = get(index);
        Double result = JSON.toDouble(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(index, object, "double");
        } //End block
        addTaint(index);
        double varE8CD7DA078A86726031AD64F35F5A6C0_792890800 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_792890800;
        // ---------- Original Method ----------
        //Object object = get(index);
        //Double result = JSON.toDouble(object);
        //if (result == null) {
            //throw JSON.typeMismatch(index, object, "double");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.193 -0400", hash_original_method = "6ACFD4932D58B1B1AAD30FC39935EAD2", hash_generated_method = "D67683155C8C818A3A1CC8D044767363")
    public double optDouble(int index) {
        double var2F77D8BD61B508531C2B6A152C657B91_480675182 = (optDouble(index, Double.NaN));
        addTaint(index);
        double varE8CD7DA078A86726031AD64F35F5A6C0_200718444 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_200718444;
        // ---------- Original Method ----------
        //return optDouble(index, Double.NaN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.193 -0400", hash_original_method = "0BBC192CCA032D1199B25DAD0E3977E8", hash_generated_method = "8C6169110A5DA829AADD4D4DEF98EC37")
    public double optDouble(int index, double fallback) {
        Object object = opt(index);
        Double result = JSON.toDouble(object);
        addTaint(index);
        addTaint(fallback);
        double varE8CD7DA078A86726031AD64F35F5A6C0_298063843 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_298063843;
        // ---------- Original Method ----------
        //Object object = opt(index);
        //Double result = JSON.toDouble(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.194 -0400", hash_original_method = "853222C548896141F9D1D8AF0338F5C4", hash_generated_method = "F9B3D4222DDD95C1A93720BC63B5FD94")
    public int getInt(int index) throws JSONException {
        Object object = get(index);
        Integer result = JSON.toInteger(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(index, object, "int");
        } //End block
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1030589039 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1030589039;
        // ---------- Original Method ----------
        //Object object = get(index);
        //Integer result = JSON.toInteger(object);
        //if (result == null) {
            //throw JSON.typeMismatch(index, object, "int");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.194 -0400", hash_original_method = "7CF76FC4FBEA846C37B11EB5D3437F82", hash_generated_method = "49576B2B276AF5A09DDD261D78EDA762")
    public int optInt(int index) {
        int varD8D9D2BD4A82A82653E187AF20B76514_238519076 = (optInt(index, 0));
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_762590295 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_762590295;
        // ---------- Original Method ----------
        //return optInt(index, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.194 -0400", hash_original_method = "5DB279774D0456981D1F7F001BBC18BA", hash_generated_method = "71159EE52314A81E1B9608AA27F6339A")
    public int optInt(int index, int fallback) {
        Object object = opt(index);
        Integer result = JSON.toInteger(object);
        addTaint(index);
        addTaint(fallback);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1304520626 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1304520626;
        // ---------- Original Method ----------
        //Object object = opt(index);
        //Integer result = JSON.toInteger(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.194 -0400", hash_original_method = "56F71130ADC070DD70D4CA02CA42F381", hash_generated_method = "87BF995CA264880567D0B57CDFD06174")
    public long getLong(int index) throws JSONException {
        Object object = get(index);
        Long result = JSON.toLong(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(index, object, "long");
        } //End block
        addTaint(index);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1102904123 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1102904123;
        // ---------- Original Method ----------
        //Object object = get(index);
        //Long result = JSON.toLong(object);
        //if (result == null) {
            //throw JSON.typeMismatch(index, object, "long");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.195 -0400", hash_original_method = "2BBCBA9E354F863B816F565C8B8E92CB", hash_generated_method = "C0C3474A27C8B666847AE85D338E482C")
    public long optLong(int index) {
        long varAF24B1D10932CD296BDC344232BE5ECF_1032355276 = (optLong(index, 0L));
        addTaint(index);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_234262785 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_234262785;
        // ---------- Original Method ----------
        //return optLong(index, 0L);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.195 -0400", hash_original_method = "81CF1715684C5D206C6FD7331990B13E", hash_generated_method = "603CA4F75E7400E832A7CC779867368A")
    public long optLong(int index, long fallback) {
        Object object = opt(index);
        Long result = JSON.toLong(object);
        addTaint(index);
        addTaint(fallback);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1838330234 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1838330234;
        // ---------- Original Method ----------
        //Object object = opt(index);
        //Long result = JSON.toLong(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.195 -0400", hash_original_method = "7F7D1138F84D636CF19BD9329533631C", hash_generated_method = "71B599A0E80F723E40934F6C63F69168")
    public String getString(int index) throws JSONException {
        String varB4EAC82CA7396A68D541C85D26508E83_1560840139 = null; //Variable for return #1
        Object object = get(index);
        String result = JSON.toString(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(index, object, "String");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1560840139 = result;
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1560840139.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1560840139;
        // ---------- Original Method ----------
        //Object object = get(index);
        //String result = JSON.toString(object);
        //if (result == null) {
            //throw JSON.typeMismatch(index, object, "String");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.196 -0400", hash_original_method = "C31202553EDC4F0A1E4B21CAD06ABEC4", hash_generated_method = "386C5531746587EEF44EAA664F48E2A8")
    public String optString(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1025572909 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1025572909 = optString(index, "");
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1025572909.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1025572909;
        // ---------- Original Method ----------
        //return optString(index, "");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.197 -0400", hash_original_method = "97366D23F93DD4ABD9E565325F7585B9", hash_generated_method = "7A784D131886552B6440F001A21FCA28")
    public String optString(int index, String fallback) {
        String varB4EAC82CA7396A68D541C85D26508E83_310735451 = null; //Variable for return #1
        Object object = opt(index);
        String result = JSON.toString(object);
        varB4EAC82CA7396A68D541C85D26508E83_310735451 = result != null ? result : fallback;
        addTaint(index);
        addTaint(fallback.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_310735451.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_310735451;
        // ---------- Original Method ----------
        //Object object = opt(index);
        //String result = JSON.toString(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.197 -0400", hash_original_method = "173A28EF43B750DEF6376D4E3E2F6DD2", hash_generated_method = "5987CD4F4F5D7EF2A94F1247FE9523AD")
    public JSONArray getJSONArray(int index) throws JSONException {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_1367263927 = null; //Variable for return #1
        Object object = get(index);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1367263927 = (JSONArray) object;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(index, object, "JSONArray");
        } //End block
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1367263927.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1367263927;
        // ---------- Original Method ----------
        //Object object = get(index);
        //if (object instanceof JSONArray) {
            //return (JSONArray) object;
        //} else {
            //throw JSON.typeMismatch(index, object, "JSONArray");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.198 -0400", hash_original_method = "CBF30564657B4CB07ABBCF29084A5653", hash_generated_method = "1207AE15DDEF57C10CE8BBA8217E6A4E")
    public JSONArray optJSONArray(int index) {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_541717905 = null; //Variable for return #1
        Object object = opt(index);
        varB4EAC82CA7396A68D541C85D26508E83_541717905 = object instanceof JSONArray ? (JSONArray) object : null;
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_541717905.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_541717905;
        // ---------- Original Method ----------
        //Object object = opt(index);
        //return object instanceof JSONArray ? (JSONArray) object : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.199 -0400", hash_original_method = "EA5692C9D71198B472B917468564A78A", hash_generated_method = "AAADA1E1D91FD4D987415E4B4C89F99B")
    public JSONObject getJSONObject(int index) throws JSONException {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_9882329 = null; //Variable for return #1
        Object object = get(index);
        {
            varB4EAC82CA7396A68D541C85D26508E83_9882329 = (JSONObject) object;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(index, object, "JSONObject");
        } //End block
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_9882329.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_9882329;
        // ---------- Original Method ----------
        //Object object = get(index);
        //if (object instanceof JSONObject) {
            //return (JSONObject) object;
        //} else {
            //throw JSON.typeMismatch(index, object, "JSONObject");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.199 -0400", hash_original_method = "871DF64EA3EF0F09C790BD6ABB0AB209", hash_generated_method = "5F39B0F01CE7878030761145A6721713")
    public JSONObject optJSONObject(int index) {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_352904506 = null; //Variable for return #1
        Object object = opt(index);
        varB4EAC82CA7396A68D541C85D26508E83_352904506 = object instanceof JSONObject ? (JSONObject) object : null;
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_352904506.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_352904506;
        // ---------- Original Method ----------
        //Object object = opt(index);
        //return object instanceof JSONObject ? (JSONObject) object : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.200 -0400", hash_original_method = "CEEBF6D79C62E432FE9EF262922223A6", hash_generated_method = "45970E356C8C9AB7A34C57604161856B")
    public JSONObject toJSONObject(JSONArray names) throws JSONException {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_1161119337 = null; //Variable for return #1
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_219102800 = null; //Variable for return #2
        JSONObject result = new JSONObject();
        int length = Math.min(names.length(), values.size());
        {
            varB4EAC82CA7396A68D541C85D26508E83_1161119337 = null;
        } //End block
        {
            int i = 0;
            {
                String name = JSON.toString(names.opt(i));
                result.put(name, opt(i));
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_219102800 = result;
        addTaint(names.getTaint());
        JSONObject varA7E53CE21691AB073D9660D615818899_292314771; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_292314771 = varB4EAC82CA7396A68D541C85D26508E83_1161119337;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_292314771 = varB4EAC82CA7396A68D541C85D26508E83_219102800;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_292314771.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_292314771;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.201 -0400", hash_original_method = "818E08743989593DA274993EAEC63482", hash_generated_method = "56424DE120A11DF975662A33552E3C47")
    public String join(String separator) throws JSONException {
        String varB4EAC82CA7396A68D541C85D26508E83_1189325666 = null; //Variable for return #1
        JSONStringer stringer = new JSONStringer();
        stringer.open(JSONStringer.Scope.NULL, "");
        {
            int i = 0;
            int size = values.size();
            {
                {
                    stringer.out.append(separator);
                } //End block
                stringer.value(values.get(i));
            } //End block
        } //End collapsed parenthetic
        stringer.close(JSONStringer.Scope.NULL, JSONStringer.Scope.NULL, "");
        varB4EAC82CA7396A68D541C85D26508E83_1189325666 = stringer.out.toString();
        addTaint(separator.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1189325666.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1189325666;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.202 -0400", hash_original_method = "CC6BE78472EEEAF64E530CA9F9B14BB5", hash_generated_method = "092511626F081389196B267356ACA6A1")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1072439755 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_551484400 = null; //Variable for return #2
        try 
        {
            JSONStringer stringer = new JSONStringer();
            writeTo(stringer);
            varB4EAC82CA7396A68D541C85D26508E83_1072439755 = stringer.toString();
        } //End block
        catch (JSONException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_551484400 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1601203008; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1601203008 = varB4EAC82CA7396A68D541C85D26508E83_1072439755;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1601203008 = varB4EAC82CA7396A68D541C85D26508E83_551484400;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1601203008.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1601203008;
        // ---------- Original Method ----------
        //try {
            //JSONStringer stringer = new JSONStringer();
            //writeTo(stringer);
            //return stringer.toString();
        //} catch (JSONException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.203 -0400", hash_original_method = "161CBAA0F7E505CC65BF62A9F4C8490E", hash_generated_method = "77F7EA2FCEF628D1140DD7FEE54911F0")
    public String toString(int indentSpaces) throws JSONException {
        String varB4EAC82CA7396A68D541C85D26508E83_735574081 = null; //Variable for return #1
        JSONStringer stringer = new JSONStringer(indentSpaces);
        writeTo(stringer);
        varB4EAC82CA7396A68D541C85D26508E83_735574081 = stringer.toString();
        addTaint(indentSpaces);
        varB4EAC82CA7396A68D541C85D26508E83_735574081.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_735574081;
        // ---------- Original Method ----------
        //JSONStringer stringer = new JSONStringer(indentSpaces);
        //writeTo(stringer);
        //return stringer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.210 -0400", hash_original_method = "07D36EC028565C954CCF4CA47905C766", hash_generated_method = "1132E49EA608354F79C78BA27188686B")
     void writeTo(JSONStringer stringer) throws JSONException {
        stringer.array();
        {
            Iterator<Object> var130A2A32E1B03BFE017093C104B0D8C2_675811831 = (values).iterator();
            var130A2A32E1B03BFE017093C104B0D8C2_675811831.hasNext();
            Object value = var130A2A32E1B03BFE017093C104B0D8C2_675811831.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.212 -0400", hash_original_method = "BF4C72A1D6E8FA2592A6106FA9BE5FDF", hash_generated_method = "34BC9A8B486C68B01C2802BCFA3F7B91")
    @Override
    public boolean equals(Object o) {
        boolean var55ECC7CEA4332693419A47B87C1FDC1B_1867988373 = (o instanceof JSONArray && ((JSONArray) o).values.equals(values));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1834544613 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1834544613;
        // ---------- Original Method ----------
        //return o instanceof JSONArray && ((JSONArray) o).values.equals(values);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.213 -0400", hash_original_method = "5391F86F0DF47CDF0FABD2AA1BAE9E60", hash_generated_method = "094A4D801C713ABCEB1E86F03F4642C4")
    @Override
    public int hashCode() {
        int var3FF07D23466C64F67CC15CC69EEE9A22_183039197 = (values.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_244385868 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_244385868;
        // ---------- Original Method ----------
        //return values.hashCode();
    }

    
}

