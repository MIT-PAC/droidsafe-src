package org.apache.http.conn.routing;

// Droidsafe Imports
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.protocol.HttpContext;

public interface HttpRoutePlanner {
    
            
    public HttpRoute determineRoute(HttpHost target,
                                    HttpRequest request,
                                    HttpContext context)
        throws HttpException
        ;
    
}
