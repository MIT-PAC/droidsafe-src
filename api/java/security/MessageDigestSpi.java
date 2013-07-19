package java.security;

// Droidsafe Imports
import java.nio.ByteBuffer;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class MessageDigestSpi {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.096 -0400", hash_original_method = "1CC69EEF55221D742AA45996503C6E66", hash_generated_method = "1CC69EEF55221D742AA45996503C6E66")
    public MessageDigestSpi ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.096 -0400", hash_original_method = "3B6B0B894EAF70FF02C9B2DD93EC82F9", hash_generated_method = "C3588ED89CA57DA51D2BEDCCFC4F1558")
    protected int engineGetDigestLength() {
        int varCFCD208495D565EF66E7DFF9F98764DA_438192762 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1715454951 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1715454951;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract void engineUpdate(byte input);

    
    @DSModeled(DSC.SAFE)
    protected abstract void engineUpdate(byte[] input, int offset, int len);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.098 -0400", hash_original_method = "63E93F26D259525D134C674633CD9D02", hash_generated_method = "99A5066D1A75A8074D20D672E6DF8797")
    protected void engineUpdate(ByteBuffer input) {
        addTaint(input.getTaint());
        if(!input.hasRemaining())        
        {
            return;
        } //End block
        byte[] tmp;
        if(input.hasArray())        
        {
            tmp = input.array();
            int offset = input.arrayOffset();
            int position = input.position();
            int limit = input.limit();
            engineUpdate(tmp, offset+position, limit - position);
            input.position(limit);
        } //End block
        else
        {
            tmp = new byte[input.limit() - input.position()];
            input.get(tmp);
            engineUpdate(tmp, 0, tmp.length);
        } //End block
        // ---------- Original Method ----------
        //if (!input.hasRemaining()) {
            //return;
        //}
        //byte[] tmp;
        //if (input.hasArray()) {
            //tmp = input.array();
            //int offset = input.arrayOffset();
            //int position = input.position();
            //int limit = input.limit();
            //engineUpdate(tmp, offset+position, limit - position);
            //input.position(limit);
        //} else {
            //tmp = new byte[input.limit() - input.position()];
            //input.get(tmp);
            //engineUpdate(tmp, 0, tmp.length);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract byte[] engineDigest();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.099 -0400", hash_original_method = "D264912F1C73FF5788F885ED0FD28756", hash_generated_method = "5C5FEB1745139CDCBC54557753C24714")
    protected int engineDigest(byte[] buf, int offset, int len) throws DigestException {
        addTaint(len);
        addTaint(offset);
        addTaint(buf[0]);
        if(len < engineGetDigestLength())        
        {
            engineReset();
            DigestException varA0BDA52328B09E3FB89A55293F4862F3_2000005677 = new DigestException("The value of len parameter is less than the actual digest length");
            varA0BDA52328B09E3FB89A55293F4862F3_2000005677.addTaint(taint);
            throw varA0BDA52328B09E3FB89A55293F4862F3_2000005677;
        } //End block
        if(offset < 0)        
        {
            engineReset();
            DigestException varB8AC5FF11332D8E89AA51B9A01353B36_802709677 = new DigestException("offset < 0");
            varB8AC5FF11332D8E89AA51B9A01353B36_802709677.addTaint(taint);
            throw varB8AC5FF11332D8E89AA51B9A01353B36_802709677;
        } //End block
        if(offset + len > buf.length)        
        {
            engineReset();
            DigestException varCB8D15DFD12EED43A8175D5DB037C963_1967335225 = new DigestException("offset + len > buf.length");
            varCB8D15DFD12EED43A8175D5DB037C963_1967335225.addTaint(taint);
            throw varCB8D15DFD12EED43A8175D5DB037C963_1967335225;
        } //End block
        byte[] tmp = engineDigest();
        if(len < tmp.length)        
        {
            DigestException varA0BDA52328B09E3FB89A55293F4862F3_555159145 = new DigestException("The value of len parameter is less than the actual digest length");
            varA0BDA52328B09E3FB89A55293F4862F3_555159145.addTaint(taint);
            throw varA0BDA52328B09E3FB89A55293F4862F3_555159145;
        } //End block
        System.arraycopy(tmp, 0, buf, offset, tmp.length);
        int varE4FA7AD586BA429F593A6E87F52C4CF3_1283599584 = (tmp.length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_666217301 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_666217301;
        // ---------- Original Method ----------
        //if (len < engineGetDigestLength()) {
            //engineReset();
            //throw new DigestException("The value of len parameter is less than the actual digest length");
        //}
        //if (offset < 0) {
            //engineReset();
            //throw new DigestException("offset < 0");
        //}
        //if (offset + len > buf.length) {
            //engineReset();
            //throw new DigestException("offset + len > buf.length");
        //}
        //byte[] tmp = engineDigest();
        //if (len < tmp.length) {
            //throw new DigestException("The value of len parameter is less than the actual digest length");
        //}
        //System.arraycopy(tmp, 0, buf, offset, tmp.length);
        //return tmp.length;
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract void engineReset();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.100 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "384C58DB8AC8BCDFBE5C979645B03B28")
    @Override
    public Object clone() throws CloneNotSupportedException {
Object var46F3A0D86742C1D6E099C2B166941A33_866749537 =         super.clone();
        var46F3A0D86742C1D6E099C2B166941A33_866749537.addTaint(taint);
        return var46F3A0D86742C1D6E099C2B166941A33_866749537;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

