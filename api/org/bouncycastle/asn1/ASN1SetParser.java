package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;

public interface ASN1SetParser
    extends DEREncodable, InMemoryRepresentable
{
    public DEREncodable readObject()
        throws IOException;
}
