package org.xml.sax;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface Locator {


    
    public abstract String getPublicId ();


    
    public abstract String getSystemId ();


    
    public abstract int getLineNumber ();


    
    public abstract int getColumnNumber ();

}
