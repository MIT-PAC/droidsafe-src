package java.lang.reflect;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.annotation.Annotation;

import libcore.util.EmptyArray;

import org.apache.harmony.kernel.vm.StringUtils;
import org.apache.harmony.luni.lang.reflect.GenericSignatureParser;
import org.apache.harmony.luni.lang.reflect.ListOfTypes;
import org.apache.harmony.luni.lang.reflect.Types;






public final class Constructor<T> extends AccessibleObject implements GenericDeclaration, Member {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.840 -0500", hash_original_field = "A496C5D8F7CD0CB9CA97840555DF2AAA", hash_generated_field = "A496C5D8F7CD0CB9CA97840555DF2AAA")


    Class<T> declaringClass;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.842 -0500", hash_original_field = "6A17A418C19B2E2A1B1FDDDFEF7489B2", hash_generated_field = "6A17A418C19B2E2A1B1FDDDFEF7489B2")


    Class<?>[] parameterTypes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.844 -0500", hash_original_field = "0166CFA676A3372FA7BAE30D743E0654", hash_generated_field = "0166CFA676A3372FA7BAE30D743E0654")


    Class<?>[] exceptionTypes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.847 -0500", hash_original_field = "1086E50AEBD292B3AD2410822F2C4F08", hash_generated_field = "1086E50AEBD292B3AD2410822F2C4F08")


    ListOfTypes genericExceptionTypes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.849 -0500", hash_original_field = "8AC26B514C4DE93BC9F36D116E4A4BC6", hash_generated_field = "8AC26B514C4DE93BC9F36D116E4A4BC6")

    ListOfTypes genericParameterTypes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.852 -0500", hash_original_field = "AEB06F4FE88A2F3FB2B5EFC21C88983B", hash_generated_field = "AEB06F4FE88A2F3FB2B5EFC21C88983B")

    TypeVariable<Constructor<T>>[] formalTypeParameters;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.854 -0500", hash_original_field = "882601A2CEBECCB3AC8128B79706E015", hash_generated_field = "89FDBAE6DE2AE55271071C78F774F101")

    private volatile boolean genericTypesAreInitialized = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.860 -0500", hash_original_field = "09F7A5BA4BC6B04AB18035FB41A6CB6C", hash_generated_field = "09F7A5BA4BC6B04AB18035FB41A6CB6C")


    int slot;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.952 -0400", hash_original_method = "F22CB981733D75C2BC34BDB791B93657", hash_generated_method = "5981B35754AB4E8CEEDEF9BB5EC55BCB")
	public  Constructor() {
        // ---------- Original Method ----------
    }

