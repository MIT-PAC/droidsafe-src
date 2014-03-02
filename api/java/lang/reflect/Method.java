package java.lang.reflect;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.annotation.Annotation;
import java.util.Comparator;

import libcore.util.EmptyArray;

import org.apache.harmony.kernel.vm.StringUtils;
import org.apache.harmony.luni.lang.reflect.GenericSignatureParser;
import org.apache.harmony.luni.lang.reflect.ListOfTypes;
import org.apache.harmony.luni.lang.reflect.Types;

import droidsafe.helpers.DSUtils;

public final class Method extends AccessibleObject implements GenericDeclaration, Member {
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static Object[] getSignatureAnnotation(Class declaringClass, int slot) {
		Object[] ret = new Object[0];
		ret[0].addTaint(declaringClass.taint);
		ret[0].addTaint(slot);
		return ret;
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static Annotation[] getDeclaredAnnotations(Class<?> declaringClass, int slot) {
		Annotation[] ret = new Annotation[0];
		ret[0].addTaint(declaringClass.taint);
		ret[0].addTaint(slot);
		return ret;
	}
    
    static <A extends Annotation> A getAnnotation(Class<?> declaringClass, int slot, Class<A> annotationType) {
		A ret = (A) new Object();
		ret.addTaint(declaringClass.taint);
		ret.addTaint(slot);
		ret.addTaint(annotationType.taint);
		return ret;
	}
    
    static boolean isAnnotationPresent(Class<?> declaringClass, int slot, Class<? extends Annotation> annotationType) {
        Object obj = new Object();
        obj.addTaint(declaringClass.getTaint());
        obj.addTaint(slot);
        obj.addTaint(annotationType.getTaint());
        return obj.getTaintBoolean();
    }

    /**
     * Creates an array of empty Annotation arrays.
     */
    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.528 -0500", hash_original_method = "A33FB39CB64C1B7C3BBB588CC3F72925", hash_generated_method = "8C7A6A57A598959B1606649CF15F688C")
    
static Annotation[][] noAnnotations(int size) {
        Annotation[][] annotations = new Annotation[size][];
        for (int i = 0; i < size; i++) {
            annotations[i] = NO_ANNOTATIONS;
        }
        return annotations;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static Annotation[][] getParameterAnnotations(Class declaringClass, int slot) {
		Annotation[][] ret = new Annotation[0][0];
		ret[0][0].addTaint(declaringClass.taint);
		ret[0][0].addTaint(slot);
		return ret;
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static int getMethodModifiers(Class<?> declaringClass, int slot) {
        
        Object obj = new Object();
        obj.addTaint(declaringClass.getTaint());
        obj.addTaint(slot);
        return obj.getTaintInt();
	}
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.128 -0400", hash_original_field = "6D5C49EE7CEF5783A42FC1C7653D6955", hash_generated_field = "3465881694FBE3BA7144100AF6865EE1")

    public static final Comparator<Method> ORDER_BY_SIGNATURE = new Comparator<Method>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.441 -0500", hash_original_method = "BE88CC170A38DCD3E91DA840E3F7F4E0", hash_generated_method = "718F91E2E34FEFE101F1370F38B5FFE9")
        
public int compare(Method a, Method b) {
            int comparison = a.name.compareTo(b.name);
            if (comparison != 0) {
                return comparison;
            }

            Class<?>[] aParameters = a.parameterTypes;
            Class<?>[] bParameters = b.parameterTypes;
            int length = Math.min(aParameters.length, bParameters.length);
            for (int i = 0; i < length; i++) {
                comparison = aParameters[i].getName().compareTo(bParameters[i].getName());
                if (comparison != 0) {
                    return comparison;
                }
            }

            if (aParameters.length != bParameters.length) {
                return aParameters.length - bParameters.length;
            }

            // this is necessary for methods that have covariant return types.
            return a.getReturnType().getName().compareTo(b.getReturnType().getName());
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.525 -0500", hash_original_field = "0C73BE0651CF116606278017BBAFA70A", hash_generated_field = "D584CD4D5524F6C731424F703C29B84F")

    private static final Annotation[] NO_ANNOTATIONS = new Annotation[0];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.447 -0500", hash_original_field = "09F7A5BA4BC6B04AB18035FB41A6CB6C", hash_generated_field = "6B06F56F1EB868ADA8CFFD63973A7E09")

    private int slot;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.449 -0500", hash_original_field = "241D06F27490B4FC35F16806876AF0D3", hash_generated_field = "EC96049C106D95C970CBF94E8CE21744")

    @DSVAModeled
    private Class<?> declaringClass;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.452 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    @DSVAModeled
    private String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.454 -0500", hash_original_field = "6A17A418C19B2E2A1B1FDDDFEF7489B2", hash_generated_field = "2BEA8A3EFDFBD76D3A4CCA6C3AC7E53C")

    @DSVAModeled
    private Class<?>[] parameterTypes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.456 -0500", hash_original_field = "0166CFA676A3372FA7BAE30D743E0654", hash_generated_field = "2A0AC8F9632DF82B378D2F01BC74BDF4")

    private Class<?>[] exceptionTypes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.459 -0500", hash_original_field = "1E56956502169CC95540A786BAA638AD", hash_generated_field = "052C26419A9A6CDFB48BC17097CACAE9")

    @DSVAModeled
    private Class<?> returnType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.461 -0500", hash_original_field = "1086E50AEBD292B3AD2410822F2C4F08", hash_generated_field = "924C48D07F65387E616D3CE31DE5954D")

    private ListOfTypes genericExceptionTypes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.463 -0500", hash_original_field = "8AC26B514C4DE93BC9F36D116E4A4BC6", hash_generated_field = "4E98B7DC70F3037D11B527C2E4899BBD")

    private ListOfTypes genericParameterTypes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.466 -0500", hash_original_field = "37FAC880200D9C4671AC0282E4940755", hash_generated_field = "32E37E22BB1C76784903951645BC45C1")

    private Type genericReturnType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.469 -0500", hash_original_field = "D18E4A93B55623A68F32E4CADF845425", hash_generated_field = "4338B9C9877379FEA81BE0E690FD4B47")

    private TypeVariable<Method>[] formalTypeParameters;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.471 -0500", hash_original_field = "882601A2CEBECCB3AC8128B79706E015", hash_generated_field = "89FDBAE6DE2AE55271071C78F774F101")

    private volatile boolean genericTypesAreInitialized = false;

    /**
     * Construct a clone of the given instance.
     *
     * @param orig non-null; the original instance to clone
     */
    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.477 -0500", hash_original_method = "70F1F77231BFE73E3138A8A58A15C35C", hash_generated_method = "A1DA50C27B1D8906753DF79746239F15")
    
Method(Method orig) {
        this(orig.declaringClass, orig.parameterTypes, orig.exceptionTypes,
                orig.returnType, orig.name, orig.slot);

        // Copy the accessible flag.
        if (orig.flag) {
            this.flag = true;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.481 -0500", hash_original_method = "F4B9C750B34D03AFED72DBA84048C99D", hash_generated_method = "5EB83EDC925C7DA5615D4A150F17A05C")
    
private Method(Class<?> declaring, Class<?>[] paramTypes, Class<?>[] exceptTypes, Class<?> returnType, String name, int slot)
    {
        this.declaringClass = declaring;
        this.name = name;
        this.slot = slot;
        this.parameterTypes = paramTypes;
        this.exceptionTypes = exceptTypes;      // may be null
        this.returnType = returnType;
    }
    // orphaned legacy method
    
    public Method() {

	}

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.474 -0500", hash_original_method = "0BE83C703D137B5A5A60EFAA17178485", hash_generated_method = "60615FB4B53F171169936FBF33069ED6")
    
private synchronized void initGenericTypes() {
        if (!genericTypesAreInitialized) {
            String signatureAttribute = getSignatureAttribute();
            GenericSignatureParser parser = new GenericSignatureParser(
                    declaringClass.getClassLoader());
            parser.parseForMethod(this, signatureAttribute, exceptionTypes);
            formalTypeParameters = parser.formalTypeParameters;
            genericParameterTypes = parser.parameterTypes;
            genericExceptionTypes = parser.exceptionTypes;
            genericReturnType = parser.returnType;
            genericTypesAreInitialized = true;
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.483 -0500", hash_original_method = "0F068F731FE610BBACFD836E6A61AACF", hash_generated_method = "7CE5B759EE56284BB83AD91C7E51B619")
    
public TypeVariable<Method>[] getTypeParameters() {
        initGenericTypes();
        return formalTypeParameters.clone();
    }

    /** {@inheritDoc} */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.486 -0500", hash_original_method = "1CDF5107AC443AA5F8C2E1DA9DF559A0", hash_generated_method = "5A7AC51370A528B541EFB40EFD81B606")
    
@Override /*package*/ String getSignatureAttribute() {
        Object[] annotation = getSignatureAnnotation(declaringClass, slot);

        if (annotation == null) {
            return null;
        }

        return StringUtils.combineStrings(annotation);
    }

    /**
     * Returns the string representation of the method's declaration, including
     * the type parameters.
     *
     * @return the string representation of this method
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.493 -0500", hash_original_method = "060018D8556E7858267AA04DC5F84FE8", hash_generated_method = "9916908355C4748CA46EEB0C3F3491C9")
    
public String toGenericString() {
        StringBuilder sb = new StringBuilder(80);

        initGenericTypes();

        // append modifiers if any
        int modifier = getModifiers();
        if (modifier != 0) {
            sb.append(Modifier.toString(modifier & ~(Modifier.BRIDGE +
                    Modifier.VARARGS))).append(' ');
        }
        // append type parameters
        if (formalTypeParameters != null && formalTypeParameters.length > 0) {
            sb.append('<');
            for (int i = 0; i < formalTypeParameters.length; i++) {
                appendGenericType(sb, formalTypeParameters[i]);
                if (i < formalTypeParameters.length - 1) {
                    sb.append(",");
                }
            }
            sb.append("> ");
        }
        // append return type
        appendGenericType(sb, Types.getType(genericReturnType));
        sb.append(' ');
        // append method name
        appendArrayType(sb, getDeclaringClass());
        sb.append(".").append(getName());
        // append parameters
        sb.append('(');
        appendArrayGenericType(sb,
                Types.getClonedTypeArray(genericParameterTypes));
        sb.append(')');
        // append exceptions if any
        Type[] genericExceptionTypeArray = Types.getClonedTypeArray(
                genericExceptionTypes);
        if (genericExceptionTypeArray.length > 0) {
            sb.append(" throws ");
            appendArrayGenericType(sb, genericExceptionTypeArray);
        }
        return sb.toString();
    }

    /**
     * Returns the parameter types as an array of {@code Type} instances, in
     * declaration order. If this method has no parameters, an empty array is
     * returned.
     *
     * @return the parameter types
     *
     * @throws GenericSignatureFormatError
     *             if the generic method signature is invalid
     * @throws TypeNotPresentException
     *             if any parameter type points to a missing type
     * @throws MalformedParameterizedTypeException
     *             if any parameter type points to a type that cannot be
     *             instantiated for some reason
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.496 -0500", hash_original_method = "A9CCE739D5419EE3EB1324AC76C431BA", hash_generated_method = "597DE9D598A5006361DA519667FA4A87")
    
public Type[] getGenericParameterTypes() {
        initGenericTypes();
        return Types.getClonedTypeArray(genericParameterTypes);
    }

    /**
     * Returns the exception types as an array of {@code Type} instances. If
     * this method has no declared exceptions, an empty array will be returned.
     *
     * @return an array of generic exception types
     *
     * @throws GenericSignatureFormatError
     *             if the generic method signature is invalid
     * @throws TypeNotPresentException
     *             if any exception type points to a missing type
     * @throws MalformedParameterizedTypeException
     *             if any exception type points to a type that cannot be
     *             instantiated for some reason
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.499 -0500", hash_original_method = "D98F12BC8A74E89DDBE36E53E80FD275", hash_generated_method = "789F7B04AD124F733C6FAD0CF66E18E1")
    
public Type[] getGenericExceptionTypes() {
        initGenericTypes();
        return Types.getClonedTypeArray(genericExceptionTypes);
    }

    /**
     * Returns the return type of this method as a {@code Type} instance.
     *
     * @return the return type of this method
     *
     * @throws GenericSignatureFormatError
     *             if the generic method signature is invalid
     * @throws TypeNotPresentException
     *             if the return type points to a missing type
     * @throws MalformedParameterizedTypeException
     *             if the return type points to a type that cannot be
     *             instantiated for some reason
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.501 -0500", hash_original_method = "83125796E1541F4C47F8F2176AE50053", hash_generated_method = "C08643DE90FFCB58BAFBA77559D06E81")
    
public Type getGenericReturnType() {
        initGenericTypes();
        return Types.getType(genericReturnType);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.504 -0500", hash_original_method = "4122EC91CDDE6FFD9DA08F5ADAF8DB5D", hash_generated_method = "29F60940673BD8877EB2DF97898FD3EA")
    
@Override
    public Annotation[] getDeclaredAnnotations() {
        return getDeclaredAnnotations(declaringClass, slot);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.118 -0400", hash_original_method = "C04F97610183E33B13FB9B4273375B6D", hash_generated_method = "1C787FA354E0C9F896C47EB81A5471B7")
    @Override
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        addTaint(annotationType.getTaint());
        if(annotationType == null)        
        {
            NullPointerException varD3565833EFC12BC5822ABFE94D257EDE_1545342916 = new NullPointerException("annotationType == null");
            varD3565833EFC12BC5822ABFE94D257EDE_1545342916.addTaint(taint);
            throw varD3565833EFC12BC5822ABFE94D257EDE_1545342916;
        } //End block
A varD37D33C5EE02B81A7F8EF45A88B88039_629409244 =         getAnnotation(declaringClass, slot, annotationType);
        varD37D33C5EE02B81A7F8EF45A88B88039_629409244.addTaint(taint);
        return varD37D33C5EE02B81A7F8EF45A88B88039_629409244;
        // ---------- Original Method ----------
        //if (annotationType == null) {
            //throw new NullPointerException("annotationType == null");
        //}
        //return getAnnotation(declaringClass, slot, annotationType);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.517 -0500", hash_original_method = "D8B142EB73E138FF5927E6AE1DAD56D2", hash_generated_method = "426D294074F23AB43B6C5EEBDA3CD9A8")
    
@Override public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        if (annotationType == null) {
            throw new NullPointerException("annotationType == null");
        }
        return isAnnotationPresent(declaringClass, slot, annotationType);
    }

    /**
     * Returns an array of arrays that represent the annotations of the formal
     * parameters of this method. If there are no parameters on this method,
     * then an empty array is returned. If there are no annotations set, then
     * and array of empty arrays is returned.
     *
     * @return an array of arrays of {@code Annotation} instances
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.530 -0500", hash_original_method = "72FC508AEB582DBA9794440813C3A8B1", hash_generated_method = "4F085A2B43CC3DCF944C4B690441A4C1")
    
public Annotation[][] getParameterAnnotations() {
        Annotation[][] parameterAnnotations
                = getParameterAnnotations(declaringClass, slot);
        if (parameterAnnotations.length == 0) {
            return noAnnotations(parameterTypes.length);
        }
        return parameterAnnotations;
    }

    /**
     * Indicates whether or not this method takes a variable number argument.
     *
     * @return {@code true} if a vararg is declared, {@code false} otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.537 -0500", hash_original_method = "47D8C519D80AD7FA8ACDBB9291AF9C1F", hash_generated_method = "98BBA26B4299357852C815497BEBBE80")
    
public boolean isVarArgs() {
        int modifiers = getMethodModifiers(declaringClass, slot);
        return (modifiers & Modifier.VARARGS) != 0;
    }

    /**
     * Indicates whether or not this method is a bridge.
     *
     * @return {@code true} if this method is a bridge, {@code false} otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.539 -0500", hash_original_method = "F604FBBB689DE54F8A9C0A1F2713AB23", hash_generated_method = "8F3E1B44078EF0F4429406371B786882")
    
public boolean isBridge() {
        int modifiers = getMethodModifiers(declaringClass, slot);
        return (modifiers & Modifier.BRIDGE) != 0;
    }

    /**
     * Indicates whether or not this method is synthetic.
     *
     * @return {@code true} if this method is synthetic, {@code false} otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.542 -0500", hash_original_method = "B698BCB06B0A737FF1A228493D2DEAD0", hash_generated_method = "740D269471105F6754C2E8C0B1DE05E7")
    
public boolean isSynthetic() {
        int modifiers = getMethodModifiers(declaringClass, slot);
        return (modifiers & Modifier.SYNTHETIC) != 0;
    }

    /**
     * Returns the default value for the annotation member represented by this
     * method.
     *
     * @return the default value, or {@code null} if none
     *
     * @throws TypeNotPresentException
     *             if this annotation member is of type {@code Class} and no
     *             definition can be found
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.544 -0500", hash_original_method = "3DF570DF2B22E4E433BE61FA4A3252FF", hash_generated_method = "C232B80D92ADA1B117D87BC36DA104DD")
    
public Object getDefaultValue() {
        return getDefaultValue(declaringClass, slot);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.884 -0400", hash_original_method = "01EB45D9363E910A54E557C442527E6E", hash_generated_method = "12453DE2F22689947CA412DBF05F783C")
	private Object getDefaultValue(Class declaringClass, int slot) {
		addTaint(declaringClass.taint);
		addTaint(slot);
		return new Object();
	}

    /**
     * Indicates whether or not the specified {@code object} is equal to this
     * method. To be equal, the specified object must be an instance
     * of {@code Method} with the same declaring class and parameter types
     * as this method.
     *
     * @param object
     *            the object to compare
     *
     * @return {@code true} if the specified object is equal to this
     *         method, {@code false} otherwise
     *
     * @see #hashCode
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.551 -0500", hash_original_method = "AF56E5F5402F800187126545ABE1F97F", hash_generated_method = "2388BFFA3F066B4085F7AD1338EBF7C1")
    
@Override
    public boolean equals(Object object) {
        return object instanceof Method && toString().equals(object.toString());
    }

    /**
     * Returns the class that declares this method.
     *
     * @return the declaring class
     */
    @DSComment("Refelction/class loader")
    @DSBan(DSCat.REFLECTION)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.553 -0500", hash_original_method = "747BEFE9985C4AF4EE3D5630B62185EA", hash_generated_method = "574997FEB7F01E0808800855819F513A")
    
public Class<?> getDeclaringClass() {
        return declaringClass;
    }

    /**
     * Returns the exception types as an array of {@code Class} instances. If
     * this method has no declared exceptions, an empty array is returned.
     *
     * @return the declared exception classes
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.556 -0500", hash_original_method = "0803D161ECCDE8E4916E8597C31C5EAF", hash_generated_method = "1AD8748424F084736A9DD63261A66A14")
    
public Class<?>[] getExceptionTypes() {
        if (exceptionTypes == null) {
            return EmptyArray.CLASS;
        }
        return exceptionTypes.clone();
    }

    /**
     * Returns the modifiers for this method. The {@link Modifier} class should
     * be used to decode the result.
     *
     * @return the modifiers for this method
     *
     * @see Modifier
     */
    @DSComment("Java language reflection")
    @DSBan(DSCat.REFLECTION)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.559 -0500", hash_original_method = "D61CFE217686483C8FB69E9FFDF592A9", hash_generated_method = "48830EE19AB9C2BBC366A2463FB5A641")
    
public int getModifiers() {
        return getMethodModifiers(declaringClass, slot);
    }

    /**
     * Returns the name of the method represented by this {@code Method}
     * instance.
     *
     * @return the name of this method
     */
    @DSComment("Java language reflection")
    @DSBan(DSCat.REFLECTION)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.566 -0500", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "50860709F8CC9FE19B604881E59FBA54")
    
public String getName() {
        return name;
    }

    /**
     * Returns an array of {@code Class} objects associated with the parameter
     * types of this method. If the method was declared with no parameters, an
     * empty array will be returned.
     *
     * @return the parameter types
     */
    @DSComment("Refelction/class loader")
    @DSBan(DSCat.REFLECTION)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.568 -0500", hash_original_method = "860AC8CD4E2F5F390A65618A1941DEDE", hash_generated_method = "0845E4F05C4F8FB178489C01FC4EE8B5")
    
public Class<?>[] getParameterTypes() {
        return parameterTypes.clone();
    }

    /**
     * Returns the {@code Class} associated with the return type of this
     * method.
     *
     * @return the return type
     */
    @DSComment("Refelction/class loader")
    @DSBan(DSCat.REFLECTION)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.571 -0500", hash_original_method = "952CC59854183D9751F85A9597A378CE", hash_generated_method = "F8F970361961EA482B13AE142C333181")
    
public Class<?> getReturnType() {
        return returnType;
    }

    /**
     * Returns an integer hash code for this method. Objects which are equal
     * return the same value for this method. The hash code for this Method is
     * the hash code of the name of this method.
     *
     * @return hash code for this method
     *
     * @see #equals
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.573 -0500", hash_original_method = "EF5D8B81A9E09E0C38DFC15BA422ECA1", hash_generated_method = "79AB96931D4D2744C8AC02B11E3A7517")
    
@Override
    public int hashCode() {
        return name.hashCode();
    }

    /**
     * Returns the result of dynamically invoking this method. Equivalent to
     * {@code receiver.methodName(arg1, arg2, ... , argN)}.
     *
     * <p>If the method is static, the receiver argument is ignored (and may be null).
     *
     * <p>If the method takes no arguments, you can pass {@code (Object[]) null} instead of
     * allocating an empty array.
     *
     * <p>If you're calling a varargs method, you need to pass an {@code Object[]} for the
     * varargs parameter: that conversion is usually done in {@code javac}, not the VM, and
     * the reflection machinery does not do this for you. (It couldn't, because it would be
     * ambiguous.)
     *
     * <p>Reflective method invocation follows the usual process for method lookup.
     *
     * <p>If an exception is thrown during the invocation it is caught and
     * wrapped in an InvocationTargetException. This exception is then thrown.
     *
     * <p>If the invocation completes normally, the return value itself is
     * returned. If the method is declared to return a primitive type, the
     * return value is boxed. If the return type is void, null is returned.
     *
     * @param receiver
     *            the object on which to call this method (or null for static methods)
     * @param args
     *            the arguments to the method
     * @return the result
     *
     * @throws NullPointerException
     *             if {@code receiver == null} for a non-static method
     * @throws IllegalAccessException
     *             if this method is not accessible (see {@link AccessibleObject})
     * @throws IllegalArgumentException
     *             if the number of arguments doesn't match the number of parameters, the receiver
     *             is incompatible with the declaring class, or an argument could not be unboxed
     *             or converted by a widening conversion to the corresponding parameter type
     * @throws InvocationTargetException
     *             if an exception was thrown by the invoked method
     */
    @DSComment("Java language reflection")
    @DSBan(DSCat.REFLECTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.576 -0500", hash_original_method = "4A7D773CBB2CABEB3FBD24437D2F9CE8", hash_generated_method = "2FD521E61FBF204709DD6167E6F69FD0")
    
public Object invoke(Object receiver, Object... args)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (args == null) {
            args = EmptyArray.OBJECT;
        }
        return invokeNative(receiver, args, declaringClass, parameterTypes, returnType, slot, flag);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.898 -0400", hash_original_method = "0E030E32F68EF389669F95D53DF2EFAB", hash_generated_method = "5C866D8DF0795175296282F6D723F5B5")
	private Object invokeNative(Object obj, Object[] args, Class<?> declaringClass, Class<?>[] parameterTypes, Class<?> returnType, int slot, boolean noAccessCheck)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		addTaint(obj.taint);
		addTaint(args[0].taint);
		addTaint(declaringClass.taint);
		addTaint(parameterTypes[0].taint);
		addTaint(returnType.taint);
		addTaint(slot);
		addTaint(noAccessCheck);
		Object ret = new Object();
		return ret;
	}

    /**
     * Returns a string containing a concise, human-readable description of this
     * method. The format of the string is:
     *
     * <ol>
     *   <li>modifiers (if any)
     *   <li>return type or 'void'
     *   <li>declaring class name
     *   <li>'('
     *   <li>parameter types, separated by ',' (if any)
     *   <li>')'
     *   <li>'throws' plus exception types, separated by ',' (if any)
     * </ol>
     *
     * For example: {@code public native Object
     * java.lang.Method.invoke(Object,Object) throws
     * IllegalAccessException,IllegalArgumentException
     * ,InvocationTargetException}
     *
     * @return a printable representation for this method
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.583 -0500", hash_original_method = "20379CC138163D24505D982E1BF3267A", hash_generated_method = "A3209D87A40A94BDDEE3267FFAF5CF50")
    
@Override
    public String toString() {
        StringBuilder result = new StringBuilder(Modifier.toString(getModifiers()));

        if (result.length() != 0)
            result.append(' ');
        result.append(returnType.getName());
        result.append(' ');
        result.append(declaringClass.getName());
        result.append('.');
        result.append(name);
        result.append("(");
        result.append(toString(parameterTypes));
        result.append(")");
        if (exceptionTypes != null && exceptionTypes.length != 0) {
            result.append(" throws ");
            result.append(toString(exceptionTypes));
        }

        return result.toString();
    }

    /**
     * Returns the constructor's signature in non-printable form. This is called
     * (only) from IO native code and needed for deriving the serialVersionUID
     * of the class
     *
     * @return The constructor's signature.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.586 -0500", hash_original_method = "C4F068AB884B2FBA426F9E4B4EB5335D", hash_generated_method = "209508FF00FA7C82E8EAE16DB1379871")
    
@SuppressWarnings("unused")
    private String getSignature() {
        StringBuilder result = new StringBuilder();

        result.append('(');
        for (int i = 0; i < parameterTypes.length; i++) {
            result.append(getSignature(parameterTypes[i]));
        }
        result.append(')');
        result.append(getSignature(returnType));

        return result.toString();
    }
    
    // orphaned legacy method
    public int compare(Method a, Method b) {
		int comparison = a.name.compareTo(b.name);
		if (comparison != 0) {
			return comparison;
		}

		Class<?>[] aParameters = a.parameterTypes;
		Class<?>[] bParameters = b.parameterTypes;
		int length = Math.min(aParameters.length, bParameters.length);
		for (int i = 0; i < length; i++) {
			comparison = aParameters[i].getName().compareTo(bParameters[i].getName());
			if (comparison != 0) {
				return comparison;
			}
		}

		if (aParameters.length != bParameters.length) {
			return aParameters.length - bParameters.length;
		}

		return a.getReturnType().getName().compareTo(b.getReturnType().getName());
	}
    
}

