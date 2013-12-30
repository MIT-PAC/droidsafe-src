package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;



public class DERSet extends ASN1Set {
    /**
     * create an empty set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.326 -0500", hash_original_method = "80B25DE2FCBFBCCF6E0A2A88A3316812", hash_generated_method = "901CD9BB0992FD3EB90507D2EC9F1B80")
    
public DERSet()
    {
    }

    /**
     * @param obj - a single object that makes up the set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.328 -0500", hash_original_method = "80662AFE581998795E7545830F255DD3", hash_generated_method = "D5E3DF43366E2ACEA7F323B66EFAEFB8")
    
public DERSet(
        DEREncodable   obj)
    {
        this.addObject(obj);
    }

    /**
     * @param v - a vector of objects making up the set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.331 -0500", hash_original_method = "A9BFF2B058FC769C1F8C48EB1BA33880", hash_generated_method = "2EA00A2E19D0060C02C1C6CA8A08F3F0")
    
public DERSet(
        ASN1EncodableVector   v)
    {
        this(v, true);
    }
    
    /**
     * create a set from an array of objects.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.333 -0500", hash_original_method = "DFBC1065284BB1C2F3C0505C2EF2AEEC", hash_generated_method = "23D51F05B534713A6782D78D5D996E7E")
    
public DERSet(
        ASN1Encodable[]   a)
    {
        for (int i = 0; i != a.length; i++)
        {
            this.addObject(a[i]);
        }
        
        this.sort();
    }
    
    /**
     * @param v - a vector of objects making up the set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.336 -0500", hash_original_method = "90B6A9A913780E80B577423E4251EEF7", hash_generated_method = "90B6A9A913780E80B577423E4251EEF7")
    
DERSet(
        ASN1EncodableVector  v,
        boolean              needsSorting)
    {
        for (int i = 0; i != v.size(); i++)
        {
            this.addObject(v.get(i));
        }

        if (needsSorting)
        {
            this.sort();
        }
    }

    /*
     * A note on the implementation:
     * <p>
     * As DER requires the constructed, definite-length model to
     * be used for structured types, this varies slightly from the
     * ASN.1 descriptions given. Rather than just outputing SET,
     * we also have to specify CONSTRUCTED, and the objects length.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.338 -0500", hash_original_method = "0C0574F6B6AA5F6F63D97835BA3FFE58", hash_generated_method = "27E305CBEB8AB667D6FFAD78415E16AD")
    
void encode(
        DEROutputStream out)
        throws IOException
    {
        // TODO Intermediate buffer could be avoided if we could calculate expected length
        ByteArrayOutputStream   bOut = new ByteArrayOutputStream();
        DEROutputStream         dOut = new DEROutputStream(bOut);
        Enumeration             e = this.getObjects();

        while (e.hasMoreElements())
        {
            Object    obj = e.nextElement();

            dOut.writeObject(obj);
        }

        dOut.close();

        byte[]  bytes = bOut.toByteArray();

        out.writeEncoded(SET | CONSTRUCTED, bytes);
    }

    
}

