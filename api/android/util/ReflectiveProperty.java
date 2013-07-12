package android.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ReflectiveProperty<T, V> extends Property<T, V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.197 -0400", hash_original_field = "16EEDAABC5C1FB42003AA47180ED612B", hash_generated_field = "EEA8654E15111D59944789CA5B543C76")

    private Method mSetter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.197 -0400", hash_original_field = "7107F73C17BAE03EC85BA17E62A26036", hash_generated_field = "6E8EC7297CA45290DB21D59C8AA7D832")

    private Method mGetter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.197 -0400", hash_original_field = "0CAB8BA8DDC27902A8770C3001E7D4DF", hash_generated_field = "0E3FF9C9FB2909B4EEFAB3A86E1A80E5")

    private Field mField;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.198 -0400", hash_original_method = "4D5217EDB6A50C089202283FEC2465A8", hash_generated_method = "DB720BEB6FAE0E0B1958BCEBB7869F3C")
    public  ReflectiveProperty(Class<T> propertyHolder, Class<V> valueType, String name) {
        super(valueType, name);
        addTaint(valueType.getTaint());
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
    if(!typesMatch(valueType, fieldType))                    
                    {
                        NoSuchPropertyException var89739AF27078F6CF291E82A821220B64_1773208073 = new NoSuchPropertyException("Underlying type (" + fieldType + ") " +
                                "does not match Property type (" + valueType + ")");
                        var89739AF27078F6CF291E82A821220B64_1773208073.addTaint(taint);
                        throw var89739AF27078F6CF291E82A821220B64_1773208073;
                    } 
                    return;
                } 
                catch (NoSuchFieldException e2)
                {
                    NoSuchPropertyException var858E788E5B1503FF62C58AD5D2C7E476_367665286 = new NoSuchPropertyException("No accessor method or field found for"
                            + " property with name " + name);
                    var858E788E5B1503FF62C58AD5D2C7E476_367665286.addTaint(taint);
                    throw var858E788E5B1503FF62C58AD5D2C7E476_367665286;
                } 
            } 
        } 
        Class getterType = mGetter.getReturnType();
    if(!typesMatch(valueType, getterType))        
        {
            NoSuchPropertyException varEA57993FAB212A9EB3D78132E76DB573_1258559282 = new NoSuchPropertyException("Underlying type (" + getterType + ") " +
                    "does not match Property type (" + valueType + ")");
            varEA57993FAB212A9EB3D78132E76DB573_1258559282.addTaint(taint);
            throw varEA57993FAB212A9EB3D78132E76DB573_1258559282;
        } 
        String setterName = PREFIX_SET + capitalizedName;
        try 
        {
            mSetter = propertyHolder.getMethod(setterName, getterType);
        } 
        catch (NoSuchMethodException ignored)
        {
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.200 -0400", hash_original_method = "ED015CEE91613D6F524378162B530528", hash_generated_method = "B8E679FCBA456BC27A8FE330139F42EF")
    private boolean typesMatch(Class<V> valueType, Class getterType) {
        addTaint(getterType.getTaint());
        addTaint(valueType.getTaint());
    if(getterType != valueType)        
        {
    if(getterType.isPrimitive())            
            {
                boolean var54AB7A359F2D3C3B11FDC409AD690B54_359950014 = ((getterType == float.class && valueType == Float.class) ||
                        (getterType == int.class && valueType == Integer.class) ||
                        (getterType == boolean.class && valueType == Boolean.class) ||
                        (getterType == long.class && valueType == Long.class) ||
                        (getterType == double.class && valueType == Double.class) ||
                        (getterType == short.class && valueType == Short.class) ||
                        (getterType == byte.class && valueType == Byte.class) ||
                        (getterType == char.class && valueType == Character.class));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1897435496 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1897435496;
            } 
            boolean var68934A3E9455FA72420237EB05902327_403520319 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2132985899 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2132985899;
        } 
        boolean varB326B5062B2F0E69046810717534CB09_1680301828 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1983024837 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1983024837;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.201 -0400", hash_original_method = "9BC237A59BE2F86E825267381E38AEC8", hash_generated_method = "A65AC38E0991ABDAB0D1D65A0195EAEC")
    @Override
    public void set(T object, V value) {
        addTaint(value.getTaint());
        addTaint(object.getTaint());
    if(mSetter != null)        
        {
            try 
            {
                mSetter.invoke(object, value);
            } 
            catch (IllegalAccessException e)
            {
                AssertionError varA81442E36297E737EB908877E58260E8_1262174682 = new AssertionError();
                varA81442E36297E737EB908877E58260E8_1262174682.addTaint(taint);
                throw varA81442E36297E737EB908877E58260E8_1262174682;
            } 
            catch (InvocationTargetException e)
            {
                RuntimeException var21A9144EB1856059FE4C4B9FF95E6F43_1322203866 = new RuntimeException(e.getCause());
                var21A9144EB1856059FE4C4B9FF95E6F43_1322203866.addTaint(taint);
                throw var21A9144EB1856059FE4C4B9FF95E6F43_1322203866;
            } 
        } 
        else
    if(mField != null)        
        {
            try 
            {
                mField.set(object, value);
            } 
            catch (IllegalAccessException e)
            {
                AssertionError varA81442E36297E737EB908877E58260E8_1346433135 = new AssertionError();
                varA81442E36297E737EB908877E58260E8_1346433135.addTaint(taint);
                throw varA81442E36297E737EB908877E58260E8_1346433135;
            } 
        } 
        else
        {
            UnsupportedOperationException var7C18E98A72208702C7C0661FD2550E26_1317381738 = new UnsupportedOperationException("Property " + getName() +" is read-only");
            var7C18E98A72208702C7C0661FD2550E26_1317381738.addTaint(taint);
            throw var7C18E98A72208702C7C0661FD2550E26_1317381738;
        } 
        
        
            
                
            
                
            
                
            
        
            
                
            
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.202 -0400", hash_original_method = "4070872B48CA952F40E8D9AD673A26AA", hash_generated_method = "7CC6699337DD41AF73580930944DD5D5")
    @Override
    public V get(T object) {
        addTaint(object.getTaint());
    if(mGetter != null)        
        {
            try 
            {
V var6F170D17107151FFB1EB230D5CB4817D_185544340 =                 (V) mGetter.invoke(object, (Object[])null);
                var6F170D17107151FFB1EB230D5CB4817D_185544340.addTaint(taint);
                return var6F170D17107151FFB1EB230D5CB4817D_185544340;
            } 
            catch (IllegalAccessException e)
            {
                AssertionError varA81442E36297E737EB908877E58260E8_1975972058 = new AssertionError();
                varA81442E36297E737EB908877E58260E8_1975972058.addTaint(taint);
                throw varA81442E36297E737EB908877E58260E8_1975972058;
            } 
            catch (InvocationTargetException e)
            {
                RuntimeException var21A9144EB1856059FE4C4B9FF95E6F43_1307336171 = new RuntimeException(e.getCause());
                var21A9144EB1856059FE4C4B9FF95E6F43_1307336171.addTaint(taint);
                throw var21A9144EB1856059FE4C4B9FF95E6F43_1307336171;
            } 
        } 
        else
    if(mField != null)        
        {
            try 
            {
V varE396095FB568A116FDE56C12F3E74C0A_1336768383 =                 (V) mField.get(object);
                varE396095FB568A116FDE56C12F3E74C0A_1336768383.addTaint(taint);
                return varE396095FB568A116FDE56C12F3E74C0A_1336768383;
            } 
            catch (IllegalAccessException e)
            {
                AssertionError varA81442E36297E737EB908877E58260E8_972153670 = new AssertionError();
                varA81442E36297E737EB908877E58260E8_972153670.addTaint(taint);
                throw varA81442E36297E737EB908877E58260E8_972153670;
            } 
        } 
        AssertionError varA81442E36297E737EB908877E58260E8_1995393566 = new AssertionError();
        varA81442E36297E737EB908877E58260E8_1995393566.addTaint(taint);
        throw varA81442E36297E737EB908877E58260E8_1995393566;
        
        
            
                
            
                
            
                
            
        
            
                
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.203 -0400", hash_original_method = "176D77E232A76459A0F514B7F2AA65DB", hash_generated_method = "6D3FB7659584CE31C0E753556C93A188")
    @Override
    public boolean isReadOnly() {
        boolean var0CD26F59E51E95187630282130E31EE1_1856391403 = ((mSetter == null && mField == null));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_303079719 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_303079719;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.203 -0400", hash_original_field = "25304E0CA662AE83D08DBF98C8D49512", hash_generated_field = "DCD45C1BFB57F61F4FD82A59CD9038F7")

    private static final String PREFIX_GET = "get";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.203 -0400", hash_original_field = "833FCA24685BACBAAEB467CFFA681776", hash_generated_field = "BEF88240E4DBFFAA180B73F2B3351672")

    private static final String PREFIX_IS = "is";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.203 -0400", hash_original_field = "A5A69007E412F74A05D61934014BBC10", hash_generated_field = "69FF23A6AF0F51D218A18A1112A00C6F")

    private static final String PREFIX_SET = "set";
}

