package java.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class Array {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.801 -0400", hash_original_method = "27C967B98A825ABE55DF7CE292BE2D15", hash_generated_method = "8F496C8B0F35FBBE27EB4065BD3777B5")
    @DSModeled(DSC.SAFE)
    private Array() {
        // ---------- Original Method ----------
    }

    
        public static Object get(Object array, int index) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
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

    
        public static boolean getBoolean(Object array, int index) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
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

    
        public static byte getByte(Object array, int index) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof byte[]) {
            return ((byte[]) array)[index];
        } else {
            return getBoolean(array, index) ? (byte)1 : (byte)0;
        }
    }

    
        public static char getChar(Object array, int index) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
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

    
        public static double getDouble(Object array, int index) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof double[]) {
            return ((double[]) array)[index];
        } else {
            return getFloat(array, index);
        }
    }

    
        public static float getFloat(Object array, int index) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof float[]) {
            return ((float[]) array)[index];
        } else {
            return getLong(array, index);
        }
    }

    
        public static int getInt(Object array, int index) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof int[]) {
            return ((int[]) array)[index];
        } else {
            return getShort(array, index);
        }
    }

    
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

    
        public static long getLong(Object array, int index) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof long[]) {
            return ((long[]) array)[index];
        } else {
            return getInt(array, index);
        }
    }

    
        public static short getShort(Object array, int index) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof short[])
            return ((short[]) array)[index];
        return getByte(array, index);
    }

    
        public static Object newInstance(Class<?> componentType, int... dimensions) throws NegativeArraySizeException, IllegalArgumentException {
        if (dimensions.length <= 0 || dimensions.length > 255)
            throw new IllegalArgumentException("Bad number of dimensions");
        if (componentType == void.class)
            throw new IllegalArgumentException();
        if (componentType == null)
            throw new NullPointerException();
        return createMultiArray(componentType, dimensions);
    }

    
        private static Object createMultiArray(Class<?> componentType,
        int[] dimensions) throws NegativeArraySizeException {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        public static Object newInstance(Class<?> componentType, int size) throws NegativeArraySizeException {
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

    
        private static Object createObjectArray(Class<?> componentType,
        int length) throws NegativeArraySizeException {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        public static void set(Object array, int index, Object value) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (!array.getClass().isArray()) {
            throw new IllegalArgumentException("Not an array type");
        }
        if (array instanceof Object[]) {
            if (value != null &&
                !array.getClass().getComponentType().isInstance(value)) {
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

    
        public static void setBoolean(Object array, int index, boolean value) {
        if (array instanceof boolean[]) {
            ((boolean[]) array)[index] = value;
        } else {
            setByte(array, index, value ? (byte)1 : (byte)0);
        }
    }

    
        public static void setByte(Object array, int index, byte value) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof byte[]) {
            ((byte[]) array)[index] = value;
        } else {
            setShort(array, index, value);
        }
    }

    
        public static void setChar(Object array, int index, char value) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
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

    
        public static void setDouble(Object array, int index, double value) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
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

    
        public static void setFloat(Object array, int index, float value) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof float[]) {
            ((float[]) array)[index] = value;
        } else {
            setDouble(array, index, value);
        }
    }

    
        public static void setInt(Object array, int index, int value) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof int[]) {
            ((int[]) array)[index] = value;
        } else {
            setLong(array, index, value);
        }
    }

    
        public static void setLong(Object array, int index, long value) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof long[]) {
            ((long[]) array)[index] = value;
        } else {
            setFloat(array, index, value);
        }
    }

    
        public static void setShort(Object array, int index, short value) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof short[]) {
            ((short[]) array)[index] = value;
        } else {
            setInt(array, index, value);
        }
    }

    
}

