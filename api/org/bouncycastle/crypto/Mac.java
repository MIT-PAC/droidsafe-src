package org.bouncycastle.crypto;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface Mac
{
    
    public void init(CipherParameters params)
        throws IllegalArgumentException;

    
    public String getAlgorithmName();

    
    public int getMacSize();

    
    public void update(byte in)
        throws IllegalStateException;

    
    public void update(byte[] in, int inOff, int len)
        throws DataLengthException, IllegalStateException;

    
    public int doFinal(byte[] out, int outOff)
        throws DataLengthException, IllegalStateException;

    
    public void reset();
}
