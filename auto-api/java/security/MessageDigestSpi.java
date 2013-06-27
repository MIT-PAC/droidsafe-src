package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.nio.ByteBuffer;

public abstract class MessageDigestSpi {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.035 -0400", hash_original_method = "1CC69EEF55221D742AA45996503C6E66", hash_generated_method = "1CC69EEF55221D742AA45996503C6E66")
    public MessageDigestSpi ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.036 -0400", hash_original_method = "3B6B0B894EAF70FF02C9B2DD93EC82F9", hash_generated_method = "54FA4FABD4862E395F6ADAEAD06535BD")
    protected int engineGetDigestLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_174074647 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_174074647;
        // ---------- Original Method ----------
        //return 0;
    }

    
    protected abstract void engineUpdate(byte input);

    
    protected abstract void engineUpdate(byte[] input, int offset, int len);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.037 -0400", hash_original_method = "63E93F26D259525D134C674633CD9D02", hash_generated_method = "CEBF0DD5A3B299BFEFB0986C75435932")
    protected void engineUpdate(ByteBuffer input) {
        {
            boolean varE54245A319FB90E6E4BB7E9A96B716C3_846577035 = (!input.hasRemaining());
        } //End collapsed parenthetic
        byte[] tmp;
        {
            boolean var011961AA1A198646CB962085FB0562D5_1366737327 = (input.hasArray());
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
        addTaint(input.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.048 -0400", hash_original_method = "D264912F1C73FF5788F885ED0FD28756", hash_generated_method = "29694D5AFCDB35C45F9E90EB74390ABF")
    protected int engineDigest(byte[] buf, int offset, int len) throws DigestException {
        {
            boolean var0728C0E705DD9A0A8E1467295A1F681F_1766095332 = (len < engineGetDigestLength());
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
        addTaint(buf[0]);
        addTaint(offset);
        addTaint(len);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_940431133 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_940431133;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.057 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "933CE804FEB5CE3D45C0CB2FC815B285")
    @Override
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_90397239 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_90397239 = super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_90397239.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_90397239;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

