package org.w3c.dom;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface DOMError {
    
    
    public static final short SEVERITY_WARNING          = 1;
    
    public static final short SEVERITY_ERROR            = 2;
    
    public static final short SEVERITY_FATAL_ERROR      = 3;

    
    public short getSeverity();

    
    public String getMessage();

    
    public String getType();

    
    public Object getRelatedException();

    
    public Object getRelatedData();

    
    public DOMLocator getLocation();

}
