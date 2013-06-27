package org.apache.http.impl.conn;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.939 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "4E4E630304492253CB8147CAE1C7D2A5")

    private Log log = LogFactory.getLog(getClass());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.939 -0400", hash_original_field = "1D823F19EC944D016B48B105C3632412", hash_generated_field = "262A27B6B6B1CBF25439CFECC3909997")

    protected SchemeRegistry schemeRegistry;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.939 -0400", hash_original_field = "30434E45229CAA1EA40A11E0FD7C2DB8", hash_generated_field = "6D2607DA479BDA11A25B13C47E7F0C5C")

    protected ClientConnectionOperator connOperator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.939 -0400", hash_original_field = "6D003C5F17C112226AF27457632A4972", hash_generated_field = "68C30A3515A31DCBBABC9A4AD6123F1A")

    protected PoolEntry uniquePoolEntry;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.939 -0400", hash_original_field = "58ED85B7F214AB5BB7A822D300274AA0", hash_generated_field = "59F808726659CBD9A4D1E0F9113A82AC")

    protected ConnAdapter managedConn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.939 -0400", hash_original_field = "8A2F2226402543777D365809A8D2F379", hash_generated_field = "CEAB2B6CC71A381A86CBD5D45B4080B0")

    protected long lastReleaseTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.939 -0400", hash_original_field = "14B63D5F8086D40A86BC053333383197", hash_generated_field = "AF6AF66999801967D31BB459E9721911")

    protected long connectionExpiresTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.939 -0400", hash_original_field = "C8C68B10128207BCAFB5BE78980E53DB", hash_generated_field = "547C5CD459CD6CC7C1FD7211D1EFA7DD")

    protected boolean alwaysShutDown;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.940 -0400", hash_original_field = "39E5F82929A2140F9EAABEA99A57C705", hash_generated_field = "F15F5E1E3CD7B6799921EE9E4A605FC3")

    protected volatile boolean isShutDown;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.944 -0400", hash_original_method = "3E7F5EDF72EC8A96B4F4BE9344F2EB6F", hash_generated_method = "6732B07487A9AB5BDC1E06E0D02F6D70")
    public  SingleClientConnManager(HttpParams params,
                                   SchemeRegistry schreg) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Scheme registry must not be null.");
        } //End block
        this.schemeRegistry  = schreg;
        this.connOperator    = createConnectionOperator(schreg);
        this.uniquePoolEntry = new PoolEntry();
        this.managedConn     = null;
        this.lastReleaseTime = -1L;
        this.alwaysShutDown  = false;
        this.isShutDown      = false;
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        //if (schreg == null) {
            //throw new IllegalArgumentException
                //("Scheme registry must not be null.");
        //}
        //this.schemeRegistry  = schreg;
        //this.connOperator    = createConnectionOperator(schreg);
        //this.uniquePoolEntry = new PoolEntry();
        //this.managedConn     = null;
        //this.lastReleaseTime = -1L;
        //this.alwaysShutDown  = false;
        //this.isShutDown      = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.945 -0400", hash_original_method = "0E19810A97EBEE58216EC05F0D60A026", hash_generated_method = "374DE57AB0E3DB06FD60574FD3247A4E")
    @Override
    protected void finalize() throws Throwable {
        shutdown();
        super.finalize();
        // ---------- Original Method ----------
        //shutdown();
        //super.finalize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.949 -0400", hash_original_method = "98F37EDA7C4377EF27FBBC8455A5DCE4", hash_generated_method = "1EE73A461CB67F3F22195ED3DA5ED93C")
    public SchemeRegistry getSchemeRegistry() {
        SchemeRegistry varB4EAC82CA7396A68D541C85D26508E83_1900531045 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1900531045 = this.schemeRegistry;
        varB4EAC82CA7396A68D541C85D26508E83_1900531045.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1900531045;
        // ---------- Original Method ----------
        //return this.schemeRegistry;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.959 -0400", hash_original_method = "25E4E60569E24699D7326BD2975E9BC2", hash_generated_method = "C17D3A5D74907AB9681668CB08B982C9")
    protected ClientConnectionOperator createConnectionOperator(SchemeRegistry schreg) {
        ClientConnectionOperator varB4EAC82CA7396A68D541C85D26508E83_625857077 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_625857077 = new DefaultClientConnectionOperator(schreg);
        addTaint(schreg.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_625857077.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_625857077;
        // ---------- Original Method ----------
        //return new DefaultClientConnectionOperator(schreg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.959 -0400", hash_original_method = "44578A979892A5F860429A798FAB46C1", hash_generated_method = "4D301BC83B9FC5EC76254E7DA4B17778")
    protected final void assertStillUp() throws IllegalStateException {
        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Manager is shut down.");
        // ---------- Original Method ----------
        //if (this.isShutDown)
            //throw new IllegalStateException("Manager is shut down.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.960 -0400", hash_original_method = "C57EA524B73906635020F1375B79652C", hash_generated_method = "7DD39CB03A7272764486A904AA801F4F")
    public final ClientConnectionRequest requestConnection(
            final HttpRoute route,
            final Object state) {
        ClientConnectionRequest varB4EAC82CA7396A68D541C85D26508E83_967175804 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_967175804 = new ClientConnectionRequest() {
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
        varB4EAC82CA7396A68D541C85D26508E83_967175804.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_967175804;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.981 -0400", hash_original_method = "781D1E313D4AFDE231A72D7CBA370F5D", hash_generated_method = "F6A3EFDB0CD711E70F8230CF867B8C4D")
    public ManagedClientConnection getConnection(HttpRoute route, Object state) {
        ManagedClientConnection varB4EAC82CA7396A68D541C85D26508E83_1792354508 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Route may not be null.");
        } //End block
        assertStillUp();
        {
            boolean var983CD6AA124987301747A815A5742497_2014107419 = (log.isDebugEnabled());
            {
                log.debug("Get connection for route " + route);
            } //End block
        } //End collapsed parenthetic
        revokeConnection();
        boolean recreate;
        recreate = false;
        boolean shutdown;
        shutdown = false;
        closeExpiredConnections();
        {
            boolean var72F90A8C7AF89D25F111886DE381BB76_165838069 = (uniquePoolEntry.connection.isOpen());
            {
                RouteTracker tracker;
                tracker = uniquePoolEntry.tracker;
                shutdown = (tracker == null || 
                        !tracker.toRoute().equals(route));
            } //End block
            {
                recreate = true;
            } //End block
        } //End collapsed parenthetic
        {
            recreate = true;
            try 
            {
                uniquePoolEntry.shutdown();
            } //End block
            catch (IOException iox)
            {
                log.debug("Problem shutting down connection.", iox);
            } //End block
        } //End block
        uniquePoolEntry = new PoolEntry();
        try 
        {
            Socket socket;
            socket = uniquePoolEntry.connection.getSocket();
            {
                SocketTagger.get().tag(socket);
            } //End block
        } //End block
        catch (IOException iox)
        {
            log.debug("Problem tagging socket.", iox);
        } //End block
        managedConn = new ConnAdapter(uniquePoolEntry, route);
        varB4EAC82CA7396A68D541C85D26508E83_1792354508 = managedConn;
        addTaint(state.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1792354508.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1792354508;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.994 -0400", hash_original_method = "ECDB4EF7528DEE3D21C1E4EB659EC445", hash_generated_method = "653F4866E17555FF20FF8D2DB7F31DD3")
    public void releaseConnection(ManagedClientConnection conn, long validDuration, TimeUnit timeUnit) {
        assertStillUp();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Connection class mismatch, " +
                 "connection not obtained from this manager.");
        } //End block
        {
            boolean var983CD6AA124987301747A815A5742497_269189976 = (log.isDebugEnabled());
            {
                log.debug("Releasing connection " + conn);
            } //End block
        } //End collapsed parenthetic
        ConnAdapter sca;
        sca = (ConnAdapter) conn;
        ClientConnectionManager manager;
        manager = sca.getManager();
        {
            boolean var081AEB8E390D54DA4094B93407CD9737_971236273 = (manager != null && manager != this);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Connection not obtained from this manager.");
            } //End block
        } //End collapsed parenthetic
        try 
        {
            Socket socket;
            socket = uniquePoolEntry.connection.getSocket();
            {
                SocketTagger.get().untag(socket);
            } //End block
            {
                boolean var220532814503DAF47A1F81300A448E72_965889266 = (sca.isOpen() && (this.alwaysShutDown ||
                                 !sca.isMarkedReusable()));
                {
                    {
                        boolean varB5EA13E236059479AA556C9226E19405_70720812 = (log.isDebugEnabled());
                        {
                            log.debug
                        ("Released connection open but not reusable.");
                        } //End block
                    } //End collapsed parenthetic
                    sca.shutdown();
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (IOException iox)
        {
            {
                boolean varCF6EB300C7D56FAF33A2C36006D8EF42_2027634406 = (log.isDebugEnabled());
                log.debug("Exception shutting down released connection.",
                          iox);
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            sca.detach();
            managedConn = null;
            lastReleaseTime = System.currentTimeMillis();
            connectionExpiresTime = timeUnit.toMillis(validDuration) + lastReleaseTime;
            connectionExpiresTime = Long.MAX_VALUE;
        } //End block
        addTaint(conn.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.995 -0400", hash_original_method = "144B79381F1DE3A7D4EE72C53F4D2E2A", hash_generated_method = "EF346FA02F25876B5E60F3D66972B2BF")
    public void closeExpiredConnections() {
        {
            boolean var3A76C195B52250D143AAB2069E67A9B7_1742649544 = (System.currentTimeMillis() >= connectionExpiresTime);
            {
                closeIdleConnections(0, TimeUnit.MILLISECONDS);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if(System.currentTimeMillis() >= connectionExpiresTime) {
            //closeIdleConnections(0, TimeUnit.MILLISECONDS);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.008 -0400", hash_original_method = "F34DBDBB0F8CB1363DA5802203A9DE31", hash_generated_method = "8B47960EECACDDACFD3C1651A24CC877")
    public void closeIdleConnections(long idletime, TimeUnit tunit) {
        assertStillUp();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Time unit must not be null.");
        } //End block
        {
            boolean varC7DF02E8F93FE640F7F2DB9CF140D0C6_12435976 = ((managedConn == null) && uniquePoolEntry.connection.isOpen());
            {
                long cutoff;
                cutoff = System.currentTimeMillis() - tunit.toMillis(idletime);
                {
                    try 
                    {
                        uniquePoolEntry.close();
                    } //End block
                    catch (IOException iox)
                    {
                        log.debug("Problem closing idle connection.", iox);
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(idletime);
        addTaint(tunit.getTaint());
        // ---------- Original Method ----------
        //assertStillUp();
        //if (tunit == null) {
            //throw new IllegalArgumentException("Time unit must not be null.");
        //}
        //if ((managedConn == null) && uniquePoolEntry.connection.isOpen()) {
            //final long cutoff =
                //System.currentTimeMillis() - tunit.toMillis(idletime);
            //if (lastReleaseTime <= cutoff) {
                //try {
                    //uniquePoolEntry.close();
                //} catch (IOException iox) {
                    //log.debug("Problem closing idle connection.", iox);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.009 -0400", hash_original_method = "3B23C31C02DC0AC3A698CF8CD25A20B9", hash_generated_method = "AA0B5EB526D095ED1D59094E27DBAAFD")
    public void shutdown() {
        this.isShutDown = true;
        managedConn.detach();
        try 
        {
            uniquePoolEntry.shutdown();
        } //End block
        catch (IOException iox)
        {
            log.debug("Problem while shutting down manager.", iox);
        } //End block
        finally 
        {
            uniquePoolEntry = null;
        } //End block
        // ---------- Original Method ----------
        //this.isShutDown = true;
        //if (managedConn != null)
            //managedConn.detach();
        //try {
            //if (uniquePoolEntry != null) 
                //uniquePoolEntry.shutdown();
        //} catch (IOException iox) {
            //log.debug("Problem while shutting down manager.", iox);
        //} finally {
            //uniquePoolEntry = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.010 -0400", hash_original_method = "A0A03885E6FE7F03CE9159285B1CDEFC", hash_generated_method = "2F059EBA76AEDD39AAE7669CFF61C476")
    protected void revokeConnection() {
        log.warn(MISUSE_MESSAGE);
        managedConn.detach();
        try 
        {
            uniquePoolEntry.shutdown();
        } //End block
        catch (IOException iox)
        {
            log.debug("Problem while shutting down connection.", iox);
        } //End block
        // ---------- Original Method ----------
        //if (managedConn == null)
            //return;
        //log.warn(MISUSE_MESSAGE);
        //managedConn.detach();
        //try {
            //uniquePoolEntry.shutdown();
        //} catch (IOException iox) {
            //log.debug("Problem while shutting down connection.", iox);
        //}
    }

    
    protected class PoolEntry extends AbstractPoolEntry {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.010 -0400", hash_original_method = "631D63FD16AE3FEAB1552B743E29445B", hash_generated_method = "0E4235DC66A001DF5C14070AD2C3F949")
        protected  PoolEntry() {
            super(SingleClientConnManager.this.connOperator, null);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.010 -0400", hash_original_method = "A86295986A372D00C8F07CAE9A39223B", hash_generated_method = "28E49B705D7766F583222C469E3B8439")
        protected void close() throws IOException {
            shutdownEntry();
            {
                boolean var85F1E373E51097C86DB69532656E7FF3_71397966 = (connection.isOpen());
                connection.close();
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //shutdownEntry();
            //if (connection.isOpen())
                //connection.close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.011 -0400", hash_original_method = "D39515BCFB2BDEF720AFC38551AEFE84", hash_generated_method = "AE0DA30E46F0D58DC9FC493AFA8C9BDD")
        protected void shutdown() throws IOException {
            shutdownEntry();
            {
                boolean var85F1E373E51097C86DB69532656E7FF3_337569674 = (connection.isOpen());
                connection.shutdown();
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //shutdownEntry();
            //if (connection.isOpen())
                //connection.shutdown();
        }

        
    }


    
    protected class ConnAdapter extends AbstractPooledConnAdapter {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.020 -0400", hash_original_method = "8101547A28FD0D2F472FF84F23BAF09C", hash_generated_method = "C4D7A0BD04C16390F4B37F425AC9C610")
        protected  ConnAdapter(PoolEntry entry, HttpRoute route) {
            super(SingleClientConnManager.this, entry);
            markReusable();
            entry.route = route;
            addTaint(entry.getTaint());
            addTaint(route.getTaint());
            // ---------- Original Method ----------
            //markReusable();
            //entry.route = route;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.020 -0400", hash_original_field = "BD1D652AAA6438AB5EC42DCDC531A4BB", hash_generated_field = "3A54ED9163F39DBD02547DB2ADF36FAA")

    public final static String MISUSE_MESSAGE =
    "Invalid use of SingleClientConnManager: connection still allocated.\n" +
    "Make sure to release the connection before allocating another one.";
}

