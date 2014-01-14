package android.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ReflectiveProperty<T, V> extends Property<T, V> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:24.292 -0500", hash_original_field = "5F7B571BB99FA76816322B7587147DD0", hash_generated_field = "DCD45C1BFB57F61F4FD82A59CD9038F7")

    private static final String PREFIX_GET = "get";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:24.294 -0500", hash_original_field = "05E81A61077B470225BE76F3EB3480A6", hash_generated_field = "BEF88240E4DBFFAA180B73F2B3351672")

    private static final String PREFIX_IS = "is";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:24.296 -0500", hash_original_field = "9C27731008A7EE1670C9850706BDCE7A", hash_generated_field = "69FF23A6AF0F51D218A18A1112A00C6F")

    private static final String PREFIX_SET = "set";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:24.298 -0500", hash_original_field = "E0622C3B28C50EA05166B5F3A85164F6", hash_generated_field = "EEA8654E15111D59944789CA5B543C76")

    private Method mSetter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:24.300 -0500", hash_original_field = "5E70FC9D82905C760AC172919A2D96FA", hash_generated_field = "6E8EC7297CA45290DB21D59C8AA7D832")

    private Method mGetter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:24.302 -0500", hash_original_field = "A36D1E69B2CF857FFEEB155335429AF7", hash_generated_field = "0E3FF9C9FB2909B4EEFAB3A86E1A80E5")

    private Field mField;

    /**
     * For given property name 'name', look for getName/isName method or 'name' field.
     * Also look for setName method (optional - could be readonly). Failing method getters and
     * field results in throwing NoSuchPropertyException.
     *
     * @param propertyHolder The class on which the methods or field are found
     * @param name The name of the property, where this name is capitalized and appended to
     * "get" and "is to search for the appropriate methods. If the get/is methods are not found,
     * the constructor will search for a field with that exact name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:24.306 -0500", hash_original_method = "4D5217EDB6A50C089202283FEC2465A8", hash_generated_method = "2C47B4FF771B11706F9E0B58201D7C3E")
    
public ReflectiveProperty(Class<T> propertyHolder, Class<V> valueType, String name) {
         // TODO: cache reflection info for each new class/name pair
        super(valueType, name);
        char firstLetter = Character.toUpperCase(name.charAt(0));
        String theRest = name.substring(1);
        String capitalizedName = firstLetter + theRest;
        String getterName = PREFIX_GET + capitalizedName;
        try {
            mGetter = propertyHolder.getMethod(getterName, (Class<?>[])null);
        } catch (NoSuchMethodException e) {
            // getName() not available - try isName() instead
            getterName = PREFIX_IS + capitalizedName;
            try {
                mGetter = propertyHolder.getMethod(getterName, (Class<?>[])null);
            } catch (NoSuchMethodException e1) {
                // Try public field instead
                try {
                    mField = propertyHolder.getField(name);
                    Class fieldType = mField.getType();
                    if (!typesMatch(valueType, fieldType)) {
                        throw new NoSuchPropertyException("Underlying type (" + fieldType + ") " +
                                "does not match Property type (" + valueType + ")");
                    }
                    return;
                } catch (NoSuchFieldException e2) {
                    // no way to access property - throw appropriate exception
                    throw new NoSuchPropertyException("No accessor method or field found for"
                            + " property with name " + name);
                }
            }
        }
        Class getterType = mGetter.getReturnType();
        // Check to make sure our getter type matches our valueType
        if (!typesMatch(valueType, getterType)) {
            throw new NoSuchPropertyException("Underlying type (" + getterType + ") " +
                    "does not match Property type (" + valueType + ")");
        }
        String setterName = PREFIX_SET + capitalizedName;
        try {
            mSetter = propertyHolder.getMethod(setterName, getterType);
        } catch (NoSuchMethodException ignored) {
            // Okay to not have a setter - just a readonly property
        }
    }

    /**
     * Utility method to check whether the type of the underlying field/method on the target
     * object matches the type of the Property. The extra checks for primitive types are because
     * generics will force the Property type to be a class, whereas the type of the underlying
     * method/field will probably be a primitive type instead. Accept float as matching Float,
     * etc.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:24.309 -0500", hash_original_method = "ED015CEE91613D6F524378162B530528", hash_generated_method = "90EE6004B1BC61FC87B465AFC51A1F2D")
    
private boolean typesMatch(Class<V> valueType, Class getterType) {
        if (getterType != valueType) {
            if (getterType.isPrimitive()) {
                return (getterType == float.class && valueType == Float.class) ||
                        (getterType == int.class && valueType == Integer.class) ||
                        (getterType == boolean.class && valueType == Boolean.class) ||
                        (getterType == long.class && valueType == Long.class) ||
                        (getterType == double.class && valueType == Double.class) ||
                        (getterType == short.class && valueType == Short.class) ||
                        (getterType == byte.class && valueType == Byte.class) ||
                        (getterType == char.class && valueType == Character.class);
            }
            return false;
        }
        return true;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:24.311 -0500", hash_original_method = "9BC237A59BE2F86E825267381E38AEC8", hash_generated_method = "47F4B9026211DAFB20F708621F748541")
    
@Override
    public void set(T object, V value) {
        if (mSetter != null) {
            try {
                mSetter.invoke(object, value);
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        } else if (mField != null) {
            try {
                mField.set(object, value);
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            }
        } else {
            throw new UnsupportedOperationException("Property " + getName() +" is read-only");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:24.314 -0500", hash_original_method = "4070872B48CA952F40E8D9AD673A26AA", hash_generated_method = "CFEA08AC56501D6F20CDB2B045F6A76A")
    
@Override
    public V get(T object) {
        if (mGetter != null) {
            try {
                return (V) mGetter.invoke(object, (Object[])null);
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        } else if (mField != null) {
            try {
                return (V) mField.get(object);
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            }
        }
        // Should not get here: there should always be a non-null getter or field
        throw new AssertionError();
    }

    /**
     * Returns false if there is no setter or public field underlying this Property.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:24.316 -0500", hash_original_method = "176D77E232A76459A0F514B7F2AA65DB", hash_generated_method = "50F85749A649DF96EF9573CA722BDC1F")
    
@Override
    public boolean isReadOnly() {
        return (mSetter == null && mField == null);
    }
}