    /**
     * Creates an instance of the class. Only called from native code, thus
     * private.
     *
     * @param declaringClass
     *            the class this constructor object belongs to
     * @param ptypes
     *            the parameter types of the constructor
     * @param extypes
     *            the exception types of the constructor
     * @param slot
     *            the slot of the constructor inside the VM class structure
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.866 -0500", hash_original_method = "4E2CA9FC94A5B82D01ACB923AD24E02D", hash_generated_method = "16894EF4C9E59BDD4BE588525F38FC7A")
    
private Constructor (Class<T> declaringClass, Class<?>[] ptypes, Class<?>[] extypes, int slot){
        this.declaringClass = declaringClass;
        this.parameterTypes = ptypes;
        this.exceptionTypes = extypes;          // may be null
        this.slot = slot;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.857 -0500", hash_original_method = "ED32915D16D10FD7E30E61397009B806", hash_generated_method = "A1FFE78535A43F8D511E022C93030B73")
    
private synchronized void initGenericTypes() {
        if (!genericTypesAreInitialized) {
            String signatureAttribute = getSignatureAttribute();
            GenericSignatureParser parser = new GenericSignatureParser(
                    declaringClass.getClassLoader());
            parser.parseForConstructor(this, signatureAttribute, exceptionTypes);
            formalTypeParameters = parser.formalTypeParameters;
            genericParameterTypes = parser.parameterTypes;
            genericExceptionTypes = parser.exceptionTypes;
            genericTypesAreInitialized = true;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.868 -0500", hash_original_method = "C62B79950C859BF71BE9288BB0AB9C37", hash_generated_method = "906C8465F062DF16643A1BE9DE73F23B")
    
@Override /*package*/ String getSignatureAttribute() {
        Object[] annotation = Method.getSignatureAnnotation(declaringClass, slot);

        if (annotation == null) {
            return null;
        }

        return StringUtils.combineStrings(annotation);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.871 -0500", hash_original_method = "085B8CB42A6E3AC80C8A5E5B20AAB41A", hash_generated_method = "BE6271EFEC0F6A356B73FB6A34AE80E2")
    
public TypeVariable<Constructor<T>>[] getTypeParameters() {
        initGenericTypes();
        return formalTypeParameters.clone();
    }

    /**
     * Returns the string representation of the constructor's declaration,
     * including the type parameters.
     *
     * @return the string representation of the constructor's declaration
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.874 -0500", hash_original_method = "BD69A0542CEC9A8352D572DD82647C37", hash_generated_method = "CD727EAEB1AC1D999C72A37595380EDA")
    
public String toGenericString() {
        StringBuilder sb = new StringBuilder(80);
        initGenericTypes();
        // append modifiers if any
        int modifier = getModifiers();
        if (modifier != 0) {
            sb.append(Modifier.toString(modifier & ~Modifier.VARARGS)).append(' ');
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
        // append constructor name
        appendArrayType(sb, getDeclaringClass());
        // append parameters
        sb.append('(');
        appendArrayGenericType(sb,
                Types.getClonedTypeArray(genericParameterTypes));
        sb.append(')');
        // append exceptions if any
        Type[] genericExceptionTypeArray =
                Types.getClonedTypeArray(genericExceptionTypes);
        if (genericExceptionTypeArray.length > 0) {
            sb.append(" throws ");
            appendArrayGenericType(sb, genericExceptionTypeArray);
        }
        return sb.toString();
    }

    /**
     * Returns the generic parameter types as an array of {@code Type}
     * instances, in declaration order. If this constructor has no generic
     * parameters, an empty array is returned.
     *
     * @return the parameter types
     *
     * @throws GenericSignatureFormatError
     *             if the generic constructor signature is invalid
     * @throws TypeNotPresentException
     *             if any parameter type points to a missing type
     * @throws MalformedParameterizedTypeException
     *             if any parameter type points to a type that cannot be
     *             instantiated for some reason
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.876 -0500", hash_original_method = "A9CCE739D5419EE3EB1324AC76C431BA", hash_generated_method = "597DE9D598A5006361DA519667FA4A87")
    
public Type[] getGenericParameterTypes() {
        initGenericTypes();
        return Types.getClonedTypeArray(genericParameterTypes);
    }

    /**
     * Returns the exception types as an array of {@code Type} instances. If
     * this constructor has no declared exceptions, an empty array will be
     * returned.
     *
     * @return an array of generic exception types
     *
     * @throws GenericSignatureFormatError
     *             if the generic constructor signature is invalid
     * @throws TypeNotPresentException
     *             if any exception type points to a missing type
     * @throws MalformedParameterizedTypeException
     *             if any exception type points to a type that cannot be
     *             instantiated for some reason
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.879 -0500", hash_original_method = "D98F12BC8A74E89DDBE36E53E80FD275", hash_generated_method = "789F7B04AD124F733C6FAD0CF66E18E1")
    
public Type[] getGenericExceptionTypes() {
        initGenericTypes();
        return Types.getClonedTypeArray(genericExceptionTypes);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.882 -0500", hash_original_method = "4F7DC07C64174CDAA43175ECC599103D", hash_generated_method = "07AEBC12CA2EC299F6E5FE6DB937C323")
    
@Override
    public Annotation[] getDeclaredAnnotations() {
        return Method.getDeclaredAnnotations(declaringClass, slot);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.941 -0400", hash_original_method = "1A4BA94BF375F0F7A6512272530A6D39", hash_generated_method = "EFFA4E5032510A0BF30E67FE04872295")
    @Override
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        addTaint(annotationType.getTaint());
        if(annotationType == null)        
        {
            NullPointerException varD3565833EFC12BC5822ABFE94D257EDE_1877579624 = new NullPointerException("annotationType == null");
            varD3565833EFC12BC5822ABFE94D257EDE_1877579624.addTaint(taint);
            throw varD3565833EFC12BC5822ABFE94D257EDE_1877579624;
        } //End block
A var5417718CA49F9779F67999A1AA0ED4BB_140290513 =         Method.getAnnotation(declaringClass, slot, annotationType);
        var5417718CA49F9779F67999A1AA0ED4BB_140290513.addTaint(taint);
        return var5417718CA49F9779F67999A1AA0ED4BB_140290513;
        // ---------- Original Method ----------
        //if (annotationType == null) {
            //throw new NullPointerException("annotationType == null");
        //}
        //return Method.getAnnotation(declaringClass, slot, annotationType);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.886 -0500", hash_original_method = "DC6811BC307F5F500FE8FCDF979C7822", hash_generated_method = "D5FBE5652D97F48772ABB77A18869AD0")
    
@Override public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        if (annotationType == null) {
            throw new NullPointerException("annotationType == null");
        }
        return Method.isAnnotationPresent(declaringClass, slot, annotationType);
    }

    /**
     * Returns an array of arrays that represent the annotations of the formal
     * parameters of this constructor. If there are no parameters on this
     * constructor, then an empty array is returned. If there are no annotations
     * set, then an array of empty arrays is returned.
     *
     * @return an array of arrays of {@code Annotation} instances
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.889 -0500", hash_original_method = "15C5C292A9A80BF83F51CF39D22A468B", hash_generated_method = "6D00B8F17DF6E80921324AFA765B6F74")
    
public Annotation[][] getParameterAnnotations() {
        Annotation[][] parameterAnnotations
                = Method.getParameterAnnotations(declaringClass, slot);
        if (parameterAnnotations.length == 0) {
            return Method.noAnnotations(parameterTypes.length);
        }
        return parameterAnnotations;
    }

    /**
     * Indicates whether or not this constructor takes a variable number of
     * arguments.
     *
     * @return {@code true} if a vararg is declare, otherwise
     *         {@code false}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.891 -0500", hash_original_method = "27084EEDAB7B32E40BFE6AC29F04C9B8", hash_generated_method = "F7B313C619E35ED15C78BD29E09C3FC8")
    
public boolean isVarArgs() {
        int mods = Method.getMethodModifiers(declaringClass, slot);
        return (mods & Modifier.VARARGS) != 0;
    }

    /**
     * Indicates whether or not this constructor is synthetic (artificially
     * introduced by the compiler).
     *
     * @return {@code true} if this constructor is synthetic, {@code false}
     *         otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.893 -0500", hash_original_method = "98AC39075FB2CBC83E161E978A13C606", hash_generated_method = "EA89296846BBCB6FAAB4928645EE2640")
    
public boolean isSynthetic() {
        int mods = Method.getMethodModifiers(declaringClass, slot);
        return (mods & Modifier.SYNTHETIC) != 0;
    }

    /**
     * Indicates whether or not the specified {@code object} is equal to this
     * constructor. To be equal, the specified object must be an instance
     * of {@code Constructor} with the same declaring class and parameter types
     * as this constructor.
     *
     * @param object
     *            the object to compare
     *
     * @return {@code true} if the specified object is equal to this
     *         constructor, {@code false} otherwise
     *
     * @see #hashCode
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.897 -0500", hash_original_method = "B30900BF5B4B7FDD7368A6CB9464E167", hash_generated_method = "C8AF66BD38D397DF89E4D697F0FC0F82")
    
@Override
    public boolean equals(Object object) {
        return object instanceof Constructor && toString().equals(object.toString());
    }

    /**
     * Returns the class that declares this constructor.
     *
     * @return the declaring class
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.899 -0500", hash_original_method = "CE10C7360422171346CFCFE4390D0CD4", hash_generated_method = "90E9BF83F1779E241EBB0A05FEA9321D")
    
public Class<T> getDeclaringClass() {
        return declaringClass;
    }

    /**
     * Returns the exception types as an array of {@code Class} instances. If
     * this constructor has no declared exceptions, an empty array will be
     * returned.
     *
     * @return the declared exception classes
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.901 -0500", hash_original_method = "0803D161ECCDE8E4916E8597C31C5EAF", hash_generated_method = "1AD8748424F084736A9DD63261A66A14")
    
public Class<?>[] getExceptionTypes() {
        if (exceptionTypes == null) {
            return EmptyArray.CLASS;
        }
        return exceptionTypes.clone();
    }

    /**
     * Returns the modifiers for this constructor. The {@link Modifier} class
     * should be used to decode the result.
     *
     * @return the modifiers for this constructor
     *
     * @see Modifier
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.904 -0500", hash_original_method = "75F84F634C025C373FC5DFC6F2FEAE7E", hash_generated_method = "C18C1BAA23A876F5E5A67D46CB05C716")
    
public int getModifiers() {
        return Method.getMethodModifiers(declaringClass, slot);
    }

    /**
     * Returns the name of this constructor.
     *
     * @return the name of this constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.906 -0500", hash_original_method = "64DF6B8C865C11FF9D8C98657107C7C5", hash_generated_method = "CB3A20844DD676DBCB831F281B3D93F7")
    
public String getName() {
        return declaringClass.getName();
    }

    /**
     * Returns an array of the {@code Class} objects associated with the
     * parameter types of this constructor. If the constructor was declared with
     * no parameters, an empty array will be returned.
     *
     * @return the parameter types
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.909 -0500", hash_original_method = "860AC8CD4E2F5F390A65618A1941DEDE", hash_generated_method = "0845E4F05C4F8FB178489C01FC4EE8B5")
    
public Class<?>[] getParameterTypes() {
        return parameterTypes.clone();
    }

    /**
     * Returns the constructor's signature in non-printable form. This is called
     * (only) from IO native code and needed for deriving the serialVersionUID
     * of the class
     *
     * @return the constructor's signature
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.912 -0500", hash_original_method = "70A1497759834DE033251D58FB1BC60F", hash_generated_method = "500A530AB78C817D473EEED83F309284")
    
@SuppressWarnings("unused")
    private String getSignature() {
        StringBuilder result = new StringBuilder();

        result.append('(');
        for (int i = 0; i < parameterTypes.length; i++) {
            result.append(getSignature(parameterTypes[i]));
        }
        result.append(")V");

        return result.toString();
    }

    /**
     * Returns an integer hash code for this constructor. Constructors which are
     * equal return the same value for this method. The hash code for a
     * Constructor is the hash code of the name of the declaring class.
     *
     * @return the hash code
     *
     * @see #equals
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.915 -0500", hash_original_method = "B8D03AB769FE0736E7C02030ACA8679C", hash_generated_method = "23EBF2A9186F5D0C599C5C1CCE703357")
    
@Override
    public int hashCode() {
        return declaringClass.getName().hashCode();
    }

    /**
     * Returns a new instance of the declaring class, initialized by dynamically
     * invoking the constructor represented by this {@code Constructor} object.
     * This reproduces the effect of {@code new declaringClass(arg1, arg2, ... ,
     * argN)} This method performs the following:
     * <ul>
     * <li>A new instance of the declaring class is created. If the declaring
     * class cannot be instantiated (i.e. abstract class, an interface, an array
     * type, or a primitive type) then an InstantiationException is thrown.</li>
     * <li>If this Constructor object is enforcing access control (see
     * {@link AccessibleObject}) and this constructor is not accessible from the
     * current context, an IllegalAccessException is thrown.</li>
     * <li>If the number of arguments passed and the number of parameters do not
     * match, an IllegalArgumentException is thrown.</li>
     * <li>For each argument passed:
     * <ul>
     * <li>If the corresponding parameter type is a primitive type, the argument
     * is unboxed. If the unboxing fails, an IllegalArgumentException is
     * thrown.</li>
     * <li>If the resulting argument cannot be converted to the parameter type
     * via a widening conversion, an IllegalArgumentException is thrown.</li>
     * </ul>
     * <li>The constructor represented by this {@code Constructor} object is
     * then invoked. If an exception is thrown during the invocation, it is
     * caught and wrapped in an InvocationTargetException. This exception is
     * then thrown. If the invocation completes normally, the newly initialized
     * object is returned.
     * </ul>
     *
     * @param args
     *            the arguments to the constructor
     *
     * @return the new, initialized, object
     *
     * @exception InstantiationException
     *                if the class cannot be instantiated
     * @exception IllegalAccessException
     *                if this constructor is not accessible
     * @exception IllegalArgumentException
     *                if an incorrect number of arguments are passed, or an
     *                argument could not be converted by a widening conversion
     * @exception InvocationTargetException
     *                if an exception was thrown by the invoked constructor
     *
     * @see AccessibleObject
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.917 -0500", hash_original_method = "E7355AF509FB0F598B5C977468B592C4", hash_generated_method = "63FEE1322FA0BC46765B9AB7FCBF68AC")
    
public T newInstance(Object... args) throws InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        return constructNative (args, declaringClass, parameterTypes, slot, flag);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.723 -0400", hash_original_method = "847A043CD7E53CD248ABB6D5FEBEB21F", hash_generated_method = "AB7A646FD776CAA4E845EC2470DC079B")
    private T constructNative(Object[] args, Class<T> declaringClass,
            Class<?>[] parameterTypes, int slot,
            boolean noAccessCheck) throws InstantiationException, IllegalAccessException,
            InvocationTargetException {
    	addTaint(args[0].taint);
    	addTaint(declaringClass.taint);
    	addTaint(parameterTypes[0].taint);
    	addTaint(slot);
    	addTaint(noAccessCheck);
    	return (T)new Object();
    }

    /**
     * Returns a string containing a concise, human-readable description of this
     * constructor. The format of the string is:
     *
     * <ol>
     *   <li>modifiers (if any)
     *   <li>declaring class name
     *   <li>'('
     *   <li>parameter types, separated by ',' (if any)
     *   <li>')'
     *   <li>'throws' plus exception types, separated by ',' (if any)
     * </ol>
     *
     * For example:
     * {@code public String(byte[],String) throws UnsupportedEncodingException}
     *
     * @return a printable representation for this constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:13.924 -0500", hash_original_method = "4738B09E6DE786765E7966DA89BB1975", hash_generated_method = "2EDD7FCF208F6E1D78BDB8F8499E562B")
    
@Override
    public String toString() {
        StringBuilder result = new StringBuilder(Modifier.toString(getModifiers()));

        if (result.length() != 0)
            result.append(' ');
        result.append(declaringClass.getName());
        result.append("(");
        result.append(toString(parameterTypes));
        result.append(")");
        if (exceptionTypes != null && exceptionTypes.length != 0) {
            result.append(" throws ");
            result.append(toString(exceptionTypes));
        }

        return result.toString();
    }

    
}

