package java.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.lang.annotation.Annotation;
import java.util.Comparator;
import libcore.util.EmptyArray;
import org.apache.harmony.kernel.vm.StringUtils;
import org.apache.harmony.luni.lang.reflect.GenericSignatureParser;
import org.apache.harmony.luni.lang.reflect.ListOfTypes;
import org.apache.harmony.luni.lang.reflect.Types;

public final class Method extends AccessibleObject implements GenericDeclaration, Member {
    public static final Comparator<Method> ORDER_BY_SIGNATURE = new Comparator<Method>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:11.050 -0400", hash_original_method = "BE88CC170A38DCD3E91DA840E3F7F4E0", hash_generated_method = "B05BF28A02B7310D4249852DEBCB9C9A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int compare(Method a, Method b) {
            dsTaint.addTaint(b.dsTaint);
            dsTaint.addTaint(a.dsTaint);
            int comparison;
            comparison = a.name.compareTo(b.name);
            Class<?>[] aParameters;
            aParameters = a.parameterTypes;
            Class<?>[] bParameters;
            bParameters = b.parameterTypes;
            int length;
            length = Math.min(aParameters.length, bParameters.length);
            {
                int i;
                i = 0;
                {
                    comparison = aParameters[i].getName().compareTo(bParameters[i].getName());
                } //End block
            } //End collapsed parenthetic
            int varD82080CC8BE1D0175ED867E01D1CD16B_62143411 = (a.getReturnType().getName().compareTo(b.getReturnType().getName()));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //int comparison = a.name.compareTo(b.name);
            //if (comparison != 0) {
                //return comparison;
            //}
            //Class<?>[] aParameters = a.parameterTypes;
            //Class<?>[] bParameters = b.parameterTypes;
            //int length = Math.min(aParameters.length, bParameters.length);
            //for (int i = 0; i < length; i++) {
                //comparison = aParameters[i].getName().compareTo(bParameters[i].getName());
                //if (comparison != 0) {
                    //return comparison;
                //}
            //}
            //if (aParameters.length != bParameters.length) {
                //return aParameters.length - bParameters.length;
            //}
            //return a.getReturnType().getName().compareTo(b.getReturnType().getName());
        }

        
}; //Transformed anonymous class
    private int slot;
    private Class<?> declaringClass;
    private String name;
    private Class<?>[] parameterTypes;
    private Class<?>[] exceptionTypes;
    private Class<?> returnType;
    private ListOfTypes genericExceptionTypes;
    private ListOfTypes genericParameterTypes;
    private Type genericReturnType;
    private TypeVariable<Method>[] formalTypeParameters;
    private volatile boolean genericTypesAreInitialized = false;
    private static Annotation[] NO_ANNOTATIONS = new Annotation[0];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:11.062 -0400", hash_original_method = "70F1F77231BFE73E3138A8A58A15C35C", hash_generated_method = "E408100225D95A6DF62A24952ED18ECA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Method(Method orig) {
        this(orig.declaringClass, orig.parameterTypes, orig.exceptionTypes,
                orig.returnType, orig.name, orig.slot);
        dsTaint.addTaint(orig.dsTaint);
        {
            this.flag = true;
        } //End block
        // ---------- Original Method ----------
        //if (orig.flag) {
            //this.flag = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:11.070 -0400", hash_original_method = "F4B9C750B34D03AFED72DBA84048C99D", hash_generated_method = "2C7EBAA7D75D991948B98029E286D2B5")
    @DSModeled(DSC.SAFE)
    private Method(Class<?> declaring, Class<?>[] paramTypes, Class<?>[] exceptTypes, Class<?> returnType, String name, int slot) {
        dsTaint.addTaint(exceptTypes[0].dsTaint);
        dsTaint.addTaint(name);
        dsTaint.addTaint(declaring.dsTaint);
        dsTaint.addTaint(paramTypes[0].dsTaint);
        dsTaint.addTaint(slot);
        dsTaint.addTaint(returnType.dsTaint);
        // ---------- Original Method ----------
        //this.declaringClass = declaring;
        //this.name = name;
        //this.slot = slot;
        //this.parameterTypes = paramTypes;
        //this.exceptionTypes = exceptTypes;
        //this.returnType = returnType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:11.079 -0400", hash_original_method = "0BE83C703D137B5A5A60EFAA17178485", hash_generated_method = "2E6602FB9B8F757AAC6EA0C750B3F508")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized void initGenericTypes() {
        {
            String signatureAttribute;
            signatureAttribute = getSignatureAttribute();
            GenericSignatureParser parser;
            parser = new GenericSignatureParser(
                    declaringClass.getClassLoader());
            parser.parseForMethod(this, signatureAttribute, exceptionTypes);
            formalTypeParameters = parser.formalTypeParameters;
            genericParameterTypes = parser.parameterTypes;
            genericExceptionTypes = parser.exceptionTypes;
            genericReturnType = parser.returnType;
            genericTypesAreInitialized = true;
        } //End block
        // ---------- Original Method ----------
        //if (!genericTypesAreInitialized) {
            //String signatureAttribute = getSignatureAttribute();
            //GenericSignatureParser parser = new GenericSignatureParser(
                    //declaringClass.getClassLoader());
            //parser.parseForMethod(this, signatureAttribute, exceptionTypes);
            //formalTypeParameters = parser.formalTypeParameters;
            //genericParameterTypes = parser.parameterTypes;
            //genericExceptionTypes = parser.exceptionTypes;
            //genericReturnType = parser.returnType;
            //genericTypesAreInitialized = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:11.085 -0400", hash_original_method = "0F068F731FE610BBACFD836E6A61AACF", hash_generated_method = "ACA76EC6B35A226FCA252A2261F4E527")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TypeVariable<Method>[] getTypeParameters() {
        initGenericTypes();
        TypeVariable<Method>[] var5320BB572BA206FFFB06E56C5FAE64D5_937070402 = (formalTypeParameters.clone());
        return (TypeVariable<Method>[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //initGenericTypes();
        //return formalTypeParameters.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:11.088 -0400", hash_original_method = "1CDF5107AC443AA5F8C2E1DA9DF559A0", hash_generated_method = "68F3042B30D28555B5BB2316D014F0B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     String getSignatureAttribute() {
        Object[] annotation;
        annotation = getSignatureAnnotation(declaringClass, slot);
        String var33705CFE2485E284459211E6CFE410F3_844915459 = (StringUtils.combineStrings(annotation));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //Object[] annotation = getSignatureAnnotation(declaringClass, slot);
        //if (annotation == null) {
            //return null;
        //}
        //return StringUtils.combineStrings(annotation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:11.093 -0400", hash_original_method = "5161131687230E0D7EE89383FDDF9117", hash_generated_method = "C86FF5AA7B792DD7103D0965CACD1AC0")
    static Object[] getSignatureAnnotation(Class declaringClass, int slot) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return new Annotation[]{(Annotation)declaringClass.dsTaint};
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:11.110 -0400", hash_original_method = "060018D8556E7858267AA04DC5F84FE8", hash_generated_method = "0453D6DDD0FD08A9B841829DC39D87C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toGenericString() {
        StringBuilder sb;
        sb = new StringBuilder(80);
        initGenericTypes();
        int modifier;
        modifier = getModifiers();
        {
            sb.append(Modifier.toString(modifier & ~(Modifier.BRIDGE +
                    Modifier.VARARGS))).append(' ');
        } //End block
        {
            sb.append('<');
            {
                int i;
                i = 0;
                {
                    appendGenericType(sb, formalTypeParameters[i]);
                    {
                        sb.append(",");
                    } //End block
                } //End block
            } //End collapsed parenthetic
            sb.append("> ");
        } //End block
        appendGenericType(sb, Types.getType(genericReturnType));
        sb.append(' ');
        appendArrayType(sb, getDeclaringClass());
        sb.append(".").append(getName());
        sb.append('(');
        appendArrayGenericType(sb,
                Types.getClonedTypeArray(genericParameterTypes));
        sb.append(')');
        Type[] genericExceptionTypeArray;
        genericExceptionTypeArray = Types.getClonedTypeArray(
                genericExceptionTypes);
        {
            sb.append(" throws ");
            appendArrayGenericType(sb, genericExceptionTypeArray);
        } //End block
        String var806458D832AB974D230FEE4CBBDBD390_1543503733 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:11.119 -0400", hash_original_method = "A9CCE739D5419EE3EB1324AC76C431BA", hash_generated_method = "786159E29C79465ADAEF6BB2ADF17F77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Type[] getGenericParameterTypes() {
        initGenericTypes();
        Type[] varCE0399215D6C708DCB4E972B600A112D_724093060 = (Types.getClonedTypeArray(genericParameterTypes));
        return (Type[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //initGenericTypes();
        //return Types.getClonedTypeArray(genericParameterTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:11.126 -0400", hash_original_method = "D98F12BC8A74E89DDBE36E53E80FD275", hash_generated_method = "75B15993381071A531659B7BD48DC217")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Type[] getGenericExceptionTypes() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        initGenericTypes();
        Type[] var63B58D61A87E534F5FBD3F9F11DC7F51_403515636 = (Types.getClonedTypeArray(genericExceptionTypes));
        return (Type[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //initGenericTypes();
        //return Types.getClonedTypeArray(genericExceptionTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:11.136 -0400", hash_original_method = "83125796E1541F4C47F8F2176AE50053", hash_generated_method = "A1D03B38E25904B49503ED811F16B828")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Type getGenericReturnType() {
        initGenericTypes();
        Type var62E8E372FB8C7B45C55EECB285EDD7EA_1920997061 = (Types.getType(genericReturnType));
        return (Type)dsTaint.getTaint();
        // ---------- Original Method ----------
        //initGenericTypes();
        //return Types.getType(genericReturnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:11.146 -0400", hash_original_method = "4122EC91CDDE6FFD9DA08F5ADAF8DB5D", hash_generated_method = "17A40771E0F0297089FCB320E127D631")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Annotation[] getDeclaredAnnotations() {
        Annotation[] varC17A9D109C2F23B123FCE14BCDF22667_154602466 = (getDeclaredAnnotations(declaringClass, slot));
        return (Annotation[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getDeclaredAnnotations(declaringClass, slot);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:11.152 -0400", hash_original_method = "BD3C661F4197C5A0A0AE31F0699A32C5", hash_generated_method = "FF49EFB75248C7D88D6A9B1A64B1BD15")
    static Annotation[] getDeclaredAnnotations(Class<?> declaringClass, int slot) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return new Annotation[]{(Annotation)declaringClass.dsTaint};
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:11.160 -0400", hash_original_method = "C04F97610183E33B13FB9B4273375B6D", hash_generated_method = "5BE4CBD938070B1346E6A4D1E02DC341")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        dsTaint.addTaint(annotationType.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("annotationType == null");
        } //End block
        A var5916D8A05D9FACE17C9DF14466E6D186_2109579304 = (getAnnotation(declaringClass, slot, annotationType));
        return (A)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (annotationType == null) {
            //throw new NullPointerException("annotationType == null");
        //}
        //return getAnnotation(declaringClass, slot, annotationType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:11.167 -0400", hash_original_method = "C4BBAD45B2B34A1D1F18CA240E0A5303", hash_generated_method = "5B5FFDB35F0BD2CDC481D11AE71987FE")
    static <A extends Annotation> A getAnnotation(
            Class<?> declaringClass, int slot, Class<A> annotationType) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return (A)declaringClass.dsTaint;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:11.176 -0400", hash_original_method = "D8B142EB73E138FF5927E6AE1DAD56D2", hash_generated_method = "59827CF5D3FF5BFB0C3428B339202311")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(annotationType.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("annotationType == null");
        } //End block
        boolean varB3780DB5BBCCEE48C62CDF997A07D42D_893659058 = (isAnnotationPresent(declaringClass, slot, annotationType));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (annotationType == null) {
            //throw new NullPointerException("annotationType == null");
        //}
        //return isAnnotationPresent(declaringClass, slot, annotationType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:11.184 -0400", hash_original_method = "B27804BB128191FC86404E3EF5E631CD", hash_generated_method = "743D272366C2F0078C6564F4201E20EE")
    static boolean isAnnotationPresent(
            Class<?> declaringClass, int slot, Class<? extends Annotation> annotationType) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:11.186 -0400", hash_original_method = "A33FB39CB64C1B7C3BBB588CC3F72925", hash_generated_method = "8C7A6A57A598959B1606649CF15F688C")
    static Annotation[][] noAnnotations(int size) {
        Annotation[][] annotations = new Annotation[size][];
        for (int i = 0; i < size; i++) {
            annotations[i] = NO_ANNOTATIONS;
        }
        return annotations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:11.196 -0400", hash_original_method = "72FC508AEB582DBA9794440813C3A8B1", hash_generated_method = "868C346AC835C234F601B8B21B4C0E7A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Annotation[][] getParameterAnnotations() {
        Annotation[][] parameterAnnotations;
        parameterAnnotations = getParameterAnnotations(declaringClass, slot);
        {
            Annotation[][] varDD1873AE5C63322151A60A739AADDF06_1600474286 = (noAnnotations(parameterTypes.length));
        } //End block
        return (Annotation[][])dsTaint.getTaint();
        // ---------- Original Method ----------
        //Annotation[][] parameterAnnotations
                //= getParameterAnnotations(declaringClass, slot);
        //if (parameterAnnotations.length == 0) {
            //return noAnnotations(parameterTypes.length);
        //}
        //return parameterAnnotations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:11.203 -0400", hash_original_method = "902FB4D5FA928FFE2E97E0A201CE8947", hash_generated_method = "75BB9147FD7D7B56B48E2FD3F2EBCAAD")
    static Annotation[][] getParameterAnnotations(Class declaringClass, int slot) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return new Annotation[][]{new Annotation[]{(Annotation)declaringClass.dsTaint}};
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:11.207 -0400", hash_original_method = "47D8C519D80AD7FA8ACDBB9291AF9C1F", hash_generated_method = "595B2393D9F040D9777F24B473AABE70")
    @DSModeled(DSC.SAFE)
    public boolean isVarArgs() {
        int modifiers;
        modifiers = getMethodModifiers(declaringClass, slot);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int modifiers = getMethodModifiers(declaringClass, slot);
        //return (modifiers & Modifier.VARARGS) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:11.213 -0400", hash_original_method = "F604FBBB689DE54F8A9C0A1F2713AB23", hash_generated_method = "5D01036889A779A56EC36BA8CFB91A08")
    @DSModeled(DSC.SAFE)
    public boolean isBridge() {
        int modifiers;
        modifiers = getMethodModifiers(declaringClass, slot);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int modifiers = getMethodModifiers(declaringClass, slot);
        //return (modifiers & Modifier.BRIDGE) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:11.218 -0400", hash_original_method = "B698BCB06B0A737FF1A228493D2DEAD0", hash_generated_method = "B63728BE5E86CE54AB4FE0F4D5CA8CED")
    @DSModeled(DSC.SAFE)
    public boolean isSynthetic() {
        int modifiers;
        modifiers = getMethodModifiers(declaringClass, slot);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int modifiers = getMethodModifiers(declaringClass, slot);
        //return (modifiers & Modifier.SYNTHETIC) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:11.223 -0400", hash_original_method = "3DF570DF2B22E4E433BE61FA4A3252FF", hash_generated_method = "BC398F2AC54162E95FCDF72BC8E104F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getDefaultValue() {
        Object var644613182228D60E61B756314B353991_1715275639 = (getDefaultValue(declaringClass, slot));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getDefaultValue(declaringClass, slot);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:11.227 -0400", hash_original_method = "01EB45D9363E910A54E557C442527E6E", hash_generated_method = "B7510CCB2FEF7E5F6AFA81A61F1CB396")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Object getDefaultValue(Class declaringClass, int slot) {
        dsTaint.addTaint(declaringClass.dsTaint);
        dsTaint.addTaint(slot);
        return (Object)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:11.233 -0400", hash_original_method = "AF56E5F5402F800187126545ABE1F97F", hash_generated_method = "7DDF85C50D6EA2850A17FF0F89A7D0B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        boolean varA56EFC3BDF27A12659DE2CAD30DABBAC_1599858845 = (object instanceof Method && toString().equals(object.toString()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return object instanceof Method && toString().equals(object.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:11.238 -0400", hash_original_method = "747BEFE9985C4AF4EE3D5630B62185EA", hash_generated_method = "99880D4E2F357F2473F072C752026276")
    @DSModeled(DSC.SAFE)
    public Class<?> getDeclaringClass() {
        return (Class<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return declaringClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:11.249 -0400", hash_original_method = "0803D161ECCDE8E4916E8597C31C5EAF", hash_generated_method = "7F16457B1900300D72998C2062D6F94E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Class<?>[] getExceptionTypes() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Class<?>[] var8D1A1E052BC746D564CFE0CF254A767C_1233357104 = (exceptionTypes.clone());
        return (Class<?>[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (exceptionTypes == null) {
            //return EmptyArray.CLASS;
        //}
        //return exceptionTypes.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:11.255 -0400", hash_original_method = "D61CFE217686483C8FB69E9FFDF592A9", hash_generated_method = "8ACF053056F53BE723850D529B6C8D9D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getModifiers() {
        int varE3C3A4926E4A75C433C82B3799B27F5E_1537588927 = (getMethodModifiers(declaringClass, slot));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getMethodModifiers(declaringClass, slot);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:11.259 -0400", hash_original_method = "A31D200D598E943DCCCB394C8F8F3879", hash_generated_method = "FA541D89630401B9044BD9D41C539F57")
    static int getMethodModifiers(Class<?> declaringClass, int slot) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:11.264 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "F47755EA38582EE7C3877DD72123E9B0")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:11.275 -0400", hash_original_method = "860AC8CD4E2F5F390A65618A1941DEDE", hash_generated_method = "42C1A5D03202A1075A182960C7E30F0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Class<?>[] getParameterTypes() {
        Class<?>[] varA5D1C4B2BC221077E7A9B22F667CEDFE_1650025596 = (parameterTypes.clone());
        return (Class<?>[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return parameterTypes.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:11.282 -0400", hash_original_method = "952CC59854183D9751F85A9597A378CE", hash_generated_method = "B65C04E0BA698112A1BF3C3D88DC207D")
    @DSModeled(DSC.SAFE)
    public Class<?> getReturnType() {
        return (Class<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return returnType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:11.286 -0400", hash_original_method = "EF5D8B81A9E09E0C38DFC15BA422ECA1", hash_generated_method = "58B5DF4639BE5684385E21F6B57FECE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var8EF65A1839C36EED6A25646011513717_674474188 = (name.hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return name.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:11.299 -0400", hash_original_method = "4A7D773CBB2CABEB3FBD24437D2F9CE8", hash_generated_method = "11E9D9CB21D1A7535AC579A9649969AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object invoke(Object receiver, Object... args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        dsTaint.addTaint(receiver.dsTaint);
        dsTaint.addTaint(args[0].dsTaint);
        {
            args = EmptyArray.OBJECT;
        } //End block
        Object varE7AE536B195BF0A749EC2198B9CB2C6E_961607313 = (invokeNative(receiver, args, declaringClass, parameterTypes, returnType, slot, flag));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (args == null) {
            //args = EmptyArray.OBJECT;
        //}
        //return invokeNative(receiver, args, declaringClass, parameterTypes, returnType, slot, flag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:11.306 -0400", hash_original_method = "0E030E32F68EF389669F95D53DF2EFAB", hash_generated_method = "338C728B79F5630328919DCFF3C25C53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Object invokeNative(Object obj, Object[] args, Class<?> declaringClass,
            Class<?>[] parameterTypes, Class<?> returnType, int slot, boolean noAccessCheck) throws IllegalAccessException, IllegalArgumentException,
                            InvocationTargetException {
        dsTaint.addTaint(noAccessCheck);
        dsTaint.addTaint(declaringClass.dsTaint);
        dsTaint.addTaint(args[0].dsTaint);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(slot);
        dsTaint.addTaint(returnType.dsTaint);
        dsTaint.addTaint(parameterTypes[0].dsTaint);
        return (Object)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:11.319 -0400", hash_original_method = "20379CC138163D24505D982E1BF3267A", hash_generated_method = "D843CEF6B2CFB4498472038B6F26431F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder result;
        result = new StringBuilder(Modifier.toString(getModifiers()));
        {
            boolean varFD23457D7925EE9ADC9C1D678FE17210_125750852 = (result.length() != 0);
            result.append(' ');
        } //End collapsed parenthetic
        result.append(returnType.getName());
        result.append(' ');
        result.append(declaringClass.getName());
        result.append('.');
        result.append(name);
        result.append("(");
        result.append(toString(parameterTypes));
        result.append(")");
        {
            result.append(" throws ");
            result.append(toString(exceptionTypes));
        } //End block
        String varEA70154FDA28CC59402440C6317B57EF_1999862609 = (result.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder(Modifier.toString(getModifiers()));
        //if (result.length() != 0)
            //result.append(' ');
        //result.append(returnType.getName());
        //result.append(' ');
        //result.append(declaringClass.getName());
        //result.append('.');
        //result.append(name);
        //result.append("(");
        //result.append(toString(parameterTypes));
        //result.append(")");
        //if (exceptionTypes != null && exceptionTypes.length != 0) {
            //result.append(" throws ");
            //result.append(toString(exceptionTypes));
        //}
        //return result.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:11.328 -0400", hash_original_method = "C4F068AB884B2FBA426F9E4B4EB5335D", hash_generated_method = "9F18A0D76237B1596BB5822B41CB02E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unused")
    private String getSignature() {
        StringBuilder result;
        result = new StringBuilder();
        result.append('(');
        {
            int i;
            i = 0;
            {
                result.append(getSignature(parameterTypes[i]));
            } //End block
        } //End collapsed parenthetic
        result.append(')');
        result.append(getSignature(returnType));
        String varEA70154FDA28CC59402440C6317B57EF_866501102 = (result.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder();
        //result.append('(');
        //for (int i = 0; i < parameterTypes.length; i++) {
            //result.append(getSignature(parameterTypes[i]));
        //}
        //result.append(')');
        //result.append(getSignature(returnType));
        //return result.toString();
    }

    
}


