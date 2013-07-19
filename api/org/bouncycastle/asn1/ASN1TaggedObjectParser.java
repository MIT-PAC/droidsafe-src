package org.bouncycastle.asn1;

// Droidsafe Imports
import java.io.IOException;

public interface ASN1TaggedObjectParser
    extends DEREncodable, InMemoryRepresentable
{
    public int getTagNo();
    
    public DEREncodable getObjectParser(int tag, boolean isExplicit)
        throws IOException;
}
