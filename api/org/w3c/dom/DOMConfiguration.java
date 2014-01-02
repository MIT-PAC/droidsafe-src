package org.w3c.dom;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface DOMConfiguration {
    
    public void setParameter(String name,
                             Object value)
                             throws DOMException;

    
    public Object getParameter(String name)
                               throws DOMException;

    
    public boolean canSetParameter(String name,
                                   Object value);

    
    public DOMStringList getParameterNames();

}
