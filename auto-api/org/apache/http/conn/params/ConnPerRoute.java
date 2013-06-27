package org.apache.http.conn.params;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.conn.routing.HttpRoute;

public interface ConnPerRoute {

    int getMaxForRoute(HttpRoute route);
    
}
