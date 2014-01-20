package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import libcore.util.BasicLruCache;
import libcore.util.EmptyArray;

import droidsafe.runtime.DroidSafeAndroidRuntime;

public abstract class Enum<E extends Enum<E>> implements Serializable, Comparable<E> {
    
    public static <T extends Enum<T>> T valueOf(Class<T> enumType, String name) {
        if (enumType == null || name == null) {
            throw new NullPointerException("enumType == null || name == null");
        }
        if (!enumType.isEnum()) {
            throw new IllegalArgumentException(enumType + " is not an enum type");
        }
        for (T value : getSharedConstants(enumType)) {
            if (name.equals(value.name())) {
                return value;
            }
        }
        throw new IllegalArgumentException(name + " is not a constant in " + enumType.getName());
    }
    
    @SuppressWarnings("unchecked")
    public static <T extends Enum<T>> T[] getSharedConstants(Class<T> enumType) {
        return (T[]) sharedConstantsCache.get(enumType);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.908 -0500", hash_original_field = "36ABA869F03F9A9F22D0E91086D2EDD0", hash_generated_field = "F6C6D1A2DF29E3B35FCE4B7C508D18C8")

    private static final long serialVersionUID = -4300926546619394005L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.973 -0400", hash_original_field = "9E1AB9651106D78F89D200A6B8A75C99", hash_generated_field = "B4F6D6026899BCE9E7B0DB1ABDB36603")

    private static final BasicLruCache<Class<? extends Enum>, Object[]> sharedConstantsCache = new BasicLruCache<Class<? extends Enum>, Object[]>(64) {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.973 -0400", hash_original_method = "4DA067D184DCA03E4A8499CE8148F1DB", hash_generated_method = "7F031794B7075609744F8874AE3F398D")
        @Override
        protected Object[] create(Class<? extends Enum> enumType) {
            Object[] varB4EAC82CA7396A68D541C85D26508E83_1848793963 = null; 
            Method method = (Method) Class.getDeclaredConstructorOrMethod(
                    enumType, "values", EmptyArray.CLASS);
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1848793963 = (Object[]) method.invoke((Object[]) null);
            } 
            catch (IllegalAccessException impossible)
            {
                if (DroidSafeAndroidRuntime.control) throw new AssertionError();
            } 
            catch (InvocationTargetException impossible)
            {
                if (DroidSafeAndroidRuntime.control) throw new AssertionError();
            } 
            addTaint(enumType.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1848793963.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1848793963;
            
        }
        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.917 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private  String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.919 -0500", hash_original_field = "9B9D896414A0E67CE9221B96A63BE0CD", hash_generated_field = "9B9D896414A0E67CE9221B96A63BE0CD")

     int ordinal;

    /**
     * Constructor for constants of enum subtypes.
     *
     * @param name
     *            the enum constant's declared name.
     * @param ordinal
     *            the enum constant's ordinal, which corresponds to its position
     *            in the enum declaration, starting at zero.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.922 -0500", hash_original_method = "2DD8D404884977C1C225DE3C5244FDA0", hash_generated_method = "1887E501CA6B8019D2032FB3139B9377")
    
protected Enum(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
    }

    /**
     * Returns the name of this enum constant. The name is the field as it
     * appears in the {@code enum} declaration.
     *
     * @return the name of this enum constant.
     * @see #toString()
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.924 -0500", hash_original_method = "B829A2DCF2B6B038F9421827E4B40BDF", hash_generated_method = "45DBC829FBEEC28B377967506702788C")
    
public final String name() {
        return name;
    }

    /**
     * Returns the position of the enum constant in the declaration. The first
     * constant has an ordinal value of zero.
     *
     * @return the ordinal value of this enum constant.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.927 -0500", hash_original_method = "F85866CCC5D845B1D53CAF0C5BA97CF5", hash_generated_method = "B40243DEA0D5F5AC565137554CC28EF5")
    
public final int ordinal() {
        return ordinal;
    }

    /**
     * Returns a string containing a concise, human-readable description of this
     * object. In this case, the enum constant's name is returned.
     *
     * @return a printable representation of this object.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.930 -0500", hash_original_method = "0EB66BA5E965B83E191719250E0A82FF", hash_generated_method = "0D841C721535905DD0E9F7FAE6757EB9")
    
@Override
    public String toString() {
        return name;
    }

    /**
     * Compares this object with the specified object and indicates if they are
     * equal. In order to be equal, {@code object} must be identical to this
     * enum constant.
     *
     * @param other
     *            the object to compare this enum constant with.
     * @return {@code true} if the specified object is equal to this
     *         {@code Enum}; {@code false} otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.933 -0500", hash_original_method = "75011B979FEDB2DAAF1F1F1C2C24B4BF", hash_generated_method = "49333CCC66E5984AFB70D1F9628F7838")
    
@Override
    public final boolean equals(Object other) {
        return this == other;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.936 -0500", hash_original_method = "EA441E584394EE19D2A56603F808DF7D", hash_generated_method = "3A6CF9A299D5297FC59AC2356DCC4811")
    
@Override
    public final int hashCode() {
        return ordinal + (name == null ? 0 : name.hashCode());
    }

    /**
     * {@code Enum} objects are singletons, they may not be cloned. This method
     * always throws a {@code CloneNotSupportedException}.
     *
     * @return does not return.
     * @throws CloneNotSupportedException
     *             is always thrown.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.938 -0500", hash_original_method = "E819DB208756D0A4B5DFB72B3A772B65", hash_generated_method = "720A1100071FDC468D6438DAE71A3A05")
    
@Override
    protected final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Enums may not be cloned");
    }

    /**
     * Compares this object to the specified enum object to determine their
     * relative order. This method compares the object's ordinal values, that
     * is, their position in the enum declaration.
     *
     * @param o
     *            the enum object to compare this object to.
     * @return a negative value if the ordinal value of this enum constant is
     *         less than the ordinal value of {@code o}; 0 if the ordinal
     *         values of this enum constant and {@code o} are equal; a positive
     *         value if the ordinal value of this enum constant is greater than
     *         the ordinal value of {@code o}.
     * @see java.lang.Comparable
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.941 -0500", hash_original_method = "914B430886739457D899D0D840F0325C", hash_generated_method = "50826E44A2062E2FB025D20ED02D5714")
    
public final int compareTo(E o) {
        return ordinal - o.ordinal;
    }

    /**
     * Returns the enum constant's declaring class.
     *
     * @return the class object representing the constant's enum type.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.943 -0500", hash_original_method = "0D462A5B0CC7E5E79CA20DB4952DBB5B", hash_generated_method = "762014D63804DB3D4D80E909CA7FDE71")
    
@SuppressWarnings("unchecked")
    public final Class<E> getDeclaringClass() {
        Class<?> myClass = getClass();
        Class<?> mySuperClass = myClass.getSuperclass();
        if (Enum.class == mySuperClass) {
            return (Class<E>)myClass;
        }
        return (Class<E>)mySuperClass;
    }

    /**
     * Enum types may not have finalizers.
     *
     * @since 1.6
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.950 -0500", hash_original_method = "3012BD4162FEB4D4063E0B4E3944BED9", hash_generated_method = "2079993A117A470D1C9BB6A7397F737D")
    
@Override
    @SuppressWarnings("FinalizeDoesntCallSuperFinalize")
    protected final void finalize() {
    }
}

