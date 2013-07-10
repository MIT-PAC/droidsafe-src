package com.android.internal.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class BitwiseInputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.613 -0400", hash_original_field = "D8259507CE3049C660B2FFFC8043DC4C", hash_generated_field = "29FB82D1D2E75901C37B9EDD1B81BDDE")

    private byte[] mBuf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.613 -0400", hash_original_field = "A8470CE6E0050B0E832FDE52720C7250", hash_generated_field = "649CC94BF1D5A5FECFE4D2F006B35728")

    private int mPos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.613 -0400", hash_original_field = "C3B248BAD041692A85BAABC024E9FDCE", hash_generated_field = "EA295975CAF8E42F4C28A87EADB358DF")

    private int mEnd;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.614 -0400", hash_original_method = "5532B5125C79E9957D47EEEDDF5375E5", hash_generated_method = "F4070DF16873D45534FF26EEBA652BFC")
    public  BitwiseInputStream(byte buf[]) {
        mBuf = buf;
        mEnd = buf.length << 3;
        mPos = 0;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.614 -0400", hash_original_method = "66AE1F5CE6A7D22DCB733CBBD166C2BB", hash_generated_method = "B6A8F5DD36405FF653F10472E9C75071")
    public int available() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_906654994 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_906654994;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.615 -0400", hash_original_method = "D3779E30F0E2824C817E23A6212C6A73", hash_generated_method = "F8F46BCE35302A55DEBF337753D31624")
    public int read(int bits) throws AccessException {
        int index = mPos >>> 3;
        int offset = 16 - (mPos & 0x07) - bits;
        {
            if (DroidSafeAndroidRuntime.control) throw new AccessException("illegal read " +
                "(pos " + mPos + ", end " + mEnd + ", bits " + bits + ")");
        } 
        int data = (mBuf[index] & 0xFF) << 8;
        data |= mBuf[index + 1] & 0xFF;
        data >>>= offset;
        data &= (-1 >>> (32 - bits));
        mPos += bits;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_492096395 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_492096395;
        
        
        
        
            
                
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.615 -0400", hash_original_method = "6BC73F7388CF8F913A045B88BC2AD5D8", hash_generated_method = "FD594D4DA099A9354916375CADFA1C05")
    public byte[] readByteArray(int bits) throws AccessException {
        int bytes = (bits >>> 3) + ((bits & 0x07) > 0 ? 1 : 0);
        byte[] arr = new byte[bytes];
        {
            int i = 0;
            {
                int increment = Math.min(8, bits - (i << 3));
                arr[i] = (byte)(read(increment) << (8 - increment));
            } 
        } 
        addTaint(bits);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_417045077 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_417045077;
        
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.615 -0400", hash_original_method = "2B3CAB6B00B171A015C7D4103C2B529C", hash_generated_method = "0AE42AA53536C7B8C86D04C3CAE6D9E1")
    public void skip(int bits) throws AccessException {
        {
            if (DroidSafeAndroidRuntime.control) throw new AccessException("illegal skip " +
                "(pos " + mPos + ", end " + mEnd + ", bits " + bits + ")");
        } 
        mPos += bits;
        
        
            
                
        
        
    }

    
    public static class AccessException extends Exception {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.616 -0400", hash_original_method = "52F4B42001DB417C9537E4FCBE00DA44", hash_generated_method = "91D817A58B62BA1BD87BADB0342B2B6A")
        public  AccessException(String s) {
            super("BitwiseInputStream access failed: " + s);
            addTaint(s.getTaint());
            
        }

        
    }


    
}

