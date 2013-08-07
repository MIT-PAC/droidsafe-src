package org.xml.sax;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface Attributes
{


    
    
    


    
    public abstract int getLength ();


    
    public abstract String getURI (int index);


    
    public abstract String getLocalName (int index);


    
    public abstract String getQName (int index);


    
    public abstract String getType (int index);


    
    public abstract String getValue (int index);



    
    
    


    
    public int getIndex (String uri, String localName);


    
    public int getIndex (String qName);


    
    public abstract String getType (String uri, String localName);


    
    public abstract String getType (String qName);


    
    public abstract String getValue (String uri, String localName);


    
    public abstract String getValue (String qName);

}
