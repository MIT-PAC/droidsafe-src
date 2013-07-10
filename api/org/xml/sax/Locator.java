package org.xml.sax;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface Locator {


    
    public abstract String getPublicId ();


    
    public abstract String getSystemId ();


    
    public abstract int getLineNumber ();


    
    public abstract int getColumnNumber ();

}
