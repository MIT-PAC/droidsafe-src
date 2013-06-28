package android.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.FloatProperty;
import android.util.IntProperty;
import android.util.Log;
import android.util.Property;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PropertyValuesHolder implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.744 -0400", hash_original_field = "AFC1281EACDFDDEC758551A3AAE3876C", hash_generated_field = "3E0E605326E1698CDE7903701811F2C0")

    String mPropertyName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.744 -0400", hash_original_field = "3BE74FBBD7FF163511D9CBD518CBA4A5", hash_generated_field = "E251A73627C8A3AA16F08ACAF8645F40")

    protected Property mProperty;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.745 -0400", hash_original_field = "D97BFD6711E9CC57FA5DB2FD2F8DE87B", hash_generated_field = "848F529A6ABC40F993A3D418131EC7A7")

    Method mSetter = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.745 -0400", hash_original_field = "8CE425F19DFD100C313BF3389D2C121A", hash_generated_field = "E1F4E67E7973C49A4B9CE526E6FC6D89")

    private Method mGetter = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.745 -0400", hash_original_field = "98DE3BF49406C5ACB6938D9BD7C43E69", hash_generated_field = "28819529602B8605503B4054C761CC6C")

    Class mValueType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.745 -0400", hash_original_field = "4849D8B4AB6A0FE1F7B81C0C07A14B0B", hash_generated_field = "C6973E4C17AF76FE86969D85049286F9")

    KeyframeSet mKeyframeSet = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.746 -0400", hash_original_field = "FD615E1C9081D8D57987D5321893DFF1", hash_generated_field = "F9F4D75002E3053AFE14BD3164953095")

    final ReentrantReadWriteLock mPropertyMapLock = new ReentrantReadWriteLock();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.746 -0400", hash_original_field = "90FCE5F7BA7EF0DAA4E972BE07405AE2", hash_generated_field = "D71A65350B0F0F3529679E7C5F1E5190")

    final Object[] mTmpValueArray = new Object[1];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.746 -0400", hash_original_field = "A5A16062C8CFDCD2D78B97324D59FBBD", hash_generated_field = "49D878C6212418A96C46E0217176C94E")

    private TypeEvaluator mEvaluator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.746 -0400", hash_original_field = "3A611FC8D0DF942B3AE2A62063E4425B", hash_generated_field = "B2B6DB149B87CF34CE07060A7A505841")

    private Object mAnimatedValue;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.747 -0400", hash_original_method = "73C53AD6C55F8F35D3899F0ADDC03638", hash_generated_method = "173B3BF84BCAAD759EC1E53526977EB5")
    private  PropertyValuesHolder(String propertyName) {
        mPropertyName = propertyName;
        // ---------- Original Method ----------
        //mPropertyName = propertyName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.748 -0400", hash_original_method = "BDE609B5B8790707A2E7C7F2E71E73EE", hash_generated_method = "5DE9995FB67BDB2A36117192638C1042")
    private  PropertyValuesHolder(Property property) {
        mProperty = property;
        {
            mPropertyName = property.getName();
        } //End block
        // ---------- Original Method ----------
        //mProperty = property;
        //if (property != null) {
            //mPropertyName = property.getName();
        //}
    }

    
    public static PropertyValuesHolder ofInt(String propertyName, int... values) {
        return new IntPropertyValuesHolder(propertyName, values);
    }

    
    public static PropertyValuesHolder ofInt(Property<?, Integer> property, int... values) {
        return new IntPropertyValuesHolder(property, values);
    }

    
    public static PropertyValuesHolder ofFloat(String propertyName, float... values) {
        return new FloatPropertyValuesHolder(propertyName, values);
    }

    
    public static PropertyValuesHolder ofFloat(Property<?, Float> property, float... values) {
        return new FloatPropertyValuesHolder(property, values);
    }

    
    public static PropertyValuesHolder ofObject(String propertyName, TypeEvaluator evaluator,
            Object... values) {
        PropertyValuesHolder pvh = new PropertyValuesHolder(propertyName);
        pvh.setObjectValues(values);
        pvh.setEvaluator(evaluator);
        return pvh;
    }

    
    public static <V> PropertyValuesHolder ofObject(Property property,
            TypeEvaluator<V> evaluator, V... values) {
        PropertyValuesHolder pvh = new PropertyValuesHolder(property);
        pvh.setObjectValues(values);
        pvh.setEvaluator(evaluator);
        return pvh;
    }

    
    public static PropertyValuesHolder ofKeyframe(String propertyName, Keyframe... values) {
        KeyframeSet keyframeSet = KeyframeSet.ofKeyframe(values);
        if (keyframeSet instanceof IntKeyframeSet) {
            return new IntPropertyValuesHolder(propertyName, (IntKeyframeSet) keyframeSet);
        } else if (keyframeSet instanceof FloatKeyframeSet) {
            return new FloatPropertyValuesHolder(propertyName, (FloatKeyframeSet) keyframeSet);
        }
        else {
            PropertyValuesHolder pvh = new PropertyValuesHolder(propertyName);
            pvh.mKeyframeSet = keyframeSet;
            pvh.mValueType = ((Keyframe)values[0]).getType();
            return pvh;
        }
    }

    
    public static PropertyValuesHolder ofKeyframe(Property property, Keyframe... values) {
        KeyframeSet keyframeSet = KeyframeSet.ofKeyframe(values);
        if (keyframeSet instanceof IntKeyframeSet) {
            return new IntPropertyValuesHolder(property, (IntKeyframeSet) keyframeSet);
        } else if (keyframeSet instanceof FloatKeyframeSet) {
            return new FloatPropertyValuesHolder(property, (FloatKeyframeSet) keyframeSet);
        }
        else {
            PropertyValuesHolder pvh = new PropertyValuesHolder(property);
            pvh.mKeyframeSet = keyframeSet;
            pvh.mValueType = ((Keyframe)values[0]).getType();
            return pvh;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.756 -0400", hash_original_method = "5ACB1BF4CE1DE924456A446D3AE6F5AC", hash_generated_method = "F988F397E0C59F23B11B46996200454C")
    public void setIntValues(int... values) {
        mValueType = int.class;
        mKeyframeSet = KeyframeSet.ofInt(values);
        // ---------- Original Method ----------
        //mValueType = int.class;
        //mKeyframeSet = KeyframeSet.ofInt(values);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.757 -0400", hash_original_method = "E55475A51A76C9AF68CEE5048B067603", hash_generated_method = "9308781A147C7C8F6EE137B61C15BCBE")
    public void setFloatValues(float... values) {
        mValueType = float.class;
        mKeyframeSet = KeyframeSet.ofFloat(values);
        // ---------- Original Method ----------
        //mValueType = float.class;
        //mKeyframeSet = KeyframeSet.ofFloat(values);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.760 -0400", hash_original_method = "A7BBAF2A9B12EBB30CB57DBA83B6B7FC", hash_generated_method = "2E2A9A8ADE43C4F3D41CAB3D475C086D")
    public void setKeyframes(Keyframe... values) {
        int numKeyframes = values.length;
        Keyframe keyframes[] = new Keyframe[Math.max(numKeyframes,2)];
        mValueType = ((Keyframe)values[0]).getType();
        {
            int i = 0;
            {
                keyframes[i] = (Keyframe)values[i];
            } //End block
        } //End collapsed parenthetic
        mKeyframeSet = new KeyframeSet(keyframes);
        // ---------- Original Method ----------
        //int numKeyframes = values.length;
        //Keyframe keyframes[] = new Keyframe[Math.max(numKeyframes,2)];
        //mValueType = ((Keyframe)values[0]).getType();
        //for (int i = 0; i < numKeyframes; ++i) {
            //keyframes[i] = (Keyframe)values[i];
        //}
        //mKeyframeSet = new KeyframeSet(keyframes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.763 -0400", hash_original_method = "8EF0800B602558BC1B6F05E6446D461B", hash_generated_method = "009C87DF8D68A19F0FC02389A7898792")
    public void setObjectValues(Object... values) {
        mValueType = values[0].getClass();
        mKeyframeSet = KeyframeSet.ofObject(values);
        // ---------- Original Method ----------
        //mValueType = values[0].getClass();
        //mKeyframeSet = KeyframeSet.ofObject(values);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:38.407 -0400", hash_original_method = "13DE02BBE5B8605736F61BF53DFAC872", hash_generated_method = "1A4AFD96D9EED5033597480A5DC86087")
    private Method getPropertyFunction(Class targetClass, String prefix, Class valueType) {
        Method varB4EAC82CA7396A68D541C85D26508E83_87597492 = null; //Variable for return #1
        Method varB4EAC82CA7396A68D541C85D26508E83_196857360 = null; //Variable for return #2
        Method returnVal;
        returnVal = null;
        String methodName;
        methodName = getMethodName(prefix, mPropertyName);
        Class args[];
        args = null;
        {
            try 
            {
                returnVal = targetClass.getMethod(methodName, args);
            } //End block
            catch (NoSuchMethodException e)
            { }
        } //End block
        {
            args = new Class[1];
            Class typeVariants[];
            {
                boolean varA19CC413B5D979C40823A0DFD08B5B8B_2115484489 = (mValueType.equals(Float.class));
                {
                    typeVariants = FLOAT_VARIANTS;
                } //End block
                {
                    boolean varD5B60361EAD528E96F229CD21781680B_1863461398 = (mValueType.equals(Integer.class));
                    {
                        typeVariants = INTEGER_VARIANTS;
                    } //End block
                    {
                        boolean var0B542F869A194F37A1EAAC7F79A1D812_378240604 = (mValueType.equals(Double.class));
                        {
                            typeVariants = DOUBLE_VARIANTS;
                        } //End block
                        {
                            typeVariants = new Class[1];
                            typeVariants[0] = mValueType;
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            {
                Class typeVariant = typeVariants[0];
                {
                    args[0] = typeVariant;
                    try 
                    {
                        returnVal = targetClass.getMethod(methodName, args);
                        mValueType = typeVariant;
                        varB4EAC82CA7396A68D541C85D26508E83_87597492 = returnVal;
                    } //End block
                    catch (NoSuchMethodException e)
                    { }
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_196857360 = returnVal;
        addTaint(targetClass.getTaint());
        addTaint(prefix.getTaint());
        addTaint(valueType.getTaint());
        Method varA7E53CE21691AB073D9660D615818899_1445172644; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1445172644 = varB4EAC82CA7396A68D541C85D26508E83_87597492;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1445172644 = varB4EAC82CA7396A68D541C85D26508E83_196857360;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1445172644.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1445172644;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.768 -0400", hash_original_method = "D9982E89760E4BF7FBC2F6FCA80BFE72", hash_generated_method = "17005EF1C1983F5A0E8AA6AD695764F6")
    private Method setupSetterOrGetter(Class targetClass,
            HashMap<Class, HashMap<String, Method>> propertyMapMap,
            String prefix, Class valueType) {
        Method varB4EAC82CA7396A68D541C85D26508E83_1941418102 = null; //Variable for return #1
        Method setterOrGetter = null;
        try 
        {
            mPropertyMapLock.writeLock().lock();
            HashMap<String, Method> propertyMap = propertyMapMap.get(targetClass);
            {
                setterOrGetter = propertyMap.get(mPropertyName);
            } //End block
            {
                setterOrGetter = getPropertyFunction(targetClass, prefix, valueType);
                {
                    propertyMap = new HashMap<String, Method>();
                    propertyMapMap.put(targetClass, propertyMap);
                } //End block
                propertyMap.put(mPropertyName, setterOrGetter);
            } //End block
        } //End block
        finally 
        {
            mPropertyMapLock.writeLock().unlock();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1941418102 = setterOrGetter;
        addTaint(targetClass.getTaint());
        addTaint(propertyMapMap.getTaint());
        addTaint(prefix.getTaint());
        addTaint(valueType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1941418102.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1941418102;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.770 -0400", hash_original_method = "1E4C95A3F0C35809E96A1D77677A320B", hash_generated_method = "57274BDEAD6F4EE1BDEDD294D61925B1")
     void setupSetter(Class targetClass) {
        mSetter = setupSetterOrGetter(targetClass, sSetterPropertyMap, "set", mValueType);
        // ---------- Original Method ----------
        //mSetter = setupSetterOrGetter(targetClass, sSetterPropertyMap, "set", mValueType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.772 -0400", hash_original_method = "8511F8F7AD8858B7DCF32F8ED21ED093", hash_generated_method = "AD073233B0C810F579053BFA42B447EA")
    private void setupGetter(Class targetClass) {
        mGetter = setupSetterOrGetter(targetClass, sGetterPropertyMap, "get", null);
        // ---------- Original Method ----------
        //mGetter = setupSetterOrGetter(targetClass, sGetterPropertyMap, "get", null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.829 -0400", hash_original_method = "0087C9C0C21400747AF8DC614F234C65", hash_generated_method = "BC6917B04B6D0371F13019ED0E1112E1")
     void setupSetterAndGetter(Object target) {
        {
            try 
            {
                Object testValue = mProperty.get(target);
                {
                    Iterator<Keyframe> var30BC71CCD48BB50A1DFF3F1C4E9C9F4A_349156052 = (mKeyframeSet.mKeyframes).iterator();
                    var30BC71CCD48BB50A1DFF3F1C4E9C9F4A_349156052.hasNext();
                    Keyframe kf = var30BC71CCD48BB50A1DFF3F1C4E9C9F4A_349156052.next();
                    {
                        {
                            boolean var4D41CBD03F5F0E056BC0D1CE3112DD7D_1550028995 = (!kf.hasValue());
                            {
                                kf.setValue(mProperty.get(target));
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            catch (ClassCastException e)
            {
                mProperty = null;
            } //End block
        } //End block
        Class targetClass = target.getClass();
        {
            setupSetter(targetClass);
        } //End block
        {
            Iterator<Keyframe> var30BC71CCD48BB50A1DFF3F1C4E9C9F4A_584600520 = (mKeyframeSet.mKeyframes).iterator();
            var30BC71CCD48BB50A1DFF3F1C4E9C9F4A_584600520.hasNext();
            Keyframe kf = var30BC71CCD48BB50A1DFF3F1C4E9C9F4A_584600520.next();
            {
                {
                    boolean var1879ACDF397A2339AF73F7A898CEEF3F_1863201678 = (!kf.hasValue());
                    {
                        {
                            setupGetter(targetClass);
                        } //End block
                        try 
                        {
                            kf.setValue(mGetter.invoke(target));
                        } //End block
                        catch (InvocationTargetException e)
                        { }
                        catch (IllegalAccessException e)
                        { }
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(target.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.831 -0400", hash_original_method = "FD1A4547C57F636637D228B97E0E8D50", hash_generated_method = "D9F01A664430A841C0BCFE3DC9A61472")
    private void setupValue(Object target, Keyframe kf) {
        {
            kf.setValue(mProperty.get(target));
        } //End block
        try 
        {
            {
                Class targetClass = target.getClass();
                setupGetter(targetClass);
            } //End block
            kf.setValue(mGetter.invoke(target));
        } //End block
        catch (InvocationTargetException e)
        { }
        catch (IllegalAccessException e)
        { }
        addTaint(target.getTaint());
        addTaint(kf.getTaint());
        // ---------- Original Method ----------
        //if (mProperty != null) {
            //kf.setValue(mProperty.get(target));
        //}
        //try {
            //if (mGetter == null) {
                //Class targetClass = target.getClass();
                //setupGetter(targetClass);
            //}
            //kf.setValue(mGetter.invoke(target));
        //} catch (InvocationTargetException e) {
            //Log.e("PropertyValuesHolder", e.toString());
        //} catch (IllegalAccessException e) {
            //Log.e("PropertyValuesHolder", e.toString());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.832 -0400", hash_original_method = "981ED4D0B23A22C5ED7F7AF0C37F067E", hash_generated_method = "867D1F50031AB0576FBA2A86061B6B9C")
     void setupStartValue(Object target) {
        setupValue(target, mKeyframeSet.mKeyframes.get(0));
        addTaint(target.getTaint());
        // ---------- Original Method ----------
        //setupValue(target, mKeyframeSet.mKeyframes.get(0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.834 -0400", hash_original_method = "387F5EDF2150EE198B0BBE4A1C97CF48", hash_generated_method = "DD6595A99889F7C988C13F044E8173FB")
     void setupEndValue(Object target) {
        setupValue(target, mKeyframeSet.mKeyframes.get(mKeyframeSet.mKeyframes.size() - 1));
        addTaint(target.getTaint());
        // ---------- Original Method ----------
        //setupValue(target, mKeyframeSet.mKeyframes.get(mKeyframeSet.mKeyframes.size() - 1));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.837 -0400", hash_original_method = "8E6DC562093F236AE410C563F47F28F2", hash_generated_method = "DAD9A40E8F349433249805E376BC088D")
    @Override
    public PropertyValuesHolder clone() {
        PropertyValuesHolder varB4EAC82CA7396A68D541C85D26508E83_1046091219 = null; //Variable for return #1
        PropertyValuesHolder varB4EAC82CA7396A68D541C85D26508E83_1090578265 = null; //Variable for return #2
        try 
        {
            PropertyValuesHolder newPVH = (PropertyValuesHolder) super.clone();
            newPVH.mPropertyName = mPropertyName;
            newPVH.mProperty = mProperty;
            newPVH.mKeyframeSet = mKeyframeSet.clone();
            newPVH.mEvaluator = mEvaluator;
            varB4EAC82CA7396A68D541C85D26508E83_1046091219 = newPVH;
        } //End block
        catch (CloneNotSupportedException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1090578265 = null;
        } //End block
        PropertyValuesHolder varA7E53CE21691AB073D9660D615818899_1524536022; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1524536022 = varB4EAC82CA7396A68D541C85D26508E83_1046091219;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1524536022 = varB4EAC82CA7396A68D541C85D26508E83_1090578265;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1524536022.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1524536022;
        // ---------- Original Method ----------
        //try {
            //PropertyValuesHolder newPVH = (PropertyValuesHolder) super.clone();
            //newPVH.mPropertyName = mPropertyName;
            //newPVH.mProperty = mProperty;
            //newPVH.mKeyframeSet = mKeyframeSet.clone();
            //newPVH.mEvaluator = mEvaluator;
            //return newPVH;
        //} catch (CloneNotSupportedException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.838 -0400", hash_original_method = "BBF3202CC4B8C1713A46E96DE0EE5426", hash_generated_method = "14041544524E55B0F7FAAEF6C0ADEB9E")
     void setAnimatedValue(Object target) {
        {
            mProperty.set(target, getAnimatedValue());
        } //End block
        {
            try 
            {
                mTmpValueArray[0] = getAnimatedValue();
                mSetter.invoke(target, mTmpValueArray);
            } //End block
            catch (InvocationTargetException e)
            { }
            catch (IllegalAccessException e)
            { }
        } //End block
        addTaint(target.getTaint());
        // ---------- Original Method ----------
        //if (mProperty != null) {
            //mProperty.set(target, getAnimatedValue());
        //}
        //if (mSetter != null) {
            //try {
                //mTmpValueArray[0] = getAnimatedValue();
                //mSetter.invoke(target, mTmpValueArray);
            //} catch (InvocationTargetException e) {
                //Log.e("PropertyValuesHolder", e.toString());
            //} catch (IllegalAccessException e) {
                //Log.e("PropertyValuesHolder", e.toString());
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.840 -0400", hash_original_method = "9511AC0B81E584A22A2DBDCB260E6C63", hash_generated_method = "6FB68D7738033F4BC849D6B08F43923F")
     void init() {
        {
            mEvaluator = (mValueType == Integer.class) ? sIntEvaluator :
                    (mValueType == Float.class) ? sFloatEvaluator :
                    null;
        } //End block
        {
            mKeyframeSet.setEvaluator(mEvaluator);
        } //End block
        // ---------- Original Method ----------
        //if (mEvaluator == null) {
            //mEvaluator = (mValueType == Integer.class) ? sIntEvaluator :
                    //(mValueType == Float.class) ? sFloatEvaluator :
                    //null;
        //}
        //if (mEvaluator != null) {
            //mKeyframeSet.setEvaluator(mEvaluator);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.841 -0400", hash_original_method = "8817589F1B40B238224DB9B551F0527E", hash_generated_method = "6E854FEA53C36628363D039E79093E2A")
    public void setEvaluator(TypeEvaluator evaluator) {
        mEvaluator = evaluator;
        mKeyframeSet.setEvaluator(evaluator);
        // ---------- Original Method ----------
        //mEvaluator = evaluator;
        //mKeyframeSet.setEvaluator(evaluator);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.841 -0400", hash_original_method = "3D77B6F49E03B0770D03717F27BECD0E", hash_generated_method = "988B14A5F356427273DDE8DEE23C1F6E")
     void calculateValue(float fraction) {
        mAnimatedValue = mKeyframeSet.getValue(fraction);
        // ---------- Original Method ----------
        //mAnimatedValue = mKeyframeSet.getValue(fraction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.842 -0400", hash_original_method = "748680E3CF42F5BF312929F3A98BA3E4", hash_generated_method = "FF84DEB99D9BF13141DD024987B0DB4E")
    public void setPropertyName(String propertyName) {
        mPropertyName = propertyName;
        // ---------- Original Method ----------
        //mPropertyName = propertyName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.843 -0400", hash_original_method = "8FEFD1E6365C919A12E22D83DCF12A7D", hash_generated_method = "C7C8013F4ECEE98331FB456D99BFC828")
    public void setProperty(Property property) {
        mProperty = property;
        // ---------- Original Method ----------
        //mProperty = property;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.847 -0400", hash_original_method = "53B20749B4CEAC5C134A85897865D0FE", hash_generated_method = "E85C808B5792FA356D8CA289B4BFD34F")
    public String getPropertyName() {
        String varB4EAC82CA7396A68D541C85D26508E83_994990327 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_994990327 = mPropertyName;
        varB4EAC82CA7396A68D541C85D26508E83_994990327.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_994990327;
        // ---------- Original Method ----------
        //return mPropertyName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.849 -0400", hash_original_method = "7EED53883B814F7F8B112CE8FF982C26", hash_generated_method = "CF442C3F8E83FF5DDF62EAB99AAC4987")
     Object getAnimatedValue() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1150295307 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1150295307 = mAnimatedValue;
        varB4EAC82CA7396A68D541C85D26508E83_1150295307.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1150295307;
        // ---------- Original Method ----------
        //return mAnimatedValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.852 -0400", hash_original_method = "BD911D365C7FC80DCCAF5DAD046A5B1C", hash_generated_method = "CA7AFDF7846673EFA2AC1F9322F0DCD9")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_665206067 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_665206067 = mPropertyName + ": " + mKeyframeSet.toString();
        varB4EAC82CA7396A68D541C85D26508E83_665206067.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_665206067;
        // ---------- Original Method ----------
        //return mPropertyName + ": " + mKeyframeSet.toString();
    }

    
    static String getMethodName(String prefix, String propertyName) {
        if (propertyName == null || propertyName.length() == 0) {
            return prefix;
        }
        char firstLetter = Character.toUpperCase(propertyName.charAt(0));
        String theRest = propertyName.substring(1);
        return prefix + firstLetter + theRest;
    }

    
    static private int nGetIntMethod(Class targetClass, String methodName) {
        return DSUtils.UNKNOWN_INT;
    }

    
    static private int nGetFloatMethod(Class targetClass, String methodName) {
        return DSUtils.UNKNOWN_INT;
    }

    
    static private void nCallIntMethod(Object target, int methodID, int arg) {
    }

    
    static private void nCallFloatMethod(Object target, int methodID, float arg) {
    }

    
    static class IntPropertyValuesHolder extends PropertyValuesHolder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.857 -0400", hash_original_field = "1D03D8B3C2FC1C9E51FA22A2A4C67478", hash_generated_field = "231C812A3CFDA881BCF1A1E1FEBCC96E")

        int mJniSetter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.858 -0400", hash_original_field = "F2CA4D1427C3922823BBBDBD76EDBB11", hash_generated_field = "789F496EFC4542E214000BFABCAD154A")

        private IntProperty mIntProperty;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.858 -0400", hash_original_field = "9393500818F5C0586106C06A2F52BBD9", hash_generated_field = "16BE68696FD23E4C9E2C2D0F3A95F693")

        IntKeyframeSet mIntKeyframeSet;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.858 -0400", hash_original_field = "B0684E8FF71F0AF7EF02100CBEEE1611", hash_generated_field = "2C2C363F77070248FB79E89B9069E337")

        int mIntAnimatedValue;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.859 -0400", hash_original_method = "A1404C395B1A556C6EC35453AB25DA4D", hash_generated_method = "79343ECB976D77E231462B6E9D001116")
        public  IntPropertyValuesHolder(String propertyName, IntKeyframeSet keyframeSet) {
            super(propertyName);
            mValueType = int.class;
            mKeyframeSet = keyframeSet;
            mIntKeyframeSet = (IntKeyframeSet) mKeyframeSet;
            addTaint(propertyName.getTaint());
            addTaint(keyframeSet.getTaint());
            // ---------- Original Method ----------
            //mValueType = int.class;
            //mKeyframeSet = keyframeSet;
            //mIntKeyframeSet = (IntKeyframeSet) mKeyframeSet;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.860 -0400", hash_original_method = "81A38376DA5063E7A71924F7865D18EE", hash_generated_method = "6FBE8689CD88A7AC128363C64EE872AA")
        public  IntPropertyValuesHolder(Property property, IntKeyframeSet keyframeSet) {
            super(property);
            mValueType = int.class;
            mKeyframeSet = keyframeSet;
            mIntKeyframeSet = (IntKeyframeSet) mKeyframeSet;
            {
                mIntProperty = (IntProperty) mProperty;
            } //End block
            addTaint(property.getTaint());
            addTaint(keyframeSet.getTaint());
            // ---------- Original Method ----------
            //mValueType = int.class;
            //mKeyframeSet = keyframeSet;
            //mIntKeyframeSet = (IntKeyframeSet) mKeyframeSet;
            //if (property instanceof  IntProperty) {
                //mIntProperty = (IntProperty) mProperty;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.861 -0400", hash_original_method = "D138EB87670EDA5FF4AD9A96EB7F8CD0", hash_generated_method = "3DD20029936AD2BE361CB245A95926AC")
        public  IntPropertyValuesHolder(String propertyName, int... values) {
            super(propertyName);
            setIntValues(values);
            addTaint(propertyName.getTaint());
            addTaint(values[0]);
            // ---------- Original Method ----------
            //setIntValues(values);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.863 -0400", hash_original_method = "EF8A3E59A9590685EEFC24C3E37051A8", hash_generated_method = "65A2E915C0A12F64053967EE3A4FFD91")
        public  IntPropertyValuesHolder(Property property, int... values) {
            super(property);
            setIntValues(values);
            {
                mIntProperty = (IntProperty) mProperty;
            } //End block
            addTaint(property.getTaint());
            addTaint(values[0]);
            // ---------- Original Method ----------
            //setIntValues(values);
            //if (property instanceof  IntProperty) {
                //mIntProperty = (IntProperty) mProperty;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.864 -0400", hash_original_method = "36FED796688BFE2861C8D1DF18289634", hash_generated_method = "15ABF75218379EB6024C02B9A5EDEA50")
        @Override
        public void setIntValues(int... values) {
            super.setIntValues(values);
            mIntKeyframeSet = (IntKeyframeSet) mKeyframeSet;
            addTaint(values[0]);
            // ---------- Original Method ----------
            //super.setIntValues(values);
            //mIntKeyframeSet = (IntKeyframeSet) mKeyframeSet;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.866 -0400", hash_original_method = "30F7306C8A34979730DB91915B461598", hash_generated_method = "46A582808A5314364CD0A0447001C6BD")
        @Override
         void calculateValue(float fraction) {
            mIntAnimatedValue = mIntKeyframeSet.getIntValue(fraction);
            // ---------- Original Method ----------
            //mIntAnimatedValue = mIntKeyframeSet.getIntValue(fraction);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.869 -0400", hash_original_method = "CE13DB8914BA3896479030C59B8EB5EA", hash_generated_method = "649E8EA5366146849FB5056D64836C4B")
        @Override
         Object getAnimatedValue() {
            Object varB4EAC82CA7396A68D541C85D26508E83_1268945121 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1268945121 = mIntAnimatedValue;
            varB4EAC82CA7396A68D541C85D26508E83_1268945121.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1268945121;
            // ---------- Original Method ----------
            //return mIntAnimatedValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.871 -0400", hash_original_method = "D2AD407C7BF3FF5B871B87BBB92EBDD2", hash_generated_method = "4D0BDEAC37783228BA6BB2F1D7E5B993")
        @Override
        public IntPropertyValuesHolder clone() {
            IntPropertyValuesHolder varB4EAC82CA7396A68D541C85D26508E83_485658772 = null; //Variable for return #1
            IntPropertyValuesHolder newPVH = (IntPropertyValuesHolder) super.clone();
            newPVH.mIntKeyframeSet = (IntKeyframeSet) newPVH.mKeyframeSet;
            varB4EAC82CA7396A68D541C85D26508E83_485658772 = newPVH;
            varB4EAC82CA7396A68D541C85D26508E83_485658772.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_485658772;
            // ---------- Original Method ----------
            //IntPropertyValuesHolder newPVH = (IntPropertyValuesHolder) super.clone();
            //newPVH.mIntKeyframeSet = (IntKeyframeSet) newPVH.mKeyframeSet;
            //return newPVH;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.873 -0400", hash_original_method = "774DCA711497C815C6106461263A2AF3", hash_generated_method = "BFA3BC1B53BD9BA86E33A31904B2B43C")
        @Override
         void setAnimatedValue(Object target) {
            {
                mIntProperty.setValue(target, mIntAnimatedValue);
            } //End block
            {
                mProperty.set(target, mIntAnimatedValue);
            } //End block
            {
                nCallIntMethod(target, mJniSetter, mIntAnimatedValue);
            } //End block
            {
                try 
                {
                    mTmpValueArray[0] = mIntAnimatedValue;
                    mSetter.invoke(target, mTmpValueArray);
                } //End block
                catch (InvocationTargetException e)
                { }
                catch (IllegalAccessException e)
                { }
            } //End block
            addTaint(target.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.876 -0400", hash_original_method = "E5FCCB47E07ECB03BE2F278E504281F8", hash_generated_method = "4A6B9459ED6F698E7C57E3F31C93D62D")
        @Override
         void setupSetter(Class targetClass) {
            try 
            {
                mPropertyMapLock.writeLock().lock();
                HashMap<String, Integer> propertyMap = sJNISetterPropertyMap.get(targetClass);
                {
                    Integer mJniSetterInteger = propertyMap.get(mPropertyName);
                    {
                        mJniSetter = mJniSetterInteger;
                    } //End block
                } //End block
                {
                    String methodName = getMethodName("set", mPropertyName);
                    mJniSetter = nGetIntMethod(targetClass, methodName);
                    {
                        {
                            propertyMap = new HashMap<String, Integer>();
                            sJNISetterPropertyMap.put(targetClass, propertyMap);
                        } //End block
                        propertyMap.put(mPropertyName, mJniSetter);
                    } //End block
                } //End block
            } //End block
            catch (NoSuchMethodError e)
            {
                Log.d("PropertyValuesHolder",
                        "Can't find native method using JNI, use reflection" + e);
            } //End block
            finally 
            {
                mPropertyMapLock.writeLock().unlock();
            } //End block
            {
                super.setupSetter(targetClass);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.877 -0400", hash_original_field = "3557D6C5630E32249364C424D4B5912C", hash_generated_field = "47B44650F9265B2FD77E2A3383B8E152")

        private static final HashMap<Class, HashMap<String, Integer>> sJNISetterPropertyMap = new HashMap<Class, HashMap<String, Integer>>();
    }


    
    static class FloatPropertyValuesHolder extends PropertyValuesHolder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.877 -0400", hash_original_field = "1D03D8B3C2FC1C9E51FA22A2A4C67478", hash_generated_field = "231C812A3CFDA881BCF1A1E1FEBCC96E")

        int mJniSetter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.878 -0400", hash_original_field = "A9FFA5F0B217D5C92DAC4D0CA7B51B16", hash_generated_field = "CC72C56A48E7B9C7E56C889DE4F33E11")

        private FloatProperty mFloatProperty;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.878 -0400", hash_original_field = "E0E765CEEB5252BEC7C45ABA4D0174F9", hash_generated_field = "23FE3970B948CA0567BB21122CB48811")

        FloatKeyframeSet mFloatKeyframeSet;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.878 -0400", hash_original_field = "00AB0073C143477CD902DA8D79D657A7", hash_generated_field = "4734C624F522D63647CA34AA79C8C9AC")

        float mFloatAnimatedValue;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.879 -0400", hash_original_method = "5C9EF6457927B43859688413E4C7829F", hash_generated_method = "DD4526685218C6E938C003E9BA9A629B")
        public  FloatPropertyValuesHolder(String propertyName, FloatKeyframeSet keyframeSet) {
            super(propertyName);
            mValueType = float.class;
            mKeyframeSet = keyframeSet;
            mFloatKeyframeSet = (FloatKeyframeSet) mKeyframeSet;
            addTaint(propertyName.getTaint());
            addTaint(keyframeSet.getTaint());
            // ---------- Original Method ----------
            //mValueType = float.class;
            //mKeyframeSet = keyframeSet;
            //mFloatKeyframeSet = (FloatKeyframeSet) mKeyframeSet;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.880 -0400", hash_original_method = "3ECDE802415F2017B0BC69F95B30B753", hash_generated_method = "84D0B4658F58C2634914648D0EC8E9B0")
        public  FloatPropertyValuesHolder(Property property, FloatKeyframeSet keyframeSet) {
            super(property);
            mValueType = float.class;
            mKeyframeSet = keyframeSet;
            mFloatKeyframeSet = (FloatKeyframeSet) mKeyframeSet;
            {
                mFloatProperty = (FloatProperty) mProperty;
            } //End block
            addTaint(property.getTaint());
            addTaint(keyframeSet.getTaint());
            // ---------- Original Method ----------
            //mValueType = float.class;
            //mKeyframeSet = keyframeSet;
            //mFloatKeyframeSet = (FloatKeyframeSet) mKeyframeSet;
            //if (property instanceof FloatProperty) {
                //mFloatProperty = (FloatProperty) mProperty;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.881 -0400", hash_original_method = "C77EAEA380E6CBE61D90EF78014D158B", hash_generated_method = "9E0999F9960257834D9B3CE37645F957")
        public  FloatPropertyValuesHolder(String propertyName, float... values) {
            super(propertyName);
            setFloatValues(values);
            addTaint(propertyName.getTaint());
            addTaint(values[0]);
            // ---------- Original Method ----------
            //setFloatValues(values);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.882 -0400", hash_original_method = "91C83497360B006516EF522F9EB49209", hash_generated_method = "AF32CCC600819A3FB0610B09E52BE2FC")
        public  FloatPropertyValuesHolder(Property property, float... values) {
            super(property);
            setFloatValues(values);
            {
                mFloatProperty = (FloatProperty) mProperty;
            } //End block
            addTaint(property.getTaint());
            addTaint(values[0]);
            // ---------- Original Method ----------
            //setFloatValues(values);
            //if (property instanceof  FloatProperty) {
                //mFloatProperty = (FloatProperty) mProperty;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.883 -0400", hash_original_method = "4C7839391C0E614BE090BEA208DAADC2", hash_generated_method = "B5561BD3C3C1617EA91F5A8EE04027C6")
        @Override
        public void setFloatValues(float... values) {
            super.setFloatValues(values);
            mFloatKeyframeSet = (FloatKeyframeSet) mKeyframeSet;
            addTaint(values[0]);
            // ---------- Original Method ----------
            //super.setFloatValues(values);
            //mFloatKeyframeSet = (FloatKeyframeSet) mKeyframeSet;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.884 -0400", hash_original_method = "EBADBBF750EE6D7005FAC08DD166E4F4", hash_generated_method = "E685B94C8F911CB6E2E055829FA0FF32")
        @Override
         void calculateValue(float fraction) {
            mFloatAnimatedValue = mFloatKeyframeSet.getFloatValue(fraction);
            // ---------- Original Method ----------
            //mFloatAnimatedValue = mFloatKeyframeSet.getFloatValue(fraction);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.886 -0400", hash_original_method = "56F77D961BC82461152CD24C144983C0", hash_generated_method = "E1155EDC7327C7E48D21FDEA7C3A6E2A")
        @Override
         Object getAnimatedValue() {
            Object varB4EAC82CA7396A68D541C85D26508E83_1208508870 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1208508870 = mFloatAnimatedValue;
            varB4EAC82CA7396A68D541C85D26508E83_1208508870.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1208508870;
            // ---------- Original Method ----------
            //return mFloatAnimatedValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.889 -0400", hash_original_method = "3798C3AECEA696DCFE0B333FF00EF37C", hash_generated_method = "0A15FBF4FE25A8971FD825C5B898D443")
        @Override
        public FloatPropertyValuesHolder clone() {
            FloatPropertyValuesHolder varB4EAC82CA7396A68D541C85D26508E83_1708112015 = null; //Variable for return #1
            FloatPropertyValuesHolder newPVH = (FloatPropertyValuesHolder) super.clone();
            newPVH.mFloatKeyframeSet = (FloatKeyframeSet) newPVH.mKeyframeSet;
            varB4EAC82CA7396A68D541C85D26508E83_1708112015 = newPVH;
            varB4EAC82CA7396A68D541C85D26508E83_1708112015.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1708112015;
            // ---------- Original Method ----------
            //FloatPropertyValuesHolder newPVH = (FloatPropertyValuesHolder) super.clone();
            //newPVH.mFloatKeyframeSet = (FloatKeyframeSet) newPVH.mKeyframeSet;
            //return newPVH;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.891 -0400", hash_original_method = "727C6F3DB059985E066E102AF679E2D9", hash_generated_method = "7C2B2E68E9BE79A5A33C0D4E4A9CBB80")
        @Override
         void setAnimatedValue(Object target) {
            {
                mFloatProperty.setValue(target, mFloatAnimatedValue);
            } //End block
            {
                mProperty.set(target, mFloatAnimatedValue);
            } //End block
            {
                nCallFloatMethod(target, mJniSetter, mFloatAnimatedValue);
            } //End block
            {
                try 
                {
                    mTmpValueArray[0] = mFloatAnimatedValue;
                    mSetter.invoke(target, mTmpValueArray);
                } //End block
                catch (InvocationTargetException e)
                { }
                catch (IllegalAccessException e)
                { }
            } //End block
            addTaint(target.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.893 -0400", hash_original_method = "2E99CF7209AB7743339028E8A9433227", hash_generated_method = "606AFC71AFB39FF33BA259EE11AB64CA")
        @Override
         void setupSetter(Class targetClass) {
            try 
            {
                mPropertyMapLock.writeLock().lock();
                HashMap<String, Integer> propertyMap = sJNISetterPropertyMap.get(targetClass);
                {
                    Integer mJniSetterInteger = propertyMap.get(mPropertyName);
                    {
                        mJniSetter = mJniSetterInteger;
                    } //End block
                } //End block
                {
                    String methodName = getMethodName("set", mPropertyName);
                    mJniSetter = nGetFloatMethod(targetClass, methodName);
                    {
                        {
                            propertyMap = new HashMap<String, Integer>();
                            sJNISetterPropertyMap.put(targetClass, propertyMap);
                        } //End block
                        propertyMap.put(mPropertyName, mJniSetter);
                    } //End block
                } //End block
            } //End block
            catch (NoSuchMethodError e)
            {
                Log.d("PropertyValuesHolder",
                        "Can't find native method using JNI, use reflection" + e);
            } //End block
            finally 
            {
                mPropertyMapLock.writeLock().unlock();
            } //End block
            {
                super.setupSetter(targetClass);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.893 -0400", hash_original_field = "3557D6C5630E32249364C424D4B5912C", hash_generated_field = "47B44650F9265B2FD77E2A3383B8E152")

        private static final HashMap<Class, HashMap<String, Integer>> sJNISetterPropertyMap = new HashMap<Class, HashMap<String, Integer>>();
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.894 -0400", hash_original_field = "524C52C0A1E88CDA180A0F7AA6118606", hash_generated_field = "7E9EFDBC560251144B1ABA6A3E58FAA3")

    private static final TypeEvaluator sIntEvaluator = new IntEvaluator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.894 -0400", hash_original_field = "15DEFED28FFB599464BB68C200695E4F", hash_generated_field = "81564E463CF700876869857891E00106")

    private static final TypeEvaluator sFloatEvaluator = new FloatEvaluator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.894 -0400", hash_original_field = "5020662D31A4B6283E1907ADCCEB4874", hash_generated_field = "07148BED043B90DA742996E111F16340")

    private static Class[] FLOAT_VARIANTS = {float.class, Float.class, double.class, int.class,
            Double.class, Integer.class};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.895 -0400", hash_original_field = "9C4E25A2E91D75D9D3EE0570B712EB32", hash_generated_field = "2AB15B1F0AA6A5F55EE330ABD82CD53C")

    private static Class[] INTEGER_VARIANTS = {int.class, Integer.class, float.class, double.class,
            Float.class, Double.class};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.895 -0400", hash_original_field = "B1F33CAD2A359720FA9A32D35A347DF1", hash_generated_field = "1C78BAF1D2C06E74F6CAF6919DCF921C")

    private static Class[] DOUBLE_VARIANTS = {double.class, Double.class, float.class, int.class,
            Float.class, Integer.class};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.895 -0400", hash_original_field = "8C96BADD97EAAC3C551B0848BE293B12", hash_generated_field = "B79DE0A5696D74AB905E382C94DB8E44")

    private static final HashMap<Class, HashMap<String, Method>> sSetterPropertyMap = new HashMap<Class, HashMap<String, Method>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.895 -0400", hash_original_field = "F56CDACEEA95F1D6646404DB17E451C2", hash_generated_field = "C2AD3EF1A9BABE0B350993A7EE00B799")

    private static final HashMap<Class, HashMap<String, Method>> sGetterPropertyMap = new HashMap<Class, HashMap<String, Method>>();
}

