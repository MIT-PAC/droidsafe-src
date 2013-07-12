package org.apache.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface Header {

    String getName();
    
    String getValue();

    HeaderElement[] getElements() throws ParseException;
    
}
