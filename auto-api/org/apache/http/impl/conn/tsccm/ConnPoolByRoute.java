package org.apache.http.impl.conn.tsccm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.110 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "4E4E630304492253CB8147CAE1C7D2A5")

    private Log log = LogFactory.getLog(getClass());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.110 -0400", hash_original_field = "4B583376B2767B923C3E1DA60D10DE59", hash_generated_field = "026614D17D2D565C77517B2D71C2A557")

    protected ClientConnectionOperator operator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.110 -0400", hash_original_field = "00F6D979105D0C08D3FF3C34966EEEFF", hash_generated_field = "E964A63E9B82E3DD4DC47C59FAE8DE45")

    protected Queue<BasicPoolEntry> freeConnections;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.110 -0400", hash_original_field = "EDA389023301AC22C2ECA1E2C34DC3F8", hash_generated_field = "E267A7FAC4E8E5B414A36EEBC5A1B7B4")

    protected Queue<WaitingThread> waitingThreads;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.110 -0400", hash_original_field = "BBAA0DF2F5EF3A9A15A4D8772C595503", hash_generated_field = "CC1DA54842268F916A1617EAB82AA607")

    protected Map<HttpRoute, RouteSpecificPool> routeToPool;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.111 -0400", hash_original_field = "497186546BBF70F0259AFAED612CA74D", hash_generated_field = "72497F1614BF1540B1D26A1572D9E5CA")

    protected int maxTotalConnections;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.111 -0400", hash_original_field = "6C54B2094555AA6B7B51CC3ABCFA4CCB", hash_generated_field = "9E9F031DEF0505CA4E19FEFFE7AAAD7E")

    private ConnPerRoute connPerRoute;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.113 -0400", hash_original_method = "66E0A8FBF49ECB21297BEFDE183D53F0", hash_generated_method = "A13B7BD20F669797EDA87C2AEB9624FF")
    public  ConnPoolByRoute(final ClientConnectionOperator operator, final HttpParams params) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Connection operator may not be null");
        } //End block
        this.operator = operator;
        freeConnections = createFreeConnQueue();
        waitingThreads  = createWaitingThreadQueue();
        routeToPool     = createRouteToPoolMap();
        maxTotalConnections = ConnManagerParams
            .getMaxTotalConnections(params);
        connPerRoute = ConnManagerParams
            .getMaxConnectionsPerRoute(params);
        // ---------- Original Method ----------
        //if (operator == null) {
            //throw new IllegalArgumentException("Connection operator may not be null");
        //}
        //this.operator = operator;
        //freeConnections = createFreeConnQueue();
        //waitingThreads  = createWaitingThreadQueue();
        //routeToPool     = createRouteToPoolMap();
        //maxTotalConnections = ConnManagerParams
            //.getMaxTotalConnections(params);
        //connPerRoute = ConnManagerParams
            //.getMaxConnectionsPerRoute(params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.118 -0400", hash_original_method = "5727338124A1E72B6395110A48913E3E", hash_generated_method = "EABAF3F4832F393CC08E51F4C5EE3A90")
    protected Queue<BasicPoolEntry> createFreeConnQueue() {
        Queue<BasicPoolEntry> varB4EAC82CA7396A68D541C85D26508E83_503149637 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_503149637 = new LinkedList<BasicPoolEntry>();
        varB4EAC82CA7396A68D541C85D26508E83_503149637.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_503149637;
        // ---------- Original Method ----------
        //return new LinkedList<BasicPoolEntry>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.119 -0400", hash_original_method = "6DAD2F123996401C30A0886A4B729895", hash_generated_method = "900CC78A561063D315408951933AB3E7")
    protected Queue<WaitingThread> createWaitingThreadQueue() {
        Queue<WaitingThread> varB4EAC82CA7396A68D541C85D26508E83_1227976271 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1227976271 = new LinkedList<WaitingThread>();
        varB4EAC82CA7396A68D541C85D26508E83_1227976271.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1227976271;
        // ---------- Original Method ----------
        //return new LinkedList<WaitingThread>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.119 -0400", hash_original_method = "2238A516ECCEA4A16F09E10B17DA5B4C", hash_generated_method = "3E80E13B2C558E806E240870320CA794")
    protected Map<HttpRoute, RouteSpecificPool> createRouteToPoolMap() {
        Map<HttpRoute, RouteSpecificPool> varB4EAC82CA7396A68D541C85D26508E83_1203874476 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1203874476 = new HashMap<HttpRoute, RouteSpecificPool>();
        varB4EAC82CA7396A68D541C85D26508E83_1203874476.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1203874476;
        // ---------- Original Method ----------
        //return new HashMap<HttpRoute, RouteSpecificPool>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.120 -0400", hash_original_method = "5DDB8B45F189660D50400B7C32F12F31", hash_generated_method = "65C022897ED999C6431373DDC0E23CAF")
    protected RouteSpecificPool newRouteSpecificPool(HttpRoute route) {
        RouteSpecificPool varB4EAC82CA7396A68D541C85D26508E83_57586561 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_57586561 = new RouteSpecificPool(route, connPerRoute.getMaxForRoute(route));
        addTaint(route.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_57586561.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_57586561;
        // ---------- Original Method ----------
        //return new RouteSpecificPool(route, connPerRoute.getMaxForRoute(route));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.121 -0400", hash_original_method = "92724E0FC2C28E5538F8325CDCFB2338", hash_generated_method = "C3FBC32D167D5E307E012F29A00C68AE")
    protected WaitingThread newWaitingThread(Condition cond,
                                             RouteSpecificPool rospl) {
        WaitingThread varB4EAC82CA7396A68D541C85D26508E83_1099771557 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1099771557 = new WaitingThread(cond, rospl);
        addTaint(cond.getTaint());
        addTaint(rospl.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1099771557.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1099771557;
        // ---------- Original Method ----------
        //return new WaitingThread(cond, rospl);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.124 -0400", hash_original_method = "2DA0D144EE94C06AE8D1ED191B4BB0F6", hash_generated_method = "19C0841F3C92FD156B7AE149D8BBF315")
    protected RouteSpecificPool getRoutePool(HttpRoute route,
                                             boolean create) {
        RouteSpecificPool varB4EAC82CA7396A68D541C85D26508E83_1868605528 = null; //Variable for return #1
        RouteSpecificPool rospl;
        rospl = null;
        poolLock.lock();
        try 
        {
            rospl = routeToPool.get(route);
            {
                rospl = newRouteSpecificPool(route);
                routeToPool.put(route, rospl);
            } //End block
        } //End block
        finally 
        {
            poolLock.unlock();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1868605528 = rospl;
        addTaint(route.getTaint());
        addTaint(create);
        varB4EAC82CA7396A68D541C85D26508E83_1868605528.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1868605528;
        // ---------- Original Method ----------
        //RouteSpecificPool rospl = null;
        //poolLock.lock();
        //try {
            //rospl = routeToPool.get(route);
            //if ((rospl == null) && create) {
                //rospl = newRouteSpecificPool(route);
                //routeToPool.put(route, rospl);
            //}
        //} finally {
            //poolLock.unlock();
        //}
        //return rospl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.125 -0400", hash_original_method = "BC602BD8B10C5776DF65F2D8A63D167D", hash_generated_method = "BC55571CAD7D1BCD9E8B85BEDE2A28E3")
    public int getConnectionsInPool(HttpRoute route) {
        poolLock.lock();
        try 
        {
            RouteSpecificPool rospl;
            rospl = getRoutePool(route, false);
            {
                Object var26BD373E5730791C17FA6D5FDDB43569_793572922 = (rospl.getEntryCount());
            } //End flattened ternary
        } //End block
        finally 
        {
            poolLock.unlock();
        } //End block
        addTaint(route.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1537017111 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1537017111;
        // ---------- Original Method ----------
        //poolLock.lock();
        //try {
            //RouteSpecificPool rospl = getRoutePool(route, false);
            //return (rospl != null) ? rospl.getEntryCount() : 0;
        //} finally {
            //poolLock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.126 -0400", hash_original_method = "E2BAF1ACE5FFF01DCEE8A821FE8A73A0", hash_generated_method = "F887B10CED7B34459ABAAAE0BE8399AF")
    @Override
    public PoolEntryRequest requestPoolEntry(
            final HttpRoute route,
            final Object state) {
        PoolEntryRequest varB4EAC82CA7396A68D541C85D26508E83_1350316783 = null; //Variable for return #1
        WaitingThreadAborter aborter;
        aborter = new WaitingThreadAborter();
        varB4EAC82CA7396A68D541C85D26508E83_1350316783 = new PoolEntryRequest() {
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
        varB4EAC82CA7396A68D541C85D26508E83_1350316783.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1350316783;
        // ---------- Original Method ----------
        //final WaitingThreadAborter aborter = new WaitingThreadAborter();
        //return new PoolEntryRequest() {
            //public void abortRequest() {
                //poolLock.lock();
                //try {
                    //aborter.abort();
                //} finally {
                    //poolLock.unlock();
                //}
            //}
            //public BasicPoolEntry getPoolEntry(
                    //long timeout,
                    //TimeUnit tunit)
                        //throws InterruptedException, ConnectionPoolTimeoutException {
                //return getEntryBlocking(route, state, timeout, tunit, aborter);
            //}
        //};
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.131 -0400", hash_original_method = "0255BF16791796767BBFE4AD753EF26D", hash_generated_method = "4CBB15CA25A8FEC0FE9EB02293E9315D")
    protected BasicPoolEntry getEntryBlocking(
                                   HttpRoute route, Object state,
                                   long timeout, TimeUnit tunit,
                                   WaitingThreadAborter aborter) throws ConnectionPoolTimeoutException, InterruptedException {
        BasicPoolEntry varB4EAC82CA7396A68D541C85D26508E83_1000776589 = null; //Variable for return #1
        Date deadline;
        deadline = null;
        {
            deadline = new Date
                (System.currentTimeMillis() + tunit.toMillis(timeout));
        } //End block
        BasicPoolEntry entry;
        entry = null;
        poolLock.lock();
        try 
        {
            RouteSpecificPool rospl;
            rospl = getRoutePool(route, true);
            WaitingThread waitingThread;
            waitingThread = null;
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException
                        ("Connection pool shut down.");
                } //End block
                {
                    boolean var8C81D2AA4B3CAAC93C1458903A413EAB_271649807 = (log.isDebugEnabled());
                    {
                        log.debug("Total connections kept alive: " + freeConnections.size());
                        log.debug("Total issued connections: " + issuedConnections.size());
                        log.debug("Total allocated connection: " + numConnections + " out of " + maxTotalConnections);
                    } //End block
                } //End collapsed parenthetic
                entry = getFreeEntry(rospl, state);
                boolean hasCapacity;
                hasCapacity = rospl.getCapacity() > 0;
                {
                    boolean var8C81D2AA4B3CAAC93C1458903A413EAB_737724850 = (log.isDebugEnabled());
                    {
                        log.debug("Available capacity: " + rospl.getCapacity() 
                            + " out of " + rospl.getMaxEntries()
                            + " [" + route + "][" + state + "]");
                    } //End block
                } //End collapsed parenthetic
                {
                    entry = createEntry(rospl, operator);
                } //End block
                {
                    boolean varBB9316C6F8FFF645825C6D7CBC27F3F6_429581064 = (hasCapacity && !freeConnections.isEmpty());
                    {
                        deleteLeastUsedEntry();
                        entry = createEntry(rospl, operator);
                    } //End block
                    {
                        {
                            boolean varF1685CB26B0999B3A47E854C01691B8F_2044718293 = (log.isDebugEnabled());
                            {
                                log.debug("Need to wait for connection" +
                                " [" + route + "][" + state + "]");
                            } //End block
                        } //End collapsed parenthetic
                        {
                            waitingThread =
                            newWaitingThread(poolLock.newCondition(), rospl);
                            aborter.setWaitingThread(waitingThread);
                        } //End block
                        boolean success;
                        success = false;
                        try 
                        {
                            rospl.queueThread(waitingThread);
                            waitingThreads.add(waitingThread);
                            success = waitingThread.await(deadline);
                        } //End block
                        finally 
                        {
                            rospl.removeThread(waitingThread);
                            waitingThreads.remove(waitingThread);
                        } //End block
                        {
                            boolean varC77383D433BAB16A958CAA9A5957ED7F_901754639 = (!success && (deadline != null) &&
                        (deadline.getTime() <= System.currentTimeMillis()));
                            {
                                if (DroidSafeAndroidRuntime.control) throw new ConnectionPoolTimeoutException
                            ("Timeout waiting for connection");
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        finally 
        {
            poolLock.unlock();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1000776589 = entry;
        addTaint(route.getTaint());
        addTaint(state.getTaint());
        addTaint(timeout);
        addTaint(tunit.getTaint());
        addTaint(aborter.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1000776589.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1000776589;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.158 -0400", hash_original_method = "459D6C1E2796BA157345E479FDD43BC9", hash_generated_method = "2E5E3968AA2B883D3D2B20E2A3DCE3B2")
    @Override
    public void freeEntry(BasicPoolEntry entry, boolean reusable, long validDuration, TimeUnit timeUnit) {
        HttpRoute route;
        route = entry.getPlannedRoute();
        {
            boolean var983CD6AA124987301747A815A5742497_1251828067 = (log.isDebugEnabled());
            {
                log.debug("Freeing connection" +                                 
                    " [" + route + "][" + entry.getState() + "]");
            } //End block
        } //End collapsed parenthetic
        poolLock.lock();
        try 
        {
            {
                closeConnection(entry.getConnection());
            } //End block
            issuedConnections.remove(entry.getWeakRef());
            RouteSpecificPool rospl;
            rospl = getRoutePool(route, true);
            {
                rospl.freeEntry(entry);
                freeConnections.add(entry);
                idleConnHandler.add(entry.getConnection(), validDuration, timeUnit);
            } //End block
            {
                rospl.dropEntry();
            } //End block
            notifyWaitingThread(rospl);
        } //End block
        finally 
        {
            poolLock.unlock();
        } //End block
        addTaint(entry.getTaint());
        addTaint(reusable);
        addTaint(validDuration);
        addTaint(timeUnit.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.161 -0400", hash_original_method = "962CBFF1A83D816E79E3DF7051655A88", hash_generated_method = "C3EEA923374D9DE8F6FFD2A286FA8B28")
    protected BasicPoolEntry getFreeEntry(RouteSpecificPool rospl, Object state) {
        BasicPoolEntry varB4EAC82CA7396A68D541C85D26508E83_371670408 = null; //Variable for return #1
        BasicPoolEntry entry;
        entry = null;
        poolLock.lock();
        try 
        {
            boolean done;
            done = false;
            {
                entry = rospl.allocEntry(state);
                {
                    {
                        boolean varB5EA13E236059479AA556C9226E19405_1312335075 = (log.isDebugEnabled());
                        {
                            log.debug("Getting free connection" 
                                + " [" + rospl.getRoute() + "][" + state + "]");
                        } //End block
                    } //End collapsed parenthetic
                    freeConnections.remove(entry);
                    boolean valid;
                    valid = idleConnHandler.remove(entry.getConnection());
                    {
                        {
                            boolean varF1685CB26B0999B3A47E854C01691B8F_2062932603 = (log.isDebugEnabled());
                            log.debug("Closing expired free connection"
                                    + " [" + rospl.getRoute() + "][" + state + "]");
                        } //End collapsed parenthetic
                        closeConnection(entry.getConnection());
                        rospl.dropEntry();
                    } //End block
                    {
                        issuedConnections.add(entry.getWeakRef());
                        done = true;
                    } //End block
                } //End block
                {
                    done = true;
                    {
                        boolean varB5EA13E236059479AA556C9226E19405_521462090 = (log.isDebugEnabled());
                        {
                            log.debug("No free connections" 
                                + " [" + rospl.getRoute() + "][" + state + "]");
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End block
        finally 
        {
            poolLock.unlock();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_371670408 = entry;
        addTaint(rospl.getTaint());
        addTaint(state.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_371670408.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_371670408;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.161 -0400", hash_original_method = "97D909B421F8D92376760AF2E5C3347E", hash_generated_method = "8B44B7AF143CBBF6579387F1A935BED3")
    protected BasicPoolEntry createEntry(RouteSpecificPool rospl,
                                         ClientConnectionOperator op) {
        BasicPoolEntry varB4EAC82CA7396A68D541C85D26508E83_946381916 = null; //Variable for return #1
        {
            boolean var983CD6AA124987301747A815A5742497_1318938731 = (log.isDebugEnabled());
            {
                log.debug("Creating new connection [" + rospl.getRoute() + "]");
            } //End block
        } //End collapsed parenthetic
        BasicPoolEntry entry;
        entry = new BasicPoolEntry(op, rospl.getRoute(), refQueue);
        poolLock.lock();
        try 
        {
            rospl.createdEntry(entry);
            issuedConnections.add(entry.getWeakRef());
        } //End block
        finally 
        {
            poolLock.unlock();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_946381916 = entry;
        addTaint(rospl.getTaint());
        addTaint(op.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_946381916.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_946381916;
        // ---------- Original Method ----------
        //if (log.isDebugEnabled()) {
            //log.debug("Creating new connection [" + rospl.getRoute() + "]");
        //}
        //BasicPoolEntry entry =
            //new BasicPoolEntry(op, rospl.getRoute(), refQueue);
        //poolLock.lock();
        //try {
            //rospl.createdEntry(entry);
            //numConnections++;
            //issuedConnections.add(entry.getWeakRef());
        //} finally {
            //poolLock.unlock();
        //}
        //return entry;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.174 -0400", hash_original_method = "D62BEFFDBE1A81D3681FD693CE298CE1", hash_generated_method = "72C8F4817BE2024CEEFCCB7931CBDBB4")
    protected void deleteEntry(BasicPoolEntry entry) {
        HttpRoute route;
        route = entry.getPlannedRoute();
        {
            boolean var983CD6AA124987301747A815A5742497_1700558866 = (log.isDebugEnabled());
            {
                log.debug("Deleting connection" 
                    + " [" + route + "][" + entry.getState() + "]");
            } //End block
        } //End collapsed parenthetic
        poolLock.lock();
        try 
        {
            closeConnection(entry.getConnection());
            RouteSpecificPool rospl;
            rospl = getRoutePool(route, true);
            rospl.deleteEntry(entry);
            {
                boolean var8D810A24394F07D416710B0736FD510C_2042200164 = (rospl.isUnused());
                {
                    routeToPool.remove(route);
                } //End block
            } //End collapsed parenthetic
            idleConnHandler.remove(entry.getConnection());
        } //End block
        finally 
        {
            poolLock.unlock();
        } //End block
        addTaint(entry.getTaint());
        // ---------- Original Method ----------
        //HttpRoute route = entry.getPlannedRoute();
        //if (log.isDebugEnabled()) {
            //log.debug("Deleting connection" 
                    //+ " [" + route + "][" + entry.getState() + "]");
        //}
        //poolLock.lock();
        //try {
            //closeConnection(entry.getConnection());
            //RouteSpecificPool rospl = getRoutePool(route, true);
            //rospl.deleteEntry(entry);
            //numConnections--;
            //if (rospl.isUnused()) {
                //routeToPool.remove(route);
            //}
            //idleConnHandler.remove(entry.getConnection());
        //} finally {
            //poolLock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.175 -0400", hash_original_method = "55BF8FCE42D97AAB2D67412B08D832BA", hash_generated_method = "5F7D7A2D490C4E71297384603C971A4A")
    protected void deleteLeastUsedEntry() {
        try 
        {
            poolLock.lock();
            BasicPoolEntry entry;
            entry = freeConnections.remove();
            {
                deleteEntry(entry);
            } //End block
            {
                boolean varCF6EB300C7D56FAF33A2C36006D8EF42_1439929324 = (log.isDebugEnabled());
                {
                    log.debug("No free connection to delete.");
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            poolLock.unlock();
        } //End block
        // ---------- Original Method ----------
        //try {
            //poolLock.lock();
            //BasicPoolEntry entry = freeConnections.remove();
            //if (entry != null) {
                //deleteEntry(entry);
            //} else if (log.isDebugEnabled()) {
                //log.debug("No free connection to delete.");
            //}
        //} finally {
            //poolLock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.175 -0400", hash_original_method = "DA32210354F9DB856361268717BF05AF", hash_generated_method = "1F58FA54C3B7C053728890B3E9885E4C")
    @Override
    protected void handleLostEntry(HttpRoute route) {
        poolLock.lock();
        try 
        {
            RouteSpecificPool rospl;
            rospl = getRoutePool(route, true);
            rospl.dropEntry();
            {
                boolean var8D810A24394F07D416710B0736FD510C_1217826675 = (rospl.isUnused());
                {
                    routeToPool.remove(route);
                } //End block
            } //End collapsed parenthetic
            notifyWaitingThread(rospl);
        } //End block
        finally 
        {
            poolLock.unlock();
        } //End block
        addTaint(route.getTaint());
        // ---------- Original Method ----------
        //poolLock.lock();
        //try {
            //RouteSpecificPool rospl = getRoutePool(route, true);
            //rospl.dropEntry();
            //if (rospl.isUnused()) {
                //routeToPool.remove(route);
            //}
            //numConnections--;
            //notifyWaitingThread(rospl);
        //} finally {
            //poolLock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.176 -0400", hash_original_method = "31234679312EA392475BCCB545DA6E40", hash_generated_method = "C69331F9847BC4875BC12471332F905A")
    protected void notifyWaitingThread(RouteSpecificPool rospl) {
        WaitingThread waitingThread;
        waitingThread = null;
        poolLock.lock();
        try 
        {
            {
                boolean var13AF0F99B5C721DC0586151E6E94535B_1405762797 = ((rospl != null) && rospl.hasThread());
                {
                    {
                        boolean varB5EA13E236059479AA556C9226E19405_1203761683 = (log.isDebugEnabled());
                        {
                            log.debug("Notifying thread waiting on pool" +
                            " [" + rospl.getRoute() + "]");
                        } //End block
                    } //End collapsed parenthetic
                    waitingThread = rospl.nextThread();
                } //End block
                {
                    boolean var83EDDC38CA2B42006FCFF31DB3DA3393_287574412 = (!waitingThreads.isEmpty());
                    {
                        {
                            boolean varF1685CB26B0999B3A47E854C01691B8F_463651444 = (log.isDebugEnabled());
                            {
                                log.debug("Notifying thread waiting on any pool");
                            } //End block
                        } //End collapsed parenthetic
                        waitingThread = waitingThreads.remove();
                    } //End block
                    {
                        boolean varB5EA13E236059479AA556C9226E19405_1907356955 = (log.isDebugEnabled());
                        {
                            log.debug("Notifying no-one, there are no waiting threads");
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            {
                waitingThread.wakeup();
            } //End block
        } //End block
        finally 
        {
            poolLock.unlock();
        } //End block
        addTaint(rospl.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.176 -0400", hash_original_method = "0A72C49DF2696A5ACE45DBE2BAC53FC3", hash_generated_method = "82AF3401B8AF71AEFAB22251C5211553")
    @Override
    public void deleteClosedConnections() {
        poolLock.lock();
        try 
        {
            Iterator<BasicPoolEntry> iter;
            iter = freeConnections.iterator();
            {
                boolean var8492AE2C695A56B730381A28B8BA3F6D_1155569801 = (iter.hasNext());
                {
                    BasicPoolEntry entry;
                    entry = iter.next();
                    {
                        boolean var950A0EAB3C04D174C02E91857C6308E2_3375294 = (!entry.getConnection().isOpen());
                        {
                            iter.remove();
                            deleteEntry(entry);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            poolLock.unlock();
        } //End block
        // ---------- Original Method ----------
        //poolLock.lock();
        //try {
            //Iterator<BasicPoolEntry>  iter = freeConnections.iterator();
            //while (iter.hasNext()) {
                //BasicPoolEntry entry = iter.next();
                //if (!entry.getConnection().isOpen()) {
                    //iter.remove();
                    //deleteEntry(entry);
                //}
            //}
        //} finally {
            //poolLock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.191 -0400", hash_original_method = "38D5175483A246D837BDBD9602C30A7F", hash_generated_method = "CB122A236055FC0D6E30FAAAEEC35467")
    @Override
    public void shutdown() {
        poolLock.lock();
        try 
        {
            super.shutdown();
            Iterator<BasicPoolEntry> ibpe;
            ibpe = freeConnections.iterator();
            {
                boolean var173117A8B9F49E273F835BF5D96C17AD_488388359 = (ibpe.hasNext());
                {
                    BasicPoolEntry entry;
                    entry = ibpe.next();
                    ibpe.remove();
                    closeConnection(entry.getConnection());
                } //End block
            } //End collapsed parenthetic
            Iterator<WaitingThread> iwth;
            iwth = waitingThreads.iterator();
            {
                boolean var7C47C57BBF30942F9164D5370F6AA67B_1610956658 = (iwth.hasNext());
                {
                    WaitingThread waiter;
                    waiter = iwth.next();
                    iwth.remove();
                    waiter.wakeup();
                } //End block
            } //End collapsed parenthetic
            routeToPool.clear();
        } //End block
        finally 
        {
            poolLock.unlock();
        } //End block
        // ---------- Original Method ----------
        //poolLock.lock();
        //try {
            //super.shutdown();
            //Iterator<BasicPoolEntry> ibpe = freeConnections.iterator();
            //while (ibpe.hasNext()) {
                //BasicPoolEntry entry = ibpe.next();
                //ibpe.remove();
                //closeConnection(entry.getConnection());
            //}
            //Iterator<WaitingThread> iwth = waitingThreads.iterator();
            //while (iwth.hasNext()) {
                //WaitingThread waiter = iwth.next();
                //iwth.remove();
                //waiter.wakeup();
            //}
            //routeToPool.clear();
        //} finally {
            //poolLock.unlock();
        //}
    }

    
}

