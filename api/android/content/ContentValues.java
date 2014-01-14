package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import android.os.Parcel;
import android.os.Parcelable;

public final class ContentValues implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.386 -0500", hash_original_field = "0343975A9178EED731F3644B77817EE1", hash_generated_field = "AB3063BFEEBD1A5014F8E7157F8C6CDE")

    public static final String TAG = "ContentValues";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.386 -0400", hash_original_field = "4984E8C692C60517E25A1E921D4F008F", hash_generated_field = "507973BFDDF20607CD005815DB6B91C3")

    public static final Parcelable.Creator<ContentValues> CREATOR =
            new Parcelable.Creator<ContentValues>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.466 -0500", hash_original_method = "408F12EF384AFD72C1D92CDACF4EC38C", hash_generated_method = "A371E979F18D3337928B454C76A92DA5")
        
@SuppressWarnings({"deprecation", "unchecked"})
        public ContentValues createFromParcel(Parcel in) {
            // TODO - what ClassLoader should be passed to readHashMap?
            HashMap<String, Object> values = in.readHashMap(null);
            return new ContentValues(values);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.468 -0500", hash_original_method = "E7BE33AD94ACBD14D20A573DAFF34DE4", hash_generated_method = "2D0C2B6770913EABA40EBFC2659569A1")
        
public ContentValues[] newArray(int size) {
            return new ContentValues[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.388 -0500", hash_original_field = "039B8A7F5562BA2021E6CE00D5DF9B9F", hash_generated_field = "6A0C6DC1A4312984791FEB326F38FF7D")

    private HashMap<String, Object> mValues;

    /**
     * Creates an empty set of values using the default initial size
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.390 -0500", hash_original_method = "5E7EA6E1821501C5972B7C7CC639145B", hash_generated_method = "D260892D300891C4FE19BE87A93B10A6")
    
public ContentValues() {
        // Choosing a default size of 8 based on analysis of typical
        // consumption by applications.
        mValues = new HashMap<String, Object>(8);
    }

    /**
     * Creates an empty set of values using the given initial size
     *
     * @param size the initial size of the set of values
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.392 -0500", hash_original_method = "8E588067C2537376173067FE549DA446", hash_generated_method = "2E6215BF8A605EB938132E1331B9ECE3")
    
public ContentValues(int size) {
        mValues = new HashMap<String, Object>(size, 1.0f);
    }

    /**
     * Creates a set of values copied from the given set
     *
     * @param from the values to copy
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.395 -0500", hash_original_method = "6386ACC7AEA70584EF32F8CAA1BD0C6A", hash_generated_method = "92AFC2541FA7884B51844D8D4C94ACE3")
    
public ContentValues(ContentValues from) {
        mValues = new HashMap<String, Object>(from.mValues);
    }

    /**
     * Creates a set of values copied from the given HashMap. This is used
     * by the Parcel unmarshalling code.
     *
     * @param values the values to start with
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.398 -0500", hash_original_method = "79B820032F5D7F722A5DF12324BC548A", hash_generated_method = "5E252719E39637156C8BAC11C1AC30FD")
    
private ContentValues(HashMap<String, Object> values) {
        mValues = values;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.401 -0500", hash_original_method = "B119129681FC05E44686163A6A753063", hash_generated_method = "CA9A0B792F9EB3DA75443922B274F1F5")
    
@Override
    public boolean equals(Object object) {
        if (!(object instanceof ContentValues)) {
            return false;
        }
        return mValues.equals(((ContentValues) object).mValues);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.403 -0500", hash_original_method = "61C7B1D258FDF4A8DE4F58009B844658", hash_generated_method = "8D922C89C140B0009A3734D07F3FE687")
    
@Override
    public int hashCode() {
        return mValues.hashCode();
    }

    /**
     * Adds a value to the set.
     *
     * @param key the name of the value to put
     * @param value the data for the value to put
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.405 -0500", hash_original_method = "65B11A528910ED48D0A8C0B3A81DCA11", hash_generated_method = "B5C901E1F01EEDB880F526FCDBB68387")
    
public void put(String key, String value) {
        mValues.put(key, value);
    }

    /**
     * Adds all values from the passed in ContentValues.
     *
     * @param other the ContentValues from which to copy
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.407 -0500", hash_original_method = "0A271D2A4C7890E9466C28EF447DC416", hash_generated_method = "E1A375CD5D20AF529A55BF1855FAA640")
    
public void putAll(ContentValues other) {
        mValues.putAll(other.mValues);
    }

    /**
     * Adds a value to the set.
     *
     * @param key the name of the value to put
     * @param value the data for the value to put
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.409 -0500", hash_original_method = "46309CD6AABC048E549ED8D367B97222", hash_generated_method = "3AC3EEB729C4601EC06C6443D14BA600")
    
public void put(String key, Byte value) {
        mValues.put(key, value);
    }

    /**
     * Adds a value to the set.
     *
     * @param key the name of the value to put
     * @param value the data for the value to put
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.411 -0500", hash_original_method = "19B45CF10C6274AA18ED4281EBB4A7D5", hash_generated_method = "7097D4FC5474B218D98D39DBDCF261FE")
    
public void put(String key, Short value) {
        mValues.put(key, value);
    }

    /**
     * Adds a value to the set.
     *
     * @param key the name of the value to put
     * @param value the data for the value to put
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.413 -0500", hash_original_method = "519D763DA29CBC7E3659F73066396076", hash_generated_method = "8B8E1E074EA3F65B4B1F9E5DDE6B2927")
    
public void put(String key, Integer value) {
        mValues.put(key, value);
    }

    /**
     * Adds a value to the set.
     *
     * @param key the name of the value to put
     * @param value the data for the value to put
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.416 -0500", hash_original_method = "68C6754D41E6DE24B60EFC88A41FDF20", hash_generated_method = "6D544EC8491E760D52C3029F0A93F4D4")
    
public void put(String key, Long value) {
        mValues.put(key, value);
    }

    /**
     * Adds a value to the set.
     *
     * @param key the name of the value to put
     * @param value the data for the value to put
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.418 -0500", hash_original_method = "66DA1C106B1B7F2AFB03D110B785A501", hash_generated_method = "2C261E0300BC82829635A8C7705EBEBA")
    
public void put(String key, Float value) {
        mValues.put(key, value);
    }

    /**
     * Adds a value to the set.
     *
     * @param key the name of the value to put
     * @param value the data for the value to put
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.420 -0500", hash_original_method = "1050A4E9D6DF2BBB4B07F9E50B35502F", hash_generated_method = "114BF55AC26E62B9CA474044AEB4178D")
    
public void put(String key, Double value) {
        mValues.put(key, value);
    }

    /**
     * Adds a value to the set.
     *
     * @param key the name of the value to put
     * @param value the data for the value to put
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.422 -0500", hash_original_method = "C35988B4D54806692C616FB01B8C7793", hash_generated_method = "85E7BF1BC6441FD82F6063C8524910C6")
    
public void put(String key, Boolean value) {
        mValues.put(key, value);
    }

    /**
     * Adds a value to the set.
     *
     * @param key the name of the value to put
     * @param value the data for the value to put
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.424 -0500", hash_original_method = "79D16814F7AC00D5B324C095EC421557", hash_generated_method = "E5447840A038CF6FF4B838DA64F9014B")
    
public void put(String key, byte[] value) {
        mValues.put(key, value);
    }

    /**
     * Adds a null value to the set.
     *
     * @param key the name of the value to make null
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.425 -0500", hash_original_method = "8F0D800F5C28B5CCC219C4767FE49E89", hash_generated_method = "6ECD2A3AC7C93E2D73067B2282916525")
    
public void putNull(String key) {
        mValues.put(key, null);
    }

    /**
     * Returns the number of values.
     *
     * @return the number of values
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.427 -0500", hash_original_method = "C7AE6CE1280D5E080A32F66907E851BD", hash_generated_method = "630AC021B3D713F59B111AFE3453A52E")
    
public int size() {
        return mValues.size();
    }

    /**
     * Remove a single value.
     *
     * @param key the name of the value to remove
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.430 -0500", hash_original_method = "377B4DB42071C90137241E64BA4CBF0D", hash_generated_method = "4DC03058BC1F180FEA26F342760300F9")
    
public void remove(String key) {
        mValues.remove(key);
    }

    /**
     * Removes all values.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.432 -0500", hash_original_method = "08286611C689211C8F9484889D0FA29C", hash_generated_method = "764A54F9EBB9194B4D91349716380299")
    
public void clear() {
        mValues.clear();
    }

    /**
     * Returns true if this object has the named value.
     *
     * @param key the value to check for
     * @return {@code true} if the value is present, {@code false} otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.434 -0500", hash_original_method = "26760966C3F3EED5AADC7592B64BFAAE", hash_generated_method = "3612599B770562FC03F7BB50A809B2D4")
    
public boolean containsKey(String key) {
        return mValues.containsKey(key);
    }

    /**
     * Gets a value. Valid value types are {@link String}, {@link Boolean}, and
     * {@link Number} implementations.
     *
     * @param key the value to get
     * @return the data for the value
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.437 -0500", hash_original_method = "F0AF95EE9AB5B022FDA3C4DAA44F68C1", hash_generated_method = "90455CF295F390F2AAF28D8F1514C03B")
    
public Object get(String key) {
        return mValues.get(key);
    }

    /**
     * Gets a value and converts it to a String.
     *
     * @param key the value to get
     * @return the String for the value
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.439 -0500", hash_original_method = "FD6B0B33BC77B5F3D2D2C6DE92834A83", hash_generated_method = "7199169D6D2219FAEE1D4C15DF024A82")
    
public String getAsString(String key) {
        Object value = mValues.get(key);
        return value != null ? value.toString() : null;
    }

    /**
     * Gets a value and converts it to a Long.
     *
     * @param key the value to get
     * @return the Long value, or null if the value is missing or cannot be converted
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.442 -0500", hash_original_method = "50D64D5E49DC2F013CFC471F23AA3A1E", hash_generated_method = "90B4436A7B4E83B6B4974647F5D4E892")
    
public Long getAsLong(String key) {
        Object value = mValues.get(key);
        try {
            return value != null ? ((Number) value).longValue() : null;
        } catch (ClassCastException e) {
            if (value instanceof CharSequence) {
                try {
                    return Long.valueOf(value.toString());
                } catch (NumberFormatException e2) {
                    Log.e(TAG, "Cannot parse Long value for " + value + " at key " + key);
                    return null;
                }
            } else {
                Log.e(TAG, "Cannot cast value for " + key + " to a Long: " + value, e);
                return null;
            }
        }
    }

    /**
     * Gets a value and converts it to an Integer.
     *
     * @param key the value to get
     * @return the Integer value, or null if the value is missing or cannot be converted
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.444 -0500", hash_original_method = "C11C55EBF0D230069C8558AD456DF6B2", hash_generated_method = "BC9A5C1FBC18FEA67B7B9944B7CC111E")
    
public Integer getAsInteger(String key) {
        Object value = mValues.get(key);
        try {
            return value != null ? ((Number) value).intValue() : null;
        } catch (ClassCastException e) {
            if (value instanceof CharSequence) {
                try {
                    return Integer.valueOf(value.toString());
                } catch (NumberFormatException e2) {
                    Log.e(TAG, "Cannot parse Integer value for " + value + " at key " + key);
                    return null;
                }
            } else {
                Log.e(TAG, "Cannot cast value for " + key + " to a Integer: " + value, e);
                return null;
            }
        }
    }

    /**
     * Gets a value and converts it to a Short.
     *
     * @param key the value to get
     * @return the Short value, or null if the value is missing or cannot be converted
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.447 -0500", hash_original_method = "20021B08C31B81AF996FD4C57E428DFB", hash_generated_method = "084F1A93407BB3F10DFA05ACD68140DA")
    
public Short getAsShort(String key) {
        Object value = mValues.get(key);
        try {
            return value != null ? ((Number) value).shortValue() : null;
        } catch (ClassCastException e) {
            if (value instanceof CharSequence) {
                try {
                    return Short.valueOf(value.toString());
                } catch (NumberFormatException e2) {
                    Log.e(TAG, "Cannot parse Short value for " + value + " at key " + key);
                    return null;
                }
            } else {
                Log.e(TAG, "Cannot cast value for " + key + " to a Short: " + value, e);
                return null;
            }
        }
    }

    /**
     * Gets a value and converts it to a Byte.
     *
     * @param key the value to get
     * @return the Byte value, or null if the value is missing or cannot be converted
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.449 -0500", hash_original_method = "10A45AB5E2B4A25109E88A986B8ABD1E", hash_generated_method = "ED03B4A9267748BD386793EE3BAD47CE")
    
public Byte getAsByte(String key) {
        Object value = mValues.get(key);
        try {
            return value != null ? ((Number) value).byteValue() : null;
        } catch (ClassCastException e) {
            if (value instanceof CharSequence) {
                try {
                    return Byte.valueOf(value.toString());
                } catch (NumberFormatException e2) {
                    Log.e(TAG, "Cannot parse Byte value for " + value + " at key " + key);
                    return null;
                }
            } else {
                Log.e(TAG, "Cannot cast value for " + key + " to a Byte: " + value, e);
                return null;
            }
        }
    }

    /**
     * Gets a value and converts it to a Double.
     *
     * @param key the value to get
     * @return the Double value, or null if the value is missing or cannot be converted
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.451 -0500", hash_original_method = "43D54EF438725B45BE89593CD2466062", hash_generated_method = "9087EB4791921E8CA3FA63C865DF0C3B")
    
public Double getAsDouble(String key) {
        Object value = mValues.get(key);
        try {
            return value != null ? ((Number) value).doubleValue() : null;
        } catch (ClassCastException e) {
            if (value instanceof CharSequence) {
                try {
                    return Double.valueOf(value.toString());
                } catch (NumberFormatException e2) {
                    Log.e(TAG, "Cannot parse Double value for " + value + " at key " + key);
                    return null;
                }
            } else {
                Log.e(TAG, "Cannot cast value for " + key + " to a Double: " + value, e);
                return null;
            }
        }
    }

    /**
     * Gets a value and converts it to a Float.
     *
     * @param key the value to get
     * @return the Float value, or null if the value is missing or cannot be converted
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.454 -0500", hash_original_method = "72E58B472E78C1EB7239E330F6CA9313", hash_generated_method = "1A6A710378117929D6B8B9AF9163C405")
    
public Float getAsFloat(String key) {
        Object value = mValues.get(key);
        try {
            return value != null ? ((Number) value).floatValue() : null;
        } catch (ClassCastException e) {
            if (value instanceof CharSequence) {
                try {
                    return Float.valueOf(value.toString());
                } catch (NumberFormatException e2) {
                    Log.e(TAG, "Cannot parse Float value for " + value + " at key " + key);
                    return null;
                }
            } else {
                Log.e(TAG, "Cannot cast value for " + key + " to a Float: " + value, e);
                return null;
            }
        }
    }

    /**
     * Gets a value and converts it to a Boolean.
     *
     * @param key the value to get
     * @return the Boolean value, or null if the value is missing or cannot be converted
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.456 -0500", hash_original_method = "26BA447DF201321FA24067450431D916", hash_generated_method = "C83DDB57478ED2772F3D0A5353558170")
    
public Boolean getAsBoolean(String key) {
        Object value = mValues.get(key);
        try {
            return (Boolean) value;
        } catch (ClassCastException e) {
            if (value instanceof CharSequence) {
                return Boolean.valueOf(value.toString());
            } else if (value instanceof Number) {
                return ((Number) value).intValue() != 0;
            } else {
                Log.e(TAG, "Cannot cast value for " + key + " to a Boolean: " + value, e);
                return null;
            }
        }
    }

    /**
     * Gets a value that is a byte array. Note that this method will not convert
     * any other types to byte arrays.
     *
     * @param key the value to get
     * @return the byte[] value, or null is the value is missing or not a byte[]
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.458 -0500", hash_original_method = "A780551E0EA49FF2BF74805BA852B981", hash_generated_method = "E1A8731A3C9ABAE4601BA2A77AFB6F0D")
    
public byte[] getAsByteArray(String key) {
        Object value = mValues.get(key);
        if (value instanceof byte[]) {
            return (byte[]) value;
        } else {
            return null;
        }
    }

    /**
     * Returns a set of all of the keys and values
     *
     * @return a set of all of the keys and values
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.461 -0500", hash_original_method = "CB190561C8A3BAECAF3D6E789BEEE6E0", hash_generated_method = "E931700C85A5C713A2383C3DAB6619FE")
    
public Set<Map.Entry<String, Object>> valueSet() {
        return mValues.entrySet();
    }

    /**
     * Returns a set of all of the keys
     *
     * @return a set of all of the keys
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.463 -0500", hash_original_method = "424C133E0D7FEE4B423B7AD7977A2226", hash_generated_method = "62D31CA182F4473486D8FA372AA8A524")
    
public Set<String> keySet() {
        return mValues.keySet();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.472 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.476 -0500", hash_original_method = "2C0F18C86DFE76C8F92DFC9EBC596E26", hash_generated_method = "D50600D319BBE332CB539A601CA15601")
    
@SuppressWarnings("deprecation")
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeMap(mValues);
    }

    /**
     * Unsupported, here until we get proper bulk insert APIs.
     * {@hide}
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.478 -0500", hash_original_method = "F9E2AE250F36F443A2E1239B6C3C3E6F", hash_generated_method = "C94896E04D024940261C2C2CF36C6B93")
    
@Deprecated
    public void putStringArrayList(String key, ArrayList<String> value) {
        mValues.put(key, value);
    }

    /**
     * Unsupported, here until we get proper bulk insert APIs.
     * {@hide}
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.481 -0500", hash_original_method = "F231C09776862BE2F464FBA056529E22", hash_generated_method = "F471723AB710D2C54B4BF56C2AE02468")
    
@SuppressWarnings("unchecked")
    @Deprecated
    public ArrayList<String> getStringArrayList(String key) {
        return (ArrayList<String>) mValues.get(key);
    }

    /**
     * Returns a string containing a concise, human-readable description of this object.
     * @return a printable representation of this object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.483 -0500", hash_original_method = "7B4B42E004B10F53CC96D4FD27076B59", hash_generated_method = "EC8B35621884B7BF7FC98A2548C7EE22")
    
@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String name : mValues.keySet()) {
            String value = getAsString(name);
            if (sb.length() > 0) sb.append(" ");
            sb.append(name + "=" + value);
        }
        return sb.toString();
    }
    // orphaned legacy method
    @SuppressWarnings({"deprecation", "unchecked"})
        public ContentValues createFromParcel(Parcel in) {
            
            HashMap<String, Object> values = in.readHashMap(null);
            return new ContentValues(values);
        }
    
    // orphaned legacy method
    public ContentValues[] newArray(int size) {
            return new ContentValues[size];
        }
    
}

