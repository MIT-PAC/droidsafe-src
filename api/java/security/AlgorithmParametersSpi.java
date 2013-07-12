package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;

public abstract class AlgorithmParametersSpi {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:57.939 -0400", hash_original_method = "0323D51824F6B2D78575D923F8282326", hash_generated_method = "0323D51824F6B2D78575D923F8282326")
    public AlgorithmParametersSpi ()
    {
        //Synthesized constructor
    }


    protected abstract void engineInit(AlgorithmParameterSpec paramSpec)
            throws InvalidParameterSpecException;

    
    protected abstract void engineInit(byte[] params) throws IOException;

    
    protected abstract void engineInit(byte[] params, String format)
            throws IOException;

    
    protected abstract <T extends AlgorithmParameterSpec> T engineGetParameterSpec(
            Class<T> paramSpec) throws InvalidParameterSpecException;

    
    protected abstract byte[] engineGetEncoded() throws IOException;

    
    protected abstract byte[] engineGetEncoded(String format)
            throws IOException;

    
    protected abstract String engineToString();

    
}

