package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.Enumeration;

public class BERTaggedObject extends DERTaggedObject {
    /**
     * @param tagNo the tag number for this object.
     * @param obj the tagged object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.038 -0500", hash_original_method = "C31FB64F3B4373F22983AB0E8A924F45", hash_generated_method = "231C96219E146238CAC8F275EC80286F")
    
public BERTaggedObject(
        int             tagNo,
        DEREncodable    obj)
    {
        super(tagNo, obj);
    }

    /**
     * @param explicit true if an explicitly tagged object.
     * @param tagNo the tag number for this object.
     * @param obj the tagged object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.041 -0500", hash_original_method = "F5B7A80AD1A003D34ED6FD9BD184C1A3", hash_generated_method = "741EF45117E7DB0D8CC373BD84C73EB0")
    
public BERTaggedObject(
        boolean         explicit,
        int             tagNo,
        DEREncodable    obj)
    {
        super(explicit, tagNo, obj);
    }

    /**
     * create an implicitly tagged object that contains a zero
     * length sequence.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.044 -0500", hash_original_method = "6F574A26D6DB1C59B77D339A09CC5651", hash_generated_method = "6E8D1564353F1F57F1DB4C1958DE215F")
    
public BERTaggedObject(
        int             tagNo)
    {
        super(false, tagNo, new BERSequence());
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.047 -0500", hash_original_method = "7D1415DBFEACA82B062C25744BEBEEC4", hash_generated_method = "7D1415DBFEACA82B062C25744BEBEEC4")
    
void encode(
        DEROutputStream  out)
        throws IOException
    {
        if (out instanceof ASN1OutputStream || out instanceof BEROutputStream)
        {
            out.writeTag(CONSTRUCTED | TAGGED, tagNo);
            out.write(0x80);

            if (!empty)
            {
                if (!explicit)
                {
                    Enumeration e;
                    if (obj instanceof ASN1OctetString)
                    {
                        if (obj instanceof BERConstructedOctetString)
                        {
                            e = ((BERConstructedOctetString)obj).getObjects();
                        }
                        else
                        {
                            ASN1OctetString             octs = (ASN1OctetString)obj;
                            BERConstructedOctetString   berO = new BERConstructedOctetString(octs.getOctets());
                            e = berO.getObjects();
                        }
                    }
                    else if (obj instanceof ASN1Sequence)
                    {
                        e = ((ASN1Sequence)obj).getObjects();
                    }
                    else if (obj instanceof ASN1Set)
                    {
                        e = ((ASN1Set)obj).getObjects();
                    }
                    else
                    {
                        throw new RuntimeException("not implemented: " + obj.getClass().getName());
                    }

                    while (e.hasMoreElements())
                    {
                        out.writeObject(e.nextElement());
                    }
                }
                else
                {
                    out.writeObject(obj);
                }
            }

            out.write(0x00);
            out.write(0x00);
        }
        else
        {
            super.encode(out);
        }
    }
    
}

