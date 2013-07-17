package javax.crypto;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;
import org.apache.harmony.crypto.internal.NullCipherSpi;

public class NullCipher extends Cipher {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.297 -0400", hash_original_method = "88CD20CBC668B0AA4FE357EBFA9D0A37", hash_generated_method = "65A5AE0FB45FD9FCF4B248765E7ABA1E")
    public  NullCipher() {
        super(new NullCipherSpi(), null, null);
        try 
        {
            this.init(Cipher.ENCRYPT_MODE, (Key)null, (SecureRandom)null);
        } //End block
        catch (InvalidKeyException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //this.init(Cipher.ENCRYPT_MODE, (Key)null, (SecureRandom)null);
        //} catch (InvalidKeyException e) {
        //}
    }

    
}

