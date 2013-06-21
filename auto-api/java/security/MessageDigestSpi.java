package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.nio.ByteBuffer;

public abstract class MessageDigestSpi {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.395 -0400", hash_original_method = "EE14E7391A5A700FEA91F11DB2A3A73B", hash_generated_method = "EE14E7391A5A700FEA91F11DB2A3A73B")
        public MessageDigestSpi ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.395 -0400", hash_original_method = "3B6B0B894EAF70FF02C9B2DD93EC82F9", hash_generated_method = "2B045E9EE3D77CA48FB0546C3F1ECF01")
    @DSModeled(DSC.SAFE)
    protected int engineGetDigestLength() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    protected abstract void engineUpdate(byte input);

    
    protected abstract void engineUpdate(byte[] input, int offset, int len);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.395 -0400", hash_original_method = "63E93F26D259525D134C674633CD9D02", hash_generated_method = "A89D0F3449519A2B0DAAF87870BB702C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void engineUpdate(ByteBuffer input) {
        dsTaint.addTaint(input.dsTaint);
        {
            boolean varE54245A319FB90E6E4BB7E9A96B716C3_536216660 = (!input.hasRemaining());
        } //End collapsed parenthetic
        byte[] tmp;
        {
            boolean var011961AA1A198646CB962085FB0562D5_1897408252 = (input.hasArray());
            {
                tmp = input.array();
                int offset;
                offset = input.arrayOffset();
                int position;
                position = input.position();
                int limit;
                limit = input.limit();
                engineUpdate(tmp, offset+position, limit - position);
                input.position(limit);
            } //End block
            {
                tmp = new byte[input.limit() - input.position()];
                input.get(tmp);
                engineUpdate(tmp, 0, tmp.length);
            } //End block
        } //End collapsed parenthetic
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

    
    protected abstract byte[] engineDigest();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.396 -0400", hash_original_method = "D264912F1C73FF5788F885ED0FD28756", hash_generated_method = "E66D7BB1D8CCC46AAAC127052933B0CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int engineDigest(byte[] buf, int offset, int len) throws DigestException {
        dsTaint.addTaint(len);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(buf[0]);
        {
            boolean var0728C0E705DD9A0A8E1467295A1F681F_542828652 = (len < engineGetDigestLength());
            {
                engineReset();
                if (DroidSafeAndroidRuntime.control) throw new DigestException("The value of len parameter is less than the actual digest length");
            } //End block
        } //End collapsed parenthetic
        {
            engineReset();
            if (DroidSafeAndroidRuntime.control) throw new DigestException("offset < 0");
        } //End block
        {
            engineReset();
            if (DroidSafeAndroidRuntime.control) throw new DigestException("offset + len > buf.length");
        } //End block
        byte[] tmp;
        tmp = engineDigest();
        {
            if (DroidSafeAndroidRuntime.control) throw new DigestException("The value of len parameter is less than the actual digest length");
        } //End block
        System.arraycopy(tmp, 0, buf, offset, tmp.length);
        return dsTaint.getTaintInt();
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

    
    protected abstract void engineReset();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.396 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "7A287D27D7B8CCD077A358CD2CE27544")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() throws CloneNotSupportedException {
        Object var234434AAD2BC7C43140CB7A97B63D24C_2035860260 = (super.clone());
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

