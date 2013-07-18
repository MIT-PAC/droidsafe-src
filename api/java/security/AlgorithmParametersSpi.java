package java.security;

// Droidsafe Imports
import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class AlgorithmParametersSpi {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.769 -0400", hash_original_method = "0323D51824F6B2D78575D923F8282326", hash_generated_method = "0323D51824F6B2D78575D923F8282326")
    public AlgorithmParametersSpi ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    protected abstract void engineInit(AlgorithmParameterSpec paramSpec)
            throws InvalidParameterSpecException;

    
    @DSModeled(DSC.SAFE)
    protected abstract void engineInit(byte[] params) throws IOException;

    
    @DSModeled(DSC.SAFE)
    protected abstract void engineInit(byte[] params, String format)
            throws IOException;

    
    protected abstract <T extends AlgorithmParameterSpec> T engineGetParameterSpec(
            Class<T> paramSpec) throws InvalidParameterSpecException;

    
    @DSModeled(DSC.SAFE)
    protected abstract byte[] engineGetEncoded() throws IOException;

    
    @DSModeled(DSC.SAFE)
    protected abstract byte[] engineGetEncoded(String format)
            throws IOException;

    
    @DSModeled(DSC.SAFE)
    protected abstract String engineToString();

    
}

