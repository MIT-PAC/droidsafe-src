package org.w3c.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface DOMStringList {
    
    public String item(int index);

    
    public int getLength();

    
    public boolean contains(String str);

}
