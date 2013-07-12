package gov.nist.core;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.*;

public class ThreadAuditor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.797 -0400", hash_original_field = "E69CF33726E786A313D6AF0449302A13", hash_generated_field = "A00A12B2B5536306E22F7FB7287ECF23")

    private Map<Thread,ThreadHandle> threadHandles = new HashMap<Thread,ThreadHandle>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.797 -0400", hash_original_field = "FA5518F285459CD63B5D113F72CB1C39", hash_generated_field = "8666B6F6E2B3566873DE3F0C843D61F9")

    private long pingIntervalInMillisecs = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.797 -0400", hash_original_method = "46343C8CADBF1D5ED7A34C5D2358E7DA", hash_generated_method = "46343C8CADBF1D5ED7A34C5D2358E7DA")
    public ThreadAuditor ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.798 -0400", hash_original_method = "E626588797C11F0AE30EE2336DDF5DDE", hash_generated_method = "1430901666801E75BBC7719A953460F5")
    public long getPingIntervalInMillisecs() {
        long varCBCED6551849E103E372D83857F211E1_479280851 = (pingIntervalInMillisecs);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_2040185269 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2040185269;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.798 -0400", hash_original_method = "7A7DF1118EDC7A81CF310DAEDEA2CA24", hash_generated_method = "4EE6AECCAFAC51D47EC18DF5AFAFA65C")
    public void setPingIntervalInMillisecs(long value) {
        pingIntervalInMillisecs = value;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.798 -0400", hash_original_method = "3383EC0356978E6A8A0873AB5EB0F6B5", hash_generated_method = "BE518DEC7547C69763191097B3CB8240")
    public boolean isEnabled() {
        boolean var9DF94B84EDB5144CC140ACBCC7DF389E_557457304 = ((pingIntervalInMillisecs > 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1241447178 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1241447178;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.799 -0400", hash_original_method = "E669DE9122CCA9B4713223F08741F9E6", hash_generated_method = "110C5C89DA65093075BC8CF20E4C94C5")
    public synchronized ThreadHandle addCurrentThread() {
        ThreadHandle threadHandle = new ThreadHandle(this);
    if(isEnabled())        
        {
            threadHandles.put(Thread.currentThread(), threadHandle);
        } 
ThreadHandle var47A3C09AC8DC8AC9BE3EA5513CADAD05_2091508683 =         threadHandle;
        var47A3C09AC8DC8AC9BE3EA5513CADAD05_2091508683.addTaint(taint);
        return var47A3C09AC8DC8AC9BE3EA5513CADAD05_2091508683;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.799 -0400", hash_original_method = "6C8F2FE0AC3A02915C2D70AD5F0F3037", hash_generated_method = "79DB510705DE3BBAA294FC06133CAFA1")
    public synchronized void removeThread(Thread thread) {
        addTaint(thread.getTaint());
        threadHandles.remove(thread);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.799 -0400", hash_original_method = "BB4C09A88190125090DD9FF91A5AB1C4", hash_generated_method = "298E0EA8EA3D8FFE3D800D4D9CBC8225")
    public synchronized void ping(ThreadHandle threadHandle) {
        addTaint(threadHandle.getTaint());
        threadHandle.setThreadActive(true);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.800 -0400", hash_original_method = "E964CDFC4A03877954EFAFA10E2DC29D", hash_generated_method = "F6A427298AA3312377E760135921E0C2")
    public synchronized void reset() {
        threadHandles.clear();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.800 -0400", hash_original_method = "A466F08B2826217F8F5011AA1A7379A2", hash_generated_method = "BBF63AF56065CE9866F8099F06AB51CD")
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
                } 
                auditReport += "   Thread [" + thread.getName() + "] has failed to respond to an audit request.\n";
            } 
            threadHandle.setThreadActive(false);
        } 
String var45515A2592231F3BCF49C3DB63F02A4B_1873409561 =         auditReport;
        var45515A2592231F3BCF49C3DB63F02A4B_1873409561.addTaint(taint);
        return var45515A2592231F3BCF49C3DB63F02A4B_1873409561;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.801 -0400", hash_original_method = "6675CF6A116AB121851289F1BA88A8F3", hash_generated_method = "EBE1B7C7006ACFE8158B3D8A089EE278")
    public synchronized String toString() {
        String toString = "Thread Auditor - List of monitored threads:\n";
        Iterator<ThreadHandle> it = threadHandles.values().iterator();
        while
(it.hasNext())        
        {
            ThreadHandle threadHandle = (ThreadHandle)it.next();
            toString += "   " + threadHandle.toString() + "\n";
        } 
String varC9A0E46F6EAD14B0A7B52DADE46AB753_705824705 =         toString;
        varC9A0E46F6EAD14B0A7B52DADE46AB753_705824705.addTaint(taint);
        return varC9A0E46F6EAD14B0A7B52DADE46AB753_705824705;
        
        
        
        
            
            
        
        
    }

    
    public class ThreadHandle {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.802 -0400", hash_original_field = "C27D2AE338AEB5D3D641D7F9A5579631", hash_generated_field = "4D9544D57A3ABD008438B9DAA58E4AF5")

        private boolean isThreadActive;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.802 -0400", hash_original_field = "DC127F5D2483352FD20EADDB38FEB6D2", hash_generated_field = "3B3F78C77D023C4AC9933B933AD9AFEC")

        private Thread thread;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.802 -0400", hash_original_field = "47F1716A39791C61AF97E4DC8530DE5E", hash_generated_field = "997328D506876FA38420B35187A6D56F")

        private ThreadAuditor threadAuditor;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.802 -0400", hash_original_method = "40C494E087A9AB3654ECCCB79F809CD9", hash_generated_method = "9F19CF9B53493A055DB4C0233322D8F1")
        public  ThreadHandle(ThreadAuditor aThreadAuditor) {
            isThreadActive = false;
            thread = Thread.currentThread();
            threadAuditor = aThreadAuditor;
            
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.803 -0400", hash_original_method = "7C169FF6005EF7125A62D6FC1B2750B7", hash_generated_method = "846BF304E42A7582792D8E7C7F906EB3")
        public boolean isThreadActive() {
            boolean varC27D2AE338AEB5D3D641D7F9A5579631_2130226447 = (isThreadActive);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1381884590 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1381884590;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.803 -0400", hash_original_method = "88A3AB81179102C8D04CED6A81B233E5", hash_generated_method = "F939265BD831E182F8951ADA8E09D004")
        protected void setThreadActive(boolean value) {
            isThreadActive = value;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.804 -0400", hash_original_method = "F8B0A54928E7ECAC7F4DBC7FBE8E98A4", hash_generated_method = "7588DA55A7936F641D6A5F3738377E27")
        public Thread getThread() {
Thread var4E4577EDE13083D3065B1ECBBC20E477_1915925799 =             thread;
            var4E4577EDE13083D3065B1ECBBC20E477_1915925799.addTaint(taint);
            return var4E4577EDE13083D3065B1ECBBC20E477_1915925799;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.804 -0400", hash_original_method = "6040EE7F290925ABE22D0B8E78C0C92D", hash_generated_method = "A73BBB325702DD928662037CB4D962EF")
        public void ping() {
            threadAuditor.ping(this);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.804 -0400", hash_original_method = "3E3AA41CAE680C9493787FE6AF60A593", hash_generated_method = "30F5E6205AFEC6FB2DEA985222D121DF")
        public long getPingIntervalInMillisecs() {
            long varB3D5BC2A6F17C75D3047A7E8BDB8B6C4_792142176 = (threadAuditor.getPingIntervalInMillisecs());
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_493749873 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_493749873;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.804 -0400", hash_original_method = "433F66024AB5F11DDEF8BAC7248248B0", hash_generated_method = "D9F210C8CBFF89ED22E8DF534866F857")
        public String toString() {
            StringBuffer toString = new StringBuffer()
                    .append("Thread Name: ").append(thread.getName())
                    .append(", Alive: ").append(thread.isAlive());
String var6C6056BC03A3D6D14AB3C12F1BAA8CBB_1222447457 =             toString.toString();
            var6C6056BC03A3D6D14AB3C12F1BAA8CBB_1222447457.addTaint(taint);
            return var6C6056BC03A3D6D14AB3C12F1BAA8CBB_1222447457;
            
            
                    
                    
            
        }

        
    }


    
}

