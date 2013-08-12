package android.animation;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.ArrayList;

import android.util.Log;
import android.util.Property;





public final class ObjectAnimator extends ValueAnimator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.420 -0400", hash_original_field = "562619214306F5C11A815E975B7D2477", hash_generated_field = "532AA6353374D87021D18089A8C99282")

    private Object mTarget;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.420 -0400", hash_original_field = "AFC1281EACDFDDEC758551A3AAE3876C", hash_generated_field = "A5D083978DF1D40FFF516AEB84BBF3F8")

    private String mPropertyName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.420 -0400", hash_original_field = "3BE74FBBD7FF163511D9CBD518CBA4A5", hash_generated_field = "17ADCF9554A0CCEDE828D4C3909FCAFB")

    private Property mProperty;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.421 -0400", hash_original_method = "C409E7B2E0E9411E53B94F67FBBD17CB", hash_generated_method = "3F67C7C40A1D89645B17D105E342199D")
    @DSModeled(DSC.SAFE)
    public  ObjectAnimator() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.423 -0400", hash_original_method = "72D05C8CED3E11A756BC68866B4296D0", hash_generated_method = "908359367A860F063D504A9A990778EC")
    private  ObjectAnimator(Object target, String propertyName) {
        addTaint(propertyName.getTaint());
        mTarget = target;
        setPropertyName(propertyName);
        // ---------- Original Method ----------
        //mTarget = target;
        //setPropertyName(propertyName);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.425 -0400", hash_original_method = "F7624EC0BC93A299A0815B7F750DA685", hash_generated_method = "B706FB603085445093D29E8EBDAC0467")
    private <T>  ObjectAnimator(T target, Property<T, ?> property) {
        addTaint(property.getTaint());
        mTarget = target;
        setProperty(property);
        // ---------- Original Method ----------
        //mTarget = target;
        //setProperty(property);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.429 -0400", hash_original_method = "9BD9C177E2BB2F7D9011362061D59F72", hash_generated_method = "260112EC428DA08DA01EAD5129EE7154")
    @DSModeled(DSC.SAFE)
    public void setPropertyName(String propertyName) {
        if(mValues != null)        
        {
            PropertyValuesHolder valuesHolder = mValues[0];
            String oldName = valuesHolder.getPropertyName();
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.432 -0400", hash_original_method = "B6C27508DB7D8F3AB8749306282F7776", hash_generated_method = "854DC1A8D0E899A149A9FDE8C1BD11A5")
    public void setProperty(Property property) {
        if(mValues != null)        
        {
            PropertyValuesHolder valuesHolder = mValues[0];
            String oldName = valuesHolder.getPropertyName();
            valuesHolder.setProperty(property);
            mValuesMap.remove(oldName);
            mValuesMap.put(mPropertyName, valuesHolder);
        } //End block
        if(mProperty != null)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.434 -0400", hash_original_method = "53B20749B4CEAC5C134A85897865D0FE", hash_generated_method = "21EDBCA4490BCDCA3F0DC4EE28CD5C0C")
    public String getPropertyName() {
String varA94EBE08267F8B14AA5B485C2D24900F_1015137819 =         mPropertyName;
        varA94EBE08267F8B14AA5B485C2D24900F_1015137819.addTaint(taint);
        return varA94EBE08267F8B14AA5B485C2D24900F_1015137819;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.445 -0400", hash_original_method = "5C1AD477A95BE17D3D6636E100CB747E", hash_generated_method = "A2518A498670DA6A6083516886558788")
    @Override
    @DSModeled(DSC.SAFE)
    public void setIntValues(int... values) {
        addTaint(values[0]);
        if(mValues == null || mValues.length == 0)        
        {
            if(mProperty != null)            
            {
                setValues(PropertyValuesHolder.ofInt(mProperty, values));
            } //End block
            else
            {
                setValues(PropertyValuesHolder.ofInt(mPropertyName, values));
            } //End block
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.448 -0400", hash_original_method = "BECFA01C089C05BCDFA6C4149CD77C82", hash_generated_method = "F11EEB7EEE700EAB889D811A0AB2EAC3")
    @Override
    @DSModeled(DSC.SAFE)
    public void setFloatValues(float... values) {
        addTaint(values[0]);
        if(mValues == null || mValues.length == 0)        
        {
            if(mProperty != null)            
            {
                setValues(PropertyValuesHolder.ofFloat(mProperty, values));
            } //End block
            else
            {
                setValues(PropertyValuesHolder.ofFloat(mPropertyName, values));
            } //End block
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.457 -0400", hash_original_method = "B3827B31EA19B66EB767F4A848C1D3E5", hash_generated_method = "950AC66856418FDB38DC9565E926B5EB")
    @Override
    public void setObjectValues(Object... values) {
        addTaint(values[0].getTaint());
        if(mValues == null || mValues.length == 0)        
        {
            if(mProperty != null)            
            {
                setValues(PropertyValuesHolder.ofObject(mProperty, (TypeEvaluator)null, values));
            } //End block
            else
            {
                setValues(PropertyValuesHolder.ofObject(mPropertyName, (TypeEvaluator)null, values));
            } //End block
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.461 -0400", hash_original_method = "56CCF5D2849A2C2A18C16A03F4D35824", hash_generated_method = "0014A7331BCE921B4A8704507B58D908")
    @Override
    @DSModeled(DSC.SAFE)
    public void start() {
        if(DBG)        
        {
            Log.d("ObjectAnimator", "Anim target, duration: " + mTarget + ", " + getDuration());
for(int i = 0;i < mValues.length;++i)
            {
                PropertyValuesHolder pvh = mValues[i];
                ArrayList<Keyframe> keyframes = pvh.mKeyframeSet.mKeyframes;
                Log.d("ObjectAnimator", "   Values[" + i + "]: " +
                    pvh.getPropertyName() + ", " + keyframes.get(0).getValue() + ", " +
                    keyframes.get(pvh.mKeyframeSet.mNumKeyframes - 1).getValue());
            } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.464 -0400", hash_original_method = "58C84EAE8A6F0E173B983D834F02804C", hash_generated_method = "C7C35DA9F90DCDD60FB7CE95ED590157")
    @Override
     void initAnimation() {
        if(!mInitialized)        
        {
            int numValues = mValues.length;
for(int i = 0;i < numValues;++i)
            {
                mValues[i].setupSetterAndGetter(mTarget);
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.467 -0400", hash_original_method = "954A06F8CA33C0A594F77D3B920078B4", hash_generated_method = "1CF7636CBC70F582E2F8618E77519FE3")
    @Override
    @DSModeled(DSC.SAFE)
    public ObjectAnimator setDuration(long duration) {
        addTaint(duration);
        super.setDuration(duration);
ObjectAnimator var72A74007B2BE62B849F475C7BDA4658B_1833458887 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1833458887.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1833458887;
        // ---------- Original Method ----------
        //super.setDuration(duration);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.469 -0400", hash_original_method = "AF1F3CF2C666AC410BA38EDE7AFA44BA", hash_generated_method = "D9E04E344C43396C9C8E50B48EF574C8")
    public Object getTarget() {
Object var1FC339B2A7C7BA226929CA8B7CC3A063_1704531941 =         mTarget;
        var1FC339B2A7C7BA226929CA8B7CC3A063_1704531941.addTaint(taint);
        return var1FC339B2A7C7BA226929CA8B7CC3A063_1704531941;
        // ---------- Original Method ----------
        //return mTarget;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.472 -0400", hash_original_method = "08B359BFA7826C6DC05DFFE8229162D4", hash_generated_method = "37BA95BE3D8E62D7B3562752DBFCB34C")
    @Override
    @DSModeled(DSC.SAFE)
    public void setTarget(Object target) {
        if(mTarget != target)        
        {
            final Object oldTarget = mTarget;
            mTarget = target;
            if(oldTarget != null && target != null && oldTarget.getClass() == target.getClass())            
            {
                return;
            } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.475 -0400", hash_original_method = "E0694B6EB6C164E3B15E1A0481C3ED42", hash_generated_method = "767C9B1E7A14D1E2091F1EF0AE99A79A")
    @Override
    public void setupStartValues() {
        initAnimation();
        int numValues = mValues.length;
for(int i = 0;i < numValues;++i)
        {
            mValues[i].setupStartValue(mTarget);
        } //End block
        // ---------- Original Method ----------
        //initAnimation();
        //int numValues = mValues.length;
        //for (int i = 0; i < numValues; ++i) {
            //mValues[i].setupStartValue(mTarget);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.479 -0400", hash_original_method = "92466FCD37C3DD1F8AE0CEC84015AF5E", hash_generated_method = "E004FAA27C7A53EB1015D719F05368FE")
    @Override
    public void setupEndValues() {
        initAnimation();
        int numValues = mValues.length;
for(int i = 0;i < numValues;++i)
        {
            mValues[i].setupEndValue(mTarget);
        } //End block
        // ---------- Original Method ----------
        //initAnimation();
        //int numValues = mValues.length;
        //for (int i = 0; i < numValues; ++i) {
            //mValues[i].setupEndValue(mTarget);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.482 -0400", hash_original_method = "4BDD5FFF3171B4A6B3EE2F328E3988FB", hash_generated_method = "116C8CCA3973AA532C453CB7EC83692C")
    @Override
     void animateValue(float fraction) {
        addTaint(fraction);
        super.animateValue(fraction);
        int numValues = mValues.length;
for(int i = 0;i < numValues;++i)
        {
            mValues[i].setAnimatedValue(mTarget);
        } //End block
        // ---------- Original Method ----------
        //super.animateValue(fraction);
        //int numValues = mValues.length;
        //for (int i = 0; i < numValues; ++i) {
            //mValues[i].setAnimatedValue(mTarget);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.486 -0400", hash_original_method = "90D327822AEC361513F70606A9AC65F7", hash_generated_method = "83DA70629275C895463B7B68DFEF25ED")
    @Override
    public ObjectAnimator clone() {
        final ObjectAnimator anim = (ObjectAnimator) super.clone();
ObjectAnimator var6E2178F33F884BED37C5DEBCD18F9A96_1966573763 =         anim;
        var6E2178F33F884BED37C5DEBCD18F9A96_1966573763.addTaint(taint);
        return var6E2178F33F884BED37C5DEBCD18F9A96_1966573763;
        // ---------- Original Method ----------
        //final ObjectAnimator anim = (ObjectAnimator) super.clone();
        //return anim;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.489 -0400", hash_original_method = "0AD6D5BD218B220E887BD38666E44260", hash_generated_method = "A50BE9EFC68F73413A11928C26CCC663")
    @Override
    public String toString() {
        String returnVal = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " +
            mTarget;
        if(mValues != null)        
        {
for(int i = 0;i < mValues.length;++i)
            {
                returnVal += "\n    " + mValues[i].toString();
            } //End block
        } //End block
String var74D8482D05AF02514EABC315066E6806_1991356935 =         returnVal;
        var74D8482D05AF02514EABC315066E6806_1991356935.addTaint(taint);
        return var74D8482D05AF02514EABC315066E6806_1991356935;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:15.491 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
}

