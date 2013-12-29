package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;






public class IssuerSerial extends ASN1Encodable {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.270 -0500", hash_original_method = "F369CB01BCE8122A7661819262EC732F", hash_generated_method = "C73D815F8A6CB4383D861082720D129C")
    public static IssuerSerial getInstance(
            Object  obj)
    {
        if (obj == null || obj instanceof IssuerSerial)
        {
            return (IssuerSerial)obj;
        }

        if (obj instanceof ASN1Sequence)
        {
            return new IssuerSerial((ASN1Sequence)obj);
        }

        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.271 -0500", hash_original_method = "16EE3F5497429C0B3335EEF6761E4C38", hash_generated_method = "808E378EF807DCAA4B5F79230D1808F7")
    public static IssuerSerial getInstance(
        ASN1TaggedObject obj,
        boolean          explicit)
    {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.268 -0500", hash_original_field = "FBA189AA1CCDF885E2BAFE3258EFE992", hash_generated_field = "FBA189AA1CCDF885E2BAFE3258EFE992")

    GeneralNames            issuer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.269 -0500", hash_original_field = "B567171129E718B07996A791966D9A47", hash_generated_field = "B567171129E718B07996A791966D9A47")

    DERInteger              serial;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.270 -0500", hash_original_field = "3D9E898FBB0D3A6964BB9F619F1BE32F", hash_generated_field = "3D9E898FBB0D3A6964BB9F619F1BE32F")

    DERBitString            issuerUID;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.272 -0500", hash_original_method = "6A7E42DF8EF9B09B844C872DFCA023C7", hash_generated_method = "21B5E94B1503EB3B81CAD22E6A3D29F8")
    public IssuerSerial(
        ASN1Sequence    seq)
    {
        if (seq.size() != 2 && seq.size() != 3)
        {
            throw new IllegalArgumentException("Bad sequence size: " + seq.size());
        }
        
        issuer = GeneralNames.getInstance(seq.getObjectAt(0));
        serial = DERInteger.getInstance(seq.getObjectAt(1));

        if (seq.size() == 3)
        {
            issuerUID = DERBitString.getInstance(seq.getObjectAt(2));
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.273 -0500", hash_original_method = "B838D7E53D177DFF65C1A291EEAEEEE1", hash_generated_method = "B019390C0E97EF31F3632A3E801BE04A")
    public IssuerSerial(
        GeneralNames    issuer,
        DERInteger      serial)
    {
        this.issuer = issuer;
        this.serial = serial;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.274 -0500", hash_original_method = "C6A01CC056B505ECB1961F3D46D5E125", hash_generated_method = "121D325F48E2B3A786B066E3FBD8CF8E")
    public GeneralNames getIssuer()
    {
        return issuer;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.276 -0500", hash_original_method = "4A26172B3E4E9D1CBD95C0010541030C", hash_generated_method = "5D6388981ABB0E785476088CA6DBF8F0")
    public DERInteger getSerial()
    {
        return serial;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.277 -0500", hash_original_method = "6FC86B4935E8EDEA9326972109BFF43A", hash_generated_method = "DEAD8AFE430386E1B7F42E96AADE631F")
    public DERBitString getIssuerUID()
    {
        return issuerUID;
    }

    /**
     * Produce an object suitable for an ASN1OutputStream.
     * <pre>
     *  IssuerSerial  ::=  SEQUENCE {
     *       issuer         GeneralNames,
     *       serial         CertificateSerialNumber,
     *       issuerUID      UniqueIdentifier OPTIONAL
     *  }
     * </pre>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.277 -0500", hash_original_method = "91432FD7FC59DB0CA5EF9903A7843F73", hash_generated_method = "10A3F3F9908BFA8B7AE8CBA1BE39230F")
    public DERObject toASN1Object()
    {
        ASN1EncodableVector  v = new ASN1EncodableVector();

        v.add(issuer);
        v.add(serial);

        if (issuerUID != null)
        {
            v.add(issuerUID);
        }

        return new DERSequence(v);
    }

    
}

