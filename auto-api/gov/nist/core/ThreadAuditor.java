package gov.nist.core;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.*;

public class ThreadAuditor {
    private Map<Thread,ThreadHandle> threadHandles = new HashMap<Thread,ThreadHandle>();
    private long pingIntervalInMillisecs = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.785 -0400", hash_original_method = "B99652BE208BCED386BE2147266842B7", hash_generated_method = "B99652BE208BCED386BE2147266842B7")
        public ThreadAuditor ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.785 -0400", hash_original_method = "E626588797C11F0AE30EE2336DDF5DDE", hash_generated_method = "4D274A3F3DB0831F8DDCA94843E8A887")
    @DSModeled(DSC.SAFE)
    public long getPingIntervalInMillisecs() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return pingIntervalInMillisecs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.785 -0400", hash_original_method = "7A7DF1118EDC7A81CF310DAEDEA2CA24", hash_generated_method = "657CB59C7CD339CC3DFC003306024C7B")
    @DSModeled(DSC.SAFE)
    public void setPingIntervalInMillisecs(long value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //pingIntervalInMillisecs = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.786 -0400", hash_original_method = "3383EC0356978E6A8A0873AB5EB0F6B5", hash_generated_method = "2DF3E0B18C5FB4F8635711CD1356AF2A")
    @DSModeled(DSC.SAFE)
    public boolean isEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (pingIntervalInMillisecs > 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.786 -0400", hash_original_method = "E669DE9122CCA9B4713223F08741F9E6", hash_generated_method = "9CCEAE35CFD9654572A5AE26942ED515")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized ThreadHandle addCurrentThread() {
        ThreadHandle threadHandle;
        threadHandle = new ThreadHandle(this);
        {
            boolean var7DF3FD71A82DB900422A2663707EECDE_2091384284 = (isEnabled());
            {
                threadHandles.put(Thread.currentThread(), threadHandle);
            } //End block
        } //End collapsed parenthetic
        return (ThreadHandle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ThreadHandle threadHandle = new ThreadHandle(this);
        //if (isEnabled()) {
            //threadHandles.put(Thread.currentThread(), threadHandle);
        //}
        //return threadHandle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.786 -0400", hash_original_method = "6C8F2FE0AC3A02915C2D70AD5F0F3037", hash_generated_method = "B8110CB97F280347E697BB7340515C49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void removeThread(Thread thread) {
        dsTaint.addTaint(thread.dsTaint);
        threadHandles.remove(thread);
        // ---------- Original Method ----------
        //threadHandles.remove(thread);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.786 -0400", hash_original_method = "BB4C09A88190125090DD9FF91A5AB1C4", hash_generated_method = "661000569A59F2FAE3BE67C6B86B85A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void ping(ThreadHandle threadHandle) {
        dsTaint.addTaint(threadHandle.dsTaint);
        threadHandle.setThreadActive(true);
        // ---------- Original Method ----------
        //threadHandle.setThreadActive(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.787 -0400", hash_original_method = "E964CDFC4A03877954EFAFA10E2DC29D", hash_generated_method = "F6A427298AA3312377E760135921E0C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void reset() {
        threadHandles.clear();
        // ---------- Original Method ----------
        //threadHandles.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.787 -0400", hash_original_method = "A466F08B2826217F8F5011AA1A7379A2", hash_generated_method = "574D93B6E5C800026B2576E611EC60F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized String auditThreads() {
        String auditReport;
        auditReport = null;
        Iterator<ThreadHandle> it;
        it = threadHandles.values().iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1681795995 = (it.hasNext());
            {
                ThreadHandle threadHandle;
                threadHandle = (ThreadHandle) it.next();
                {
                    boolean varFBC1EC9DA8E6596CD1694AC52109EE2E_1720347281 = (!threadHandle.isThreadActive());
                    {
                        Thread thread;
                        thread = threadHandle.getThread();
                        {
                            auditReport = "Thread Auditor Report:\n";
                        } //End block
                        auditReport += "   Thread [" + thread.getName() + "] has failed to respond to an audit request.\n";
                    } //End block
                } //End collapsed parenthetic
                threadHandle.setThreadActive(false);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.787 -0400", hash_original_method = "6675CF6A116AB121851289F1BA88A8F3", hash_generated_method = "B74F9D4BCE6B0D969867E38ACCCE632C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized String toString() {
        String toString;
        toString = "Thread Auditor - List of monitored threads:\n";
        Iterator<ThreadHandle> it;
        it = threadHandles.values().iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_893429548 = (it.hasNext());
            {
                ThreadHandle threadHandle;
                threadHandle = (ThreadHandle)it.next();
                toString += "   " + threadHandle.toString() + "\n";
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String toString = "Thread Auditor - List of monitored threads:\n";
        //Iterator<ThreadHandle> it = threadHandles.values().iterator();
        //while ( it.hasNext()) {
            //ThreadHandle threadHandle = (ThreadHandle)it.next();
            //toString += "   " + threadHandle.toString() + "\n";
        //}
        //return toString;
    }

    
    public class ThreadHandle {
        private boolean isThreadActive;
        private Thread thread;
        private ThreadAuditor threadAuditor;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.787 -0400", hash_original_method = "40C494E087A9AB3654ECCCB79F809CD9", hash_generated_method = "2193FD7C829659D3EC0CE81CA1B3FE40")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ThreadHandle(ThreadAuditor aThreadAuditor) {
            dsTaint.addTaint(aThreadAuditor.dsTaint);
            isThreadActive = false;
            thread = Thread.currentThread();
            // ---------- Original Method ----------
            //isThreadActive = false;
            //thread = Thread.currentThread();
            //threadAuditor = aThreadAuditor;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.787 -0400", hash_original_method = "7C169FF6005EF7125A62D6FC1B2750B7", hash_generated_method = "227B541D46108B090956FD2061DAEE6B")
        @DSModeled(DSC.SAFE)
        public boolean isThreadActive() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return isThreadActive;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.788 -0400", hash_original_method = "88A3AB81179102C8D04CED6A81B233E5", hash_generated_method = "F069F5AC27902B64AA06721C5F337F2C")
        @DSModeled(DSC.SAFE)
        protected void setThreadActive(boolean value) {
            dsTaint.addTaint(value);
            // ---------- Original Method ----------
            //isThreadActive = value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.788 -0400", hash_original_method = "F8B0A54928E7ECAC7F4DBC7FBE8E98A4", hash_generated_method = "922A9721A7FC9F9280608D96B3264D7F")
        @DSModeled(DSC.SAFE)
        public Thread getThread() {
            return (Thread)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return thread;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.788 -0400", hash_original_method = "6040EE7F290925ABE22D0B8E78C0C92D", hash_generated_method = "A73BBB325702DD928662037CB4D962EF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void ping() {
            threadAuditor.ping(this);
            // ---------- Original Method ----------
            //threadAuditor.ping(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.788 -0400", hash_original_method = "3E3AA41CAE680C9493787FE6AF60A593", hash_generated_method = "6012108EE03AA3378C596F953D6F99C9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public long getPingIntervalInMillisecs() {
            long varDC0145732EE94D2B5394CBE03D07A9CF_441528132 = (threadAuditor.getPingIntervalInMillisecs());
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //return threadAuditor.getPingIntervalInMillisecs();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.788 -0400", hash_original_method = "433F66024AB5F11DDEF8BAC7248248B0", hash_generated_method = "5953EA40B6642DF7C6704F4F181AB1FF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String toString() {
            StringBuffer toString;
            toString = new StringBuffer()
                    .append("Thread Name: ").append(thread.getName())
                    .append(", Alive: ").append(thread.isAlive());
            String var41545C59E0F525A7377B0F0E4522E77F_404970268 = (toString.toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //StringBuffer toString = new StringBuffer()
                    //.append("Thread Name: ").append(thread.getName())
                    //.append(", Alive: ").append(thread.isAlive());
            //return toString.toString();
        }

        
    }


    
}

