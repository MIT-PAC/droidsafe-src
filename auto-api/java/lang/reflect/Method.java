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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.950 -0400", hash_original_method = "70F1F77231BFE73E3138A8A58A15C35C", hash_generated_method = "4AC9062F2BA661D1CC1A4961E42A79E6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.951 -0400", hash_original_method = "F4B9C750B34D03AFED72DBA84048C99D", hash_generated_method = "1204BDD38380C5F842667BFDF47DF812")
    @DSModeled(DSC.SAFE)
    private Method(Class<?> declaring, Class<?>[] paramTypes, Class<?>[] exceptTypes, Class<?> returnType, String name, int slot) {
        dsTaint.addTaint(exceptTypes[0].dsTaint);
        dsTaint.addTaint(name);
        dsTaint.addTaint(declaring.dsTaint);
        dsTaint.addTaint(slot);
        dsTaint.addTaint(paramTypes[0].dsTaint);
        dsTaint.addTaint(returnType.dsTaint);
        // ---------- Original Method ----------
        //this.declaringClass = declaring;
        //this.name = name;
        //this.slot = slot;
        //this.parameterTypes = paramTypes;
        //this.exceptionTypes = exceptTypes;
        //this.returnType = returnType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.953 -0400", hash_original_method = "0BE83C703D137B5A5A60EFAA17178485", hash_generated_method = "E8F805B2A3FE8E9F2FC17CEAF704CF1B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.953 -0400", hash_original_method = "0F068F731FE610BBACFD836E6A61AACF", hash_generated_method = "1C1E063EC8DE364F454AF26D5ACA6357")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TypeVariable<Method>[] getTypeParameters() {
        initGenericTypes();
        TypeVariable<Method>[] var5320BB572BA206FFFB06E56C5FAE64D5_169106032 = (formalTypeParameters.clone());
        return (TypeVariable<Method>[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //initGenericTypes();
        //return formalTypeParameters.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.954 -0400", hash_original_method = "1CDF5107AC443AA5F8C2E1DA9DF559A0", hash_generated_method = "AF97A32335BFD7FC9E618F13A887C031")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     String getSignatureAttribute() {
        Object[] annotation;
        annotation = getSignatureAnnotation(declaringClass, slot);
        String var33705CFE2485E284459211E6CFE410F3_1375390365 = (StringUtils.combineStrings(annotation));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //Object[] annotation = getSignatureAnnotation(declaringClass, slot);
        //if (annotation == null) {
            //return null;
        //}
        //return StringUtils.combineStrings(annotation);
    }

    
        static Object[] getSignatureAnnotation(Class declaringClass, int slot) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.955 -0400", hash_original_method = "060018D8556E7858267AA04DC5F84FE8", hash_generated_method = "795E3AE5BF3CDAACBF19DD955A9885C8")
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
        String var806458D832AB974D230FEE4CBBDBD390_1295948665 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.956 -0400", hash_original_method = "A9CCE739D5419EE3EB1324AC76C431BA", hash_generated_method = "F69D2EE2C99EE918B28F29239816FBFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Type[] getGenericParameterTypes() {
        initGenericTypes();
        Type[] varCE0399215D6C708DCB4E972B600A112D_1464805587 = (Types.getClonedTypeArray(genericParameterTypes));
        return (Type[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //initGenericTypes();
        //return Types.getClonedTypeArray(genericParameterTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.956 -0400", hash_original_method = "D98F12BC8A74E89DDBE36E53E80FD275", hash_generated_method = "DAEB80F3300148A01D90A83076B3C18F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Type[] getGenericExceptionTypes() {
        initGenericTypes();
        Type[] var63B58D61A87E534F5FBD3F9F11DC7F51_1848030052 = (Types.getClonedTypeArray(genericExceptionTypes));
        return (Type[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //initGenericTypes();
        //return Types.getClonedTypeArray(genericExceptionTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.956 -0400", hash_original_method = "83125796E1541F4C47F8F2176AE50053", hash_generated_method = "750946E51366797086B0649C01B9114F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Type getGenericReturnType() {
        initGenericTypes();
        Type var62E8E372FB8C7B45C55EECB285EDD7EA_1112211325 = (Types.getType(genericReturnType));
        return (Type)dsTaint.getTaint();
        // ---------- Original Method ----------
        //initGenericTypes();
        //return Types.getType(genericReturnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.957 -0400", hash_original_method = "4122EC91CDDE6FFD9DA08F5ADAF8DB5D", hash_generated_method = "6B9E9F0993DEE22DFF6011928CA40077")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Annotation[] getDeclaredAnnotations() {
        Annotation[] varC17A9D109C2F23B123FCE14BCDF22667_586199815 = (getDeclaredAnnotations(declaringClass, slot));
        return (Annotation[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getDeclaredAnnotations(declaringClass, slot);
    }

    
        static Annotation[] getDeclaredAnnotations(Class<?> declaringClass, int slot) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.957 -0400", hash_original_method = "C04F97610183E33B13FB9B4273375B6D", hash_generated_method = "16EE8B99927BA440A82920782B2DBB6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        dsTaint.addTaint(annotationType.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("annotationType == null");
        } //End block
        A var5916D8A05D9FACE17C9DF14466E6D186_1901820790 = (getAnnotation(declaringClass, slot, annotationType));
        return (A)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (annotationType == null) {
            //throw new NullPointerException("annotationType == null");
        //}
        //return getAnnotation(declaringClass, slot, annotationType);
    }

    
        static <A extends Annotation> A getAnnotation(
            Class<?> declaringClass, int slot, Class<A> annotationType) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.958 -0400", hash_original_method = "D8B142EB73E138FF5927E6AE1DAD56D2", hash_generated_method = "E7C70AE2CDDE29C93E6A0126D564D4D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        dsTaint.addTaint(annotationType.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("annotationType == null");
        } //End block
        boolean varB3780DB5BBCCEE48C62CDF997A07D42D_1394317204 = (isAnnotationPresent(declaringClass, slot, annotationType));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (annotationType == null) {
            //throw new NullPointerException("annotationType == null");
        //}
        //return isAnnotationPresent(declaringClass, slot, annotationType);
    }

    
        static boolean isAnnotationPresent(
            Class<?> declaringClass, int slot, Class<? extends Annotation> annotationType) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        static Annotation[][] noAnnotations(int size) {
        Annotation[][] annotations = new Annotation[size][];
        for (int i = 0; i < size; i++) {
            annotations[i] = NO_ANNOTATIONS;
        }
        return annotations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.959 -0400", hash_original_method = "72FC508AEB582DBA9794440813C3A8B1", hash_generated_method = "6896714F48996FFCB708D1DC153C6361")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Annotation[][] getParameterAnnotations() {
        Annotation[][] parameterAnnotations;
        parameterAnnotations = getParameterAnnotations(declaringClass, slot);
        {
            Annotation[][] varDD1873AE5C63322151A60A739AADDF06_1552314118 = (noAnnotations(parameterTypes.length));
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

    
        static Annotation[][] getParameterAnnotations(Class declaringClass, int slot) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.960 -0400", hash_original_method = "47D8C519D80AD7FA8ACDBB9291AF9C1F", hash_generated_method = "FAD4C6687D9E04A7DD09B5ED1DFE86CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isVarArgs() {
        int modifiers;
        modifiers = getMethodModifiers(declaringClass, slot);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int modifiers = getMethodModifiers(declaringClass, slot);
        //return (modifiers & Modifier.VARARGS) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.960 -0400", hash_original_method = "F604FBBB689DE54F8A9C0A1F2713AB23", hash_generated_method = "BC0F5BD3E41442CC9F1D1362995809E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isBridge() {
        int modifiers;
        modifiers = getMethodModifiers(declaringClass, slot);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int modifiers = getMethodModifiers(declaringClass, slot);
        //return (modifiers & Modifier.BRIDGE) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.961 -0400", hash_original_method = "B698BCB06B0A737FF1A228493D2DEAD0", hash_generated_method = "8EBAE68C01CC813510DA71A789A3D078")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isSynthetic() {
        int modifiers;
        modifiers = getMethodModifiers(declaringClass, slot);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int modifiers = getMethodModifiers(declaringClass, slot);
        //return (modifiers & Modifier.SYNTHETIC) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.961 -0400", hash_original_method = "3DF570DF2B22E4E433BE61FA4A3252FF", hash_generated_method = "33DAAB66E021A8FFFDC36B8D4B00AD66")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getDefaultValue() {
        Object var644613182228D60E61B756314B353991_241361739 = (getDefaultValue(declaringClass, slot));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getDefaultValue(declaringClass, slot);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.961 -0400", hash_original_method = "01EB45D9363E910A54E557C442527E6E", hash_generated_method = "DF42206C8FCAA956369DB4CE0D2E6A38")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Object getDefaultValue(Class declaringClass, int slot) {
        dsTaint.addTaint(declaringClass.dsTaint);
        dsTaint.addTaint(slot);
        return (Object)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.962 -0400", hash_original_method = "AF56E5F5402F800187126545ABE1F97F", hash_generated_method = "AF894AE9FC794D4F25CA81E45E8CF387")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        boolean varA56EFC3BDF27A12659DE2CAD30DABBAC_765601397 = (object instanceof Method && toString().equals(object.toString()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return object instanceof Method && toString().equals(object.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.962 -0400", hash_original_method = "747BEFE9985C4AF4EE3D5630B62185EA", hash_generated_method = "3640F7B34AFA7FCA661FE004002AD79B")
    @DSModeled(DSC.SAFE)
    public Class<?> getDeclaringClass() {
        return (Class<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return declaringClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.964 -0400", hash_original_method = "0803D161ECCDE8E4916E8597C31C5EAF", hash_generated_method = "3EAEA7EBF5057E80D7BC9DBF4C75B15F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Class<?>[] getExceptionTypes() {
        Class<?>[] var8D1A1E052BC746D564CFE0CF254A767C_355240938 = (exceptionTypes.clone());
        return (Class<?>[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (exceptionTypes == null) {
            //return EmptyArray.CLASS;
        //}
        //return exceptionTypes.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.965 -0400", hash_original_method = "D61CFE217686483C8FB69E9FFDF592A9", hash_generated_method = "EB214C26AA480E83F0BD497F12AC1DA1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getModifiers() {
        int varE3C3A4926E4A75C433C82B3799B27F5E_86459653 = (getMethodModifiers(declaringClass, slot));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getMethodModifiers(declaringClass, slot);
    }

    
        static int getMethodModifiers(Class<?> declaringClass, int slot) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.966 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "3573899E99121C9CFE87F9DDAEE36810")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.966 -0400", hash_original_method = "860AC8CD4E2F5F390A65618A1941DEDE", hash_generated_method = "743C907D397BC603FCDEB50164DF75C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Class<?>[] getParameterTypes() {
        Class<?>[] varA5D1C4B2BC221077E7A9B22F667CEDFE_2086350344 = (parameterTypes.clone());
        return (Class<?>[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return parameterTypes.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.966 -0400", hash_original_method = "952CC59854183D9751F85A9597A378CE", hash_generated_method = "A1C54CF5B85F22A528B808859CAD58B6")
    @DSModeled(DSC.SAFE)
    public Class<?> getReturnType() {
        return (Class<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return returnType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.967 -0400", hash_original_method = "EF5D8B81A9E09E0C38DFC15BA422ECA1", hash_generated_method = "B874CF84695B8BCE87327E305CC830CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var8EF65A1839C36EED6A25646011513717_316623312 = (name.hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return name.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.967 -0400", hash_original_method = "4A7D773CBB2CABEB3FBD24437D2F9CE8", hash_generated_method = "B0880FD5E2193E90DC3F2BDEDB25937E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object invoke(Object receiver, Object... args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        dsTaint.addTaint(receiver.dsTaint);
        dsTaint.addTaint(args[0].dsTaint);
        {
            args = EmptyArray.OBJECT;
        } //End block
        Object varE7AE536B195BF0A749EC2198B9CB2C6E_1276700385 = (invokeNative(receiver, args, declaringClass, parameterTypes, returnType, slot, flag));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (args == null) {
            //args = EmptyArray.OBJECT;
        //}
        //return invokeNative(receiver, args, declaringClass, parameterTypes, returnType, slot, flag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.967 -0400", hash_original_method = "0E030E32F68EF389669F95D53DF2EFAB", hash_generated_method = "66EC1DF8CD8BA9E9628E4A1FE4F53F9D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.968 -0400", hash_original_method = "20379CC138163D24505D982E1BF3267A", hash_generated_method = "4DE1A407E59F77ACAE5D48A8DE4B5CB9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder result;
        result = new StringBuilder(Modifier.toString(getModifiers()));
        {
            boolean varFD23457D7925EE9ADC9C1D678FE17210_2126195988 = (result.length() != 0);
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
        String varEA70154FDA28CC59402440C6317B57EF_1129878547 = (result.toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.969 -0400", hash_original_method = "C4F068AB884B2FBA426F9E4B4EB5335D", hash_generated_method = "AC27981ED042A0F062155B16AA84DC31")
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
        String varEA70154FDA28CC59402440C6317B57EF_1854669064 = (result.toString());
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

    
    public static final Comparator<Method> ORDER_BY_SIGNATURE = new Comparator<Method>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.970 -0400", hash_original_method = "BE88CC170A38DCD3E91DA840E3F7F4E0", hash_generated_method = "41313214471CA882AC857B824D97741B")
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
            int varD82080CC8BE1D0175ED867E01D1CD16B_1748690940 = (a.getReturnType().getName().compareTo(b.getReturnType().getName()));
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
    private static final Annotation[] NO_ANNOTATIONS = new Annotation[0];
}

