package libcore.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class Memory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.478 -0400", hash_original_method = "8E748606B262B165332F0089DEAB291F", hash_generated_method = "CF85F1CB6A297EA6C2DCCB454E8EC052")
    @DSModeled(DSC.SAFE)
    private Memory() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.478 -0400", hash_original_method = "654AF2D9EB6B68141E8A93F893919395", hash_generated_method = "B1600547B92F4E5D44BDB6BF578F6B63")
    public static void unsafeBulkGet(Object dst, int dstOffset, int byteCount,
            byte[] src, int srcOffset, int sizeofElements, boolean swap) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.478 -0400", hash_original_method = "C3A5299E3BD189EE34DA350FE218F46C", hash_generated_method = "313AB051D83276EA22AE5B3C5EE370E7")
    public static void unsafeBulkPut(byte[] dst, int dstOffset, int byteCount,
            Object src, int srcOffset, int sizeofElements, boolean swap) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.478 -0400", hash_original_method = "8D305254CD39829F31410B39DF7BBEBE", hash_generated_method = "C0A96DEE00CA2BE8EF1300EFA2162F67")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.478 -0400", hash_original_method = "B98F7C4B79C3BE5084DDBB18889854BB", hash_generated_method = "24280502FAE5E6F244E66533738743BD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.478 -0400", hash_original_method = "AA975D78647A63D19011E50852F27F77", hash_generated_method = "A2FE1438CB8FEBAE16E8C1B640DD0C94")
    public static short peekShort(byte[] src, int offset, ByteOrder order) {
        if (order == ByteOrder.BIG_ENDIAN) {
            return (short) ((src[offset] << 8) | (src[offset + 1] & 0xff));
        } else {
            return (short) ((src[offset + 1] << 8) | (src[offset] & 0xff));
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.478 -0400", hash_original_method = "44BE7D40F5A344CCFA84ECB14F292BE4", hash_generated_method = "A8DDB705EB46AF8364B74A8E9874F939")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.478 -0400", hash_original_method = "D98917DE7F47EEA6D6D33C72096FA56C", hash_generated_method = "CAE5456AB250883137844560F51B60A7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.479 -0400", hash_original_method = "126E144BF1B52FAB4A446BDFDDF25035", hash_generated_method = "ECB2141A3DBF6EE4061FC9D3169A2629")
    public static void pokeShort(byte[] dst, int offset, short value, ByteOrder order) {
        if (order == ByteOrder.BIG_ENDIAN) {
            dst[offset++] = (byte) ((value >> 8) & 0xff);
            dst[offset  ] = (byte) ((value >> 0) & 0xff);
        } else {
            dst[offset++] = (byte) ((value >> 0) & 0xff);
            dst[offset  ] = (byte) ((value >> 8) & 0xff);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.479 -0400", hash_original_method = "E359F7154C5548C2FA31CA123BC29EE2", hash_generated_method = "19355FEE835D832107CAEBADCBCF4E96")
    public static void memmove(Object dstObject, int dstOffset, Object srcObject, int srcOffset, long byteCount) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.479 -0400", hash_original_method = "153A400D82219B55CEEC5CB515033E2B", hash_generated_method = "3F2FBC0585D0455FCA3FDC9AE53B2C21")
    public static byte peekByte(int address) {
    	return DSUtils.UNKNOWN_BYTE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.479 -0400", hash_original_method = "0B9E9C9191403A3800E7272D993B1A29", hash_generated_method = "A43C6CD924DFC76D1E2C12EF77DB5324")
    public static int peekInt(int address, boolean swap) {
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.479 -0400", hash_original_method = "C65857A6559B5563A7F34C07527432FD", hash_generated_method = "4DE98E4938C5D4590C9782129A7175FB")
    public static long peekLong(int address, boolean swap) {
    	return DSUtils.UNKNOWN_LONG;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.479 -0400", hash_original_method = "2EB104BC83E162F49238BC8FAE579C06", hash_generated_method = "A50E7B50291FB9B7256B66852BFA7FEE")
    public static short peekShort(int address, boolean swap) {
    	return DSUtils.UNKNOWN_SHORT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.479 -0400", hash_original_method = "5483143254F1144B2CFF3E6218B05BB9", hash_generated_method = "AADBBA64228B4DC1F8E4FB6960A7C3EF")
    public static void peekByteArray(int address, byte[] dst, int dstOffset, int byteCount) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.479 -0400", hash_original_method = "1EC40647627828B652A13DBB43981305", hash_generated_method = "4224F5B016447C4C3E081799FAE5F750")
    public static void peekCharArray(int address, char[] dst, int dstOffset, int charCount, boolean swap) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.479 -0400", hash_original_method = "731BB688883404C8D576914AED781338", hash_generated_method = "60F9B216E9FF04C8D2697907D98E7A83")
    public static void peekDoubleArray(int address, double[] dst, int dstOffset, int doubleCount, boolean swap) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.479 -0400", hash_original_method = "BCD4C9B9F63B73250213F4A8484DAFCB", hash_generated_method = "5094E0EAF0AC861C97DCEFD4FADCA726")
    public static void peekFloatArray(int address, float[] dst, int dstOffset, int floatCount, boolean swap) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.479 -0400", hash_original_method = "730382752D0EA68509A46AA2CDEC340A", hash_generated_method = "E896830716966F2C65B84451F9D5545C")
    public static void peekIntArray(int address, int[] dst, int dstOffset, int intCount, boolean swap) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.479 -0400", hash_original_method = "9EB172695AE34DC04E0BD7B68CBF22C1", hash_generated_method = "602754987AD1DDC6BDAC92E2E0BB9CCA")
    public static void peekLongArray(int address, long[] dst, int dstOffset, int longCount, boolean swap) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.479 -0400", hash_original_method = "FFBB36C5046D5E3CE5F700B3CBDBE58C", hash_generated_method = "84359C06E77D404198B15130A0139D2C")
    public static void peekShortArray(int address, short[] dst, int dstOffset, int shortCount, boolean swap) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.479 -0400", hash_original_method = "A9F0F801A7D700C7B4FE480CA1308427", hash_generated_method = "6C3F87A2FF2CF88AA2EC8340971FE347")
    public static void pokeByte(int address, byte value) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.479 -0400", hash_original_method = "E2607A7016E14AA559EB9368F0AE0105", hash_generated_method = "D68FD333752D3D5432F84DC1E5E948EE")
    public static void pokeInt(int address, int value, boolean swap) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.479 -0400", hash_original_method = "8D76F1E8D01F41C42B3F96705A41B1A6", hash_generated_method = "2F5598611F1FD8F0AEF026DE35D67956")
    public static void pokeLong(int address, long value, boolean swap) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.479 -0400", hash_original_method = "E0BAE8305BDB3C017D1D8F0901118B7B", hash_generated_method = "BF2D7D3CA6C2E4F776191222DA151748")
    public static void pokeShort(int address, short value, boolean swap) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.479 -0400", hash_original_method = "B28D5511CAC2E147C539235A849E576D", hash_generated_method = "A74AA8CD9CB4EC6B047E3E4B061E9D99")
    public static void pokeByteArray(int address, byte[] src, int offset, int count) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.479 -0400", hash_original_method = "6B8C67E8A93720B011C8546090389036", hash_generated_method = "23B5FA40B2E341257047EDB080AFEF25")
    public static void pokeCharArray(int address, char[] src, int offset, int count, boolean swap) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.479 -0400", hash_original_method = "0320F6A998E39A923981E3BEBD6693F4", hash_generated_method = "4B035120539750B69F6A1F77AB166C9A")
    public static void pokeDoubleArray(int address, double[] src, int offset, int count, boolean swap) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.479 -0400", hash_original_method = "4E4C4ADE58F2384C1636BD53FE061524", hash_generated_method = "68E8F3D49B36C69B3C401A000D8C1260")
    public static void pokeFloatArray(int address, float[] src, int offset, int count, boolean swap) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.479 -0400", hash_original_method = "2E9BA77227C7B65945FE86EAB4A6578B", hash_generated_method = "522CB048967E9D5DA0762C1B2258739E")
    public static void pokeIntArray(int address, int[] src, int offset, int count, boolean swap) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.479 -0400", hash_original_method = "CDBA71F4AC959394DF11ED66AA8C965D", hash_generated_method = "D01DA80E097319DD83C608C147D4FA0B")
    public static void pokeLongArray(int address, long[] src, int offset, int count, boolean swap) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.479 -0400", hash_original_method = "CB9279548A63BCF1FB918685C68F416D", hash_generated_method = "4395D0A992E7E0E4F1685B4470715865")
    public static void pokeShortArray(int address, short[] src, int offset, int count, boolean swap) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
}


