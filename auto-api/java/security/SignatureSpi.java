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
    protected SecureRandom appRandom;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.602 -0400", hash_original_method = "3A934505F5D647F2F4E0D28CFC510466", hash_generated_method = "3A934505F5D647F2F4E0D28CFC510466")
        public SignatureSpi ()
    {
    }


    protected abstract void engineInitVerify(PublicKey publicKey)
            throws InvalidKeyException;

    
    protected abstract void engineInitSign(PrivateKey privateKey)
            throws InvalidKeyException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.602 -0400", hash_original_method = "B296906AC674D1ED6BCB89B75E33BE26", hash_generated_method = "D4A94C5CCA94535365F016FDBE2B407D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void engineInitSign(PrivateKey privateKey, SecureRandom random) throws InvalidKeyException {
        dsTaint.addTaint(privateKey.dsTaint);
        dsTaint.addTaint(random.dsTaint);
        engineInitSign(privateKey);
        // ---------- Original Method ----------
        //appRandom = random;
        //engineInitSign(privateKey);
    }

    
    protected abstract void engineUpdate(byte b) throws SignatureException;

    
    protected abstract void engineUpdate(byte[] b, int off, int len)
            throws SignatureException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.603 -0400", hash_original_method = "71C4E934CEE377EFD0E73DFCB679FE83", hash_generated_method = "F36FEA7A13957C4F907D5F0DD3C41674")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void engineUpdate(ByteBuffer input) {
        dsTaint.addTaint(input.dsTaint);
        {
            boolean varE54245A319FB90E6E4BB7E9A96B716C3_966611061 = (!input.hasRemaining());
        } //End collapsed parenthetic
        byte[] tmp;
        {
            boolean var011961AA1A198646CB962085FB0562D5_1779892285 = (input.hasArray());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.603 -0400", hash_original_method = "1C34A6699CF243CE14ADEEFCA006987F", hash_generated_method = "96D3A486EF937DADEF0D160A8D8C8D71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int engineSign(byte[] outbuf, int offset, int len) throws SignatureException {
        dsTaint.addTaint(outbuf[0]);
        dsTaint.addTaint(len);
        dsTaint.addTaint(offset);
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.603 -0400", hash_original_method = "1A108B8DE7E13E12F61358DC32E2687B", hash_generated_method = "FB09C16DB8EE79DE05C1C87567E67FCF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean engineVerify(byte[] sigBytes, int offset, int length) throws SignatureException {
        dsTaint.addTaint(sigBytes[0]);
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
        byte[] tmp;
        tmp = new byte[length];
        System.arraycopy(sigBytes, offset, tmp, 0, length);
        boolean var1E1A814EA269B82FF70BA29FE59F4B53_710029693 = (engineVerify(tmp));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //byte[] tmp = new byte[length];
        //System.arraycopy(sigBytes, offset, tmp, 0, length);
        //return engineVerify(tmp);
    }

    
        @Deprecated
protected abstract void engineSetParameter(String param, Object value)
            throws InvalidParameterException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.604 -0400", hash_original_method = "09773BC31BC521068D3A412C371D22F3", hash_generated_method = "5606D58FF6CD6F591400E9BE16BF55AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void engineSetParameter(AlgorithmParameterSpec params) throws InvalidAlgorithmParameterException {
        dsTaint.addTaint(params.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.604 -0400", hash_original_method = "8524B01EC33E60B2ED7B8CC70F0D409D", hash_generated_method = "976ADFF1CD0B6147A3071E30AA3B1C2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected AlgorithmParameters engineGetParameters() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return (AlgorithmParameters)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @Deprecated
protected abstract Object engineGetParameter(String param)
            throws InvalidParameterException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.604 -0400", hash_original_method = "31D01322C9910F836DA03F7FCF4D6261", hash_generated_method = "2B4C71A2D69FE35CC9664FE516CC264E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() throws CloneNotSupportedException {
        {
            Object varDEB570B566DA7549E2F197D0AFA5A2B6_689376288 = (super.clone());
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new CloneNotSupportedException();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (this instanceof Cloneable) {
            //return super.clone();
        //}
        //throw new CloneNotSupportedException();
    }

    
}

