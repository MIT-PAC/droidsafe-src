package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.ref.SoftReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.WeakHashMap;

import libcore.io.Memory;
import libcore.util.EmptyArray;

import droidsafe.helpers.DSUtils;

public class ObjectStreamClass implements Serializable {

    /**
     * Compute class descriptor for a given class <code>cl</code>.
     *
     * @param cl
     *            a java.langClass for which to compute the corresponding
     *            descriptor
     * @return the computer class descriptor
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.253 -0500", hash_original_method = "EE95B522B106FAE9E2BC75AC9A53C7A8", hash_generated_method = "7C589C8FAA2EC286F4CCE935FE295ADA")
    
private static ObjectStreamClass createClassDesc(Class<?> cl) {

        ObjectStreamClass result = new ObjectStreamClass();

        boolean isArray = cl.isArray();
        boolean serializable = isSerializable(cl);
        boolean externalizable = isExternalizable(cl);

        result.isSerializable = serializable;
        result.isExternalizable = externalizable;

        // Now we fill in the values
        result.setName(cl.getName());
        result.setClass(cl);
        Class<?> superclass = cl.getSuperclass();
        if (superclass != null) {
            result.setSuperclass(lookup(superclass));
        }

        Field[] declaredFields = null;

        // Compute the SUID
        if (serializable || externalizable) {
            if (result.isEnum() || result.isProxy()) {
                result.setSerialVersionUID(0L);
            } else {
                declaredFields = cl.getDeclaredFields();
                result.setSerialVersionUID(computeSerialVersionUID(cl, declaredFields));
            }
        }

        // Serializables need field descriptors
        if (serializable && !isArray) {
            if (declaredFields == null) {
                declaredFields = cl.getDeclaredFields();
            }
            result.buildFieldDescriptors(declaredFields);
        } else {
            // Externalizables or arrays do not need FieldDesc info
            result.setFields(NO_FIELDS);
        }

        // Copy all fields to loadFields - they should be read by default in
        // ObjectInputStream.defaultReadObject() method
        ObjectStreamField[] fields = result.getFields();

        if (fields != null) {
            ObjectStreamField[] loadFields = new ObjectStreamField[fields.length];

            for (int i = 0; i < fields.length; ++i) {
                loadFields[i] = new ObjectStreamField(fields[i].getName(),
                        fields[i].getType(), fields[i].isUnshared());

                // resolve type string to init typeString field in
                // ObjectStreamField
                loadFields[i].getTypeString();
            }
            result.setLoadFields(loadFields);
        }

        byte flags = 0;
        if (externalizable) {
            flags |= ObjectStreamConstants.SC_EXTERNALIZABLE;
            flags |= ObjectStreamConstants.SC_BLOCK_DATA; // use protocol version 2 by default
        } else if (serializable) {
            flags |= ObjectStreamConstants.SC_SERIALIZABLE;
        }
        result.methodWriteReplace = findMethod(cl, "writeReplace");
        result.methodReadResolve = findMethod(cl, "readResolve");
        result.methodWriteObject = findPrivateMethod(cl, "writeObject", WRITE_PARAM_TYPES);
        result.methodReadObject = findPrivateMethod(cl, "readObject", READ_PARAM_TYPES);
        result.methodReadObjectNoData = findPrivateMethod(cl, "readObjectNoData", EmptyArray.CLASS);
        if (result.hasMethodWriteObject()) {
            flags |= ObjectStreamConstants.SC_WRITE_METHOD;
        }
        result.setFlags(flags);

        return result;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static long computeSerialVersionUID(Class<?> cl, Field[] fields) {
        for (int i = 0; i < fields.length; i++) {
            final Field field = fields[i];
            if (field.getType() == long.class) {
                int modifiers = field.getModifiers();
                if (Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers)) {
                    if (UID_FIELD_NAME.equals(field.getName())) {
                        field.setAccessible(true);
                        try {
                            return field.getLong(null);
                        } catch (IllegalAccessException iae) {
                            throw new RuntimeException("Error fetching SUID: " + iae);
                        }
                    }
                }
            }
        }
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA");
        } catch (NoSuchAlgorithmException e) {
            throw new Error(e);
        }
        ByteArrayOutputStream sha = new ByteArrayOutputStream();
        try {
            DataOutputStream output = new DataOutputStream(sha);
            output.writeUTF(cl.getName());
            int classModifiers = CLASS_MODIFIERS_MASK & cl.getModifiers();
            boolean isArray = cl.isArray();
            if (isArray) {
                classModifiers |= Modifier.ABSTRACT;
            }
            if (cl.isInterface() && !Modifier.isPublic(classModifiers)) {
                classModifiers &= ~Modifier.ABSTRACT;
            }
            output.writeInt(classModifiers);
            if (!isArray) {
                Class<?>[] interfaces = cl.getInterfaces();
                if (interfaces.length > 1) {
                    Comparator<Class<?>> interfaceComparator = new Comparator<Class<?>>() {
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.261 -0500", hash_original_method = "5214BD474E002DC374463B4FFD8CA7F7", hash_generated_method = "BDEE9CA9F60D2077C2689BFEB1952349")
                        
public int compare(Class<?> itf1, Class<?> itf2) {
                            return itf1.getName().compareTo(itf2.getName());
                        }
                    };
                    Arrays.sort(interfaces, interfaceComparator);
                }
                for (int i = 0; i < interfaces.length; i++) {
                    output.writeUTF(interfaces[i].getName());
                }
            }
            if (fields.length > 1) {
                Comparator<Field> fieldComparator = new Comparator<Field>() {
                    @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.264 -0500", hash_original_method = "AFBDAD85BF1614275D9D6A609C54DB23", hash_generated_method = "462A7954A85764F00B1CECD09B2457DF")
                    
public int compare(Field field1, Field field2) {
                        return field1.getName().compareTo(field2.getName());
                    }
                };
                Arrays.sort(fields, fieldComparator);
            }
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                int modifiers = field.getModifiers() & FIELD_MODIFIERS_MASK;
                boolean skip = Modifier.isPrivate(modifiers)
                        && (Modifier.isTransient(modifiers) || Modifier
                                .isStatic(modifiers));
                if (!skip) {
                    output.writeUTF(field.getName());
                    output.writeInt(modifiers);
                    output
                            .writeUTF(descriptorForFieldSignature(getFieldSignature(field)));
                }
            }
            if (hasClinit(cl)) {
                output.writeUTF(CLINIT_NAME);
                output.writeInt(CLINIT_MODIFIERS);
                output.writeUTF(CLINIT_SIGNATURE);
            }
            Constructor<?>[] constructors = cl.getDeclaredConstructors();
            if (constructors.length > 1) {
                Comparator<Constructor<?>> constructorComparator = new Comparator<Constructor<?>>() {
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.268 -0500", hash_original_method = "85A1C2FA200F04557471D7F31B94D455", hash_generated_method = "B42E0519DDCA5A9B6D56419965E86962")
                    
public int compare(Constructor<?> ctr1, Constructor<?> ctr2) {
                        // All constructors have same name, so we sort based on
                        // signature
                        return (getConstructorSignature(ctr1)
                                .compareTo(getConstructorSignature(ctr2)));
                    }
                };
                Arrays.sort(constructors, constructorComparator);
            }
            for (int i = 0; i < constructors.length; i++) {
                Constructor<?> constructor = constructors[i];
                int modifiers = constructor.getModifiers()
                        & METHOD_MODIFIERS_MASK;
                boolean isPrivate = Modifier.isPrivate(modifiers);
                if (!isPrivate) {
                    output.writeUTF("<init>");
                    output.writeInt(modifiers);
                    output.writeUTF(descriptorForSignature(
                            getConstructorSignature(constructor)).replace('/',
                            '.'));
                }
            }
            Method[] methods = cl.getDeclaredMethods();
            if (methods.length > 1) {
                Comparator<Method> methodComparator = new Comparator<Method>() {
                    @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.271 -0500", hash_original_method = "47D61E2A0009DDA953F7DBCF813448D1", hash_generated_method = "799ECE919A479EDD5A113F27DE521F95")
                    
public int compare(Method m1, Method m2) {
                        int result = m1.getName().compareTo(m2.getName());
                        if (result == 0) {
                            // same name, signature will tell which one comes
                            // first
                            return getMethodSignature(m1).compareTo(
                                    getMethodSignature(m2));
                        }
                        return result;
                    }
                };
                Arrays.sort(methods, methodComparator);
            }
            for (int i = 0; i < methods.length; i++) {
                Method method = methods[i];
                int modifiers = method.getModifiers() & METHOD_MODIFIERS_MASK;
                boolean isPrivate = Modifier.isPrivate(modifiers);
                if (!isPrivate) {
                    output.writeUTF(method.getName());
                    output.writeInt(modifiers);
                    output.writeUTF(descriptorForSignature(
                            getMethodSignature(method)).replace('/', '.'));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e + " computing SHA-1/SUID");
        }
        byte[] hash = digest.digest(sha.toByteArray());
        return Memory.peekLong(hash, 0, ByteOrder.LITTLE_ENDIAN);
    }

    /**
     * Returns what the serialization specification calls "descriptor" given a
     * field signature.
     *
     * @param signature
     *            a field signature
     * @return containing the descriptor
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.280 -0500", hash_original_method = "218236478243591CE821F4BA590E81DD", hash_generated_method = "ABBE47BB0144736314470898AAF5A980")
    
private static String descriptorForFieldSignature(String signature) {
        return signature.replace('.', '/');
    }

    /**
     * Return what the serialization specification calls "descriptor" given a
     * method/constructor signature.
     *
     * @param signature
     *            a method or constructor signature
     * @return containing the descriptor
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.283 -0500", hash_original_method = "2440EA3F17E46E83B0C55915F3096F8E", hash_generated_method = "C5D9C7488210A8FCBCD98983FD46923D")
    
private static String descriptorForSignature(String signature) {
        return signature.substring(signature.indexOf("("));
    }

    /**
     * Return the java.lang.reflect.Field {@code serialPersistentFields}
     * if class {@code cl} implements it. Return null otherwise.
     *
     * @param cl
     *            a java.lang.Class which to test
     * @return {@code java.lang.reflect.Field} if the class has
     *         serialPersistentFields {@code null} if the class does not
     *         have serialPersistentFields
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.286 -0500", hash_original_method = "96D2879811B04BE03B81870D013DA6FA", hash_generated_method = "89D0726E0C8CF3709FB42187E8FA9808")
    
static Field fieldSerialPersistentFields(Class<?> cl) {
        try {
            Field f = cl.getDeclaredField("serialPersistentFields");
            int modifiers = f.getModifiers();
            if (Modifier.isStatic(modifiers) && Modifier.isPrivate(modifiers)
                    && Modifier.isFinal(modifiers)) {
                if (f.getType() == ARRAY_OF_FIELDS) {
                    return f;
                }
            }
        } catch (NoSuchFieldException nsm) {
            // Ignored
        }
        return null;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static Object newInstance(Class<?> instantiationClass, int methodId) {
		return new Object();
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int getConstructorId(Class<?> c) {
        return c.getTaintInt();
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static String getConstructorSignature(Constructor<?> c) {
		return new String();
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static String getFieldSignature(Field f) {
		return new String();
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static String getMethodSignature(Method m) {
		return new String();
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean hasClinit(Class<?> cl) {
        return cl.getTaintBoolean();
	}

    /**
     * Return true if instances of class {@code cl} are Externalizable,
     * false otherwise.
     *
     * @param cl
     *            a java.lang.Class which to test
     * @return {@code true} if instances of the class are Externalizable
     *         {@code false} if instances of the class are not
     *         Externalizable
     *
     * @see Object#hashCode
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.356 -0500", hash_original_method = "FDF4BA7EF329EAA2CE64F9956BF205C6", hash_generated_method = "F4EDCF3F853EC659B04101229D5E120B")
    
static boolean isExternalizable(Class<?> cl) {
        return EXTERNALIZABLE.isAssignableFrom(cl);
    }

    /**
     * Return true if the type code
     * <code>typecode<code> describes a primitive type
     *
     * @param typecode a char describing the typecode
     * @return {@code true} if the typecode represents a primitive type
     * {@code false} if the typecode represents an Object type (including arrays)
     *
     * @see Object#hashCode
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.359 -0500", hash_original_method = "6FE1F5C82C04AB08E12223950D7EB08A", hash_generated_method = "0970F67E09B2A5AAF9041B560FB4FFF3")
    
static boolean isPrimitiveType(char typecode) {
        return toTaintBoolean((typecode + '[' + typecode + 'L'));
    }

    /**
     * Return true if instances of class {@code cl} are Serializable,
     * false otherwise.
     *
     * @param cl
     *            a java.lang.Class which to test
     * @return {@code true} if instances of the class are Serializable
     *         {@code false} if instances of the class are not
     *         Serializable
     *
     * @see Object#hashCode
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.361 -0500", hash_original_method = "1C1B1909AD548F77B8D4A1B7F72F485A", hash_generated_method = "6757B2545B287A28286565B96FCAA48C")
    
static boolean isSerializable(Class<?> cl) {
        return SERIALIZABLE.isAssignableFrom(cl);
    }

    /**
     * Returns the descriptor for a serializable class.
     * Returns null if the class doesn't implement {@code Serializable} or {@code Externalizable}.
     *
     * @param cl
     *            a java.lang.Class for which to obtain the corresponding
     *            descriptor
     * @return the corresponding descriptor if the class is serializable or
     *         externalizable; null otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.376 -0500", hash_original_method = "4E9665B66F7E0C974FC483540841948D", hash_generated_method = "CE2898CC9C78E94F0A6BE8C3E14BB4E9")
    
public static ObjectStreamClass lookup(Class<?> cl) {
        ObjectStreamClass osc = lookupStreamClass(cl);
        return (osc.isSerializable() || osc.isExternalizable()) ? osc : null;
    }

    /**
     * Returns the descriptor for any class, whether or not the class
     * implements Serializable or Externalizable.
     *
     * @param cl
     *            a java.lang.Class for which to obtain the corresponding
     *            descriptor
     * @return the descriptor
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.379 -0500", hash_original_method = "982D878B5D9789546161AA6A5787B81A", hash_generated_method = "FA778DEB818C9C440A8ED2F5F9D4FBB2")
    
public static ObjectStreamClass lookupAny(Class<?> cl) {
        return lookupStreamClass(cl);
    }

    /**
     * Return the descriptor (ObjectStreamClass) corresponding to the class
     * {@code cl}. Returns an ObjectStreamClass even if instances of the
     * class cannot be serialized
     *
     * @param cl
     *            a java.langClass for which to obtain the corresponding
     *            descriptor
     * @return the corresponding descriptor
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.381 -0500", hash_original_method = "B7C56FB22E8F4B2B6633F52B26078E29", hash_generated_method = "DB71443E3123CE8B4711D6791B0D923F")
    
static ObjectStreamClass lookupStreamClass(Class<?> cl) {
        WeakHashMap<Class<?>, ObjectStreamClass> tlc = getCache();
        ObjectStreamClass cachedValue = tlc.get(cl);
        if (cachedValue == null) {
            cachedValue = createClassDesc(cl);
            tlc.put(cl, cachedValue);
        }
        return cachedValue;

    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.391 -0500", hash_original_method = "BEB8966DF391A95FA8B87FE718027911", hash_generated_method = "8810CB9D2A65598D62D1C0ADD8DA521C")
    
private static WeakHashMap<Class<?>, ObjectStreamClass> getCache() {
        ThreadLocal<WeakHashMap<Class<?>, ObjectStreamClass>> tls = storage.get();
        if (tls == null) {
            tls = new ThreadLocal<WeakHashMap<Class<?>, ObjectStreamClass>>() {
                public WeakHashMap<Class<?>, ObjectStreamClass> initialValue() {
                    return new WeakHashMap<Class<?>, ObjectStreamClass>();
                }
            };
            storage = new SoftReference<ThreadLocal<WeakHashMap<Class<?>, ObjectStreamClass>>>(tls);
        }
        return tls.get();
    }

    /**
     * Return the java.lang.reflect.Method if class <code>cl</code> implements
     * <code>methodName</code> . Return null otherwise.
     *
     * @param cl
     *            a java.lang.Class which to test
     * @return <code>java.lang.reflect.Method</code> if the class implements
     *         writeReplace <code>null</code> if the class does not implement
     *         writeReplace
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.393 -0500", hash_original_method = "B0BA66A83CE642C4DD80DDEEFA7F6EBC", hash_generated_method = "A96091188E14B3C0996F8E224B35FC6E")
    
static Method findMethod(Class<?> cl, String methodName) {
        Class<?> search = cl;
        Method method = null;
        while (search != null) {
            try {
                method = search.getDeclaredMethod(methodName, (Class[]) null);
                if (search == cl
                        || (method.getModifiers() & Modifier.PRIVATE) == 0) {
                    method.setAccessible(true);
                    return method;
                }
            } catch (NoSuchMethodException nsm) {
            }
            search = search.getSuperclass();
        }
        return null;
    }

    /**
     * Return the java.lang.reflect.Method if class <code>cl</code> implements
     * private <code>methodName</code> . Return null otherwise.
     *
     * @param cl
     *            a java.lang.Class which to test
     * @return {@code java.lang.reflect.Method} if the class implements
     *         writeReplace {@code null} if the class does not implement
     *         writeReplace
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.396 -0500", hash_original_method = "8084AF2768C65A12352E4FA34C16662E", hash_generated_method = "C3F50F19E1593A2AFAFF7BEFBFAD1479")
    
static Method findPrivateMethod(Class<?> cl, String methodName,
            Class<?>[] param) {
        try {
            Method method = cl.getDeclaredMethod(methodName, param);
            if (Modifier.isPrivate(method.getModifiers()) && method.getReturnType() == void.class) {
                method.setAccessible(true);
                return method;
            }
        } catch (NoSuchMethodException nsm) {
            // Ignored
        }
        return null;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.135 -0500", hash_original_field = "30A2E1DB596154B66C443EA956F82BE1", hash_generated_field = "F4B2A7F3877BA77B5DCECEA13608910C")

    // below
    private static final long serialVersionUID = -6120832682080437368L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.138 -0500", hash_original_field = "32159AE77E20540BEAA19AB30CEBBCF2", hash_generated_field = "7C93B17B1CD1259F16B6C51AFF108516")

    private static final String UID_FIELD_NAME = "serialVersionUID";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.141 -0500", hash_original_field = "526472ACDB4C61D538BE4606AE65BABB", hash_generated_field = "9AFAE497812747A92BB053856885C1C2")

    static final long CONSTRUCTOR_IS_NOT_RESOLVED = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.144 -0500", hash_original_field = "4DCB83B91CAA619875117607ABE8EDCF", hash_generated_field = "590029B14B4132E56D522CD50C18A2A5")

    private static final int CLASS_MODIFIERS_MASK = Modifier.PUBLIC | Modifier.FINAL |
            Modifier.INTERFACE | Modifier.ABSTRACT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.147 -0500", hash_original_field = "1BB66EAE449F920319A068C11609AD4E", hash_generated_field = "6E176BF4C7339EE62D8B4C9DEC6243A9")

    private static final int FIELD_MODIFIERS_MASK = Modifier.PUBLIC | Modifier.PRIVATE |
            Modifier.PROTECTED | Modifier.STATIC | Modifier.FINAL | Modifier.VOLATILE |
            Modifier.TRANSIENT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.150 -0500", hash_original_field = "1E1D8C1638F23AD8369D61B3AD561F3D", hash_generated_field = "5D118F6B69CCB323323A9B49BDA9C6C3")

    private static final int METHOD_MODIFIERS_MASK = Modifier.PUBLIC | Modifier.PRIVATE |
            Modifier.PROTECTED | Modifier.STATIC | Modifier.FINAL | Modifier.SYNCHRONIZED |
            Modifier.NATIVE | Modifier.ABSTRACT | Modifier.STRICT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.152 -0500", hash_original_field = "169E82E41DB0ED9CB4884C3C42730CD6", hash_generated_field = "43D6F3E9D5C647D35731B8383079E1D6")

    private static final Class<?>[] READ_PARAM_TYPES = new Class[] { ObjectInputStream.class };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.155 -0500", hash_original_field = "37FA512C1D1B945A566FC2F56646A45B", hash_generated_field = "4A3EE43FA683211E618FB6747D07F843")

    private static final Class<?>[] WRITE_PARAM_TYPES = new Class[] { ObjectOutputStream.class };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.158 -0500", hash_original_field = "B341058DE998F03576C2AC5EFB3EBE5E", hash_generated_field = "7D11682BF64A4B005019DE32559565EF")

    public static final ObjectStreamField[] NO_FIELDS = new ObjectStreamField[0];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.160 -0500", hash_original_field = "69E9E2A355907EFA62592AB1A1E82D3B", hash_generated_field = "6978DEEE48DC3157891475C4DA0DAB91")

    static  Class<?> ARRAY_OF_FIELDS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.163 -0500", hash_original_field = "17957C462363A888F2BDCDF45AAC66F6", hash_generated_field = "FA5209333B79D9097B62842702D68121")

    private static final String CLINIT_NAME = "<clinit>";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.166 -0500", hash_original_field = "2C83013070AFD863CA1790676F53F01E", hash_generated_field = "ACFFC1389FDC9F82445E4D03EE9ED911")

    private static final int CLINIT_MODIFIERS = Modifier.STATIC;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.169 -0500", hash_original_field = "BB1C2F96CCB58DCD83A71EE7D6EC2C83", hash_generated_field = "423C84B6DC3BB79CF9824136C350B1B0")

    private static final String CLINIT_SIGNATURE = "()V";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.172 -0500", hash_original_field = "57A812EAE6F514D7427AB8BB55910376", hash_generated_field = "4F2D1BC91F0EEAF8AFC3647840FAEB8F")

    private static final Class<Serializable> SERIALIZABLE = Serializable.class;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.175 -0500", hash_original_field = "6759E2A372072E18FDA04B59850EC53D", hash_generated_field = "8FF60D62BE9F159A9087406109E4ACEB")

    private static final Class<Externalizable> EXTERNALIZABLE = Externalizable.class;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.177 -0500", hash_original_field = "4F06862DF431885DA6DB4C6DF36DD700", hash_generated_field = "E50E1B7F50901172462DF6CB7A52BABD")

    static final Class<String> STRINGCLASS = String.class;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.179 -0500", hash_original_field = "E0D8AE8345DBA009B9698C5F1947BA37", hash_generated_field = "51D83A7260A0C617FACB44B683730C6D")

    static final Class<?> CLASSCLASS = Class.class;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.182 -0500", hash_original_field = "304AEC30FCFB212B4A2682EE850154ED", hash_generated_field = "F91CD3D7464571E8E9D05D8CAFE05B21")

    static final Class<ObjectStreamClass> OBJECTSTREAMCLASSCLASS = ObjectStreamClass.class;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.384 -0500", hash_original_field = "B5C370223CAA64275F503CB6753DB658", hash_generated_field = "16A63F3AB899CF3EB9607AD6E5CAA631")

    private static SoftReference<ThreadLocal<WeakHashMap<Class<?>, ObjectStreamClass>>> storage =
            new SoftReference<ThreadLocal<WeakHashMap<Class<?>, ObjectStreamClass>>>(null);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.184 -0500", hash_original_field = "2E144C7609F169F8133321495F094E1D", hash_generated_field = "565644E752815B2ABF82349A3CEA0B6B")

    private transient Method methodWriteReplace;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.187 -0500", hash_original_field = "1120D4F811D1CEECFEFAA363E9BB5D88", hash_generated_field = "6059C8931AF46DD9869FE9A893452731")

    private transient Method methodReadResolve;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.190 -0500", hash_original_field = "D6B541032CBA0BA095BE99442CE15BA1", hash_generated_field = "79B39BB54513173AC7D6E6CEF6CBC2C1")

    private transient Method methodWriteObject;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.192 -0500", hash_original_field = "3A698EC24B6AA64B1843CC9BDA60DA44", hash_generated_field = "95EB8846D319017FC3432FF6857D1E5F")

    private transient Method methodReadObject;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.195 -0500", hash_original_field = "E89A773592F712BE4D19FEEBDE018C4F", hash_generated_field = "7CE9FEA6AC19BB8C204FD6B95B2862F7")

    private transient Method methodReadObjectNoData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.197 -0500", hash_original_field = "2481264BA81BE68E201420BF5FFD7694", hash_generated_field = "9CF3DD8AED4B95AE1F483D580B3C9FB3")

    private transient boolean arePropertiesResolved;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.200 -0500", hash_original_field = "EB59C52569F23D48D06C39313C00E5E5", hash_generated_field = "CCFF438B2B69BBC8976762B5C0E1BAAE")

    private transient boolean isSerializable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.202 -0500", hash_original_field = "8E082D4D97BA2958195FE999276E22B5", hash_generated_field = "4BE511410EC0FFD94E2FF75D626D91CA")

    private transient boolean isExternalizable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.205 -0500", hash_original_field = "D142710B1B8C53515486D234BB9497DC", hash_generated_field = "08F3A9F82723EA0AE100503EE65CAB86")

    private transient boolean isProxy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.207 -0500", hash_original_field = "9E065219EE3F9DE19AF9EC1817A6A225", hash_generated_field = "36F43E2AAA4E18617E48CB413466DD29")

    private transient boolean isEnum;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.210 -0500", hash_original_field = "CA6BE7A479C5F3E68F3687DBA3A4A48F", hash_generated_field = "7BB61DAF9177E2FC248A00CF596CB1A4")

    // Name of the class this descriptor represents
    private transient String className;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.212 -0500", hash_original_field = "B0D345A5696D09C9B451C4A1BCEC2572", hash_generated_field = "AC340BA4F3A44FB166243898294EB37E")

    private transient Class<?> resolvedClass;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.215 -0500", hash_original_field = "68A4F3F4C953C2DB8C9A536D78502BAF", hash_generated_field = "971C9C890CEBC6BE40FABDECB2212AA0")

    private transient Class<?> resolvedConstructorClass;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.217 -0500", hash_original_field = "74725AFEB9A35146682F2F042B6B1898", hash_generated_field = "A4FBAD79CEB03A973A15AB5C7331E7A6")

    private transient int resolvedConstructorMethodId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.220 -0500", hash_original_field = "DC83E3BEFB7BA07B600323A421496520", hash_generated_field = "2CBD7F29D2CB9FEFE962129E37123233")

    private transient long svUID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.222 -0500", hash_original_field = "149BEAA77385A175012092F85F4E187A", hash_generated_field = "410554D49386BD33FE8E3AFFA864857F")

    // Any combination of SC_WRITE_METHOD, SC_SERIALIZABLE and SC_EXTERNALIZABLE
    // (see ObjectStreamConstants)
    private transient byte flags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.225 -0500", hash_original_field = "8616E33BDA3606419705BD4A604A6111", hash_generated_field = "0E8A2842EA061C0F95100317C7F2561C")

    // descriptor
    private transient ObjectStreamClass superclass;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.229 -0500", hash_original_field = "6C2C40828753853944FECE50DFBC2BFB", hash_generated_field = "21B2B6F793E44D1D94F0832A4DD6C976")

    // class
    private transient ObjectStreamField[] fields;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.231 -0500", hash_original_field = "88EBC5F94F893FF4189630396BBFE2DE", hash_generated_field = "A56A7B7B744B804CA41E1FD965741EE2")

    private transient ObjectStreamField[] loadFields;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.234 -0500", hash_original_field = "A770B53E19CEC0E8D2B9282241B85983", hash_generated_field = "98DF80295AE2B617789B3F4B441A2EF2")

    // IdentityHashMap, which is fine for our purposes.
    private transient HashMap<ObjectStreamField, Field> reflectionFields =
            new HashMap<ObjectStreamField, Field>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.237 -0500", hash_original_field = "8254D150709613AF303D88C09D79BAAC", hash_generated_field = "C0358E6BFD2D898DD9C7ADBEBD4D2ECF")

    private transient long constructor = CONSTRUCTOR_IS_NOT_RESOLVED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.321 -0500", hash_original_field = "0B91E83329D37B70A304881206962D9B", hash_generated_field = "4AA36F11897D193C7F055A6BB8228782")

    private transient volatile List<ObjectStreamClass> cachedHierarchy;

    /*
     * If an ObjectStreamClass describes an Externalizable class, it (the
     * descriptor) should not have field descriptors (ObjectStreamField) at all.
     * The ObjectStreamClass that gets saved should simply have no field info.
     * This is a footnote in page 1511 (class Serializable) of "The Java Class
     * Libraries, Second Edition, Vol. I".
     */

