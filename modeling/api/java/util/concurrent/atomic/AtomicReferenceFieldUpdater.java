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
 * designated {@code volatile} reference fields of designated
 * classes.  This class is designed for use in atomic data structures
 * in which several reference fields of the same node are
 * independently subject to atomic updates. For example, a tree node
 * might be declared as
 *
 *  <pre> {@code
 * class Node {
 *   private volatile Node left, right;
 *
 *   private static final AtomicReferenceFieldUpdater<Node, Node> leftUpdater =
 *     AtomicReferenceFieldUpdater.newUpdater(Node.class, Node.class, "left");
 *   private static AtomicReferenceFieldUpdater<Node, Node> rightUpdater =
 *     AtomicReferenceFieldUpdater.newUpdater(Node.class, Node.class, "right");
 *
 *   Node getLeft() { return left;  }
 *   boolean compareAndSetLeft(Node expect, Node update) {
 *     return leftUpdater.compareAndSet(this, expect, update);
 *   }
 *   // ... and so on
 * }}</pre>
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
 * @param <V> The type of the field
 */
public abstract class AtomicReferenceFieldUpdater<T,V> {

    /**
     * Creates and returns an updater for objects with the given field.
     * The Class arguments are needed to check that reflective types and
     * generic types match.
     *
     * @param tclass the class of the objects holding the field
     * @param vclass the class of the field
     * @param fieldName the name of the field to be updated
     * @return the updater
     * @throws IllegalArgumentException if the field is not a volatile reference type
     * @throws RuntimeException with a nested reflection-based
     * exception if the class does not hold field or is the wrong type,
     * or the field is inaccessible to the caller according to Java language
     * access control
     */
    public static <U, W> AtomicReferenceFieldUpdater<U,W> newUpdater(Class<U> tclass, Class<W> vclass, String fieldName) {
        return new AtomicReferenceFieldUpdaterImpl<U,W>(tclass,
                                                        vclass,
                                                        fieldName);
    }

