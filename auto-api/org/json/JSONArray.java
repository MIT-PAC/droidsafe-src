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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.450 -0400", hash_original_field = "F09CC7EE3A9A93273F4B80601CAFB00C", hash_generated_field = "76A4FC356F020E02D923B1E56C39C10C")

    private List<Object> values;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.450 -0400", hash_original_method = "1427CA478AAC933787CA982EEEA58E55", hash_generated_method = "C0E1FE19CFD6C8C417EA7BEBD218CAB1")
    public  JSONArray() {
        values = new ArrayList<Object>();
        // ---------- Original Method ----------
        //values = new ArrayList<Object>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.451 -0400", hash_original_method = "805B0E8915A04C6C98723D3A60FEDF41", hash_generated_method = "4B9D9EC2F4D14E333AE5079990B38FA7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.451 -0400", hash_original_method = "7582B79BE7678565BA45DD0B34B6A75F", hash_generated_method = "F57944023DEEA39B90899AF0F1D8A9C6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.454 -0400", hash_original_method = "FBB8D188E5327545CDAACE0ACBE68DD3", hash_generated_method = "9DFE658011D3DBAD15ECDD1AD977929B")
    public  JSONArray(String json) throws JSONException {
        this(new JSONTokener(json));
        addTaint(json.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.455 -0400", hash_original_method = "2C5D59A27A6C313C8872AC341D9D75C0", hash_generated_method = "A0B0A616ACF660CC42BFB2F26372BD7B")
    public int length() {
        int varFE0BF0CE0C99947CFE3CAA895B4887C8_1840797953 = (values.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_59551553 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_59551553;
        // ---------- Original Method ----------
        //return values.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.471 -0400", hash_original_method = "F9CCA0A17EFD82FAE33507862E5A944E", hash_generated_method = "568512F73C4DDF4A5ECF13B5F8400A65")
    public JSONArray put(boolean value) {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_1389028126 = null; //Variable for return #1
        values.add(value);
        varB4EAC82CA7396A68D541C85D26508E83_1389028126 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1389028126.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1389028126;
        // ---------- Original Method ----------
        //values.add(value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.472 -0400", hash_original_method = "632D5AC8096954F0909B9EEBB1192731", hash_generated_method = "0F3D5F20E2C0CEA922E4E16545DF8379")
    public JSONArray put(double value) throws JSONException {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_728636447 = null; //Variable for return #1
        values.add(JSON.checkDouble(value));
        varB4EAC82CA7396A68D541C85D26508E83_728636447 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_728636447.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_728636447;
        // ---------- Original Method ----------
        //values.add(JSON.checkDouble(value));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.473 -0400", hash_original_method = "324220FCD4B61377969B5003ED2C32CE", hash_generated_method = "CCD0866FB93837FD08C500CFC27B3FE6")
    public JSONArray put(int value) {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_1975321438 = null; //Variable for return #1
        values.add(value);
        varB4EAC82CA7396A68D541C85D26508E83_1975321438 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1975321438.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1975321438;
        // ---------- Original Method ----------
        //values.add(value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.473 -0400", hash_original_method = "4C6CD72BE64F436E9F52C8D610641FF3", hash_generated_method = "0C8E65068867D1AB0B598E0820134C89")
    public JSONArray put(long value) {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_943504287 = null; //Variable for return #1
        values.add(value);
        varB4EAC82CA7396A68D541C85D26508E83_943504287 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_943504287.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_943504287;
        // ---------- Original Method ----------
        //values.add(value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.480 -0400", hash_original_method = "1D7645A229713F67337A58F8FF42D21C", hash_generated_method = "C7D0A26D3ECFC2A707A5E871B8887B78")
    public JSONArray put(Object value) {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_2002141948 = null; //Variable for return #1
        values.add(value);
        varB4EAC82CA7396A68D541C85D26508E83_2002141948 = this;
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2002141948.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2002141948;
        // ---------- Original Method ----------
        //values.add(value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.481 -0400", hash_original_method = "A8D9FD0A2FF792A00A29218BCE37DF7B", hash_generated_method = "DDCD8D21CCDDD9F5DFD56690AC3BF163")
    public JSONArray put(int index, boolean value) throws JSONException {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_668865813 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_668865813 = put(index, (Boolean) value);
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_668865813.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_668865813;
        // ---------- Original Method ----------
        //return put(index, (Boolean) value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.481 -0400", hash_original_method = "EB27801A89D2451AEBF6D71C639BF890", hash_generated_method = "3F588D3A8F8327E1E9E3C80F7B2DDB95")
    public JSONArray put(int index, double value) throws JSONException {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_19986098 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_19986098 = put(index, (Double) value);
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_19986098.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_19986098;
        // ---------- Original Method ----------
        //return put(index, (Double) value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.486 -0400", hash_original_method = "95364EFCBA8D50C1E1F228177A921191", hash_generated_method = "3EB9C488C7C7E337A80B6FBFB3E631AA")
    public JSONArray put(int index, int value) throws JSONException {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_461750003 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_461750003 = put(index, (Integer) value);
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_461750003.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_461750003;
        // ---------- Original Method ----------
        //return put(index, (Integer) value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.487 -0400", hash_original_method = "3F2291B7B045A442A1A296D04FF74C3B", hash_generated_method = "BF5C19BB7FA7FB638145E99C610B356B")
    public JSONArray put(int index, long value) throws JSONException {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_1545125403 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1545125403 = put(index, (Long) value);
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1545125403.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1545125403;
        // ---------- Original Method ----------
        //return put(index, (Long) value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.488 -0400", hash_original_method = "965F91AFDF1516EF58CC39AD3E1136B7", hash_generated_method = "E4FD8C4D95B6C48B0461230986DE4E6D")
    public JSONArray put(int index, Object value) throws JSONException {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_1599870391 = null; //Variable for return #1
        {
            JSON.checkDouble(((Number) value).doubleValue());
        } //End block
        {
            boolean var2B4B6857AFAECD928119D2C5979FA85A_1036695903 = (values.size() <= index);
            {
                values.add(null);
            } //End block
        } //End collapsed parenthetic
        values.set(index, value);
        varB4EAC82CA7396A68D541C85D26508E83_1599870391 = this;
        addTaint(index);
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1599870391.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1599870391;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.488 -0400", hash_original_method = "075BEAC25684C4B47CFBC04F9272F423", hash_generated_method = "D91C3B3CC8AAB65B5E0758FBF5D46FAD")
    public boolean isNull(int index) {
        Object value;
        value = opt(index);
        addTaint(index);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1287044091 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1287044091;
        // ---------- Original Method ----------
        //Object value = opt(index);
        //return value == null || value == JSONObject.NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.500 -0400", hash_original_method = "2917FB45D7E32294FB2932AB5B08992C", hash_generated_method = "544A1E553312948537A9823CA4B00EB5")
    public Object get(int index) throws JSONException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1363851185 = null; //Variable for return #1
        try 
        {
            Object value;
            value = values.get(index);
            {
                if (DroidSafeAndroidRuntime.control) throw new JSONException("Value at " + index + " is null.");
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1363851185 = value;
        } //End block
        catch (IndexOutOfBoundsException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new JSONException("Index " + index + " out of range [0.." + values.size() + ")");
        } //End block
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1363851185.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1363851185;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.501 -0400", hash_original_method = "3B6F9D3E5AFD1AB6175A8B6BF8959553", hash_generated_method = "3F723E08ACEBD7D2D474B418E4E0D17A")
    public Object opt(int index) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1785358156 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1866495817 = null; //Variable for return #2
        {
            boolean var132C4C95984B2E0FF5E13EAAE18B9F13_1996801014 = (index < 0 || index >= values.size());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1785358156 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1866495817 = values.get(index);
        addTaint(index);
        Object varA7E53CE21691AB073D9660D615818899_1437959194; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1437959194 = varB4EAC82CA7396A68D541C85D26508E83_1785358156;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1437959194 = varB4EAC82CA7396A68D541C85D26508E83_1866495817;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1437959194.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1437959194;
        // ---------- Original Method ----------
        //if (index < 0 || index >= values.size()) {
            //return null;
        //}
        //return values.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.501 -0400", hash_original_method = "24E6A67B676FCC7270A02518A61B22A2", hash_generated_method = "05E9644C8286888EEE6BAB2A708F5EE4")
    public boolean getBoolean(int index) throws JSONException {
        Object object;
        object = get(index);
        Boolean result;
        result = JSON.toBoolean(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(index, object, "boolean");
        } //End block
        addTaint(index);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1493934682 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1493934682;
        // ---------- Original Method ----------
        //Object object = get(index);
        //Boolean result = JSON.toBoolean(object);
        //if (result == null) {
            //throw JSON.typeMismatch(index, object, "boolean");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.504 -0400", hash_original_method = "A304D16233AC57FB2DDAD429570460E8", hash_generated_method = "17FD7C94E6B50F8F4DE8012763AC63CF")
    public boolean optBoolean(int index) {
        boolean var4B8DE6C9BC9DF2A597FF887DEEFA1EE5_192610264 = (optBoolean(index, false));
        addTaint(index);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_540814595 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_540814595;
        // ---------- Original Method ----------
        //return optBoolean(index, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.505 -0400", hash_original_method = "D837DFEA35C0469693745E1088FDEE2E", hash_generated_method = "A4A9908B54F1494BBF8F375ADA4ECD1E")
    public boolean optBoolean(int index, boolean fallback) {
        Object object;
        object = opt(index);
        Boolean result;
        result = JSON.toBoolean(object);
        addTaint(index);
        addTaint(fallback);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_927982954 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_927982954;
        // ---------- Original Method ----------
        //Object object = opt(index);
        //Boolean result = JSON.toBoolean(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.505 -0400", hash_original_method = "6D74AEBF7F111E364BD2DB0E7727FAF6", hash_generated_method = "0655EAC3869B34EFF9B1E8E9318FF4C1")
    public double getDouble(int index) throws JSONException {
        Object object;
        object = get(index);
        Double result;
        result = JSON.toDouble(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(index, object, "double");
        } //End block
        addTaint(index);
        double varE8CD7DA078A86726031AD64F35F5A6C0_1920261758 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1920261758;
        // ---------- Original Method ----------
        //Object object = get(index);
        //Double result = JSON.toDouble(object);
        //if (result == null) {
            //throw JSON.typeMismatch(index, object, "double");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.505 -0400", hash_original_method = "6ACFD4932D58B1B1AAD30FC39935EAD2", hash_generated_method = "844CBFAA56939153188F075DA8D7DA65")
    public double optDouble(int index) {
        double var2F77D8BD61B508531C2B6A152C657B91_1187570276 = (optDouble(index, Double.NaN));
        addTaint(index);
        double varE8CD7DA078A86726031AD64F35F5A6C0_1947301761 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1947301761;
        // ---------- Original Method ----------
        //return optDouble(index, Double.NaN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.535 -0400", hash_original_method = "0BBC192CCA032D1199B25DAD0E3977E8", hash_generated_method = "468965D9B986EB95799FD1E10EF1BB1D")
    public double optDouble(int index, double fallback) {
        Object object;
        object = opt(index);
        Double result;
        result = JSON.toDouble(object);
        addTaint(index);
        addTaint(fallback);
        double varE8CD7DA078A86726031AD64F35F5A6C0_275577226 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_275577226;
        // ---------- Original Method ----------
        //Object object = opt(index);
        //Double result = JSON.toDouble(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.536 -0400", hash_original_method = "853222C548896141F9D1D8AF0338F5C4", hash_generated_method = "B048859D018698D2F2AA1201E9D4AA7D")
    public int getInt(int index) throws JSONException {
        Object object;
        object = get(index);
        Integer result;
        result = JSON.toInteger(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(index, object, "int");
        } //End block
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_993578568 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_993578568;
        // ---------- Original Method ----------
        //Object object = get(index);
        //Integer result = JSON.toInteger(object);
        //if (result == null) {
            //throw JSON.typeMismatch(index, object, "int");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.537 -0400", hash_original_method = "7CF76FC4FBEA846C37B11EB5D3437F82", hash_generated_method = "52C8AE7FEDF388809A3203181659E860")
    public int optInt(int index) {
        int varD8D9D2BD4A82A82653E187AF20B76514_305425658 = (optInt(index, 0));
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_737290339 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_737290339;
        // ---------- Original Method ----------
        //return optInt(index, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.537 -0400", hash_original_method = "5DB279774D0456981D1F7F001BBC18BA", hash_generated_method = "64E1C840F84288AEBCDD28C429B74F6D")
    public int optInt(int index, int fallback) {
        Object object;
        object = opt(index);
        Integer result;
        result = JSON.toInteger(object);
        addTaint(index);
        addTaint(fallback);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1847392202 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1847392202;
        // ---------- Original Method ----------
        //Object object = opt(index);
        //Integer result = JSON.toInteger(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.537 -0400", hash_original_method = "56F71130ADC070DD70D4CA02CA42F381", hash_generated_method = "237AEF3CAA89FE24A4967982C7DFC617")
    public long getLong(int index) throws JSONException {
        Object object;
        object = get(index);
        Long result;
        result = JSON.toLong(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(index, object, "long");
        } //End block
        addTaint(index);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1566774201 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1566774201;
        // ---------- Original Method ----------
        //Object object = get(index);
        //Long result = JSON.toLong(object);
        //if (result == null) {
            //throw JSON.typeMismatch(index, object, "long");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.538 -0400", hash_original_method = "2BBCBA9E354F863B816F565C8B8E92CB", hash_generated_method = "38C9DFC27C10843F36891DD485CD96E6")
    public long optLong(int index) {
        long varAF24B1D10932CD296BDC344232BE5ECF_1810139145 = (optLong(index, 0L));
        addTaint(index);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_240670455 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_240670455;
        // ---------- Original Method ----------
        //return optLong(index, 0L);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.538 -0400", hash_original_method = "81CF1715684C5D206C6FD7331990B13E", hash_generated_method = "F163DCF42E14AA7BFD1213A248B97B35")
    public long optLong(int index, long fallback) {
        Object object;
        object = opt(index);
        Long result;
        result = JSON.toLong(object);
        addTaint(index);
        addTaint(fallback);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_215054299 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_215054299;
        // ---------- Original Method ----------
        //Object object = opt(index);
        //Long result = JSON.toLong(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.550 -0400", hash_original_method = "7F7D1138F84D636CF19BD9329533631C", hash_generated_method = "96E5B18BD9BAD46D9C32605D6128D65F")
    public String getString(int index) throws JSONException {
        String varB4EAC82CA7396A68D541C85D26508E83_1664509277 = null; //Variable for return #1
        Object object;
        object = get(index);
        String result;
        result = JSON.toString(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(index, object, "String");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1664509277 = result;
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1664509277.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1664509277;
        // ---------- Original Method ----------
        //Object object = get(index);
        //String result = JSON.toString(object);
        //if (result == null) {
            //throw JSON.typeMismatch(index, object, "String");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.553 -0400", hash_original_method = "C31202553EDC4F0A1E4B21CAD06ABEC4", hash_generated_method = "D4325E2C25B86957223BF7ACB377A7EA")
    public String optString(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_339626602 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_339626602 = optString(index, "");
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_339626602.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_339626602;
        // ---------- Original Method ----------
        //return optString(index, "");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.570 -0400", hash_original_method = "97366D23F93DD4ABD9E565325F7585B9", hash_generated_method = "25F5F8F16DB265C42151351DD59CBFEC")
    public String optString(int index, String fallback) {
        String varB4EAC82CA7396A68D541C85D26508E83_1154168012 = null; //Variable for return #1
        Object object;
        object = opt(index);
        String result;
        result = JSON.toString(object);
        varB4EAC82CA7396A68D541C85D26508E83_1154168012 = result != null ? result : fallback;
        addTaint(index);
        addTaint(fallback.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1154168012.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1154168012;
        // ---------- Original Method ----------
        //Object object = opt(index);
        //String result = JSON.toString(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.571 -0400", hash_original_method = "173A28EF43B750DEF6376D4E3E2F6DD2", hash_generated_method = "9E22EC4FAE54C6AE5929A09D7A497C19")
    public JSONArray getJSONArray(int index) throws JSONException {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_1354957695 = null; //Variable for return #1
        Object object;
        object = get(index);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1354957695 = (JSONArray) object;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(index, object, "JSONArray");
        } //End block
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1354957695.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1354957695;
        // ---------- Original Method ----------
        //Object object = get(index);
        //if (object instanceof JSONArray) {
            //return (JSONArray) object;
        //} else {
            //throw JSON.typeMismatch(index, object, "JSONArray");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.572 -0400", hash_original_method = "CBF30564657B4CB07ABBCF29084A5653", hash_generated_method = "5AB8F83DBE2A9B2A13BDB72B6103B3F0")
    public JSONArray optJSONArray(int index) {
        JSONArray varB4EAC82CA7396A68D541C85D26508E83_1124347143 = null; //Variable for return #1
        Object object;
        object = opt(index);
        varB4EAC82CA7396A68D541C85D26508E83_1124347143 = object instanceof JSONArray ? (JSONArray) object : null;
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1124347143.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1124347143;
        // ---------- Original Method ----------
        //Object object = opt(index);
        //return object instanceof JSONArray ? (JSONArray) object : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.572 -0400", hash_original_method = "EA5692C9D71198B472B917468564A78A", hash_generated_method = "F00B868EFAD9B2EED1C4C6D4AF2A2FD3")
    public JSONObject getJSONObject(int index) throws JSONException {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_2070675999 = null; //Variable for return #1
        Object object;
        object = get(index);
        {
            varB4EAC82CA7396A68D541C85D26508E83_2070675999 = (JSONObject) object;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(index, object, "JSONObject");
        } //End block
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_2070675999.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2070675999;
        // ---------- Original Method ----------
        //Object object = get(index);
        //if (object instanceof JSONObject) {
            //return (JSONObject) object;
        //} else {
            //throw JSON.typeMismatch(index, object, "JSONObject");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.573 -0400", hash_original_method = "871DF64EA3EF0F09C790BD6ABB0AB209", hash_generated_method = "A6924761072D48F639A048931CED56E2")
    public JSONObject optJSONObject(int index) {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_369598092 = null; //Variable for return #1
        Object object;
        object = opt(index);
        varB4EAC82CA7396A68D541C85D26508E83_369598092 = object instanceof JSONObject ? (JSONObject) object : null;
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_369598092.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_369598092;
        // ---------- Original Method ----------
        //Object object = opt(index);
        //return object instanceof JSONObject ? (JSONObject) object : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.581 -0400", hash_original_method = "CEEBF6D79C62E432FE9EF262922223A6", hash_generated_method = "98B52FEB2F9CEC72A0ED8ACBA6FB16C1")
    public JSONObject toJSONObject(JSONArray names) throws JSONException {
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_1971949097 = null; //Variable for return #1
        JSONObject varB4EAC82CA7396A68D541C85D26508E83_78122582 = null; //Variable for return #2
        JSONObject result;
        result = new JSONObject();
        int length;
        length = Math.min(names.length(), values.size());
        {
            varB4EAC82CA7396A68D541C85D26508E83_1971949097 = null;
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
        varB4EAC82CA7396A68D541C85D26508E83_78122582 = result;
        addTaint(names.getTaint());
        JSONObject varA7E53CE21691AB073D9660D615818899_290819473; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_290819473 = varB4EAC82CA7396A68D541C85D26508E83_1971949097;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_290819473 = varB4EAC82CA7396A68D541C85D26508E83_78122582;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_290819473.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_290819473;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.594 -0400", hash_original_method = "818E08743989593DA274993EAEC63482", hash_generated_method = "D5E9E38D4E7BA387A499FF0A022049D9")
    public String join(String separator) throws JSONException {
        String varB4EAC82CA7396A68D541C85D26508E83_1960502996 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1960502996 = stringer.out.toString();
        addTaint(separator.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1960502996.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1960502996;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.595 -0400", hash_original_method = "CC6BE78472EEEAF64E530CA9F9B14BB5", hash_generated_method = "0E548BBE9458EB1F164709EC13E9EEBA")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_726805704 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_57401415 = null; //Variable for return #2
        try 
        {
            JSONStringer stringer;
            stringer = new JSONStringer();
            writeTo(stringer);
            varB4EAC82CA7396A68D541C85D26508E83_726805704 = stringer.toString();
        } //End block
        catch (JSONException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_57401415 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_301308119; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_301308119 = varB4EAC82CA7396A68D541C85D26508E83_726805704;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_301308119 = varB4EAC82CA7396A68D541C85D26508E83_57401415;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_301308119.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_301308119;
        // ---------- Original Method ----------
        //try {
            //JSONStringer stringer = new JSONStringer();
            //writeTo(stringer);
            //return stringer.toString();
        //} catch (JSONException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.595 -0400", hash_original_method = "161CBAA0F7E505CC65BF62A9F4C8490E", hash_generated_method = "011D488513F705BB75BFBC0D4211C513")
    public String toString(int indentSpaces) throws JSONException {
        String varB4EAC82CA7396A68D541C85D26508E83_737576601 = null; //Variable for return #1
        JSONStringer stringer;
        stringer = new JSONStringer(indentSpaces);
        writeTo(stringer);
        varB4EAC82CA7396A68D541C85D26508E83_737576601 = stringer.toString();
        addTaint(indentSpaces);
        varB4EAC82CA7396A68D541C85D26508E83_737576601.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_737576601;
        // ---------- Original Method ----------
        //JSONStringer stringer = new JSONStringer(indentSpaces);
        //writeTo(stringer);
        //return stringer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.637 -0400", hash_original_method = "07D36EC028565C954CCF4CA47905C766", hash_generated_method = "6137FA1CFF3C032ACD60D99D9833149A")
     void writeTo(JSONStringer stringer) throws JSONException {
        stringer.array();
        {
            Iterator<Object> var130A2A32E1B03BFE017093C104B0D8C2_1748239847 = (values).iterator();
            var130A2A32E1B03BFE017093C104B0D8C2_1748239847.hasNext();
            Object value = var130A2A32E1B03BFE017093C104B0D8C2_1748239847.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.637 -0400", hash_original_method = "BF4C72A1D6E8FA2592A6106FA9BE5FDF", hash_generated_method = "C49D5D5ADDCEB22B5E491DE2567C0646")
    @Override
    public boolean equals(Object o) {
        boolean var55ECC7CEA4332693419A47B87C1FDC1B_44251108 = (o instanceof JSONArray && ((JSONArray) o).values.equals(values));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1214820770 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1214820770;
        // ---------- Original Method ----------
        //return o instanceof JSONArray && ((JSONArray) o).values.equals(values);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.638 -0400", hash_original_method = "5391F86F0DF47CDF0FABD2AA1BAE9E60", hash_generated_method = "67E6ACD27F17019B04BE00BA62D1C293")
    @Override
    public int hashCode() {
        int var3FF07D23466C64F67CC15CC69EEE9A22_1856247611 = (values.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_899017334 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_899017334;
        // ---------- Original Method ----------
        //return values.hashCode();
    }

    
}

