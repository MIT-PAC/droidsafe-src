/*
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/publicdomain/zero/1.0/
 */

package java.util.concurrent.atomic;

/**
 * An {@code AtomicMarkableReference} maintains an object reference
 * along with a mark bit, that can be updated atomically.
 *
 * <p>Implementation note: This implementation maintains markable
 * references by creating internal objects representing "boxed"
 * [reference, boolean] pairs.
 *
 * @since 1.5
 * @author Doug Lea
 * @param <V> The type of object referred to by this reference
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class AtomicMarkableReference<V> {

    private static class Pair<T> {
        static <T> Pair<T> of(T reference, boolean mark) {
            return new Pair<T>(reference, mark);
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.480 -0400", hash_original_field = "9AA758B93292CE24241117DA947733D9", hash_generated_field = "9AA758B93292CE24241117DA947733D9")

         T reference;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.481 -0400", hash_original_field = "BEBD5B55C5C91D81FBD2A439CA6E7BE0", hash_generated_field = "BEBD5B55C5C91D81FBD2A439CA6E7BE0")

         boolean mark;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.481 -0400", hash_original_method = "F35003E7C6B621585B421FC96CB6A301", hash_generated_method = "CEDDDB1BDAC1C08EC937B7B7AA14CB86")
        
private Pair(T reference, boolean mark) {
            this.reference = reference;
            this.mark = mark;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.486 -0400", hash_original_field = "3CDC466E57A745145BB720535953BC43", hash_generated_field = "42C3BEC243DA1A57DFC4FB82C324F252")


    private static final sun.misc.Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.487 -0400", hash_original_field = "32066985979901F6654657DFF9D7FC60", hash_generated_field = "DFEA52697B5C3D37F2A89D529E2C3C77")

    private static final long pairOffset =
        objectFieldOffset(UNSAFE, "pair", AtomicMarkableReference.class);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.488 -0400", hash_original_method = "AB96ED97F4B21B8760238DEC7BD056B4", hash_generated_method = "2DEA2A5047BC334C40FA23467D30FC1B")
    
static long objectFieldOffset(sun.misc.Unsafe UNSAFE,
                                  String field, Class<?> klazz) {
        try {
            return UNSAFE.objectFieldOffset(klazz.getDeclaredField(field));
        } catch (NoSuchFieldException e) {
            // Convert Exception to corresponding Error
            NoSuchFieldError error = new NoSuchFieldError(field);
            error.initCause(e);
            throw error;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.482 -0400", hash_original_field = "0F65541BB9DB9A2F48A2606929CB1FA1", hash_generated_field = "14FE3AEE3C50B91D66D1F89B08838CAE")


    private volatile Pair<V> pair;

    /**
     * Creates a new {@code AtomicMarkableReference} with the given
     * initial values.
     *
     * @param initialRef the initial reference
     * @param initialMark the initial mark
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.483 -0400", hash_original_method = "42F473007AD9C350DF83DCDEDD71C7F0", hash_generated_method = "EAA4045C112B689A3DC593C5FD041596")
    
public AtomicMarkableReference(V initialRef, boolean initialMark) {
        pair = Pair.of(initialRef, initialMark);
    }

    /**
     * Returns the current value of the reference.
     *
     * @return the current value of the reference
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.483 -0400", hash_original_method = "530A7145AB9AD77C70614364A6CDD5EE", hash_generated_method = "46C5F78F0974D5331A0EA50FF64036EF")
    
public V getReference() {
        return pair.reference;
    }

    /**
     * Returns the current value of the mark.
     *
     * @return the current value of the mark
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.484 -0400", hash_original_method = "FE4B8D7BDC2BC5EA73BFE2D5582C2DF7", hash_generated_method = "8E163135FFCE65EC07B847F759C17E8E")
    
public boolean isMarked() {
        return pair.mark;
    }

    /**
     * Returns the current values of both the reference and the mark.
     * Typical usage is {@code boolean[1] holder; ref = v.get(holder); }.
     *
     * @param markHolder an array of size of at least one. On return,
     * {@code markholder[0]} will hold the value of the mark.
     * @return the current value of the reference
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.484 -0400", hash_original_method = "346501377C11C40D44DC348130A905B5", hash_generated_method = "ACDB1D162D5BDD571A6CC671DDF31E12")
    
public V get(boolean[] markHolder) {
        Pair<V> pair = this.pair;
        markHolder[0] = pair.mark;
        return pair.reference;
    }

    /**
     * Atomically sets the value of both the reference and mark
     * to the given update values if the
     * current reference is {@code ==} to the expected reference
     * and the current mark is equal to the expected mark.
     *
     * <p><a href="package-summary.html#weakCompareAndSet">May fail
     * spuriously and does not provide ordering guarantees</a>, so is
     * only rarely an appropriate alternative to {@code compareAndSet}.
     *
     * @param expectedReference the expected value of the reference
     * @param newReference the new value for the reference
     * @param expectedMark the expected value of the mark
     * @param newMark the new value for the mark
     * @return true if successful
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.484 -0400", hash_original_method = "E6AF40C6FDE8A269D80195286E5D674E", hash_generated_method = "636EE154AF215B74A020E8C7C9FE8A2B")
    
public boolean weakCompareAndSet(V       expectedReference,
                                     V       newReference,
                                     boolean expectedMark,
                                     boolean newMark) {
        return compareAndSet(expectedReference, newReference,
                             expectedMark, newMark);
    }

    /**
     * Atomically sets the value of both the reference and mark
     * to the given update values if the
     * current reference is {@code ==} to the expected reference
     * and the current mark is equal to the expected mark.
     *
     * @param expectedReference the expected value of the reference
     * @param newReference the new value for the reference
     * @param expectedMark the expected value of the mark
     * @param newMark the new value for the mark
     * @return true if successful
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.485 -0400", hash_original_method = "C4865F46E5A2BB1F5AC4FED696185A5B", hash_generated_method = "76C27835EF21230B57D79D0F5BEF5CB7")
    
public boolean compareAndSet(V       expectedReference,
                                 V       newReference,
                                 boolean expectedMark,
                                 boolean newMark) {
        Pair<V> current = pair;
        return
            expectedReference == current.reference &&
            expectedMark == current.mark &&
            ((newReference == current.reference &&
              newMark == current.mark) ||
             casPair(current, Pair.of(newReference, newMark)));
    }

    /**
     * Unconditionally sets the value of both the reference and mark.
     *
     * @param newReference the new value for the reference
     * @param newMark the new value for the mark
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.485 -0400", hash_original_method = "DAA1662DC16613D5110B0FD056BCEDA7", hash_generated_method = "9FFDB63221E6BB23BE3E2F2E306BC2BD")
    
public void set(V newReference, boolean newMark) {
        Pair<V> current = pair;
        if (newReference != current.reference || newMark != current.mark)
            this.pair = Pair.of(newReference, newMark);
    }

    /**
     * Atomically sets the value of the mark to the given update value
     * if the current reference is {@code ==} to the expected
     * reference.  Any given invocation of this operation may fail
     * (return {@code false}) spuriously, but repeated invocation
     * when the current value holds the expected value and no other
     * thread is also attempting to set the value will eventually
     * succeed.
     *
     * @param expectedReference the expected value of the reference
     * @param newMark the new value for the mark
     * @return true if successful
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.486 -0400", hash_original_method = "AB429FF68845979469FD23F42857F47E", hash_generated_method = "36100E25D977B800140683628158E66D")
    
public boolean attemptMark(V expectedReference, boolean newMark) {
        Pair<V> current = pair;
        return
            expectedReference == current.reference &&
            (newMark == current.mark ||
             casPair(current, Pair.of(expectedReference, newMark)));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.487 -0400", hash_original_method = "C1D5D6F205264E0DD876F79FC7EA9A5C", hash_generated_method = "52CAEC7EBD3E9105FDD719993E8F962E")
    
private boolean casPair(Pair<V> cmp, Pair<V> val) {
        return UNSAFE.compareAndSwapObject(this, pairOffset, cmp, val);
    }
}