    /**
     * Protected do-nothing constructor for use by subclasses.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.201 -0400", hash_original_method = "C32EA60D622EDD5FEDD8C0EAA74D6A06", hash_generated_method = "D3AD81052FD00E279BE1F2467DE7F9E6")
    
protected AtomicReferenceFieldUpdater() {
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
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.201 -0400", hash_original_method = "09C8114E4D06CCE89414B8688B42D6F2", hash_generated_method = "BE0FF3470C703AEB82AEED5DA53809D2")
    
public abstract boolean compareAndSet(T obj, V expect, V update);

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
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.201 -0400", hash_original_method = "89A2E13412E4859B3C2604C8E2A7137D", hash_generated_method = "4ACBC88E1EE6954DBF0603B0BBC0DADE")
    
public abstract boolean weakCompareAndSet(T obj, V expect, V update);

    /**
     * Sets the field of the given object managed by this updater to the
     * given updated value. This operation is guaranteed to act as a volatile
     * store with respect to subsequent invocations of {@code compareAndSet}.
     *
     * @param obj An object whose field to set
     * @param newValue the new value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.202 -0400", hash_original_method = "D9246BB24AC5EC18E460DC6AA1900321", hash_generated_method = "E1B48C33911222D0E5060FA72DFB485C")
    
public abstract void set(T obj, V newValue);

    /**
     * Eventually sets the field of the given object managed by this
     * updater to the given updated value.
     *
     * @param obj An object whose field to set
     * @param newValue the new value
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.202 -0400", hash_original_method = "1B05A397CF65AC214288FE0FCFF8DC9A", hash_generated_method = "216351B2C30C7BE221DA4D61D645BAD5")
    
public abstract void lazySet(T obj, V newValue);

    /**
     * Gets the current value held in the field of the given object managed
     * by this updater.
     *
     * @param obj An object whose field to get
     * @return the current value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.202 -0400", hash_original_method = "991F18FCD84A3D9417E0AABB976FDE84", hash_generated_method = "D6E586F60B56AB0CAF7F20146F2BC06F")
    
public abstract V get(T obj);

    /**
     * Atomically sets the field of the given object managed by this updater
     * to the given value and returns the old value.
     *
     * @param obj An object whose field to get and set
     * @param newValue the new value
     * @return the previous value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.203 -0400", hash_original_method = "58B3DFEB401AD99EDDA798B0C0699A5A", hash_generated_method = "9FA71580E6654FF58298579209DBA048")
    
public V getAndSet(T obj, V newValue) {
        for (;;) {
            V current = get(obj);
            if (compareAndSet(obj, current, newValue))
                return current;
        }
    }

    private static final class AtomicReferenceFieldUpdaterImpl<T,V>
        extends AtomicReferenceFieldUpdater<T,V> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.203 -0400", hash_original_field = "45AA3EADCAC9C9E31A558AD2E7D920BC", hash_generated_field = "225667B44D983DC733D3AAE856B0466F")

        private static final Unsafe unsafe = Unsafe.getUnsafe();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.204 -0400", hash_original_field = "2050C11A9A31014833645AED9E75EDF7", hash_generated_field = "72D7DAA3F4E10A36C8D7D11B414E5D04")

        private  long offset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.204 -0400", hash_original_field = "0CFC39A9D5D31B63B20E48B09AD7D9E1", hash_generated_field = "0450F005DE31D500992E091D0E59F118")

        private  Class<T> tclass;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.204 -0400", hash_original_field = "E47E97B0E9A27E06306C1A2657B06726", hash_generated_field = "1B74B717D580F907B66BEDADED2EA27B")

        private  Class<V> vclass;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.205 -0400", hash_original_field = "ADE55029326573E7366ED47F9819FCAB", hash_generated_field = "E0159A26A00960682545CA8A02C7CC23")

        private  Class<?> cclass;

        /*
         * Internal type checks within all update methods contain
         * internal inlined optimizations checking for the common
         * cases where the class is final (in which case a simple
         * getClass comparison suffices) or is of type Object (in
         * which case no check is needed because all objects are
         * instances of Object). The Object case is handled simply by
         * setting vclass to null in constructor.  The targetCheck and
         * updateCheck methods are invoked when these faster
         * screenings fail.
         */

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.206 -0400", hash_original_method = "5B5233814E5BCDC8364934E1C698E098", hash_generated_method = "292AF1786CF485FB6E1145A005DAA2A8")
        
AtomicReferenceFieldUpdaterImpl(final Class<T> tclass,
                                        Class<V> vclass,
                                        final String fieldName) {
            final Field field;
            final Class<?> fieldClass;
            final Class<?> caller;
            final int modifiers;
            try {
                field = tclass.getDeclaredField(fieldName); // android-changed
                caller = VMStack.getStackClass2(); // android-changed
                modifiers = field.getModifiers();
            // BEGIN android-removed
            //     sun.reflect.misc.ReflectUtil.ensureMemberAccess(
            //         caller, tclass, null, modifiers);
            //     ClassLoader cl = tclass.getClassLoader();
            //     ClassLoader ccl = caller.getClassLoader();
            //     if ((ccl != null) && (ccl != cl) &&
            //         ((cl == null) || !isAncestor(cl, ccl))) {
            //       sun.reflect.misc.ReflectUtil.checkPackageAccess(tclass);
            //     }
            // END android-removed
                fieldClass = field.getType();
            // BEGIN android-removed
            // } catch (PrivilegedActionException pae) {
            //     throw new RuntimeException(pae.getException());
            // END android-removed
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

            if (vclass != fieldClass)
                throw new ClassCastException();

            if (!Modifier.isVolatile(modifiers))
                throw new IllegalArgumentException("Must be volatile type");

            this.cclass = (Modifier.isProtected(modifiers) &&
                           caller != tclass) ? caller : null;
            this.tclass = tclass;
            if (vclass == Object.class)
                this.vclass = null;
            else
                this.vclass = vclass;
            offset = unsafe.objectFieldOffset(field);
        }

        // BEGIN android-removed
        // /**
        //  * Returns true if the second classloader can be found in the first
        //  * classloader's delegation chain.
        //  * Equivalent to the inaccessible: first.isAncestor(second).
        //  */
        //
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.206 -0400", hash_original_method = "AE32E54E435AD699C784E985D115CD5E", hash_generated_method = "AE32E54E435AD699C784E985D115CD5E")
        
void targetCheck(T obj) {
            if (!tclass.isInstance(obj))
                throw new ClassCastException();
            if (cclass != null)
                ensureProtectedAccess(obj);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.207 -0400", hash_original_method = "42A01209ADEAF64E852BE875C19F5B7A", hash_generated_method = "42A01209ADEAF64E852BE875C19F5B7A")
        
void updateCheck(T obj, V update) {
            if (!tclass.isInstance(obj) ||
                (update != null && vclass != null && !vclass.isInstance(update)))
                throw new ClassCastException();
            if (cclass != null)
                ensureProtectedAccess(obj);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.207 -0400", hash_original_method = "57335D9634CE1B0C62B6259FB1219474", hash_generated_method = "F2BF0BF5DE9407DBDF5C5455E9B6479A")
        
public boolean compareAndSet(T obj, V expect, V update) {
            if (obj == null || obj.getClass() != tclass || cclass != null ||
                (update != null && vclass != null &&
                 vclass != update.getClass()))
                updateCheck(obj, update);
            return unsafe.compareAndSwapObject(obj, offset, expect, update);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.207 -0400", hash_original_method = "8E26A9C0E9D0D33CDDE2A32ECFD1F1B4", hash_generated_method = "E0F2443D4D98959861DF59BE95219A37")
        
public boolean weakCompareAndSet(T obj, V expect, V update) {
            // same implementation as strong form for now
            if (obj == null || obj.getClass() != tclass || cclass != null ||
                (update != null && vclass != null &&
                 vclass != update.getClass()))
                updateCheck(obj, update);
            return unsafe.compareAndSwapObject(obj, offset, expect, update);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.209 -0400", hash_original_method = "25492C6FE28EDEAEE65FD92BA416E52D", hash_generated_method = "C8DED10646833597D9D1DB6FF4D91218")
        
public void set(T obj, V newValue) {
            if (obj == null || obj.getClass() != tclass || cclass != null ||
                (newValue != null && vclass != null &&
                 vclass != newValue.getClass()))
                updateCheck(obj, newValue);
            unsafe.putObjectVolatile(obj, offset, newValue);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.209 -0400", hash_original_method = "393BE6A21E57FD8C608762EA076C9780", hash_generated_method = "3C42C72FB9167E3D61496F6F538BBC6D")
        
public void lazySet(T obj, V newValue) {
            if (obj == null || obj.getClass() != tclass || cclass != null ||
                (newValue != null && vclass != null &&
                 vclass != newValue.getClass()))
                updateCheck(obj, newValue);
            unsafe.putOrderedObject(obj, offset, newValue);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.210 -0400", hash_original_method = "52E90E06F254285644DD8FD17022DFC2", hash_generated_method = "4DC7066487449C8E35E96A1159505865")
        
@SuppressWarnings("unchecked")
        public V get(T obj) {
            if (obj == null || obj.getClass() != tclass || cclass != null)
                targetCheck(obj);
            return (V)unsafe.getObjectVolatile(obj, offset);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.210 -0400", hash_original_method = "9D11BBB4695C9E411934FC937C6FB3CE", hash_generated_method = "6A9765088E6121BD885496B0D0292AC5")
        
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
