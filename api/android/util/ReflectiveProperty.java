package android.util;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;






class ReflectiveProperty<T, V> extends Property<T, V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.067 -0400", hash_original_field = "16EEDAABC5C1FB42003AA47180ED612B", hash_generated_field = "EEA8654E15111D59944789CA5B543C76")

    private Method mSetter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.067 -0400", hash_original_field = "7107F73C17BAE03EC85BA17E62A26036", hash_generated_field = "6E8EC7297CA45290DB21D59C8AA7D832")

    private Method mGetter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.067 -0400", hash_original_field = "0CAB8BA8DDC27902A8770C3001E7D4DF", hash_generated_field = "0E3FF9C9FB2909B4EEFAB3A86E1A80E5")

    private Field mField;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.068 -0400", hash_original_method = "4D5217EDB6A50C089202283FEC2465A8", hash_generated_method = "47CD576DE9F87598A2D1272F978A825C")
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
                    Class fieldType = mField.getType();
                    if(!typesMatch(valueType, fieldType))                    
                    {
                        NoSuchPropertyException var89739AF27078F6CF291E82A821220B64_1443542344 = new NoSuchPropertyException("Underlying type (" + fieldType + ") " +
                                "does not match Property type (" + valueType + ")");
                        var89739AF27078F6CF291E82A821220B64_1443542344.addTaint(taint);
                        throw var89739AF27078F6CF291E82A821220B64_1443542344;
                    } //End block
                    return;
                } //End block
                catch (NoSuchFieldException e2)
                {
                    NoSuchPropertyException var858E788E5B1503FF62C58AD5D2C7E476_4367653 = new NoSuchPropertyException("No accessor method or field found for"
                            + " property with name " + name);
                    var858E788E5B1503FF62C58AD5D2C7E476_4367653.addTaint(taint);
                    throw var858E788E5B1503FF62C58AD5D2C7E476_4367653;
                } //End block
            } //End block
        } //End block
        Class getterType = mGetter.getReturnType();
        if(!typesMatch(valueType, getterType))        
        {
            NoSuchPropertyException varEA57993FAB212A9EB3D78132E76DB573_1530666159 = new NoSuchPropertyException("Underlying type (" + getterType + ") " +
                    "does not match Property type (" + valueType + ")");
            varEA57993FAB212A9EB3D78132E76DB573_1530666159.addTaint(taint);
            throw varEA57993FAB212A9EB3D78132E76DB573_1530666159;
        } //End block
        String setterName = PREFIX_SET + capitalizedName;
        try 
        {
            mSetter = propertyHolder.getMethod(setterName, getterType);
        } //End block
        catch (NoSuchMethodException ignored)
        {
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.068 -0400", hash_original_method = "ED015CEE91613D6F524378162B530528", hash_generated_method = "F79DC0FAAA8B7107A7AB9B6C257E1DF8")
    private boolean typesMatch(Class<V> valueType, Class getterType) {
        addTaint(getterType.getTaint());
        addTaint(valueType.getTaint());
        if(getterType != valueType)        
        {
            if(getterType.isPrimitive())            
            {
                boolean var54AB7A359F2D3C3B11FDC409AD690B54_1891711655 = ((getterType == float.class && valueType == Float.class) ||
                        (getterType == int.class && valueType == Integer.class) ||
                        (getterType == boolean.class && valueType == Boolean.class) ||
                        (getterType == long.class && valueType == Long.class) ||
                        (getterType == double.class && valueType == Double.class) ||
                        (getterType == short.class && valueType == Short.class) ||
                        (getterType == byte.class && valueType == Byte.class) ||
                        (getterType == char.class && valueType == Character.class));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_682391198 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_682391198;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_736039742 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_762516429 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_762516429;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_705768857 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1748540907 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1748540907;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.068 -0400", hash_original_method = "9BC237A59BE2F86E825267381E38AEC8", hash_generated_method = "CFAD963715C08895B70B6FABBF1C15B5")
    @Override
    public void set(T object, V value) {
        addTaint(value.getTaint());
        addTaint(object.getTaint());
        if(mSetter != null)        
        {
            try 
            {
                mSetter.invoke(object, value);
            } //End block
            catch (IllegalAccessException e)
            {
                AssertionError varA81442E36297E737EB908877E58260E8_284824032 = new AssertionError();
                varA81442E36297E737EB908877E58260E8_284824032.addTaint(taint);
                throw varA81442E36297E737EB908877E58260E8_284824032;
            } //End block
            catch (InvocationTargetException e)
            {
                RuntimeException var21A9144EB1856059FE4C4B9FF95E6F43_1830717592 = new RuntimeException(e.getCause());
                var21A9144EB1856059FE4C4B9FF95E6F43_1830717592.addTaint(taint);
                throw var21A9144EB1856059FE4C4B9FF95E6F43_1830717592;
            } //End block
        } //End block
        else
        if(mField != null)        
        {
            try 
            {
                mField.set(object, value);
            } //End block
            catch (IllegalAccessException e)
            {
                AssertionError varA81442E36297E737EB908877E58260E8_239704025 = new AssertionError();
                varA81442E36297E737EB908877E58260E8_239704025.addTaint(taint);
                throw varA81442E36297E737EB908877E58260E8_239704025;
            } //End block
        } //End block
        else
        {
            UnsupportedOperationException var7C18E98A72208702C7C0661FD2550E26_1990566153 = new UnsupportedOperationException("Property " + getName() +" is read-only");
            var7C18E98A72208702C7C0661FD2550E26_1990566153.addTaint(taint);
            throw var7C18E98A72208702C7C0661FD2550E26_1990566153;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.069 -0400", hash_original_method = "4070872B48CA952F40E8D9AD673A26AA", hash_generated_method = "5C3CAA4C584D2F1EF9112B658D5E5978")
    @Override
    public V get(T object) {
        addTaint(object.getTaint());
        if(mGetter != null)        
        {
            try 
            {
V var6F170D17107151FFB1EB230D5CB4817D_1204625272 =                 (V) mGetter.invoke(object, (Object[])null);
                var6F170D17107151FFB1EB230D5CB4817D_1204625272.addTaint(taint);
                return var6F170D17107151FFB1EB230D5CB4817D_1204625272;
            } //End block
            catch (IllegalAccessException e)
            {
                AssertionError varA81442E36297E737EB908877E58260E8_1817630319 = new AssertionError();
                varA81442E36297E737EB908877E58260E8_1817630319.addTaint(taint);
                throw varA81442E36297E737EB908877E58260E8_1817630319;
            } //End block
            catch (InvocationTargetException e)
            {
                RuntimeException var21A9144EB1856059FE4C4B9FF95E6F43_249896443 = new RuntimeException(e.getCause());
                var21A9144EB1856059FE4C4B9FF95E6F43_249896443.addTaint(taint);
                throw var21A9144EB1856059FE4C4B9FF95E6F43_249896443;
            } //End block
        } //End block
        else
        if(mField != null)        
        {
            try 
            {
V varE396095FB568A116FDE56C12F3E74C0A_738716014 =                 (V) mField.get(object);
                varE396095FB568A116FDE56C12F3E74C0A_738716014.addTaint(taint);
                return varE396095FB568A116FDE56C12F3E74C0A_738716014;
            } //End block
            catch (IllegalAccessException e)
            {
                AssertionError varA81442E36297E737EB908877E58260E8_1933201669 = new AssertionError();
                varA81442E36297E737EB908877E58260E8_1933201669.addTaint(taint);
                throw varA81442E36297E737EB908877E58260E8_1933201669;
            } //End block
        } //End block
        AssertionError varA81442E36297E737EB908877E58260E8_1400617155 = new AssertionError();
        varA81442E36297E737EB908877E58260E8_1400617155.addTaint(taint);
        throw varA81442E36297E737EB908877E58260E8_1400617155;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.069 -0400", hash_original_method = "176D77E232A76459A0F514B7F2AA65DB", hash_generated_method = "D32CBF21FCD7FD188B6F0A193EFA729A")
    @Override
    public boolean isReadOnly() {
        boolean var0CD26F59E51E95187630282130E31EE1_484025215 = ((mSetter == null && mField == null));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_336240994 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_336240994;
        // ---------- Original Method ----------
        //return (mSetter == null && mField == null);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.069 -0400", hash_original_field = "25304E0CA662AE83D08DBF98C8D49512", hash_generated_field = "DCD45C1BFB57F61F4FD82A59CD9038F7")

    private static final String PREFIX_GET = "get";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.069 -0400", hash_original_field = "833FCA24685BACBAAEB467CFFA681776", hash_generated_field = "BEF88240E4DBFFAA180B73F2B3351672")

    private static final String PREFIX_IS = "is";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.069 -0400", hash_original_field = "A5A69007E412F74A05D61934014BBC10", hash_generated_field = "69FF23A6AF0F51D218A18A1112A00C6F")

    private static final String PREFIX_SET = "set";
}

