package org.apache.http.auth;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.apache.http.params.HttpParams;

public interface AuthSchemeFactory {    

    AuthScheme newInstance(HttpParams params);

}
