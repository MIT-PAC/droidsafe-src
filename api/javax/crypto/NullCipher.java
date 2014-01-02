package javax.crypto;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;

import org.apache.harmony.crypto.internal.NullCipherSpi;



public class NullCipher extends Cipher {

    /**
     * Creates a new {@code NullCipher} instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.907 -0500", hash_original_method = "88CD20CBC668B0AA4FE357EBFA9D0A37", hash_generated_method = "89406841F3C0132922C311A94FEA334A")
    
public NullCipher() {
        super(new NullCipherSpi(), null, null);
        try {
            this.init(Cipher.ENCRYPT_MODE, (Key)null, (SecureRandom)null);
        } catch (InvalidKeyException e) {
        }
    }

    
}

