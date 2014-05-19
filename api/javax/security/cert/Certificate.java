package javax.security.cert;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.util.Arrays;

public abstract class Certificate {

    /**
     * Creates a new {@code Certificate}.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.704 -0500", hash_original_method = "EF3B6A1B9C3991494D57A734B30AC9EA", hash_generated_method = "20DF396713DAA02310F7328ADDA40AD2")
    
public Certificate() {}

    /**
     * Compares the argument to this Certificate. If both have the same bytes
     * they are assumed to be equal.
     *
     * @param obj
     *            the {@code Certificate} to compare with this object
     * @return <code>true</code> if {@code obj} is the same as this
     *         {@code Certificate}, <code>false</code> otherwise
     * @see #hashCode
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.707 -0500", hash_original_method = "7638A14848B991538FCB5E98A2110811", hash_generated_method = "2236536B45A96F8C521CF0A7F03F6670")
    
public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Certificate)) {
            return false;
        }
        Certificate object = (Certificate) obj;
        try {
            return Arrays.equals(getEncoded(), object.getEncoded());
        } catch (CertificateEncodingException e) {
            return false;
        }
    }

    /**
     * Returns an integer hash code for the receiver. Any two objects which
     * return <code>true</code> when passed to <code>equals</code> must answer
     * the same value for this method.
     *
     * @return the receiver's hash
     * @see #equals
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.709 -0500", hash_original_method = "694012085EC68335A49724253FE100EC", hash_generated_method = "ABB931EA2622BE63EC57C620C12C47F6")
    
public int hashCode() {
        int res = 0;
        try {
            byte[] array = getEncoded();
            for (int i=0; i<array.length; i++) {
                res += array[i];
            }
        } catch (CertificateEncodingException e) {
        }
        return res;
    }

    /**
     * Returns the encoded representation for this certificate.
     *
     * @return the encoded representation for this certificate.
     * @throws CertificateEncodingException
     *             if encoding fails.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.711 -0500", hash_original_method = "97985BC010DD1187CA9D18F27C6321CC", hash_generated_method = "967CA908BE3445AA84C7FF1C69EFF907")
    
public abstract byte[] getEncoded()
            throws CertificateEncodingException;

    /**
     * Verifies that this certificate was signed with the given public key.
     *
     * @param key
     *            public key for which verification should be performed.
     * @throws CertificateException
     *             if encoding errors are detected
     * @throws NoSuchAlgorithmException
     *             if an unsupported algorithm is detected
     * @throws InvalidKeyException
     *             if an invalid key is detected
     * @throws NoSuchProviderException
     *             if there is no default provider
     * @throws SignatureException
     *             if signature errors are detected
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.714 -0500", hash_original_method = "B83CE65D5C6D1244820061871FC42D24", hash_generated_method = "25F475487B3388B4A59788D7DA6ADFA1")
    
public abstract void verify(PublicKey key)
            throws CertificateException, NoSuchAlgorithmException,
                   InvalidKeyException, NoSuchProviderException,
                   SignatureException;

    /**
     * Verifies that this certificate was signed with the given public key. Uses
     * the signature algorithm given by the provider.
     *
     * @param key
     *            public key for which verification should be performed.
     * @param sigProvider
     *            the name of the signature provider.
     * @exception CertificateException
     *                if encoding errors are detected
     * @exception NoSuchAlgorithmException
     *                if an unsupported algorithm is detected
     * @exception InvalidKeyException
     *                if an invalid key is detected
     * @exception NoSuchProviderException
     *                if the specified provider does not exists.
     * @exception SignatureException
     *                if signature errors are detected
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.716 -0500", hash_original_method = "206D0A21D5BAE0F83A1719C1D14A7E35", hash_generated_method = "D17B985B54E602C77696D4D138B8890E")
    
public abstract void verify(PublicKey key, String sigProvider)
            throws CertificateException, NoSuchAlgorithmException,
                   InvalidKeyException, NoSuchProviderException,
                   SignatureException;

    /**
     * Returns a string containing a concise, human-readable description of the
     * receiver.
     *
     * @return a printable representation for the receiver.
     */
    @DSComment("Abstract Method")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.718 -0500", hash_original_method = "D4E4943029EE450E10D723A13B21ADBA", hash_generated_method = "7EA90E50E51652C3FF11C3BD32031D10")
    
public abstract String toString();

    /**
     * Returns the public key corresponding to this certificate.
     *
     * @return the public key corresponding to this certificate.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.721 -0500", hash_original_method = "F2C717FDFBF8A1EA046A033A3AA9C5CC", hash_generated_method = "D544FA3197F301F074C9140DD12C3EA0")
    
public abstract PublicKey getPublicKey();
    
}

