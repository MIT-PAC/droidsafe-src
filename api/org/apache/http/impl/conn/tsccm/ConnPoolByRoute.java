package org.apache.http.impl.conn.tsccm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRoute;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.params.HttpParams;




public class ConnPoolByRoute extends AbstractConnPool {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.595 -0500", hash_original_field = "0DA7E40E862C937570CA6B0D96D2555A", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

        
    private final Log log = LogFactory.getLog(getClass());
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.596 -0500", hash_original_field = "5ECDF9140F933CD067B24AED705BDC40", hash_generated_field = "026614D17D2D565C77517B2D71C2A557")

    protected  ClientConnectionOperator operator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.597 -0500", hash_original_field = "517E1AF3F20473F418CDD5D509A852FD", hash_generated_field = "E964A63E9B82E3DD4DC47C59FAE8DE45")

    protected Queue<BasicPoolEntry> freeConnections;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.597 -0500", hash_original_field = "BDF0A61E4197385E0D2E24DFD51B36B8", hash_generated_field = "E267A7FAC4E8E5B414A36EEBC5A1B7B4")

    protected Queue<WaitingThread> waitingThreads;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.598 -0500", hash_original_field = "FBF07056504D45C56ED67579F5AABB78", hash_generated_field = "CC1DA54842268F916A1617EAB82AA607")

    protected  Map<HttpRoute, RouteSpecificPool> routeToPool;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.599 -0500", hash_original_field = "9593BFDFA77F7CEC9E2DEF7153A8A474", hash_generated_field = "72497F1614BF1540B1D26A1572D9E5CA")


    protected  int maxTotalConnections;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.600 -0500", hash_original_field = "4F999BC70044645838F3F4E2114A0BFC", hash_generated_field = "9E9F031DEF0505CA4E19FEFFE7AAAD7E")

    
    private  ConnPerRoute connPerRoute;
    
