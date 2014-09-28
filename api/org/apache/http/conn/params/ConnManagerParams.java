package org.apache.http.conn.params;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.params.HttpParams;

public final class ConnManagerParams implements ConnManagerPNames {

    /**
     * Returns the timeout in milliseconds used when retrieving a
     * {@link org.apache.http.conn.ManagedClientConnection} from the
     * {@link org.apache.http.conn.ClientConnectionManager}.
     * 
     * @return timeout in milliseconds.
     */ 
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.486 -0500", hash_original_method = "FD4C98B6EDB2AFA076AECC9704DEFB76", hash_generated_method = "5387CEDCB7B0BB0910DD35D84FD97F40")
    
public static long getTimeout(final HttpParams params) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        return params.getLongParameter(TIMEOUT, 0);
    }

    /**
     * Sets the timeout in milliseconds used when retrieving a
     * {@link org.apache.http.conn.ManagedClientConnection} from the
     * {@link org.apache.http.conn.ClientConnectionManager}.
     * 
     * @param timeout the timeout in milliseconds
     */ 
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.489 -0500", hash_original_method = "7D98989200DAF0BA98D6FFB7AC81BAD6", hash_generated_method = "8A302D9C85D171E68FBD072098ACDA21")
    
public static void setTimeout(final HttpParams params, long timeout) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        params.setLongParameter(TIMEOUT, timeout);
    }
    
    /**
     * Sets lookup interface for maximum number of connections allowed per route.
     *
     * @param params HTTP parameters
     * @param connPerRoute lookup interface for maximum number of connections allowed 
     *        per route
     * 
     * @see ConnManagerPNames#MAX_CONNECTIONS_PER_ROUTE
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.497 -0500", hash_original_method = "3DCAD70CA382D41D17C5B340B2EE4C25", hash_generated_method = "16B1D778A5050ED6238BF2CD9D270CB4")
    
public static void setMaxConnectionsPerRoute(final HttpParams params,
                                                final ConnPerRoute connPerRoute) {
        if (params == null) {
            throw new IllegalArgumentException
                ("HTTP parameters must not be null.");
        }
        params.setParameter(MAX_CONNECTIONS_PER_ROUTE, connPerRoute);
    }

    /**
     * Returns lookup interface for maximum number of connections allowed per route.
     *
     * @param params HTTP parameters
     * 
     * @return lookup interface for maximum number of connections allowed per route.
     * 
     * @see ConnManagerPNames#MAX_CONNECTIONS_PER_ROUTE
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.501 -0500", hash_original_method = "DA6ADC6E9D2C27BABC0D2375E7EFB08F", hash_generated_method = "C9A4CA687813F883FB044D2453FB3140")
    @DSVerified
    @DSSafe(DSCat.DATA_STRUCTURE)
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

    /**
     * Sets the maximum number of connections allowed.
     *
     * @param params HTTP parameters
     * @param maxTotalConnections The maximum number of connections allowed.
     * 
     * @see ConnManagerPNames#MAX_TOTAL_CONNECTIONS
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.505 -0500", hash_original_method = "CCEF4B77D67782457983F2288B549EE2", hash_generated_method = "3127C15C40190CCC980FFC20A3EED242")
    
public static void setMaxTotalConnections(
            final HttpParams params,
            int maxTotalConnections) {
        if (params == null) {
            throw new IllegalArgumentException
                ("HTTP parameters must not be null.");
        }
        params.setIntParameter(MAX_TOTAL_CONNECTIONS, maxTotalConnections);
    }

    /**
     * Gets the maximum number of connections allowed.
     *
     * @param params HTTP parameters
     *
     * @return The maximum number of connections allowed.
     * 
     * @see ConnManagerPNames#MAX_TOTAL_CONNECTIONS
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.507 -0500", hash_original_method = "8A44C1562C00FDF1C3C7A41DAEA26FFA", hash_generated_method = "2198D79E44FD7265C9FEBFD6CE73CE83")
    
public static int getMaxTotalConnections(
            final HttpParams params) {
        if (params == null) {
            throw new IllegalArgumentException
                ("HTTP parameters must not be null.");
        }
        return params.getIntParameter(MAX_TOTAL_CONNECTIONS, DEFAULT_MAX_TOTAL_CONNECTIONS);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.484 -0500", hash_original_field = "B6D5CF03E5CC8D52D832E9FC5112413E", hash_generated_field = "FBFB3324EA0A0B325C6C3EFFF24349B5")

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
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.733 -0400", hash_original_method = "8D73F0F63C95FBB6C86DB2075286A73B", hash_generated_method = "8D73F0F63C95FBB6C86DB2075286A73B")
    public ConnManagerParams ()
    {
        //Synthesized constructor
    }
}

