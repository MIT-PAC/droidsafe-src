package org.bouncycastle.crypto.params;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.bouncycastle.crypto.CipherParameters;






public class ParametersWithIV implements CipherParameters {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:55.924 -0500", hash_original_field = "E884C91B0186461100A61CCE6B0406E0", hash_generated_field = "EF60E6736481A45AB4AEED35775132C4")

    private byte[]              iv;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:55.925 -0500", hash_original_field = "95B98FE0C5601A91715393CB954CA53B", hash_generated_field = "37E4A1EB8E400F5F526111B05CB36773")

    private CipherParameters    parameters;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:55.926 -0500", hash_original_method = "02220345FBEC664F191759358E3133FB", hash_generated_method = "FC0AA52C9E90129E04116D96B6832BDD")
    public ParametersWithIV(
        CipherParameters    parameters,
        byte[]              iv)
    {
        this(parameters, iv, 0, iv.length);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:55.926 -0500", hash_original_method = "828E5FEC62EC7B691A55A07AD37E3F65", hash_generated_method = "B641260C4389AA9F4B990975B8E142CA")
    public ParametersWithIV(
        CipherParameters    parameters,
        byte[]              iv,
        int                 ivOff,
        int                 ivLen)
    {
        this.iv = new byte[ivLen];
        this.parameters = parameters;

        System.arraycopy(iv, ivOff, this.iv, 0, ivLen);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:55.927 -0500", hash_original_method = "D19EA42446BC5DC2CC45B356827C0DC7", hash_generated_method = "EFC97A9055972B046A2769DFAEED1D6F")
    public byte[] getIV()
    {
        return iv;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:55.928 -0500", hash_original_method = "4D76F2EFD1EF9C1CA864824F06254E67", hash_generated_method = "574A09DACE341E4A2632E93FD70A2C75")
    public CipherParameters getParameters()
    {
        return parameters;
    }

    
}

