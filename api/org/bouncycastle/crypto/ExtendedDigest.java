package org.bouncycastle.crypto;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface ExtendedDigest 
    extends Digest
{
    
    public int getByteLength();
}
