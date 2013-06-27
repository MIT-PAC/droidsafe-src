package org.apache.http.conn.params;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface ConnManagerPNames {

     
    public static final String TIMEOUT = "http.conn-manager.timeout"; 

    
    public static final String MAX_CONNECTIONS_PER_ROUTE = "http.conn-manager.max-per-route";

    
    public static final String MAX_TOTAL_CONNECTIONS = "http.conn-manager.max-total";

}
