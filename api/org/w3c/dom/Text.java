package org.w3c.dom;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface Text extends CharacterData {
    
    public Text splitText(int offset)
                          throws DOMException;

    
    public boolean isElementContentWhitespace();

    
    public String getWholeText();

    
    public Text replaceWholeText(String content)
                                 throws DOMException;

}
