package libcore.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.nio.ByteOrder;




import droidsafe.helpers.DSUtils;

public final class Memory {

    
    @DSModeled(DSC.SAFE)
    public static void unsafeBulkGet(Object dst, int dstOffset, int byteCount,
            byte[] src, int srcOffset, int sizeofElements, boolean swap) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void unsafeBulkPut(byte[] dst, int dstOffset, int byteCount,
            Object src, int srcOffset, int sizeofElements, boolean swap) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:37.841 -0500", hash_original_method = "8D305254CD39829F31410B39DF7BBEBE", hash_generated_method = "C0A96DEE00CA2BE8EF1300EFA2162F67")
    public static int peekInt(byte[] src, int offset, ByteOrder order) {
        if (order == ByteOrder.BIG_ENDIAN) {
            return (((src[offset++] & 0xff) << 24) |
                    ((src[offset++] & 0xff) << 16) |
                    ((src[offset++] & 0xff) <<  8) |
                    ((src[offset  ] & 0xff) <<  0));
        } else {
            return (((src[offset++] & 0xff) <<  0) |
                    ((src[offset++] & 0xff) <<  8) |
                    ((src[offset++] & 0xff) << 16) |
                    ((src[offset  ] & 0xff) << 24));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:37.842 -0500", hash_original_method = "B98F7C4B79C3BE5084DDBB18889854BB", hash_generated_method = "24280502FAE5E6F244E66533738743BD")
    public static long peekLong(byte[] src, int offset, ByteOrder order) {
        if (order == ByteOrder.BIG_ENDIAN) {
            int h = ((src[offset++] & 0xff) << 24) |
                    ((src[offset++] & 0xff) << 16) |
                    ((src[offset++] & 0xff) <<  8) |
                    ((src[offset++] & 0xff) <<  0);
            int l = ((src[offset++] & 0xff) << 24) |
                    ((src[offset++] & 0xff) << 16) |
                    ((src[offset++] & 0xff) <<  8) |
                    ((src[offset  ] & 0xff) <<  0);
            return (((long) h) << 32L) | ((long) l) & 0xffffffffL;
        } else {
            int l = ((src[offset++] & 0xff) <<  0) |
                    ((src[offset++] & 0xff) <<  8) |
                    ((src[offset++] & 0xff) << 16) |
                    ((src[offset++] & 0xff) << 24);
            int h = ((src[offset++] & 0xff) <<  0) |
                    ((src[offset++] & 0xff) <<  8) |
                    ((src[offset++] & 0xff) << 16) |
                    ((src[offset  ] & 0xff) << 24);
            return (((long) h) << 32L) | ((long) l) & 0xffffffffL;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:37.843 -0500", hash_original_method = "AA975D78647A63D19011E50852F27F77", hash_generated_method = "A2FE1438CB8FEBAE16E8C1B640DD0C94")
    public static short peekShort(byte[] src, int offset, ByteOrder order) {
        if (order == ByteOrder.BIG_ENDIAN) {
            return (short) ((src[offset] << 8) | (src[offset + 1] & 0xff));
        } else {
            return (short) ((src[offset + 1] << 8) | (src[offset] & 0xff));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:37.844 -0500", hash_original_method = "44BE7D40F5A344CCFA84ECB14F292BE4", hash_generated_method = "A8DDB705EB46AF8364B74A8E9874F939")
    public static void pokeInt(byte[] dst, int offset, int value, ByteOrder order) {
        if (order == ByteOrder.BIG_ENDIAN) {
            dst[offset++] = (byte) ((value >> 24) & 0xff);
            dst[offset++] = (byte) ((value >> 16) & 0xff);
            dst[offset++] = (byte) ((value >>  8) & 0xff);
            dst[offset  ] = (byte) ((value >>  0) & 0xff);
        } else {
            dst[offset++] = (byte) ((value >>  0) & 0xff);
            dst[offset++] = (byte) ((value >>  8) & 0xff);
            dst[offset++] = (byte) ((value >> 16) & 0xff);
            dst[offset  ] = (byte) ((value >> 24) & 0xff);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:37.845 -0500", hash_original_method = "D98917DE7F47EEA6D6D33C72096FA56C", hash_generated_method = "CAE5456AB250883137844560F51B60A7")
    public static void pokeLong(byte[] dst, int offset, long value, ByteOrder order) {
        if (order == ByteOrder.BIG_ENDIAN) {
            int i = (int) (value >> 32);
            dst[offset++] = (byte) ((i >> 24) & 0xff);
            dst[offset++] = (byte) ((i >> 16) & 0xff);
            dst[offset++] = (byte) ((i >>  8) & 0xff);
            dst[offset++] = (byte) ((i >>  0) & 0xff);
            i = (int) value;
            dst[offset++] = (byte) ((i >> 24) & 0xff);
            dst[offset++] = (byte) ((i >> 16) & 0xff);
            dst[offset++] = (byte) ((i >>  8) & 0xff);
            dst[offset  ] = (byte) ((i >>  0) & 0xff);
        } else {
            int i = (int) value;
            dst[offset++] = (byte) ((i >>  0) & 0xff);
            dst[offset++] = (byte) ((i >>  8) & 0xff);
            dst[offset++] = (byte) ((i >> 16) & 0xff);
            dst[offset++] = (byte) ((i >> 24) & 0xff);
            i = (int) (value >> 32);
            dst[offset++] = (byte) ((i >>  0) & 0xff);
            dst[offset++] = (byte) ((i >>  8) & 0xff);
            dst[offset++] = (byte) ((i >> 16) & 0xff);
            dst[offset  ] = (byte) ((i >> 24) & 0xff);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:37.846 -0500", hash_original_method = "126E144BF1B52FAB4A446BDFDDF25035", hash_generated_method = "ECB2141A3DBF6EE4061FC9D3169A2629")
    public static void pokeShort(byte[] dst, int offset, short value, ByteOrder order) {
        if (order == ByteOrder.BIG_ENDIAN) {
            dst[offset++] = (byte) ((value >> 8) & 0xff);
            dst[offset  ] = (byte) ((value >> 0) & 0xff);
        } else {
            dst[offset++] = (byte) ((value >> 0) & 0xff);
            dst[offset  ] = (byte) ((value >> 8) & 0xff);
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static void memmove(Object dstObject, int dstOffset, Object srcObject, int srcOffset, long byteCount) {
    }

    
    @DSModeled(DSC.SAFE)
    public static byte peekByte(int address) {
        return DSUtils.UNKNOWN_BYTE;
    }

    
    @DSModeled(DSC.SAFE)
    public static int peekInt(int address, boolean swap) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    public static long peekLong(int address, boolean swap) {
        return DSUtils.UNKNOWN_LONG;
    }

    
    @DSModeled(DSC.SAFE)
    public static short peekShort(int address, boolean swap) {
        return DSUtils.UNKNOWN_SHORT;
    }

    
    @DSModeled(DSC.SAFE)
    public static void peekByteArray(int address, byte[] dst, int dstOffset, int byteCount) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void peekCharArray(int address, char[] dst, int dstOffset, int charCount, boolean swap) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void peekDoubleArray(int address, double[] dst, int dstOffset, int doubleCount, boolean swap) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void peekFloatArray(int address, float[] dst, int dstOffset, int floatCount, boolean swap) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void peekIntArray(int address, int[] dst, int dstOffset, int intCount, boolean swap) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void peekLongArray(int address, long[] dst, int dstOffset, int longCount, boolean swap) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void peekShortArray(int address, short[] dst, int dstOffset, int shortCount, boolean swap) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void pokeByte(int address, byte value) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void pokeInt(int address, int value, boolean swap) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void pokeLong(int address, long value, boolean swap) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void pokeShort(int address, short value, boolean swap) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void pokeByteArray(int address, byte[] src, int offset, int count) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void pokeCharArray(int address, char[] src, int offset, int count, boolean swap) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void pokeDoubleArray(int address, double[] src, int offset, int count, boolean swap) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void pokeFloatArray(int address, float[] src, int offset, int count, boolean swap) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void pokeIntArray(int address, int[] src, int offset, int count, boolean swap) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void pokeLongArray(int address, long[] src, int offset, int count, boolean swap) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void pokeShortArray(int address, short[] src, int offset, int count, boolean swap) {
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:37.837 -0500", hash_original_method = "8E748606B262B165332F0089DEAB291F", hash_generated_method = "B7B6F537B3C912F02D456567DA9C0DA2")
    private Memory() { }

    
}

