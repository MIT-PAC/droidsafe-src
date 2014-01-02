package javax.crypto;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

import org.apache.harmony.security.asn1.ASN1Any;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1OctetString;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1SetOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.utils.AlgNameMapper;
import org.apache.harmony.security.x509.AlgorithmIdentifier;






public class EncryptedPrivateKeyInfo {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.909 -0500", hash_original_method = "C7F017D6BF0E95CAC7E674AE844EA4C0", hash_generated_method = "771F301A53C79B4866730FA1B1BFDF03")
    
private static boolean isNullValue(byte[] toCheck) {
        return toCheck[0] == 5 && toCheck[1] == 0;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.945 -0500", hash_original_field = "6AA659307682AEBB3689DA3CB2EFE970", hash_generated_field = "3BB751772098CBC3BE6239971FC3AA39")

    // EncryptedPrivateKeyInfo DER encoder/decoder.
    // EncryptedPrivateKeyInfo ASN.1 definition
    // (as defined in PKCS #8: Private-Key Information Syntax Standard
    //  http://www.ietf.org/rfc/rfc2313.txt)
    //
    // EncryptedPrivateKeyInfo ::=  SEQUENCE {
    //      encryptionAlgorithm   AlgorithmIdentifier,
    //      encryptedData   OCTET STRING }
    //

    private static final byte[] nullParam = new byte[] { 5, 0 };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.195 -0400", hash_original_field = "3915FFC8629FD83CE2C58F175000FC30", hash_generated_field = "60288359336523FE1C59A5FB75AA0AE8")

    private static final ASN1Sequence asn1 = new ASN1Sequence(new ASN1Type[] {
            AlgorithmIdentifier.ASN1, ASN1OctetString.getInstance() }) {

                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.949 -0500", hash_original_method = "C7B48C01EA9BD54A7C386B9C416EAF20", hash_generated_method = "48CF409BFA2FD98CA784817441662D7D")
        
@Override
                protected void getValues(Object object, Object[] values) {

                    EncryptedPrivateKeyInfo epki = (EncryptedPrivateKeyInfo) object;

                    try {
                        byte[] algParmsEncoded = (epki.algParameters == null) ? nullParam
                                : epki.algParameters.getEncoded();
                        values[0] = new AlgorithmIdentifier(epki.oid, algParmsEncoded);
                        values[1] = epki.encryptedData;
                    } catch (IOException e) {
                        throw new RuntimeException(e.getMessage());
                    }
                }

        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.954 -0500", hash_original_field = "A11EDF8CF3A8BB86D36A267914CFC02F", hash_generated_field = "FECDA1F83CA859E5D8EFB1232126B5BC")

    // PrivateKeyInfo ASN.1 definition
    // (as defined in PKCS #8: Private-Key Information Syntax Standard
    //  http://www.ietf.org/rfc/rfc2313.txt)
    //
    //
    //    PrivateKeyInfo ::= SEQUENCE {
    //        version Version,
    //        privateKeyAlgorithm PrivateKeyAlgorithmIdentifier,
    //        privateKey PrivateKey,
    //        attributes [0] IMPLICIT Attributes OPTIONAL }
    //
    //      Version ::= INTEGER
    //
    //      PrivateKeyAlgorithmIdentifier ::= AlgorithmIdentifier
    //
    //      PrivateKey ::= OCTET STRING
    //
    //      Attributes ::= SET OF Attribute

    private static final ASN1SetOf ASN1Attributes = new ASN1SetOf(ASN1Any.getInstance());
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.957 -0500", hash_original_field = "D26FDF2D9014955F3EDD22BA2379AFC1", hash_generated_field = "3F79D30007B2B4B6B1391DB32F1ED09E")


    private static final ASN1Sequence ASN1PrivateKeyInfo = new ASN1Sequence(
            new ASN1Type[] { ASN1Integer.getInstance(), AlgorithmIdentifier.ASN1,
                    ASN1OctetString.getInstance(),
                    new ASN1Implicit(0, ASN1Attributes) }) {
        {
            setOptional(3); //attributes are optional
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.895 -0500", hash_original_field = "185F123DDE5C4A6836DC3E442124135F", hash_generated_field = "660D008EA392E932E9C27E468BE1012B")

    private String algName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.897 -0500", hash_original_field = "E821E523F1E958F6986B4B19804F6B2B", hash_generated_field = "F067F90327B8A01DE7755B4FD06CC969")

    private  AlgorithmParameters algParameters;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.899 -0500", hash_original_field = "608FC506AA693B29FB44BD7478B0A23D", hash_generated_field = "B29484238F58CF38DC30E0B9CE6E09D3")

    private  byte[] encryptedData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.902 -0500", hash_original_field = "9C420410CA5A3136C0764F58D4287A0B", hash_generated_field = "D745B114B0A51171DAD36F87C0CC38B4")

    private String oid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.904 -0500", hash_original_field = "B26EA4441AC976CE9D513DB2C8639526", hash_generated_field = "30CBCFF31EBF02BAF8CCE8746893E2BE")

    private volatile byte[] encoded;

    /**
     * Creates an {@code EncryptedPrivateKeyInfo} instance from its encoded
     * representation by parsing it.
     *
     * @param encoded
     *            the encoded representation of this object
     * @throws IOException
     *             if parsing the encoded representation fails.
     * @throws NullPointerException
     *             if {@code encoded} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.907 -0500", hash_original_method = "5968D7DC318FA4818B0D7FF4BA782716", hash_generated_method = "35DDAD652CB58CF16A4FC25D3CC36893")
    
public EncryptedPrivateKeyInfo(byte[] encoded) throws IOException {
        if (encoded == null) {
            throw new NullPointerException("encoded == null");
        }
        this.encoded = new byte[encoded.length];
        System.arraycopy(encoded, 0, this.encoded, 0, encoded.length);
        Object[] values;

        values = (Object[])asn1.decode(encoded);

        AlgorithmIdentifier aId = (AlgorithmIdentifier) values[0];

        algName = aId.getAlgorithm();
        // algName == oid now
        boolean mappingExists = mapAlgName();
        // algName == name from map oid->name if mapping exists, or
        // algName == oid if mapping does not exist

        AlgorithmParameters aParams = null;
        byte[] params = aId.getParameters();
        if (params != null && !isNullValue(params)) {
            try {
                aParams = AlgorithmParameters.getInstance(algName);
                aParams.init(aId.getParameters());
                if (!mappingExists) {
                    algName = aParams.getAlgorithm();
                }
            } catch (NoSuchAlgorithmException e) {
            }
        }
        algParameters = aParams;

        encryptedData = (byte[]) values[1];
    }

    /**
     * Creates an {@code EncryptedPrivateKeyInfo} instance from an algorithm
     * name and its encrypted data.
     *
     * @param encrAlgName
     *            the name of an algorithm.
     * @param encryptedData
     *            the encrypted data.
     * @throws NoSuchAlgorithmException
     *             if the {@code encrAlgName} is not a supported algorithm.
     * @throws NullPointerException
     *             if {@code encrAlgName} or {@code encryptedData} is {@code
     *             null}.
     * @throws IllegalArgumentException
     *             if {@code encryptedData} is empty.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.912 -0500", hash_original_method = "C009D0E8F0D5EB33E14FDFB24A942703", hash_generated_method = "90B51164B2B5F6D1BAEE74AACBC078CB")
    
public EncryptedPrivateKeyInfo(String encrAlgName, byte[] encryptedData)
        throws NoSuchAlgorithmException {
        if (encrAlgName == null) {
            throw new NullPointerException("the algName parameter is null");
        }
        this.algName = encrAlgName;
        if (!mapAlgName()) {
            throw new NoSuchAlgorithmException("Unsupported algorithm: " + this.algName);
        }
        if (encryptedData == null) {
            throw new NullPointerException("encryptedData == null");
        }
        if (encryptedData.length == 0) {
            throw new IllegalArgumentException("encryptedData.length == 0");
        }
        this.encryptedData = new byte[encryptedData.length];
        System.arraycopy(encryptedData, 0,
                this.encryptedData, 0, encryptedData.length);
        this.algParameters = null;
    }

    /**
     * Creates an {@code EncryptedPrivateKeyInfo} instance from the
     * encryption algorithm parameters an its encrypted data.
     *
     * @param algParams
     *            the encryption algorithm parameters.
     * @param encryptedData
     *            the encrypted data.
     * @throws NoSuchAlgorithmException
     *             if the algorithm name of the specified {@code algParams}
     *             parameter is not supported.
     * @throws NullPointerException
     *             if {@code algParams} or {@code encryptedData} is
     *             {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.916 -0500", hash_original_method = "5A4FF1B4B6EE8C8ABD405D2DD33761E1", hash_generated_method = "1C1631A0E74EAD9E9B3F3FC9AAFD9227")
    
public EncryptedPrivateKeyInfo(AlgorithmParameters algParams, byte[] encryptedData)
        throws NoSuchAlgorithmException {
        if (algParams == null) {
            throw new NullPointerException("algParams == null");
        }
        this.algParameters = algParams;
        if (encryptedData == null) {
            throw new NullPointerException("encryptedData == null");
        }
        if (encryptedData.length == 0) {
            throw new IllegalArgumentException("encryptedData.length == 0");
        }
        this.encryptedData = new byte[encryptedData.length];
        System.arraycopy(encryptedData, 0,
                this.encryptedData, 0, encryptedData.length);
        this.algName = this.algParameters.getAlgorithm();
        if (!mapAlgName()) {
            throw new NoSuchAlgorithmException("Unsupported algorithm: " + this.algName);
        }
    }

    /**
     * Returns the name of the encryption algorithm.
     *
     * @return the name of the encryption algorithm.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.919 -0500", hash_original_method = "099B16E0CAD27366561935338A7E9D49", hash_generated_method = "5AA3D5AAD76F730C1A3ECC390DC0233B")
    
public String getAlgName() {
        return algName;
    }

    /**
     * Returns the parameters used by the encryption algorithm.
     *
     * @return the parameters used by the encryption algorithm.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.921 -0500", hash_original_method = "E53778AACD7278B4FF9EA916DFF39F89", hash_generated_method = "7D57BF37CA5A17CA5EADF0E819A5F24E")
    
public AlgorithmParameters getAlgParameters() {
        return algParameters;
    }

    /**
     * Returns the encrypted data of this key.
     *
     * @return the encrypted data of this key, each time this method is called a
     *         new array is returned.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.923 -0500", hash_original_method = "953A1BC97C4FC2CA6B0BC7CB45B78971", hash_generated_method = "9C20FA4CC1CE75FC577A9F9BAAB21AFD")
    
public byte[] getEncryptedData() {
        byte[] ret = new byte[encryptedData.length];
        System.arraycopy(encryptedData, 0, ret, 0, encryptedData.length);
        return ret;
    }

    /**
     * Returns the {@code PKCS8EncodedKeySpec} object extracted from the
     * encrypted data.
     * <p>
     * The cipher must be initialize in either {@code Cipher.DECRYPT_MODE} or
     * {@code Cipher.UNWRAP_MODE} with the same parameters and key used for
     * encrypting this.
     *
     * @param cipher
     *            the cipher initialized for decrypting the encrypted data.
     * @return the extracted {@code PKCS8EncodedKeySpec}.
     * @throws InvalidKeySpecException
     *             if the specified cipher is not suited to decrypt the
     *             encrypted data.
     * @throws NullPointerException
     *             if {@code cipher} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.926 -0500", hash_original_method = "5E7E74DFC3F27253F408C7A3D7CB1593", hash_generated_method = "B5B5FF4BF80F8BB143008AC94EED3070")
    
public PKCS8EncodedKeySpec getKeySpec(Cipher cipher)
        throws InvalidKeySpecException {
        if (cipher == null) {
            throw new NullPointerException("cipher == null");
        }
        try {
            byte[] decryptedData = cipher.doFinal(encryptedData);
            try {
                ASN1PrivateKeyInfo.verify(decryptedData);
            } catch (IOException e1) {
                throw new InvalidKeySpecException("Decrypted data does not represent valid PKCS#8 PrivateKeyInfo");
            }
            return new PKCS8EncodedKeySpec(decryptedData);
        } catch (IllegalStateException e) {
            throw new InvalidKeySpecException(e.getMessage());
        } catch (IllegalBlockSizeException e) {
            throw new InvalidKeySpecException(e.getMessage());
        } catch (BadPaddingException e) {
            throw new InvalidKeySpecException(e.getMessage());
        }
    }

    /**
     * Returns the {@code PKCS8EncodedKeySpec} object extracted from the
     * encrypted data.
     *
     * @param decryptKey
     *            the key to decrypt the encrypted data with.
     * @return the extracted {@code PKCS8EncodedKeySpec}.
     * @throws NoSuchAlgorithmException
     *             if no usable cipher can be found to decrypt the encrypted
     *             data.
     * @throws InvalidKeyException
     *             if {@code decryptKey} is not usable to decrypt the encrypted
     *             data.
     * @throws NullPointerException
     *             if {@code decryptKey} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.929 -0500", hash_original_method = "E86A0445ED0DCCD02C804E7FA87DE046", hash_generated_method = "F49D88DE8FCC2C7D409380CE18A69C9C")
    
public PKCS8EncodedKeySpec getKeySpec(Key decryptKey) throws NoSuchAlgorithmException,
               InvalidKeyException {
        if (decryptKey == null) {
            throw new NullPointerException("decryptKey == null");
        }
        try {
            Cipher cipher = Cipher.getInstance(algName);
            if (algParameters == null) {
                cipher.init(Cipher.DECRYPT_MODE, decryptKey);
            } else {
                cipher.init(Cipher.DECRYPT_MODE, decryptKey, algParameters);
            }
            byte[] decryptedData = cipher.doFinal(encryptedData);
            try {
                ASN1PrivateKeyInfo.verify(decryptedData);
            } catch (IOException e1) {
                throw invalidKey();
            }
            return new PKCS8EncodedKeySpec(decryptedData);
        } catch (NoSuchPaddingException e) {
            throw new NoSuchAlgorithmException(e.getMessage());
        } catch (InvalidAlgorithmParameterException e) {
            throw new NoSuchAlgorithmException(e.getMessage());
        } catch (IllegalStateException e) {
            throw new InvalidKeyException(e.getMessage());
        } catch (IllegalBlockSizeException e) {
            throw new InvalidKeyException(e.getMessage());
        } catch (BadPaddingException e) {
            throw new InvalidKeyException(e.getMessage());
        }
    }

    /**
     * Returns the {@code PKCS8EncodedKeySpec} object extracted from the
     * encrypted data.
     *
     * @param decryptKey
     *            the key to decrypt the encrypted data with.
     * @param providerName
     *            the name of a provider whose cipher implementation should be
     *            used.
     * @return the extracted {@code PKCS8EncodedKeySpec}.
     * @throws NoSuchProviderException
     *             if no provider with {@code providerName} can be found.
     * @throws NoSuchAlgorithmException
     *             if no usable cipher can be found to decrypt the encrypted
     *             data.
     * @throws InvalidKeyException
     *             if {@code decryptKey} is not usable to decrypt the encrypted
     *             data.
     * @throws NullPointerException
     *             if {@code decryptKey} or {@code providerName} is {@code null}
     *             .
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.932 -0500", hash_original_method = "B712B7178E60AED4791DB32F07137FE5", hash_generated_method = "08BE82471E385C5F3849CFEAEC1307C4")
    
public PKCS8EncodedKeySpec getKeySpec(Key decryptKey, String providerName)
        throws NoSuchProviderException,
               NoSuchAlgorithmException,
               InvalidKeyException {
        if (decryptKey == null) {
            throw new NullPointerException("decryptKey == null");
        }
        if (providerName == null) {
            throw new NullPointerException("providerName == null");
        }
        try {
            Cipher cipher = Cipher.getInstance(algName, providerName);
            if (algParameters == null) {
                cipher.init(Cipher.DECRYPT_MODE, decryptKey);
            } else {
                cipher.init(Cipher.DECRYPT_MODE, decryptKey, algParameters);
            }
            byte[] decryptedData = cipher.doFinal(encryptedData);
            try {
                ASN1PrivateKeyInfo.verify(decryptedData);
            } catch (IOException e1) {
                throw invalidKey();
            }
            return new PKCS8EncodedKeySpec(decryptedData);
        } catch (NoSuchPaddingException e) {
            throw new NoSuchAlgorithmException(e.getMessage());
        } catch (InvalidAlgorithmParameterException e) {
            throw new NoSuchAlgorithmException(e.getMessage());
        } catch (IllegalStateException e) {
            throw new InvalidKeyException(e.getMessage());
        } catch (IllegalBlockSizeException e) {
            throw new InvalidKeyException(e.getMessage());
        } catch (BadPaddingException e) {
            throw new InvalidKeyException(e.getMessage());
        }
    }

    /**
     * Returns the {@code PKCS8EncodedKeySpec} object extracted from the
     * encrypted data.
     *
     * @param decryptKey
     *            the key to decrypt the encrypted data with.
     * @param provider
     *            the provider whose cipher implementation should be used.
     * @return the extracted {@code PKCS8EncodedKeySpec}.
     * @throws NoSuchAlgorithmException
     *             if no usable cipher can be found to decrypt the encrypted
     *             data.
     * @throws InvalidKeyException
     *             if {@code decryptKey} is not usable to decrypt the encrypted
     *             data.
     * @throws NullPointerException
     *             if {@code decryptKey} or {@code provider} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.935 -0500", hash_original_method = "90A968B6E2258355BD8D757E8E7A32BF", hash_generated_method = "13A5E6F239E1078E9EA802ABB49EFC38")
    
public PKCS8EncodedKeySpec getKeySpec(Key decryptKey, Provider provider)
        throws NoSuchAlgorithmException,
               InvalidKeyException {
        if (decryptKey == null) {
            throw new NullPointerException("decryptKey == null");
        }
        if (provider == null) {
            throw new NullPointerException("provider == null");
        }
        try {
            Cipher cipher = Cipher.getInstance(algName, provider);
            if (algParameters == null) {
                cipher.init(Cipher.DECRYPT_MODE, decryptKey);
            } else {
                cipher.init(Cipher.DECRYPT_MODE, decryptKey, algParameters);
            }
            byte[] decryptedData = cipher.doFinal(encryptedData);
            try {
                ASN1PrivateKeyInfo.verify(decryptedData);
            } catch (IOException e1) {
                throw invalidKey();
            }
            return new PKCS8EncodedKeySpec(decryptedData);
        } catch (NoSuchPaddingException e) {
            throw new NoSuchAlgorithmException(e.getMessage());
        } catch (InvalidAlgorithmParameterException e) {
            throw new NoSuchAlgorithmException(e.getMessage());
        } catch (IllegalStateException e) {
            throw new InvalidKeyException(e.getMessage());
        } catch (IllegalBlockSizeException e) {
            throw new InvalidKeyException(e.getMessage());
        } catch (BadPaddingException e) {
            throw new InvalidKeyException(e.getMessage());
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.937 -0500", hash_original_method = "F2C8E0AE199C63E108D40A2C42D8E5F5", hash_generated_method = "C89E4771B98C8F23FB7E2846E4B6C518")
    
private InvalidKeyException invalidKey() throws InvalidKeyException {
        throw new InvalidKeyException("Decrypted data does not represent valid PKCS#8 PrivateKeyInfo");
    }

    /**
     * Returns the ASN.1 encoded representation of this object.
     *
     * @return the ASN.1 encoded representation of this object.
     * @throws IOException
     *             if encoding this object fails.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.939 -0500", hash_original_method = "64506A3A148BFB8614C90465965B2E22", hash_generated_method = "429BA8AB473A949FCE514B8CBD77E250")
    
public byte[] getEncoded() throws IOException {
        if (encoded == null) {
            // Generate ASN.1 encoding:
            encoded = asn1.encode(this);
        }
        byte[] ret = new byte[encoded.length];
        System.arraycopy(encoded, 0, ret, 0, encoded.length);
        return ret;
    }

    // Performs all needed alg name mappings.
    // Returns 'true' if mapping available 'false' otherwise
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.942 -0500", hash_original_method = "BB96A16B2E5B8AF0DEB9007883ABA8DF", hash_generated_method = "523D01EB592C72324F70A8A3FFC59C8B")
    
private boolean mapAlgName() {
        if (AlgNameMapper.isOID(this.algName)) {
            // OID provided to the ctor
            // get rid of possible leading "OID."
            this.oid = AlgNameMapper.normalize(this.algName);
            // try to find mapping OID->algName
            this.algName = AlgNameMapper.map2AlgName(this.oid);
            // if there is no mapping OID->algName
            // set OID as algName
            if (this.algName == null) {
                this.algName = this.oid;
            }
        } else {
            String stdName = AlgNameMapper.getStandardName(this.algName);
            // Alg name provided to the ctor
            // try to find mapping algName->OID or
            // (algName->stdAlgName)->OID
            this.oid = AlgNameMapper.map2OID(this.algName);
            if (this.oid == null) {
                if (stdName == null) {
                    // no above mappings available
                    return false;
                }
                this.oid = AlgNameMapper.map2OID(stdName);
                if (this.oid == null) {
                    return false;
                }
                this.algName = stdName;
            } else if (stdName != null) {
                this.algName = stdName;
            }
        }
        return true;
    }
}

