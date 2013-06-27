package org.apache.http.impl.conn.tsccm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class WaitingThreadAborter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.146 -0400", hash_original_field = "BD94CA2DD62250633E81D56743BB8F43", hash_generated_field = "C79D835D74C6AC2AE8A11E51B7EFA777")

    private WaitingThread waitingThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.146 -0400", hash_original_field = "DFB7069BFC6E0064A6C667626ECA07B4", hash_generated_field = "7C8E769DDEE22768B70313CCC815CA01")

    private boolean aborted;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.146 -0400", hash_original_method = "41E9B73CB6D6B9988302B233DF5A4C64", hash_generated_method = "41E9B73CB6D6B9988302B233DF5A4C64")
    public WaitingThreadAborter ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.146 -0400", hash_original_method = "27CF8733634F3CF20401DD1AFEAA91BD", hash_generated_method = "C610490FDACB4748EF3CD51AB05EF810")
    public void abort() {
        aborted = true;
        waitingThread.interrupt();
        // ---------- Original Method ----------
        //aborted = true;
        //if (waitingThread != null)
            //waitingThread.interrupt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.147 -0400", hash_original_method = "BEF4BF67B8CAA8FFE4DAC439C25D6987", hash_generated_method = "3515289F9B4B3E806895F6787774C485")
    public void setWaitingThread(WaitingThread waitingThread) {
        this.waitingThread = waitingThread;
        waitingThread.interrupt();
        // ---------- Original Method ----------
        //this.waitingThread = waitingThread;
        //if (aborted)
            //waitingThread.interrupt();
    }

    
}

