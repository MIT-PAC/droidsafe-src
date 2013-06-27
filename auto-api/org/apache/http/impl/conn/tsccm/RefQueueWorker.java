package org.apache.http.impl.conn.tsccm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RefQueueWorker implements Runnable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.952 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "4E4E630304492253CB8147CAE1C7D2A5")

    private Log log = LogFactory.getLog(getClass());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.952 -0400", hash_original_field = "B82FB46AF129A517A66F7204F172DDA9", hash_generated_field = "40049CCA20E99139643BCB7890F78F90")

    protected ReferenceQueue<?> refQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.953 -0400", hash_original_field = "EC3D083E9EB758561E8C0FEFA6782F05", hash_generated_field = "7ABFD2CF4B63269B45DD287A5590324B")

    protected RefQueueHandler refHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.953 -0400", hash_original_field = "34A11ABDA68ED9AF26BEFBF2D01C2C93", hash_generated_field = "AD9424F71A9D950798ECA942D1D55E60")

    protected volatile Thread workerThread;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.964 -0400", hash_original_method = "7CE59BC66C958C608E20B1EEC430162A", hash_generated_method = "A423FF98FC62F0BBBE4FCD6D81CDB6D2")
    public  RefQueueWorker(ReferenceQueue<?> queue, RefQueueHandler handler) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Queue must not be null.");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Handler must not be null.");
        } //End block
        refQueue   = queue;
        refHandler = handler;
        // ---------- Original Method ----------
        //if (queue == null) {
            //throw new IllegalArgumentException("Queue must not be null.");
        //}
        //if (handler == null) {
            //throw new IllegalArgumentException("Handler must not be null.");
        //}
        //refQueue   = queue;
        //refHandler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.974 -0400", hash_original_method = "068901515EDCF67E719CCEED21C02CEA", hash_generated_method = "98E56B87EB812BB58FBAF476D8C4C10C")
    public void run() {
        {
            this.workerThread = Thread.currentThread();
        } //End block
        {
            boolean varE14712F15E5CA00C0DB87D4DDAAE505C_2068748126 = (this.workerThread == Thread.currentThread());
            {
                try 
                {
                    Reference<?> ref;
                    ref = refQueue.remove();
                    refHandler.handleReference(ref);
                } //End block
                catch (InterruptedException e)
                {
                    {
                        boolean varB5EA13E236059479AA556C9226E19405_1773676871 = (log.isDebugEnabled());
                        {
                            log.debug(this.toString() + " interrupted", e);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (this.workerThread == null) {
            //this.workerThread = Thread.currentThread();
        //}
        //while (this.workerThread == Thread.currentThread()) {
            //try {
                //Reference<?> ref = refQueue.remove();
                //refHandler.handleReference(ref);
            //} catch (InterruptedException e) {
                //if (log.isDebugEnabled()) {
                    //log.debug(this.toString() + " interrupted", e);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.975 -0400", hash_original_method = "4BBB4A6394E78355577BCA1899518AA3", hash_generated_method = "EA455C1EE8CD135BF372307EDBA99C2D")
    public void shutdown() {
        Thread wt;
        wt = this.workerThread;
        {
            this.workerThread = null;
            wt.interrupt();
        } //End block
        // ---------- Original Method ----------
        //Thread wt = this.workerThread;
        //if (wt != null) {
            //this.workerThread = null; 
            //wt.interrupt();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.975 -0400", hash_original_method = "7EB957F4647F2E9AB09EE1A296B7BEEF", hash_generated_method = "129A57693B6E57991C8664DE941C78EE")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_462538788 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_462538788 = "RefQueueWorker::" + this.workerThread;
        varB4EAC82CA7396A68D541C85D26508E83_462538788.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_462538788;
        // ---------- Original Method ----------
        //return "RefQueueWorker::" + this.workerThread;
    }

    
}

