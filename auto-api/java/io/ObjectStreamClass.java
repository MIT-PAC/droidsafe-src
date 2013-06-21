package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.136 -0400", hash_original_method = "F4D9898A03FC0DADA999BF46D97F9433", hash_generated_method = "A9246BC45205ECF4E818CF0D168C4ADC")
    @DSModeled(DSC.SAFE)
     ObjectStreamClass() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.136 -0400", hash_original_method = "7053F33417C9644BFD49070B9EF96C54", hash_generated_method = "5B9DDFE99B211925C9DE4CAF40E03361")
    @DSModeled(DSC.SAFE)
     void setConstructor(long newConstructor) {
        dsTaint.addTaint(newConstructor);
        // ---------- Original Method ----------
        //constructor = newConstructor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.136 -0400", hash_original_method = "AE977884038645FC18D9650C0686387C", hash_generated_method = "B5347027E7DCF31F08C6A2501D0BE54A")
    @DSModeled(DSC.SAFE)
     long getConstructor() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return constructor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.136 -0400", hash_original_method = "592D0703821799AB937A99A67AB05B5C", hash_generated_method = "76D0F79A58CDD6982D7AD87BFBA70C74")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Field getReflectionField(ObjectStreamField osf) {
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
            Field varD725508B623A3D120B2EA4039D10E9A2_728444493 = (reflectionFields.get(osf));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.144 -0400", hash_original_method = "3492CF41320405C3965233DAB60A3EF1", hash_generated_method = "CF24A2654F4C6FEBCE0A8FB40AE639A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void buildFieldDescriptors(Field[] declaredFields) {
        dsTaint.addTaint(declaredFields[0].dsTaint);
        Field f;
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
                if (DroidSafeAndroidRuntime.control) throw new AssertionError(ex);
            } //End block
        } //End block
        {
            List<ObjectStreamField> serializableFields;
            serializableFields = new ArrayList<ObjectStreamField>(declaredFields.length);
            {
                Field declaredField = declaredFields[0];
                {
                    int modifiers;
                    modifiers = declaredField.getModifiers();
                    {
                        boolean var0B0C4470A78EE89D4D1877A6DDF6E76D_1667677422 = (!Modifier.isStatic(modifiers) && !Modifier.isTransient(modifiers));
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
                boolean varFDB496ED83E038616C56C9314DBD5FA6_912967679 = (serializableFields.size() == 0);
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
                    boolean varA97A53306537CEF5EB846AEB112A7855_474595430 = (type.isPrimitive());
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

    
        private static String descriptorForFieldSignature(String signature) {
        return signature.replace('.', '/');
    }

    
        private static String descriptorForSignature(String signature) {
        return signature.substring(signature.indexOf("("));
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.146 -0400", hash_original_method = "3FC829F6BB79347D76007A55E3423470", hash_generated_method = "0681E16C1D5DA091C6D4502A9E289BFF")
    @DSModeled(DSC.SAFE)
    public Class<?> forClass() {
        return (Class<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return resolvedClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.146 -0400", hash_original_method = "CFDAB7386CDDDD8EC35152CD7D073792", hash_generated_method = "D07E72D28E248CD87D6BF0F474B3ACF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Object newInstance(Class<?> instantiationClass) throws InvalidClassException {
        dsTaint.addTaint(instantiationClass.dsTaint);
        resolveConstructorClass(instantiationClass);
        Object varD04EE31C879DA25E3454A86A6F86461E_1442085045 = (newInstance(instantiationClass, resolvedConstructorMethodId));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //resolveConstructorClass(instantiationClass);
        //return newInstance(instantiationClass, resolvedConstructorMethodId);
    }

    
        private static Object newInstance(Class<?> instantiationClass, int methodId) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.147 -0400", hash_original_method = "66A47A19F5FB8C837FA66140F62CB154", hash_generated_method = "B3F5F95A8C7B0830EC1C682CD656A0C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Class<?> resolveConstructorClass(Class<?> objectClass) throws InvalidClassException {
        dsTaint.addTaint(objectClass.dsTaint);
        Class<?> constructorClass;
        constructorClass = objectClass;
        boolean wasSerializable;
        wasSerializable = (flags & ObjectStreamConstants.SC_SERIALIZABLE) != 0;
        {
            {
                boolean varFDE4CBEE93EED52DBC15AAE1ACE55609_94025634 = (constructorClass != null && ObjectStreamClass.isSerializable(constructorClass));
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
            if (DroidSafeAndroidRuntime.control) throw new InvalidClassException(className, "IllegalAccessException");
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
            if (DroidSafeAndroidRuntime.control) throw new InvalidClassException(constructorClass.getName(), "IllegalAccessException");
        } //End block
        {
            {
                boolean var01C93A2AE05D9878C907DF6E9F64ECCC_581664175 = (!inSamePackage(constructorClass, objectClass));
                {
                    if (DroidSafeAndroidRuntime.control) throw new InvalidClassException(constructorClass.getName(), "IllegalAccessException");
                } //End block
            } //End collapsed parenthetic
        } //End block
        resolvedConstructorClass = constructorClass;
        resolvedConstructorMethodId = getConstructorId(resolvedConstructorClass);
        return (Class<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static int getConstructorId(Class<?> c) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.147 -0400", hash_original_method = "C730C766F4F6CE91266CBA72D38C529A", hash_generated_method = "C5BA479D2E26B1148907927F908B6714")
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
        boolean var16017E65E75A0A549986C98F6129AABC_1672289599 = (nameC1.regionMatches(0, nameC2, 0, indexDotC1));
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

    
        static String getConstructorSignature(Constructor<?> c) {
        return DSUtils.UNKNOWN_STRING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.148 -0400", hash_original_method = "58A307C728457592549C73808957655C", hash_generated_method = "DD213335ED2A1A562AB739F1B44A9653")
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
                    boolean var32E5452974F5912B0D1DFCF62E31A958_139460095 = (f.getName().equals(name));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.148 -0400", hash_original_method = "3D80A7A04F3988E3E464D888981C4A01", hash_generated_method = "665E2C2669DD4FAFB3D05E3A62DD1C5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ObjectStreamField[] fields() {
        {
            Class<?> forCl;
            forCl = forClass();
            {
                boolean var793D8E01C16F5EE9855A6887A9C40654_1133559874 = (forCl != null && isSerializable() && !forCl.isArray());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.149 -0400", hash_original_method = "BA69DA3B5E6C7F20CA233B877CCB0384", hash_generated_method = "AB3EB4BCE1E6A639C81183E911EF38E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ObjectStreamField[] getFields() {
        copyFieldAttributes();
        {
            Object var724A75ED62EC2D3B03408921AE3D7374_1956867364 = (fields().clone());
            Object varFEC1ED2628BE881835AA100557350A1B_165680916 = (loadFields.clone());
        } //End flattened ternary
        return (ObjectStreamField[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //copyFieldAttributes();
        //return loadFields == null ? fields().clone() : loadFields.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.149 -0400", hash_original_method = "8AA71837DDE89491F51C878CBC8B38A5", hash_generated_method = "C0939727E2118311FE8D249B7EB29752")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.149 -0400", hash_original_method = "970C4D30E4F07A217EB44CA0880B9D33", hash_generated_method = "42EE5C32FC31F5B931482660A82FF745")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.149 -0400", hash_original_method = "F57C7EC559BF09EB03BA0EA2BC063E8F", hash_generated_method = "4E41A607113A21BA4BF006CB7688D15C")
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
                            boolean var249D9F14035FBD16E855916C4D99FDA9_1560905150 = (name.equals(field.getName()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.149 -0400", hash_original_method = "8F334CDB84C81A51C0419AAF322CA87A", hash_generated_method = "20C4599022343742D44C1DFE206BBD7E")
    @DSModeled(DSC.SAFE)
     ObjectStreamField[] getLoadFields() {
        return (ObjectStreamField[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return loadFields;
    }

    
        private static String getFieldSignature(Field f) {
        return DSUtils.UNKNOWN_STRING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.150 -0400", hash_original_method = "CB224A404D2A4A24CFF7504565CB22F2", hash_generated_method = "D731EBDB1FF6605D30FFB8A4F4453A47")
    @DSModeled(DSC.SAFE)
     byte getFlags() {
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //return flags;
    }

    
        static String getMethodSignature(Method m) {
        return DSUtils.UNKNOWN_STRING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.150 -0400", hash_original_method = "4A271A070FBC29EF826D1B50170E00D2", hash_generated_method = "383BD09D62077631FB2BEB9F961F3C6A")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return className;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.150 -0400", hash_original_method = "50DDDA79153910C7DDC4FA6D8AF3586E", hash_generated_method = "5DECA062F2554B941803A4A898F17CC7")
    @DSModeled(DSC.SAFE)
    public long getSerialVersionUID() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return svUID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.151 -0400", hash_original_method = "B099B86A783D62A1B2FEC5CAB74CA2FF", hash_generated_method = "C07D521339946A5C374F2AEE804EB9C7")
    @DSModeled(DSC.SAFE)
     ObjectStreamClass getSuperclass() {
        return (ObjectStreamClass)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return superclass;
    }

    
        private static boolean hasClinit(Class<?> cl) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        static boolean isExternalizable(Class<?> cl) {
        return EXTERNALIZABLE.isAssignableFrom(cl);
    }

    
        static boolean isPrimitiveType(char typecode) {
        return !(typecode == '[' || typecode == 'L');
    }

    
        static boolean isSerializable(Class<?> cl) {
        return SERIALIZABLE.isAssignableFrom(cl);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.152 -0400", hash_original_method = "742EA2900A6EB88CE28517352A724CD7", hash_generated_method = "CC63C37364420B18FEC87E5A532480EA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.153 -0400", hash_original_method = "250E0179C7C05D1D77B183DF06C38BC2", hash_generated_method = "30D978C474FA98B5AFF6758BC0DD91EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isSerializable() {
        resolveProperties();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //resolveProperties();
        //return isSerializable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.153 -0400", hash_original_method = "86835294A15C6057A38D3AF0C7A856A1", hash_generated_method = "EA275A81C3152A1B3FED45F347A0845A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isExternalizable() {
        resolveProperties();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //resolveProperties();
        //return isExternalizable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.153 -0400", hash_original_method = "052543446E0B6EEA498804C02394B590", hash_generated_method = "66873B68428A6662EA3F7411596B2E61")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isProxy() {
        resolveProperties();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //resolveProperties();
        //return isProxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.154 -0400", hash_original_method = "23781B8C58B21A484CF86E4B23EBD9CC", hash_generated_method = "1CC98EAC6A96370072CCB37EF85F74A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isEnum() {
        resolveProperties();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //resolveProperties();
        //return isEnum;
    }

    
        public static ObjectStreamClass lookup(Class<?> cl) {
        ObjectStreamClass osc = lookupStreamClass(cl);
        return (osc.isSerializable() || osc.isExternalizable()) ? osc : null;
    }

    
        public static ObjectStreamClass lookupAny(Class<?> cl) {
        return lookupStreamClass(cl);
    }

    
        static ObjectStreamClass lookupStreamClass(Class<?> cl) {
        WeakHashMap<Class<?>, ObjectStreamClass> tlc = getCache();
        ObjectStreamClass cachedValue = tlc.get(cl);
        if (cachedValue == null) {
            cachedValue = createClassDesc(cl);
            tlc.put(cl, cachedValue);
        }
        return cachedValue;
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.155 -0400", hash_original_method = "8B291B650661131936FFDD0976F9C451", hash_generated_method = "37F4C05FB0D9E9A28D5468D681573140")
    @DSModeled(DSC.SAFE)
     boolean hasMethodWriteReplace() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (methodWriteReplace != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.155 -0400", hash_original_method = "42662B3DE24059CFD85E0D286320D7E3", hash_generated_method = "2782B14A655B07E6B23F1F1CEFB052DF")
    @DSModeled(DSC.SAFE)
     Method getMethodWriteReplace() {
        return (Method)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return methodWriteReplace;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.155 -0400", hash_original_method = "2852DBB1E5C3B0D1351FCC53EE3E49ED", hash_generated_method = "809BF90CC2F83F2FB0FF9932005C6997")
    @DSModeled(DSC.SAFE)
     boolean hasMethodReadResolve() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (methodReadResolve != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.155 -0400", hash_original_method = "4E87A71E13632BD19F893729646A7048", hash_generated_method = "36BAE989745B3868699D7FE65A8A6E81")
    @DSModeled(DSC.SAFE)
     Method getMethodReadResolve() {
        return (Method)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return methodReadResolve;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.156 -0400", hash_original_method = "5A79EE26139C94EE3C3A1C73D8050C0E", hash_generated_method = "E1BE4FDBB18EC129B2BE1C3CD3CF8337")
    @DSModeled(DSC.SAFE)
     boolean hasMethodWriteObject() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (methodWriteObject != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.156 -0400", hash_original_method = "234967F1224E01D561A4A7AA93A723BD", hash_generated_method = "9F310BF87FC0B423C2887F741E02D9FE")
    @DSModeled(DSC.SAFE)
     Method getMethodWriteObject() {
        return (Method)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return methodWriteObject;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.156 -0400", hash_original_method = "46A702B5AEFAE4B1088A7C3DF1FC5D53", hash_generated_method = "755697FF0957A4CB133DB6E8DC263ADB")
    @DSModeled(DSC.SAFE)
     boolean hasMethodReadObject() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (methodReadObject != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.156 -0400", hash_original_method = "46960222BC0B63A6D59A57191BB77464", hash_generated_method = "065A2D028518D77516159B56FFE6A452")
    @DSModeled(DSC.SAFE)
     Method getMethodReadObject() {
        return (Method)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return methodReadObject;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.156 -0400", hash_original_method = "29BCBE89B6EA217724D7699109546E15", hash_generated_method = "2577730B8386AF4FC97A1195F1731757")
    @DSModeled(DSC.SAFE)
     boolean hasMethodReadObjectNoData() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (methodReadObjectNoData != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.156 -0400", hash_original_method = "04BED52E799E809DB8DD364039964962", hash_generated_method = "4A73C69D08F198FD7FEE56C106621B93")
    @DSModeled(DSC.SAFE)
     Method getMethodReadObjectNoData() {
        return (Method)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return methodReadObjectNoData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.157 -0400", hash_original_method = "971C620E95BDC0255A7014EB736B5315", hash_generated_method = "C7CE8792F9DD45CDEE965E9FA9D0DED9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.157 -0400", hash_original_method = "7A3AD0F8FFB276A7B1543CE5BED00A8C", hash_generated_method = "361F7AB3D32EE08B83D3120A76F33993")
    @DSModeled(DSC.SAFE)
     void setClass(Class<?> c) {
        dsTaint.addTaint(c.dsTaint);
        // ---------- Original Method ----------
        //resolvedClass = c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.157 -0400", hash_original_method = "95CB44F7E664D85BD475B63456D19F48", hash_generated_method = "D76008F6D377DB837A56C00786503AF3")
    @DSModeled(DSC.SAFE)
     void setFields(ObjectStreamField[] f) {
        dsTaint.addTaint(f[0].dsTaint);
        // ---------- Original Method ----------
        //fields = f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.157 -0400", hash_original_method = "BCDE99C62E7E698332D80A91E945CB98", hash_generated_method = "FDC00F153C5A4DC3D4DA4483BE537E7D")
    @DSModeled(DSC.SAFE)
     void setLoadFields(ObjectStreamField[] f) {
        dsTaint.addTaint(f[0].dsTaint);
        // ---------- Original Method ----------
        //loadFields = f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.157 -0400", hash_original_method = "576B4ED3621FB044BCB61FA4A013466B", hash_generated_method = "816D604F49453402961FBCFB8BC8BD38")
    @DSModeled(DSC.SAFE)
     void setFlags(byte b) {
        dsTaint.addTaint(b);
        // ---------- Original Method ----------
        //flags = b;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.157 -0400", hash_original_method = "013A745A10FFAC0063C18ECA8D35B13C", hash_generated_method = "1C0F485DE2ED803DAA23FAD7B75D2A89")
    @DSModeled(DSC.SAFE)
     void setName(String newName) {
        dsTaint.addTaint(newName);
        // ---------- Original Method ----------
        //className = newName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.158 -0400", hash_original_method = "F5AE79B32CCC15982EBF3437ADD142B6", hash_generated_method = "AD732F18C8C750EA6DAD360D9B14527E")
    @DSModeled(DSC.SAFE)
     void setSerialVersionUID(long l) {
        dsTaint.addTaint(l);
        // ---------- Original Method ----------
        //svUID = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.158 -0400", hash_original_method = "0C66D1C8E17ECB3824AFA99C964D873A", hash_generated_method = "B78C12C195C4BFD842878A6F3A3554BC")
    @DSModeled(DSC.SAFE)
     void setSuperclass(ObjectStreamClass c) {
        dsTaint.addTaint(c.dsTaint);
        // ---------- Original Method ----------
        //superclass = c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.158 -0400", hash_original_method = "555F932795060D0A381054093FA5AE4C", hash_generated_method = "AEBD2E3A5DB3C844610A8EC6ED57A764")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int primitiveSize(Class<?> type) {
        dsTaint.addTaint(type.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new AssertionError();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.158 -0400", hash_original_method = "0689970A4402522168D5BA272C87560D", hash_generated_method = "4E07D183211B7DE0088DE67E56E81FC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varDCAE4EE0B46960A781CF68E0E1D322C9_336011870 = (getName() + ": static final long serialVersionUID =" + getSerialVersionUID() + "L;");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getName() + ": static final long serialVersionUID =" + getSerialVersionUID() + "L;";
    }

    
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
    static {
        try {
            ARRAY_OF_FIELDS = Class.forName("[Ljava.io.ObjectStreamField;");
        } catch (ClassNotFoundException e) {
            throw new AssertionError(e);
        }
    }
    
    private static final String CLINIT_NAME = "<clinit>";
    private static final int CLINIT_MODIFIERS = Modifier.STATIC;
    private static final String CLINIT_SIGNATURE = "()V";
    private static final Class<Serializable> SERIALIZABLE = Serializable.class;
    private static final Class<Externalizable> EXTERNALIZABLE = Externalizable.class;
    static final Class<String> STRINGCLASS = String.class;
    static final Class<?> CLASSCLASS = Class.class;
    static final Class<ObjectStreamClass> OBJECTSTREAMCLASSCLASS = ObjectStreamClass.class;
    private static SoftReference<ThreadLocal<WeakHashMap<Class<?>, ObjectStreamClass>>> storage =
            new SoftReference<ThreadLocal<WeakHashMap<Class<?>, ObjectStreamClass>>>(null);
}

