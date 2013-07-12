package javax.crypto.interfaces;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.crypto.spec.DHParameterSpec;

public interface DHKey {

    
    public DHParameterSpec getParams();
}
