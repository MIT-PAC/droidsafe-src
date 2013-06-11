package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public abstract class TimerTask implements Runnable {
    final Object lock = new Object();
    boolean cancelled;
    long when;
    long period;
    boolean fixedRate;
    private long scheduledTime;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.196 -0400", hash_original_method = "41AFEAE31E9AFC51442EB32F1B803F09", hash_generated_method = "A5E31C09BA1EB4605DAFC965C97B3580")
    @DSModeled(DSC.SAFE)
    protected TimerTask() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.196 -0400", hash_original_method = "61DD03075FF1927377D7CEC2AE97ED1A", hash_generated_method = "D12CE277B8BE6ED762789D845E808CA0")
    @DSModeled(DSC.SAFE)
     long getWhen() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //synchronized (lock) {
            //return when;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.196 -0400", hash_original_method = "AE139E2AB369CB1B1C48D00C62C96DCB", hash_generated_method = "229827CCB8EDE003D9723F6143290797")
    @DSModeled(DSC.SAFE)
     void setScheduledTime(long time) {
        dsTaint.addTaint(time);
        // ---------- Original Method ----------
        //synchronized (lock) {
            //scheduledTime = time;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.196 -0400", hash_original_method = "0BC3D740AEEAEAE472C572E03A1906A5", hash_generated_method = "A0F16CC88CC7FD25760C81F06A616728")
    @DSModeled(DSC.SAFE)
     boolean isScheduled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (lock) {
            //return when > 0 || scheduledTime > 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.196 -0400", hash_original_method = "1700D6DAFB7BC2815E6FE0B3C1768102", hash_generated_method = "858F80A74242EB8A56FD01D9DA3D7B6F")
    @DSModeled(DSC.SAFE)
    public boolean cancel() {
        {
            boolean willRun;
            willRun = !cancelled && when > 0;
            cancelled = true;
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (lock) {
            //boolean willRun = !cancelled && when > 0;
            //cancelled = true;
            //return willRun;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.196 -0400", hash_original_method = "BAEF9B11043548CD5E25A5F175F23300", hash_generated_method = "BCDCE9D387A83252354ED3944DF1FC66")
    @DSModeled(DSC.SAFE)
    public long scheduledExecutionTime() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //synchronized (lock) {
            //return scheduledTime;
        //}
    }

    
    public abstract void run();

    
}


