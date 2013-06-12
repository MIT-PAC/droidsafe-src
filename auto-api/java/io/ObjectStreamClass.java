package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

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

public class ObjectStreamClass implements Serializable {
    private static final long serialVersionUID = -6120832682080437368L;
    private static final String UID_FIELD_NAME = "serialVersionUID";
    static final long CONSTRUCTOR_IS_NOT_RESOLVED = -1;
    private static final int CLASS_MODIFIERS_MASK = Modifier.PUBLIC | Modifier.FINAL |
            Modifier.INTERFACE | Modifier.ABSTRACT;
    private static final int FIELD_MODIFIERS_MASK = Modifier.PUBLIC | Modifier.PRIVATE |
            Modifier.PROTECTED | Modifier.STATIC | Modifier.FINAL | Modifier.VOLATILE |
            Modifier.TRANSIENT;
    private static final int METHOD_MODIFIERS_MASK = Modifier.PUBLIC | Modifier.PRIVATE |
            Modifier.PROTECTED | Modifier.STATIC | Modifier.FINAL | Modifier.SYNCHRONIZED |
            Modifier.NATIVE | Modifier.ABSTRACT | Modifier.STRICT;
    private static final Class<?>[] READ_PARAM_TYPES = new Class[] { ObjectInputStream.class };
    private static final Class<?>[] WRITE_PARAM_TYPES = new Class[] { ObjectOutputStream.class };
    public static final ObjectStreamField[] NO_FIELDS = new ObjectStreamField[0];
    static final Class<?> ARRAY_OF_FIELDS;
    private static final String CLINIT_NAME = "<clinit>";
    private static final int CLINIT_MODIFIERS = Modifier.STATIC;
    private static final String CLINIT_SIGNATURE = "()V";
    private static final Class<Serializable> SERIALIZABLE = Serializable.class;
    private static final Class<Externalizable> EXTERNALIZABLE = Externalizable.class;
    static final Class<String> STRINGCLASS = String.class;
    static final Class<?> CLASSCLASS = Class.class;
    static final Class<ObjectStreamClass> OBJECTSTREAMCLASSCLASS = ObjectStreamClass.class;
    private transient Method methodWriteReplace;
    private transient Method methodReadResolve;
    private transient Method methodWriteObject;
    private transient Method methodReadObject;
    private transient Method methodReadObjectNoData;
    private transient boolean arePropertiesResolved;
    private transient boolean isSerializable;
    private transient boolean isExternalizable;
    private transient boolean isProxy;
    private transient boolean isEnum;
    private transient String className;
    private transient Class<?> resolvedClass;
    private transient Class<?> resolvedConstructorClass;
    private transient int resolvedConstructorMethodId;
    private transient long svUID;
    private transient byte flags;
    private transient ObjectStreamClass superclass;
    private transient ObjectStreamField[] fields;
    private transient ObjectStreamField[] loadFields;
    private transient HashMap<ObjectStreamField, Field> reflectionFields =
            new HashMap<ObjectStreamField, Field>();
    private transient long constructor = CONSTRUCTOR_IS_NOT_RESOLVED;
    private transient volatile List<ObjectStreamClass> cachedHierarchy;
    private static SoftReference<ThreadLocal<WeakHashMap<Class<?>, ObjectStreamClass>>> storage =
            new SoftReference<ThreadLocal<WeakHashMap<Class<?>, ObjectStreamClass>>>(null);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.619 -0400", hash_original_method = "F4D9898A03FC0DADA999BF46D97F9433", hash_generated_method = "D6A7B0292354513CA9EF8C9E6F9C7CFB")
    @DSModeled(DSC.SAFE)
     ObjectStreamClass() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.619 -0400", hash_original_method = "7053F33417C9644BFD49070B9EF96C54", hash_generated_method = "350092DC40DF44EFAD36AD0212B4AC79")
    @DSModeled(DSC.SAFE)
     void setConstructor(long newConstructor) {
        dsTaint.addTaint(newConstructor);
        // ---------- Original Method ----------
        //constructor = newConstructor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.619 -0400", hash_original_method = "AE977884038645FC18D9650C0686387C", hash_generated_method = "D89037FF7512309C3BC6AD8E07C5F426")
    @DSModeled(DSC.SAFE)
     long getConstructor() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return constructor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.620 -0400", hash_original_method = "592D0703821799AB937A99A67AB05B5C", hash_generated_method = "5982F124C3B3BA1BDCDD185095E6B95B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Field getReflectionField(ObjectStreamField osf) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(osf.dsTaint);
        {
            Field field;
            field = reflectionFields.get(osf);
        } //End block
        try 
        {
            Class<?> declaringClass;
            declaringClass = forClass();
            Field field;
            field = declaringClass.getDeclaredField(osf.getName());
            field.setAccessible(true);
            {
                reflectionFields.put(osf, field);
            } //End block
            Field varD725508B623A3D120B2EA4039D10E9A2_365509907 = (reflectionFields.get(osf));
        } //End block
        catch (NoSuchFieldException ex)
        { }
        return (Field)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (reflectionFields) {
            //Field field = reflectionFields.get(osf);
            //if (field != null) {
                //return field;
            //}
        //}
        //try {
            //Class<?> declaringClass = forClass();
            //Field field = declaringClass.getDeclaredField(osf.getName());
            //field.setAccessible(true);
            //synchronized (reflectionFields) {
                //reflectionFields.put(osf, field);
            //}
            //return reflectionFields.get(osf);
        //} catch (NoSuchFieldException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.620 -0400", hash_original_method = "EE95B522B106FAE9E2BC75AC9A53C7A8", hash_generated_method = "DC30E68382F98514F5FB1275F0A22A11")
    private static ObjectStreamClass createClassDesc(Class<?> cl) {
        ObjectStreamClass result = new ObjectStreamClass();
        boolean isArray = cl.isArray();
        boolean serializable = isSerializable(cl);
        boolean externalizable = isExternalizable(cl);
        result.isSerializable = serializable;
        result.isExternalizable = externalizable;
        result.setName(cl.getName());
        result.setClass(cl);
        Class<?> superclass = cl.getSuperclass();
        if (superclass != null) {
            result.setSuperclass(lookup(superclass));
        }
        Field[] declaredFields = null;
        if (serializable || externalizable) {
            if (result.isEnum() || result.isProxy()) {
                result.setSerialVersionUID(0L);
            } else {
                declaredFields = cl.getDeclaredFields();
                result.setSerialVersionUID(computeSerialVersionUID(cl, declaredFields));
            }
        }
        if (serializable && !isArray) {
            if (declaredFields == null) {
                declaredFields = cl.getDeclaredFields();
            }
            result.buildFieldDescriptors(declaredFields);
        } else {
            result.setFields(NO_FIELDS);
        }
        ObjectStreamField[] fields = result.getFields();
        if (fields != null) {
            ObjectStreamField[] loadFields = new ObjectStreamField[fields.length];
            for (int i = 0; i < fields.length; ++i) {
                loadFields[i] = new ObjectStreamField(fields[i].getName(),
                        fields[i].getType(), fields[i].isUnshared());
                loadFields[i].getTypeString();
            }
            result.setLoadFields(loadFields);
        }
        byte flags = 0;
        if (externalizable) {
            flags |= ObjectStreamConstants.SC_EXTERNALIZABLE;
            flags |= ObjectStreamConstants.SC_BLOCK_DATA; 
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.620 -0400", hash_original_method = "3492CF41320405C3965233DAB60A3EF1", hash_generated_method = "BD4CA9E755C0EB367F42F05658195BDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void buildFieldDescriptors(Field[] declaredFields) {
        dsTaint.addTaint(declaredFields.dsTaint);
        final Field f;
        f = ObjectStreamClass.fieldSerialPersistentFields(this.forClass());
        boolean useReflectFields;
        useReflectFields = f == null;
        ObjectStreamField[] _fields;
        _fields = null;
        {
            f.setAccessible(true);
            try 
            {
                _fields = (ObjectStreamField[]) f.get(null);
            } //End block
            catch (IllegalAccessException ex)
            {
                throw new AssertionError(ex);
            } //End block
        } //End block
        {
            List<ObjectStreamField> serializableFields;
            serializableFields = new ArrayList<ObjectStreamField>(declaredFields.length);
            {
                Iterator<Field> seatecAstronomy42 = declaredFields.iterator();
                seatecAstronomy42.hasNext();
                Field declaredField = seatecAstronomy42.next();
                {
                    int modifiers;
                    modifiers = declaredField.getModifiers();
                    {
                        boolean var0B0C4470A78EE89D4D1877A6DDF6E76D_1590339905 = (!Modifier.isStatic(modifiers) && !Modifier.isTransient(modifiers));
                        {
                            ObjectStreamField field;
                            field = new ObjectStreamField(declaredField.getName(),
                            declaredField.getType());
                            serializableFields.add(field);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                boolean varFDB496ED83E038616C56C9314DBD5FA6_893892644 = (serializableFields.size() == 0);
                {
                    _fields = NO_FIELDS;
                } //End block
                {
                    _fields = serializableFields.toArray(new ObjectStreamField[serializableFields.size()]);
                } //End block
            } //End collapsed parenthetic
        } //End block
        Arrays.sort(_fields);
        int primOffset, objectOffset;
        primOffset = 0;
        objectOffset = 0;
        {
            int i;
            i = 0;
            {
                Class<?> type;
                type = _fields[i].getType();
                {
                    boolean varA97A53306537CEF5EB846AEB112A7855_774651061 = (type.isPrimitive());
                    {
                        _fields[i].offset = primOffset;
                        primOffset += primitiveSize(type);
                    } //End block
                    {
                        _fields[i].offset = objectOffset++;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        fields = _fields;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.621 -0400", hash_original_method = "68E06AEE7CCE863400565C48D48B7448", hash_generated_method = "B4DF7FBB85B90119B0C59240225F0BF2")
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
                    public int compare(Constructor<?> ctr1, Constructor<?> ctr2) {
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
                    public int compare(Method m1, Method m2) {
                        int result = m1.getName().compareTo(m2.getName());
                        if (result == 0) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.621 -0400", hash_original_method = "218236478243591CE821F4BA590E81DD", hash_generated_method = "ABBE47BB0144736314470898AAF5A980")
    private static String descriptorForFieldSignature(String signature) {
        return signature.replace('.', '/');
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.621 -0400", hash_original_method = "2440EA3F17E46E83B0C55915F3096F8E", hash_generated_method = "C5D9C7488210A8FCBCD98983FD46923D")
    private static String descriptorForSignature(String signature) {
        return signature.substring(signature.indexOf("("));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.621 -0400", hash_original_method = "96D2879811B04BE03B81870D013DA6FA", hash_generated_method = "90A5BF4D32FDB1ECC4E66DFA7B37CB70")
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
        }
        return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.621 -0400", hash_original_method = "3FC829F6BB79347D76007A55E3423470", hash_generated_method = "DF426345C68227165D39D42DFAB3D3DE")
    @DSModeled(DSC.SAFE)
    public Class<?> forClass() {
        return (Class<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return resolvedClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.621 -0400", hash_original_method = "CFDAB7386CDDDD8EC35152CD7D073792", hash_generated_method = "86FFED18946B9E644BB3A00A9DF58B86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Object newInstance(Class<?> instantiationClass) throws InvalidClassException {
        dsTaint.addTaint(instantiationClass.dsTaint);
        resolveConstructorClass(instantiationClass);
        Object varD04EE31C879DA25E3454A86A6F86461E_274407365 = (newInstance(instantiationClass, resolvedConstructorMethodId));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //resolveConstructorClass(instantiationClass);
        //return newInstance(instantiationClass, resolvedConstructorMethodId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.621 -0400", hash_original_method = "9DB5F04D2345DC121956725FD4475E83", hash_generated_method = "1D4DEDB1038117766248B0460C42AE40")
    private static Object newInstance(Class<?> instantiationClass, int methodId) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.621 -0400", hash_original_method = "66A47A19F5FB8C837FA66140F62CB154", hash_generated_method = "1CF3BED9A0DF28F7EDD8030E7AA85FAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Class<?> resolveConstructorClass(Class<?> objectClass) throws InvalidClassException {
        dsTaint.addTaint(objectClass.dsTaint);
        Class<?> constructorClass;
        constructorClass = objectClass;
        boolean wasSerializable;
        wasSerializable = (flags & ObjectStreamConstants.SC_SERIALIZABLE) != 0;
        {
            {
                boolean varFDE4CBEE93EED52DBC15AAE1ACE55609_1021605297 = (constructorClass != null && ObjectStreamClass.isSerializable(constructorClass));
                {
                    constructorClass = constructorClass.getSuperclass();
                } //End block
            } //End collapsed parenthetic
        } //End block
        Constructor<?> constructor;
        constructor = null;
        {
            try 
            {
                constructor = constructorClass.getDeclaredConstructor(EmptyArray.CLASS);
            } //End block
            catch (NoSuchMethodException ignored)
            { }
        } //End block
        {
            String className;
            className = constructorClass.getName();
            className = null;
            throw new InvalidClassException(className, "IllegalAccessException");
        } //End block
        int constructorModifiers;
        constructorModifiers = constructor.getModifiers();
        boolean isPublic;
        isPublic = Modifier.isPublic(constructorModifiers);
        boolean isProtected;
        isProtected = Modifier.isProtected(constructorModifiers);
        boolean isPrivate;
        isPrivate = Modifier.isPrivate(constructorModifiers);
        boolean wasExternalizable;
        wasExternalizable = (flags & ObjectStreamConstants.SC_EXTERNALIZABLE) != 0;
        {
            throw new InvalidClassException(constructorClass.getName(), "IllegalAccessException");
        } //End block
        {
            {
                boolean var01C93A2AE05D9878C907DF6E9F64ECCC_219800935 = (!inSamePackage(constructorClass, objectClass));
                {
                    throw new InvalidClassException(constructorClass.getName(), "IllegalAccessException");
                } //End block
            } //End collapsed parenthetic
        } //End block
        resolvedConstructorClass = constructorClass;
        resolvedConstructorMethodId = getConstructorId(resolvedConstructorClass);
        return (Class<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.621 -0400", hash_original_method = "47FFFC8DB7B413C50329191F7D22936C", hash_generated_method = "49FA9FF50A6B1279530D73CA44BDD33E")
    private static int getConstructorId(Class<?> c) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.621 -0400", hash_original_method = "C730C766F4F6CE91266CBA72D38C529A", hash_generated_method = "AFA64B31027034AD578C55FADE0B2CA1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean inSamePackage(Class<?> c1, Class<?> c2) {
        dsTaint.addTaint(c1.dsTaint);
        dsTaint.addTaint(c2.dsTaint);
        String nameC1;
        nameC1 = c1.getName();
        String nameC2;
        nameC2 = c2.getName();
        int indexDotC1;
        indexDotC1 = nameC1.lastIndexOf('.');
        int indexDotC2;
        indexDotC2 = nameC2.lastIndexOf('.');
        boolean var16017E65E75A0A549986C98F6129AABC_1137495456 = (nameC1.regionMatches(0, nameC2, 0, indexDotC1));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //String nameC1 = c1.getName();
        //String nameC2 = c2.getName();
        //int indexDotC1 = nameC1.lastIndexOf('.');
        //int indexDotC2 = nameC2.lastIndexOf('.');
        //if (indexDotC1 != indexDotC2) {
            //return false; 
        //}
        //if (indexDotC1 == -1) {
            //return true; 
        //}
        //return nameC1.regionMatches(0, nameC2, 0, indexDotC1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.622 -0400", hash_original_method = "492915BBB1E6EFE96AEDB3519982807A", hash_generated_method = "379FFF0E54A1E682A5FAA0C6DE30BB6E")
    static String getConstructorSignature(Constructor<?> c) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.622 -0400", hash_original_method = "58A307C728457592549C73808957655C", hash_generated_method = "4A7873D8A846AC4DBB7195526D9519FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ObjectStreamField getField(String name) {
        dsTaint.addTaint(name);
        ObjectStreamField[] allFields;
        allFields = getFields();
        {
            int i;
            i = 0;
            {
                ObjectStreamField f;
                f = allFields[i];
                {
                    boolean var32E5452974F5912B0D1DFCF62E31A958_1480883764 = (f.getName().equals(name));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (ObjectStreamField)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ObjectStreamField[] allFields = getFields();
        //for (int i = 0; i < allFields.length; i++) {
            //ObjectStreamField f = allFields[i];
            //if (f.getName().equals(name)) {
                //return f;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.622 -0400", hash_original_method = "3D80A7A04F3988E3E464D888981C4A01", hash_generated_method = "079056DC94976F1108A56CA3E0F9B48A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ObjectStreamField[] fields() {
        {
            Class<?> forCl;
            forCl = forClass();
            {
                boolean var793D8E01C16F5EE9855A6887A9C40654_405434064 = (forCl != null && isSerializable() && !forCl.isArray());
                {
                    buildFieldDescriptors(forCl.getDeclaredFields());
                } //End block
                {
                    setFields(NO_FIELDS);
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (ObjectStreamField[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (fields == null) {
            //Class<?> forCl = forClass();
            //if (forCl != null && isSerializable() && !forCl.isArray()) {
                //buildFieldDescriptors(forCl.getDeclaredFields());
            //} else {
                //setFields(NO_FIELDS);
            //}
        //}
        //return fields;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.622 -0400", hash_original_method = "BA69DA3B5E6C7F20CA233B877CCB0384", hash_generated_method = "D0B6543436CAC97274C49B86FAD976D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ObjectStreamField[] getFields() {
        copyFieldAttributes();
        {
            Object var724A75ED62EC2D3B03408921AE3D7374_130784505 = (fields().clone());
            Object varFEC1ED2628BE881835AA100557350A1B_730650311 = (loadFields.clone());
        } //End flattened ternary
        return (ObjectStreamField[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //copyFieldAttributes();
        //return loadFields == null ? fields().clone() : loadFields.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.622 -0400", hash_original_method = "8AA71837DDE89491F51C878CBC8B38A5", hash_generated_method = "E68F7E5E08DF9688B7259A1F1DABB627")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     List<ObjectStreamClass> getHierarchy() {
        List<ObjectStreamClass> result;
        result = cachedHierarchy;
        {
            cachedHierarchy = result = makeHierarchy();
        } //End block
        return (List<ObjectStreamClass>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //List<ObjectStreamClass> result = cachedHierarchy;
        //if (result == null) {
            //cachedHierarchy = result = makeHierarchy();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.622 -0400", hash_original_method = "970C4D30E4F07A217EB44CA0880B9D33", hash_generated_method = "D3083946285F736586FFF38BE6100374")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private List<ObjectStreamClass> makeHierarchy() {
        ArrayList<ObjectStreamClass> result;
        result = new ArrayList<ObjectStreamClass>();
        {
            ObjectStreamClass osc;
            osc = this;
            osc = osc.getSuperclass();
            {
                result.add(0, osc);
            } //End block
        } //End collapsed parenthetic
        return (List<ObjectStreamClass>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ArrayList<ObjectStreamClass> result = new ArrayList<ObjectStreamClass>();
        //for (ObjectStreamClass osc = this; osc != null; osc = osc.getSuperclass()) {
            //result.add(0, osc);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.622 -0400", hash_original_method = "F57C7EC559BF09EB03BA0EA2BC063E8F", hash_generated_method = "FE324FAC8E223FA3F861CE509584FDCE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void copyFieldAttributes() {
        {
            int i;
            i = 0;
            {
                ObjectStreamField loadField;
                loadField = loadFields[i];
                String name;
                name = loadField.getName();
                {
                    int j;
                    j = 0;
                    {
                        ObjectStreamField field;
                        field = fields[j];
                        {
                            boolean var249D9F14035FBD16E855916C4D99FDA9_594259276 = (name.equals(field.getName()));
                            {
                                loadField.setUnshared(field.isUnshared());
                                loadField.setOffset(field.getOffset());
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if ((loadFields == null) || fields == null) {
            //return;
        //}
        //for (int i = 0; i < loadFields.length; i++) {
            //ObjectStreamField loadField = loadFields[i];
            //String name = loadField.getName();
            //for (int j = 0; j < fields.length; j++) {
                //ObjectStreamField field = fields[j];
                //if (name.equals(field.getName())) {
                    //loadField.setUnshared(field.isUnshared());
                    //loadField.setOffset(field.getOffset());
                    //break;
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.622 -0400", hash_original_method = "8F334CDB84C81A51C0419AAF322CA87A", hash_generated_method = "FDB4B8A0A11C61388B5AB92AE5B83244")
    @DSModeled(DSC.SAFE)
     ObjectStreamField[] getLoadFields() {
        return (ObjectStreamField[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return loadFields;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.622 -0400", hash_original_method = "DE3AAEC04A2A3C5E11B0CAE1796F4FE4", hash_generated_method = "6AA3A0DC26AB32BA1A82183F5F074A3B")
    private static String getFieldSignature(Field f) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.622 -0400", hash_original_method = "CB224A404D2A4A24CFF7504565CB22F2", hash_generated_method = "D977ABBE21CFB352799197FDDB0AF495")
    @DSModeled(DSC.SAFE)
     byte getFlags() {
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //return flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.622 -0400", hash_original_method = "CBD407D4198617146BC229416539B1A9", hash_generated_method = "162D2E2FD1E02EB99F1855C171200DDC")
    static String getMethodSignature(Method m) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.622 -0400", hash_original_method = "4A271A070FBC29EF826D1B50170E00D2", hash_generated_method = "948D4335017D6A6EC3CD4571779BA167")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return className;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.622 -0400", hash_original_method = "50DDDA79153910C7DDC4FA6D8AF3586E", hash_generated_method = "43F80790142C3454228D7D9EAE0E9DFA")
    @DSModeled(DSC.SAFE)
    public long getSerialVersionUID() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return svUID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.622 -0400", hash_original_method = "B099B86A783D62A1B2FEC5CAB74CA2FF", hash_generated_method = "00C92F24ED4A9CAAD4F3A95D0BED3811")
    @DSModeled(DSC.SAFE)
     ObjectStreamClass getSuperclass() {
        return (ObjectStreamClass)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return superclass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.623 -0400", hash_original_method = "5FABFFE4976E203C5A9763AC936D8AB6", hash_generated_method = "4CCD2B56BB6690CED4391323335E2351")
    private static boolean hasClinit(Class<?> cl) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.623 -0400", hash_original_method = "FDF4BA7EF329EAA2CE64F9956BF205C6", hash_generated_method = "F4EDCF3F853EC659B04101229D5E120B")
    static boolean isExternalizable(Class<?> cl) {
        return EXTERNALIZABLE.isAssignableFrom(cl);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.623 -0400", hash_original_method = "6FE1F5C82C04AB08E12223950D7EB08A", hash_generated_method = "0970F67E09B2A5AAF9041B560FB4FFF3")
    static boolean isPrimitiveType(char typecode) {
        return !(typecode == '[' || typecode == 'L');
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.623 -0400", hash_original_method = "1C1B1909AD548F77B8D4A1B7F72F485A", hash_generated_method = "6757B2545B287A28286565B96FCAA48C")
    static boolean isSerializable(Class<?> cl) {
        return SERIALIZABLE.isAssignableFrom(cl);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.623 -0400", hash_original_method = "742EA2900A6EB88CE28517352A724CD7", hash_generated_method = "4C079CCE5FA78C973A67E607C58E1F7B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void resolveProperties() {
        Class<?> cl;
        cl = forClass();
        isProxy = Proxy.isProxyClass(cl);
        isEnum = Enum.class.isAssignableFrom(cl);
        isSerializable = isSerializable(cl);
        isExternalizable = isExternalizable(cl);
        arePropertiesResolved = true;
        // ---------- Original Method ----------
        //if (arePropertiesResolved) {
            //return;
        //}
        //Class<?> cl = forClass();
        //isProxy = Proxy.isProxyClass(cl);
        //isEnum = Enum.class.isAssignableFrom(cl);
        //isSerializable = isSerializable(cl);
        //isExternalizable = isExternalizable(cl);
        //arePropertiesResolved = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.623 -0400", hash_original_method = "250E0179C7C05D1D77B183DF06C38BC2", hash_generated_method = "8765023651CC8D2B3C2210FD04900B84")
    @DSModeled(DSC.SAFE)
     boolean isSerializable() {
        resolveProperties();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //resolveProperties();
        //return isSerializable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.623 -0400", hash_original_method = "86835294A15C6057A38D3AF0C7A856A1", hash_generated_method = "254FFCEE203DE6E6EE2F8B62E4F46719")
    @DSModeled(DSC.SAFE)
     boolean isExternalizable() {
        resolveProperties();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //resolveProperties();
        //return isExternalizable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.623 -0400", hash_original_method = "052543446E0B6EEA498804C02394B590", hash_generated_method = "1E88838B4D74E988D6F706CB7D04049D")
    @DSModeled(DSC.SAFE)
     boolean isProxy() {
        resolveProperties();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //resolveProperties();
        //return isProxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.623 -0400", hash_original_method = "23781B8C58B21A484CF86E4B23EBD9CC", hash_generated_method = "383B8018D05BB2CD2B0E822387512D87")
    @DSModeled(DSC.SAFE)
     boolean isEnum() {
        resolveProperties();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //resolveProperties();
        //return isEnum;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.623 -0400", hash_original_method = "4E9665B66F7E0C974FC483540841948D", hash_generated_method = "CE2898CC9C78E94F0A6BE8C3E14BB4E9")
    public static ObjectStreamClass lookup(Class<?> cl) {
        ObjectStreamClass osc = lookupStreamClass(cl);
        return (osc.isSerializable() || osc.isExternalizable()) ? osc : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.623 -0400", hash_original_method = "982D878B5D9789546161AA6A5787B81A", hash_generated_method = "FA778DEB818C9C440A8ED2F5F9D4FBB2")
    public static ObjectStreamClass lookupAny(Class<?> cl) {
        return lookupStreamClass(cl);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.623 -0400", hash_original_method = "B7C56FB22E8F4B2B6633F52B26078E29", hash_generated_method = "DB71443E3123CE8B4711D6791B0D923F")
    static ObjectStreamClass lookupStreamClass(Class<?> cl) {
        WeakHashMap<Class<?>, ObjectStreamClass> tlc = getCache();
        ObjectStreamClass cachedValue = tlc.get(cl);
        if (cachedValue == null) {
            cachedValue = createClassDesc(cl);
            tlc.put(cl, cachedValue);
        }
        return cachedValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.623 -0400", hash_original_method = "BEB8966DF391A95FA8B87FE718027911", hash_generated_method = "8810CB9D2A65598D62D1C0ADD8DA521C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.623 -0400", hash_original_method = "B0BA66A83CE642C4DD80DDEEFA7F6EBC", hash_generated_method = "A96091188E14B3C0996F8E224B35FC6E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.623 -0400", hash_original_method = "8084AF2768C65A12352E4FA34C16662E", hash_generated_method = "0E63B5919CEE3199ABC6DD2FBFC872A9")
    static Method findPrivateMethod(Class<?> cl, String methodName,
            Class<?>[] param) {
        try {
            Method method = cl.getDeclaredMethod(methodName, param);
            if (Modifier.isPrivate(method.getModifiers()) && method.getReturnType() == void.class) {
                method.setAccessible(true);
                return method;
            }
        } catch (NoSuchMethodException nsm) {
        }
        return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.623 -0400", hash_original_method = "8B291B650661131936FFDD0976F9C451", hash_generated_method = "812F95BC7CB6B61E37BEE61611CA17BA")
    @DSModeled(DSC.SAFE)
     boolean hasMethodWriteReplace() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (methodWriteReplace != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.623 -0400", hash_original_method = "42662B3DE24059CFD85E0D286320D7E3", hash_generated_method = "83FE3FDEC6BC0C32B03EA45ED34C647C")
    @DSModeled(DSC.SAFE)
     Method getMethodWriteReplace() {
        return (Method)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return methodWriteReplace;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.627 -0400", hash_original_method = "2852DBB1E5C3B0D1351FCC53EE3E49ED", hash_generated_method = "E5171626481E9B6163A6CF8F7B5C3AD6")
    @DSModeled(DSC.SAFE)
     boolean hasMethodReadResolve() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (methodReadResolve != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.627 -0400", hash_original_method = "4E87A71E13632BD19F893729646A7048", hash_generated_method = "1B296307C58F1F140DD98EB19B526630")
    @DSModeled(DSC.SAFE)
     Method getMethodReadResolve() {
        return (Method)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return methodReadResolve;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.627 -0400", hash_original_method = "5A79EE26139C94EE3C3A1C73D8050C0E", hash_generated_method = "EB9688317A3A51E7C861C8AF9F32DEC2")
    @DSModeled(DSC.SAFE)
     boolean hasMethodWriteObject() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (methodWriteObject != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.628 -0400", hash_original_method = "234967F1224E01D561A4A7AA93A723BD", hash_generated_method = "7D8B0BFEC785F30732F0294CB0F5E164")
    @DSModeled(DSC.SAFE)
     Method getMethodWriteObject() {
        return (Method)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return methodWriteObject;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.628 -0400", hash_original_method = "46A702B5AEFAE4B1088A7C3DF1FC5D53", hash_generated_method = "86D54232F13C2E93A35F9FF4A1E96585")
    @DSModeled(DSC.SAFE)
     boolean hasMethodReadObject() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (methodReadObject != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.628 -0400", hash_original_method = "46960222BC0B63A6D59A57191BB77464", hash_generated_method = "0259C8DCD445C52F8FDC7A270A566B6C")
    @DSModeled(DSC.SAFE)
     Method getMethodReadObject() {
        return (Method)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return methodReadObject;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.628 -0400", hash_original_method = "29BCBE89B6EA217724D7699109546E15", hash_generated_method = "B132149C6CB60D988B3C3075DA1A8082")
    @DSModeled(DSC.SAFE)
     boolean hasMethodReadObjectNoData() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (methodReadObjectNoData != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.628 -0400", hash_original_method = "04BED52E799E809DB8DD364039964962", hash_generated_method = "808497C62E3C1AB7A7569D5A41064024")
    @DSModeled(DSC.SAFE)
     Method getMethodReadObjectNoData() {
        return (Method)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return methodReadObjectNoData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.628 -0400", hash_original_method = "971C620E95BDC0255A7014EB736B5315", hash_generated_method = "6B7AC4241BCB3AA25C6465617DF84574")
    @DSModeled(DSC.SAFE)
     void initPrivateFields(ObjectStreamClass desc) {
        dsTaint.addTaint(desc.dsTaint);
        methodWriteReplace = desc.methodWriteReplace;
        methodReadResolve = desc.methodReadResolve;
        methodWriteObject = desc.methodWriteObject;
        methodReadObject = desc.methodReadObject;
        methodReadObjectNoData = desc.methodReadObjectNoData;
        // ---------- Original Method ----------
        //methodWriteReplace = desc.methodWriteReplace;
        //methodReadResolve = desc.methodReadResolve;
        //methodWriteObject = desc.methodWriteObject;
        //methodReadObject = desc.methodReadObject;
        //methodReadObjectNoData = desc.methodReadObjectNoData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.628 -0400", hash_original_method = "7A3AD0F8FFB276A7B1543CE5BED00A8C", hash_generated_method = "6D54FE3E5F4C79A21A8CADE9C1E0C9E9")
    @DSModeled(DSC.SAFE)
     void setClass(Class<?> c) {
        dsTaint.addTaint(c.dsTaint);
        // ---------- Original Method ----------
        //resolvedClass = c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.628 -0400", hash_original_method = "95CB44F7E664D85BD475B63456D19F48", hash_generated_method = "8425EB96B921B5A97380F706DEA3787D")
    @DSModeled(DSC.SAFE)
     void setFields(ObjectStreamField[] f) {
        dsTaint.addTaint(f.dsTaint);
        // ---------- Original Method ----------
        //fields = f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.628 -0400", hash_original_method = "BCDE99C62E7E698332D80A91E945CB98", hash_generated_method = "7861B2E746ECBE51D22F76D89753772C")
    @DSModeled(DSC.SAFE)
     void setLoadFields(ObjectStreamField[] f) {
        dsTaint.addTaint(f.dsTaint);
        // ---------- Original Method ----------
        //loadFields = f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.628 -0400", hash_original_method = "576B4ED3621FB044BCB61FA4A013466B", hash_generated_method = "E95B91C77EE2A1D38AD16FE823694150")
    @DSModeled(DSC.SAFE)
     void setFlags(byte b) {
        dsTaint.addTaint(b);
        // ---------- Original Method ----------
        //flags = b;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.628 -0400", hash_original_method = "013A745A10FFAC0063C18ECA8D35B13C", hash_generated_method = "5F862D62B011745E7E2D2F327B22DFC5")
    @DSModeled(DSC.SAFE)
     void setName(String newName) {
        dsTaint.addTaint(newName);
        // ---------- Original Method ----------
        //className = newName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.628 -0400", hash_original_method = "F5AE79B32CCC15982EBF3437ADD142B6", hash_generated_method = "0B4893D026795FA35635D5C8241DCD45")
    @DSModeled(DSC.SAFE)
     void setSerialVersionUID(long l) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(l);
        // ---------- Original Method ----------
        //svUID = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.628 -0400", hash_original_method = "0C66D1C8E17ECB3824AFA99C964D873A", hash_generated_method = "FDC3178366ACB4CD8175EF35C75A922D")
    @DSModeled(DSC.SAFE)
     void setSuperclass(ObjectStreamClass c) {
        dsTaint.addTaint(c.dsTaint);
        // ---------- Original Method ----------
        //superclass = c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.628 -0400", hash_original_method = "555F932795060D0A381054093FA5AE4C", hash_generated_method = "8BEE0116ED39207B252CD58FF25D90B0")
    @DSModeled(DSC.SAFE)
    private int primitiveSize(Class<?> type) {
        dsTaint.addTaint(type.dsTaint);
        throw new AssertionError();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (type == byte.class || type == boolean.class) {
            //return 1;
        //}
        //if (type == short.class || type == char.class) {
            //return 2;
        //}
        //if (type == int.class || type == float.class) {
            //return 4;
        //}
        //if (type == long.class || type == double.class) {
            //return 8;
        //}
        //throw new AssertionError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.628 -0400", hash_original_method = "0689970A4402522168D5BA272C87560D", hash_generated_method = "D571A4817B3D3117236C78386299A5C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varDCAE4EE0B46960A781CF68E0E1D322C9_1894630502 = (getName() + ": static final long serialVersionUID =" + getSerialVersionUID() + "L;");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getName() + ": static final long serialVersionUID =" + getSerialVersionUID() + "L;";
    }

    
    static {
        try {
            ARRAY_OF_FIELDS = Class.forName("[Ljava.io.ObjectStreamField;");
        } catch (ClassNotFoundException e) {
            throw new AssertionError(e);
        }
    }
    
}


