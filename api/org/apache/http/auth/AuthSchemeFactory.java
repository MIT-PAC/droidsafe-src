package org.apache.http.auth;

// Droidsafe Imports
import org.apache.http.params.HttpParams;

public interface AuthSchemeFactory {    

    AuthScheme newInstance(HttpParams params);

}
