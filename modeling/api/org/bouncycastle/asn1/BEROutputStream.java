package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.OutputStream;

public class BEROutputStream extends DEROutputStream {
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.040 -0500", hash_original_method = "39D0C914F21422AAB9B31B993D1339D0", hash_generated_method = "28BBAD8BDC7025DAF40DA1211C60EC05")
    
public BEROutputStream(
        OutputStream    os)
    {
        super(os);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.042 -0500", hash_original_method = "7A7F2C3481471D2C873255AD36ADBA85", hash_generated_method = "798D21AF0BF25D74DE1C514D0932572C")
    
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
            throw new IOException("object not BEREncodable");
        }
    }
    
}

