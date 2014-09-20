/*
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/publicdomain/zero/1.0/
 */

package java.util.concurrent.atomic;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import dalvik.system.VMStack; // android-added
import sun.misc.Unsafe;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * A reflection-based utility that enables atomic updates to
 * designated {@code volatile long} fields of designated classes.
 * This class is designed for use in atomic data structures in which
 * several fields of the same node are independently subject to atomic
 * updates.
 *
 * <p>Note that the guarantees of the {@code compareAndSet}
 * method in this class are weaker than in other atomic classes.
 * Because this class cannot ensure that all uses of the field
 * are appropriate for purposes of atomic access, it can
 * guarantee atomicity only with respect to other invocations of
 * {@code compareAndSet} and {@code set} on the same updater.
 *
 * @since 1.5
 * @author Doug Lea
 * @param <T> The type of the object holding the updatable field
 */
public abstract class AtomicLongFieldUpdater<T> {
    /**
     * Creates and returns an updater for objects with the given field.
     * The Class argument is needed to check that reflective types and
     * generic types match.
     *
     * @param tclass the class of the objects holding the field
     * @param fieldName the name of the field to be updated
     * @return the updater
     * @throws IllegalArgumentException if the field is not a
     * volatile long type
     * @throws RuntimeException with a nested reflection-based
     * exception if the class does not hold field or is the wrong type,
     * or the field is inaccessible to the caller according to Java language
     * access control
     */
    public static <U> AtomicLongFieldUpdater<U> newUpdater(Class<U> tclass, String fieldName) {
        if (AtomicLong.VM_SUPPORTS_LONG_CAS)
            return new CASUpdater<U>(tclass, fieldName);
        else
            return new LockedUpdater<U>(tclass, fieldName);
    }

