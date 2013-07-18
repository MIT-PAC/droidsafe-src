package org.apache.http.conn.params;

// Droidsafe Imports
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.params.HttpParams;

import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public final class ConnManagerParams implements ConnManagerPNames {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.733 -0400", hash_original_method = "8D73F0F63C95FBB6C86DB2075286A73B", hash_generated_method = "8D73F0F63C95FBB6C86DB2075286A73B")
    public ConnManagerParams ()
    {
        //Synthesized constructor
    }


    public static long getTimeout(final HttpParams params) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        return params.getLongParameter(TIMEOUT, 0);
    }

    
    public static void setTimeout(final HttpParams params, long timeout) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        params.setLongParameter(TIMEOUT, timeout);
    }

    
    public static void setMaxConnectionsPerRoute(final HttpParams params,
                                                final ConnPerRoute connPerRoute) {
        if (params == null) {
            throw new IllegalArgumentException
                ("HTTP parameters must not be null.");
        }
        params.setParameter(MAX_CONNECTIONS_PER_ROUTE, connPerRoute);
    }

    
    public static ConnPerRoute getMaxConnectionsPerRoute(final HttpParams params) {
        if (params == null) {
            throw new IllegalArgumentException
                ("HTTP parameters must not be null.");
        }
        ConnPerRoute connPerRoute = (ConnPerRoute) params.getParameter(MAX_CONNECTIONS_PER_ROUTE);
        if (connPerRoute == null) {
            connPerRoute = DEFAULT_CONN_PER_ROUTE;
        }
        return connPerRoute;
    }

    
    public static void setMaxTotalConnections(
            final HttpParams params,
            int maxTotalConnections) {
        if (params == null) {
            throw new IllegalArgumentException
                ("HTTP parameters must not be null.");
        }
        params.setIntParameter(MAX_TOTAL_CONNECTIONS, maxTotalConnections);
    }

    
    public static int getMaxTotalConnections(
            final HttpParams params) {
        if (params == null) {
            throw new IllegalArgumentException
                ("HTTP parameters must not be null.");
        }
        return params.getIntParameter(MAX_TOTAL_CONNECTIONS, DEFAULT_MAX_TOTAL_CONNECTIONS);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.737 -0400", hash_original_field = "8083486B9C020E19D5C7068AFB38AE78", hash_generated_field = "FBFB3324EA0A0B325C6C3EFFF24349B5")

    public static final int DEFAULT_MAX_TOTAL_CONNECTIONS = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.069 -0400", hash_original_field = "DD59E98DD00850A7DCC1DD983A709C49", hash_generated_field = "31C4DE057B93401DBCAF299288501B61")

    private static final ConnPerRoute DEFAULT_CONN_PER_ROUTE = new ConnPerRoute() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.069 -0400", hash_original_method = "BC1F672F46BDFCECD4BF3D32787E67D5", hash_generated_method = "8A95F28D3AD48F3D120597EE4D0EC8E5")
        public int getMaxForRoute(HttpRoute route) {
            addTaint(route.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1631977428 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1631977428;
            
            
        }

        
};
}

