package java.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;
import java.security.cert.CertPath;

public final class CodeSigner implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.207 -0500", hash_original_field = "BAF8884A774DF62E276A09BDF26B6BA0", hash_generated_field = "29E3705B91FEE287C2335C4D8AA59C47")

    private static final long serialVersionUID = 6819288105193937581L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.211 -0500", hash_original_field = "C6569135C27F1E6021BDE7485FB065B4", hash_generated_field = "FC883EA50AB2FDD2C3073E407E6CEA66")

    private CertPath signerCertPath;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.215 -0500", hash_original_field = "81116940964DBAC2DFF057116D2E46D6", hash_generated_field = "0D494C7F1B090A9E890D8617AD65E8BA")

    private Timestamp timestamp;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.218 -0500", hash_original_field = "5ED776CD81502BA181156D7F28EBC9C8", hash_generated_field = "0316D82713F1CE4A6BE9BC97E8C831C1")

    private transient int hash;

    /**
     * Constructs a new instance of {@code CodeSigner}.
     *
     * @param signerCertPath
     *            the certificate path associated with this code signer.
     * @param timestamp
     *            the time stamp associated with this code signer, maybe {@code
     *            null}.
     * @throws NullPointerException
     *             if {@code signerCertPath} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.222 -0500", hash_original_method = "2D1A8E0F0018E23D2016EEE74572794C", hash_generated_method = "ECD963418CA8B31D9727E7D0EC5679BD")
    
public CodeSigner(CertPath signerCertPath, Timestamp timestamp) {
        if (signerCertPath == null) {
            throw new NullPointerException("signerCertPath == null");
        }
        this.signerCertPath = signerCertPath;
        this.timestamp = timestamp;
    }

    /**
     * Compares the specified object with this {@code CodeSigner} for equality.
     * Returns {@code true} if the specified object is also an instance of
     * {@code CodeSigner}, the two {@code CodeSigner} encapsulate the same
     * certificate path and the same time stamp, if present in both.
     *
     * @param obj
     *            object to be compared for equality with this {@code
     *            CodeSigner}.
     * @return {@code true} if the specified object is equal to this {@code
     *         CodeSigner}, otherwise {@code false}.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.227 -0500", hash_original_method = "9391ADEEB71A28BB26D9308D62C031F2", hash_generated_method = "D1C8D217DA8A3328F3F13BD41BE1E495")
    
@Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CodeSigner) {
            CodeSigner that = (CodeSigner) obj;
            if (!signerCertPath.equals(that.signerCertPath)) {
                return false;
            }
            return timestamp == null ? that.timestamp == null : timestamp
                    .equals(that.timestamp);
        }
        return false;
    }

    /**
     * Returns the certificate path associated with this {@code CodeSigner}.
     *
     * @return the certificate path associated with this {@code CodeSigner}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.231 -0500", hash_original_method = "30F2DDB76579221F80A186A0F4D6B0C1", hash_generated_method = "01A5353F5016822816912028EB92BCE2")
    
public CertPath getSignerCertPath() {
        return signerCertPath;
    }

    /**
     * Returns the time stamp associated with this {@code CodeSigner}.
     *
     * @return the time stamp associated with this {@code CodeSigner}, maybe
     *         {@code null}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.235 -0500", hash_original_method = "F117DFA1A6EB777CC4A763885DD30F8B", hash_generated_method = "4B27F1C3C30E2F31AB70EF3276E874F9")
    
public Timestamp getTimestamp() {
        return timestamp;
    }

    /**
     * Returns the hash code value for this {@code CodeSigner}. Returns the same
     * hash code for {@code CodeSigner}s that are equal to each other as
     * required by the general contract of {@link Object#hashCode}.
     *
     * @return the hash code value for this {@code CodeSigner}.
     * @see Object#equals(Object)
     * @see CodeSigner#equals(Object)
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.238 -0500", hash_original_method = "4C01119C48849B3B8C0F3B7EFA427DC4", hash_generated_method = "4F01C03BC42B5DC33901E517641097EE")
    
@Override
    public int hashCode() {
        if (hash == 0) {
            hash = signerCertPath.hashCode()
                    ^ (timestamp == null ? 0 : timestamp.hashCode());
        }
        return hash;
    }

    /**
     * Returns a string containing a concise, human-readable description of the
     * this {@code CodeSigner} including its first certificate and its time
     * stamp, if present.
     *
     * @return a printable representation for this {@code CodeSigner}.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.242 -0500", hash_original_method = "9AD37782FDC32A71B028636E3AD750B0", hash_generated_method = "EAF07D91ED239F7396733C880033622C")
    
@Override
    public String toString() {
        // There is no any special reason for '256' here, it's taken abruptly
        StringBuilder buf = new StringBuilder(256);
        // The javadoc says nothing, and the others implementations behavior seems as
        // dumping only the first certificate. Well, let's do the same.
        buf.append("CodeSigner [").append(signerCertPath.getCertificates().get(0));
        if( timestamp != null ) {
            buf.append("; ").append(timestamp);
        }
        buf.append("]");
        return buf.toString();
    }
}

