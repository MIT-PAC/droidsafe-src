package org.apache.http.auth;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.security.Principal;

public interface Credentials {

    Principal getUserPrincipal();

    String getPassword();
    
}
