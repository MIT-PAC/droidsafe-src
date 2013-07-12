package java.security;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.nio.ByteBuffer;

public abstract class MessageDigestSpi {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.124 -0400", hash_original_method = "1CC69EEF55221D742AA45996503C6E66", hash_generated_method = "1CC69EEF55221D742AA45996503C6E66")
    public MessageDigestSpi ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.125 -0400", hash_original_method = "3B6B0B894EAF70FF02C9B2DD93EC82F9", hash_generated_method = "575BF4156FBCB64EC8AE6101C37A7754")
    protected int engineGetDigestLength() {
        int varCFCD208495D565EF66E7DFF9F98764DA_162752270 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_420354966 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_420354966;
        
        
    }

    
    protected abstract void engineUpdate(byte input);

    
    protected abstract void engineUpdate(byte[] input, int offset, int len);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.126 -0400", hash_original_method = "63E93F26D259525D134C674633CD9D02", hash_generated_method = "99A5066D1A75A8074D20D672E6DF8797")
    protected void engineUpdate(ByteBuffer input) {
        addTaint(input.getTaint());
    if(!input.hasRemaining())        
        {
            return;
        } 
        byte[] tmp;
    if(input.hasArray())        
        {
            tmp = input.array();
            int offset = input.arrayOffset();
            int position = input.position();
            int limit = input.limit();
            engineUpdate(tmp, offset+position, limit - position);
            input.position(limit);
        } 
        else
        {
            tmp = new byte[input.limit() - input.position()];
            input.get(tmp);
            engineUpdate(tmp, 0, tmp.length);
        } 
        
        
            
        
        
        
            
            
            
            
            
            
        
            
            
            
        
    }

    
    protected abstract byte[] engineDigest();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.127 -0400", hash_original_method = "D264912F1C73FF5788F885ED0FD28756", hash_generated_method = "E6BEBF1734CEB1C95D0EDB37B5A9DA9E")
    protected int engineDigest(byte[] buf, int offset, int len) throws DigestException {
        addTaint(len);
        addTaint(offset);
        addTaint(buf[0]);
    if(len < engineGetDigestLength())        
        {
            engineReset();
            DigestException varA0BDA52328B09E3FB89A55293F4862F3_2079483533 = new DigestException("The value of len parameter is less than the actual digest length");
            varA0BDA52328B09E3FB89A55293F4862F3_2079483533.addTaint(taint);
            throw varA0BDA52328B09E3FB89A55293F4862F3_2079483533;
        } 
    if(offset < 0)        
        {
            engineReset();
            DigestException varB8AC5FF11332D8E89AA51B9A01353B36_829881684 = new DigestException("offset < 0");
            varB8AC5FF11332D8E89AA51B9A01353B36_829881684.addTaint(taint);
            throw varB8AC5FF11332D8E89AA51B9A01353B36_829881684;
        } 
    if(offset + len > buf.length)        
        {
            engineReset();
            DigestException varCB8D15DFD12EED43A8175D5DB037C963_2133093671 = new DigestException("offset + len > buf.length");
            varCB8D15DFD12EED43A8175D5DB037C963_2133093671.addTaint(taint);
            throw varCB8D15DFD12EED43A8175D5DB037C963_2133093671;
        } 
        byte[] tmp = engineDigest();
    if(len < tmp.length)        
        {
            DigestException varA0BDA52328B09E3FB89A55293F4862F3_1433512034 = new DigestException("The value of len parameter is less than the actual digest length");
            varA0BDA52328B09E3FB89A55293F4862F3_1433512034.addTaint(taint);
            throw varA0BDA52328B09E3FB89A55293F4862F3_1433512034;
        } 
        System.arraycopy(tmp, 0, buf, offset, tmp.length);
        int varE4FA7AD586BA429F593A6E87F52C4CF3_1374917535 = (tmp.length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1602319267 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1602319267;
        
        
            
            
        
        
            
            
        
        
            
            
        
        
        
            
        
        
        
    }

    
    protected abstract void engineReset();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.127 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "5B375CA84478ED722DB4E18BDDF03D6F")
    @Override
    public Object clone() throws CloneNotSupportedException {
Object var46F3A0D86742C1D6E099C2B166941A33_1622483562 =         super.clone();
        var46F3A0D86742C1D6E099C2B166941A33_1622483562.addTaint(taint);
        return var46F3A0D86742C1D6E099C2B166941A33_1622483562;
        
        
    }

    
}

