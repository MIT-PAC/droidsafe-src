package android.animation;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.FloatProperty;
import android.util.IntProperty;
import android.util.Log;
import android.util.Property;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PropertyValuesHolder implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.128 -0400", hash_original_field = "AFC1281EACDFDDEC758551A3AAE3876C", hash_generated_field = "3E0E605326E1698CDE7903701811F2C0")

    String mPropertyName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.129 -0400", hash_original_field = "3BE74FBBD7FF163511D9CBD518CBA4A5", hash_generated_field = "E251A73627C8A3AA16F08ACAF8645F40")

    protected Property mProperty;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.129 -0400", hash_original_field = "D97BFD6711E9CC57FA5DB2FD2F8DE87B", hash_generated_field = "848F529A6ABC40F993A3D418131EC7A7")

    Method mSetter = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.129 -0400", hash_original_field = "8CE425F19DFD100C313BF3389D2C121A", hash_generated_field = "E1F4E67E7973C49A4B9CE526E6FC6D89")

    private Method mGetter = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.130 -0400", hash_original_field = "98DE3BF49406C5ACB6938D9BD7C43E69", hash_generated_field = "28819529602B8605503B4054C761CC6C")

    Class mValueType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.130 -0400", hash_original_field = "4849D8B4AB6A0FE1F7B81C0C07A14B0B", hash_generated_field = "C6973E4C17AF76FE86969D85049286F9")

    KeyframeSet mKeyframeSet = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.132 -0400", hash_original_field = "FD615E1C9081D8D57987D5321893DFF1", hash_generated_field = "F9F4D75002E3053AFE14BD3164953095")

    final ReentrantReadWriteLock mPropertyMapLock = new ReentrantReadWriteLock();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.133 -0400", hash_original_field = "90FCE5F7BA7EF0DAA4E972BE07405AE2", hash_generated_field = "D71A65350B0F0F3529679E7C5F1E5190")

    final Object[] mTmpValueArray = new Object[1];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.133 -0400", hash_original_field = "A5A16062C8CFDCD2D78B97324D59FBBD", hash_generated_field = "49D878C6212418A96C46E0217176C94E")

    private TypeEvaluator mEvaluator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.134 -0400", hash_original_field = "3A611FC8D0DF942B3AE2A62063E4425B", hash_generated_field = "B2B6DB149B87CF34CE07060A7A505841")

    private Object mAnimatedValue;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.135 -0400", hash_original_method = "73C53AD6C55F8F35D3899F0ADDC03638", hash_generated_method = "173B3BF84BCAAD759EC1E53526977EB5")
    private  PropertyValuesHolder(String propertyName) {
        mPropertyName = propertyName;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.137 -0400", hash_original_method = "BDE609B5B8790707A2E7C7F2E71E73EE", hash_generated_method = "0E856EB53E72B16051B207D87A59ECAC")
    private  PropertyValuesHolder(Property property) {
        mProperty = property;
    if(property != null)        
        {
            mPropertyName = property.getName();
        } 
        
        
        
            
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.148 -0400", hash_original_method = "5ACB1BF4CE1DE924456A446D3AE6F5AC", hash_generated_method = "F988F397E0C59F23B11B46996200454C")
    public void setIntValues(int... values) {
        mValueType = int.class;
        mKeyframeSet = KeyframeSet.ofInt(values);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.150 -0400", hash_original_method = "E55475A51A76C9AF68CEE5048B067603", hash_generated_method = "9308781A147C7C8F6EE137B61C15BCBE")
    public void setFloatValues(float... values) {
        mValueType = float.class;
        mKeyframeSet = KeyframeSet.ofFloat(values);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.153 -0400", hash_original_method = "A7BBAF2A9B12EBB30CB57DBA83B6B7FC", hash_generated_method = "552EE3E60999739A382FB82E32FC0AAF")
    public void setKeyframes(Keyframe... values) {
        int numKeyframes = values.length;
        Keyframe keyframes[] = new Keyframe[Math.max(numKeyframes,2)];
        mValueType = ((Keyframe)values[0]).getType();
for(int i = 0;i < numKeyframes;++i)
        {
            keyframes[i] = (Keyframe)values[i];
        } 
        mKeyframeSet = new KeyframeSet(keyframes);
        
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.155 -0400", hash_original_method = "8EF0800B602558BC1B6F05E6446D461B", hash_generated_method = "009C87DF8D68A19F0FC02389A7898792")
    public void setObjectValues(Object... values) {
        mValueType = values[0].getClass();
        mKeyframeSet = KeyframeSet.ofObject(values);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.160 -0400", hash_original_method = "13DE02BBE5B8605736F61BF53DFAC872", hash_generated_method = "0D0CB2066DA0C9BAEA501F70CA807049")
    private Method getPropertyFunction(Class targetClass, String prefix, Class valueType) {
        addTaint(valueType.getTaint());
        addTaint(prefix.getTaint());
        addTaint(targetClass.getTaint());
        Method returnVal = null;
        String methodName = getMethodName(prefix, mPropertyName);
        Class args[] = null;
    if(valueType == null)        
        {
            try 
            {
                returnVal = targetClass.getMethod(methodName, args);
            } 
            catch (NoSuchMethodException e)
            {
            } 
        } 
        else
        {
            args = new Class[1];
            Class typeVariants[];
    if(mValueType.equals(Float.class))            
            {
                typeVariants = FLOAT_VARIANTS;
            } 
            else
    if(mValueType.equals(Integer.class))            
            {
                typeVariants = INTEGER_VARIANTS;
            } 
            else
    if(mValueType.equals(Double.class))            
            {
                typeVariants = DOUBLE_VARIANTS;
            } 
            else
            {
                typeVariants = new Class[1];
                typeVariants[0] = mValueType;
            } 
for(Class typeVariant : typeVariants)
            {
                args[0] = typeVariant;
                try 
                {
                    returnVal = targetClass.getMethod(methodName, args);
                    mValueType = typeVariant;
Method var74D8482D05AF02514EABC315066E6806_1566437176 =                     returnVal;
                    var74D8482D05AF02514EABC315066E6806_1566437176.addTaint(taint);
                    return var74D8482D05AF02514EABC315066E6806_1566437176;
                } 
                catch (NoSuchMethodException e)
                {
                } 
            } 
        } 
Method var74D8482D05AF02514EABC315066E6806_87141303 =         returnVal;
        var74D8482D05AF02514EABC315066E6806_87141303.addTaint(taint);
        return var74D8482D05AF02514EABC315066E6806_87141303;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.169 -0400", hash_original_method = "D9982E89760E4BF7FBC2F6FCA80BFE72", hash_generated_method = "9E280888FE48D92A78489F5334FB9A91")
    private Method setupSetterOrGetter(Class targetClass,
            HashMap<Class, HashMap<String, Method>> propertyMapMap,
            String prefix, Class valueType) {
        addTaint(valueType.getTaint());
        addTaint(prefix.getTaint());
        addTaint(propertyMapMap.getTaint());
        addTaint(targetClass.getTaint());
        Method setterOrGetter = null;
        try 
        {
            mPropertyMapLock.writeLock().lock();
            HashMap<String, Method> propertyMap = propertyMapMap.get(targetClass);
    if(propertyMap != null)            
            {
                setterOrGetter = propertyMap.get(mPropertyName);
            } 
    if(setterOrGetter == null)            
            {
                setterOrGetter = getPropertyFunction(targetClass, prefix, valueType);
    if(propertyMap == null)                
                {
                    propertyMap = new HashMap<String, Method>();
                    propertyMapMap.put(targetClass, propertyMap);
                } 
                propertyMap.put(mPropertyName, setterOrGetter);
            } 
        } 
        finally 
        {
            mPropertyMapLock.writeLock().unlock();
        } 
Method var72DEA74FB2F1F2EAE5BFBBD9D6D5878A_1000477689 =         setterOrGetter;
        var72DEA74FB2F1F2EAE5BFBBD9D6D5878A_1000477689.addTaint(taint);
        return var72DEA74FB2F1F2EAE5BFBBD9D6D5878A_1000477689;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.171 -0400", hash_original_method = "1E4C95A3F0C35809E96A1D77677A320B", hash_generated_method = "57274BDEAD6F4EE1BDEDD294D61925B1")
     void setupSetter(Class targetClass) {
        mSetter = setupSetterOrGetter(targetClass, sSetterPropertyMap, "set", mValueType);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.173 -0400", hash_original_method = "8511F8F7AD8858B7DCF32F8ED21ED093", hash_generated_method = "AD073233B0C810F579053BFA42B447EA")
    private void setupGetter(Class targetClass) {
        mGetter = setupSetterOrGetter(targetClass, sGetterPropertyMap, "get", null);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.176 -0400", hash_original_method = "0087C9C0C21400747AF8DC614F234C65", hash_generated_method = "70CFB988AD4BBC3F7AC471C608877740")
     void setupSetterAndGetter(Object target) {
        addTaint(target.getTaint());
    if(mProperty != null)        
        {
            try 
            {
                Object testValue = mProperty.get(target);
for(Keyframe kf : mKeyframeSet.mKeyframes)
                {
    if(!kf.hasValue())                    
                    {
                        kf.setValue(mProperty.get(target));
                    } 
                } 
                return;
            } 
            catch (ClassCastException e)
            {
                mProperty = null;
            } 
        } 
        Class targetClass = target.getClass();
    if(mSetter == null)        
        {
            setupSetter(targetClass);
        } 
for(Keyframe kf : mKeyframeSet.mKeyframes)
        {
    if(!kf.hasValue())            
            {
    if(mGetter == null)                
                {
                    setupGetter(targetClass);
                } 
                try 
                {
                    kf.setValue(mGetter.invoke(target));
                } 
                catch (InvocationTargetException e)
                {
                } 
                catch (IllegalAccessException e)
                {
                } 
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.178 -0400", hash_original_method = "FD1A4547C57F636637D228B97E0E8D50", hash_generated_method = "BF228A1FFB36B0FC80C97497F9CCEB87")
    private void setupValue(Object target, Keyframe kf) {
        addTaint(kf.getTaint());
        addTaint(target.getTaint());
    if(mProperty != null)        
        {
            kf.setValue(mProperty.get(target));
        } 
        try 
        {
    if(mGetter == null)            
            {
                Class targetClass = target.getClass();
                setupGetter(targetClass);
            } 
            kf.setValue(mGetter.invoke(target));
        } 
        catch (InvocationTargetException e)
        {
        } 
        catch (IllegalAccessException e)
        {
        } 
        
        
            
        
        
            
                
                
            
            
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.179 -0400", hash_original_method = "981ED4D0B23A22C5ED7F7AF0C37F067E", hash_generated_method = "F1C4DF5D9A5AB6EB3669A9D104565E27")
     void setupStartValue(Object target) {
        addTaint(target.getTaint());
        setupValue(target, mKeyframeSet.mKeyframes.get(0));
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.180 -0400", hash_original_method = "387F5EDF2150EE198B0BBE4A1C97CF48", hash_generated_method = "33035B9CE60D7FE8A3439592C4CC671D")
     void setupEndValue(Object target) {
        addTaint(target.getTaint());
        setupValue(target, mKeyframeSet.mKeyframes.get(mKeyframeSet.mKeyframes.size() - 1));
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.186 -0400", hash_original_method = "8E6DC562093F236AE410C563F47F28F2", hash_generated_method = "23884267D61B574CC639E6CEBCCC195A")
    @Override
    public PropertyValuesHolder clone() {
        try 
        {
            PropertyValuesHolder newPVH = (PropertyValuesHolder) super.clone();
            newPVH.mPropertyName = mPropertyName;
            newPVH.mProperty = mProperty;
            newPVH.mKeyframeSet = mKeyframeSet.clone();
            newPVH.mEvaluator = mEvaluator;
PropertyValuesHolder var0228D1B95935619353E03C912CA40EEA_1134031670 =             newPVH;
            var0228D1B95935619353E03C912CA40EEA_1134031670.addTaint(taint);
            return var0228D1B95935619353E03C912CA40EEA_1134031670;
        } 
        catch (CloneNotSupportedException e)
        {
PropertyValuesHolder var540C13E9E156B687226421B24F2DF178_843498742 =             null;
            var540C13E9E156B687226421B24F2DF178_843498742.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_843498742;
        } 
        
        
            
            
            
            
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.193 -0400", hash_original_method = "BBF3202CC4B8C1713A46E96DE0EE5426", hash_generated_method = "5FD19CD3FB785848537C746D0A1CCE49")
     void setAnimatedValue(Object target) {
        addTaint(target.getTaint());
    if(mProperty != null)        
        {
            mProperty.set(target, getAnimatedValue());
        } 
    if(mSetter != null)        
        {
            try 
            {
                mTmpValueArray[0] = getAnimatedValue();
                mSetter.invoke(target, mTmpValueArray);
            } 
            catch (InvocationTargetException e)
            {
            } 
            catch (IllegalAccessException e)
            {
            } 
        } 
        
        
            
        
        
            
                
                
            
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.197 -0400", hash_original_method = "9511AC0B81E584A22A2DBDCB260E6C63", hash_generated_method = "285DE10A1D589EEEB4DAACD93EC58884")
     void init() {
    if(mEvaluator == null)        
        {
            mEvaluator = (mValueType == Integer.class) ? sIntEvaluator :
                    (mValueType == Float.class) ? sFloatEvaluator :
                    null;
        } 
    if(mEvaluator != null)        
        {
            mKeyframeSet.setEvaluator(mEvaluator);
        } 
        
        
            
                    
                    
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.199 -0400", hash_original_method = "8817589F1B40B238224DB9B551F0527E", hash_generated_method = "6E854FEA53C36628363D039E79093E2A")
    public void setEvaluator(TypeEvaluator evaluator) {
        mEvaluator = evaluator;
        mKeyframeSet.setEvaluator(evaluator);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.200 -0400", hash_original_method = "3D77B6F49E03B0770D03717F27BECD0E", hash_generated_method = "988B14A5F356427273DDE8DEE23C1F6E")
     void calculateValue(float fraction) {
        mAnimatedValue = mKeyframeSet.getValue(fraction);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.201 -0400", hash_original_method = "748680E3CF42F5BF312929F3A98BA3E4", hash_generated_method = "FF84DEB99D9BF13141DD024987B0DB4E")
    public void setPropertyName(String propertyName) {
        mPropertyName = propertyName;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.203 -0400", hash_original_method = "8FEFD1E6365C919A12E22D83DCF12A7D", hash_generated_method = "C7C8013F4ECEE98331FB456D99BFC828")
    public void setProperty(Property property) {
        mProperty = property;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.204 -0400", hash_original_method = "53B20749B4CEAC5C134A85897865D0FE", hash_generated_method = "FD0F51BE8BDD7F02349B9FA2FF2BDD08")
    public String getPropertyName() {
String varA94EBE08267F8B14AA5B485C2D24900F_712709125 =         mPropertyName;
        varA94EBE08267F8B14AA5B485C2D24900F_712709125.addTaint(taint);
        return varA94EBE08267F8B14AA5B485C2D24900F_712709125;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.206 -0400", hash_original_method = "7EED53883B814F7F8B112CE8FF982C26", hash_generated_method = "EAC0F08A2AFB9A9B2A6D4B33F05BCAFE")
     Object getAnimatedValue() {
Object var75C3F7261811C89DF5C27F09ADF01F70_577607631 =         mAnimatedValue;
        var75C3F7261811C89DF5C27F09ADF01F70_577607631.addTaint(taint);
        return var75C3F7261811C89DF5C27F09ADF01F70_577607631;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.208 -0400", hash_original_method = "BD911D365C7FC80DCCAF5DAD046A5B1C", hash_generated_method = "EFF9453FABB0C4D44303E98BE459CF66")
    @Override
    public String toString() {
String varBC0B2EC6369EA6D22FDCE3D1CEE1384D_237214400 =         mPropertyName + ": " + mKeyframeSet.toString();
        varBC0B2EC6369EA6D22FDCE3D1CEE1384D_237214400.addTaint(taint);
        return varBC0B2EC6369EA6D22FDCE3D1CEE1384D_237214400;
        
        
    }

    
        static String getMethodName(String prefix, String propertyName) {
        if (propertyName == null || propertyName.length() == 0) {
            return prefix;
        }
        char firstLetter = Character.toUpperCase(propertyName.charAt(0));
        String theRest = propertyName.substring(1);
        return prefix + firstLetter + theRest;
    }

    
    @DSModeled(DSC.SAFE)
    static private int nGetIntMethod(Class targetClass, String methodName) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    static private int nGetFloatMethod(Class targetClass, String methodName) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    static private void nCallIntMethod(Object target, int methodID, int arg) {
    }

    
    @DSModeled(DSC.SAFE)
    static private void nCallFloatMethod(Object target, int methodID, float arg) {
    }

    
    static class IntPropertyValuesHolder extends PropertyValuesHolder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.213 -0400", hash_original_field = "1D03D8B3C2FC1C9E51FA22A2A4C67478", hash_generated_field = "231C812A3CFDA881BCF1A1E1FEBCC96E")

        int mJniSetter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.214 -0400", hash_original_field = "F2CA4D1427C3922823BBBDBD76EDBB11", hash_generated_field = "789F496EFC4542E214000BFABCAD154A")

        private IntProperty mIntProperty;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.214 -0400", hash_original_field = "9393500818F5C0586106C06A2F52BBD9", hash_generated_field = "16BE68696FD23E4C9E2C2D0F3A95F693")

        IntKeyframeSet mIntKeyframeSet;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.216 -0400", hash_original_field = "B0684E8FF71F0AF7EF02100CBEEE1611", hash_generated_field = "2C2C363F77070248FB79E89B9069E337")

        int mIntAnimatedValue;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.220 -0400", hash_original_method = "A1404C395B1A556C6EC35453AB25DA4D", hash_generated_method = "5FE0BA07A052FEBCEE45A62B9CED2CD8")
        public  IntPropertyValuesHolder(String propertyName, IntKeyframeSet keyframeSet) {
            super(propertyName);
            addTaint(keyframeSet.getTaint());
            addTaint(propertyName.getTaint());
            mValueType = int.class;
            mKeyframeSet = keyframeSet;
            mIntKeyframeSet = (IntKeyframeSet) mKeyframeSet;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.223 -0400", hash_original_method = "81A38376DA5063E7A71924F7865D18EE", hash_generated_method = "603403109260D3D7DD707FECA22F3846")
        public  IntPropertyValuesHolder(Property property, IntKeyframeSet keyframeSet) {
            super(property);
            addTaint(keyframeSet.getTaint());
            addTaint(property.getTaint());
            mValueType = int.class;
            mKeyframeSet = keyframeSet;
            mIntKeyframeSet = (IntKeyframeSet) mKeyframeSet;
    if(property instanceof  IntProperty)            
            {
                mIntProperty = (IntProperty) mProperty;
            } 
            
            
            
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.225 -0400", hash_original_method = "D138EB87670EDA5FF4AD9A96EB7F8CD0", hash_generated_method = "532BFD017F30B7F2929B9C12E960B0B4")
        public  IntPropertyValuesHolder(String propertyName, int... values) {
            super(propertyName);
            addTaint(values[0]);
            addTaint(propertyName.getTaint());
            setIntValues(values);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.227 -0400", hash_original_method = "EF8A3E59A9590685EEFC24C3E37051A8", hash_generated_method = "C2EFCE5E7F9746C9668FB087F69B4335")
        public  IntPropertyValuesHolder(Property property, int... values) {
            super(property);
            addTaint(values[0]);
            addTaint(property.getTaint());
            setIntValues(values);
    if(property instanceof  IntProperty)            
            {
                mIntProperty = (IntProperty) mProperty;
            } 
            
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.229 -0400", hash_original_method = "36FED796688BFE2861C8D1DF18289634", hash_generated_method = "01AE1DF0BE62DDBBE13D52476B0C8687")
        @Override
        public void setIntValues(int... values) {
            addTaint(values[0]);
            super.setIntValues(values);
            mIntKeyframeSet = (IntKeyframeSet) mKeyframeSet;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.231 -0400", hash_original_method = "30F7306C8A34979730DB91915B461598", hash_generated_method = "46A582808A5314364CD0A0447001C6BD")
        @Override
         void calculateValue(float fraction) {
            mIntAnimatedValue = mIntKeyframeSet.getIntValue(fraction);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.233 -0400", hash_original_method = "CE13DB8914BA3896479030C59B8EB5EA", hash_generated_method = "A710DA4AA428881F595EF55E0B5D9C8B")
        @Override
         Object getAnimatedValue() {
Object var4277311C62C8711609EF6BC38BDC5F88_743667089 =             mIntAnimatedValue;
            var4277311C62C8711609EF6BC38BDC5F88_743667089.addTaint(taint);
            return var4277311C62C8711609EF6BC38BDC5F88_743667089;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.235 -0400", hash_original_method = "D2AD407C7BF3FF5B871B87BBB92EBDD2", hash_generated_method = "3E33F0B4B6DD34101AC164F2F34C0872")
        @Override
        public IntPropertyValuesHolder clone() {
            IntPropertyValuesHolder newPVH = (IntPropertyValuesHolder) super.clone();
            newPVH.mIntKeyframeSet = (IntKeyframeSet) newPVH.mKeyframeSet;
IntPropertyValuesHolder var0228D1B95935619353E03C912CA40EEA_1682747108 =             newPVH;
            var0228D1B95935619353E03C912CA40EEA_1682747108.addTaint(taint);
            return var0228D1B95935619353E03C912CA40EEA_1682747108;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.241 -0400", hash_original_method = "774DCA711497C815C6106461263A2AF3", hash_generated_method = "F5BFF10E5B60D98E42F7D3EED0C6573A")
        @Override
         void setAnimatedValue(Object target) {
            addTaint(target.getTaint());
    if(mIntProperty != null)            
            {
                mIntProperty.setValue(target, mIntAnimatedValue);
                return;
            } 
    if(mProperty != null)            
            {
                mProperty.set(target, mIntAnimatedValue);
                return;
            } 
    if(mJniSetter != 0)            
            {
                nCallIntMethod(target, mJniSetter, mIntAnimatedValue);
                return;
            } 
    if(mSetter != null)            
            {
                try 
                {
                    mTmpValueArray[0] = mIntAnimatedValue;
                    mSetter.invoke(target, mTmpValueArray);
                } 
                catch (InvocationTargetException e)
                {
                } 
                catch (IllegalAccessException e)
                {
                } 
            } 
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.249 -0400", hash_original_method = "E5FCCB47E07ECB03BE2F278E504281F8", hash_generated_method = "10B6BAB8B6610DDB6C6A993AE5C0D96A")
        @Override
         void setupSetter(Class targetClass) {
    if(mProperty != null)            
            {
                return;
            } 
            try 
            {
                mPropertyMapLock.writeLock().lock();
                HashMap<String, Integer> propertyMap = sJNISetterPropertyMap.get(targetClass);
    if(propertyMap != null)                
                {
                    Integer mJniSetterInteger = propertyMap.get(mPropertyName);
    if(mJniSetterInteger != null)                    
                    {
                        mJniSetter = mJniSetterInteger;
                    } 
                } 
    if(mJniSetter == 0)                
                {
                    String methodName = getMethodName("set", mPropertyName);
                    mJniSetter = nGetIntMethod(targetClass, methodName);
    if(mJniSetter != 0)                    
                    {
    if(propertyMap == null)                        
                        {
                            propertyMap = new HashMap<String, Integer>();
                            sJNISetterPropertyMap.put(targetClass, propertyMap);
                        } 
                        propertyMap.put(mPropertyName, mJniSetter);
                    } 
                } 
            } 
            catch (NoSuchMethodError e)
            {
                Log.d("PropertyValuesHolder",
                        "Can't find native method using JNI, use reflection" + e);
            } 
            finally 
            {
                mPropertyMapLock.writeLock().unlock();
            } 
    if(mJniSetter == 0)            
            {
                super.setupSetter(targetClass);
            } 
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.252 -0400", hash_original_field = "3557D6C5630E32249364C424D4B5912C", hash_generated_field = "47B44650F9265B2FD77E2A3383B8E152")

        private static final HashMap<Class, HashMap<String, Integer>> sJNISetterPropertyMap = new HashMap<Class, HashMap<String, Integer>>();
    }


    
    static class FloatPropertyValuesHolder extends PropertyValuesHolder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.253 -0400", hash_original_field = "1D03D8B3C2FC1C9E51FA22A2A4C67478", hash_generated_field = "231C812A3CFDA881BCF1A1E1FEBCC96E")

        int mJniSetter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.254 -0400", hash_original_field = "A9FFA5F0B217D5C92DAC4D0CA7B51B16", hash_generated_field = "CC72C56A48E7B9C7E56C889DE4F33E11")

        private FloatProperty mFloatProperty;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.255 -0400", hash_original_field = "E0E765CEEB5252BEC7C45ABA4D0174F9", hash_generated_field = "23FE3970B948CA0567BB21122CB48811")

        FloatKeyframeSet mFloatKeyframeSet;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.257 -0400", hash_original_field = "00AB0073C143477CD902DA8D79D657A7", hash_generated_field = "4734C624F522D63647CA34AA79C8C9AC")

        float mFloatAnimatedValue;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.260 -0400", hash_original_method = "5C9EF6457927B43859688413E4C7829F", hash_generated_method = "1C6A68ABB501736E53F2078FBE484AD0")
        public  FloatPropertyValuesHolder(String propertyName, FloatKeyframeSet keyframeSet) {
            super(propertyName);
            addTaint(keyframeSet.getTaint());
            addTaint(propertyName.getTaint());
            mValueType = float.class;
            mKeyframeSet = keyframeSet;
            mFloatKeyframeSet = (FloatKeyframeSet) mKeyframeSet;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.262 -0400", hash_original_method = "3ECDE802415F2017B0BC69F95B30B753", hash_generated_method = "CE1B2E236B6B2D071E8BC6578615B221")
        public  FloatPropertyValuesHolder(Property property, FloatKeyframeSet keyframeSet) {
            super(property);
            addTaint(keyframeSet.getTaint());
            addTaint(property.getTaint());
            mValueType = float.class;
            mKeyframeSet = keyframeSet;
            mFloatKeyframeSet = (FloatKeyframeSet) mKeyframeSet;
    if(property instanceof FloatProperty)            
            {
                mFloatProperty = (FloatProperty) mProperty;
            } 
            
            
            
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.264 -0400", hash_original_method = "C77EAEA380E6CBE61D90EF78014D158B", hash_generated_method = "EB7373B06A0F202E717672B41B3483C0")
        public  FloatPropertyValuesHolder(String propertyName, float... values) {
            super(propertyName);
            addTaint(values[0]);
            addTaint(propertyName.getTaint());
            setFloatValues(values);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.267 -0400", hash_original_method = "91C83497360B006516EF522F9EB49209", hash_generated_method = "C75E92C8020AF69AF06A27711692A923")
        public  FloatPropertyValuesHolder(Property property, float... values) {
            super(property);
            addTaint(values[0]);
            addTaint(property.getTaint());
            setFloatValues(values);
    if(property instanceof  FloatProperty)            
            {
                mFloatProperty = (FloatProperty) mProperty;
            } 
            
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.271 -0400", hash_original_method = "4C7839391C0E614BE090BEA208DAADC2", hash_generated_method = "E3019C45C896254CDB01DFA68E65398E")
        @Override
        public void setFloatValues(float... values) {
            addTaint(values[0]);
            super.setFloatValues(values);
            mFloatKeyframeSet = (FloatKeyframeSet) mKeyframeSet;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.272 -0400", hash_original_method = "EBADBBF750EE6D7005FAC08DD166E4F4", hash_generated_method = "E685B94C8F911CB6E2E055829FA0FF32")
        @Override
         void calculateValue(float fraction) {
            mFloatAnimatedValue = mFloatKeyframeSet.getFloatValue(fraction);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.274 -0400", hash_original_method = "56F77D961BC82461152CD24C144983C0", hash_generated_method = "60A3E2E86FFBD5E463BE714C0CE63E3C")
        @Override
         Object getAnimatedValue() {
Object varB8B4E2E7B85FC6B8760DC96DCB9D7522_902918195 =             mFloatAnimatedValue;
            varB8B4E2E7B85FC6B8760DC96DCB9D7522_902918195.addTaint(taint);
            return varB8B4E2E7B85FC6B8760DC96DCB9D7522_902918195;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.277 -0400", hash_original_method = "3798C3AECEA696DCFE0B333FF00EF37C", hash_generated_method = "2D0563A3D3BE62879379639DCA9C1E7A")
        @Override
        public FloatPropertyValuesHolder clone() {
            FloatPropertyValuesHolder newPVH = (FloatPropertyValuesHolder) super.clone();
            newPVH.mFloatKeyframeSet = (FloatKeyframeSet) newPVH.mKeyframeSet;
FloatPropertyValuesHolder var0228D1B95935619353E03C912CA40EEA_256238234 =             newPVH;
            var0228D1B95935619353E03C912CA40EEA_256238234.addTaint(taint);
            return var0228D1B95935619353E03C912CA40EEA_256238234;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.280 -0400", hash_original_method = "727C6F3DB059985E066E102AF679E2D9", hash_generated_method = "380BF794E029B539040479D082A315C2")
        @Override
         void setAnimatedValue(Object target) {
            addTaint(target.getTaint());
    if(mFloatProperty != null)            
            {
                mFloatProperty.setValue(target, mFloatAnimatedValue);
                return;
            } 
    if(mProperty != null)            
            {
                mProperty.set(target, mFloatAnimatedValue);
                return;
            } 
    if(mJniSetter != 0)            
            {
                nCallFloatMethod(target, mJniSetter, mFloatAnimatedValue);
                return;
            } 
    if(mSetter != null)            
            {
                try 
                {
                    mTmpValueArray[0] = mFloatAnimatedValue;
                    mSetter.invoke(target, mTmpValueArray);
                } 
                catch (InvocationTargetException e)
                {
                } 
                catch (IllegalAccessException e)
                {
                } 
            } 
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.284 -0400", hash_original_method = "2E99CF7209AB7743339028E8A9433227", hash_generated_method = "6FEE76FAEB8E2505A984B7996A280AD7")
        @Override
         void setupSetter(Class targetClass) {
    if(mProperty != null)            
            {
                return;
            } 
            try 
            {
                mPropertyMapLock.writeLock().lock();
                HashMap<String, Integer> propertyMap = sJNISetterPropertyMap.get(targetClass);
    if(propertyMap != null)                
                {
                    Integer mJniSetterInteger = propertyMap.get(mPropertyName);
    if(mJniSetterInteger != null)                    
                    {
                        mJniSetter = mJniSetterInteger;
                    } 
                } 
    if(mJniSetter == 0)                
                {
                    String methodName = getMethodName("set", mPropertyName);
                    mJniSetter = nGetFloatMethod(targetClass, methodName);
    if(mJniSetter != 0)                    
                    {
    if(propertyMap == null)                        
                        {
                            propertyMap = new HashMap<String, Integer>();
                            sJNISetterPropertyMap.put(targetClass, propertyMap);
                        } 
                        propertyMap.put(mPropertyName, mJniSetter);
                    } 
                } 
            } 
            catch (NoSuchMethodError e)
            {
                Log.d("PropertyValuesHolder",
                        "Can't find native method using JNI, use reflection" + e);
            } 
            finally 
            {
                mPropertyMapLock.writeLock().unlock();
            } 
    if(mJniSetter == 0)            
            {
                super.setupSetter(targetClass);
            } 
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.286 -0400", hash_original_field = "3557D6C5630E32249364C424D4B5912C", hash_generated_field = "47B44650F9265B2FD77E2A3383B8E152")

        private static final HashMap<Class, HashMap<String, Integer>> sJNISetterPropertyMap = new HashMap<Class, HashMap<String, Integer>>();
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.288 -0400", hash_original_field = "524C52C0A1E88CDA180A0F7AA6118606", hash_generated_field = "7E9EFDBC560251144B1ABA6A3E58FAA3")

    private static final TypeEvaluator sIntEvaluator = new IntEvaluator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.290 -0400", hash_original_field = "15DEFED28FFB599464BB68C200695E4F", hash_generated_field = "81564E463CF700876869857891E00106")

    private static final TypeEvaluator sFloatEvaluator = new FloatEvaluator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.292 -0400", hash_original_field = "5020662D31A4B6283E1907ADCCEB4874", hash_generated_field = "07148BED043B90DA742996E111F16340")

    private static Class[] FLOAT_VARIANTS = {float.class, Float.class, double.class, int.class,
            Double.class, Integer.class};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.294 -0400", hash_original_field = "9C4E25A2E91D75D9D3EE0570B712EB32", hash_generated_field = "2AB15B1F0AA6A5F55EE330ABD82CD53C")

    private static Class[] INTEGER_VARIANTS = {int.class, Integer.class, float.class, double.class,
            Float.class, Double.class};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.295 -0400", hash_original_field = "B1F33CAD2A359720FA9A32D35A347DF1", hash_generated_field = "1C78BAF1D2C06E74F6CAF6919DCF921C")

    private static Class[] DOUBLE_VARIANTS = {double.class, Double.class, float.class, int.class,
            Float.class, Integer.class};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.296 -0400", hash_original_field = "8C96BADD97EAAC3C551B0848BE293B12", hash_generated_field = "B79DE0A5696D74AB905E382C94DB8E44")

    private static final HashMap<Class, HashMap<String, Method>> sSetterPropertyMap = new HashMap<Class, HashMap<String, Method>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.297 -0400", hash_original_field = "F56CDACEEA95F1D6646404DB17E451C2", hash_generated_field = "C2AD3EF1A9BABE0B350993A7EE00B799")

    private static final HashMap<Class, HashMap<String, Method>> sGetterPropertyMap = new HashMap<Class, HashMap<String, Method>>();
}

