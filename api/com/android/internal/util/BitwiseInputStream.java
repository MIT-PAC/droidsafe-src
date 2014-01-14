package com.android.internal.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class BitwiseInputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.734 -0500", hash_original_field = "CCCDB98A97C1303EEF1EDB8DB6C44807", hash_generated_field = "29FB82D1D2E75901C37B9EDD1B81BDDE")

    private byte[] mBuf;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.737 -0500", hash_original_field = "25A5DEAC26D49039381CEC3AC02D8D8E", hash_generated_field = "649CC94BF1D5A5FECFE4D2F006B35728")

    private int mPos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.739 -0500", hash_original_field = "6FAA56F5628A0F1DAAFED98EBDB1C99E", hash_generated_field = "EA295975CAF8E42F4C28A87EADB358DF")

    private int mEnd;

    /**
     * Create object from byte array.
     *
     * @param buf a byte array containing data
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.747 -0500", hash_original_method = "5532B5125C79E9957D47EEEDDF5375E5", hash_generated_method = "69BFF5261DA4E74D25F3305A2DDF6A46")
    
public BitwiseInputStream(byte buf[]) {
        mBuf = buf;
        mEnd = buf.length << 3;
        mPos = 0;
    }

    /**
     * Return the number of bit still available for reading.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.749 -0500", hash_original_method = "66AE1F5CE6A7D22DCB733CBBD166C2BB", hash_generated_method = "2EA6E3EF05C1CC57312D79304A74B402")
    
public int available() {
        return mEnd - mPos;
    }

    /**
     * Read some data and increment the current position.
     *
     * The 8-bit limit on access to bitwise streams is intentional to
     * avoid endianness issues.
     *
     * @param bits the amount of data to read (gte 0, lte 8)
     * @return byte of read data (possibly partially filled, from lsb)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.751 -0500", hash_original_method = "D3779E30F0E2824C817E23A6212C6A73", hash_generated_method = "67A585DB033E1032E265A2F415C5FE45")
    
public int read(int bits) throws AccessException {
        int index = mPos >>> 3;
        int offset = 16 - (mPos & 0x07) - bits;  // &7==%8
        if ((bits < 0) || (bits > 8) || ((mPos + bits) > mEnd)) {
            throw new AccessException("illegal read " +
                "(pos " + mPos + ", end " + mEnd + ", bits " + bits + ")");
        }
        int data = (mBuf[index] & 0xFF) << 8;
        if (offset < 8) data |= mBuf[index + 1] & 0xFF;
        data >>>= offset;
        data &= (-1 >>> (32 - bits));
        mPos += bits;
        return data;
    }

    /**
     * Read data in bulk into a byte array and increment the current position.
     *
     * @param bits the amount of data to read
     * @return newly allocated byte array of read data
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.754 -0500", hash_original_method = "6BC73F7388CF8F913A045B88BC2AD5D8", hash_generated_method = "02D1E84EDD88A1B1D8D962D865C80497")
    
public byte[] readByteArray(int bits) throws AccessException {
        int bytes = (bits >>> 3) + ((bits & 0x07) > 0 ? 1 : 0);  // &7==%8
        byte[] arr = new byte[bytes];
        for (int i = 0; i < bytes; i++) {
            int increment = Math.min(8, bits - (i << 3));
            arr[i] = (byte)(read(increment) << (8 - increment));
        }
        return arr;
    }

    /**
     * Increment the current position and ignore contained data.
     *
     * @param bits the amount by which to increment the position
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.756 -0500", hash_original_method = "2B3CAB6B00B171A015C7D4103C2B529C", hash_generated_method = "46464080E4EC25A4875686809D40D7DD")
    
public void skip(int bits) throws AccessException {
        if ((mPos + bits) > mEnd) {
            throw new AccessException("illegal skip " +
                "(pos " + mPos + ", end " + mEnd + ", bits " + bits + ")");
        }
        mPos += bits;
    }
    
    public static class AccessException extends Exception {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.742 -0500", hash_original_method = "52F4B42001DB417C9537E4FCBE00DA44", hash_generated_method = "E3D542A3BCC80436D82FFEC6A5EDB18E")
        
public AccessException(String s) {
            super("BitwiseInputStream access failed: " + s);
        }
        
    }
    
}

