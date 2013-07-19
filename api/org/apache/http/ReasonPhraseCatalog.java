package org.apache.http;

// Droidsafe Imports
import java.util.Locale;

public interface ReasonPhraseCatalog {

    
    public String getReason(int status, Locale loc)
        ;

}
