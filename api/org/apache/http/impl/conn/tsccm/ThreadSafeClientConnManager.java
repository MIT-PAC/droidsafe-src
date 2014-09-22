package org.apache.http.impl.conn.tsccm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.conn.DefaultClientConnectionOperator;
import org.apache.http.params.HttpParams;

import dalvik.system.SocketTagger;

public class ThreadSafeClientConnManager implements ClientConnectionManager {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.990 -0500", hash_original_field = "0DA7E40E862C937570CA6B0D96D2555A", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.992 -0500", hash_original_field = "FFCBB3FF9A8B5221F5621A7A590508B0", hash_generated_field = "262A27B6B6B1CBF25439CFECC3909997")

    protected SchemeRegistry schemeRegistry;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.994 -0500", hash_original_field = "C51B0436AE871509A750A80EBB760F42", hash_generated_field = "A126A5C00AC17033F6B94E836FE92D15")

    protected  AbstractConnPool connectionPool;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.996 -0500", hash_original_field = "E40B74D82804A7A9813CCFFD83EFDC95", hash_generated_field = "6D2607DA479BDA11A25B13C47E7F0C5C")

    protected ClientConnectionOperator connOperator;

    /**
     * Creates a new thread safe connection manager.
     *
     * @param params    the parameters for this manager
     * @param schreg    the scheme registry, or
     *                  <code>null</code> for the default registry
     */
    @DSComment("internet access")
    @DSSpec(DSCat.INTERNET)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.999 -0500", hash_original_method = "CE8305B2F50479AC170D47319F9570C8", hash_generated_method = "3017661F6403C8D54CDAF2BA856FA17A")
    
public ThreadSafeClientConnManager(HttpParams params,
                                       SchemeRegistry schreg) {

        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        this.schemeRegistry = schreg;
        this.connOperator   = createConnectionOperator(schreg);
        this.connectionPool = createConnectionPool(params);

    } // <constructor>
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.002 -0500", hash_original_method = "0E19810A97EBEE58216EC05F0D60A026", hash_generated_method = "7633383EE29DF3462EC06822CAD53A41")
    
