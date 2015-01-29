package java.security.spec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class X509EncodedKeySpec extends EncodedKeySpec {

    /**
     * Creates a new {@code X509EncodedKeySpec} with the specified encoded key
     * bytes.
     *
     * @param encodedKey
     *            the encoded key bytes.
     */
    @DSComment("no suspicious activity, just creates object")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.787 -0500", hash_original_method = "653C2DD285722882E5BF9CD68F7E16B1", hash_generated_method = "A67D46C756B7827A9B6F37BCF7C96E70")
    
public X509EncodedKeySpec(byte[] encodedKey) {
        // Super class' ctor makes defensive parameter copy
        super(encodedKey);
    }

    /**
     * Returns the encoded key bytes.
     *
     * @return the encoded key bytes.
     */
    @DSComment("no suspicious activity")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.790 -0500", hash_original_method = "79A7CC1F7A80EF2ADD7D2AFF5368D500", hash_generated_method = "E32E93258666D229EF01F9B67C223079")
    
public byte[] getEncoded() {
        // Super class' getEncoded() always returns a new array
        return super.getEncoded();
    }

    /**
     * Returns the name of the encoding format of this encoded key
     * specification.
     *
     * @return the string "X.509".
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.792 -0500", hash_original_method = "52CFE6084CDA819966418EDF944DBC96", hash_generated_method = "9D006A499B2FF2C80FEFAE144AC818F0")
    
public final String getFormat() {
        return "X.509";
    }
    
}

