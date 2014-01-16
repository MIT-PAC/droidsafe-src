package java.util.concurrent.atomic;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import sun.misc.Unsafe;

import droidsafe.helpers.DSUtils;

public class AtomicLong extends Number implements java.io.Serializable {
    
    private static boolean VMSupportsCS8() {
        return DSUtils.UNKNOWN_BOOLEAN;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.503 -0500", hash_original_field = "657C091FF433ACBC782F3ED1087BD6AB", hash_generated_field = "0B880760F282B6C2D9B088CA9DBA6E27")

    private static final long serialVersionUID = 1927816293512124184L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.506 -0500", hash_original_field = "888B3F05664BAF88334D2C14A4DA8138", hash_generated_field = "E7D465D52C267C4626E00B16AF4442B8")

    private static final Unsafe unsafe = UnsafeAccess.THE_ONE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.508 -0500", hash_original_field = "2B4D3697B0BD0FB4DB161026EA588EEA", hash_generated_field = "3ACE806C2A776E8F67FFC072288734E8")

    private static  long valueOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.511 -0500", hash_original_field = "30B9CCD7A135D4B84BDC156BA4310026", hash_generated_field = "FB29CA34A363CAEEC18A2DF988EF15B6")

    static final boolean VM_SUPPORTS_LONG_CAS = VMSupportsCS8();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.518 -0500", hash_original_field = "DDD221DA9F0E75EE691CFACED8C3397A", hash_generated_field = "272863A964896393C50056118F48F189")

    private volatile long value;

    /**
     * Creates a new AtomicLong with the given initial value.
     *
     * @param initialValue the initial value
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.521 -0500", hash_original_method = "6ECA774993D880ABD38A420DC693E35F", hash_generated_method = "289533BFFF52F6D05E10ACA8F1E13A96")
    
public AtomicLong(long initialValue) {
        value = initialValue;
    }

    /**
     * Creates a new AtomicLong with initial value {@code 0}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.523 -0500", hash_original_method = "E5BCC7DD3ADE986582FDD04FB62FAAFA", hash_generated_method = "2C25E4FF944D2330F4ED58696D2578B6")
    
public AtomicLong() {
    }

    /**
     * Gets the current value.
     *
     * @return the current value
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.526 -0500", hash_original_method = "558225EAA1BF82052D6B969C16747B7A", hash_generated_method = "0DA3986B795EBED7D70FCF24B2FF399B")
    
public final long get() {
        return value;
    }

    /**
     * Sets to the given value.
     *
     * @param newValue the new value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.528 -0500", hash_original_method = "CA4706358CD81A962EB6E91A1521FBCA", hash_generated_method = "D6D1339A4D29B95ECE9495EA453F9D24")
    
public final void set(long newValue) {
        value = newValue;
    }

    /**
     * Eventually sets to the given value.
     *
     * @param newValue the new value
     * @since 1.6
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.531 -0500", hash_original_method = "5F840B47C39798AC1AA2E3C6DCFC9B43", hash_generated_method = "83A9877A95611BF082C2348B8392889A")
    
public final void lazySet(long newValue) {
        unsafe.putOrderedLong(this, valueOffset, newValue);
    }

    /**
     * Atomically sets to the given value and returns the old value.
     *
     * @param newValue the new value
     * @return the previous value
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.534 -0500", hash_original_method = "390AAB13B16AF188378473BA59BB98BA", hash_generated_method = "4DB366D00B730F399166E828BE3ABDB1")
    
public final long getAndSet(long newValue) {
        while (true) {
            long current = get();
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.536 -0500", hash_original_method = "9AFEEC1B0401F372D8D224EE7A6E78FB", hash_generated_method = "189734F5014268382A7251BC77333F86")
    
public final boolean compareAndSet(long expect, long update) {
        return unsafe.compareAndSwapLong(this, valueOffset, expect, update);
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.539 -0500", hash_original_method = "CF5E29839097193C76F9677539F6A8BA", hash_generated_method = "91E09302334FEF6440EF02F50CA298F0")
    
public final boolean weakCompareAndSet(long expect, long update) {
        return unsafe.compareAndSwapLong(this, valueOffset, expect, update);
    }

    /**
     * Atomically increments by one the current value.
     *
     * @return the previous value
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.542 -0500", hash_original_method = "0FB09453B9C7F7E3674DED4A168E8FE2", hash_generated_method = "3E6BAA9B4DE447110E896CD61AC2ACE1")
    
public final long getAndIncrement() {
        while (true) {
            long current = get();
            long next = current + 1;
            if (compareAndSet(current, next))
                return current;
        }
    }

    /**
     * Atomically decrements by one the current value.
     *
     * @return the previous value
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.544 -0500", hash_original_method = "B338EF04AC352C769CAB7069B279216B", hash_generated_method = "6552A10E0051DDC92382F8CAC7DF24C1")
    
public final long getAndDecrement() {
        while (true) {
            long current = get();
            long next = current - 1;
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
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.547 -0500", hash_original_method = "F13F3FE7BE5ED16E2943CEEE9739382A", hash_generated_method = "77B18165BA1EBE3546A7B43EEE7209E2")
    
public final long getAndAdd(long delta) {
        while (true) {
            long current = get();
            long next = current + delta;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.549 -0500", hash_original_method = "0B4DA3D002D9BEE66893798DFD4DBDF7", hash_generated_method = "D3393C2385D07821FEECC3C8F0475B32")
    
public final long incrementAndGet() {
        for (;;) {
            long current = get();
            long next = current + 1;
            if (compareAndSet(current, next))
                return next;
        }
    }

    /**
     * Atomically decrements by one the current value.
     *
     * @return the updated value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.552 -0500", hash_original_method = "BC527AFE730427BE036B66CE7C20403C", hash_generated_method = "57901D9491D199549A641CDD99485838")
    
public final long decrementAndGet() {
        for (;;) {
            long current = get();
            long next = current - 1;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.554 -0500", hash_original_method = "9F7FB16A58B977A4E2DB5A0F397D878E", hash_generated_method = "E4AC06DEA775AB143FDC21E24E9F7009")
    
public final long addAndGet(long delta) {
        for (;;) {
            long current = get();
            long next = current + delta;
            if (compareAndSet(current, next))
                return next;
        }
    }

    /**
     * Returns the String representation of the current value.
     * @return the String representation of the current value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.556 -0500", hash_original_method = "87FB115D4E2C883D105781A1EF69130B", hash_generated_method = "8711F4F37C5F12AC2EEB1DF48218526D")
    
public String toString() {
        return Long.toString(get());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.558 -0500", hash_original_method = "84EB409D8DAC6A9532DB1B14F662CA95", hash_generated_method = "EE23D09943DC9A4EFC33B9CF333E20F2")
    
public int intValue() {
        return (int)get();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.561 -0500", hash_original_method = "8D0E58021498DD6F55D0437545A61BE8", hash_generated_method = "EB2B40DFCD2177F5A108DEC6604A00BB")
    
public long longValue() {
        return get();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.563 -0500", hash_original_method = "F8181329F165428C51D2197BB97797EF", hash_generated_method = "225ECFECD93F68C7D435A4909B28BB0D")
    
public float floatValue() {
        return (float)get();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.566 -0500", hash_original_method = "486C42E34E3619D90E05BCBEDA3844AE", hash_generated_method = "45341808FAD3EC3D7016C92E90DEA5E8")
    
public double doubleValue() {
        return (double)get();
    }
    static {
      try {
        valueOffset = unsafe.objectFieldOffset
            (AtomicLong.class.getDeclaredField("value"));
      } catch (Exception ex) { throw new Error(ex); }
    }
    
}

