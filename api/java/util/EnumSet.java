package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Serializable;

public abstract class EnumSet<E extends Enum<E>> extends AbstractSet<E> implements Cloneable, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.893 -0400", hash_original_field = "FB94A9C20B79E783DE4BCF1F79EAF776", hash_generated_field = "0757B9C0415F73A0D91556E8A81F8809")

    Class<E> elementClass;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.893 -0400", hash_original_method = "39015C507ACAACD362C6AF5AEC7D9CF8", hash_generated_method = "A30DF7F45610C591D70BF68AB99C63B7")
      EnumSet(Class<E> cls) {
        elementClass = cls;
        // ---------- Original Method ----------
        //elementClass = cls;
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    abstract void setRange(E start, E end);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.897 -0400", hash_original_method = "37C8AB3D6E991A765CF2ADF4E1FAB73C", hash_generated_method = "636C731AF07C87A06EA2B4CF35727CF2")
    @SuppressWarnings("unchecked")
    @Override
    public EnumSet<E> clone() {
        try 
        {
EnumSet<E> varEF0FA5E6D5CDFF5EA3B5838CC968F234_1045299942 =             (EnumSet<E>) super.clone();
            varEF0FA5E6D5CDFF5EA3B5838CC968F234_1045299942.addTaint(taint);
            return varEF0FA5E6D5CDFF5EA3B5838CC968F234_1045299942;
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_1377225968 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_1377225968.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_1377225968;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return (EnumSet<E>) super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.897 -0400", hash_original_method = "04E56AE18F38E72A8E3B6B437517B693", hash_generated_method = "15CCAB0C5A48F73F57F6A0F40455452C")
     boolean isValidType(Class<?> cls) {
        addTaint(cls.getTaint());
        boolean varA4C9D97F9E25688FCC6F325088E3177C_117063789 = (cls == elementClass || cls.getSuperclass() == elementClass);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1389480399 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1389480399;
        // ---------- Original Method ----------
        //return cls == elementClass || cls.getSuperclass() == elementClass;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.898 -0400", hash_original_method = "3A8DA3E34FE3E13C123721386FD31559", hash_generated_method = "4F85DE672569941BA460E291B8113A2F")
    @SuppressWarnings("unchecked")
     Object writeReplace() {
        SerializationProxy proxy = new SerializationProxy();
        proxy.elements = toArray(new Enum[0]);
        proxy.elementType = elementClass;
Object var60FC9F22F7E863EBFD33B2ADB8462743_854371647 =         proxy;
        var60FC9F22F7E863EBFD33B2ADB8462743_854371647.addTaint(taint);
        return var60FC9F22F7E863EBFD33B2ADB8462743_854371647;
        // ---------- Original Method ----------
        //SerializationProxy proxy = new SerializationProxy();
        //proxy.elements = toArray(new Enum[0]);
        //proxy.elementType = elementClass;
        //return proxy;
    }

    
    private static class SerializationProxy<E extends Enum<E>> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.898 -0400", hash_original_field = "481A5F16B24D461E31D85ABA607238B8", hash_generated_field = "BAFDB1CEF7FBA0865D5F65267AFDE26E")

        private Class<E> elementType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.898 -0400", hash_original_field = "6A7F245843454CF4F28AD7C5E2572AA2", hash_generated_field = "2E15D256D1A6512A2F0AF70544EADE97")

        private E[] elements;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.898 -0400", hash_original_method = "F430ADBE7D405D29614A0779FFE3FD6E", hash_generated_method = "F430ADBE7D405D29614A0779FFE3FD6E")
        public SerializationProxy ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.899 -0400", hash_original_method = "60C5F56392547A20884548FBBB7D801A", hash_generated_method = "F9E63A5A4DCA43DE2A708F3A2223E1C5")
        private Object readResolve() {
            EnumSet<E> set = EnumSet.noneOf(elementType);
for(E e : elements)
            {
                set.add(e);
            } //End block
Object varD2D4612E029977363A9BBEBD4F0339C0_682674571 =             set;
            varD2D4612E029977363A9BBEBD4F0339C0_682674571.addTaint(taint);
            return varD2D4612E029977363A9BBEBD4F0339C0_682674571;
            // ---------- Original Method ----------
            //EnumSet<E> set = EnumSet.noneOf(elementType);
            //for (E e : elements) {
                //set.add(e);
            //}
            //return set;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.899 -0400", hash_original_field = "63F70EFA85E609812664393CCD84E846", hash_generated_field = "E79FD2852CCA02DD45BA574EFFDAB459")

        private static final long serialVersionUID = 362491234563181265L;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.899 -0400", hash_original_field = "B777A8DDEBA23C22FE27C03920BBFA75", hash_generated_field = "EC99618EBC86758F2DE324F7F50D83B7")

    private static final long serialVersionUID = 1009687484059888093L;
}

