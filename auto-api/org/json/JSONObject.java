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
    private Map<String, Object> nameValuePairs;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.156 -0400", hash_original_method = "B0BA44B1CBEEB832685DE1D9CC551D36", hash_generated_method = "8AB77AFCB9DCE98AE75372C152EFAE46")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONObject() {
        nameValuePairs = new HashMap<String, Object>();
        // ---------- Original Method ----------
        //nameValuePairs = new HashMap<String, Object>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.158 -0400", hash_original_method = "64F11EBDF44BE4F1CBC516D3CD1F34E9", hash_generated_method = "CF8BB452C04CE3A62B52F5CE69B24E98")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONObject(Map copyFrom) {
        this();
        dsTaint.addTaint(copyFrom.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.158 -0400", hash_original_method = "E218F03BB03DC7D8503E0318225F7859", hash_generated_method = "8E99A3C30D0FF1CF03D9070EB585DF49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONObject(JSONTokener readFrom) throws JSONException {
        dsTaint.addTaint(readFrom.dsTaint);
        Object object;
        object = readFrom.nextValue();
        {
            this.nameValuePairs = ((JSONObject) object).nameValuePairs;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(object, "JSONObject");
        } //End block
        // ---------- Original Method ----------
        //Object object = readFrom.nextValue();
        //if (object instanceof JSONObject) {
            //this.nameValuePairs = ((JSONObject) object).nameValuePairs;
        //} else {
            //throw JSON.typeMismatch(object, "JSONObject");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.158 -0400", hash_original_method = "27B9491B51940DE15585B798AFD3D304", hash_generated_method = "BDF8A1AF46DA4FD98866B254AF5F737C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONObject(String json) throws JSONException {
        this(new JSONTokener(json));
        dsTaint.addTaint(json);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.160 -0400", hash_original_method = "D555E6715A2E6E4EC106278BB66ED891", hash_generated_method = "DA138DC96800316EECF8BD5781E601C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONObject(JSONObject copyFrom, String[] names) throws JSONException {
        this();
        dsTaint.addTaint(names[0]);
        dsTaint.addTaint(copyFrom.dsTaint);
        {
            Iterator<String> var0B4471083E71D104FA84944F144C9814_823816608 = (names).iterator();
            var0B4471083E71D104FA84944F144C9814_823816608.hasNext();
            String name = var0B4471083E71D104FA84944F144C9814_823816608.next();
            {
                Object value;
                value = copyFrom.opt(name);
                {
                    nameValuePairs.put(name, value);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (String name : names) {
            //Object value = copyFrom.opt(name);
            //if (value != null) {
                //nameValuePairs.put(name, value);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.160 -0400", hash_original_method = "BB0C5A7042ADC1F8FC4BAA64EBFD2B52", hash_generated_method = "174BBA221EF20339DBAD62AC29C3EFC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int length() {
        int var5BCA4F4CB72BD4E013D6A2FD0A5A950A_2105148053 = (nameValuePairs.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nameValuePairs.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.160 -0400", hash_original_method = "43A124AF3EF8B2736A46103CC8729DE3", hash_generated_method = "AC06D3992FA86B884729F0CCAB13A2A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONObject put(String name, boolean value) throws JSONException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        nameValuePairs.put(checkName(name), value);
        return (JSONObject)dsTaint.getTaint();
        // ---------- Original Method ----------
        //nameValuePairs.put(checkName(name), value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.161 -0400", hash_original_method = "FF23ECF2F7B3A424BD0CA2B446E9E0DB", hash_generated_method = "3380DB4ADB8312885F3A6B7DC6ED6E79")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONObject put(String name, double value) throws JSONException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        nameValuePairs.put(checkName(name), JSON.checkDouble(value));
        return (JSONObject)dsTaint.getTaint();
        // ---------- Original Method ----------
        //nameValuePairs.put(checkName(name), JSON.checkDouble(value));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.161 -0400", hash_original_method = "14B3109A64A28D2764163C4077CDC45D", hash_generated_method = "EE44703C9C907072D8D5C177107BDEDD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONObject put(String name, int value) throws JSONException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        nameValuePairs.put(checkName(name), value);
        return (JSONObject)dsTaint.getTaint();
        // ---------- Original Method ----------
        //nameValuePairs.put(checkName(name), value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.161 -0400", hash_original_method = "0E78BCAD739042DC347A7959C52D188A", hash_generated_method = "15AB554454E10CE2609869A359BECAD1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONObject put(String name, long value) throws JSONException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        nameValuePairs.put(checkName(name), value);
        return (JSONObject)dsTaint.getTaint();
        // ---------- Original Method ----------
        //nameValuePairs.put(checkName(name), value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.161 -0400", hash_original_method = "8B4C0C01745202135A0373E57DFB791E", hash_generated_method = "BD2BABCCF75A828C04D9F5093FCC0915")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONObject put(String name, Object value) throws JSONException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value.dsTaint);
        {
            nameValuePairs.remove(name);
        } //End block
        {
            JSON.checkDouble(((Number) value).doubleValue());
        } //End block
        nameValuePairs.put(checkName(name), value);
        return (JSONObject)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.161 -0400", hash_original_method = "D9589667A2509A719F9DF68E891B85DD", hash_generated_method = "11317283F9E23BFA5DD54F9BD9C7373E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONObject putOpt(String name, Object value) throws JSONException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value.dsTaint);
        JSONObject var941E67453FF51A43FE5EC92D5E498D61_1272476313 = (put(name, value));
        return (JSONObject)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (name == null || value == null) {
            //return this;
        //}
        //return put(name, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.162 -0400", hash_original_method = "5A758AD2B70A18447D6617A35807B03B", hash_generated_method = "832D96287E7F325EA091A186AD376B4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONObject accumulate(String name, Object value) throws JSONException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value.dsTaint);
        Object current;
        current = nameValuePairs.get(checkName(name));
        {
            JSONObject var6A9DE0347AC15B914F5D5797A9005ECA_1099736812 = (put(name, value));
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
        return (JSONObject)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.162 -0400", hash_original_method = "1AA4BB08CA8C9DDACC6E60D58C017824", hash_generated_method = "1AE386A4FEEE7CEE9B213028C8158769")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     String checkName(String name) throws JSONException {
        dsTaint.addTaint(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new JSONException("Names must be non-null");
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new JSONException("Names must be non-null");
        //}
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.162 -0400", hash_original_method = "BEB5EB52101798DC8AC0FA25480A2C90", hash_generated_method = "FC3679D8BA0D28A9542727D159A691B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object remove(String name) {
        dsTaint.addTaint(name);
        Object varF154AA98D0BD663E354E2F5E611333DA_376541144 = (nameValuePairs.remove(name));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return nameValuePairs.remove(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.162 -0400", hash_original_method = "A1CD692FA856D7FF90D2024A71E93EE6", hash_generated_method = "1AE08EB0E5DD709E262AC8DDD5840C26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isNull(String name) {
        dsTaint.addTaint(name);
        Object value;
        value = nameValuePairs.get(name);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Object value = nameValuePairs.get(name);
        //return value == null || value == NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.162 -0400", hash_original_method = "297E71AC76AEECD92DCC3FA05327BE46", hash_generated_method = "A7526E29171DAC01FF30CD1E66988E58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean has(String name) {
        dsTaint.addTaint(name);
        boolean varAECCD7AE3813DBC2EAACB91C7BEDAB3D_518785485 = (nameValuePairs.containsKey(name));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return nameValuePairs.containsKey(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.162 -0400", hash_original_method = "C38AAF9284AEE2A94970713BC651F263", hash_generated_method = "76BAC8072D48D988CA17615D337EF5DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object get(String name) throws JSONException {
        dsTaint.addTaint(name);
        Object result;
        result = nameValuePairs.get(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new JSONException("No value for " + name);
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object result = nameValuePairs.get(name);
        //if (result == null) {
            //throw new JSONException("No value for " + name);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.163 -0400", hash_original_method = "05A351DC7DE639568132A573A6E2106E", hash_generated_method = "3C1CFCF9427AF5B9BD56785F5A3B1B3A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object opt(String name) {
        dsTaint.addTaint(name);
        Object var83CD46631178BED894FA00675FEDA5DC_1808442474 = (nameValuePairs.get(name));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return nameValuePairs.get(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.165 -0400", hash_original_method = "7B38D2B2DBA3C433303B4D117D86E4E0", hash_generated_method = "2C2AD5EB0695407F8F92964355364CB4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getBoolean(String name) throws JSONException {
        dsTaint.addTaint(name);
        Object object;
        object = get(name);
        Boolean result;
        result = JSON.toBoolean(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(name, object, "boolean");
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Object object = get(name);
        //Boolean result = JSON.toBoolean(object);
        //if (result == null) {
            //throw JSON.typeMismatch(name, object, "boolean");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.165 -0400", hash_original_method = "3DA4544CD80345F7570489979490BD16", hash_generated_method = "A9F6E25C2ABD4C53EE8B63A2E8C4CFFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean optBoolean(String name) {
        dsTaint.addTaint(name);
        boolean var8BE80B6E9846B5FE1784886B30F81C14_1029700745 = (optBoolean(name, false));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return optBoolean(name, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.166 -0400", hash_original_method = "C49CAFC4CC69BC825D274D7317108A68", hash_generated_method = "5C3B60766EE9A71485C0DCEC2501D388")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean optBoolean(String name, boolean fallback) {
        dsTaint.addTaint(fallback);
        dsTaint.addTaint(name);
        Object object;
        object = opt(name);
        Boolean result;
        result = JSON.toBoolean(object);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Object object = opt(name);
        //Boolean result = JSON.toBoolean(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.166 -0400", hash_original_method = "0C60D6C72644A8965D87529BB9443348", hash_generated_method = "6F1DF4AF8892CEF1CAD7DF93810B59BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public double getDouble(String name) throws JSONException {
        dsTaint.addTaint(name);
        Object object;
        object = get(name);
        Double result;
        result = JSON.toDouble(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(name, object, "double");
        } //End block
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //Object object = get(name);
        //Double result = JSON.toDouble(object);
        //if (result == null) {
            //throw JSON.typeMismatch(name, object, "double");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.166 -0400", hash_original_method = "B9CFB7D5CC2BB58B8CACB29638DEE6A6", hash_generated_method = "E8F0D01F3639A4535DDC3CD76F44C048")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public double optDouble(String name) {
        dsTaint.addTaint(name);
        double varC56F0B477EEE0A41E1A76F177E961C03_1237894856 = (optDouble(name, Double.NaN));
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return optDouble(name, Double.NaN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.166 -0400", hash_original_method = "F525E9AC5AAC714EA253692C6DC9EE0E", hash_generated_method = "9BEE24A5FD22D627C56DD83FA22FD634")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public double optDouble(String name, double fallback) {
        dsTaint.addTaint(fallback);
        dsTaint.addTaint(name);
        Object object;
        object = opt(name);
        Double result;
        result = JSON.toDouble(object);
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //Object object = opt(name);
        //Double result = JSON.toDouble(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.166 -0400", hash_original_method = "06DD6202AFC58B0F1BA6F9DBAA37C5F3", hash_generated_method = "E1F6BCFC2FFAF11D43BA4005DC92999B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getInt(String name) throws JSONException {
        dsTaint.addTaint(name);
        Object object;
        object = get(name);
        Integer result;
        result = JSON.toInteger(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(name, object, "int");
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //Object object = get(name);
        //Integer result = JSON.toInteger(object);
        //if (result == null) {
            //throw JSON.typeMismatch(name, object, "int");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.167 -0400", hash_original_method = "CF8C56AE8C6952FAAA48007CA568A3BF", hash_generated_method = "BB443E5E458F69DA63807D58708FC530")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int optInt(String name) {
        dsTaint.addTaint(name);
        int var9479CC3C6E3D661742F54067B614174E_73257411 = (optInt(name, 0));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return optInt(name, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.167 -0400", hash_original_method = "FC3121A883EAF5555BD9C194D7925D34", hash_generated_method = "E8AA6C3CA1CBB05BFEEDF912A16385F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int optInt(String name, int fallback) {
        dsTaint.addTaint(fallback);
        dsTaint.addTaint(name);
        Object object;
        object = opt(name);
        Integer result;
        result = JSON.toInteger(object);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //Object object = opt(name);
        //Integer result = JSON.toInteger(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.167 -0400", hash_original_method = "55ABC1042FFC5D7EF9272460461F1426", hash_generated_method = "D68B27CF657328007B32CA96BE0871FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getLong(String name) throws JSONException {
        dsTaint.addTaint(name);
        Object object;
        object = get(name);
        Long result;
        result = JSON.toLong(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(name, object, "long");
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //Object object = get(name);
        //Long result = JSON.toLong(object);
        //if (result == null) {
            //throw JSON.typeMismatch(name, object, "long");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.167 -0400", hash_original_method = "70DEF89A3C807E0937F5C9E9E3A1A203", hash_generated_method = "2CEA33A6D4A0FD4B59C82CB300675D4A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long optLong(String name) {
        dsTaint.addTaint(name);
        long var4E3DB8E77FB5DFAD161FC7022FC765A8_1384815543 = (optLong(name, 0L));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return optLong(name, 0L);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.167 -0400", hash_original_method = "C94BC7D2B7352E7323E9E58C53ACE476", hash_generated_method = "A3B703E93D74A53E9ABE0D3617024823")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long optLong(String name, long fallback) {
        dsTaint.addTaint(fallback);
        dsTaint.addTaint(name);
        Object object;
        object = opt(name);
        Long result;
        result = JSON.toLong(object);
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //Object object = opt(name);
        //Long result = JSON.toLong(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.168 -0400", hash_original_method = "CC649536AC568087B4414076D420F027", hash_generated_method = "D977B62971FA296F65BB28AE6BBD341F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getString(String name) throws JSONException {
        dsTaint.addTaint(name);
        Object object;
        object = get(name);
        String result;
        result = JSON.toString(object);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(name, object, "String");
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //Object object = get(name);
        //String result = JSON.toString(object);
        //if (result == null) {
            //throw JSON.typeMismatch(name, object, "String");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.168 -0400", hash_original_method = "8B81E5CBB6FE92C9270C8AE14E1D248D", hash_generated_method = "A2D087A9A948BC3E3FCEFE58CBE8989F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String optString(String name) {
        dsTaint.addTaint(name);
        String var364AAD92CBF0649838B1576BBE024E24_1313502939 = (optString(name, ""));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return optString(name, "");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.168 -0400", hash_original_method = "B4BBF2951ACCBF79FD3FE8AB17DCAE83", hash_generated_method = "6C053E0A4B7B90BD8021AFDED52D0E07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String optString(String name, String fallback) {
        dsTaint.addTaint(fallback);
        dsTaint.addTaint(name);
        Object object;
        object = opt(name);
        String result;
        result = JSON.toString(object);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //Object object = opt(name);
        //String result = JSON.toString(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.168 -0400", hash_original_method = "1CE1CD2D1D65AA0859027B9575FA80C4", hash_generated_method = "C38209502A9AC70D199E7096C0BCD4BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONArray getJSONArray(String name) throws JSONException {
        dsTaint.addTaint(name);
        Object object;
        object = get(name);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(name, object, "JSONArray");
        } //End block
        return (JSONArray)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object object = get(name);
        //if (object instanceof JSONArray) {
            //return (JSONArray) object;
        //} else {
            //throw JSON.typeMismatch(name, object, "JSONArray");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.169 -0400", hash_original_method = "576EFB0CB9E2FA91FCF1D9A3EF1337C6", hash_generated_method = "3EC4065316BBBF7C048F1B86C9E7317E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONArray optJSONArray(String name) {
        dsTaint.addTaint(name);
        Object object;
        object = opt(name);
        return (JSONArray)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object object = opt(name);
        //return object instanceof JSONArray ? (JSONArray) object : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.169 -0400", hash_original_method = "5326315C93466A3B1E8C695224A5B5FD", hash_generated_method = "84C2287543E36DED7BDE721168874278")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONObject getJSONObject(String name) throws JSONException {
        dsTaint.addTaint(name);
        Object object;
        object = get(name);
        {
            if (DroidSafeAndroidRuntime.control) throw JSON.typeMismatch(name, object, "JSONObject");
        } //End block
        return (JSONObject)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object object = get(name);
        //if (object instanceof JSONObject) {
            //return (JSONObject) object;
        //} else {
            //throw JSON.typeMismatch(name, object, "JSONObject");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.169 -0400", hash_original_method = "B736B3B7313026EC1CBB4CB1D3C2367D", hash_generated_method = "018C22756C040DEC91FC5DC999A6DB36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONObject optJSONObject(String name) {
        dsTaint.addTaint(name);
        Object object;
        object = opt(name);
        return (JSONObject)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object object = opt(name);
        //return object instanceof JSONObject ? (JSONObject) object : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.169 -0400", hash_original_method = "1E876AFA246F164144A4BA68FB0C8527", hash_generated_method = "D00FA5861753B91409D5D9F6967CADDC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONArray toJSONArray(JSONArray names) throws JSONException {
        dsTaint.addTaint(names.dsTaint);
        JSONArray result;
        result = new JSONArray();
        int length;
        length = names.length();
        {
            int i;
            i = 0;
            {
                String name;
                name = JSON.toString(names.opt(i));
                result.put(opt(name));
            } //End block
        } //End collapsed parenthetic
        return (JSONArray)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.169 -0400", hash_original_method = "2D137981D66EA2E55940EA81187D393D", hash_generated_method = "CC98571723225796499A75705F420502")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Iterator keys() {
        Iterator var287F0F66295B676F0A5B3067B553F943_1725206617 = (nameValuePairs.keySet().iterator());
        return (Iterator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return nameValuePairs.keySet().iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.170 -0400", hash_original_method = "3ECE715C4DC492B6D08AC6D2EACB5C9C", hash_generated_method = "87E52D479FE66FAD8D8FFA0D2FFB3424")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONArray names() {
        {
            boolean var18643A8CD2E355DDB0351E435114CDB3_283742424 = (nameValuePairs.isEmpty());
            Object varFA1DE0EE90812A59A2F47815E244E5DC_105584058 = (new JSONArray(new ArrayList<String>(nameValuePairs.keySet())));
        } //End flattened ternary
        return (JSONArray)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return nameValuePairs.isEmpty()
                //? null
                //: new JSONArray(new ArrayList<String>(nameValuePairs.keySet()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.170 -0400", hash_original_method = "CC6BE78472EEEAF64E530CA9F9B14BB5", hash_generated_method = "79CC07BA20F12611E99C031FB0A36450")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        try 
        {
            JSONStringer stringer;
            stringer = new JSONStringer();
            writeTo(stringer);
            String var4DDAB7D77993E4AF1A58F12BAE21218F_888240372 = (stringer.toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.170 -0400", hash_original_method = "161CBAA0F7E505CC65BF62A9F4C8490E", hash_generated_method = "C75521C898C092454982B86F99FC0196")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString(int indentSpaces) throws JSONException {
        dsTaint.addTaint(indentSpaces);
        JSONStringer stringer;
        stringer = new JSONStringer(indentSpaces);
        writeTo(stringer);
        String var8FC62F826C6AE40C27D034989F134FDC_1170803398 = (stringer.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //JSONStringer stringer = new JSONStringer(indentSpaces);
        //writeTo(stringer);
        //return stringer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.174 -0400", hash_original_method = "4318203F3538DC271461FDA2F00ABD52", hash_generated_method = "9CBAF9CDBD7A99CD459E50577786161F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void writeTo(JSONStringer stringer) throws JSONException {
        dsTaint.addTaint(stringer.dsTaint);
        stringer.object();
        {
            Iterator<Map.Entry<String, Object>> varAC53BD32903113FD541755067191E1E9_683458762 = (nameValuePairs.entrySet()).iterator();
            varAC53BD32903113FD541755067191E1E9_683458762.hasNext();
            Map.Entry<String, Object> entry = varAC53BD32903113FD541755067191E1E9_683458762.next();
            {
                stringer.key(entry.getKey()).value(entry.getValue());
            } //End block
        } //End collapsed parenthetic
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

    
    private static final Double NEGATIVE_ZERO = -0d;
    public static final Object NULL = new Object() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.175 -0400", hash_original_method = "4F2355DBC727B25E0D2B31778D32159D", hash_generated_method = "3C7431A759B58721632B2318CF983ABF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object o) {
            dsTaint.addTaint(o.dsTaint);
            boolean varAA72FD11672B18F724F2EFF7FAA60339_693216470 = (o == this || o == null);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return o == this || o == null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.175 -0400", hash_original_method = "2607A8359DD6B43A393B68FD7BAE6C5B", hash_generated_method = "33D1BEAFBEDE6C89BC6BE0E44ACAF702")
        @DSModeled(DSC.SAFE)
        @Override
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "null";
        }

        
}; //Transformed anonymous class
}

