package org.bouncycastle.util.io.pem;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;

public interface PemObjectParser
{
    Object parseObject(PemObject obj)
            throws IOException;
}
