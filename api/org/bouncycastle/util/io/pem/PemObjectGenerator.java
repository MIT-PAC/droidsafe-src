package org.bouncycastle.util.io.pem;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface PemObjectGenerator
{
    PemObject generate()
        throws PemGenerationException;
}
