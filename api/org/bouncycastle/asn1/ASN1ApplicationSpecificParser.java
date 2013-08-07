package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;

public interface ASN1ApplicationSpecificParser
    extends DEREncodable, InMemoryRepresentable
{
    DEREncodable readObject()
        throws IOException;
}
