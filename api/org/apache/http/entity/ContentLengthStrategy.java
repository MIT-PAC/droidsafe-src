package org.apache.http.entity;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;

public interface ContentLengthStrategy {

    public static final int IDENTITY         = -1;
    public static final int CHUNKED          = -2;
    
    long determineLength(HttpMessage message) throws HttpException;
            
}