    /**
     * Constructs a new instance of this class.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.248 -0500", hash_original_method = "F4D9898A03FC0DADA999BF46D97F9433", hash_generated_method = "F4D9898A03FC0DADA999BF46D97F9433")
    
ObjectStreamClass() {
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.241 -0500", hash_original_method = "7053F33417C9644BFD49070B9EF96C54", hash_generated_method = "7053F33417C9644BFD49070B9EF96C54")
    
void setConstructor(long newConstructor) {
        constructor = newConstructor;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.243 -0500", hash_original_method = "AE977884038645FC18D9650C0686387C", hash_generated_method = "AE977884038645FC18D9650C0686387C")
    
long getConstructor() {
        return constructor;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.246 -0500", hash_original_method = "592D0703821799AB937A99A67AB05B5C", hash_generated_method = "E84EEE9AF44D27FA2C13151A94F52D4C")
    
Field getReflectionField(ObjectStreamField osf) {
        synchronized (reflectionFields) {
            Field field = reflectionFields.get(osf);
            if (field != null) {
                return field;
            }
        }

        try {
            Class<?> declaringClass = forClass();
            Field field = declaringClass.getDeclaredField(osf.getName());
            field.setAccessible(true);
            synchronized (reflectionFields) {
                reflectionFields.put(osf, field);
            }
            return reflectionFields.get(osf);
        } catch (NoSuchFieldException ex) {
            // The caller messed up. We'll return null and won't try to resolve this again.
            return null;
        }
    }

    /**
     * Builds the collection of field descriptors for the receiver
     *
     * @param declaredFields
     *            collection of java.lang.reflect.Field for which to compute
     *            field descriptors
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.256 -0500", hash_original_method = "3492CF41320405C3965233DAB60A3EF1", hash_generated_method = "7E137D5EAEFEEFFC7D0548124A537F7E")
    
void buildFieldDescriptors(Field[] declaredFields) {
        // We could find the field ourselves in the collection, but calling
        // reflect is easier. Optimize if needed.
        final Field f = ObjectStreamClass.fieldSerialPersistentFields(this.forClass());
        // If we could not find the emulated fields, we'll have to compute
        // dumpable fields from reflect fields
        boolean useReflectFields = f == null; // Assume we will compute the
        // fields to dump based on the
        // reflect fields

        ObjectStreamField[] _fields = null;
        if (!useReflectFields) {
            // The user declared a collection of emulated fields. Use them.
            // We have to be able to fetch its value, even if it is private
            f.setAccessible(true);
            try {
                // static field, pass null
                _fields = (ObjectStreamField[]) f.get(null);
            } catch (IllegalAccessException ex) {
                throw new AssertionError(ex);
            }
        } else {
            // Compute collection of dumpable fields based on reflect fields
            List<ObjectStreamField> serializableFields =
                    new ArrayList<ObjectStreamField>(declaredFields.length);
            // Filter, we are only interested in fields that are serializable
            for (Field declaredField : declaredFields) {
                int modifiers = declaredField.getModifiers();
                if (!Modifier.isStatic(modifiers) && !Modifier.isTransient(modifiers)) {
                    ObjectStreamField field = new ObjectStreamField(declaredField.getName(),
                            declaredField.getType());
                    serializableFields.add(field);
                }
            }

            if (serializableFields.size() == 0) {
                _fields = NO_FIELDS; // If no serializable fields, share the
                // special value so that users can test
            } else {
                _fields = serializableFields.toArray(new ObjectStreamField[serializableFields.size()]);
            }
        }
        Arrays.sort(_fields);
        // assign offsets
        int primOffset = 0, objectOffset = 0;
        for (int i = 0; i < _fields.length; i++) {
            Class<?> type = _fields[i].getType();
            if (type.isPrimitive()) {
                _fields[i].offset = primOffset;
                primOffset += primitiveSize(type);
            } else {
                _fields[i].offset = objectOffset++;
            }
        }
        fields = _fields;
    }

    /**
     * Returns the class (java.lang.Class) for this descriptor.
     *
     * @return the class in the local VM that this descriptor represents;
     *         {@code null} if there is no corresponding class.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.288 -0500", hash_original_method = "3FC829F6BB79347D76007A55E3423470", hash_generated_method = "4254136FF2998A18A9977A88AE4EA5EE")
    
public Class<?> forClass() {
        return resolvedClass;
    }

    /**
     * Create and return a new instance of class 'instantiationClass'
     * using JNI to call the constructor chosen by resolveConstructorClass.
     *
     * The returned instance may have uninitialized fields, including final fields.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.290 -0500", hash_original_method = "CFDAB7386CDDDD8EC35152CD7D073792", hash_generated_method = "CFDAB7386CDDDD8EC35152CD7D073792")
    
Object newInstance(Class<?> instantiationClass) throws InvalidClassException {
        resolveConstructorClass(instantiationClass);
        return newInstance(instantiationClass, resolvedConstructorMethodId);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.298 -0500", hash_original_method = "66A47A19F5FB8C837FA66140F62CB154", hash_generated_method = "A49C2FFE48B88A785AC206E614ED6413")
    
private Class<?> resolveConstructorClass(Class<?> objectClass) throws InvalidClassException {
        if (resolvedConstructorClass != null) {
            return resolvedConstructorClass;
        }

        // The class of the instance may not be the same as the class of the
        // constructor to run
        // This is the constructor to run if Externalizable
        Class<?> constructorClass = objectClass;

        // WARNING - What if the object is serializable and externalizable ?
        // Is that possible ?
        boolean wasSerializable = (flags & ObjectStreamConstants.SC_SERIALIZABLE) != 0;
        if (wasSerializable) {
            // Now we must run the constructor of the class just above the
            // one that implements Serializable so that slots that were not
            // dumped can be initialized properly
            while (constructorClass != null && ObjectStreamClass.isSerializable(constructorClass)) {
                constructorClass = constructorClass.getSuperclass();
            }
        }

        // Fetch the empty constructor, or null if none.
        Constructor<?> constructor = null;
        if (constructorClass != null) {
            try {
                constructor = constructorClass.getDeclaredConstructor(EmptyArray.CLASS);
            } catch (NoSuchMethodException ignored) {
            }
        }

        // Has to have an empty constructor
        if (constructor == null) {
            String className = constructorClass != null ? constructorClass.getName() : null;
            throw new InvalidClassException(className, "IllegalAccessException");
        }

        int constructorModifiers = constructor.getModifiers();
        boolean isPublic = Modifier.isPublic(constructorModifiers);
        boolean isProtected = Modifier.isProtected(constructorModifiers);
        boolean isPrivate = Modifier.isPrivate(constructorModifiers);

        // Now we must check if the empty constructor is visible to the
        // instantiation class
        boolean wasExternalizable = (flags & ObjectStreamConstants.SC_EXTERNALIZABLE) != 0;
        if (isPrivate || (wasExternalizable && !isPublic)) {
            throw new InvalidClassException(constructorClass.getName(), "IllegalAccessException");
        }

        // We know we are testing from a subclass, so the only other case
        // where the visibility is not allowed is when the constructor has
        // default visibility and the instantiation class is in a different
        // package than the constructor class
        if (!isPublic && !isProtected) {
            // Not public, not private and not protected...means default
            // visibility. Check if same package
            if (!inSamePackage(constructorClass, objectClass)) {
                throw new InvalidClassException(constructorClass.getName(), "IllegalAccessException");
            }
        }

        resolvedConstructorClass = constructorClass;
        resolvedConstructorMethodId = getConstructorId(resolvedConstructorClass);
        return constructorClass;
    }

    /**
     * Checks if two classes belong to the same package.
     *
     * @param c1
     *            one of the classes to test.
     * @param c2
     *            the other class to test.
     * @return {@code true} if the two classes belong to the same package,
     *         {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.306 -0500", hash_original_method = "C730C766F4F6CE91266CBA72D38C529A", hash_generated_method = "023C0B2F9BE49BF16B5DD6A189CAE77F")
    
private boolean inSamePackage(Class<?> c1, Class<?> c2) {
        String nameC1 = c1.getName();
        String nameC2 = c2.getName();
        int indexDotC1 = nameC1.lastIndexOf('.');
        int indexDotC2 = nameC2.lastIndexOf('.');
        if (indexDotC1 != indexDotC2) {
            return false; // cannot be in the same package if indices are not the same
        }
        if (indexDotC1 == -1) {
            return true; // both of them are in default package
        }
        return nameC1.regionMatches(0, nameC2, 0, indexDotC1);
    }

    /**
     * Gets a field descriptor of the class represented by this class
     * descriptor.
     *
     * @param name
     *            the name of the desired field.
     * @return the field identified by {@code name} or {@code null} if there is
     *         no such field.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.312 -0500", hash_original_method = "58A307C728457592549C73808957655C", hash_generated_method = "2E47CEDE989772B0264F8C1B960F85F1")
    
public ObjectStreamField getField(String name) {
        ObjectStreamField[] allFields = getFields();
        for (int i = 0; i < allFields.length; i++) {
            ObjectStreamField f = allFields[i];
            if (f.getName().equals(name)) {
                return f;
            }
        }
        return null;
    }

    /**
     * Returns the collection of field descriptors for the fields of the
     * corresponding class
     *
     * @return the receiver's collection of declared fields for the class it
     *         represents
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.315 -0500", hash_original_method = "3D80A7A04F3988E3E464D888981C4A01", hash_generated_method = "45D9D5658ADE04E7870C234E33A3805F")
    
ObjectStreamField[] fields() {
        if (fields == null) {
            Class<?> forCl = forClass();
            if (forCl != null && isSerializable() && !forCl.isArray()) {
                buildFieldDescriptors(forCl.getDeclaredFields());
            } else {
                // Externalizables or arrays do not need FieldDesc info
                setFields(NO_FIELDS);
            }
        }
        return fields;
    }

    /**
     * Returns a collection of field descriptors for the serialized fields of
     * the class represented by this class descriptor.
     *
     * @return an array of field descriptors or an array of length zero if there
     *         are no fields in this descriptor's class.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.318 -0500", hash_original_method = "BA69DA3B5E6C7F20CA233B877CCB0384", hash_generated_method = "F03AA34DEFAAA8EB951500B4E2BD9627")
    
public ObjectStreamField[] getFields() {
        copyFieldAttributes();
        return loadFields == null ? fields().clone() : loadFields.clone();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.323 -0500", hash_original_method = "8AA71837DDE89491F51C878CBC8B38A5", hash_generated_method = "8AA71837DDE89491F51C878CBC8B38A5")
    
List<ObjectStreamClass> getHierarchy() {
        List<ObjectStreamClass> result = cachedHierarchy;
        if (result == null) {
            cachedHierarchy = result = makeHierarchy();
        }
        return result;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.326 -0500", hash_original_method = "970C4D30E4F07A217EB44CA0880B9D33", hash_generated_method = "F9888FC48E0E9E4FE1CD6D12F0A7D843")
    
private List<ObjectStreamClass> makeHierarchy() {
        ArrayList<ObjectStreamClass> result = new ArrayList<ObjectStreamClass>();
        for (ObjectStreamClass osc = this; osc != null; osc = osc.getSuperclass()) {
            result.add(0, osc);
        }
        return result;
    }

    /**
     * If a Class uses "serialPersistentFields" to define the serialized fields,
     * this.loadFields cannot get the "unshared" information when deserializing
     * fields using current implementation of ObjectInputStream. This method
     * provides a way to copy the "unshared" attribute from this.fields.
     *
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.329 -0500", hash_original_method = "F57C7EC559BF09EB03BA0EA2BC063E8F", hash_generated_method = "37ED6A429AC93FABB5ECD6432523CB64")
    
private void copyFieldAttributes() {
        if ((loadFields == null) || fields == null) {
            return;
        }

        for (int i = 0; i < loadFields.length; i++) {
            ObjectStreamField loadField = loadFields[i];
            String name = loadField.getName();
            for (int j = 0; j < fields.length; j++) {
                ObjectStreamField field = fields[j];
                if (name.equals(field.getName())) {
                    loadField.setUnshared(field.isUnshared());
                    loadField.setOffset(field.getOffset());
                    break;
                }
            }
        }
    }

    /**
     * Returns the collection of field descriptors for the input fields of the
     * corresponding class
     *
     * @return the receiver's collection of input fields for the class it
     *         represents
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.331 -0500", hash_original_method = "8F334CDB84C81A51C0419AAF322CA87A", hash_generated_method = "8F334CDB84C81A51C0419AAF322CA87A")
    
ObjectStreamField[] getLoadFields() {
        return loadFields;
    }

    /**
     * Returns the flags for this descriptor, where possible combined values are
     *
     * ObjectStreamConstants.SC_WRITE_METHOD
     * ObjectStreamConstants.SC_SERIALIZABLE
     * ObjectStreamConstants.SC_EXTERNALIZABLE
     *
     * @return byte the receiver's flags for the class it represents
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.337 -0500", hash_original_method = "CB224A404D2A4A24CFF7504565CB22F2", hash_generated_method = "CB224A404D2A4A24CFF7504565CB22F2")
    
byte getFlags() {
        return flags;
    }

    /**
     * Returns the name of the class represented by this descriptor.
     *
     * @return the fully qualified name of the class this descriptor represents.
     */
    @DSComment("class serialization")
    @DSBan(DSCat.REFLECTION)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.344 -0500", hash_original_method = "4A271A070FBC29EF826D1B50170E00D2", hash_generated_method = "A2E949B0EE53973533E1D165657305B6")
    
public String getName() {
        return className;
    }

