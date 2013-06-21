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
    private List<Object> values;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.130 -0400", hash_original_method = "1427CA478AAC933787CA982EEEA58E55", hash_generated_method = "C0E1FE19CFD6C8C417EA7BEBD218CAB1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONArray() {
        values = new ArrayList<Object>();
        // ---------- Original Method ----------
        //values = new ArrayList<Object>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.130 -0400", hash_original_method = "805B0E8915A04C6C98723D3A60FEDF41", hash_generated_method = "36E30C8CD1E827FBAD24BAE35C4AB2E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONArray(Collection copyFrom) {
        this();
        dsTaint.addTaint(copyFrom.dsTaint);
        Collection<?> copyFromTyped;
        copyFromTyped = (Collection<?>) copyFrom;
        values.addAll(copyFromTyped);
        // ---------- Original Method ----------
        //Collection<?> copyFromTyped = (Collection<?>) copyFrom;
        //values.addAll(copyFromTyped);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.131 -0400", hash_original_method = "7582B79BE7678565BA45DD0B34B6A75F", hash_generated_method = "81C9D9282C9F9F2CB864BD78DCA1D31F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONArray(JSONTokener readFrom) throws JSONException {
        dsTaint.addTaint(readFrom.dsTaint);
        Object object;
        object = readFrom.nextValue();
        {
            values = ((JSONArray) object).values;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(object, "JSONArray");
        } //End block
        // ---------- Original Method ----------
        //Object object = readFrom.nextValue();
        //if (object instanceof JSONArray) {
            //values = ((JSONArray) object).values;
        //} else {
            //throw JSON.typeMismatch(object, "JSONArray");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.131 -0400", hash_original_method = "FBB8D188E5327545CDAACE0ACBE68DD3", hash_generated_method = "35C1FF2E27CD969DD70BF1AB6045EA12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONArray(String json) throws JSONException {
        this(new JSONTokener(json));
        dsTaint.addTaint(json);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.131 -0400", hash_original_method = "2C5D59A27A6C313C8872AC341D9D75C0", hash_generated_method = "5A0AAE2F1BAB99C647B61D7D24D56658")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int length() {
        int varFE0BF0CE0C99947CFE3CAA895B4887C8_2115056614 = (values.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return values.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.131 -0400", hash_original_method = "F9CCA0A17EFD82FAE33507862E5A944E", hash_generated_method = "2610FEFC5E303AFAEE3D5113844F804F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONArray put(boolean value) {
        dsTaint.addTaint(value);
        values.add(value);
        return (JSONArray)dsTaint.getTaint();
        // ---------- Original Method ----------
        //values.add(value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.131 -0400", hash_original_method = "632D5AC8096954F0909B9EEBB1192731", hash_generated_method = "E461C86D27515C0CA14F41AE9D922562")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONArray put(double value) throws JSONException {
        dsTaint.addTaint(value);
        values.add(JSON.checkDouble(value));
        return (JSONArray)dsTaint.getTaint();
        // ---------- Original Method ----------
        //values.add(JSON.checkDouble(value));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.131 -0400", hash_original_method = "324220FCD4B61377969B5003ED2C32CE", hash_generated_method = "2ED899D63622B150BCF7D781E63FCE49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONArray put(int value) {
        dsTaint.addTaint(value);
        values.add(value);
        return (JSONArray)dsTaint.getTaint();
        // ---------- Original Method ----------
        //values.add(value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.132 -0400", hash_original_method = "4C6CD72BE64F436E9F52C8D610641FF3", hash_generated_method = "DCF26F3A2EC6C445CD8021F555E703FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONArray put(long value) {
        dsTaint.addTaint(value);
        values.add(value);
        return (JSONArray)dsTaint.getTaint();
        // ---------- Original Method ----------
        //values.add(value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.134 -0400", hash_original_method = "1D7645A229713F67337A58F8FF42D21C", hash_generated_method = "2BC4DB0BE8F7AA63F4D526B3225321C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONArray put(Object value) {
        dsTaint.addTaint(value.dsTaint);
        values.add(value);
        return (JSONArray)dsTaint.getTaint();
        // ---------- Original Method ----------
        //values.add(value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.134 -0400", hash_original_method = "A8D9FD0A2FF792A00A29218BCE37DF7B", hash_generated_method = "FB870C5779EA5C7DFE7BCCCBA9654650")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONArray put(int index, boolean value) throws JSONException {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
        JSONArray varCAC0CF34016B29A6A391A641FA7BFF51_447837090 = (put(index, (Boolean) value));
        return (JSONArray)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return put(index, (Boolean) value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.135 -0400", hash_original_method = "EB27801A89D2451AEBF6D71C639BF890", hash_generated_method = "9714CB4E888E973F2A4EBECCD2FE151B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONArray put(int index, double value) throws JSONException {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
        JSONArray varF547E28C09792EA3B8CD78F9EFDD074E_417525449 = (put(index, (Double) value));
        return (JSONArray)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return put(index, (Double) value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.135 -0400", hash_original_method = "95364EFCBA8D50C1E1F228177A921191", hash_generated_method = "1119558D51895C34326AC936FBF3521A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONArray put(int index, int value) throws JSONException {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
        JSONArray var01C00356728C227CC0CAC5F75464C101_550036330 = (put(index, (Integer) value));
        return (JSONArray)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return put(index, (Integer) value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.135 -0400", hash_original_method = "3F2291B7B045A442A1A296D04FF74C3B", hash_generated_method = "282BBEFD40AC7DF26F721E6ABEA04424")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONArray put(int index, long value) throws JSONException {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
        JSONArray var1871F50CBA8E5AE15CE2792672328FBD_971004754 = (put(index, (Long) value));
        return (JSONArray)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return put(index, (Long) value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.135 -0400", hash_original_method = "965F91AFDF1516EF58CC39AD3E1136B7", hash_generated_method = "9425705585E307AF3DD24DE88358560A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONArray put(int index, Object value) throws JSONException {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value.dsTaint);
        {
            JSON.checkDouble(((Number) value).doubleValue());
        } //End block
        {
            boolean var2B4B6857AFAECD928119D2C5979FA85A_1043461831 = (values.size() <= index);
            {
                values.add(null);
            } //End block
        } //End collapsed parenthetic
        values.set(index, value);
        return (JSONArray)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.135 -0400", hash_original_method = "075BEAC25684C4B47CFBC04F9272F423", hash_generated_method = "ABD4B835ADA1B87BA2CECDA4B2545654")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isNull(int index) {
        dsTaint.addTaint(index);
        Object value;
        value = opt(index);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Object value = opt(index);
        //return value == null || value == JSONObject.NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.136 -0400", hash_original_method = "2917FB45D7E32294FB2932AB5B08992C", hash_generated_method = "55F3057FC4B72B7CF6575E784E54A97F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object get(int index) throws JSONException {
        dsTaint.addTaint(index);
        try 
        {
            Object value;
            value = values.get(index);
            {
                if (DroidSafeAndroidRuntime.control) throw new JSONException("Value at " + index + " is null.");
            } //End block
        } //End block
        catch (IndexOutOfBoundsException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new JSONException("Index " + index + " out of range [0.." + values.size() + ")");
        } //End block
        return (Object)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.136 -0400", hash_original_method = "3B6F9D3E5AFD1AB6175A8B6BF8959553", hash_generated_method = "A19C9AB6CE09ECFB46D47BFC99FDE212")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object opt(int index) {
        dsTaint.addTaint(index);
        {
            boolean var132C4C95984B2E0FF5E13EAAE18B9F13_976944304 = (index < 0 || index >= values.size());
        } //End collapsed parenthetic
        Object var42ABEBFF0FF0A14646C3A25DFABD23AC_1993098528 = (values.get(index));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (index < 0 || index >= values.size()) {
            //return null;
        //}
        //return values.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.136 -0400", hash_original_method = "24E6A67B676FCC7270A02518A61B22A2", hash_generated_method = "5F8BB96345B75AF45EE2207E0680227C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getBoolean(int index) throws JSONException {
        dsTaint.addTaint(index);
        Object object;
        object = get(index);
        Boolean result;
        result = JSON.toBoolean(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(index, object, "boolean");
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Object object = get(index);
        //Boolean result = JSON.toBoolean(object);
        //if (result == null) {
            //throw JSON.typeMismatch(index, object, "boolean");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.136 -0400", hash_original_method = "A304D16233AC57FB2DDAD429570460E8", hash_generated_method = "6C11875AAAAB886394C9AF1BE7D175B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean optBoolean(int index) {
        dsTaint.addTaint(index);
        boolean var4B8DE6C9BC9DF2A597FF887DEEFA1EE5_1799226694 = (optBoolean(index, false));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return optBoolean(index, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.136 -0400", hash_original_method = "D837DFEA35C0469693745E1088FDEE2E", hash_generated_method = "FBB8C0686C36EA4F393D82BF325AE90B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean optBoolean(int index, boolean fallback) {
        dsTaint.addTaint(fallback);
        dsTaint.addTaint(index);
        Object object;
        object = opt(index);
        Boolean result;
        result = JSON.toBoolean(object);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Object object = opt(index);
        //Boolean result = JSON.toBoolean(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.136 -0400", hash_original_method = "6D74AEBF7F111E364BD2DB0E7727FAF6", hash_generated_method = "70B5DF4A8C5FC9C86FED9ED566CDCB99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public double getDouble(int index) throws JSONException {
        dsTaint.addTaint(index);
        Object object;
        object = get(index);
        Double result;
        result = JSON.toDouble(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(index, object, "double");
        } //End block
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //Object object = get(index);
        //Double result = JSON.toDouble(object);
        //if (result == null) {
            //throw JSON.typeMismatch(index, object, "double");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.137 -0400", hash_original_method = "6ACFD4932D58B1B1AAD30FC39935EAD2", hash_generated_method = "220C54D1DD7D3FB7E495D9C08004B08D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public double optDouble(int index) {
        dsTaint.addTaint(index);
        double var2F77D8BD61B508531C2B6A152C657B91_247428917 = (optDouble(index, Double.NaN));
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return optDouble(index, Double.NaN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.137 -0400", hash_original_method = "0BBC192CCA032D1199B25DAD0E3977E8", hash_generated_method = "AB1F841AC7B7C099AA44135FA1B03182")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public double optDouble(int index, double fallback) {
        dsTaint.addTaint(fallback);
        dsTaint.addTaint(index);
        Object object;
        object = opt(index);
        Double result;
        result = JSON.toDouble(object);
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //Object object = opt(index);
        //Double result = JSON.toDouble(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.137 -0400", hash_original_method = "853222C548896141F9D1D8AF0338F5C4", hash_generated_method = "B69A6837E3FED792E6A8A5CF3DDC41C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getInt(int index) throws JSONException {
        dsTaint.addTaint(index);
        Object object;
        object = get(index);
        Integer result;
        result = JSON.toInteger(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(index, object, "int");
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //Object object = get(index);
        //Integer result = JSON.toInteger(object);
        //if (result == null) {
            //throw JSON.typeMismatch(index, object, "int");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.137 -0400", hash_original_method = "7CF76FC4FBEA846C37B11EB5D3437F82", hash_generated_method = "37A1AA7F80EF7129525A98FD626204B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int optInt(int index) {
        dsTaint.addTaint(index);
        int varD8D9D2BD4A82A82653E187AF20B76514_1194324754 = (optInt(index, 0));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return optInt(index, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.137 -0400", hash_original_method = "5DB279774D0456981D1F7F001BBC18BA", hash_generated_method = "3447753F55B28DDB6D545B787729F00E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int optInt(int index, int fallback) {
        dsTaint.addTaint(fallback);
        dsTaint.addTaint(index);
        Object object;
        object = opt(index);
        Integer result;
        result = JSON.toInteger(object);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //Object object = opt(index);
        //Integer result = JSON.toInteger(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.138 -0400", hash_original_method = "56F71130ADC070DD70D4CA02CA42F381", hash_generated_method = "6F6C885C1018D0DE2078717A5277F3AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getLong(int index) throws JSONException {
        dsTaint.addTaint(index);
        Object object;
        object = get(index);
        Long result;
        result = JSON.toLong(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(index, object, "long");
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //Object object = get(index);
        //Long result = JSON.toLong(object);
        //if (result == null) {
            //throw JSON.typeMismatch(index, object, "long");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.138 -0400", hash_original_method = "2BBCBA9E354F863B816F565C8B8E92CB", hash_generated_method = "8C0B0F20FD2008FECCB7A910EAF717A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long optLong(int index) {
        dsTaint.addTaint(index);
        long varAF24B1D10932CD296BDC344232BE5ECF_523743090 = (optLong(index, 0L));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return optLong(index, 0L);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.138 -0400", hash_original_method = "81CF1715684C5D206C6FD7331990B13E", hash_generated_method = "5F2BFD5D806AAD512F795D9706A3501A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long optLong(int index, long fallback) {
        dsTaint.addTaint(fallback);
        dsTaint.addTaint(index);
        Object object;
        object = opt(index);
        Long result;
        result = JSON.toLong(object);
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //Object object = opt(index);
        //Long result = JSON.toLong(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.138 -0400", hash_original_method = "7F7D1138F84D636CF19BD9329533631C", hash_generated_method = "BFD8E3BA06292F20F5CB40ECA2BCC0AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getString(int index) throws JSONException {
        dsTaint.addTaint(index);
        Object object;
        object = get(index);
        String result;
        result = JSON.toString(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(index, object, "String");
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //Object object = get(index);
        //String result = JSON.toString(object);
        //if (result == null) {
            //throw JSON.typeMismatch(index, object, "String");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.138 -0400", hash_original_method = "C31202553EDC4F0A1E4B21CAD06ABEC4", hash_generated_method = "D2AD75EC6767CDFBA8067DA08500ABE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String optString(int index) {
        dsTaint.addTaint(index);
        String var52E12EA8D6911842E7B821FA60FF4A0C_445215837 = (optString(index, ""));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return optString(index, "");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.138 -0400", hash_original_method = "97366D23F93DD4ABD9E565325F7585B9", hash_generated_method = "5479BF6EAF0A4AFA89415FD71359D220")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String optString(int index, String fallback) {
        dsTaint.addTaint(fallback);
        dsTaint.addTaint(index);
        Object object;
        object = opt(index);
        String result;
        result = JSON.toString(object);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //Object object = opt(index);
        //String result = JSON.toString(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.139 -0400", hash_original_method = "173A28EF43B750DEF6376D4E3E2F6DD2", hash_generated_method = "CA434FF3E90AF89066A1E9F47D4EEA29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONArray getJSONArray(int index) throws JSONException {
        dsTaint.addTaint(index);
        Object object;
        object = get(index);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(index, object, "JSONArray");
        } //End block
        return (JSONArray)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object object = get(index);
        //if (object instanceof JSONArray) {
            //return (JSONArray) object;
        //} else {
            //throw JSON.typeMismatch(index, object, "JSONArray");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.139 -0400", hash_original_method = "CBF30564657B4CB07ABBCF29084A5653", hash_generated_method = "CC884A75B51BC5C67CF27AD39387E9D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONArray optJSONArray(int index) {
        dsTaint.addTaint(index);
        Object object;
        object = opt(index);
        return (JSONArray)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object object = opt(index);
        //return object instanceof JSONArray ? (JSONArray) object : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.139 -0400", hash_original_method = "EA5692C9D71198B472B917468564A78A", hash_generated_method = "8EA955640608BFCD4180EAE45FA92022")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONObject getJSONObject(int index) throws JSONException {
        dsTaint.addTaint(index);
        Object object;
        object = get(index);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(index, object, "JSONObject");
        } //End block
        return (JSONObject)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object object = get(index);
        //if (object instanceof JSONObject) {
            //return (JSONObject) object;
        //} else {
            //throw JSON.typeMismatch(index, object, "JSONObject");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.139 -0400", hash_original_method = "871DF64EA3EF0F09C790BD6ABB0AB209", hash_generated_method = "93EAA1272CEA815E2826EA5B5A06BD34")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONObject optJSONObject(int index) {
        dsTaint.addTaint(index);
        Object object;
        object = opt(index);
        return (JSONObject)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object object = opt(index);
        //return object instanceof JSONObject ? (JSONObject) object : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.139 -0400", hash_original_method = "CEEBF6D79C62E432FE9EF262922223A6", hash_generated_method = "3D4C2A411623FF1237152C1347E315AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONObject toJSONObject(JSONArray names) throws JSONException {
        dsTaint.addTaint(names.dsTaint);
        JSONObject result;
        result = new JSONObject();
        int length;
        length = Math.min(names.length(), values.size());
        {
            int i;
            i = 0;
            {
                String name;
                name = JSON.toString(names.opt(i));
                result.put(name, opt(i));
            } //End block
        } //End collapsed parenthetic
        return (JSONObject)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.140 -0400", hash_original_method = "818E08743989593DA274993EAEC63482", hash_generated_method = "79CE230B6D798B5844B318D382933EF6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String join(String separator) throws JSONException {
        dsTaint.addTaint(separator);
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
        String varFEBE1C5BCF8CF1B49BB94436D3C674BE_671513629 = (stringer.out.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.140 -0400", hash_original_method = "CC6BE78472EEEAF64E530CA9F9B14BB5", hash_generated_method = "871548F8B8AA774D3D8FA3C232FEEDBB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        try 
        {
            JSONStringer stringer;
            stringer = new JSONStringer();
            writeTo(stringer);
            String var4DDAB7D77993E4AF1A58F12BAE21218F_1177092154 = (stringer.toString());
        } //End block
        catch (JSONException e)
        { }
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //try {
            //JSONStringer stringer = new JSONStringer();
            //writeTo(stringer);
            //return stringer.toString();
        //} catch (JSONException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.140 -0400", hash_original_method = "161CBAA0F7E505CC65BF62A9F4C8490E", hash_generated_method = "6C58812B52BF5267127F80733D9D34EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString(int indentSpaces) throws JSONException {
        dsTaint.addTaint(indentSpaces);
        JSONStringer stringer;
        stringer = new JSONStringer(indentSpaces);
        writeTo(stringer);
        String var8FC62F826C6AE40C27D034989F134FDC_1080388209 = (stringer.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //JSONStringer stringer = new JSONStringer(indentSpaces);
        //writeTo(stringer);
        //return stringer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.144 -0400", hash_original_method = "07D36EC028565C954CCF4CA47905C766", hash_generated_method = "EB9FA658614D177A41052A6D5837B024")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void writeTo(JSONStringer stringer) throws JSONException {
        dsTaint.addTaint(stringer.dsTaint);
        stringer.array();
        {
            Iterator<Object> var130A2A32E1B03BFE017093C104B0D8C2_1887073353 = (values).iterator();
            var130A2A32E1B03BFE017093C104B0D8C2_1887073353.hasNext();
            Object value = var130A2A32E1B03BFE017093C104B0D8C2_1887073353.next();
            {
                stringer.value(value);
            } //End block
        } //End collapsed parenthetic
        stringer.endArray();
        // ---------- Original Method ----------
        //stringer.array();
        //for (Object value : values) {
            //stringer.value(value);
        //}
        //stringer.endArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.144 -0400", hash_original_method = "BF4C72A1D6E8FA2592A6106FA9BE5FDF", hash_generated_method = "3D7DA2F28FFE19AD29E583C555730324")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        boolean var55ECC7CEA4332693419A47B87C1FDC1B_1931244919 = (o instanceof JSONArray && ((JSONArray) o).values.equals(values));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return o instanceof JSONArray && ((JSONArray) o).values.equals(values);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.144 -0400", hash_original_method = "5391F86F0DF47CDF0FABD2AA1BAE9E60", hash_generated_method = "E132B3CC9FB88EAF593332A6D92AA115")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var3FF07D23466C64F67CC15CC69EEE9A22_10472118 = (values.hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return values.hashCode();
    }

    
}

