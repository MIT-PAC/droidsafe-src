package android.animation;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import android.util.FloatProperty;
import android.util.IntProperty;
import android.util.Log;
import android.util.Property;

import droidsafe.helpers.DSUtils;

public class PropertyValuesHolder implements Cloneable {

    /**
     * Constructs and returns a PropertyValuesHolder with a given property name and
     * set of int values.
     * @param propertyName The name of the property being animated.
     * @param values The values that the named property will animate between.
     * @return PropertyValuesHolder The constructed PropertyValuesHolder object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.703 -0500", hash_original_method = "27B4992A0A3B9BF53AD43F01217A5C6E", hash_generated_method = "F056BF1B70871DD93562AA3B815C94A7")
    
public static PropertyValuesHolder ofInt(String propertyName, int... values) {
        return new IntPropertyValuesHolder(propertyName, values);
    }

    /**
     * Constructs and returns a PropertyValuesHolder with a given property and
     * set of int values.
     * @param property The property being animated. Should not be null.
     * @param values The values that the property will animate between.
     * @return PropertyValuesHolder The constructed PropertyValuesHolder object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.705 -0500", hash_original_method = "88A8B174B1FD83CC528E44242CA889F8", hash_generated_method = "D4565BE04A1630A3B42E3BF52FE8DF17")
    
public static PropertyValuesHolder ofInt(Property<?, Integer> property, int... values) {
        return new IntPropertyValuesHolder(property, values);
    }

    /**
     * Constructs and returns a PropertyValuesHolder with a given property name and
     * set of float values.
     * @param propertyName The name of the property being animated.
     * @param values The values that the named property will animate between.
     * @return PropertyValuesHolder The constructed PropertyValuesHolder object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.707 -0500", hash_original_method = "E89632A72B3B069774FB78064C9564E7", hash_generated_method = "D7F19B09078573C85F9E9DA9F6D93C10")
    
public static PropertyValuesHolder ofFloat(String propertyName, float... values) {
        return new FloatPropertyValuesHolder(propertyName, values);
    }

    /**
     * Constructs and returns a PropertyValuesHolder with a given property and
     * set of float values.
     * @param property The property being animated. Should not be null.
     * @param values The values that the property will animate between.
     * @return PropertyValuesHolder The constructed PropertyValuesHolder object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.709 -0500", hash_original_method = "466E87FBA65675C6EFE457E3CD1EC710", hash_generated_method = "704239654977DB05B159AA9DE97E7B3B")
    
public static PropertyValuesHolder ofFloat(Property<?, Float> property, float... values) {
        return new FloatPropertyValuesHolder(property, values);
    }

    /**
     * Constructs and returns a PropertyValuesHolder with a given property name and
     * set of Object values. This variant also takes a TypeEvaluator because the system
     * cannot automatically interpolate between objects of unknown type.
     *
     * @param propertyName The name of the property being animated.
     * @param evaluator A TypeEvaluator that will be called on each animation frame to
     * provide the necessary interpolation between the Object values to derive the animated
     * value.
     * @param values The values that the named property will animate between.
     * @return PropertyValuesHolder The constructed PropertyValuesHolder object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.711 -0500", hash_original_method = "B50FEB452305718DD4A7DDB2A5A67DD1", hash_generated_method = "00599FD0052FE20BA1EFA9934E7F91F0")
    
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

    /**
     * Constructs and returns a PropertyValuesHolder object with the specified property name and set
     * of values. These values can be of any type, but the type should be consistent so that
     * an appropriate {@link android.animation.TypeEvaluator} can be found that matches
     * the common type.
     * <p>If there is only one value, it is assumed to be the end value of an animation,
     * and an initial value will be derived, if possible, by calling a getter function
     * on the object. Also, if any value is null, the value will be filled in when the animation
     * starts in the same way. This mechanism of automatically getting null values only works
     * if the PropertyValuesHolder object is used in conjunction
     * {@link ObjectAnimator}, and with a getter function
     * derived automatically from <code>propertyName</code>, since otherwise PropertyValuesHolder has
     * no way of determining what the value should be.
     * @param propertyName The name of the property associated with this set of values. This
     * can be the actual property name to be used when using a ObjectAnimator object, or
     * just a name used to get animated values, such as if this object is used with an
     * ValueAnimator object.
     * @param values The set of values to animate between.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.716 -0500", hash_original_method = "78E549231B416785584730785C66EDED", hash_generated_method = "770DF158014FABCC866A4E78FF3F6D6F")
    
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

    /**
     * Constructs and returns a PropertyValuesHolder object with the specified property and set
     * of values. These values can be of any type, but the type should be consistent so that
     * an appropriate {@link android.animation.TypeEvaluator} can be found that matches
     * the common type.
     * <p>If there is only one value, it is assumed to be the end value of an animation,
     * and an initial value will be derived, if possible, by calling the property's
     * {@link android.util.Property#get(Object)} function.
     * Also, if any value is null, the value will be filled in when the animation
     * starts in the same way. This mechanism of automatically getting null values only works
     * if the PropertyValuesHolder object is used in conjunction with
     * {@link ObjectAnimator}, since otherwise PropertyValuesHolder has
     * no way of determining what the value should be.
     * @param property The property associated with this set of values. Should not be null.
     * @param values The set of values to animate between.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.720 -0500", hash_original_method = "5BCF08BD3C30A7D4ED2D8814A854B53D", hash_generated_method = "2906BFEE2CAD0A44D3FFEF13AEA0E44A")
    
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

    /**
     * Utility method to derive a setter/getter method name from a property name, where the
     * prefix is typically "set" or "get" and the first letter of the property name is
     * capitalized.
     *
     * @param prefix The precursor to the method name, before the property name begins, typically
     * "set" or "get".
     * @param propertyName The name of the property that represents the bulk of the method name
     * after the prefix. The first letter of this word will be capitalized in the resulting
     * method name.
     * @return String the property name converted to a method name according to the conventions
     * specified above.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.773 -0500", hash_original_method = "82F5D656CE1D2806336A89B52A0194E7", hash_generated_method = "A922753D6323B195319892BF99C7313B")
    
static String getMethodName(String prefix, String propertyName) {
        if (propertyName == null || propertyName.length() == 0) {
            // shouldn't get here
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.671 -0500", hash_original_field = "A112865653801638C79C91F184034634", hash_generated_field = "7E9EFDBC560251144B1ABA6A3E58FAA3")

    private static final TypeEvaluator sIntEvaluator = new IntEvaluator();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.674 -0500", hash_original_field = "E7F37E75E6D7F06F3D5272356AD9C663", hash_generated_field = "81564E463CF700876869857891E00106")

    private static final TypeEvaluator sFloatEvaluator = new FloatEvaluator();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.676 -0500", hash_original_field = "9C6FA13E5868B0D1E2C8698E6AA3EEA9", hash_generated_field = "9885B3E2C333209E79A2C1456E20B3F3")

    // The caller may have supplied values in a type that does not match the setter/getter
    // functions (such as the integers 0 and 1 to represent floating point values for alpha).
    // Also, the use of generics in constructors means that we end up with the Object versions
    // of primitive types (Float vs. float). But most likely, the setter/getter functions
    // will take primitive types instead.
    // So we supply an ordered array of other types to try before giving up.
    private static Class[] FLOAT_VARIANTS = {float.class, Float.class, double.class, int.class,
            Double.class, Integer.class};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.679 -0500", hash_original_field = "963B6DECFBD67A8B4501E599D8CFD0A1", hash_generated_field = "2AB15B1F0AA6A5F55EE330ABD82CD53C")

    private static Class[] INTEGER_VARIANTS = {int.class, Integer.class, float.class, double.class,
            Float.class, Double.class};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.681 -0500", hash_original_field = "7FA249FF0F9E19D3CB28FEB818B8C779", hash_generated_field = "1C78BAF1D2C06E74F6CAF6919DCF921C")

    private static Class[] DOUBLE_VARIANTS = {double.class, Double.class, float.class, int.class,
            Float.class, Integer.class};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.683 -0500", hash_original_field = "3043154C0D68EF902F240E91D5E98AA4", hash_generated_field = "2D64219C3D4F52A5BFFC6043E076F125")

    // is used to speed up property/setter/getter lookups for a given class/property
    // combination. No need to use reflection on the combination more than once.
    private static final HashMap<Class, HashMap<String, Method>> sSetterPropertyMap =
            new HashMap<Class, HashMap<String, Method>>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.686 -0500", hash_original_field = "9FE6CBD5D977A3B06462F9BA6EE0F48E", hash_generated_field = "C2AD3EF1A9BABE0B350993A7EE00B799")

    private static final HashMap<Class, HashMap<String, Method>> sGetterPropertyMap =
            new HashMap<Class, HashMap<String, Method>>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.659 -0500", hash_original_field = "3E0E605326E1698CDE7903701811F2C0", hash_generated_field = "3E0E605326E1698CDE7903701811F2C0")

    String mPropertyName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.661 -0500", hash_original_field = "359373B7AA050F75C4B02BC22FC64F0E", hash_generated_field = "E251A73627C8A3AA16F08ACAF8645F40")

    protected Property mProperty;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.663 -0500", hash_original_field = "848F529A6ABC40F993A3D418131EC7A7", hash_generated_field = "848F529A6ABC40F993A3D418131EC7A7")

    Method mSetter = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.665 -0500", hash_original_field = "DCE23AB5B3896EA09188AFC593B41CAE", hash_generated_field = "E1F4E67E7973C49A4B9CE526E6FC6D89")

    private Method mGetter = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.667 -0500", hash_original_field = "28819529602B8605503B4054C761CC6C", hash_generated_field = "28819529602B8605503B4054C761CC6C")

    Class mValueType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.669 -0500", hash_original_field = "C6973E4C17AF76FE86969D85049286F9", hash_generated_field = "C6973E4C17AF76FE86969D85049286F9")

    KeyframeSet mKeyframeSet = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.689 -0500", hash_original_field = "E057CF75DFC846BF3FB1F41806B52A19", hash_generated_field = "52550D99DE4A8F55BBFF70B4EA1194BF")

    // at a time.
    final ReentrantReadWriteLock mPropertyMapLock = new ReentrantReadWriteLock();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.691 -0500", hash_original_field = "B1B01E8F86EEB9C319C134B378D8BBDD", hash_generated_field = "D71A65350B0F0F3529679E7C5F1E5190")

    final Object[] mTmpValueArray = new Object[1];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.693 -0500", hash_original_field = "FEF5736B09891D2FD2D8C1BD6C28F3AE", hash_generated_field = "49D878C6212418A96C46E0217176C94E")

    private TypeEvaluator mEvaluator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.695 -0500", hash_original_field = "E9C0384D1380A6683B8E91FE9E289167", hash_generated_field = "B2B6DB149B87CF34CE07060A7A505841")

    private Object mAnimatedValue;

    /**
     * Internal utility constructor, used by the factory methods to set the property name.
     * @param propertyName The name of the property for this holder.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.697 -0500", hash_original_method = "73C53AD6C55F8F35D3899F0ADDC03638", hash_generated_method = "2D14E895D4B516EDB216E1CDBD096B97")
    
private PropertyValuesHolder(String propertyName) {
        mPropertyName = propertyName;
    }

    /**
     * Internal utility constructor, used by the factory methods to set the property.
     * @param property The property for this holder.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.700 -0500", hash_original_method = "BDE609B5B8790707A2E7C7F2E71E73EE", hash_generated_method = "0B26935083816CB7C053F482734C3CA3")
    
private PropertyValuesHolder(Property property) {
        mProperty = property;
        if (property != null) {
            mPropertyName = property.getName();
        }
    }

    /**
     * Set the animated values for this object to this set of ints.
     * If there is only one value, it is assumed to be the end value of an animation,
     * and an initial value will be derived, if possible, by calling a getter function
     * on the object. Also, if any value is null, the value will be filled in when the animation
     * starts in the same way. This mechanism of automatically getting null values only works
     * if the PropertyValuesHolder object is used in conjunction
     * {@link ObjectAnimator}, and with a getter function
     * derived automatically from <code>propertyName</code>, since otherwise PropertyValuesHolder has
     * no way of determining what the value should be.
     *
     * @param values One or more values that the animation will animate between.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.722 -0500", hash_original_method = "5ACB1BF4CE1DE924456A446D3AE6F5AC", hash_generated_method = "B36B90076B3E296AD7B1ECB44517F9CD")
    
public void setIntValues(int... values) {
        mValueType = int.class;
        mKeyframeSet = KeyframeSet.ofInt(values);
    }

    /**
     * Set the animated values for this object to this set of floats.
     * If there is only one value, it is assumed to be the end value of an animation,
     * and an initial value will be derived, if possible, by calling a getter function
     * on the object. Also, if any value is null, the value will be filled in when the animation
     * starts in the same way. This mechanism of automatically getting null values only works
     * if the PropertyValuesHolder object is used in conjunction
     * {@link ObjectAnimator}, and with a getter function
     * derived automatically from <code>propertyName</code>, since otherwise PropertyValuesHolder has
     * no way of determining what the value should be.
     *
     * @param values One or more values that the animation will animate between.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.724 -0500", hash_original_method = "E55475A51A76C9AF68CEE5048B067603", hash_generated_method = "FDEA3CCFA4BDEFC0E5289215CF6964BE")
    
public void setFloatValues(float... values) {
        mValueType = float.class;
        mKeyframeSet = KeyframeSet.ofFloat(values);
    }

    /**
     * Set the animated values for this object to this set of Keyframes.
     *
     * @param values One or more values that the animation will animate between.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.726 -0500", hash_original_method = "A7BBAF2A9B12EBB30CB57DBA83B6B7FC", hash_generated_method = "C3C99AC520CD3926BEF98A996A980935")
    
public void setKeyframes(Keyframe... values) {
        int numKeyframes = values.length;
        Keyframe keyframes[] = new Keyframe[Math.max(numKeyframes,2)];
        mValueType = ((Keyframe)values[0]).getType();
        for (int i = 0; i < numKeyframes; ++i) {
            keyframes[i] = (Keyframe)values[i];
        }
        mKeyframeSet = new KeyframeSet(keyframes);
    }

    /**
     * Set the animated values for this object to this set of Objects.
     * If there is only one value, it is assumed to be the end value of an animation,
     * and an initial value will be derived, if possible, by calling a getter function
     * on the object. Also, if any value is null, the value will be filled in when the animation
     * starts in the same way. This mechanism of automatically getting null values only works
     * if the PropertyValuesHolder object is used in conjunction
     * {@link ObjectAnimator}, and with a getter function
     * derived automatically from <code>propertyName</code>, since otherwise PropertyValuesHolder has
     * no way of determining what the value should be.
     * 
     * @param values One or more values that the animation will animate between.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.728 -0500", hash_original_method = "8EF0800B602558BC1B6F05E6446D461B", hash_generated_method = "514648C91566CCE1DE0795DC4948A0DD")
    
public void setObjectValues(Object... values) {
        mValueType = values[0].getClass();
        mKeyframeSet = KeyframeSet.ofObject(values);
    }

    /**
     * Determine the setter or getter function using the JavaBeans convention of setFoo or
     * getFoo for a property named 'foo'. This function figures out what the name of the
     * function should be and uses reflection to find the Method with that name on the
     * target object.
     *
     * @param targetClass The class to search for the method
     * @param prefix "set" or "get", depending on whether we need a setter or getter.
     * @param valueType The type of the parameter (in the case of a setter). This type
     * is derived from the values set on this PropertyValuesHolder. This type is used as
     * a first guess at the parameter type, but we check for methods with several different
     * types to avoid problems with slight mis-matches between supplied values and actual
     * value types used on the setter.
     * @return Method the method associated with mPropertyName.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.732 -0500", hash_original_method = "13DE02BBE5B8605736F61BF53DFAC872", hash_generated_method = "D5AC74373C64EA76831BD5A69FB568C5")
    
private Method getPropertyFunction(Class targetClass, String prefix, Class valueType) {
        // TODO: faster implementation...
        Method returnVal = null;
        String methodName = getMethodName(prefix, mPropertyName);
        Class args[] = null;
        if (valueType == null) {
            try {
                returnVal = targetClass.getMethod(methodName, args);
            } catch (NoSuchMethodException e) {
                Log.e("PropertyValuesHolder",
                        "Couldn't find no-arg method for property " + mPropertyName + ": " + e);
            }
        } else {
            args = new Class[1];
            Class typeVariants[];
            if (mValueType.equals(Float.class)) {
                typeVariants = FLOAT_VARIANTS;
            } else if (mValueType.equals(Integer.class)) {
                typeVariants = INTEGER_VARIANTS;
            } else if (mValueType.equals(Double.class)) {
                typeVariants = DOUBLE_VARIANTS;
            } else {
                typeVariants = new Class[1];
                typeVariants[0] = mValueType;
            }
            for (Class typeVariant : typeVariants) {
                args[0] = typeVariant;
                try {
                    returnVal = targetClass.getMethod(methodName, args);
                    // change the value type to suit
                    mValueType = typeVariant;
                    return returnVal;
                } catch (NoSuchMethodException e) {
                    // Swallow the error and keep trying other variants
                }
            }
            // If we got here, then no appropriate function was found
            Log.e("PropertyValuesHolder",
                    "Couldn't find setter/getter for property " + mPropertyName +
                            " with value type "+ mValueType);
        }

        return returnVal;
    }

    /**
     * Returns the setter or getter requested. This utility function checks whether the
     * requested method exists in the propertyMapMap cache. If not, it calls another
     * utility function to request the Method from the targetClass directly.
     * @param targetClass The Class on which the requested method should exist.
     * @param propertyMapMap The cache of setters/getters derived so far.
     * @param prefix "set" or "get", for the setter or getter.
     * @param valueType The type of parameter passed into the method (null for getter).
     * @return Method the method associated with mPropertyName.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.735 -0500", hash_original_method = "D9982E89760E4BF7FBC2F6FCA80BFE72", hash_generated_method = "156BC28568B2D9535AC0A3A65DEEE555")
    
private Method setupSetterOrGetter(Class targetClass,
            HashMap<Class, HashMap<String, Method>> propertyMapMap,
            String prefix, Class valueType) {
        Method setterOrGetter = null;
        try {
            // Have to lock property map prior to reading it, to guard against
            // another thread putting something in there after we've checked it
            // but before we've added an entry to it
            mPropertyMapLock.writeLock().lock();
            HashMap<String, Method> propertyMap = propertyMapMap.get(targetClass);
            if (propertyMap != null) {
                setterOrGetter = propertyMap.get(mPropertyName);
            }
            if (setterOrGetter == null) {
                setterOrGetter = getPropertyFunction(targetClass, prefix, valueType);
                if (propertyMap == null) {
                    propertyMap = new HashMap<String, Method>();
                    propertyMapMap.put(targetClass, propertyMap);
                }
                propertyMap.put(mPropertyName, setterOrGetter);
            }
        } finally {
            mPropertyMapLock.writeLock().unlock();
        }
        return setterOrGetter;
    }

    /**
     * Utility function to get the setter from targetClass
     * @param targetClass The Class on which the requested method should exist.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.737 -0500", hash_original_method = "1E4C95A3F0C35809E96A1D77677A320B", hash_generated_method = "1E4C95A3F0C35809E96A1D77677A320B")
    
void setupSetter(Class targetClass) {
        mSetter = setupSetterOrGetter(targetClass, sSetterPropertyMap, "set", mValueType);
    }

    /**
     * Utility function to get the getter from targetClass
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.739 -0500", hash_original_method = "8511F8F7AD8858B7DCF32F8ED21ED093", hash_generated_method = "53E7D140BF9BE5CB4E809FEC0093E2D2")
    
private void setupGetter(Class targetClass) {
        mGetter = setupSetterOrGetter(targetClass, sGetterPropertyMap, "get", null);
    }

    /**
     * Internal function (called from ObjectAnimator) to set up the setter and getter
     * prior to running the animation. If the setter has not been manually set for this
     * object, it will be derived automatically given the property name, target object, and
     * types of values supplied. If no getter has been set, it will be supplied iff any of the
     * supplied values was null. If there is a null value, then the getter (supplied or derived)
     * will be called to set those null values to the current value of the property
     * on the target object.
     * @param target The object on which the setter (and possibly getter) exist.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.741 -0500", hash_original_method = "0087C9C0C21400747AF8DC614F234C65", hash_generated_method = "A1154521EE1E5D30840F449F0BA0CB0D")
    
void setupSetterAndGetter(Object target) {
        if (mProperty != null) {
            // check to make sure that mProperty is on the class of target
            try {
                Object testValue = mProperty.get(target);
                for (Keyframe kf : mKeyframeSet.mKeyframes) {
                    if (!kf.hasValue()) {
                        kf.setValue(mProperty.get(target));
                    }
                }
                return;
            } catch (ClassCastException e) {
                Log.e("PropertyValuesHolder","No such property (" + mProperty.getName() +
                        ") on target object " + target + ". Trying reflection instead");
                mProperty = null;
            }
        }
        Class targetClass = target.getClass();
        if (mSetter == null) {
            setupSetter(targetClass);
        }
        for (Keyframe kf : mKeyframeSet.mKeyframes) {
            if (!kf.hasValue()) {
                if (mGetter == null) {
                    setupGetter(targetClass);
                }
                try {
                    kf.setValue(mGetter.invoke(target));
                } catch (InvocationTargetException e) {
                    Log.e("PropertyValuesHolder", e.toString());
                } catch (IllegalAccessException e) {
                    Log.e("PropertyValuesHolder", e.toString());
                }
            }
        }
    }

    /**
     * Utility function to set the value stored in a particular Keyframe. The value used is
     * whatever the value is for the property name specified in the keyframe on the target object.
     *
     * @param target The target object from which the current value should be extracted.
     * @param kf The keyframe which holds the property name and value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.744 -0500", hash_original_method = "FD1A4547C57F636637D228B97E0E8D50", hash_generated_method = "FB5D155A14778A736F2907FB868E19F6")
    
private void setupValue(Object target, Keyframe kf) {
        if (mProperty != null) {
            kf.setValue(mProperty.get(target));
        }
        try {
            if (mGetter == null) {
                Class targetClass = target.getClass();
                setupGetter(targetClass);
            }
            kf.setValue(mGetter.invoke(target));
        } catch (InvocationTargetException e) {
            Log.e("PropertyValuesHolder", e.toString());
        } catch (IllegalAccessException e) {
            Log.e("PropertyValuesHolder", e.toString());
        }
    }

    /**
     * This function is called by ObjectAnimator when setting the start values for an animation.
     * The start values are set according to the current values in the target object. The
     * property whose value is extracted is whatever is specified by the propertyName of this
     * PropertyValuesHolder object.
     *
     * @param target The object which holds the start values that should be set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.746 -0500", hash_original_method = "981ED4D0B23A22C5ED7F7AF0C37F067E", hash_generated_method = "981ED4D0B23A22C5ED7F7AF0C37F067E")
    
void setupStartValue(Object target) {
        setupValue(target, mKeyframeSet.mKeyframes.get(0));
    }

    /**
     * This function is called by ObjectAnimator when setting the end values for an animation.
     * The end values are set according to the current values in the target object. The
     * property whose value is extracted is whatever is specified by the propertyName of this
     * PropertyValuesHolder object.
     *
     * @param target The object which holds the start values that should be set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.748 -0500", hash_original_method = "387F5EDF2150EE198B0BBE4A1C97CF48", hash_generated_method = "387F5EDF2150EE198B0BBE4A1C97CF48")
    
void setupEndValue(Object target) {
        setupValue(target, mKeyframeSet.mKeyframes.get(mKeyframeSet.mKeyframes.size() - 1));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.751 -0500", hash_original_method = "8E6DC562093F236AE410C563F47F28F2", hash_generated_method = "70FAB153373754018A531B973343BF1F")
    
@Override
    public PropertyValuesHolder clone() {
        try {
            PropertyValuesHolder newPVH = (PropertyValuesHolder) super.clone();
            newPVH.mPropertyName = mPropertyName;
            newPVH.mProperty = mProperty;
            newPVH.mKeyframeSet = mKeyframeSet.clone();
            newPVH.mEvaluator = mEvaluator;
            return newPVH;
        } catch (CloneNotSupportedException e) {
            // won't reach here
            return null;
        }
    }

    /**
     * Internal function to set the value on the target object, using the setter set up
     * earlier on this PropertyValuesHolder object. This function is called by ObjectAnimator
     * to handle turning the value calculated by ValueAnimator into a value set on the object
     * according to the name of the property.
     * @param target The target object on which the value is set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.753 -0500", hash_original_method = "BBF3202CC4B8C1713A46E96DE0EE5426", hash_generated_method = "BBF3202CC4B8C1713A46E96DE0EE5426")
    
void setAnimatedValue(Object target) {
        if (mProperty != null) {
            mProperty.set(target, getAnimatedValue());
        }
        if (mSetter != null) {
            try {
                mTmpValueArray[0] = getAnimatedValue();
                mSetter.invoke(target, mTmpValueArray);
            } catch (InvocationTargetException e) {
                Log.e("PropertyValuesHolder", e.toString());
            } catch (IllegalAccessException e) {
                Log.e("PropertyValuesHolder", e.toString());
            }
        }
    }

    /**
     * Internal function, called by ValueAnimator, to set up the TypeEvaluator that will be used
     * to calculate animated values.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.755 -0500", hash_original_method = "9511AC0B81E584A22A2DBDCB260E6C63", hash_generated_method = "DA9647646504BBB0EA293CD423DA54F8")
    
void init() {
        if (mEvaluator == null) {
            // We already handle int and float automatically, but not their Object
            // equivalents
            mEvaluator = (mValueType == Integer.class) ? sIntEvaluator :
                    (mValueType == Float.class) ? sFloatEvaluator :
                    null;
        }
        if (mEvaluator != null) {
            // KeyframeSet knows how to evaluate the common types - only give it a custom
            // evaluator if one has been set on this class
            mKeyframeSet.setEvaluator(mEvaluator);
        }
    }
    
    static class IntPropertyValuesHolder extends PropertyValuesHolder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.776 -0500", hash_original_field = "B515852A0A207BEB3C75216030DE5088", hash_generated_field = "47B44650F9265B2FD77E2A3383B8E152")

        private static final HashMap<Class, HashMap<String, Integer>> sJNISetterPropertyMap =
                new HashMap<Class, HashMap<String, Integer>>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.778 -0500", hash_original_field = "231C812A3CFDA881BCF1A1E1FEBCC96E", hash_generated_field = "231C812A3CFDA881BCF1A1E1FEBCC96E")

        int mJniSetter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.780 -0500", hash_original_field = "62E04B8D0CF69342D1B5EA299B41E71B", hash_generated_field = "789F496EFC4542E214000BFABCAD154A")

        private IntProperty mIntProperty;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.782 -0500", hash_original_field = "16BE68696FD23E4C9E2C2D0F3A95F693", hash_generated_field = "16BE68696FD23E4C9E2C2D0F3A95F693")

        IntKeyframeSet mIntKeyframeSet;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.784 -0500", hash_original_field = "2C2C363F77070248FB79E89B9069E337", hash_generated_field = "2C2C363F77070248FB79E89B9069E337")

        int mIntAnimatedValue;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.787 -0500", hash_original_method = "A1404C395B1A556C6EC35453AB25DA4D", hash_generated_method = "9456462D62D345FC48ADB881B9295DDB")
        
public IntPropertyValuesHolder(String propertyName, IntKeyframeSet keyframeSet) {
            super(propertyName);
            mValueType = int.class;
            mKeyframeSet = keyframeSet;
            mIntKeyframeSet = (IntKeyframeSet) mKeyframeSet;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.790 -0500", hash_original_method = "81A38376DA5063E7A71924F7865D18EE", hash_generated_method = "4D89B8FA409AF68224C2E0F884C2E3FF")
        
public IntPropertyValuesHolder(Property property, IntKeyframeSet keyframeSet) {
            super(property);
            mValueType = int.class;
            mKeyframeSet = keyframeSet;
            mIntKeyframeSet = (IntKeyframeSet) mKeyframeSet;
            if (property instanceof  IntProperty) {
                mIntProperty = (IntProperty) mProperty;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.793 -0500", hash_original_method = "D138EB87670EDA5FF4AD9A96EB7F8CD0", hash_generated_method = "B7565D7200230F99A61A4593E857CD52")
        
public IntPropertyValuesHolder(String propertyName, int... values) {
            super(propertyName);
            setIntValues(values);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.796 -0500", hash_original_method = "EF8A3E59A9590685EEFC24C3E37051A8", hash_generated_method = "ED603DBBFF5013319C20F2A54581D4FF")
        
public IntPropertyValuesHolder(Property property, int... values) {
            super(property);
            setIntValues(values);
            if (property instanceof  IntProperty) {
                mIntProperty = (IntProperty) mProperty;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.800 -0500", hash_original_method = "36FED796688BFE2861C8D1DF18289634", hash_generated_method = "30ADE19B7D80FC234461DAE0E6D3E58C")
        
@Override
        public void setIntValues(int... values) {
            super.setIntValues(values);
            mIntKeyframeSet = (IntKeyframeSet) mKeyframeSet;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.802 -0500", hash_original_method = "30F7306C8A34979730DB91915B461598", hash_generated_method = "4ED0D4FCFEA7E441D20735472C856D1E")
        
@Override
        void calculateValue(float fraction) {
            mIntAnimatedValue = mIntKeyframeSet.getIntValue(fraction);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.804 -0500", hash_original_method = "CE13DB8914BA3896479030C59B8EB5EA", hash_generated_method = "E0C63FD811BC259B825A918D50DE5EDF")
        
@Override
        Object getAnimatedValue() {
            return mIntAnimatedValue;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.806 -0500", hash_original_method = "D2AD407C7BF3FF5B871B87BBB92EBDD2", hash_generated_method = "BBFF4065182D0E27F38591ACFAB82A07")
        
@Override
        public IntPropertyValuesHolder clone() {
            IntPropertyValuesHolder newPVH = (IntPropertyValuesHolder) super.clone();
            newPVH.mIntKeyframeSet = (IntKeyframeSet) newPVH.mKeyframeSet;
            return newPVH;
        }

        /**
         * Internal function to set the value on the target object, using the setter set up
         * earlier on this PropertyValuesHolder object. This function is called by ObjectAnimator
         * to handle turning the value calculated by ValueAnimator into a value set on the object
         * according to the name of the property.
         * @param target The target object on which the value is set
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.809 -0500", hash_original_method = "774DCA711497C815C6106461263A2AF3", hash_generated_method = "7306EFD2C435A31B28DA158F855893E7")
        
@Override
        void setAnimatedValue(Object target) {
            if (mIntProperty != null) {
                mIntProperty.setValue(target, mIntAnimatedValue);
                return;
            }
            if (mProperty != null) {
                mProperty.set(target, mIntAnimatedValue);
                return;
            }
            if (mJniSetter != 0) {
                nCallIntMethod(target, mJniSetter, mIntAnimatedValue);
                return;
            }
            if (mSetter != null) {
                try {
                    mTmpValueArray[0] = mIntAnimatedValue;
                    mSetter.invoke(target, mTmpValueArray);
                } catch (InvocationTargetException e) {
                    Log.e("PropertyValuesHolder", e.toString());
                } catch (IllegalAccessException e) {
                    Log.e("PropertyValuesHolder", e.toString());
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.812 -0500", hash_original_method = "E5FCCB47E07ECB03BE2F278E504281F8", hash_generated_method = "4A89B7134AF1D568189DFDD1FEA1CF13")
        
@Override
        void setupSetter(Class targetClass) {
            if (mProperty != null) {
                return;
            }
            // Check new static hashmap<propName, int> for setter method
            try {
                mPropertyMapLock.writeLock().lock();
                HashMap<String, Integer> propertyMap = sJNISetterPropertyMap.get(targetClass);
                if (propertyMap != null) {
                    Integer mJniSetterInteger = propertyMap.get(mPropertyName);
                    if (mJniSetterInteger != null) {
                        mJniSetter = mJniSetterInteger;
                    }
                }
                if (mJniSetter == 0) {
                    String methodName = getMethodName("set", mPropertyName);
                    mJniSetter = nGetIntMethod(targetClass, methodName);
                    if (mJniSetter != 0) {
                        if (propertyMap == null) {
                            propertyMap = new HashMap<String, Integer>();
                            sJNISetterPropertyMap.put(targetClass, propertyMap);
                        }
                        propertyMap.put(mPropertyName, mJniSetter);
                    }
                }
            } catch (NoSuchMethodError e) {
                Log.d("PropertyValuesHolder",
                        "Can't find native method using JNI, use reflection" + e);
            } finally {
                mPropertyMapLock.writeLock().unlock();
            }
            if (mJniSetter == 0) {
                // Couldn't find method through fast JNI approach - just use reflection
                super.setupSetter(targetClass);
            }
        }
    }
    
    static class FloatPropertyValuesHolder extends PropertyValuesHolder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.819 -0500", hash_original_field = "B515852A0A207BEB3C75216030DE5088", hash_generated_field = "47B44650F9265B2FD77E2A3383B8E152")

        private static final HashMap<Class, HashMap<String, Integer>> sJNISetterPropertyMap =
                new HashMap<Class, HashMap<String, Integer>>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.821 -0500", hash_original_field = "231C812A3CFDA881BCF1A1E1FEBCC96E", hash_generated_field = "231C812A3CFDA881BCF1A1E1FEBCC96E")

        int mJniSetter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.824 -0500", hash_original_field = "9AC36FEA452FB4A773C570E9717E82CC", hash_generated_field = "CC72C56A48E7B9C7E56C889DE4F33E11")

        private FloatProperty mFloatProperty;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.826 -0500", hash_original_field = "23FE3970B948CA0567BB21122CB48811", hash_generated_field = "23FE3970B948CA0567BB21122CB48811")

        FloatKeyframeSet mFloatKeyframeSet;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.828 -0500", hash_original_field = "4734C624F522D63647CA34AA79C8C9AC", hash_generated_field = "4734C624F522D63647CA34AA79C8C9AC")

        float mFloatAnimatedValue;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.830 -0500", hash_original_method = "5C9EF6457927B43859688413E4C7829F", hash_generated_method = "F299FDFB6D3EB6B52038999E22A587C1")
        
public FloatPropertyValuesHolder(String propertyName, FloatKeyframeSet keyframeSet) {
            super(propertyName);
            mValueType = float.class;
            mKeyframeSet = keyframeSet;
            mFloatKeyframeSet = (FloatKeyframeSet) mKeyframeSet;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.833 -0500", hash_original_method = "3ECDE802415F2017B0BC69F95B30B753", hash_generated_method = "99180EBCDA50F3119231B620E284786E")
        
public FloatPropertyValuesHolder(Property property, FloatKeyframeSet keyframeSet) {
            super(property);
            mValueType = float.class;
            mKeyframeSet = keyframeSet;
            mFloatKeyframeSet = (FloatKeyframeSet) mKeyframeSet;
            if (property instanceof FloatProperty) {
                mFloatProperty = (FloatProperty) mProperty;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.836 -0500", hash_original_method = "C77EAEA380E6CBE61D90EF78014D158B", hash_generated_method = "0DF7FFF5ED95FEF536679B44A565E003")
        
public FloatPropertyValuesHolder(String propertyName, float... values) {
            super(propertyName);
            setFloatValues(values);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.839 -0500", hash_original_method = "91C83497360B006516EF522F9EB49209", hash_generated_method = "BFE115C630EF4B90A1FE6ADC885FA6A5")
        
public FloatPropertyValuesHolder(Property property, float... values) {
            super(property);
            setFloatValues(values);
            if (property instanceof  FloatProperty) {
                mFloatProperty = (FloatProperty) mProperty;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.841 -0500", hash_original_method = "4C7839391C0E614BE090BEA208DAADC2", hash_generated_method = "2208DFD28687205E39ADC139771DB70B")
        
@Override
        public void setFloatValues(float... values) {
            super.setFloatValues(values);
            mFloatKeyframeSet = (FloatKeyframeSet) mKeyframeSet;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.843 -0500", hash_original_method = "EBADBBF750EE6D7005FAC08DD166E4F4", hash_generated_method = "66510F3EA1DA18F2F5D12C20D1213C09")
        
@Override
        void calculateValue(float fraction) {
            mFloatAnimatedValue = mFloatKeyframeSet.getFloatValue(fraction);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.845 -0500", hash_original_method = "56F77D961BC82461152CD24C144983C0", hash_generated_method = "932BE8033097A3E0DD0F0777F6D73A1F")
        
@Override
        Object getAnimatedValue() {
            return mFloatAnimatedValue;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.848 -0500", hash_original_method = "3798C3AECEA696DCFE0B333FF00EF37C", hash_generated_method = "75E0FDAC35B4309FA831B3B2BEAC8741")
        
@Override
        public FloatPropertyValuesHolder clone() {
            FloatPropertyValuesHolder newPVH = (FloatPropertyValuesHolder) super.clone();
            newPVH.mFloatKeyframeSet = (FloatKeyframeSet) newPVH.mKeyframeSet;
            return newPVH;
        }

        /**
         * Internal function to set the value on the target object, using the setter set up
         * earlier on this PropertyValuesHolder object. This function is called by ObjectAnimator
         * to handle turning the value calculated by ValueAnimator into a value set on the object
         * according to the name of the property.
         * @param target The target object on which the value is set
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.850 -0500", hash_original_method = "727C6F3DB059985E066E102AF679E2D9", hash_generated_method = "0BF299EE2EE1BE08B279BB046D43F5A8")
        
@Override
        void setAnimatedValue(Object target) {
            if (mFloatProperty != null) {
                mFloatProperty.setValue(target, mFloatAnimatedValue);
                return;
            }
            if (mProperty != null) {
                mProperty.set(target, mFloatAnimatedValue);
                return;
            }
            if (mJniSetter != 0) {
                nCallFloatMethod(target, mJniSetter, mFloatAnimatedValue);
                return;
            }
            if (mSetter != null) {
                try {
                    mTmpValueArray[0] = mFloatAnimatedValue;
                    mSetter.invoke(target, mTmpValueArray);
                } catch (InvocationTargetException e) {
                    Log.e("PropertyValuesHolder", e.toString());
                } catch (IllegalAccessException e) {
                    Log.e("PropertyValuesHolder", e.toString());
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.853 -0500", hash_original_method = "2E99CF7209AB7743339028E8A9433227", hash_generated_method = "166A6D1C15BBA9368BF93C2728AD3F35")
        
@Override
        void setupSetter(Class targetClass) {
            if (mProperty != null) {
                return;
            }
            // Check new static hashmap<propName, int> for setter method
            try {
                mPropertyMapLock.writeLock().lock();
                HashMap<String, Integer> propertyMap = sJNISetterPropertyMap.get(targetClass);
                if (propertyMap != null) {
                    Integer mJniSetterInteger = propertyMap.get(mPropertyName);
                    if (mJniSetterInteger != null) {
                        mJniSetter = mJniSetterInteger;
                    }
                }
                if (mJniSetter == 0) {
                    String methodName = getMethodName("set", mPropertyName);
                    mJniSetter = nGetFloatMethod(targetClass, methodName);
                    if (mJniSetter != 0) {
                        if (propertyMap == null) {
                            propertyMap = new HashMap<String, Integer>();
                            sJNISetterPropertyMap.put(targetClass, propertyMap);
                        }
                        propertyMap.put(mPropertyName, mJniSetter);
                    }
                }
            } catch (NoSuchMethodError e) {
                Log.d("PropertyValuesHolder",
                        "Can't find native method using JNI, use reflection" + e);
            } finally {
                mPropertyMapLock.writeLock().unlock();
            }
            if (mJniSetter == 0) {
                // Couldn't find method through fast JNI approach - just use reflection
                super.setupSetter(targetClass);
            }
        }
    }

    /**
     * The TypeEvaluator will the automatically determined based on the type of values
     * supplied to PropertyValuesHolder. The evaluator can be manually set, however, if so
     * desired. This may be important in cases where either the type of the values supplied
     * do not match the way that they should be interpolated between, or if the values
     * are of a custom type or one not currently understood by the animation system. Currently,
     * only values of type float and int (and their Object equivalents: Float
     * and Integer) are  correctly interpolated; all other types require setting a TypeEvaluator.
     * @param evaluator
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.757 -0500", hash_original_method = "8817589F1B40B238224DB9B551F0527E", hash_generated_method = "2B32C607BF9C56CC95FB41BA1479F466")
    
public void setEvaluator(TypeEvaluator evaluator) {
        mEvaluator = evaluator;
        mKeyframeSet.setEvaluator(evaluator);
    }

    /**
     * Function used to calculate the value according to the evaluator set up for
     * this PropertyValuesHolder object. This function is called by ValueAnimator.animateValue().
     *
     * @param fraction The elapsed, interpolated fraction of the animation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.759 -0500", hash_original_method = "3D77B6F49E03B0770D03717F27BECD0E", hash_generated_method = "3D77B6F49E03B0770D03717F27BECD0E")
    
void calculateValue(float fraction) {
        mAnimatedValue = mKeyframeSet.getValue(fraction);
    }

    /**
     * Sets the name of the property that will be animated. This name is used to derive
     * a setter function that will be called to set animated values.
     * For example, a property name of <code>foo</code> will result
     * in a call to the function <code>setFoo()</code> on the target object. If either
     * <code>valueFrom</code> or <code>valueTo</code> is null, then a getter function will
     * also be derived and called.
     *
     * <p>Note that the setter function derived from this property name
     * must take the same parameter type as the
     * <code>valueFrom</code> and <code>valueTo</code> properties, otherwise the call to
     * the setter function will fail.</p>
     *
     * @param propertyName The name of the property being animated.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.761 -0500", hash_original_method = "748680E3CF42F5BF312929F3A98BA3E4", hash_generated_method = "BBEEF7E2FD60EB160ED64755CD8A91AB")
    
public void setPropertyName(String propertyName) {
        mPropertyName = propertyName;
    }

    /**
     * Sets the property that will be animated.
     *
     * <p>Note that if this PropertyValuesHolder object is used with ObjectAnimator, the property
     * must exist on the target object specified in that ObjectAnimator.</p>
     *
     * @param property The property being animated.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.764 -0500", hash_original_method = "8FEFD1E6365C919A12E22D83DCF12A7D", hash_generated_method = "70E6CB7F593AA6BC9FF806DD9A42BE97")
    
public void setProperty(Property property) {
        mProperty = property;
    }

    /**
     * Gets the name of the property that will be animated. This name will be used to derive
     * a setter function that will be called to set animated values.
     * For example, a property name of <code>foo</code> will result
     * in a call to the function <code>setFoo()</code> on the target object. If either
     * <code>valueFrom</code> or <code>valueTo</code> is null, then a getter function will
     * also be derived and called.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.766 -0500", hash_original_method = "53B20749B4CEAC5C134A85897865D0FE", hash_generated_method = "4494B660E2F9A3D639720AD3F41DECE4")
    
public String getPropertyName() {
        return mPropertyName;
    }

    /**
     * Internal function, called by ValueAnimator and ObjectAnimator, to retrieve the value
     * most recently calculated in calculateValue().
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.769 -0500", hash_original_method = "7EED53883B814F7F8B112CE8FF982C26", hash_generated_method = "7EED53883B814F7F8B112CE8FF982C26")
    
Object getAnimatedValue() {
        return mAnimatedValue;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:31.771 -0500", hash_original_method = "BD911D365C7FC80DCCAF5DAD046A5B1C", hash_generated_method = "41D933AE1C4CDEA057B6FEEE76A81639")
    
@Override
    public String toString() {
        return mPropertyName + ": " + mKeyframeSet.toString();
    }
}

