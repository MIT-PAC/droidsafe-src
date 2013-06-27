package java.lang.ref;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class FinalizerReference<T> extends Reference<T> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.899 -0400", hash_original_field = "0EDA241FC65CCF35D9743309AC395215", hash_generated_field = "F4C159F0B6076ECC1F9CAA1CB201F6E0")

    private T zombie;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.899 -0400", hash_original_field = "FCB08B164AC83E09964DEB24F2D2E80B", hash_generated_field = "931A49835AE6DF8D2727A2766B72C4E8")

    private FinalizerReference prev;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.899 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "0895DC7BB9249EF0B39CCA8400E2652C")

    private FinalizerReference next;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.900 -0400", hash_original_method = "794711F8A2A85EA506452F6F39733664", hash_generated_method = "73CE904CF1B06B9C2B91D70E1BEB41EC")
    public  FinalizerReference(T r, ReferenceQueue<? super T> q) {
        super(r, q);
        addTaint(r.getTaint());
        addTaint(q.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.913 -0400", hash_original_method = "832B7710CFA0BEA3E25E81BFE41C7B96", hash_generated_method = "965F3CF4A890F1C8EACB1E4C04B378BB")
    @Override
    public T get() {
        T varB4EAC82CA7396A68D541C85D26508E83_1327876599 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1327876599 = zombie;
        varB4EAC82CA7396A68D541C85D26508E83_1327876599.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1327876599;
        // ---------- Original Method ----------
        //return zombie;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.913 -0400", hash_original_method = "B5E36D5C5E2E18FD73C503842BC207C6", hash_generated_method = "AA79A11271518D347BCB1CB74D552364")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.914 -0400", hash_original_field = "7444D387F44EDE1F73252C1AE20DC826", hash_generated_field = "BBB41717FFD03365F94834C608C18643")

        boolean finalized = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.914 -0400", hash_original_method = "E2AD40226AFB74C4AE2C6FB439A5AA79", hash_generated_method = "E2AD40226AFB74C4AE2C6FB439A5AA79")
        public Sentinel ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.914 -0400", hash_original_method = "0B77E3D00E3E63F9573A7AA23F424DE4", hash_generated_method = "C853D95507C1B6CBA3AFB545F976D807")
        @Override
        protected synchronized void finalize() throws Throwable {
            finalized = true;
            notifyAll();
            // ---------- Original Method ----------
            //finalized = true;
            //notifyAll();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.915 -0400", hash_original_method = "A29097CA472383A8F0DF21D7D263FC96", hash_generated_method = "D6E8CB57AB6F46B5CCA224F7EDA538A5")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.915 -0400", hash_original_field = "E491E49FF2A29423B3EC90DBE3F3F909", hash_generated_field = "ACA725B85508F4962A184A7170B54E9F")

    public static final ReferenceQueue<Object> queue = new ReferenceQueue<Object>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.915 -0400", hash_original_field = "E44CB42EFC4A81D53C78F68458FE60A7", hash_generated_field = "F1FE4453AD6DA8D79B965F88B219654D")

    private static FinalizerReference head = null;
}

