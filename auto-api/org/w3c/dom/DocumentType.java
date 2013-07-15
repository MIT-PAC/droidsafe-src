package org.w3c.dom;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface DocumentType extends Node {
    
    public String getName();

    
    public NamedNodeMap getEntities();

    
    public NamedNodeMap getNotations();

    
    public String getPublicId();

    
    public String getSystemId();

    
    public String getInternalSubset();

}
