package org.bouncycastle.util.io.pem;

// Droidsafe Imports

public interface PemObjectGenerator
{
    PemObject generate()
        throws PemGenerationException;
}
