package org.apache.http.impl.conn.tsccm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class WaitingThreadAborter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.190 -0400", hash_original_field = "BD94CA2DD62250633E81D56743BB8F43", hash_generated_field = "C79D835D74C6AC2AE8A11E51B7EFA777")

    private WaitingThread waitingThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.190 -0400", hash_original_field = "DFB7069BFC6E0064A6C667626ECA07B4", hash_generated_field = "7C8E769DDEE22768B70313CCC815CA01")

    private boolean aborted;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.190 -0400", hash_original_method = "41E9B73CB6D6B9988302B233DF5A4C64", hash_generated_method = "41E9B73CB6D6B9988302B233DF5A4C64")
    public WaitingThreadAborter ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.191 -0400", hash_original_method = "27CF8733634F3CF20401DD1AFEAA91BD", hash_generated_method = "CEC22C4B3505739F30026513C6F8E7A8")
    public void abort() {
        aborted = true;
    if(waitingThread != null)        
        waitingThread.interrupt();
        // ---------- Original Method ----------
        //aborted = true;
        //if (waitingThread != null)
            //waitingThread.interrupt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.191 -0400", hash_original_method = "BEF4BF67B8CAA8FFE4DAC439C25D6987", hash_generated_method = "C5CE5879075AEFB8B494E1944799BBF9")
    public void setWaitingThread(WaitingThread waitingThread) {
        this.waitingThread = waitingThread;
    if(aborted)        
        waitingThread.interrupt();
        // ---------- Original Method ----------
        //this.waitingThread = waitingThread;
        //if (aborted)
            //waitingThread.interrupt();
    }

    
}

