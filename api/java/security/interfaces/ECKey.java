package java.security.interfaces;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.spec.ECParameterSpec;

public interface ECKey {

    
    public ECParameterSpec getParams();
}
