package java.lang.ref;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ReferenceQueue<T> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.609 -0400", hash_original_field = "96E89A298E0A9F469B9AE458D6AFAE9F", hash_generated_field = "0D4E357872E15A12A6822EA05A1FF146")

    private Reference<? extends T> head;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.610 -0400", hash_original_method = "74975F7A6AFB5E81CCF3457B53FB8A14", hash_generated_method = "77FCC81AFA085C6B3B372539AC2D673F")
    public  ReferenceQueue() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.612 -0400", hash_original_method = "0715328D7F7BB9D5550B9E381C496C43", hash_generated_method = "21F968355715CEA0A95F5C5F16FDBE9F")
    @SuppressWarnings("unchecked")
    public synchronized Reference<? extends T> poll() {
        Reference<? extends T> varB4EAC82CA7396A68D541C85D26508E83_2048790781 = null; //Variable for return #1
        Reference<? extends T> varB4EAC82CA7396A68D541C85D26508E83_1378744601 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_2048790781 = null;
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
        varB4EAC82CA7396A68D541C85D26508E83_1378744601 = ret;
        Reference<? extends T> varA7E53CE21691AB073D9660D615818899_1101147987; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1101147987 = varB4EAC82CA7396A68D541C85D26508E83_2048790781;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1101147987 = varB4EAC82CA7396A68D541C85D26508E83_1378744601;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1101147987.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1101147987;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.614 -0400", hash_original_method = "B9994ACC80E0363C78DC4EB28757C058", hash_generated_method = "A97A2C48E60DD223FF1F43FE15D1B955")
    public Reference<? extends T> remove() throws InterruptedException {
        Reference<? extends T> varB4EAC82CA7396A68D541C85D26508E83_1619959723 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1619959723 = remove(0L);
        varB4EAC82CA7396A68D541C85D26508E83_1619959723.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1619959723;
        // ---------- Original Method ----------
        //return remove(0L);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.617 -0400", hash_original_method = "55CFE9AF663FFFA3410902143F42A33C", hash_generated_method = "4DAA9443B8FA540AB78D4228B86E25CF")
    public synchronized Reference<? extends T> remove(long timeoutMillis) throws InterruptedException {
        Reference<? extends T> varB4EAC82CA7396A68D541C85D26508E83_884074998 = null; //Variable for return #1
        Reference<? extends T> varB4EAC82CA7396A68D541C85D26508E83_1731548039 = null; //Variable for return #2
        Reference<? extends T> varB4EAC82CA7396A68D541C85D26508E83_1929005724 = null; //Variable for return #3
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("timeout < 0: " + timeoutMillis);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_884074998 = poll();
        } //End block
        {
            {
                wait(0);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1731548039 = poll();
        } //End block
        long nanosToWait = timeoutMillis * NANOS_PER_MILLI;
        int timeoutNanos = 0;
        long startTime = System.nanoTime();
        {
            wait(timeoutMillis, timeoutNanos);
            long nanosElapsed = System.nanoTime() - startTime;
            long nanosRemaining = nanosToWait - nanosElapsed;
            timeoutMillis = nanosRemaining / NANOS_PER_MILLI;
            timeoutNanos = (int) (nanosRemaining - timeoutMillis * NANOS_PER_MILLI);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1929005724 = poll();
        addTaint(timeoutMillis);
        Reference<? extends T> varA7E53CE21691AB073D9660D615818899_88676665; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_88676665 = varB4EAC82CA7396A68D541C85D26508E83_884074998;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_88676665 = varB4EAC82CA7396A68D541C85D26508E83_1731548039;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_88676665 = varB4EAC82CA7396A68D541C85D26508E83_1929005724;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_88676665.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_88676665;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.618 -0400", hash_original_method = "A43A8FC0DB505099966EA05BCA8E1BC7", hash_generated_method = "9ECE3F5ABA51CE93DE1D21F9DBC7A9C4")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.618 -0400", hash_original_field = "90F159E16A269B6F875D096F21ED865D", hash_generated_field = "E32D593DEDB2FDC7FE0DFB7474352DBA")

    private static final int NANOS_PER_MILLI = 1000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.618 -0400", hash_original_field = "995097E066213348C3BBA01801EB2CBA", hash_generated_field = "4ECF0535730E811CDF8F487B61B191FD")

    public static Reference unenqueued = null;
}

