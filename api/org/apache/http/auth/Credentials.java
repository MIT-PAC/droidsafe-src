package org.apache.http.auth;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.security.Principal;

public interface Credentials {

    Principal getUserPrincipal();

    String getPassword();
    
}
