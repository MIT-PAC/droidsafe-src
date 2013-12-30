package org.apache.http.impl.conn.tsccm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Date;
import java.util.concurrent.locks.Condition;






public class WaitingThread {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.520 -0500", hash_original_field = "DD3B07F50A4277E065FDFFC919E9FDDB", hash_generated_field = "E7E85605CD9DCB175BB641FD2FDA33A7")

    private  Condition cond;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.523 -0500", hash_original_field = "9002D6F36A50032691C79DB8C1414AE5", hash_generated_field = "4F597DD21DBF7DD08DD945195741315F")

    //@@@ replace with generic pool interface
    private  RouteSpecificPool pool;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.525 -0500", hash_original_field = "4DB9CE87B9CCE3428476BDB51EBE9EF1", hash_generated_field = "33CCD5EB6905F134ACE39F8BADCDC158")

    private Thread waiter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.527 -0500", hash_original_field = "D257EA6B1465C401242DE11DC61376AA", hash_generated_field = "7C8E769DDEE22768B70313CCC815CA01")

    private boolean aborted;


    /**
     * Creates a new entry for a waiting thread.
     *
     * @param cond      the condition for which to wait
     * @param pool      the pool on which the thread will be waiting,
     *                  or <code>null</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.530 -0500", hash_original_method = "4E0FEF0D8484D6DA3DA82AB98780B168", hash_generated_method = "AD84B0CDF4AF9E51E405E56F720A791E")
    
public WaitingThread(Condition cond, RouteSpecificPool pool) {

        if (cond == null) {
            throw new IllegalArgumentException("Condition must not be null.");
        }

        this.cond = cond;
        this.pool = pool;
    }


    /**
     * Obtains the condition.
     *
     * @return  the condition on which to wait, never <code>null</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.532 -0500", hash_original_method = "06148A18B01DA630C8E9D1BE56535730", hash_generated_method = "4F4AE62136D5CFFE877E5BE8F3488E56")
    
public final Condition getCondition() {
        // not synchronized
        return this.cond;
    }


    /**
     * Obtains the pool, if there is one.
     *
     * @return  the pool on which a thread is or was waiting,
     *          or <code>null</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.534 -0500", hash_original_method = "7ACEF95834A46E1067A2FCD807704A00", hash_generated_method = "C35E32D5D68307FC752F688479E534D1")
    
public final RouteSpecificPool getPool() {
        // not synchronized
        return this.pool;
    }


    /**
     * Obtains the thread, if there is one.
     *
     * @return  the thread which is waiting, or <code>null</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.536 -0500", hash_original_method = "71CC45999E743AA15F11389550D41BFD", hash_generated_method = "CB85D10A1FD8B2013E04262B36A14664")
    
public final Thread getThread() {
        // not synchronized
        return this.waiter;
    }


    /**
     * Blocks the calling thread.
     * This method returns when the thread is notified or interrupted,
     * if a timeout occurrs, or if there is a spurious wakeup.
     * <br/>
     * This method assumes external synchronization.
     *
     * @param deadline  when to time out, or <code>null</code> for no timeout
     *
     * @return  <code>true</code> if the condition was satisfied,
     *          <code>false</code> in case of a timeout.
     *          Typically, a call to {@link #wakeup} is used to indicate
     *          that the condition was satisfied. Since the condition is
     *          accessible outside, this cannot be guaranteed though.
     *
     * @throws InterruptedException     if the waiting thread was interrupted
     *
     * @see #wakeup
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.540 -0500", hash_original_method = "7B6DA174509B07DB7E171D838B6C3551", hash_generated_method = "3132B8E88CA8F5E6038CA366225F4B87")
    
public boolean await(Date deadline)
        throws InterruptedException {

        // This is only a sanity check. We cannot synchronize here,
        // the lock would not be released on calling cond.await() below.
        if (this.waiter != null) {
            throw new IllegalStateException
                ("A thread is already waiting on this object." +
                 "\ncaller: " + Thread.currentThread() +
                 "\nwaiter: " + this.waiter);
        }

        if (aborted)
            throw new InterruptedException("Operation interrupted");
        
        this.waiter = Thread.currentThread();

        boolean success = false;
        try {
            if (deadline != null) {
                success = this.cond.awaitUntil(deadline);
            } else {
                this.cond.await();
                success = true;
            }
            if (aborted)
                throw new InterruptedException("Operation interrupted");
        } finally {
            this.waiter = null;
        }
        return success;

    } // await


    /**
     * Wakes up the waiting thread.
     * <br/>
     * This method assumes external synchronization.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.542 -0500", hash_original_method = "BAB31B5D41D1F7BEE0FF6A7B649DDB38", hash_generated_method = "C9A60E4F7AC3C08B42FE428C72B41A85")
    
public void wakeup() {

        // If external synchronization and pooling works properly,
        // this cannot happen. Just a sanity check.
        if (this.waiter == null) {
            throw new IllegalStateException
                ("Nobody waiting on this object.");
        }

        // One condition might be shared by several WaitingThread instances.
        // It probably isn't, but just in case: wake all, not just one.
        this.cond.signalAll();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.544 -0500", hash_original_method = "BFE3F8B3CBA9A24F2514C6FAB517057D", hash_generated_method = "EBD5A7B5A967E1082278D6C7AC0C58BD")
    
public void interrupt() {
        aborted = true;
        this.cond.signalAll();
    }

    
}

