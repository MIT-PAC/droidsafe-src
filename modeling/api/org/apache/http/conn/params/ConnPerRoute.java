package org.apache.http.conn.params;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.conn.routing.HttpRoute;

public interface ConnPerRoute {

    @DSVerified
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    int getMaxForRoute(HttpRoute route);
    
}
