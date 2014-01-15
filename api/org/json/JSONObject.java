package org.json;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JSONObject {

    /**
     * Encodes the number as a JSON string.
     *
     * @param number a finite value. May not be {@link Double#isNaN() NaNs} or
     *     {@link Double#isInfinite() infinities}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.470 -0500", hash_original_method = "09914F60338D027B2BB13037BC713EDF", hash_generated_method = "5C825957353297221E26BC173ADA838D")
    
public static String numberToString(Number number) throws JSONException {
        if (number == null) {
            throw new JSONException("Number must be non-null");
        }

        double doubleValue = number.doubleValue();
        JSON.checkDouble(doubleValue);

        // the original returns "-0" instead of "-0.0" for negative zero
        if (number.equals(NEGATIVE_ZERO)) {
            return "-0";
        }

        long longValue = number.longValue();
        if (doubleValue == (double) longValue) {
            return Long.toString(longValue);
        }

        return number.toString();
    }

    /**
     * Encodes {@code data} as a JSON string. This applies quotes and any
     * necessary character escaping.
     *
     * @param data the string to encode. Null will be interpreted as an empty
     *     string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.472 -0500", hash_original_method = "8D831B624CAFCAE7E1032CD23305A3CA", hash_generated_method = "B2F669A03BE3445D5D4B9CA2A8D481B1")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.342 -0500", hash_original_field = "A6DB63616B9247B564C5D7181273FC7D", hash_generated_field = "1DBE8D3C6A9A7131154428322A8B1823")

    private static final Double NEGATIVE_ZERO = -0d;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.299 -0400", hash_original_field = "69D6A2BFA9970459DEF9916A4A819505", hash_generated_field = "3F3D3946D0FBB086C49E80D158F100D9")

    public static final Object NULL = new Object() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.345 -0500", hash_original_method = "4F2355DBC727B25E0D2B31778D32159D", hash_generated_method = "A167818F648781FE5D4BB7B0C4526A86")
        
@Override public boolean equals(Object o) {
            return o == this || o == null; // API specifies this broken equals implementation
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.348 -0500", hash_original_method = "2607A8359DD6B43A393B68FD7BAE6C5B", hash_generated_method = "27D7C70B62D116AE1958CB86717C0D66")
        
@Override public String toString() {
            return "null";
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.353 -0500", hash_original_field = "57EC091A260F7D60766E2E433D329B4D", hash_generated_field = "4AEF8EB90733274F8DF38365152EB324")

    private  Map<String, Object> nameValuePairs;

    /**
     * Creates a {@code JSONObject} with no name/value mappings.
     */
    @DSComment("no input, no suspicious activity")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.356 -0500", hash_original_method = "B0BA44B1CBEEB832685DE1D9CC551D36", hash_generated_method = "CA886F78827CF393F461673A690A24C4")
    
public JSONObject() {
        nameValuePairs = new HashMap<String, Object>();
    }

    /**
     * Creates a new {@code JSONObject} by copying all name/value mappings from
     * the given map.
     *
     * @param copyFrom a map whose keys are of type {@link String} and whose
     *     values are of supported types.
     * @throws NullPointerException if any of the map's keys are null.
     */
    /* (accept a raw type for API compatibility) */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.359 -0500", hash_original_method = "64F11EBDF44BE4F1CBC516D3CD1F34E9", hash_generated_method = "A0778519395FA695CB7DBFFBB7FA30BC")
    
public JSONObject(Map copyFrom) {
        this();
        Map<?, ?> contentsTyped = (Map<?, ?>) copyFrom;
        for (Map.Entry<?, ?> entry : contentsTyped.entrySet()) {
            /*
             * Deviate from the original by checking that keys are non-null and
             * of the proper type. (We still defer validating the values).
             */
            String key = (String) entry.getKey();
            if (key == null) {
                throw new NullPointerException();
            }
            nameValuePairs.put(key, entry.getValue());
        }
    }

    /**
     * Creates a new {@code JSONObject} with name/value mappings from the next
     * object in the tokener.
     *
     * @param readFrom a tokener whose nextValue() method will yield a
     *     {@code JSONObject}.
     * @throws JSONException if the parse fails or doesn't yield a
     *     {@code JSONObject}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.363 -0500", hash_original_method = "E218F03BB03DC7D8503E0318225F7859", hash_generated_method = "14CA65EE5FC3339BBD0B6282CFCE6FA6")
    
public JSONObject(JSONTokener readFrom) throws JSONException {
        /*
         * Getting the parser to populate this could get tricky. Instead, just
         * parse to temporary JSONObject and then steal the data from that.
         */
        Object object = readFrom.nextValue();
        if (object instanceof JSONObject) {
            this.nameValuePairs = ((JSONObject) object).nameValuePairs;
        } else {
            throw JSON.typeMismatch(object, "JSONObject");
        }
    }

    /**
     * Creates a new {@code JSONObject} with name/value mappings from the JSON
     * string.
     *
     * @param json a JSON-encoded string containing an object.
     * @throws JSONException if the parse fails or doesn't yield a {@code
     *     JSONObject}.
     */
    @DSComment("nothing useful in String")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.366 -0500", hash_original_method = "27B9491B51940DE15585B798AFD3D304", hash_generated_method = "EB2B2208654B0CC9801488D0DBC5ED91")
    
