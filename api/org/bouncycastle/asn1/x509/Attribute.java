package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;






public class Attribute extends ASN1Encodable {

    /**
     * return an Attribute object from the given object.
     *
     * @param o the object we want converted.
     * @exception IllegalArgumentException if the object cannot be converted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.083 -0500", hash_original_method = "3900192E5C6BDC4DF63A83B098509C68", hash_generated_method = "089131B893FFD9CDC6A629ED1C46B3B4")
    
public static Attribute getInstance(
        Object o)
    {
        if (o == null || o instanceof Attribute)
        {
            return (Attribute)o;
        }
        
        if (o instanceof ASN1Sequence)
        {
            return new Attribute((ASN1Sequence)o);
        }

        throw new IllegalArgumentException("unknown object in factory: " + o.getClass().getName());
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.078 -0500", hash_original_field = "F2A79CA5EF17C9AB113B6AE0088A1D98", hash_generated_field = "4851D4166E5BF16AA64E550E5ECE0B30")

    private DERObjectIdentifier attrType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.080 -0500", hash_original_field = "B360C8C036E210AB5E5762E4BF3880F5", hash_generated_field = "240506915FE52EB5683D0C9895D89C66")

    private ASN1Set             attrValues;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.086 -0500", hash_original_method = "F858B1E12EC141756BCF51707692EAE3", hash_generated_method = "6DB04527E87E26A9B9F09A9E586EE417")
    
public Attribute(
        ASN1Sequence seq)
    {
        if (seq.size() != 2)
        {
            throw new IllegalArgumentException("Bad sequence size: " + seq.size());
        }

        attrType = DERObjectIdentifier.getInstance(seq.getObjectAt(0));
        attrValues = ASN1Set.getInstance(seq.getObjectAt(1));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.088 -0500", hash_original_method = "38B63F7591289E34615CCB148E077DFB", hash_generated_method = "FF37471E5EEB316BC49CC00340936419")
    
public Attribute(
        DERObjectIdentifier attrType,
        ASN1Set             attrValues)
    {
        this.attrType = attrType;
        this.attrValues = attrValues;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.090 -0500", hash_original_method = "C61254DD25EA79572F2B43B889534711", hash_generated_method = "08471F8FA52CFE477DB38EFD336FF4E4")
    
public ASN1ObjectIdentifier getAttrType()
    {
        return new ASN1ObjectIdentifier(attrType.getId());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.092 -0500", hash_original_method = "3714D5AC97801D67C3C70862DB57F642", hash_generated_method = "5A00221649A5B2B38D66D09D20488CFF")
    
public ASN1Encodable[] getAttributeValues()
    {
        return attrValues.toArray();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.095 -0500", hash_original_method = "0C9FA4513BA0CB1318C076F6A4C1BAA0", hash_generated_method = "23346F242C4FD6576DC175E213D69F37")
    
public ASN1Set getAttrValues()
    {
        return attrValues;
    }

    /** 
     * Produce an object suitable for an ASN1OutputStream.
     * <pre>
     * Attribute ::= SEQUENCE {
     *     attrType OBJECT IDENTIFIER,
     *     attrValues SET OF AttributeValue
     * }
     * </pre>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.098 -0500", hash_original_method = "7FF9F3775D261945F5C8461E1521856A", hash_generated_method = "D864767FDAD7272F38B233AE7BC199CE")
    
public DERObject toASN1Object()
    {
        ASN1EncodableVector v = new ASN1EncodableVector();

        v.add(attrType);
        v.add(attrValues);

        return new DERSequence(v);
    }

    
}

