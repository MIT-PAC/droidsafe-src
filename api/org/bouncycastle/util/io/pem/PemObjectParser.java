package org.bouncycastle.util.io.pem;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

public interface PemObjectParser
{
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    Object parseObject(PemObject obj)
            throws IOException;
}
