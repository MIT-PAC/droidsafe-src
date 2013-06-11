package org.w3c.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public interface Text extends CharacterData {
    
    public Text splitText(int offset)
                          throws DOMException;

    
    public boolean isElementContentWhitespace();

    
    public String getWholeText();

    
    public Text replaceWholeText(String content)
                                 throws DOMException;

}

