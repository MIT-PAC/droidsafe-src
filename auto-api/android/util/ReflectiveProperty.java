package android.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ReflectiveProperty<T, V> extends Property<T, V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.548 -0400", hash_original_field = "16EEDAABC5C1FB42003AA47180ED612B", hash_generated_field = "EEA8654E15111D59944789CA5B543C76")

    private Method mSetter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.548 -0400", hash_original_field = "7107F73C17BAE03EC85BA17E62A26036", hash_generated_field = "6E8EC7297CA45290DB21D59C8AA7D832")

    private Method mGetter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.548 -0400", hash_original_field = "0CAB8BA8DDC27902A8770C3001E7D4DF", hash_generated_field = "0E3FF9C9FB2909B4EEFAB3A86E1A80E5")

    private Field mField;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.549 -0400", hash_original_method = "4D5217EDB6A50C089202283FEC2465A8", hash_generated_method = "C41BBD637399E93211B18D67FBB42FE2")
    public  ReflectiveProperty(Class<T> propertyHolder, Class<V> valueType, String name) {
        super(valueType, name);
        char firstLetter = Character.toUpperCase(name.charAt(0));
        String theRest = name.substring(1);
        String capitalizedName = firstLetter + theRest;
        String getterName = PREFIX_GET + capitalizedName;
        try 
        {
            mGetter = propertyHolder.getMethod(getterName, (Class<?>[])null);
        } 
        catch (NoSuchMethodException e)
        {
            getterName = PREFIX_IS + capitalizedName;
            try 
            {
                mGetter = propertyHolder.getMethod(getterName, (Class<?>[])null);
            } 
            catch (NoSuchMethodException e1)
            {
                try 
                {
                    mField = propertyHolder.getField(name);
                    Class fieldType = mField.getType();
                    {
                        boolean var9268CA5610FB5210C54887757616A17A_474163686 = (!typesMatch(valueType, fieldType));
                        {
                            if (DroidSafeAndroidRuntime.control) throw new NoSuchPropertyException("Underlying type (" + fieldType + ") " +
                                "does not match Property type (" + valueType + ")");
                        } 
                    } 
                } 
                catch (NoSuchFieldException e2)
                {
                    if (DroidSafeAndroidRuntime.control) throw new NoSuchPropertyException("No accessor method or field found for"
                            + " property with name " + name);
                } 
            } 
        } 
        Class getterType = mGetter.getReturnType();
        {
            boolean varE0F8B9103254BA81ACC9A19D1436928E_201144115 = (!typesMatch(valueType, getterType));
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchPropertyException("Underlying type (" + getterType + ") " +
                    "does not match Property type (" + valueType + ")");
            } 
        } 
        String setterName = PREFIX_SET + capitalizedName;
        try 
        {
            mSetter = propertyHolder.getMethod(setterName, getterType);
        } 
        catch (NoSuchMethodException ignored)
        { }
        addTaint(valueType.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.550 -0400", hash_original_method = "ED015CEE91613D6F524378162B530528", hash_generated_method = "F8F44CC9D5CEE8C11ADA23B9CB6A8750")
    private boolean typesMatch(Class<V> valueType, Class getterType) {
        {
            {
                boolean var15116A97817E37F8F785F1AE4B1D8378_161625805 = (getterType.isPrimitive());
            } 
        } 
        addTaint(valueType.getTaint());
        addTaint(getterType.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_264735394 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_264735394;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.550 -0400", hash_original_method = "9BC237A59BE2F86E825267381E38AEC8", hash_generated_method = "4D0CC7DEB5DFC49E01B15312CF58C810")
    @Override
    public void set(T object, V value) {
        {
            try 
            {
                mSetter.invoke(object, value);
            } 
            catch (IllegalAccessException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new AssertionError();
            } 
            catch (InvocationTargetException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e.getCause());
            } 
        } 
        {
            try 
            {
                mField.set(object, value);
            } 
            catch (IllegalAccessException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new AssertionError();
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Property " + getName() +" is read-only");
        } 
        addTaint(object.getTaint());
        addTaint(value.getTaint());
        
        
            
                
            
                
            
                
            
        
            
                
            
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.551 -0400", hash_original_method = "4070872B48CA952F40E8D9AD673A26AA", hash_generated_method = "AC7892B10E2D1E20782EE72A4165C9AD")
    @Override
    public V get(T object) {
        V varB4EAC82CA7396A68D541C85D26508E83_506606232 = null; 
        V varB4EAC82CA7396A68D541C85D26508E83_1139843364 = null; 
        {
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_506606232 = (V) mGetter.invoke(object, (Object[])null);
            } 
            catch (IllegalAccessException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new AssertionError();
            } 
            catch (InvocationTargetException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e.getCause());
            } 
        } 
        {
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1139843364 = (V) mField.get(object);
            } 
            catch (IllegalAccessException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new AssertionError();
            } 
        } 
        if (DroidSafeAndroidRuntime.control) throw new AssertionError();
        addTaint(object.getTaint());
        V varA7E53CE21691AB073D9660D615818899_1763632809; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1763632809 = varB4EAC82CA7396A68D541C85D26508E83_506606232;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1763632809 = varB4EAC82CA7396A68D541C85D26508E83_1139843364;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1763632809.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1763632809;
        
        
            
                
            
                
            
                
            
        
            
                
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.552 -0400", hash_original_method = "176D77E232A76459A0F514B7F2AA65DB", hash_generated_method = "70471920EF9581BA3FA23E2761761D47")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1802897594 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1802897594;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.552 -0400", hash_original_field = "25304E0CA662AE83D08DBF98C8D49512", hash_generated_field = "DCD45C1BFB57F61F4FD82A59CD9038F7")

    private static final String PREFIX_GET = "get";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.552 -0400", hash_original_field = "833FCA24685BACBAAEB467CFFA681776", hash_generated_field = "BEF88240E4DBFFAA180B73F2B3351672")

    private static final String PREFIX_IS = "is";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.552 -0400", hash_original_field = "A5A69007E412F74A05D61934014BBC10", hash_generated_field = "69FF23A6AF0F51D218A18A1112A00C6F")

    private static final String PREFIX_SET = "set";
}

