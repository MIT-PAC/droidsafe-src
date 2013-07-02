package org.apache.http.impl.conn.tsccm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import dalvik.system.SocketTagger;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.params.HttpParams;
import org.apache.http.impl.conn.DefaultClientConnectionOperator;

public class ThreadSafeClientConnManager implements ClientConnectionManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.791 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.791 -0400", hash_original_field = "1D823F19EC944D016B48B105C3632412", hash_generated_field = "262A27B6B6B1CBF25439CFECC3909997")

    protected SchemeRegistry schemeRegistry;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.791 -0400", hash_original_field = "99874BDECC32FFAA06AFF68D9A8B62AF", hash_generated_field = "A126A5C00AC17033F6B94E836FE92D15")

    protected AbstractConnPool connectionPool;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.791 -0400", hash_original_field = "30434E45229CAA1EA40A11E0FD7C2DB8", hash_generated_field = "6D2607DA479BDA11A25B13C47E7F0C5C")

    protected ClientConnectionOperator connOperator;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.792 -0400", hash_original_method = "CE8305B2F50479AC170D47319F9570C8", hash_generated_method = "47E8D39DEDAEBCF841B552E3AC018102")
    public  ThreadSafeClientConnManager(HttpParams params,
                                       SchemeRegistry schreg) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP parameters may not be null");
        } 
        this.schemeRegistry = schreg;
        this.connOperator   = createConnectionOperator(schreg);
        this.connectionPool = createConnectionPool(params);
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.792 -0400", hash_original_method = "0E19810A97EBEE58216EC05F0D60A026", hash_generated_method = "374DE57AB0E3DB06FD60574FD3247A4E")
    @Override
    protected void finalize() throws Throwable {
        shutdown();
        super.finalize();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.793 -0400", hash_original_method = "E5BC66DBF19261346819AE7E60C7F467", hash_generated_method = "C0F9A2F6C651A44ACABCF4ABF23DCCBC")
    protected AbstractConnPool createConnectionPool(final HttpParams params) {
        AbstractConnPool varB4EAC82CA7396A68D541C85D26508E83_1639446597 = null; 
        AbstractConnPool acp = new ConnPoolByRoute(connOperator, params);
        boolean conngc = true;
        {
            acp.enableConnectionGC();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1639446597 = acp;
        addTaint(params.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1639446597.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1639446597;
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.793 -0400", hash_original_method = "25E4E60569E24699D7326BD2975E9BC2", hash_generated_method = "3A8FF4BF616C5BE0415588C9EB3C408E")
    protected ClientConnectionOperator createConnectionOperator(SchemeRegistry schreg) {
        ClientConnectionOperator varB4EAC82CA7396A68D541C85D26508E83_854067861 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_854067861 = new DefaultClientConnectionOperator(schreg);
        addTaint(schreg.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_854067861.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_854067861;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.794 -0400", hash_original_method = "98F37EDA7C4377EF27FBBC8455A5DCE4", hash_generated_method = "A3B33BCD195CE2EE5D556F539BFCE121")
    public SchemeRegistry getSchemeRegistry() {
        SchemeRegistry varB4EAC82CA7396A68D541C85D26508E83_241105017 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_241105017 = this.schemeRegistry;
        varB4EAC82CA7396A68D541C85D26508E83_241105017.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_241105017;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.795 -0400", hash_original_method = "3E5898B68534E316FCFFCF41E86D81D5", hash_generated_method = "36CDE881D7614D80DA70CEEA5772446D")
    public ClientConnectionRequest requestConnection(
            final HttpRoute route, 
            final Object state) {
        ClientConnectionRequest varB4EAC82CA7396A68D541C85D26508E83_83493792 = null; 
        final PoolEntryRequest poolRequest = connectionPool.requestPoolEntry(
                route, state);
        varB4EAC82CA7396A68D541C85D26508E83_83493792 = new ClientConnectionRequest() {
            public void abortRequest() {
                poolRequest.abortRequest();
            }
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
                try {
                    final Socket socket = entry.getConnection().getSocket();
                    if (socket != null) {
                        SocketTagger.get().tag(socket);
                    }
                } catch (IOException iox) {
                    log.debug("Problem tagging socket.", iox);
                }
                return new BasicPooledConnAdapter(ThreadSafeClientConnManager.this, entry);
            }
        };
        addTaint(route.getTaint());
        addTaint(state.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_83493792.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_83493792;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.796 -0400", hash_original_method = "3CF782E9F00803924FA9A14119B3585D", hash_generated_method = "DA0ED21B530D5B7A0FDE8F1721E0CED6")
    public void releaseConnection(ManagedClientConnection conn, long validDuration, TimeUnit timeUnit) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Connection class mismatch, " +
                 "connection not obtained from this manager.");
        } 
        BasicPooledConnAdapter hca = (BasicPooledConnAdapter) conn;
        {
            boolean var6192AB5B64B46E2400472BDF20A88225_478302655 = ((hca.getPoolEntry() != null) && (hca.getManager() != this));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Connection not obtained from this manager.");
            } 
        } 
        try 
        {
            final BasicPoolEntry entry = (BasicPoolEntry) hca.getPoolEntry();
            final Socket socket = entry.getConnection().getSocket();
            {
                SocketTagger.get().untag(socket);
            } 
            {
                boolean var3E60D1B6142E7057429C96B0BFD0893C_581848289 = (hca.isOpen() && !hca.isMarkedReusable());
                {
                    {
                        boolean varB5EA13E236059479AA556C9226E19405_345980437 = (log.isDebugEnabled());
                        {
                            log.debug
                        ("Released connection open but not marked reusable.");
                        } 
                    } 
                    hca.shutdown();
                } 
            } 
        } 
        catch (IOException iox)
        {
            {
                boolean varCF6EB300C7D56FAF33A2C36006D8EF42_790078522 = (log.isDebugEnabled());
                log.debug("Exception shutting down released connection.",
                          iox);
            } 
        } 
        finally 
        {
            BasicPoolEntry entry = (BasicPoolEntry) hca.getPoolEntry();
            boolean reusable = hca.isMarkedReusable();
            hca.detach();
            {
                connectionPool.freeEntry(entry, reusable, validDuration, timeUnit);
            } 
        } 
        addTaint(conn.getTaint());
        addTaint(validDuration);
        addTaint(timeUnit.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.797 -0400", hash_original_method = "5B798EEC995C1D56865AC1580F955080", hash_generated_method = "42E2BBAB2AF21073775665B77EF166D8")
    public void shutdown() {
        connectionPool.shutdown();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.799 -0400", hash_original_method = "52C9DA1F5E2D598BCB82BD013D1068AD", hash_generated_method = "8516C456A5B45F2FBA44FB76E7F850FC")
    public int getConnectionsInPool(HttpRoute route) {
        int varC462CC0BD6AD8361B0292006FD2C7F79_28363766 = (((ConnPoolByRoute)connectionPool).getConnectionsInPool(
                route));
        addTaint(route.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_548691023 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_548691023;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.800 -0400", hash_original_method = "A7E68EC885457C399BA150A4DD387F90", hash_generated_method = "F75A05A53DDAB72B742695A702487106")
    public int getConnectionsInPool() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_71107610 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_71107610;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.801 -0400", hash_original_method = "614803CEB018564B6D4B8085A3E1BC4F", hash_generated_method = "E2FAE87BE7F4B8196EB48159FCB6D7F9")
    public void closeIdleConnections(long idleTimeout, TimeUnit tunit) {
        connectionPool.closeIdleConnections(idleTimeout, tunit);
        connectionPool.deleteClosedConnections();
        addTaint(idleTimeout);
        addTaint(tunit.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.802 -0400", hash_original_method = "3CBEAD5C5E5FD142C35EE66C6F0AAE4C", hash_generated_method = "536375C07B2EFC293E2096521891082E")
    public void closeExpiredConnections() {
        connectionPool.closeExpiredConnections();
        connectionPool.deleteClosedConnections();
        
        
        
    }

    
}

