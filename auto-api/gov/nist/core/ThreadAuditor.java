package gov.nist.core;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.*;

public class ThreadAuditor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.907 -0400", hash_original_field = "E69CF33726E786A313D6AF0449302A13", hash_generated_field = "A00A12B2B5536306E22F7FB7287ECF23")

    private Map<Thread,ThreadHandle> threadHandles = new HashMap<Thread,ThreadHandle>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.907 -0400", hash_original_field = "FA5518F285459CD63B5D113F72CB1C39", hash_generated_field = "8666B6F6E2B3566873DE3F0C843D61F9")

    private long pingIntervalInMillisecs = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.907 -0400", hash_original_method = "46343C8CADBF1D5ED7A34C5D2358E7DA", hash_generated_method = "46343C8CADBF1D5ED7A34C5D2358E7DA")
    public ThreadAuditor ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.908 -0400", hash_original_method = "E626588797C11F0AE30EE2336DDF5DDE", hash_generated_method = "636F2B59043DF57D20C7B31C7B2FC975")
    public long getPingIntervalInMillisecs() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_827917271 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_827917271;
        // ---------- Original Method ----------
        //return pingIntervalInMillisecs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.908 -0400", hash_original_method = "7A7DF1118EDC7A81CF310DAEDEA2CA24", hash_generated_method = "4EE6AECCAFAC51D47EC18DF5AFAFA65C")
    public void setPingIntervalInMillisecs(long value) {
        pingIntervalInMillisecs = value;
        // ---------- Original Method ----------
        //pingIntervalInMillisecs = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.908 -0400", hash_original_method = "3383EC0356978E6A8A0873AB5EB0F6B5", hash_generated_method = "B0B8AA330144BB4C299862E811629891")
    public boolean isEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1425852766 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1425852766;
        // ---------- Original Method ----------
        //return (pingIntervalInMillisecs > 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.909 -0400", hash_original_method = "E669DE9122CCA9B4713223F08741F9E6", hash_generated_method = "0A6CDBF6C4794045A5631236392A7797")
    public synchronized ThreadHandle addCurrentThread() {
        ThreadHandle varB4EAC82CA7396A68D541C85D26508E83_1338809257 = null; //Variable for return #1
        ThreadHandle threadHandle = new ThreadHandle(this);
        {
            boolean var7DF3FD71A82DB900422A2663707EECDE_1931055990 = (isEnabled());
            {
                threadHandles.put(Thread.currentThread(), threadHandle);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1338809257 = threadHandle;
        varB4EAC82CA7396A68D541C85D26508E83_1338809257.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1338809257;
        // ---------- Original Method ----------
        //ThreadHandle threadHandle = new ThreadHandle(this);
        //if (isEnabled()) {
            //threadHandles.put(Thread.currentThread(), threadHandle);
        //}
        //return threadHandle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.910 -0400", hash_original_method = "6C8F2FE0AC3A02915C2D70AD5F0F3037", hash_generated_method = "EA74FC04FE85FBD080E82E32B6E9526A")
    public synchronized void removeThread(Thread thread) {
        threadHandles.remove(thread);
        addTaint(thread.getTaint());
        // ---------- Original Method ----------
        //threadHandles.remove(thread);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.910 -0400", hash_original_method = "BB4C09A88190125090DD9FF91A5AB1C4", hash_generated_method = "AA42BC2F7439DB5735CC64F07F52D5FC")
    public synchronized void ping(ThreadHandle threadHandle) {
        threadHandle.setThreadActive(true);
        addTaint(threadHandle.getTaint());
        // ---------- Original Method ----------
        //threadHandle.setThreadActive(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.910 -0400", hash_original_method = "E964CDFC4A03877954EFAFA10E2DC29D", hash_generated_method = "F6A427298AA3312377E760135921E0C2")
    public synchronized void reset() {
        threadHandles.clear();
        // ---------- Original Method ----------
        //threadHandles.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.912 -0400", hash_original_method = "A466F08B2826217F8F5011AA1A7379A2", hash_generated_method = "2B12AAA75D1865A5D8C72FDFE1149FDF")
    public synchronized String auditThreads() {
        String varB4EAC82CA7396A68D541C85D26508E83_533252088 = null; //Variable for return #1
        String auditReport = null;
        Iterator<ThreadHandle> it = threadHandles.values().iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_235562361 = (it.hasNext());
            {
                ThreadHandle threadHandle = (ThreadHandle) it.next();
                {
                    boolean varFBC1EC9DA8E6596CD1694AC52109EE2E_1409789028 = (!threadHandle.isThreadActive());
                    {
                        Thread thread = threadHandle.getThread();
                        {
                            auditReport = "Thread Auditor Report:\n";
                        } //End block
                        auditReport += "   Thread [" + thread.getName() + "] has failed to respond to an audit request.\n";
                    } //End block
                } //End collapsed parenthetic
                threadHandle.setThreadActive(false);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_533252088 = auditReport;
        varB4EAC82CA7396A68D541C85D26508E83_533252088.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_533252088;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.915 -0400", hash_original_method = "6675CF6A116AB121851289F1BA88A8F3", hash_generated_method = "B2FC2DEDCD3606671103D94566247647")
    public synchronized String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_524543371 = null; //Variable for return #1
        String toString = "Thread Auditor - List of monitored threads:\n";
        Iterator<ThreadHandle> it = threadHandles.values().iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_2084470402 = (it.hasNext());
            {
                ThreadHandle threadHandle = (ThreadHandle)it.next();
                toString += "   " + threadHandle.toString() + "\n";
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_524543371 = toString;
        varB4EAC82CA7396A68D541C85D26508E83_524543371.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_524543371;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.915 -0400", hash_original_field = "C27D2AE338AEB5D3D641D7F9A5579631", hash_generated_field = "4D9544D57A3ABD008438B9DAA58E4AF5")

        private boolean isThreadActive;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.915 -0400", hash_original_field = "DC127F5D2483352FD20EADDB38FEB6D2", hash_generated_field = "3B3F78C77D023C4AC9933B933AD9AFEC")

        private Thread thread;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.916 -0400", hash_original_field = "47F1716A39791C61AF97E4DC8530DE5E", hash_generated_field = "997328D506876FA38420B35187A6D56F")

        private ThreadAuditor threadAuditor;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.916 -0400", hash_original_method = "40C494E087A9AB3654ECCCB79F809CD9", hash_generated_method = "9F19CF9B53493A055DB4C0233322D8F1")
        public  ThreadHandle(ThreadAuditor aThreadAuditor) {
            isThreadActive = false;
            thread = Thread.currentThread();
            threadAuditor = aThreadAuditor;
            // ---------- Original Method ----------
            //isThreadActive = false;
            //thread = Thread.currentThread();
            //threadAuditor = aThreadAuditor;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.917 -0400", hash_original_method = "7C169FF6005EF7125A62D6FC1B2750B7", hash_generated_method = "0255DD6DB1D9EA804D13E06958FCD4CF")
        public boolean isThreadActive() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1061912172 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1061912172;
            // ---------- Original Method ----------
            //return isThreadActive;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.918 -0400", hash_original_method = "88A3AB81179102C8D04CED6A81B233E5", hash_generated_method = "F939265BD831E182F8951ADA8E09D004")
        protected void setThreadActive(boolean value) {
            isThreadActive = value;
            // ---------- Original Method ----------
            //isThreadActive = value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.918 -0400", hash_original_method = "F8B0A54928E7ECAC7F4DBC7FBE8E98A4", hash_generated_method = "37C247424F4C4D70C8832F8945623919")
        public Thread getThread() {
            Thread varB4EAC82CA7396A68D541C85D26508E83_852567862 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_852567862 = thread;
            varB4EAC82CA7396A68D541C85D26508E83_852567862.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_852567862;
            // ---------- Original Method ----------
            //return thread;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.919 -0400", hash_original_method = "6040EE7F290925ABE22D0B8E78C0C92D", hash_generated_method = "A73BBB325702DD928662037CB4D962EF")
        public void ping() {
            threadAuditor.ping(this);
            // ---------- Original Method ----------
            //threadAuditor.ping(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.919 -0400", hash_original_method = "3E3AA41CAE680C9493787FE6AF60A593", hash_generated_method = "723636CA3DE2D5B0C457F4389DD14F23")
        public long getPingIntervalInMillisecs() {
            long varDC0145732EE94D2B5394CBE03D07A9CF_492187868 = (threadAuditor.getPingIntervalInMillisecs());
            long var0F5264038205EDFB1AC05FBB0E8C5E94_1225068567 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1225068567;
            // ---------- Original Method ----------
            //return threadAuditor.getPingIntervalInMillisecs();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.920 -0400", hash_original_method = "433F66024AB5F11DDEF8BAC7248248B0", hash_generated_method = "357AB5A36A072E0CC1D9D78A37F96143")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_43125509 = null; //Variable for return #1
            StringBuffer toString = new StringBuffer()
                    .append("Thread Name: ").append(thread.getName())
                    .append(", Alive: ").append(thread.isAlive());
            varB4EAC82CA7396A68D541C85D26508E83_43125509 = toString.toString();
            varB4EAC82CA7396A68D541C85D26508E83_43125509.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_43125509;
            // ---------- Original Method ----------
            //StringBuffer toString = new StringBuffer()
                    //.append("Thread Name: ").append(thread.getName())
                    //.append(", Alive: ").append(thread.isAlive());
            //return toString.toString();
        }

        
    }


    
}

