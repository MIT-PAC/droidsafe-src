package org.bouncycastle.asn1.pkcs;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class EncryptionScheme extends AlgorithmIdentifier {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.250 -0500", hash_original_method = "329448F62D43F2D72E279A19F351634F", hash_generated_method = "0FBFED9FCE389ACC961AA8E74204421B")
    
public static final AlgorithmIdentifier getInstance(Object obj)
    {
        if (obj instanceof EncryptionScheme)
        {
            return (EncryptionScheme)obj;
        }
        else if (obj instanceof ASN1Sequence)
        {
            return new EncryptionScheme((ASN1Sequence)obj);
        }

        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.244 -0500", hash_original_method = "695FECBCB14F5A1D31F0B55CAC6B7944", hash_generated_method = "F06CCC20B17EC02450A3149CDE6F7757")
    
public EncryptionScheme(
        DERObjectIdentifier objectId,
        DEREncodable parameters)
    {
        super(objectId, parameters);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.247 -0500", hash_original_method = "14492AE8746901ADA4AAC49DFFF4DA42", hash_generated_method = "14492AE8746901ADA4AAC49DFFF4DA42")
    
EncryptionScheme(
        ASN1Sequence  seq)
    {   
        this((DERObjectIdentifier)seq.getObjectAt(0), seq.getObjectAt(1));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.252 -0500", hash_original_method = "20A4F3D13CF17139753D47801A517EAE", hash_generated_method = "34A9F5DDC33A7CAADF3965056BE10DA3")
    
public DERObject getObject()
    {
        return (DERObject)getParameters();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.256 -0500", hash_original_method = "0A2A11415EF4AC8722D540FA9324533D", hash_generated_method = "D184C3070E0B8E20E17B5A76A65BA9EB")
    
public DERObject getDERObject()
    {
        ASN1EncodableVector  v = new ASN1EncodableVector();

        v.add(getObjectId());
        v.add(getParameters());

        return new DERSequence(v);
    }
    
}

