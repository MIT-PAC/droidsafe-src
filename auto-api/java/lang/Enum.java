package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import libcore.util.BasicLruCache;
import libcore.util.EmptyArray;

public abstract class Enum<E extends Enum<E>> implements Serializable, Comparable<E> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.427 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.427 -0400", hash_original_field = "281858037F7DCF7ED49271BB92C60526", hash_generated_field = "9B9D896414A0E67CE9221B96A63BE0CD")

    int ordinal;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.432 -0400", hash_original_method = "2DD8D404884977C1C225DE3C5244FDA0", hash_generated_method = "3A3CD01EC43B734FD3F8DAA5CF280987")
    protected  Enum(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
        // ---------- Original Method ----------
        //this.name = name;
        //this.ordinal = ordinal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.432 -0400", hash_original_method = "B829A2DCF2B6B038F9421827E4B40BDF", hash_generated_method = "143C362A77F8ECD2769F3CAECDB57CDC")
    public final String name() {
        String varB4EAC82CA7396A68D541C85D26508E83_1210376069 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1210376069 = name;
        varB4EAC82CA7396A68D541C85D26508E83_1210376069.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1210376069;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.433 -0400", hash_original_method = "F85866CCC5D845B1D53CAF0C5BA97CF5", hash_generated_method = "CEC73ED38A22EF12028855BC5BB309D6")
    public final int ordinal() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1097524327 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1097524327;
        // ---------- Original Method ----------
        //return ordinal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.433 -0400", hash_original_method = "0EB66BA5E965B83E191719250E0A82FF", hash_generated_method = "5197A53E0CFACF2AAF1A73A08A067AAC")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2034120038 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2034120038 = name;
        varB4EAC82CA7396A68D541C85D26508E83_2034120038.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2034120038;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.433 -0400", hash_original_method = "75011B979FEDB2DAAF1F1F1C2C24B4BF", hash_generated_method = "9704FC90FEBED3B84D39682C5E67F874")
    @Override
    public final boolean equals(Object other) {
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2142634918 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2142634918;
        // ---------- Original Method ----------
        //return this == other;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.434 -0400", hash_original_method = "EA441E584394EE19D2A56603F808DF7D", hash_generated_method = "5B1105DFB2CDD989410A4FA96CF50F45")
    @Override
    public final int hashCode() {
        int var7757EFC4B98575F4A69036771684C57E_406986715 = (ordinal + (name == null ? 0 : name.hashCode())); //DSFIXME:  CODE0008: Nested ternary operator in expression
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_83754221 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_83754221;
        // ---------- Original Method ----------
        //return ordinal + (name == null ? 0 : name.hashCode());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.434 -0400", hash_original_method = "E819DB208756D0A4B5DFB72B3A772B65", hash_generated_method = "7CFDAA36D607D56DCBB441FFA1E83CF5")
    @Override
    protected final Object clone() throws CloneNotSupportedException {
        if (DroidSafeAndroidRuntime.control) throw new CloneNotSupportedException("Enums may not be cloned");
        // ---------- Original Method ----------
        //throw new CloneNotSupportedException("Enums may not be cloned");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.434 -0400", hash_original_method = "914B430886739457D899D0D840F0325C", hash_generated_method = "4644FAF45477AC601C2CD24213200412")
    public final int compareTo(E o) {
        addTaint(o.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_457283777 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_457283777;
        // ---------- Original Method ----------
        //return ordinal - o.ordinal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.443 -0400", hash_original_method = "0D462A5B0CC7E5E79CA20DB4952DBB5B", hash_generated_method = "1BBDAEC04793E8F3EA02CAC633A39CDC")
    @SuppressWarnings("unchecked")
    public final Class<E> getDeclaringClass() {
        Class<E> varB4EAC82CA7396A68D541C85D26508E83_1088254238 = null; //Variable for return #1
        Class<E> varB4EAC82CA7396A68D541C85D26508E83_26783191 = null; //Variable for return #2
        Class<?> myClass;
        myClass = getClass();
        Class<?> mySuperClass;
        mySuperClass = myClass.getSuperclass();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1088254238 = (Class<E>)myClass;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_26783191 = (Class<E>)mySuperClass;
        Class<E> varA7E53CE21691AB073D9660D615818899_1264271705; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1264271705 = varB4EAC82CA7396A68D541C85D26508E83_1088254238;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1264271705 = varB4EAC82CA7396A68D541C85D26508E83_26783191;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1264271705.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1264271705;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.447 -0400", hash_original_method = "3012BD4162FEB4D4063E0B4E3944BED9", hash_generated_method = "FE1C663109CE5DFABF002048A3AF339A")
    @Override
    @SuppressWarnings("FinalizeDoesntCallSuperFinalize")
    protected final void finalize() {
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.447 -0400", hash_original_field = "7DBCEA52E8DCD6AE5AC7B75D618534F3", hash_generated_field = "7965F57B8F8F319E8512B13FAE13C9AD")

    private static long serialVersionUID = -4300926546619394005L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.449 -0400", hash_original_field = "9E1AB9651106D78F89D200A6B8A75C99", hash_generated_field = "2FB518AF8A0DE7287BE3A150134241BF")

    private static BasicLruCache<Class<? extends Enum>, Object[]> sharedConstantsCache = new BasicLruCache<Class<? extends Enum>, Object[]>(64) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.448 -0400", hash_original_method = "4DA067D184DCA03E4A8499CE8148F1DB", hash_generated_method = "ADA028285C462EFE47703D8F8F0FFC43")
        @Override
        protected Object[] create(Class<? extends Enum> enumType) {
            Object[] varB4EAC82CA7396A68D541C85D26508E83_1757866168 = null; //Variable for return #1
            Method method;
            method = (Method) Class.getDeclaredConstructorOrMethod(
                    enumType, "values", EmptyArray.CLASS);
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1757866168 = (Object[]) method.invoke((Object[]) null);
            } //End block
            catch (IllegalAccessException impossible)
            {
                if (DroidSafeAndroidRuntime.control) throw new AssertionError();
            } //End block
            catch (InvocationTargetException impossible)
            {
                if (DroidSafeAndroidRuntime.control) throw new AssertionError();
            } //End block
            addTaint(enumType.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1757866168.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1757866168;
            // ---------- Original Method ----------
            //Method method = (Method) Class.getDeclaredConstructorOrMethod(
                    //enumType, "values", EmptyArray.CLASS);
            //try {
                //return (Object[]) method.invoke((Object[]) null);
            //} catch (IllegalAccessException impossible) {
                //throw new AssertionError();
            //} catch (InvocationTargetException impossible) {
                //throw new AssertionError();
            //}
        }

        
};
}

