package org.apache.http.impl.conn.tsccm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RefQueueWorker implements Runnable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.753 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.753 -0400", hash_original_field = "B82FB46AF129A517A66F7204F172DDA9", hash_generated_field = "40049CCA20E99139643BCB7890F78F90")

    protected ReferenceQueue<?> refQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.753 -0400", hash_original_field = "EC3D083E9EB758561E8C0FEFA6782F05", hash_generated_field = "7ABFD2CF4B63269B45DD287A5590324B")

    protected RefQueueHandler refHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.753 -0400", hash_original_field = "34A11ABDA68ED9AF26BEFBF2D01C2C93", hash_generated_field = "AD9424F71A9D950798ECA942D1D55E60")

    protected volatile Thread workerThread;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.754 -0400", hash_original_method = "7CE59BC66C958C608E20B1EEC430162A", hash_generated_method = "A423FF98FC62F0BBBE4FCD6D81CDB6D2")
    public  RefQueueWorker(ReferenceQueue<?> queue, RefQueueHandler handler) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Queue must not be null.");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Handler must not be null.");
        } 
        refQueue   = queue;
        refHandler = handler;
        
        
            
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.754 -0400", hash_original_method = "068901515EDCF67E719CCEED21C02CEA", hash_generated_method = "566F05C855126D90B6F6C81BF0F30F25")
    public void run() {
        {
            this.workerThread = Thread.currentThread();
        } 
        {
            boolean varE14712F15E5CA00C0DB87D4DDAAE505C_550056354 = (this.workerThread == Thread.currentThread());
            {
                try 
                {
                    Reference<?> ref = refQueue.remove();
                    refHandler.handleReference(ref);
                } 
                catch (InterruptedException e)
                {
                    {
                        boolean varB5EA13E236059479AA556C9226E19405_1783955369 = (log.isDebugEnabled());
                        {
                            log.debug(this.toString() + " interrupted", e);
                        } 
                    } 
                } 
            } 
        } 
        
        
            
        
        
            
                
                
            
                
                    
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.755 -0400", hash_original_method = "4BBB4A6394E78355577BCA1899518AA3", hash_generated_method = "DA735DF86B79FF9748E537A0C86BBAFC")
    public void shutdown() {
        Thread wt = this.workerThread;
        {
            this.workerThread = null;
            wt.interrupt();
        } 
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.755 -0400", hash_original_method = "7EB957F4647F2E9AB09EE1A296B7BEEF", hash_generated_method = "0B11938F10572A470CCB3E8113F58F5B")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1188174140 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1188174140 = "RefQueueWorker::" + this.workerThread;
        varB4EAC82CA7396A68D541C85D26508E83_1188174140.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1188174140;
        
        
    }

    
}

