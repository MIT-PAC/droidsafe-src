package java.lang.ref;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ReferenceQueue<T> {
    private Reference<? extends T> head;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.733 -0400", hash_original_method = "74975F7A6AFB5E81CCF3457B53FB8A14", hash_generated_method = "77FCC81AFA085C6B3B372539AC2D673F")
    @DSModeled(DSC.SAFE)
    public ReferenceQueue() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.734 -0400", hash_original_method = "0715328D7F7BB9D5550B9E381C496C43", hash_generated_method = "EABC5AD9174C8C270D7668ADBD71C0C4")
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked")
    public synchronized Reference<? extends T> poll() {
        Reference<? extends T> ret;
        ret = head;
        {
            head = null;
        } //End block
        {
            head = head.queueNext;
        } //End block
        ret.queueNext = null;
        return (Reference<? extends T>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (head == null) {
            //return null;
        //}
        //Reference<? extends T> ret;
        //ret = head;
        //if (head == head.queueNext) {
            //head = null;
        //} else {
            //head = head.queueNext;
        //}
        //ret.queueNext = null;
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.734 -0400", hash_original_method = "B9994ACC80E0363C78DC4EB28757C058", hash_generated_method = "01C823DBB23736500EE59304B932E691")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Reference<? extends T> remove() throws InterruptedException {
        Reference<? extends T> varF9FC58DE49803451ADACA548EB3F7110_1426647437 = (remove(0L));
        return (Reference<? extends T>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return remove(0L);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.734 -0400", hash_original_method = "55CFE9AF663FFFA3410902143F42A33C", hash_generated_method = "6C6240CA61EB3B255910E74ECE4152C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized Reference<? extends T> remove(long timeoutMillis) throws InterruptedException {
        dsTaint.addTaint(timeoutMillis);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("timeout < 0: " + timeoutMillis);
        } //End block
        {
            Reference<? extends T> var2F0A11953DF6A22DE51C1F54E46EB922_1972619626 = (poll());
        } //End block
        {
            {
                wait(0);
            } //End block
            Reference<? extends T> var2F0A11953DF6A22DE51C1F54E46EB922_1637868234 = (poll());
        } //End block
        long nanosToWait;
        nanosToWait = timeoutMillis * NANOS_PER_MILLI;
        int timeoutNanos;
        timeoutNanos = 0;
        long startTime;
        startTime = System.nanoTime();
        {
            wait(timeoutMillis, timeoutNanos);
            long nanosElapsed;
            nanosElapsed = System.nanoTime() - startTime;
            long nanosRemaining;
            nanosRemaining = nanosToWait - nanosElapsed;
            timeoutMillis = nanosRemaining / NANOS_PER_MILLI;
            timeoutNanos = (int) (nanosRemaining - timeoutMillis * NANOS_PER_MILLI);
        } //End block
        Reference<? extends T> var995A5D9E921766343C049452777D2C7C_310030713 = (poll());
        return (Reference<? extends T>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.735 -0400", hash_original_method = "A43A8FC0DB505099966EA05BCA8E1BC7", hash_generated_method = "3164E1BA175A8E719395FFACDAD80FC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void enqueue(Reference<? extends T> reference) {
        dsTaint.addTaint(reference.dsTaint);
        {
            reference.queueNext = reference;
        } //End block
        {
            reference.queueNext = head;
        } //End block
        notify();
        // ---------- Original Method ----------
        //if (head == null) {
            //reference.queueNext = reference;
        //} else {
            //reference.queueNext = head;
        //}
        //head = reference;
        //notify();
    }

    
        static void add(Reference<?> list) {
        synchronized (ReferenceQueue.class) {
            if (unenqueued == null) {
                unenqueued = list;
            } else {
                Reference<?> next = unenqueued.pendingNext;
                unenqueued.pendingNext = list.pendingNext;
                list.pendingNext = next;
            }
            ReferenceQueue.class.notifyAll();
        }
    }

    
    private static final int NANOS_PER_MILLI = 1000000;
    public static Reference unenqueued = null;
}

