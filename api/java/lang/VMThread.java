package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

class VMThread {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.708 -0400", hash_original_field = "DC127F5D2483352FD20EADDB38FEB6D2", hash_generated_field = "AB87C4F6E5547EBD7483F34732EA576D")

    Thread thread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.708 -0400", hash_original_field = "7241F87448ECB2DF51477E7C46B08008", hash_generated_field = "4CE593F597436D5B18C67B1F3A65463F")

    int vmData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.709 -0400", hash_original_method = "1F6D5BC845AA1BFC5CA0AAC86B89BD84", hash_generated_method = "491E6C78D5C5B622654A9B44AD8AA760")
      VMThread(Thread t) {
        thread = t;
        // ---------- Original Method ----------
        //thread = t;
    }

    
    @DSModeled(DSC.SAFE)
    static void create(Thread t, long stackSize) {
    }

    
    @DSModeled(DSC.SAFE)
    static Thread currentThread() {
    	return new Thread();
    }

    
    @DSModeled(DSC.SAFE)
    static boolean interrupted() {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1527386262 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1527386262;
    }

    
    @DSModeled(DSC.SAFE)
    static void sleep(long msec, int nsec) throws InterruptedException {
    }

    
    @DSModeled(DSC.SAFE)
    static void yield() {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.710 -0400", hash_original_method = "72EE977944BFE2711990DF062DD76748", hash_generated_method = "94B6702A412D748369A93518D1439045")
     void interrupt() {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.711 -0400", hash_original_method = "52F72D61B7E8A4F0C857BD363070E325", hash_generated_method = "06B0CBE4E50AAD9F6BFBECB0BAF1805F")
     boolean isInterrupted() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_750154509 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_750154509;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.711 -0400", hash_original_method = "A99C097CFE2867999295EE26A5D88F1F", hash_generated_method = "B21ED2BD8C15ED3917243D47CE193AD3")
     void start(long stackSize) {
        addTaint(stackSize);
        VMThread.create(thread, stackSize);
        // ---------- Original Method ----------
        //VMThread.create(thread, stackSize);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.712 -0400", hash_original_method = "E049D119A7B4A553F02CF8223BDECCF5", hash_generated_method = "E969AECE3FE9447B70533180772864F6")
     boolean holdsLock(Object object) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_96840845 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_96840845;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.712 -0400", hash_original_method = "7C8E9A670D06C8AE48DAFFA12CDF6628", hash_generated_method = "A11F7437771887EBEDB3015231AB3F04")
     void setPriority(int newPriority) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.713 -0400", hash_original_method = "133516DDD0D787C1D7D737647A15F491", hash_generated_method = "8E2584C80FE964ED317831D03B4AD0F0")
     int getStatus() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_841163013 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_841163013;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.713 -0400", hash_original_method = "E4C63287FA81E5CD749A3DF00B7871AE", hash_generated_method = "FD1E9D6CA0E361F0092CB029A4E0F83F")
     void nameChanged(String newName) {
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.713 -0400", hash_original_field = "235737FA5DA80904A3D176829C45D7AA", hash_generated_field = "5ED7E7DDB13276AD69276C3B167D8840")

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

