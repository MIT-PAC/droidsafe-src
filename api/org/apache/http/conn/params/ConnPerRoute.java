package org.apache.http.conn.params;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.conn.routing.HttpRoute;

public interface ConnPerRoute {

    int getMaxForRoute(HttpRoute route);
    
}
