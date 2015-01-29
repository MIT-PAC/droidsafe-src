package org.apache.http.impl.conn.tsccm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RefQueueWorker implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.624 -0500", hash_original_field = "0DA7E40E862C937570CA6B0D96D2555A", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.626 -0500", hash_original_field = "AF3F1BF62DD67A6204D4B99C3928DDE7", hash_generated_field = "40049CCA20E99139643BCB7890F78F90")

    protected  ReferenceQueue<?> refQueue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.628 -0500", hash_original_field = "C4D17D8E20F898203F5288742532355E", hash_generated_field = "7ABFD2CF4B63269B45DD287A5590324B")

    protected  RefQueueHandler refHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.631 -0500", hash_original_field = "E9FF103FC0FAC4762B85597770D9D323", hash_generated_field = "AD9424F71A9D950798ECA942D1D55E60")

    protected volatile Thread workerThread;

    /**
     * Instantiates a new worker to listen for lost connections.
     *
     * @param queue     the queue on which to wait for references
     * @param handler   the handler to pass the references to
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.633 -0500", hash_original_method = "7CE59BC66C958C608E20B1EEC430162A", hash_generated_method = "CA85AE20212AFCDAED1E94900A261A2A")
    
public RefQueueWorker(ReferenceQueue<?> queue, RefQueueHandler handler) {
        if (queue == null) {
            throw new IllegalArgumentException("Queue must not be null.");
        }
        if (handler == null) {
            throw new IllegalArgumentException("Handler must not be null.");
        }

        refQueue   = queue;
        refHandler = handler;
    }

    /**
     * The main loop of this worker.
     * If initialization succeeds, this method will only return
     * after {@link #shutdown shutdown()}. Only one thread can
     * execute the main loop at any time.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.635 -0500", hash_original_method = "068901515EDCF67E719CCEED21C02CEA", hash_generated_method = "3D8D6E0C0D5DD7B4890A87101CA0C31F")
    
public void run() {

        if (this.workerThread == null) {
            this.workerThread = Thread.currentThread();
        }

        while (this.workerThread == Thread.currentThread()) {
            try {
                // remove the next reference and process it
                Reference<?> ref = refQueue.remove();
                refHandler.handleReference(ref);
            } catch (InterruptedException e) {
                //@@@ is logging really necessary? this here is the
                //@@@ only reason for having a log in this class
                if (log.isDebugEnabled()) {
                    log.debug(this.toString() + " interrupted", e);
                }
            }
        }
    }

    /**
     * Shuts down this worker.
     * It can be re-started afterwards by another call to {@link #run run()}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.637 -0500", hash_original_method = "4BBB4A6394E78355577BCA1899518AA3", hash_generated_method = "6CE48C3E51E997E0D335B5113DBA95F1")
    
public void shutdown() {
        Thread wt = this.workerThread;
        if (wt != null) {
            this.workerThread = null; // indicate shutdown
            wt.interrupt();
        }
    }

    /**
     * Obtains a description of this worker.
     *
     * @return  a descriptive string for this worker
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.640 -0500", hash_original_method = "7EB957F4647F2E9AB09EE1A296B7BEEF", hash_generated_method = "4C820E660A2767B76BC387A5AB9B43EE")
    
@Override
    public String toString() {
        return "RefQueueWorker::" + this.workerThread;
    }
    
}