public JSONObject(String json) throws JSONException {
        this(new JSONTokener(json));
    }

    /**
     * Creates a new {@code JSONObject} by copying mappings for the listed names
     * from the given object. Names that aren't present in {@code copyFrom} will
     * be skipped.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.370 -0500", hash_original_method = "D555E6715A2E6E4EC106278BB66ED891", hash_generated_method = "E3D3A083646CDD937ED359E8AD5EC3A5")
    
public JSONObject(JSONObject copyFrom, String[] names) throws JSONException {
        this();
        for (String name : names) {
            Object value = copyFrom.opt(name);
            if (value != null) {
                nameValuePairs.put(name, value);
            }
        }
    }

    /**
     * Returns the number of name/value mappings in this object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.373 -0500", hash_original_method = "BB0C5A7042ADC1F8FC4BAA64EBFD2B52", hash_generated_method = "F53F34D04C3A7CD07CB3E8669CAB776D")
    
public int length() {
        return nameValuePairs.size();
    }

    /**
     * Maps {@code name} to {@code value}, clobbering any existing name/value
     * mapping with the same name.
     *
     * @return this object.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.377 -0500", hash_original_method = "43A124AF3EF8B2736A46103CC8729DE3", hash_generated_method = "2D8FDC3BDDE11901BE6BDBA44C0A6DDE")
    
public JSONObject put(String name, boolean value) throws JSONException {
        nameValuePairs.put(checkName(name), value);
        return this;
    }

    /**
     * Maps {@code name} to {@code value}, clobbering any existing name/value
     * mapping with the same name.
     *
     * @param value a finite value. May not be {@link Double#isNaN() NaNs} or
     *     {@link Double#isInfinite() infinities}.
     * @return this object.
     */
    @DSComment("nothing useful in inputs")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.379 -0500", hash_original_method = "FF23ECF2F7B3A424BD0CA2B446E9E0DB", hash_generated_method = "A8CF02341257AB189DB0DD273F097E91")
    
public JSONObject put(String name, double value) throws JSONException {
        nameValuePairs.put(checkName(name), JSON.checkDouble(value));
        return this;
    }

    /**
     * Maps {@code name} to {@code value}, clobbering any existing name/value
     * mapping with the same name.
     *
     * @return this object.
     */
    @DSComment("nothing useful in inputs")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.382 -0500", hash_original_method = "14B3109A64A28D2764163C4077CDC45D", hash_generated_method = "4A49F6F026199A14A96931DDB451468E")
    
public JSONObject put(String name, int value) throws JSONException {
        nameValuePairs.put(checkName(name), value);
        return this;
    }

    /**
     * Maps {@code name} to {@code value}, clobbering any existing name/value
     * mapping with the same name.
     *
     * @return this object.
     */
    @DSComment("nothing useful in String")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.384 -0500", hash_original_method = "0E78BCAD739042DC347A7959C52D188A", hash_generated_method = "52002C976EFF172F842E649C92F9A7AB")
    
public JSONObject put(String name, long value) throws JSONException {
        nameValuePairs.put(checkName(name), value);
        return this;
    }

    /**
     * Maps {@code name} to {@code value}, clobbering any existing name/value
     * mapping with the same name. If the value is {@code null}, any existing
     * mapping for {@code name} is removed.
     *
     * @param value a {@link JSONObject}, {@link JSONArray}, String, Boolean,
     *     Integer, Long, Double, {@link #NULL}, or {@code null}. May not be
     *     {@link Double#isNaN() NaNs} or {@link Double#isInfinite()
     *     infinities}.
     * @return this object.
     */
    @DSComment("nothing useful in inputs")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.387 -0500", hash_original_method = "8B4C0C01745202135A0373E57DFB791E", hash_generated_method = "2AB8BC2C7AA0FCD846B0A90F8EE2FDC3")
    
