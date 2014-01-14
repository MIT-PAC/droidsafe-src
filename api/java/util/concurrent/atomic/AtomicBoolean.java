package java.util.concurrent.atomic;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import sun.misc.Unsafe;

public class AtomicBoolean implements java.io.Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.071 -0500", hash_original_field = "FA01BDB879BB99A8D2FB4230076CD508", hash_generated_field = "0560675D9B140F497F7B6539FEA0318E")

    private static final long serialVersionUID = 4654671469794556979L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.073 -0500", hash_original_field = "888B3F05664BAF88334D2C14A4DA8138", hash_generated_field = "E7D465D52C267C4626E00B16AF4442B8")

    private static final Unsafe unsafe = UnsafeAccess.THE_ONE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.076 -0500", hash_original_field = "2B4D3697B0BD0FB4DB161026EA588EEA", hash_generated_field = "3ACE806C2A776E8F67FFC072288734E8")

    private static  long valueOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.078 -0500", hash_original_field = "2A5EA2B60261C751D318C2CB32BF7CEC", hash_generated_field = "AACF1191CE0421BEFC63226B2561E15D")

    private volatile int value;

    /**
     * Creates a new {@code AtomicBoolean} with the given initial value.
     *
     * @param initialValue the initial value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.082 -0500", hash_original_method = "2D4043190EFF6FBF71F6E61F91ACE979", hash_generated_method = "22155F1CEA387050B46DD1FA608FC521")
    
public AtomicBoolean(boolean initialValue) {
        value = initialValue ? 1 : 0;
    }

    /**
     * Creates a new {@code AtomicBoolean} with initial value {@code false}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.084 -0500", hash_original_method = "4EFA45A0BE6632C845A9BA70932A5A0A", hash_generated_method = "DD75D899E8FB229720E6C75B96D2B634")
    
public AtomicBoolean() {
    }

    /**
     * Returns the current value.
     *
     * @return the current value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.087 -0500", hash_original_method = "5ABD420FFDECFAFBA90B6FD43E53DADE", hash_generated_method = "2A5391E4D85B9017AC3F9C1E1F50A417")
    
public final boolean get() {
        return value != 0;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.090 -0500", hash_original_method = "F4EDC6324B18AED31374999FCFCE4700", hash_generated_method = "A44868BB070126C586D116031BF7BDEA")
    
public final boolean compareAndSet(boolean expect, boolean update) {
        int e = expect ? 1 : 0;
        int u = update ? 1 : 0;
        return unsafe.compareAndSwapInt(this, valueOffset, e, u);
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.096 -0500", hash_original_method = "788D44D9ED0FFD916FA1001367F68A82", hash_generated_method = "CD9B06279AE1596651A40D0F8BE72E2B")
    
public boolean weakCompareAndSet(boolean expect, boolean update) {
        int e = expect ? 1 : 0;
        int u = update ? 1 : 0;
        return unsafe.compareAndSwapInt(this, valueOffset, e, u);
    }

    /**
     * Unconditionally sets to the given value.
     *
     * @param newValue the new value
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.099 -0500", hash_original_method = "FD0CF162327E2AB30C8884FB52F6FB5F", hash_generated_method = "B7867BD27F3347CA40707405C7C5B66A")
    
public final void set(boolean newValue) {
        value = newValue ? 1 : 0;
    }

    /**
     * Eventually sets to the given value.
     *
     * @param newValue the new value
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.101 -0500", hash_original_method = "CA687482363D6F32107DA02B75F4C570", hash_generated_method = "38099AD6E6A367E1D914C6C541A62172")
    
public final void lazySet(boolean newValue) {
        int v = newValue ? 1 : 0;
        unsafe.putOrderedInt(this, valueOffset, v);
    }

    /**
     * Atomically sets to the given value and returns the previous value.
     *
     * @param newValue the new value
     * @return the previous value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.104 -0500", hash_original_method = "E903BF98EDD2BB9EFF497ED0D64C109B", hash_generated_method = "880640B07998C4C0047A34C015B6399D")
    
public final boolean getAndSet(boolean newValue) {
        for (;;) {
            boolean current = get();
            if (compareAndSet(current, newValue))
                return current;
        }
    }

    /**
     * Returns the String representation of the current value.
     * @return the String representation of the current value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.107 -0500", hash_original_method = "A5A2E0E9AE6072C3F7FFFC3FCCD2C5BC", hash_generated_method = "C8C62185C324BC1270BA5043B15CB6F0")
    
public String toString() {
        return Boolean.toString(get());
    }
    static {
      try {
        valueOffset = unsafe.objectFieldOffset
            (AtomicBoolean.class.getDeclaredField("value"));
      } catch (Exception ex) { throw new Error(ex); }
    }
    
}

