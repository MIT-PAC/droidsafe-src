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
    private String name;
    private int ordinal;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:16:36.973 -0400", hash_original_method = "2DD8D404884977C1C225DE3C5244FDA0", hash_generated_method = "3C2ABA71BBDE3A1E044A771ABA95B245")
    @DSModeled(DSC.SAFE)
    protected Enum(String name, int ordinal) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(ordinal);
        // ---------- Original Method ----------
        //this.name = name;
        //this.ordinal = ordinal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:16:36.996 -0400", hash_original_method = "B829A2DCF2B6B038F9421827E4B40BDF", hash_generated_method = "964A63D5360B676B99ED7B64A0FDD36D")
    @DSModeled(DSC.SAFE)
    public final String name() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:16:37.008 -0400", hash_original_method = "F85866CCC5D845B1D53CAF0C5BA97CF5", hash_generated_method = "6C0FC637AEF0E07635B4B8803ADFF7FB")
    @DSModeled(DSC.SAFE)
    public final int ordinal() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return ordinal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:16:37.018 -0400", hash_original_method = "0EB66BA5E965B83E191719250E0A82FF", hash_generated_method = "07B6DEDCDA0BCBF94ECA7AFA0C3C49FD")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:16:37.035 -0400", hash_original_method = "75011B979FEDB2DAAF1F1F1C2C24B4BF", hash_generated_method = "C2C3011E1C73CB48A8F4A51CFD543144")
    @DSModeled(DSC.SAFE)
    @Override
    public final boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this == other;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:16:37.072 -0400", hash_original_method = "EA441E584394EE19D2A56603F808DF7D", hash_generated_method = "B95475F400F3D54CA693FD186A65F0E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final int hashCode() {
        int var7757EFC4B98575F4A69036771684C57E_388588480 = (ordinal + (name == null ? 0 : name.hashCode())); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return ordinal + (name == null ? 0 : name.hashCode());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:16:37.089 -0400", hash_original_method = "E819DB208756D0A4B5DFB72B3A772B65", hash_generated_method = "793C8241B0588E44083381264991548D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected final Object clone() throws CloneNotSupportedException {
        if (DroidSafeAndroidRuntime.control) throw new CloneNotSupportedException("Enums may not be cloned");
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new CloneNotSupportedException("Enums may not be cloned");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:16:37.105 -0400", hash_original_method = "914B430886739457D899D0D840F0325C", hash_generated_method = "CAA3A94FF9F726DBA8DA1F6319A04C26")
    @DSModeled(DSC.SAFE)
    public final int compareTo(E o) {
        dsTaint.addTaint(o.dsTaint);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return ordinal - o.ordinal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:16:37.126 -0400", hash_original_method = "0D462A5B0CC7E5E79CA20DB4952DBB5B", hash_generated_method = "C7B23DDC4F8263878ACD2974B907C608")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public final Class<E> getDeclaringClass() {
        Class<?> myClass;
        myClass = getClass();
        Class<?> mySuperClass;
        mySuperClass = myClass.getSuperclass();
        return (Class<E>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:16:37.164 -0400", hash_original_method = "3012BD4162FEB4D4063E0B4E3944BED9", hash_generated_method = "FE1C663109CE5DFABF002048A3AF339A")
    @DSModeled(DSC.SAFE)
    @Override
    @SuppressWarnings("FinalizeDoesntCallSuperFinalize")
    protected final void finalize() {
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -4300926546619394005L;
    private static final BasicLruCache<Class<? extends Enum>, Object[]> sharedConstantsCache = new BasicLruCache<Class<? extends Enum>, Object[]>(64) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:16:37.195 -0400", hash_original_method = "4DA067D184DCA03E4A8499CE8148F1DB", hash_generated_method = "2D1A3037B9931E07F8549B31C3013597")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected Object[] create(Class<? extends Enum> enumType) {
            dsTaint.addTaint(enumType.dsTaint);
            Method method;
            method = (Method) Class.getDeclaredConstructorOrMethod(
                    enumType, "values", EmptyArray.CLASS);
            try 
            {
                Object[] varB28655DAFC9E6BD40C5D48F62FFE72C2_686223504 = ((Object[]) method.invoke((Object[]) null));
            } //End block
            catch (IllegalAccessException impossible)
            {
                if (DroidSafeAndroidRuntime.control) throw new AssertionError();
            } //End block
            catch (InvocationTargetException impossible)
            {
                if (DroidSafeAndroidRuntime.control) throw new AssertionError();
            } //End block
            return (Object[])dsTaint.getTaint();
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

        
}; //Transformed anonymous class
}

