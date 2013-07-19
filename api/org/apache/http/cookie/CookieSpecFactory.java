package org.apache.http.cookie;

// Droidsafe Imports
import org.apache.http.params.HttpParams;

public interface CookieSpecFactory {    

    CookieSpec newInstance(HttpParams params);

}
