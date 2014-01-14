package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;

public abstract class EnumSet<E extends Enum<E>> extends AbstractSet<E> implements Cloneable, Serializable {
    
    public static <E extends Enum<E>> EnumSet<E> noneOf(Class<E> elementType) {
        if (!elementType.isEnum()) {
            throw new ClassCastException(elementType.getClass().getName() + " is not an Enum");
        }
        E[] enums = Enum.getSharedConstants(elementType);
        if (enums.length <= 64) {
            return new MiniEnumSet<E>(elementType, enums);
        }
        return new HugeEnumSet<E>(elementType, enums);
    }
    
    public static <E extends Enum<E>> EnumSet<E> allOf(Class<E> elementType) {
        EnumSet<E> set = noneOf(elementType);
        set.complement();
        return set;
    }
    
    public static <E extends Enum<E>> EnumSet<E> copyOf(EnumSet<E> s) {
        EnumSet<E> set = EnumSet.noneOf(s.elementClass);
        set.addAll(s);
        return set;
    }
    
    public static <E extends Enum<E>> EnumSet<E> copyOf(Collection<E> c) {
        if (c instanceof EnumSet) {
            return copyOf((EnumSet<E>) c);
        }
        if (c.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Iterator<E> iterator = c.iterator();
        E element = iterator.next();
        EnumSet<E> set = EnumSet.noneOf(element.getDeclaringClass());
        set.add(element);
        while (iterator.hasNext()) {
            set.add(iterator.next());
        }
        return set;
    }
    
    public static <E extends Enum<E>> EnumSet<E> complementOf(EnumSet<E> s) {
        EnumSet<E> set = EnumSet.noneOf(s.elementClass);
        set.addAll(s);
        set.complement();
        return set;
    }
    
    public static <E extends Enum<E>> EnumSet<E> of(E e) {
        EnumSet<E> set = EnumSet.noneOf(e.getDeclaringClass());
        set.add(e);
        return set;
    }
    
    public static <E extends Enum<E>> EnumSet<E> of(E e1, E e2) {
        EnumSet<E> set = of(e1);
        set.add(e2);
        return set;
    }
    
    public static <E extends Enum<E>> EnumSet<E> of(E e1, E e2, E e3) {
        EnumSet<E> set = of(e1, e2);
        set.add(e3);
        return set;
    }
    
    public static <E extends Enum<E>> EnumSet<E> of(E e1, E e2, E e3, E e4) {
        EnumSet<E> set = of(e1, e2, e3);
        set.add(e4);
        return set;
    }
    
    public static <E extends Enum<E>> EnumSet<E> of(E e1, E e2, E e3, E e4, E e5) {
        EnumSet<E> set = of(e1, e2, e3, e4);
        set.add(e5);
        return set;
    }
    
    public static <E extends Enum<E>> EnumSet<E> of(E start, E... others) {
        EnumSet<E> set = of(start);
        for (E e : others) {
            set.add(e);
        }
        return set;
    }
    
    public static <E extends Enum<E>> EnumSet<E> range(E start, E end) {
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException();
        }
        EnumSet<E> set = EnumSet.noneOf(start.getDeclaringClass());
        set.setRange(start, end);
        return set;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.884 -0500", hash_original_field = "410E538DA3F679A78C5742732ACBCDAB", hash_generated_field = "EC99618EBC86758F2DE324F7F50D83B7")

    private static final long serialVersionUID = 1009687484059888093L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.887 -0500", hash_original_field = "0757B9C0415F73A0D91556E8A81F8809", hash_generated_field = "0757B9C0415F73A0D91556E8A81F8809")

     Class<E> elementClass;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.889 -0500", hash_original_method = "39015C507ACAACD362C6AF5AEC7D9CF8", hash_generated_method = "39015C507ACAACD362C6AF5AEC7D9CF8")
    
EnumSet(Class<E> cls) {
        elementClass = cls;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.904 -0500", hash_original_method = "EDF5635B07DD157E75B67DB68527FFEC", hash_generated_method = "ACF3C29D7B78CD2551BA957A21A83266")
    
abstract void complement();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.921 -0500", hash_original_method = "22E0C0F3586FDDB410A4105E191F862F", hash_generated_method = "F372EEBFD9F4E52EB239CB2AEAC3C717")
    
abstract void setRange(E start, E end);

    /**
     * Creates a new enum set with the same elements as those contained in this
     * enum set.
     *
     * @return a new enum set with the same elements as those contained in this
     *         enum set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.924 -0500", hash_original_method = "37C8AB3D6E991A765CF2ADF4E1FAB73C", hash_generated_method = "94112DC51F4003A94A0F873704824E8C")
    
@SuppressWarnings("unchecked")
    @Override
    public EnumSet<E> clone() {
        try {
            return (EnumSet<E>) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.927 -0500", hash_original_method = "04E56AE18F38E72A8E3B6B437517B693", hash_generated_method = "04E56AE18F38E72A8E3B6B437517B693")
    
boolean isValidType(Class<?> cls) {
        return cls == elementClass || cls.getSuperclass() == elementClass;
    }
    
    private static class SerializationProxy<E extends Enum<E>> implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.931 -0500", hash_original_field = "590689D01799A1C2393FB3444EAC58BE", hash_generated_field = "E79FD2852CCA02DD45BA574EFFDAB459")

        private static final long serialVersionUID = 362491234563181265L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.934 -0500", hash_original_field = "D4653695FD4E6285822AB50E4AE9CD38", hash_generated_field = "BAFDB1CEF7FBA0865D5F65267AFDE26E")

        private Class<E> elementType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.936 -0500", hash_original_field = "FB10D604B5E15C042369D34E470EFDCF", hash_generated_field = "2E15D256D1A6512A2F0AF70544EADE97")

        private E[] elements;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.898 -0400", hash_original_method = "F430ADBE7D405D29614A0779FFE3FD6E", hash_generated_method = "F430ADBE7D405D29614A0779FFE3FD6E")
        public SerializationProxy ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.939 -0500", hash_original_method = "60C5F56392547A20884548FBBB7D801A", hash_generated_method = "45836297E2DCA0C6F305BA7D8B75FD65")
        
private Object readResolve() {
            EnumSet<E> set = EnumSet.noneOf(elementType);
            for (E e : elements) {
                set.add(e);
            }
            return set;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.943 -0500", hash_original_method = "3A8DA3E34FE3E13C123721386FD31559", hash_generated_method = "4102122C8CA6BFB91A0AAFAE0AD38EAD")
    
@SuppressWarnings("unchecked")
    Object writeReplace() {
        SerializationProxy proxy = new SerializationProxy();
        proxy.elements = toArray(new Enum[0]);
        proxy.elementType = elementClass;
        return proxy;
    }
}

