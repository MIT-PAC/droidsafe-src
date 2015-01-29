package java.security.spec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class PKCS8EncodedKeySpec extends EncodedKeySpec {

    /**
     * Creates a new {@code PKCS8EncodedKeySpec} with the specified encoded key
     * bytes.
     *
     * @param encodedKey
     *            the encoded key bytes.
     */
    @DSComment("no suspicious activity")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.713 -0500", hash_original_method = "EEE3491490D4DFB630EB03F68D682F22", hash_generated_method = "86C6D6A7BC7FF0954F0F19E99C2DA49F")
    
public PKCS8EncodedKeySpec(byte[] encodedKey) {
        // Super class' ctor makes defensive parameter copy
        super(encodedKey);
    }

    /**
     * Returns a copy of the encoded key bytes.
     *
     * @return a copy of the encoded key bytes.
     */
    @DSComment("no suspicious activity")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.715 -0500", hash_original_method = "79A7CC1F7A80EF2ADD7D2AFF5368D500", hash_generated_method = "E32E93258666D229EF01F9B67C223079")
    
public byte[] getEncoded() {
        // Super class' getEncoded() always returns a new array
        return super.getEncoded();
    }

    /**
     * Returns the name of the encoding format of this encoded key
     * specification.
     *
     * @return the string "PKCS#8".
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.718 -0500", hash_original_method = "CC009CA66A5AFAFE0E87AA4EEC147948", hash_generated_method = "B50F99C7BAF445D2AA7C64194FE029F2")
    
public final String getFormat() {
        return "PKCS#8";
    }
    
}

