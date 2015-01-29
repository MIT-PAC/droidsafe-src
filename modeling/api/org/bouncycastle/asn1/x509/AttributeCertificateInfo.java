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






public class AttributeCertificateInfo extends ASN1Encodable {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.674 -0500", hash_original_method = "737B0D2E660F27598C4C4B047B7A6056", hash_generated_method = "8EB1FD84B38A51913D864BF9FDF1A59A")
    
public static AttributeCertificateInfo getInstance(
        ASN1TaggedObject obj,
        boolean          explicit)
    {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.676 -0500", hash_original_method = "FF4B809FF765A4FA7F8FBB66040465D6", hash_generated_method = "2046C83F2D9ACF728DCE0458675B7A1E")
    
public static AttributeCertificateInfo getInstance(
        Object  obj)
    {
        if (obj instanceof AttributeCertificateInfo)
        {
            return (AttributeCertificateInfo)obj;
        }
        else if (obj instanceof ASN1Sequence)
        {
            return new AttributeCertificateInfo((ASN1Sequence)obj);
        }

        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.653 -0500", hash_original_field = "E228CDE1667030A19BE9074EE632C2E6", hash_generated_field = "22EBE359829AB95B300B64E2550F3EA1")

    private DERInteger              version;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.655 -0500", hash_original_field = "81EEF30676831ECD3948BE1C9E69FB41", hash_generated_field = "563B820D71AB887AFBDC4FA155EF0F94")

    private Holder                  holder;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.657 -0500", hash_original_field = "9F975C29C0329E13C99EBC932478654A", hash_generated_field = "19091383B7F6282BDA73C5A5CBC6602A")

    private AttCertIssuer           issuer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.660 -0500", hash_original_field = "A9C2427A585DE5C2846E517FA208C326", hash_generated_field = "783386BC2A99F90E6BCFC976FA88180B")

    private AlgorithmIdentifier     signature;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.662 -0500", hash_original_field = "61F6E9A806268A4DFEFDDB24EB7F542C", hash_generated_field = "5FEA8F3298727145BB03455817D3DE5F")

    private DERInteger              serialNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.665 -0500", hash_original_field = "E7D5627BCA6D2A3FBD008FA1EE514D05", hash_generated_field = "C8E13C4545DF7403FD584DFAE694F588")

    private AttCertValidityPeriod   attrCertValidityPeriod;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.667 -0500", hash_original_field = "09C499BED7CFEDE474428C75E926BE6E", hash_generated_field = "DBB0952120A99FCFC1819E5AA89DC04F")

    private ASN1Sequence            attributes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.669 -0500", hash_original_field = "C5F9D3D90C65BF542442B283D86C530C", hash_generated_field = "F6ABE18285D56BD9C63FFD10DEBF5BD7")

    private DERBitString            issuerUniqueID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.671 -0500", hash_original_field = "2BA375987D179ECB55F007F92DADE11C", hash_generated_field = "FD88AE5D9F8262A2B65FEAADA7C32BCC")

    private X509Extensions          extensions;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.680 -0500", hash_original_method = "C35C344C6189D0B2CCFCB8B319FD5953", hash_generated_method = "DE92D9DF9F8D761027B93AB36B48875B")
    
public AttributeCertificateInfo(
        ASN1Sequence   seq)
    {
        if (seq.size() < 7 || seq.size() > 9)
        {
            throw new IllegalArgumentException("Bad sequence size: " + seq.size());
        }

        this.version = DERInteger.getInstance(seq.getObjectAt(0));
        this.holder = Holder.getInstance(seq.getObjectAt(1));
        this.issuer = AttCertIssuer.getInstance(seq.getObjectAt(2));
        this.signature = AlgorithmIdentifier.getInstance(seq.getObjectAt(3));
        this.serialNumber = DERInteger.getInstance(seq.getObjectAt(4));
        this.attrCertValidityPeriod = AttCertValidityPeriod.getInstance(seq.getObjectAt(5));
        this.attributes = ASN1Sequence.getInstance(seq.getObjectAt(6));
        
        for (int i = 7; i < seq.size(); i++)
        {
            ASN1Encodable    obj = (ASN1Encodable)seq.getObjectAt(i);

            if (obj instanceof DERBitString)
            {
                this.issuerUniqueID = DERBitString.getInstance(seq.getObjectAt(i));
            }
            else if (obj instanceof ASN1Sequence || obj instanceof X509Extensions)
            {
                this.extensions = X509Extensions.getInstance(seq.getObjectAt(i));
            }
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.682 -0500", hash_original_method = "C14C6949EA2D9724014BC15AB24B85D9", hash_generated_method = "78B2DE65AC516EF0C8AEDCD6952A1B97")
    
public DERInteger getVersion()
    {
        return version;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.684 -0500", hash_original_method = "31AEFB5A2FC3B890A5A042FC24D98031", hash_generated_method = "BD240A4ACB1EB7E35913D90B5F53C61E")
    
public Holder getHolder()
    {
        return holder;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.686 -0500", hash_original_method = "CDB27E7EA4A3B5B10C6A056E131798BE", hash_generated_method = "E231918B7232DA42452C3E12906B7E50")
    
public AttCertIssuer getIssuer()
    {
        return issuer;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.689 -0500", hash_original_method = "DD6542667BFDE70B879F723105C92A71", hash_generated_method = "8983DBF8FD7CF97E2F3DB5F36F4DEF72")
    
public AlgorithmIdentifier getSignature()
    {
        return signature;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.691 -0500", hash_original_method = "FB637D35FB72ECF5302334390BEEB5AC", hash_generated_method = "B4C3507C7CA5004E71D41514D5FECB65")
    
public DERInteger getSerialNumber()
    {
        return serialNumber;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.693 -0500", hash_original_method = "3C65423907176C9088B2D87B8798CFAE", hash_generated_method = "6CFE80698242F5A12450AD67A94BBA98")
    
public AttCertValidityPeriod getAttrCertValidityPeriod()
    {
        return attrCertValidityPeriod;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.695 -0500", hash_original_method = "936A2581CBB919961CE40AAE721BB5BA", hash_generated_method = "B55C58A75EB6CF7800711C9FE631B6B2")
    
public ASN1Sequence getAttributes()
    {
        return attributes;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.697 -0500", hash_original_method = "2F58C5477BC934C0C5DF4943197A2496", hash_generated_method = "83DD1F9293CE06622510C8FA1C526140")
    
public DERBitString getIssuerUniqueID()
    {
        return issuerUniqueID;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.699 -0500", hash_original_method = "0A664DE086A2ED08A47FCC7544F0D12E", hash_generated_method = "732ED8B11FCC424D21ECD48504DDD415")
    
public X509Extensions getExtensions()
    {
        return extensions;
    }

    /**
     * Produce an object suitable for an ASN1OutputStream.
     * <pre>
     *  AttributeCertificateInfo ::= SEQUENCE {
     *       version              AttCertVersion -- version is v2,
     *       holder               Holder,
     *       issuer               AttCertIssuer,
     *       signature            AlgorithmIdentifier,
     *       serialNumber         CertificateSerialNumber,
     *       attrCertValidityPeriod   AttCertValidityPeriod,
     *       attributes           SEQUENCE OF Attribute,
     *       issuerUniqueID       UniqueIdentifier OPTIONAL,
     *       extensions           Extensions OPTIONAL
     *  }
     *
     *  AttCertVersion ::= INTEGER { v2(1) }
     * </pre>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.701 -0500", hash_original_method = "AEBC8D50EAAC05A83CB6DB0736727739", hash_generated_method = "8790492141693B1F68EBB4D6E615F743")
    
public DERObject toASN1Object()
    {
        ASN1EncodableVector  v = new ASN1EncodableVector();

        v.add(version);
        v.add(holder);
        v.add(issuer);
        v.add(signature);
        v.add(serialNumber);
        v.add(attrCertValidityPeriod);
        v.add(attributes);
        
        if (issuerUniqueID != null)
        {
            v.add(issuerUniqueID);
        }
        
        if (extensions != null)
        {
            v.add(extensions);
        }
        
        return new DERSequence(v);
    }

    
}

