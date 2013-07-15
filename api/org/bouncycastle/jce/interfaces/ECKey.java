package org.bouncycastle.jce.interfaces;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.bouncycastle.jce.spec.ECParameterSpec;

public interface ECKey
{
    
    public ECParameterSpec getParameters();
}
