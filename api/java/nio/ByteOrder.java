package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

import droidsafe.helpers.DSUtils;

public final class ByteOrder {
    
    private static boolean isLittleEndian() {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    /**
     * Returns the current platform byte order.
     *
     * @return the byte order object, which is either LITTLE_ENDIAN or
     *         BIG_ENDIAN.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.396 -0500", hash_original_method = "D07BFAC609E59F2C654790B31AE5FD0D", hash_generated_method = "A24B785DD11572D2B52D969BDBCFE967")
    
public static ByteOrder nativeOrder() {
        return NATIVE_ORDER;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.377 -0500", hash_original_field = "300C157B3F571CC7E4A3C7E28EDC8E80", hash_generated_field = "92D01F42E3BD90FA81F44D4D587D8F69")

    private static  ByteOrder NATIVE_ORDER;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.379 -0500", hash_original_field = "08B1D83DA65FF100C74A08917D79DA88", hash_generated_field = "B2FFDD2947FFF15E017EF1E34971641D")

    public static  ByteOrder BIG_ENDIAN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.382 -0500", hash_original_field = "06E35B36A14A1260B58EADC7D10BE2A0", hash_generated_field = "75DB246CA3F938879550B10AA3E5DDC1")

    public static  ByteOrder LITTLE_ENDIAN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.389 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private  String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.391 -0500", hash_original_field = "148531C14C69A88C9CE8A910FECF241A", hash_generated_field = "4ECB2B3E8E176FD36BB429A3A3830E89")

    public  boolean needsSwap;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.394 -0500", hash_original_method = "B317EBC8D5650E5C34B265838B9D3EC5", hash_generated_method = "60CB5148C5FD483B83C3C29ED77A5A9D")
    
private ByteOrder(String name, boolean needsSwap) {
        this.name = name;
        this.needsSwap = needsSwap;
    }

    /**
     * Returns a string that describes this object.
     *
     * @return "BIG_ENDIAN" for {@link #BIG_ENDIAN ByteOrder.BIG_ENDIAN}
     *         objects, "LITTLE_ENDIAN" for
     *         {@link #LITTLE_ENDIAN ByteOrder.LITTLE_ENDIAN} objects.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.399 -0500", hash_original_method = "0EB66BA5E965B83E191719250E0A82FF", hash_generated_method = "0D841C721535905DD0E9F7FAE6757EB9")
    
@Override
    public String toString() {
        return name;
    }
    static {
        boolean isLittleEndian = isLittleEndian();
        BIG_ENDIAN = new ByteOrder("BIG_ENDIAN", isLittleEndian);
        LITTLE_ENDIAN = new ByteOrder("LITTLE_ENDIAN", !isLittleEndian);
        NATIVE_ORDER = isLittleEndian ? LITTLE_ENDIAN : BIG_ENDIAN;
    }
    
}

