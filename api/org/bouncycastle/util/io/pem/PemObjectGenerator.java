package org.bouncycastle.util.io.pem;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface PemObjectGenerator
{
    PemObject generate()
        throws PemGenerationException;
}
