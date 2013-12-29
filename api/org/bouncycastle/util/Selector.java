package org.bouncycastle.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface Selector
    extends Cloneable
{
    boolean match(Object obj);

    Object clone();
}
