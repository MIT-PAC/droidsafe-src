package java.lang.reflect;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.annotation.Annotation;
import java.util.Comparator;

import org.apache.harmony.kernel.vm.StringUtils;
import org.apache.harmony.luni.lang.reflect.GenericSignatureParser;
import org.apache.harmony.luni.lang.reflect.Types;

import droidsafe.helpers.DSUtils;

public final class Field extends AccessibleObject implements Member {
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static Annotation[] getDeclaredAnnotations(Class declaringClass, int slot) {
    	Annotation[] ret = new Annotation[0];
    	ret[0].addTaint(declaringClass.taint);
    	ret[0].addTaint(slot);
    	return ret;
    }
    
    private static <A extends Annotation> A getAnnotation(
            Class<?> declaringClass, int slot, Class<A> annotationType) {
    	A ret = (A)new Object();
    	ret.addTaint(declaringClass.taint);
    	ret.addTaint(slot);
    	ret.addTaint(annotationType.taint);
    	return ret;
    }
    
    private static boolean isAnnotationPresent(
            Class<?> declaringClass, int slot, Class<? extends Annotation> annotationType) {
            
            Object obj = new Object();
            obj.addTaint(declaringClass.getTaint());
            obj.addTaint(slot);
            obj.addTaint(annotationType.getTaint());
            return obj.getTaintBoolean();
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.020 -0400", hash_original_field = "53D2DF7F6A0025522B6A62D7BCCD362B", hash_generated_field = "FE1CC35DA4EB56C9880DCB488708D9CB")

    public static final Comparator<Field> ORDER_BY_NAME_AND_DECLARING_CLASS
            = new Comparator<Field>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.209 -0500", hash_original_method = "5733993CE756EF2C84207962A0640F37", hash_generated_method = "58E07DB8D9CA9A37815FB7EB15AD1B47")
        
@Override public int compare(Field a, Field b) {
            int comparison = a.name.compareTo(b.name);
            if (comparison != 0) {
                return comparison;
            }

            return a.getDeclaringClass().getName().compareTo(b.getDeclaringClass().getName());
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.228 -0500", hash_original_field = "219932C0D186751984D7A1480007F050", hash_generated_field = "0B71E07F68242E0883FB03EAE37B4026")

    private static final char TYPE_BOOLEAN = 'Z';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.230 -0500", hash_original_field = "A7EA91CACB6C0C9F16D655BBF0959ECF", hash_generated_field = "A2F4D86DAE2B010C8D5C08013F0683CA")

    private static final char TYPE_BYTE = 'B';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.233 -0500", hash_original_field = "0E07C50E06E50D7993D48617FCA44DF3", hash_generated_field = "AAD9FB3C86B29282B83CDD80DE09CFA0")

    private static final char TYPE_CHAR = 'C';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.236 -0500", hash_original_field = "1A68B6AA1E43E350649DA67C8CB34C6B", hash_generated_field = "EFF96E3ED8672BC1006A65B4ACD711D8")

    private static final char TYPE_SHORT = 'S';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.239 -0500", hash_original_field = "AAABE4244B678BB150AB4CE74E91E0D9", hash_generated_field = "6F52E15DB27ACBF8AF1261D87ACDC04B")

    private static final char TYPE_INTEGER = 'I';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.241 -0500", hash_original_field = "D853A8C8135414E3A4B03729147B3708", hash_generated_field = "7E3646905DF597FA341E03A9809EDF6C")

    private static final char TYPE_FLOAT = 'F';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.243 -0500", hash_original_field = "DB7796E7A575652F4B6DB1960B2A6838", hash_generated_field = "4C7FC2EC3A51877374490391181D6419")

    private static final char TYPE_LONG = 'J';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.246 -0500", hash_original_field = "08DD0261DF27D520D3504AD5642E2C73", hash_generated_field = "1C723C993774EE671598C52201355866")

    private static final char TYPE_DOUBLE = 'D';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.214 -0500", hash_original_field = "241D06F27490B4FC35F16806876AF0D3", hash_generated_field = "EC96049C106D95C970CBF94E8CE21744")

    private Class<?> declaringClass;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.216 -0500", hash_original_field = "9D08EA5E8D4745A2564880C6C6CE140D", hash_generated_field = "73346820208B59684010E2508B329B0F")

    private Class<?> type;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.218 -0500", hash_original_field = "A95822D2306865328E23008716F35B78", hash_generated_field = "DF8CDE4E2FC6AAB2D60A934C2A3F8E04")

    private Type genericType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.221 -0500", hash_original_field = "882601A2CEBECCB3AC8128B79706E015", hash_generated_field = "89FDBAE6DE2AE55271071C78F774F101")

    private volatile boolean genericTypesAreInitialized = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.223 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.225 -0500", hash_original_field = "09F7A5BA4BC6B04AB18035FB41A6CB6C", hash_generated_field = "6B06F56F1EB868ADA8CFFD63973A7E09")

    private int slot;

    /**
     * Construct a clone of the given instance.
     *
     * @param orig non-null; the original instance to clone
     */
    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.248 -0500", hash_original_method = "18020B40E6468EB970BF7E1035466368", hash_generated_method = "9031960A6529FC97E6B8E086CB3ADC55")
    
Field(Field orig) {
        this(orig.declaringClass, orig.type, orig.name, orig.slot);

        // Copy the accessible flag.
        if (orig.flag) {
            this.flag = true;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.251 -0500", hash_original_method = "5600995DFD2A0F6D5A6AA1A0A4EAB766", hash_generated_method = "5A72BEDBD55C04FD903B63ABB16427E2")
    
private Field(Class<?> declaringClass, Class<?> type, String name, int slot) {
        this.declaringClass = declaringClass;
        this.type = type;
        this.name = name;
        this.slot = slot;
    }
    // orphaned legacy method
    
    public Field() {
    	
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.254 -0500", hash_original_method = "5029B4C059F978BE158986B034FE3005", hash_generated_method = "63D5F4635328AC6DD49A3A6379D3C306")
    
private synchronized void initGenericType() {
        if (!genericTypesAreInitialized) {
            String signatureAttribute = getSignatureAttribute();
            GenericSignatureParser parser = new GenericSignatureParser(
                    declaringClass.getClassLoader());
            parser.parseForField(this.declaringClass, signatureAttribute);
            genericType = parser.fieldType;
            if (genericType == null) {
                genericType = getType();
            }
            genericTypesAreInitialized = true;
        }
    }

    /** {@inheritDoc} */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.256 -0500", hash_original_method = "1CDF5107AC443AA5F8C2E1DA9DF559A0", hash_generated_method = "5A7AC51370A528B541EFB40EFD81B606")
    
@Override
    /* package */String getSignatureAttribute() {
        Object[] annotation = getSignatureAnnotation(declaringClass, slot);

        if (annotation == null) {
            return null;
        }

        return StringUtils.combineStrings(annotation);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.759 -0400", hash_original_method = "5161131687230E0D7EE89383FDDF9117", hash_generated_method = "F1BBACEA836E9C65FE0E5D9A22FF7006")
    private Object[] getSignatureAnnotation(Class declaringClass, int slot) {
    	addTaint(declaringClass.taint);
    	addTaint(slot);
    	return new Object[0];
    }

    /**
     * Indicates whether or not this field is synthetic.
     *
     * @return {@code true} if this field is synthetic, {@code false} otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.263 -0500", hash_original_method = "FC3424D2079ACBF27BEC7269ECB48C94", hash_generated_method = "3C1589722F7DF9BF4FE6C3BC09F89D05")
    
public boolean isSynthetic() {
        int flags = getFieldModifiers(declaringClass, slot);
        return (flags & Modifier.SYNTHETIC) != 0;
    }

    /**
     * Returns the string representation of this field, including the field's
     * generic type.
     *
     * @return the string representation of this field
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.265 -0500", hash_original_method = "E96960960A41CE3DD754F7ED4B73683A", hash_generated_method = "3090DEA6078ACAD12CEA90B953DAEDAE")
    
public String toGenericString() {
        StringBuilder sb = new StringBuilder(80);
        // append modifiers if any
        int modifier = getModifiers();
        if (modifier != 0) {
            sb.append(Modifier.toString(modifier)).append(' ');
        }
        // append generic type
        appendGenericType(sb, getGenericType());
        sb.append(' ');
        // append full field name
        sb.append(getDeclaringClass().getName()).append('.').append(getName());
        return sb.toString();
    }

    /**
     * Indicates whether or not this field is an enumeration constant.
     *
     * @return {@code true} if this field is an enumeration constant, {@code
     *         false} otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.268 -0500", hash_original_method = "2827C86400F787FBBD0EA58BB5706D02", hash_generated_method = "2934D7504E02E9D936FDCFD6FF0437F1")
    
public boolean isEnumConstant() {
        int flags = getFieldModifiers(declaringClass, slot);
        return (flags & Modifier.ENUM) != 0;
    }

    /**
     * Returns the generic type of this field.
     *
     * @return the generic type
     * @throws GenericSignatureFormatError
     *             if the generic field signature is invalid
     * @throws TypeNotPresentException
     *             if the generic type points to a missing type
     * @throws MalformedParameterizedTypeException
     *             if the generic type points to a type that cannot be
     *             instantiated for some reason
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.271 -0500", hash_original_method = "963F10B2A4697E7A9ECC1BB94066D74F", hash_generated_method = "FD2CCB94E0B27938FC7C6CEA8DFA5A0E")
    
public Type getGenericType() {
        initGenericType();
        return Types.getType(genericType);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.273 -0500", hash_original_method = "4122EC91CDDE6FFD9DA08F5ADAF8DB5D", hash_generated_method = "29F60940673BD8877EB2DF97898FD3EA")
    
@Override public Annotation[] getDeclaredAnnotations() {
        return getDeclaredAnnotations(declaringClass, slot);
    }
        
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.008 -0400", hash_original_method = "C04F97610183E33B13FB9B4273375B6D", hash_generated_method = "5FA34C6FB9279968DCAA09543A6D1EB0")
    @Override
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        addTaint(annotationType.getTaint());
        if(annotationType == null)        
        {
            NullPointerException varD3565833EFC12BC5822ABFE94D257EDE_286909647 = new NullPointerException("annotationType == null");
            varD3565833EFC12BC5822ABFE94D257EDE_286909647.addTaint(taint);
            throw varD3565833EFC12BC5822ABFE94D257EDE_286909647;
        } //End block
A varD37D33C5EE02B81A7F8EF45A88B88039_1884546761 =         getAnnotation(declaringClass, slot, annotationType);
        varD37D33C5EE02B81A7F8EF45A88B88039_1884546761.addTaint(taint);
        return varD37D33C5EE02B81A7F8EF45A88B88039_1884546761;
        // ---------- Original Method ----------
        //if (annotationType == null) {
            //throw new NullPointerException("annotationType == null");
        //}
        //return getAnnotation(declaringClass, slot, annotationType);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.286 -0500", hash_original_method = "D8B142EB73E138FF5927E6AE1DAD56D2", hash_generated_method = "426D294074F23AB43B6C5EEBDA3CD9A8")
    
@Override public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        if (annotationType == null) {
            throw new NullPointerException("annotationType == null");
        }
        return isAnnotationPresent(declaringClass, slot, annotationType);
    }

    /**
     * Indicates whether or not the specified {@code object} is equal to this
     * field. To be equal, the specified object must be an instance of
     * {@code Field} with the same declaring class, type and name as this field.
     *
     * @param object
     *            the object to compare
     * @return {@code true} if the specified object is equal to this method,
     *         {@code false} otherwise
     * @see #hashCode
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.292 -0500", hash_original_method = "955F27DFEC9F7B5FBB7D8BD5BE41A050", hash_generated_method = "2D6DDF2DE351D77D80BAFBA105D2D762")
    
@Override
    public boolean equals(Object object) {
        return object instanceof Field && toString().equals(object.toString());
    }

    /**
     * Returns the value of the field in the specified object. This reproduces
     * the effect of {@code object.fieldName}
     *
     * <p>If the type of this field is a primitive type, the field value is
     * automatically boxed.
     *
     * <p>If this field is static, the object argument is ignored.
     * Otherwise, if the object is null, a NullPointerException is thrown. If
     * the object is not an instance of the declaring class of the method, an
     * IllegalArgumentException is thrown.
     *
     * <p>If this Field object is enforcing access control (see AccessibleObject)
     * and this field is not accessible from the current context, an
     * IllegalAccessException is thrown.
     *
     * @param object
     *            the object to access
     * @return the field value, possibly boxed
     * @throws NullPointerException
     *             if the object is {@code null} and the field is non-static
     * @throws IllegalArgumentException
     *             if the object is not compatible with the declaring class
     * @throws IllegalAccessException
     *             if this field is not accessible
     */
    @DSComment("Java language reflection")
    @DSBan(DSCat.REFLECTION)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.294 -0500", hash_original_method = "7AE3BC00249CC99885BB0445C93FB18A", hash_generated_method = "81AB090C4B0E06E8EAE64B54F604EA2C")
    
public Object get(Object object) throws IllegalAccessException, IllegalArgumentException {
        return getField(object, declaringClass, type, slot, flag);
    }

    /**
     * Returns the value of the field in the specified object as a {@code
     * boolean}. This reproduces the effect of {@code object.fieldName}
     * <p>
     * If this field is static, the object argument is ignored.
     * Otherwise, if the object is {@code null}, a NullPointerException is
     * thrown. If the object is not an instance of the declaring class of the
     * method, an IllegalArgumentException is thrown.
     * <p>
     * If this Field object is enforcing access control (see AccessibleObject)
     * and this field is not accessible from the current context, an
     * IllegalAccessException is thrown.
     *
     * @param object
     *            the object to access
     * @return the field value
     * @throws NullPointerException
     *             if the object is {@code null} and the field is non-static
     * @throws IllegalArgumentException
     *             if the object is not compatible with the declaring class
     * @throws IllegalAccessException
     *             if this field is not accessible
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.297 -0500", hash_original_method = "27492232D5FCC61236B83BF948F6F104", hash_generated_method = "2EB630EB808CEE18ED2189A070FCC695")
    
public boolean getBoolean(Object object) throws IllegalAccessException,
            IllegalArgumentException {
        return getZField(object, declaringClass, type, slot, flag, TYPE_BOOLEAN);
    }

    /**
     * Returns the value of the field in the specified object as a {@code byte}.
     * This reproduces the effect of {@code object.fieldName}
     * <p>
     * If this field is static, the object argument is ignored.
     * Otherwise, if the object is {@code null}, a NullPointerException is
     * thrown. If the object is not an instance of the declaring class of the
     * method, an IllegalArgumentException is thrown.
     * <p>
     * If this Field object is enforcing access control (see AccessibleObject)
     * and this field is not accessible from the current context, an
     * IllegalAccessException is thrown.
     *
     * @param object
     *            the object to access
     * @return the field value
     * @throws NullPointerException
     *             if the object is {@code null} and the field is non-static
     * @throws IllegalArgumentException
     *             if the object is not compatible with the declaring class
     * @throws IllegalAccessException
     *             if this field is not accessible
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.299 -0500", hash_original_method = "638C7C4918F4FDF5130555C74F583890", hash_generated_method = "F08EE7D873CB6C30199B36D5A03129A0")
    
public byte getByte(Object object) throws IllegalAccessException, IllegalArgumentException {
        return getBField(object, declaringClass, type, slot, flag, TYPE_BYTE);
    }

    /**
     * Returns the value of the field in the specified object as a {@code char}.
     * This reproduces the effect of {@code object.fieldName}
     * <p>
     * If this field is static, the object argument is ignored.
     * Otherwise, if the object is {@code null}, a NullPointerException is
     * thrown. If the object is not an instance of the declaring class of the
     * method, an IllegalArgumentException is thrown.
     * <p>
     * If this Field object is enforcing access control (see AccessibleObject)
     * and this field is not accessible from the current context, an
     * IllegalAccessException is thrown.
     *
     * @param object
     *            the object to access
     * @return the field value
     * @throws NullPointerException
     *             if the object is {@code null} and the field is non-static
     * @throws IllegalArgumentException
     *             if the object is not compatible with the declaring class
     * @throws IllegalAccessException
     *             if this field is not accessible
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.302 -0500", hash_original_method = "6648A25494EBFE26376F66DF9331BADB", hash_generated_method = "F2005E402570EBEB89A8181B3E933C42")
    
public char getChar(Object object) throws IllegalAccessException, IllegalArgumentException {
        return getCField(object, declaringClass, type, slot, flag, TYPE_CHAR);
    }

    /**
     * Returns the class that declares this field.
     *
     * @return the declaring class
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.305 -0500", hash_original_method = "747BEFE9985C4AF4EE3D5630B62185EA", hash_generated_method = "574997FEB7F01E0808800855819F513A")
    
public Class<?> getDeclaringClass() {
        return declaringClass;
    }

    /**
     * Returns the value of the field in the specified object as a {@code
     * double}. This reproduces the effect of {@code object.fieldName}
     * <p>
     * If this field is static, the object argument is ignored.
     * Otherwise, if the object is {@code null}, a NullPointerException is
     * thrown. If the object is not an instance of the declaring class of the
     * method, an IllegalArgumentException is thrown.
     * <p>
     * If this Field object is enforcing access control (see AccessibleObject)
     * and this field is not accessible from the current context, an
     * IllegalAccessException is thrown.
     *
     * @param object
     *            the object to access
     * @return the field value
     * @throws NullPointerException
     *             if the object is {@code null} and the field is non-static
     * @throws IllegalArgumentException
     *             if the object is not compatible with the declaring class
     * @throws IllegalAccessException
     *             if this field is not accessible
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.307 -0500", hash_original_method = "B22A8667913C0820CACD3D8F78E3B803", hash_generated_method = "C81603E2D1BE2E53E3059A1EFD5E186F")
    
public double getDouble(Object object) throws IllegalAccessException, IllegalArgumentException {
        return getDField(object, declaringClass, type, slot, flag, TYPE_DOUBLE);
    }

    /**
     * Returns the value of the field in the specified object as a {@code float}
     * . This reproduces the effect of {@code object.fieldName}
     * <p>
     * If this field is static, the object argument is ignored.
     * Otherwise, if the object is {@code null}, a NullPointerException is
     * thrown. If the object is not an instance of the declaring class of the
     * method, an IllegalArgumentException is thrown.
     * <p>
     * If this Field object is enforcing access control (see AccessibleObject)
     * and this field is not accessible from the current context, an
     * IllegalAccessException is thrown.
     *
     * @param object
     *            the object to access
     * @return the field value
     * @throws NullPointerException
     *             if the object is {@code null} and the field is non-static
     * @throws IllegalArgumentException
     *             if the object is not compatible with the declaring class
     * @throws IllegalAccessException
     *             if this field is not accessible
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.310 -0500", hash_original_method = "BFF553DA1989441891013747E355F341", hash_generated_method = "F8F480A05C16CA6CB51B124F3B714944")
    
public float getFloat(Object object) throws IllegalAccessException, IllegalArgumentException {
        return getFField(object, declaringClass, type, slot, flag, TYPE_FLOAT);
    }

    /**
     * Returns the value of the field in the specified object as an {@code int}.
     * This reproduces the effect of {@code object.fieldName}
     * <p>
     * If this field is static, the object argument is ignored.
     * Otherwise, if the object is {@code null}, a NullPointerException is
     * thrown. If the object is not an instance of the declaring class of the
     * method, an IllegalArgumentException is thrown.
     * <p>
     * If this Field object is enforcing access control (see AccessibleObject)
     * and this field is not accessible from the current context, an
     * IllegalAccessException is thrown.
     *
     * @param object
     *            the object to access
     * @return the field value
     * @throws NullPointerException
     *             if the object is {@code null} and the field is non-static
     * @throws IllegalArgumentException
     *             if the object is not compatible with the declaring class
     * @throws IllegalAccessException
     *             if this field is not accessible
     */
    @DSComment("Java language reflection")
    @DSBan(DSCat.REFLECTION)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.312 -0500", hash_original_method = "5CB83BC53ADA020FA0FD37C15AAD9E62", hash_generated_method = "9D7296B3392D54E0B4B59D734A1FEECF")
    
public int getInt(Object object) throws IllegalAccessException, IllegalArgumentException {
        return getIField(object, declaringClass, type, slot, flag, TYPE_INTEGER);
    }

    /**
     * Returns the value of the field in the specified object as a {@code long}.
     * This reproduces the effect of {@code object.fieldName}
     * <p>
     * If this field is static, the object argument is ignored.
     * Otherwise, if the object is {@code null}, a NullPointerException is
     * thrown. If the object is not an instance of the declaring class of the
     * method, an IllegalArgumentException is thrown.
     * <p>
     * If this Field object is enforcing access control (see AccessibleObject)
     * and this field is not accessible from the current context, an
     * IllegalAccessException is thrown.
     *
     * @param object
     *            the object to access
     * @return the field value
     * @throws NullPointerException
     *             if the object is {@code null} and the field is non-static
     * @throws IllegalArgumentException
     *             if the object is not compatible with the declaring class
     * @throws IllegalAccessException
     *             if this field is not accessible
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.314 -0500", hash_original_method = "005A2557A921AA55BF8BDBCBDC639BE4", hash_generated_method = "7AFCB38C335290318905087FBA964B3A")
    
public long getLong(Object object) throws IllegalAccessException, IllegalArgumentException {
        return getJField(object, declaringClass, type, slot, flag, TYPE_LONG);
    }

    /**
     * Returns the modifiers for this field. The {@link Modifier} class should
     * be used to decode the result.
     *
     * @return the modifiers for this field
     * @see Modifier
     */
    @DSComment("Java language reflection")
    @DSBan(DSCat.REFLECTION)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.317 -0500", hash_original_method = "5A676A538E8952F6729F0D8423178A33", hash_generated_method = "1327A747177D4EE276A0F6E14A311D56")
    
public int getModifiers() {
        return getFieldModifiers(declaringClass, slot);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.320 -0500", hash_original_method = "9D513D500FBFD57DB21A924D9A85826A", hash_generated_method = "D9F237B55D499490E2BC78D721103B22")
    
    private int getFieldModifiers(Class<?> declaringClass, int slot){
    	//Formerly a native method
    	addTaint(declaringClass.getTaint());
    	addTaint(slot);
    	return getTaintInt();
    }

    /**
     * Returns the name of this field.
     *
     * @return the name of this field
     */
    @DSComment("Java language reflection")
    @DSBan(DSCat.REFLECTION)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.322 -0500", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "50860709F8CC9FE19B604881E59FBA54")
    
public String getName() {
        return name;
    }

    /**
     * Returns the value of the field in the specified object as a {@code short}
     * . This reproduces the effect of {@code object.fieldName}
     * <p>
     * If this field is static, the object argument is ignored.
     * Otherwise, if the object is {@code null}, a NullPointerException is
     * thrown. If the object is not an instance of the declaring class of the
     * method, an IllegalArgumentException is thrown.
     * <p>
     * If this Field object is enforcing access control (see AccessibleObject)
     * and this field is not accessible from the current context, an
     * IllegalAccessException is thrown.
     *
     * @param object
     *            the object to access
     * @return the field value
     * @throws NullPointerException
     *             if the object is {@code null} and the field is non-static
     * @throws IllegalArgumentException
     *             if the object is not compatible with the declaring class
     * @throws IllegalAccessException
     *             if this field is not accessible
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.325 -0500", hash_original_method = "0DDA5605A2464ED398902817D939E3F2", hash_generated_method = "C1F8C1DFD6141C567C3BF4B10E660C5B")
    
public short getShort(Object object) throws IllegalAccessException, IllegalArgumentException {
        return getSField(object, declaringClass, type, slot, flag, TYPE_SHORT);
    }

    /**
     * Returns the constructor's signature in non-printable form. This is called
     * (only) from IO native code and needed for deriving the serialVersionUID
     * of the class
     *
     * @return the constructor's signature.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.328 -0500", hash_original_method = "994767CE6492BCD5B50ECB089389E539", hash_generated_method = "05C67715888196CD12438B44D6E73AE7")
    
@SuppressWarnings("unused")
    private String getSignature() {
        return getSignature(type);
    }

    /**
     * Return the {@link Class} associated with the type of this field.
     *
     * @return the type of this field
     */
    @DSComment("Refelction/class loader")
    @DSBan(DSCat.REFLECTION)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.330 -0500", hash_original_method = "21C93A7CC51FD6114C8D944747F943F4", hash_generated_method = "0EEEE4F02A27E714D03E663A59C6B204")
    
public Class<?> getType() {
        return type;
    }

    /**
     * Returns an integer hash code for this field. Objects which are equal
     * return the same value for this method.
     * <p>
     * The hash code for a Field is the exclusive-or combination of the hash
     * code of the field's name and the hash code of the name of its declaring
     * class.
     *
     * @return the hash code for this field
     * @see #equals
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.332 -0500", hash_original_method = "7C0B16AD34D2790FBD73D96D003DD91D", hash_generated_method = "40DF09C1461284A20372BDE4CE08D655")
    
@Override
    public int hashCode() {
        return name.hashCode() ^ getDeclaringClass().getName().hashCode();
    }

    /**
     * Sets the value of the field in the specified object to the value. This
     * reproduces the effect of {@code object.fieldName = value}
     *
     * <p>If this field is static, the object argument is ignored.
     * Otherwise, if the object is {@code null}, a NullPointerException is
     * thrown. If the object is not an instance of the declaring class of the
     * method, an IllegalArgumentException is thrown.
     *
     * <p>If this Field object is enforcing access control (see AccessibleObject)
     * and this field is not accessible from the current context, an
     * IllegalAccessException is thrown.
     *
     * <p>If the field type is a primitive type, the value is automatically
     * unboxed. If the unboxing fails, an IllegalArgumentException is thrown. If
     * the value cannot be converted to the field type via a widening
     * conversion, an IllegalArgumentException is thrown.
     *
     * @param object
     *            the object to access
     * @param value
     *            the new value
     * @throws NullPointerException
     *             if the object is {@code null} and the field is non-static
     * @throws IllegalArgumentException
     *             if the object is not compatible with the declaring class
     * @throws IllegalAccessException
     *             if this field is not accessible
     */
    @DSComment("Java language reflection")
    @DSBan(DSCat.REFLECTION)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.335 -0500", hash_original_method = "6D24AA0F6B01F01D922DBBA93FD91F81", hash_generated_method = "30D8F62F862AD3637A8B07C21E9E5524")
    
public void set(Object object, Object value) throws IllegalAccessException,
            IllegalArgumentException {
        setField(object, declaringClass, type, slot, flag, value);
    }

    /**
     * Sets the value of the field in the specified object to the {@code
     * boolean} value. This reproduces the effect of {@code object.fieldName =
     * value}
     * <p>
     * If this field is static, the object argument is ignored.
     * Otherwise, if the object is {@code null}, a NullPointerException is
     * thrown. If the object is not an instance of the declaring class of the
     * method, an IllegalArgumentException is thrown.
     * <p>
     * If this Field object is enforcing access control (see AccessibleObject)
     * and this field is not accessible from the current context, an
     * IllegalAccessException is thrown.
     * <p>
     * If the value cannot be converted to the field type via a widening
     * conversion, an IllegalArgumentException is thrown.
     *
     * @param object
     *            the object to access
     * @param value
     *            the new value
     * @throws NullPointerException
     *             if the object is {@code null} and the field is non-static
     * @throws IllegalArgumentException
     *             if the object is not compatible with the declaring class
     * @throws IllegalAccessException
     *             if this field is not accessible
     */
    @DSComment("Java language reflection")
    @DSBan(DSCat.REFLECTION)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.337 -0500", hash_original_method = "25FFB4639E444F2A9FD12AF0E909B7A5", hash_generated_method = "50D46A62976E2A32D29DFB63C6D79FD9")
    
public void setBoolean(Object object, boolean value) throws IllegalAccessException,
            IllegalArgumentException {
        setZField(object, declaringClass, type, slot, flag, TYPE_BOOLEAN, value);
    }

    /**
     * Sets the value of the field in the specified object to the {@code byte}
     * value. This reproduces the effect of {@code object.fieldName = value}
     * <p>
     * If this field is static, the object argument is ignored.
     * Otherwise, if the object is {@code null}, a NullPointerException is
     * thrown. If the object is not an instance of the declaring class of the
     * method, an IllegalArgumentException is thrown.
     * <p>
     * If this Field object is enforcing access control (see AccessibleObject)
     * and this field is not accessible from the current context, an
     * IllegalAccessException is thrown.
     * <p>
     * If the value cannot be converted to the field type via a widening
     * conversion, an IllegalArgumentException is thrown.
     *
     * @param object
     *            the object to access
     * @param value
     *            the new value
     * @throws NullPointerException
     *             if the object is {@code null} and the field is non-static
     * @throws IllegalArgumentException
     *             if the object is not compatible with the declaring class
     * @throws IllegalAccessException
     *             if this field is not accessible
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.340 -0500", hash_original_method = "AD912B9A4F5D11756FF2F9AE3FC4D6E6", hash_generated_method = "93A31D3D90D062DC6036124FE7AB93E4")
    
public void setByte(Object object, byte value) throws IllegalAccessException,
            IllegalArgumentException {
        setBField(object, declaringClass, type, slot, flag, TYPE_BYTE, value);
    }

    /**
     * Sets the value of the field in the specified object to the {@code char}
     * value. This reproduces the effect of {@code object.fieldName = value}
     * <p>
     * If this field is static, the object argument is ignored.
     * Otherwise, if the object is {@code null}, a NullPointerException is
     * thrown. If the object is not an instance of the declaring class of the
     * method, an IllegalArgumentException is thrown.
     * <p>
     * If this Field object is enforcing access control (see AccessibleObject)
     * and this field is not accessible from the current context, an
     * IllegalAccessException is thrown.
     * <p>
     * If the value cannot be converted to the field type via a widening
     * conversion, an IllegalArgumentException is thrown.
     *
     * @param object
     *            the object to access
     * @param value
     *            the new value
     * @throws NullPointerException
     *             if the object is {@code null} and the field is non-static
     * @throws IllegalArgumentException
     *             if the object is not compatible with the declaring class
     * @throws IllegalAccessException
     *             if this field is not accessible
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.342 -0500", hash_original_method = "97D79EA86FEBB11A4E8B5CD3EFF3DEF5", hash_generated_method = "27D7E83AF7256E0E15F6688E1952724B")
    
public void setChar(Object object, char value) throws IllegalAccessException,
            IllegalArgumentException {
        setCField(object, declaringClass, type, slot, flag, TYPE_CHAR, value);
    }

    /**
     * Sets the value of the field in the specified object to the {@code double}
     * value. This reproduces the effect of {@code object.fieldName = value}
     * <p>
     * If this field is static, the object argument is ignored.
     * Otherwise, if the object is {@code null}, a NullPointerException is
     * thrown. If the object is not an instance of the declaring class of the
     * method, an IllegalArgumentException is thrown.
     * <p>
     * If this Field object is enforcing access control (see AccessibleObject)
     * and this field is not accessible from the current context, an
     * IllegalAccessException is thrown.
     * <p>
     * If the value cannot be converted to the field type via a widening
     * conversion, an IllegalArgumentException is thrown.
     *
     * @param object
     *            the object to access
     * @param value
     *            the new value
     * @throws NullPointerException
     *             if the object is {@code null} and the field is non-static
     * @throws IllegalArgumentException
     *             if the object is not compatible with the declaring class
     * @throws IllegalAccessException
     *             if this field is not accessible
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.344 -0500", hash_original_method = "5E12E36ACBA66ADB7DF4FF63170F60C3", hash_generated_method = "C021E230FDFB0E83C2A3E76BB8D4B05D")
    
public void setDouble(Object object, double value) throws IllegalAccessException,
            IllegalArgumentException {
        setDField(object, declaringClass, type, slot, flag, TYPE_DOUBLE, value);
    }

    /**
     * Sets the value of the field in the specified object to the {@code float}
     * value. This reproduces the effect of {@code object.fieldName = value}
     * <p>
     * If this field is static, the object argument is ignored.
     * Otherwise, if the object is {@code null}, a NullPointerException is
     * thrown. If the object is not an instance of the declaring class of the
     * method, an IllegalArgumentException is thrown.
     * <p>
     * If this Field object is enforcing access control (see AccessibleObject)
     * and this field is not accessible from the current context, an
     * IllegalAccessException is thrown.
     * <p>
     * If the value cannot be converted to the field type via a widening
     * conversion, an IllegalArgumentException is thrown.
     *
     * @param object
     *            the object to access
     * @param value
     *            the new value
     * @throws NullPointerException
     *             if the object is {@code null} and the field is non-static
     * @throws IllegalArgumentException
     *             if the object is not compatible with the declaring class
     * @throws IllegalAccessException
     *             if this field is not accessible
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.347 -0500", hash_original_method = "4860783C5B567E2FC646E7FC5AE81E3C", hash_generated_method = "447B5BAB277B3C4B348F36DA3728A9A7")
    
public void setFloat(Object object, float value) throws IllegalAccessException,
            IllegalArgumentException {
        setFField(object, declaringClass, type, slot, flag, TYPE_FLOAT, value);
    }

    /**
     * Set the value of the field in the specified object to the {@code int}
     * value. This reproduces the effect of {@code object.fieldName = value}
     * <p>
     * If this field is static, the object argument is ignored.
     * Otherwise, if the object is {@code null}, a NullPointerException is
     * thrown. If the object is not an instance of the declaring class of the
     * method, an IllegalArgumentException is thrown.
     * <p>
     * If this Field object is enforcing access control (see AccessibleObject)
     * and this field is not accessible from the current context, an
     * IllegalAccessException is thrown.
     * <p>
     * If the value cannot be converted to the field type via a widening
     * conversion, an IllegalArgumentException is thrown.
     *
     * @param object
     *            the object to access
     * @param value
     *            the new value
     * @throws NullPointerException
     *             if the object is {@code null} and the field is non-static
     * @throws IllegalArgumentException
     *             if the object is not compatible with the declaring class
     * @throws IllegalAccessException
     *             if this field is not accessible
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.350 -0500", hash_original_method = "DA13B1330D08A636280F51E51FF711B2", hash_generated_method = "6392FEF2EBBE8D70E43184E3B192A066")
    
public void setInt(Object object, int value) throws IllegalAccessException,
            IllegalArgumentException {
        setIField(object, declaringClass, type, slot, flag, TYPE_INTEGER, value);
    }

    /**
     * Sets the value of the field in the specified object to the {@code long}
     * value. This reproduces the effect of {@code object.fieldName = value}
     * <p>
     * If this field is static, the object argument is ignored.
     * Otherwise, if the object is {@code null}, a NullPointerException is
     * thrown. If the object is not an instance of the declaring class of the
     * method, an IllegalArgumentException is thrown.
     * <p>
     * If this Field object is enforcing access control (see AccessibleObject)
     * and this field is not accessible from the current context, an
     * IllegalAccessException is thrown.
     * <p>
     * If the value cannot be converted to the field type via a widening
     * conversion, an IllegalArgumentException is thrown.
     *
     * @param object
     *            the object to access
     * @param value
     *            the new value
     * @throws NullPointerException
     *             if the object is {@code null} and the field is non-static
     * @throws IllegalArgumentException
     *             if the object is not compatible with the declaring class
     * @throws IllegalAccessException
     *             if this field is not accessible
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.353 -0500", hash_original_method = "F703AA23CA1EF460C68B245887B2C6B7", hash_generated_method = "0439D90727AC1452C935573F5082E145")
    
public void setLong(Object object, long value) throws IllegalAccessException,
            IllegalArgumentException {
        setJField(object, declaringClass, type, slot, flag, TYPE_LONG, value);
    }

    /**
     * Sets the value of the field in the specified object to the {@code short}
     * value. This reproduces the effect of {@code object.fieldName = value}
     * <p>
     * If this field is static, the object argument is ignored.
     * Otherwise, if the object is {@code null}, a NullPointerException is
     * thrown. If the object is not an instance of the declaring class of the
     * method, an IllegalArgumentException is thrown.
     * <p>
     * If this Field object is enforcing access control (see AccessibleObject)
     * and this field is not accessible from the current context, an
     * IllegalAccessException is thrown.
     * <p>
     * If the value cannot be converted to the field type via a widening
     * conversion, an IllegalArgumentException is thrown.
     *
     * @param object
     *            the object to access
     * @param value
     *            the new value
     * @throws NullPointerException
     *             if the object is {@code null} and the field is non-static
     * @throws IllegalArgumentException
     *             if the object is not compatible with the declaring class
     * @throws IllegalAccessException
     *             if this field is not accessible
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.355 -0500", hash_original_method = "DEE843BD220F8992FC80A23844FC7C06", hash_generated_method = "E2D3FCC56BE5130B880BE3CC56366F7D")
    
public void setShort(Object object, short value) throws IllegalAccessException,
            IllegalArgumentException {
        setSField(object, declaringClass, type, slot, flag, TYPE_SHORT, value);
    }

    /**
     * Returns a string containing a concise, human-readable description of this
     * field.
     * <p>
     * The format of the string is:
     * <ol>
     *   <li>modifiers (if any)
     *   <li>type
     *   <li>declaring class name
     *   <li>'.'
     *   <li>field name
     * </ol>
     * <p>
     * For example: {@code public static java.io.InputStream
     * java.lang.System.in}
     *
     * @return a printable representation for this field
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.359 -0500", hash_original_method = "2B14553F8A926216EE23C791DBC737FD", hash_generated_method = "644A9AA29183D30BF49FDC488F794AC7")
    
@Override
    public String toString() {
        StringBuilder result = new StringBuilder(Modifier.toString(getModifiers()));
        if (result.length() != 0) {
            result.append(' ');
        }
        appendArrayType(result, type);
        result.append(' ');
        result.append(declaringClass.getName());
        result.append('.');
        result.append(name);
        return result.toString();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.775 -0400", hash_original_method = "2E771D0497C584665EAFE5039BCB9B58", hash_generated_method = "5DD6344BFC9E3A8D7857167F9BE20F54")
    private Object getField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck) throws IllegalAccessException {
    	addTaint(o.taint);
    	addTaint(declaringClass.taint);
    	addTaint(type.taint);
    	addTaint(slot);
    	addTaint(noAccessCheck);
    	return new Object();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.367 -0500", hash_original_method = "E4CBB65FF20F2B42AAAA5852C9FC84C9", hash_generated_method = "7D4CC84E642A9B8F84899FF8124D047E")
    
    private double getDField(Object o, Class<?> declaringClass, Class<?> type, int slot,
                boolean noAccessCheck, char descriptor) throws IllegalAccessException{
    	//Formerly a native method
    	addTaint(o.getTaint());
    	addTaint(declaringClass.getTaint());
    	addTaint(type.getTaint());
    	addTaint(slot);
    	addTaint(noAccessCheck);
    	addTaint(descriptor);
    	return getTaintDouble();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.372 -0500", hash_original_method = "9B86AA05444EF83A8159E0D0E3B46582", hash_generated_method = "B74E641A880F7F4CAFE36D8F59671659")
    
    private int getIField(Object o, Class<?> declaringClass, Class<?> type, int slot,
                boolean noAccessCheck, char descriptor) throws IllegalAccessException{
    	//Formerly a native method
    	addTaint(o.getTaint());
    	addTaint(declaringClass.getTaint());
    	addTaint(type.getTaint());
    	addTaint(slot);
    	addTaint(noAccessCheck);
    	addTaint(descriptor);
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.377 -0500", hash_original_method = "1F116F930DBB16C5DB58ABA31954B7AA", hash_generated_method = "B9D4C0CDCB4ACFE048039233711F1945")
    
    private long getJField(Object o, Class<?> declaringClass, Class<?> type, int slot,
                boolean noAccessCheck, char descriptor) throws IllegalAccessException{
    	//Formerly a native method
    	addTaint(o.getTaint());
    	addTaint(declaringClass.getTaint());
    	addTaint(type.getTaint());
    	addTaint(slot);
    	addTaint(noAccessCheck);
    	addTaint(descriptor);
    	return getTaintLong();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.381 -0500", hash_original_method = "50BE3A9E4BA3ACB6450AF3382B17C97D", hash_generated_method = "EB1F217629CB5D6767561D345CEB3865")
    
    private boolean getZField(Object o, Class<?> declaringClass, Class<?> type, int slot,
                boolean noAccessCheck, char descriptor) throws IllegalAccessException{
    	//Formerly a native method
    	addTaint(o.getTaint());
    	addTaint(declaringClass.getTaint());
    	addTaint(type.getTaint());
    	addTaint(slot);
    	addTaint(noAccessCheck);
    	addTaint(descriptor);
    	return getTaintBoolean();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.385 -0500", hash_original_method = "94E059571B5D65D86B6231E7D36BF7FA", hash_generated_method = "F0E33CCE67BFFA19486031BD31B1AE93")
    
    private float getFField(Object o, Class<?> declaringClass, Class<?> type, int slot,
                boolean noAccessCheck, char descriptor) throws IllegalAccessException{
    	//Formerly a native method
    	addTaint(o.getTaint());
    	addTaint(declaringClass.getTaint());
    	addTaint(type.getTaint());
    	addTaint(slot);
    	addTaint(noAccessCheck);
    	addTaint(descriptor);
    	return getTaintFloat();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.388 -0500", hash_original_method = "9A55E198BD753BB34F159FBC2807D96E", hash_generated_method = "B63920F09E6904E02975DC224E825622")
    
    private char getCField(Object o, Class<?> declaringClass, Class<?> type, int slot,
                boolean noAccessCheck, char descriptor) throws IllegalAccessException{
    	//Formerly a native method
    	addTaint(o.getTaint());
    	addTaint(declaringClass.getTaint());
    	addTaint(type.getTaint());
    	addTaint(slot);
    	addTaint(noAccessCheck);
    	addTaint(descriptor);
    	return getTaintChar();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.392 -0500", hash_original_method = "9FE268B454DA8902066BFF2BFC132935", hash_generated_method = "6CB0B6B331AB7F25005F8859B3BC7690")
    
    private short getSField(Object o, Class<?> declaringClass, Class<?> type, int slot,
                boolean noAccessCheck, char descriptor) throws IllegalAccessException{
    	//Formerly a native method
    	addTaint(o.getTaint());
    	addTaint(declaringClass.getTaint());
    	addTaint(type.getTaint());
    	addTaint(slot);
    	addTaint(noAccessCheck);
    	addTaint(descriptor);
    	return getTaintShort();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.396 -0500", hash_original_method = "B020FC56F3182544B11E7C259C9C5B21", hash_generated_method = "F56E2CFA9BC73845B8AEDDD5EA6CCF55")
    
    private byte getBField(Object o, Class<?> declaringClass, Class<?> type, int slot,
                boolean noAccessCheck, char descriptor) throws IllegalAccessException{
    	//Formerly a native method
    	addTaint(o.getTaint());
    	addTaint(declaringClass.getTaint());
    	addTaint(type.getTaint());
    	addTaint(slot);
    	addTaint(noAccessCheck);
    	addTaint(descriptor);
    	return getTaintByte();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.400 -0500", hash_original_method = "D9AA799947323C8F653B1139DF380855", hash_generated_method = "9A3E5817AA51FCFBF3800D6C87BEEE00")
    
    private void setField(Object o, Class<?> declaringClass, Class<?> type, int slot,
                boolean noAccessCheck, Object value) throws IllegalAccessException{
    	//Formerly a native method
    	addTaint(o.getTaint());
    	addTaint(declaringClass.getTaint());
    	addTaint(type.getTaint());
    	addTaint(slot);
    	addTaint(noAccessCheck);
    	addTaint(value.getTaint());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.404 -0500", hash_original_method = "3CCE00B68111CAA3AA20979F21B904D8", hash_generated_method = "B25ABDFEDB35FEF76162472530BB71EE")
    
    private void setDField(Object o, Class<?> declaringClass, Class<?> type, int slot,
                boolean noAccessCheck, char descriptor, double v) throws IllegalAccessException{
    	//Formerly a native method
    	addTaint(o.getTaint());
    	addTaint(declaringClass.getTaint());
    	addTaint(type.getTaint());
    	addTaint(slot);
    	addTaint(noAccessCheck);
    	addTaint(descriptor);
    	addTaint(v);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.408 -0500", hash_original_method = "32CBAB454E52D8BFC71D6AB87E7BF1FE", hash_generated_method = "E0961D002F94AFBEC9175A9BE22B40BA")
    
    private void setIField(Object o, Class<?> declaringClass, Class<?> type, int slot,
                boolean noAccessCheck, char descriptor, int i) throws IllegalAccessException{
    	//Formerly a native method
    	addTaint(o.getTaint());
    	addTaint(declaringClass.getTaint());
    	addTaint(type.getTaint());
    	addTaint(slot);
    	addTaint(noAccessCheck);
    	addTaint(descriptor);
    	addTaint(i);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.412 -0500", hash_original_method = "7CE46D8AB646DF2CA9A88ACDCE998029", hash_generated_method = "F492CDB921D7C1073D3C679ADCB53F17")
    
    private void setJField(Object o, Class<?> declaringClass, Class<?> type, int slot,
                boolean noAccessCheck, char descriptor, long j) throws IllegalAccessException{
    	//Formerly a native method
    	addTaint(o.getTaint());
    	addTaint(declaringClass.getTaint());
    	addTaint(type.getTaint());
    	addTaint(slot);
    	addTaint(noAccessCheck);
    	addTaint(descriptor);
    	addTaint(j);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.416 -0500", hash_original_method = "E80188BF0543922F0F2BDA0A103D17F5", hash_generated_method = "08BC613543A152C1628DCF0372279C5A")
    
    private void setZField(Object o, Class<?> declaringClass, Class<?> type, int slot,
                boolean noAccessCheck, char descriptor, boolean z) throws IllegalAccessException{
    	//Formerly a native method
    	addTaint(o.getTaint());
    	addTaint(declaringClass.getTaint());
    	addTaint(type.getTaint());
    	addTaint(slot);
    	addTaint(noAccessCheck);
    	addTaint(descriptor);
    	addTaint(z);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.420 -0500", hash_original_method = "570BC71D32CB4741615EF7701079ED2D", hash_generated_method = "8A8ECE7D192F4A5DCFCE15CB7659AF54")
    
    private void setFField(Object o, Class<?> declaringClass, Class<?> type, int slot,
                boolean noAccessCheck, char descriptor, float f) throws IllegalAccessException{
    	//Formerly a native method
    	addTaint(o.getTaint());
    	addTaint(declaringClass.getTaint());
    	addTaint(type.getTaint());
    	addTaint(slot);
    	addTaint(noAccessCheck);
    	addTaint(descriptor);
    	addTaint(f);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.425 -0500", hash_original_method = "ACD0A6EABB934CC5EEECCAB72AA01730", hash_generated_method = "572011FE38AC9D62A97FBEA67172AFB4")
    
    private void setCField(Object o, Class<?> declaringClass, Class<?> type, int slot,
                boolean noAccessCheck, char descriptor, char c) throws IllegalAccessException{
    	//Formerly a native method
    	addTaint(o.getTaint());
    	addTaint(declaringClass.getTaint());
    	addTaint(type.getTaint());
    	addTaint(slot);
    	addTaint(noAccessCheck);
    	addTaint(descriptor);
    	addTaint(c);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.429 -0500", hash_original_method = "2A0F6C37A6B68BD24BAC15A31879F06F", hash_generated_method = "29AE506210359DB36AA4E8E8A68FA52D")
    
    private void setSField(Object o, Class<?> declaringClass, Class<?> type, int slot,
                boolean noAccessCheck, char descriptor, short s) throws IllegalAccessException{
    	//Formerly a native method
    	addTaint(o.getTaint());
    	addTaint(declaringClass.getTaint());
    	addTaint(type.getTaint());
    	addTaint(slot);
    	addTaint(noAccessCheck);
    	addTaint(descriptor);
    	addTaint(s);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.433 -0500", hash_original_method = "4D8B3646C0E699793861ED8487ADC739", hash_generated_method = "637955DC4F54566501CD227F672567C7")
    
    private void setBField(Object o, Class<?> declaringClass, Class<?> type, int slot,
                boolean noAccessCheck, char descriptor, byte b) throws IllegalAccessException{
    	//Formerly a native method
    	addTaint(o.getTaint());
    	addTaint(declaringClass.getTaint());
    	addTaint(type.getTaint());
    	addTaint(slot);
    	addTaint(noAccessCheck);
    	addTaint(descriptor);
    	addTaint(b);
    }
    
}

