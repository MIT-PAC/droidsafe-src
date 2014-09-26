package java.lang.reflect;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public final class Array {

    /**
     * Returns the element of the array at the specified index. This reproduces
     * the effect of {@code array[index]}. If the array component is a primitive
     * type, the result is automatically boxed.
     *
     * @param array
     *            the array
     * @param index
     *            the index
     *
     * @return the requested element, possibly boxed
     *
     * @throws NullPointerException
     *             if the array is null
     * @throws IllegalArgumentException
     *             if {@code array} is not an array
     * @throws ArrayIndexOutOfBoundsException
     *             if {@code  index < 0 || index >= array.length}
     */
    @DSComment("Java language reflection")
    @DSBan(DSCat.REFLECTION)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.893 -0500", hash_original_method = "DC819166ADE9A9BB796EBD77364A49D8", hash_generated_method = "B57FA28A23A3CBE2087765A9CBD0CB7A")
    
public static Object get(Object array, int index)
            throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof Object[])
            return ((Object[]) array)[index];

        if (array instanceof boolean[])
            return ((boolean[]) array)[index] ? Boolean.TRUE : Boolean.FALSE;

        if (array instanceof byte[])
            return Byte.valueOf(((byte[]) array)[index]);

        if (array instanceof char[])
            return Character.valueOf(((char[]) array)[index]);

        if (array instanceof short[])
            return Short.valueOf(((short[]) array)[index]);

        if (array instanceof int[])
            return Integer.valueOf(((int[]) array)[index]);

        if (array instanceof long[])
            return Long.valueOf(((long[]) array)[index]);

        if (array instanceof float[])
            return new Float(((float[]) array)[index]);

        if (array instanceof double[])
            return new Double(((double[]) array)[index]);

        if (array == null)
            throw new NullPointerException();

        throw new IllegalArgumentException("Not an array");
    }

    /**
     * Returns the element of the array at the specified index, converted to a
     * {@code boolean}, if possible. This reproduces the effect of {@code
     * array[index]}
     *
     * @param array
     *            the array
     * @param index
     *            the index
     *
     * @return the requested element
     *
     * @throws NullPointerException
     *             if the {@code array} is {@code null}
     * @throws IllegalArgumentException
     *             if {@code array} is not an array or the element at the
     *             index position can not be converted to the return type
     * @throws ArrayIndexOutOfBoundsException
     *             if {@code index < 0 || index >= array.length}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.897 -0500", hash_original_method = "4FBA4EB2136CE3D0A944EBC9D223B8AB", hash_generated_method = "867DD4BF2D81B80067BF55D8AE1A6CF1")
    
public static boolean getBoolean(Object array, int index)
            throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof boolean[]) {
            return ((boolean[]) array)[index];
        } else if (array == null) {
            throw new NullPointerException();
        } else if (array.getClass().isArray()) {
            throw new IllegalArgumentException("Wrong array type");
        } else {
            throw new IllegalArgumentException("Not an array");
        }
    }

    /**
     * Returns the element of the array at the specified index, converted to a
     * {@code byte}, if possible. This reproduces the effect of {@code
     * array[index]}
     *
     * @param array
     *            the array
     * @param index
     *            the index
     *
     * @return the requested element
     *
     * @throws NullPointerException
     *             if the {@code array} is {@code null}
     * @throws IllegalArgumentException
     *             if {@code array} is not an array or the element at the
     *             index position can not be converted to the return type
     * @throws ArrayIndexOutOfBoundsException
     *             if {@code index < 0 || index >= array.length}
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.900 -0500", hash_original_method = "B4311492402F851EAEF8E66ECE236930", hash_generated_method = "0AA22A962031A2D97CA8C12D8E0949C4")
    
public static byte getByte(Object array, int index)
            throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof byte[]) {
            return ((byte[]) array)[index];
        } else {
            return getBoolean(array, index) ? (byte)1 : (byte)0;
        }
    }

    /**
     * Returns the element of the array at the specified index, converted to a
     * {@code char}, if possible. This reproduces the effect of {@code
     * array[index]}
     *
     * @param array
     *            the array
     * @param index
     *            the index
     *
     * @return the requested element
     *
     * @throws NullPointerException
     *             if the {@code array} is {@code null}
     * @throws IllegalArgumentException
     *             if {@code array} is not an array or the element at the
     *             index position can not be converted to the return type
     * @throws ArrayIndexOutOfBoundsException
     *             if {@code index < 0 || index >= array.length}
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.903 -0500", hash_original_method = "F9750F8D4DCE07008B25C7B9487F8814", hash_generated_method = "B86F3A445EE7F35813E9E5F6EC113BD4")
    
public static char getChar(Object array, int index)
            throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof char[]) {
            return ((char[]) array)[index];
        } else if (array == null) {
            throw new NullPointerException();
        } else if (array.getClass().isArray()) {
            throw new IllegalArgumentException("Wrong array type");
        } else {
            throw new IllegalArgumentException("Not an array");
        }
    }

    /**
     * Returns the element of the array at the specified index, converted to a
     * {@code double}, if possible. This reproduces the effect of {@code
     * array[index]}
     *
     * @param array
     *            the array
     * @param index
     *            the index
     *
     * @return the requested element
     *
     * @throws NullPointerException
     *             if the {@code array} is {@code null}
     * @throws IllegalArgumentException
     *             if {@code array} is not an array or the element at the
     *             index position can not be converted to the return type
     * @throws ArrayIndexOutOfBoundsException
     *             if {@code index < 0 || index >= array.length}
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.905 -0500", hash_original_method = "50790AF08E26146F4B35A5889C5B3E01", hash_generated_method = "7CEC4F3CC0D7EEC9D77535675F4D890C")
    
public static double getDouble(Object array, int index)
            throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof double[]) {
            return ((double[]) array)[index];
        } else {
            return getFloat(array, index);
        }
    }

    /**
     * Returns the element of the array at the specified index, converted to a
     * {@code float}, if possible. This reproduces the effect of {@code
     * array[index]}
     *
     * @param array
     *            the array
     * @param index
     *            the index
     *
     * @return the requested element
     *
     * @throws NullPointerException
     *             if the {@code array} is {@code null}
     * @throws IllegalArgumentException
     *             if {@code array} is not an array or the element at the
     *             index position can not be converted to the return type
     * @throws ArrayIndexOutOfBoundsException
     *             if {@code index < 0 || index >= array.length}
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.908 -0500", hash_original_method = "688EF8AB88B411AE551AED0281953294", hash_generated_method = "A8F4F4E7676F5C9C1F8E4194AA6B6DDD")
    
public static float getFloat(Object array, int index)
            throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof float[]) {
            return ((float[]) array)[index];
        } else {
            return getLong(array, index);
        }
    }

    /**
     * Returns the element of the array at the specified index, converted to an
     * {@code int}, if possible. This reproduces the effect of {@code
     * array[index]}
     *
     * @param array
     *            the array
     * @param index
     *            the index
     *
     * @return the requested element
     *
     * @throws NullPointerException
     *             if the {@code array} is {@code null}
     * @throws IllegalArgumentException
     *             if {@code array} is not an array or the element at the
     *             index position can not be converted to the return type
     * @throws ArrayIndexOutOfBoundsException
     *             if {@code index < 0 || index >= array.length}
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.911 -0500", hash_original_method = "5A8557FDE3B2AD2419DCA0873E4EC2DB", hash_generated_method = "BCBA513CC2B7EC43A10E7622F59DDF67")
    
public static int getInt(Object array, int index)
            throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof int[]) {
            return ((int[]) array)[index];
        } else {
            return getShort(array, index);
        }
    }

    /**
     * Returns the length of the array. This reproduces the effect of {@code
     * array.length}
     *
     * @param array
     *            the array
     *
     * @return the length of the array
     *
     * @throws NullPointerException
     *             if the {@code array} is {@code null}
     * @throws IllegalArgumentException
     *             if {@code array} is not an array
     */
    @DSComment("Java language reflection")
    @DSBan(DSCat.REFLECTION)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.914 -0500", hash_original_method = "01924EF6E2610B26238572C631DDDD41", hash_generated_method = "09C4DE3DCD0A88FB68A0D99BE393988C")
    
