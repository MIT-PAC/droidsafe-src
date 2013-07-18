package org.apache.http.auth;

// Droidsafe Imports
import java.security.Principal;

public interface Credentials {

    Principal getUserPrincipal();

    String getPassword();
    
}
