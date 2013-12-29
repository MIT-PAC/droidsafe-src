package java.lang.ref;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public class PhantomReference<T> extends Reference<T> {

    /**
     * Constructs a new phantom reference and registers it with the given
     * reference queue. The reference queue may be {@code null}, but this case
     * does not make any sense, since the reference will never be enqueued, and
     * the {@link #get()} method always returns {@code null}.
     *
     * @param r the referent to track
     * @param q the queue to register the phantom reference object with
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.606 -0500", hash_original_method = "269EAD0EE18A562FFF5DDE7409E1AEEE", hash_generated_method = "4727728D6D4C47B3855AF188ED24FE94")
    public PhantomReference(T r, ReferenceQueue<? super T> q) {
        super(r, q);
    }

    /**
     * Returns {@code null}.  The referent of a phantom reference is not
     * accessible.
     *
     * @return {@code null} (always)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.607 -0500", hash_original_method = "11AC17D1A4195077BEA3CC915127101C", hash_generated_method = "9D8C05BF72C06ED6D6C3876E93EDC03F")
    @Override
public T get() {
        return null;
    }

    
}