@Override
    protected void finalize() throws Throwable {
        shutdown();
        super.finalize();
    }

    /**
     * Hook for creating the connection pool.
     *
     * @return  the connection pool to use
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.004 -0500", hash_original_method = "E5BC66DBF19261346819AE7E60C7F467", hash_generated_method = "43714C46B8D85A3B80F5B710851996FB")
    
protected AbstractConnPool createConnectionPool(final HttpParams params) {

        AbstractConnPool acp = new ConnPoolByRoute(connOperator, params);
        boolean conngc = true; //@@@ check parameters to decide
        if (conngc) {
            acp.enableConnectionGC();
        }
        return acp;
    }

    /**
     * Hook for creating the connection operator.
     * It is called by the constructor.
     * Derived classes can override this method to change the
     * instantiation of the operator.
     * The default implementation here instantiates
     * {@link DefaultClientConnectionOperator DefaultClientConnectionOperator}.
     *
     * @param schreg    the scheme registry to use, or <code>null</code>
     *
     * @return  the connection operator to use
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.006 -0500", hash_original_method = "25E4E60569E24699D7326BD2975E9BC2", hash_generated_method = "CDFBE14A441ACDD32840AD53090D9F1C")
    
protected ClientConnectionOperator
        createConnectionOperator(SchemeRegistry schreg) {

        return new DefaultClientConnectionOperator(schreg);
    }

    // non-javadoc, see interface ClientConnectionManager
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.008 -0500", hash_original_method = "98F37EDA7C4377EF27FBBC8455A5DCE4", hash_generated_method = "F81D1E42481BBD388E0F662F8AE87096")
    
public SchemeRegistry getSchemeRegistry() {
        return this.schemeRegistry;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.017 -0500", hash_original_method = "3E5898B68534E316FCFFCF41E86D81D5", hash_generated_method = "2595F1BD101B9EFC4F50FA58275F098D")
    
public ClientConnectionRequest requestConnection(
            final HttpRoute route, 
            final Object state) {
        
        final PoolEntryRequest poolRequest = connectionPool.requestPoolEntry(
                route, state);
        
        return new ClientConnectionRequest() {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:39.881 -0400", hash_original_method = "F05670E2223BB88FEEE004D958D804B8", hash_generated_method = "C015E39A59E87F5CCED4C0BEA6A35F4F")
            
public void abortRequest() {
                poolRequest.abortRequest();
            }
            
            @DSSource({DSSourceKind.NETWORK_INFORMATION})

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:39.882 -0400", hash_original_method = "6069BCC0A12724F289E46465DF3930EB", hash_generated_method = "D6BE21BEFC25F7F837BCD631BB872C2F")
            
public ManagedClientConnection getConnection(
                    long timeout, TimeUnit tunit) throws InterruptedException,
                    ConnectionPoolTimeoutException {
                if (route == null) {
                    throw new IllegalArgumentException("Route may not be null.");
                }

                if (log.isDebugEnabled()) {
                    log.debug("ThreadSafeClientConnManager.getConnection: "
                        + route + ", timeout = " + timeout);
                }

                BasicPoolEntry entry = poolRequest.getPoolEntry(timeout, tunit);
                // BEGIN android-changed
                // When using a recycled Socket, we need to re-tag it with any
                // updated statistics options.
                try {
                    final Socket socket = entry.getConnection().getSocket();
                    if (socket != null) {
                        SocketTagger.get().tag(socket);
                    }
                } catch (IOException iox) {
                    log.debug("Problem tagging socket.", iox);
                }
                // END android-changed
                return new BasicPooledConnAdapter(ThreadSafeClientConnManager.this, entry);
            }
            
        };
        
    }
    
    // non-javadoc, see interface ClientConnectionManager
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.021 -0500", hash_original_method = "3CF782E9F00803924FA9A14119B3585D", hash_generated_method = "965933621A779C00BB41B52FA48DB134")
    
public void releaseConnection(ManagedClientConnection conn, long validDuration, TimeUnit timeUnit) {

        if (!(conn instanceof BasicPooledConnAdapter)) {
            throw new IllegalArgumentException
                ("Connection class mismatch, " +
                 "connection not obtained from this manager.");
        }
        BasicPooledConnAdapter hca = (BasicPooledConnAdapter) conn;
        if ((hca.getPoolEntry() != null) && (hca.getManager() != this)) {
            throw new IllegalArgumentException
                ("Connection not obtained from this manager.");
        }

        try {
            // BEGIN android-changed
            // When recycling a Socket, we un-tag it to avoid collecting
            // statistics from future users.
            final BasicPoolEntry entry = (BasicPoolEntry) hca.getPoolEntry();
            final Socket socket = entry.getConnection().getSocket();
            if (socket != null) {
                SocketTagger.get().untag(socket);
            }
            // END android-changed

            // make sure that the response has been read completely
            if (hca.isOpen() && !hca.isMarkedReusable()) {
                if (log.isDebugEnabled()) {
                    log.debug
                        ("Released connection open but not marked reusable.");
                }
                // In MTHCM, there would be a call to
                // SimpleHttpConnectionManager.finishLastResponse(conn);
                // Consuming the response is handled outside in 4.0.

                // make sure this connection will not be re-used
                // Shut down rather than close, we might have gotten here
                // because of a shutdown trigger.
                // Shutdown of the adapter also clears the tracked route.
                hca.shutdown();
            }
        } catch (IOException iox) {
            //@@@ log as warning? let pass?
            if (log.isDebugEnabled())
                log.debug("Exception shutting down released connection.",
                          iox);
        } finally {
            BasicPoolEntry entry = (BasicPoolEntry) hca.getPoolEntry();
            boolean reusable = hca.isMarkedReusable();
            hca.detach();
            if (entry != null) {
                connectionPool.freeEntry(entry, reusable, validDuration, timeUnit);
            }
        }
    }

    // non-javadoc, see interface ClientConnectionManager
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.023 -0500", hash_original_method = "5B798EEC995C1D56865AC1580F955080", hash_generated_method = "CEE6CB689845EDD2EA493E239BD36C85")
    
public void shutdown() {
        connectionPool.shutdown();
    }

    /**
     * Gets the total number of pooled connections for the given route.
     * This is the total number of connections that have been created and
     * are still in use by this connection manager for the route.
     * This value will not exceed the maximum number of connections per host.
     * 
     * @param route     the route in question
     *
     * @return  the total number of pooled connections for that route
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.025 -0500", hash_original_method = "52C9DA1F5E2D598BCB82BD013D1068AD", hash_generated_method = "465C2C57EE0EF189E08CEF080378B6A3")
    
public int getConnectionsInPool(HttpRoute route) {
        return ((ConnPoolByRoute)connectionPool).getConnectionsInPool(
                route);
    }

    /**
     * Gets the total number of pooled connections.  This is the total number of 
     * connections that have been created and are still in use by this connection 
     * manager.  This value will not exceed the maximum number of connections
     * in total.
     * 
     * @return the total number of pooled connections
     */
    @DSComment("not network data manipulation")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.027 -0500", hash_original_method = "A7E68EC885457C399BA150A4DD387F90", hash_generated_method = "AE043477A09E5726953EC376CD87E313")
    
public int getConnectionsInPool() {
        synchronized (connectionPool) {
            return connectionPool.numConnections; //@@@
        }
    }

    // non-javadoc, see interface ClientConnectionManager
    @DSComment("not network data manipulation")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.029 -0500", hash_original_method = "614803CEB018564B6D4B8085A3E1BC4F", hash_generated_method = "9701D873AA485CC59CEAB1483AA16E3C")
    
public void closeIdleConnections(long idleTimeout, TimeUnit tunit) {
        // combine these two in a single call?
        connectionPool.closeIdleConnections(idleTimeout, tunit);
        connectionPool.deleteClosedConnections();
    }
    
    @DSComment("not network data manipulation")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.032 -0500", hash_original_method = "3CBEAD5C5E5FD142C35EE66C6F0AAE4C", hash_generated_method = "CA70EE0AA50EB205DCE5EB4409E500DE")
    
public void closeExpiredConnections() {
        connectionPool.closeExpiredConnections();
        connectionPool.deleteClosedConnections();
    }
    
}

