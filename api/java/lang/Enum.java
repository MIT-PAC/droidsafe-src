package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import libcore.util.BasicLruCache;
import libcore.util.EmptyArray;

public abstract class Enum<E extends Enum<E>> implements Serializable, Comparable<E> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.882 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.882 -0400", hash_original_field = "281858037F7DCF7ED49271BB92C60526", hash_generated_field = "9B9D896414A0E67CE9221B96A63BE0CD")

    int ordinal;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.883 -0400", hash_original_method = "2DD8D404884977C1C225DE3C5244FDA0", hash_generated_method = "3A3CD01EC43B734FD3F8DAA5CF280987")
    protected  Enum(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
        // ---------- Original Method ----------
        //this.name = name;
        //this.ordinal = ordinal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.883 -0400", hash_original_method = "B829A2DCF2B6B038F9421827E4B40BDF", hash_generated_method = "8A30242CE8D0CB02E57E58DCDA24F567")
    public final String name() {
String varB017984728AC60AD1F0BF8734F33F15C_757045605 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_757045605.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_757045605;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.883 -0400", hash_original_method = "F85866CCC5D845B1D53CAF0C5BA97CF5", hash_generated_method = "EF8D0A297BAABEB927165E73292CBAB7")
    public final int ordinal() {
        int var281858037F7DCF7ED49271BB92C60526_998066655 = (ordinal);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_341565542 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_341565542;
        // ---------- Original Method ----------
        //return ordinal;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.883 -0400", hash_original_method = "0EB66BA5E965B83E191719250E0A82FF", hash_generated_method = "327C80A5A85A0E5B677D523066C17A2C")
    @Override
    public String toString() {
String varB017984728AC60AD1F0BF8734F33F15C_260720592 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_260720592.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_260720592;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.884 -0400", hash_original_method = "75011B979FEDB2DAAF1F1F1C2C24B4BF", hash_generated_method = "B583E0ADA66D824780621E405990FBFE")
    @Override
    public final boolean equals(Object other) {
        addTaint(other.getTaint());
        boolean varBE1F9AF96A88D9FBF24773A7F592CAA1_163519073 = (this == other);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1952540366 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1952540366;
        // ---------- Original Method ----------
        //return this == other;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.884 -0400", hash_original_method = "EA441E584394EE19D2A56603F808DF7D", hash_generated_method = "B06EC22335759DBCCCD8FE540B2969CD")
    @Override
    public final int hashCode() {
        int var33D1C4572F13B312B30F81348BACBF5B_1878844967 = (ordinal + (name == null ? 0 : name.hashCode()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1387709158 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1387709158;
        // ---------- Original Method ----------
        //return ordinal + (name == null ? 0 : name.hashCode());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.884 -0400", hash_original_method = "E819DB208756D0A4B5DFB72B3A772B65", hash_generated_method = "9B119528F2A1B8082DAB33EF18F80266")
    @Override
    protected final Object clone() throws CloneNotSupportedException {
        CloneNotSupportedException var0F695EF6D311AE6302038C57F4C701F5_697978242 = new CloneNotSupportedException("Enums may not be cloned");
        var0F695EF6D311AE6302038C57F4C701F5_697978242.addTaint(taint);
        throw var0F695EF6D311AE6302038C57F4C701F5_697978242;
        // ---------- Original Method ----------
        //throw new CloneNotSupportedException("Enums may not be cloned");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.885 -0400", hash_original_method = "914B430886739457D899D0D840F0325C", hash_generated_method = "E0B302E8443D845F17BB1335C3F8C851")
    public final int compareTo(E o) {
        addTaint(o.getTaint());
        int var2F1BC9575CF0B62B5E318FC18441A6C5_506069942 = (ordinal - o.ordinal);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_533829681 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_533829681;
        // ---------- Original Method ----------
        //return ordinal - o.ordinal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.885 -0400", hash_original_method = "0D462A5B0CC7E5E79CA20DB4952DBB5B", hash_generated_method = "A1C39A8D489C80F6E7D350EDA2F474AC")
    @SuppressWarnings("unchecked")
    public final Class<E> getDeclaringClass() {
        Class<?> myClass = getClass();
        Class<?> mySuperClass = myClass.getSuperclass();
        if(Enum.class == mySuperClass)        
        {
Class<E> varB15DA18871E1717E67B355E232DDA51C_793700120 =             (Class<E>)myClass;
            varB15DA18871E1717E67B355E232DDA51C_793700120.addTaint(taint);
            return varB15DA18871E1717E67B355E232DDA51C_793700120;
        } //End block
Class<E> var8F6953680D8F9BB6E774268F02FC3AA7_2002885057 =         (Class<E>)mySuperClass;
        var8F6953680D8F9BB6E774268F02FC3AA7_2002885057.addTaint(taint);
        return var8F6953680D8F9BB6E774268F02FC3AA7_2002885057;
        // ---------- Original Method ----------
        //Class<?> myClass = getClass();
        //Class<?> mySuperClass = myClass.getSuperclass();
        //if (Enum.class == mySuperClass) {
            //return (Class<E>)myClass;
        //}
        //return (Class<E>)mySuperClass;
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.886 -0400", hash_original_method = "3012BD4162FEB4D4063E0B4E3944BED9", hash_generated_method = "FE1C663109CE5DFABF002048A3AF339A")
    @Override
    @SuppressWarnings("FinalizeDoesntCallSuperFinalize")
    protected final void finalize() {
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.887 -0400", hash_original_field = "7DBCEA52E8DCD6AE5AC7B75D618534F3", hash_generated_field = "F6C6D1A2DF29E3B35FCE4B7C508D18C8")

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
}

