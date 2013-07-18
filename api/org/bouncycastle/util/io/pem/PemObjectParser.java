package org.bouncycastle.util.io.pem;

// Droidsafe Imports
import java.io.IOException;

public interface PemObjectParser
{
    Object parseObject(PemObject obj)
            throws IOException;
}
