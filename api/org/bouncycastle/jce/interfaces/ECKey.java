package org.bouncycastle.jce.interfaces;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.bouncycastle.jce.spec.ECParameterSpec;

public interface ECKey
{
    
    public ECParameterSpec getParameters();
}
