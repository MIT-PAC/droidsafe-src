package org.bouncycastle.asn1;

// Droidsafe Imports
import java.io.InputStream;

public interface ASN1OctetStringParser
    extends DEREncodable, InMemoryRepresentable
{
    public InputStream getOctetStream();
}
