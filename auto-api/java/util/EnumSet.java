package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.Serializable;

public abstract class EnumSet<E extends Enum<E>> extends AbstractSet<E> implements Cloneable, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.241 -0400", hash_original_field = "FB94A9C20B79E783DE4BCF1F79EAF776", hash_generated_field = "0757B9C0415F73A0D91556E8A81F8809")

    Class<E> elementClass;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.241 -0400", hash_original_method = "39015C507ACAACD362C6AF5AEC7D9CF8", hash_generated_method = "A30DF7F45610C591D70BF68AB99C63B7")
      EnumSet(Class<E> cls) {
        elementClass = cls;
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static <E extends Enum<E>> EnumSet<E> allOf(Class<E> elementType) {
        EnumSet<E> set = noneOf(elementType);
        set.complement();
        return set;
    }

    
    @DSModeled(DSC.SAFE)
    public static <E extends Enum<E>> EnumSet<E> copyOf(EnumSet<E> s) {
        EnumSet<E> set = EnumSet.noneOf(s.elementClass);
        set.addAll(s);
        return set;
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static <E extends Enum<E>> EnumSet<E> complementOf(EnumSet<E> s) {
        EnumSet<E> set = EnumSet.noneOf(s.elementClass);
        set.addAll(s);
        set.complement();
        return set;
    }

    
    abstract void complement();

    
    @DSModeled(DSC.SAFE)
    public static <E extends Enum<E>> EnumSet<E> of(E e) {
        EnumSet<E> set = EnumSet.noneOf(e.getDeclaringClass());
        set.add(e);
        return set;
    }

    
    @DSModeled(DSC.SAFE)
    public static <E extends Enum<E>> EnumSet<E> of(E e1, E e2) {
        EnumSet<E> set = of(e1);
        set.add(e2);
        return set;
    }

    
    @DSModeled(DSC.SAFE)
    public static <E extends Enum<E>> EnumSet<E> of(E e1, E e2, E e3) {
        EnumSet<E> set = of(e1, e2);
        set.add(e3);
        return set;
    }

    
    @DSModeled(DSC.SAFE)
    public static <E extends Enum<E>> EnumSet<E> of(E e1, E e2, E e3, E e4) {
        EnumSet<E> set = of(e1, e2, e3);
        set.add(e4);
        return set;
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static <E extends Enum<E>> EnumSet<E> range(E start, E end) {
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException();
        }
        EnumSet<E> set = EnumSet.noneOf(start.getDeclaringClass());
        set.setRange(start, end);
        return set;
    }

    
    abstract void setRange(E start, E end);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.244 -0400", hash_original_method = "37C8AB3D6E991A765CF2ADF4E1FAB73C", hash_generated_method = "C4312EEEC02373BB32AD03A79E90A8AF")
    @SuppressWarnings("unchecked")
    @Override
    public EnumSet<E> clone() {
        EnumSet<E> varB4EAC82CA7396A68D541C85D26508E83_29026602 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_29026602 = (EnumSet<E>) super.clone();
        } 
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_29026602.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_29026602;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.244 -0400", hash_original_method = "04E56AE18F38E72A8E3B6B437517B693", hash_generated_method = "27CB6816053B8F0748F157B02FBFD254")
     boolean isValidType(Class<?> cls) {
        boolean varC4F22E7D1D98E0932E239EA5CACE82BB_2057604744 = (cls == elementClass || cls.getSuperclass() == elementClass);
        addTaint(cls.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_853626876 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_853626876;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.246 -0400", hash_original_method = "3A8DA3E34FE3E13C123721386FD31559", hash_generated_method = "6FA2EB01A6268ED717BBE8634B850F41")
    @SuppressWarnings("unchecked")
     Object writeReplace() {
        Object varB4EAC82CA7396A68D541C85D26508E83_257336915 = null; 
        SerializationProxy proxy = new SerializationProxy();
        proxy.elements = toArray(new Enum[0]);
        proxy.elementType = elementClass;
        varB4EAC82CA7396A68D541C85D26508E83_257336915 = proxy;
        varB4EAC82CA7396A68D541C85D26508E83_257336915.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_257336915;
        
        
        
        
        
    }

    
    private static class SerializationProxy<E extends Enum<E>> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.246 -0400", hash_original_field = "481A5F16B24D461E31D85ABA607238B8", hash_generated_field = "BAFDB1CEF7FBA0865D5F65267AFDE26E")

        private Class<E> elementType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.246 -0400", hash_original_field = "6A7F245843454CF4F28AD7C5E2572AA2", hash_generated_field = "2E15D256D1A6512A2F0AF70544EADE97")

        private E[] elements;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.246 -0400", hash_original_method = "F430ADBE7D405D29614A0779FFE3FD6E", hash_generated_method = "F430ADBE7D405D29614A0779FFE3FD6E")
        public SerializationProxy ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.249 -0400", hash_original_method = "60C5F56392547A20884548FBBB7D801A", hash_generated_method = "56D57287E50C01A98BF3EDDA5F0A63F8")
        private Object readResolve() {
            Object varB4EAC82CA7396A68D541C85D26508E83_123553871 = null; 
            EnumSet<E> set = EnumSet.noneOf(elementType);
            {
                E e = elements[0];
                {
                    set.add(e);
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_123553871 = set;
            varB4EAC82CA7396A68D541C85D26508E83_123553871.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_123553871;
            
            
            
                
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.249 -0400", hash_original_field = "63F70EFA85E609812664393CCD84E846", hash_generated_field = "E79FD2852CCA02DD45BA574EFFDAB459")

        private static final long serialVersionUID = 362491234563181265L;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.249 -0400", hash_original_field = "B777A8DDEBA23C22FE27C03920BBFA75", hash_generated_field = "EC99618EBC86758F2DE324F7F50D83B7")

    private static final long serialVersionUID = 1009687484059888093L;
}

