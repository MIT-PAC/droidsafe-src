package com.android.internal.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class BitwiseOutputStream {
    private byte[] mBuf;
    private int mPos;
    private int mEnd;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.637 -0400", hash_original_method = "8BA43F60B4A234D737B83D6AB4280BA3", hash_generated_method = "8AD4EBDD6BB0C75EB20C10958AF370A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BitwiseOutputStream(int startingLength) {
        dsTaint.addTaint(startingLength);
        mBuf = new byte[startingLength];
        mEnd = startingLength << 3;
        mPos = 0;
        // ---------- Original Method ----------
        //mBuf = new byte[startingLength];
        //mEnd = startingLength << 3;
        //mPos = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.637 -0400", hash_original_method = "72E6824355C9DBC273758F3BBD7B1F36", hash_generated_method = "DE13B0A76F336E0D5A776A0BAFB80CAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] toByteArray() {
        int len;
        len = (mPos >>> 3) + ((mPos & 0x07) > 0 ? 1 : 0);//DSFIXME:  CODE0008: Nested ternary operator in expression
        byte[] newBuf;
        newBuf = new byte[len];
        System.arraycopy(mBuf, 0, newBuf, 0, len);
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //int len = (mPos >>> 3) + ((mPos & 0x07) > 0 ? 1 : 0);
        //byte[] newBuf = new byte[len];
        //System.arraycopy(mBuf, 0, newBuf, 0, len);
        //return newBuf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.637 -0400", hash_original_method = "85E3B4FCCAFED594AE8716A3280C8E01", hash_generated_method = "954462CA52ACED9414EF9EBE73904490")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void possExpand(int bits) {
        dsTaint.addTaint(bits);
        byte[] newBuf;
        newBuf = new byte[(mPos + bits) >>> 2];
        System.arraycopy(mBuf, 0, newBuf, 0, mEnd >>> 3);
        mBuf = newBuf;
        // ---------- Original Method ----------
        //if ((mPos + bits) < mEnd) return;
        //byte[] newBuf = new byte[(mPos + bits) >>> 2];
        //System.arraycopy(mBuf, 0, newBuf, 0, mEnd >>> 3);
        //mBuf = newBuf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.638 -0400", hash_original_method = "5E02E1586BFD98056E8E0E2C4C1BAAF7", hash_generated_method = "3B81CE0464DB73C82FA1AFE22C1E210A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void write(int bits, int data) throws AccessException {
        dsTaint.addTaint(bits);
        dsTaint.addTaint(data);
        {
            if (DroidSafeAndroidRuntime.control) throw new AccessException("illegal write (" + bits + " bits)");
        } //End block
        possExpand(bits);
        data &= (-1 >>> (32 - bits));
        int index;
        index = mPos >>> 3;
        int offset;
        offset = 16 - (mPos & 0x07) - bits;
        data <<= offset;
        mBuf[index] |= data >>> 8;
        mBuf[index + 1] |= data & 0xFF;
        // ---------- Original Method ----------
        //if ((bits < 0) || (bits > 8)) {
            //throw new AccessException("illegal write (" + bits + " bits)");
        //}
        //possExpand(bits);
        //data &= (-1 >>> (32 - bits));
        //int index = mPos >>> 3;
        //int offset = 16 - (mPos & 0x07) - bits;
        //data <<= offset;
        //mPos += bits;
        //mBuf[index] |= data >>> 8;
        //if (offset < 8) mBuf[index + 1] |= data & 0xFF;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.638 -0400", hash_original_method = "2EEA7A5C566152BE0CF88964605D6DC9", hash_generated_method = "6F247A17EBBEF854B1FDD62E4B8A873B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeByteArray(int bits, byte[] arr) throws AccessException {
        dsTaint.addTaint(arr[0]);
        dsTaint.addTaint(bits);
        {
            int i;
            i = 0;
            {
                int increment;
                increment = Math.min(8, bits - (i << 3));
                {
                    write(increment, (byte)(arr[i] >>> (8 - increment)));
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (int i = 0; i < arr.length; i++) {
            //int increment = Math.min(8, bits - (i << 3));
            //if (increment > 0) {
                //write(increment, (byte)(arr[i] >>> (8 - increment)));
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.638 -0400", hash_original_method = "8EBD7575DC6E636356E0A413FE046F9F", hash_generated_method = "E7AF1913BD5788082DDB1EADD24ABD52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void skip(int bits) {
        dsTaint.addTaint(bits);
        possExpand(bits);
        // ---------- Original Method ----------
        //possExpand(bits);
        //mPos += bits;
    }

    
    public static class AccessException extends Exception {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.638 -0400", hash_original_method = "FD7EE91BB7CFA9004E3BBE9542C9C5B5", hash_generated_method = "E2CE9693775015C657FDD296C1A79F89")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public AccessException(String s) {
            super("BitwiseOutputStream access failed: " + s);
            dsTaint.addTaint(s);
            // ---------- Original Method ----------
        }

        
    }


    
}

