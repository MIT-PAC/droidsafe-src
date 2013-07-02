package org.w3c.dom;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface DOMStringList {
    
    public String item(int index);

    
    public int getLength();

    
    public boolean contains(String str);

}
