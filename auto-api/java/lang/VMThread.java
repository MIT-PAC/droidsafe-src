package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

class VMThread {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.496 -0400", hash_original_field = "DC127F5D2483352FD20EADDB38FEB6D2", hash_generated_field = "AB87C4F6E5547EBD7483F34732EA576D")

    Thread thread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.496 -0400", hash_original_field = "7241F87448ECB2DF51477E7C46B08008", hash_generated_field = "4CE593F597436D5B18C67B1F3A65463F")

    int vmData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.496 -0400", hash_original_method = "1F6D5BC845AA1BFC5CA0AAC86B89BD84", hash_generated_method = "491E6C78D5C5B622654A9B44AD8AA760")
      VMThread(Thread t) {
        thread = t;
        // ---------- Original Method ----------
        //thread = t;
    }

    
    static void create(Thread t, long stackSize) {
    }

    
    static Thread currentThread() {
                //DSFIXME:  This shouldn't happen!
    	return new Thread();
    }

    
    static boolean interrupted() {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1527386262 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1527386262;
    }

    
    static void sleep(long msec, int nsec) throws InterruptedException {
    }

    
    static void yield() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.498 -0400", hash_original_method = "72EE977944BFE2711990DF062DD76748", hash_generated_method = "94B6702A412D748369A93518D1439045")
     void interrupt() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.498 -0400", hash_original_method = "52F72D61B7E8A4F0C857BD363070E325", hash_generated_method = "C0048033A2077FC7D44EC217ECA4718D")
     boolean isInterrupted() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1989784656 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1989784656;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.498 -0400", hash_original_method = "A99C097CFE2867999295EE26A5D88F1F", hash_generated_method = "D55FD8C808938B3BBD33670F5C7F0D81")
     void start(long stackSize) {
        VMThread.create(thread, stackSize);
        addTaint(stackSize);
        // ---------- Original Method ----------
        //VMThread.create(thread, stackSize);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.498 -0400", hash_original_method = "E049D119A7B4A553F02CF8223BDECCF5", hash_generated_method = "0665D9236A1B7D87F72867974F20C98F")
     boolean holdsLock(Object object) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2076884891 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2076884891;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.499 -0400", hash_original_method = "7C8E9A670D06C8AE48DAFFA12CDF6628", hash_generated_method = "A11F7437771887EBEDB3015231AB3F04")
     void setPriority(int newPriority) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.499 -0400", hash_original_method = "133516DDD0D787C1D7D737647A15F491", hash_generated_method = "DBCF976F78690075D21E9D906EC72998")
     int getStatus() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1658562 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1658562;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.499 -0400", hash_original_method = "E4C63287FA81E5CD749A3DF00B7871AE", hash_generated_method = "FD1E9D6CA0E361F0092CB029A4E0F83F")
     void nameChanged(String newName) {
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.499 -0400", hash_original_field = "235737FA5DA80904A3D176829C45D7AA", hash_generated_field = "5ED7E7DDB13276AD69276C3B167D8840")

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

