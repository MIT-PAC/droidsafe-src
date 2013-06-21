package com.android.internal.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class BitwiseInputStream {
    private byte[] mBuf;
    private int mPos;
    private int mEnd;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.627 -0400", hash_original_method = "5532B5125C79E9957D47EEEDDF5375E5", hash_generated_method = "01EBD5B222FD7457F14DD3605A549E93")
    @DSModeled(DSC.SAFE)
    public BitwiseInputStream(byte buf[]) {
        dsTaint.addTaint(buf);
        mEnd = buf.length << 3;
        mPos = 0;
        // ---------- Original Method ----------
        //mBuf = buf;
        //mEnd = buf.length << 3;
        //mPos = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.628 -0400", hash_original_method = "66AE1F5CE6A7D22DCB733CBBD166C2BB", hash_generated_method = "AA2973E629686342435D033F8331ECE5")
    @DSModeled(DSC.SAFE)
    public int available() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mEnd - mPos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.630 -0400", hash_original_method = "D3779E30F0E2824C817E23A6212C6A73", hash_generated_method = "49C6B6B930DFF16FC76E6C3CA041F348")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int read(int bits) throws AccessException {
        dsTaint.addTaint(bits);
        int index;
        index = mPos >>> 3;
        int offset;
        offset = 16 - (mPos & 0x07) - bits;
        {
            if (DroidSafeAndroidRuntime.control) throw new AccessException("illegal read " +
                "(pos " + mPos + ", end " + mEnd + ", bits " + bits + ")");
        } //End block
        int data;
        data = (mBuf[index] & 0xFF) << 8;
        data |= mBuf[index + 1] & 0xFF;
        data >>>= offset;
        data &= (-1 >>> (32 - bits));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int index = mPos >>> 3;
        //int offset = 16 - (mPos & 0x07) - bits;
        //if ((bits < 0) || (bits > 8) || ((mPos + bits) > mEnd)) {
            //throw new AccessException("illegal read " +
                //"(pos " + mPos + ", end " + mEnd + ", bits " + bits + ")");
        //}
        //int data = (mBuf[index] & 0xFF) << 8;
        //if (offset < 8) data |= mBuf[index + 1] & 0xFF;
        //data >>>= offset;
        //data &= (-1 >>> (32 - bits));
        //mPos += bits;
        //return data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.631 -0400", hash_original_method = "6BC73F7388CF8F913A045B88BC2AD5D8", hash_generated_method = "85405CA1052FFC6C03A45DF02910CEEA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] readByteArray(int bits) throws AccessException {
        dsTaint.addTaint(bits);
        int bytes;
        bytes = (bits >>> 3) + ((bits & 0x07) > 0 ? 1 : 0);//DSFIXME:  CODE0008: Nested ternary operator in expression
        byte[] arr;
        arr = new byte[bytes];
        {
            int i;
            i = 0;
            {
                int increment;
                increment = Math.min(8, bits - (i << 3));
                arr[i] = (byte)(read(increment) << (8 - increment));
            } //End block
        } //End collapsed parenthetic
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //int bytes = (bits >>> 3) + ((bits & 0x07) > 0 ? 1 : 0);
        //byte[] arr = new byte[bytes];
        //for (int i = 0; i < bytes; i++) {
            //int increment = Math.min(8, bits - (i << 3));
            //arr[i] = (byte)(read(increment) << (8 - increment));
        //}
        //return arr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.631 -0400", hash_original_method = "2B3CAB6B00B171A015C7D4103C2B529C", hash_generated_method = "5D9E5709A632C6A8924FF6DDA9832D30")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void skip(int bits) throws AccessException {
        dsTaint.addTaint(bits);
        {
            if (DroidSafeAndroidRuntime.control) throw new AccessException("illegal skip " +
                "(pos " + mPos + ", end " + mEnd + ", bits " + bits + ")");
        } //End block
        // ---------- Original Method ----------
        //if ((mPos + bits) > mEnd) {
            //throw new AccessException("illegal skip " +
                //"(pos " + mPos + ", end " + mEnd + ", bits " + bits + ")");
        //}
        //mPos += bits;
    }

    
    public static class AccessException extends Exception {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.631 -0400", hash_original_method = "52F4B42001DB417C9537E4FCBE00DA44", hash_generated_method = "2AEBC42C972753F1B0D898A32576FA3A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public AccessException(String s) {
            super("BitwiseInputStream access failed: " + s);
            dsTaint.addTaint(s);
            // ---------- Original Method ----------
        }

        
    }


    
}