public static int getLength(Object array) {
        if (array instanceof Object[])
            return ((Object[]) array).length;

        if (array instanceof boolean[])
            return ((boolean[]) array).length;

        if (array instanceof byte[])
            return ((byte[]) array).length;

        if (array instanceof char[])
            return ((char[]) array).length;

        if (array instanceof short[])
            return ((short[]) array).length;

        if (array instanceof int[])
            return ((int[]) array).length;

        if (array instanceof long[])
            return ((long[]) array).length;

        if (array instanceof float[])
            return ((float[]) array).length;

        if (array instanceof double[])
            return ((double[]) array).length;

        if (array == null)
            throw new NullPointerException();

        throw new IllegalArgumentException("Not an array");
    }

    /**
     * Returns the element of the array at the specified index, converted to a
     * {@code long}, if possible. This reproduces the effect of {@code
     * array[index]}
     *
     * @param array
     *            the array
     * @param index
     *            the index
     *
     * @return the requested element
     *
     * @throws NullPointerException
     *             if the {@code array} is {@code null}
     * @throws IllegalArgumentException
     *             if {@code array} is not an array or the element at the
     *             index position can not be converted to the return type
     * @throws ArrayIndexOutOfBoundsException
     *             if {@code index < 0 || index >= array.length}
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.917 -0500", hash_original_method = "5A35E5A70189A9661FDF585F087D7AAE", hash_generated_method = "B619311A3C57FCC2206E764058DE5993")
    
public static long getLong(Object array, int index)
            throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof long[]) {
            return ((long[]) array)[index];
        } else {
            return getInt(array, index);
        }
    }

    /**
     * Returns the element of the array at the specified index, converted to a
     * {@code short}, if possible. This reproduces the effect of {@code
     * array[index]}
     *
     * @param array
     *            the array
     * @param index
     *            the index
     *
     * @return the requested element
     *
     * @throws NullPointerException
     *             if the {@code array} is {@code null}
     * @throws IllegalArgumentException
     *             if {@code array} is not an array or the element at the
     *             index position can not be converted to the return type
     * @throws ArrayIndexOutOfBoundsException
     *             if {@code index < 0 || index >= array.length}
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.919 -0500", hash_original_method = "4F5B502567D6D9A0FE26CC3AAC82FB87", hash_generated_method = "21D028DC552E779A896D9EBBA6CBF3EF")
    
public static short getShort(Object array, int index)
            throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof short[])
            return ((short[]) array)[index];

        return getByte(array, index);
    }

    /**
     * Returns a new multidimensional array of the specified component type and
     * dimensions. This reproduces the effect of {@code new
     * componentType[d0][d1]...[dn]} for a dimensions array of { d0, d1, ... ,
     * dn }.
     *
     * @param componentType
     *            the component type of the new array
     * @param dimensions
     *            the dimensions of the new array
     *
     * @return the new array
     *
     * @throws NullPointerException
     *             if the component type is {@code null}
     * @throws NegativeArraySizeException
     *             if any of the dimensions are negative
     * @throws IllegalArgumentException
     *             if the array of dimensions is of size zero, or exceeds the
     *             limit of the number of dimension for an array (currently 255)
     */
    @DSComment("Refelction/class loader")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.922 -0500", hash_original_method = "9C554BC8C0AA11B64E6653FCAA15C2E7", hash_generated_method = "4A9297550B4F9160675971DAFB19C3B9")
    
