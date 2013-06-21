package org.w3c.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface UserDataHandler {
    
    
    public static final short NODE_CLONED               = 1;
    
    public static final short NODE_IMPORTED             = 2;
    
    public static final short NODE_DELETED              = 3;
    
    public static final short NODE_RENAMED              = 4;
    
    public static final short NODE_ADOPTED              = 5;

    
    public void handle(short operation,
                       String key,
                       Object data,
                       Node src,
                       Node dst);

}
