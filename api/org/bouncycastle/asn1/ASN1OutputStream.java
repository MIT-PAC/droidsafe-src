package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.OutputStream;





public class ASN1OutputStream extends DEROutputStream {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:52.040 -0500", hash_original_method = "B585D0D3F95079429B677B297C18775F", hash_generated_method = "B569EF4B8419AD672B8625889975F8A7")
    public ASN1OutputStream(
        OutputStream    os)
    {
        super(os);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:52.041 -0500", hash_original_method = "7E9399FEF1C678E926DDEA0139F7BC7D", hash_generated_method = "7C45C5B31E1BC705865E60D91A006764")
    public void writeObject(
        Object    obj)
        throws IOException
    {
        if (obj == null)
        {
            writeNull();
        }
        else if (obj instanceof DERObject)
        {
            ((DERObject)obj).encode(this);
        }
        else if (obj instanceof DEREncodable)
        {
            ((DEREncodable)obj).getDERObject().encode(this);
        }
        else
        {
            throw new IOException("object not ASN1Encodable");
        }
    }

    
}

