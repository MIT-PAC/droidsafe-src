package org.apache.http.cookie;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.apache.http.params.HttpParams;

public interface CookieSpecFactory {    

    CookieSpec newInstance(HttpParams params);

}
