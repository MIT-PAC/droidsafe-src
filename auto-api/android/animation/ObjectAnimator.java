package android.animation;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.util.Log;
import android.util.Property;
import java.lang.reflect.Method;
import java.util.ArrayList;

public final class ObjectAnimator extends ValueAnimator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.620 -0400", hash_original_field = "562619214306F5C11A815E975B7D2477", hash_generated_field = "532AA6353374D87021D18089A8C99282")

    private Object mTarget;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.620 -0400", hash_original_field = "AFC1281EACDFDDEC758551A3AAE3876C", hash_generated_field = "A5D083978DF1D40FFF516AEB84BBF3F8")

    private String mPropertyName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.620 -0400", hash_original_field = "3BE74FBBD7FF163511D9CBD518CBA4A5", hash_generated_field = "17ADCF9554A0CCEDE828D4C3909FCAFB")

    private Property mProperty;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.621 -0400", hash_original_method = "C409E7B2E0E9411E53B94F67FBBD17CB", hash_generated_method = "3F67C7C40A1D89645B17D105E342199D")
    public  ObjectAnimator() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.622 -0400", hash_original_method = "72D05C8CED3E11A756BC68866B4296D0", hash_generated_method = "1D81765CF4A12858856FB023F952261D")
    private  ObjectAnimator(Object target, String propertyName) {
        mTarget = target;
        setPropertyName(propertyName);
        addTaint(propertyName.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.623 -0400", hash_original_method = "F7624EC0BC93A299A0815B7F750DA685", hash_generated_method = "8EE497D27CEBF0533E003D6032449D57")
    private <T>  ObjectAnimator(T target, Property<T, ?> property) {
        mTarget = target;
        setProperty(property);
        addTaint(property.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.625 -0400", hash_original_method = "9BD9C177E2BB2F7D9011362061D59F72", hash_generated_method = "6EE4C5E62C1F9F9FE790555DB66A6541")
    public void setPropertyName(String propertyName) {
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.626 -0400", hash_original_method = "B6C27508DB7D8F3AB8749306282F7776", hash_generated_method = "46DA46ECA8149E528E26A3D896630030")
    public void setProperty(Property property) {
        {
            PropertyValuesHolder valuesHolder = mValues[0];
            String oldName = valuesHolder.getPropertyName();
            valuesHolder.setProperty(property);
            mValuesMap.remove(oldName);
            mValuesMap.put(mPropertyName, valuesHolder);
        } 
        {
            mPropertyName = property.getName();
        } 
        mProperty = property;
        mInitialized = false;
        
        
            
            
            
            
            
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.627 -0400", hash_original_method = "53B20749B4CEAC5C134A85897865D0FE", hash_generated_method = "BFDDCC1C64B103212D4FFDBA9CAF450F")
    public String getPropertyName() {
        String varB4EAC82CA7396A68D541C85D26508E83_901590770 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_901590770 = mPropertyName;
        varB4EAC82CA7396A68D541C85D26508E83_901590770.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_901590770;
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.630 -0400", hash_original_method = "5C1AD477A95BE17D3D6636E100CB747E", hash_generated_method = "5B6231E7C40364D96D9BA02DC89633CE")
    @Override
    public void setIntValues(int... values) {
        {
            {
                setValues(PropertyValuesHolder.ofInt(mProperty, values));
            } 
            {
                setValues(PropertyValuesHolder.ofInt(mPropertyName, values));
            } 
        } 
        {
            super.setIntValues(values);
        } 
        addTaint(values[0]);
        
        
            
                
            
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.631 -0400", hash_original_method = "BECFA01C089C05BCDFA6C4149CD77C82", hash_generated_method = "332EC15F08B57FE299D0CE6A8E5850F6")
    @Override
    public void setFloatValues(float... values) {
        {
            {
                setValues(PropertyValuesHolder.ofFloat(mProperty, values));
            } 
            {
                setValues(PropertyValuesHolder.ofFloat(mPropertyName, values));
            } 
        } 
        {
            super.setFloatValues(values);
        } 
        addTaint(values[0]);
        
        
            
                
            
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.633 -0400", hash_original_method = "B3827B31EA19B66EB767F4A848C1D3E5", hash_generated_method = "082BB2A77203708C89F0240D87050F72")
    @Override
    public void setObjectValues(Object... values) {
        {
            {
                setValues(PropertyValuesHolder.ofObject(mProperty, (TypeEvaluator)null, values));
            } 
            {
                setValues(PropertyValuesHolder.ofObject(mPropertyName, (TypeEvaluator)null, values));
            } 
        } 
        {
            super.setObjectValues(values);
        } 
        addTaint(values[0].getTaint());
        
        
            
                
            
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.635 -0400", hash_original_method = "56CCF5D2849A2C2A18C16A03F4D35824", hash_generated_method = "E60024947773E65864A50476AB2FC5C5")
    @Override
    public void start() {
        {
            Log.d("ObjectAnimator", "Anim target, duration: " + mTarget + ", " + getDuration());
            {
                int i = 0;
                {
                    PropertyValuesHolder pvh = mValues[i];
                    ArrayList<Keyframe> keyframes = pvh.mKeyframeSet.mKeyframes;
                    Log.d("ObjectAnimator", "   Values[" + i + "]: " +
                    pvh.getPropertyName() + ", " + keyframes.get(0).getValue() + ", " +
                    keyframes.get(pvh.mKeyframeSet.mNumKeyframes - 1).getValue());
                } 
            } 
        } 
        super.start();
        
        
            
            
                
                
                
                    
                    
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.638 -0400", hash_original_method = "58C84EAE8A6F0E173B983D834F02804C", hash_generated_method = "CBB441DB5FAC0CFA7D5980D594DAF0E2")
    @Override
     void initAnimation() {
        {
            int numValues = mValues.length;
            {
                int i = 0;
                {
                    mValues[i].setupSetterAndGetter(mTarget);
                } 
            } 
            super.initAnimation();
        } 
        
        
            
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.639 -0400", hash_original_method = "954A06F8CA33C0A594F77D3B920078B4", hash_generated_method = "4390EF41D9CEBA38E6E4081B3B078249")
    @Override
    public ObjectAnimator setDuration(long duration) {
        ObjectAnimator varB4EAC82CA7396A68D541C85D26508E83_565726242 = null; 
        super.setDuration(duration);
        varB4EAC82CA7396A68D541C85D26508E83_565726242 = this;
        addTaint(duration);
        varB4EAC82CA7396A68D541C85D26508E83_565726242.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_565726242;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.641 -0400", hash_original_method = "AF1F3CF2C666AC410BA38EDE7AFA44BA", hash_generated_method = "80BA8A52854B7B5BFCE048C5288512FD")
    public Object getTarget() {
        Object varB4EAC82CA7396A68D541C85D26508E83_487936247 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_487936247 = mTarget;
        varB4EAC82CA7396A68D541C85D26508E83_487936247.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_487936247;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.643 -0400", hash_original_method = "08B359BFA7826C6DC05DFFE8229162D4", hash_generated_method = "1DF6189AA9FB7E5536F6E046F0C7E440")
    @Override
    public void setTarget(Object target) {
        {
            final Object oldTarget = mTarget;
            mTarget = target;
            {
                boolean var2C98E48E4B4F691EA736E0E5C65FA038_184075610 = (oldTarget != null && target != null && oldTarget.getClass() == target.getClass());
            } 
            mInitialized = false;
        } 
        
        
            
            
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.645 -0400", hash_original_method = "E0694B6EB6C164E3B15E1A0481C3ED42", hash_generated_method = "845B263D0D325D058621240BBCAF7E66")
    @Override
    public void setupStartValues() {
        initAnimation();
        int numValues = mValues.length;
        {
            int i = 0;
            {
                mValues[i].setupStartValue(mTarget);
            } 
        } 
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.647 -0400", hash_original_method = "92466FCD37C3DD1F8AE0CEC84015AF5E", hash_generated_method = "7768C55949F452D76BCA537EED4C568C")
    @Override
    public void setupEndValues() {
        initAnimation();
        int numValues = mValues.length;
        {
            int i = 0;
            {
                mValues[i].setupEndValue(mTarget);
            } 
        } 
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.648 -0400", hash_original_method = "4BDD5FFF3171B4A6B3EE2F328E3988FB", hash_generated_method = "36E0A8F00C3A79872D2F1CC64D9E16EA")
    @Override
     void animateValue(float fraction) {
        super.animateValue(fraction);
        int numValues = mValues.length;
        {
            int i = 0;
            {
                mValues[i].setAnimatedValue(mTarget);
            } 
        } 
        addTaint(fraction);
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.650 -0400", hash_original_method = "90D327822AEC361513F70606A9AC65F7", hash_generated_method = "44BE608EF9F871653BB1190247987DF3")
    @Override
    public ObjectAnimator clone() {
        ObjectAnimator varB4EAC82CA7396A68D541C85D26508E83_296615539 = null; 
        final ObjectAnimator anim = (ObjectAnimator) super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_296615539 = anim;
        varB4EAC82CA7396A68D541C85D26508E83_296615539.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_296615539;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.652 -0400", hash_original_method = "0AD6D5BD218B220E887BD38666E44260", hash_generated_method = "D86A40819E32E41C974F25FF33C29EBF")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_424631953 = null; 
        String returnVal = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " +
            mTarget;
        {
            {
                int i = 0;
                {
                    returnVal += "\n    " + mValues[i].toString();
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_424631953 = returnVal;
        varB4EAC82CA7396A68D541C85D26508E83_424631953.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_424631953;
        
        
            
        
            
                
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:12.653 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
}

