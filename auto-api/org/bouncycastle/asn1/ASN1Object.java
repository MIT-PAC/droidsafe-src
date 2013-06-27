package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public abstract class ASN1Object extends DERObject {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.701 -0400", hash_original_method = "79A6503CF02D2BF6CA7C22C7ECE56A0E", hash_generated_method = "79A6503CF02D2BF6CA7C22C7ECE56A0E")
    public ASN1Object ()
    {
        //Synthesized constructor
    }


        public static ASN1Object fromByteArray(byte[] data) throws IOException {
        ASN1InputStream aIn = new ASN1InputStream(data);
        try
        {
            return (ASN1Object)aIn.readObject();
        }
        catch (ClassCastException e)
        {
            throw new IOException("cannot recognise object in stream");    
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.703 -0400", hash_original_method = "DA81A9CF27CE7E2A8EA2EF36D7C19ED4", hash_generated_method = "72858C9EB26F3B66DEBF6272A067B1B8")
    public final boolean equals(Object o) {
        boolean varC64BD2CC2CF0DD7A929C1BCE70981A7D_2056766671 = ((o instanceof DEREncodable) && asn1Equals(((DEREncodable)o).getDERObject()));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1260446340 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1260446340;
        // ---------- Original Method ----------
        //if (this == o)
        //{
            //return true;
        //}
        //return (o instanceof DEREncodable) && asn1Equals(((DEREncodable)o).getDERObject());
    }

    
    public abstract int hashCode();

    
    abstract void encode(DEROutputStream out) throws IOException;

    
    abstract boolean asn1Equals(DERObject o);

    
}

