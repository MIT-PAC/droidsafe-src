package org.bouncycastle.asn1;

// Droidsafe Imports
import java.io.IOException;

public interface ASN1SequenceParser
    extends DEREncodable, InMemoryRepresentable
{
    DEREncodable readObject()
        throws IOException;
}
