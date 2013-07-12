package java.security.interfaces;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.security.spec.ECParameterSpec;

public interface ECKey {

    
    public ECParameterSpec getParams();
}
