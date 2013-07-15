package org.bouncycastle.crypto.params;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.bouncycastle.crypto.CipherParameters;

public class ParametersWithIV implements CipherParameters {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:41.367 -0400", hash_original_field = "F0B53B2DA041FCA49EF0B9839060B345", hash_generated_field = "EF60E6736481A45AB4AEED35775132C4")

    private byte[] iv;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:41.367 -0400", hash_original_field = "166E64F6C3677D0C513901242A3E702D", hash_generated_field = "37E4A1EB8E400F5F526111B05CB36773")

    private CipherParameters parameters;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:41.367 -0400", hash_original_method = "02220345FBEC664F191759358E3133FB", hash_generated_method = "6BABCE7FA5D667F461C3C5D358B7706C")
    public  ParametersWithIV(
        CipherParameters    parameters,
        byte[]              iv) {
        this(parameters, iv, 0, iv.length);
        addTaint(iv[0]);
        addTaint(parameters.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:41.368 -0400", hash_original_method = "828E5FEC62EC7B691A55A07AD37E3F65", hash_generated_method = "15C0E1CCF15C13F0F986A26163EB8C91")
    public  ParametersWithIV(
        CipherParameters    parameters,
        byte[]              iv,
        int                 ivOff,
        int                 ivLen) {
        addTaint(ivOff);
        this.iv = new byte[ivLen];
        this.parameters = parameters;
        System.arraycopy(iv, ivOff, this.iv, 0, ivLen);
        // ---------- Original Method ----------
        //this.iv = new byte[ivLen];
        //this.parameters = parameters;
        //System.arraycopy(iv, ivOff, this.iv, 0, ivLen);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:41.369 -0400", hash_original_method = "D19EA42446BC5DC2CC45B356827C0DC7", hash_generated_method = "E87DE6F16DBB9A4E31DCCA0268FA02B0")
    public byte[] getIV() {
        byte[] varF0B53B2DA041FCA49EF0B9839060B345_1964996980 = (iv);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_709850034 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_709850034;
        // ---------- Original Method ----------
        //return iv;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:41.369 -0400", hash_original_method = "4D76F2EFD1EF9C1CA864824F06254E67", hash_generated_method = "DD6B56145C8B65B1DFA041347100D2B9")
    public CipherParameters getParameters() {
CipherParameters var3CB0A38B794BDEDADB1F50256E0AE35B_993589388 =         parameters;
        var3CB0A38B794BDEDADB1F50256E0AE35B_993589388.addTaint(taint);
        return var3CB0A38B794BDEDADB1F50256E0AE35B_993589388;
        // ---------- Original Method ----------
        //return parameters;
    }

    
}

