package org.apache.http.impl.conn;


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
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.RouteTracker;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.params.HttpParams;

public class SingleClientConnManager implements ClientConnectionManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.580 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.580 -0400", hash_original_field = "1D823F19EC944D016B48B105C3632412", hash_generated_field = "262A27B6B6B1CBF25439CFECC3909997")

    protected SchemeRegistry schemeRegistry;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.580 -0400", hash_original_field = "30434E45229CAA1EA40A11E0FD7C2DB8", hash_generated_field = "6D2607DA479BDA11A25B13C47E7F0C5C")

    protected ClientConnectionOperator connOperator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.580 -0400", hash_original_field = "6D003C5F17C112226AF27457632A4972", hash_generated_field = "68C30A3515A31DCBBABC9A4AD6123F1A")

    protected PoolEntry uniquePoolEntry;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.580 -0400", hash_original_field = "58ED85B7F214AB5BB7A822D300274AA0", hash_generated_field = "59F808726659CBD9A4D1E0F9113A82AC")

    protected ConnAdapter managedConn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.580 -0400", hash_original_field = "8A2F2226402543777D365809A8D2F379", hash_generated_field = "CEAB2B6CC71A381A86CBD5D45B4080B0")

    protected long lastReleaseTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.580 -0400", hash_original_field = "14B63D5F8086D40A86BC053333383197", hash_generated_field = "AF6AF66999801967D31BB459E9721911")

    protected long connectionExpiresTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.580 -0400", hash_original_field = "C8C68B10128207BCAFB5BE78980E53DB", hash_generated_field = "547C5CD459CD6CC7C1FD7211D1EFA7DD")

    protected boolean alwaysShutDown;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.580 -0400", hash_original_field = "39E5F82929A2140F9EAABEA99A57C705", hash_generated_field = "F15F5E1E3CD7B6799921EE9E4A605FC3")

    protected volatile boolean isShutDown;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.581 -0400", hash_original_method = "3E7F5EDF72EC8A96B4F4BE9344F2EB6F", hash_generated_method = "6732B07487A9AB5BDC1E06E0D02F6D70")
    public  SingleClientConnManager(HttpParams params,
                                   SchemeRegistry schreg) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Scheme registry must not be null.");
        } 
        this.schemeRegistry  = schreg;
        this.connOperator    = createConnectionOperator(schreg);
        this.uniquePoolEntry = new PoolEntry();
        this.managedConn     = null;
        this.lastReleaseTime = -1L;
        this.alwaysShutDown  = false;
        this.isShutDown      = false;
        addTaint(params.getTaint());
        
        
            
                
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.581 -0400", hash_original_method = "0E19810A97EBEE58216EC05F0D60A026", hash_generated_method = "374DE57AB0E3DB06FD60574FD3247A4E")
    @Override
    protected void finalize() throws Throwable {
        shutdown();
        super.finalize();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.582 -0400", hash_original_method = "98F37EDA7C4377EF27FBBC8455A5DCE4", hash_generated_method = "E77172DE7FE0F89D96B38AC43FEBFC9D")
    public SchemeRegistry getSchemeRegistry() {
        SchemeRegistry varB4EAC82CA7396A68D541C85D26508E83_1278964490 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1278964490 = this.schemeRegistry;
        varB4EAC82CA7396A68D541C85D26508E83_1278964490.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1278964490;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.582 -0400", hash_original_method = "25E4E60569E24699D7326BD2975E9BC2", hash_generated_method = "505A7AC4976CCF21FFD8AB27EFD7BE5C")
    protected ClientConnectionOperator createConnectionOperator(SchemeRegistry schreg) {
        ClientConnectionOperator varB4EAC82CA7396A68D541C85D26508E83_1674408001 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1674408001 = new DefaultClientConnectionOperator(schreg);
        addTaint(schreg.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1674408001.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1674408001;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.582 -0400", hash_original_method = "44578A979892A5F860429A798FAB46C1", hash_generated_method = "4D301BC83B9FC5EC76254E7DA4B17778")
    protected final void assertStillUp() throws IllegalStateException {
        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Manager is shut down.");
        
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.584 -0400", hash_original_method = "C57EA524B73906635020F1375B79652C", hash_generated_method = "5F646EFF707C98B6DEA9011212622B5E")
    public final ClientConnectionRequest requestConnection(
            final HttpRoute route,
            final Object state) {
        ClientConnectionRequest varB4EAC82CA7396A68D541C85D26508E83_400136477 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_400136477 = new ClientConnectionRequest() {
            public void abortRequest() {
            }
            public ManagedClientConnection getConnection(
                    long timeout, TimeUnit tunit) {
                return SingleClientConnManager.this.getConnection(
                        route, state);
            }
        };
        addTaint(route.getTaint());
        addTaint(state.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_400136477.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_400136477;
        
        
            
            
            
                    
                
                        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.585 -0400", hash_original_method = "781D1E313D4AFDE231A72D7CBA370F5D", hash_generated_method = "EB4D55CEAE9D60A2B4C5C16F0C6B55C5")
    public ManagedClientConnection getConnection(HttpRoute route, Object state) {
        ManagedClientConnection varB4EAC82CA7396A68D541C85D26508E83_551525865 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Route may not be null.");
        } 
        assertStillUp();
        {
            boolean var983CD6AA124987301747A815A5742497_2011952603 = (log.isDebugEnabled());
            {
                log.debug("Get connection for route " + route);
            } 
        } 
        revokeConnection();
        boolean recreate = false;
        boolean shutdown = false;
        closeExpiredConnections();
        {
            boolean var72F90A8C7AF89D25F111886DE381BB76_337300101 = (uniquePoolEntry.connection.isOpen());
            {
                RouteTracker tracker = uniquePoolEntry.tracker;
                shutdown = (tracker == null || 
                        !tracker.toRoute().equals(route));
            } 
            {
                recreate = true;
            } 
        } 
        {
            recreate = true;
            try 
            {
                uniquePoolEntry.shutdown();
            } 
            catch (IOException iox)
            {
                log.debug("Problem shutting down connection.", iox);
            } 
        } 
        uniquePoolEntry = new PoolEntry();
        try 
        {
            final Socket socket = uniquePoolEntry.connection.getSocket();
            {
                SocketTagger.get().tag(socket);
            } 
        } 
        catch (IOException iox)
        {
            log.debug("Problem tagging socket.", iox);
        } 
        managedConn = new ConnAdapter(uniquePoolEntry, route);
        varB4EAC82CA7396A68D541C85D26508E83_551525865 = managedConn;
        addTaint(state.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_551525865.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_551525865;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.586 -0400", hash_original_method = "ECDB4EF7528DEE3D21C1E4EB659EC445", hash_generated_method = "E6CCC93ADED61714AE3F251E70A6000C")
    public void releaseConnection(ManagedClientConnection conn, long validDuration, TimeUnit timeUnit) {
        assertStillUp();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Connection class mismatch, " +
                 "connection not obtained from this manager.");
        } 
        {
            boolean var983CD6AA124987301747A815A5742497_658884855 = (log.isDebugEnabled());
            {
                log.debug("Releasing connection " + conn);
            } 
        } 
        ConnAdapter sca = (ConnAdapter) conn;
        ClientConnectionManager manager = sca.getManager();
        {
            boolean var081AEB8E390D54DA4094B93407CD9737_1022314343 = (manager != null && manager != this);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Connection not obtained from this manager.");
            } 
        } 
        try 
        {
            final Socket socket = uniquePoolEntry.connection.getSocket();
            {
                SocketTagger.get().untag(socket);
            } 
            {
                boolean var220532814503DAF47A1F81300A448E72_2061252141 = (sca.isOpen() && (this.alwaysShutDown ||
                                 !sca.isMarkedReusable()));
                {
                    {
                        boolean varB5EA13E236059479AA556C9226E19405_407184218 = (log.isDebugEnabled());
                        {
                            log.debug
                        ("Released connection open but not reusable.");
                        } 
                    } 
                    sca.shutdown();
                } 
            } 
        } 
        catch (IOException iox)
        {
            {
                boolean varCF6EB300C7D56FAF33A2C36006D8EF42_202442492 = (log.isDebugEnabled());
                log.debug("Exception shutting down released connection.",
                          iox);
            } 
        } 
        finally 
        {
            sca.detach();
            managedConn = null;
            lastReleaseTime = System.currentTimeMillis();
            connectionExpiresTime = timeUnit.toMillis(validDuration) + lastReleaseTime;
            connectionExpiresTime = Long.MAX_VALUE;
        } 
        addTaint(conn.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.587 -0400", hash_original_method = "144B79381F1DE3A7D4EE72C53F4D2E2A", hash_generated_method = "B7A635E6FC9A31EFFB0905317B2BD849")
    public void closeExpiredConnections() {
        {
            boolean var3A76C195B52250D143AAB2069E67A9B7_469646302 = (System.currentTimeMillis() >= connectionExpiresTime);
            {
                closeIdleConnections(0, TimeUnit.MILLISECONDS);
            } 
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.587 -0400", hash_original_method = "F34DBDBB0F8CB1363DA5802203A9DE31", hash_generated_method = "F1597D8C6B10425FFEBAE348B48B39D6")
    public void closeIdleConnections(long idletime, TimeUnit tunit) {
        assertStillUp();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Time unit must not be null.");
        } 
        {
            boolean varC7DF02E8F93FE640F7F2DB9CF140D0C6_551533497 = ((managedConn == null) && uniquePoolEntry.connection.isOpen());
            {
                final long cutoff = System.currentTimeMillis() - tunit.toMillis(idletime);
                {
                    try 
                    {
                        uniquePoolEntry.close();
                    } 
                    catch (IOException iox)
                    {
                        log.debug("Problem closing idle connection.", iox);
                    } 
                } 
            } 
        } 
        addTaint(idletime);
        addTaint(tunit.getTaint());
        
        
        
            
        
        
            
                
            
                
                    
                
                    
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.588 -0400", hash_original_method = "3B23C31C02DC0AC3A698CF8CD25A20B9", hash_generated_method = "AA0B5EB526D095ED1D59094E27DBAAFD")
    public void shutdown() {
        this.isShutDown = true;
        managedConn.detach();
        try 
        {
            uniquePoolEntry.shutdown();
        } 
        catch (IOException iox)
        {
            log.debug("Problem while shutting down manager.", iox);
        } 
        finally 
        {
            uniquePoolEntry = null;
        } 
        
        
        
            
        
            
                
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.588 -0400", hash_original_method = "A0A03885E6FE7F03CE9159285B1CDEFC", hash_generated_method = "2F059EBA76AEDD39AAE7669CFF61C476")
    protected void revokeConnection() {
        log.warn(MISUSE_MESSAGE);
        managedConn.detach();
        try 
        {
            uniquePoolEntry.shutdown();
        } 
        catch (IOException iox)
        {
            log.debug("Problem while shutting down connection.", iox);
        } 
        
        
            
        
        
        
            
        
            
        
    }

    
    protected class PoolEntry extends AbstractPoolEntry {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.588 -0400", hash_original_method = "631D63FD16AE3FEAB1552B743E29445B", hash_generated_method = "0E4235DC66A001DF5C14070AD2C3F949")
        protected  PoolEntry() {
            super(SingleClientConnManager.this.connOperator, null);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.589 -0400", hash_original_method = "A86295986A372D00C8F07CAE9A39223B", hash_generated_method = "373D2219AE199F1CF5F72A5BDA57A09E")
        protected void close() throws IOException {
            shutdownEntry();
            {
                boolean var85F1E373E51097C86DB69532656E7FF3_566966852 = (connection.isOpen());
                connection.close();
            } 
            
            
            
                
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.589 -0400", hash_original_method = "D39515BCFB2BDEF720AFC38551AEFE84", hash_generated_method = "3F389FA5C35BFD71995074D02A0D0F7C")
        protected void shutdown() throws IOException {
            shutdownEntry();
            {
                boolean var85F1E373E51097C86DB69532656E7FF3_621189969 = (connection.isOpen());
                connection.shutdown();
            } 
            
            
            
                
        }

        
    }


    
    protected class ConnAdapter extends AbstractPooledConnAdapter {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.589 -0400", hash_original_method = "8101547A28FD0D2F472FF84F23BAF09C", hash_generated_method = "C4D7A0BD04C16390F4B37F425AC9C610")
        protected  ConnAdapter(PoolEntry entry, HttpRoute route) {
            super(SingleClientConnManager.this, entry);
            markReusable();
            entry.route = route;
            addTaint(entry.getTaint());
            addTaint(route.getTaint());
            
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.589 -0400", hash_original_field = "BD1D652AAA6438AB5EC42DCDC531A4BB", hash_generated_field = "3A54ED9163F39DBD02547DB2ADF36FAA")

    public final static String MISUSE_MESSAGE =
    "Invalid use of SingleClientConnManager: connection still allocated.\n" +
    "Make sure to release the connection before allocating another one.";
    
}

