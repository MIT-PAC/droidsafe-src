package javax.crypto.interfaces;

// Droidsafe Imports
import droidsafe.annotations.*;
import javax.crypto.spec.DHParameterSpec;

public interface DHKey {

    
    public DHParameterSpec getParams();
}
