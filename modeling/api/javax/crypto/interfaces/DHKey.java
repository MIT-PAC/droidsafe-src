package javax.crypto.interfaces;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.crypto.spec.DHParameterSpec;

public interface DHKey {
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public DHParameterSpec getParams();
}
