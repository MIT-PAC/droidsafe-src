package org.apache.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Locale;

public interface ReasonPhraseCatalog {

    
    public String getReason(int status, Locale loc)
        ;

}
