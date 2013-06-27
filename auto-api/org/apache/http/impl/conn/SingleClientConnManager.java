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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.855 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "4E4E630304492253CB8147CAE1C7D2A5")

    private Log log = LogFactory.getLog(getClass());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.855 -0400", hash_original_field = "1D823F19EC944D016B48B105C3632412", hash_generated_field = "262A27B6B6B1CBF25439CFECC3909997")

    protected SchemeRegistry schemeRegistry;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.855 -0400", hash_original_field = "30434E45229CAA1EA40A11E0FD7C2DB8", hash_generated_field = "6D2607DA479BDA11A25B13C47E7F0C5C")

    protected ClientConnectionOperator connOperator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.855 -0400", hash_original_field = "6D003C5F17C112226AF27457632A4972", hash_generated_field = "68C30A3515A31DCBBABC9A4AD6123F1A")

    protected PoolEntry uniquePoolEntry;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.855 -0400", hash_original_field = "58ED85B7F214AB5BB7A822D300274AA0", hash_generated_field = "59F808726659CBD9A4D1E0F9113A82AC")

    protected ConnAdapter managedConn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.855 -0400", hash_original_field = "8A2F2226402543777D365809A8D2F379", hash_generated_field = "CEAB2B6CC71A381A86CBD5D45B4080B0")

    protected long lastReleaseTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.855 -0400", hash_original_field = "14B63D5F8086D40A86BC053333383197", hash_generated_field = "AF6AF66999801967D31BB459E9721911")

    protected long connectionExpiresTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.855 -0400", hash_original_field = "C8C68B10128207BCAFB5BE78980E53DB", hash_generated_field = "547C5CD459CD6CC7C1FD7211D1EFA7DD")

    protected boolean alwaysShutDown;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.861 -0400", hash_original_field = "39E5F82929A2140F9EAABEA99A57C705", hash_generated_field = "F15F5E1E3CD7B6799921EE9E4A605FC3")

    protected volatile boolean isShutDown;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.867 -0400", hash_original_method = "3E7F5EDF72EC8A96B4F4BE9344F2EB6F", hash_generated_method = "6732B07487A9AB5BDC1E06E0D02F6D70")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.868 -0400", hash_original_method = "0E19810A97EBEE58216EC05F0D60A026", hash_generated_method = "374DE57AB0E3DB06FD60574FD3247A4E")
    @Override
    protected void finalize() throws Throwable {
        shutdown();
        super.finalize();
        // ---------- Original Method ----------
        //shutdown();
        //super.finalize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.883 -0400", hash_original_method = "98F37EDA7C4377EF27FBBC8455A5DCE4", hash_generated_method = "FD7F905FB3BD490704D52CBD3C59C193")
    public SchemeRegistry getSchemeRegistry() {
        SchemeRegistry varB4EAC82CA7396A68D541C85D26508E83_1468768235 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1468768235 = this.schemeRegistry;
        varB4EAC82CA7396A68D541C85D26508E83_1468768235.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1468768235;
        // ---------- Original Method ----------
        //return this.schemeRegistry;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.883 -0400", hash_original_method = "25E4E60569E24699D7326BD2975E9BC2", hash_generated_method = "7ED1A3916940F745C97C8E36D0BBAC49")
    protected ClientConnectionOperator createConnectionOperator(SchemeRegistry schreg) {
        ClientConnectionOperator varB4EAC82CA7396A68D541C85D26508E83_1758988116 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1758988116 = new DefaultClientConnectionOperator(schreg);
        addTaint(schreg.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1758988116.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1758988116;
        // ---------- Original Method ----------
        //return new DefaultClientConnectionOperator(schreg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.888 -0400", hash_original_method = "44578A979892A5F860429A798FAB46C1", hash_generated_method = "4D301BC83B9FC5EC76254E7DA4B17778")
    protected final void assertStillUp() throws IllegalStateException {
        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Manager is shut down.");
        // ---------- Original Method ----------
        //if (this.isShutDown)
            //throw new IllegalStateException("Manager is shut down.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.890 -0400", hash_original_method = "C57EA524B73906635020F1375B79652C", hash_generated_method = "22C6F0DAECFAD603FFA1ACE6E389CF85")
    public final ClientConnectionRequest requestConnection(
            final HttpRoute route,
            final Object state) {
        ClientConnectionRequest varB4EAC82CA7396A68D541C85D26508E83_872138654 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_872138654 = new ClientConnectionRequest() {
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
        varB4EAC82CA7396A68D541C85D26508E83_872138654.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_872138654;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.905 -0400", hash_original_method = "781D1E313D4AFDE231A72D7CBA370F5D", hash_generated_method = "8CBC8876579EFE173671B2DA02AC0BEA")
    public ManagedClientConnection getConnection(HttpRoute route, Object state) {
        ManagedClientConnection varB4EAC82CA7396A68D541C85D26508E83_1854622407 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Route may not be null.");
        } //End block
        assertStillUp();
        {
            boolean var983CD6AA124987301747A815A5742497_660649587 = (log.isDebugEnabled());
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
            boolean var72F90A8C7AF89D25F111886DE381BB76_722692172 = (uniquePoolEntry.connection.isOpen());
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
        varB4EAC82CA7396A68D541C85D26508E83_1854622407 = managedConn;
        addTaint(state.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1854622407.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1854622407;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.907 -0400", hash_original_method = "ECDB4EF7528DEE3D21C1E4EB659EC445", hash_generated_method = "8576B506D5B1958F9EC106901D677FDB")
    public void releaseConnection(ManagedClientConnection conn, long validDuration, TimeUnit timeUnit) {
        assertStillUp();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Connection class mismatch, " +
                 "connection not obtained from this manager.");
        } //End block
        {
            boolean var983CD6AA124987301747A815A5742497_1057581114 = (log.isDebugEnabled());
            {
                log.debug("Releasing connection " + conn);
            } //End block
        } //End collapsed parenthetic
        ConnAdapter sca;
        sca = (ConnAdapter) conn;
        ClientConnectionManager manager;
        manager = sca.getManager();
        {
            boolean var081AEB8E390D54DA4094B93407CD9737_1283403235 = (manager != null && manager != this);
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
                boolean var220532814503DAF47A1F81300A448E72_1227550930 = (sca.isOpen() && (this.alwaysShutDown ||
                                 !sca.isMarkedReusable()));
                {
                    {
                        boolean varB5EA13E236059479AA556C9226E19405_2042660350 = (log.isDebugEnabled());
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
                boolean varCF6EB300C7D56FAF33A2C36006D8EF42_438143856 = (log.isDebugEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.910 -0400", hash_original_method = "144B79381F1DE3A7D4EE72C53F4D2E2A", hash_generated_method = "0AC3C5D360A24697596D74FDC1297E96")
    public void closeExpiredConnections() {
        {
            boolean var3A76C195B52250D143AAB2069E67A9B7_2002680643 = (System.currentTimeMillis() >= connectionExpiresTime);
            {
                closeIdleConnections(0, TimeUnit.MILLISECONDS);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if(System.currentTimeMillis() >= connectionExpiresTime) {
            //closeIdleConnections(0, TimeUnit.MILLISECONDS);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.911 -0400", hash_original_method = "F34DBDBB0F8CB1363DA5802203A9DE31", hash_generated_method = "10EE4B8C8F35B854D109917D0A40E687")
    public void closeIdleConnections(long idletime, TimeUnit tunit) {
        assertStillUp();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Time unit must not be null.");
        } //End block
        {
            boolean varC7DF02E8F93FE640F7F2DB9CF140D0C6_1532957590 = ((managedConn == null) && uniquePoolEntry.connection.isOpen());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.918 -0400", hash_original_method = "3B23C31C02DC0AC3A698CF8CD25A20B9", hash_generated_method = "AA0B5EB526D095ED1D59094E27DBAAFD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.920 -0400", hash_original_method = "A0A03885E6FE7F03CE9159285B1CDEFC", hash_generated_method = "2F059EBA76AEDD39AAE7669CFF61C476")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.921 -0400", hash_original_method = "631D63FD16AE3FEAB1552B743E29445B", hash_generated_method = "0E4235DC66A001DF5C14070AD2C3F949")
        protected  PoolEntry() {
            super(SingleClientConnManager.this.connOperator, null);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.921 -0400", hash_original_method = "A86295986A372D00C8F07CAE9A39223B", hash_generated_method = "A636AC36AE12EEA7CC618D366CEAB085")
        protected void close() throws IOException {
            shutdownEntry();
            {
                boolean var85F1E373E51097C86DB69532656E7FF3_1076078634 = (connection.isOpen());
                connection.close();
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //shutdownEntry();
            //if (connection.isOpen())
                //connection.close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.922 -0400", hash_original_method = "D39515BCFB2BDEF720AFC38551AEFE84", hash_generated_method = "099228B2580C6B804CAC8947FEC9AA3E")
        protected void shutdown() throws IOException {
            shutdownEntry();
            {
                boolean var85F1E373E51097C86DB69532656E7FF3_50649355 = (connection.isOpen());
                connection.shutdown();
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //shutdownEntry();
            //if (connection.isOpen())
                //connection.shutdown();
        }

        
    }


    
    protected class ConnAdapter extends AbstractPooledConnAdapter {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.922 -0400", hash_original_method = "8101547A28FD0D2F472FF84F23BAF09C", hash_generated_method = "C4D7A0BD04C16390F4B37F425AC9C610")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.922 -0400", hash_original_field = "BD1D652AAA6438AB5EC42DCDC531A4BB", hash_generated_field = "3A54ED9163F39DBD02547DB2ADF36FAA")

    public final static String MISUSE_MESSAGE =
    "Invalid use of SingleClientConnManager: connection still allocated.\n" +
    "Make sure to release the connection before allocating another one.";
}

