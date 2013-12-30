package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;



public class DERSequence extends ASN1Sequence {
    /**
     * create an empty sequence
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.876 -0500", hash_original_method = "B1D7F8D200E7560B8E505C8DEB6A735D", hash_generated_method = "85D53223E55406568DCC1E3049BE6B3B")
    
public DERSequence()
    {
    }

    /**
     * create a sequence containing one object
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.880 -0500", hash_original_method = "02EB65A37D4D288F16E2D066B80A09B0", hash_generated_method = "F90E40FD842414200810B891B70D4B65")
    
public DERSequence(
        DEREncodable    obj)
    {
        this.addObject(obj);
    }

    /**
     * create a sequence containing a vector of objects.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.883 -0500", hash_original_method = "74532D23F47B58A7B943BD7A29A6F5A5", hash_generated_method = "0688AD0FCF54E3601A33DFBBE5746A1C")
    
public DERSequence(
        ASN1EncodableVector   v)
    {
        for (int i = 0; i != v.size(); i++)
        {
            this.addObject(v.get(i));
        }
    }

    /**
     * create a sequence containing an array of objects.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.885 -0500", hash_original_method = "6C44128901F5187598F8352DD3C74981", hash_generated_method = "86E5FD8BB1F2A96A9350DE12B2BEE997")
    
public DERSequence(
        ASN1Encodable[]   a)
    {
        for (int i = 0; i != a.length; i++)
        {
            this.addObject(a[i]);
        }
    }
    
    /*
     * A note on the implementation:
     * <p>
     * As DER requires the constructed, definite-length model to
     * be used for structured types, this varies slightly from the
     * ASN.1 descriptions given. Rather than just outputing SEQUENCE,
     * we also have to specify CONSTRUCTED, and the objects length.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.887 -0500", hash_original_method = "EB6AC1866581E5FE18FBF3DDAE772D4D", hash_generated_method = "7741E6233F15C15B810E57DD9EDBEC11")
    
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

        out.writeEncoded(SEQUENCE | CONSTRUCTED, bytes);
    }

    
}

