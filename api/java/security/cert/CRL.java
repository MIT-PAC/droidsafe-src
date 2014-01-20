package java.security.cert;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public abstract class CRL {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.024 -0500", hash_original_field = "1B03D0EF3E71EB350936336F82D5E0C5", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

    private  String type;

    /**
     * Creates a new certificate revocation list of the specified type.
     *
     * @param type
     *            the type for the CRL.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.027 -0500", hash_original_method = "F343602788E22E62E7F41ECF989C2105", hash_generated_method = "5B986CA51E056358B9C1BA8C794E9825")
    
protected CRL(String type) {
        this.type = type;
    }

    /**
     * Returns the type of this CRL.
     *
     * @return the type of this CRL.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.029 -0500", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "B5025B3379E65F477B29B0C5C8B783DF")
    
public final String getType() {
        return type;
    }

    /**
     * Returns whether the specified certificate is revoked by this CRL.
     *
     * @param cert
     *            the certificate to check.
     * @return {@code true} if the certificate is revoked by this CRL, otherwise
     *         {@code false}.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.032 -0500", hash_original_method = "7535F863E9ECA41180B61FD2B41FAD02", hash_generated_method = "D6F72261C48256DC21A27BCC771AFA2D")
    
public abstract boolean isRevoked(Certificate cert);

    /**
     * Returns the string representation of this instance.
     *
     * @return the string representation of this instance.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.035 -0500", hash_original_method = "D4E4943029EE450E10D723A13B21ADBA", hash_generated_method = "7EA90E50E51652C3FF11C3BD32031D10")
    
public abstract String toString();
    
}

