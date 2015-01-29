package org.w3c.dom;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface TypeInfo {
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public String getTypeName();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public String getTypeNamespace();
    
    public static final int DERIVATION_RESTRICTION    = 0x00000001;
    
    public static final int DERIVATION_EXTENSION      = 0x00000002;
    
    public static final int DERIVATION_UNION          = 0x00000004;
    
    public static final int DERIVATION_LIST           = 0x00000008;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean isDerivedFrom(String typeNamespaceArg,
                                 String typeNameArg,
                                 int derivationMethod);

}
