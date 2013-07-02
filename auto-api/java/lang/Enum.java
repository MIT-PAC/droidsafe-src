package java.lang;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import libcore.util.BasicLruCache;
import libcore.util.EmptyArray;

public abstract class Enum<E extends Enum<E>> implements Serializable, Comparable<E> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.968 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.968 -0400", hash_original_field = "281858037F7DCF7ED49271BB92C60526", hash_generated_field = "9B9D896414A0E67CE9221B96A63BE0CD")

    int ordinal;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.969 -0400", hash_original_method = "2DD8D404884977C1C225DE3C5244FDA0", hash_generated_method = "3A3CD01EC43B734FD3F8DAA5CF280987")
    protected  Enum(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.969 -0400", hash_original_method = "B829A2DCF2B6B038F9421827E4B40BDF", hash_generated_method = "79CA60EE9D1057A7D6581BCAFED470BD")
    public final String name() {
        String varB4EAC82CA7396A68D541C85D26508E83_80574957 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_80574957 = name;
        varB4EAC82CA7396A68D541C85D26508E83_80574957.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_80574957;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.969 -0400", hash_original_method = "F85866CCC5D845B1D53CAF0C5BA97CF5", hash_generated_method = "8B4678E6142587D6657D8215ED485DD8")
    public final int ordinal() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_863636262 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_863636262;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.970 -0400", hash_original_method = "0EB66BA5E965B83E191719250E0A82FF", hash_generated_method = "63FE3120529F360F42489B5082934718")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_317817671 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_317817671 = name;
        varB4EAC82CA7396A68D541C85D26508E83_317817671.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_317817671;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.970 -0400", hash_original_method = "75011B979FEDB2DAAF1F1F1C2C24B4BF", hash_generated_method = "8750797A248F8B1AB247D8AF0503CD74")
    @Override
    public final boolean equals(Object other) {
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_561549600 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_561549600;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.970 -0400", hash_original_method = "EA441E584394EE19D2A56603F808DF7D", hash_generated_method = "7E5AA309F267D16B92DE0E0E24ECB228")
    @Override
    public final int hashCode() {
        int var7757EFC4B98575F4A69036771684C57E_2117114853 = (ordinal + (name == null ? 0 : name.hashCode())); 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_237067515 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_237067515;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.970 -0400", hash_original_method = "E819DB208756D0A4B5DFB72B3A772B65", hash_generated_method = "7CFDAA36D607D56DCBB441FFA1E83CF5")
    @Override
    protected final Object clone() throws CloneNotSupportedException {
    	throw new CloneNotSupportedException("Enums may not be cloned");
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.971 -0400", hash_original_method = "914B430886739457D899D0D840F0325C", hash_generated_method = "52D6F20A9BAF4D24D53B52CB63AEC7A4")
    public final int compareTo(E o) {
        addTaint(o.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_68555680 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_68555680;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.971 -0400", hash_original_method = "0D462A5B0CC7E5E79CA20DB4952DBB5B", hash_generated_method = "3641F5E846FAD51B672403C675422EBC")
    @SuppressWarnings("unchecked")
    public final Class<E> getDeclaringClass() {
        Class<E> varB4EAC82CA7396A68D541C85D26508E83_1360417961 = null; 
        Class<E> varB4EAC82CA7396A68D541C85D26508E83_478588676 = null; 
        Class<?> myClass = getClass();
        Class<?> mySuperClass = myClass.getSuperclass();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1360417961 = (Class<E>)myClass;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_478588676 = (Class<E>)mySuperClass;
        Class<E> varA7E53CE21691AB073D9660D615818899_98375339; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_98375339 = varB4EAC82CA7396A68D541C85D26508E83_1360417961;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_98375339 = varB4EAC82CA7396A68D541C85D26508E83_478588676;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_98375339.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_98375339;
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked")
    public static <T extends Enum<T>> T[] getSharedConstants(Class<T> enumType) {
        return (T[]) sharedConstantsCache.get(enumType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.972 -0400", hash_original_method = "3012BD4162FEB4D4063E0B4E3944BED9", hash_generated_method = "FE1C663109CE5DFABF002048A3AF339A")
    @Override
    @SuppressWarnings("FinalizeDoesntCallSuperFinalize")
    protected final void finalize() {
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.972 -0400", hash_original_field = "7DBCEA52E8DCD6AE5AC7B75D618534F3", hash_generated_field = "F6C6D1A2DF29E3B35FCE4B7C508D18C8")

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

