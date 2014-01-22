package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

public interface ASN1SequenceParser
    extends DEREncodable, InMemoryRepresentable
{
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    DEREncodable readObject()
        throws IOException;
}
