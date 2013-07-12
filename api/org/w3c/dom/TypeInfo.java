package org.w3c.dom;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface TypeInfo {
    
    public String getTypeName();

    
    public String getTypeNamespace();

    
    
    public static final int DERIVATION_RESTRICTION    = 0x00000001;
    
    public static final int DERIVATION_EXTENSION      = 0x00000002;
    
    public static final int DERIVATION_UNION          = 0x00000004;
    
    public static final int DERIVATION_LIST           = 0x00000008;

    
    public boolean isDerivedFrom(String typeNamespaceArg,
                                 String typeNameArg,
                                 int derivationMethod);

}
