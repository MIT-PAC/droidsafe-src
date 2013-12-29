package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.Enumeration;



public class BERSequence extends DERSequence {
    /**
     * create an empty sequence
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:55.597 -0500", hash_original_method = "0D9B441EA6B4B8E8347B85C87EDD1299", hash_generated_method = "134B791CD0D6796A7817E9FBE2672519")
    public BERSequence()
    {
    }

    /**
     * create a sequence containing one object
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:55.598 -0500", hash_original_method = "F58B9D9CAFA6022E13B23B504AFBA49E", hash_generated_method = "EF9BF655595B6F8D8A6427E5F24F9CCD")
    public BERSequence(
        DEREncodable    obj)
    {
        super(obj);
    }

    /**
     * create a sequence containing a vector of objects.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:55.599 -0500", hash_original_method = "77CDCB3AD1301C069F2E513DC8F21CC0", hash_generated_method = "F3E389E8A04049A10986837EC4E60A62")
    public BERSequence(
        ASN1EncodableVector   v)
    {
        super(v);
    }

    /*
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:55.600 -0500", hash_original_method = "02357BA9FDB8523F9B8A86E245A5D94B", hash_generated_method = "02357BA9FDB8523F9B8A86E245A5D94B")
    void encode(
        DEROutputStream out)
        throws IOException
    {
        if (out instanceof ASN1OutputStream || out instanceof BEROutputStream)
        {
            out.write(SEQUENCE | CONSTRUCTED);
            out.write(0x80);
            
            Enumeration e = getObjects();
            while (e.hasMoreElements())
            {
                out.writeObject(e.nextElement());
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

