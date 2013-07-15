package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.nio.ByteBuffer;
import java.security.spec.AlgorithmParameterSpec;

public abstract class SignatureSpi {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.554 -0400", hash_original_field = "7F0E25AE98CB8CAAE133E519F90D8F55", hash_generated_field = "179FDAA6281D622A7488CD99E06D8FD3")

    protected SecureRandom appRandom;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.554 -0400", hash_original_method = "579C0D6C0992E59A5D82007FD2101B72", hash_generated_method = "579C0D6C0992E59A5D82007FD2101B72")
    public SignatureSpi ()
    {
        //Synthesized constructor
    }


    protected abstract void engineInitVerify(PublicKey publicKey)
            throws InvalidKeyException;

    
    protected abstract void engineInitSign(PrivateKey privateKey)
            throws InvalidKeyException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.555 -0400", hash_original_method = "B296906AC674D1ED6BCB89B75E33BE26", hash_generated_method = "4A98244F9B1ADE8FF226127164FF7ED3")
    protected void engineInitSign(PrivateKey privateKey, SecureRandom random) throws InvalidKeyException {
        addTaint(privateKey.getTaint());
        appRandom = random;
        engineInitSign(privateKey);
        // ---------- Original Method ----------
        //appRandom = random;
        //engineInitSign(privateKey);
    }

    
    protected abstract void engineUpdate(byte b) throws SignatureException;

    
    protected abstract void engineUpdate(byte[] b, int off, int len)
            throws SignatureException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.556 -0400", hash_original_method = "71C4E934CEE377EFD0E73DFCB679FE83", hash_generated_method = "7594FFE4DDCA83DB4412E9044EB07BEF")
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
                RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_978629310 = new RuntimeException(e);
                varC76ADF009CE2FEDD948F7A54F409BA37_978629310.addTaint(taint);
                throw varC76ADF009CE2FEDD948F7A54F409BA37_978629310;
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
                RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_1138322859 = new RuntimeException(e);
                varC76ADF009CE2FEDD948F7A54F409BA37_1138322859.addTaint(taint);
                throw varC76ADF009CE2FEDD948F7A54F409BA37_1138322859;
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

    
    protected abstract byte[] engineSign() throws SignatureException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.557 -0400", hash_original_method = "1C34A6699CF243CE14ADEEFCA006987F", hash_generated_method = "7E4CBA6A33FC414DAD16BE40F0793495")
    protected int engineSign(byte[] outbuf, int offset, int len) throws SignatureException {
        addTaint(len);
        addTaint(offset);
        addTaint(outbuf[0]);
        byte[] tmp = engineSign();
    if(tmp == null)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_570581309 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1521022860 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1521022860;
        } //End block
    if(len < tmp.length)        
        {
            SignatureException var793DE458F5DAFD639B51EAC37CB6B485_1208890245 = new SignatureException("The value of len parameter is less than the actual signature length");
            var793DE458F5DAFD639B51EAC37CB6B485_1208890245.addTaint(taint);
            throw var793DE458F5DAFD639B51EAC37CB6B485_1208890245;
        } //End block
    if(offset < 0)        
        {
            SignatureException varC087FC5A907B40AA758ABA3900E2EC41_1471854935 = new SignatureException("offset < 0");
            varC087FC5A907B40AA758ABA3900E2EC41_1471854935.addTaint(taint);
            throw varC087FC5A907B40AA758ABA3900E2EC41_1471854935;
        } //End block
    if(offset + len > outbuf.length)        
        {
            SignatureException var2565465B64637ED69FEAB47586A52500_19481804 = new SignatureException("offset + len > outbuf.length");
            var2565465B64637ED69FEAB47586A52500_19481804.addTaint(taint);
            throw var2565465B64637ED69FEAB47586A52500_19481804;
        } //End block
        System.arraycopy(tmp, 0, outbuf, offset, tmp.length);
        int varE4FA7AD586BA429F593A6E87F52C4CF3_1839761036 = (tmp.length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1161111619 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1161111619;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.558 -0400", hash_original_method = "1A108B8DE7E13E12F61358DC32E2687B", hash_generated_method = "A7EECB28E4D3700D139D412B2DBF8004")
    protected boolean engineVerify(byte[] sigBytes, int offset, int length) throws SignatureException {
        addTaint(length);
        addTaint(offset);
        addTaint(sigBytes[0]);
        byte[] tmp = new byte[length];
        System.arraycopy(sigBytes, offset, tmp, 0, length);
        boolean varE900B177C05AEBD098D9B1D815110B2F_382102974 = (engineVerify(tmp));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2020389941 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2020389941;
        // ---------- Original Method ----------
        //byte[] tmp = new byte[length];
        //System.arraycopy(sigBytes, offset, tmp, 0, length);
        //return engineVerify(tmp);
    }

    
        @Deprecated
protected abstract void engineSetParameter(String param, Object value)
            throws InvalidParameterException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.559 -0400", hash_original_method = "09773BC31BC521068D3A412C371D22F3", hash_generated_method = "253230E3EFCC5D9AFB3586240405401E")
    protected void engineSetParameter(AlgorithmParameterSpec params) throws InvalidAlgorithmParameterException {
        addTaint(params.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_822030722 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_822030722.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_822030722;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.559 -0400", hash_original_method = "8524B01EC33E60B2ED7B8CC70F0D409D", hash_generated_method = "EA1ABAD47DC6E56CE5C242E147BB7C5C")
    protected AlgorithmParameters engineGetParameters() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1648796934 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1648796934.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1648796934;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @Deprecated
protected abstract Object engineGetParameter(String param)
            throws InvalidParameterException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.560 -0400", hash_original_method = "31D01322C9910F836DA03F7FCF4D6261", hash_generated_method = "FC48D153D9C0B729D681F7098C224B94")
    @Override
    public Object clone() throws CloneNotSupportedException {
    if(this instanceof Cloneable)        
        {
Object var46F3A0D86742C1D6E099C2B166941A33_1134618449 =             super.clone();
            var46F3A0D86742C1D6E099C2B166941A33_1134618449.addTaint(taint);
            return var46F3A0D86742C1D6E099C2B166941A33_1134618449;
        } //End block
        CloneNotSupportedException var1615C718FF05C0D800F9FFF876AD8603_2142986331 = new CloneNotSupportedException();
        var1615C718FF05C0D800F9FFF876AD8603_2142986331.addTaint(taint);
        throw var1615C718FF05C0D800F9FFF876AD8603_2142986331;
        // ---------- Original Method ----------
        //if (this instanceof Cloneable) {
            //return super.clone();
        //}
        //throw new CloneNotSupportedException();
    }

    
}

