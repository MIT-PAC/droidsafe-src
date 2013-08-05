package com.android.internal.util;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class BitwiseOutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.634 -0400", hash_original_field = "D8259507CE3049C660B2FFFC8043DC4C", hash_generated_field = "29FB82D1D2E75901C37B9EDD1B81BDDE")

    private byte[] mBuf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.634 -0400", hash_original_field = "A8470CE6E0050B0E832FDE52720C7250", hash_generated_field = "649CC94BF1D5A5FECFE4D2F006B35728")

    private int mPos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.634 -0400", hash_original_field = "C3B248BAD041692A85BAABC024E9FDCE", hash_generated_field = "EA295975CAF8E42F4C28A87EADB358DF")

    private int mEnd;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.634 -0400", hash_original_method = "8BA43F60B4A234D737B83D6AB4280BA3", hash_generated_method = "06427A18CDB37C1BE01DC8D43457AF3E")
    public  BitwiseOutputStream(int startingLength) {
        mBuf = new byte[startingLength];
        mEnd = startingLength << 3;
        mPos = 0;
        // ---------- Original Method ----------
        //mBuf = new byte[startingLength];
        //mEnd = startingLength << 3;
        //mPos = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.635 -0400", hash_original_method = "72E6824355C9DBC273758F3BBD7B1F36", hash_generated_method = "E8EB08C6FE932CB4E3C29B04903FE853")
    public byte[] toByteArray() {
        int len = (mPos >>> 3) + ((mPos & 0x07) > 0 ? 1 : 0);
        byte[] newBuf = new byte[len];
        System.arraycopy(mBuf, 0, newBuf, 0, len);
        byte[] var0A94B194638DDB595BED320A270BC946_164127938 = (newBuf);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_939421704 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_939421704;
        // ---------- Original Method ----------
        //int len = (mPos >>> 3) + ((mPos & 0x07) > 0 ? 1 : 0);
        //byte[] newBuf = new byte[len];
        //System.arraycopy(mBuf, 0, newBuf, 0, len);
        //return newBuf;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.635 -0400", hash_original_method = "85E3B4FCCAFED594AE8716A3280C8E01", hash_generated_method = "A0CF2C335A2FCC8E209D57A79F780C18")
    private void possExpand(int bits) {
        addTaint(bits);
        if((mPos + bits) < mEnd)        
        return;
        byte[] newBuf = new byte[(mPos + bits) >>> 2];
        System.arraycopy(mBuf, 0, newBuf, 0, mEnd >>> 3);
        mBuf = newBuf;
        // ---------- Original Method ----------
        //if ((mPos + bits) < mEnd) return;
        //byte[] newBuf = new byte[(mPos + bits) >>> 2];
        //System.arraycopy(mBuf, 0, newBuf, 0, mEnd >>> 3);
        //mBuf = newBuf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.637 -0400", hash_original_method = "5E02E1586BFD98056E8E0E2C4C1BAAF7", hash_generated_method = "FF34A3B6B04D013F8C84D8F13303AF47")
    public void write(int bits, int data) throws AccessException {
        if((bits < 0) || (bits > 8))        
        {
            AccessException varC19FF9A33E636231793F43F4DF35322B_231634614 = new AccessException("illegal write (" + bits + " bits)");
            varC19FF9A33E636231793F43F4DF35322B_231634614.addTaint(taint);
            throw varC19FF9A33E636231793F43F4DF35322B_231634614;
        } //End block
        possExpand(bits);
        data &= (-1 >>> (32 - bits));
        int index = mPos >>> 3;
        int offset = 16 - (mPos & 0x07) - bits;
        data <<= offset;
        mPos += bits;
        mBuf[index] |= data >>> 8;
        if(offset < 8)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.639 -0400", hash_original_method = "2EEA7A5C566152BE0CF88964605D6DC9", hash_generated_method = "DFBBF92D2E3D42D9037EDC6C8D333A9C")
    public void writeByteArray(int bits, byte[] arr) throws AccessException {
        addTaint(arr[0]);
        addTaint(bits);
for(int i = 0;i < arr.length;i++)
        {
            int increment = Math.min(8, bits - (i << 3));
            if(increment > 0)            
            {
                write(increment, (byte)(arr[i] >>> (8 - increment)));
            } //End block
        } //End block
        // ---------- Original Method ----------
        //for (int i = 0; i < arr.length; i++) {
            //int increment = Math.min(8, bits - (i << 3));
            //if (increment > 0) {
                //write(increment, (byte)(arr[i] >>> (8 - increment)));
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.640 -0400", hash_original_method = "8EBD7575DC6E636356E0A413FE046F9F", hash_generated_method = "FE4673D796D119D8C6BA5A110C594DA4")
    public void skip(int bits) {
        possExpand(bits);
        mPos += bits;
        // ---------- Original Method ----------
        //possExpand(bits);
        //mPos += bits;
    }

    
    public static class AccessException extends Exception {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.641 -0400", hash_original_method = "FD7EE91BB7CFA9004E3BBE9542C9C5B5", hash_generated_method = "C8649CF1DC7622EC3E4732E728626B65")
        public  AccessException(String s) {
            super("BitwiseOutputStream access failed: " + s);
            addTaint(s.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
}

