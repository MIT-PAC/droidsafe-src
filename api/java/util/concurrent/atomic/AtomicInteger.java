package java.util.concurrent.atomic;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import sun.misc.Unsafe;

public class AtomicInteger extends Number implements java.io.Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.314 -0500", hash_original_field = "EDA2AEC613B19DD5D3B8D8B483F792BA", hash_generated_field = "BC575BADA52C64A5C5C6ADD1B81BACA0")

    private static final long serialVersionUID = 6214790243416807050L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.317 -0500", hash_original_field = "888B3F05664BAF88334D2C14A4DA8138", hash_generated_field = "E7D465D52C267C4626E00B16AF4442B8")

    private static final Unsafe unsafe = UnsafeAccess.THE_ONE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.320 -0500", hash_original_field = "2B4D3697B0BD0FB4DB161026EA588EEA", hash_generated_field = "3ACE806C2A776E8F67FFC072288734E8")

    private static  long valueOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.323 -0500", hash_original_field = "2A5EA2B60261C751D318C2CB32BF7CEC", hash_generated_field = "AACF1191CE0421BEFC63226B2561E15D")

    private volatile int value;

    /**
     * Creates a new AtomicInteger with the given initial value.
     *
     * @param initialValue the initial value
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.325 -0500", hash_original_method = "A3EEEE607FBEBD432F4111F47BB23345", hash_generated_method = "F0670CE27A83C450C2A4000B5E8C2390")
    
public AtomicInteger(int initialValue) {
        value = initialValue;
    }

    /**
     * Creates a new AtomicInteger with initial value {@code 0}.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.328 -0500", hash_original_method = "3B74ED36698F9901BA50127D104C26DE", hash_generated_method = "0E6B9C34F7A1BCF5C7C73F35173892F1")
    
public AtomicInteger() {
    }

    /**
     * Gets the current value.
     *
     * @return the current value
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.330 -0500", hash_original_method = "2C5A1089E8025181868581E48D922F38", hash_generated_method = "703E0755BD925C4D70E557B53D2BF771")
    
public final int get() {
        return value;
    }

    /**
     * Sets to the given value.
     *
     * @param newValue the new value
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.333 -0500", hash_original_method = "E51FD8A91C159D9D3ED3BF52073569AD", hash_generated_method = "C05E959756CFE2654FE95A60FD2AD98E")
    
public final void set(int newValue) {
        value = newValue;
    }

    /**
     * Eventually sets to the given value.
     *
     * @param newValue the new value
     * @since 1.6
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.336 -0500", hash_original_method = "77EB9E59BE67AA43485FF3A0F0492CB7", hash_generated_method = "4CD52BDA532FC5AB7C0B2B2E1A0C3792")
    
public final void lazySet(int newValue) {
        unsafe.putOrderedInt(this, valueOffset, newValue);
    }

    /**
     * Atomically sets to the given value and returns the old value.
     *
     * @param newValue the new value
     * @return the previous value
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.338 -0500", hash_original_method = "EFF79965BA8CD7578F2A5616273687C7", hash_generated_method = "459912E78FA47DBEC8F8D999BA2FBD0D")
    
public final int getAndSet(int newValue) {
        for (;;) {
            int current = get();
            if (compareAndSet(current, newValue))
                return current;
        }
    }

    /**
     * Atomically sets the value to the given updated value
     * if the current value {@code ==} the expected value.
     *
     * @param expect the expected value
     * @param update the new value
     * @return true if successful. False return indicates that
     * the actual value was not equal to the expected value.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.340 -0500", hash_original_method = "3CF6D7A3DD4EDBE8D1648E756B160F53", hash_generated_method = "1B4BBA8A27DFE3B91E1C4A1B3C9EAA69")
    
public final boolean compareAndSet(int expect, int update) {
        return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
    }

    /**
     * Atomically sets the value to the given updated value
     * if the current value {@code ==} the expected value.
     *
     * <p>May <a href="package-summary.html#Spurious">fail spuriously</a>
     * and does not provide ordering guarantees, so is only rarely an
     * appropriate alternative to {@code compareAndSet}.
     *
     * @param expect the expected value
     * @param update the new value
     * @return true if successful.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.343 -0500", hash_original_method = "22EC2300FEC70C46ECF009D542FC9430", hash_generated_method = "9EF3B090C06F7BFF42DD435957FE768B")
    
public final boolean weakCompareAndSet(int expect, int update) {
        return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
    }

    /**
     * Atomically increments by one the current value.
     *
     * @return the previous value
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.345 -0500", hash_original_method = "621C33BC86CD3122044A53600F895B29", hash_generated_method = "425725E2DE13479856F360A7F13BBBA6")
    
public final int getAndIncrement() {
        for (;;) {
            int current = get();
            int next = current + 1;
            if (compareAndSet(current, next))
                return current;
        }
    }

    /**
     * Atomically decrements by one the current value.
     *
     * @return the previous value
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.348 -0500", hash_original_method = "D5257E8A410056D1BB1DB7447390EAE5", hash_generated_method = "8C7CA472D5F813D9D0A3E6E453CD9E55")
    
public final int getAndDecrement() {
        for (;;) {
            int current = get();
            int next = current - 1;
            if (compareAndSet(current, next))
                return current;
        }
    }

    /**
     * Atomically adds the given value to the current value.
     *
     * @param delta the value to add
     * @return the previous value
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.351 -0500", hash_original_method = "4B803B85C89B0C062A735FA86D4518AE", hash_generated_method = "95C75EF25F3A5B40B217926C833417D1")
    
public final int getAndAdd(int delta) {
        for (;;) {
            int current = get();
            int next = current + delta;
            if (compareAndSet(current, next))
                return current;
        }
    }

    /**
     * Atomically increments by one the current value.
     *
     * @return the updated value
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.353 -0500", hash_original_method = "6DC45C427ABFB1C3B7D74803EAAF22FF", hash_generated_method = "0B6200F869F0C82E61A1C6A81CB8263D")
    
public final int incrementAndGet() {
        for (;;) {
            int current = get();
            int next = current + 1;
            if (compareAndSet(current, next))
                return next;
        }
    }

    /**
     * Atomically decrements by one the current value.
     *
     * @return the updated value
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.356 -0500", hash_original_method = "4357F9DD6725F5F393683EE2EA89C677", hash_generated_method = "64BF2D5FDACCDB13E451FABAE036B245")
    
public final int decrementAndGet() {
        for (;;) {
            int current = get();
            int next = current - 1;
            if (compareAndSet(current, next))
                return next;
        }
    }

    /**
     * Atomically adds the given value to the current value.
     *
     * @param delta the value to add
     * @return the updated value
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.359 -0500", hash_original_method = "5280B98EAB69F2A556138E3D06C4D0D3", hash_generated_method = "0AE1F741F0946B437A1E22F6DD01A830")
    
public final int addAndGet(int delta) {
        for (;;) {
            int current = get();
            int next = current + delta;
            if (compareAndSet(current, next))
                return next;
        }
    }

    /**
     * Returns the String representation of the current value.
     * @return the String representation of the current value.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.361 -0500", hash_original_method = "0CBFF056CB46F189F8DC45AFB469D5F9", hash_generated_method = "D0001D1DA32AF75F5957F8071053FA0F")
    
public String toString() {
        return Integer.toString(get());
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.363 -0500", hash_original_method = "B90EC926C8275C97256DF1E0AD9FC076", hash_generated_method = "78E09736EA0B907CA81C02E14B9D2D57")
    
public int intValue() {
        return get();
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.365 -0500", hash_original_method = "41D936CCD9A9D16949AE3FD60738B8AD", hash_generated_method = "04195FC3A55F3D732B787FB3633E9A7D")
    
public long longValue() {
        return (long)get();
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.368 -0500", hash_original_method = "F8181329F165428C51D2197BB97797EF", hash_generated_method = "225ECFECD93F68C7D435A4909B28BB0D")
    
public float floatValue() {
        return (float)get();
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.371 -0500", hash_original_method = "486C42E34E3619D90E05BCBEDA3844AE", hash_generated_method = "45341808FAD3EC3D7016C92E90DEA5E8")
    
public double doubleValue() {
        return (double)get();
    }
    static {
      try {
        valueOffset = unsafe.objectFieldOffset
            (AtomicInteger.class.getDeclaredField("value"));
      } catch (Exception ex) { throw new Error(ex); }
    }
    
}

