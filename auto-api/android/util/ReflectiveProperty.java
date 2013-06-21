package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ReflectiveProperty<T, V> extends Property<T, V> {
    private Method mSetter;
    private Method mGetter;
    private Field mField;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.330 -0400", hash_original_method = "4D5217EDB6A50C089202283FEC2465A8", hash_generated_method = "95176A0F961D7D314A400C88FD0EB915")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ReflectiveProperty(Class<T> propertyHolder, Class<V> valueType, String name) {
        super(valueType, name);
        dsTaint.addTaint(propertyHolder.dsTaint);
        dsTaint.addTaint(name);
        dsTaint.addTaint(valueType.dsTaint);
        char firstLetter;
        firstLetter = Character.toUpperCase(name.charAt(0));
        String theRest;
        theRest = name.substring(1);
        String capitalizedName;
        capitalizedName = firstLetter + theRest;
        String getterName;
        getterName = PREFIX_GET + capitalizedName;
        try 
        {
            mGetter = propertyHolder.getMethod(getterName, (Class<?>[])null);
        } //End block
        catch (NoSuchMethodException e)
        {
            getterName = PREFIX_IS + capitalizedName;
            try 
            {
                mGetter = propertyHolder.getMethod(getterName, (Class<?>[])null);
            } //End block
            catch (NoSuchMethodException e1)
            {
                try 
                {
                    mField = propertyHolder.getField(name);
                    Class fieldType;
                    fieldType = mField.getType();
                    {
                        boolean var9268CA5610FB5210C54887757616A17A_1902898069 = (!typesMatch(valueType, fieldType));
                        {
                            if (DroidSafeAndroidRuntime.control) throw new NoSuchPropertyException("Underlying type (" + fieldType + ") " +
                                "does not match Property type (" + valueType + ")");
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                catch (NoSuchFieldException e2)
                {
                    if (DroidSafeAndroidRuntime.control) throw new NoSuchPropertyException("No accessor method or field found for"
                            + " property with name " + name);
                } //End block
            } //End block
        } //End block
        Class getterType;
        getterType = mGetter.getReturnType();
        {
            boolean varE0F8B9103254BA81ACC9A19D1436928E_1681098900 = (!typesMatch(valueType, getterType));
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchPropertyException("Underlying type (" + getterType + ") " +
                    "does not match Property type (" + valueType + ")");
            } //End block
        } //End collapsed parenthetic
        String setterName;
        setterName = PREFIX_SET + capitalizedName;
        try 
        {
            mSetter = propertyHolder.getMethod(setterName, getterType);
        } //End block
        catch (NoSuchMethodException ignored)
        { }
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.330 -0400", hash_original_method = "ED015CEE91613D6F524378162B530528", hash_generated_method = "F0801EC9FBF30740D18AC32C743EF1C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean typesMatch(Class<V> valueType, Class getterType) {
        dsTaint.addTaint(getterType.dsTaint);
        dsTaint.addTaint(valueType.dsTaint);
        {
            {
                boolean var15116A97817E37F8F785F1AE4B1D8378_6895726 = (getterType.isPrimitive());
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.331 -0400", hash_original_method = "9BC237A59BE2F86E825267381E38AEC8", hash_generated_method = "FB89EFE045D8B83617A88F7AF7BDBE0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void set(T object, V value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(object.dsTaint);
        {
            try 
            {
                mSetter.invoke(object, value);
            } //End block
            catch (IllegalAccessException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new AssertionError();
            } //End block
            catch (InvocationTargetException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e.getCause());
            } //End block
        } //End block
        {
            try 
            {
                mField.set(object, value);
            } //End block
            catch (IllegalAccessException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new AssertionError();
            } //End block
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Property " + getName() +" is read-only");
        } //End block
        // ---------- Original Method ----------
        //if (mSetter != null) {
            //try {
                //mSetter.invoke(object, value);
            //} catch (IllegalAccessException e) {
                //throw new AssertionError();
            //} catch (InvocationTargetException e) {
                //throw new RuntimeException(e.getCause());
            //}
        //} else if (mField != null) {
            //try {
                //mField.set(object, value);
            //} catch (IllegalAccessException e) {
                //throw new AssertionError();
            //}
        //} else {
            //throw new UnsupportedOperationException("Property " + getName() +" is read-only");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.331 -0400", hash_original_method = "4070872B48CA952F40E8D9AD673A26AA", hash_generated_method = "497219FD145C7F494BCC004CEA6F2F37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public V get(T object) {
        dsTaint.addTaint(object.dsTaint);
        {
            try 
            {
                V var06A2599A94AA6D9609858EF9FD4A877F_1921981604 = ((V) mGetter.invoke(object, (Object[])null));
            } //End block
            catch (IllegalAccessException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new AssertionError();
            } //End block
            catch (InvocationTargetException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e.getCause());
            } //End block
        } //End block
        {
            try 
            {
                V var955D7B307F3520A05B35145A82037DF4_675644043 = ((V) mField.get(object));
            } //End block
            catch (IllegalAccessException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new AssertionError();
            } //End block
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new AssertionError();
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mGetter != null) {
            //try {
                //return (V) mGetter.invoke(object, (Object[])null);
            //} catch (IllegalAccessException e) {
                //throw new AssertionError();
            //} catch (InvocationTargetException e) {
                //throw new RuntimeException(e.getCause());
            //}
        //} else if (mField != null) {
            //try {
                //return (V) mField.get(object);
            //} catch (IllegalAccessException e) {
                //throw new AssertionError();
            //}
        //}
        //throw new AssertionError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.331 -0400", hash_original_method = "176D77E232A76459A0F514B7F2AA65DB", hash_generated_method = "0B0AD12BBFF1E6CA163603F9F014CE50")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isReadOnly() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mSetter == null && mField == null);
    }

    
    private static final String PREFIX_GET = "get";
    private static final String PREFIX_IS = "is";
    private static final String PREFIX_SET = "set";
}

