package org.xml.sax;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

@Deprecated public interface AttributeList {


    
    
    


    
    public abstract int getLength ();


    
    public abstract String getName (int i);


    
    public abstract String getType (int i);


    
    public abstract String getValue (int i);



    
    
    


    
    public abstract String getType (String name);


    
    public abstract String getValue (String name);

}
