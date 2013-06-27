package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.nio.ByteBuffer;

public abstract class MessageDigestSpi {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.301 -0400", hash_original_method = "1CC69EEF55221D742AA45996503C6E66", hash_generated_method = "1CC69EEF55221D742AA45996503C6E66")
    public MessageDigestSpi ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.302 -0400", hash_original_method = "3B6B0B894EAF70FF02C9B2DD93EC82F9", hash_generated_method = "05DA40A5BFD5ACC1F4E6E58FA5FD622A")
    protected int engineGetDigestLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1561650805 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1561650805;
        // ---------- Original Method ----------
        //return 0;
    }

    
    protected abstract void engineUpdate(byte input);

    
    protected abstract void engineUpdate(byte[] input, int offset, int len);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.303 -0400", hash_original_method = "63E93F26D259525D134C674633CD9D02", hash_generated_method = "4FD35A6AA0FBE22A9FAF7F919D0AF105")
    protected void engineUpdate(ByteBuffer input) {
        {
            boolean varE54245A319FB90E6E4BB7E9A96B716C3_9218114 = (!input.hasRemaining());
        } //End collapsed parenthetic
        byte[] tmp;
        {
            boolean var011961AA1A198646CB962085FB0562D5_111060048 = (input.hasArray());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.307 -0400", hash_original_method = "D264912F1C73FF5788F885ED0FD28756", hash_generated_method = "D5350619DAFBB97C6FA40CA4D872C75F")
    protected int engineDigest(byte[] buf, int offset, int len) throws DigestException {
        {
            boolean var0728C0E705DD9A0A8E1467295A1F681F_1310234779 = (len < engineGetDigestLength());
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_114040244 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_114040244;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.319 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "E95312CDD7D6485F51274CD15F31DA2A")
    @Override
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1326631917 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1326631917 = super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1326631917.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1326631917;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

