package org.apache.http.impl.conn.tsccm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.params.ConnPerRoute;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.params.HttpParams;

public class ConnPoolByRoute extends AbstractConnPool {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.080 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.080 -0400", hash_original_field = "4B583376B2767B923C3E1DA60D10DE59", hash_generated_field = "026614D17D2D565C77517B2D71C2A557")

    protected ClientConnectionOperator operator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.080 -0400", hash_original_field = "00F6D979105D0C08D3FF3C34966EEEFF", hash_generated_field = "E964A63E9B82E3DD4DC47C59FAE8DE45")

    protected Queue<BasicPoolEntry> freeConnections;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.080 -0400", hash_original_field = "EDA389023301AC22C2ECA1E2C34DC3F8", hash_generated_field = "E267A7FAC4E8E5B414A36EEBC5A1B7B4")

    protected Queue<WaitingThread> waitingThreads;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.080 -0400", hash_original_field = "BBAA0DF2F5EF3A9A15A4D8772C595503", hash_generated_field = "CC1DA54842268F916A1617EAB82AA607")

    protected Map<HttpRoute, RouteSpecificPool> routeToPool;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.080 -0400", hash_original_field = "497186546BBF70F0259AFAED612CA74D", hash_generated_field = "72497F1614BF1540B1D26A1572D9E5CA")

    protected int maxTotalConnections;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.080 -0400", hash_original_field = "6C54B2094555AA6B7B51CC3ABCFA4CCB", hash_generated_field = "9E9F031DEF0505CA4E19FEFFE7AAAD7E")

