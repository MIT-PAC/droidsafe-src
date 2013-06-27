package org.bouncycastle.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface Selector
    extends Cloneable
{
    boolean match(Object obj);

    Object clone();
}
