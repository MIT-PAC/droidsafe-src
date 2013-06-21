package org.w3c.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface DocumentType extends Node {
    
    public String getName();

    
    public NamedNodeMap getEntities();

    
    public NamedNodeMap getNotations();

    
    public String getPublicId();

    
    public String getSystemId();

    
    public String getInternalSubset();

}
