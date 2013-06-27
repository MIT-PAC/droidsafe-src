package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.nio.ByteBuffer;
import java.security.spec.AlgorithmParameterSpec;

public abstract class SignatureSpi {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.573 -0400", hash_original_field = "7F0E25AE98CB8CAAE133E519F90D8F55", hash_generated_field = "179FDAA6281D622A7488CD99E06D8FD3")

    protected SecureRandom appRandom;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.573 -0400", hash_original_method = "579C0D6C0992E59A5D82007FD2101B72", hash_generated_method = "579C0D6C0992E59A5D82007FD2101B72")
    public SignatureSpi ()
    {
        //Synthesized constructor
    }


    protected abstract void engineInitVerify(PublicKey publicKey)
            throws InvalidKeyException;

    
    protected abstract void engineInitSign(PrivateKey privateKey)
            throws InvalidKeyException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.583 -0400", hash_original_method = "B296906AC674D1ED6BCB89B75E33BE26", hash_generated_method = "D4BFE09E7FEF5095911C1C9BDF919E2C")
    protected void engineInitSign(PrivateKey privateKey, SecureRandom random) throws InvalidKeyException {
        appRandom = random;
        engineInitSign(privateKey);
        addTaint(privateKey.getTaint());
        // ---------- Original Method ----------
        //appRandom = random;
        //engineInitSign(privateKey);
    }

    
    protected abstract void engineUpdate(byte b) throws SignatureException;

    
    protected abstract void engineUpdate(byte[] b, int off, int len)
            throws SignatureException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.584 -0400", hash_original_method = "71C4E934CEE377EFD0E73DFCB679FE83", hash_generated_method = "61685A863314BA682E095E19D92D8C0E")
    protected void engineUpdate(ByteBuffer input) {
        {
            boolean varE54245A319FB90E6E4BB7E9A96B716C3_1979585794 = (!input.hasRemaining());
        } //End collapsed parenthetic
        byte[] tmp;
        {
            boolean var011961AA1A198646CB962085FB0562D5_688536590 = (input.hasArray());
            {
                tmp = input.array();
                int offset;
                offset = input.arrayOffset();
                int position;
                position = input.position();
                int limit;
                limit = input.limit();
                try 
                {
                    engineUpdate(tmp, offset + position, limit - position);
                } //End block
                catch (SignatureException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
                } //End block
                input.position(limit);
            } //End block
            {
                tmp = new byte[input.limit() - input.position()];
                input.get(tmp);
                try 
                {
                    engineUpdate(tmp, 0, tmp.length);
                } //End block
                catch (SignatureException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
                } //End block
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
            //try {
                //engineUpdate(tmp, offset + position, limit - position);
            //} catch (SignatureException e) {
                //throw new RuntimeException(e); 
            //}
            //input.position(limit);
        //} else {
            //tmp = new byte[input.limit() - input.position()];
            //input.get(tmp);
            //try {
                //engineUpdate(tmp, 0, tmp.length);
            //} catch (SignatureException e) {
                //throw new RuntimeException(e); 
            //}
        //}
    }

    
    protected abstract byte[] engineSign() throws SignatureException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.591 -0400", hash_original_method = "1C34A6699CF243CE14ADEEFCA006987F", hash_generated_method = "031A8BC8E008C5C3088975A8A12B4AA4")
    protected int engineSign(byte[] outbuf, int offset, int len) throws SignatureException {
        byte[] tmp;
        tmp = engineSign();
        {
            if (DroidSafeAndroidRuntime.control) throw new SignatureException("The value of len parameter is less than the actual signature length");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new SignatureException("offset < 0");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new SignatureException("offset + len > outbuf.length");
        } //End block
        System.arraycopy(tmp, 0, outbuf, offset, tmp.length);
        addTaint(outbuf[0]);
        addTaint(offset);
        addTaint(len);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1439796418 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1439796418;
        // ---------- Original Method ----------
        //byte[] tmp = engineSign();
        //if (tmp == null) {
            //return 0;
        //}
        //if (len < tmp.length) {
            //throw new SignatureException("The value of len parameter is less than the actual signature length");
        //}
        //if (offset < 0) {
            //throw new SignatureException("offset < 0");
        //}
        //if (offset + len > outbuf.length) {
            //throw new SignatureException("offset + len > outbuf.length");
        //}
        //System.arraycopy(tmp, 0, outbuf, offset, tmp.length);
        //return tmp.length;
    }

    
    protected abstract boolean engineVerify(byte[] sigBytes)
            throws SignatureException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.598 -0400", hash_original_method = "1A108B8DE7E13E12F61358DC32E2687B", hash_generated_method = "D483559B6F62902672433064014070C6")
    protected boolean engineVerify(byte[] sigBytes, int offset, int length) throws SignatureException {
        byte[] tmp;
        tmp = new byte[length];
        System.arraycopy(sigBytes, offset, tmp, 0, length);
        boolean var1E1A814EA269B82FF70BA29FE59F4B53_1575172699 = (engineVerify(tmp));
        addTaint(sigBytes[0]);
        addTaint(offset);
        addTaint(length);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1710379281 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1710379281;
        // ---------- Original Method ----------
        //byte[] tmp = new byte[length];
        //System.arraycopy(sigBytes, offset, tmp, 0, length);
        //return engineVerify(tmp);
    }

    
        @Deprecated
protected abstract void engineSetParameter(String param, Object value)
            throws InvalidParameterException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.599 -0400", hash_original_method = "09773BC31BC521068D3A412C371D22F3", hash_generated_method = "93DAA0D9AA1F787D91827786DAA2CB92")
    protected void engineSetParameter(AlgorithmParameterSpec params) throws InvalidAlgorithmParameterException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.613 -0400", hash_original_method = "8524B01EC33E60B2ED7B8CC70F0D409D", hash_generated_method = "7D60887B06E007D941A2154E83C7DFA5")
    protected AlgorithmParameters engineGetParameters() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @Deprecated
protected abstract Object engineGetParameter(String param)
            throws InvalidParameterException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.613 -0400", hash_original_method = "31D01322C9910F836DA03F7FCF4D6261", hash_generated_method = "4E346774A1DA2810627D8ABF7100A812")
    @Override
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1179929871 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_1179929871 = super.clone();
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new CloneNotSupportedException();
        varB4EAC82CA7396A68D541C85D26508E83_1179929871.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1179929871;
        // ---------- Original Method ----------
        //if (this instanceof Cloneable) {
            //return super.clone();
        //}
        //throw new CloneNotSupportedException();
    }

    
}

