package org.apache.commons.io.input;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface TailerListener {

    
    void init(Tailer tailer);

    
    void fileNotFound();

    
    void fileRotated();

    
    void handle(String line);

    
    void handle(Exception ex);

}
