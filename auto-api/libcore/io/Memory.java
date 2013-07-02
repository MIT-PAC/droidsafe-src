package libcore.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class Memory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.252 -0400", hash_original_method = "8E748606B262B165332F0089DEAB291F", hash_generated_method = "65AB48DAC941764A247934D1396F6184")
    private  Memory() {
        
    }

    
    public static void unsafeBulkGet(Object dst, int dstOffset, int byteCount,
            byte[] src, int srcOffset, int sizeofElements, boolean swap) {
    }

    
    public static void unsafeBulkPut(byte[] dst, int dstOffset, int byteCount,
            Object src, int srcOffset, int sizeofElements, boolean swap) {
    }

    
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

    
    public static short peekShort(byte[] src, int offset, ByteOrder order) {
        if (order == ByteOrder.BIG_ENDIAN) {
            return (short) ((src[offset] << 8) | (src[offset + 1] & 0xff));
        } else {
            return (short) ((src[offset + 1] << 8) | (src[offset] & 0xff));
        }
    }

    
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

    
    public static void pokeShort(byte[] dst, int offset, short value, ByteOrder order) {
        if (order == ByteOrder.BIG_ENDIAN) {
            dst[offset++] = (byte) ((value >> 8) & 0xff);
            dst[offset  ] = (byte) ((value >> 0) & 0xff);
        } else {
            dst[offset++] = (byte) ((value >> 0) & 0xff);
            dst[offset  ] = (byte) ((value >> 8) & 0xff);
        }
    }

    
    public static void memmove(Object dstObject, int dstOffset, Object srcObject, int srcOffset, long byteCount) {
    }

    
    public static byte peekByte(int address) {
        return DSUtils.UNKNOWN_BYTE;
    }

    
    public static int peekInt(int address, boolean swap) {
        return DSUtils.UNKNOWN_INT;
    }

    
    public static long peekLong(int address, boolean swap) {
        return DSUtils.UNKNOWN_LONG;
    }

    
    public static short peekShort(int address, boolean swap) {
        return DSUtils.UNKNOWN_SHORT;
    }

    
    public static void peekByteArray(int address, byte[] dst, int dstOffset, int byteCount) {
    }

    
    public static void peekCharArray(int address, char[] dst, int dstOffset, int charCount, boolean swap) {
    }

    
    public static void peekDoubleArray(int address, double[] dst, int dstOffset, int doubleCount, boolean swap) {
    }

    
    public static void peekFloatArray(int address, float[] dst, int dstOffset, int floatCount, boolean swap) {
    }

    
    public static void peekIntArray(int address, int[] dst, int dstOffset, int intCount, boolean swap) {
    }

    
    public static void peekLongArray(int address, long[] dst, int dstOffset, int longCount, boolean swap) {
    }

    
    public static void peekShortArray(int address, short[] dst, int dstOffset, int shortCount, boolean swap) {
    }

    
    public static void pokeByte(int address, byte value) {
    }

    
    public static void pokeInt(int address, int value, boolean swap) {
    }

    
    public static void pokeLong(int address, long value, boolean swap) {
    }

    
    public static void pokeShort(int address, short value, boolean swap) {
    }

    
    public static void pokeByteArray(int address, byte[] src, int offset, int count) {
    }

    
    public static void pokeCharArray(int address, char[] src, int offset, int count, boolean swap) {
    }

    
    public static void pokeDoubleArray(int address, double[] src, int offset, int count, boolean swap) {
    }

    
    public static void pokeFloatArray(int address, float[] src, int offset, int count, boolean swap) {
    }

    
    public static void pokeIntArray(int address, int[] src, int offset, int count, boolean swap) {
    }

    
    public static void pokeLongArray(int address, long[] src, int offset, int count, boolean swap) {
    }

    
    public static void pokeShortArray(int address, short[] src, int offset, int count, boolean swap) {
    }

    
}

