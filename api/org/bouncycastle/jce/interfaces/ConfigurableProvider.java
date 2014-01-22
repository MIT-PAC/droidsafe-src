package org.bouncycastle.jce.interfaces;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface ConfigurableProvider
{
    static final String      THREAD_LOCAL_EC_IMPLICITLY_CA = "threadLocalEcImplicitlyCa";   
    static final String      EC_IMPLICITLY_CA = "ecImplicitlyCa";

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void setParameter(String parameterName, Object parameter);
}
