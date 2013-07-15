package java.security;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.nio.ByteBuffer;

public abstract class MessageDigestSpi {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.389 -0400", hash_original_method = "1CC69EEF55221D742AA45996503C6E66", hash_generated_method = "1CC69EEF55221D742AA45996503C6E66")
    public MessageDigestSpi ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.390 -0400", hash_original_method = "3B6B0B894EAF70FF02C9B2DD93EC82F9", hash_generated_method = "DCA6F1BF86D80C99692C231E86CAE3AE")
    protected int engineGetDigestLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1709903827 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1709903827;
        
        
    }

    
    protected abstract void engineUpdate(byte input);

    
    protected abstract void engineUpdate(byte[] input, int offset, int len);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.391 -0400", hash_original_method = "63E93F26D259525D134C674633CD9D02", hash_generated_method = "D019E3038D111B5ACA05920A024889DE")
    protected void engineUpdate(ByteBuffer input) {
        {
            boolean varE54245A319FB90E6E4BB7E9A96B716C3_1154623511 = (!input.hasRemaining());
        } 
        byte[] tmp;
        {
            boolean var011961AA1A198646CB962085FB0562D5_309677857 = (input.hasArray());
            {
                tmp = input.array();
                int offset = input.arrayOffset();
                int position = input.position();
                int limit = input.limit();
                engineUpdate(tmp, offset+position, limit - position);
                input.position(limit);
            } 
            {
                tmp = new byte[input.limit() - input.position()];
                input.get(tmp);
                engineUpdate(tmp, 0, tmp.length);
            } 
        } 
        addTaint(input.getTaint());
        
        
            
        
        
        
            
            
            
            
            
            
        
            
            
            
        
    }

    
    protected abstract byte[] engineDigest();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.391 -0400", hash_original_method = "D264912F1C73FF5788F885ED0FD28756", hash_generated_method = "0B0201CFDE8408E0CD86A3FC24DAFE06")
    protected int engineDigest(byte[] buf, int offset, int len) throws DigestException {
        {
            boolean var0728C0E705DD9A0A8E1467295A1F681F_957845363 = (len < engineGetDigestLength());
            {
                engineReset();
                if (DroidSafeAndroidRuntime.control) throw new DigestException("The value of len parameter is less than the actual digest length");
            } 
        } 
        {
            engineReset();
            if (DroidSafeAndroidRuntime.control) throw new DigestException("offset < 0");
        } 
        {
            engineReset();
            if (DroidSafeAndroidRuntime.control) throw new DigestException("offset + len > buf.length");
        } 
        byte[] tmp = engineDigest();
        {
            if (DroidSafeAndroidRuntime.control) throw new DigestException("The value of len parameter is less than the actual digest length");
        } 
        System.arraycopy(tmp, 0, buf, offset, tmp.length);
        addTaint(buf[0]);
        addTaint(offset);
        addTaint(len);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1921695142 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1921695142;
        
        
            
            
        
        
            
            
        
        
            
            
        
        
        
            
        
        
        
    }

    
    protected abstract void engineReset();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.392 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "A7FE630CDA3F79E211E6A43001779F3F")
    @Override
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1315527177 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1315527177 = super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1315527177.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1315527177;
        
        
    }

    
}