public JSONObject put(String name, Object value) throws JSONException {
        if (value == null) {
            nameValuePairs.remove(name);
            return this;
        }
        if (value instanceof Number) {
            // deviate from the original by checking all Numbers, not just floats & doubles
            JSON.checkDouble(((Number) value).doubleValue());
        }
        nameValuePairs.put(checkName(name), value);
        return this;
    }

    /**
     * Equivalent to {@code put(name, value)} when both parameters are non-null;
     * does nothing otherwise.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.390 -0500", hash_original_method = "D9589667A2509A719F9DF68E891B85DD", hash_generated_method = "213508B3CB132802B111EB473893D74C")
    
public JSONObject putOpt(String name, Object value) throws JSONException {
        if (name == null || value == null) {
            return this;
        }
        return put(name, value);
    }

    /**
     * Appends {@code value} to the array already mapped to {@code name}. If
     * this object has no mapping for {@code name}, this inserts a new mapping.
     * If the mapping exists but its value is not an array, the existing
     * and new values are inserted in order into a new array which is itself
     * mapped to {@code name}. In aggregate, this allows values to be added to a
     * mapping one at a time.
     *
     * @param value a {@link JSONObject}, {@link JSONArray}, String, Boolean,
     *     Integer, Long, Double, {@link #NULL} or null. May not be {@link
     *     Double#isNaN() NaNs} or {@link Double#isInfinite() infinities}.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.393 -0500", hash_original_method = "5A758AD2B70A18447D6617A35807B03B", hash_generated_method = "F2929DD2BE4B2CF0A8B81B1A28EFBEDB")
    
public JSONObject accumulate(String name, Object value) throws JSONException {
        Object current = nameValuePairs.get(checkName(name));
        if (current == null) {
            return put(name, value);
        }

        // check in accumulate, since array.put(Object) doesn't do any checking
        if (value instanceof Number) {
            JSON.checkDouble(((Number) value).doubleValue());
        }

        if (current instanceof JSONArray) {
            JSONArray array = (JSONArray) current;
            array.put(value);
        } else {
            JSONArray array = new JSONArray();
            array.put(current);
            array.put(value);
            nameValuePairs.put(name, array);
        }
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.395 -0500", hash_original_method = "1AA4BB08CA8C9DDACC6E60D58C017824", hash_generated_method = "1AA4BB08CA8C9DDACC6E60D58C017824")
    
String checkName(String name) throws JSONException {
        if (name == null) {
            throw new JSONException("Names must be non-null");
        }
        return name;
    }

    /**
     * Removes the named mapping if it exists; does nothing otherwise.
     *
     * @return the value previously mapped by {@code name}, or null if there was
     *     no such mapping.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.397 -0500", hash_original_method = "BEB5EB52101798DC8AC0FA25480A2C90", hash_generated_method = "7166FDD059B68813A67B9C42C369C0B6")
    
public Object remove(String name) {
        return nameValuePairs.remove(name);
    }

    /**
     * Returns true if this object has no mapping for {@code name} or if it has
     * a mapping whose value is {@link #NULL}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.400 -0500", hash_original_method = "A1CD692FA856D7FF90D2024A71E93EE6", hash_generated_method = "917F48F48E987BE0757F99968E0BB86C")
    
public boolean isNull(String name) {
        Object value = nameValuePairs.get(name);
        return value == null || value == NULL;
    }

    /**
     * Returns true if this object has a mapping for {@code name}. The mapping
     * may be {@link #NULL}.
     */
    @DSComment("nothing useful in String")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.402 -0500", hash_original_method = "297E71AC76AEECD92DCC3FA05327BE46", hash_generated_method = "A687C4B3EBBBFBBC16F111AAE84548E1")
    
public boolean has(String name) {
        return nameValuePairs.containsKey(name);
    }

    /**
     * Returns the value mapped by {@code name}.
     *
     * @throws JSONException if no such mapping exists.
     */
    @DSComment("nothing useful in String")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.405 -0500", hash_original_method = "C38AAF9284AEE2A94970713BC651F263", hash_generated_method = "989F09A0F626ABF8850A0B3BD55B0EE1")
    
