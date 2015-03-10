/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/licenses/publicdomain
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


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
 * designated {@code volatile int} fields of designated classes.
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
public abstract class AtomicIntegerFieldUpdater<T> {
    /**
     * Creates and returns an updater for objects with the given field.
     * The Class argument is needed to check that reflective types and
     * generic types match.
     *
     * @param tclass the class of the objects holding the field
     * @param fieldName the name of the field to be updated
     * @return the updater
     * @throws IllegalArgumentException if the field is not a
     * volatile integer type
     * @throws RuntimeException with a nested reflection-based
     * exception if the class does not hold field or is the wrong type,
     * or the field is inaccessible to the caller according to Java language
     * access control
     */
    public static <U> AtomicIntegerFieldUpdater<U> newUpdater(Class<U> tclass, String fieldName) {
        return new AtomicIntegerFieldUpdaterImpl<U>(tclass, fieldName);
    }

    /**
     * Protected do-nothing constructor for use by subclasses.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.416 -0400", hash_original_method = "9AA07EB737377587467CEEE13B576FDF", hash_generated_method = "1BA6750D10D0254E25F6137C7903CBF7")
    
protected AtomicIntegerFieldUpdater() {
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.416 -0400", hash_original_method = "B4770E29712415FFDD9FC97888AC40B4", hash_generated_method = "AE0F55025E2A05069EF5A93B1D9751D4")
    
public abstract boolean compareAndSet(T obj, int expect, int update);

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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.417 -0400", hash_original_method = "7AAD66DFF635523FE3965CB5DFDCB715", hash_generated_method = "E5AB00B791F4B44DCE9150E949D2ED6D")
    
public abstract boolean weakCompareAndSet(T obj, int expect, int update);

    /**
     * Sets the field of the given object managed by this updater to the
     * given updated value. This operation is guaranteed to act as a volatile
     * store with respect to subsequent invocations of {@code compareAndSet}.
     *
     * @param obj An object whose field to set
     * @param newValue the new value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.417 -0400", hash_original_method = "79692E96566C762442B3F6FB90D03393", hash_generated_method = "99FA125AB198ACEA4D3BC1D5E84543C7")
    
public abstract void set(T obj, int newValue);

    /**
     * Eventually sets the field of the given object managed by this
     * updater to the given updated value.
     *
     * @param obj An object whose field to set
     * @param newValue the new value
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.418 -0400", hash_original_method = "7312B9CEFC43A8F02D096BDA4B4EFC4D", hash_generated_method = "BABF528BA9DB263EF9CA437C96EF3842")
    
public abstract void lazySet(T obj, int newValue);

    /**
     * Gets the current value held in the field of the given object managed
     * by this updater.
     *
     * @param obj An object whose field to get
     * @return the current value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.418 -0400", hash_original_method = "3B1E05081CADF246BFDCA15FC09B505B", hash_generated_method = "346EA4F1629648F77AA47541A2162AD9")
    
public abstract int get(T obj);

    /**
     * Atomically sets the field of the given object managed by this updater
     * to the given value and returns the old value.
     *
     * @param obj An object whose field to get and set
     * @param newValue the new value
     * @return the previous value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.418 -0400", hash_original_method = "77BB8D6DDE97FEB2D478DA7A0FD3F96A", hash_generated_method = "BCCF6BCC5583C785FEC7C5156EE50531")
    
public int getAndSet(T obj, int newValue) {
        for (;;) {
            int current = get(obj);
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.419 -0400", hash_original_method = "A4B1366C3E22D2A242E609DE104C6429", hash_generated_method = "53AA3688AE83CF18C6FD2C6D1F9AC6B6")
    
public int getAndIncrement(T obj) {
        for (;;) {
            int current = get(obj);
            int next = current + 1;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.419 -0400", hash_original_method = "F2E33F1731BDA557B42689B1A3096D25", hash_generated_method = "BAFB249663B7FED7CF61895F3E571537")
    
public int getAndDecrement(T obj) {
        for (;;) {
            int current = get(obj);
            int next = current - 1;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.419 -0400", hash_original_method = "C1993F2EB18E0931190A5B4F9B973038", hash_generated_method = "1C696D45FDDD3645138AD08E42DB6DCE")
    
public int getAndAdd(T obj, int delta) {
        for (;;) {
            int current = get(obj);
            int next = current + delta;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.420 -0400", hash_original_method = "81D4BE1061FB84BDE4F36E95BC61A6D2", hash_generated_method = "B58CC7488C469A667AF58B3F6F464264")
    
public int incrementAndGet(T obj) {
        for (;;) {
            int current = get(obj);
            int next = current + 1;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.420 -0400", hash_original_method = "90B712BB5A6675E71DCABE45961DE816", hash_generated_method = "300424672F4024DA664DA14D075114F6")
    
public int decrementAndGet(T obj) {
        for (;;) {
            int current = get(obj);
            int next = current - 1;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.421 -0400", hash_original_method = "B2AEF583C2A8BAD6EC33DE47698A1D33", hash_generated_method = "0B83E4A3F459F18BB9D3C304CDA5BEAC")
    
public int addAndGet(T obj, int delta) {
        for (;;) {
            int current = get(obj);
            int next = current + delta;
            if (compareAndSet(obj, current, next))
                return next;
        }
    }

    /**
     * Standard hotspot implementation using intrinsics
     */
    private static class AtomicIntegerFieldUpdaterImpl<T> extends AtomicIntegerFieldUpdater<T> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.421 -0400", hash_original_field = "45AA3EADCAC9C9E31A558AD2E7D920BC", hash_generated_field = "225667B44D983DC733D3AAE856B0466F")

