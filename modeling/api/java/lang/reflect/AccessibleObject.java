package java.lang.reflect;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.annotation.Annotation;
import java.util.Hashtable;

import org.apache.harmony.kernel.vm.StringUtils;

public class AccessibleObject implements AnnotatedElement {

    @DSSafe(DSCat.SAFE_LIST)

    @DSComment("Java language reflection")

    /**
     * Attempts to set the accessible flag for all objects in {@code objects}.
     * Setting this to true prevents {@code IllegalAccessExceptions}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 01:11:00.494 -0400", hash_original_method = "986E0AEABE79531D4CEF9192F310BD8A", hash_generated_method = "1DF5E8147BD1E50E88045DC772FE8D22")
    
public static void setAccessible(AccessibleObject[] objects, boolean flag) {
        for (AccessibleObject object : objects) {
            object.flag = flag;
        }
    }

    /**
     * Retrieve the signature attribute from an arbitrary class.  This is
     * the same as Class.getSignatureAttribute(), but it can be used from
     * the java.lang.reflect package.
     */
    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.363 -0500", hash_original_method = "0EA85850CAF8D26BF10D52C824A0CA19", hash_generated_method = "48B4ABE2E7323E428D11CA7F6309669D")
    
static String getClassSignatureAttribute(Class clazz) {
        Object[] annotation = getClassSignatureAnnotation(clazz);

        if (annotation == null) {
            return null;
        }

        return StringUtils.combineStrings(annotation);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static Object[] getClassSignatureAnnotation(Class clazz) {
		Object[] ret = new Object[0];
		ret[0].addTaint(clazz.getTaint());
		return ret;
	}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.332 -0500", hash_original_field = "73EA6AEBBE448C5C33ED9F0E5E3F055A", hash_generated_field = "F7E345322C5DA8049D7465C5406D9B9D")

    static Hashtable<String, String> trans;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:40.098 -0400", hash_original_field = "D3CD6765000979577B5DA559E9F23C55", hash_generated_field = "1A2D47197AF65ECB2BA4A26AB02401AE")

    boolean flag = false;
    @DSSafe(DSCat.SAFE_OTHERS)

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 01:11:00.480 -0400", hash_original_method = "79E776845C9774BB9614D2D0955EABCF", hash_generated_method = "07D69BA5ABE497283D1B6DE52B581BA9")
    
protected AccessibleObject() {
    }

  /*  protected ArtMethod artMethod;
    public AccessibleObject(ArtMethod artMethod) {
        this.artMethod  = artMethod;
        // TODO Auto-generated constructor stub
    }*/

    @DSSafe(DSCat.SAFE_LIST)

    @DSComment("Java language reflection")

    /**
     * Returns true if this object is accessible without access checks.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 01:11:00.487 -0400", hash_original_method = "66D52F3844786BE4BB43647AC248F3A6", hash_generated_method = "F758FA2BFE5D48F8DCF99731C758F154")
    
public boolean isAccessible() {
        return flag;
    }

    @DSSafe(DSCat.SAFE_LIST)

    @DSComment("Java language reflection")

    /**
     * Attempts to set the accessible flag. Setting this to true prevents {@code
     * IllegalAccessExceptions}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 01:11:00.491 -0400", hash_original_method = "1000999C704703264C7A249C905DEAE6", hash_generated_method = "BB58AE5FEDFFFA08CEBC07B09269E4D5")
    
public void setAccessible(boolean flag) {
        this.flag = flag;
     }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 01:11:00.498 -0400", hash_original_method = "8CC5FFC4D6878043D8F48CA01CEE9F83", hash_generated_method = "43B9C3B1D7E884AD2A7C713875A9E867")
    
@Override public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        throw new UnsupportedOperationException();
    }

    @DSSafe(DSCat.SAFE_LIST)

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 01:11:00.501 -0400", hash_original_method = "0B7DCEEC0F2643B54E5B168F87B9CE3A", hash_generated_method = "25FEC77CF75F53EC70921EE8A193CB69")
    
@Override public Annotation[] getDeclaredAnnotations() {
        throw new UnsupportedOperationException();
    }

    @DSSafe(DSCat.SAFE_LIST)

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 01:11:00.508 -0400", hash_original_method = "CDE5472758ACF6CE75A2FF7BF6EF0F38", hash_generated_method = "0E992320369165946CB376284766369A")
    
@Override public Annotation[] getAnnotations() {
        // for all but Class, getAnnotations == getDeclaredAnnotations
        return getDeclaredAnnotations();
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.854 -0400", hash_original_method = "E854D6B6A4F110252592FEF88B9AB0AA", hash_generated_method = "3568A964D8BA23EB6D5CB01D72AE6A5D")
    public <T extends Annotation> T getAnnotation(Class<T> annotationType) {
        addTaint(annotationType.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1374839107 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1374839107.addTaint(getTaint());
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1374839107;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    /**
     * Returns the signature for a class. This is the kind of signature used
     * internally by the JVM, with one-character codes representing the basic
     * types. It is not suitable for printing.
     *
     * @param clazz
     *            the class for which a signature is required
     *
     * @return The signature as a string
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.356 -0500", hash_original_method = "AFCD123A6E616CB6E7A6F8CAEE33C533", hash_generated_method = "AFCD123A6E616CB6E7A6F8CAEE33C533")
    
String getSignature(Class<?> clazz) {
        String result = "";
        String nextType = clazz.getName();

        if(trans.containsKey(nextType)) {
            result = trans.get(nextType);
        } else {
            if(clazz.isArray()) {
                result = "[" + getSignature(clazz.getComponentType());
            } else {
                result = "L" + nextType + ";";
            }
        }
        return result;
    }

    /**
     * Returns a printable String consisting of the canonical names of the
     * classes contained in an array. The form is that used in parameter and
     * exception lists, that is, the class or type names are separated by
     * commas.
     *
     * @param types
     *            the array of classes
     *
     * @return The String of names
     */
    @DSComment("Package priviledge")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.358 -0500", hash_original_method = "538B7B8EC3794D6F6E22215297E953DA", hash_generated_method = "538B7B8EC3794D6F6E22215297E953DA")
    
String toString(Class<?>[] types) {
        StringBuilder result = new StringBuilder();

        if (types.length != 0) {
            result.append(types[0].getName());
            for (int i = 1; i < types.length; i++) {
                result.append(',');
                result.append(types[i].getName());
            }
        }

        return result.toString();
    }

    /**
     * Gets the Signature attribute for this instance. Returns {@code null}
     * if not found.
     */
    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.360 -0500", hash_original_method = "595C9CE9F234EEA7E3334962F2566B38", hash_generated_method = "F0B9CD63B24B94657C1ECA3D3E5E02CA")
    
String getSignatureAttribute() {
        /*
         * Note: This method would have been declared abstract, but the
         * standard API lists this class as concrete.
         */
        throw new UnsupportedOperationException();
    }

    /**
     * Appends the specified class name to the buffer. The class may represent
     * a simple type, a reference type or an array type.
     *
     * @param sb buffer
     * @param obj the class which name should be appended to the buffer
     *
     * @throws NullPointerException if any of the arguments is null
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.370 -0500", hash_original_method = "96346F5FDCAEE775233825443F323528", hash_generated_method = "96346F5FDCAEE775233825443F323528")
    
void appendArrayType(StringBuilder sb, Class<?> obj) {
        int dimensions = 0;
        while (obj.isArray()) {
            obj = obj.getComponentType();
            dimensions++;
        }
        sb.append(obj.getName());
        for (int d = 0; d < dimensions; d++) {
            sb.append("[]");
        }
    }

    /**
     * Appends names of the specified array classes to the buffer. The array
     * elements may represent a simple type, a reference type or an array type.
     * Output format: java.lang.Object[], java.io.File, void
     *
     * @param types array of classes to print the names
     * @throws NullPointerException if any of the arguments is null
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.373 -0500", hash_original_method = "4331049DB20FE3D320265414E1BB6DD1", hash_generated_method = "4331049DB20FE3D320265414E1BB6DD1")
    
void appendArrayGenericType(StringBuilder sb, Type[] types) {
        if (types.length > 0) {
            appendGenericType(sb, types[0]);
            for (int i = 1; i < types.length; i++) {
                sb.append(',');
                appendGenericType(sb, types[i]);
            }
        }
    }

    /**
     * Appends the generic type representation to the buffer.
     *
     * @param sb buffer
     * @param obj the generic type which representation should be appended to the buffer
     *
     * @throws NullPointerException if any of the arguments is null
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.377 -0500", hash_original_method = "8E82FAA48BB361A9859A3C64A69CEBFA", hash_generated_method = "639986077F4F64C49F9CD8BE0AAAE4A8")
    
void appendGenericType(StringBuilder sb, Type obj) {
        if (obj instanceof TypeVariable) {
            sb.append(((TypeVariable)obj).getName());
        } else if (obj instanceof ParameterizedType) {
            sb.append(obj.toString());
        } else if (obj instanceof GenericArrayType) { //XXX: is it a working branch?
            Type simplified = ((GenericArrayType)obj).getGenericComponentType();
            appendGenericType(sb, simplified);
            sb.append("[]");
        } else if (obj instanceof Class) {
            Class c = ((Class<?>)obj);
            if (c.isArray()){
                String as[] = c.getName().split("\\[");
                int len = as.length-1;
                if (as[len].length() > 1){
                    sb.append(as[len].substring(1, as[len].length()-1));
                } else {
                    char ch = as[len].charAt(0);
                    if (ch == 'I')
                        sb.append("int");
                    else if (ch == 'B')
                        sb.append("byte");
                    else if (ch == 'J')
                        sb.append("long");
                    else if (ch == 'F')
                        sb.append("float");
                    else if (ch == 'D')
                        sb.append("double");
                    else if (ch == 'S')
                        sb.append("short");
                    else if (ch == 'C')
                        sb.append("char");
                    else if (ch == 'Z')
                        sb.append("boolean");
                    else if (ch == 'V') //XXX: is it a working branch?
                        sb.append("void");
                }
                for (int i = 0; i < len; i++){
                    sb.append("[]");
                }
            } else {
                sb.append(c.getName());
            }
        }
    }
    static {
        trans = new Hashtable<String, String>(9);
        trans.put("byte", "B");
        trans.put("char", "C");
        trans.put("short", "S");
        trans.put("int", "I");
        trans.put("long", "J");
        trans.put("float", "F");
        trans.put("double", "D");
        trans.put("void", "V");
        trans.put("boolean", "Z");
    }

    String toGenericString() {
        // TODO Auto-generated method stub
        return "<genericString>";
    }

    Type[] getGenericParameterTypes() {
        // TODO Auto-generated method stub
        return null;
    }

    Class<?> getDeclaringClass() {
        // TODO Auto-generated method stub
        try {
            return (Class<?>)new Class();
        }
        catch (Exception ex) {
            return null;
        }
    }

    int getModifiers() {
        // TODO Auto-generated method stub
        return 0;
    }

    public Class<?>[] getParameterTypes() {
        // TODO Auto-generated method stub
        return null;
    }
    
    public int getDexMethodIndex() {
        return getTaintInt();
    }

    public int getDexFieldIndex() {
        return getTaintInt();
    }
    
}

