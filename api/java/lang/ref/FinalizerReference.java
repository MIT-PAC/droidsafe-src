package java.lang.ref;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public final class FinalizerReference<T> extends Reference<T> {

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.855 -0500", hash_original_method = "9DC5C682C66521FC5D3F7542530076A6", hash_generated_method = "ED5A546F7FBC0B84D692AD55F97BB409")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.858 -0500", hash_original_method = "F978B40AB2D74AD3C7D7AAFC252D0863", hash_generated_method = "2AADD692CE24C688AD0AB86653BFFF43")
    
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

    /**
     * Returns once all currently-enqueued references have been finalized.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.861 -0500", hash_original_method = "093D6CB6B4451769E91B74C04E5F7D4D", hash_generated_method = "2E8F1D472E39A46FC75E0E5ADF04BCAD")
    
public static void finalizeAllEnqueued() throws InterruptedException {
        Sentinel sentinel = new Sentinel();
        FinalizerReference<Object> reference = new FinalizerReference<Object>(null, queue);
        reference.zombie = sentinel;
        reference.enqueueInternal();
        sentinel.awaitFinalization();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.835 -0500", hash_original_field = "E08CBE8674EF0D8CC4258C6544AEC21B", hash_generated_field = "ACA725B85508F4962A184A7170B54E9F")

    public static final ReferenceQueue<Object> queue = new ReferenceQueue<Object>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.838 -0500", hash_original_field = "1CC7A4653A23EB08329071CAC890A98D", hash_generated_field = "F1FE4453AD6DA8D79B965F88B219654D")

    private static FinalizerReference head = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.840 -0500", hash_original_field = "4C0E2919F6ADDA77126DC96D2888F52C", hash_generated_field = "F4C159F0B6076ECC1F9CAA1CB201F6E0")

    private T zombie;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.843 -0500", hash_original_field = "6ADD3C23DE4F6DD631E595B78BA351C2", hash_generated_field = "931A49835AE6DF8D2727A2766B72C4E8")

    private FinalizerReference prev;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.845 -0500", hash_original_field = "9E13E0CDDC18CB6C99B721F8B813CCED", hash_generated_field = "0895DC7BB9249EF0B39CCA8400E2652C")

    private FinalizerReference next;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.848 -0500", hash_original_method = "794711F8A2A85EA506452F6F39733664", hash_generated_method = "EBD04AFD7D005F46724994DC7F4E5D2B")
    
public FinalizerReference(T r, ReferenceQueue<? super T> q) {
        super(r, q);
    }
    
    private static class Sentinel {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.864 -0500", hash_original_field = "BBB41717FFD03365F94834C608C18643", hash_generated_field = "BBB41717FFD03365F94834C608C18643")

        boolean finalized = false;
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.761 -0400", hash_original_method = "E2AD40226AFB74C4AE2C6FB439A5AA79", hash_generated_method = "E2AD40226AFB74C4AE2C6FB439A5AA79")
        public Sentinel ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.867 -0500", hash_original_method = "0B77E3D00E3E63F9573A7AA23F424DE4", hash_generated_method = "AB9F9E254821C381F9E3DFA75177581B")
        
@Override protected synchronized void finalize() throws Throwable {
            finalized = true;
            notifyAll();
        }
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.870 -0500", hash_original_method = "A29097CA472383A8F0DF21D7D263FC96", hash_generated_method = "106B6DFB59807D9A553C254965EC984E")
        
synchronized void awaitFinalization() throws InterruptedException {
            while (!finalized) {
                wait();
            }
        }
        
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.850 -0500", hash_original_method = "832B7710CFA0BEA3E25E81BFE41C7B96", hash_generated_method = "0952BA6CBF47F9BAD62AEB744FFFEA47")
    
@Override
    public T get() {
        return zombie;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.853 -0500", hash_original_method = "B5E36D5C5E2E18FD73C503842BC207C6", hash_generated_method = "DFD8A987C8D1EC1496BF858C8F01453B")
    
@Override
    public void clear() {
        zombie = null;
    }
}

