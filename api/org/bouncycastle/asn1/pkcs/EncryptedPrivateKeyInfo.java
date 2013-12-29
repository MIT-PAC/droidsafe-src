package org.bouncycastle.asn1.pkcs;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Enumeration;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;






public class EncryptedPrivateKeyInfo extends ASN1Encodable {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.690 -0500", hash_original_method = "F9838ABC09DFC71BE0E2859BCEB4ADAA", hash_generated_method = "58B6E66D99CF38FD6914F175F41F4A18")
    public static EncryptedPrivateKeyInfo getInstance(
        Object  obj)
    {
        // BEGIN android-changed
        //     fix copy and paste error in instanceof call
        if (obj instanceof EncryptedPrivateKeyInfo)
        {
            return (EncryptedPrivateKeyInfo)obj;
        }
        // END android-changed
        else if (obj instanceof ASN1Sequence)
        { 
            return new EncryptedPrivateKeyInfo((ASN1Sequence)obj);
        }

        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.686 -0500", hash_original_field = "77AE1AC968895C7830B8ADE3B24ECA2A", hash_generated_field = "7AD6F6C3D264D25074D6D91921F8050B")

    private AlgorithmIdentifier algId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.687 -0500", hash_original_field = "5C196EF0BBC956ADE069DE36C5B87632", hash_generated_field = "E7847206107AFED7061FA6DEEE6B4715")

    private ASN1OctetString     data;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.688 -0500", hash_original_method = "D7780F085E4F69D75EAD7364F689A92D", hash_generated_method = "AA0B88F9EAB5CAC843BDF1D4AC96E2C3")
    public EncryptedPrivateKeyInfo(
        ASN1Sequence  seq)
    {
        Enumeration e = seq.getObjects();

        algId = AlgorithmIdentifier.getInstance(e.nextElement());
        data = (ASN1OctetString)e.nextElement();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.689 -0500", hash_original_method = "05A2146A24A4B777EF99E759E6105DB4", hash_generated_method = "573A50447AC9DAA24846278817298354")
    public EncryptedPrivateKeyInfo(
        AlgorithmIdentifier algId,
        byte[]              encoding)
    {
        this.algId = algId;
        this.data = new DEROctetString(encoding);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.691 -0500", hash_original_method = "742117C3F9E40BA83B51D9D3C5056A2D", hash_generated_method = "40112245C730D0DC0753F753412F25E8")
    public AlgorithmIdentifier getEncryptionAlgorithm()
    {
        return algId;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.692 -0500", hash_original_method = "BBC4FA06F2A86F1789EA116FAB590C10", hash_generated_method = "D5C7E6258227F7A11439DD49BA77C9D5")
    public byte[] getEncryptedData()
    {
        return data.getOctets();
    }

    /**
     * Produce an object suitable for an ASN1OutputStream.
     * <pre>
     * EncryptedPrivateKeyInfo ::= SEQUENCE {
     *      encryptionAlgorithm AlgorithmIdentifier {{KeyEncryptionAlgorithms}},
     *      encryptedData EncryptedData
     * }
     *
     * EncryptedData ::= OCTET STRING
     *
     * KeyEncryptionAlgorithms ALGORITHM-IDENTIFIER ::= {
     *          ... -- For local profiles
     * }
     * </pre>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.692 -0500", hash_original_method = "1A83B7862624E8339D74A705608FC69D", hash_generated_method = "5829FB947C5E6F5307EFE5A1F054489F")
    public DERObject toASN1Object()
    {
        ASN1EncodableVector v = new ASN1EncodableVector();

        v.add(algId);
        v.add(data);

        return new DERSequence(v);
    }

    
}

