package org.apache.http.client;

// Droidsafe Imports
import java.io.IOException;

import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;

public interface RequestDirector {


    
    HttpResponse execute(HttpHost target, HttpRequest request,
                         HttpContext context)
        throws HttpException, IOException
        ;

}
