package org.apache.http.auth;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.Principal;

public interface Credentials {

    Principal getUserPrincipal();

    String getPassword();
    
}
