package org.apache.http.cookie;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.params.HttpParams;

public interface CookieSpecFactory {    

    CookieSpec newInstance(HttpParams params);

}
