package org.bouncycastle.crypto;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface Digest
{
    
    public String getAlgorithmName();

    
    public int getDigestSize();

    
    public void update(byte in);

    
    public void update(byte[] in, int inOff, int len);

    
    public int doFinal(byte[] out, int outOff);

    
    public void reset();
}
