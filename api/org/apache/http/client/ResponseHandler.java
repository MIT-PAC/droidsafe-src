package org.apache.http.client;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import org.apache.http.HttpResponse;

public interface ResponseHandler<T> {

    
    T handleResponse(HttpResponse response) throws ClientProtocolException, IOException;
    
}
