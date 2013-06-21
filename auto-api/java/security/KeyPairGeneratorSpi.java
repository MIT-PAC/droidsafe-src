package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.spec.AlgorithmParameterSpec;

public abstract class KeyPairGeneratorSpi {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.338 -0400", hash_original_method = "CDF881F5D78C7440721315183DA160B5", hash_generated_method = "A796CA261F352E71417CD5D1ED45A3DF")
    @DSModeled(DSC.SAFE)
    public KeyPairGeneratorSpi() {
        // ---------- Original Method ----------
    }

    
    public abstract KeyPair generateKeyPair();

    
    public abstract void initialize(int keysize, SecureRandom random);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.338 -0400", hash_original_method = "C370D2A572FDE8D7C9214C2A1EC5BB2B", hash_generated_method = "9198EB99C27A2C98D9A79A8DB5459E54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void initialize(AlgorithmParameterSpec params, SecureRandom random) throws InvalidAlgorithmParameterException {
        dsTaint.addTaint(random.dsTaint);
        dsTaint.addTaint(params.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
}

