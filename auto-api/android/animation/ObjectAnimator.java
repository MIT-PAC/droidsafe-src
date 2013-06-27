package android.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Log;
import android.util.Property;
import java.lang.reflect.Method;
import java.util.ArrayList;

public final class ObjectAnimator extends ValueAnimator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.339 -0400", hash_original_field = "562619214306F5C11A815E975B7D2477", hash_generated_field = "532AA6353374D87021D18089A8C99282")

    private Object mTarget;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.340 -0400", hash_original_field = "AFC1281EACDFDDEC758551A3AAE3876C", hash_generated_field = "A5D083978DF1D40FFF516AEB84BBF3F8")

    private String mPropertyName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.341 -0400", hash_original_field = "3BE74FBBD7FF163511D9CBD518CBA4A5", hash_generated_field = "17ADCF9554A0CCEDE828D4C3909FCAFB")

    private Property mProperty;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.354 -0400", hash_original_method = "C409E7B2E0E9411E53B94F67FBBD17CB", hash_generated_method = "3F67C7C40A1D89645B17D105E342199D")
    public  ObjectAnimator() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.366 -0400", hash_original_method = "72D05C8CED3E11A756BC68866B4296D0", hash_generated_method = "1D81765CF4A12858856FB023F952261D")
    private  ObjectAnimator(Object target, String propertyName) {
        mTarget = target;
        setPropertyName(propertyName);
        addTaint(propertyName.getTaint());
        // ---------- Original Method ----------
        //mTarget = target;
        //setPropertyName(propertyName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.381 -0400", hash_original_method = "F7624EC0BC93A299A0815B7F750DA685", hash_generated_method = "8EE497D27CEBF0533E003D6032449D57")
    private <T>  ObjectAnimator(T target, Property<T, ?> property) {
        mTarget = target;
        setProperty(property);
        addTaint(property.getTaint());
        // ---------- Original Method ----------
        //mTarget = target;
        //setProperty(property);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.401 -0400", hash_original_method = "9BD9C177E2BB2F7D9011362061D59F72", hash_generated_method = "99078DA03E5651E86D034D895D728ACA")
    public void setPropertyName(String propertyName) {
        {
            PropertyValuesHolder valuesHolder;
            valuesHolder = mValues[0];
            String oldName;
            oldName = valuesHolder.getPropertyName();
            valuesHolder.setPropertyName(propertyName);
            mValuesMap.remove(oldName);
            mValuesMap.put(propertyName, valuesHolder);
        } //End block
        mPropertyName = propertyName;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.431 -0400", hash_original_method = "B6C27508DB7D8F3AB8749306282F7776", hash_generated_method = "CB0971919A67203EEE27E2E9E45C75C4")
    public void setProperty(Property property) {
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
        mProperty = property;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.445 -0400", hash_original_method = "53B20749B4CEAC5C134A85897865D0FE", hash_generated_method = "C89059A1D80C22DCEF9A7B4B8C21F4F8")
    public String getPropertyName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1449522580 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1449522580 = mPropertyName;
        varB4EAC82CA7396A68D541C85D26508E83_1449522580.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1449522580;
        // ---------- Original Method ----------
        //return mPropertyName;
    }

    
        public static ObjectAnimator ofInt(Object target, String propertyName, int... values) {
        ObjectAnimator anim = new ObjectAnimator(target, propertyName);
        anim.setIntValues(values);
        return anim;
    }

    
        public static <T> ObjectAnimator ofInt(T target, Property<T, Integer> property, int... values) {
        ObjectAnimator anim = new ObjectAnimator(target, property);
        anim.setIntValues(values);
        return anim;
    }

    
        public static ObjectAnimator ofFloat(Object target, String propertyName, float... values) {
        ObjectAnimator anim = new ObjectAnimator(target, propertyName);
        anim.setFloatValues(values);
        return anim;
    }

    
        public static <T> ObjectAnimator ofFloat(T target, Property<T, Float> property,
            float... values) {
        ObjectAnimator anim = new ObjectAnimator(target, property);
        anim.setFloatValues(values);
        return anim;
    }

    
        public static ObjectAnimator ofObject(Object target, String propertyName,
            TypeEvaluator evaluator, Object... values) {
        ObjectAnimator anim = new ObjectAnimator(target, propertyName);
        anim.setObjectValues(values);
        anim.setEvaluator(evaluator);
        return anim;
    }

    
        public static <T, V> ObjectAnimator ofObject(T target, Property<T, V> property,
            TypeEvaluator<V> evaluator, V... values) {
        ObjectAnimator anim = new ObjectAnimator(target, property);
        anim.setObjectValues(values);
        anim.setEvaluator(evaluator);
        return anim;
    }

    
        public static ObjectAnimator ofPropertyValuesHolder(Object target,
            PropertyValuesHolder... values) {
        ObjectAnimator anim = new ObjectAnimator();
        anim.mTarget = target;
        anim.setValues(values);
        return anim;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.510 -0400", hash_original_method = "5C1AD477A95BE17D3D6636E100CB747E", hash_generated_method = "5B6231E7C40364D96D9BA02DC89633CE")
    @Override
    public void setIntValues(int... values) {
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
        addTaint(values[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.541 -0400", hash_original_method = "BECFA01C089C05BCDFA6C4149CD77C82", hash_generated_method = "332EC15F08B57FE299D0CE6A8E5850F6")
    @Override
    public void setFloatValues(float... values) {
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
        addTaint(values[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.646 -0400", hash_original_method = "B3827B31EA19B66EB767F4A848C1D3E5", hash_generated_method = "082BB2A77203708C89F0240D87050F72")
    @Override
    public void setObjectValues(Object... values) {
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
        addTaint(values[0].getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.687 -0400", hash_original_method = "56CCF5D2849A2C2A18C16A03F4D35824", hash_generated_method = "7DF663F09394BFEA548F149051E152C2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.700 -0400", hash_original_method = "58C84EAE8A6F0E173B983D834F02804C", hash_generated_method = "137E5821CE786116C4E689E86268E952")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.738 -0400", hash_original_method = "954A06F8CA33C0A594F77D3B920078B4", hash_generated_method = "EE891EC0780080160B8C17164FC8A31D")
    @Override
    public ObjectAnimator setDuration(long duration) {
        ObjectAnimator varB4EAC82CA7396A68D541C85D26508E83_339808210 = null; //Variable for return #1
        super.setDuration(duration);
        varB4EAC82CA7396A68D541C85D26508E83_339808210 = this;
        addTaint(duration);
        varB4EAC82CA7396A68D541C85D26508E83_339808210.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_339808210;
        // ---------- Original Method ----------
        //super.setDuration(duration);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.761 -0400", hash_original_method = "AF1F3CF2C666AC410BA38EDE7AFA44BA", hash_generated_method = "5FA28DE6235887A7F6F8C84844EE72D0")
    public Object getTarget() {
        Object varB4EAC82CA7396A68D541C85D26508E83_486492395 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_486492395 = mTarget;
        varB4EAC82CA7396A68D541C85D26508E83_486492395.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_486492395;
        // ---------- Original Method ----------
        //return mTarget;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.786 -0400", hash_original_method = "08B359BFA7826C6DC05DFFE8229162D4", hash_generated_method = "4B9D4D8278ADDD66D4F634A0C5C9F8C3")
    @Override
    public void setTarget(Object target) {
        {
            Object oldTarget;
            oldTarget = mTarget;
            mTarget = target;
            {
                boolean var2C98E48E4B4F691EA736E0E5C65FA038_540565392 = (oldTarget != null && target != null && oldTarget.getClass() == target.getClass());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.803 -0400", hash_original_method = "E0694B6EB6C164E3B15E1A0481C3ED42", hash_generated_method = "CAC2CEBA4DB9FB2A9C9011854DF1B925")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.827 -0400", hash_original_method = "92466FCD37C3DD1F8AE0CEC84015AF5E", hash_generated_method = "73FCB81C2A7805EB8C979D166B750567")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.840 -0400", hash_original_method = "4BDD5FFF3171B4A6B3EE2F328E3988FB", hash_generated_method = "471191A63A87CC820196409826C0E996")
    @Override
     void animateValue(float fraction) {
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
        addTaint(fraction);
        // ---------- Original Method ----------
        //super.animateValue(fraction);
        //int numValues = mValues.length;
        //for (int i = 0; i < numValues; ++i) {
            //mValues[i].setAnimatedValue(mTarget);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.863 -0400", hash_original_method = "90D327822AEC361513F70606A9AC65F7", hash_generated_method = "804CC67C7A515566A98258B610212CD5")
    @Override
    public ObjectAnimator clone() {
        ObjectAnimator varB4EAC82CA7396A68D541C85D26508E83_1700641745 = null; //Variable for return #1
        ObjectAnimator anim;
        anim = (ObjectAnimator) super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1700641745 = anim;
        varB4EAC82CA7396A68D541C85D26508E83_1700641745.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1700641745;
        // ---------- Original Method ----------
        //final ObjectAnimator anim = (ObjectAnimator) super.clone();
        //return anim;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.875 -0400", hash_original_method = "0AD6D5BD218B220E887BD38666E44260", hash_generated_method = "A8995CC1F5307FF8644811E39E153A80")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_890503368 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_890503368 = returnVal;
        varB4EAC82CA7396A68D541C85D26508E83_890503368.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_890503368;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:35:52.877 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "B7C4E93D97D072890A37A56076D870F8")

    private static boolean DBG = false;
}

