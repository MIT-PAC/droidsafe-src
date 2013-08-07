package org.bouncycastle.crypto;

// Droidsafe Imports
import droidsafe.annotations.*;


public class RuntimeCryptoException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.487 -0400", hash_original_method = "967763ED132A6B5D59753D4D73A06C5A", hash_generated_method = "D6A2F7F0EC5B2291AE5C6C87E6295099")
    public  RuntimeCryptoException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.487 -0400", hash_original_method = "E9BB75E73BA30AD97FC5CFD7AF8A9F87", hash_generated_method = "383E90D38FAFD32EB8D3C2B60414DEA5")
    public  RuntimeCryptoException(
        String  message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
}

