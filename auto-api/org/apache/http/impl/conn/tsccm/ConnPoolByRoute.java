package org.apache.http.impl.conn.tsccm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.720 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.721 -0400", hash_original_field = "4B583376B2767B923C3E1DA60D10DE59", hash_generated_field = "026614D17D2D565C77517B2D71C2A557")

    protected ClientConnectionOperator operator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.721 -0400", hash_original_field = "00F6D979105D0C08D3FF3C34966EEEFF", hash_generated_field = "E964A63E9B82E3DD4DC47C59FAE8DE45")

    protected Queue<BasicPoolEntry> freeConnections;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.721 -0400", hash_original_field = "EDA389023301AC22C2ECA1E2C34DC3F8", hash_generated_field = "E267A7FAC4E8E5B414A36EEBC5A1B7B4")

    protected Queue<WaitingThread> waitingThreads;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.721 -0400", hash_original_field = "BBAA0DF2F5EF3A9A15A4D8772C595503", hash_generated_field = "CC1DA54842268F916A1617EAB82AA607")

    protected Map<HttpRoute, RouteSpecificPool> routeToPool;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.721 -0400", hash_original_field = "497186546BBF70F0259AFAED612CA74D", hash_generated_field = "72497F1614BF1540B1D26A1572D9E5CA")

    protected int maxTotalConnections;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.721 -0400", hash_original_field = "6C54B2094555AA6B7B51CC3ABCFA4CCB", hash_generated_field = "9E9F031DEF0505CA4E19FEFFE7AAAD7E")

    private ConnPerRoute connPerRoute;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.721 -0400", hash_original_method = "66E0A8FBF49ECB21297BEFDE183D53F0", hash_generated_method = "A13B7BD20F669797EDA87C2AEB9624FF")
    public  ConnPoolByRoute(final ClientConnectionOperator operator, final HttpParams params) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Connection operator may not be null");
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.722 -0400", hash_original_method = "5727338124A1E72B6395110A48913E3E", hash_generated_method = "0DAC662BB001089CA18942E468032531")
    protected Queue<BasicPoolEntry> createFreeConnQueue() {
        Queue<BasicPoolEntry> varB4EAC82CA7396A68D541C85D26508E83_372096319 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_372096319 = new LinkedList<BasicPoolEntry>();
        varB4EAC82CA7396A68D541C85D26508E83_372096319.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_372096319;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.722 -0400", hash_original_method = "6DAD2F123996401C30A0886A4B729895", hash_generated_method = "6957528D5FADAF7FF809BB3FC4B3DA56")
    protected Queue<WaitingThread> createWaitingThreadQueue() {
        Queue<WaitingThread> varB4EAC82CA7396A68D541C85D26508E83_838557714 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_838557714 = new LinkedList<WaitingThread>();
        varB4EAC82CA7396A68D541C85D26508E83_838557714.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_838557714;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.722 -0400", hash_original_method = "2238A516ECCEA4A16F09E10B17DA5B4C", hash_generated_method = "A432301C28FD9FE39C1241404DFF1F03")
    protected Map<HttpRoute, RouteSpecificPool> createRouteToPoolMap() {
        Map<HttpRoute, RouteSpecificPool> varB4EAC82CA7396A68D541C85D26508E83_1155801199 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1155801199 = new HashMap<HttpRoute, RouteSpecificPool>();
        varB4EAC82CA7396A68D541C85D26508E83_1155801199.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1155801199;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.723 -0400", hash_original_method = "5DDB8B45F189660D50400B7C32F12F31", hash_generated_method = "A49A7DAD7722AE7EF561988E38F8CDD5")
    protected RouteSpecificPool newRouteSpecificPool(HttpRoute route) {
        RouteSpecificPool varB4EAC82CA7396A68D541C85D26508E83_221720533 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_221720533 = new RouteSpecificPool(route, connPerRoute.getMaxForRoute(route));
        addTaint(route.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_221720533.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_221720533;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.724 -0400", hash_original_method = "92724E0FC2C28E5538F8325CDCFB2338", hash_generated_method = "0BB1FBC5A80AC0C84871E13749EE2139")
    protected WaitingThread newWaitingThread(Condition cond,
                                             RouteSpecificPool rospl) {
        WaitingThread varB4EAC82CA7396A68D541C85D26508E83_775381242 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_775381242 = new WaitingThread(cond, rospl);
        addTaint(cond.getTaint());
        addTaint(rospl.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_775381242.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_775381242;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.725 -0400", hash_original_method = "2DA0D144EE94C06AE8D1ED191B4BB0F6", hash_generated_method = "8634A15CDEA1D191A945CB5BE96DB6CC")
    protected RouteSpecificPool getRoutePool(HttpRoute route,
                                             boolean create) {
        RouteSpecificPool varB4EAC82CA7396A68D541C85D26508E83_1486774807 = null; 
        RouteSpecificPool rospl = null;
        poolLock.lock();
        try 
        {
            rospl = routeToPool.get(route);
            {
                rospl = newRouteSpecificPool(route);
                routeToPool.put(route, rospl);
            } 
        } 
        finally 
        {
            poolLock.unlock();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1486774807 = rospl;
        addTaint(route.getTaint());
        addTaint(create);
        varB4EAC82CA7396A68D541C85D26508E83_1486774807.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1486774807;
        
        
        
        
            
            
                
                
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.726 -0400", hash_original_method = "BC602BD8B10C5776DF65F2D8A63D167D", hash_generated_method = "EA3B8949AC1D7225AE3DE93B7349860B")
    public int getConnectionsInPool(HttpRoute route) {
        poolLock.lock();
        try 
        {
            RouteSpecificPool rospl = getRoutePool(route, false);
            {
                Object var26BD373E5730791C17FA6D5FDDB43569_444505002 = (rospl.getEntryCount());
            } 
        } 
        finally 
        {
            poolLock.unlock();
        } 
        addTaint(route.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1273993810 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1273993810;
        
        
        
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.727 -0400", hash_original_method = "E2BAF1ACE5FFF01DCEE8A821FE8A73A0", hash_generated_method = "03B4CD58CBE33169EE9C49E6CBD5056D")
    @Override
    public PoolEntryRequest requestPoolEntry(
            final HttpRoute route,
            final Object state) {
        PoolEntryRequest varB4EAC82CA7396A68D541C85D26508E83_680261906 = null; 
        final WaitingThreadAborter aborter = new WaitingThreadAborter();
        varB4EAC82CA7396A68D541C85D26508E83_680261906 = new PoolEntryRequest() {
            public void abortRequest() {
                poolLock.lock();
                try {
                    aborter.abort();
                } finally {
                    poolLock.unlock();
                }
            }
            public BasicPoolEntry getPoolEntry(
                    long timeout,
                    TimeUnit tunit)
                        throws InterruptedException, ConnectionPoolTimeoutException {
                return getEntryBlocking(route, state, timeout, tunit, aborter);
            }
        };
        addTaint(route.getTaint());
        addTaint(state.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_680261906.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_680261906;
        
        
        
            
                
                
                    
                
                    
                
            
            
                    
                    
                        
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.728 -0400", hash_original_method = "0255BF16791796767BBFE4AD753EF26D", hash_generated_method = "A7594E81589D9EB03C826D9E229BC111")
    protected BasicPoolEntry getEntryBlocking(
                                   HttpRoute route, Object state,
                                   long timeout, TimeUnit tunit,
                                   WaitingThreadAborter aborter) throws ConnectionPoolTimeoutException, InterruptedException {
        BasicPoolEntry varB4EAC82CA7396A68D541C85D26508E83_1236988259 = null; 
        Date deadline = null;
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
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException
                        ("Connection pool shut down.");
                } 
                {
                    boolean var8C81D2AA4B3CAAC93C1458903A413EAB_615376132 = (log.isDebugEnabled());
                    {
                        log.debug("Total connections kept alive: " + freeConnections.size());
                        log.debug("Total issued connections: " + issuedConnections.size());
                        log.debug("Total allocated connection: " + numConnections + " out of " + maxTotalConnections);
                    } 
                } 
                entry = getFreeEntry(rospl, state);
                boolean hasCapacity = rospl.getCapacity() > 0;
                {
                    boolean var8C81D2AA4B3CAAC93C1458903A413EAB_350746468 = (log.isDebugEnabled());
                    {
                        log.debug("Available capacity: " + rospl.getCapacity() 
                            + " out of " + rospl.getMaxEntries()
                            + " [" + route + "][" + state + "]");
                    } 
                } 
                {
                    entry = createEntry(rospl, operator);
                } 
                {
                    boolean varBB9316C6F8FFF645825C6D7CBC27F3F6_115571681 = (hasCapacity && !freeConnections.isEmpty());
                    {
                        deleteLeastUsedEntry();
                        entry = createEntry(rospl, operator);
                    } 
                    {
                        {
                            boolean varF1685CB26B0999B3A47E854C01691B8F_1811635313 = (log.isDebugEnabled());
                            {
                                log.debug("Need to wait for connection" +
                                " [" + route + "][" + state + "]");
                            } 
                        } 
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
                        {
                            boolean varC77383D433BAB16A958CAA9A5957ED7F_1352057725 = (!success && (deadline != null) &&
                        (deadline.getTime() <= System.currentTimeMillis()));
                            {
                                if (DroidSafeAndroidRuntime.control) throw new ConnectionPoolTimeoutException
                            ("Timeout waiting for connection");
                            } 
                        } 
                    } 
                } 
            } 
        } 
        finally 
        {
            poolLock.unlock();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1236988259 = entry;
        addTaint(route.getTaint());
        addTaint(state.getTaint());
        addTaint(timeout);
        addTaint(tunit.getTaint());
        addTaint(aborter.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1236988259.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1236988259;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.729 -0400", hash_original_method = "459D6C1E2796BA157345E479FDD43BC9", hash_generated_method = "2595A1D4BA964166426A38918A227CF3")
    @Override
    public void freeEntry(BasicPoolEntry entry, boolean reusable, long validDuration, TimeUnit timeUnit) {
        HttpRoute route = entry.getPlannedRoute();
        {
            boolean var983CD6AA124987301747A815A5742497_37877812 = (log.isDebugEnabled());
            {
                log.debug("Freeing connection" +                                 
                    " [" + route + "][" + entry.getState() + "]");
            } 
        } 
        poolLock.lock();
        try 
        {
            {
                closeConnection(entry.getConnection());
            } 
            issuedConnections.remove(entry.getWeakRef());
            RouteSpecificPool rospl = getRoutePool(route, true);
            {
                rospl.freeEntry(entry);
                freeConnections.add(entry);
                idleConnHandler.add(entry.getConnection(), validDuration, timeUnit);
            } 
            {
                rospl.dropEntry();
            } 
            notifyWaitingThread(rospl);
        } 
        finally 
        {
            poolLock.unlock();
        } 
        addTaint(entry.getTaint());
        addTaint(reusable);
        addTaint(validDuration);
        addTaint(timeUnit.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.730 -0400", hash_original_method = "962CBFF1A83D816E79E3DF7051655A88", hash_generated_method = "1E683B3CF190179C215A5B32D5354B3C")
    protected BasicPoolEntry getFreeEntry(RouteSpecificPool rospl, Object state) {
        BasicPoolEntry varB4EAC82CA7396A68D541C85D26508E83_627541936 = null; 
        BasicPoolEntry entry = null;
        poolLock.lock();
        try 
        {
            boolean done = false;
            {
                entry = rospl.allocEntry(state);
                {
                    {
                        boolean varB5EA13E236059479AA556C9226E19405_344608679 = (log.isDebugEnabled());
                        {
                            log.debug("Getting free connection" 
                                + " [" + rospl.getRoute() + "][" + state + "]");
                        } 
                    } 
                    freeConnections.remove(entry);
                    boolean valid = idleConnHandler.remove(entry.getConnection());
                    {
                        {
                            boolean varF1685CB26B0999B3A47E854C01691B8F_673034361 = (log.isDebugEnabled());
                            log.debug("Closing expired free connection"
                                    + " [" + rospl.getRoute() + "][" + state + "]");
                        } 
                        closeConnection(entry.getConnection());
                        rospl.dropEntry();
                    } 
                    {
                        issuedConnections.add(entry.getWeakRef());
                        done = true;
                    } 
                } 
                {
                    done = true;
                    {
                        boolean varB5EA13E236059479AA556C9226E19405_88837425 = (log.isDebugEnabled());
                        {
                            log.debug("No free connections" 
                                + " [" + rospl.getRoute() + "][" + state + "]");
                        } 
                    } 
                } 
            } 
        } 
        finally 
        {
            poolLock.unlock();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_627541936 = entry;
        addTaint(rospl.getTaint());
        addTaint(state.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_627541936.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_627541936;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.731 -0400", hash_original_method = "97D909B421F8D92376760AF2E5C3347E", hash_generated_method = "19FAF8812261631C04867C56A0F6B658")
    protected BasicPoolEntry createEntry(RouteSpecificPool rospl,
                                         ClientConnectionOperator op) {
        BasicPoolEntry varB4EAC82CA7396A68D541C85D26508E83_267747374 = null; 
        {
            boolean var983CD6AA124987301747A815A5742497_1992631452 = (log.isDebugEnabled());
            {
                log.debug("Creating new connection [" + rospl.getRoute() + "]");
            } 
        } 
        BasicPoolEntry entry = new BasicPoolEntry(op, rospl.getRoute(), refQueue);
        poolLock.lock();
        try 
        {
            rospl.createdEntry(entry);
            issuedConnections.add(entry.getWeakRef());
        } 
        finally 
        {
            poolLock.unlock();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_267747374 = entry;
        addTaint(rospl.getTaint());
        addTaint(op.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_267747374.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_267747374;
        
        
            
        
        
            
        
        
            
            
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.732 -0400", hash_original_method = "D62BEFFDBE1A81D3681FD693CE298CE1", hash_generated_method = "839920D8A282912E0483F632FFBAAE13")
    protected void deleteEntry(BasicPoolEntry entry) {
        HttpRoute route = entry.getPlannedRoute();
        {
            boolean var983CD6AA124987301747A815A5742497_1673882112 = (log.isDebugEnabled());
            {
                log.debug("Deleting connection" 
                    + " [" + route + "][" + entry.getState() + "]");
            } 
        } 
        poolLock.lock();
        try 
        {
            closeConnection(entry.getConnection());
            RouteSpecificPool rospl = getRoutePool(route, true);
            rospl.deleteEntry(entry);
            {
                boolean var8D810A24394F07D416710B0736FD510C_186971331 = (rospl.isUnused());
                {
                    routeToPool.remove(route);
                } 
            } 
            idleConnHandler.remove(entry.getConnection());
        } 
        finally 
        {
            poolLock.unlock();
        } 
        addTaint(entry.getTaint());
        
        
        
            
                    
        
        
        
            
            
            
            
            
                
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.732 -0400", hash_original_method = "55BF8FCE42D97AAB2D67412B08D832BA", hash_generated_method = "3491C930DD55A1E8D3683075AD29E875")
    protected void deleteLeastUsedEntry() {
        try 
        {
            poolLock.lock();
            BasicPoolEntry entry = freeConnections.remove();
            {
                deleteEntry(entry);
            } 
            {
                boolean varCF6EB300C7D56FAF33A2C36006D8EF42_13960181 = (log.isDebugEnabled());
                {
                    log.debug("No free connection to delete.");
                } 
            } 
        } 
        finally 
        {
            poolLock.unlock();
        } 
        
        
            
            
            
                
            
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.733 -0400", hash_original_method = "DA32210354F9DB856361268717BF05AF", hash_generated_method = "4E747788793D4FB8221AA281B15166EC")
    @Override
    protected void handleLostEntry(HttpRoute route) {
        poolLock.lock();
        try 
        {
            RouteSpecificPool rospl = getRoutePool(route, true);
            rospl.dropEntry();
            {
                boolean var8D810A24394F07D416710B0736FD510C_139617738 = (rospl.isUnused());
                {
                    routeToPool.remove(route);
                } 
            } 
            notifyWaitingThread(rospl);
        } 
        finally 
        {
            poolLock.unlock();
        } 
        addTaint(route.getTaint());
        
        
        
            
            
            
                
            
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.733 -0400", hash_original_method = "31234679312EA392475BCCB545DA6E40", hash_generated_method = "70A66641491F4B3E0FF7A347F76F9B39")
    protected void notifyWaitingThread(RouteSpecificPool rospl) {
        WaitingThread waitingThread = null;
        poolLock.lock();
        try 
        {
            {
                boolean var13AF0F99B5C721DC0586151E6E94535B_265293209 = ((rospl != null) && rospl.hasThread());
                {
                    {
                        boolean varB5EA13E236059479AA556C9226E19405_1753541513 = (log.isDebugEnabled());
                        {
                            log.debug("Notifying thread waiting on pool" +
                            " [" + rospl.getRoute() + "]");
                        } 
                    } 
                    waitingThread = rospl.nextThread();
                } 
                {
                    boolean var83EDDC38CA2B42006FCFF31DB3DA3393_1342622294 = (!waitingThreads.isEmpty());
                    {
                        {
                            boolean varF1685CB26B0999B3A47E854C01691B8F_5877981 = (log.isDebugEnabled());
                            {
                                log.debug("Notifying thread waiting on any pool");
                            } 
                        } 
                        waitingThread = waitingThreads.remove();
                    } 
                    {
                        boolean varB5EA13E236059479AA556C9226E19405_1201015391 = (log.isDebugEnabled());
                        {
                            log.debug("Notifying no-one, there are no waiting threads");
                        } 
                    } 
                } 
            } 
            {
                waitingThread.wakeup();
            } 
        } 
        finally 
        {
            poolLock.unlock();
        } 
        addTaint(rospl.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.734 -0400", hash_original_method = "0A72C49DF2696A5ACE45DBE2BAC53FC3", hash_generated_method = "CBAD437B75E2BD1AB1AF27DFAD62D7CE")
    @Override
    public void deleteClosedConnections() {
        poolLock.lock();
        try 
        {
            Iterator<BasicPoolEntry> iter = freeConnections.iterator();
            {
                boolean var8492AE2C695A56B730381A28B8BA3F6D_1962839398 = (iter.hasNext());
                {
                    BasicPoolEntry entry = iter.next();
                    {
                        boolean var950A0EAB3C04D174C02E91857C6308E2_1620982694 = (!entry.getConnection().isOpen());
                        {
                            iter.remove();
                            deleteEntry(entry);
                        } 
                    } 
                } 
            } 
        } 
        finally 
        {
            poolLock.unlock();
        } 
        
        
        
            
            
                
                
                    
                    
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.735 -0400", hash_original_method = "38D5175483A246D837BDBD9602C30A7F", hash_generated_method = "2BE0425712E40FD5B2C0660989C413A4")
    @Override
    public void shutdown() {
        poolLock.lock();
        try 
        {
            super.shutdown();
            Iterator<BasicPoolEntry> ibpe = freeConnections.iterator();
            {
                boolean var173117A8B9F49E273F835BF5D96C17AD_1403140571 = (ibpe.hasNext());
                {
                    BasicPoolEntry entry = ibpe.next();
                    ibpe.remove();
                    closeConnection(entry.getConnection());
                } 
            } 
            Iterator<WaitingThread> iwth = waitingThreads.iterator();
            {
                boolean var7C47C57BBF30942F9164D5370F6AA67B_939530367 = (iwth.hasNext());
                {
                    WaitingThread waiter = iwth.next();
                    iwth.remove();
                    waiter.wakeup();
                } 
            } 
            routeToPool.clear();
        } 
        finally 
        {
            poolLock.unlock();
        } 
        
        
        
            
            
            
                
                
                
            
            
            
                
                
                
            
            
        
            
        
    }
}

