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
    private Object mTarget;
    private String mPropertyName;
    private Property mProperty;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.683 -0400", hash_original_method = "C409E7B2E0E9411E53B94F67FBBD17CB", hash_generated_method = "3F67C7C40A1D89645B17D105E342199D")
    @DSModeled(DSC.SAFE)
    public ObjectAnimator() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.684 -0400", hash_original_method = "72D05C8CED3E11A756BC68866B4296D0", hash_generated_method = "ED4DF055B466351B22407118D0106EB1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ObjectAnimator(Object target, String propertyName) {
        dsTaint.addTaint(propertyName);
        dsTaint.addTaint(target.dsTaint);
        setPropertyName(propertyName);
        // ---------- Original Method ----------
        //mTarget = target;
        //setPropertyName(propertyName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.694 -0400", hash_original_method = "F7624EC0BC93A299A0815B7F750DA685", hash_generated_method = "4A487AD9C12B13730B3003E744749DB3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private <T> ObjectAnimator(T target, Property<T, ?> property) {
        dsTaint.addTaint(target.dsTaint);
        dsTaint.addTaint(property.dsTaint);
        setProperty(property);
        // ---------- Original Method ----------
        //mTarget = target;
        //setProperty(property);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.695 -0400", hash_original_method = "9BD9C177E2BB2F7D9011362061D59F72", hash_generated_method = "124B980D3EE3B01C8688117A9F4DA1A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.697 -0400", hash_original_method = "B6C27508DB7D8F3AB8749306282F7776", hash_generated_method = "C1C90D13A8B74CBFBE7447DBFE847553")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.697 -0400", hash_original_method = "53B20749B4CEAC5C134A85897865D0FE", hash_generated_method = "19C243F0DAD668218C8EB3848FFD0192")
    @DSModeled(DSC.SAFE)
    public String getPropertyName() {
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.711 -0400", hash_original_method = "5C1AD477A95BE17D3D6636E100CB747E", hash_generated_method = "791501B1A27923744BA5CA2B9A487F76")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setIntValues(int... values) {
        dsTaint.addTaint(values[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.712 -0400", hash_original_method = "BECFA01C089C05BCDFA6C4149CD77C82", hash_generated_method = "97623658C1B3593594C208FAB342B588")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setFloatValues(float... values) {
        dsTaint.addTaint(values[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.714 -0400", hash_original_method = "B3827B31EA19B66EB767F4A848C1D3E5", hash_generated_method = "9A5A2093ECFA311234AFE7E4D9B18934")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.716 -0400", hash_original_method = "56CCF5D2849A2C2A18C16A03F4D35824", hash_generated_method = "7DF663F09394BFEA548F149051E152C2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.718 -0400", hash_original_method = "58C84EAE8A6F0E173B983D834F02804C", hash_generated_method = "137E5821CE786116C4E689E86268E952")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.726 -0400", hash_original_method = "954A06F8CA33C0A594F77D3B920078B4", hash_generated_method = "E03FBB9CE719868D13CA68C8E157727B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ObjectAnimator setDuration(long duration) {
        dsTaint.addTaint(duration);
        super.setDuration(duration);
        return (ObjectAnimator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //super.setDuration(duration);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.728 -0400", hash_original_method = "AF1F3CF2C666AC410BA38EDE7AFA44BA", hash_generated_method = "A5826E8CD3491E5B2736AD8217A05D25")
    @DSModeled(DSC.SAFE)
    public Object getTarget() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mTarget;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.730 -0400", hash_original_method = "08B359BFA7826C6DC05DFFE8229162D4", hash_generated_method = "369AA5A618F4D2D3A4B08FB7AE621536")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setTarget(Object target) {
        dsTaint.addTaint(target.dsTaint);
        {
            Object oldTarget;
            oldTarget = mTarget;
            {
                boolean var2C98E48E4B4F691EA736E0E5C65FA038_912846296 = (oldTarget != null && target != null && oldTarget.getClass() == target.getClass());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.731 -0400", hash_original_method = "E0694B6EB6C164E3B15E1A0481C3ED42", hash_generated_method = "CAC2CEBA4DB9FB2A9C9011854DF1B925")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.742 -0400", hash_original_method = "92466FCD37C3DD1F8AE0CEC84015AF5E", hash_generated_method = "73FCB81C2A7805EB8C979D166B750567")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.743 -0400", hash_original_method = "4BDD5FFF3171B4A6B3EE2F328E3988FB", hash_generated_method = "F4257CAD5420C96863DF40C2D91D61AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.744 -0400", hash_original_method = "90D327822AEC361513F70606A9AC65F7", hash_generated_method = "327B7C0483956276F8E273AB7615615B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ObjectAnimator clone() {
        ObjectAnimator anim;
        anim = (ObjectAnimator) super.clone();
        return (ObjectAnimator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final ObjectAnimator anim = (ObjectAnimator) super.clone();
        //return anim;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:32.745 -0400", hash_original_method = "0AD6D5BD218B220E887BD38666E44260", hash_generated_method = "2919ADA2E69FF29C6392F0FB13A21FD6")
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

    
    private static final boolean DBG = false;
}

