package java.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;

public final class KeyPair implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.981 -0500", hash_original_field = "023CECE5F37B287B37A790157CE63873", hash_generated_field = "07AAFE09296E79DE4CD9DDFF85CB5BFC")

    private static final long serialVersionUID = -7565189502268009837L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.983 -0500", hash_original_field = "E343478F4FCDDE86054B291B9794F31B", hash_generated_field = "0BDA09A35A184B3500330A0D915760C1")

    private  PrivateKey privateKey;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.986 -0500", hash_original_field = "B73719A7AAE8E737607C294F86B7D620", hash_generated_field = "597E676F0E34E7523D486C2FEA821479")

    private  PublicKey publicKey;

    /**
     * Constructs a new instance of {@code KeyPair} with a public key and the
     * corresponding private key.
     *
     * @param publicKey
     *            the public key.
     * @param privateKey
     *            the private key.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.988 -0500", hash_original_method = "283304EE488E7CC511471A1BB564958E", hash_generated_method = "86C254513ECA923A9F08846838AF5892")
    
public KeyPair(PublicKey publicKey, PrivateKey privateKey) {
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    /**
     * Returns the private key.
     *
     * @return the private key.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.990 -0500", hash_original_method = "3FFC913C725561B27B9684931E08C69F", hash_generated_method = "84368FE1E2A592A7742CA323B46771F5")
    
public PrivateKey getPrivate() {
        return privateKey;
    }

    /**
     * Returns the public key.
     *
     * @return the public key.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.993 -0500", hash_original_method = "6C6DB8409915627C7F2AEC2B5C46974F", hash_generated_method = "96498FAE112785B7A14D5367EC416CAF")
    
public PublicKey getPublic() {
        return publicKey;
    }
}

