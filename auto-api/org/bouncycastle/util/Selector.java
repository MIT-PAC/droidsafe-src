package org.bouncycastle.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface Selector
    extends Cloneable
{
    boolean match(Object obj);

    Object clone();
}
