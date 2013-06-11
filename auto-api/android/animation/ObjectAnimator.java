package android.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.util.Log;
import android.util.Property;
import java.lang.reflect.Method;
import java.util.ArrayList;

public final class ObjectAnimator extends ValueAnimator {
    private static final boolean DBG = false;
    private Object mTarget;
    private String mPropertyName;
    private Property mProperty;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.233 -0400", hash_original_method = "C409E7B2E0E9411E53B94F67FBBD17CB", hash_generated_method = "A9F5B962CAF62ABD4BD355E0D2C0F73B")
    @DSModeled(DSC.SAFE)
    public ObjectAnimator() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.234 -0400", hash_original_method = "72D05C8CED3E11A756BC68866B4296D0", hash_generated_method = "238F594692381D34203C2AD4740DE3E0")
    @DSModeled(DSC.SAFE)
    private ObjectAnimator(Object target, String propertyName) {
        dsTaint.addTaint(propertyName);
        dsTaint.addTaint(target.dsTaint);
        setPropertyName(propertyName);
        // ---------- Original Method ----------
        //mTarget = target;
        //setPropertyName(propertyName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.235 -0400", hash_original_method = "F7624EC0BC93A299A0815B7F750DA685", hash_generated_method = "7D9E406D3686333386B89598B275D0AF")
    @DSModeled(DSC.SAFE)
    private <T> ObjectAnimator(T target, Property<T, ?> property) {
        dsTaint.addTaint(target.dsTaint);
        dsTaint.addTaint(property.dsTaint);
        setProperty(property);
        // ---------- Original Method ----------
        //mTarget = target;
        //setProperty(property);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.235 -0400", hash_original_method = "9BD9C177E2BB2F7D9011362061D59F72", hash_generated_method = "0FEE86E878FF61600DA8BE54EB2AD5AF")
    @DSModeled(DSC.SAFE)
    public void setPropertyName(String propertyName) {
        dsTaint.addTaint(propertyName);
        {
            PropertyValuesHolder valuesHolder;
            valuesHolder = mValues[0];
            String oldName;
            oldName = valuesHolder.getPropertyName();
            valuesHolder.setPropertyName(propertyName);
            mValuesMap.remove(oldName);
            mValuesMap.put(propertyName, valuesHolder);
        } //End block
        mInitialized = false;
        // ---------- Original Method ----------
        //if (mValues != null) {
            //PropertyValuesHolder valuesHolder = mValues[0];
            //String oldName = valuesHolder.getPropertyName();
            //valuesHolder.setPropertyName(propertyName);
            //mValuesMap.remove(oldName);
            //mValuesMap.put(propertyName, valuesHolder);
        //}
        //mPropertyName = propertyName;
        //mInitialized = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.236 -0400", hash_original_method = "B6C27508DB7D8F3AB8749306282F7776", hash_generated_method = "35F8829841FC5BB64953F98B9E7841A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setProperty(Property property) {
        dsTaint.addTaint(property.dsTaint);
        {
            PropertyValuesHolder valuesHolder;
            valuesHolder = mValues[0];
            String oldName;
            oldName = valuesHolder.getPropertyName();
            valuesHolder.setProperty(property);
            mValuesMap.remove(oldName);
            mValuesMap.put(mPropertyName, valuesHolder);
        } //End block
        {
            mPropertyName = property.getName();
        } //End block
        mInitialized = false;
        // ---------- Original Method ----------
        //if (mValues != null) {
            //PropertyValuesHolder valuesHolder = mValues[0];
            //String oldName = valuesHolder.getPropertyName();
            //valuesHolder.setProperty(property);
            //mValuesMap.remove(oldName);
            //mValuesMap.put(mPropertyName, valuesHolder);
        //}
        //if (mProperty != null) {
            //mPropertyName = property.getName();
        //}
        //mProperty = property;
        //mInitialized = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.237 -0400", hash_original_method = "53B20749B4CEAC5C134A85897865D0FE", hash_generated_method = "2330B782FDC9651284786DD5F80AE038")
    @DSModeled(DSC.SAFE)
    public String getPropertyName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPropertyName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.237 -0400", hash_original_method = "A00631EA578020D8AF102DDB2FCEFAC8", hash_generated_method = "45A1DBE9A77A2E9820DD58C0D0247F0A")
    public static ObjectAnimator ofInt(Object target, String propertyName, int... values) {
        ObjectAnimator anim = new ObjectAnimator(target, propertyName);
        anim.setIntValues(values);
        return anim;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.238 -0400", hash_original_method = "804C28FFAA38E8B57DE65DF965A25DD7", hash_generated_method = "5705D14949EE3CC81489F5FC1409FC66")
    public static <T> ObjectAnimator ofInt(T target, Property<T, Integer> property, int... values) {
        ObjectAnimator anim = new ObjectAnimator(target, property);
        anim.setIntValues(values);
        return anim;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.238 -0400", hash_original_method = "7A2DAA3629AD92EDC2DFD0D78B3421C9", hash_generated_method = "13FDA7CA700C3F2B682BF97543D98984")
    public static ObjectAnimator ofFloat(Object target, String propertyName, float... values) {
        ObjectAnimator anim = new ObjectAnimator(target, propertyName);
        anim.setFloatValues(values);
        return anim;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.239 -0400", hash_original_method = "CC0A47207E256D165722872938274B5A", hash_generated_method = "152C268B7D631A0CBD881155D65F10D9")
    public static <T> ObjectAnimator ofFloat(T target, Property<T, Float> property,
            float... values) {
        ObjectAnimator anim = new ObjectAnimator(target, property);
        anim.setFloatValues(values);
        return anim;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.240 -0400", hash_original_method = "DE1B2BCCD3B55E7FACB214B3EF8522F8", hash_generated_method = "ABB9422B750CE62A42A7A36B491E4432")
    public static ObjectAnimator ofObject(Object target, String propertyName,
            TypeEvaluator evaluator, Object... values) {
        ObjectAnimator anim = new ObjectAnimator(target, propertyName);
        anim.setObjectValues(values);
        anim.setEvaluator(evaluator);
        return anim;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.240 -0400", hash_original_method = "A3562473E9653FEFB811E30D98967954", hash_generated_method = "A48DF7E89BD5C246EBA60B61F777BC0D")
    public static <T, V> ObjectAnimator ofObject(T target, Property<T, V> property,
            TypeEvaluator<V> evaluator, V... values) {
        ObjectAnimator anim = new ObjectAnimator(target, property);
        anim.setObjectValues(values);
        anim.setEvaluator(evaluator);
        return anim;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.241 -0400", hash_original_method = "319D9FA5F10AFC0CE6C0218CC418C7B4", hash_generated_method = "54975663517FB18AE3E5D5817FD53889")
    public static ObjectAnimator ofPropertyValuesHolder(Object target,
            PropertyValuesHolder... values) {
        ObjectAnimator anim = new ObjectAnimator();
        anim.mTarget = target;
        anim.setValues(values);
        return anim;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.241 -0400", hash_original_method = "5C1AD477A95BE17D3D6636E100CB747E", hash_generated_method = "0730A0C8BDD8EF65B81A3156611D21F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setIntValues(int... values) {
        dsTaint.addTaint(values);
        {
            {
                setValues(PropertyValuesHolder.ofInt(mProperty, values));
            } //End block
            {
                setValues(PropertyValuesHolder.ofInt(mPropertyName, values));
            } //End block
        } //End block
        {
            super.setIntValues(values);
        } //End block
        // ---------- Original Method ----------
        //if (mValues == null || mValues.length == 0) {
            //if (mProperty != null) {
                //setValues(PropertyValuesHolder.ofInt(mProperty, values));
            //} else {
                //setValues(PropertyValuesHolder.ofInt(mPropertyName, values));
            //}
        //} else {
            //super.setIntValues(values);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.242 -0400", hash_original_method = "BECFA01C089C05BCDFA6C4149CD77C82", hash_generated_method = "67DF20F667B31DBEB9203AAF7664DCBD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setFloatValues(float... values) {
        dsTaint.addTaint(values);
        {
            {
                setValues(PropertyValuesHolder.ofFloat(mProperty, values));
            } //End block
            {
                setValues(PropertyValuesHolder.ofFloat(mPropertyName, values));
            } //End block
        } //End block
        {
            super.setFloatValues(values);
        } //End block
        // ---------- Original Method ----------
        //if (mValues == null || mValues.length == 0) {
            //if (mProperty != null) {
                //setValues(PropertyValuesHolder.ofFloat(mProperty, values));
            //} else {
                //setValues(PropertyValuesHolder.ofFloat(mPropertyName, values));
            //}
        //} else {
            //super.setFloatValues(values);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.243 -0400", hash_original_method = "B3827B31EA19B66EB767F4A848C1D3E5", hash_generated_method = "E4881A3C8215AD47875C1BBF9B9817BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setObjectValues(Object... values) {
        dsTaint.addTaint(values[0].dsTaint);
        {
            {
                setValues(PropertyValuesHolder.ofObject(mProperty, (TypeEvaluator)null, values));
            } //End block
            {
                setValues(PropertyValuesHolder.ofObject(mPropertyName, (TypeEvaluator)null, values));
            } //End block
        } //End block
        {
            super.setObjectValues(values);
        } //End block
        // ---------- Original Method ----------
        //if (mValues == null || mValues.length == 0) {
            //if (mProperty != null) {
                //setValues(PropertyValuesHolder.ofObject(mProperty, (TypeEvaluator)null, values));
            //} else {
                //setValues(PropertyValuesHolder.ofObject(mPropertyName, (TypeEvaluator)null, values));
            //}
        //} else {
            //super.setObjectValues(values);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.244 -0400", hash_original_method = "56CCF5D2849A2C2A18C16A03F4D35824", hash_generated_method = "E10395CDB63EE1E703693E0088375831")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void start() {
        {
            Log.d("ObjectAnimator", "Anim target, duration: " + mTarget + ", " + getDuration());
            {
                int i;
                i = 0;
                {
                    PropertyValuesHolder pvh;
                    pvh = mValues[i];
                    ArrayList<Keyframe> keyframes;
                    keyframes = pvh.mKeyframeSet.mKeyframes;
                    Log.d("ObjectAnimator", "   Values[" + i + "]: " +
                    pvh.getPropertyName() + ", " + keyframes.get(0).getValue() + ", " +
                    keyframes.get(pvh.mKeyframeSet.mNumKeyframes - 1).getValue());
                } //End block
            } //End collapsed parenthetic
        } //End block
        super.start();
        // ---------- Original Method ----------
        //if (DBG) {
            //Log.d("ObjectAnimator", "Anim target, duration: " + mTarget + ", " + getDuration());
            //for (int i = 0; i < mValues.length; ++i) {
                //PropertyValuesHolder pvh = mValues[i];
                //ArrayList<Keyframe> keyframes = pvh.mKeyframeSet.mKeyframes;
                //Log.d("ObjectAnimator", "   Values[" + i + "]: " +
                    //pvh.getPropertyName() + ", " + keyframes.get(0).getValue() + ", " +
                    //keyframes.get(pvh.mKeyframeSet.mNumKeyframes - 1).getValue());
            //}
        //}
        //super.start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.245 -0400", hash_original_method = "58C84EAE8A6F0E173B983D834F02804C", hash_generated_method = "CF3A25D4C5197BB0E874180FCD49B896")
    @DSModeled(DSC.SAFE)
    @Override
     void initAnimation() {
        {
            int numValues;
            numValues = mValues.length;
            {
                int i;
                i = 0;
                {
                    mValues[i].setupSetterAndGetter(mTarget);
                } //End block
            } //End collapsed parenthetic
            super.initAnimation();
        } //End block
        // ---------- Original Method ----------
        //if (!mInitialized) {
            //int numValues = mValues.length;
            //for (int i = 0; i < numValues; ++i) {
                //mValues[i].setupSetterAndGetter(mTarget);
            //}
            //super.initAnimation();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.246 -0400", hash_original_method = "954A06F8CA33C0A594F77D3B920078B4", hash_generated_method = "93A94D160957A92269F5F65859FB2B84")
    @DSModeled(DSC.SAFE)
    @Override
    public ObjectAnimator setDuration(long duration) {
        dsTaint.addTaint(duration);
        super.setDuration(duration);
        return (ObjectAnimator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //super.setDuration(duration);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.246 -0400", hash_original_method = "AF1F3CF2C666AC410BA38EDE7AFA44BA", hash_generated_method = "35BB9D7971ED8DBE35F11A705375AF23")
    @DSModeled(DSC.SAFE)
    public Object getTarget() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mTarget;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.247 -0400", hash_original_method = "08B359BFA7826C6DC05DFFE8229162D4", hash_generated_method = "D6BF277CD6B7F8EBE847D2841D07B8F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setTarget(Object target) {
        dsTaint.addTaint(target.dsTaint);
        {
            final Object oldTarget;
            oldTarget = mTarget;
            {
                boolean var2C98E48E4B4F691EA736E0E5C65FA038_525405655 = (oldTarget != null && target != null && oldTarget.getClass() == target.getClass());
            } //End collapsed parenthetic
            mInitialized = false;
        } //End block
        // ---------- Original Method ----------
        //if (mTarget != target) {
            //final Object oldTarget = mTarget;
            //mTarget = target;
            //if (oldTarget != null && target != null && oldTarget.getClass() == target.getClass()) {
                //return;
            //}
            //mInitialized = false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.248 -0400", hash_original_method = "E0694B6EB6C164E3B15E1A0481C3ED42", hash_generated_method = "3959AC99805ADC47040023A4D48A25EF")
    @DSModeled(DSC.SAFE)
    @Override
    public void setupStartValues() {
        initAnimation();
        int numValues;
        numValues = mValues.length;
        {
            int i;
            i = 0;
            {
                mValues[i].setupStartValue(mTarget);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //initAnimation();
        //int numValues = mValues.length;
        //for (int i = 0; i < numValues; ++i) {
            //mValues[i].setupStartValue(mTarget);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.248 -0400", hash_original_method = "92466FCD37C3DD1F8AE0CEC84015AF5E", hash_generated_method = "324295B55DA5CCC552B3A08B19381399")
    @DSModeled(DSC.SAFE)
    @Override
    public void setupEndValues() {
        initAnimation();
        int numValues;
        numValues = mValues.length;
        {
            int i;
            i = 0;
            {
                mValues[i].setupEndValue(mTarget);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //initAnimation();
        //int numValues = mValues.length;
        //for (int i = 0; i < numValues; ++i) {
            //mValues[i].setupEndValue(mTarget);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.249 -0400", hash_original_method = "4BDD5FFF3171B4A6B3EE2F328E3988FB", hash_generated_method = "C2961606A652CEFEBB9E5A8414AEE7D9")
    @DSModeled(DSC.SAFE)
    @Override
     void animateValue(float fraction) {
        dsTaint.addTaint(fraction);
        super.animateValue(fraction);
        int numValues;
        numValues = mValues.length;
        {
            int i;
            i = 0;
            {
                mValues[i].setAnimatedValue(mTarget);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.animateValue(fraction);
        //int numValues = mValues.length;
        //for (int i = 0; i < numValues; ++i) {
            //mValues[i].setAnimatedValue(mTarget);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.250 -0400", hash_original_method = "90D327822AEC361513F70606A9AC65F7", hash_generated_method = "EA696CD23F0A1AAE8EF161C6A604839E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ObjectAnimator clone() {
        final ObjectAnimator anim;
        anim = (ObjectAnimator) super.clone();
        return (ObjectAnimator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final ObjectAnimator anim = (ObjectAnimator) super.clone();
        //return anim;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.250 -0400", hash_original_method = "0AD6D5BD218B220E887BD38666E44260", hash_generated_method = "042D6836A338D97C95EF200CE8711B0C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String returnVal;
        returnVal = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " +
            mTarget;
        {
            {
                int i;
                i = 0;
                {
                    returnVal += "\n    " + mValues[i].toString();
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String returnVal = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " +
            //mTarget;
        //if (mValues != null) {
            //for (int i = 0; i < mValues.length; ++i) {
                //returnVal += "\n    " + mValues[i].toString();
            //}
        //}
        //return returnVal;
    }

    
}


