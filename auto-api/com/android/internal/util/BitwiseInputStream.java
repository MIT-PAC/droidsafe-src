package com.android.internal.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class BitwiseInputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.110 -0400", hash_original_field = "D8259507CE3049C660B2FFFC8043DC4C", hash_generated_field = "29FB82D1D2E75901C37B9EDD1B81BDDE")

    private byte[] mBuf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.110 -0400", hash_original_field = "A8470CE6E0050B0E832FDE52720C7250", hash_generated_field = "649CC94BF1D5A5FECFE4D2F006B35728")

    private int mPos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.110 -0400", hash_original_field = "C3B248BAD041692A85BAABC024E9FDCE", hash_generated_field = "EA295975CAF8E42F4C28A87EADB358DF")

    private int mEnd;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.128 -0400", hash_original_method = "5532B5125C79E9957D47EEEDDF5375E5", hash_generated_method = "F4070DF16873D45534FF26EEBA652BFC")
    public  BitwiseInputStream(byte buf[]) {
        mBuf = buf;
        mEnd = buf.length << 3;
        mPos = 0;
        // ---------- Original Method ----------
        //mBuf = buf;
        //mEnd = buf.length << 3;
        //mPos = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.128 -0400", hash_original_method = "66AE1F5CE6A7D22DCB733CBBD166C2BB", hash_generated_method = "58DDEB61C3681E0D3B8D7132A2B58F47")
    public int available() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_773988105 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_773988105;
        // ---------- Original Method ----------
        //return mEnd - mPos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.128 -0400", hash_original_method = "D3779E30F0E2824C817E23A6212C6A73", hash_generated_method = "7ED91B6F5ED73F6A6A01F2CBE4C51E56")
    public int read(int bits) throws AccessException {
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
        mPos += bits;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_796405038 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_796405038;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.129 -0400", hash_original_method = "6BC73F7388CF8F913A045B88BC2AD5D8", hash_generated_method = "B933AA77A328A92A49DCB460E5978ABF")
    public byte[] readByteArray(int bits) throws AccessException {
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
        addTaint(bits);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1252984652 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1252984652;
        // ---------- Original Method ----------
        //int bytes = (bits >>> 3) + ((bits & 0x07) > 0 ? 1 : 0);
        //byte[] arr = new byte[bytes];
        //for (int i = 0; i < bytes; i++) {
            //int increment = Math.min(8, bits - (i << 3));
            //arr[i] = (byte)(read(increment) << (8 - increment));
        //}
        //return arr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.129 -0400", hash_original_method = "2B3CAB6B00B171A015C7D4103C2B529C", hash_generated_method = "0AE42AA53536C7B8C86D04C3CAE6D9E1")
    public void skip(int bits) throws AccessException {
        {
            if (DroidSafeAndroidRuntime.control) throw new AccessException("illegal skip " +
                "(pos " + mPos + ", end " + mEnd + ", bits " + bits + ")");
        } //End block
        mPos += bits;
        // ---------- Original Method ----------
        //if ((mPos + bits) > mEnd) {
            //throw new AccessException("illegal skip " +
                //"(pos " + mPos + ", end " + mEnd + ", bits " + bits + ")");
        //}
        //mPos += bits;
    }

    
    public static class AccessException extends Exception {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.130 -0400", hash_original_method = "52F4B42001DB417C9537E4FCBE00DA44", hash_generated_method = "91D817A58B62BA1BD87BADB0342B2B6A")
        public  AccessException(String s) {
            super("BitwiseInputStream access failed: " + s);
            addTaint(s.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
}

