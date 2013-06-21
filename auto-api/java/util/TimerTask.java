package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class TimerTask implements Runnable {
    Object lock = new Object();
    boolean cancelled;
    long when;
    long period;
    boolean fixedRate;
    private long scheduledTime;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.857 -0400", hash_original_method = "41AFEAE31E9AFC51442EB32F1B803F09", hash_generated_method = "77D10C16E519E63639DFE51A512851F6")
    @DSModeled(DSC.SAFE)
    protected TimerTask() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.857 -0400", hash_original_method = "61DD03075FF1927377D7CEC2AE97ED1A", hash_generated_method = "59660757F41CD4479FCD4ED1519CE94D")
    @DSModeled(DSC.SAFE)
     long getWhen() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //synchronized (lock) {
            //return when;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.857 -0400", hash_original_method = "AE139E2AB369CB1B1C48D00C62C96DCB", hash_generated_method = "B0F2959845401D9E08B94D5E3ABC92B8")
    @DSModeled(DSC.SAFE)
     void setScheduledTime(long time) {
        dsTaint.addTaint(time);
        // ---------- Original Method ----------
        //synchronized (lock) {
            //scheduledTime = time;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.857 -0400", hash_original_method = "0BC3D740AEEAEAE472C572E03A1906A5", hash_generated_method = "0A2876F5A87751B39A63ED575D07FA1D")
    @DSModeled(DSC.SAFE)
     boolean isScheduled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (lock) {
            //return when > 0 || scheduledTime > 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.858 -0400", hash_original_method = "1700D6DAFB7BC2815E6FE0B3C1768102", hash_generated_method = "D0BAC2E24969A808984D690A847704A2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.858 -0400", hash_original_method = "BAEF9B11043548CD5E25A5F175F23300", hash_generated_method = "53F685224C2FB006200A9DA4A31FCCA3")
    @DSModeled(DSC.SAFE)
    public long scheduledExecutionTime() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //synchronized (lock) {
            //return scheduledTime;
        //}
    }

    
    public abstract void run();

    
}