    /**
     * Returns the Serial Version User ID of the class represented by this
     * descriptor.
     *
     * @return the SUID for the class represented by this descriptor.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.347 -0500", hash_original_method = "50DDDA79153910C7DDC4FA6D8AF3586E", hash_generated_method = "D492C3ED977B85A6545C4C78EDE2BD87")
    
public long getSerialVersionUID() {
        return svUID;
    }

    /**
     * Returns the descriptor (ObjectStreamClass) of the superclass of the class
     * represented by the receiver.
     *
     * @return an ObjectStreamClass representing the superclass of the class
     *         represented by the receiver.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.349 -0500", hash_original_method = "B099B86A783D62A1B2FEC5CAB74CA2FF", hash_generated_method = "B099B86A783D62A1B2FEC5CAB74CA2FF")
    
ObjectStreamClass getSuperclass() {
        return superclass;
    }

    /**
     * Resolves the class properties, if they weren't already
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.363 -0500", hash_original_method = "742EA2900A6EB88CE28517352A724CD7", hash_generated_method = "34500EE607CF681AAABF6AB99F1567DF")
    
private void resolveProperties() {
        if (arePropertiesResolved) {
            return;
        }

        Class<?> cl = forClass();
        isProxy = Proxy.isProxyClass(cl);
        isEnum = Enum.class.isAssignableFrom(cl);
        isSerializable = isSerializable(cl);
        isExternalizable = isExternalizable(cl);

        arePropertiesResolved = true;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.366 -0500", hash_original_method = "250E0179C7C05D1D77B183DF06C38BC2", hash_generated_method = "250E0179C7C05D1D77B183DF06C38BC2")
    
boolean isSerializable() {
        resolveProperties();
        return isSerializable;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.368 -0500", hash_original_method = "86835294A15C6057A38D3AF0C7A856A1", hash_generated_method = "86835294A15C6057A38D3AF0C7A856A1")
    
boolean isExternalizable() {
        resolveProperties();
        return isExternalizable;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.371 -0500", hash_original_method = "052543446E0B6EEA498804C02394B590", hash_generated_method = "052543446E0B6EEA498804C02394B590")
    
boolean isProxy() {
        resolveProperties();
        return isProxy;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.373 -0500", hash_original_method = "23781B8C58B21A484CF86E4B23EBD9CC", hash_generated_method = "23781B8C58B21A484CF86E4B23EBD9CC")
    
boolean isEnum() {
        resolveProperties();
        return isEnum;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.398 -0500", hash_original_method = "8B291B650661131936FFDD0976F9C451", hash_generated_method = "8B291B650661131936FFDD0976F9C451")
    
boolean hasMethodWriteReplace() {
        //return (methodWriteReplace != null);
        return (methodWriteReplace.getTaintBoolean());
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.401 -0500", hash_original_method = "42662B3DE24059CFD85E0D286320D7E3", hash_generated_method = "42662B3DE24059CFD85E0D286320D7E3")
    
Method getMethodWriteReplace() {
        return methodWriteReplace;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.403 -0500", hash_original_method = "2852DBB1E5C3B0D1351FCC53EE3E49ED", hash_generated_method = "2852DBB1E5C3B0D1351FCC53EE3E49ED")
    
boolean hasMethodReadResolve() {
        //return (methodReadResolve != null);
        return (methodReadResolve.getTaintBoolean());
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.405 -0500", hash_original_method = "4E87A71E13632BD19F893729646A7048", hash_generated_method = "4E87A71E13632BD19F893729646A7048")
    
Method getMethodReadResolve() {
        return methodReadResolve;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.407 -0500", hash_original_method = "5A79EE26139C94EE3C3A1C73D8050C0E", hash_generated_method = "5A79EE26139C94EE3C3A1C73D8050C0E")
    
boolean hasMethodWriteObject() {
        return (methodWriteObject.getTaintBoolean());
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.409 -0500", hash_original_method = "234967F1224E01D561A4A7AA93A723BD", hash_generated_method = "234967F1224E01D561A4A7AA93A723BD")
    
Method getMethodWriteObject() {
        return methodWriteObject;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.412 -0500", hash_original_method = "46A702B5AEFAE4B1088A7C3DF1FC5D53", hash_generated_method = "46A702B5AEFAE4B1088A7C3DF1FC5D53")
    
boolean hasMethodReadObject() {
        return (methodReadObject.getTaintBoolean());
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.414 -0500", hash_original_method = "46960222BC0B63A6D59A57191BB77464", hash_generated_method = "46960222BC0B63A6D59A57191BB77464")
    
Method getMethodReadObject() {
        return methodReadObject;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.417 -0500", hash_original_method = "29BCBE89B6EA217724D7699109546E15", hash_generated_method = "29BCBE89B6EA217724D7699109546E15")
    
boolean hasMethodReadObjectNoData() {
        return (methodReadObjectNoData.getTaintBoolean());
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.419 -0500", hash_original_method = "04BED52E799E809DB8DD364039964962", hash_generated_method = "04BED52E799E809DB8DD364039964962")
    
Method getMethodReadObjectNoData() {
        return methodReadObjectNoData;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.421 -0500", hash_original_method = "971C620E95BDC0255A7014EB736B5315", hash_generated_method = "971C620E95BDC0255A7014EB736B5315")
    
void initPrivateFields(ObjectStreamClass desc) {
        methodWriteReplace = desc.methodWriteReplace;
        methodReadResolve = desc.methodReadResolve;
        methodWriteObject = desc.methodWriteObject;
        methodReadObject = desc.methodReadObject;
        methodReadObjectNoData = desc.methodReadObjectNoData;
    }
    static {
        try {
            ARRAY_OF_FIELDS = Class.forName("[Ljava.io.ObjectStreamField;");
        } catch (ClassNotFoundException e) {
            throw new AssertionError(e);
        }
    }

    /**
     * Set the class (java.lang.Class) that the receiver represents
     *
     * @param c
     *            aClass, the new class that the receiver describes
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.424 -0500", hash_original_method = "7A3AD0F8FFB276A7B1543CE5BED00A8C", hash_generated_method = "7A3AD0F8FFB276A7B1543CE5BED00A8C")
    
void setClass(Class<?> c) {
        resolvedClass = c;
    }

    /**
     * Set the collection of field descriptors for the fields of the
     * corresponding class
     *
     * @param f
     *            ObjectStreamField[], the receiver's new collection of declared
     *            fields for the class it represents
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.427 -0500", hash_original_method = "95CB44F7E664D85BD475B63456D19F48", hash_generated_method = "95CB44F7E664D85BD475B63456D19F48")
    
void setFields(ObjectStreamField[] f) {
        fields = f;
    }

    /**
     * Set the collection of field descriptors for the input fields of the
     * corresponding class
     *
     * @param f
     *            ObjectStreamField[], the receiver's new collection of input
     *            fields for the class it represents
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.429 -0500", hash_original_method = "BCDE99C62E7E698332D80A91E945CB98", hash_generated_method = "BCDE99C62E7E698332D80A91E945CB98")
    
void setLoadFields(ObjectStreamField[] f) {
        loadFields = f;
    }

    /**
     * Set the flags for this descriptor, where possible combined values are
     *
     * ObjectStreamConstants.SC_WRITE_METHOD
     * ObjectStreamConstants.SC_SERIALIZABLE
     * ObjectStreamConstants.SC_EXTERNALIZABLE
     *
     * @param b
     *            byte, the receiver's new flags for the class it represents
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.431 -0500", hash_original_method = "576B4ED3621FB044BCB61FA4A013466B", hash_generated_method = "576B4ED3621FB044BCB61FA4A013466B")
    
void setFlags(byte b) {
        flags = b;
    }

    /**
     * Set the name of the class represented by the receiver
     *
     * @param newName
     *            a String, the new fully qualified name of the class the
     *            receiver represents
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.433 -0500", hash_original_method = "013A745A10FFAC0063C18ECA8D35B13C", hash_generated_method = "013A745A10FFAC0063C18ECA8D35B13C")
    
void setName(String newName) {
        className = newName;
    }

    /**
     * Set the Serial Version User ID of the class represented by the receiver
     *
     * @param l
     *            a long, the new SUID for the class represented by the receiver
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.435 -0500", hash_original_method = "F5AE79B32CCC15982EBF3437ADD142B6", hash_generated_method = "F5AE79B32CCC15982EBF3437ADD142B6")
    
void setSerialVersionUID(long l) {
        svUID = l;
    }

    /**
     * Set the descriptor for the superclass of the class described by the
     * receiver
     *
     * @param c
     *            an ObjectStreamClass, the new ObjectStreamClass for the
     *            superclass of the class represented by the receiver
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.437 -0500", hash_original_method = "0C66D1C8E17ECB3824AFA99C964D873A", hash_generated_method = "0C66D1C8E17ECB3824AFA99C964D873A")
    
void setSuperclass(ObjectStreamClass c) {
        superclass = c;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.440 -0500", hash_original_method = "555F932795060D0A381054093FA5AE4C", hash_generated_method = "05142541EFC82F6D90BAECD39A06BF52")
    
private int primitiveSize(Class<?> type) {
        if (type == byte.class || type == boolean.class) {
            return 1;
        }
        if (type == short.class || type == char.class) {
            return 2;
        }
        if (type == int.class || type == float.class) {
            return 4;
        }
        if (type == long.class || type == double.class) {
            return 8;
        }
        throw new AssertionError();
    }

    /**
     * Returns a string containing a concise, human-readable description of this
     * descriptor.
     *
     * @return a printable representation of this descriptor.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:48.443 -0500", hash_original_method = "0689970A4402522168D5BA272C87560D", hash_generated_method = "5221D52B2EE9B6519F8D992F992A07B8")
    
@Override
    public String toString() {
        return getName() + ": static final long serialVersionUID =" + getSerialVersionUID() + "L;";
    }
    // orphaned legacy method
    
    public int compare(Class<?> itf1, Class<?> itf2) {
		return itf1.getName().compareTo(itf2.getName());
	}
    
    // orphaned legacy method
    public WeakHashMap<Class<?>, ObjectStreamClass> initialValue() {
		return new WeakHashMap<Class<?>, ObjectStreamClass>();
	}
    
    // orphaned legacy method
    public int compare(Method m1, Method m2) {
		int result = m1.getName().compareTo(m2.getName());
		if (result == 0) {
			return getMethodSignature(m1).compareTo(getMethodSignature(m2));
		}
		return result;
	}
    
    // orphaned legacy method
    
    public int compare(Constructor<?> ctr1, Constructor<?> ctr2) {
		return (getConstructorSignature(ctr1).compareTo(getConstructorSignature(ctr2)));
	}
    
    // orphaned legacy method
    
    public int compare(Field field1, Field field2) {
		return field1.getName().compareTo(field2.getName());
	}
    
}

