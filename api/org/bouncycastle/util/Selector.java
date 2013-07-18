package org.bouncycastle.util;

// Droidsafe Imports

public interface Selector
    extends Cloneable
{
    boolean match(Object obj);

    Object clone();
}
