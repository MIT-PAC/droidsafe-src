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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.628 -0400", hash_original_field = "924AD349EDF719B44ED4F6F5E69E79C8", hash_generated_field = "565644E752815B2ABF82349A3CEA0B6B")

    private transient Method methodWriteReplace;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.628 -0400", hash_original_field = "122CA9229276E3DB873F1636B9A73713", hash_generated_field = "6059C8931AF46DD9869FE9A893452731")

    private transient Method methodReadResolve;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.628 -0400", hash_original_field = "0AF54E3AF04EAD8206E09DE0F3EFF6A5", hash_generated_field = "79B39BB54513173AC7D6E6CEF6CBC2C1")

    private transient Method methodWriteObject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.628 -0400", hash_original_field = "B82644AD4949DE727339E54F199447FA", hash_generated_field = "95EB8846D319017FC3432FF6857D1E5F")

    private transient Method methodReadObject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.628 -0400", hash_original_field = "32BFCA8D9BFE8B95457E5550245CB6B9", hash_generated_field = "7CE9FEA6AC19BB8C204FD6B95B2862F7")

    private transient Method methodReadObjectNoData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.628 -0400", hash_original_field = "98E79AD3A7FF3396963BD7E17B70758D", hash_generated_field = "9CF3DD8AED4B95AE1F483D580B3C9FB3")

    private transient boolean arePropertiesResolved;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.628 -0400", hash_original_field = "C4140104E3123239B50920CAF039E81E", hash_generated_field = "CCFF438B2B69BBC8976762B5C0E1BAAE")

    private transient boolean isSerializable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.628 -0400", hash_original_field = "E7861AE2BAD033AB7951E8BEF5C2A338", hash_generated_field = "4BE511410EC0FFD94E2FF75D626D91CA")

    private transient boolean isExternalizable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.628 -0400", hash_original_field = "AD3DC48725AE019F4BB4FCBF31A8F0A2", hash_generated_field = "08F3A9F82723EA0AE100503EE65CAB86")

    private transient boolean isProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.628 -0400", hash_original_field = "DE5BB2742FE3A4D4DDF9022B2054FD05", hash_generated_field = "36F43E2AAA4E18617E48CB413466DD29")

    private transient boolean isEnum;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.628 -0400", hash_original_field = "6F66E878C62DB60568A3487869695820", hash_generated_field = "288941F24943F280BE7DD01D20E3054F")

    private transient String className;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.628 -0400", hash_original_field = "49F703B414E479ADB1C3D60FCEC4F53F", hash_generated_field = "AC340BA4F3A44FB166243898294EB37E")

    private transient Class<?> resolvedClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.628 -0400", hash_original_field = "F92B03D6EDD39C2B4E711BE71293FD13", hash_generated_field = "971C9C890CEBC6BE40FABDECB2212AA0")

    private transient Class<?> resolvedConstructorClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.628 -0400", hash_original_field = "0F889FB01934E2F8046B517E783FC0E3", hash_generated_field = "A4FBAD79CEB03A973A15AB5C7331E7A6")

    private transient int resolvedConstructorMethodId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.628 -0400", hash_original_field = "28CDF3CD863FE5D84844FE25A3CD04A2", hash_generated_field = "2CBD7F29D2CB9FEFE962129E37123233")

    private transient long svUID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.628 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "E30025CF9CDCA8A17963070ADA592697")

    private transient byte flags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.628 -0400", hash_original_field = "7ECAB020F524F5AA6F04649D13BC0A2C", hash_generated_field = "F7485FE95D068421E7ED5928F1406E97")

    private transient ObjectStreamClass superclass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.628 -0400", hash_original_field = "D05B6ED7D2345020440DF396D6DA7F73", hash_generated_field = "186A117481AECE390EACD17A001BE99F")

    private transient ObjectStreamField[] fields;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.628 -0400", hash_original_field = "B7449C3BA34A98413B53EF5F6AAAAE64", hash_generated_field = "A56A7B7B744B804CA41E1FD965741EE2")

    private transient ObjectStreamField[] loadFields;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.628 -0400", hash_original_field = "7ED7EB5221669EADB9DDC3B8CA1218F3", hash_generated_field = "00A9BB651D9852E56EFAEA15E35B461E")

    private transient HashMap<ObjectStreamField, Field> reflectionFields = new HashMap<ObjectStreamField, Field>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.628 -0400", hash_original_field = "6ED86FE66FD07A5256097A5CD1494E95", hash_generated_field = "C0358E6BFD2D898DD9C7ADBEBD4D2ECF")

    private transient long constructor = CONSTRUCTOR_IS_NOT_RESOLVED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.628 -0400", hash_original_field = "B145651EF057F5E0B5598B009F752B32", hash_generated_field = "4AA36F11897D193C7F055A6BB8228782")

    private transient volatile List<ObjectStreamClass> cachedHierarchy;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.628 -0400", hash_original_method = "F4D9898A03FC0DADA999BF46D97F9433", hash_generated_method = "A9246BC45205ECF4E818CF0D168C4ADC")
      ObjectStreamClass() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.629 -0400", hash_original_method = "7053F33417C9644BFD49070B9EF96C54", hash_generated_method = "AC3AFCBDE4A9E172383956581C876B87")
     void setConstructor(long newConstructor) {
        constructor = newConstructor;
        // ---------- Original Method ----------
        //constructor = newConstructor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.629 -0400", hash_original_method = "AE977884038645FC18D9650C0686387C", hash_generated_method = "C4ED0586FE42610108CA75BBD5409CC5")
     long getConstructor() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1425690750 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1425690750;
        // ---------- Original Method ----------
        //return constructor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.629 -0400", hash_original_method = "592D0703821799AB937A99A67AB05B5C", hash_generated_method = "8611FC62419E06A96E1473F2BC8AE493")
     Field getReflectionField(ObjectStreamField osf) {
        Field varB4EAC82CA7396A68D541C85D26508E83_1449209208 = null; //Variable for return #1
        Field varB4EAC82CA7396A68D541C85D26508E83_871860779 = null; //Variable for return #2
        Field varB4EAC82CA7396A68D541C85D26508E83_881212181 = null; //Variable for return #3
        {
            Field field = reflectionFields.get(osf);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1449209208 = field;
            } //End block
        } //End block
        try 
        {
            Class<?> declaringClass = forClass();
            Field field = declaringClass.getDeclaredField(osf.getName());
            field.setAccessible(true);
            {
                reflectionFields.put(osf, field);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_871860779 = reflectionFields.get(osf);
        } //End block
        catch (NoSuchFieldException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_881212181 = null;
        } //End block
        addTaint(osf.getTaint());
        Field varA7E53CE21691AB073D9660D615818899_1507256867; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1507256867 = varB4EAC82CA7396A68D541C85D26508E83_1449209208;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1507256867 = varB4EAC82CA7396A68D541C85D26508E83_871860779;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1507256867 = varB4EAC82CA7396A68D541C85D26508E83_881212181;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1507256867.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1507256867;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.638 -0400", hash_original_method = "3492CF41320405C3965233DAB60A3EF1", hash_generated_method = "A994BA87C10A6BF04661EE694D4FEB24")
     void buildFieldDescriptors(Field[] declaredFields) {
        final Field f = ObjectStreamClass.fieldSerialPersistentFields(this.forClass());
        boolean useReflectFields = f == null;
        ObjectStreamField[] _fields = null;
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
            List<ObjectStreamField> serializableFields = new ArrayList<ObjectStreamField>(declaredFields.length);
            {
                Field declaredField = declaredFields[0];
                {
                    int modifiers = declaredField.getModifiers();
                    {
                        boolean var0B0C4470A78EE89D4D1877A6DDF6E76D_704592795 = (!Modifier.isStatic(modifiers) && !Modifier.isTransient(modifiers));
                        {
                            ObjectStreamField field = new ObjectStreamField(declaredField.getName(),
                            declaredField.getType());
                            serializableFields.add(field);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                boolean varFDB496ED83E038616C56C9314DBD5FA6_2048431108 = (serializableFields.size() == 0);
                {
                    _fields = NO_FIELDS;
                } //End block
                {
                    _fields = serializableFields.toArray(new ObjectStreamField[serializableFields.size()]);
                } //End block
            } //End collapsed parenthetic
        } //End block
        Arrays.sort(_fields);
        int primOffset = 0;
        int objectOffset = 0;
        {
            int i = 0;
            {
                Class<?> type = _fields[i].getType();
                {
                    boolean varA97A53306537CEF5EB846AEB112A7855_1859814974 = (type.isPrimitive());
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
        addTaint(declaredFields[0].getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.640 -0400", hash_original_method = "3FC829F6BB79347D76007A55E3423470", hash_generated_method = "D63EC402D38BB2DFA8A7CED3C660D16D")
    public Class<?> forClass() {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1538019573 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1538019573 = resolvedClass;
        varB4EAC82CA7396A68D541C85D26508E83_1538019573.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1538019573;
        // ---------- Original Method ----------
        //return resolvedClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.640 -0400", hash_original_method = "CFDAB7386CDDDD8EC35152CD7D073792", hash_generated_method = "DEA791BC18F148AEB2D968623E9210CB")
     Object newInstance(Class<?> instantiationClass) throws InvalidClassException {
        Object varB4EAC82CA7396A68D541C85D26508E83_2016379475 = null; //Variable for return #1
        resolveConstructorClass(instantiationClass);
        varB4EAC82CA7396A68D541C85D26508E83_2016379475 = newInstance(instantiationClass, resolvedConstructorMethodId);
        addTaint(instantiationClass.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2016379475.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2016379475;
        // ---------- Original Method ----------
        //resolveConstructorClass(instantiationClass);
        //return newInstance(instantiationClass, resolvedConstructorMethodId);
    }

    
    private static Object newInstance(Class<?> instantiationClass, int methodId) {
                //DSFIXME:  This shouldn't happen!
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.642 -0400", hash_original_method = "66A47A19F5FB8C837FA66140F62CB154", hash_generated_method = "595EAAB94FE3D49F8C3873467DFEAECD")
    private Class<?> resolveConstructorClass(Class<?> objectClass) throws InvalidClassException {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_241925724 = null; //Variable for return #1
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_252712759 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_241925724 = resolvedConstructorClass;
        } //End block
        Class<?> constructorClass = objectClass;
        boolean wasSerializable = (flags & ObjectStreamConstants.SC_SERIALIZABLE) != 0;
        {
            {
                boolean varFDE4CBEE93EED52DBC15AAE1ACE55609_893219583 = (constructorClass != null && ObjectStreamClass.isSerializable(constructorClass));
                {
                    constructorClass = constructorClass.getSuperclass();
                } //End block
            } //End collapsed parenthetic
        } //End block
        Constructor<?> constructor = null;
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
        int constructorModifiers = constructor.getModifiers();
        boolean isPublic = Modifier.isPublic(constructorModifiers);
        boolean isProtected = Modifier.isProtected(constructorModifiers);
        boolean isPrivate = Modifier.isPrivate(constructorModifiers);
        boolean wasExternalizable = (flags & ObjectStreamConstants.SC_EXTERNALIZABLE) != 0;
        {
            if (DroidSafeAndroidRuntime.control) throw new InvalidClassException(constructorClass.getName(), "IllegalAccessException");
        } //End block
        {
            {
                boolean var01C93A2AE05D9878C907DF6E9F64ECCC_1226439427 = (!inSamePackage(constructorClass, objectClass));
                {
                    if (DroidSafeAndroidRuntime.control) throw new InvalidClassException(constructorClass.getName(), "IllegalAccessException");
                } //End block
            } //End collapsed parenthetic
        } //End block
        resolvedConstructorClass = constructorClass;
        resolvedConstructorMethodId = getConstructorId(resolvedConstructorClass);
        varB4EAC82CA7396A68D541C85D26508E83_252712759 = constructorClass;
        addTaint(objectClass.getTaint());
        Class<?> varA7E53CE21691AB073D9660D615818899_1733000738; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1733000738 = varB4EAC82CA7396A68D541C85D26508E83_241925724;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1733000738 = varB4EAC82CA7396A68D541C85D26508E83_252712759;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1733000738.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1733000738;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static int getConstructorId(Class<?> c) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1812619741 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1812619741;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.643 -0400", hash_original_method = "C730C766F4F6CE91266CBA72D38C529A", hash_generated_method = "8172BD5199700ACCD1EE7FA43F02D881")
    private boolean inSamePackage(Class<?> c1, Class<?> c2) {
        String nameC1 = c1.getName();
        String nameC2 = c2.getName();
        int indexDotC1 = nameC1.lastIndexOf('.');
        int indexDotC2 = nameC2.lastIndexOf('.');
        boolean var16017E65E75A0A549986C98F6129AABC_696364159 = (nameC1.regionMatches(0, nameC2, 0, indexDotC1));
        addTaint(c1.getTaint());
        addTaint(c2.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_207544676 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_207544676;
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
                //DSFIXME:  This shouldn't happen!
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.644 -0400", hash_original_method = "58A307C728457592549C73808957655C", hash_generated_method = "8FF72D37D5259741B2A327CCFC8B5D8A")
    public ObjectStreamField getField(String name) {
        ObjectStreamField varB4EAC82CA7396A68D541C85D26508E83_560435753 = null; //Variable for return #1
        ObjectStreamField varB4EAC82CA7396A68D541C85D26508E83_778220312 = null; //Variable for return #2
        ObjectStreamField[] allFields = getFields();
        {
            int i = 0;
            {
                ObjectStreamField f = allFields[i];
                {
                    boolean var32E5452974F5912B0D1DFCF62E31A958_1340372051 = (f.getName().equals(name));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_560435753 = f;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_778220312 = null;
        addTaint(name.getTaint());
        ObjectStreamField varA7E53CE21691AB073D9660D615818899_2135839227; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2135839227 = varB4EAC82CA7396A68D541C85D26508E83_560435753;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2135839227 = varB4EAC82CA7396A68D541C85D26508E83_778220312;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2135839227.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2135839227;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.647 -0400", hash_original_method = "3D80A7A04F3988E3E464D888981C4A01", hash_generated_method = "BBEBBA3648A24068E82B84EB0A09CB3D")
     ObjectStreamField[] fields() {
        ObjectStreamField[] varB4EAC82CA7396A68D541C85D26508E83_1887859363 = null; //Variable for return #1
        {
            Class<?> forCl = forClass();
            {
                boolean var793D8E01C16F5EE9855A6887A9C40654_2014162983 = (forCl != null && isSerializable() && !forCl.isArray());
                {
                    buildFieldDescriptors(forCl.getDeclaredFields());
                } //End block
                {
                    setFields(NO_FIELDS);
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1887859363 = fields;
        varB4EAC82CA7396A68D541C85D26508E83_1887859363.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1887859363;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.648 -0400", hash_original_method = "BA69DA3B5E6C7F20CA233B877CCB0384", hash_generated_method = "80BD9A0ED40A556837E2B4F1838D67E9")
    public ObjectStreamField[] getFields() {
        ObjectStreamField[] varB4EAC82CA7396A68D541C85D26508E83_1934263097 = null; //Variable for return #1
        copyFieldAttributes();
        varB4EAC82CA7396A68D541C85D26508E83_1934263097 = loadFields == null ? fields().clone() : loadFields.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1934263097.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1934263097;
        // ---------- Original Method ----------
        //copyFieldAttributes();
        //return loadFields == null ? fields().clone() : loadFields.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.650 -0400", hash_original_method = "8AA71837DDE89491F51C878CBC8B38A5", hash_generated_method = "B83840894AC51F5B849D3B4B0FA643AA")
     List<ObjectStreamClass> getHierarchy() {
        List<ObjectStreamClass> varB4EAC82CA7396A68D541C85D26508E83_1562373706 = null; //Variable for return #1
        List<ObjectStreamClass> result = cachedHierarchy;
        {
            cachedHierarchy = result = makeHierarchy();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1562373706 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1562373706.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1562373706;
        // ---------- Original Method ----------
        //List<ObjectStreamClass> result = cachedHierarchy;
        //if (result == null) {
            //cachedHierarchy = result = makeHierarchy();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.651 -0400", hash_original_method = "970C4D30E4F07A217EB44CA0880B9D33", hash_generated_method = "D2096202FE142E1732FC42CEDE64A7A7")
    private List<ObjectStreamClass> makeHierarchy() {
        List<ObjectStreamClass> varB4EAC82CA7396A68D541C85D26508E83_1053179254 = null; //Variable for return #1
        ArrayList<ObjectStreamClass> result = new ArrayList<ObjectStreamClass>();
        {
            ObjectStreamClass osc = this;
            osc = osc.getSuperclass();
            {
                result.add(0, osc);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1053179254 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1053179254.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1053179254;
        // ---------- Original Method ----------
        //ArrayList<ObjectStreamClass> result = new ArrayList<ObjectStreamClass>();
        //for (ObjectStreamClass osc = this; osc != null; osc = osc.getSuperclass()) {
            //result.add(0, osc);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.652 -0400", hash_original_method = "F57C7EC559BF09EB03BA0EA2BC063E8F", hash_generated_method = "A6AD325DEB326A074CDF5C63128D9C8D")
    private void copyFieldAttributes() {
        {
            int i = 0;
            {
                ObjectStreamField loadField = loadFields[i];
                String name = loadField.getName();
                {
                    int j = 0;
                    {
                        ObjectStreamField field = fields[j];
                        {
                            boolean var249D9F14035FBD16E855916C4D99FDA9_1208129559 = (name.equals(field.getName()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.653 -0400", hash_original_method = "8F334CDB84C81A51C0419AAF322CA87A", hash_generated_method = "49A5A77647A3F9D9046235FBC13079CE")
     ObjectStreamField[] getLoadFields() {
        ObjectStreamField[] varB4EAC82CA7396A68D541C85D26508E83_1133706895 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1133706895 = loadFields;
        varB4EAC82CA7396A68D541C85D26508E83_1133706895.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1133706895;
        // ---------- Original Method ----------
        //return loadFields;
    }

    
    private static String getFieldSignature(Field f) {
                //DSFIXME:  This shouldn't happen!
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.654 -0400", hash_original_method = "CB224A404D2A4A24CFF7504565CB22F2", hash_generated_method = "9EE83EEBD0CA031699398282D3DE4A4F")
     byte getFlags() {
        byte var40EA57D3EE3C07BF1C102B466E1C3091_1245108842 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1245108842;
        // ---------- Original Method ----------
        //return flags;
    }

    
    static String getMethodSignature(Method m) {
                //DSFIXME:  This shouldn't happen!
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.655 -0400", hash_original_method = "4A271A070FBC29EF826D1B50170E00D2", hash_generated_method = "F66372DAA28E9F284E52B2223D8C79F2")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1868377228 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1868377228 = className;
        varB4EAC82CA7396A68D541C85D26508E83_1868377228.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1868377228;
        // ---------- Original Method ----------
        //return className;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.656 -0400", hash_original_method = "50DDDA79153910C7DDC4FA6D8AF3586E", hash_generated_method = "BFB61BA302CB57CC955CB2E1A41E888B")
    public long getSerialVersionUID() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1523350722 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1523350722;
        // ---------- Original Method ----------
        //return svUID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.656 -0400", hash_original_method = "B099B86A783D62A1B2FEC5CAB74CA2FF", hash_generated_method = "446B05A66643E081EAAE5AFE270C9F58")
     ObjectStreamClass getSuperclass() {
        ObjectStreamClass varB4EAC82CA7396A68D541C85D26508E83_1792698509 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1792698509 = superclass;
        varB4EAC82CA7396A68D541C85D26508E83_1792698509.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1792698509;
        // ---------- Original Method ----------
        //return superclass;
    }

    
    private static boolean hasClinit(Class<?> cl) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_153496694 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_153496694;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.658 -0400", hash_original_method = "742EA2900A6EB88CE28517352A724CD7", hash_generated_method = "C3BBF1AF12AC99C743540033EC3FD26A")
    private void resolveProperties() {
        Class<?> cl = forClass();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.658 -0400", hash_original_method = "250E0179C7C05D1D77B183DF06C38BC2", hash_generated_method = "6F0DEC5BAA2248956AD2E44F3BE865C4")
     boolean isSerializable() {
        resolveProperties();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_659067420 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_659067420;
        // ---------- Original Method ----------
        //resolveProperties();
        //return isSerializable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.659 -0400", hash_original_method = "86835294A15C6057A38D3AF0C7A856A1", hash_generated_method = "DEACE47AF23324A1D818D8A3E4389644")
     boolean isExternalizable() {
        resolveProperties();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1727210800 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1727210800;
        // ---------- Original Method ----------
        //resolveProperties();
        //return isExternalizable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.659 -0400", hash_original_method = "052543446E0B6EEA498804C02394B590", hash_generated_method = "70C3467C6274DDC96065B5C42EFA0A56")
     boolean isProxy() {
        resolveProperties();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_666368256 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_666368256;
        // ---------- Original Method ----------
        //resolveProperties();
        //return isProxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.659 -0400", hash_original_method = "23781B8C58B21A484CF86E4B23EBD9CC", hash_generated_method = "231E706EAA7974F023A112B750B73D0A")
     boolean isEnum() {
        resolveProperties();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2099454599 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2099454599;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.660 -0400", hash_original_method = "8B291B650661131936FFDD0976F9C451", hash_generated_method = "2291E26360E565C445B4564B03B47BBC")
     boolean hasMethodWriteReplace() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1028287424 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1028287424;
        // ---------- Original Method ----------
        //return (methodWriteReplace != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.661 -0400", hash_original_method = "42662B3DE24059CFD85E0D286320D7E3", hash_generated_method = "61BEEA9904CB23328B8F168146690B1D")
     Method getMethodWriteReplace() {
        Method varB4EAC82CA7396A68D541C85D26508E83_2012613051 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2012613051 = methodWriteReplace;
        varB4EAC82CA7396A68D541C85D26508E83_2012613051.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2012613051;
        // ---------- Original Method ----------
        //return methodWriteReplace;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.661 -0400", hash_original_method = "2852DBB1E5C3B0D1351FCC53EE3E49ED", hash_generated_method = "995357488B52D25BC1E2C4626373F760")
     boolean hasMethodReadResolve() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_599949023 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_599949023;
        // ---------- Original Method ----------
        //return (methodReadResolve != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.662 -0400", hash_original_method = "4E87A71E13632BD19F893729646A7048", hash_generated_method = "DBCF2F68B8606E775935413A5E461347")
     Method getMethodReadResolve() {
        Method varB4EAC82CA7396A68D541C85D26508E83_1329561666 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1329561666 = methodReadResolve;
        varB4EAC82CA7396A68D541C85D26508E83_1329561666.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1329561666;
        // ---------- Original Method ----------
        //return methodReadResolve;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.662 -0400", hash_original_method = "5A79EE26139C94EE3C3A1C73D8050C0E", hash_generated_method = "F70917DBE527F7F6DBD9812D249E294B")
     boolean hasMethodWriteObject() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_230828924 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_230828924;
        // ---------- Original Method ----------
        //return (methodWriteObject != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.662 -0400", hash_original_method = "234967F1224E01D561A4A7AA93A723BD", hash_generated_method = "CE7E2CAB268353F4D0584988421EBC09")
     Method getMethodWriteObject() {
        Method varB4EAC82CA7396A68D541C85D26508E83_1152270775 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1152270775 = methodWriteObject;
        varB4EAC82CA7396A68D541C85D26508E83_1152270775.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1152270775;
        // ---------- Original Method ----------
        //return methodWriteObject;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.663 -0400", hash_original_method = "46A702B5AEFAE4B1088A7C3DF1FC5D53", hash_generated_method = "D86AB29E76E5BEEEE76DF36CAB799BFD")
     boolean hasMethodReadObject() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1069842555 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1069842555;
        // ---------- Original Method ----------
        //return (methodReadObject != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.663 -0400", hash_original_method = "46960222BC0B63A6D59A57191BB77464", hash_generated_method = "A28B6058C89BC4209B639E25C065CFFF")
     Method getMethodReadObject() {
        Method varB4EAC82CA7396A68D541C85D26508E83_657351500 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_657351500 = methodReadObject;
        varB4EAC82CA7396A68D541C85D26508E83_657351500.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_657351500;
        // ---------- Original Method ----------
        //return methodReadObject;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.663 -0400", hash_original_method = "29BCBE89B6EA217724D7699109546E15", hash_generated_method = "BCE5A3340F91E4532B8169E3319642E1")
     boolean hasMethodReadObjectNoData() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1192369223 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1192369223;
        // ---------- Original Method ----------
        //return (methodReadObjectNoData != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.664 -0400", hash_original_method = "04BED52E799E809DB8DD364039964962", hash_generated_method = "39620AE6C6A4ECC7624B185A44B52196")
     Method getMethodReadObjectNoData() {
        Method varB4EAC82CA7396A68D541C85D26508E83_2053911821 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2053911821 = methodReadObjectNoData;
        varB4EAC82CA7396A68D541C85D26508E83_2053911821.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2053911821;
        // ---------- Original Method ----------
        //return methodReadObjectNoData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.664 -0400", hash_original_method = "971C620E95BDC0255A7014EB736B5315", hash_generated_method = "B5F3BDDAE6A803CDF4D471FA2756DB0E")
     void initPrivateFields(ObjectStreamClass desc) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.664 -0400", hash_original_method = "7A3AD0F8FFB276A7B1543CE5BED00A8C", hash_generated_method = "F5A742D0B09B68C4FB60A9954C304EDB")
     void setClass(Class<?> c) {
        resolvedClass = c;
        // ---------- Original Method ----------
        //resolvedClass = c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.665 -0400", hash_original_method = "95CB44F7E664D85BD475B63456D19F48", hash_generated_method = "621FA11CDA9BF8080C1105CE3A873D93")
     void setFields(ObjectStreamField[] f) {
        fields = f;
        // ---------- Original Method ----------
        //fields = f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.665 -0400", hash_original_method = "BCDE99C62E7E698332D80A91E945CB98", hash_generated_method = "D8783C05CB4817ECCBC0A4DB4114E614")
     void setLoadFields(ObjectStreamField[] f) {
        loadFields = f;
        // ---------- Original Method ----------
        //loadFields = f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.665 -0400", hash_original_method = "576B4ED3621FB044BCB61FA4A013466B", hash_generated_method = "A1473C1BC66B458281188527CD3D2FFA")
     void setFlags(byte b) {
        flags = b;
        // ---------- Original Method ----------
        //flags = b;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.666 -0400", hash_original_method = "013A745A10FFAC0063C18ECA8D35B13C", hash_generated_method = "A8DB264CFECA0C5CD0FC0F9AB8AC5A8F")
     void setName(String newName) {
        className = newName;
        // ---------- Original Method ----------
        //className = newName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.666 -0400", hash_original_method = "F5AE79B32CCC15982EBF3437ADD142B6", hash_generated_method = "2B1ADB1E939E150C2B4F3759E3B94493")
     void setSerialVersionUID(long l) {
        svUID = l;
        // ---------- Original Method ----------
        //svUID = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.666 -0400", hash_original_method = "0C66D1C8E17ECB3824AFA99C964D873A", hash_generated_method = "B10D683C7024190847B8FAF4B67B2A8C")
     void setSuperclass(ObjectStreamClass c) {
        superclass = c;
        // ---------- Original Method ----------
        //superclass = c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.666 -0400", hash_original_method = "555F932795060D0A381054093FA5AE4C", hash_generated_method = "FAC82077D9841FF34B6FCA29312EE0B2")
    private int primitiveSize(Class<?> type) {
        if (DroidSafeAndroidRuntime.control) throw new AssertionError();
        addTaint(type.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1690577052 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1690577052;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.667 -0400", hash_original_method = "0689970A4402522168D5BA272C87560D", hash_generated_method = "A184C8DD035D977BBB8D64F96FCDB5E3")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1197857063 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1197857063 = getName() + ": static final long serialVersionUID =" + getSerialVersionUID() + "L;";
        varB4EAC82CA7396A68D541C85D26508E83_1197857063.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1197857063;
        // ---------- Original Method ----------
        //return getName() + ": static final long serialVersionUID =" + getSerialVersionUID() + "L;";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.667 -0400", hash_original_field = "F80ED60A319D1F80CB33832164C227CF", hash_generated_field = "BA8EEE23E6596CE6F7527CE0FB83EF58")

    private static final long serialVersionUID = -6120832682080437368L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.667 -0400", hash_original_field = "356C063796A1DA01825DA22B2E8BF97E", hash_generated_field = "7C93B17B1CD1259F16B6C51AFF108516")

    private static final String UID_FIELD_NAME = "serialVersionUID";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.667 -0400", hash_original_field = "804DD882D7CAF8F79C2FD4521F960B6D", hash_generated_field = "9AFAE497812747A92BB053856885C1C2")

    static final long CONSTRUCTOR_IS_NOT_RESOLVED = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.667 -0400", hash_original_field = "622985B8B870C83F524B1E348D91C675", hash_generated_field = "590029B14B4132E56D522CD50C18A2A5")

    private static final int CLASS_MODIFIERS_MASK = Modifier.PUBLIC | Modifier.FINAL |
            Modifier.INTERFACE | Modifier.ABSTRACT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.667 -0400", hash_original_field = "A22CFAB1E19A0404A170D1B7CE8C38AA", hash_generated_field = "6E176BF4C7339EE62D8B4C9DEC6243A9")

    private static final int FIELD_MODIFIERS_MASK = Modifier.PUBLIC | Modifier.PRIVATE |
            Modifier.PROTECTED | Modifier.STATIC | Modifier.FINAL | Modifier.VOLATILE |
            Modifier.TRANSIENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.667 -0400", hash_original_field = "91DFB60E26ED5735564D744CF8176019", hash_generated_field = "5D118F6B69CCB323323A9B49BDA9C6C3")

    private static final int METHOD_MODIFIERS_MASK = Modifier.PUBLIC | Modifier.PRIVATE |
            Modifier.PROTECTED | Modifier.STATIC | Modifier.FINAL | Modifier.SYNCHRONIZED |
            Modifier.NATIVE | Modifier.ABSTRACT | Modifier.STRICT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.667 -0400", hash_original_field = "624FC6A8300688A4B8B6B2000FCD81E0", hash_generated_field = "43D6F3E9D5C647D35731B8383079E1D6")

    private static final Class<?>[] READ_PARAM_TYPES = new Class[] { ObjectInputStream.class };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.667 -0400", hash_original_field = "C13E9F6B09096E6021DA7DDB46B18579", hash_generated_field = "4A3EE43FA683211E618FB6747D07F843")

    private static final Class<?>[] WRITE_PARAM_TYPES = new Class[] { ObjectOutputStream.class };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.667 -0400", hash_original_field = "243B2E96A5F4E8F89A323D42DBE7EEBC", hash_generated_field = "7D11682BF64A4B005019DE32559565EF")

    public static final ObjectStreamField[] NO_FIELDS = new ObjectStreamField[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.667 -0400", hash_original_field = "92BCE7D158829B88C361F39F1D78D7E8", hash_generated_field = "6978DEEE48DC3157891475C4DA0DAB91")

    static Class<?> ARRAY_OF_FIELDS;
    static {
        try {
            ARRAY_OF_FIELDS = Class.forName("[Ljava.io.ObjectStreamField;");
        } catch (ClassNotFoundException e) {
            throw new AssertionError(e);
        }
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.667 -0400", hash_original_field = "F76F81B088AEDCF4CC4AC04CE877788E", hash_generated_field = "FA5209333B79D9097B62842702D68121")

    private static final String CLINIT_NAME = "<clinit>";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.667 -0400", hash_original_field = "8DF4213BA7E05A81E7135E331B30C11A", hash_generated_field = "ACFFC1389FDC9F82445E4D03EE9ED911")

    private static final int CLINIT_MODIFIERS = Modifier.STATIC;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.667 -0400", hash_original_field = "BB1CCCC3FF0A517413C95AB9047469B9", hash_generated_field = "423C84B6DC3BB79CF9824136C350B1B0")

    private static final String CLINIT_SIGNATURE = "()V";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.668 -0400", hash_original_field = "94EB83F78C40AA1F634F2E0003836AD5", hash_generated_field = "4F2D1BC91F0EEAF8AFC3647840FAEB8F")

    private static final Class<Serializable> SERIALIZABLE = Serializable.class;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.668 -0400", hash_original_field = "11A54DB730E2A2D3B34516F5BDFFC5DA", hash_generated_field = "8FF60D62BE9F159A9087406109E4ACEB")

    private static final Class<Externalizable> EXTERNALIZABLE = Externalizable.class;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.668 -0400", hash_original_field = "596AA5ABAEC6715E1C73E44D6723DCCF", hash_generated_field = "E50E1B7F50901172462DF6CB7A52BABD")

    static final Class<String> STRINGCLASS = String.class;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.668 -0400", hash_original_field = "5F0E1B2239647B717460E2812C1E45A5", hash_generated_field = "51D83A7260A0C617FACB44B683730C6D")

    static final Class<?> CLASSCLASS = Class.class;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.668 -0400", hash_original_field = "4A025773485868FB6759CAC7E647646C", hash_generated_field = "F91CD3D7464571E8E9D05D8CAFE05B21")

    static final Class<ObjectStreamClass> OBJECTSTREAMCLASSCLASS = ObjectStreamClass.class;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.668 -0400", hash_original_field = "17CA37E35AD877567E00ECAF794A6918", hash_generated_field = "16A63F3AB899CF3EB9607AD6E5CAA631")

    private static SoftReference<ThreadLocal<WeakHashMap<Class<?>, ObjectStreamClass>>> storage = new SoftReference<ThreadLocal<WeakHashMap<Class<?>, ObjectStreamClass>>>(null);
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
                            return getMethodSignature(m1).compareTo(
                                    getMethodSignature(m2));
                        }
                        return result;
                    }
    
    // orphaned legacy method
    public int compare(Constructor<?> ctr1, Constructor<?> ctr2) {
                        return (getConstructorSignature(ctr1)
                                .compareTo(getConstructorSignature(ctr2)));
                    }
    
    // orphaned legacy method
    public int compare(Field field1, Field field2) {
                        return field1.getName().compareTo(field2.getName());
                    }
    
}

