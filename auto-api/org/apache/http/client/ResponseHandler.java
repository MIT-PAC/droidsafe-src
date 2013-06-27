package org.apache.http.client;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import org.apache.http.HttpResponse;

public interface ResponseHandler<T> {

    
    T handleResponse(HttpResponse response) throws ClientProtocolException, IOException;
    
}
