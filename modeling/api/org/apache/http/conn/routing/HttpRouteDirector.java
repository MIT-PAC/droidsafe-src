package org.apache.http.conn.routing;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface HttpRouteDirector {
    
    public final static int UNREACHABLE = -1;
    
    public final static int COMPLETE = 0;
    
    public final static int CONNECT_TARGET = 1;
    
    public final static int CONNECT_PROXY = 2;
    
    public final static int TUNNEL_TARGET = 3;
    
    public final static int TUNNEL_PROXY = 4;
    
    public final static int LAYER_PROTOCOL = 5;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int nextStep(RouteInfo plan, RouteInfo fact)
        ;

}
