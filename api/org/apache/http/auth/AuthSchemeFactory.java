package org.apache.http.auth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.params.HttpParams;

public interface AuthSchemeFactory {    

    AuthScheme newInstance(HttpParams params);

}
