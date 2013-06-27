package org.apache.commons.io.input;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface TailerListener {

    
    void init(Tailer tailer);

    
    void fileNotFound();

    
    void fileRotated();

    
    void handle(String line);

    
    void handle(Exception ex);

}
