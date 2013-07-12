package org.bouncycastle.util.io.pem;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface PemObjectGenerator
{
    PemObject generate()
        throws PemGenerationException;
}
