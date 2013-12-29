package gov.nist.core;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;






public class ThreadAuditor {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:12.394 -0500", hash_original_field = "C0954453DE9443D825381060F57A509D", hash_generated_field = "A00A12B2B5536306E22F7FB7287ECF23")

    private Map<Thread,ThreadHandle> threadHandles = new HashMap<Thread,ThreadHandle>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:12.395 -0500", hash_original_field = "1A9598317B4645FD7F8072A4F686DA17", hash_generated_field = "8666B6F6E2B3566873DE3F0C843D61F9")

    private long pingIntervalInMillisecs = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.755 -0400", hash_original_method = "46343C8CADBF1D5ED7A34C5D2358E7DA", hash_generated_method = "46343C8CADBF1D5ED7A34C5D2358E7DA")
    public ThreadAuditor ()
    {
        //Synthesized constructor
    }

    /// Indicates how often monitored threads are supposed to ping (0 = no thread monitoring)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:12.407 -0500", hash_original_method = "E626588797C11F0AE30EE2336DDF5DDE", hash_generated_method = "325A7BDCD5A9E1DB33EDC3E2D130E002")
    public long getPingIntervalInMillisecs() {
        return pingIntervalInMillisecs;
    }

    /// Defines how often monitored threads are supposed to ping
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:12.407 -0500", hash_original_method = "7A7DF1118EDC7A81CF310DAEDEA2CA24", hash_generated_method = "46ECF13295FCB3EE3932456287538819")
    public void setPingIntervalInMillisecs(long value) {
        pingIntervalInMillisecs = value;
    }

    /// Indicates if the auditing of threads is enabled
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:12.408 -0500", hash_original_method = "3383EC0356978E6A8A0873AB5EB0F6B5", hash_generated_method = "9783E6D77EFA94B7C226D48E26D742BC")
    public boolean isEnabled() {
        return (pingIntervalInMillisecs > 0);
    }

    /// Called by a thread that wants to be monitored
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:12.409 -0500", hash_original_method = "E669DE9122CCA9B4713223F08741F9E6", hash_generated_method = "6D717BDFED7BCB288F8AE8D65A106332")
    public synchronized ThreadHandle addCurrentThread() {
        // Create and return a thread handle but only add it
        // to the list of monitored threads if the auditor is enabled
        ThreadHandle threadHandle = new ThreadHandle(this);
        if (isEnabled()) {
            threadHandles.put(Thread.currentThread(), threadHandle);
        }
        return threadHandle;
    }

    /// Stops monitoring a given thread
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:12.410 -0500", hash_original_method = "6C8F2FE0AC3A02915C2D70AD5F0F3037", hash_generated_method = "55982BC2AB481FC3E04B5647A4256301")
    public synchronized void removeThread(Thread thread) {
        threadHandles.remove(thread);
    }

    /// Called by a monitored thread reporting that it's alive and well
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:12.411 -0500", hash_original_method = "BB4C09A88190125090DD9FF91A5AB1C4", hash_generated_method = "310B624B9883B5206688617BA91FD1AB")
    public synchronized void ping(ThreadHandle threadHandle) {
        threadHandle.setThreadActive(true);
    }

    /// Resets the auditor
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:12.411 -0500", hash_original_method = "E964CDFC4A03877954EFAFA10E2DC29D", hash_generated_method = "E2FF4588CEA4889BD68FCC3692CBB5F8")
    public synchronized void reset() {
        threadHandles.clear();
    }

