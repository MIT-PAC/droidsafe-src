package java.lang.ref;

// Droidsafe Imports
import droidsafe.annotations.*;





public final class FinalizerReference<T> extends Reference<T> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.758 -0400", hash_original_field = "0EDA241FC65CCF35D9743309AC395215", hash_generated_field = "F4C159F0B6076ECC1F9CAA1CB201F6E0")

    private T zombie;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.759 -0400", hash_original_field = "FCB08B164AC83E09964DEB24F2D2E80B", hash_generated_field = "931A49835AE6DF8D2727A2766B72C4E8")

    private FinalizerReference prev;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.759 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "0895DC7BB9249EF0B39CCA8400E2652C")

    private FinalizerReference next;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.759 -0400", hash_original_method = "794711F8A2A85EA506452F6F39733664", hash_generated_method = "42DCF29ACAFCD1B3BB33325026979E23")
    public  FinalizerReference(T r, ReferenceQueue<? super T> q) {
        super(r, q);
        addTaint(q.getTaint());
        addTaint(r.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.759 -0400", hash_original_method = "832B7710CFA0BEA3E25E81BFE41C7B96", hash_generated_method = "235D170ABA453556898E79DC3497E234")
    @Override
    public T get() {
T var21716E4C70987A9F4C0F382061B0AD90_1452399684 =         zombie;
        var21716E4C70987A9F4C0F382061B0AD90_1452399684.addTaint(taint);
        return var21716E4C70987A9F4C0F382061B0AD90_1452399684;
        // ---------- Original Method ----------
        //return zombie;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.759 -0400", hash_original_method = "B5E36D5C5E2E18FD73C503842BC207C6", hash_generated_method = "AA79A11271518D347BCB1CB74D552364")
    @Override
    public void clear() {
        zombie = null;
        // ---------- Original Method ----------
        //zombie = null;
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
    public static void finalizeAllEnqueued() throws InterruptedException {
        Sentinel sentinel = new Sentinel();
        FinalizerReference<Object> reference = new FinalizerReference<Object>(null, queue);
        reference.zombie = sentinel;
        reference.enqueueInternal();
        sentinel.awaitFinalization();
    }

    
    private static class Sentinel {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.761 -0400", hash_original_field = "7444D387F44EDE1F73252C1AE20DC826", hash_generated_field = "BBB41717FFD03365F94834C608C18643")

        boolean finalized = false;
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.761 -0400", hash_original_method = "E2AD40226AFB74C4AE2C6FB439A5AA79", hash_generated_method = "E2AD40226AFB74C4AE2C6FB439A5AA79")
        public Sentinel ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.762 -0400", hash_original_method = "0B77E3D00E3E63F9573A7AA23F424DE4", hash_generated_method = "C853D95507C1B6CBA3AFB545F976D807")
        @Override
        protected synchronized void finalize() throws Throwable {
            finalized = true;
            notifyAll();
            // ---------- Original Method ----------
            //finalized = true;
            //notifyAll();
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.762 -0400", hash_original_method = "A29097CA472383A8F0DF21D7D263FC96", hash_generated_method = "F9EBC14D37BCEB0BC09147006A13433A")
        synchronized void awaitFinalization() throws InterruptedException {
            while
(!finalized)            
            {
                wait();
            } //End block
            // ---------- Original Method ----------
            //while (!finalized) {
                //wait();
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.762 -0400", hash_original_field = "E491E49FF2A29423B3EC90DBE3F3F909", hash_generated_field = "ACA725B85508F4962A184A7170B54E9F")

    public static final ReferenceQueue<Object> queue = new ReferenceQueue<Object>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.763 -0400", hash_original_field = "E44CB42EFC4A81D53C78F68458FE60A7", hash_generated_field = "F1FE4453AD6DA8D79B965F88B219654D")

    private static FinalizerReference head = null;
}