public static Object newInstance(Class<?> componentType, int... dimensions)
            throws NegativeArraySizeException, IllegalArgumentException {
        if (dimensions.length <= 0 || dimensions.length > 255)
            throw new IllegalArgumentException("Bad number of dimensions");

        if (componentType == void.class)
            throw new IllegalArgumentException();

        if (componentType == null)
            throw new NullPointerException();

        return createMultiArray(componentType, dimensions);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static Object createMultiArray(Class<?> componentType,
        int[] dimensions) throws NegativeArraySizeException {
    	Object ret = new Object();
    	ret.addTaint(componentType.getTaint());
    	ret.addTaint(dimensions[0]);
    	return ret;
    }

    /**
     * Returns a new array of the specified component type and length. This
     * reproduces the effect of {@code new componentType[size]}.
     *
     * @param componentType
     *            the component type of the new array
     * @param size
     *            the length of the new array
     *
     * @return the new array
     *
     * @throws NullPointerException
     *             if the component type is null
     * @throws NegativeArraySizeException
     *             if {@code size < 0}
     */
    @DSComment("Refelction/class loader")
    @DSSafe(DSCat.REFLECTION)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.930 -0500", hash_original_method = "8C1FC94B96B7DFB690D4B009645E9D92", hash_generated_method = "7B175AE1219E00BE34100EB87DDF9825")
    
public static Object newInstance(Class<?> componentType, int size)
            throws NegativeArraySizeException {
        if (!componentType.isPrimitive()) {
            return createObjectArray(componentType, size);
        }
        if (componentType == boolean.class) {
            return new boolean[size];
        }
        if (componentType == byte.class) {
            return new byte[size];
        }
        if (componentType == char.class) {
            return new char[size];
        }
        if (componentType == short.class) {
            return new short[size];
        }
        if (componentType == int.class) {
            return new int[size];
        }
        if (componentType == long.class) {
            return new long[size];
        }
        if (componentType == float.class) {
            return new float[size];
        }
        if (componentType == double.class) {
            return new double[size];
        }
        if (componentType == void.class) {
            throw new IllegalArgumentException();
        }
        throw new AssertionError();
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static Object createObjectArray(Class<?> componentType,
        int length) throws NegativeArraySizeException {
    	Object ret = new Object();
    	ret.addTaint(componentType.getTaint());
    	ret.addTaint(length);
    	return ret;
    }

    /**
     * Sets the element of the array at the specified index to the value. This
     * reproduces the effect of {@code array[index] = value}. If the array
     * component is a primitive type, the value is automatically unboxed.
     *
     * @param array
     *            the array
     * @param index
     *            the index
     * @param value
     *            the new value
     *
     * @throws NullPointerException
     *             if the {@code array} is {@code null}
     * @throws IllegalArgumentException
     *             if {@code array} is not an array or the value cannot be
     *             converted to the array type by a widening conversion
     * @throws ArrayIndexOutOfBoundsException
     *             if {@code  index < 0 || index >= array.length}
     */
    @DSComment("Java language reflection")
    @DSBan(DSCat.REFLECTION)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.939 -0500", hash_original_method = "FADDAEE666A0FA8B6A8804C4360DADA9", hash_generated_method = "B34412158113A1AF647DBD12A67F2D85")
    
public static void set(Object array, int index, Object value)
            throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (!array.getClass().isArray()) {
            throw new IllegalArgumentException("Not an array type");
        }

        if (array instanceof Object[]) {
            if (value != null &&
                !array.getClass().getComponentType().isInstance(value)) {
                // incompatible object type for this array
                throw new IllegalArgumentException("Wrong array type");
            }

            ((Object[]) array)[index] = value;
        } else {
            if (value == null) {
                throw new IllegalArgumentException("Primitive array can't take null values.");
            }

            if (value instanceof Boolean)
                setBoolean(array, index, ((Boolean) value).booleanValue());
            else if (value instanceof Byte)
                setByte(array, index, ((Byte) value).byteValue());
            else if (value instanceof Character)
                setChar(array, index, ((Character) value).charValue());
            else if (value instanceof Short)
                setShort(array, index, ((Short) value).shortValue());
            else if (value instanceof Integer)
                setInt(array, index, ((Integer) value).intValue());
            else if (value instanceof Long)
                setLong(array, index, ((Long) value).longValue());
            else if (value instanceof Float)
                setFloat(array, index, ((Float) value).floatValue());
            else if (value instanceof Double)
                setDouble(array, index, ((Double) value).doubleValue());
        }
    }

    /**
     * Sets the element of the array at the specified index to the {@code
     * boolean} value. This reproduces the effect of {@code array[index] =
     * value}.
     *
     * @param array
     *            the array
     * @param index
     *            the index
     * @param value
     *            the new value
     *
     * @throws NullPointerException
     *             if the {@code array} is {@code null}
     * @throws IllegalArgumentException
     *             if the {@code array} is not an array or the value cannot be
     *             converted to the array type by a widening conversion
     * @throws ArrayIndexOutOfBoundsException
     *             if {@code  index < 0 || index >= array.length}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.941 -0500", hash_original_method = "82697F1DDAD6BA9F9E75F9E43B83D4A4", hash_generated_method = "83984F9D434875D4294FD285688C4F47")
    
public static void setBoolean(Object array, int index, boolean value) {
        if (array instanceof boolean[]) {
            ((boolean[]) array)[index] = value;
        } else {
            setByte(array, index, value ? (byte)1 : (byte)0);
        }
    }

    /**
     * Sets the element of the array at the specified index to the {@code byte}
     * value. This reproduces the effect of {@code array[index] = value}.
     *
     * @param array
     *            the array
     * @param index
     *            the index
     * @param value
     *            the new value
     *
     * @throws NullPointerException
     *             if the {@code array} is {@code null}
     * @throws IllegalArgumentException
     *             if the {@code array} is not an array or the value cannot be
     *             converted to the array type by a widening conversion
     * @throws ArrayIndexOutOfBoundsException
     *             if {@code  index < 0 || index >= array.length}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.944 -0500", hash_original_method = "06DE3C579F1C27527258FCCA4070112F", hash_generated_method = "E4C73FDD6187D8AB73AB7378788C6545")
    
public static void setByte(Object array, int index, byte value)
            throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof byte[]) {
            ((byte[]) array)[index] = value;
        } else {
            setShort(array, index, value);
        }
    }

    /**
     * Set the element of the array at the specified index to the {@code char}
     * value. This reproduces the effect of {@code array[index] = value}.
     *
     * @param array
     *            the array
     * @param index
     *            the index
     * @param value
     *            the new value
     *
     * @throws NullPointerException
     *             if the {@code array} is {@code null}
     * @throws IllegalArgumentException
     *             if the {@code array} is not an array or the value cannot be
     *             converted to the array type by a widening conversion
     * @throws ArrayIndexOutOfBoundsException
     *             if {@code  index < 0 || index >= array.length}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.947 -0500", hash_original_method = "5D69B4420808CC9CFE99BC3EB7AEDFF4", hash_generated_method = "CCFEA739A8DC4DECFA9D58398631A466")
    
public static void setChar(Object array, int index, char value)
            throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof char[]) {
            ((char[]) array)[index] = value;
        } else if (array == null) {
            throw new NullPointerException();
        } else if (!array.getClass().isArray()) {
            throw new IllegalArgumentException("Not an array");
        } else {
            throw new IllegalArgumentException("Wrong array type");
        }
    }

    /**
     * Set the element of the array at the specified index to the {@code double}
     * value. This reproduces the effect of {@code array[index] = value}.
     *
     * @param array
     *            the array
     * @param index
     *            the index
     * @param value
     *            the new value
     *
     * @throws NullPointerException
     *             if the {@code array} is {@code null}
     * @throws IllegalArgumentException
     *             if the {@code array} is not an array or the value cannot be
     *             converted to the array type by a widening conversion
     * @throws ArrayIndexOutOfBoundsException
     *             if {@code  index < 0 || index >= array.length}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.950 -0500", hash_original_method = "7CE56449C89109BF4F3077D8A9898080", hash_generated_method = "D798C171B71FE76DA180C32FAAF0EDBA")
    
public static void setDouble(Object array, int index, double value)
            throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof double[]) {
            ((double[]) array)[index] = value;
        } else if (array == null) {
            throw new NullPointerException();
        } else if (!array.getClass().isArray()) {
            throw new IllegalArgumentException("Not an array");
        } else {
            throw new IllegalArgumentException("Wrong array type");
        }
    }

    /**
     * Set the element of the array at the specified index to the {@code float}
     * value. This reproduces the effect of {@code array[index] = value}.
     *
     * @param array
     *            the array
     * @param index
     *            the index
     * @param value
     *            the new value
     *
     * @throws NullPointerException
     *             if the {@code array} is {@code null}
     * @throws IllegalArgumentException
     *             if the {@code array} is not an array or the value cannot be
     *             converted to the array type by a widening conversion
     * @throws ArrayIndexOutOfBoundsException
     *             if {@code  index < 0 || index >= array.length}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.952 -0500", hash_original_method = "B114FA04803A295BF712D3F663C0A834", hash_generated_method = "8912131F2F92F92BD6A0357D35E98B92")
    
public static void setFloat(Object array, int index, float value)
            throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof float[]) {
            ((float[]) array)[index] = value;
        } else {
            setDouble(array, index, value);
        }
    }

    /**
     * Set the element of the array at the specified index to the {@code int}
     * value. This reproduces the effect of {@code array[index] = value}.
     *
     * @param array
     *            the array
     * @param index
     *            the index
     * @param value
     *            the new value
     *
     * @throws NullPointerException
     *             if the {@code array} is {@code null}
     * @throws IllegalArgumentException
     *             if the {@code array} is not an array or the value cannot be
     *             converted to the array type by a widening conversion
     * @throws ArrayIndexOutOfBoundsException
     *             if {@code  index < 0 || index >= array.length}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.955 -0500", hash_original_method = "25E4DD1429136F60BC5ECAD59EC59863", hash_generated_method = "67E50538391AACB7F5628B54716E5734")
    
public static void setInt(Object array, int index, int value)
            throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof int[]) {
            ((int[]) array)[index] = value;
        } else {
            setLong(array, index, value);
        }
    }

    /**
     * Set the element of the array at the specified index to the {@code long}
     * value. This reproduces the effect of {@code array[index] = value}.
     *
     * @param array
     *            the array
     * @param index
     *            the index
     * @param value
     *            the new value
     *
     * @throws NullPointerException
     *             if the {@code array} is {@code null}
     * @throws IllegalArgumentException
     *             if the {@code array} is not an array or the value cannot be
     *             converted to the array type by a widening conversion
     * @throws ArrayIndexOutOfBoundsException
     *             if {@code  index < 0 || index >= array.length}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.958 -0500", hash_original_method = "F26580A8BCD1140BCFEF5033D47111C1", hash_generated_method = "EFA24DD4D71766C1D72944AB6EE2AA6D")
    
public static void setLong(Object array, int index, long value)
            throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof long[]) {
            ((long[]) array)[index] = value;
        } else {
            setFloat(array, index, value);
        }
    }

    /**
     * Set the element of the array at the specified index to the {@code short}
     * value. This reproduces the effect of {@code array[index] = value}.
     *
     * @param array
     *            the array
     * @param index
     *            the index
     * @param value
     *            the new value
     *
     * @throws NullPointerException
     *             if the {@code array} is {@code null}
     * @throws IllegalArgumentException
     *             if the {@code array} is not an array or the value cannot be
     *             converted to the array type by a widening conversion
     * @throws ArrayIndexOutOfBoundsException
     *             if {@code  index < 0 || index >= array.length}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.961 -0500", hash_original_method = "AE3247E24329D7A423373428AFCD12D1", hash_generated_method = "280F3A662E9D64701C5A60365BBDDBA5")
    
public static void setShort(Object array, int index, short value)
            throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof short[]) {
            ((short[]) array)[index] = value;
        } else {
            setInt(array, index, value);
        }
    }
    @DSBan(DSCat.PRIVATE_METHOD)

    @DSComment("Private Method")

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:39.984 -0400", hash_original_method = "27C967B98A825ABE55DF7CE292BE2D15", hash_generated_method = "6D2788CE118EA61713C3B72F25526FFC")
    
private Array() {
    }
    
}