public Object get(String name) throws JSONException {
        Object result = nameValuePairs.get(name);
        if (result == null) {
            throw new JSONException("No value for " + name);
        }
        return result;
    }

    /**
     * Returns the value mapped by {@code name}, or null if no such mapping
     * exists.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.407 -0500", hash_original_method = "05A351DC7DE639568132A573A6E2106E", hash_generated_method = "C267BC0F558D100AC5316952018EA59B")
    
public Object opt(String name) {
        return nameValuePairs.get(name);
    }

    /**
     * Returns the value mapped by {@code name} if it exists and is a boolean or
     * can be coerced to a boolean.
     *
     * @throws JSONException if the mapping doesn't exist or cannot be coerced
     *     to a boolean.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.409 -0500", hash_original_method = "7B38D2B2DBA3C433303B4D117D86E4E0", hash_generated_method = "524137AA97929B7940A3B37A4429C672")
    
public boolean getBoolean(String name) throws JSONException {
        Object object = get(name);
        Boolean result = JSON.toBoolean(object);
        if (result == null) {
            throw JSON.typeMismatch(name, object, "boolean");
        }
        return result;
    }

    /**
     * Returns the value mapped by {@code name} if it exists and is a boolean or
     * can be coerced to a boolean. Returns false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.412 -0500", hash_original_method = "3DA4544CD80345F7570489979490BD16", hash_generated_method = "01F5D58A3CC80D86DC11758B1A119246")
    
public boolean optBoolean(String name) {
        return optBoolean(name, false);
    }

    /**
     * Returns the value mapped by {@code name} if it exists and is a boolean or
     * can be coerced to a boolean. Returns {@code fallback} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.414 -0500", hash_original_method = "C49CAFC4CC69BC825D274D7317108A68", hash_generated_method = "05C748725A3CB7C08F5949A0674C8D6F")
    
public boolean optBoolean(String name, boolean fallback) {
        Object object = opt(name);
        Boolean result = JSON.toBoolean(object);
        return result != null ? result : fallback;
    }

    /**
     * Returns the value mapped by {@code name} if it exists and is a double or
     * can be coerced to a double.
     *
     * @throws JSONException if the mapping doesn't exist or cannot be coerced
     *     to a double.
     */
    @DSComment("nothing useful in String")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.417 -0500", hash_original_method = "0C60D6C72644A8965D87529BB9443348", hash_generated_method = "868253F442609340D6ABB43C2D6FF2A9")
    
public double getDouble(String name) throws JSONException {
        Object object = get(name);
        Double result = JSON.toDouble(object);
        if (result == null) {
            throw JSON.typeMismatch(name, object, "double");
        }
        return result;
    }

    /**
     * Returns the value mapped by {@code name} if it exists and is a double or
     * can be coerced to a double. Returns {@code NaN} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.420 -0500", hash_original_method = "B9CFB7D5CC2BB58B8CACB29638DEE6A6", hash_generated_method = "1A9685DE715E064E3792A984DA336D5A")
    
public double optDouble(String name) {
        return optDouble(name, Double.NaN);
    }

    /**
     * Returns the value mapped by {@code name} if it exists and is a double or
     * can be coerced to a double. Returns {@code fallback} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.422 -0500", hash_original_method = "F525E9AC5AAC714EA253692C6DC9EE0E", hash_generated_method = "E523F2A2D2C56DACA01D3466089BA96B")
    
public double optDouble(String name, double fallback) {
        Object object = opt(name);
        Double result = JSON.toDouble(object);
        return result != null ? result : fallback;
    }

    /**
     * Returns the value mapped by {@code name} if it exists and is an int or
     * can be coerced to an int.
     *
     * @throws JSONException if the mapping doesn't exist or cannot be coerced
     *     to an int.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.424 -0500", hash_original_method = "06DD6202AFC58B0F1BA6F9DBAA37C5F3", hash_generated_method = "79D5758DF600F70E8745D09754786AE5")
    
public int getInt(String name) throws JSONException {
        Object object = get(name);
        Integer result = JSON.toInteger(object);
        if (result == null) {
            throw JSON.typeMismatch(name, object, "int");
        }
        return result;
    }

    /**
     * Returns the value mapped by {@code name} if it exists and is an int or
     * can be coerced to an int. Returns 0 otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.427 -0500", hash_original_method = "CF8C56AE8C6952FAAA48007CA568A3BF", hash_generated_method = "60C88A9D3DDD51D4A572E81B6ED2CBF6")
    
public int optInt(String name) {
        return optInt(name, 0);
    }

    /**
     * Returns the value mapped by {@code name} if it exists and is an int or
     * can be coerced to an int. Returns {@code fallback} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.429 -0500", hash_original_method = "FC3121A883EAF5555BD9C194D7925D34", hash_generated_method = "F0BAA599A45C5FCD63DEB3DF8A52C135")
    
public int optInt(String name, int fallback) {
        Object object = opt(name);
        Integer result = JSON.toInteger(object);
        return result != null ? result : fallback;
    }

    /**
     * Returns the value mapped by {@code name} if it exists and is a long or
     * can be coerced to a long.
     *
     * @throws JSONException if the mapping doesn't exist or cannot be coerced
     *     to a long.
     */
    @DSComment("nothing useful in String")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.431 -0500", hash_original_method = "55ABC1042FFC5D7EF9272460461F1426", hash_generated_method = "059F3F609EB1191C057F2BD5A86A3CE9")
    