    /**
     * Audits the sanity of all threads
     *
     * @return An audit report string (multiple lines), or null if all is well
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:12.412 -0500", hash_original_method = "A466F08B2826217F8F5011AA1A7379A2", hash_generated_method = "EE38FC579D3F4C6D892C94DABF909DD5")
    public synchronized String auditThreads() {
        String auditReport = null;
        // Map stackTraces = null;

        // Scan all monitored threads looking for non-responsive ones
        Iterator<ThreadHandle> it = threadHandles.values().iterator();
        while (it.hasNext()) {
            ThreadHandle threadHandle = (ThreadHandle) it.next();
            if (!threadHandle.isThreadActive()) {
                // Get the non-responsive thread
                Thread thread = threadHandle.getThread();

                // Update the audit report
                if (auditReport == null) {
                    auditReport = "Thread Auditor Report:\n";
                }
                auditReport += "   Thread [" + thread.getName() + "] has failed to respond to an audit request.\n";

                /*
                 * Stack traces are not available with JDK 1.4.
                 * Feel free to uncomment this block to get a better report if you're using JDK 1.5.
                 */
                //  // Get stack traces for all live threads (do this only once per audit)
                //  if (stackTraces == null) {
                //      stackTraces = Thread.getAllStackTraces();
                //  }
                //
                //  // Get the stack trace for the non-responsive thread
                //  StackTraceElement[] stackTraceElements = (StackTraceElement[])stackTraces.get(thread);
                //  if (stackTraceElements != null && stackTraceElements.length > 0) {
                //      auditReport += "      Stack trace:\n";
                //
                //      for (int i = 0; i < stackTraceElements.length ; i ++ ) {
                //          StackTraceElement stackTraceElement = stackTraceElements[i];
                //          auditReport += "         " + stackTraceElement.toString() + "\n";
                //      }
                //  } else {
                //      auditReport += "      Stack trace is not available.\n";
                //  }
            }

            // Reset the ping status of the thread
            threadHandle.setThreadActive(false);
        }
        return auditReport;
    }

    /**
     * Returns a string representation of the object
     *
     * @return a string representation of the object
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:12.413 -0500", hash_original_method = "6675CF6A116AB121851289F1BA88A8F3", hash_generated_method = "38400F3F6112D3DE73B892A67C6ECDE2")
    public synchronized String toString() {
        String toString = "Thread Auditor - List of monitored threads:\n";
        Iterator<ThreadHandle> it = threadHandles.values().iterator();
        while ( it.hasNext()) {
            ThreadHandle threadHandle = (ThreadHandle)it.next();
            toString += "   " + threadHandle.toString() + "\n";
        }
        return toString;
    }

    
    public class ThreadHandle {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:12.396 -0500", hash_original_field = "70806230BDAC98ABA704C6088D7869BC", hash_generated_field = "4D9544D57A3ABD008438B9DAA58E4AF5")

        private boolean isThreadActive;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:12.397 -0500", hash_original_field = "AB87C4F6E5547EBD7483F34732EA576D", hash_generated_field = "3B3F78C77D023C4AC9933B933AD9AFEC")

        private Thread thread;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:12.398 -0500", hash_original_field = "7593F62FA1C58ED4FC3A743FA55F4C35", hash_generated_field = "997328D506876FA38420B35187A6D56F")

        private ThreadAuditor threadAuditor;

        /// Constructor
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:12.399 -0500", hash_original_method = "40C494E087A9AB3654ECCCB79F809CD9", hash_generated_method = "DE94129241E219AFBD37DACA8BD1D3CE")
        public ThreadHandle(ThreadAuditor aThreadAuditor) {
            isThreadActive = false;
            thread = Thread.currentThread();
            threadAuditor = aThreadAuditor;
        }

        /// Called by the auditor thread to check the ping status of the thread
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:12.400 -0500", hash_original_method = "7C169FF6005EF7125A62D6FC1B2750B7", hash_generated_method = "2ACB5C51D1F7CEB1B7E2904E75673A65")
        public boolean isThreadActive() {
            return isThreadActive;
        }

        /// Called by the auditor thread to reset the ping status of the thread
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:12.401 -0500", hash_original_method = "88A3AB81179102C8D04CED6A81B233E5", hash_generated_method = "EDEB71C9E8696E8D29517B7D20F7A503")
        protected void setThreadActive(boolean value) {
            isThreadActive = value;
        }

        /// Return the thread being monitored
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:12.402 -0500", hash_original_method = "F8B0A54928E7ECAC7F4DBC7FBE8E98A4", hash_generated_method = "78BA0CB0A6EA66A4E6AF70FE95A6D126")
        public Thread getThread() {
            return thread;
        }

        // Helper function to allow threads to ping using this handle
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:12.403 -0500", hash_original_method = "6040EE7F290925ABE22D0B8E78C0C92D", hash_generated_method = "A7DBC252C76F23B690C252DA2B20A411")
        public void ping() {
            threadAuditor.ping(this);
        }

        // Helper function to allow threads to get the ping interval directly from this handle
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:12.403 -0500", hash_original_method = "3E3AA41CAE680C9493787FE6AF60A593", hash_generated_method = "794D0F3E134A5E5E8EE2425424D11A73")
        public long getPingIntervalInMillisecs() {
            return threadAuditor.getPingIntervalInMillisecs();
        }

        /**
         * Returns a string representation of the object
         *
         * @return a string representation of the object
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:12.405 -0500", hash_original_method = "433F66024AB5F11DDEF8BAC7248248B0", hash_generated_method = "909BCDEC255E3C10659E5129D1CB9A5B")
        public String toString() {
            StringBuffer toString = new StringBuffer()
                    .append("Thread Name: ").append(thread.getName())
                    .append(", Alive: ").append(thread.isAlive());
            return toString.toString();
        }

        
    }


    
}

