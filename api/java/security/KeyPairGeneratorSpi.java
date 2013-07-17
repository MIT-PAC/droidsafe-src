package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.security.spec.AlgorithmParameterSpec;

public abstract class KeyPairGeneratorSpi {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.957 -0400", hash_original_method = "CDF881F5D78C7440721315183DA160B5", hash_generated_method = "A796CA261F352E71417CD5D1ED45A3DF")
    public  KeyPairGeneratorSpi() {
        // ---------- Original Method ----------
    }

    
    public abstract KeyPair generateKeyPair();

    
    public abstract void initialize(int keysize, SecureRandom random);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.958 -0400", hash_original_method = "C370D2A572FDE8D7C9214C2A1EC5BB2B", hash_generated_method = "5BB2C8DB89D06B961C64FC553034873D")
    public void initialize(AlgorithmParameterSpec params, SecureRandom random) throws InvalidAlgorithmParameterException {
        addTaint(random.getTaint());
        addTaint(params.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_730839425 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_730839425.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_730839425;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
}

