package org.bouncycastle.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface Selector
    extends Cloneable
{
    boolean match(Object obj);

    Object clone();
}
