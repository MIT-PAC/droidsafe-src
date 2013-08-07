package org.apache.http.impl.conn;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.230 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.230 -0400", hash_original_field = "1D823F19EC944D016B48B105C3632412", hash_generated_field = "262A27B6B6B1CBF25439CFECC3909997")

    protected SchemeRegistry schemeRegistry;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.230 -0400", hash_original_field = "30434E45229CAA1EA40A11E0FD7C2DB8", hash_generated_field = "6D2607DA479BDA11A25B13C47E7F0C5C")

    protected ClientConnectionOperator connOperator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.230 -0400", hash_original_field = "6D003C5F17C112226AF27457632A4972", hash_generated_field = "68C30A3515A31DCBBABC9A4AD6123F1A")

    protected PoolEntry uniquePoolEntry;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.230 -0400", hash_original_field = "58ED85B7F214AB5BB7A822D300274AA0", hash_generated_field = "59F808726659CBD9A4D1E0F9113A82AC")

    protected ConnAdapter managedConn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.231 -0400", hash_original_field = "8A2F2226402543777D365809A8D2F379", hash_generated_field = "CEAB2B6CC71A381A86CBD5D45B4080B0")

    protected long lastReleaseTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.231 -0400", hash_original_field = "14B63D5F8086D40A86BC053333383197", hash_generated_field = "AF6AF66999801967D31BB459E9721911")

    protected long connectionExpiresTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.231 -0400", hash_original_field = "C8C68B10128207BCAFB5BE78980E53DB", hash_generated_field = "547C5CD459CD6CC7C1FD7211D1EFA7DD")

    protected boolean alwaysShutDown;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.231 -0400", hash_original_field = "39E5F82929A2140F9EAABEA99A57C705", hash_generated_field = "F15F5E1E3CD7B6799921EE9E4A605FC3")

    protected volatile boolean isShutDown;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.232 -0400", hash_original_method = "3E7F5EDF72EC8A96B4F4BE9344F2EB6F", hash_generated_method = "A381D64963D925541A875DB5A1694294")
    public  SingleClientConnManager(HttpParams params,
                                   SchemeRegistry schreg) {
        addTaint(params.getTaint());
        if(schreg == null)        
        {
            IllegalArgumentException var9D0DCFA9FB8D2370B81F25E8E10E412A_1335859753 = new IllegalArgumentException
                ("Scheme registry must not be null.");
            var9D0DCFA9FB8D2370B81F25E8E10E412A_1335859753.addTaint(taint);
            throw var9D0DCFA9FB8D2370B81F25E8E10E412A_1335859753;
        } //End block
        this.schemeRegistry  = schreg;
        this.connOperator    = createConnectionOperator(schreg);
        this.uniquePoolEntry = new PoolEntry();
        this.managedConn     = null;
        this.lastReleaseTime = -1L;
        this.alwaysShutDown  = false;
        this.isShutDown      = false;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.233 -0400", hash_original_method = "0E19810A97EBEE58216EC05F0D60A026", hash_generated_method = "374DE57AB0E3DB06FD60574FD3247A4E")
    @Override
    protected void finalize() throws Throwable {
        shutdown();
        super.finalize();
        // ---------- Original Method ----------
        //shutdown();
        //super.finalize();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.233 -0400", hash_original_method = "98F37EDA7C4377EF27FBBC8455A5DCE4", hash_generated_method = "4C9300DEFE9E8AC99BA511DAEA50E719")
    public SchemeRegistry getSchemeRegistry() {
SchemeRegistry var88A9F5243E7E93089AA8FDF949007087_1168920541 =         this.schemeRegistry;
        var88A9F5243E7E93089AA8FDF949007087_1168920541.addTaint(taint);
        return var88A9F5243E7E93089AA8FDF949007087_1168920541;
        // ---------- Original Method ----------
        //return this.schemeRegistry;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.233 -0400", hash_original_method = "25E4E60569E24699D7326BD2975E9BC2", hash_generated_method = "F789CAC3F7C3DECCE4D04B2D75D2EA85")
    protected ClientConnectionOperator createConnectionOperator(SchemeRegistry schreg) {
        addTaint(schreg.getTaint());
ClientConnectionOperator var5302AB2ADD1B4945976DC003AFE0BD75_751159360 =         new DefaultClientConnectionOperator(schreg);
        var5302AB2ADD1B4945976DC003AFE0BD75_751159360.addTaint(taint);
        return var5302AB2ADD1B4945976DC003AFE0BD75_751159360;
        // ---------- Original Method ----------
        //return new DefaultClientConnectionOperator(schreg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.233 -0400", hash_original_method = "44578A979892A5F860429A798FAB46C1", hash_generated_method = "1A7D2E313FDD8BB38CF6CD33615FF938")
    protected final void assertStillUp() throws IllegalStateException {
        if(this.isShutDown)        
        {
        IllegalStateException varB0F9022553288C2CA311ECE4145AB186_1214124114 = new IllegalStateException("Manager is shut down.");
        varB0F9022553288C2CA311ECE4145AB186_1214124114.addTaint(taint);
        throw varB0F9022553288C2CA311ECE4145AB186_1214124114;
        }
        // ---------- Original Method ----------
        //if (this.isShutDown)
            //throw new IllegalStateException("Manager is shut down.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.235 -0400", hash_original_method = "C57EA524B73906635020F1375B79652C", hash_generated_method = "ACFDDA8919D9EA92ACFD0D9859DA5746")
    public final ClientConnectionRequest requestConnection(
            final HttpRoute route,
            final Object state) {
        addTaint(state.getTaint());
        addTaint(route.getTaint());
ClientConnectionRequest var0563123A8DD7E35E063A27BF427D175E_529814248 =         new ClientConnectionRequest() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.234 -0400", hash_original_method = "59B8F54C56EBECF9DD50C78DE5B52C0B", hash_generated_method = "9DC48F8D0136273714585B8035E22ED8")
        public void abortRequest() {
            // ---------- Original Method ----------
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.235 -0400", hash_original_method = "F7F3F9BF4CE416F8572A5E185A1E7C99", hash_generated_method = "94730C77E873BF3A93546DD07366F266")
        public ManagedClientConnection getConnection(
                    long timeout, TimeUnit tunit) {
            addTaint(tunit.getTaint());
            addTaint(timeout);
ManagedClientConnection var3E69174ACEA1CF1786ED4F87EE0B3E2A_795684114 =             SingleClientConnManager.this.getConnection(
                        route, state);
            var3E69174ACEA1CF1786ED4F87EE0B3E2A_795684114.addTaint(taint);
            return var3E69174ACEA1CF1786ED4F87EE0B3E2A_795684114;
            // ---------- Original Method ----------
            //return SingleClientConnManager.this.getConnection(
                        //route, state);
        }
};
        var0563123A8DD7E35E063A27BF427D175E_529814248.addTaint(taint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.236 -0400", hash_original_method = "781D1E313D4AFDE231A72D7CBA370F5D", hash_generated_method = "C36F53E267D37F8C4CB91EAF07832A28")
    public ManagedClientConnection getConnection(HttpRoute route, Object state) {
        addTaint(state.getTaint());
        if(route == null)        
        {
            IllegalArgumentException var807ED97BD06382A664709EF49C1C9EA3_1610020669 = new IllegalArgumentException("Route may not be null.");
            var807ED97BD06382A664709EF49C1C9EA3_1610020669.addTaint(taint);
            throw var807ED97BD06382A664709EF49C1C9EA3_1610020669;
        } //End block
        assertStillUp();
        if(log.isDebugEnabled())        
        {
            log.debug("Get connection for route " + route);
        } //End block
        if(managedConn != null)        
        revokeConnection();
        boolean recreate = false;
        boolean shutdown = false;
        closeExpiredConnections();
        if(uniquePoolEntry.connection.isOpen())        
        {
            RouteTracker tracker = uniquePoolEntry.tracker;
            shutdown = (tracker == null || 
                        !tracker.toRoute().equals(route));
        } //End block
        else
        {
            recreate = true;
        } //End block
        if(shutdown)        
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
        if(recreate)        
        uniquePoolEntry = new PoolEntry();
        try 
        {
            final Socket socket = uniquePoolEntry.connection.getSocket();
            if(socket != null)            
            {
                SocketTagger.get().tag(socket);
            } //End block
        } //End block
        catch (IOException iox)
        {
            log.debug("Problem tagging socket.", iox);
        } //End block
        managedConn = new ConnAdapter(uniquePoolEntry, route);
ManagedClientConnection varCEBBA00AC725936F4BAAED64D1A16A9F_980550794 =         managedConn;
        varCEBBA00AC725936F4BAAED64D1A16A9F_980550794.addTaint(taint);
        return varCEBBA00AC725936F4BAAED64D1A16A9F_980550794;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.238 -0400", hash_original_method = "ECDB4EF7528DEE3D21C1E4EB659EC445", hash_generated_method = "F5B9A0BB1253D98F8263F387B4364C61")
    public void releaseConnection(ManagedClientConnection conn, long validDuration, TimeUnit timeUnit) {
        addTaint(conn.getTaint());
        assertStillUp();
        if(!(conn instanceof ConnAdapter))        
        {
            IllegalArgumentException var5C20061853D03D1DF306BE40FC8B88CE_1996843474 = new IllegalArgumentException
                ("Connection class mismatch, " +
                 "connection not obtained from this manager.");
            var5C20061853D03D1DF306BE40FC8B88CE_1996843474.addTaint(taint);
            throw var5C20061853D03D1DF306BE40FC8B88CE_1996843474;
        } //End block
        if(log.isDebugEnabled())        
        {
            log.debug("Releasing connection " + conn);
        } //End block
        ConnAdapter sca = (ConnAdapter) conn;
        if(sca.poolEntry == null)        
        return;
        ClientConnectionManager manager = sca.getManager();
        if(manager != null && manager != this)        
        {
            IllegalArgumentException varBB73D5117B54E30F8478997E19A744E0_2025031119 = new IllegalArgumentException
                ("Connection not obtained from this manager.");
            varBB73D5117B54E30F8478997E19A744E0_2025031119.addTaint(taint);
            throw varBB73D5117B54E30F8478997E19A744E0_2025031119;
        } //End block
        try 
        {
            final Socket socket = uniquePoolEntry.connection.getSocket();
            if(socket != null)            
            {
                SocketTagger.get().untag(socket);
            } //End block
            if(sca.isOpen() && (this.alwaysShutDown ||
                                 !sca.isMarkedReusable()))            
            {
                if(log.isDebugEnabled())                
                {
                    log.debug
                        ("Released connection open but not reusable.");
                } //End block
                sca.shutdown();
            } //End block
        } //End block
        catch (IOException iox)
        {
            if(log.isDebugEnabled())            
            log.debug("Exception shutting down released connection.",
                          iox);
        } //End block
        finally 
        {
            sca.detach();
            managedConn = null;
            lastReleaseTime = System.currentTimeMillis();
            if(validDuration > 0)            
            connectionExpiresTime = timeUnit.toMillis(validDuration) + lastReleaseTime;
            else
            connectionExpiresTime = Long.MAX_VALUE;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.239 -0400", hash_original_method = "144B79381F1DE3A7D4EE72C53F4D2E2A", hash_generated_method = "B3B27C124C0090ADAAAC1C9DDBCC5BFE")
    public void closeExpiredConnections() {
        if(System.currentTimeMillis() >= connectionExpiresTime)        
        {
            closeIdleConnections(0, TimeUnit.MILLISECONDS);
        } //End block
        // ---------- Original Method ----------
        //if(System.currentTimeMillis() >= connectionExpiresTime) {
            //closeIdleConnections(0, TimeUnit.MILLISECONDS);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.239 -0400", hash_original_method = "F34DBDBB0F8CB1363DA5802203A9DE31", hash_generated_method = "276EED88B6765E3300D2822C1EAF6360")
    public void closeIdleConnections(long idletime, TimeUnit tunit) {
        addTaint(tunit.getTaint());
        addTaint(idletime);
        assertStillUp();
        if(tunit == null)        
        {
            IllegalArgumentException var1E3A26647533CD72883EC80C4F4E6594_339400617 = new IllegalArgumentException("Time unit must not be null.");
            var1E3A26647533CD72883EC80C4F4E6594_339400617.addTaint(taint);
            throw var1E3A26647533CD72883EC80C4F4E6594_339400617;
        } //End block
        if((managedConn == null) && uniquePoolEntry.connection.isOpen())        
        {
            final long cutoff = System.currentTimeMillis() - tunit.toMillis(idletime);
            if(lastReleaseTime <= cutoff)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.240 -0400", hash_original_method = "3B23C31C02DC0AC3A698CF8CD25A20B9", hash_generated_method = "A7BA68780740FF17BA19B4FD51517DF3")
    public void shutdown() {
        this.isShutDown = true;
        if(managedConn != null)        
        managedConn.detach();
        try 
        {
            if(uniquePoolEntry != null)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.241 -0400", hash_original_method = "A0A03885E6FE7F03CE9159285B1CDEFC", hash_generated_method = "557F5CF728EB0934EB84B187017182EB")
    protected void revokeConnection() {
        if(managedConn == null)        
        return;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.241 -0400", hash_original_method = "631D63FD16AE3FEAB1552B743E29445B", hash_generated_method = "0E4235DC66A001DF5C14070AD2C3F949")
        protected  PoolEntry() {
            super(SingleClientConnManager.this.connOperator, null);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.241 -0400", hash_original_method = "A86295986A372D00C8F07CAE9A39223B", hash_generated_method = "A56F21567D7EEEE24E934EB99AD6ACA0")
        protected void close() throws IOException {
            shutdownEntry();
            if(connection.isOpen())            
            connection.close();
            // ---------- Original Method ----------
            //shutdownEntry();
            //if (connection.isOpen())
                //connection.close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.242 -0400", hash_original_method = "D39515BCFB2BDEF720AFC38551AEFE84", hash_generated_method = "09F56C05011DFD8E7D934EA5DEC37239")
        protected void shutdown() throws IOException {
            shutdownEntry();
            if(connection.isOpen())            
            connection.shutdown();
            // ---------- Original Method ----------
            //shutdownEntry();
            //if (connection.isOpen())
                //connection.shutdown();
        }

        
    }


    
    protected class ConnAdapter extends AbstractPooledConnAdapter {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.242 -0400", hash_original_method = "8101547A28FD0D2F472FF84F23BAF09C", hash_generated_method = "A7EAC48D22FFB4A7D16838E71A4449BB")
        protected  ConnAdapter(PoolEntry entry, HttpRoute route) {
            super(SingleClientConnManager.this, entry);
            addTaint(route.getTaint());
            addTaint(entry.getTaint());
            markReusable();
            entry.route = route;
            // ---------- Original Method ----------
            //markReusable();
            //entry.route = route;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.242 -0400", hash_original_field = "BD1D652AAA6438AB5EC42DCDC531A4BB", hash_generated_field = "3A54ED9163F39DBD02547DB2ADF36FAA")

    public final static String MISUSE_MESSAGE =
    "Invalid use of SingleClientConnManager: connection still allocated.\n" +
    "Make sure to release the connection before allocating another one.";
}

