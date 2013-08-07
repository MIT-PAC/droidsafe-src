package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;

public interface InMemoryRepresentable
{
    DERObject getLoadedObject()
        throws IOException;
}
