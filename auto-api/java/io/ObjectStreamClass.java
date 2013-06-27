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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.613 -0400", hash_original_field = "924AD349EDF719B44ED4F6F5E69E79C8", hash_generated_field = "565644E752815B2ABF82349A3CEA0B6B")

    private transient Method methodWriteReplace;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.613 -0400", hash_original_field = "122CA9229276E3DB873F1636B9A73713", hash_generated_field = "6059C8931AF46DD9869FE9A893452731")

    private transient Method methodReadResolve;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.613 -0400", hash_original_field = "0AF54E3AF04EAD8206E09DE0F3EFF6A5", hash_generated_field = "79B39BB54513173AC7D6E6CEF6CBC2C1")

    private transient Method methodWriteObject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.613 -0400", hash_original_field = "B82644AD4949DE727339E54F199447FA", hash_generated_field = "95EB8846D319017FC3432FF6857D1E5F")

    private transient Method methodReadObject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.613 -0400", hash_original_field = "32BFCA8D9BFE8B95457E5550245CB6B9", hash_generated_field = "7CE9FEA6AC19BB8C204FD6B95B2862F7")

    private transient Method methodReadObjectNoData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.613 -0400", hash_original_field = "98E79AD3A7FF3396963BD7E17B70758D", hash_generated_field = "9CF3DD8AED4B95AE1F483D580B3C9FB3")

    private transient boolean arePropertiesResolved;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.613 -0400", hash_original_field = "C4140104E3123239B50920CAF039E81E", hash_generated_field = "CCFF438B2B69BBC8976762B5C0E1BAAE")

    private transient boolean isSerializable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.613 -0400", hash_original_field = "E7861AE2BAD033AB7951E8BEF5C2A338", hash_generated_field = "4BE511410EC0FFD94E2FF75D626D91CA")

    private transient boolean isExternalizable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.613 -0400", hash_original_field = "AD3DC48725AE019F4BB4FCBF31A8F0A2", hash_generated_field = "08F3A9F82723EA0AE100503EE65CAB86")

    private transient boolean isProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.613 -0400", hash_original_field = "DE5BB2742FE3A4D4DDF9022B2054FD05", hash_generated_field = "36F43E2AAA4E18617E48CB413466DD29")

    private transient boolean isEnum;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.613 -0400", hash_original_field = "6F66E878C62DB60568A3487869695820", hash_generated_field = "288941F24943F280BE7DD01D20E3054F")

    private transient String className;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.613 -0400", hash_original_field = "49F703B414E479ADB1C3D60FCEC4F53F", hash_generated_field = "AC340BA4F3A44FB166243898294EB37E")

    private transient Class<?> resolvedClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.613 -0400", hash_original_field = "F92B03D6EDD39C2B4E711BE71293FD13", hash_generated_field = "971C9C890CEBC6BE40FABDECB2212AA0")

    private transient Class<?> resolvedConstructorClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.613 -0400", hash_original_field = "0F889FB01934E2F8046B517E783FC0E3", hash_generated_field = "A4FBAD79CEB03A973A15AB5C7331E7A6")

    private transient int resolvedConstructorMethodId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.613 -0400", hash_original_field = "28CDF3CD863FE5D84844FE25A3CD04A2", hash_generated_field = "2CBD7F29D2CB9FEFE962129E37123233")

    private transient long svUID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.613 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "E30025CF9CDCA8A17963070ADA592697")

    private transient byte flags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.613 -0400", hash_original_field = "7ECAB020F524F5AA6F04649D13BC0A2C", hash_generated_field = "F7485FE95D068421E7ED5928F1406E97")

    private transient ObjectStreamClass superclass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.613 -0400", hash_original_field = "D05B6ED7D2345020440DF396D6DA7F73", hash_generated_field = "186A117481AECE390EACD17A001BE99F")

    private transient ObjectStreamField[] fields;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.613 -0400", hash_original_field = "B7449C3BA34A98413B53EF5F6AAAAE64", hash_generated_field = "A56A7B7B744B804CA41E1FD965741EE2")

    private transient ObjectStreamField[] loadFields;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.613 -0400", hash_original_field = "7ED7EB5221669EADB9DDC3B8CA1218F3", hash_generated_field = "00A9BB651D9852E56EFAEA15E35B461E")

    private transient HashMap<ObjectStreamField, Field> reflectionFields = new HashMap<ObjectStreamField, Field>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.614 -0400", hash_original_field = "6ED86FE66FD07A5256097A5CD1494E95", hash_generated_field = "C0358E6BFD2D898DD9C7ADBEBD4D2ECF")

    private transient long constructor = CONSTRUCTOR_IS_NOT_RESOLVED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.614 -0400", hash_original_field = "B145651EF057F5E0B5598B009F752B32", hash_generated_field = "4AA36F11897D193C7F055A6BB8228782")

    private transient volatile List<ObjectStreamClass> cachedHierarchy;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.614 -0400", hash_original_method = "F4D9898A03FC0DADA999BF46D97F9433", hash_generated_method = "A9246BC45205ECF4E818CF0D168C4ADC")
      ObjectStreamClass() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.614 -0400", hash_original_method = "7053F33417C9644BFD49070B9EF96C54", hash_generated_method = "AC3AFCBDE4A9E172383956581C876B87")
     void setConstructor(long newConstructor) {
        constructor = newConstructor;
        // ---------- Original Method ----------
        //constructor = newConstructor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.614 -0400", hash_original_method = "AE977884038645FC18D9650C0686387C", hash_generated_method = "820FBF726C27857B7D1115A27B97CEEC")
     long getConstructor() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2107972527 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2107972527;
        // ---------- Original Method ----------
        //return constructor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.627 -0400", hash_original_method = "592D0703821799AB937A99A67AB05B5C", hash_generated_method = "94E7844F4E3AF37A930F72B7737D1574")
     Field getReflectionField(ObjectStreamField osf) {
        Field varB4EAC82CA7396A68D541C85D26508E83_1983663648 = null; //Variable for return #1
        Field varB4EAC82CA7396A68D541C85D26508E83_518397270 = null; //Variable for return #2
        Field varB4EAC82CA7396A68D541C85D26508E83_1611197688 = null; //Variable for return #3
        {
            Field field;
            field = reflectionFields.get(osf);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1983663648 = field;
            } //End block
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
            varB4EAC82CA7396A68D541C85D26508E83_518397270 = reflectionFields.get(osf);
        } //End block
        catch (NoSuchFieldException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1611197688 = null;
        } //End block
        addTaint(osf.getTaint());
        Field varA7E53CE21691AB073D9660D615818899_823467160; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_823467160 = varB4EAC82CA7396A68D541C85D26508E83_1983663648;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_823467160 = varB4EAC82CA7396A68D541C85D26508E83_518397270;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_823467160 = varB4EAC82CA7396A68D541C85D26508E83_1611197688;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_823467160.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_823467160;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.679 -0400", hash_original_method = "3492CF41320405C3965233DAB60A3EF1", hash_generated_method = "7EDACB62622E2E56FBC8E91459C52EFE")
     void buildFieldDescriptors(Field[] declaredFields) {
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
                Iterator<Field> var159717E9986B19084138F4BBBD10820B_1722426071 = (declaredFields).iterator();
                var159717E9986B19084138F4BBBD10820B_1722426071.hasNext();
                Field declaredField = var159717E9986B19084138F4BBBD10820B_1722426071.next();
                {
                    int modifiers;
                    modifiers = declaredField.getModifiers();
                    {
                        boolean var0B0C4470A78EE89D4D1877A6DDF6E76D_79707048 = (!Modifier.isStatic(modifiers) && !Modifier.isTransient(modifiers));
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
                boolean varFDB496ED83E038616C56C9314DBD5FA6_1132309167 = (serializableFields.size() == 0);
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
                    boolean varA97A53306537CEF5EB846AEB112A7855_800902228 = (type.isPrimitive());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.686 -0400", hash_original_method = "3FC829F6BB79347D76007A55E3423470", hash_generated_method = "A861E9272B46BCA02C79AF643375F027")
    public Class<?> forClass() {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_382263936 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_382263936 = resolvedClass;
        varB4EAC82CA7396A68D541C85D26508E83_382263936.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_382263936;
        // ---------- Original Method ----------
        //return resolvedClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.686 -0400", hash_original_method = "CFDAB7386CDDDD8EC35152CD7D073792", hash_generated_method = "F25EEDBA52D39B3268987E76D6E7032D")
     Object newInstance(Class<?> instantiationClass) throws InvalidClassException {
        Object varB4EAC82CA7396A68D541C85D26508E83_629545840 = null; //Variable for return #1
        resolveConstructorClass(instantiationClass);
        varB4EAC82CA7396A68D541C85D26508E83_629545840 = newInstance(instantiationClass, resolvedConstructorMethodId);
        addTaint(instantiationClass.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_629545840.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_629545840;
        // ---------- Original Method ----------
        //resolveConstructorClass(instantiationClass);
        //return newInstance(instantiationClass, resolvedConstructorMethodId);
    }

    
        private static Object newInstance(Class<?> instantiationClass, int methodId) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.695 -0400", hash_original_method = "66A47A19F5FB8C837FA66140F62CB154", hash_generated_method = "0C88E83ECCD36835539782B60B7BDF37")
    private Class<?> resolveConstructorClass(Class<?> objectClass) throws InvalidClassException {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_57048909 = null; //Variable for return #1
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1008015388 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_57048909 = resolvedConstructorClass;
        } //End block
        Class<?> constructorClass;
        constructorClass = objectClass;
        boolean wasSerializable;
        wasSerializable = (flags & ObjectStreamConstants.SC_SERIALIZABLE) != 0;
        {
            {
                boolean varFDE4CBEE93EED52DBC15AAE1ACE55609_689887865 = (constructorClass != null && ObjectStreamClass.isSerializable(constructorClass));
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
                boolean var01C93A2AE05D9878C907DF6E9F64ECCC_2010728089 = (!inSamePackage(constructorClass, objectClass));
                {
                    if (DroidSafeAndroidRuntime.control) throw new InvalidClassException(constructorClass.getName(), "IllegalAccessException");
                } //End block
            } //End collapsed parenthetic
        } //End block
        resolvedConstructorClass = constructorClass;
        resolvedConstructorMethodId = getConstructorId(resolvedConstructorClass);
        varB4EAC82CA7396A68D541C85D26508E83_1008015388 = constructorClass;
        addTaint(objectClass.getTaint());
        Class<?> varA7E53CE21691AB073D9660D615818899_1537597970; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1537597970 = varB4EAC82CA7396A68D541C85D26508E83_57048909;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1537597970 = varB4EAC82CA7396A68D541C85D26508E83_1008015388;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1537597970.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1537597970;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static int getConstructorId(Class<?> c) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.702 -0400", hash_original_method = "C730C766F4F6CE91266CBA72D38C529A", hash_generated_method = "D0332DB9CA02B87709C48BF1E636EC07")
    private boolean inSamePackage(Class<?> c1, Class<?> c2) {
        String nameC1;
        nameC1 = c1.getName();
        String nameC2;
        nameC2 = c2.getName();
        int indexDotC1;
        indexDotC1 = nameC1.lastIndexOf('.');
        int indexDotC2;
        indexDotC2 = nameC2.lastIndexOf('.');
        boolean var16017E65E75A0A549986C98F6129AABC_1625363384 = (nameC1.regionMatches(0, nameC2, 0, indexDotC1));
        addTaint(c1.getTaint());
        addTaint(c2.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1506756287 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1506756287;
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
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.702 -0400", hash_original_method = "58A307C728457592549C73808957655C", hash_generated_method = "FECE76AEDCE95A2C20BF04C32938FC48")
    public ObjectStreamField getField(String name) {
        ObjectStreamField varB4EAC82CA7396A68D541C85D26508E83_538567521 = null; //Variable for return #1
        ObjectStreamField varB4EAC82CA7396A68D541C85D26508E83_1068974490 = null; //Variable for return #2
        ObjectStreamField[] allFields;
        allFields = getFields();
        {
            int i;
            i = 0;
            {
                ObjectStreamField f;
                f = allFields[i];
                {
                    boolean var32E5452974F5912B0D1DFCF62E31A958_1012898279 = (f.getName().equals(name));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_538567521 = f;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1068974490 = null;
        addTaint(name.getTaint());
        ObjectStreamField varA7E53CE21691AB073D9660D615818899_416123995; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_416123995 = varB4EAC82CA7396A68D541C85D26508E83_538567521;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_416123995 = varB4EAC82CA7396A68D541C85D26508E83_1068974490;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_416123995.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_416123995;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.710 -0400", hash_original_method = "3D80A7A04F3988E3E464D888981C4A01", hash_generated_method = "46B38B5C6C3FF45935990E33BAFE4C5F")
     ObjectStreamField[] fields() {
        ObjectStreamField[] varB4EAC82CA7396A68D541C85D26508E83_1943106225 = null; //Variable for return #1
        {
            Class<?> forCl;
            forCl = forClass();
            {
                boolean var793D8E01C16F5EE9855A6887A9C40654_1043520224 = (forCl != null && isSerializable() && !forCl.isArray());
                {
                    buildFieldDescriptors(forCl.getDeclaredFields());
                } //End block
                {
                    setFields(NO_FIELDS);
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1943106225 = fields;
        varB4EAC82CA7396A68D541C85D26508E83_1943106225.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1943106225;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.710 -0400", hash_original_method = "BA69DA3B5E6C7F20CA233B877CCB0384", hash_generated_method = "D6598E3A568491F74932AB8B42D1764F")
    public ObjectStreamField[] getFields() {
        ObjectStreamField[] varB4EAC82CA7396A68D541C85D26508E83_766814263 = null; //Variable for return #1
        copyFieldAttributes();
        varB4EAC82CA7396A68D541C85D26508E83_766814263 = loadFields == null ? fields().clone() : loadFields.clone();
        varB4EAC82CA7396A68D541C85D26508E83_766814263.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_766814263;
        // ---------- Original Method ----------
        //copyFieldAttributes();
        //return loadFields == null ? fields().clone() : loadFields.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.711 -0400", hash_original_method = "8AA71837DDE89491F51C878CBC8B38A5", hash_generated_method = "FC285D8DB8C0AFCF725B33AA07ADD65E")
     List<ObjectStreamClass> getHierarchy() {
        List<ObjectStreamClass> varB4EAC82CA7396A68D541C85D26508E83_1669291664 = null; //Variable for return #1
        List<ObjectStreamClass> result;
        result = cachedHierarchy;
        {
            cachedHierarchy = result = makeHierarchy();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1669291664 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1669291664.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1669291664;
        // ---------- Original Method ----------
        //List<ObjectStreamClass> result = cachedHierarchy;
        //if (result == null) {
            //cachedHierarchy = result = makeHierarchy();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.711 -0400", hash_original_method = "970C4D30E4F07A217EB44CA0880B9D33", hash_generated_method = "DEC4608B26E7E51E030B6EFB54D009D0")
    private List<ObjectStreamClass> makeHierarchy() {
        List<ObjectStreamClass> varB4EAC82CA7396A68D541C85D26508E83_1156787830 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1156787830 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1156787830.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1156787830;
        // ---------- Original Method ----------
        //ArrayList<ObjectStreamClass> result = new ArrayList<ObjectStreamClass>();
        //for (ObjectStreamClass osc = this; osc != null; osc = osc.getSuperclass()) {
            //result.add(0, osc);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.712 -0400", hash_original_method = "F57C7EC559BF09EB03BA0EA2BC063E8F", hash_generated_method = "D77E77B0B8C5F42A94CDC7FA2FD42FC2")
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
                            boolean var249D9F14035FBD16E855916C4D99FDA9_2025063467 = (name.equals(field.getName()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.713 -0400", hash_original_method = "8F334CDB84C81A51C0419AAF322CA87A", hash_generated_method = "1913719D293999780BD1BC0EC1F7B916")
     ObjectStreamField[] getLoadFields() {
        ObjectStreamField[] varB4EAC82CA7396A68D541C85D26508E83_590375301 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_590375301 = loadFields;
        varB4EAC82CA7396A68D541C85D26508E83_590375301.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_590375301;
        // ---------- Original Method ----------
        //return loadFields;
    }

    
        private static String getFieldSignature(Field f) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.787 -0400", hash_original_method = "CB224A404D2A4A24CFF7504565CB22F2", hash_generated_method = "128099D05AE332B42D0EB497EE8E516F")
     byte getFlags() {
        byte var40EA57D3EE3C07BF1C102B466E1C3091_170628245 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_170628245;
        // ---------- Original Method ----------
        //return flags;
    }

    
        static String getMethodSignature(Method m) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.788 -0400", hash_original_method = "4A271A070FBC29EF826D1B50170E00D2", hash_generated_method = "48A52AAD4B43990FDD892F4A8E134889")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1980002153 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1980002153 = className;
        varB4EAC82CA7396A68D541C85D26508E83_1980002153.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1980002153;
        // ---------- Original Method ----------
        //return className;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.788 -0400", hash_original_method = "50DDDA79153910C7DDC4FA6D8AF3586E", hash_generated_method = "37FE7B785BF28049B81C9455896AEE1E")
    public long getSerialVersionUID() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1083751864 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1083751864;
        // ---------- Original Method ----------
        //return svUID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.789 -0400", hash_original_method = "B099B86A783D62A1B2FEC5CAB74CA2FF", hash_generated_method = "859127BD46C9984D843C4F4C3EA78484")
     ObjectStreamClass getSuperclass() {
        ObjectStreamClass varB4EAC82CA7396A68D541C85D26508E83_611588903 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_611588903 = superclass;
        varB4EAC82CA7396A68D541C85D26508E83_611588903.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_611588903;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.794 -0400", hash_original_method = "742EA2900A6EB88CE28517352A724CD7", hash_generated_method = "CC63C37364420B18FEC87E5A532480EA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.795 -0400", hash_original_method = "250E0179C7C05D1D77B183DF06C38BC2", hash_generated_method = "F12EAA304DD33ABA3A5D8942B32E9FB7")
     boolean isSerializable() {
        resolveProperties();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_616073212 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_616073212;
        // ---------- Original Method ----------
        //resolveProperties();
        //return isSerializable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.795 -0400", hash_original_method = "86835294A15C6057A38D3AF0C7A856A1", hash_generated_method = "2832E54FFBE6A22C4D3DA3CFA4CD5F1B")
     boolean isExternalizable() {
        resolveProperties();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1925180124 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1925180124;
        // ---------- Original Method ----------
        //resolveProperties();
        //return isExternalizable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.795 -0400", hash_original_method = "052543446E0B6EEA498804C02394B590", hash_generated_method = "B373662D422D4D392B62044D920C152D")
     boolean isProxy() {
        resolveProperties();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2068973031 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2068973031;
        // ---------- Original Method ----------
        //resolveProperties();
        //return isProxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.796 -0400", hash_original_method = "23781B8C58B21A484CF86E4B23EBD9CC", hash_generated_method = "A46D6C3A191311ED98CC489E908B57A0")
     boolean isEnum() {
        resolveProperties();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1054207052 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1054207052;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.816 -0400", hash_original_method = "8B291B650661131936FFDD0976F9C451", hash_generated_method = "870B973549F95CD6EFE5043DA16C8A64")
     boolean hasMethodWriteReplace() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_504893313 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_504893313;
        // ---------- Original Method ----------
        //return (methodWriteReplace != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.817 -0400", hash_original_method = "42662B3DE24059CFD85E0D286320D7E3", hash_generated_method = "60969AF2F1B7664B09AD4F54DB3E9CA3")
     Method getMethodWriteReplace() {
        Method varB4EAC82CA7396A68D541C85D26508E83_965480264 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_965480264 = methodWriteReplace;
        varB4EAC82CA7396A68D541C85D26508E83_965480264.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_965480264;
        // ---------- Original Method ----------
        //return methodWriteReplace;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.818 -0400", hash_original_method = "2852DBB1E5C3B0D1351FCC53EE3E49ED", hash_generated_method = "C215FB9188E85F59739559448729B528")
     boolean hasMethodReadResolve() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1951298698 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1951298698;
        // ---------- Original Method ----------
        //return (methodReadResolve != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.834 -0400", hash_original_method = "4E87A71E13632BD19F893729646A7048", hash_generated_method = "1E4BA6743DB6D5A866B8ADB331262828")
     Method getMethodReadResolve() {
        Method varB4EAC82CA7396A68D541C85D26508E83_262608282 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_262608282 = methodReadResolve;
        varB4EAC82CA7396A68D541C85D26508E83_262608282.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_262608282;
        // ---------- Original Method ----------
        //return methodReadResolve;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.834 -0400", hash_original_method = "5A79EE26139C94EE3C3A1C73D8050C0E", hash_generated_method = "73A60EC38B32B1CFDE08720F405A2928")
     boolean hasMethodWriteObject() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1867062158 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1867062158;
        // ---------- Original Method ----------
        //return (methodWriteObject != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.834 -0400", hash_original_method = "234967F1224E01D561A4A7AA93A723BD", hash_generated_method = "69D0C11DA51CAADAAC0755FD39924586")
     Method getMethodWriteObject() {
        Method varB4EAC82CA7396A68D541C85D26508E83_1950487811 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1950487811 = methodWriteObject;
        varB4EAC82CA7396A68D541C85D26508E83_1950487811.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1950487811;
        // ---------- Original Method ----------
        //return methodWriteObject;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.834 -0400", hash_original_method = "46A702B5AEFAE4B1088A7C3DF1FC5D53", hash_generated_method = "2CF79AD9E7B69D32698597319549082C")
     boolean hasMethodReadObject() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_136533750 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_136533750;
        // ---------- Original Method ----------
        //return (methodReadObject != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.835 -0400", hash_original_method = "46960222BC0B63A6D59A57191BB77464", hash_generated_method = "14A8BABC06EC2D80F873B3E1F8FD99B8")
     Method getMethodReadObject() {
        Method varB4EAC82CA7396A68D541C85D26508E83_1407164121 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1407164121 = methodReadObject;
        varB4EAC82CA7396A68D541C85D26508E83_1407164121.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1407164121;
        // ---------- Original Method ----------
        //return methodReadObject;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.835 -0400", hash_original_method = "29BCBE89B6EA217724D7699109546E15", hash_generated_method = "750D95881C78F8178E4F4FD5348582F2")
     boolean hasMethodReadObjectNoData() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_226612693 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_226612693;
        // ---------- Original Method ----------
        //return (methodReadObjectNoData != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.835 -0400", hash_original_method = "04BED52E799E809DB8DD364039964962", hash_generated_method = "C99E12E914A0B8DCBCB42FC23564F2FA")
     Method getMethodReadObjectNoData() {
        Method varB4EAC82CA7396A68D541C85D26508E83_323605832 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_323605832 = methodReadObjectNoData;
        varB4EAC82CA7396A68D541C85D26508E83_323605832.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_323605832;
        // ---------- Original Method ----------
        //return methodReadObjectNoData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.836 -0400", hash_original_method = "971C620E95BDC0255A7014EB736B5315", hash_generated_method = "B5F3BDDAE6A803CDF4D471FA2756DB0E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.836 -0400", hash_original_method = "7A3AD0F8FFB276A7B1543CE5BED00A8C", hash_generated_method = "F5A742D0B09B68C4FB60A9954C304EDB")
     void setClass(Class<?> c) {
        resolvedClass = c;
        // ---------- Original Method ----------
        //resolvedClass = c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.836 -0400", hash_original_method = "95CB44F7E664D85BD475B63456D19F48", hash_generated_method = "621FA11CDA9BF8080C1105CE3A873D93")
     void setFields(ObjectStreamField[] f) {
        fields = f;
        // ---------- Original Method ----------
        //fields = f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.844 -0400", hash_original_method = "BCDE99C62E7E698332D80A91E945CB98", hash_generated_method = "D8783C05CB4817ECCBC0A4DB4114E614")
     void setLoadFields(ObjectStreamField[] f) {
        loadFields = f;
        // ---------- Original Method ----------
        //loadFields = f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.844 -0400", hash_original_method = "576B4ED3621FB044BCB61FA4A013466B", hash_generated_method = "A1473C1BC66B458281188527CD3D2FFA")
     void setFlags(byte b) {
        flags = b;
        // ---------- Original Method ----------
        //flags = b;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.844 -0400", hash_original_method = "013A745A10FFAC0063C18ECA8D35B13C", hash_generated_method = "A8DB264CFECA0C5CD0FC0F9AB8AC5A8F")
     void setName(String newName) {
        className = newName;
        // ---------- Original Method ----------
        //className = newName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.853 -0400", hash_original_method = "F5AE79B32CCC15982EBF3437ADD142B6", hash_generated_method = "2B1ADB1E939E150C2B4F3759E3B94493")
     void setSerialVersionUID(long l) {
        svUID = l;
        // ---------- Original Method ----------
        //svUID = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.863 -0400", hash_original_method = "0C66D1C8E17ECB3824AFA99C964D873A", hash_generated_method = "B10D683C7024190847B8FAF4B67B2A8C")
     void setSuperclass(ObjectStreamClass c) {
        superclass = c;
        // ---------- Original Method ----------
        //superclass = c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.864 -0400", hash_original_method = "555F932795060D0A381054093FA5AE4C", hash_generated_method = "F7810857DBFADDA70FBC7026BAE49888")
    private int primitiveSize(Class<?> type) {
        if (DroidSafeAndroidRuntime.control) throw new AssertionError();
        addTaint(type.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_317528324 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_317528324;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.864 -0400", hash_original_method = "0689970A4402522168D5BA272C87560D", hash_generated_method = "7ED32336538B8A8D37005FE90AB242CB")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_861042203 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_861042203 = getName() + ": static final long serialVersionUID =" + getSerialVersionUID() + "L;";
        varB4EAC82CA7396A68D541C85D26508E83_861042203.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_861042203;
        // ---------- Original Method ----------
        //return getName() + ": static final long serialVersionUID =" + getSerialVersionUID() + "L;";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.864 -0400", hash_original_field = "F80ED60A319D1F80CB33832164C227CF", hash_generated_field = "E41E94063A7A531342A1465B4D36F60D")

    private static long serialVersionUID = -6120832682080437368L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.864 -0400", hash_original_field = "356C063796A1DA01825DA22B2E8BF97E", hash_generated_field = "0ADE90057A267DFB383459C6A0586139")

    private static String UID_FIELD_NAME = "serialVersionUID";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.864 -0400", hash_original_field = "804DD882D7CAF8F79C2FD4521F960B6D", hash_generated_field = "F0E25EC000FBA71D824CA3CD9953DAAD")

    static long CONSTRUCTOR_IS_NOT_RESOLVED = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.864 -0400", hash_original_field = "622985B8B870C83F524B1E348D91C675", hash_generated_field = "A57C76BD067D1189851CE8610A785872")

    private static int CLASS_MODIFIERS_MASK = Modifier.PUBLIC | Modifier.FINAL |
            Modifier.INTERFACE | Modifier.ABSTRACT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.865 -0400", hash_original_field = "A22CFAB1E19A0404A170D1B7CE8C38AA", hash_generated_field = "A14951D2E087D0AB8C5C4292D73B268D")

    private static int FIELD_MODIFIERS_MASK = Modifier.PUBLIC | Modifier.PRIVATE |
            Modifier.PROTECTED | Modifier.STATIC | Modifier.FINAL | Modifier.VOLATILE |
            Modifier.TRANSIENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.865 -0400", hash_original_field = "91DFB60E26ED5735564D744CF8176019", hash_generated_field = "282208F349F5832BE16D801B88C31C9D")

    private static int METHOD_MODIFIERS_MASK = Modifier.PUBLIC | Modifier.PRIVATE |
            Modifier.PROTECTED | Modifier.STATIC | Modifier.FINAL | Modifier.SYNCHRONIZED |
            Modifier.NATIVE | Modifier.ABSTRACT | Modifier.STRICT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.865 -0400", hash_original_field = "624FC6A8300688A4B8B6B2000FCD81E0", hash_generated_field = "C12EE4F801E1F226DEADEBF2C52752CC")

    private static Class<?>[] READ_PARAM_TYPES = new Class[] { ObjectInputStream.class };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.865 -0400", hash_original_field = "C13E9F6B09096E6021DA7DDB46B18579", hash_generated_field = "35274DA224D2B7210EBFD546B69B636F")

    private static Class<?>[] WRITE_PARAM_TYPES = new Class[] { ObjectOutputStream.class };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.865 -0400", hash_original_field = "243B2E96A5F4E8F89A323D42DBE7EEBC", hash_generated_field = "7D11682BF64A4B005019DE32559565EF")

    public static final ObjectStreamField[] NO_FIELDS = new ObjectStreamField[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.865 -0400", hash_original_field = "92BCE7D158829B88C361F39F1D78D7E8", hash_generated_field = "6978DEEE48DC3157891475C4DA0DAB91")

    static Class<?> ARRAY_OF_FIELDS;
    static {
        try {
            ARRAY_OF_FIELDS = Class.forName("[Ljava.io.ObjectStreamField;");
        } catch (ClassNotFoundException e) {
            throw new AssertionError(e);
        }
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.865 -0400", hash_original_field = "F76F81B088AEDCF4CC4AC04CE877788E", hash_generated_field = "14DE3FD399514795BC9AF1609116D9E4")

    private static String CLINIT_NAME = "<clinit>";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.865 -0400", hash_original_field = "8DF4213BA7E05A81E7135E331B30C11A", hash_generated_field = "C4347278E576448462F519943C4270B8")

    private static int CLINIT_MODIFIERS = Modifier.STATIC;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.865 -0400", hash_original_field = "BB1CCCC3FF0A517413C95AB9047469B9", hash_generated_field = "F22F1B63FCBB7BC30D60EE006AD50B25")

    private static String CLINIT_SIGNATURE = "()V";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.865 -0400", hash_original_field = "94EB83F78C40AA1F634F2E0003836AD5", hash_generated_field = "301A650035F05FEC12EEFBD28EC5410B")

    private static Class<Serializable> SERIALIZABLE = Serializable.class;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.865 -0400", hash_original_field = "11A54DB730E2A2D3B34516F5BDFFC5DA", hash_generated_field = "A8710160377F90C8B57B2A38035A81DF")

    private static Class<Externalizable> EXTERNALIZABLE = Externalizable.class;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.865 -0400", hash_original_field = "596AA5ABAEC6715E1C73E44D6723DCCF", hash_generated_field = "34363D443B7E316581044781988636CD")

    static Class<String> STRINGCLASS = String.class;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.865 -0400", hash_original_field = "5F0E1B2239647B717460E2812C1E45A5", hash_generated_field = "91903B167255F25CF1CED60E97EA333D")

    static Class<?> CLASSCLASS = Class.class;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.865 -0400", hash_original_field = "4A025773485868FB6759CAC7E647646C", hash_generated_field = "8F2985441FFFD65C69F5F4B8C21E0C14")

    static Class<ObjectStreamClass> OBJECTSTREAMCLASSCLASS = ObjectStreamClass.class;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.865 -0400", hash_original_field = "17CA37E35AD877567E00ECAF794A6918", hash_generated_field = "16A63F3AB899CF3EB9607AD6E5CAA631")

    private static SoftReference<ThreadLocal<WeakHashMap<Class<?>, ObjectStreamClass>>> storage = new SoftReference<ThreadLocal<WeakHashMap<Class<?>, ObjectStreamClass>>>(null);
}

