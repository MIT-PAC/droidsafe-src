package org.bouncycastle.crypto;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
