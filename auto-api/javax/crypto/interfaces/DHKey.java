package javax.crypto.interfaces;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.crypto.spec.DHParameterSpec;

public interface DHKey {

    
    public DHParameterSpec getParams();
}
