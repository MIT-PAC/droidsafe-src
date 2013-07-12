package org.apache.http.impl.conn.tsccm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.166 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.166 -0400", hash_original_field = "1D823F19EC944D016B48B105C3632412", hash_generated_field = "262A27B6B6B1CBF25439CFECC3909997")

    protected SchemeRegistry schemeRegistry;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.167 -0400", hash_original_field = "99874BDECC32FFAA06AFF68D9A8B62AF", hash_generated_field = "A126A5C00AC17033F6B94E836FE92D15")

    protected AbstractConnPool connectionPool;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.167 -0400", hash_original_field = "30434E45229CAA1EA40A11E0FD7C2DB8", hash_generated_field = "6D2607DA479BDA11A25B13C47E7F0C5C")

    protected ClientConnectionOperator connOperator;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.167 -0400", hash_original_method = "CE8305B2F50479AC170D47319F9570C8", hash_generated_method = "38F74EB4E0C239FEE8D73DC995BAF06C")
    public  ThreadSafeClientConnManager(HttpParams params,
                                       SchemeRegistry schreg) {
    if(params == null)        
        {
            IllegalArgumentException var497CCC27A43EDD6EE25BEEC5507E2BE2_721857634 = new IllegalArgumentException("HTTP parameters may not be null");
            var497CCC27A43EDD6EE25BEEC5507E2BE2_721857634.addTaint(taint);
            throw var497CCC27A43EDD6EE25BEEC5507E2BE2_721857634;
        } 
        this.schemeRegistry = schreg;
        this.connOperator   = createConnectionOperator(schreg);
        this.connectionPool = createConnectionPool(params);
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.168 -0400", hash_original_method = "0E19810A97EBEE58216EC05F0D60A026", hash_generated_method = "374DE57AB0E3DB06FD60574FD3247A4E")
    @Override
    protected void finalize() throws Throwable {
        shutdown();
        super.finalize();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.168 -0400", hash_original_method = "E5BC66DBF19261346819AE7E60C7F467", hash_generated_method = "8EE80FAFDF3A7356B41E50103185436A")
    protected AbstractConnPool createConnectionPool(final HttpParams params) {
        addTaint(params.getTaint());
        AbstractConnPool acp = new ConnPoolByRoute(connOperator, params);
        boolean conngc = true;
    if(conngc)        
        {
            acp.enableConnectionGC();
        } 
AbstractConnPool varE953D28529A29D0923F05A1180B1C595_1912163811 =         acp;
        varE953D28529A29D0923F05A1180B1C595_1912163811.addTaint(taint);
        return varE953D28529A29D0923F05A1180B1C595_1912163811;
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.168 -0400", hash_original_method = "25E4E60569E24699D7326BD2975E9BC2", hash_generated_method = "F247CA0E3949ABD1C71E4EA5549D93E8")
    protected ClientConnectionOperator createConnectionOperator(SchemeRegistry schreg) {
        addTaint(schreg.getTaint());
ClientConnectionOperator var5302AB2ADD1B4945976DC003AFE0BD75_1374227233 =         new DefaultClientConnectionOperator(schreg);
        var5302AB2ADD1B4945976DC003AFE0BD75_1374227233.addTaint(taint);
        return var5302AB2ADD1B4945976DC003AFE0BD75_1374227233;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.169 -0400", hash_original_method = "98F37EDA7C4377EF27FBBC8455A5DCE4", hash_generated_method = "663F38AEA7317FF7841935355BA0554E")
    public SchemeRegistry getSchemeRegistry() {
SchemeRegistry var88A9F5243E7E93089AA8FDF949007087_937005648 =         this.schemeRegistry;
        var88A9F5243E7E93089AA8FDF949007087_937005648.addTaint(taint);
        return var88A9F5243E7E93089AA8FDF949007087_937005648;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.170 -0400", hash_original_method = "3E5898B68534E316FCFFCF41E86D81D5", hash_generated_method = "29C2F5DEFF4E501BA5B477959048EE71")
    public ClientConnectionRequest requestConnection(
            final HttpRoute route, 
            final Object state) {
        addTaint(state.getTaint());
        addTaint(route.getTaint());
        final PoolEntryRequest poolRequest = connectionPool.requestPoolEntry(
                route, state);
ClientConnectionRequest var770B2D70BC29F87D7B2C9D785AEF83CC_1359834413 =         new ClientConnectionRequest() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.169 -0400", hash_original_method = "F05670E2223BB88FEEE004D958D804B8", hash_generated_method = "C6881EAE8DDE9E7198AF00DA9B39007F")
        public void abortRequest() {
            poolRequest.abortRequest();
            
            
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.170 -0400", hash_original_method = "6069BCC0A12724F289E46465DF3930EB", hash_generated_method = "91051601A4A4AEF2428F3E11D184C8AC")
        public ManagedClientConnection getConnection(
                    long timeout, TimeUnit tunit) throws InterruptedException,
                    ConnectionPoolTimeoutException {
            addTaint(tunit.getTaint());
            addTaint(timeout);
    if(route == null)            
            {
                IllegalArgumentException var807ED97BD06382A664709EF49C1C9EA3_1660183659 = new IllegalArgumentException("Route may not be null.");
                var807ED97BD06382A664709EF49C1C9EA3_1660183659.addTaint(taint);
                throw var807ED97BD06382A664709EF49C1C9EA3_1660183659;
            } 
    if(log.isDebugEnabled())            
            {
                log.debug("ThreadSafeClientConnManager.getConnection: "
                        + route + ", timeout = " + timeout);
            } 
            BasicPoolEntry entry = poolRequest.getPoolEntry(timeout, tunit);
            try 
            {
                final Socket socket = entry.getConnection().getSocket();
    if(socket != null)                
                {
                    SocketTagger.get().tag(socket);
                } 
            } 
            catch (IOException iox)
            {
                log.debug("Problem tagging socket.", iox);
            } 
ManagedClientConnection var050DB10D94FB3DCE7E05105A39B0D859_1469194523 =             new BasicPooledConnAdapter(ThreadSafeClientConnManager.this, entry);
            var050DB10D94FB3DCE7E05105A39B0D859_1469194523.addTaint(taint);
            return var050DB10D94FB3DCE7E05105A39B0D859_1469194523;
            
            
        }
};
        var770B2D70BC29F87D7B2C9D785AEF83CC_1359834413.addTaint(taint);
        return var770B2D70BC29F87D7B2C9D785AEF83CC_1359834413;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.171 -0400", hash_original_method = "3CF782E9F00803924FA9A14119B3585D", hash_generated_method = "A55AB667B3B6756A84595FD01E192D41")
    public void releaseConnection(ManagedClientConnection conn, long validDuration, TimeUnit timeUnit) {
        addTaint(timeUnit.getTaint());
        addTaint(validDuration);
        addTaint(conn.getTaint());
    if(!(conn instanceof BasicPooledConnAdapter))        
        {
            IllegalArgumentException var5C20061853D03D1DF306BE40FC8B88CE_2072981088 = new IllegalArgumentException
                ("Connection class mismatch, " +
                 "connection not obtained from this manager.");
            var5C20061853D03D1DF306BE40FC8B88CE_2072981088.addTaint(taint);
            throw var5C20061853D03D1DF306BE40FC8B88CE_2072981088;
        } 
        BasicPooledConnAdapter hca = (BasicPooledConnAdapter) conn;
    if((hca.getPoolEntry() != null) && (hca.getManager() != this))        
        {
            IllegalArgumentException varBB73D5117B54E30F8478997E19A744E0_865061827 = new IllegalArgumentException
                ("Connection not obtained from this manager.");
            varBB73D5117B54E30F8478997E19A744E0_865061827.addTaint(taint);
            throw varBB73D5117B54E30F8478997E19A744E0_865061827;
        } 
        try 
        {
            final BasicPoolEntry entry = (BasicPoolEntry) hca.getPoolEntry();
            final Socket socket = entry.getConnection().getSocket();
    if(socket != null)            
            {
                SocketTagger.get().untag(socket);
            } 
    if(hca.isOpen() && !hca.isMarkedReusable())            
            {
    if(log.isDebugEnabled())                
                {
                    log.debug
                        ("Released connection open but not marked reusable.");
                } 
                hca.shutdown();
            } 
        } 
        catch (IOException iox)
        {
    if(log.isDebugEnabled())            
            log.debug("Exception shutting down released connection.",
                          iox);
        } 
        finally 
        {
            BasicPoolEntry entry = (BasicPoolEntry) hca.getPoolEntry();
            boolean reusable = hca.isMarkedReusable();
            hca.detach();
    if(entry != null)            
            {
                connectionPool.freeEntry(entry, reusable, validDuration, timeUnit);
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.171 -0400", hash_original_method = "5B798EEC995C1D56865AC1580F955080", hash_generated_method = "42E2BBAB2AF21073775665B77EF166D8")
    public void shutdown() {
        connectionPool.shutdown();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.171 -0400", hash_original_method = "52C9DA1F5E2D598BCB82BD013D1068AD", hash_generated_method = "0DA693E102D009795756D9828B442A25")
    public int getConnectionsInPool(HttpRoute route) {
        addTaint(route.getTaint());
        int var98FF7D22E269D4EE315C5F83DB696C31_1756949604 = (((ConnPoolByRoute)connectionPool).getConnectionsInPool(
                route));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1981789563 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1981789563;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.172 -0400", hash_original_method = "A7E68EC885457C399BA150A4DD387F90", hash_generated_method = "F8DA8F615D1B7CDB1E2EA9BC5DCA8E85")
    public int getConnectionsInPool() {
        synchronized
(connectionPool)        {
            int var038F1DAABF4682F3C2515CE7A20EDA08_1040964192 = (connectionPool.numConnections);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1747848300 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1747848300;
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.172 -0400", hash_original_method = "614803CEB018564B6D4B8085A3E1BC4F", hash_generated_method = "02B4FE8F0B0FCC91334B2078A30ECCC5")
    public void closeIdleConnections(long idleTimeout, TimeUnit tunit) {
        addTaint(tunit.getTaint());
        addTaint(idleTimeout);
        connectionPool.closeIdleConnections(idleTimeout, tunit);
        connectionPool.deleteClosedConnections();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.172 -0400", hash_original_method = "3CBEAD5C5E5FD142C35EE66C6F0AAE4C", hash_generated_method = "536375C07B2EFC293E2096521891082E")
    public void closeExpiredConnections() {
        connectionPool.closeExpiredConnections();
        connectionPool.deleteClosedConnections();
        
        
        
    }

    
}

