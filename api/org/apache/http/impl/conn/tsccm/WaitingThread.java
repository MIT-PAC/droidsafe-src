package org.apache.http.impl.conn.tsccm;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Date;
import java.util.concurrent.locks.Condition;






public class WaitingThread {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.495 -0400", hash_original_field = "26542FB18A8B14C9775AA475F23C909F", hash_generated_field = "E7E85605CD9DCB175BB641FD2FDA33A7")

    private Condition cond;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.495 -0400", hash_original_field = "B10A8C0BEDE9EB4EA771B04DB3149F28", hash_generated_field = "E21679471610B2B7ED2D35D85B755050")

    private RouteSpecificPool pool;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.495 -0400", hash_original_field = "F64CFF138020A2060A9817272F563B3C", hash_generated_field = "33CCD5EB6905F134ACE39F8BADCDC158")

    private Thread waiter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.496 -0400", hash_original_field = "DFB7069BFC6E0064A6C667626ECA07B4", hash_generated_field = "7C8E769DDEE22768B70313CCC815CA01")

    private boolean aborted;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.497 -0400", hash_original_method = "4E0FEF0D8484D6DA3DA82AB98780B168", hash_generated_method = "BD9DFDB50E96F614876252FDFCF5362E")
    public  WaitingThread(Condition cond, RouteSpecificPool pool) {
        if(cond == null)        
        {
            IllegalArgumentException var34D4FBFEC6ED6866DA5BDDE44FD11CF2_1789360857 = new IllegalArgumentException("Condition must not be null.");
            var34D4FBFEC6ED6866DA5BDDE44FD11CF2_1789360857.addTaint(taint);
            throw var34D4FBFEC6ED6866DA5BDDE44FD11CF2_1789360857;
        } //End block
        this.cond = cond;
        this.pool = pool;
        // ---------- Original Method ----------
        //if (cond == null) {
            //throw new IllegalArgumentException("Condition must not be null.");
        //}
        //this.cond = cond;
        //this.pool = pool;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.498 -0400", hash_original_method = "06148A18B01DA630C8E9D1BE56535730", hash_generated_method = "7C298436A208FB7C1EA84C48779AED06")
    public final Condition getCondition() {
Condition var8E3679EF6AFF44D2ADE75707730E246F_952510130 =         this.cond;
        var8E3679EF6AFF44D2ADE75707730E246F_952510130.addTaint(taint);
        return var8E3679EF6AFF44D2ADE75707730E246F_952510130;
        // ---------- Original Method ----------
        //return this.cond;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.498 -0400", hash_original_method = "7ACEF95834A46E1067A2FCD807704A00", hash_generated_method = "CCAA026FC26C458AA459F6DABC61F4B5")
    public final RouteSpecificPool getPool() {
RouteSpecificPool var3D7A8FEF66EC1D1D80E6ECD3302B47BC_111884384 =         this.pool;
        var3D7A8FEF66EC1D1D80E6ECD3302B47BC_111884384.addTaint(taint);
        return var3D7A8FEF66EC1D1D80E6ECD3302B47BC_111884384;
        // ---------- Original Method ----------
        //return this.pool;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.499 -0400", hash_original_method = "71CC45999E743AA15F11389550D41BFD", hash_generated_method = "9C69197045411E42839FAC71CA909F2D")
    public final Thread getThread() {
Thread var760B1EA155F5CA2BBA827AEB44D8EA68_282244282 =         this.waiter;
        var760B1EA155F5CA2BBA827AEB44D8EA68_282244282.addTaint(taint);
        return var760B1EA155F5CA2BBA827AEB44D8EA68_282244282;
        // ---------- Original Method ----------
        //return this.waiter;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.502 -0400", hash_original_method = "7B6DA174509B07DB7E171D838B6C3551", hash_generated_method = "4EE06FD4F867CAA9991ABA9C8829311B")
    public boolean await(Date deadline) throws InterruptedException {
        addTaint(deadline.getTaint());
        if(this.waiter != null)        
        {
            IllegalStateException varCE7AD081C18F30A16317EA83A08A4371_869727605 = new IllegalStateException
                ("A thread is already waiting on this object." +
                 "\ncaller: " + Thread.currentThread() +
                 "\nwaiter: " + this.waiter);
            varCE7AD081C18F30A16317EA83A08A4371_869727605.addTaint(taint);
            throw varCE7AD081C18F30A16317EA83A08A4371_869727605;
        } //End block
        if(aborted)        
        {
        InterruptedException var7EE922E5DCB3F92D72C13AFC121FC801_2080137034 = new InterruptedException("Operation interrupted");
        var7EE922E5DCB3F92D72C13AFC121FC801_2080137034.addTaint(taint);
        throw var7EE922E5DCB3F92D72C13AFC121FC801_2080137034;
        }
        this.waiter = Thread.currentThread();
        boolean success = false;
        try 
        {
            if(deadline != null)            
            {
                success = this.cond.awaitUntil(deadline);
            } //End block
            else
            {
                this.cond.await();
                success = true;
            } //End block
            if(aborted)            
            {
            InterruptedException var7EE922E5DCB3F92D72C13AFC121FC801_1911152172 = new InterruptedException("Operation interrupted");
            var7EE922E5DCB3F92D72C13AFC121FC801_1911152172.addTaint(taint);
            throw var7EE922E5DCB3F92D72C13AFC121FC801_1911152172;
            }
        } //End block
        finally 
        {
            this.waiter = null;
        } //End block
        boolean var260CA9DD8A4577FC00B7BD5810298076_297256408 = (success);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_868009963 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_868009963;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.503 -0400", hash_original_method = "BAB31B5D41D1F7BEE0FF6A7B649DDB38", hash_generated_method = "6E0027649F8839C336ED2ACB7C15CD06")
    public void wakeup() {
        if(this.waiter == null)        
        {
            IllegalStateException var734AD850447D0A571E2A31F53594F3FC_1564958973 = new IllegalStateException
                ("Nobody waiting on this object.");
            var734AD850447D0A571E2A31F53594F3FC_1564958973.addTaint(taint);
            throw var734AD850447D0A571E2A31F53594F3FC_1564958973;
        } //End block
        this.cond.signalAll();
        // ---------- Original Method ----------
        //if (this.waiter == null) {
            //throw new IllegalStateException
                //("Nobody waiting on this object.");
        //}
        //this.cond.signalAll();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.504 -0400", hash_original_method = "BFE3F8B3CBA9A24F2514C6FAB517057D", hash_generated_method = "A5EA451F6D91CB4B8E0C2D7D002E7ED2")
    public void interrupt() {
        aborted = true;
        this.cond.signalAll();
        // ---------- Original Method ----------
        //aborted = true;
        //this.cond.signalAll();
    }

    
}

