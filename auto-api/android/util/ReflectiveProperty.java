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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.534 -0400", hash_original_field = "16EEDAABC5C1FB42003AA47180ED612B", hash_generated_field = "EEA8654E15111D59944789CA5B543C76")

    private Method mSetter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.534 -0400", hash_original_field = "7107F73C17BAE03EC85BA17E62A26036", hash_generated_field = "6E8EC7297CA45290DB21D59C8AA7D832")

    private Method mGetter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.534 -0400", hash_original_field = "0CAB8BA8DDC27902A8770C3001E7D4DF", hash_generated_field = "0E3FF9C9FB2909B4EEFAB3A86E1A80E5")

    private Field mField;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.536 -0400", hash_original_method = "4D5217EDB6A50C089202283FEC2465A8", hash_generated_method = "26EF7CC32660E026178686553DC909A7")
    public  ReflectiveProperty(Class<T> propertyHolder, Class<V> valueType, String name) {
        super(valueType, name);
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
                        boolean var9268CA5610FB5210C54887757616A17A_611987213 = (!typesMatch(valueType, fieldType));
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
            boolean varE0F8B9103254BA81ACC9A19D1436928E_2009923460 = (!typesMatch(valueType, getterType));
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
        addTaint(valueType.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.537 -0400", hash_original_method = "ED015CEE91613D6F524378162B530528", hash_generated_method = "2E092B2938484EF290912004EECCCDB7")
    private boolean typesMatch(Class<V> valueType, Class getterType) {
        {
            {
                boolean var15116A97817E37F8F785F1AE4B1D8378_752699957 = (getterType.isPrimitive());
            } //End collapsed parenthetic
        } //End block
        addTaint(valueType.getTaint());
        addTaint(getterType.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_79338384 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_79338384;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.550 -0400", hash_original_method = "9BC237A59BE2F86E825267381E38AEC8", hash_generated_method = "4D0CC7DEB5DFC49E01B15312CF58C810")
    @Override
    public void set(T object, V value) {
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
        addTaint(object.getTaint());
        addTaint(value.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.551 -0400", hash_original_method = "4070872B48CA952F40E8D9AD673A26AA", hash_generated_method = "7FD570B74BC07B0F82923DB212E4404D")
    @Override
    public V get(T object) {
        V varB4EAC82CA7396A68D541C85D26508E83_742910111 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_1326146542 = null; //Variable for return #2
        {
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_742910111 = (V) mGetter.invoke(object, (Object[])null);
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
                varB4EAC82CA7396A68D541C85D26508E83_1326146542 = (V) mField.get(object);
            } //End block
            catch (IllegalAccessException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new AssertionError();
            } //End block
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new AssertionError();
        addTaint(object.getTaint());
        V varA7E53CE21691AB073D9660D615818899_1386241213; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1386241213 = varB4EAC82CA7396A68D541C85D26508E83_742910111;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1386241213 = varB4EAC82CA7396A68D541C85D26508E83_1326146542;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1386241213.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1386241213;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.553 -0400", hash_original_method = "176D77E232A76459A0F514B7F2AA65DB", hash_generated_method = "1C54CDCEC63135E28ED1878189E0AAEC")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_517971596 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_517971596;
        // ---------- Original Method ----------
        //return (mSetter == null && mField == null);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.553 -0400", hash_original_field = "25304E0CA662AE83D08DBF98C8D49512", hash_generated_field = "2A5C594F2BEF0BF666F0F88A20D8D536")

    private static String PREFIX_GET = "get";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.553 -0400", hash_original_field = "833FCA24685BACBAAEB467CFFA681776", hash_generated_field = "32F999CAFF347D8E14B6988B23AB1CF0")

    private static String PREFIX_IS = "is";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.553 -0400", hash_original_field = "A5A69007E412F74A05D61934014BBC10", hash_generated_field = "6033275DC6CCCED1E7B80816287C3AAE")

    private static String PREFIX_SET = "set";
}

