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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.191 -0400", hash_original_field = "AFC1281EACDFDDEC758551A3AAE3876C", hash_generated_field = "3E0E605326E1698CDE7903701811F2C0")

    String mPropertyName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.192 -0400", hash_original_field = "3BE74FBBD7FF163511D9CBD518CBA4A5", hash_generated_field = "E251A73627C8A3AA16F08ACAF8645F40")

    protected Property mProperty;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.212 -0400", hash_original_field = "D97BFD6711E9CC57FA5DB2FD2F8DE87B", hash_generated_field = "848F529A6ABC40F993A3D418131EC7A7")

    Method mSetter = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.213 -0400", hash_original_field = "8CE425F19DFD100C313BF3389D2C121A", hash_generated_field = "E1F4E67E7973C49A4B9CE526E6FC6D89")

    private Method mGetter = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.214 -0400", hash_original_field = "98DE3BF49406C5ACB6938D9BD7C43E69", hash_generated_field = "28819529602B8605503B4054C761CC6C")

    Class mValueType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.215 -0400", hash_original_field = "4849D8B4AB6A0FE1F7B81C0C07A14B0B", hash_generated_field = "C6973E4C17AF76FE86969D85049286F9")

    KeyframeSet mKeyframeSet = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.232 -0400", hash_original_field = "FD615E1C9081D8D57987D5321893DFF1", hash_generated_field = "E057CF75DFC846BF3FB1F41806B52A19")

    ReentrantReadWriteLock mPropertyMapLock = new ReentrantReadWriteLock();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.234 -0400", hash_original_field = "90FCE5F7BA7EF0DAA4E972BE07405AE2", hash_generated_field = "B1B01E8F86EEB9C319C134B378D8BBDD")

    Object[] mTmpValueArray = new Object[1];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.235 -0400", hash_original_field = "A5A16062C8CFDCD2D78B97324D59FBBD", hash_generated_field = "49D878C6212418A96C46E0217176C94E")

    private TypeEvaluator mEvaluator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.242 -0400", hash_original_field = "3A611FC8D0DF942B3AE2A62063E4425B", hash_generated_field = "B2B6DB149B87CF34CE07060A7A505841")

    private Object mAnimatedValue;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.258 -0400", hash_original_method = "73C53AD6C55F8F35D3899F0ADDC03638", hash_generated_method = "173B3BF84BCAAD759EC1E53526977EB5")
    private  PropertyValuesHolder(String propertyName) {
        mPropertyName = propertyName;
        // ---------- Original Method ----------
        //mPropertyName = propertyName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.287 -0400", hash_original_method = "BDE609B5B8790707A2E7C7F2E71E73EE", hash_generated_method = "5DE9995FB67BDB2A36117192638C1042")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.369 -0400", hash_original_method = "5ACB1BF4CE1DE924456A446D3AE6F5AC", hash_generated_method = "F988F397E0C59F23B11B46996200454C")
    public void setIntValues(int... values) {
        mValueType = int.class;
        mKeyframeSet = KeyframeSet.ofInt(values);
        // ---------- Original Method ----------
        //mValueType = int.class;
        //mKeyframeSet = KeyframeSet.ofInt(values);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.411 -0400", hash_original_method = "E55475A51A76C9AF68CEE5048B067603", hash_generated_method = "9308781A147C7C8F6EE137B61C15BCBE")
    public void setFloatValues(float... values) {
        mValueType = float.class;
        mKeyframeSet = KeyframeSet.ofFloat(values);
        // ---------- Original Method ----------
        //mValueType = float.class;
        //mKeyframeSet = KeyframeSet.ofFloat(values);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.450 -0400", hash_original_method = "A7BBAF2A9B12EBB30CB57DBA83B6B7FC", hash_generated_method = "D02E18B44CDCC216E26384D8B9131D6A")
    public void setKeyframes(Keyframe... values) {
        int numKeyframes;
        numKeyframes = values.length;
        Keyframe keyframes[];
        keyframes = new Keyframe[Math.max(numKeyframes,2)];
        mValueType = ((Keyframe)values[0]).getType();
        {
            int i;
            i = 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:51.472 -0400", hash_original_method = "8EF0800B602558BC1B6F05E6446D461B", hash_generated_method = "009C87DF8D68A19F0FC02389A7898792")
    public void setObjectValues(Object... values) {
        mValueType = values[0].getClass();
        mKeyframeSet = KeyframeSet.ofObject(values);
        // ---------- Original Method ----------
        //mValueType = values[0].getClass();
        //mKeyframeSet = KeyframeSet.ofObject(values);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.597 -0400", hash_original_method = "13DE02BBE5B8605736F61BF53DFAC872", hash_generated_method = "939759900F19E15AB1A919B96E48DF5C")
    private Method getPropertyFunction(Class targetClass, String prefix, Class valueType) {
        Method varB4EAC82CA7396A68D541C85D26508E83_816349025 = null; //Variable for return #1
        Method varB4EAC82CA7396A68D541C85D26508E83_1096970333 = null; //Variable for return #2
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
                boolean varA19CC413B5D979C40823A0DFD08B5B8B_1731897155 = (mValueType.equals(Float.class));
                {
                    typeVariants = FLOAT_VARIANTS;
                } //End block
                {
                    boolean varD5B60361EAD528E96F229CD21781680B_431019493 = (mValueType.equals(Integer.class));
                    {
                        typeVariants = INTEGER_VARIANTS;
                    } //End block
                    {
                        boolean var0B542F869A194F37A1EAAC7F79A1D812_585878084 = (mValueType.equals(Double.class));
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
                        varB4EAC82CA7396A68D541C85D26508E83_816349025 = returnVal;
                    } //End block
                    catch (NoSuchMethodException e)
                    { }
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1096970333 = returnVal;
        addTaint(targetClass.getTaint());
        addTaint(prefix.getTaint());
        addTaint(valueType.getTaint());
        Method varA7E53CE21691AB073D9660D615818899_436370980; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_436370980 = varB4EAC82CA7396A68D541C85D26508E83_816349025;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_436370980 = varB4EAC82CA7396A68D541C85D26508E83_1096970333;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_436370980.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_436370980;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.611 -0400", hash_original_method = "D9982E89760E4BF7FBC2F6FCA80BFE72", hash_generated_method = "850CCD193EBA8C15587657C27FA9FC22")
    private Method setupSetterOrGetter(Class targetClass,
            HashMap<Class, HashMap<String, Method>> propertyMapMap,
            String prefix, Class valueType) {
        Method varB4EAC82CA7396A68D541C85D26508E83_592362940 = null; //Variable for return #1
        Method setterOrGetter;
        setterOrGetter = null;
        try 
        {
            mPropertyMapLock.writeLock().lock();
            HashMap<String, Method> propertyMap;
            propertyMap = propertyMapMap.get(targetClass);
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
        varB4EAC82CA7396A68D541C85D26508E83_592362940 = setterOrGetter;
        addTaint(targetClass.getTaint());
        addTaint(propertyMapMap.getTaint());
        addTaint(prefix.getTaint());
        addTaint(valueType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_592362940.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_592362940;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.631 -0400", hash_original_method = "1E4C95A3F0C35809E96A1D77677A320B", hash_generated_method = "57274BDEAD6F4EE1BDEDD294D61925B1")
     void setupSetter(Class targetClass) {
        mSetter = setupSetterOrGetter(targetClass, sSetterPropertyMap, "set", mValueType);
        // ---------- Original Method ----------
        //mSetter = setupSetterOrGetter(targetClass, sSetterPropertyMap, "set", mValueType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.639 -0400", hash_original_method = "8511F8F7AD8858B7DCF32F8ED21ED093", hash_generated_method = "AD073233B0C810F579053BFA42B447EA")
    private void setupGetter(Class targetClass) {
        mGetter = setupSetterOrGetter(targetClass, sGetterPropertyMap, "get", null);
        // ---------- Original Method ----------
        //mGetter = setupSetterOrGetter(targetClass, sGetterPropertyMap, "get", null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.484 -0400", hash_original_method = "0087C9C0C21400747AF8DC614F234C65", hash_generated_method = "6BEC2BA55283642BCFCC672CA3F08509")
     void setupSetterAndGetter(Object target) {
        {
            try 
            {
                Object testValue;
                testValue = mProperty.get(target);
                {
                    Iterator<Keyframe> var30BC71CCD48BB50A1DFF3F1C4E9C9F4A_294141663 = (mKeyframeSet.mKeyframes).iterator();
                    var30BC71CCD48BB50A1DFF3F1C4E9C9F4A_294141663.hasNext();
                    Keyframe kf = var30BC71CCD48BB50A1DFF3F1C4E9C9F4A_294141663.next();
                    {
                        {
                            boolean var4D41CBD03F5F0E056BC0D1CE3112DD7D_1187209173 = (!kf.hasValue());
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
        Class targetClass;
        targetClass = target.getClass();
        {
            setupSetter(targetClass);
        } //End block
        {
            Iterator<Keyframe> var30BC71CCD48BB50A1DFF3F1C4E9C9F4A_741012343 = (mKeyframeSet.mKeyframes).iterator();
            var30BC71CCD48BB50A1DFF3F1C4E9C9F4A_741012343.hasNext();
            Keyframe kf = var30BC71CCD48BB50A1DFF3F1C4E9C9F4A_741012343.next();
            {
                {
                    boolean var1879ACDF397A2339AF73F7A898CEEF3F_1669154184 = (!kf.hasValue());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.502 -0400", hash_original_method = "FD1A4547C57F636637D228B97E0E8D50", hash_generated_method = "2A17C520E70C6F523F70FBD297D31D75")
    private void setupValue(Object target, Keyframe kf) {
        {
            kf.setValue(mProperty.get(target));
        } //End block
        try 
        {
            {
                Class targetClass;
                targetClass = target.getClass();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.515 -0400", hash_original_method = "981ED4D0B23A22C5ED7F7AF0C37F067E", hash_generated_method = "867D1F50031AB0576FBA2A86061B6B9C")
     void setupStartValue(Object target) {
        setupValue(target, mKeyframeSet.mKeyframes.get(0));
        addTaint(target.getTaint());
        // ---------- Original Method ----------
        //setupValue(target, mKeyframeSet.mKeyframes.get(0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.517 -0400", hash_original_method = "387F5EDF2150EE198B0BBE4A1C97CF48", hash_generated_method = "DD6595A99889F7C988C13F044E8173FB")
     void setupEndValue(Object target) {
        setupValue(target, mKeyframeSet.mKeyframes.get(mKeyframeSet.mKeyframes.size() - 1));
        addTaint(target.getTaint());
        // ---------- Original Method ----------
        //setupValue(target, mKeyframeSet.mKeyframes.get(mKeyframeSet.mKeyframes.size() - 1));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.540 -0400", hash_original_method = "8E6DC562093F236AE410C563F47F28F2", hash_generated_method = "83F70FF6EA23301A001E1EAF86D8CAF3")
    @Override
    public PropertyValuesHolder clone() {
        PropertyValuesHolder varB4EAC82CA7396A68D541C85D26508E83_1116715146 = null; //Variable for return #1
        PropertyValuesHolder varB4EAC82CA7396A68D541C85D26508E83_1010325450 = null; //Variable for return #2
        try 
        {
            PropertyValuesHolder newPVH;
            newPVH = (PropertyValuesHolder) super.clone();
            newPVH.mPropertyName = mPropertyName;
            newPVH.mProperty = mProperty;
            newPVH.mKeyframeSet = mKeyframeSet.clone();
            newPVH.mEvaluator = mEvaluator;
            varB4EAC82CA7396A68D541C85D26508E83_1116715146 = newPVH;
        } //End block
        catch (CloneNotSupportedException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1010325450 = null;
        } //End block
        PropertyValuesHolder varA7E53CE21691AB073D9660D615818899_64500701; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_64500701 = varB4EAC82CA7396A68D541C85D26508E83_1116715146;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_64500701 = varB4EAC82CA7396A68D541C85D26508E83_1010325450;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_64500701.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_64500701;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.543 -0400", hash_original_method = "BBF3202CC4B8C1713A46E96DE0EE5426", hash_generated_method = "14041544524E55B0F7FAAEF6C0ADEB9E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.575 -0400", hash_original_method = "9511AC0B81E584A22A2DBDCB260E6C63", hash_generated_method = "6FB68D7738033F4BC849D6B08F43923F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.587 -0400", hash_original_method = "8817589F1B40B238224DB9B551F0527E", hash_generated_method = "6E854FEA53C36628363D039E79093E2A")
    public void setEvaluator(TypeEvaluator evaluator) {
        mEvaluator = evaluator;
        mKeyframeSet.setEvaluator(evaluator);
        // ---------- Original Method ----------
        //mEvaluator = evaluator;
        //mKeyframeSet.setEvaluator(evaluator);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.589 -0400", hash_original_method = "3D77B6F49E03B0770D03717F27BECD0E", hash_generated_method = "988B14A5F356427273DDE8DEE23C1F6E")
     void calculateValue(float fraction) {
        mAnimatedValue = mKeyframeSet.getValue(fraction);
        // ---------- Original Method ----------
        //mAnimatedValue = mKeyframeSet.getValue(fraction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.604 -0400", hash_original_method = "748680E3CF42F5BF312929F3A98BA3E4", hash_generated_method = "FF84DEB99D9BF13141DD024987B0DB4E")
    public void setPropertyName(String propertyName) {
        mPropertyName = propertyName;
        // ---------- Original Method ----------
        //mPropertyName = propertyName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.607 -0400", hash_original_method = "8FEFD1E6365C919A12E22D83DCF12A7D", hash_generated_method = "C7C8013F4ECEE98331FB456D99BFC828")
    public void setProperty(Property property) {
        mProperty = property;
        // ---------- Original Method ----------
        //mProperty = property;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.627 -0400", hash_original_method = "53B20749B4CEAC5C134A85897865D0FE", hash_generated_method = "4A6730A8A843098274114F94ABC16E18")
    public String getPropertyName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1200724724 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1200724724 = mPropertyName;
        varB4EAC82CA7396A68D541C85D26508E83_1200724724.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1200724724;
        // ---------- Original Method ----------
        //return mPropertyName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.649 -0400", hash_original_method = "7EED53883B814F7F8B112CE8FF982C26", hash_generated_method = "08E7F24F0166FFEA5983975CACAA5465")
     Object getAnimatedValue() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1708915399 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1708915399 = mAnimatedValue;
        varB4EAC82CA7396A68D541C85D26508E83_1708915399.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1708915399;
        // ---------- Original Method ----------
        //return mAnimatedValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.659 -0400", hash_original_method = "BD911D365C7FC80DCCAF5DAD046A5B1C", hash_generated_method = "77815D16271F1DA36FBC43E6F820F6BE")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1615441220 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1615441220 = mPropertyName + ": " + mKeyframeSet.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1615441220.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1615441220;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.685 -0400", hash_original_field = "1D03D8B3C2FC1C9E51FA22A2A4C67478", hash_generated_field = "231C812A3CFDA881BCF1A1E1FEBCC96E")

        int mJniSetter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.686 -0400", hash_original_field = "F2CA4D1427C3922823BBBDBD76EDBB11", hash_generated_field = "789F496EFC4542E214000BFABCAD154A")

        private IntProperty mIntProperty;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.687 -0400", hash_original_field = "9393500818F5C0586106C06A2F52BBD9", hash_generated_field = "16BE68696FD23E4C9E2C2D0F3A95F693")

        IntKeyframeSet mIntKeyframeSet;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.687 -0400", hash_original_field = "B0684E8FF71F0AF7EF02100CBEEE1611", hash_generated_field = "2C2C363F77070248FB79E89B9069E337")

        int mIntAnimatedValue;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.705 -0400", hash_original_method = "A1404C395B1A556C6EC35453AB25DA4D", hash_generated_method = "79343ECB976D77E231462B6E9D001116")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.708 -0400", hash_original_method = "81A38376DA5063E7A71924F7865D18EE", hash_generated_method = "6FBE8689CD88A7AC128363C64EE872AA")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.732 -0400", hash_original_method = "D138EB87670EDA5FF4AD9A96EB7F8CD0", hash_generated_method = "3DD20029936AD2BE361CB245A95926AC")
        public  IntPropertyValuesHolder(String propertyName, int... values) {
            super(propertyName);
            setIntValues(values);
            addTaint(propertyName.getTaint());
            addTaint(values[0]);
            // ---------- Original Method ----------
            //setIntValues(values);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.736 -0400", hash_original_method = "EF8A3E59A9590685EEFC24C3E37051A8", hash_generated_method = "65A2E915C0A12F64053967EE3A4FFD91")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.739 -0400", hash_original_method = "36FED796688BFE2861C8D1DF18289634", hash_generated_method = "15ABF75218379EB6024C02B9A5EDEA50")
        @Override
        public void setIntValues(int... values) {
            super.setIntValues(values);
            mIntKeyframeSet = (IntKeyframeSet) mKeyframeSet;
            addTaint(values[0]);
            // ---------- Original Method ----------
            //super.setIntValues(values);
            //mIntKeyframeSet = (IntKeyframeSet) mKeyframeSet;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.763 -0400", hash_original_method = "30F7306C8A34979730DB91915B461598", hash_generated_method = "46A582808A5314364CD0A0447001C6BD")
        @Override
         void calculateValue(float fraction) {
            mIntAnimatedValue = mIntKeyframeSet.getIntValue(fraction);
            // ---------- Original Method ----------
            //mIntAnimatedValue = mIntKeyframeSet.getIntValue(fraction);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.779 -0400", hash_original_method = "CE13DB8914BA3896479030C59B8EB5EA", hash_generated_method = "50BC7A84E31053704549AFE5C44DFF9F")
        @Override
         Object getAnimatedValue() {
            Object varB4EAC82CA7396A68D541C85D26508E83_968163367 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_968163367 = mIntAnimatedValue;
            varB4EAC82CA7396A68D541C85D26508E83_968163367.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_968163367;
            // ---------- Original Method ----------
            //return mIntAnimatedValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.796 -0400", hash_original_method = "D2AD407C7BF3FF5B871B87BBB92EBDD2", hash_generated_method = "632C10D8083AD568A53AE19A7E448DAF")
        @Override
        public IntPropertyValuesHolder clone() {
            IntPropertyValuesHolder varB4EAC82CA7396A68D541C85D26508E83_708823205 = null; //Variable for return #1
            IntPropertyValuesHolder newPVH;
            newPVH = (IntPropertyValuesHolder) super.clone();
            newPVH.mIntKeyframeSet = (IntKeyframeSet) newPVH.mKeyframeSet;
            varB4EAC82CA7396A68D541C85D26508E83_708823205 = newPVH;
            varB4EAC82CA7396A68D541C85D26508E83_708823205.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_708823205;
            // ---------- Original Method ----------
            //IntPropertyValuesHolder newPVH = (IntPropertyValuesHolder) super.clone();
            //newPVH.mIntKeyframeSet = (IntKeyframeSet) newPVH.mKeyframeSet;
            //return newPVH;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.802 -0400", hash_original_method = "774DCA711497C815C6106461263A2AF3", hash_generated_method = "BFA3BC1B53BD9BA86E33A31904B2B43C")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.834 -0400", hash_original_method = "E5FCCB47E07ECB03BE2F278E504281F8", hash_generated_method = "DF1E4FC608A920DEB21BD06C09162AF8")
        @Override
         void setupSetter(Class targetClass) {
            try 
            {
                mPropertyMapLock.writeLock().lock();
                HashMap<String, Integer> propertyMap;
                propertyMap = sJNISetterPropertyMap.get(targetClass);
                {
                    Integer mJniSetterInteger;
                    mJniSetterInteger = propertyMap.get(mPropertyName);
                    {
                        mJniSetter = mJniSetterInteger;
                    } //End block
                } //End block
                {
                    String methodName;
                    methodName = getMethodName("set", mPropertyName);
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.841 -0400", hash_original_field = "3557D6C5630E32249364C424D4B5912C", hash_generated_field = "E33CDD551E146F107F5D8536DEF61423")

        private static HashMap<Class, HashMap<String, Integer>> sJNISetterPropertyMap = new HashMap<Class, HashMap<String, Integer>>();
    }


    
    static class FloatPropertyValuesHolder extends PropertyValuesHolder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.842 -0400", hash_original_field = "1D03D8B3C2FC1C9E51FA22A2A4C67478", hash_generated_field = "231C812A3CFDA881BCF1A1E1FEBCC96E")

        int mJniSetter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.843 -0400", hash_original_field = "A9FFA5F0B217D5C92DAC4D0CA7B51B16", hash_generated_field = "CC72C56A48E7B9C7E56C889DE4F33E11")

        private FloatProperty mFloatProperty;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.855 -0400", hash_original_field = "E0E765CEEB5252BEC7C45ABA4D0174F9", hash_generated_field = "23FE3970B948CA0567BB21122CB48811")

        FloatKeyframeSet mFloatKeyframeSet;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.856 -0400", hash_original_field = "00AB0073C143477CD902DA8D79D657A7", hash_generated_field = "4734C624F522D63647CA34AA79C8C9AC")

        float mFloatAnimatedValue;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.857 -0400", hash_original_method = "5C9EF6457927B43859688413E4C7829F", hash_generated_method = "DD4526685218C6E938C003E9BA9A629B")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.879 -0400", hash_original_method = "3ECDE802415F2017B0BC69F95B30B753", hash_generated_method = "84D0B4658F58C2634914648D0EC8E9B0")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.894 -0400", hash_original_method = "C77EAEA380E6CBE61D90EF78014D158B", hash_generated_method = "9E0999F9960257834D9B3CE37645F957")
        public  FloatPropertyValuesHolder(String propertyName, float... values) {
            super(propertyName);
            setFloatValues(values);
            addTaint(propertyName.getTaint());
            addTaint(values[0]);
            // ---------- Original Method ----------
            //setFloatValues(values);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.904 -0400", hash_original_method = "91C83497360B006516EF522F9EB49209", hash_generated_method = "AF32CCC600819A3FB0610B09E52BE2FC")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.926 -0400", hash_original_method = "4C7839391C0E614BE090BEA208DAADC2", hash_generated_method = "B5561BD3C3C1617EA91F5A8EE04027C6")
        @Override
        public void setFloatValues(float... values) {
            super.setFloatValues(values);
            mFloatKeyframeSet = (FloatKeyframeSet) mKeyframeSet;
            addTaint(values[0]);
            // ---------- Original Method ----------
            //super.setFloatValues(values);
            //mFloatKeyframeSet = (FloatKeyframeSet) mKeyframeSet;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.928 -0400", hash_original_method = "EBADBBF750EE6D7005FAC08DD166E4F4", hash_generated_method = "E685B94C8F911CB6E2E055829FA0FF32")
        @Override
         void calculateValue(float fraction) {
            mFloatAnimatedValue = mFloatKeyframeSet.getFloatValue(fraction);
            // ---------- Original Method ----------
            //mFloatAnimatedValue = mFloatKeyframeSet.getFloatValue(fraction);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.943 -0400", hash_original_method = "56F77D961BC82461152CD24C144983C0", hash_generated_method = "5BB62E449AC8CDDD86D508EA92E70ABA")
        @Override
         Object getAnimatedValue() {
            Object varB4EAC82CA7396A68D541C85D26508E83_80346636 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_80346636 = mFloatAnimatedValue;
            varB4EAC82CA7396A68D541C85D26508E83_80346636.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_80346636;
            // ---------- Original Method ----------
            //return mFloatAnimatedValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.954 -0400", hash_original_method = "3798C3AECEA696DCFE0B333FF00EF37C", hash_generated_method = "355B9C95F3B12722077E8841788E8B45")
        @Override
        public FloatPropertyValuesHolder clone() {
            FloatPropertyValuesHolder varB4EAC82CA7396A68D541C85D26508E83_658095816 = null; //Variable for return #1
            FloatPropertyValuesHolder newPVH;
            newPVH = (FloatPropertyValuesHolder) super.clone();
            newPVH.mFloatKeyframeSet = (FloatKeyframeSet) newPVH.mKeyframeSet;
            varB4EAC82CA7396A68D541C85D26508E83_658095816 = newPVH;
            varB4EAC82CA7396A68D541C85D26508E83_658095816.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_658095816;
            // ---------- Original Method ----------
            //FloatPropertyValuesHolder newPVH = (FloatPropertyValuesHolder) super.clone();
            //newPVH.mFloatKeyframeSet = (FloatKeyframeSet) newPVH.mKeyframeSet;
            //return newPVH;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.978 -0400", hash_original_method = "727C6F3DB059985E066E102AF679E2D9", hash_generated_method = "7C2B2E68E9BE79A5A33C0D4E4A9CBB80")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.017 -0400", hash_original_method = "2E99CF7209AB7743339028E8A9433227", hash_generated_method = "8C0E1410633F2A27BE78AC714D9C2379")
        @Override
         void setupSetter(Class targetClass) {
            try 
            {
                mPropertyMapLock.writeLock().lock();
                HashMap<String, Integer> propertyMap;
                propertyMap = sJNISetterPropertyMap.get(targetClass);
                {
                    Integer mJniSetterInteger;
                    mJniSetterInteger = propertyMap.get(mPropertyName);
                    {
                        mJniSetter = mJniSetterInteger;
                    } //End block
                } //End block
                {
                    String methodName;
                    methodName = getMethodName("set", mPropertyName);
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.018 -0400", hash_original_field = "3557D6C5630E32249364C424D4B5912C", hash_generated_field = "E33CDD551E146F107F5D8536DEF61423")

        private static HashMap<Class, HashMap<String, Integer>> sJNISetterPropertyMap = new HashMap<Class, HashMap<String, Integer>>();
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.018 -0400", hash_original_field = "524C52C0A1E88CDA180A0F7AA6118606", hash_generated_field = "30E5C223A9B6F778F4F421C7D3106909")

    private static TypeEvaluator sIntEvaluator = new IntEvaluator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.019 -0400", hash_original_field = "15DEFED28FFB599464BB68C200695E4F", hash_generated_field = "7AEBE35D2A556DA8460D794234916F05")

    private static TypeEvaluator sFloatEvaluator = new FloatEvaluator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.037 -0400", hash_original_field = "5020662D31A4B6283E1907ADCCEB4874", hash_generated_field = "4904B1FEB97A28D3BF5E8A847584B9D9")

    private static Class[] FLOAT_VARIANTS = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.038 -0400", hash_original_field = "9C4E25A2E91D75D9D3EE0570B712EB32", hash_generated_field = "84A9ADB305F7E4BBC9780BF0AA1A0112")

    private static Class[] INTEGER_VARIANTS = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.038 -0400", hash_original_field = "B1F33CAD2A359720FA9A32D35A347DF1", hash_generated_field = "77B911A6C878234571903CF1A003EE05")

    private static Class[] DOUBLE_VARIANTS = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.039 -0400", hash_original_field = "8C96BADD97EAAC3C551B0848BE293B12", hash_generated_field = "BFD06F6D309E1BBADE77924DF6EA94CF")

    private static HashMap<Class, HashMap<String, Method>> sSetterPropertyMap = new HashMap<Class, HashMap<String, Method>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.040 -0400", hash_original_field = "F56CDACEEA95F1D6646404DB17E451C2", hash_generated_field = "2BB26A3604DDC0603B655D3B8A822B89")

    private static HashMap<Class, HashMap<String, Method>> sGetterPropertyMap = new HashMap<Class, HashMap<String, Method>>();
}

