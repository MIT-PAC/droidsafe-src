package android.animation;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;

import android.util.Log;
import android.util.Property;

public final class ObjectAnimator extends ValueAnimator {

    /**
     * Constructs and returns an ObjectAnimator that animates between int values. A single
     * value implies that that value is the one being animated to. Two values imply a starting
     * and ending values. More than two values imply a starting value, values to animate through
     * along the way, and an ending value (these values will be distributed evenly across
     * the duration of the animation).
     *
     * @param target The object whose property is to be animated. This object should
     * have a public method on it called <code>setName()</code>, where <code>name</code> is
     * the value of the <code>propertyName</code> parameter.
     * @param propertyName The name of the property being animated.
     * @param values A set of values that the animation will animate between over time.
     * @return An ObjectAnimator object that is set up to animate between the given values.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.559 -0500", hash_original_method = "A00631EA578020D8AF102DDB2FCEFAC8", hash_generated_method = "45A1DBE9A77A2E9820DD58C0D0247F0A")
    
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

    /**
     * Constructs and returns an ObjectAnimator that animates between float values. A single
     * value implies that that value is the one being animated to. Two values imply a starting
     * and ending values. More than two values imply a starting value, values to animate through
     * along the way, and an ending value (these values will be distributed evenly across
     * the duration of the animation).
     *
     * @param target The object whose property is to be animated. This object should
     * have a public method on it called <code>setName()</code>, where <code>name</code> is
     * the value of the <code>propertyName</code> parameter.
     * @param propertyName The name of the property being animated.
     * @param values A set of values that the animation will animate between over time.
     * @return An ObjectAnimator object that is set up to animate between the given values.
     */
    @DSComment("Animation class")
    @DSSafe(DSCat.ANDROID_ANIMATION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.564 -0500", hash_original_method = "7A2DAA3629AD92EDC2DFD0D78B3421C9", hash_generated_method = "13FDA7CA700C3F2B682BF97543D98984")
    
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

    /**
     * Constructs and returns an ObjectAnimator that animates between Object values. A single
     * value implies that that value is the one being animated to. Two values imply a starting
     * and ending values. More than two values imply a starting value, values to animate through
     * along the way, and an ending value (these values will be distributed evenly across
     * the duration of the animation).
     *
     * @param target The object whose property is to be animated. This object should
     * have a public method on it called <code>setName()</code>, where <code>name</code> is
     * the value of the <code>propertyName</code> parameter.
     * @param propertyName The name of the property being animated.
     * @param evaluator A TypeEvaluator that will be called on each animation frame to
     * provide the necessary interpolation between the Object values to derive the animated
     * value.
     * @param values A set of values that the animation will animate between over time.
     * @return An ObjectAnimator object that is set up to animate between the given values.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.569 -0500", hash_original_method = "DE1B2BCCD3B55E7FACB214B3EF8522F8", hash_generated_method = "ABB9422B750CE62A42A7A36B491E4432")
    
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

    /**
     * Constructs and returns an ObjectAnimator that animates between the sets of values specified
     * in <code>PropertyValueHolder</code> objects. This variant should be used when animating
     * several properties at once with the same ObjectAnimator, since PropertyValuesHolder allows
     * you to associate a set of animation values with a property name.
     *
     * @param target The object whose property is to be animated. Depending on how the
     * PropertyValuesObjects were constructed, the target object should either have the {@link
     * android.util.Property} objects used to construct the PropertyValuesHolder objects or (if the
     * PropertyValuesHOlder objects were created with property names) the target object should have
     * public methods on it called <code>setName()</code>, where <code>name</code> is the name of
     * the property passed in as the <code>propertyName</code> parameter for each of the
     * PropertyValuesHolder objects.
     * @param values A set of PropertyValuesHolder objects whose values will be animated between
     * over time.
     * @return An ObjectAnimator object that is set up to animate between the given values.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.573 -0500", hash_original_method = "319D9FA5F10AFC0CE6C0218CC418C7B4", hash_generated_method = "54975663517FB18AE3E5D5817FD53889")
    
public static ObjectAnimator ofPropertyValuesHolder(Object target,
            PropertyValuesHolder... values) {
        ObjectAnimator anim = new ObjectAnimator();
        anim.mTarget = target;
        anim.setValues(values);
        return anim;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.534 -0500", hash_original_field = "B2601CA7445F6BA19FA7884763D82281", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.536 -0500", hash_original_field = "AF4AFD8EA7996748BC121D1F7045BCD6", hash_generated_field = "532AA6353374D87021D18089A8C99282")

    private Object mTarget;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.539 -0500", hash_original_field = "3E0E605326E1698CDE7903701811F2C0", hash_generated_field = "A5D083978DF1D40FFF516AEB84BBF3F8")

    private String mPropertyName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.542 -0500", hash_original_field = "359373B7AA050F75C4B02BC22FC64F0E", hash_generated_field = "17ADCF9554A0CCEDE828D4C3909FCAFB")

    private Property mProperty;

    /**
     * Creates a new ObjectAnimator object. This default constructor is primarily for
     * use internally; the other constructors which take parameters are more generally
     * useful.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.551 -0500", hash_original_method = "C409E7B2E0E9411E53B94F67FBBD17CB", hash_generated_method = "EC0F459776122EDCE3E2989B148B5549")
    
public ObjectAnimator() {
    }

    /**
     * Private utility constructor that initializes the target object and name of the
     * property being animated.
     *
     * @param target The object whose property is to be animated. This object should
     * have a public method on it called <code>setName()</code>, where <code>name</code> is
     * the value of the <code>propertyName</code> parameter.
     * @param propertyName The name of the property being animated.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.554 -0500", hash_original_method = "72D05C8CED3E11A756BC68866B4296D0", hash_generated_method = "46ABB29A73B0BECD5A47934583013711")
    
private ObjectAnimator(Object target, String propertyName) {
        mTarget = target;
        setPropertyName(propertyName);
    }

    /**
     * Private utility constructor that initializes the target object and property being animated.
     *
     * @param target The object whose property is to be animated.
     * @param property The property being animated.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.557 -0500", hash_original_method = "F7624EC0BC93A299A0815B7F750DA685", hash_generated_method = "30EA1A433D105EC96F26D1757776D294")
    
private <T> ObjectAnimator(T target, Property<T, ?> property) {
        mTarget = target;
        setProperty(property);
    }

    /**
     * Sets the name of the property that will be animated. This name is used to derive
     * a setter function that will be called to set animated values.
     * For example, a property name of <code>foo</code> will result
     * in a call to the function <code>setFoo()</code> on the target object. If either
     * <code>valueFrom</code> or <code>valueTo</code> is null, then a getter function will
     * also be derived and called.
     *
     * <p>For best performance of the mechanism that calls the setter function determined by the
     * name of the property being animated, use <code>float</code> or <code>int</code> typed values,
     * and make the setter function for those properties have a <code>void</code> return value. This
     * will cause the code to take an optimized path for these constrained circumstances. Other
     * property types and return types will work, but will have more overhead in processing
     * the requests due to normal reflection mechanisms.</p>
     *
     * <p>Note that the setter function derived from this property name
     * must take the same parameter type as the
     * <code>valueFrom</code> and <code>valueTo</code> properties, otherwise the call to
     * the setter function will fail.</p>
     *
     * <p>If this ObjectAnimator has been set up to animate several properties together,
     * using more than one PropertyValuesHolder objects, then setting the propertyName simply
     * sets the propertyName in the first of those PropertyValuesHolder objects.</p>
     *
     * @param propertyName The name of the property being animated. Should not be null.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.544 -0500", hash_original_method = "9BD9C177E2BB2F7D9011362061D59F72", hash_generated_method = "E389D8E1CC4E9E98DE01EC491A9987DA")
    
public void setPropertyName(String propertyName) {
        // mValues could be null if this is being constructed piecemeal. Just record the
        // propertyName to be used later when setValues() is called if so.
        if (mValues != null) {
            PropertyValuesHolder valuesHolder = mValues[0];
            String oldName = valuesHolder.getPropertyName();
            valuesHolder.setPropertyName(propertyName);
            mValuesMap.remove(oldName);
            mValuesMap.put(propertyName, valuesHolder);
        }
        mPropertyName = propertyName;
        // New property/values/target should cause re-initialization prior to starting
        mInitialized = false;
    }

    /**
     * Sets the property that will be animated. Property objects will take precedence over
     * properties specified by the {@link #setPropertyName(String)} method. Animations should
     * be set up to use one or the other, not both.
     *
     * @param property The property being animated. Should not be null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.547 -0500", hash_original_method = "B6C27508DB7D8F3AB8749306282F7776", hash_generated_method = "5093A5F52513B711B13D817CD01E9811")
    
public void setProperty(Property property) {
        // mValues could be null if this is being constructed piecemeal. Just record the
        // propertyName to be used later when setValues() is called if so.
        if (mValues != null) {
            PropertyValuesHolder valuesHolder = mValues[0];
            String oldName = valuesHolder.getPropertyName();
            valuesHolder.setProperty(property);
            mValuesMap.remove(oldName);
            mValuesMap.put(mPropertyName, valuesHolder);
        }
        if (mProperty != null) {
            mPropertyName = property.getName();
        }
        mProperty = property;
        // New property/values/target should cause re-initialization prior to starting
        mInitialized = false;
    }

    /**
     * Gets the name of the property that will be animated. This name will be used to derive
     * a setter function that will be called to set animated values.
     * For example, a property name of <code>foo</code> will result
     * in a call to the function <code>setFoo()</code> on the target object. If either
     * <code>valueFrom</code> or <code>valueTo</code> is null, then a getter function will
     * also be derived and called.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.549 -0500", hash_original_method = "53B20749B4CEAC5C134A85897865D0FE", hash_generated_method = "4494B660E2F9A3D639720AD3F41DECE4")
    
public String getPropertyName() {
        return mPropertyName;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.575 -0500", hash_original_method = "5C1AD477A95BE17D3D6636E100CB747E", hash_generated_method = "C720D38E7C916822D5CFDE05787FD478")
    
@Override
    public void setIntValues(int... values) {
        if (mValues == null || mValues.length == 0) {
            // No values yet - this animator is being constructed piecemeal. Init the values with
            // whatever the current propertyName is
            if (mProperty != null) {
                setValues(PropertyValuesHolder.ofInt(mProperty, values));
            } else {
                setValues(PropertyValuesHolder.ofInt(mPropertyName, values));
            }
        } else {
            super.setIntValues(values);
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.577 -0500", hash_original_method = "BECFA01C089C05BCDFA6C4149CD77C82", hash_generated_method = "354B37464F207855D597208AE6CB62A5")
    
@Override
    public void setFloatValues(float... values) {
        if (mValues == null || mValues.length == 0) {
            // No values yet - this animator is being constructed piecemeal. Init the values with
            // whatever the current propertyName is
            if (mProperty != null) {
                setValues(PropertyValuesHolder.ofFloat(mProperty, values));
            } else {
                setValues(PropertyValuesHolder.ofFloat(mPropertyName, values));
            }
        } else {
            super.setFloatValues(values);
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.581 -0500", hash_original_method = "B3827B31EA19B66EB767F4A848C1D3E5", hash_generated_method = "C092E58D2D5FF285F659DCBC36DB8BEF")
    
@Override
    public void setObjectValues(Object... values) {
        if (mValues == null || mValues.length == 0) {
            // No values yet - this animator is being constructed piecemeal. Init the values with
            // whatever the current propertyName is
            if (mProperty != null) {
                setValues(PropertyValuesHolder.ofObject(mProperty, (TypeEvaluator)null, values));
            } else {
                setValues(PropertyValuesHolder.ofObject(mPropertyName, (TypeEvaluator)null, values));
            }
        } else {
            super.setObjectValues(values);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.583 -0500", hash_original_method = "56CCF5D2849A2C2A18C16A03F4D35824", hash_generated_method = "3730F65F1A571CD9F3FA8EEC1A85EB3A")
    
@Override
    public void start() {
        if (DBG) {
            Log.d("ObjectAnimator", "Anim target, duration: " + mTarget + ", " + getDuration());
            for (int i = 0; i < mValues.length; ++i) {
                PropertyValuesHolder pvh = mValues[i];
                ArrayList<Keyframe> keyframes = pvh.mKeyframeSet.mKeyframes;
                Log.d("ObjectAnimator", "   Values[" + i + "]: " +
                    pvh.getPropertyName() + ", " + keyframes.get(0).getValue() + ", " +
                    keyframes.get(pvh.mKeyframeSet.mNumKeyframes - 1).getValue());
            }
        }
        super.start();
    }

    /**
     * This function is called immediately before processing the first animation
     * frame of an animation. If there is a nonzero <code>startDelay</code>, the
     * function is called after that delay ends.
     * It takes care of the final initialization steps for the
     * animation. This includes setting mEvaluator, if the user has not yet
     * set it up, and the setter/getter methods, if the user did not supply
     * them.
     *
     *  <p>Overriders of this method should call the superclass method to cause
     *  internal mechanisms to be set up correctly.</p>
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.586 -0500", hash_original_method = "58C84EAE8A6F0E173B983D834F02804C", hash_generated_method = "A5C0BD8252EEC05C3DBED48542EC8BED")
    
@Override
    void initAnimation() {
        if (!mInitialized) {
            // mValueType may change due to setter/getter setup; do this before calling super.init(),
            // which uses mValueType to set up the default type evaluator.
            int numValues = mValues.length;
            for (int i = 0; i < numValues; ++i) {
                mValues[i].setupSetterAndGetter(mTarget);
            }
            super.initAnimation();
        }
    }

    /**
     * Sets the length of the animation. The default duration is 300 milliseconds.
     *
     * @param duration The length of the animation, in milliseconds.
     * @return ObjectAnimator The object called with setDuration(). This return
     * value makes it easier to compose statements together that construct and then set the
     * duration, as in
     * <code>ObjectAnimator.ofInt(target, propertyName, 0, 10).setDuration(500).start()</code>.
     */
    @DSComment("Animation class")
    @DSSafe(DSCat.ANDROID_ANIMATION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.588 -0500", hash_original_method = "954A06F8CA33C0A594F77D3B920078B4", hash_generated_method = "1B4CF989E6D7E3414ECFC36FFDB9F01F")
    
@Override
    public ObjectAnimator setDuration(long duration) {
        super.setDuration(duration);
        return this;
    }

    /**
     * The target object whose property will be animated by this animation
     *
     * @return The object being animated
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.590 -0500", hash_original_method = "AF1F3CF2C666AC410BA38EDE7AFA44BA", hash_generated_method = "5B4D93ECA8837590455F546455CF6241")
    
public Object getTarget() {
        return mTarget;
    }

    /**
     * Sets the target object whose property will be animated by this animation
     *
     * @param target The object being animated
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.593 -0500", hash_original_method = "08B359BFA7826C6DC05DFFE8229162D4", hash_generated_method = "F22953CE49EE6A2C91E7441BFCD3B334")
    
@Override
    public void setTarget(Object target) {
        if (mTarget != target) {
            final Object oldTarget = mTarget;
            mTarget = target;
            if (oldTarget != null && target != null && oldTarget.getClass() == target.getClass()) {
                return;
            }
            // New target type should cause re-initialization prior to starting
            mInitialized = false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.595 -0500", hash_original_method = "E0694B6EB6C164E3B15E1A0481C3ED42", hash_generated_method = "1FEEFCE00B6812283DF0C40A0BDAB3AD")
    
@Override
    public void setupStartValues() {
        initAnimation();
        int numValues = mValues.length;
        for (int i = 0; i < numValues; ++i) {
            mValues[i].setupStartValue(mTarget);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.597 -0500", hash_original_method = "92466FCD37C3DD1F8AE0CEC84015AF5E", hash_generated_method = "CF720457F073E57E12E3AF2DBBDEF420")
    
@Override
    public void setupEndValues() {
        initAnimation();
        int numValues = mValues.length;
        for (int i = 0; i < numValues; ++i) {
            mValues[i].setupEndValue(mTarget);
        }
    }

    /**
     * This method is called with the elapsed fraction of the animation during every
     * animation frame. This function turns the elapsed fraction into an interpolated fraction
     * and then into an animated value (from the evaluator. The function is called mostly during
     * animation updates, but it is also called when the <code>end()</code>
     * function is called, to set the final value on the property.
     *
     * <p>Overrides of this method must call the superclass to perform the calculation
     * of the animated value.</p>
     *
     * @param fraction The elapsed fraction of the animation.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.599 -0500", hash_original_method = "4BDD5FFF3171B4A6B3EE2F328E3988FB", hash_generated_method = "FAD2D93F1AAA4EA78CC5842EE5541188")
    
@Override
    void animateValue(float fraction) {
        super.animateValue(fraction);
        int numValues = mValues.length;
        for (int i = 0; i < numValues; ++i) {
            mValues[i].setAnimatedValue(mTarget);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.602 -0500", hash_original_method = "90D327822AEC361513F70606A9AC65F7", hash_generated_method = "561BA5E0647B4EC723EBCA1E17749283")
    
@Override
    public ObjectAnimator clone() {
        final ObjectAnimator anim = (ObjectAnimator) super.clone();
        return anim;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.604 -0500", hash_original_method = "0AD6D5BD218B220E887BD38666E44260", hash_generated_method = "6F611F0E760AAAA48F3F3EA242509A2C")
    
@Override
    public String toString() {
        String returnVal = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " +
            mTarget;
        if (mValues != null) {
            for (int i = 0; i < mValues.length; ++i) {
                returnVal += "\n    " + mValues[i].toString();
            }
        }
        return returnVal;
    }
}