    /**
     * Creates a new connection pool, managed by route.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.601 -0500", hash_original_method = "66E0A8FBF49ECB21297BEFDE183D53F0", hash_generated_method = "6FAF55943B44526C037FBE5D40EDF4C6")
    public ConnPoolByRoute(final ClientConnectionOperator operator, final HttpParams params) {
        super();
        if (operator == null) {
            throw new IllegalArgumentException("Connection operator may not be null");
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


    /**
     * Creates the queue for {@link #freeConnections}.
     * Called once by the constructor.
     *
     * @return  a queue
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.601 -0500", hash_original_method = "5727338124A1E72B6395110A48913E3E", hash_generated_method = "8336F85EC4456F5E84A7B4216D92B008")
    protected Queue<BasicPoolEntry> createFreeConnQueue() {
        return new LinkedList<BasicPoolEntry>();
    }

    /**
     * Creates the queue for {@link #waitingThreads}.
     * Called once by the constructor.
     *
     * @return  a queue
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.602 -0500", hash_original_method = "6DAD2F123996401C30A0886A4B729895", hash_generated_method = "C303012397C1CFEC345256FC35AB2A22")
    protected Queue<WaitingThread> createWaitingThreadQueue() {
        return new LinkedList<WaitingThread>();
    }

    /**
     * Creates the map for {@link #routeToPool}.
     * Called once by the constructor.
     *
     * @return  a map
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.603 -0500", hash_original_method = "2238A516ECCEA4A16F09E10B17DA5B4C", hash_generated_method = "3A4D0585B195E0B08364B295F1ABF353")
    protected Map<HttpRoute, RouteSpecificPool> createRouteToPoolMap() {
        return new HashMap<HttpRoute, RouteSpecificPool>();
    }


    /**
     * Creates a new route-specific pool.
     * Called by {@link #getRoutePool} when necessary.
     *
     * @param route     the route
     *
     * @return  the new pool
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.604 -0500", hash_original_method = "5DDB8B45F189660D50400B7C32F12F31", hash_generated_method = "6592B93F88A363C7E41FBD1C5A6C9416")
    protected RouteSpecificPool newRouteSpecificPool(HttpRoute route) {
        return new RouteSpecificPool(route, connPerRoute.getMaxForRoute(route));
    }


    /**
     * Creates a new waiting thread.
     * Called by {@link #getRoutePool} when necessary.
     *
     * @param cond      the condition to wait for
     * @param rospl     the route specific pool, or <code>null</code>
     *
     * @return  a waiting thread representation
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.605 -0500", hash_original_method = "92724E0FC2C28E5538F8325CDCFB2338", hash_generated_method = "65784DF194E2AC5D199AF672A4193A2F")
    protected WaitingThread newWaitingThread(Condition cond,
                                             RouteSpecificPool rospl) {
        return new WaitingThread(cond, rospl);
    }


    /**
     * Get a route-specific pool of available connections.
     *
     * @param route   the route
     * @param create    whether to create the pool if it doesn't exist
     *
     * @return  the pool for the argument route,
     *     never <code>null</code> if <code>create</code> is <code>true</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.606 -0500", hash_original_method = "2DA0D144EE94C06AE8D1ED191B4BB0F6", hash_generated_method = "B25413AC7ABE939B0C0783C46AFD556E")
    protected RouteSpecificPool getRoutePool(HttpRoute route,
                                             boolean create) {
        RouteSpecificPool rospl = null;
        poolLock.lock();
        try {

            rospl = routeToPool.get(route);
            if ((rospl == null) && create) {
                // no pool for this route yet (or anymore)
                rospl = newRouteSpecificPool(route);
                routeToPool.put(route, rospl);
            }

        } finally {
            poolLock.unlock();
        }

        return rospl;
    }


    //@@@ consider alternatives for gathering statistics
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.606 -0500", hash_original_method = "BC602BD8B10C5776DF65F2D8A63D167D", hash_generated_method = "1F8CB93833AC002F19CB03C0E120A93D")
    public int getConnectionsInPool(HttpRoute route) {

        poolLock.lock();
        try {
            // don't allow a pool to be created here!
            RouteSpecificPool rospl = getRoutePool(route, false);
            return (rospl != null) ? rospl.getEntryCount() : 0;

        } finally {
            poolLock.unlock();
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.609 -0500", hash_original_method = "E2BAF1ACE5FFF01DCEE8A821FE8A73A0", hash_generated_method = "BC642E2C466CF994C6A5B39EE8582DA1")
    @Override
public PoolEntryRequest requestPoolEntry(
            final HttpRoute route,
            final Object state) {
        
        final WaitingThreadAborter aborter = new WaitingThreadAborter();
        
        return new PoolEntryRequest() {
        
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
    }

    /**
     * Obtains a pool entry with a connection within the given timeout.
     * If a {@link WaitingThread} is used to block, {@link WaitingThreadAborter#setWaitingThread(WaitingThread)}
     * must be called before blocking, to allow the thread to be interrupted.
     *
     * @param route     the route for which to get the connection
     * @param timeout   the timeout, 0 or negative for no timeout
     * @param tunit     the unit for the <code>timeout</code>,
     *                  may be <code>null</code> only if there is no timeout
     * @param aborter   an object which can abort a {@link WaitingThread}.
     *
     * @return  pool entry holding a connection for the route
     *
     * @throws ConnectionPoolTimeoutException
     *         if the timeout expired
     * @throws InterruptedException
     *         if the calling thread was interrupted
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.611 -0500", hash_original_method = "0255BF16791796767BBFE4AD753EF26D", hash_generated_method = "42AE41691B0A6F52ED435ADF2A60DA17")
    protected BasicPoolEntry getEntryBlocking(
                                   HttpRoute route, Object state,
                                   long timeout, TimeUnit tunit,
                                   WaitingThreadAborter aborter)
        throws ConnectionPoolTimeoutException, InterruptedException {

        Date deadline = null;
        if (timeout > 0) {
            deadline = new Date
                (System.currentTimeMillis() + tunit.toMillis(timeout));
        }

        BasicPoolEntry entry = null;
        poolLock.lock();
        try {

            RouteSpecificPool rospl = getRoutePool(route, true);
            WaitingThread waitingThread = null;

            while (entry == null) {

                if (isShutDown) {
                    throw new IllegalStateException
                        ("Connection pool shut down.");
                }

                if (log.isDebugEnabled()) {
                    log.debug("Total connections kept alive: " + freeConnections.size()); 
                    log.debug("Total issued connections: " + issuedConnections.size()); 
                    log.debug("Total allocated connection: " + numConnections + " out of " + maxTotalConnections);
                }
                
                // the cases to check for:
                // - have a free connection for that route
                // - allowed to create a free connection for that route
                // - can delete and replace a free connection for another route
                // - need to wait for one of the things above to come true

                entry = getFreeEntry(rospl, state);
                if (entry != null) {
                    break;
                }
                
                boolean hasCapacity = rospl.getCapacity() > 0; 
                
                if (log.isDebugEnabled()) {
                    log.debug("Available capacity: " + rospl.getCapacity() 
                            + " out of " + rospl.getMaxEntries()
                            + " [" + route + "][" + state + "]");
                }
                
                if (hasCapacity && numConnections < maxTotalConnections) {

                    entry = createEntry(rospl, operator);

                } else if (hasCapacity && !freeConnections.isEmpty()) {

                    deleteLeastUsedEntry();
                    entry = createEntry(rospl, operator);

                } else {

                    if (log.isDebugEnabled()) {
                        log.debug("Need to wait for connection" +
                                " [" + route + "][" + state + "]");
                    }

                    if (waitingThread == null) {
                        waitingThread =
                            newWaitingThread(poolLock.newCondition(), rospl);
                        aborter.setWaitingThread(waitingThread);
                    }

                    boolean success = false;
                    try {
                        rospl.queueThread(waitingThread);
                        waitingThreads.add(waitingThread);
                        success = waitingThread.await(deadline);

                    } finally {
                        // In case of 'success', we were woken up by the
                        // connection pool and should now have a connection
                        // waiting for us, or else we're shutting down.
                        // Just continue in the loop, both cases are checked.
                        rospl.removeThread(waitingThread);
                        waitingThreads.remove(waitingThread);
                    }

                    // check for spurious wakeup vs. timeout
                    if (!success && (deadline != null) &&
                        (deadline.getTime() <= System.currentTimeMillis())) {
                        throw new ConnectionPoolTimeoutException
                            ("Timeout waiting for connection");
                    }
                }
            } // while no entry

        } finally {
            poolLock.unlock();
        }

        return entry;

    } // getEntry


    // non-javadoc, see base class AbstractConnPool
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.612 -0500", hash_original_method = "459D6C1E2796BA157345E479FDD43BC9", hash_generated_method = "A0C57248EFBB8ED1117CA62640C63DEE")
    @Override
public void freeEntry(BasicPoolEntry entry, boolean reusable, long validDuration, TimeUnit timeUnit) {

        HttpRoute route = entry.getPlannedRoute();
        if (log.isDebugEnabled()) {
            log.debug("Freeing connection" +                                 
                    " [" + route + "][" + entry.getState() + "]");
        }

        poolLock.lock();
        try {
            if (isShutDown) {
                // the pool is shut down, release the
                // connection's resources and get out of here
                closeConnection(entry.getConnection());
                return;
            }

            // no longer issued, we keep a hard reference now
            issuedConnections.remove(entry.getWeakRef());

            RouteSpecificPool rospl = getRoutePool(route, true);

            if (reusable) {
                rospl.freeEntry(entry);
                freeConnections.add(entry);
                idleConnHandler.add(entry.getConnection(), validDuration, timeUnit);
            } else {
                rospl.dropEntry();
                numConnections--;
            }

            notifyWaitingThread(rospl);

        } finally {
            poolLock.unlock();
        }

    } // freeEntry



    /**
     * If available, get a free pool entry for a route.
     *
     * @param rospl       the route-specific pool from which to get an entry
     *
     * @return  an available pool entry for the given route, or
     *          <code>null</code> if none is available
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.613 -0500", hash_original_method = "962CBFF1A83D816E79E3DF7051655A88", hash_generated_method = "4C168A3B7F5D96148AAB429AAB5A5A94")
    protected BasicPoolEntry getFreeEntry(RouteSpecificPool rospl, Object state) {

        BasicPoolEntry entry = null;
        poolLock.lock();
        try {
            boolean done = false;
            while(!done) {

                entry = rospl.allocEntry(state);
    
                if (entry != null) {
                    if (log.isDebugEnabled()) {
                        log.debug("Getting free connection" 
                                + " [" + rospl.getRoute() + "][" + state + "]");
    
                    }
                    freeConnections.remove(entry);
                    boolean valid = idleConnHandler.remove(entry.getConnection());
                    if(!valid) {
                        // If the free entry isn't valid anymore, get rid of it
                        // and loop to find another one that might be valid.
                        if(log.isDebugEnabled())
                            log.debug("Closing expired free connection"
                                    + " [" + rospl.getRoute() + "][" + state + "]");
                        closeConnection(entry.getConnection());
                        // We use dropEntry instead of deleteEntry because the entry
                        // is no longer "free" (we just allocated it), and deleteEntry
                        // can only be used to delete free entries.
                        rospl.dropEntry();
                        numConnections--;
                    } else {
                        issuedConnections.add(entry.getWeakRef());
                        done = true;
                    }
    
                } else {
                    done = true;
                    if (log.isDebugEnabled()) {
                        log.debug("No free connections" 
                                + " [" + rospl.getRoute() + "][" + state + "]");
                    }
                }
            }
        } finally {
            poolLock.unlock();
        }

        return entry;
    }


    /**
     * Creates a new pool entry.
     * This method assumes that the new connection will be handed
     * out immediately.
     *
     * @param rospl       the route-specific pool for which to create the entry
     * @param op        the operator for creating a connection
     *
     * @return  the new pool entry for a new connection
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.614 -0500", hash_original_method = "97D909B421F8D92376760AF2E5C3347E", hash_generated_method = "75335BCEFB3A3540B523AEC1175349E1")
    protected BasicPoolEntry createEntry(RouteSpecificPool rospl,
                                         ClientConnectionOperator op) {

        if (log.isDebugEnabled()) {
            log.debug("Creating new connection [" + rospl.getRoute() + "]");
        }

        // the entry will create the connection when needed
        BasicPoolEntry entry =
            new BasicPoolEntry(op, rospl.getRoute(), refQueue);

        poolLock.lock();
        try {

            rospl.createdEntry(entry);
            numConnections++;

            issuedConnections.add(entry.getWeakRef());

        } finally {
            poolLock.unlock();
        }

        return entry;
    }

        
    /**
     * Deletes a given pool entry.
     * This closes the pooled connection and removes all references,
     * so that it can be GCed.
     * 
     * <p><b>Note:</b> Does not remove the entry from the freeConnections list.
     * It is assumed that the caller has already handled this step.</p>
     * <!-- @@@ is that a good idea? or rather fix it? -->
     * 
     * @param entry         the pool entry for the connection to delete
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.615 -0500", hash_original_method = "D62BEFFDBE1A81D3681FD693CE298CE1", hash_generated_method = "DE69742049282C79EB47EDF398873D01")
    protected void deleteEntry(BasicPoolEntry entry) {

        HttpRoute route = entry.getPlannedRoute();

        if (log.isDebugEnabled()) {
            log.debug("Deleting connection" 
                    + " [" + route + "][" + entry.getState() + "]");
        }

        poolLock.lock();
        try {

            closeConnection(entry.getConnection());

            RouteSpecificPool rospl = getRoutePool(route, true);
            rospl.deleteEntry(entry);
            numConnections--;
            if (rospl.isUnused()) {
                routeToPool.remove(route);
            }

            idleConnHandler.remove(entry.getConnection());// not idle, but dead

        } finally {
            poolLock.unlock();
        }
    }


    /**
     * Delete an old, free pool entry to make room for a new one.
     * Used to replace pool entries with ones for a different route.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.616 -0500", hash_original_method = "55BF8FCE42D97AAB2D67412B08D832BA", hash_generated_method = "632817AFA767493BA72EC19BBB90A656")
    protected void deleteLeastUsedEntry() {

        try {
            poolLock.lock();

            //@@@ with get() instead of remove, we could
            //@@@ leave the removing to deleteEntry()
            BasicPoolEntry entry = freeConnections.remove();

            if (entry != null) {
                deleteEntry(entry);
            } else if (log.isDebugEnabled()) {
                log.debug("No free connection to delete.");
            }

        } finally {
            poolLock.unlock();
        }
    }


    // non-javadoc, see base class AbstractConnPool
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.617 -0500", hash_original_method = "DA32210354F9DB856361268717BF05AF", hash_generated_method = "3C6C7543468A7B5C7B2199850FCEAB03")
    @Override
protected void handleLostEntry(HttpRoute route) {

        poolLock.lock();
        try {

            RouteSpecificPool rospl = getRoutePool(route, true);
            rospl.dropEntry();
            if (rospl.isUnused()) {
                routeToPool.remove(route);
            }

            numConnections--;
            notifyWaitingThread(rospl);

        } finally {
            poolLock.unlock();
        }
    }


    /**
     * Notifies a waiting thread that a connection is available.
     * This will wake a thread waiting in the specific route pool,
     * if there is one.
     * Otherwise, a thread in the connection pool will be notified.
     * 
     * @param rospl     the pool in which to notify, or <code>null</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.618 -0500", hash_original_method = "31234679312EA392475BCCB545DA6E40", hash_generated_method = "3B04045FA1A9995CA2B6266B7957485C")
    protected void notifyWaitingThread(RouteSpecificPool rospl) {

        //@@@ while this strategy provides for best connection re-use,
        //@@@ is it fair? only do this if the connection is open?
        // Find the thread we are going to notify. We want to ensure that
        // each waiting thread is only interrupted once, so we will remove
        // it from all wait queues before interrupting.
        WaitingThread waitingThread = null;

        poolLock.lock();
        try {

            if ((rospl != null) && rospl.hasThread()) {
                if (log.isDebugEnabled()) {
                    log.debug("Notifying thread waiting on pool" +
                            " [" + rospl.getRoute() + "]");
                }
                waitingThread = rospl.nextThread();
            } else if (!waitingThreads.isEmpty()) {
                if (log.isDebugEnabled()) {
                    log.debug("Notifying thread waiting on any pool");
                }
                waitingThread = waitingThreads.remove();
            } else if (log.isDebugEnabled()) {
                log.debug("Notifying no-one, there are no waiting threads");
            }

            if (waitingThread != null) {
                waitingThread.wakeup();
            }

        } finally {
            poolLock.unlock();
        }
    }


    //@@@ revise this cleanup stuff
    //@@@ move method to base class when deleteEntry() is fixed
    // non-javadoc, see base class AbstractConnPool
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.619 -0500", hash_original_method = "0A72C49DF2696A5ACE45DBE2BAC53FC3", hash_generated_method = "D89F88E44A7129FBD75F19970B372D36")
    @Override
public void deleteClosedConnections() {

        poolLock.lock();
        try {

            Iterator<BasicPoolEntry>  iter = freeConnections.iterator();
            while (iter.hasNext()) {
                BasicPoolEntry entry = iter.next();
                if (!entry.getConnection().isOpen()) {
                    iter.remove();
                    deleteEntry(entry);
                }
            }

        } finally {
            poolLock.unlock();
        }
    }


    // non-javadoc, see base class AbstractConnPool
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:19.620 -0500", hash_original_method = "38D5175483A246D837BDBD9602C30A7F", hash_generated_method = "AA4704DDF720BECB14BF1C3FD1807862")
    @Override
public void shutdown() {

        poolLock.lock();
        try {

            super.shutdown();

            // close all free connections
            //@@@ move this to base class?
            Iterator<BasicPoolEntry> ibpe = freeConnections.iterator();
            while (ibpe.hasNext()) {
                BasicPoolEntry entry = ibpe.next();
                ibpe.remove();
                closeConnection(entry.getConnection());
            }

            // wake up all waiting threads
            Iterator<WaitingThread> iwth = waitingThreads.iterator();
            while (iwth.hasNext()) {
                WaitingThread waiter = iwth.next();
                iwth.remove();
                waiter.wakeup();
            }

            routeToPool.clear();

        } finally {
            poolLock.unlock();
        }
    }

    
}

