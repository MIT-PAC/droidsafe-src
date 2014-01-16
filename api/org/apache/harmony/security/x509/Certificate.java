package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.harmony.security.asn1.ASN1BitString;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.BitString;
import org.apache.harmony.security.utils.Array;

public final class Certificate {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.889 -0400", hash_original_field = "8339CCCD344A2DCCCDFE1DAEDAF1FA1B", hash_generated_field = "23BC4A8E936707952E42A4866427E16B")

    public static final ASN1Sequence ASN1 =
        new ASN1Sequence(new ASN1Type[]
                {TBSCertificate.ASN1, AlgorithmIdentifier.ASN1, ASN1BitString.getInstance()}) {

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.621 -0500", hash_original_method = "E9A0EBC5EB9E7858903883226F7AD5F5", hash_generated_method = "47ED9AA3E0E1AB289A1B89691A7E99F4")
        
@Override protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;
            return new Certificate(
                    (TBSCertificate) values[0],
                    (AlgorithmIdentifier) values[1],
                    ((BitString) values[2]).bytes, // FIXME keep as BitString object
                    in.getEncoded());
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.624 -0500", hash_original_method = "01876C68B36ED76B36AC389852322C04", hash_generated_method = "D9BC38DA53C5414A894CB7558786F7D3")
        
@Override protected void getValues(Object object, Object[] values) {
            Certificate cert = (Certificate) object;
            values[0] = cert.tbsCertificate;
            values[1] = cert.signatureAlgorithm;
            values[2] = new BitString(cert.signatureValue, 0);
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.596 -0500", hash_original_field = "E3DE59EDDA13D0928D683048AB16089C", hash_generated_field = "9248E33E3F77CE913BD8C48F1C53B58B")

    private  TBSCertificate tbsCertificate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.599 -0500", hash_original_field = "2F7BE616514E885F71195FC5A07117B0", hash_generated_field = "4CC78CEDF5C854EC0CED71E47BBFC813")

    private  AlgorithmIdentifier signatureAlgorithm;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.601 -0500", hash_original_field = "9521EB9F2B8E8BECDD1F8EF0CD48C6D0", hash_generated_field = "9AB01BF01A2AD28FB638C6788268D049")

    private  byte[] signatureValue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.604 -0500", hash_original_field = "B36A946B5145D992E53209BC6743765D", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.607 -0500", hash_original_method = "36888DF2201C733781C462219C862A19", hash_generated_method = "60A4162C0C91B21381C763814A37C2CB")
    
public Certificate(TBSCertificate tbsCertificate,
                       AlgorithmIdentifier signatureAlgorithm,
                       byte[] signatureValue) {
        this.tbsCertificate = tbsCertificate;
        this.signatureAlgorithm = signatureAlgorithm;
        this.signatureValue = new byte[signatureValue.length];
        System.arraycopy(signatureValue, 0, this.signatureValue, 0,
                                                    signatureValue.length);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.609 -0500", hash_original_method = "B77628638E378AC1094C2F162FBF82C6", hash_generated_method = "AB98346AA18DD00ED2A3C4A64B248526")
    
private Certificate(TBSCertificate tbsCertificate,
                       AlgorithmIdentifier signatureAlgorithm,
                       byte[] signatureValue, byte[] encoding) {
        this(tbsCertificate, signatureAlgorithm, signatureValue);
        this.encoding = encoding;
    }

    /**
     * Returns the value of tbsCertificate field of the structure.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.612 -0500", hash_original_method = "FF2C12E3D498720C4C6A280928F0E345", hash_generated_method = "8C99BE7A64B0828B3027F555C9A2D401")
    
public TBSCertificate getTbsCertificate() {
        return tbsCertificate;
    }

    /**
     * Returns the value of signatureValue field of the structure.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.614 -0500", hash_original_method = "8722C62E4FA981F57078A28963CBFC5B", hash_generated_method = "986DB3C1A2EA054C6FF6A66D245B73E9")
    
public byte[] getSignatureValue() {
        return signatureValue.clone();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.616 -0500", hash_original_method = "AB851A8A0A531CFA5FA89690A5B67B6A", hash_generated_method = "FBDBA8AE9EEF1047F645660D8F347221")
    
@Override public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("X.509 Certificate:\n[\n");
        tbsCertificate.dumpValue(result);
        result.append("\n  Algorithm: [");
        signatureAlgorithm.dumpValue(result);
        result.append(']');
        result.append("\n  Signature Value:\n");
        result.append(Array.toString(signatureValue, ""));
        result.append(']');
        return result.toString();
    }

    /**
     * Returns ASN.1 encoded form of this X.509 TBSCertificate value.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.618 -0500", hash_original_method = "40E68AC9D0BBD7DBB7B922A2DC357EC3", hash_generated_method = "D37A78C7C950CFA5A1AB9865437CF8F4")
    
public byte[] getEncoded() {
        if (encoding == null) {
            encoding = Certificate.ASN1.encode(this);
        }
        return encoding;
    }
}

