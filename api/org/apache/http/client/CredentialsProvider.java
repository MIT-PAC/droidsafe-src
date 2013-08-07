package org.apache.http.client;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;

public interface CredentialsProvider {

    
    void setCredentials(AuthScope authscope, Credentials credentials);

    
    Credentials getCredentials(AuthScope authscope);

    
    void clear();
    
}
