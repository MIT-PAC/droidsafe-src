package org.apache.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface Header {

    String getName();
    
    String getValue();

    HeaderElement[] getElements() throws ParseException;
    
}
