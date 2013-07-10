package org.w3c.dom;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface CharacterData extends Node {
    
    public String getData()
                            throws DOMException;
    
    public void setData(String data)
                            throws DOMException;

    
    public int getLength();

    
    public String substringData(int offset,
                                int count)
                                throws DOMException;

    
    public void appendData(String arg)
                           throws DOMException;

    
    public void insertData(int offset,
                           String arg)
                           throws DOMException;

    
    public void deleteData(int offset,
                           int count)
                           throws DOMException;

    
    public void replaceData(int offset,
                            int count,
                            String arg)
                            throws DOMException;

}
