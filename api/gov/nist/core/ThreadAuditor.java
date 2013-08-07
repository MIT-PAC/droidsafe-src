package gov.nist.core;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;






public class ThreadAuditor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.754 -0400", hash_original_field = "E69CF33726E786A313D6AF0449302A13", hash_generated_field = "A00A12B2B5536306E22F7FB7287ECF23")

    private Map<Thread,ThreadHandle> threadHandles = new HashMap<Thread,ThreadHandle>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.755 -0400", hash_original_field = "FA5518F285459CD63B5D113F72CB1C39", hash_generated_field = "8666B6F6E2B3566873DE3F0C843D61F9")

    private long pingIntervalInMillisecs = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.755 -0400", hash_original_method = "46343C8CADBF1D5ED7A34C5D2358E7DA", hash_generated_method = "46343C8CADBF1D5ED7A34C5D2358E7DA")
    public ThreadAuditor ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.755 -0400", hash_original_method = "E626588797C11F0AE30EE2336DDF5DDE", hash_generated_method = "60EFB720F3D53FA799BA24AC74E46D98")
    public long getPingIntervalInMillisecs() {
        long varCBCED6551849E103E372D83857F211E1_1000180060 = (pingIntervalInMillisecs);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_304229590 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_304229590;
        // ---------- Original Method ----------
        //return pingIntervalInMillisecs;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.755 -0400", hash_original_method = "7A7DF1118EDC7A81CF310DAEDEA2CA24", hash_generated_method = "4EE6AECCAFAC51D47EC18DF5AFAFA65C")
    public void setPingIntervalInMillisecs(long value) {
        pingIntervalInMillisecs = value;
        // ---------- Original Method ----------
        //pingIntervalInMillisecs = value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.756 -0400", hash_original_method = "3383EC0356978E6A8A0873AB5EB0F6B5", hash_generated_method = "6B412AE4342D71E7C6DF43E10A3CB29B")
    public boolean isEnabled() {
        boolean var9DF94B84EDB5144CC140ACBCC7DF389E_1467403334 = ((pingIntervalInMillisecs > 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1530152366 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1530152366;
        // ---------- Original Method ----------
        //return (pingIntervalInMillisecs > 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.756 -0400", hash_original_method = "E669DE9122CCA9B4713223F08741F9E6", hash_generated_method = "C2A6343487A5B64A9D1AE0665B01426A")
    public synchronized ThreadHandle addCurrentThread() {
        ThreadHandle threadHandle = new ThreadHandle(this);
        if(isEnabled())        
        {
            threadHandles.put(Thread.currentThread(), threadHandle);
        } //End block
ThreadHandle var47A3C09AC8DC8AC9BE3EA5513CADAD05_1168278357 =         threadHandle;
        var47A3C09AC8DC8AC9BE3EA5513CADAD05_1168278357.addTaint(taint);
        return var47A3C09AC8DC8AC9BE3EA5513CADAD05_1168278357;
        // ---------- Original Method ----------
        //ThreadHandle threadHandle = new ThreadHandle(this);
        //if (isEnabled()) {
            //threadHandles.put(Thread.currentThread(), threadHandle);
        //}
        //return threadHandle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.757 -0400", hash_original_method = "6C8F2FE0AC3A02915C2D70AD5F0F3037", hash_generated_method = "79DB510705DE3BBAA294FC06133CAFA1")
    public synchronized void removeThread(Thread thread) {
        addTaint(thread.getTaint());
        threadHandles.remove(thread);
        // ---------- Original Method ----------
        //threadHandles.remove(thread);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.757 -0400", hash_original_method = "BB4C09A88190125090DD9FF91A5AB1C4", hash_generated_method = "298E0EA8EA3D8FFE3D800D4D9CBC8225")
    public synchronized void ping(ThreadHandle threadHandle) {
        addTaint(threadHandle.getTaint());
        threadHandle.setThreadActive(true);
        // ---------- Original Method ----------
        //threadHandle.setThreadActive(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.758 -0400", hash_original_method = "E964CDFC4A03877954EFAFA10E2DC29D", hash_generated_method = "F6A427298AA3312377E760135921E0C2")
    public synchronized void reset() {
        threadHandles.clear();
        // ---------- Original Method ----------
        //threadHandles.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.759 -0400", hash_original_method = "A466F08B2826217F8F5011AA1A7379A2", hash_generated_method = "95A8A160C6BD6012CFC0D7686CF14825")
    public synchronized String auditThreads() {
        String auditReport = null;
        Iterator<ThreadHandle> it = threadHandles.values().iterator();
        while
(it.hasNext())        
        {
            ThreadHandle threadHandle = (ThreadHandle) it.next();
            if(!threadHandle.isThreadActive())            
            {
                Thread thread = threadHandle.getThread();
                if(auditReport == null)                
                {
                    auditReport = "Thread Auditor Report:\n";
                } //End block
                auditReport += "   Thread [" + thread.getName() + "] has failed to respond to an audit request.\n";
            } //End block
            threadHandle.setThreadActive(false);
        } //End block
String var45515A2592231F3BCF49C3DB63F02A4B_2122072438 =         auditReport;
        var45515A2592231F3BCF49C3DB63F02A4B_2122072438.addTaint(taint);
        return var45515A2592231F3BCF49C3DB63F02A4B_2122072438;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.759 -0400", hash_original_method = "6675CF6A116AB121851289F1BA88A8F3", hash_generated_method = "43D6283ABB7FF643DE9470CC1ABE9647")
    public synchronized String toString() {
        String toString = "Thread Auditor - List of monitored threads:\n";
        Iterator<ThreadHandle> it = threadHandles.values().iterator();
        while
(it.hasNext())        
        {
            ThreadHandle threadHandle = (ThreadHandle)it.next();
            toString += "   " + threadHandle.toString() + "\n";
        } //End block
String varC9A0E46F6EAD14B0A7B52DADE46AB753_64522560 =         toString;
        varC9A0E46F6EAD14B0A7B52DADE46AB753_64522560.addTaint(taint);
        return varC9A0E46F6EAD14B0A7B52DADE46AB753_64522560;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.760 -0400", hash_original_field = "C27D2AE338AEB5D3D641D7F9A5579631", hash_generated_field = "4D9544D57A3ABD008438B9DAA58E4AF5")

        private boolean isThreadActive;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.760 -0400", hash_original_field = "DC127F5D2483352FD20EADDB38FEB6D2", hash_generated_field = "3B3F78C77D023C4AC9933B933AD9AFEC")

        private Thread thread;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.760 -0400", hash_original_field = "47F1716A39791C61AF97E4DC8530DE5E", hash_generated_field = "997328D506876FA38420B35187A6D56F")

        private ThreadAuditor threadAuditor;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.760 -0400", hash_original_method = "40C494E087A9AB3654ECCCB79F809CD9", hash_generated_method = "9F19CF9B53493A055DB4C0233322D8F1")
        public  ThreadHandle(ThreadAuditor aThreadAuditor) {
            isThreadActive = false;
            thread = Thread.currentThread();
            threadAuditor = aThreadAuditor;
            // ---------- Original Method ----------
            //isThreadActive = false;
            //thread = Thread.currentThread();
            //threadAuditor = aThreadAuditor;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.761 -0400", hash_original_method = "7C169FF6005EF7125A62D6FC1B2750B7", hash_generated_method = "6D68D4CCF58BA36FE9BCE23F2F1D34EB")
        public boolean isThreadActive() {
            boolean varC27D2AE338AEB5D3D641D7F9A5579631_1612855099 = (isThreadActive);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_396975358 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_396975358;
            // ---------- Original Method ----------
            //return isThreadActive;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.761 -0400", hash_original_method = "88A3AB81179102C8D04CED6A81B233E5", hash_generated_method = "F939265BD831E182F8951ADA8E09D004")
        protected void setThreadActive(boolean value) {
            isThreadActive = value;
            // ---------- Original Method ----------
            //isThreadActive = value;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.761 -0400", hash_original_method = "F8B0A54928E7ECAC7F4DBC7FBE8E98A4", hash_generated_method = "EC4EF6B3843CE14593DFB42423B5ACD9")
        public Thread getThread() {
Thread var4E4577EDE13083D3065B1ECBBC20E477_1349802468 =             thread;
            var4E4577EDE13083D3065B1ECBBC20E477_1349802468.addTaint(taint);
            return var4E4577EDE13083D3065B1ECBBC20E477_1349802468;
            // ---------- Original Method ----------
            //return thread;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.762 -0400", hash_original_method = "6040EE7F290925ABE22D0B8E78C0C92D", hash_generated_method = "A73BBB325702DD928662037CB4D962EF")
        public void ping() {
            threadAuditor.ping(this);
            // ---------- Original Method ----------
            //threadAuditor.ping(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.762 -0400", hash_original_method = "3E3AA41CAE680C9493787FE6AF60A593", hash_generated_method = "9418C86B1BBC9E9B1CF1F5718E2E85D8")
        public long getPingIntervalInMillisecs() {
            long varB3D5BC2A6F17C75D3047A7E8BDB8B6C4_752342588 = (threadAuditor.getPingIntervalInMillisecs());
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_946009532 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_946009532;
            // ---------- Original Method ----------
            //return threadAuditor.getPingIntervalInMillisecs();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.762 -0400", hash_original_method = "433F66024AB5F11DDEF8BAC7248248B0", hash_generated_method = "A380C9068B72136FDE855B17E3BFA5EF")
        public String toString() {
            StringBuffer toString = new StringBuffer()
                    .append("Thread Name: ").append(thread.getName())
                    .append(", Alive: ").append(thread.isAlive());
String var6C6056BC03A3D6D14AB3C12F1BAA8CBB_155368535 =             toString.toString();
            var6C6056BC03A3D6D14AB3C12F1BAA8CBB_155368535.addTaint(taint);
            return var6C6056BC03A3D6D14AB3C12F1BAA8CBB_155368535;
            // ---------- Original Method ----------
            //StringBuffer toString = new StringBuffer()
                    //.append("Thread Name: ").append(thread.getName())
                    //.append(", Alive: ").append(thread.isAlive());
            //return toString.toString();
        }

        
    }


    
}

