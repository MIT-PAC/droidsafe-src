package java.lang.ref;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ReferenceQueue<T> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.796 -0400", hash_original_field = "96E89A298E0A9F469B9AE458D6AFAE9F", hash_generated_field = "0D4E357872E15A12A6822EA05A1FF146")

    private Reference<? extends T> head;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.797 -0400", hash_original_method = "74975F7A6AFB5E81CCF3457B53FB8A14", hash_generated_method = "77FCC81AFA085C6B3B372539AC2D673F")
    public  ReferenceQueue() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.822 -0400", hash_original_method = "0715328D7F7BB9D5550B9E381C496C43", hash_generated_method = "382EC86CED945084FCFEE7A6B9614222")
    @SuppressWarnings("unchecked")
    public synchronized Reference<? extends T> poll() {
        Reference<? extends T> varB4EAC82CA7396A68D541C85D26508E83_948831523 = null; //Variable for return #1
        Reference<? extends T> varB4EAC82CA7396A68D541C85D26508E83_1990165920 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_948831523 = null;
        } //End block
        Reference<? extends T> ret;
        ret = head;
        {
            head = null;
        } //End block
        {
            head = head.queueNext;
        } //End block
        ret.queueNext = null;
        varB4EAC82CA7396A68D541C85D26508E83_1990165920 = ret;
        Reference<? extends T> varA7E53CE21691AB073D9660D615818899_1996268686; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1996268686 = varB4EAC82CA7396A68D541C85D26508E83_948831523;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1996268686 = varB4EAC82CA7396A68D541C85D26508E83_1990165920;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1996268686.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1996268686;
        // ---------- Original Method ----------
        //if (head == null) {
            //return null;
        //}
        //Reference<? extends T> ret;
        //ret = head;
        //if (head == head.queueNext) {
            //head = null;
        //} else {
            //head = head.queueNext;
        //}
        //ret.queueNext = null;
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.823 -0400", hash_original_method = "B9994ACC80E0363C78DC4EB28757C058", hash_generated_method = "B5286E6D538224B9F4296C33BDC0B458")
    public Reference<? extends T> remove() throws InterruptedException {
        Reference<? extends T> varB4EAC82CA7396A68D541C85D26508E83_1512480090 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1512480090 = remove(0L);
        varB4EAC82CA7396A68D541C85D26508E83_1512480090.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1512480090;
        // ---------- Original Method ----------
        //return remove(0L);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.824 -0400", hash_original_method = "55CFE9AF663FFFA3410902143F42A33C", hash_generated_method = "F85BD94AA6E7272A458ECAF67BE0BB33")
    public synchronized Reference<? extends T> remove(long timeoutMillis) throws InterruptedException {
        Reference<? extends T> varB4EAC82CA7396A68D541C85D26508E83_2122313544 = null; //Variable for return #1
        Reference<? extends T> varB4EAC82CA7396A68D541C85D26508E83_1509037492 = null; //Variable for return #2
        Reference<? extends T> varB4EAC82CA7396A68D541C85D26508E83_1553968194 = null; //Variable for return #3
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("timeout < 0: " + timeoutMillis);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_2122313544 = poll();
        } //End block
        {
            {
                wait(0);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1509037492 = poll();
        } //End block
        long nanosToWait;
        nanosToWait = timeoutMillis * NANOS_PER_MILLI;
        int timeoutNanos;
        timeoutNanos = 0;
        long startTime;
        startTime = System.nanoTime();
        {
            wait(timeoutMillis, timeoutNanos);
            long nanosElapsed;
            nanosElapsed = System.nanoTime() - startTime;
            long nanosRemaining;
            nanosRemaining = nanosToWait - nanosElapsed;
            timeoutMillis = nanosRemaining / NANOS_PER_MILLI;
            timeoutNanos = (int) (nanosRemaining - timeoutMillis * NANOS_PER_MILLI);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1553968194 = poll();
        addTaint(timeoutMillis);
        Reference<? extends T> varA7E53CE21691AB073D9660D615818899_2106163067; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2106163067 = varB4EAC82CA7396A68D541C85D26508E83_2122313544;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2106163067 = varB4EAC82CA7396A68D541C85D26508E83_1509037492;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2106163067 = varB4EAC82CA7396A68D541C85D26508E83_1553968194;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2106163067.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2106163067;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.824 -0400", hash_original_method = "A43A8FC0DB505099966EA05BCA8E1BC7", hash_generated_method = "9ECE3F5ABA51CE93DE1D21F9DBC7A9C4")
    synchronized void enqueue(Reference<? extends T> reference) {
        {
            reference.queueNext = reference;
        } //End block
        {
            reference.queueNext = head;
        } //End block
        head = reference;
        notify();
        // ---------- Original Method ----------
        //if (head == null) {
            //reference.queueNext = reference;
        //} else {
            //reference.queueNext = head;
        //}
        //head = reference;
        //notify();
    }

    
        static void add(Reference<?> list) {
        synchronized (ReferenceQueue.class) {
            if (unenqueued == null) {
                unenqueued = list;
            } else {
                Reference<?> next = unenqueued.pendingNext;
                unenqueued.pendingNext = list.pendingNext;
                list.pendingNext = next;
            }
            ReferenceQueue.class.notifyAll();
        }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.825 -0400", hash_original_field = "90F159E16A269B6F875D096F21ED865D", hash_generated_field = "01FF75DD42CEEFF83B007A550DB754A1")

    private static int NANOS_PER_MILLI = 1000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.825 -0400", hash_original_field = "995097E066213348C3BBA01801EB2CBA", hash_generated_field = "4ECF0535730E811CDF8F487B61B191FD")

    public static Reference unenqueued = null;
}

