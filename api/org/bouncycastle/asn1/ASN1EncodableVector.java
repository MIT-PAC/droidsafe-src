package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Vector;

public class ASN1EncodableVector extends DEREncodableVector {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.363 -0500", hash_original_field = "A7A9A9F7A17391F6E585D35448FF7802", hash_generated_field = "A7A9A9F7A17391F6E585D35448FF7802")

    Vector v = new Vector();

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.365 -0500", hash_original_method = "631383CBD9A750B80992BEF56F7E2945", hash_generated_method = "0FC980AE54DA50E15EB5694BA518610D")
    
public ASN1EncodableVector()
    {

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.367 -0500", hash_original_method = "D2631DDAF2947787DEB94C0E4C39923E", hash_generated_method = "48317AC83DE284FEAB21BF24DC99B0C2")
    
public void add(DEREncodable obj)
    {
        v.addElement(obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.370 -0500", hash_original_method = "B314138255529409821E04A292C38866", hash_generated_method = "41F69DCE6FBBE0D8D974E08E716C3A3F")
    
public DEREncodable get(int i)
    {
        return (DEREncodable)v.elementAt(i);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.373 -0500", hash_original_method = "F82248B1BB6EFF1F27955CBD5C3A97B0", hash_generated_method = "EB8E5EC84569D43FF91B328ACD5AFC64")
    
public int size()
    {
        return v.size();
    }
    
}

