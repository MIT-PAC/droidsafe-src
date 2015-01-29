package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

import org.apache.harmony.security.asn1.ASN1BitString;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.BitString;
import org.apache.harmony.security.utils.AlgNameMapper;

public final class SubjectPublicKeyInfo {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.732 -0400", hash_original_field = "CC42040DA80C5D943F06D4C9E4EAF6E0", hash_generated_field = "48040307EA293E7C22FF1672E7CE9B9C")

    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            AlgorithmIdentifier.ASN1, ASN1BitString.getInstance() }) {
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.179 -0500", hash_original_method = "FD8EB31EDCB420BB285954F02E88B28A", hash_generated_method = "F74A8C1C6455AB0D4AE87615185F053E")
        
@Override protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;
            return new SubjectPublicKeyInfo(
                    (AlgorithmIdentifier) values[0],
                    ((BitString) values[1]).bytes,
                    ((BitString) values[1]).unusedBits,
                    in.getEncoded());
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.182 -0500", hash_original_method = "FDCC5514DD513A693728A41D76C4BE17", hash_generated_method = "180FE1AFEFF8CCC3DCE26CFC2FBFF7BD")
        
@Override protected void getValues(Object object, Object[] values) {
            SubjectPublicKeyInfo spki = (SubjectPublicKeyInfo) object;
            values[0] = spki.algorithmID;
            values[1] = new BitString(spki.subjectPublicKey, spki.unusedBits);
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.149 -0500", hash_original_field = "6AFC92FA1D812ADED4F2DD1AAE6BA2FF", hash_generated_field = "FD325ED8A60C5BD558CCCC00BB18BE1E")

    private AlgorithmIdentifier algorithmID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.152 -0500", hash_original_field = "289FEAC5B4C17545B61B3DF43A1221AB", hash_generated_field = "741B868AD923CC223249852F373451D2")

    private byte[] subjectPublicKey;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.154 -0500", hash_original_field = "B73719A7AAE8E737607C294F86B7D620", hash_generated_field = "597E676F0E34E7523D486C2FEA821479")

    private PublicKey publicKey;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.156 -0500", hash_original_field = "83B59A14DF77F932A19E40814BC16A0D", hash_generated_field = "1C126C29BD87C978D05FA9E071D552A8")

    private int unusedBits;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.159 -0500", hash_original_field = "B36A946B5145D992E53209BC6743765D", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.162 -0500", hash_original_method = "253956FBAD4830165078A1D4A5A10C63", hash_generated_method = "5176C338D7A51FFAD46FB8197E1ACB73")
    
public SubjectPublicKeyInfo(AlgorithmIdentifier algID, byte[] subjectPublicKey) {
        this(algID, subjectPublicKey, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.164 -0500", hash_original_method = "D57000139A93CCBF30D6DA3399D9D5D5", hash_generated_method = "FD8AEB51714AA6C307329C14F9BB8547")
    
public SubjectPublicKeyInfo(AlgorithmIdentifier algID, byte[] subjectPublicKey, int unused) {
        this(algID, subjectPublicKey, 0, null);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.167 -0500", hash_original_method = "78E5942A2DBBC7DA4B73868B62747270", hash_generated_method = "9205467311B061ED75535097647830D4")
    
private SubjectPublicKeyInfo(AlgorithmIdentifier algID,
                                 byte[] subjectPublicKey, int unused,
                                 byte[] encoding) {
        this.algorithmID = algID;
        this.subjectPublicKey = subjectPublicKey;
        this.unusedBits = unused;
        this.encoding = encoding;
    }

    /**
     * Returns the value of algorithmIdentifier field of the structure.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.169 -0500", hash_original_method = "D3585B3653154AD3FE820FC3C464AD5E", hash_generated_method = "6C7E05AE258BF1CF0D65ED29E7EE8FA2")
    
public AlgorithmIdentifier getAlgorithmIdentifier() {
        return algorithmID;
    }

    /**
     * Returns the value of subjectPublicKey field of the structure.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.171 -0500", hash_original_method = "6DD3F56EFCD8D5575183C0DEA4BCE90C", hash_generated_method = "C28A22C9852F0BF7DC4709C89181E268")
    
public byte[] getSubjectPublicKey() {
        return subjectPublicKey;
    }

    /**
     * Returns ASN.1 encoded form of this X.509 SubjectPublicKeyInfo value.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.173 -0500", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "5349B65E746CD014BDA35ADFF927FD5B")
    
public byte[] getEncoded() {
        if (encoding == null) {
            encoding = ASN1.encode(this);
        }
        return encoding;
    }

    /**
     * Returns The PublicKey corresponding to this SubjectPublicKeyInfo
     * instance.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.176 -0500", hash_original_method = "FA31FAEA1A381D04C25B0BE6D665660B", hash_generated_method = "1C17CC51F7492063F024E0A427C19372")
    
public PublicKey getPublicKey() {
        if (publicKey == null) {
            String alg_oid = algorithmID.getAlgorithm();
            try {
                String alg =
                    AlgNameMapper.map2AlgName(alg_oid);

                if (alg == null) {
                    alg = alg_oid;
                }
                publicKey = KeyFactory.getInstance(alg)
                    .generatePublic(new X509EncodedKeySpec(getEncoded()));
            } catch (InvalidKeySpecException ignored) {
            } catch (NoSuchAlgorithmException ignored) {
            }
            if (publicKey == null) {
                publicKey = new X509PublicKey(alg_oid, getEncoded(),
                        subjectPublicKey);
            }
        }
        return publicKey;
    }
}

