package android.animation;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.Log;
import android.util.Property;
import java.lang.reflect.Method;
import java.util.ArrayList;

public final class ObjectAnimator extends ValueAnimator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.936 -0400", hash_original_field = "562619214306F5C11A815E975B7D2477", hash_generated_field = "532AA6353374D87021D18089A8C99282")

    private Object mTarget;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.937 -0400", hash_original_field = "AFC1281EACDFDDEC758551A3AAE3876C", hash_generated_field = "A5D083978DF1D40FFF516AEB84BBF3F8")

    private String mPropertyName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.937 -0400", hash_original_field = "3BE74FBBD7FF163511D9CBD518CBA4A5", hash_generated_field = "17ADCF9554A0CCEDE828D4C3909FCAFB")

    private Property mProperty;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.938 -0400", hash_original_method = "C409E7B2E0E9411E53B94F67FBBD17CB", hash_generated_method = "3F67C7C40A1D89645B17D105E342199D")
    public  ObjectAnimator() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.940 -0400", hash_original_method = "72D05C8CED3E11A756BC68866B4296D0", hash_generated_method = "908359367A860F063D504A9A990778EC")
    private  ObjectAnimator(Object target, String propertyName) {
        addTaint(propertyName.getTaint());
        mTarget = target;
        setPropertyName(propertyName);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.942 -0400", hash_original_method = "F7624EC0BC93A299A0815B7F750DA685", hash_generated_method = "B706FB603085445093D29E8EBDAC0467")
    private <T>  ObjectAnimator(T target, Property<T, ?> property) {
        addTaint(property.getTaint());
        mTarget = target;
        setProperty(property);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.944 -0400", hash_original_method = "9BD9C177E2BB2F7D9011362061D59F72", hash_generated_method = "260112EC428DA08DA01EAD5129EE7154")
    public void setPropertyName(String propertyName) {
    if(mValues != null)        
        {
            PropertyValuesHolder valuesHolder = mValues[0];
            String oldName = valuesHolder.getPropertyName();
            valuesHolder.setPropertyName(propertyName);
            mValuesMap.remove(oldName);
            mValuesMap.put(propertyName, valuesHolder);
        } 
        mPropertyName = propertyName;
        mInitialized = false;
        
        
            
            
            
            
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.946 -0400", hash_original_method = "B6C27508DB7D8F3AB8749306282F7776", hash_generated_method = "854DC1A8D0E899A149A9FDE8C1BD11A5")
    public void setProperty(Property property) {
    if(mValues != null)        
        {
            PropertyValuesHolder valuesHolder = mValues[0];
            String oldName = valuesHolder.getPropertyName();
            valuesHolder.setProperty(property);
            mValuesMap.remove(oldName);
            mValuesMap.put(mPropertyName, valuesHolder);
        } 
    if(mProperty != null)        
        {
            mPropertyName = property.getName();
        } 
        mProperty = property;
        mInitialized = false;
        
        
            
            
            
            
            
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.948 -0400", hash_original_method = "53B20749B4CEAC5C134A85897865D0FE", hash_generated_method = "389B7E0BCD83456AA72BE6EB66EA5352")
    public String getPropertyName() {
String varA94EBE08267F8B14AA5B485C2D24900F_759312971 =         mPropertyName;
        varA94EBE08267F8B14AA5B485C2D24900F_759312971.addTaint(taint);
        return varA94EBE08267F8B14AA5B485C2D24900F_759312971;
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.960 -0400", hash_original_method = "5C1AD477A95BE17D3D6636E100CB747E", hash_generated_method = "A2518A498670DA6A6083516886558788")
    @Override
    public void setIntValues(int... values) {
        addTaint(values[0]);
    if(mValues == null || mValues.length == 0)        
        {
    if(mProperty != null)            
            {
                setValues(PropertyValuesHolder.ofInt(mProperty, values));
            } 
            else
            {
                setValues(PropertyValuesHolder.ofInt(mPropertyName, values));
            } 
        } 
        else
        {
            super.setIntValues(values);
        } 
        
        
            
                
            
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.968 -0400", hash_original_method = "BECFA01C089C05BCDFA6C4149CD77C82", hash_generated_method = "F11EEB7EEE700EAB889D811A0AB2EAC3")
    @Override
    public void setFloatValues(float... values) {
        addTaint(values[0]);
    if(mValues == null || mValues.length == 0)        
        {
    if(mProperty != null)            
            {
                setValues(PropertyValuesHolder.ofFloat(mProperty, values));
            } 
            else
            {
                setValues(PropertyValuesHolder.ofFloat(mPropertyName, values));
            } 
        } 
        else
        {
            super.setFloatValues(values);
        } 
        
        
            
                
            
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.973 -0400", hash_original_method = "B3827B31EA19B66EB767F4A848C1D3E5", hash_generated_method = "950AC66856418FDB38DC9565E926B5EB")
    @Override
    public void setObjectValues(Object... values) {
        addTaint(values[0].getTaint());
    if(mValues == null || mValues.length == 0)        
        {
    if(mProperty != null)            
            {
                setValues(PropertyValuesHolder.ofObject(mProperty, (TypeEvaluator)null, values));
            } 
            else
            {
                setValues(PropertyValuesHolder.ofObject(mPropertyName, (TypeEvaluator)null, values));
            } 
        } 
        else
        {
            super.setObjectValues(values);
        } 
        
        
            
                
            
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.998 -0400", hash_original_method = "56CCF5D2849A2C2A18C16A03F4D35824", hash_generated_method = "0014A7331BCE921B4A8704507B58D908")
    @Override
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
            } 
        } 
        super.start();
        
        
            
            
                
                
                
                    
                    
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.000 -0400", hash_original_method = "58C84EAE8A6F0E173B983D834F02804C", hash_generated_method = "C7C35DA9F90DCDD60FB7CE95ED590157")
    @Override
     void initAnimation() {
    if(!mInitialized)        
        {
            int numValues = mValues.length;
for(int i = 0;i < numValues;++i)
            {
                mValues[i].setupSetterAndGetter(mTarget);
            } 
            super.initAnimation();
        } 
        
        
            
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.002 -0400", hash_original_method = "954A06F8CA33C0A594F77D3B920078B4", hash_generated_method = "9726CF1A1E913A5448CEDBD5C7E6FFA3")
    @Override
    public ObjectAnimator setDuration(long duration) {
        addTaint(duration);
        super.setDuration(duration);
ObjectAnimator var72A74007B2BE62B849F475C7BDA4658B_278617228 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_278617228.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_278617228;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.004 -0400", hash_original_method = "AF1F3CF2C666AC410BA38EDE7AFA44BA", hash_generated_method = "3355C1B10B1B086F9616DF4970CB92C2")
    public Object getTarget() {
Object var1FC339B2A7C7BA226929CA8B7CC3A063_2081998238 =         mTarget;
        var1FC339B2A7C7BA226929CA8B7CC3A063_2081998238.addTaint(taint);
        return var1FC339B2A7C7BA226929CA8B7CC3A063_2081998238;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.006 -0400", hash_original_method = "08B359BFA7826C6DC05DFFE8229162D4", hash_generated_method = "37BA95BE3D8E62D7B3562752DBFCB34C")
    @Override
    public void setTarget(Object target) {
    if(mTarget != target)        
        {
            final Object oldTarget = mTarget;
            mTarget = target;
    if(oldTarget != null && target != null && oldTarget.getClass() == target.getClass())            
            {
                return;
            } 
            mInitialized = false;
        } 
        
        
            
            
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.016 -0400", hash_original_method = "E0694B6EB6C164E3B15E1A0481C3ED42", hash_generated_method = "767C9B1E7A14D1E2091F1EF0AE99A79A")
    @Override
    public void setupStartValues() {
        initAnimation();
        int numValues = mValues.length;
for(int i = 0;i < numValues;++i)
        {
            mValues[i].setupStartValue(mTarget);
        } 
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.020 -0400", hash_original_method = "92466FCD37C3DD1F8AE0CEC84015AF5E", hash_generated_method = "E004FAA27C7A53EB1015D719F05368FE")
    @Override
    public void setupEndValues() {
        initAnimation();
        int numValues = mValues.length;
for(int i = 0;i < numValues;++i)
        {
            mValues[i].setupEndValue(mTarget);
        } 
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.022 -0400", hash_original_method = "4BDD5FFF3171B4A6B3EE2F328E3988FB", hash_generated_method = "116C8CCA3973AA532C453CB7EC83692C")
    @Override
     void animateValue(float fraction) {
        addTaint(fraction);
        super.animateValue(fraction);
        int numValues = mValues.length;
for(int i = 0;i < numValues;++i)
        {
            mValues[i].setAnimatedValue(mTarget);
        } 
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.026 -0400", hash_original_method = "90D327822AEC361513F70606A9AC65F7", hash_generated_method = "F501BA936EAA5969D4CF12C3F5214B29")
    @Override
    public ObjectAnimator clone() {
        final ObjectAnimator anim = (ObjectAnimator) super.clone();
ObjectAnimator var6E2178F33F884BED37C5DEBCD18F9A96_1734813386 =         anim;
        var6E2178F33F884BED37C5DEBCD18F9A96_1734813386.addTaint(taint);
        return var6E2178F33F884BED37C5DEBCD18F9A96_1734813386;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.030 -0400", hash_original_method = "0AD6D5BD218B220E887BD38666E44260", hash_generated_method = "485A1517C53C8AB0F0575FE7FABD94EB")
    @Override
    public String toString() {
        String returnVal = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " +
            mTarget;
    if(mValues != null)        
        {
for(int i = 0;i < mValues.length;++i)
            {
                returnVal += "\n    " + mValues[i].toString();
            } 
        } 
String var74D8482D05AF02514EABC315066E6806_172906539 =         returnVal;
        var74D8482D05AF02514EABC315066E6806_172906539.addTaint(taint);
        return var74D8482D05AF02514EABC315066E6806_172906539;
        
        
            
        
            
                
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.031 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
}

