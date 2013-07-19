package org.apache.http.impl.conn.tsccm;

// Droidsafe Imports
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public class RefQueueWorker implements Runnable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.421 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.421 -0400", hash_original_field = "B82FB46AF129A517A66F7204F172DDA9", hash_generated_field = "40049CCA20E99139643BCB7890F78F90")

    protected ReferenceQueue<?> refQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.421 -0400", hash_original_field = "EC3D083E9EB758561E8C0FEFA6782F05", hash_generated_field = "7ABFD2CF4B63269B45DD287A5590324B")

    protected RefQueueHandler refHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.421 -0400", hash_original_field = "34A11ABDA68ED9AF26BEFBF2D01C2C93", hash_generated_field = "AD9424F71A9D950798ECA942D1D55E60")

    protected volatile Thread workerThread;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.422 -0400", hash_original_method = "7CE59BC66C958C608E20B1EEC430162A", hash_generated_method = "01EFCABA3ABC5AAE24CD200EDFA1D16B")
    public  RefQueueWorker(ReferenceQueue<?> queue, RefQueueHandler handler) {
        if(queue == null)        
        {
            IllegalArgumentException var92597C0BB4D3D87F2ECE27274D53EE76_614373096 = new IllegalArgumentException("Queue must not be null.");
            var92597C0BB4D3D87F2ECE27274D53EE76_614373096.addTaint(taint);
            throw var92597C0BB4D3D87F2ECE27274D53EE76_614373096;
        } //End block
        if(handler == null)        
        {
            IllegalArgumentException varBECFD90EE60267CC6E41D35E31D56037_739041531 = new IllegalArgumentException("Handler must not be null.");
            varBECFD90EE60267CC6E41D35E31D56037_739041531.addTaint(taint);
            throw varBECFD90EE60267CC6E41D35E31D56037_739041531;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.423 -0400", hash_original_method = "068901515EDCF67E719CCEED21C02CEA", hash_generated_method = "CE5EE7A85CCFB98120CDD87D88B7EBAF")
    public void run() {
        if(this.workerThread == null)        
        {
            this.workerThread = Thread.currentThread();
        } //End block
        while
(this.workerThread == Thread.currentThread())        
        {
            try 
            {
                Reference<?> ref = refQueue.remove();
                refHandler.handleReference(ref);
            } //End block
            catch (InterruptedException e)
            {
                if(log.isDebugEnabled())                
                {
                    log.debug(this.toString() + " interrupted", e);
                } //End block
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.424 -0400", hash_original_method = "4BBB4A6394E78355577BCA1899518AA3", hash_generated_method = "744BF52BC6D7A2884848DEF85B1B3249")
    public void shutdown() {
        Thread wt = this.workerThread;
        if(wt != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.424 -0400", hash_original_method = "7EB957F4647F2E9AB09EE1A296B7BEEF", hash_generated_method = "32A0C35C5A827075E0BED2F078302335")
    @Override
    public String toString() {
String varF97D1EB4E7BB2414B750B467C6942FFE_623497443 =         "RefQueueWorker::" + this.workerThread;
        varF97D1EB4E7BB2414B750B467C6942FFE_623497443.addTaint(taint);
        return varF97D1EB4E7BB2414B750B467C6942FFE_623497443;
        // ---------- Original Method ----------
        //return "RefQueueWorker::" + this.workerThread;
    }

    
}

