package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

class VMThread {
    Thread thread;
    int vmData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.672 -0400", hash_original_method = "1F6D5BC845AA1BFC5CA0AAC86B89BD84", hash_generated_method = "AAFA39FACEA23CBAB40BFBC4596F0455")
    @DSModeled(DSC.SAFE)
     VMThread(Thread t) {
        dsTaint.addTaint(t.dsTaint);
        // ---------- Original Method ----------
        //thread = t;
    }

    
        static void create(Thread t, long stackSize) {
    }

    
        static Thread currentThread() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        static boolean interrupted() {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        static void sleep(long msec, int nsec) throws InterruptedException {
    }

    
        static void yield() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.673 -0400", hash_original_method = "72EE977944BFE2711990DF062DD76748", hash_generated_method = "94B6702A412D748369A93518D1439045")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void interrupt() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.673 -0400", hash_original_method = "52F72D61B7E8A4F0C857BD363070E325", hash_generated_method = "EB24759DC775738D2DA4DC5522B0A521")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isInterrupted() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.679 -0400", hash_original_method = "A99C097CFE2867999295EE26A5D88F1F", hash_generated_method = "292FFA3345A9C27A8DC853FF89FE1F27")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void start(long stackSize) {
        dsTaint.addTaint(stackSize);
        VMThread.create(thread, stackSize);
        // ---------- Original Method ----------
        //VMThread.create(thread, stackSize);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.679 -0400", hash_original_method = "E049D119A7B4A553F02CF8223BDECCF5", hash_generated_method = "D076FA3261C7A55E64330A4DB99AF012")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean holdsLock(Object object) {
        dsTaint.addTaint(object.dsTaint);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.679 -0400", hash_original_method = "7C8E9A670D06C8AE48DAFFA12CDF6628", hash_generated_method = "546D8AA7EC9F6F74775BE7D540FB825C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setPriority(int newPriority) {
        dsTaint.addTaint(newPriority);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.679 -0400", hash_original_method = "133516DDD0D787C1D7D737647A15F491", hash_generated_method = "B40B51E569E88EB095E32C7EB90B1094")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int getStatus() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.680 -0400", hash_original_method = "E4C63287FA81E5CD749A3DF00B7871AE", hash_generated_method = "0B114C1DA8CA9F781B5202B6308BD34F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void nameChanged(String newName) {
        dsTaint.addTaint(newName);
    }

    
    static final Thread.State[] STATE_MAP = new Thread.State[] {
        Thread.State.TERMINATED,     
        Thread.State.RUNNABLE,       
        Thread.State.TIMED_WAITING,  
        Thread.State.BLOCKED,        
        Thread.State.WAITING,        
        Thread.State.NEW,            
        Thread.State.NEW,            
        Thread.State.RUNNABLE,       
        Thread.State.WAITING,        
        Thread.State.RUNNABLE        
    };
}

