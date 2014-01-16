package com.android.internal.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class BitwiseOutputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.004 -0500", hash_original_field = "CCCDB98A97C1303EEF1EDB8DB6C44807", hash_generated_field = "29FB82D1D2E75901C37B9EDD1B81BDDE")

    private byte[] mBuf;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.006 -0500", hash_original_field = "25A5DEAC26D49039381CEC3AC02D8D8E", hash_generated_field = "649CC94BF1D5A5FECFE4D2F006B35728")

    private int mPos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.009 -0500", hash_original_field = "6FAA56F5628A0F1DAAFED98EBDB1C99E", hash_generated_field = "EA295975CAF8E42F4C28A87EADB358DF")

    private int mEnd;

    /**
     * Create object from hint at desired size.
     *
     * @param startingLength initial internal byte array length in bytes
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.017 -0500", hash_original_method = "8BA43F60B4A234D737B83D6AB4280BA3", hash_generated_method = "19140192E224D89843B9A8AF774F4C23")
    
public BitwiseOutputStream(int startingLength) {
        mBuf = new byte[startingLength];
        mEnd = startingLength << 3;
        mPos = 0;
    }

    /**
     * Return byte array containing accumulated data, sized to just fit.
     *
     * @return newly allocated byte array
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.020 -0500", hash_original_method = "72E6824355C9DBC273758F3BBD7B1F36", hash_generated_method = "80910418259D620C34834AD17DF81588")
    
public byte[] toByteArray() {
        int len = (mPos >>> 3) + ((mPos & 0x07) > 0 ? 1 : 0);  // &7==%8
        byte[] newBuf = new byte[len];
        System.arraycopy(mBuf, 0, newBuf, 0, len);
        return newBuf;
    }

    /**
     * Allocate a new internal buffer, if needed.
     *
     * @param bits additional bits to be accommodated
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.022 -0500", hash_original_method = "85E3B4FCCAFED594AE8716A3280C8E01", hash_generated_method = "5102FE82D016AAF05DE0178E966BD666")
    
private void possExpand(int bits) {
        if ((mPos + bits) < mEnd) return;
        byte[] newBuf = new byte[(mPos + bits) >>> 2];
        System.arraycopy(mBuf, 0, newBuf, 0, mEnd >>> 3);
        mBuf = newBuf;
    }

    /**
     * Write some data and increment the current position.
     *
     * The 8-bit limit on access to bitwise streams is intentional to
     * avoid endianness issues.
     *
     * @param bits the amount of data to write (gte 0, lte 8)
     * @param data to write, will be masked to expose only bits param from lsb
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.025 -0500", hash_original_method = "5E02E1586BFD98056E8E0E2C4C1BAAF7", hash_generated_method = "F8CE9F1C5675EE19596CA54C4A157327")
    
public void write(int bits, int data) throws AccessException {
        if ((bits < 0) || (bits > 8)) {
            throw new AccessException("illegal write (" + bits + " bits)");
        }
        possExpand(bits);
        data &= (-1 >>> (32 - bits));
        int index = mPos >>> 3;
        int offset = 16 - (mPos & 0x07) - bits;  // &7==%8
        data <<= offset;
        mPos += bits;
        mBuf[index] |= data >>> 8;
        if (offset < 8) mBuf[index + 1] |= data & 0xFF;
    }

    /**
     * Write data in bulk from a byte array and increment the current position.
     *
     * @param bits the amount of data to write
     * @param arr the byte array containing data to be written
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.028 -0500", hash_original_method = "2EEA7A5C566152BE0CF88964605D6DC9", hash_generated_method = "20F289D021E621F6C80CD38801027034")
    
public void writeByteArray(int bits, byte[] arr) throws AccessException {
        for (int i = 0; i < arr.length; i++) {
            int increment = Math.min(8, bits - (i << 3));
            if (increment > 0) {
                write(increment, (byte)(arr[i] >>> (8 - increment)));
            }
        }
    }

    /**
     * Increment the current position, implicitly writing zeros.
     *
     * @param bits the amount by which to increment the position
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.030 -0500", hash_original_method = "8EBD7575DC6E636356E0A413FE046F9F", hash_generated_method = "2C74E619B3A3419A6A00E03B48D01CB6")
    
public void skip(int bits) {
        possExpand(bits);
        mPos += bits;
    }
    
    public static class AccessException extends Exception {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.012 -0500", hash_original_method = "FD7EE91BB7CFA9004E3BBE9542C9C5B5", hash_generated_method = "B5415AC5E14E36E55E139727BF67CE87")
        
public AccessException(String s) {
            super("BitwiseOutputStream access failed: " + s);
        }
        
    }
    
}

