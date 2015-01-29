package org.bouncycastle.asn1.x500;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERSet;

public class RDN extends ASN1Encodable {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.644 -0500", hash_original_method = "7D890349CF7796BE43E218B30EC245DF", hash_generated_method = "67356EBF15BC4F825F7E5C92B7EB0FD9")
    
public static RDN getInstance(Object obj)
    {
        if (obj instanceof RDN)
        {
            return (RDN)obj;
        }
        else if (obj != null)
        {
            return new RDN(ASN1Set.getInstance(obj));
        }

        return null;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.639 -0500", hash_original_field = "74914FBEF3FC1AA8D2851A1F4D8C6B4B", hash_generated_field = "239F5B210A7B8675111CDBD0D5490D28")

    private ASN1Set values;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.641 -0500", hash_original_method = "B2B65A892B577B3023594DECDAE0C7BC", hash_generated_method = "A2A80CEE22C6315FE34647E5E45FDA87")
    
private RDN(ASN1Set values)
    {
        this.values = values;
    }

    /**
     * Create a single valued RDN.
     *
     * @param oid
     * @param value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.646 -0500", hash_original_method = "34395E14B37CB09607BC1384911068DF", hash_generated_method = "75DD381234BE8FCEDB5CCD1EFCAA7952")
    
public RDN(ASN1ObjectIdentifier oid, ASN1Encodable value)
    {
        ASN1EncodableVector v = new ASN1EncodableVector();

        v.add(oid);
        v.add(value);

        this.values = new DERSet(new DERSequence(v));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.649 -0500", hash_original_method = "70441AB748507844E6B6BCC428FBB7E0", hash_generated_method = "3CF08689D93AFFA623AA66B3C761AD4B")
    
public RDN(AttributeTypeAndValue attrTAndV)
    {
        this.values = new DERSet(attrTAndV);
    }

    /**
     * Create a multi-valued RDN.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.652 -0500", hash_original_method = "64FFFA196C50B73DE4BDB139C105E877", hash_generated_method = "440C08403B82EDEBF7F0E57E23E2719D")
    
public RDN(AttributeTypeAndValue[] aAndVs)
    {
        this.values = new DERSet(aAndVs);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.654 -0500", hash_original_method = "8A639F09C3F110E6BEBA76653F26863C", hash_generated_method = "AEBF5D310D7992A27D18ACB5BA831E33")
    
public boolean isMultiValued()
    {
        return this.values.size() > 1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.656 -0500", hash_original_method = "C47887FAFD60151A3B1C3C44B7665548", hash_generated_method = "824E5830F244F3FDC6557694C09D015D")
    
public AttributeTypeAndValue getFirst()
    {
        if (this.values.size() == 0)
        {
            return null;
        }

        return AttributeTypeAndValue.getInstance(this.values.getObjectAt(0));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.658 -0500", hash_original_method = "BEE890DAA6519CDB424A36294BC48156", hash_generated_method = "DD920379A215D159F683BD8D3E56F71F")
    
public AttributeTypeAndValue[] getTypesAndValues()
    {
        AttributeTypeAndValue[] tmp = new AttributeTypeAndValue[values.size()];

        for (int i = 0; i != tmp.length; i++)
        {
            tmp[i] = AttributeTypeAndValue.getInstance(values.getObjectAt(i));
        }

        return tmp;
    }

    /**
     * <pre>
     * RelativeDistinguishedName ::=
     *                     SET OF AttributeTypeAndValue

     * AttributeTypeAndValue ::= SEQUENCE {
     *        type     AttributeType,
     *        value    AttributeValue }
     * </pre>
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.661 -0500", hash_original_method = "C51EA85277B01B717571B534CACD612E", hash_generated_method = "DC37C5D36C347AB6417D417EAF46C8A1")
    
public DERObject toASN1Object()
    {
        return values;
    }
    
}

