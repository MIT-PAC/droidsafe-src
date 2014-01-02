package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.Enumeration;



public class BERSet extends DERSet {
    /**
     * create an empty sequence
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.729 -0500", hash_original_method = "3B0CACFC7D97D5B3260958CA327C2CC2", hash_generated_method = "735EAA498A9F3963503D9EAE1819DBB2")
    
public BERSet()
    {
    }

    /**
     * create a set containing one object
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.732 -0500", hash_original_method = "58A8309A1516CB825A1DBAF515FA0A22", hash_generated_method = "CB2D009993CB3DB2DF034FA86EC5C8C4")
    
public BERSet(
        DEREncodable    obj)
    {
        super(obj);
    }

    /**
     * @param v - a vector of objects making up the set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.736 -0500", hash_original_method = "863ECA664105F25F4F85CEE28355E9A1", hash_generated_method = "005FC78B20E7282D1308FBE2A4DAC52D")
    
public BERSet(
        ASN1EncodableVector   v)
    {
        super(v, false);
    }

    /**
     * @param v - a vector of objects making up the set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.739 -0500", hash_original_method = "EA203440C88579BB4F9E161A0FFE3946", hash_generated_method = "EA203440C88579BB4F9E161A0FFE3946")
    
BERSet(
        ASN1EncodableVector  v,
        boolean              needsSorting)
    {
        super(v, needsSorting);
    }

    /*
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.742 -0500", hash_original_method = "F901566FF0371DE323597B13C49C1024", hash_generated_method = "F901566FF0371DE323597B13C49C1024")
    
void encode(
        DEROutputStream out)
        throws IOException
    {
        if (out instanceof ASN1OutputStream || out instanceof BEROutputStream)
        {
            out.write(SET | CONSTRUCTED);
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

