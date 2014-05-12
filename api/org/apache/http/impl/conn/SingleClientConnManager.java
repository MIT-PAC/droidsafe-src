package org.apache.http.impl.conn;

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
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.RouteTracker;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.params.HttpParams;

import dalvik.system.SocketTagger;

public class SingleClientConnManager implements ClientConnectionManager {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.312 -0500", hash_original_field = "212B0A87EB1D1484BA67339913729EAD", hash_generated_field = "3A54ED9163F39DBD02547DB2ADF36FAA")

    public final static String MISUSE_MESSAGE =
    "Invalid use of SingleClientConnManager: connection still allocated.\n" +
    "Make sure to release the connection before allocating another one.";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.310 -0500", hash_original_field = "0DA7E40E862C937570CA6B0D96D2555A", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.314 -0500", hash_original_field = "FFCBB3FF9A8B5221F5621A7A590508B0", hash_generated_field = "262A27B6B6B1CBF25439CFECC3909997")

    protected SchemeRegistry schemeRegistry;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.317 -0500", hash_original_field = "E40B74D82804A7A9813CCFFD83EFDC95", hash_generated_field = "6D2607DA479BDA11A25B13C47E7F0C5C")

    protected ClientConnectionOperator connOperator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.319 -0500", hash_original_field = "1FC3C0C2DEE6BA223B95A92407DF3CF0", hash_generated_field = "68C30A3515A31DCBBABC9A4AD6123F1A")

    protected PoolEntry uniquePoolEntry;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.321 -0500", hash_original_field = "D573F697D2CFEE6EF45B922AD7B8BBDB", hash_generated_field = "59F808726659CBD9A4D1E0F9113A82AC")

    protected ConnAdapter managedConn;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.323 -0500", hash_original_field = "2B21A4ED7FDF1EE906849D62F49AACFD", hash_generated_field = "CEAB2B6CC71A381A86CBD5D45B4080B0")

    protected long lastReleaseTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.326 -0500", hash_original_field = "ECF549926F75651BF8B7BB0D9CA04EB8", hash_generated_field = "AF6AF66999801967D31BB459E9721911")

    protected long connectionExpiresTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.328 -0500", hash_original_field = "EEA001539ECD85A5EACB08FB7616AEA3", hash_generated_field = "547C5CD459CD6CC7C1FD7211D1EFA7DD")

    protected boolean alwaysShutDown;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.330 -0500", hash_original_field = "C61B3BDAAF84DD1FE911E77E1145E9CF", hash_generated_field = "F15F5E1E3CD7B6799921EE9E4A605FC3")

    protected volatile boolean isShutDown;

    /**
     * Creates a new simple connection manager.
     *
     * @param params    the parameters for this manager
     * @param schreg    the scheme registry, or
     *                  <code>null</code> for the default registry
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.333 -0500", hash_original_method = "3E7F5EDF72EC8A96B4F4BE9344F2EB6F", hash_generated_method = "434DDE99510BF4146083C4E09BC81D24")
    
public SingleClientConnManager(HttpParams params,
                                   SchemeRegistry schreg) {

        if (schreg == null) {
            throw new IllegalArgumentException
                ("Scheme registry must not be null.");
        }
        this.schemeRegistry  = schreg;
        this.connOperator    = createConnectionOperator(schreg);
        this.uniquePoolEntry = new PoolEntry();
        this.managedConn     = null;
        this.lastReleaseTime = -1L;
        this.alwaysShutDown  = false; //@@@ from params? as argument?
        this.isShutDown      = false;

    } // <constructor>

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.335 -0500", hash_original_method = "0E19810A97EBEE58216EC05F0D60A026", hash_generated_method = "7633383EE29DF3462EC06822CAD53A41")
    
@Override
    protected void finalize() throws Throwable {
        shutdown();
        super.finalize();
    }

    // non-javadoc, see interface ClientConnectionManager
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.337 -0500", hash_original_method = "98F37EDA7C4377EF27FBBC8455A5DCE4", hash_generated_method = "F81D1E42481BBD388E0F662F8AE87096")
    
public SchemeRegistry getSchemeRegistry() {
        return this.schemeRegistry;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.340 -0500", hash_original_method = "25E4E60569E24699D7326BD2975E9BC2", hash_generated_method = "CDFBE14A441ACDD32840AD53090D9F1C")
    
protected ClientConnectionOperator
        createConnectionOperator(SchemeRegistry schreg) {

        return new DefaultClientConnectionOperator(schreg);
    }

    /**
     * Asserts that this manager is not shut down.
     *
     * @throws IllegalStateException    if this manager is shut down
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.343 -0500", hash_original_method = "44578A979892A5F860429A798FAB46C1", hash_generated_method = "9E094A893A715A37825170596E223547")
    
protected final void assertStillUp()
        throws IllegalStateException {

        if (this.isShutDown)
            throw new IllegalStateException("Manager is shut down.");
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.235 -0400", hash_original_method = "C57EA524B73906635020F1375B79652C", hash_generated_method = "ACFDDA8919D9EA92ACFD0D9859DA5746")
    public final ClientConnectionRequest requestConnection(
            final HttpRoute route,
            final Object state) {
        addTaint(state.getTaint());
        addTaint(route.getTaint());
ClientConnectionRequest var0563123A8DD7E35E063A27BF427D175E_529814248 =         new ClientConnectionRequest() {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.346 -0500", hash_original_method = "59B8F54C56EBECF9DD50C78DE5B52C0B", hash_generated_method = "ED2EEF45AF307CCDD255BF69CE1DB79E")
            
public void abortRequest() {
                // Nothing to abort, since requests are immediate.
            }
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.348 -0500", hash_original_method = "F7F3F9BF4CE416F8572A5E185A1E7C99", hash_generated_method = "8FF85F8EAD261050D1C796456B5D6830")
            
public ManagedClientConnection getConnection(
                    long timeout, TimeUnit tunit) {
                return SingleClientConnManager.this.getConnection(
                        route, state);
            }
};
        var0563123A8DD7E35E063A27BF427D175E_529814248.addTaint(getTaint());
        return var0563123A8DD7E35E063A27BF427D175E_529814248;
        // ---------- Original Method ----------
        //return new ClientConnectionRequest() {
            //public void abortRequest() {
            //}
            //public ManagedClientConnection getConnection(
                    //long timeout, TimeUnit tunit) {
                //return SingleClientConnManager.this.getConnection(
                        //route, state);
            //}
        //};
    }

    /**
     * Obtains a connection.
     * This method does not block.
     *
     * @param route     where the connection should point to
     *
     * @return  a connection that can be used to communicate
     *          along the given route
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.353 -0500", hash_original_method = "781D1E313D4AFDE231A72D7CBA370F5D", hash_generated_method = "38849830D340DFE19D1DD85AD4AFB2AB")
    
public ManagedClientConnection getConnection(HttpRoute route, Object state) {

        if (route == null) {
            throw new IllegalArgumentException("Route may not be null.");
        }
        assertStillUp();

        if (log.isDebugEnabled()) {
            log.debug("Get connection for route " + route);
        }

        if (managedConn != null)
            revokeConnection();

        // check re-usability of the connection
        boolean recreate = false;
        boolean shutdown = false;
        
        // Kill the connection if it expired.
        closeExpiredConnections();
        
        if (uniquePoolEntry.connection.isOpen()) {
            RouteTracker tracker = uniquePoolEntry.tracker;
            shutdown = (tracker == null || // can happen if method is aborted
                        !tracker.toRoute().equals(route));
        } else {
            // If the connection is not open, create a new PoolEntry,
            // as the connection may have been marked not reusable,
            // due to aborts -- and the PoolEntry should not be reused
            // either.  There's no harm in recreating an entry if
            // the connection is closed.
            recreate = true;
        }

        if (shutdown) {
            recreate = true;
            try {
                uniquePoolEntry.shutdown();
            } catch (IOException iox) {
                log.debug("Problem shutting down connection.", iox);
            }
        }
        
        if (recreate)
            uniquePoolEntry = new PoolEntry();

        // BEGIN android-changed
        // When using a recycled Socket, we need to re-tag it with any
        // updated statistics options.
        try {
            final Socket socket = uniquePoolEntry.connection.getSocket();
            if (socket != null) {
                SocketTagger.get().tag(socket);
            }
        } catch (IOException iox) {
            log.debug("Problem tagging socket.", iox);
        }
        // END android-changed

        managedConn = new ConnAdapter(uniquePoolEntry, route);

        return managedConn;
    }

    // non-javadoc, see interface ClientConnectionManager
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.356 -0500", hash_original_method = "ECDB4EF7528DEE3D21C1E4EB659EC445", hash_generated_method = "23C6299D37BFC32F656704593996FC88")
    
public void releaseConnection(ManagedClientConnection conn, long validDuration, TimeUnit timeUnit) {
        assertStillUp();

        if (!(conn instanceof ConnAdapter)) {
            throw new IllegalArgumentException
                ("Connection class mismatch, " +
                 "connection not obtained from this manager.");
        }
        
        if (log.isDebugEnabled()) {
            log.debug("Releasing connection " + conn);
        }

        ConnAdapter sca = (ConnAdapter) conn;
        if (sca.poolEntry == null)
            return; // already released
        ClientConnectionManager manager = sca.getManager();
        if (manager != null && manager != this) {
            throw new IllegalArgumentException
                ("Connection not obtained from this manager.");
        }

        try {
            // BEGIN android-changed
            // When recycling a Socket, we un-tag it to avoid collecting
            // statistics from future users.
            final Socket socket = uniquePoolEntry.connection.getSocket();
            if (socket != null) {
                SocketTagger.get().untag(socket);
            }
            // END android-changed

            // make sure that the response has been read completely
            if (sca.isOpen() && (this.alwaysShutDown ||
                                 !sca.isMarkedReusable())
                ) {
                if (log.isDebugEnabled()) {
                    log.debug
                        ("Released connection open but not reusable.");
                }

                // make sure this connection will not be re-used
                // we might have gotten here because of a shutdown trigger
                // shutdown of the adapter also clears the tracked route
                sca.shutdown();
            }
        } catch (IOException iox) {
            //@@@ log as warning? let pass?
            if (log.isDebugEnabled())
                log.debug("Exception shutting down released connection.",
                          iox);
        } finally {
            sca.detach();
            managedConn = null;
            lastReleaseTime = System.currentTimeMillis();
            if(validDuration > 0)
                connectionExpiresTime = timeUnit.toMillis(validDuration) + lastReleaseTime;
            else
                connectionExpiresTime = Long.MAX_VALUE;
        }
    } // releaseConnection
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.359 -0500", hash_original_method = "144B79381F1DE3A7D4EE72C53F4D2E2A", hash_generated_method = "2A910D763EEB6A74885B7AB428C9EC6D")
    
public void closeExpiredConnections() {
        if(System.currentTimeMillis() >= connectionExpiresTime) {
            closeIdleConnections(0, TimeUnit.MILLISECONDS);
        }
    }

    // non-javadoc, see interface ClientConnectionManager
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.362 -0500", hash_original_method = "F34DBDBB0F8CB1363DA5802203A9DE31", hash_generated_method = "DF67B8C0B57B0FBF4AB44E8A4500B016")
    
public void closeIdleConnections(long idletime, TimeUnit tunit) {
        assertStillUp();

        // idletime can be 0 or negative, no problem there
        if (tunit == null) {
            throw new IllegalArgumentException("Time unit must not be null.");
        }

        if ((managedConn == null) && uniquePoolEntry.connection.isOpen()) {
            final long cutoff =
                System.currentTimeMillis() - tunit.toMillis(idletime);
            if (lastReleaseTime <= cutoff) {
                try {
                    uniquePoolEntry.close();
                } catch (IOException iox) {
                    // ignore
                    log.debug("Problem closing idle connection.", iox);
                }
            }
        }
    }

    // non-javadoc, see interface ClientConnectionManager
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.364 -0500", hash_original_method = "3B23C31C02DC0AC3A698CF8CD25A20B9", hash_generated_method = "17A13C2CF7093AC2A663D1E05FB1F408")
    
public void shutdown() {

        this.isShutDown = true;

        if (managedConn != null)
            managedConn.detach();

        try {
            if (uniquePoolEntry != null) // and connection open?
                uniquePoolEntry.shutdown();
        } catch (IOException iox) {
            // ignore
            log.debug("Problem while shutting down manager.", iox);
        } finally {
            uniquePoolEntry = null;
        }
    }
    
    protected class PoolEntry extends AbstractPoolEntry {

        /**
         * Creates a new pool entry.
         *
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.370 -0500", hash_original_method = "631D63FD16AE3FEAB1552B743E29445B", hash_generated_method = "CD23FBA6B06195A36BE63AC7E71FAAB9")
        
protected PoolEntry() {
            super(SingleClientConnManager.this.connOperator, null);
        }

        /**
         * Closes the connection in this pool entry.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.372 -0500", hash_original_method = "A86295986A372D00C8F07CAE9A39223B", hash_generated_method = "9CF16047CC30070D185BAE9E42FD4882")
        
protected void close()
            throws IOException {

            shutdownEntry();
            if (connection.isOpen())
                connection.close();
        }

        /**
         * Shuts down the connection in this pool entry.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.374 -0500", hash_original_method = "D39515BCFB2BDEF720AFC38551AEFE84", hash_generated_method = "AB1861AB070B8BA388FBF22294799AB8")
        
protected void shutdown()
            throws IOException {

            shutdownEntry();
            if (connection.isOpen())
                connection.shutdown();
        }
        
    }
    
    protected class ConnAdapter extends AbstractPooledConnAdapter {

        /**
         * Creates a new connection adapter.
         *
         * @param entry   the pool entry for the connection being wrapped
         * @param route   the planned route for this connection
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.379 -0500", hash_original_method = "8101547A28FD0D2F472FF84F23BAF09C", hash_generated_method = "18ED4617EA25B83EFFD8CC7F38560051")
        
protected ConnAdapter(PoolEntry entry, HttpRoute route) {
            super(SingleClientConnManager.this, entry);
            markReusable();
            entry.route = route;
        }
        
    }

    /**
     * Revokes the currently issued connection.
     * The adapter gets disconnected, the connection will be shut down.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.366 -0500", hash_original_method = "A0A03885E6FE7F03CE9159285B1CDEFC", hash_generated_method = "F0B500420E2688A267B32A8DCC5329DB")
    
protected void revokeConnection() {
        if (managedConn == null)
            return;

        log.warn(MISUSE_MESSAGE);

        managedConn.detach();

        try {
            uniquePoolEntry.shutdown();
        } catch (IOException iox) {
            // ignore
            log.debug("Problem while shutting down connection.", iox);
        }
    }
}