        private static final Unsafe unsafe = Unsafe.getUnsafe();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.422 -0400", hash_original_field = "2050C11A9A31014833645AED9E75EDF7", hash_generated_field = "72D7DAA3F4E10A36C8D7D11B414E5D04")

        private  long offset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.422 -0400", hash_original_field = "0CFC39A9D5D31B63B20E48B09AD7D9E1", hash_generated_field = "0450F005DE31D500992E091D0E59F118")

        private  Class<T> tclass;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.422 -0400", hash_original_field = "ADE55029326573E7366ED47F9819FCAB", hash_generated_field = "E0159A26A00960682545CA8A02C7CC23")

        private  Class<?> cclass;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.423 -0400", hash_original_method = "6048EDACB2927A23781360C84E10757A", hash_generated_method = "71A30CF3444E049C83D9615C29C7F7C3")
        
AtomicIntegerFieldUpdaterImpl(Class<T> tclass, String fieldName) {
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
            //     throw new RuntimeException(pae.getException());
            // END android-removed
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

            Class<?> fieldt = field.getType();
            if (fieldt != int.class)
                throw new IllegalArgumentException("Must be integer type");

            if (!Modifier.isVolatile(modifiers))
                throw new IllegalArgumentException("Must be volatile type");

            this.cclass = (Modifier.isProtected(modifiers) &&
                           caller != tclass) ? caller : null;
            this.tclass = tclass;
            offset = unsafe.objectFieldOffset(field);
        }

        // BEGIN android-removed
        // /**
        //  * Returns true if the second classloader can be found in the first
        //  * classloader's delegation chain.
        //  * Equivalent to the inaccessible: first.isAncestor(second).
        //  */
        //  private static boolean isAncestor(ClassLoader first, ClassLoader second) {
        //     ClassLoader acl = first;
        //     do {
        //         acl = acl.getParent();
        //         if (second == acl) {
        //             return true;
        //         }
        //     } while (acl != null);
        //     return false;
        // }
        // END android-removed
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.424 -0400", hash_original_method = "0DF68968C49F6A8B54F04E52C7A3B928", hash_generated_method = "02B1A2C09CA5EE2AABB1BAF0060F915C")
        
private void fullCheck(T obj) {
            if (!tclass.isInstance(obj))
                throw new ClassCastException();
            if (cclass != null)
                ensureProtectedAccess(obj);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.424 -0400", hash_original_method = "3F60A37E335BB5DD0452AB1487E4A88F", hash_generated_method = "E7AFDDB29AFA053E856570FFD3F61AB1")
        
public boolean compareAndSet(T obj, int expect, int update) {
            if (obj == null || obj.getClass() != tclass || cclass != null) fullCheck(obj);
            return unsafe.compareAndSwapInt(obj, offset, expect, update);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.425 -0400", hash_original_method = "5FF8E7C63D228CC459D26F0AEE41B299", hash_generated_method = "1F237006F09353913D7F702833B377D0")
        
public boolean weakCompareAndSet(T obj, int expect, int update) {
            if (obj == null || obj.getClass() != tclass || cclass != null) fullCheck(obj);
            return unsafe.compareAndSwapInt(obj, offset, expect, update);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.425 -0400", hash_original_method = "DB8F75FC1E260134394CDE27C3D23A66", hash_generated_method = "2E435FC2B4FA2C1DFC9AC0461426C1D8")
        
public void set(T obj, int newValue) {
            if (obj == null || obj.getClass() != tclass || cclass != null) fullCheck(obj);
            unsafe.putIntVolatile(obj, offset, newValue);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.426 -0400", hash_original_method = "05A9CD138D0BBDD46AF6C9F09929A9D1", hash_generated_method = "0D6A76B858DFF697413FBDBBE94FFF22")
        
public void lazySet(T obj, int newValue) {
            if (obj == null || obj.getClass() != tclass || cclass != null) fullCheck(obj);
            unsafe.putOrderedInt(obj, offset, newValue);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.426 -0400", hash_original_method = "27A39E9630A0D576267E5B0A457F4188", hash_generated_method = "17E4CE19EADFA1CC1BE0DE22FCFD80C3")
        
public final int get(T obj) {
            if (obj == null || obj.getClass() != tclass || cclass != null) fullCheck(obj);
            return unsafe.getIntVolatile(obj, offset);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.426 -0400", hash_original_method = "9D11BBB4695C9E411934FC937C6FB3CE", hash_generated_method = "6A9765088E6121BD885496B0D0292AC5")
        
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
}