public long getLong(String name) throws JSONException {
        Object object = get(name);
        Long result = JSON.toLong(object);
        if (result == null) {
            throw JSON.typeMismatch(name, object, "long");
        }
        return result;
    }

    /**
     * Returns the value mapped by {@code name} if it exists and is a long or
     * can be coerced to a long. Returns 0 otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.434 -0500", hash_original_method = "70DEF89A3C807E0937F5C9E9E3A1A203", hash_generated_method = "AF003D32DC4FC73388EA649561F52E8E")
    
public long optLong(String name) {
        return optLong(name, 0L);
    }

    /**
     * Returns the value mapped by {@code name} if it exists and is a long or
     * can be coerced to a long. Returns {@code fallback} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.436 -0500", hash_original_method = "C94BC7D2B7352E7323E9E58C53ACE476", hash_generated_method = "BA6903E59331BA8DCBA1156A47217655")
    
public long optLong(String name, long fallback) {
        Object object = opt(name);
        Long result = JSON.toLong(object);
        return result != null ? result : fallback;
    }

    /**
     * Returns the value mapped by {@code name} if it exists, coercing it if
     * necessary.
     *
     * @throws JSONException if no such mapping exists.
     */
    @DSComment("nothing useful in String")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.438 -0500", hash_original_method = "CC649536AC568087B4414076D420F027", hash_generated_method = "533903449603AC67C297A20E00AF22B2")
    
public String getString(String name) throws JSONException {
        Object object = get(name);
        String result = JSON.toString(object);
        if (result == null) {
            throw JSON.typeMismatch(name, object, "String");
        }
        return result;
    }

    /**
     * Returns the value mapped by {@code name} if it exists, coercing it if
     * necessary. Returns the empty string if no such mapping exists.
     */
    @DSComment("nothing useful in String")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.440 -0500", hash_original_method = "8B81E5CBB6FE92C9270C8AE14E1D248D", hash_generated_method = "F5773F5DC0852199A08B06B771F3600E")
    
public String optString(String name) {
        return optString(name, "");
    }

    /**
     * Returns the value mapped by {@code name} if it exists, coercing it if
     * necessary. Returns {@code fallback} if no such mapping exists.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.443 -0500", hash_original_method = "B4BBF2951ACCBF79FD3FE8AB17DCAE83", hash_generated_method = "F33FCFE58BD646FEAE37CB8D0385E965")
    
public String optString(String name, String fallback) {
        Object object = opt(name);
        String result = JSON.toString(object);
        return result != null ? result : fallback;
    }

    /**
     * Returns the value mapped by {@code name} if it exists and is a {@code
     * JSONArray}.
     *
     * @throws JSONException if the mapping doesn't exist or is not a {@code
     *     JSONArray}.
     */
    @DSComment("nothing useful in String")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.446 -0500", hash_original_method = "1CE1CD2D1D65AA0859027B9575FA80C4", hash_generated_method = "BC318C84F4526F5E4A60A0591DB41663")
    
public JSONArray getJSONArray(String name) throws JSONException {
        Object object = get(name);
        if (object instanceof JSONArray) {
            return (JSONArray) object;
        } else {
            throw JSON.typeMismatch(name, object, "JSONArray");
        }
    }

    /**
     * Returns the value mapped by {@code name} if it exists and is a {@code
     * JSONArray}. Returns null otherwise.
     */
    @DSComment("nothing useful in String")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.448 -0500", hash_original_method = "576EFB0CB9E2FA91FCF1D9A3EF1337C6", hash_generated_method = "452F5371129242F4049DC0593B129F04")
    
