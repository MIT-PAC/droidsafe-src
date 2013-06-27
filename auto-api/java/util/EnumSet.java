package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public abstract class EnumSet<E extends Enum<E>> extends AbstractSet<E> implements Cloneable, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.816 -0400", hash_original_field = "FB94A9C20B79E783DE4BCF1F79EAF776", hash_generated_field = "0757B9C0415F73A0D91556E8A81F8809")

    Class<E> elementClass;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.824 -0400", hash_original_method = "39015C507ACAACD362C6AF5AEC7D9CF8", hash_generated_method = "A30DF7F45610C591D70BF68AB99C63B7")
      EnumSet(Class<E> cls) {
        elementClass = cls;
        // ---------- Original Method ----------
        //elementClass = cls;
    }

    
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

    
    abstract void complement();

    
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

    
    abstract void setRange(E start, E end);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.839 -0400", hash_original_method = "37C8AB3D6E991A765CF2ADF4E1FAB73C", hash_generated_method = "E56435244F95864B23BBC7EDC27C8C3D")
    @SuppressWarnings("unchecked")
    @Override
    public EnumSet<E> clone() {
        EnumSet<E> varB4EAC82CA7396A68D541C85D26508E83_1194555639 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1194555639 = (EnumSet<E>) super.clone();
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1194555639.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1194555639;
        // ---------- Original Method ----------
        //try {
            //return (EnumSet<E>) super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.839 -0400", hash_original_method = "04E56AE18F38E72A8E3B6B437517B693", hash_generated_method = "36A2C985B5C301EC51ECF75D0C6AA574")
     boolean isValidType(Class<?> cls) {
        boolean varC4F22E7D1D98E0932E239EA5CACE82BB_1489244684 = (cls == elementClass || cls.getSuperclass() == elementClass);
        addTaint(cls.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1918022107 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1918022107;
        // ---------- Original Method ----------
        //return cls == elementClass || cls.getSuperclass() == elementClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.840 -0400", hash_original_method = "3A8DA3E34FE3E13C123721386FD31559", hash_generated_method = "190804827AE1295D1A8E792067D0E980")
    @SuppressWarnings("unchecked")
     Object writeReplace() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1442351849 = null; //Variable for return #1
        SerializationProxy proxy;
        proxy = new SerializationProxy();
        proxy.elements = toArray(new Enum[0]);
        proxy.elementType = elementClass;
        varB4EAC82CA7396A68D541C85D26508E83_1442351849 = proxy;
        varB4EAC82CA7396A68D541C85D26508E83_1442351849.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1442351849;
        // ---------- Original Method ----------
        //SerializationProxy proxy = new SerializationProxy();
        //proxy.elements = toArray(new Enum[0]);
        //proxy.elementType = elementClass;
        //return proxy;
    }

    
    private static class SerializationProxy<E extends Enum<E>> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.841 -0400", hash_original_field = "481A5F16B24D461E31D85ABA607238B8", hash_generated_field = "BAFDB1CEF7FBA0865D5F65267AFDE26E")

        private Class<E> elementType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.841 -0400", hash_original_field = "6A7F245843454CF4F28AD7C5E2572AA2", hash_generated_field = "2E15D256D1A6512A2F0AF70544EADE97")

        private E[] elements;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.841 -0400", hash_original_method = "F430ADBE7D405D29614A0779FFE3FD6E", hash_generated_method = "F430ADBE7D405D29614A0779FFE3FD6E")
        public SerializationProxy ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.856 -0400", hash_original_method = "60C5F56392547A20884548FBBB7D801A", hash_generated_method = "FB1704294C49F7B25B12395CA6238921")
        private Object readResolve() {
            Object varB4EAC82CA7396A68D541C85D26508E83_455849984 = null; //Variable for return #1
            EnumSet<E> set;
            set = EnumSet.noneOf(elementType);
            {
                E e = elements[0];
                {
                    set.add(e);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_455849984 = set;
            varB4EAC82CA7396A68D541C85D26508E83_455849984.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_455849984;
            // ---------- Original Method ----------
            //EnumSet<E> set = EnumSet.noneOf(elementType);
            //for (E e : elements) {
                //set.add(e);
            //}
            //return set;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.857 -0400", hash_original_field = "63F70EFA85E609812664393CCD84E846", hash_generated_field = "3517FF6680B2F6A4F7DA074A9B6F93DE")

        private static long serialVersionUID = 362491234563181265L;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.883 -0400", hash_original_field = "B777A8DDEBA23C22FE27C03920BBFA75", hash_generated_field = "6874F63EC6BDFE3C491C6CE67D87A475")

    private static long serialVersionUID = 1009687484059888093L;
}

