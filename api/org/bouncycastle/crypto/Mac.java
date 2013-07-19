package org.bouncycastle.crypto;

// Droidsafe Imports

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