public JSONArray optJSONArray(String name) {
        Object object = opt(name);
        return object instanceof JSONArray ? (JSONArray) object : null;
    }

    /**
     * Returns the value mapped by {@code name} if it exists and is a {@code
     * JSONObject}.
     *
     * @throws JSONException if the mapping doesn't exist or is not a {@code
     *     JSONObject}.
     */
    @DSComment("nothing useful in String")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.450 -0500", hash_original_method = "5326315C93466A3B1E8C695224A5B5FD", hash_generated_method = "B33196C99C5716D9B399C1894439B76D")
    
public JSONObject getJSONObject(String name) throws JSONException {
        Object object = get(name);
        if (object instanceof JSONObject) {
            return (JSONObject) object;
        } else {
            throw JSON.typeMismatch(name, object, "JSONObject");
        }
    }

    /**
     * Returns the value mapped by {@code name} if it exists and is a {@code
     * JSONObject}. Returns null otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.453 -0500", hash_original_method = "B736B3B7313026EC1CBB4CB1D3C2367D", hash_generated_method = "214345F3267DBAF77830DFE6EF28CDBF")
    
public JSONObject optJSONObject(String name) {
        Object object = opt(name);
        return object instanceof JSONObject ? (JSONObject) object : null;
    }

    /**
     * Returns an array with the values corresponding to {@code names}. The
     * array contains null for names that aren't mapped. This method returns
     * null if {@code names} is either null or empty.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.455 -0500", hash_original_method = "1E876AFA246F164144A4BA68FB0C8527", hash_generated_method = "2D62066BF60C70355710B22886888F09")
    
public JSONArray toJSONArray(JSONArray names) throws JSONException {
        JSONArray result = new JSONArray();
        if (names == null) {
            return null;
        }
        int length = names.length();
        if (length == 0) {
            return null;
        }
        for (int i = 0; i < length; i++) {
            String name = JSON.toString(names.opt(i));
            result.put(opt(name));
        }
        return result;
    }

    /**
     * Returns an iterator of the {@code String} names in this object. The
     * returned iterator supports {@link Iterator#remove() remove}, which will
     * remove the corresponding mapping from this object. If this object is
     * modified after the iterator is returned, the iterator's behavior is
     * undefined. The order of the keys is undefined.
     */
    /* Return a raw type for API compatibility */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.457 -0500", hash_original_method = "2D137981D66EA2E55940EA81187D393D", hash_generated_method = "80E0B753D76CFE501014C2F1B5565F29")
    
public Iterator keys() {
        return nameValuePairs.keySet().iterator();
    }

    /**
     * Returns an array containing the string names in this object. This method
     * returns null if this object contains no mappings.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.459 -0500", hash_original_method = "3ECE715C4DC492B6D08AC6D2EACB5C9C", hash_generated_method = "D3C877EA97EE198EBB16512ACEC3EFD7")
    
public JSONArray names() {
        return nameValuePairs.isEmpty()
                ? null
                : new JSONArray(new ArrayList<String>(nameValuePairs.keySet()));
    }

    /**
     * Encodes this object as a compact JSON string, such as:
     * <pre>{"query":"Pizza","locations":[94043,90210]}</pre>
     */
    @DSComment("no input, no suspicious activity")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.462 -0500", hash_original_method = "CC6BE78472EEEAF64E530CA9F9B14BB5", hash_generated_method = "000C0FCE86F8834F70EB7B14EA12E002")
    
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
     * Encodes this object as a human readable JSON string for debugging, such
     * as:
     * <pre>
     * {
     *     "query": "Pizza",
     *     "locations": [
     *         94043,
     *         90210
     *     ]
     * }</pre>
     *
     * @param indentSpaces the number of spaces to indent for each level of
     *     nesting.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.465 -0500", hash_original_method = "161CBAA0F7E505CC65BF62A9F4C8490E", hash_generated_method = "89736320EFA9E85B06F0454670E154AA")
    
public String toString(int indentSpaces) throws JSONException {
        JSONStringer stringer = new JSONStringer(indentSpaces);
        writeTo(stringer);
        return stringer.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:10.467 -0500", hash_original_method = "4318203F3538DC271461FDA2F00ABD52", hash_generated_method = "4318203F3538DC271461FDA2F00ABD52")
    
void writeTo(JSONStringer stringer) throws JSONException {
        stringer.object();
        for (Map.Entry<String, Object> entry : nameValuePairs.entrySet()) {
            stringer.key(entry.getKey()).value(entry.getValue());
        }
        stringer.endObject();
    }
    // orphaned legacy method
    @Override public boolean equals(Object o) {
            return o == this || o == null; 
        }
    
}

