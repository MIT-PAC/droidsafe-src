package org.w3c.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface Text extends CharacterData {
    
    public Text splitText(int offset)
                          throws DOMException;

    
    public boolean isElementContentWhitespace();

    
    public String getWholeText();

    
    public Text replaceWholeText(String content)
                                 throws DOMException;

}
