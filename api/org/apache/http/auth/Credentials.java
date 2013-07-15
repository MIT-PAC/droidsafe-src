package org.apache.http.auth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.security.Principal;

public interface Credentials {

    Principal getUserPrincipal();

    String getPassword();
    
}
