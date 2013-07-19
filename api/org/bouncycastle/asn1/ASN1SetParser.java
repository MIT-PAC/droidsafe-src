package org.bouncycastle.asn1;

// Droidsafe Imports
import java.io.IOException;

public interface ASN1SetParser
    extends DEREncodable, InMemoryRepresentable
{
    public DEREncodable readObject()
        throws IOException;
}
