package org.bouncycastle.util.io.pem;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface PemObjectGenerator
{
    PemObject generate()
        throws PemGenerationException;
}
