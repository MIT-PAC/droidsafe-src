package org.apache.http.impl.conn.tsccm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class WaitingThreadAborter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.342 -0500", hash_original_field = "F1A0AC4A2E7C774F3DAB11506EBBCA82", hash_generated_field = "C79D835D74C6AC2AE8A11E51B7EFA777")

    
    private WaitingThread waitingThread;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.344 -0500", hash_original_field = "D257EA6B1465C401242DE11DC61376AA", hash_generated_field = "7C8E769DDEE22768B70313CCC815CA01")

    private boolean aborted;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.510 -0400", hash_original_method = "41E9B73CB6D6B9988302B233DF5A4C64", hash_generated_method = "41E9B73CB6D6B9988302B233DF5A4C64")
    public WaitingThreadAborter ()
    {
        //Synthesized constructor
    }
    
    /**
     * If a waiting thread has been set, interrupts it.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.346 -0500", hash_original_method = "27CF8733634F3CF20401DD1AFEAA91BD", hash_generated_method = "2BA036273BDA7B336FEB03EC4E817398")
    
public void abort() {
        aborted = true;
        
        if (waitingThread != null)
            waitingThread.interrupt();
        
    }
    
    /**
     * Sets the waiting thread.  If this has already been aborted,
     * the waiting thread is immediately interrupted.
     * 
     * @param waitingThread The thread to interrupt when aborting.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.349 -0500", hash_original_method = "BEF4BF67B8CAA8FFE4DAC439C25D6987", hash_generated_method = "C403637F10DB97F52E9C5FCC4872655C")
    
public void setWaitingThread(WaitingThread waitingThread) {
        this.waitingThread = waitingThread;
        if (aborted)
            waitingThread.interrupt();
    }

    
}

