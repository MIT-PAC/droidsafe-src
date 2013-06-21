package java.lang.ref;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class FinalizerReference<T> extends Reference<T> {
    private T zombie;
    private FinalizerReference prev;
    private FinalizerReference next;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.707 -0400", hash_original_method = "794711F8A2A85EA506452F6F39733664", hash_generated_method = "E9D2674FD9EDFF04F073132BAA4A0C01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FinalizerReference(T r, ReferenceQueue<? super T> q) {
        super(r, q);
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(q.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.707 -0400", hash_original_method = "832B7710CFA0BEA3E25E81BFE41C7B96", hash_generated_method = "9CE9B27573DEAE2EF965D655347FEBD3")
    @DSModeled(DSC.SAFE)
    @Override
    public T get() {
        return (T)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return zombie;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.708 -0400", hash_original_method = "B5E36D5C5E2E18FD73C503842BC207C6", hash_generated_method = "AA79A11271518D347BCB1CB74D552364")
    @DSModeled(DSC.SAFE)
    @Override
    public void clear() {
        zombie = null;
        // ---------- Original Method ----------
        //zombie = null;
    }

    
        static void add(Object referent) {
        FinalizerReference<?> reference = new FinalizerReference<Object>(referent, queue);
        synchronized (FinalizerReference.class) {
            reference.prev = null;
            reference.next = head;
            if (head != null) {
                head.prev = reference;
            }
            head = reference;
        }
    }

    
        public static void remove(FinalizerReference reference) {
        synchronized (FinalizerReference.class) {
            FinalizerReference next = reference.next;
            FinalizerReference prev = reference.prev;
            reference.next = null;
            reference.prev = null;
            if (prev != null) {
                prev.next = next;
            } else {
                head = next;
            }
            if (next != null) {
                next.prev = prev;
            }
        }
    }

    
        public static void finalizeAllEnqueued() throws InterruptedException {
        Sentinel sentinel = new Sentinel();
        FinalizerReference<Object> reference = new FinalizerReference<Object>(null, queue);
        reference.zombie = sentinel;
        reference.enqueueInternal();
        sentinel.awaitFinalization();
    }

    
    private static class Sentinel {
        boolean finalized = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.708 -0400", hash_original_method = "4488DA5EA3835A576C1BA348BF212030", hash_generated_method = "4488DA5EA3835A576C1BA348BF212030")
                public Sentinel ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.708 -0400", hash_original_method = "0B77E3D00E3E63F9573A7AA23F424DE4", hash_generated_method = "C853D95507C1B6CBA3AFB545F976D807")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected synchronized void finalize() throws Throwable {
            finalized = true;
            notifyAll();
            // ---------- Original Method ----------
            //finalized = true;
            //notifyAll();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.709 -0400", hash_original_method = "A29097CA472383A8F0DF21D7D263FC96", hash_generated_method = "D6E8CB57AB6F46B5CCA224F7EDA538A5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        synchronized void awaitFinalization() throws InterruptedException {
            {
                wait();
            } //End block
            // ---------- Original Method ----------
            //while (!finalized) {
                //wait();
            //}
        }

        
    }


    
    public static final ReferenceQueue<Object> queue = new ReferenceQueue<Object>();
    private static FinalizerReference head = null;
}

