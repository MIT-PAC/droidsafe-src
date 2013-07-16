package java.lang.ref;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class ReferenceQueue<T> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.848 -0400", hash_original_field = "96E89A298E0A9F469B9AE458D6AFAE9F", hash_generated_field = "0D4E357872E15A12A6822EA05A1FF146")

    private Reference<? extends T> head;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.848 -0400", hash_original_method = "74975F7A6AFB5E81CCF3457B53FB8A14", hash_generated_method = "77FCC81AFA085C6B3B372539AC2D673F")
    public  ReferenceQueue() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.849 -0400", hash_original_method = "0715328D7F7BB9D5550B9E381C496C43", hash_generated_method = "53FE4B4CAEAFF86C2EEE39EC7F2BED18")
    @SuppressWarnings("unchecked")
    public synchronized Reference<? extends T> poll() {
    if(head == null)        
        {
Reference<? extends T> var540C13E9E156B687226421B24F2DF178_1027415800 =             null;
            var540C13E9E156B687226421B24F2DF178_1027415800.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1027415800;
        } //End block
        Reference<? extends T> ret;
        ret = head;
    if(head == head.queueNext)        
        {
            head = null;
        } //End block
        else
        {
            head = head.queueNext;
        } //End block
        ret.queueNext = null;
Reference<? extends T> varEDFF4FBBF053B5DC2B444ADFA049EE0F_30853424 =         ret;
        varEDFF4FBBF053B5DC2B444ADFA049EE0F_30853424.addTaint(taint);
        return varEDFF4FBBF053B5DC2B444ADFA049EE0F_30853424;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.850 -0400", hash_original_method = "B9994ACC80E0363C78DC4EB28757C058", hash_generated_method = "57FEC471F7FC66AAF6A78D28543436FC")
    public Reference<? extends T> remove() throws InterruptedException {
Reference<? extends T> varE6CD9C3CBCBF3FEE243975EEDE7D6FE2_335026396 =         remove(0L);
        varE6CD9C3CBCBF3FEE243975EEDE7D6FE2_335026396.addTaint(taint);
        return varE6CD9C3CBCBF3FEE243975EEDE7D6FE2_335026396;
        // ---------- Original Method ----------
        //return remove(0L);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.851 -0400", hash_original_method = "55CFE9AF663FFFA3410902143F42A33C", hash_generated_method = "2F7494D786BD777405547A22B55E163C")
    public synchronized Reference<? extends T> remove(long timeoutMillis) throws InterruptedException {
        addTaint(timeoutMillis);
    if(timeoutMillis < 0)        
        {
            IllegalArgumentException varBF8C762F323E587BBBD4D39227A95BAA_935921828 = new IllegalArgumentException("timeout < 0: " + timeoutMillis);
            varBF8C762F323E587BBBD4D39227A95BAA_935921828.addTaint(taint);
            throw varBF8C762F323E587BBBD4D39227A95BAA_935921828;
        } //End block
    if(head != null)        
        {
Reference<? extends T> varC10671BA8D668DFB8A785023F8120AFE_552516576 =             poll();
            varC10671BA8D668DFB8A785023F8120AFE_552516576.addTaint(taint);
            return varC10671BA8D668DFB8A785023F8120AFE_552516576;
        } //End block
    if(timeoutMillis == 0 || (timeoutMillis > Long.MAX_VALUE / NANOS_PER_MILLI))        
        {
            do {
                {
                    wait(0);
                } //End block
} while (head == null);
Reference<? extends T> varC10671BA8D668DFB8A785023F8120AFE_1677807151 =             poll();
            varC10671BA8D668DFB8A785023F8120AFE_1677807151.addTaint(taint);
            return varC10671BA8D668DFB8A785023F8120AFE_1677807151;
        } //End block
        long nanosToWait = timeoutMillis * NANOS_PER_MILLI;
        int timeoutNanos = 0;
        long startTime = System.nanoTime();
        while
(true)        
        {
            wait(timeoutMillis, timeoutNanos);
    if(head != null)            
            {
                break;
            } //End block
            long nanosElapsed = System.nanoTime() - startTime;
            long nanosRemaining = nanosToWait - nanosElapsed;
    if(nanosRemaining <= 0)            
            {
                break;
            } //End block
            timeoutMillis = nanosRemaining / NANOS_PER_MILLI;
            timeoutNanos = (int) (nanosRemaining - timeoutMillis * NANOS_PER_MILLI);
        } //End block
Reference<? extends T> varC10671BA8D668DFB8A785023F8120AFE_1471148072 =         poll();
        varC10671BA8D668DFB8A785023F8120AFE_1471148072.addTaint(taint);
        return varC10671BA8D668DFB8A785023F8120AFE_1471148072;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.852 -0400", hash_original_method = "A43A8FC0DB505099966EA05BCA8E1BC7", hash_generated_method = "37F7E01C350A4CF2309A14DAEAA77106")
    synchronized void enqueue(Reference<? extends T> reference) {
    if(head == null)        
        {
            reference.queueNext = reference;
        } //End block
        else
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.853 -0400", hash_original_field = "90F159E16A269B6F875D096F21ED865D", hash_generated_field = "E32D593DEDB2FDC7FE0DFB7474352DBA")

    private static final int NANOS_PER_MILLI = 1000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.853 -0400", hash_original_field = "995097E066213348C3BBA01801EB2CBA", hash_generated_field = "4ECF0535730E811CDF8F487B61B191FD")

    public static Reference unenqueued = null;
}

