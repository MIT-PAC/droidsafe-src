package org.apache.http.client;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;

public interface CredentialsProvider {

    
    void setCredentials(AuthScope authscope, Credentials credentials);

    
    Credentials getCredentials(AuthScope authscope);

    
    void clear();
    
}
