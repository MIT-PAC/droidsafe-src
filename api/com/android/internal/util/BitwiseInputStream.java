package com.android.internal.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class BitwiseInputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.634 -0400", hash_original_field = "D8259507CE3049C660B2FFFC8043DC4C", hash_generated_field = "29FB82D1D2E75901C37B9EDD1B81BDDE")

    private byte[] mBuf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.634 -0400", hash_original_field = "A8470CE6E0050B0E832FDE52720C7250", hash_generated_field = "649CC94BF1D5A5FECFE4D2F006B35728")

    private int mPos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.634 -0400", hash_original_field = "C3B248BAD041692A85BAABC024E9FDCE", hash_generated_field = "EA295975CAF8E42F4C28A87EADB358DF")

    private int mEnd;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.634 -0400", hash_original_method = "5532B5125C79E9957D47EEEDDF5375E5", hash_generated_method = "F4070DF16873D45534FF26EEBA652BFC")
    public  BitwiseInputStream(byte buf[]) {
        mBuf = buf;
        mEnd = buf.length << 3;
        mPos = 0;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.634 -0400", hash_original_method = "66AE1F5CE6A7D22DCB733CBBD166C2BB", hash_generated_method = "7E7A07A0DF92F098FD4DE0543FBECE2C")
    public int available() {
        int var25F27EDFF759489C17F7B43F667E4B74_488341496 = (mEnd - mPos);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1027636717 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1027636717;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.635 -0400", hash_original_method = "D3779E30F0E2824C817E23A6212C6A73", hash_generated_method = "2E07AA68D5161ADF3914736ACC50123F")
    public int read(int bits) throws AccessException {
        int index = mPos >>> 3;
        int offset = 16 - (mPos & 0x07) - bits;
    if((bits < 0) || (bits > 8) || ((mPos + bits) > mEnd))        
        {
            AccessException var635B25830267C6E0D47AE07693F68C3D_1134798261 = new AccessException("illegal read " +
                "(pos " + mPos + ", end " + mEnd + ", bits " + bits + ")");
            var635B25830267C6E0D47AE07693F68C3D_1134798261.addTaint(taint);
            throw var635B25830267C6E0D47AE07693F68C3D_1134798261;
        } 
        int data = (mBuf[index] & 0xFF) << 8;
    if(offset < 8)        
        data |= mBuf[index + 1] & 0xFF;
        data >>>= offset;
        data &= (-1 >>> (32 - bits));
        mPos += bits;
        int var8D777F385D3DFEC8815D20F7496026DC_1915790573 = (data);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1307113445 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1307113445;
        
        
        
        
            
                
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.635 -0400", hash_original_method = "6BC73F7388CF8F913A045B88BC2AD5D8", hash_generated_method = "A860A8490D064A189C574D021B63A078")
    public byte[] readByteArray(int bits) throws AccessException {
        addTaint(bits);
        int bytes = (bits >>> 3) + ((bits & 0x07) > 0 ? 1 : 0);
        byte[] arr = new byte[bytes];
for(int i = 0;i < bytes;i++)
        {
            int increment = Math.min(8, bits - (i << 3));
            arr[i] = (byte)(read(increment) << (8 - increment));
        } 
        byte[] var47C80780AB608CC046F2A6E6F071FEB6_1805594390 = (arr);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1407028046 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1407028046;
        
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.635 -0400", hash_original_method = "2B3CAB6B00B171A015C7D4103C2B529C", hash_generated_method = "B03AD69FE2FE181115FDE1F78F7AD71C")
    public void skip(int bits) throws AccessException {
    if((mPos + bits) > mEnd)        
        {
            AccessException var42D2745CCAC04127197A5AC7D4F10A02_616394665 = new AccessException("illegal skip " +
                "(pos " + mPos + ", end " + mEnd + ", bits " + bits + ")");
            var42D2745CCAC04127197A5AC7D4F10A02_616394665.addTaint(taint);
            throw var42D2745CCAC04127197A5AC7D4F10A02_616394665;
        } 
        mPos += bits;
        
        
            
                
        
        
    }

    
    public static class AccessException extends Exception {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.635 -0400", hash_original_method = "52F4B42001DB417C9537E4FCBE00DA44", hash_generated_method = "91D817A58B62BA1BD87BADB0342B2B6A")
        public  AccessException(String s) {
            super("BitwiseInputStream access failed: " + s);
            addTaint(s.getTaint());
            
        }

        
    }


    
}

