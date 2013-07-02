package java.security;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.security.spec.AlgorithmParameterSpec;

public abstract class KeyPairGeneratorSpi {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.226 -0400", hash_original_method = "CDF881F5D78C7440721315183DA160B5", hash_generated_method = "A796CA261F352E71417CD5D1ED45A3DF")
    public  KeyPairGeneratorSpi() {
        
    }

    
    public abstract KeyPair generateKeyPair();

    
    public abstract void initialize(int keysize, SecureRandom random);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.227 -0400", hash_original_method = "C370D2A572FDE8D7C9214C2A1EC5BB2B", hash_generated_method = "A71EFC36B7798A637568D743F936CE44")
    public void initialize(AlgorithmParameterSpec params, SecureRandom random) throws InvalidAlgorithmParameterException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(params.getTaint());
        addTaint(random.getTaint());
        
        
    }

    
}

