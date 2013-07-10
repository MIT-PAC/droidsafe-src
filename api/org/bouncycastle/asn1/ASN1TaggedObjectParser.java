package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;

public interface ASN1TaggedObjectParser
    extends DEREncodable, InMemoryRepresentable
{
    public int getTagNo();
    
    public DEREncodable getObjectParser(int tag, boolean isExplicit)
        throws IOException;
}
