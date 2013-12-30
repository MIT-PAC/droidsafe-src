package java.lang.ref;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class ReferenceQueue<T> {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.018 -0500", hash_original_method = "6AE174B13F8683C0991DE48985C31F5E", hash_generated_method = "C186A2B079869A9ED3CD9461C13B023C")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.996 -0500", hash_original_field = "5FC7F9392DE523EE635F94A39030F4C7", hash_generated_field = "E32D593DEDB2FDC7FE0DFB7474352DBA")

    private static final int NANOS_PER_MILLI = 1000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.016 -0500", hash_original_field = "F3E0C99DAB358B3F255926C262A7F1DB", hash_generated_field = "4ECF0535730E811CDF8F487B61B191FD")

    public static Reference unenqueued = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.000 -0500", hash_original_field = "FA1343295FE0A11162E42F3395980C0A", hash_generated_field = "0D4E357872E15A12A6822EA05A1FF146")


    private Reference<? extends T> head;

    /**
     * Constructs a new instance of this class.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.003 -0500", hash_original_method = "74975F7A6AFB5E81CCF3457B53FB8A14", hash_generated_method = "76CCCA88EDF0B80C204E0A2802C9ECAD")
    
public ReferenceQueue() {
    }

    /**
     * Returns the next available reference from the queue, removing it in the
     * process. Does not wait for a reference to become available.
     *
     * @return the next available reference, or {@code null} if no reference is
     *         immediately available
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.006 -0500", hash_original_method = "0715328D7F7BB9D5550B9E381C496C43", hash_generated_method = "790B23600F4BF572A29424D925C154B4")
    
@SuppressWarnings("unchecked")
    public synchronized Reference<? extends T> poll() {
        if (head == null) {
            return null;
        }

        Reference<? extends T> ret;

        ret = head;

        if (head == head.queueNext) {
            head = null;
        } else {
            head = head.queueNext;
        }

        ret.queueNext = null;

        return ret;
    }

    /**
     * Returns the next available reference from the queue, removing it in the
     * process. Waits indefinitely for a reference to become available.
     *
     * @throws InterruptedException if the blocking call was interrupted
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.008 -0500", hash_original_method = "B9994ACC80E0363C78DC4EB28757C058", hash_generated_method = "D72AAED57CA4C191874CD040ABE06C73")
    
public Reference<? extends T> remove() throws InterruptedException {
        return remove(0L);
    }

    /**
     * Returns the next available reference from the queue, removing it in the
     * process. Waits for a reference to become available or the given timeout
     * period to elapse, whichever happens first.
     *
     * @param timeoutMillis maximum time to spend waiting for a reference object
     *     to become available. A value of {@code 0} results in the method
     *     waiting indefinitely.
     * @return the next available reference, or {@code null} if no reference
     *     becomes available within the timeout period
     * @throws IllegalArgumentException if {@code timeoutMillis < 0}.
     * @throws InterruptedException if the blocking call was interrupted
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.011 -0500", hash_original_method = "55CFE9AF663FFFA3410902143F42A33C", hash_generated_method = "EDA90A27A7B84BE384B1B9B462023515")
    
public synchronized Reference<? extends T> remove(long timeoutMillis)
            throws InterruptedException {
        if (timeoutMillis < 0) {
            throw new IllegalArgumentException("timeout < 0: " + timeoutMillis);
        }

        if (head != null) {
            return poll();
        }

        // avoid overflow: if total > 292 years, just wait forever
        if (timeoutMillis == 0 || (timeoutMillis > Long.MAX_VALUE / NANOS_PER_MILLI)) {
            do {
                wait(0);
            } while (head == null);
            return poll();
        }

        // guaranteed to not overflow
        long nanosToWait = timeoutMillis * NANOS_PER_MILLI;
        int timeoutNanos = 0;

        // wait until notified or the timeout has elapsed
        long startTime = System.nanoTime();
        while (true) {
            wait(timeoutMillis, timeoutNanos);
            if (head != null) {
                break;
            }
            long nanosElapsed = System.nanoTime() - startTime;
            long nanosRemaining = nanosToWait - nanosElapsed;
            if (nanosRemaining <= 0) {
                break;
            }
            timeoutMillis = nanosRemaining / NANOS_PER_MILLI;
            timeoutNanos = (int) (nanosRemaining - timeoutMillis * NANOS_PER_MILLI);
        }
        return poll();
    }

    /**
     * Enqueue the reference object on the receiver.
     *
     * @param reference
     *            reference object to be enqueued.
     * @return boolean true if reference is enqueued. false if reference failed
     *         to enqueue.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.014 -0500", hash_original_method = "A43A8FC0DB505099966EA05BCA8E1BC7", hash_generated_method = "0371090DC73679EC93E57AEC0836198E")
    
synchronized void enqueue(Reference<? extends T> reference) {
        if (head == null) {
            reference.queueNext = reference;
        } else {
            reference.queueNext = head;
        }
        head = reference;
        notify();
    }
}

