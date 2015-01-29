package com.android.org.bouncycastle.crypto.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public abstract class Pack {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:07.321 -0500", hash_original_method = "BEE7BDB9EC50CA7A0AB2196E0174132D", hash_generated_method = "44337B78D46232E2B0109ADC34575A40")
    
public static int bigEndianToInt(byte[] bs, int off)
    {
        int n = bs[  off] << 24;
        n |= (bs[++off] & 0xff) << 16;
        n |= (bs[++off] & 0xff) << 8;
        n |= (bs[++off] & 0xff);
        return n;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:07.323 -0500", hash_original_method = "CF3B11DB3F9AD09C038144DEC323B181", hash_generated_method = "AF082F78A6C082B2330DAECC46C156D4")
    
public static void intToBigEndian(int n, byte[] bs, int off)
    {
        bs[  off] = (byte)(n >>> 24);
        bs[++off] = (byte)(n >>> 16);
        bs[++off] = (byte)(n >>>  8);
        bs[++off] = (byte)(n       );
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:07.326 -0500", hash_original_method = "A4D3931B5AD5A1A7E37ABD1F83E45CC6", hash_generated_method = "4E4F20029DAD227AD4FD1F31DF1872CB")
    
public static long bigEndianToLong(byte[] bs, int off)
    {
        int hi = bigEndianToInt(bs, off);
        int lo = bigEndianToInt(bs, off + 4);
        return ((long)(hi & 0xffffffffL) << 32) | (long)(lo & 0xffffffffL);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:07.329 -0500", hash_original_method = "020931A6340D1F5405C4BB4802C068EE", hash_generated_method = "093C716E38B60F4BD2000BCCC40C0016")
    
public static void longToBigEndian(long n, byte[] bs, int off)
    {
        intToBigEndian((int)(n >>> 32), bs, off);
        intToBigEndian((int)(n & 0xffffffffL), bs, off + 4);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:07.331 -0500", hash_original_method = "E0E7107D9F4F08BBBE59C7DBE1C364DA", hash_generated_method = "24A7CBBD10CBA5F44047A3A6FE27B1B3")
    
public static int littleEndianToInt(byte[] bs, int off)
    {
        int n = bs[  off];
        n |= (bs[++off] & 0xff) << 8;
        n |= (bs[++off] & 0xff) << 16;
        n |= (bs[++off] & 0xff) << 24;
        return n;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:07.334 -0500", hash_original_method = "96C50D79BFEAC1BC7F55BB8B76F64D93", hash_generated_method = "06C4234382D303F3172E413B502693F1")
    
public static void intToLittleEndian(int n, byte[] bs, int off)
    {
        bs[  off] = (byte)(n       );
        bs[++off] = (byte)(n >>>  8);
        bs[++off] = (byte)(n >>> 16);
        bs[++off] = (byte)(n >>> 24);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:07.337 -0500", hash_original_method = "D488E31B8B95FBEFECAA57A620B591C6", hash_generated_method = "5D13EFB9F98E0C07B01AF64B37727A91")
    
public static long littleEndianToLong(byte[] bs, int off)
    {
        int lo = littleEndianToInt(bs, off);
        int hi = littleEndianToInt(bs, off + 4);
        return ((long)(hi & 0xffffffffL) << 32) | (long)(lo & 0xffffffffL);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:07.339 -0500", hash_original_method = "B198B30151ED9AAC428417B1DC7A758D", hash_generated_method = "74C155F29424C683F0F1DD98AFBEB648")
    
public static void longToLittleEndian(long n, byte[] bs, int off)
    {
        intToLittleEndian((int)(n & 0xffffffffL), bs, off);
        intToLittleEndian((int)(n >>> 32), bs, off + 4);
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.440 -0400", hash_original_method = "7D61F0FDEC5E1A91AB83D504A09E89B5", hash_generated_method = "7D61F0FDEC5E1A91AB83D504A09E89B5")
    public Pack ()
    {
        //Synthesized constructor
    }
    
}

