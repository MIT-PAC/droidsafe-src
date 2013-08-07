package org.apache.http.impl.conn.tsccm;

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
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.conn.DefaultClientConnectionOperator;
import org.apache.http.params.HttpParams;

import dalvik.system.SocketTagger;





public class ThreadSafeClientConnManager implements ClientConnectionManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.472 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.472 -0400", hash_original_field = "1D823F19EC944D016B48B105C3632412", hash_generated_field = "262A27B6B6B1CBF25439CFECC3909997")

    protected SchemeRegistry schemeRegistry;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.472 -0400", hash_original_field = "99874BDECC32FFAA06AFF68D9A8B62AF", hash_generated_field = "A126A5C00AC17033F6B94E836FE92D15")

    protected AbstractConnPool connectionPool;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.472 -0400", hash_original_field = "30434E45229CAA1EA40A11E0FD7C2DB8", hash_generated_field = "6D2607DA479BDA11A25B13C47E7F0C5C")

    protected ClientConnectionOperator connOperator;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.473 -0400", hash_original_method = "CE8305B2F50479AC170D47319F9570C8", hash_generated_method = "F0363A20272B15F0D002EA7123624925")
    public  ThreadSafeClientConnManager(HttpParams params,
                                       SchemeRegistry schreg) {
        if(params == null)        
        {
            IllegalArgumentException var497CCC27A43EDD6EE25BEEC5507E2BE2_1758958958 = new IllegalArgumentException("HTTP parameters may not be null");
            var497CCC27A43EDD6EE25BEEC5507E2BE2_1758958958.addTaint(taint);
            throw var497CCC27A43EDD6EE25BEEC5507E2BE2_1758958958;
        } //End block
        this.schemeRegistry = schreg;
        this.connOperator   = createConnectionOperator(schreg);
        this.connectionPool = createConnectionPool(params);
        // ---------- Original Method ----------
        //if (params == null) {
            //throw new IllegalArgumentException("HTTP parameters may not be null");
        //}
        //this.schemeRegistry = schreg;
        //this.connOperator   = createConnectionOperator(schreg);
        //this.connectionPool = createConnectionPool(params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.474 -0400", hash_original_method = "0E19810A97EBEE58216EC05F0D60A026", hash_generated_method = "374DE57AB0E3DB06FD60574FD3247A4E")
    @Override
    protected void finalize() throws Throwable {
        shutdown();
        super.finalize();
        // ---------- Original Method ----------
        //shutdown();
        //super.finalize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.474 -0400", hash_original_method = "E5BC66DBF19261346819AE7E60C7F467", hash_generated_method = "B937B11514E0487DFACA6487CDF959E9")
    protected AbstractConnPool createConnectionPool(final HttpParams params) {
        addTaint(params.getTaint());
        AbstractConnPool acp = new ConnPoolByRoute(connOperator, params);
        boolean conngc = true;
        if(conngc)        
        {
            acp.enableConnectionGC();
        } //End block
AbstractConnPool varE953D28529A29D0923F05A1180B1C595_1075055145 =         acp;
        varE953D28529A29D0923F05A1180B1C595_1075055145.addTaint(taint);
        return varE953D28529A29D0923F05A1180B1C595_1075055145;
        // ---------- Original Method ----------
        //AbstractConnPool acp = new ConnPoolByRoute(connOperator, params);
        //boolean conngc = true;
        //if (conngc) {
            //acp.enableConnectionGC();
        //}
        //return acp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.475 -0400", hash_original_method = "25E4E60569E24699D7326BD2975E9BC2", hash_generated_method = "956B5E71407ADEBF8101A2346BB1AC1D")
    protected ClientConnectionOperator createConnectionOperator(SchemeRegistry schreg) {
        addTaint(schreg.getTaint());
ClientConnectionOperator var5302AB2ADD1B4945976DC003AFE0BD75_1484058892 =         new DefaultClientConnectionOperator(schreg);
        var5302AB2ADD1B4945976DC003AFE0BD75_1484058892.addTaint(taint);
        return var5302AB2ADD1B4945976DC003AFE0BD75_1484058892;
        // ---------- Original Method ----------
        //return new DefaultClientConnectionOperator(schreg);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.475 -0400", hash_original_method = "98F37EDA7C4377EF27FBBC8455A5DCE4", hash_generated_method = "7F1FEA11471FF550A94E9A23AEC04EAF")
    public SchemeRegistry getSchemeRegistry() {
SchemeRegistry var88A9F5243E7E93089AA8FDF949007087_62192246 =         this.schemeRegistry;
        var88A9F5243E7E93089AA8FDF949007087_62192246.addTaint(taint);
        return var88A9F5243E7E93089AA8FDF949007087_62192246;
        // ---------- Original Method ----------
        //return this.schemeRegistry;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.478 -0400", hash_original_method = "3E5898B68534E316FCFFCF41E86D81D5", hash_generated_method = "65CB60378C4F77AF8C9BD5947A844EA7")
    public ClientConnectionRequest requestConnection(
            final HttpRoute route, 
            final Object state) {
        addTaint(state.getTaint());
        addTaint(route.getTaint());
        final PoolEntryRequest poolRequest = connectionPool.requestPoolEntry(
                route, state);
ClientConnectionRequest var770B2D70BC29F87D7B2C9D785AEF83CC_191761058 =         new ClientConnectionRequest() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.476 -0400", hash_original_method = "F05670E2223BB88FEEE004D958D804B8", hash_generated_method = "C6881EAE8DDE9E7198AF00DA9B39007F")
        public void abortRequest() {
            poolRequest.abortRequest();
            // ---------- Original Method ----------
            //poolRequest.abortRequest();
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.477 -0400", hash_original_method = "6069BCC0A12724F289E46465DF3930EB", hash_generated_method = "2E31F269253E96A419E0D2DB043527E6")
        public ManagedClientConnection getConnection(
                    long timeout, TimeUnit tunit) throws InterruptedException,
                    ConnectionPoolTimeoutException {
            addTaint(tunit.getTaint());
            addTaint(timeout);
            if(route == null)            
            {
                IllegalArgumentException var807ED97BD06382A664709EF49C1C9EA3_1395614494 = new IllegalArgumentException("Route may not be null.");
                var807ED97BD06382A664709EF49C1C9EA3_1395614494.addTaint(taint);
                throw var807ED97BD06382A664709EF49C1C9EA3_1395614494;
            } //End block
            if(log.isDebugEnabled())            
            {
                log.debug("ThreadSafeClientConnManager.getConnection: "
                        + route + ", timeout = " + timeout);
            } //End block
            BasicPoolEntry entry = poolRequest.getPoolEntry(timeout, tunit);
            try 
            {
                final Socket socket = entry.getConnection().getSocket();
                if(socket != null)                
                {
                    SocketTagger.get().tag(socket);
                } //End block
            } //End block
            catch (IOException iox)
            {
                log.debug("Problem tagging socket.", iox);
            } //End block
ManagedClientConnection var050DB10D94FB3DCE7E05105A39B0D859_763947054 =             new BasicPooledConnAdapter(ThreadSafeClientConnManager.this, entry);
            var050DB10D94FB3DCE7E05105A39B0D859_763947054.addTaint(taint);
            return var050DB10D94FB3DCE7E05105A39B0D859_763947054;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }
};
        var770B2D70BC29F87D7B2C9D785AEF83CC_191761058.addTaint(taint);
        return var770B2D70BC29F87D7B2C9D785AEF83CC_191761058;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.479 -0400", hash_original_method = "3CF782E9F00803924FA9A14119B3585D", hash_generated_method = "FFD5414D40CEB468F036AACCF39A71DB")
    public void releaseConnection(ManagedClientConnection conn, long validDuration, TimeUnit timeUnit) {
        addTaint(timeUnit.getTaint());
        addTaint(validDuration);
        addTaint(conn.getTaint());
        if(!(conn instanceof BasicPooledConnAdapter))        
        {
            IllegalArgumentException var5C20061853D03D1DF306BE40FC8B88CE_1779278517 = new IllegalArgumentException
                ("Connection class mismatch, " +
                 "connection not obtained from this manager.");
            var5C20061853D03D1DF306BE40FC8B88CE_1779278517.addTaint(taint);
            throw var5C20061853D03D1DF306BE40FC8B88CE_1779278517;
        } //End block
        BasicPooledConnAdapter hca = (BasicPooledConnAdapter) conn;
        if((hca.getPoolEntry() != null) && (hca.getManager() != this))        
        {
            IllegalArgumentException varBB73D5117B54E30F8478997E19A744E0_425695079 = new IllegalArgumentException
                ("Connection not obtained from this manager.");
            varBB73D5117B54E30F8478997E19A744E0_425695079.addTaint(taint);
            throw varBB73D5117B54E30F8478997E19A744E0_425695079;
        } //End block
        try 
        {
            final BasicPoolEntry entry = (BasicPoolEntry) hca.getPoolEntry();
            final Socket socket = entry.getConnection().getSocket();
            if(socket != null)            
            {
                SocketTagger.get().untag(socket);
            } //End block
            if(hca.isOpen() && !hca.isMarkedReusable())            
            {
                if(log.isDebugEnabled())                
                {
                    log.debug
                        ("Released connection open but not marked reusable.");
                } //End block
                hca.shutdown();
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
            BasicPoolEntry entry = (BasicPoolEntry) hca.getPoolEntry();
            boolean reusable = hca.isMarkedReusable();
            hca.detach();
            if(entry != null)            
            {
                connectionPool.freeEntry(entry, reusable, validDuration, timeUnit);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.480 -0400", hash_original_method = "5B798EEC995C1D56865AC1580F955080", hash_generated_method = "42E2BBAB2AF21073775665B77EF166D8")
    public void shutdown() {
        connectionPool.shutdown();
        // ---------- Original Method ----------
        //connectionPool.shutdown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.480 -0400", hash_original_method = "52C9DA1F5E2D598BCB82BD013D1068AD", hash_generated_method = "C700EF54A265E7A9DC66DFFEE37E17B7")
    public int getConnectionsInPool(HttpRoute route) {
        addTaint(route.getTaint());
        int var98FF7D22E269D4EE315C5F83DB696C31_1865250282 = (((ConnPoolByRoute)connectionPool).getConnectionsInPool(
                route));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2130179101 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2130179101;
        // ---------- Original Method ----------
        //return ((ConnPoolByRoute)connectionPool).getConnectionsInPool(
                //route);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.480 -0400", hash_original_method = "A7E68EC885457C399BA150A4DD387F90", hash_generated_method = "6257663D2E9FBD742278B144621450CC")
    public int getConnectionsInPool() {
        synchronized
(connectionPool)        {
            int var038F1DAABF4682F3C2515CE7A20EDA08_2098955229 = (connectionPool.numConnections);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1176858456 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1176858456;
        } //End block
        // ---------- Original Method ----------
        //synchronized (connectionPool) {
            //return connectionPool.numConnections; 
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.480 -0400", hash_original_method = "614803CEB018564B6D4B8085A3E1BC4F", hash_generated_method = "02B4FE8F0B0FCC91334B2078A30ECCC5")
    public void closeIdleConnections(long idleTimeout, TimeUnit tunit) {
        addTaint(tunit.getTaint());
        addTaint(idleTimeout);
        connectionPool.closeIdleConnections(idleTimeout, tunit);
        connectionPool.deleteClosedConnections();
        // ---------- Original Method ----------
        //connectionPool.closeIdleConnections(idleTimeout, tunit);
        //connectionPool.deleteClosedConnections();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.481 -0400", hash_original_method = "3CBEAD5C5E5FD142C35EE66C6F0AAE4C", hash_generated_method = "536375C07B2EFC293E2096521891082E")
    public void closeExpiredConnections() {
        connectionPool.closeExpiredConnections();
        connectionPool.deleteClosedConnections();
        // ---------- Original Method ----------
        //connectionPool.closeExpiredConnections();
        //connectionPool.deleteClosedConnections();
    }

    
}

