package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.nio.ByteBuffer;
import java.security.spec.AlgorithmParameterSpec;

public abstract class SignatureSpi {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.541 -0400", hash_original_field = "7F0E25AE98CB8CAAE133E519F90D8F55", hash_generated_field = "179FDAA6281D622A7488CD99E06D8FD3")

    protected SecureRandom appRandom;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.541 -0400", hash_original_method = "579C0D6C0992E59A5D82007FD2101B72", hash_generated_method = "579C0D6C0992E59A5D82007FD2101B72")
    public SignatureSpi ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    protected abstract void engineInitVerify(PublicKey publicKey)
            throws InvalidKeyException;

    
    @DSModeled(DSC.SAFE)
    protected abstract void engineInitSign(PrivateKey privateKey)
            throws InvalidKeyException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.542 -0400", hash_original_method = "B296906AC674D1ED6BCB89B75E33BE26", hash_generated_method = "4A98244F9B1ADE8FF226127164FF7ED3")
    protected void engineInitSign(PrivateKey privateKey, SecureRandom random) throws InvalidKeyException {
        addTaint(privateKey.getTaint());
        appRandom = random;
        engineInitSign(privateKey);
        // ---------- Original Method ----------
        //appRandom = random;
        //engineInitSign(privateKey);
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract void engineUpdate(byte b) throws SignatureException;

    
    @DSModeled(DSC.SAFE)
    protected abstract void engineUpdate(byte[] b, int off, int len)
            throws SignatureException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.543 -0400", hash_original_method = "71C4E934CEE377EFD0E73DFCB679FE83", hash_generated_method = "186806CEACAA265CB7CA2FC83C818E2D")
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
            try 
            {
                engineUpdate(tmp, offset + position, limit - position);
            } //End block
            catch (SignatureException e)
            {
                RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_807992311 = new RuntimeException(e);
                varC76ADF009CE2FEDD948F7A54F409BA37_807992311.addTaint(taint);
                throw varC76ADF009CE2FEDD948F7A54F409BA37_807992311;
            } //End block
            input.position(limit);
        } //End block
        else
        {
            tmp = new byte[input.limit() - input.position()];
            input.get(tmp);
            try 
            {
                engineUpdate(tmp, 0, tmp.length);
            } //End block
            catch (SignatureException e)
            {
                RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_1755970113 = new RuntimeException(e);
                varC76ADF009CE2FEDD948F7A54F409BA37_1755970113.addTaint(taint);
                throw varC76ADF009CE2FEDD948F7A54F409BA37_1755970113;
            } //End block
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

    
    @DSModeled(DSC.SAFE)
    protected abstract byte[] engineSign() throws SignatureException;

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.544 -0400", hash_original_method = "1C34A6699CF243CE14ADEEFCA006987F", hash_generated_method = "89495518D8D185BE00644943DB76BE50")
    protected int engineSign(byte[] outbuf, int offset, int len) throws SignatureException {
        addTaint(len);
        addTaint(offset);
        addTaint(outbuf[0]);
        byte[] tmp = engineSign();
        if(tmp == null)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_757510200 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_231681194 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_231681194;
        } //End block
        if(len < tmp.length)        
        {
            SignatureException var793DE458F5DAFD639B51EAC37CB6B485_1956383045 = new SignatureException("The value of len parameter is less than the actual signature length");
            var793DE458F5DAFD639B51EAC37CB6B485_1956383045.addTaint(taint);
            throw var793DE458F5DAFD639B51EAC37CB6B485_1956383045;
        } //End block
        if(offset < 0)        
        {
            SignatureException varC087FC5A907B40AA758ABA3900E2EC41_228457415 = new SignatureException("offset < 0");
            varC087FC5A907B40AA758ABA3900E2EC41_228457415.addTaint(taint);
            throw varC087FC5A907B40AA758ABA3900E2EC41_228457415;
        } //End block
        if(offset + len > outbuf.length)        
        {
            SignatureException var2565465B64637ED69FEAB47586A52500_877657500 = new SignatureException("offset + len > outbuf.length");
            var2565465B64637ED69FEAB47586A52500_877657500.addTaint(taint);
            throw var2565465B64637ED69FEAB47586A52500_877657500;
        } //End block
        System.arraycopy(tmp, 0, outbuf, offset, tmp.length);
        int varE4FA7AD586BA429F593A6E87F52C4CF3_353582661 = (tmp.length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_800685263 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_800685263;
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

    
    @DSModeled(DSC.SAFE)
    protected abstract boolean engineVerify(byte[] sigBytes)
            throws SignatureException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.546 -0400", hash_original_method = "1A108B8DE7E13E12F61358DC32E2687B", hash_generated_method = "BA1EF11CD86077982A3932BA74179C9F")
    protected boolean engineVerify(byte[] sigBytes, int offset, int length) throws SignatureException {
        addTaint(length);
        addTaint(offset);
        addTaint(sigBytes[0]);
        byte[] tmp = new byte[length];
        System.arraycopy(sigBytes, offset, tmp, 0, length);
        boolean varE900B177C05AEBD098D9B1D815110B2F_1860482335 = (engineVerify(tmp));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1833947338 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1833947338;
        // ---------- Original Method ----------
        //byte[] tmp = new byte[length];
        //System.arraycopy(sigBytes, offset, tmp, 0, length);
        //return engineVerify(tmp);
    }

    
    @DSModeled(DSC.SAFE)
    @Deprecated
protected abstract void engineSetParameter(String param, Object value)
            throws InvalidParameterException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.547 -0400", hash_original_method = "09773BC31BC521068D3A412C371D22F3", hash_generated_method = "3AF1361E0FC0104B04D9FDC515BC1E94")
    protected void engineSetParameter(AlgorithmParameterSpec params) throws InvalidAlgorithmParameterException {
        addTaint(params.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_761262649 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_761262649.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_761262649;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.547 -0400", hash_original_method = "8524B01EC33E60B2ED7B8CC70F0D409D", hash_generated_method = "B42CCBA227F77C1B64215A88923591D3")
    protected AlgorithmParameters engineGetParameters() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1736660356 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1736660356.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1736660356;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SAFE)
    @Deprecated
protected abstract Object engineGetParameter(String param)
            throws InvalidParameterException;

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.548 -0400", hash_original_method = "31D01322C9910F836DA03F7FCF4D6261", hash_generated_method = "86A2BA0FD0D8E056E5C6C6E8E0D93886")
    @Override
    public Object clone() throws CloneNotSupportedException {
        if(this instanceof Cloneable)        
        {
Object var46F3A0D86742C1D6E099C2B166941A33_1757060462 =             super.clone();
            var46F3A0D86742C1D6E099C2B166941A33_1757060462.addTaint(taint);
            return var46F3A0D86742C1D6E099C2B166941A33_1757060462;
        } //End block
        CloneNotSupportedException var1615C718FF05C0D800F9FFF876AD8603_1439474511 = new CloneNotSupportedException();
        var1615C718FF05C0D800F9FFF876AD8603_1439474511.addTaint(taint);
        throw var1615C718FF05C0D800F9FFF876AD8603_1439474511;
        // ---------- Original Method ----------
        //if (this instanceof Cloneable) {
            //return super.clone();
        //}
        //throw new CloneNotSupportedException();
    }

    
}