    private ConnPerRoute connPerRoute;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.082 -0400", hash_original_method = "66E0A8FBF49ECB21297BEFDE183D53F0", hash_generated_method = "D69695C20A1A19064CF866AF5EF96FF9")
    public  ConnPoolByRoute(final ClientConnectionOperator operator, final HttpParams params) {
        super();
    if(operator == null)        
        {
            IllegalArgumentException var77D8C168DB874D3F429F1A2BBEABDD03_1927357760 = new IllegalArgumentException("Connection operator may not be null");
            var77D8C168DB874D3F429F1A2BBEABDD03_1927357760.addTaint(taint);
            throw var77D8C168DB874D3F429F1A2BBEABDD03_1927357760;
        } 
        this.operator = operator;
        freeConnections = createFreeConnQueue();
        waitingThreads  = createWaitingThreadQueue();
        routeToPool     = createRouteToPoolMap();
        maxTotalConnections = ConnManagerParams
            .getMaxTotalConnections(params);
        connPerRoute = ConnManagerParams
            .getMaxConnectionsPerRoute(params);
        
        
            
        
        
        
        
        
        
            
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.082 -0400", hash_original_method = "5727338124A1E72B6395110A48913E3E", hash_generated_method = "36C5A31AF698343A64BCFAB4973654FD")
    protected Queue<BasicPoolEntry> createFreeConnQueue() {
Queue<BasicPoolEntry> var01B77BB2B7DAEB18A121DF47998865B8_1996144486 =         new LinkedList<BasicPoolEntry>();
        var01B77BB2B7DAEB18A121DF47998865B8_1996144486.addTaint(taint);
        return var01B77BB2B7DAEB18A121DF47998865B8_1996144486;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.082 -0400", hash_original_method = "6DAD2F123996401C30A0886A4B729895", hash_generated_method = "7C43D86B3EC5F07386130D200CBD86D2")
    protected Queue<WaitingThread> createWaitingThreadQueue() {
Queue<WaitingThread> var291A08B00D43E126646A8B5C8C6F7C49_1735501448 =         new LinkedList<WaitingThread>();
        var291A08B00D43E126646A8B5C8C6F7C49_1735501448.addTaint(taint);
        return var291A08B00D43E126646A8B5C8C6F7C49_1735501448;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.082 -0400", hash_original_method = "2238A516ECCEA4A16F09E10B17DA5B4C", hash_generated_method = "D4A24F3288B76E29769D8F547404E486")
    protected Map<HttpRoute, RouteSpecificPool> createRouteToPoolMap() {
Map<HttpRoute, RouteSpecificPool> var134DFE940BF69D54A54951EBDC23A049_1411715309 =         new HashMap<HttpRoute, RouteSpecificPool>();
        var134DFE940BF69D54A54951EBDC23A049_1411715309.addTaint(taint);
        return var134DFE940BF69D54A54951EBDC23A049_1411715309;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.083 -0400", hash_original_method = "5DDB8B45F189660D50400B7C32F12F31", hash_generated_method = "E402F87285DDBAD0238CCF060A3C09CF")
    protected RouteSpecificPool newRouteSpecificPool(HttpRoute route) {
        addTaint(route.getTaint());
RouteSpecificPool var4C24997C04DFA56270A7A8E269A0BC66_1685230555 =         new RouteSpecificPool(route, connPerRoute.getMaxForRoute(route));
        var4C24997C04DFA56270A7A8E269A0BC66_1685230555.addTaint(taint);
        return var4C24997C04DFA56270A7A8E269A0BC66_1685230555;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.083 -0400", hash_original_method = "92724E0FC2C28E5538F8325CDCFB2338", hash_generated_method = "AB4CBE0A55470F4E05938AB4A24932AC")
    protected WaitingThread newWaitingThread(Condition cond,
                                             RouteSpecificPool rospl) {
        addTaint(rospl.getTaint());
        addTaint(cond.getTaint());
WaitingThread varDFDF030C3807F5EFC0894FF071EF6497_370962266 =         new WaitingThread(cond, rospl);
        varDFDF030C3807F5EFC0894FF071EF6497_370962266.addTaint(taint);
        return varDFDF030C3807F5EFC0894FF071EF6497_370962266;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.084 -0400", hash_original_method = "2DA0D144EE94C06AE8D1ED191B4BB0F6", hash_generated_method = "A46C6001935617248DAB78E81D8D7665")
    protected RouteSpecificPool getRoutePool(HttpRoute route,
                                             boolean create) {
        addTaint(create);
        addTaint(route.getTaint());
        RouteSpecificPool rospl = null;
        poolLock.lock();
        try 
        {
            rospl = routeToPool.get(route);
    if((rospl == null) && create)            
            {
                rospl = newRouteSpecificPool(route);
                routeToPool.put(route, rospl);
            } 
        } 
        finally 
        {
            poolLock.unlock();
        } 
RouteSpecificPool varCC98A0C084730B1A1F306BC097B9A40E_673951562 =         rospl;
        varCC98A0C084730B1A1F306BC097B9A40E_673951562.addTaint(taint);
        return varCC98A0C084730B1A1F306BC097B9A40E_673951562;
        
        
        
        
            
            
                
                
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.084 -0400", hash_original_method = "BC602BD8B10C5776DF65F2D8A63D167D", hash_generated_method = "6DA7E8F673071AE7B1D42E2B46A5FDC6")
    public int getConnectionsInPool(HttpRoute route) {
        addTaint(route.getTaint());
        poolLock.lock();
        try 
        {
            RouteSpecificPool rospl = getRoutePool(route, false);
            int varDDC0D817358B407776C5AC80C93F45C4_809282912 = ((rospl != null) ? rospl.getEntryCount() : 0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_6943888 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_6943888;
        } 
        finally 
        {
            poolLock.unlock();
        } 
        
        
        
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.086 -0400", hash_original_method = "E2BAF1ACE5FFF01DCEE8A821FE8A73A0", hash_generated_method = "4B45CD6FD820D330213FD96E5D93130A")
    @Override
    public PoolEntryRequest requestPoolEntry(
            final HttpRoute route,
            final Object state) {
        addTaint(state.getTaint());
        addTaint(route.getTaint());
        final WaitingThreadAborter aborter = new WaitingThreadAborter();
PoolEntryRequest var1B2A51D879C1F73D768B957F412A1315_651671484 =         new PoolEntryRequest() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.085 -0400", hash_original_method = "C0659DE6DBCF2DF5649EE53105FC269A", hash_generated_method = "BCD4FE8FC31FA4FA7CCBE569EE60A00E")
        public void abortRequest() {
            poolLock.lock();
            try 
            {
                aborter.abort();
            } 
            finally 
            {
                poolLock.unlock();
            } 
            
            
            
                    
                
                    
                
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.085 -0400", hash_original_method = "5C56F9CAB1134243DEE9B4B085AFA43E", hash_generated_method = "D44D65E099FA595EBE7D8688D6CB9B58")
        public BasicPoolEntry getPoolEntry(
                    long timeout,
                    TimeUnit tunit) throws InterruptedException, ConnectionPoolTimeoutException {
            addTaint(tunit.getTaint());
            addTaint(timeout);
BasicPoolEntry var3ADC47A1A9E57B79D43B9B27BBB00DC3_714315262 =             getEntryBlocking(route, state, timeout, tunit, aborter);
            var3ADC47A1A9E57B79D43B9B27BBB00DC3_714315262.addTaint(taint);
            return var3ADC47A1A9E57B79D43B9B27BBB00DC3_714315262;
            
            
        }
};
        var1B2A51D879C1F73D768B957F412A1315_651671484.addTaint(taint);
        return var1B2A51D879C1F73D768B957F412A1315_651671484;
        
        
        
            
                
                
                    
                
                    
                
            
            
                    
                    
                        
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.088 -0400", hash_original_method = "0255BF16791796767BBFE4AD753EF26D", hash_generated_method = "66E6B08549ED758B64AABC4700CEC7D9")
    protected BasicPoolEntry getEntryBlocking(
                                   HttpRoute route, Object state,
                                   long timeout, TimeUnit tunit,
                                   WaitingThreadAborter aborter) throws ConnectionPoolTimeoutException, InterruptedException {
        addTaint(aborter.getTaint());
        addTaint(tunit.getTaint());
        addTaint(timeout);
        addTaint(state.getTaint());
        addTaint(route.getTaint());
        Date deadline = null;
    if(timeout > 0)        
        {
            deadline = new Date
                (System.currentTimeMillis() + tunit.toMillis(timeout));
        } 
        BasicPoolEntry entry = null;
        poolLock.lock();
        try 
        {
            RouteSpecificPool rospl = getRoutePool(route, true);
            WaitingThread waitingThread = null;
            while
(entry == null)            
            {
    if(isShutDown)                
                {
                    IllegalStateException var6E6039D9A4C3BA391612A72168B10397_1158008076 = new IllegalStateException
                        ("Connection pool shut down.");
                    var6E6039D9A4C3BA391612A72168B10397_1158008076.addTaint(taint);
                    throw var6E6039D9A4C3BA391612A72168B10397_1158008076;
                } 
    if(log.isDebugEnabled())                
                {
                    log.debug("Total connections kept alive: " + freeConnections.size());
                    log.debug("Total issued connections: " + issuedConnections.size());
                    log.debug("Total allocated connection: " + numConnections + " out of " + maxTotalConnections);
                } 
                entry = getFreeEntry(rospl, state);
    if(entry != null)                
                {
                    break;
                } 
                boolean hasCapacity = rospl.getCapacity() > 0;
    if(log.isDebugEnabled())                
                {
                    log.debug("Available capacity: " + rospl.getCapacity() 
                            + " out of " + rospl.getMaxEntries()
                            + " [" + route + "][" + state + "]");
                } 
    if(hasCapacity && numConnections < maxTotalConnections)                
                {
                    entry = createEntry(rospl, operator);
                } 
                else
    if(hasCapacity && !freeConnections.isEmpty())                
                {
                    deleteLeastUsedEntry();
                    entry = createEntry(rospl, operator);
                } 
                else
                {
    if(log.isDebugEnabled())                    
                    {
                        log.debug("Need to wait for connection" +
                                " [" + route + "][" + state + "]");
                    } 
    if(waitingThread == null)                    
                    {
                        waitingThread =
                            newWaitingThread(poolLock.newCondition(), rospl);
                        aborter.setWaitingThread(waitingThread);
                    } 
                    boolean success = false;
                    try 
                    {
                        rospl.queueThread(waitingThread);
                        waitingThreads.add(waitingThread);
                        success = waitingThread.await(deadline);
                    } 
                    finally 
                    {
                        rospl.removeThread(waitingThread);
                        waitingThreads.remove(waitingThread);
                    } 
    if(!success && (deadline != null) &&
                        (deadline.getTime() <= System.currentTimeMillis()))                    
                    {
                        ConnectionPoolTimeoutException var96319C47C8FA016BD9C81CF53419CF0E_1452468045 = new ConnectionPoolTimeoutException
                            ("Timeout waiting for connection");
                        var96319C47C8FA016BD9C81CF53419CF0E_1452468045.addTaint(taint);
                        throw var96319C47C8FA016BD9C81CF53419CF0E_1452468045;
                    } 
                } 
            } 
        } 
        finally 
        {
            poolLock.unlock();
        } 
BasicPoolEntry varF26DBE38545460D6F6AE1D948FF53869_254583454 =         entry;
        varF26DBE38545460D6F6AE1D948FF53869_254583454.addTaint(taint);
        return varF26DBE38545460D6F6AE1D948FF53869_254583454;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.090 -0400", hash_original_method = "459D6C1E2796BA157345E479FDD43BC9", hash_generated_method = "C284AAB36548E98C6B3A85CFBF51602F")
    @Override
    public void freeEntry(BasicPoolEntry entry, boolean reusable, long validDuration, TimeUnit timeUnit) {
        addTaint(timeUnit.getTaint());
        addTaint(validDuration);
        addTaint(reusable);
        addTaint(entry.getTaint());
        HttpRoute route = entry.getPlannedRoute();
    if(log.isDebugEnabled())        
        {
            log.debug("Freeing connection" +                                 
                    " [" + route + "][" + entry.getState() + "]");
        } 
        poolLock.lock();
        try 
        {
    if(isShutDown)            
            {
                closeConnection(entry.getConnection());
                return;
            } 
            issuedConnections.remove(entry.getWeakRef());
            RouteSpecificPool rospl = getRoutePool(route, true);
    if(reusable)            
            {
                rospl.freeEntry(entry);
                freeConnections.add(entry);
                idleConnHandler.add(entry.getConnection(), validDuration, timeUnit);
            } 
            else
            {
                rospl.dropEntry();
                numConnections--;
            } 
            notifyWaitingThread(rospl);
        } 
        finally 
        {
            poolLock.unlock();
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.091 -0400", hash_original_method = "962CBFF1A83D816E79E3DF7051655A88", hash_generated_method = "ADBEF0675700CD314CE37B87202861CA")
    protected BasicPoolEntry getFreeEntry(RouteSpecificPool rospl, Object state) {
        addTaint(state.getTaint());
        addTaint(rospl.getTaint());
        BasicPoolEntry entry = null;
        poolLock.lock();
        try 
        {
            boolean done = false;
            while
(!done)            
            {
                entry = rospl.allocEntry(state);
    if(entry != null)                
                {
    if(log.isDebugEnabled())                    
                    {
                        log.debug("Getting free connection" 
                                + " [" + rospl.getRoute() + "][" + state + "]");
                    } 
                    freeConnections.remove(entry);
                    boolean valid = idleConnHandler.remove(entry.getConnection());
    if(!valid)                    
                    {
    if(log.isDebugEnabled())                        
                        log.debug("Closing expired free connection"
                                    + " [" + rospl.getRoute() + "][" + state + "]");
                        closeConnection(entry.getConnection());
                        rospl.dropEntry();
                        numConnections--;
                    } 
                    else
                    {
                        issuedConnections.add(entry.getWeakRef());
                        done = true;
                    } 
                } 
                else
                {
                    done = true;
    if(log.isDebugEnabled())                    
                    {
                        log.debug("No free connections" 
                                + " [" + rospl.getRoute() + "][" + state + "]");
                    } 
                } 
            } 
        } 
        finally 
        {
            poolLock.unlock();
        } 
BasicPoolEntry varF26DBE38545460D6F6AE1D948FF53869_1556351764 =         entry;
        varF26DBE38545460D6F6AE1D948FF53869_1556351764.addTaint(taint);
        return varF26DBE38545460D6F6AE1D948FF53869_1556351764;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.091 -0400", hash_original_method = "97D909B421F8D92376760AF2E5C3347E", hash_generated_method = "3B6BE890569C3C5306B28174252B399F")
    protected BasicPoolEntry createEntry(RouteSpecificPool rospl,
                                         ClientConnectionOperator op) {
        addTaint(op.getTaint());
        addTaint(rospl.getTaint());
    if(log.isDebugEnabled())        
        {
            log.debug("Creating new connection [" + rospl.getRoute() + "]");
        } 
        BasicPoolEntry entry = new BasicPoolEntry(op, rospl.getRoute(), refQueue);
        poolLock.lock();
        try 
        {
            rospl.createdEntry(entry);
            numConnections++;
            issuedConnections.add(entry.getWeakRef());
        } 
        finally 
        {
            poolLock.unlock();
        } 
BasicPoolEntry varF26DBE38545460D6F6AE1D948FF53869_23921454 =         entry;
        varF26DBE38545460D6F6AE1D948FF53869_23921454.addTaint(taint);
        return varF26DBE38545460D6F6AE1D948FF53869_23921454;
        
        
            
        
        
            
        
        
            
            
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.092 -0400", hash_original_method = "D62BEFFDBE1A81D3681FD693CE298CE1", hash_generated_method = "6748CA7012DCB246526F1342927D8D8F")
    protected void deleteEntry(BasicPoolEntry entry) {
        addTaint(entry.getTaint());
        HttpRoute route = entry.getPlannedRoute();
    if(log.isDebugEnabled())        
        {
            log.debug("Deleting connection" 
                    + " [" + route + "][" + entry.getState() + "]");
        } 
        poolLock.lock();
        try 
        {
            closeConnection(entry.getConnection());
            RouteSpecificPool rospl = getRoutePool(route, true);
            rospl.deleteEntry(entry);
            numConnections--;
    if(rospl.isUnused())            
            {
                routeToPool.remove(route);
            } 
            idleConnHandler.remove(entry.getConnection());
        } 
        finally 
        {
            poolLock.unlock();
        } 
        
        
        
            
                    
        
        
        
            
            
            
            
            
                
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.092 -0400", hash_original_method = "55BF8FCE42D97AAB2D67412B08D832BA", hash_generated_method = "452D00794D7381FDBFA7A2428FE18DA0")
    protected void deleteLeastUsedEntry() {
        try 
        {
            poolLock.lock();
            BasicPoolEntry entry = freeConnections.remove();
    if(entry != null)            
            {
                deleteEntry(entry);
            } 
            else
    if(log.isDebugEnabled())            
            {
                log.debug("No free connection to delete.");
            } 
        } 
        finally 
        {
            poolLock.unlock();
        } 
        
        
            
            
            
                
            
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.093 -0400", hash_original_method = "DA32210354F9DB856361268717BF05AF", hash_generated_method = "6741F6577676B573D5E2D3F643B6D29D")
    @Override
    protected void handleLostEntry(HttpRoute route) {
        addTaint(route.getTaint());
        poolLock.lock();
        try 
        {
            RouteSpecificPool rospl = getRoutePool(route, true);
            rospl.dropEntry();
    if(rospl.isUnused())            
            {
                routeToPool.remove(route);
            } 
            numConnections--;
            notifyWaitingThread(rospl);
        } 
        finally 
        {
            poolLock.unlock();
        } 
        
        
        
            
            
            
                
            
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.094 -0400", hash_original_method = "31234679312EA392475BCCB545DA6E40", hash_generated_method = "D518ADA40B7CAEB8EDF8EB5B2B36F582")
    protected void notifyWaitingThread(RouteSpecificPool rospl) {
        addTaint(rospl.getTaint());
        WaitingThread waitingThread = null;
        poolLock.lock();
        try 
        {
    if((rospl != null) && rospl.hasThread())            
            {
    if(log.isDebugEnabled())                
                {
                    log.debug("Notifying thread waiting on pool" +
                            " [" + rospl.getRoute() + "]");
                } 
                waitingThread = rospl.nextThread();
            } 
            else
    if(!waitingThreads.isEmpty())            
            {
    if(log.isDebugEnabled())                
                {
                    log.debug("Notifying thread waiting on any pool");
                } 
                waitingThread = waitingThreads.remove();
            } 
            else
    if(log.isDebugEnabled())            
            {
                log.debug("Notifying no-one, there are no waiting threads");
            } 
    if(waitingThread != null)            
            {
                waitingThread.wakeup();
            } 
        } 
        finally 
        {
            poolLock.unlock();
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.095 -0400", hash_original_method = "0A72C49DF2696A5ACE45DBE2BAC53FC3", hash_generated_method = "AF6098CACC87944BEDEB0C98E10E82A2")
    @Override
    public void deleteClosedConnections() {
        poolLock.lock();
        try 
        {
            Iterator<BasicPoolEntry> iter = freeConnections.iterator();
            while
(iter.hasNext())            
            {
                BasicPoolEntry entry = iter.next();
    if(!entry.getConnection().isOpen())                
                {
                    iter.remove();
                    deleteEntry(entry);
                } 
            } 
        } 
        finally 
        {
            poolLock.unlock();
        } 
        
        
        
            
            
                
                
                    
                    
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.096 -0400", hash_original_method = "38D5175483A246D837BDBD9602C30A7F", hash_generated_method = "BDFCA26F24F86CCF88666A40FACE6822")
    @Override
    public void shutdown() {
        poolLock.lock();
        try 
        {
            super.shutdown();
            Iterator<BasicPoolEntry> ibpe = freeConnections.iterator();
            while
(ibpe.hasNext())            
            {
                BasicPoolEntry entry = ibpe.next();
                ibpe.remove();
                closeConnection(entry.getConnection());
            } 
            Iterator<WaitingThread> iwth = waitingThreads.iterator();
            while
(iwth.hasNext())            
            {
                WaitingThread waiter = iwth.next();
                iwth.remove();
                waiter.wakeup();
            } 
            routeToPool.clear();
        } 
        finally 
        {
            poolLock.unlock();
        } 
        
        
        
            
            
            
                
                
                
            
            
            
                
                
                
            
            
        
            
        
    }

    
}

