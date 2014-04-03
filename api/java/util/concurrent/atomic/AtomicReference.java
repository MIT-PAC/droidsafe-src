package java.util.concurrent.atomic;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import sun.misc.Unsafe;

public class AtomicReference<V> implements java.io.Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.189 -0500", hash_original_field = "823BEC65A4A881166696CB1BF2DFCDEF", hash_generated_field = "F377B552F3A51EC0DBE8D7F8863A64C0")

    private static final long serialVersionUID = -1848883965231344442L;

/*
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.192 -0500", hash_original_field = "888B3F05664BAF88334D2C14A4DA8138", hash_generated_field = "E7D465D52C267C4626E00B16AF4442B8")

    private static final Unsafe unsafe = UnsafeAccess.THE_ONE;
*/
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.194 -0500", hash_original_field = "2B4D3697B0BD0FB4DB161026EA588EEA", hash_generated_field = "3ACE806C2A776E8F67FFC072288734E8")

    private static  long valueOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.197 -0500", hash_original_field = "A7E8A049E4C72FD5713D3AFD6CBF7C08", hash_generated_field = "FA4D8CAB2A7D5C460EB507A64EFD91CB")

    private volatile V value;

    /**
     * Creates a new AtomicReference with the given initial value.
     *
     * @param initialValue the initial value
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.200 -0500", hash_original_method = "BDBA762FEAF5C103321D9E7FB6720E1A", hash_generated_method = "A5963EF9635EBF2275DCE7C1479416FD")
    
public AtomicReference(V initialValue) {
        value = initialValue;
    }

    /**
     * Creates a new AtomicReference with null initial value.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.203 -0500", hash_original_method = "F97CF4B9707D277EAF947474019CC6FE", hash_generated_method = "CEE6F0364685959E02A5037951EEC7AB")
    
public AtomicReference() {
    }
    
    @Override
    public void addTaint(DSTaintObject t) {
        super.addTaint(t);
        value.addTaint(t);
    }
    
    @Override
    public void addTaint(double t) {
        super.addTaint(t);
        value.addTaint(t);
    }

    /**
     * Gets the current value.
     *
     * @return the current value
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.205 -0500", hash_original_method = "479D74F52EAA9F8F31AB11658696490B", hash_generated_method = "48DC9DDD5B35A417180739369A87118B")
    
public final V get() {
        return value;
    }

    /**
     * Sets to the given value.
     *
     * @param newValue the new value
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.207 -0500", hash_original_method = "1165CC32E796F42C2841421B342AA16F", hash_generated_method = "3F4039B38D30B5F2D908B9ACDB4E9C3A")
    
public final void set(V newValue) {
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.209 -0500", hash_original_method = "5F145FC62F46FF5FAD786BED834DE8D5", hash_generated_method = "296FEC93AA3A03604C3649376F898A7D")
    
public final void lazySet(V newValue) {
        set(newValue);
    }

    /**
     * Atomically sets the value to the given updated value
     * if the current value {@code ==} the expected value.
     * @param expect the expected value
     * @param update the new value
     * @return true if successful. False return indicates that
     * the actual value was not equal to the expected value.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.212 -0500", hash_original_method = "069E7BB7A98500BAF130264F81E7ADC7", hash_generated_method = "55A18E7DD94B7439EA730F0CF8FEAE6F")
    
public final boolean compareAndSet(V expect, V update) {
        set(expect);
        set(update);
        return value.getTaintBoolean();
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.215 -0500", hash_original_method = "801403A92781688D40B445FC7E652974", hash_generated_method = "EB801DEAE4DF2E72BBC54D899262BEAE")
    
public final boolean weakCompareAndSet(V expect, V update) {
        set(expect);
        set(update);
        return value.getTaintBoolean();
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.217 -0500", hash_original_method = "FD7BCDEFF552AB71FCB964A4983AD19B", hash_generated_method = "DEF91DF473EB9A1AA2087DFAFB68BC02")
    
public final V getAndSet(V newValue) {
        set(newValue);
        return value;
    }

    /**
     * Returns the String representation of the current value.
     * @return the String representation of the current value.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.220 -0500", hash_original_method = "2EE45E1B1B1F9797465CA7143D35DB76", hash_generated_method = "972BE3736CB2D8DD7338471E5787D8D4")
    
public String toString() {
        return String.valueOf(get());
    }
    /*
    static {
      try {
        valueOffset = unsafe.objectFieldOffset
            (AtomicReference.class.getDeclaredField("value"));
      } catch (Exception ex) { throw new Error(ex); }
    }
    */
    
}

