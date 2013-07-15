package org.apache.http.conn.params;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.apache.http.conn.routing.HttpRoute;

public interface ConnPerRoute {

    int getMaxForRoute(HttpRoute route);
    
}
