package java.security.cert;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayInputStream;
import java.io.NotSerializableException;
import java.io.ObjectStreamException;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public abstract class CertPath implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.233 -0500", hash_original_field = "F7F6448E7F6B5D82CA42BAE092094F29", hash_generated_field = "22A8873A3B050ACEADFDDE2FD50272BD")

    private static final long serialVersionUID = 6068470306649138683L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.236 -0500", hash_original_field = "1B03D0EF3E71EB350936336F82D5E0C5", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

    private  String type;

    /**
     * Creates a new {@code CertPath} instance for the specified certificate
     * type.
     *
     * @param type
     *            the certificate type.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.239 -0500", hash_original_method = "302897E6BB0E40528F36909A6049B176", hash_generated_method = "E98D35C9ACB3B4A38BC7920B543F7D09")
    
protected CertPath(String type) {
        this.type = type;
    }

    /**
     * Returns the type of {@code Certificate} in this instance.
     *
     * @return the certificate type.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.241 -0500", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "375DB45064AFC367CAD6F27C4CB89612")
    
public String getType() {
        return type;
    }

    /**
     * Returns {@code true} if {@code Certificate}s in the list are the same
     * type and the lists are equal (and by implication the certificates
     * contained within are the same).
     *
     * @param other
     *            {@code CertPath} to be compared for equality.
     * @return {@code true} if the object are equal, {@code false} otherwise.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.244 -0500", hash_original_method = "8F841F69BEA866198CC0B2087E3E8CE8", hash_generated_method = "2250B7527981C6F3AE3CD0DF2F747DDF")
    
public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CertPath) {
            CertPath o = (CertPath)other;
            if (getType().equals(o.getType())) {
                if (getCertificates().equals(o.getCertificates())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Overrides {@code Object.hashCode()}. The function is defined as follows:
     * <pre>
     * {@code hashCode = 31 * path.getType().hashCode() +
     * path.getCertificates().hashCode();}
     * </pre>
     *
     * @return the hash code for this instance.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.247 -0500", hash_original_method = "E8BB667E09C60EB11FBFEAA1F9E519B1", hash_generated_method = "E84BB1278EC2D7E171B60EFD5E631879")
    
public int hashCode() {
        int hash = getType().hashCode();
        hash = hash*31 + getCertificates().hashCode();
        return hash;
    }

    /**
     * Returns a {@code String} representation of this {@code CertPath}
     * instance. It is the result of calling {@code toString} on all {@code
     * Certificate}s in the {@code List}.
     *
     * @return a string representation of this instance.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.249 -0500", hash_original_method = "476AF39C272D39EAE140D33789265072", hash_generated_method = "C5ABBA0D12DFB2C6B5FC45CDFF854B7B")
    
public String toString() {
        StringBuilder sb = new StringBuilder(getType());
        sb.append(" Cert Path, len=");
        sb.append(getCertificates().size());
        sb.append(": [\n");
        int n=1;
        for (Iterator<? extends Certificate> i=getCertificates().iterator(); i.hasNext(); n++) {
            sb.append("---------------certificate ");
            sb.append(n);
            sb.append("---------------\n");
            sb.append(((Certificate)i.next()).toString());
        }
        sb.append("\n]");
        return sb.toString();
    }

    /**
     * Returns an immutable List of the {@code Certificate}s contained
     * in the {@code CertPath}.
     *
     * @return a list of {@code Certificate}s in the {@code CertPath}.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.252 -0500", hash_original_method = "F1426E2A44812D0AE4014B7629FA559D", hash_generated_method = "2227574931B83954DB8047C4709A4C7E")
    
public abstract List<? extends Certificate> getCertificates();

    /**
     * Returns an encoding of the {@code CertPath} using the default encoding.
     *
     * @return default encoding of the {@code CertPath}.
     * @throws CertificateEncodingException
     *             if the encoding fails.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.254 -0500", hash_original_method = "97985BC010DD1187CA9D18F27C6321CC", hash_generated_method = "967CA908BE3445AA84C7FF1C69EFF907")
    
public abstract byte[] getEncoded()
        throws CertificateEncodingException;

    /**
     * Returns an encoding of the {@code CertPath} using the specified encoding.
     *
     * @param encoding
     *            encoding that should be generated.
     * @return default encoding of the {@code CertPath}.
     * @throws CertificateEncodingException
     *             if the encoding fails.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.257 -0500", hash_original_method = "5A28674A03609094F71CED2E9CFD4EAB", hash_generated_method = "F97B4E54ACD29AFDDC963FCA87397711")
    
public abstract byte[] getEncoded(String encoding)
        throws CertificateEncodingException;

    /**
     * Returns an {@code Iterator} over the supported encodings for a
     * representation of the certificate path.
     *
     * @return {@code Iterator} over supported encodings (as {@code String}s).
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.260 -0500", hash_original_method = "501BBB87AB4FA040A3C6E82444EEB8D9", hash_generated_method = "12EE1216881B2F2E57E65D52688C2530")
    
public abstract Iterator<String> getEncodings();
    
    protected static class CertPathRep implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.266 -0500", hash_original_field = "9A7C3890B74FF03B82960D0B2EBE95DB", hash_generated_field = "257527E5D7CAC38935714E2F9D854C92")

        private static final long serialVersionUID = 3015633072427920915L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.274 -0500", hash_original_field = "F8F43F98A8F5BDD8B9EFA794FE49C02B", hash_generated_field = "1A6C530EB5E4196889B6FB535AA83362")

        // for cert path data
        private static final ObjectStreamField[] serialPersistentFields = {
            new ObjectStreamField("type", String.class),
            new ObjectStreamField("data", byte[].class, true),
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.269 -0500", hash_original_field = "1B03D0EF3E71EB350936336F82D5E0C5", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

        private  String type;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.271 -0500", hash_original_field = "B330DF564CD90A5498A9E4F0AB344BB9", hash_generated_field = "BCB00A81B11593F3A75239028B6E65B9")

        private  byte[] data;

        /**
         * Creates a new {@code CertPathRep} instance with the specified type
         * and encoded data.
         *
         * @param type
         *            the certificate type.
         * @param data
         *            the encoded data.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.277 -0500", hash_original_method = "306F916982958535E78B2E37AF24DE52", hash_generated_method = "A18ADE7BDBAC4941AECC3E79C5031EEB")
        
protected CertPathRep(String type, byte[] data) {
            this.type = type;
            this.data = data;
        }

        /**
         * Deserializes a {@code CertPath} from a serialized {@code CertPathRep}
         * object.
         *
         * @return the deserialized {@code CertPath}.
         * @throws ObjectStreamException
         *             if deserialization fails.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.280 -0500", hash_original_method = "901613A0C14C6295CBB5D8B0F4F8E8BD", hash_generated_method = "CADCD91BE94BBD4B9D205EA68A8F4543")
        
protected Object readResolve() throws ObjectStreamException {
            try {
                CertificateFactory cf = CertificateFactory.getInstance(type);
                return cf.generateCertPath(new ByteArrayInputStream(data));
            } catch (Throwable t) {
                throw new NotSerializableException("Could not resolve cert path: " + t);
            }
        }
    }

    /**
     * Returns an alternate object to be serialized.
     *
     * @return an alternate object to be serialized.
     * @throws ObjectStreamException
     *             if the creation of the alternate object fails.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.263 -0500", hash_original_method = "52819054EFF055A3D86733F1F32E0BA5", hash_generated_method = "5880328DF22DAE81B71A829795742E27")
    
protected Object writeReplace() throws ObjectStreamException {
        try {
            return new CertPathRep(getType(), getEncoded());
        } catch (CertificateEncodingException e) {
            throw new NotSerializableException("Could not create serialization object: " + e);
        }
    }
}

