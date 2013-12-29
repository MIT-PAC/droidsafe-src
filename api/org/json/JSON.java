package org.json;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;




class JSON {
    /**
     * Returns the input if it is a JSON-permissible value; throws otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:49.241 -0500", hash_original_method = "40B9B88AE9C997D470FB8A7E1F30A2A6", hash_generated_method = "4DA799B304D2EBD5CA034D9B03546CD7")
    static double checkDouble(double d) throws JSONException {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new JSONException("Forbidden numeric value: " + d);
        }
        return d;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:49.242 -0500", hash_original_method = "1690CD7CDB87D93EC639ABF2ED99A913", hash_generated_method = "3AA083F73CC8B0CB362E069D65E2707B")
    static Boolean toBoolean(Object value) {
        if (value instanceof Boolean) {
            return (Boolean) value;
        } else if (value instanceof String) {
            String stringValue = (String) value;
            if ("true".equalsIgnoreCase(stringValue)) {
                return true;
            } else if ("false".equalsIgnoreCase(stringValue)) {
                return false;
            }
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:49.243 -0500", hash_original_method = "AFF454103C119AFC508A52EBC7A32A8D", hash_generated_method = "65ECAE8148DC88D4FE86B8C98798490B")
    static Double toDouble(Object value) {
        if (value instanceof Double) {
            return (Double) value;
        } else if (value instanceof Number) {
            return ((Number) value).doubleValue();
        } else if (value instanceof String) {
            try {
                return Double.valueOf((String) value);
            } catch (NumberFormatException ignored) {
            }
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:49.244 -0500", hash_original_method = "F094A4531B91B94D45315D9341A51176", hash_generated_method = "7AC53F70780CD1B4EFEA6FDCB0A40B11")
    static Integer toInteger(Object value) {
        if (value instanceof Integer) {
            return (Integer) value;
        } else if (value instanceof Number) {
            return ((Number) value).intValue();
        } else if (value instanceof String) {
            try {
                return (int) Double.parseDouble((String) value);
            } catch (NumberFormatException ignored) {
            }
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:49.245 -0500", hash_original_method = "E9C67AE95C755C19F008A641AD2EF137", hash_generated_method = "95E062C6BED64610737FE77A3023AE73")
    static Long toLong(Object value) {
        if (value instanceof Long) {
            return (Long) value;
        } else if (value instanceof Number) {
            return ((Number) value).longValue();
        } else if (value instanceof String) {
            try {
                return (long) Double.parseDouble((String) value);
            } catch (NumberFormatException ignored) {
            }
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:49.245 -0500", hash_original_method = "9BEC766C13A121BBE28CDFD990BC25A8", hash_generated_method = "C486809F4B66EAB2F0A489AAE58C4E64")
    static String toString(Object value) {
        if (value instanceof String) {
            return (String) value;
        } else if (value != null) {
            return String.valueOf(value);
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:49.246 -0500", hash_original_method = "FEFA7A5B23BC7533FFD2F4A3E3642CAF", hash_generated_method = "B37447FBEAB2976112A49052FA217516")
    public static JSONException typeMismatch(Object indexOrName, Object actual,
            String requiredType) throws JSONException {
        if (actual == null) {
            throw new JSONException("Value at " + indexOrName + " is null.");
        } else {
            throw new JSONException("Value " + actual + " at " + indexOrName
                    + " of type " + actual.getClass().getName()
                    + " cannot be converted to " + requiredType);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:49.247 -0500", hash_original_method = "3D83B7FB3783F4573A2174D8F21F3C63", hash_generated_method = "6FA608E0825D619A33E40CE0ED567576")
    public static JSONException typeMismatch(Object actual, String requiredType)
            throws JSONException {
        if (actual == null) {
            throw new JSONException("Value is null.");
        } else {
            throw new JSONException("Value " + actual
                    + " of type " + actual.getClass().getName()
                    + " cannot be converted to " + requiredType);
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.206 -0400", hash_original_method = "4E4E4AE7CF91B852034C25B487459E58", hash_generated_method = "4E4E4AE7CF91B852034C25B487459E58")
    public JSON ()
    {
        //Synthesized constructor
    }

    
}

