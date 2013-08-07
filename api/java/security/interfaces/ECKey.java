package java.security.interfaces;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.security.spec.ECParameterSpec;

public interface ECKey {

    
    public ECParameterSpec getParams();
}
