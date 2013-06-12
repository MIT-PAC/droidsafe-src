package java.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class Array {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.109 -0400", hash_original_method = "27C967B98A825ABE55DF7CE292BE2D15", hash_generated_method = "92D643DFF8307AE432533FD1FEDACBDE")
    @DSModeled(DSC.SAFE)
    private Array() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.117 -0400", hash_original_method = "DC819166ADE9A9BB796EBD77364A49D8", hash_generated_method = "B57FA28A23A3CBE2087765A9CBD0CB7A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.125 -0400", hash_original_method = "4FBA4EB2136CE3D0A944EBC9D223B8AB", hash_generated_method = "867DD4BF2D81B80067BF55D8AE1A6CF1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.130 -0400", hash_original_method = "B4311492402F851EAEF8E66ECE236930", hash_generated_method = "0AA22A962031A2D97CA8C12D8E0949C4")
    public static byte getByte(Object array, int index) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof byte[]) {
            return ((byte[]) array)[index];
        } else {
            return getBoolean(array, index) ? (byte)1 : (byte)0;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.136 -0400", hash_original_method = "F9750F8D4DCE07008B25C7B9487F8814", hash_generated_method = "B86F3A445EE7F35813E9E5F6EC113BD4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.142 -0400", hash_original_method = "50790AF08E26146F4B35A5889C5B3E01", hash_generated_method = "7CEC4F3CC0D7EEC9D77535675F4D890C")
    public static double getDouble(Object array, int index) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof double[]) {
            return ((double[]) array)[index];
        } else {
            return getFloat(array, index);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.148 -0400", hash_original_method = "688EF8AB88B411AE551AED0281953294", hash_generated_method = "A8F4F4E7676F5C9C1F8E4194AA6B6DDD")
    public static float getFloat(Object array, int index) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof float[]) {
            return ((float[]) array)[index];
        } else {
            return getLong(array, index);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.153 -0400", hash_original_method = "5A8557FDE3B2AD2419DCA0873E4EC2DB", hash_generated_method = "BCBA513CC2B7EC43A10E7622F59DDF67")
    public static int getInt(Object array, int index) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof int[]) {
            return ((int[]) array)[index];
        } else {
            return getShort(array, index);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.160 -0400", hash_original_method = "01924EF6E2610B26238572C631DDDD41", hash_generated_method = "09C4DE3DCD0A88FB68A0D99BE393988C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.167 -0400", hash_original_method = "5A35E5A70189A9661FDF585F087D7AAE", hash_generated_method = "B619311A3C57FCC2206E764058DE5993")
    public static long getLong(Object array, int index) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof long[]) {
            return ((long[]) array)[index];
        } else {
            return getInt(array, index);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.173 -0400", hash_original_method = "4F5B502567D6D9A0FE26CC3AAC82FB87", hash_generated_method = "21D028DC552E779A896D9EBBA6CBF3EF")
    public static short getShort(Object array, int index) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof short[])
            return ((short[]) array)[index];
        return getByte(array, index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.180 -0400", hash_original_method = "9C554BC8C0AA11B64E6653FCAA15C2E7", hash_generated_method = "4A9297550B4F9160675971DAFB19C3B9")
    public static Object newInstance(Class<?> componentType, int... dimensions) throws NegativeArraySizeException, IllegalArgumentException {
        if (dimensions.length <= 0 || dimensions.length > 255)
            throw new IllegalArgumentException("Bad number of dimensions");
        if (componentType == void.class)
            throw new IllegalArgumentException();
        if (componentType == null)
            throw new NullPointerException();
        return createMultiArray(componentType, dimensions);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.185 -0400", hash_original_method = "F5A480269EE51318EAD4A19F4CFD1D17", hash_generated_method = "90374BDAE32E5AD0A05C8D6964A0D7E0")
    private static Object createMultiArray(Class<?> componentType,
        int[] dimensions) throws NegativeArraySizeException {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return new Object();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.192 -0400", hash_original_method = "8C1FC94B96B7DFB690D4B009645E9D92", hash_generated_method = "7B175AE1219E00BE34100EB87DDF9825")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.198 -0400", hash_original_method = "F9B18D748F0CF6AA8F5B33198B6083B6", hash_generated_method = "FDB3C9878CD95EBA5D67FA948CB34DE4")
    private static Object createObjectArray(Class<?> componentType,
        int length) throws NegativeArraySizeException {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return new Object();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.206 -0400", hash_original_method = "FADDAEE666A0FA8B6A8804C4360DADA9", hash_generated_method = "10234A3E9FCD75E400C220BF58C17DD2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.216 -0400", hash_original_method = "82697F1DDAD6BA9F9E75F9E43B83D4A4", hash_generated_method = "83984F9D434875D4294FD285688C4F47")
    public static void setBoolean(Object array, int index, boolean value) {
        if (array instanceof boolean[]) {
            ((boolean[]) array)[index] = value;
        } else {
            setByte(array, index, value ? (byte)1 : (byte)0);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.218 -0400", hash_original_method = "06DE3C579F1C27527258FCCA4070112F", hash_generated_method = "E4C73FDD6187D8AB73AB7378788C6545")
    public static void setByte(Object array, int index, byte value) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof byte[]) {
            ((byte[]) array)[index] = value;
        } else {
            setShort(array, index, value);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.225 -0400", hash_original_method = "5D69B4420808CC9CFE99BC3EB7AEDFF4", hash_generated_method = "CCFEA739A8DC4DECFA9D58398631A466")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.233 -0400", hash_original_method = "7CE56449C89109BF4F3077D8A9898080", hash_generated_method = "D798C171B71FE76DA180C32FAAF0EDBA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.240 -0400", hash_original_method = "B114FA04803A295BF712D3F663C0A834", hash_generated_method = "8912131F2F92F92BD6A0357D35E98B92")
    public static void setFloat(Object array, int index, float value) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof float[]) {
            ((float[]) array)[index] = value;
        } else {
            setDouble(array, index, value);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.246 -0400", hash_original_method = "25E4DD1429136F60BC5ECAD59EC59863", hash_generated_method = "67E50538391AACB7F5628B54716E5734")
    public static void setInt(Object array, int index, int value) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof int[]) {
            ((int[]) array)[index] = value;
        } else {
            setLong(array, index, value);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.254 -0400", hash_original_method = "F26580A8BCD1140BCFEF5033D47111C1", hash_generated_method = "EFA24DD4D71766C1D72944AB6EE2AA6D")
    public static void setLong(Object array, int index, long value) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof long[]) {
            ((long[]) array)[index] = value;
        } else {
            setFloat(array, index, value);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.258 -0400", hash_original_method = "AE3247E24329D7A423373428AFCD12D1", hash_generated_method = "280F3A662E9D64701C5A60365BBDDBA5")
    public static void setShort(Object array, int index, short value) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof short[]) {
            ((short[]) array)[index] = value;
        } else {
            setInt(array, index, value);
        }
    }

    
}


