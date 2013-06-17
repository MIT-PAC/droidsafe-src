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
    String mPropertyName;
    protected Property mProperty;
    Method mSetter = null;
    private Method mGetter = null;
    Class mValueType;
    KeyframeSet mKeyframeSet = null;
    ReentrantReadWriteLock mPropertyMapLock = new ReentrantReadWriteLock();
    Object[] mTmpValueArray = new Object[1];
    private TypeEvaluator mEvaluator;
    private Object mAnimatedValue;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.257 -0400", hash_original_method = "73C53AD6C55F8F35D3899F0ADDC03638", hash_generated_method = "62424CA9A7F83BC65DD77DC2447DC020")
    @DSModeled(DSC.SAFE)
    private PropertyValuesHolder(String propertyName) {
        dsTaint.addTaint(propertyName);
        // ---------- Original Method ----------
        //mPropertyName = propertyName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.266 -0400", hash_original_method = "BDE609B5B8790707A2E7C7F2E71E73EE", hash_generated_method = "A9BF136FF804517F241B4E490030AF85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private PropertyValuesHolder(Property property) {
        dsTaint.addTaint(property.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.307 -0400", hash_original_method = "5ACB1BF4CE1DE924456A446D3AE6F5AC", hash_generated_method = "AC1DF3AE0812762D649AAA066A4A769B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setIntValues(int... values) {
        dsTaint.addTaint(values);
        mValueType = int.class;
        mKeyframeSet = KeyframeSet.ofInt(values);
        // ---------- Original Method ----------
        //mValueType = int.class;
        //mKeyframeSet = KeyframeSet.ofInt(values);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.320 -0400", hash_original_method = "E55475A51A76C9AF68CEE5048B067603", hash_generated_method = "CA38943C6762AB1E418F6BD63EB7EEF5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFloatValues(float... values) {
        dsTaint.addTaint(values);
        mValueType = float.class;
        mKeyframeSet = KeyframeSet.ofFloat(values);
        // ---------- Original Method ----------
        //mValueType = float.class;
        //mKeyframeSet = KeyframeSet.ofFloat(values);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.336 -0400", hash_original_method = "A7BBAF2A9B12EBB30CB57DBA83B6B7FC", hash_generated_method = "AD6A2A857B96CD2C8D4D79FC47542554")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setKeyframes(Keyframe... values) {
        dsTaint.addTaint(values[0].dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.346 -0400", hash_original_method = "8EF0800B602558BC1B6F05E6446D461B", hash_generated_method = "B96DA70AA10404EF9F7B53336306E78E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setObjectValues(Object... values) {
        dsTaint.addTaint(values[0].dsTaint);
        mValueType = values[0].getClass();
        mKeyframeSet = KeyframeSet.ofObject(values);
        // ---------- Original Method ----------
        //mValueType = values[0].getClass();
        //mKeyframeSet = KeyframeSet.ofObject(values);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.370 -0400", hash_original_method = "13DE02BBE5B8605736F61BF53DFAC872", hash_generated_method = "FB4C51BD93455D39C8B5CFAC13ECB256")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Method getPropertyFunction(Class targetClass, String prefix, Class valueType) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(targetClass.dsTaint);
        dsTaint.addTaint(valueType.dsTaint);
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
                boolean varA19CC413B5D979C40823A0DFD08B5B8B_980852553 = (mValueType.equals(Float.class));
                {
                    typeVariants = FLOAT_VARIANTS;
                } //End block
                {
                    boolean varD5B60361EAD528E96F229CD21781680B_477224864 = (mValueType.equals(Integer.class));
                    {
                        typeVariants = INTEGER_VARIANTS;
                    } //End block
                    {
                        boolean var0B542F869A194F37A1EAAC7F79A1D812_1762162030 = (mValueType.equals(Double.class));
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
                    } //End block
                    catch (NoSuchMethodException e)
                    { }
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (Method)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.402 -0400", hash_original_method = "D9982E89760E4BF7FBC2F6FCA80BFE72", hash_generated_method = "9DE4FC63AC4B553F1733EBF7A8518FDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Method setupSetterOrGetter(Class targetClass,
            HashMap<Class, HashMap<String, Method>> propertyMapMap,
            String prefix, Class valueType) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(targetClass.dsTaint);
        dsTaint.addTaint(valueType.dsTaint);
        dsTaint.addTaint(propertyMapMap.dsTaint);
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
        return (Method)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.410 -0400", hash_original_method = "1E4C95A3F0C35809E96A1D77677A320B", hash_generated_method = "3548C9DEB4687210847EE2E13946A387")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setupSetter(Class targetClass) {
        dsTaint.addTaint(targetClass.dsTaint);
        mSetter = setupSetterOrGetter(targetClass, sSetterPropertyMap, "set", mValueType);
        // ---------- Original Method ----------
        //mSetter = setupSetterOrGetter(targetClass, sSetterPropertyMap, "set", mValueType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.419 -0400", hash_original_method = "8511F8F7AD8858B7DCF32F8ED21ED093", hash_generated_method = "85D1EA7C683AF5978252EF4A2B209A37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setupGetter(Class targetClass) {
        dsTaint.addTaint(targetClass.dsTaint);
        mGetter = setupSetterOrGetter(targetClass, sGetterPropertyMap, "get", null);
        // ---------- Original Method ----------
        //mGetter = setupSetterOrGetter(targetClass, sGetterPropertyMap, "get", null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.448 -0400", hash_original_method = "0087C9C0C21400747AF8DC614F234C65", hash_generated_method = "E2CA9D3D363798461DA8F827EBFD0488")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setupSetterAndGetter(Object target) {
        dsTaint.addTaint(target.dsTaint);
        {
            try 
            {
                Object testValue;
                testValue = mProperty.get(target);
                {
                    Iterator<Keyframe> var30BC71CCD48BB50A1DFF3F1C4E9C9F4A_1612084580 = mKeyframeSet.mKeyframes.iterator();
                    var30BC71CCD48BB50A1DFF3F1C4E9C9F4A_1612084580.hasNext();
                    Keyframe kf = var30BC71CCD48BB50A1DFF3F1C4E9C9F4A_1612084580.next();
                    {
                        {
                            boolean var4D41CBD03F5F0E056BC0D1CE3112DD7D_780143373 = (!kf.hasValue());
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
            Iterator<Keyframe> var30BC71CCD48BB50A1DFF3F1C4E9C9F4A_1536575651 = mKeyframeSet.mKeyframes.iterator();
            var30BC71CCD48BB50A1DFF3F1C4E9C9F4A_1536575651.hasNext();
            Keyframe kf = var30BC71CCD48BB50A1DFF3F1C4E9C9F4A_1536575651.next();
            {
                {
                    boolean var1879ACDF397A2339AF73F7A898CEEF3F_388931025 = (!kf.hasValue());
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.463 -0400", hash_original_method = "FD1A4547C57F636637D228B97E0E8D50", hash_generated_method = "74EFF8FB64E46DF993A925753BC07B44")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setupValue(Object target, Keyframe kf) {
        dsTaint.addTaint(kf.dsTaint);
        dsTaint.addTaint(target.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.470 -0400", hash_original_method = "981ED4D0B23A22C5ED7F7AF0C37F067E", hash_generated_method = "7596C5B2EAD49C0E9771EAF157514220")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setupStartValue(Object target) {
        dsTaint.addTaint(target.dsTaint);
        setupValue(target, mKeyframeSet.mKeyframes.get(0));
        // ---------- Original Method ----------
        //setupValue(target, mKeyframeSet.mKeyframes.get(0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.475 -0400", hash_original_method = "387F5EDF2150EE198B0BBE4A1C97CF48", hash_generated_method = "07524E03C67FCC0B70B88C63CCBB28F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setupEndValue(Object target) {
        dsTaint.addTaint(target.dsTaint);
        setupValue(target, mKeyframeSet.mKeyframes.get(mKeyframeSet.mKeyframes.size() - 1));
        // ---------- Original Method ----------
        //setupValue(target, mKeyframeSet.mKeyframes.get(mKeyframeSet.mKeyframes.size() - 1));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.482 -0400", hash_original_method = "8E6DC562093F236AE410C563F47F28F2", hash_generated_method = "DC6A3EB5D44FA3500E49569D0A9731FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public PropertyValuesHolder clone() {
        try 
        {
            PropertyValuesHolder newPVH;
            newPVH = (PropertyValuesHolder) super.clone();
            newPVH.mPropertyName = mPropertyName;
            newPVH.mProperty = mProperty;
            newPVH.mKeyframeSet = mKeyframeSet.clone();
            newPVH.mEvaluator = mEvaluator;
        } //End block
        catch (CloneNotSupportedException e)
        { }
        return (PropertyValuesHolder)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.491 -0400", hash_original_method = "BBF3202CC4B8C1713A46E96DE0EE5426", hash_generated_method = "C6D0310FBC6B4E3A4FE5A95EAB5DC3EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setAnimatedValue(Object target) {
        dsTaint.addTaint(target.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.501 -0400", hash_original_method = "9511AC0B81E584A22A2DBDCB260E6C63", hash_generated_method = "6FB68D7738033F4BC849D6B08F43923F")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.508 -0400", hash_original_method = "8817589F1B40B238224DB9B551F0527E", hash_generated_method = "08077E074803F67687F81CC62727BAE1")
    @DSModeled(DSC.SAFE)
    public void setEvaluator(TypeEvaluator evaluator) {
        dsTaint.addTaint(evaluator.dsTaint);
        mKeyframeSet.setEvaluator(evaluator);
        // ---------- Original Method ----------
        //mEvaluator = evaluator;
        //mKeyframeSet.setEvaluator(evaluator);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.512 -0400", hash_original_method = "3D77B6F49E03B0770D03717F27BECD0E", hash_generated_method = "980825A4C001A10575956452936FCF98")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void calculateValue(float fraction) {
        dsTaint.addTaint(fraction);
        mAnimatedValue = mKeyframeSet.getValue(fraction);
        // ---------- Original Method ----------
        //mAnimatedValue = mKeyframeSet.getValue(fraction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.516 -0400", hash_original_method = "748680E3CF42F5BF312929F3A98BA3E4", hash_generated_method = "E96E52496C79DFA849B9E6FE242D5B8F")
    @DSModeled(DSC.SAFE)
    public void setPropertyName(String propertyName) {
        dsTaint.addTaint(propertyName);
        // ---------- Original Method ----------
        //mPropertyName = propertyName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.520 -0400", hash_original_method = "8FEFD1E6365C919A12E22D83DCF12A7D", hash_generated_method = "9CC6B949387329F614C48A65C173DBA0")
    @DSModeled(DSC.SAFE)
    public void setProperty(Property property) {
        dsTaint.addTaint(property.dsTaint);
        // ---------- Original Method ----------
        //mProperty = property;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.524 -0400", hash_original_method = "53B20749B4CEAC5C134A85897865D0FE", hash_generated_method = "19C243F0DAD668218C8EB3848FFD0192")
    @DSModeled(DSC.SAFE)
    public String getPropertyName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPropertyName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.527 -0400", hash_original_method = "7EED53883B814F7F8B112CE8FF982C26", hash_generated_method = "A63991715CC64930DB987543E9DAA593")
    @DSModeled(DSC.SAFE)
     Object getAnimatedValue() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mAnimatedValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.544 -0400", hash_original_method = "BD911D365C7FC80DCCAF5DAD046A5B1C", hash_generated_method = "C4A4223C714CA53A5D597065C3013619")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var6E0AA3FFE56F33AD4C3F9AC8B586A8AD_171574011 = (mPropertyName + ": " + mKeyframeSet.toString());
        return dsTaint.getTaintString();
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
        int mJniSetter;
        private IntProperty mIntProperty;
        IntKeyframeSet mIntKeyframeSet;
        int mIntAnimatedValue;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.555 -0400", hash_original_method = "A1404C395B1A556C6EC35453AB25DA4D", hash_generated_method = "7596D767ED640DBCB8FB3A007C291DD8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public IntPropertyValuesHolder(String propertyName, IntKeyframeSet keyframeSet) {
            super(propertyName);
            dsTaint.addTaint(propertyName);
            dsTaint.addTaint(keyframeSet.dsTaint);
            mValueType = int.class;
            mKeyframeSet = keyframeSet;
            mIntKeyframeSet = (IntKeyframeSet) mKeyframeSet;
            // ---------- Original Method ----------
            //mValueType = int.class;
            //mKeyframeSet = keyframeSet;
            //mIntKeyframeSet = (IntKeyframeSet) mKeyframeSet;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.560 -0400", hash_original_method = "81A38376DA5063E7A71924F7865D18EE", hash_generated_method = "98320D87A44ABE7A2AFF5B01D4B84B9F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public IntPropertyValuesHolder(Property property, IntKeyframeSet keyframeSet) {
            super(property);
            dsTaint.addTaint(keyframeSet.dsTaint);
            dsTaint.addTaint(property.dsTaint);
            mValueType = int.class;
            mKeyframeSet = keyframeSet;
            mIntKeyframeSet = (IntKeyframeSet) mKeyframeSet;
            {
                mIntProperty = (IntProperty) mProperty;
            } //End block
            // ---------- Original Method ----------
            //mValueType = int.class;
            //mKeyframeSet = keyframeSet;
            //mIntKeyframeSet = (IntKeyframeSet) mKeyframeSet;
            //if (property instanceof  IntProperty) {
                //mIntProperty = (IntProperty) mProperty;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.564 -0400", hash_original_method = "D138EB87670EDA5FF4AD9A96EB7F8CD0", hash_generated_method = "121BEC11467DD96FAC3B30245F5EDD11")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public IntPropertyValuesHolder(String propertyName, int... values) {
            super(propertyName);
            dsTaint.addTaint(propertyName);
            dsTaint.addTaint(values);
            setIntValues(values);
            // ---------- Original Method ----------
            //setIntValues(values);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.568 -0400", hash_original_method = "EF8A3E59A9590685EEFC24C3E37051A8", hash_generated_method = "2A7F5B3317FA5D2A87D95548E1C10E93")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public IntPropertyValuesHolder(Property property, int... values) {
            super(property);
            dsTaint.addTaint(values);
            dsTaint.addTaint(property.dsTaint);
            setIntValues(values);
            {
                mIntProperty = (IntProperty) mProperty;
            } //End block
            // ---------- Original Method ----------
            //setIntValues(values);
            //if (property instanceof  IntProperty) {
                //mIntProperty = (IntProperty) mProperty;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.572 -0400", hash_original_method = "36FED796688BFE2861C8D1DF18289634", hash_generated_method = "B9EA97A23CCD51AE586AA42AB4C5E34D")
        @DSModeled(DSC.SAFE)
        @Override
        public void setIntValues(int... values) {
            dsTaint.addTaint(values);
            super.setIntValues(values);
            mIntKeyframeSet = (IntKeyframeSet) mKeyframeSet;
            // ---------- Original Method ----------
            //super.setIntValues(values);
            //mIntKeyframeSet = (IntKeyframeSet) mKeyframeSet;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.576 -0400", hash_original_method = "30F7306C8A34979730DB91915B461598", hash_generated_method = "B091DF161147875851FDFADABAE2C35D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
         void calculateValue(float fraction) {
            dsTaint.addTaint(fraction);
            mIntAnimatedValue = mIntKeyframeSet.getIntValue(fraction);
            // ---------- Original Method ----------
            //mIntAnimatedValue = mIntKeyframeSet.getIntValue(fraction);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.579 -0400", hash_original_method = "CE13DB8914BA3896479030C59B8EB5EA", hash_generated_method = "B85693EDEC168FF8BE60D975E4FA791A")
        @DSModeled(DSC.SAFE)
        @Override
         Object getAnimatedValue() {
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mIntAnimatedValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.583 -0400", hash_original_method = "D2AD407C7BF3FF5B871B87BBB92EBDD2", hash_generated_method = "3526D1CBE66D4FC46222AF0C9A53A722")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public IntPropertyValuesHolder clone() {
            IntPropertyValuesHolder newPVH;
            newPVH = (IntPropertyValuesHolder) super.clone();
            newPVH.mIntKeyframeSet = (IntKeyframeSet) newPVH.mKeyframeSet;
            return (IntPropertyValuesHolder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //IntPropertyValuesHolder newPVH = (IntPropertyValuesHolder) super.clone();
            //newPVH.mIntKeyframeSet = (IntKeyframeSet) newPVH.mKeyframeSet;
            //return newPVH;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.593 -0400", hash_original_method = "774DCA711497C815C6106461263A2AF3", hash_generated_method = "239561D74F8DBF0D71B3CFF40AE6EE0B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
         void setAnimatedValue(Object target) {
            dsTaint.addTaint(target.dsTaint);
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
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.606 -0400", hash_original_method = "E5FCCB47E07ECB03BE2F278E504281F8", hash_generated_method = "9410E6343ED313461560F6161F6A32A3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
         void setupSetter(Class targetClass) {
            dsTaint.addTaint(targetClass.dsTaint);
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

        
        private static final HashMap<Class, HashMap<String, Integer>> sJNISetterPropertyMap =
                new HashMap<Class, HashMap<String, Integer>>();
    }


    
    static class FloatPropertyValuesHolder extends PropertyValuesHolder {
        int mJniSetter;
        private FloatProperty mFloatProperty;
        FloatKeyframeSet mFloatKeyframeSet;
        float mFloatAnimatedValue;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.615 -0400", hash_original_method = "5C9EF6457927B43859688413E4C7829F", hash_generated_method = "E2E7A1F87679E806FF739875392DE1D9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public FloatPropertyValuesHolder(String propertyName, FloatKeyframeSet keyframeSet) {
            super(propertyName);
            dsTaint.addTaint(propertyName);
            dsTaint.addTaint(keyframeSet.dsTaint);
            mValueType = float.class;
            mKeyframeSet = keyframeSet;
            mFloatKeyframeSet = (FloatKeyframeSet) mKeyframeSet;
            // ---------- Original Method ----------
            //mValueType = float.class;
            //mKeyframeSet = keyframeSet;
            //mFloatKeyframeSet = (FloatKeyframeSet) mKeyframeSet;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.620 -0400", hash_original_method = "3ECDE802415F2017B0BC69F95B30B753", hash_generated_method = "4B1870FB40EC26E7AAC0A6B464975BF7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public FloatPropertyValuesHolder(Property property, FloatKeyframeSet keyframeSet) {
            super(property);
            dsTaint.addTaint(keyframeSet.dsTaint);
            dsTaint.addTaint(property.dsTaint);
            mValueType = float.class;
            mKeyframeSet = keyframeSet;
            mFloatKeyframeSet = (FloatKeyframeSet) mKeyframeSet;
            {
                mFloatProperty = (FloatProperty) mProperty;
            } //End block
            // ---------- Original Method ----------
            //mValueType = float.class;
            //mKeyframeSet = keyframeSet;
            //mFloatKeyframeSet = (FloatKeyframeSet) mKeyframeSet;
            //if (property instanceof FloatProperty) {
                //mFloatProperty = (FloatProperty) mProperty;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.623 -0400", hash_original_method = "C77EAEA380E6CBE61D90EF78014D158B", hash_generated_method = "C079D56FAE5028C762E8E44CD9993474")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public FloatPropertyValuesHolder(String propertyName, float... values) {
            super(propertyName);
            dsTaint.addTaint(propertyName);
            dsTaint.addTaint(values);
            setFloatValues(values);
            // ---------- Original Method ----------
            //setFloatValues(values);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.627 -0400", hash_original_method = "91C83497360B006516EF522F9EB49209", hash_generated_method = "D438D5C825BD90C3DFF46758F34EA714")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public FloatPropertyValuesHolder(Property property, float... values) {
            super(property);
            dsTaint.addTaint(values);
            dsTaint.addTaint(property.dsTaint);
            setFloatValues(values);
            {
                mFloatProperty = (FloatProperty) mProperty;
            } //End block
            // ---------- Original Method ----------
            //setFloatValues(values);
            //if (property instanceof  FloatProperty) {
                //mFloatProperty = (FloatProperty) mProperty;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.633 -0400", hash_original_method = "4C7839391C0E614BE090BEA208DAADC2", hash_generated_method = "0F213DF8720A74C4984EE2875978AADA")
        @DSModeled(DSC.SAFE)
        @Override
        public void setFloatValues(float... values) {
            dsTaint.addTaint(values);
            super.setFloatValues(values);
            mFloatKeyframeSet = (FloatKeyframeSet) mKeyframeSet;
            // ---------- Original Method ----------
            //super.setFloatValues(values);
            //mFloatKeyframeSet = (FloatKeyframeSet) mKeyframeSet;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.637 -0400", hash_original_method = "EBADBBF750EE6D7005FAC08DD166E4F4", hash_generated_method = "46B82B2727C63A4226AD4F4A48BA0E8A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
         void calculateValue(float fraction) {
            dsTaint.addTaint(fraction);
            mFloatAnimatedValue = mFloatKeyframeSet.getFloatValue(fraction);
            // ---------- Original Method ----------
            //mFloatAnimatedValue = mFloatKeyframeSet.getFloatValue(fraction);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.640 -0400", hash_original_method = "56F77D961BC82461152CD24C144983C0", hash_generated_method = "D53DC255290A97220C7D4E86724FFD50")
        @DSModeled(DSC.SAFE)
        @Override
         Object getAnimatedValue() {
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mFloatAnimatedValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.643 -0400", hash_original_method = "3798C3AECEA696DCFE0B333FF00EF37C", hash_generated_method = "B716E8A4395B75FE9B78AFAC7188BF59")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public FloatPropertyValuesHolder clone() {
            FloatPropertyValuesHolder newPVH;
            newPVH = (FloatPropertyValuesHolder) super.clone();
            newPVH.mFloatKeyframeSet = (FloatKeyframeSet) newPVH.mKeyframeSet;
            return (FloatPropertyValuesHolder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //FloatPropertyValuesHolder newPVH = (FloatPropertyValuesHolder) super.clone();
            //newPVH.mFloatKeyframeSet = (FloatKeyframeSet) newPVH.mKeyframeSet;
            //return newPVH;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.652 -0400", hash_original_method = "727C6F3DB059985E066E102AF679E2D9", hash_generated_method = "85901A941102451B84DBD4955DF8D2C4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
         void setAnimatedValue(Object target) {
            dsTaint.addTaint(target.dsTaint);
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
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-17 13:03:25.662 -0400", hash_original_method = "2E99CF7209AB7743339028E8A9433227", hash_generated_method = "14B30FDADB98FD5F311FB1A119749696")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
         void setupSetter(Class targetClass) {
            dsTaint.addTaint(targetClass.dsTaint);
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

        
        private static final HashMap<Class, HashMap<String, Integer>> sJNISetterPropertyMap =
                new HashMap<Class, HashMap<String, Integer>>();
    }


    
    private static final TypeEvaluator sIntEvaluator = new IntEvaluator();
    private static final TypeEvaluator sFloatEvaluator = new FloatEvaluator();
    private static Class[] FLOAT_VARIANTS = {float.class, Float.class, double.class, int.class,
            Double.class, Integer.class};
    private static Class[] INTEGER_VARIANTS = {int.class, Integer.class, float.class, double.class,
            Float.class, Double.class};
    private static Class[] DOUBLE_VARIANTS = {double.class, Double.class, float.class, int.class,
            Float.class, Integer.class};
    private static final HashMap<Class, HashMap<String, Method>> sSetterPropertyMap =
            new HashMap<Class, HashMap<String, Method>>();
    private static final HashMap<Class, HashMap<String, Method>> sGetterPropertyMap =
            new HashMap<Class, HashMap<String, Method>>();
}