    /**
     * Protected do-nothing constructor for use by subclasses.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.654 -0400", hash_original_method = "BA7F0F8CC0F2CFF6E035F4AABDB58BFC", hash_generated_method = "79FC39BC570CBF66340E9A487BC57DED")
    
protected AtomicLongFieldUpdater() {
    }

    /**
     * Atomically sets the field of the given object managed by this updater
     * to the given updated value if the current value {@code ==} the
     * expected value. This method is guaranteed to be atomic with respect to
     * other calls to {@code compareAndSet} and {@code set}, but not
     * necessarily with respect to other changes in the field.
     *
     * @param obj An object whose field to conditionally set
     * @param expect the expected value
     * @param update the new value
     * @return true if successful
     * @throws ClassCastException if {@code obj} is not an instance
     * of the class possessing the field established in the constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.655 -0400", hash_original_method = "4A29CF60708B10DF5D9480F73D3A7930", hash_generated_method = "7B458827A299A901818BF0F8EDDC4BB5")
    
public abstract boolean compareAndSet(T obj, long expect, long update);

    /**
     * Atomically sets the field of the given object managed by this updater
     * to the given updated value if the current value {@code ==} the
     * expected value. This method is guaranteed to be atomic with respect to
     * other calls to {@code compareAndSet} and {@code set}, but not
     * necessarily with respect to other changes in the field.
     *
     * <p><a href="package-summary.html#weakCompareAndSet">May fail
     * spuriously and does not provide ordering guarantees</a>, so is
     * only rarely an appropriate alternative to {@code compareAndSet}.
     *
     * @param obj An object whose field to conditionally set
     * @param expect the expected value
     * @param update the new value
     * @return true if successful
     * @throws ClassCastException if {@code obj} is not an instance
     * of the class possessing the field established in the constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.655 -0400", hash_original_method = "B90FFAD8388148AAEE4576A6616B8F63", hash_generated_method = "225B77B69F1E841D67519EC9F36C2062")
    
public abstract boolean weakCompareAndSet(T obj, long expect, long update);

    /**
     * Sets the field of the given object managed by this updater to the
     * given updated value. This operation is guaranteed to act as a volatile
     * store with respect to subsequent invocations of {@code compareAndSet}.
     *
     * @param obj An object whose field to set
     * @param newValue the new value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.655 -0400", hash_original_method = "43B5263EDC6FBBEE8C304558F8179391", hash_generated_method = "778EDA66CD3FAD99A50C52328B142AA9")
    
public abstract void set(T obj, long newValue);

    /**
     * Eventually sets the field of the given object managed by this
     * updater to the given updated value.
     *
     * @param obj An object whose field to set
     * @param newValue the new value
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.656 -0400", hash_original_method = "4248D45B60D70C0FD304545E32756D1D", hash_generated_method = "CF21AEA982C8EBD7C5261E1A48D14E58")
    
public abstract void lazySet(T obj, long newValue);

    /**
     * Gets the current value held in the field of the given object managed
     * by this updater.
     *
     * @param obj An object whose field to get
     * @return the current value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.656 -0400", hash_original_method = "43A2EE1B5DAFCB54E86655849B3E84A4", hash_generated_method = "9A3244A592C2FB1FE6CD676F7035A127")
    
public abstract long get(T obj);

    /**
     * Atomically sets the field of the given object managed by this updater
     * to the given value and returns the old value.
     *
     * @param obj An object whose field to get and set
     * @param newValue the new value
     * @return the previous value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.657 -0400", hash_original_method = "073A4CF50E22F9EE4C4340BA9014F29C", hash_generated_method = "F37DB669BD0B6ECF5267E1024E989380")
    
public long getAndSet(T obj, long newValue) {
        for (;;) {
            long current = get(obj);
            if (compareAndSet(obj, current, newValue))
                return current;
        }
    }

    /**
     * Atomically increments by one the current value of the field of the
     * given object managed by this updater.
     *
     * @param obj An object whose field to get and set
     * @return the previous value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.657 -0400", hash_original_method = "FFCFE702F404925FF472694110925E69", hash_generated_method = "FBC2E66F3F0EED2D83AEF113BE218DE7")
    
public long getAndIncrement(T obj) {
        for (;;) {
            long current = get(obj);
            long next = current + 1;
            if (compareAndSet(obj, current, next))
                return current;
        }
    }

    /**
     * Atomically decrements by one the current value of the field of the
     * given object managed by this updater.
     *
     * @param obj An object whose field to get and set
     * @return the previous value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.657 -0400", hash_original_method = "9CAF92F1F2494CDDDA53F7B31DDB70AC", hash_generated_method = "4553E20777D3593C2E837AC2C506B648")
    
public long getAndDecrement(T obj) {
        for (;;) {
            long current = get(obj);
            long next = current - 1;
            if (compareAndSet(obj, current, next))
                return current;
        }
    }

    /**
     * Atomically adds the given value to the current value of the field of
     * the given object managed by this updater.
     *
     * @param obj An object whose field to get and set
     * @param delta the value to add
     * @return the previous value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.658 -0400", hash_original_method = "3764C955A48CF6808C45F475DCFC56BA", hash_generated_method = "A4AAD56596A4A14F86BBA6159E20DA7D")
    
public long getAndAdd(T obj, long delta) {
        for (;;) {
            long current = get(obj);
            long next = current + delta;
            if (compareAndSet(obj, current, next))
                return current;
        }
    }

    /**
     * Atomically increments by one the current value of the field of the
     * given object managed by this updater.
     *
     * @param obj An object whose field to get and set
     * @return the updated value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.658 -0400", hash_original_method = "1591AE6B0EAC64083036B0657AF8C8E8", hash_generated_method = "7CB67A2FD6283AA9150229B1E803B152")
    
public long incrementAndGet(T obj) {
        for (;;) {
            long current = get(obj);
            long next = current + 1;
            if (compareAndSet(obj, current, next))
                return next;
        }
    }

    /**
     * Atomically decrements by one the current value of the field of the
     * given object managed by this updater.
     *
     * @param obj An object whose field to get and set
     * @return the updated value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.659 -0400", hash_original_method = "F278D43CE5D7C7A4E3E54A0A47080CD8", hash_generated_method = "BB8201D6E8192B0724C658E974BCF5A8")
    
public long decrementAndGet(T obj) {
        for (;;) {
            long current = get(obj);
            long next = current - 1;
            if (compareAndSet(obj, current, next))
                return next;
        }
    }

    /**
     * Atomically adds the given value to the current value of the field of
     * the given object managed by this updater.
     *
     * @param obj An object whose field to get and set
     * @param delta the value to add
     * @return the updated value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.659 -0400", hash_original_method = "7BA11FC3A8E7EFFF8D5EBE339E5290E0", hash_generated_method = "9FF9E2EDFD5F4C76676B5A8DAA95BB8F")
    
public long addAndGet(T obj, long delta) {
        for (;;) {
            long current = get(obj);
            long next = current + delta;
            if (compareAndSet(obj, current, next))
                return next;
        }
    }

    private static class CASUpdater<T> extends AtomicLongFieldUpdater<T> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.660 -0400", hash_original_field = "45AA3EADCAC9C9E31A558AD2E7D920BC", hash_generated_field = "225667B44D983DC733D3AAE856B0466F")

        private static final Unsafe unsafe = Unsafe.getUnsafe();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.660 -0400", hash_original_field = "2050C11A9A31014833645AED9E75EDF7", hash_generated_field = "72D7DAA3F4E10A36C8D7D11B414E5D04")

        private  long offset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.660 -0400", hash_original_field = "0CFC39A9D5D31B63B20E48B09AD7D9E1", hash_generated_field = "0450F005DE31D500992E091D0E59F118")

        private  Class<T> tclass;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.661 -0400", hash_original_field = "ADE55029326573E7366ED47F9819FCAB", hash_generated_field = "E0159A26A00960682545CA8A02C7CC23")

        private  Class<?> cclass;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.662 -0400", hash_original_method = "4DBC0AA1241015CBA3B2B05DF986B67B", hash_generated_method = "F3C4C083B166CF3CDB6097072A27FEDC")
        
CASUpdater(Class<T> tclass, String fieldName) {
            final Field field;
            final Class<?> caller;
            final int modifiers;
            try {
                field = tclass.getDeclaredField(fieldName); // android-changed
                caller = VMStack.getStackClass2(); // android-changed
                modifiers = field.getModifiers();
                // BEGIN android-removed
                // sun.reflect.misc.ReflectUtil.ensureMemberAccess(
                //     caller, tclass, null, modifiers);
                // ClassLoader cl = tclass.getClassLoader();
                // ClassLoader ccl = caller.getClassLoader();
                // if ((ccl != null) && (ccl != cl) &&
                //     ((cl == null) || !isAncestor(cl, ccl))) {
                //   sun.reflect.misc.ReflectUtil.checkPackageAccess(tclass);
                // }
                // END android-removed
            // BEGIN android-removed
            // } catch (PrivilegedActionException pae) {
            //    throw new RuntimeException(pae.getException());
            // END android-removed
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

            Class<?> fieldt = field.getType();
            if (fieldt != long.class)
                throw new IllegalArgumentException("Must be long type");

            if (!Modifier.isVolatile(modifiers))
                throw new IllegalArgumentException("Must be volatile type");

            this.cclass = (Modifier.isProtected(modifiers) &&
                           caller != tclass) ? caller : null;
            this.tclass = tclass;
            offset = unsafe.objectFieldOffset(field);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.662 -0400", hash_original_method = "0DF68968C49F6A8B54F04E52C7A3B928", hash_generated_method = "02B1A2C09CA5EE2AABB1BAF0060F915C")
        
private void fullCheck(T obj) {
            if (!tclass.isInstance(obj))
                throw new ClassCastException();
            if (cclass != null)
                ensureProtectedAccess(obj);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.663 -0400", hash_original_method = "0B1B8A08B80DC3AD108753B0AFE3A4E8", hash_generated_method = "4F0D7A7554B6759128A657D16320BECE")
        
public boolean compareAndSet(T obj, long expect, long update) {
            if (obj == null || obj.getClass() != tclass || cclass != null) fullCheck(obj);
            return unsafe.compareAndSwapLong(obj, offset, expect, update);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.663 -0400", hash_original_method = "FA5ECB357D30254C8585479D53202326", hash_generated_method = "39EE061E370A6B82A24D7D1FFD218101")
        
public boolean weakCompareAndSet(T obj, long expect, long update) {
            if (obj == null || obj.getClass() != tclass || cclass != null) fullCheck(obj);
            return unsafe.compareAndSwapLong(obj, offset, expect, update);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.664 -0400", hash_original_method = "71897CED5F2740E2249B4A6609AE4D6E", hash_generated_method = "F7E3A2D60DCFE4050E72112E2910F217")
        
public void set(T obj, long newValue) {
            if (obj == null || obj.getClass() != tclass || cclass != null) fullCheck(obj);
            unsafe.putLongVolatile(obj, offset, newValue);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.664 -0400", hash_original_method = "51078ADC8C79D48D4C02CCADFB4A4445", hash_generated_method = "7D7C3DE0D2A4C4423D6E835975EAA8BD")
        
public void lazySet(T obj, long newValue) {
            if (obj == null || obj.getClass() != tclass || cclass != null) fullCheck(obj);
            unsafe.putOrderedLong(obj, offset, newValue);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.665 -0400", hash_original_method = "DD571ADDCD61186BA82D3AD7916B61C6", hash_generated_method = "1CEB3E220252AF714575ABDF5D3CD4F9")
        
public long get(T obj) {
            if (obj == null || obj.getClass() != tclass || cclass != null) fullCheck(obj);
            return unsafe.getLongVolatile(obj, offset);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.665 -0400", hash_original_method = "9D11BBB4695C9E411934FC937C6FB3CE", hash_generated_method = "6A9765088E6121BD885496B0D0292AC5")
        
private void ensureProtectedAccess(T obj) {
            if (cclass.isInstance(obj)) {
                return;
            }
            throw new RuntimeException(
                new IllegalAccessException("Class " +
                    cclass.getName() +
                    " can not access a protected member of class " +
                    tclass.getName() +
                    " using an instance of " +
                    obj.getClass().getName()
                )
            );
        }
    }


    private static class LockedUpdater<T> extends AtomicLongFieldUpdater<T> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.667 -0400", hash_original_field = "45AA3EADCAC9C9E31A558AD2E7D920BC", hash_generated_field = "225667B44D983DC733D3AAE856B0466F")

        private static final Unsafe unsafe = Unsafe.getUnsafe();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.668 -0400", hash_original_field = "2050C11A9A31014833645AED9E75EDF7", hash_generated_field = "72D7DAA3F4E10A36C8D7D11B414E5D04")

        private  long offset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.668 -0400", hash_original_field = "0CFC39A9D5D31B63B20E48B09AD7D9E1", hash_generated_field = "0450F005DE31D500992E091D0E59F118")

        private  Class<T> tclass;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.668 -0400", hash_original_field = "ADE55029326573E7366ED47F9819FCAB", hash_generated_field = "E0159A26A00960682545CA8A02C7CC23")

        private  Class<?> cclass;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.669 -0400", hash_original_method = "2E07F10BD45BBE858858F63D3C7EF49D", hash_generated_method = "17F5EB32D5FA0554FF3367520388F6CB")
        
LockedUpdater(Class<T> tclass, String fieldName) {
            Field field = null;
            Class<?> caller = null;
            int modifiers = 0;
            try {
                field = tclass.getDeclaredField(fieldName); // android-changed
                caller = VMStack.getStackClass2(); // android-changed
                modifiers = field.getModifiers();
                // BEGIN android-removed
                // sun.reflect.misc.ReflectUtil.ensureMemberAccess(
                //     caller, tclass, null, modifiers);
                // ClassLoader cl = tclass.getClassLoader();
                // ClassLoader ccl = caller.getClassLoader();
                // if ((ccl != null) && (ccl != cl) &&
                //     ((cl == null) || !isAncestor(cl, ccl))) {
                //   sun.reflect.misc.ReflectUtil.checkPackageAccess(tclass);
                // }
                // END android-removed
            // BEGIN android-removed
            // } catch (PrivilegedActionException pae) {
            //     throw new RuntimeException(pae.getException());
            // END android-removed
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

            Class<?> fieldt = field.getType();
            if (fieldt != long.class)
                throw new IllegalArgumentException("Must be long type");

            if (!Modifier.isVolatile(modifiers))
                throw new IllegalArgumentException("Must be volatile type");

            this.cclass = (Modifier.isProtected(modifiers) &&
                           caller != tclass) ? caller : null;
            this.tclass = tclass;
            offset = unsafe.objectFieldOffset(field);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.670 -0400", hash_original_method = "0DF68968C49F6A8B54F04E52C7A3B928", hash_generated_method = "02B1A2C09CA5EE2AABB1BAF0060F915C")
        
private void fullCheck(T obj) {
            if (!tclass.isInstance(obj))
                throw new ClassCastException();
            if (cclass != null)
                ensureProtectedAccess(obj);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.670 -0400", hash_original_method = "F28EEE820E0CC0A4DFB94FC74A5AFE78", hash_generated_method = "41E3A6FA5E4BFDB064D35A9FE93DF2F8")
        
public boolean compareAndSet(T obj, long expect, long update) {
            if (obj == null || obj.getClass() != tclass || cclass != null) fullCheck(obj);
            synchronized (this) {
                long v = unsafe.getLong(obj, offset);
                if (v != expect)
                    return false;
                unsafe.putLong(obj, offset, update);
                return true;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.671 -0400", hash_original_method = "14B3E8CFE4FC936117A23CCF5649E4AE", hash_generated_method = "11CB72281CEDCC20575E240C23120AE4")
        
public boolean weakCompareAndSet(T obj, long expect, long update) {
            return compareAndSet(obj, expect, update);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.671 -0400", hash_original_method = "669ED1C08689C1E7A362C28D2C445452", hash_generated_method = "2CA006DA6E058B5CE0A327B3DB1FA881")
        
public void set(T obj, long newValue) {
            if (obj == null || obj.getClass() != tclass || cclass != null) fullCheck(obj);
            synchronized (this) {
                unsafe.putLong(obj, offset, newValue);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.672 -0400", hash_original_method = "B254126A5A9A310CC60672857EFE3992", hash_generated_method = "46312F00DEADFDCFD4B30304E42ACE86")
        
public void lazySet(T obj, long newValue) {
            set(obj, newValue);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.672 -0400", hash_original_method = "DD3CDDB3808B9B1B599C95B5AE839523", hash_generated_method = "DB1C4AF74793C98F6B64020C4E01E652")
        
public long get(T obj) {
            if (obj == null || obj.getClass() != tclass || cclass != null) fullCheck(obj);
            synchronized (this) {
                return unsafe.getLong(obj, offset);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.672 -0400", hash_original_method = "9D11BBB4695C9E411934FC937C6FB3CE", hash_generated_method = "6A9765088E6121BD885496B0D0292AC5")
        
private void ensureProtectedAccess(T obj) {
            if (cclass.isInstance(obj)) {
                return;
            }
            throw new RuntimeException(
                new IllegalAccessException("Class " +
                    cclass.getName() +
                    " can not access a protected member of class " +
                    tclass.getName() +
                    " using an instance of " +
                    obj.getClass().getName()
                )
            );
        }
    }

    // BEGIN android-removed
    // /**
    //  * Returns true if the second classloader can be found in the first
    //  * classloader's delegation chain.
    //  * Equivalent to the inaccessible: first.isAncestor(second).
    //  */
    // private static boolean isAncestor(ClassLoader first, ClassLoader second) {
    //     ClassLoader acl = first;
    //     do {
    //         acl = acl.getParent();
    //         if (second == acl) {
    //             return true;
    //        }
    //     } while (acl != null);
    //     return false;
    // }
    // END android-removed
}
