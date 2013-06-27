package org.apache.commons.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

class ThreadMonitor implements Runnable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.243 -0400", hash_original_field = "DC127F5D2483352FD20EADDB38FEB6D2", hash_generated_field = "3B3F78C77D023C4AC9933B933AD9AFEC")

    private Thread thread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.244 -0400", hash_original_field = "90272DDA245AE1FB3CF197E91A8689DC", hash_generated_field = "83CDA9988365E91179262582D25947DB")

    private long timeout;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.244 -0400", hash_original_method = "F053058678CE408C06156A1232B98617", hash_generated_method = "2D092E7085083F90CAC0273861B73411")
    private  ThreadMonitor(Thread thread, long timeout) {
        this.thread = thread;
        this.timeout = timeout;
        // ---------- Original Method ----------
        //this.thread = thread;
        //this.timeout = timeout;
    }

    
        public static Thread start(long timeout) {
        return start(Thread.currentThread(), timeout);
    }

    
        public static Thread start(Thread thread, long timeout) {
        Thread monitor = null;
        if (timeout > 0) {
            ThreadMonitor timout = new ThreadMonitor(thread, timeout);
            monitor = new Thread(timout, ThreadMonitor.class.getSimpleName());
            monitor.setDaemon(true);
            monitor.start();
        }
        return monitor;
    }

    
        public static void stop(Thread thread) {
        if (thread != null) {
            thread.interrupt();
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.245 -0400", hash_original_method = "D59462ADF236F9BB2B2797E094BBD843", hash_generated_method = "1E4993D1F2279D7FB29288AE002D34FB")
    public void run() {
        try 
        {
            Thread.sleep(timeout);
            thread.interrupt();
        } //End block
        catch (InterruptedException e)
        { }
        // ---------- Original Method ----------
        //try {
            //Thread.sleep(timeout);
            //thread.interrupt();
        //} catch (InterruptedException e) {
        //}
    }

    
}

