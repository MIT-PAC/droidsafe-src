package org.json;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JSONArray {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.118 -0500", hash_original_field = "A3E8C7EC069A9E0F015BF0FA6AB144B4", hash_generated_field = "76A4FC356F020E02D923B1E56C39C10C")

    private  List<Object> values;

    /**
     * Creates a {@code JSONArray} with no values.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.121 -0500", hash_original_method = "1427CA478AAC933787CA982EEEA58E55", hash_generated_method = "2ECBE9A720E52DB096754778C599BC2A")
    
public JSONArray() {
        values = new ArrayList<Object>();
    }

    /**
     * Creates a new {@code JSONArray} by copying all values from the given
     * collection.
     *
     * @param copyFrom a collection whose values are of supported types.
     *     Unsupported values are not permitted and will yield an array in an
     *     inconsistent state.
     */
    /* Accept a raw type for API compatibility */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.124 -0500", hash_original_method = "805B0E8915A04C6C98723D3A60FEDF41", hash_generated_method = "6D7E422BCC78B627345619FACE71D8D8")
    
public JSONArray(Collection copyFrom) {
        this();
        Collection<?> copyFromTyped = (Collection<?>) copyFrom;
        values.addAll(copyFromTyped);
    }

    /**
     * Creates a new {@code JSONArray} with values from the next array in the
     * tokener.
     *
     * @param readFrom a tokener whose nextValue() method will yield a
     *     {@code JSONArray}.
     * @throws JSONException if the parse fails or doesn't yield a
     *     {@code JSONArray}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.126 -0500", hash_original_method = "7582B79BE7678565BA45DD0B34B6A75F", hash_generated_method = "995A1D2B91A3B9CA213D3B2FD5E7A572")
    
public JSONArray(JSONTokener readFrom) throws JSONException {
        /*
         * Getting the parser to populate this could get tricky. Instead, just
         * parse to temporary JSONArray and then steal the data from that.
         */
        Object object = readFrom.nextValue();
        if (object instanceof JSONArray) {
            values = ((JSONArray) object).values;
        } else {
            throw JSON.typeMismatch(object, "JSONArray");
        }
    }

    /**
     * Creates a new {@code JSONArray} with values from the JSON string.
     *
     * @param json a JSON-encoded string containing an array.
     * @throws JSONException if the parse fails or doesn't yield a {@code
     *     JSONArray}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.129 -0500", hash_original_method = "FBB8D188E5327545CDAACE0ACBE68DD3", hash_generated_method = "7DCA21631C1DA0C6495490AC1CC3915F")
    
public JSONArray(String json) throws JSONException {
        this(new JSONTokener(json));
    }

    /**
     * Returns the number of values in this array.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.131 -0500", hash_original_method = "2C5D59A27A6C313C8872AC341D9D75C0", hash_generated_method = "3AACFABE68E73FA43986B37F3043990F")
    
public int length() {
        return values.size();
    }

    /**
     * Appends {@code value} to the end of this array.
     *
     * @return this array.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.133 -0500", hash_original_method = "F9CCA0A17EFD82FAE33507862E5A944E", hash_generated_method = "92EC6FD583C43819F7C7F62F00696EBA")
    
public JSONArray put(boolean value) {
        values.add(value);
        return this;
    }

    /**
     * Appends {@code value} to the end of this array.
     *
     * @param value a finite value. May not be {@link Double#isNaN() NaNs} or
     *     {@link Double#isInfinite() infinities}.
     * @return this array.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.136 -0500", hash_original_method = "632D5AC8096954F0909B9EEBB1192731", hash_generated_method = "CBF47E97724CD52FE9176E4EB83DB62D")
    
public JSONArray put(double value) throws JSONException {
        values.add(JSON.checkDouble(value));
        return this;
    }

    /**
     * Appends {@code value} to the end of this array.
     *
     * @return this array.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.138 -0500", hash_original_method = "324220FCD4B61377969B5003ED2C32CE", hash_generated_method = "482CF9E47932D231E06BB74770E73811")
    
public JSONArray put(int value) {
        values.add(value);
        return this;
    }

    /**
     * Appends {@code value} to the end of this array.
     *
     * @return this array.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.140 -0500", hash_original_method = "4C6CD72BE64F436E9F52C8D610641FF3", hash_generated_method = "DCCA532A4FD205043A8133F30B08B029")
    
public JSONArray put(long value) {
        values.add(value);
        return this;
    }

    /**
     * Appends {@code value} to the end of this array.
     *
     * @param value a {@link JSONObject}, {@link JSONArray}, String, Boolean,
     *     Integer, Long, Double, {@link JSONObject#NULL}, or {@code null}. May
     *     not be {@link Double#isNaN() NaNs} or {@link Double#isInfinite()
     *     infinities}. Unsupported values are not permitted and will cause the
     *     array to be in an inconsistent state.
     * @return this array.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.142 -0500", hash_original_method = "1D7645A229713F67337A58F8FF42D21C", hash_generated_method = "82437EE5156066785EE68B7C3A2264D7")
    
public JSONArray put(Object value) {
        values.add(value);
        return this;
    }

    /**
     * Sets the value at {@code index} to {@code value}, null padding this array
     * to the required length if necessary. If a value already exists at {@code
     * index}, it will be replaced.
     *
     * @return this array.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.144 -0500", hash_original_method = "A8D9FD0A2FF792A00A29218BCE37DF7B", hash_generated_method = "3FCD33BB0802F5EBFF717FF4F02EDA89")
    
public JSONArray put(int index, boolean value) throws JSONException {
        return put(index, (Boolean) value);
    }

    /**
     * Sets the value at {@code index} to {@code value}, null padding this array
     * to the required length if necessary. If a value already exists at {@code
     * index}, it will be replaced.
     *
     * @param value a finite value. May not be {@link Double#isNaN() NaNs} or
     *     {@link Double#isInfinite() infinities}.
     * @return this array.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.146 -0500", hash_original_method = "EB27801A89D2451AEBF6D71C639BF890", hash_generated_method = "0D580EDBEF0BBFF5D77F8DB8DEA5850C")
    
public JSONArray put(int index, double value) throws JSONException {
        return put(index, (Double) value);
    }

    /**
     * Sets the value at {@code index} to {@code value}, null padding this array
     * to the required length if necessary. If a value already exists at {@code
     * index}, it will be replaced.
     *
     * @return this array.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.148 -0500", hash_original_method = "95364EFCBA8D50C1E1F228177A921191", hash_generated_method = "D01A68C4E36600A075B12B2BECD6C64A")
    
public JSONArray put(int index, int value) throws JSONException {
        return put(index, (Integer) value);
    }

    /**
     * Sets the value at {@code index} to {@code value}, null padding this array
     * to the required length if necessary. If a value already exists at {@code
     * index}, it will be replaced.
     *
     * @return this array.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.151 -0500", hash_original_method = "3F2291B7B045A442A1A296D04FF74C3B", hash_generated_method = "331C4CA90A1EF52AEBC951490AF5DF55")
    
public JSONArray put(int index, long value) throws JSONException {
        return put(index, (Long) value);
    }

    /**
     * Sets the value at {@code index} to {@code value}, null padding this array
     * to the required length if necessary. If a value already exists at {@code
     * index}, it will be replaced.
     *
     * @param value a {@link JSONObject}, {@link JSONArray}, String, Boolean,
     *     Integer, Long, Double, {@link JSONObject#NULL}, or {@code null}. May
     *     not be {@link Double#isNaN() NaNs} or {@link Double#isInfinite()
     *     infinities}.
     * @return this array.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.154 -0500", hash_original_method = "965F91AFDF1516EF58CC39AD3E1136B7", hash_generated_method = "FB88B16619C2545F5372C618D722FB65")
    
public JSONArray put(int index, Object value) throws JSONException {
        if (value instanceof Number) {
            // deviate from the original by checking all Numbers, not just floats & doubles
            JSON.checkDouble(((Number) value).doubleValue());
        }
        while (values.size() <= index) {
            values.add(null);
        }
        values.set(index, value);
        return this;
    }

    /**
     * Returns true if this array has no value at {@code index}, or if its value
     * is the {@code null} reference or {@link JSONObject#NULL}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.156 -0500", hash_original_method = "075BEAC25684C4B47CFBC04F9272F423", hash_generated_method = "3223A88BCBF4F6D9F170B110C5E327D9")
    
public boolean isNull(int index) {
        Object value = opt(index);
        return value == null || value == JSONObject.NULL;
    }

    /**
     * Returns the value at {@code index}.
     *
     * @throws JSONException if this array has no value at {@code index}, or if
     *     that value is the {@code null} reference. This method returns
     *     normally if the value is {@code JSONObject#NULL}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.159 -0500", hash_original_method = "2917FB45D7E32294FB2932AB5B08992C", hash_generated_method = "5EED0C1B528791A5B50CA8E6FBD90F09")
    
public Object get(int index) throws JSONException {
        try {
            Object value = values.get(index);
            if (value == null) {
                throw new JSONException("Value at " + index + " is null.");
            }
            return value;
        } catch (IndexOutOfBoundsException e) {
            throw new JSONException("Index " + index + " out of range [0.." + values.size() + ")");
        }
    }

    /**
     * Returns the value at {@code index}, or null if the array has no value
     * at {@code index}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.161 -0500", hash_original_method = "3B6F9D3E5AFD1AB6175A8B6BF8959553", hash_generated_method = "E9364195B1A2432EBD789052537240B5")
    
public Object opt(int index) {
        if (index < 0 || index >= values.size()) {
            return null;
        }
        return values.get(index);
    }

    /**
     * Returns the value at {@code index} if it exists and is a boolean or can
     * be coerced to a boolean.
     *
     * @throws JSONException if the value at {@code index} doesn't exist or
     *     cannot be coerced to a boolean.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.163 -0500", hash_original_method = "24E6A67B676FCC7270A02518A61B22A2", hash_generated_method = "068179F50E87603F2E2EB87ABC9B1FE0")
    
public boolean getBoolean(int index) throws JSONException {
        Object object = get(index);
        Boolean result = JSON.toBoolean(object);
        if (result == null) {
            throw JSON.typeMismatch(index, object, "boolean");
        }
        return result;
    }

    /**
     * Returns the value at {@code index} if it exists and is a boolean or can
     * be coerced to a boolean. Returns false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.165 -0500", hash_original_method = "A304D16233AC57FB2DDAD429570460E8", hash_generated_method = "20C15F3A4072CF074A32750E7017CD94")
    
public boolean optBoolean(int index) {
        return optBoolean(index, false);
    }

    /**
     * Returns the value at {@code index} if it exists and is a boolean or can
     * be coerced to a boolean. Returns {@code fallback} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.167 -0500", hash_original_method = "D837DFEA35C0469693745E1088FDEE2E", hash_generated_method = "25B8FC089E396BA9F9B1BEF1B31BA87A")
    
public boolean optBoolean(int index, boolean fallback) {
        Object object = opt(index);
        Boolean result = JSON.toBoolean(object);
        return result != null ? result : fallback;
    }

    /**
     * Returns the value at {@code index} if it exists and is a double or can
     * be coerced to a double.
     *
     * @throws JSONException if the value at {@code index} doesn't exist or
     *     cannot be coerced to a double.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.170 -0500", hash_original_method = "6D74AEBF7F111E364BD2DB0E7727FAF6", hash_generated_method = "F5749A7B907974AF24E1731993E89C58")
    
public double getDouble(int index) throws JSONException {
        Object object = get(index);
        Double result = JSON.toDouble(object);
        if (result == null) {
            throw JSON.typeMismatch(index, object, "double");
        }
        return result;
    }

    /**
     * Returns the value at {@code index} if it exists and is a double or can
     * be coerced to a double. Returns {@code NaN} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.172 -0500", hash_original_method = "6ACFD4932D58B1B1AAD30FC39935EAD2", hash_generated_method = "453A4D077A6982E7EDE231E2E9FAA62A")
    
public double optDouble(int index) {
        return optDouble(index, Double.NaN);
    }

    /**
     * Returns the value at {@code index} if it exists and is a double or can
     * be coerced to a double. Returns {@code fallback} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.174 -0500", hash_original_method = "0BBC192CCA032D1199B25DAD0E3977E8", hash_generated_method = "E9A90200D70440790A15A807DFBB98BC")
    
public double optDouble(int index, double fallback) {
        Object object = opt(index);
        Double result = JSON.toDouble(object);
        return result != null ? result : fallback;
    }

    /**
     * Returns the value at {@code index} if it exists and is an int or
     * can be coerced to an int.
     *
     * @throws JSONException if the value at {@code index} doesn't exist or
     *     cannot be coerced to a int.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.177 -0500", hash_original_method = "853222C548896141F9D1D8AF0338F5C4", hash_generated_method = "4C51124504E2CD640D7DF46E1E1C6C76")
    
public int getInt(int index) throws JSONException {
        Object object = get(index);
        Integer result = JSON.toInteger(object);
        if (result == null) {
            throw JSON.typeMismatch(index, object, "int");
        }
        return result;
    }

    /**
     * Returns the value at {@code index} if it exists and is an int or
     * can be coerced to an int. Returns 0 otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.179 -0500", hash_original_method = "7CF76FC4FBEA846C37B11EB5D3437F82", hash_generated_method = "32F60299344BEEC48845C167B06B4EBD")
    
public int optInt(int index) {
        return optInt(index, 0);
    }

    /**
     * Returns the value at {@code index} if it exists and is an int or
     * can be coerced to an int. Returns {@code fallback} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.181 -0500", hash_original_method = "5DB279774D0456981D1F7F001BBC18BA", hash_generated_method = "1EFFF1DE180607284DD54A152EB8A249")
    
public int optInt(int index, int fallback) {
        Object object = opt(index);
        Integer result = JSON.toInteger(object);
        return result != null ? result : fallback;
    }

    /**
     * Returns the value at {@code index} if it exists and is a long or
     * can be coerced to a long.
     *
     * @throws JSONException if the value at {@code index} doesn't exist or
     *     cannot be coerced to a long.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.183 -0500", hash_original_method = "56F71130ADC070DD70D4CA02CA42F381", hash_generated_method = "48E18E91DB48E9BD0A5BFEC4E7D094C6")
    
public long getLong(int index) throws JSONException {
        Object object = get(index);
        Long result = JSON.toLong(object);
        if (result == null) {
            throw JSON.typeMismatch(index, object, "long");
        }
        return result;
    }

    /**
     * Returns the value at {@code index} if it exists and is a long or
     * can be coerced to a long. Returns 0 otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.185 -0500", hash_original_method = "2BBCBA9E354F863B816F565C8B8E92CB", hash_generated_method = "699200C3BFF97AFD0F394965E00AD0B8")
    
public long optLong(int index) {
        return optLong(index, 0L);
    }

    /**
     * Returns the value at {@code index} if it exists and is a long or
     * can be coerced to a long. Returns {@code fallback} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.187 -0500", hash_original_method = "81CF1715684C5D206C6FD7331990B13E", hash_generated_method = "F4C8D6AC058C7590EA70B4E837E54F7B")
    
public long optLong(int index, long fallback) {
        Object object = opt(index);
        Long result = JSON.toLong(object);
        return result != null ? result : fallback;
    }

    /**
     * Returns the value at {@code index} if it exists, coercing it if
     * necessary.
     *
     * @throws JSONException if no such value exists.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.190 -0500", hash_original_method = "7F7D1138F84D636CF19BD9329533631C", hash_generated_method = "0365BDA66A795FC988F6F320537F1441")
    
public String getString(int index) throws JSONException {
        Object object = get(index);
        String result = JSON.toString(object);
        if (result == null) {
            throw JSON.typeMismatch(index, object, "String");
        }
        return result;
    }

    /**
     * Returns the value at {@code index} if it exists, coercing it if
     * necessary. Returns the empty string if no such value exists.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.192 -0500", hash_original_method = "C31202553EDC4F0A1E4B21CAD06ABEC4", hash_generated_method = "544153A500274940BF25956F852239DC")
    
public String optString(int index) {
        return optString(index, "");
    }

    /**
     * Returns the value at {@code index} if it exists, coercing it if
     * necessary. Returns {@code fallback} if no such value exists.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.194 -0500", hash_original_method = "97366D23F93DD4ABD9E565325F7585B9", hash_generated_method = "91729EF16DE49D09DE118E35C419E0FA")
    
public String optString(int index, String fallback) {
        Object object = opt(index);
        String result = JSON.toString(object);
        return result != null ? result : fallback;
    }

    /**
     * Returns the value at {@code index} if it exists and is a {@code
     * JSONArray}.
     *
     * @throws JSONException if the value doesn't exist or is not a {@code
     *     JSONArray}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.197 -0500", hash_original_method = "173A28EF43B750DEF6376D4E3E2F6DD2", hash_generated_method = "459C1ED143E63E9E494C51B86E927624")
    
public JSONArray getJSONArray(int index) throws JSONException {
        Object object = get(index);
        if (object instanceof JSONArray) {
            return (JSONArray) object;
        } else {
            throw JSON.typeMismatch(index, object, "JSONArray");
        }
    }

    /**
     * Returns the value at {@code index} if it exists and is a {@code
     * JSONArray}. Returns null otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.200 -0500", hash_original_method = "CBF30564657B4CB07ABBCF29084A5653", hash_generated_method = "3BC071041F99298217A329C64552D883")
    
public JSONArray optJSONArray(int index) {
        Object object = opt(index);
        return object instanceof JSONArray ? (JSONArray) object : null;
    }

    /**
     * Returns the value at {@code index} if it exists and is a {@code
     * JSONObject}.
     *
     * @throws JSONException if the value doesn't exist or is not a {@code
     *     JSONObject}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.202 -0500", hash_original_method = "EA5692C9D71198B472B917468564A78A", hash_generated_method = "41FD830A311E39BCE38061C86149FC0E")
    
public JSONObject getJSONObject(int index) throws JSONException {
        Object object = get(index);
        if (object instanceof JSONObject) {
            return (JSONObject) object;
        } else {
            throw JSON.typeMismatch(index, object, "JSONObject");
        }
    }

    /**
     * Returns the value at {@code index} if it exists and is a {@code
     * JSONObject}. Returns null otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.204 -0500", hash_original_method = "871DF64EA3EF0F09C790BD6ABB0AB209", hash_generated_method = "B1FB6C36F2C83C4BC0BBB19039718483")
    
public JSONObject optJSONObject(int index) {
        Object object = opt(index);
        return object instanceof JSONObject ? (JSONObject) object : null;
    }

    /**
     * Returns a new object whose values are the values in this array, and whose
     * names are the values in {@code names}. Names and values are paired up by
     * index from 0 through to the shorter array's length. Names that are not
     * strings will be coerced to strings. This method returns null if either
     * array is empty.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.207 -0500", hash_original_method = "CEEBF6D79C62E432FE9EF262922223A6", hash_generated_method = "03989B8AB15D382B730F1AA7C698EEA1")
    
public JSONObject toJSONObject(JSONArray names) throws JSONException {
        JSONObject result = new JSONObject();
        int length = Math.min(names.length(), values.size());
        if (length == 0) {
            return null;
        }
        for (int i = 0; i < length; i++) {
            String name = JSON.toString(names.opt(i));
            result.put(name, opt(i));
        }
        return result;
    }

    /**
     * Returns a new string by alternating this array's values with {@code
     * separator}. This array's string values are quoted and have their special
     * characters escaped. For example, the array containing the strings '12"
     * pizza', 'taco' and 'soda' joined on '+' returns this:
     * <pre>"12\" pizza"+"taco"+"soda"</pre>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.209 -0500", hash_original_method = "818E08743989593DA274993EAEC63482", hash_generated_method = "3BC4E310ED4F1995034F638609368D66")
    
public String join(String separator) throws JSONException {
        JSONStringer stringer = new JSONStringer();
        stringer.open(JSONStringer.Scope.NULL, "");
        for (int i = 0, size = values.size(); i < size; i++) {
            if (i > 0) {
                stringer.out.append(separator);
            }
            stringer.value(values.get(i));
        }
        stringer.close(JSONStringer.Scope.NULL, JSONStringer.Scope.NULL, "");
        return stringer.out.toString();
    }

    /**
     * Encodes this array as a compact JSON string, such as:
     * <pre>[94043,90210]</pre>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.211 -0500", hash_original_method = "CC6BE78472EEEAF64E530CA9F9B14BB5", hash_generated_method = "000C0FCE86F8834F70EB7B14EA12E002")
    
@Override public String toString() {
        try {
            JSONStringer stringer = new JSONStringer();
            writeTo(stringer);
            return stringer.toString();
        } catch (JSONException e) {
            return null;
        }
    }

    /**
     * Encodes this array as a human readable JSON string for debugging, such
     * as:
     * <pre>
     * [
     *     94043,
     *     90210
     * ]</pre>
     *
     * @param indentSpaces the number of spaces to indent for each level of
     *     nesting.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.213 -0500", hash_original_method = "161CBAA0F7E505CC65BF62A9F4C8490E", hash_generated_method = "89736320EFA9E85B06F0454670E154AA")
    
public String toString(int indentSpaces) throws JSONException {
        JSONStringer stringer = new JSONStringer(indentSpaces);
        writeTo(stringer);
        return stringer.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.216 -0500", hash_original_method = "07D36EC028565C954CCF4CA47905C766", hash_generated_method = "07D36EC028565C954CCF4CA47905C766")
    
void writeTo(JSONStringer stringer) throws JSONException {
        stringer.array();
        for (Object value : values) {
            stringer.value(value);
        }
        stringer.endArray();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.219 -0500", hash_original_method = "BF4C72A1D6E8FA2592A6106FA9BE5FDF", hash_generated_method = "0AFBB3E3E878906D580B157A22DB75DE")
    
@Override public boolean equals(Object o) {
        return o instanceof JSONArray && ((JSONArray) o).values.equals(values);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.221 -0500", hash_original_method = "5391F86F0DF47CDF0FABD2AA1BAE9E60", hash_generated_method = "17ED8AC656A97F927F56D6D68F2F762C")
    
@Override public int hashCode() {
        // diverge from the original, which doesn't implement hashCode
        return values.hashCode();
    }
    
}

