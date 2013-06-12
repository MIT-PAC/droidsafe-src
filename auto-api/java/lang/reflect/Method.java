package java.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.859 -0400", hash_original_method = "BE88CC170A38DCD3E91DA840E3F7F4E0", hash_generated_method = "643D5A595538F5209188F61EF582ABEB")
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
            int varD82080CC8BE1D0175ED867E01D1CD16B_1847204653 = (a.getReturnType().getName().compareTo(b.getReturnType().getName()));
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
    private static final Annotation[] NO_ANNOTATIONS = new Annotation[0];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.859 -0400", hash_original_method = "70F1F77231BFE73E3138A8A58A15C35C", hash_generated_method = "E408100225D95A6DF62A24952ED18ECA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.859 -0400", hash_original_method = "F4B9C750B34D03AFED72DBA84048C99D", hash_generated_method = "75D6542C47C725BB47FD778EA4D63790")
    @DSModeled(DSC.SAFE)
    private Method(Class<?> declaring, Class<?>[] paramTypes, Class<?>[] exceptTypes, Class<?> returnType, String name, int slot) {
        dsTaint.addTaint(exceptTypes.dsTaint);
        dsTaint.addTaint(name);
        dsTaint.addTaint(declaring.dsTaint);
        dsTaint.addTaint(paramTypes.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.859 -0400", hash_original_method = "0BE83C703D137B5A5A60EFAA17178485", hash_generated_method = "2E6602FB9B8F757AAC6EA0C750B3F508")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.859 -0400", hash_original_method = "0F068F731FE610BBACFD836E6A61AACF", hash_generated_method = "D9F2DCAA13968667FDB627D24BBCD70D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TypeVariable<Method>[] getTypeParameters() {
        initGenericTypes();
        TypeVariable<Method>[] var5320BB572BA206FFFB06E56C5FAE64D5_232569608 = (formalTypeParameters.clone());
        return (TypeVariable<Method>[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //initGenericTypes();
        //return formalTypeParameters.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.859 -0400", hash_original_method = "1CDF5107AC443AA5F8C2E1DA9DF559A0", hash_generated_method = "92BAB093344E587B3035AD81F8F18C45")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     String getSignatureAttribute() {
        Object[] annotation;
        annotation = getSignatureAnnotation(declaringClass, slot);
        String var33705CFE2485E284459211E6CFE410F3_1913969800 = (StringUtils.combineStrings(annotation));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //Object[] annotation = getSignatureAnnotation(declaringClass, slot);
        //if (annotation == null) {
            //return null;
        //}
        //return StringUtils.combineStrings(annotation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.859 -0400", hash_original_method = "5161131687230E0D7EE89383FDDF9117", hash_generated_method = "C86FF5AA7B792DD7103D0965CACD1AC0")
    static Object[] getSignatureAnnotation(Class declaringClass, int slot) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.860 -0400", hash_original_method = "060018D8556E7858267AA04DC5F84FE8", hash_generated_method = "787B5D90AC0A8E290176E8AECB6C5D99")
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
        String var806458D832AB974D230FEE4CBBDBD390_580234625 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.860 -0400", hash_original_method = "A9CCE739D5419EE3EB1324AC76C431BA", hash_generated_method = "415D6DC2BAD3F378443FC4B549BA97CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Type[] getGenericParameterTypes() {
        initGenericTypes();
        Type[] varCE0399215D6C708DCB4E972B600A112D_616460267 = (Types.getClonedTypeArray(genericParameterTypes));
        return (Type[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //initGenericTypes();
        //return Types.getClonedTypeArray(genericParameterTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.860 -0400", hash_original_method = "D98F12BC8A74E89DDBE36E53E80FD275", hash_generated_method = "AC95E48EDE086A0F45D9F54A0B40C406")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Type[] getGenericExceptionTypes() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        initGenericTypes();
        Type[] var63B58D61A87E534F5FBD3F9F11DC7F51_1128072332 = (Types.getClonedTypeArray(genericExceptionTypes));
        return (Type[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //initGenericTypes();
        //return Types.getClonedTypeArray(genericExceptionTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.860 -0400", hash_original_method = "83125796E1541F4C47F8F2176AE50053", hash_generated_method = "9394E546C3A4EEF13D7401F5DC8CD244")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Type getGenericReturnType() {
        initGenericTypes();
        Type var62E8E372FB8C7B45C55EECB285EDD7EA_740318303 = (Types.getType(genericReturnType));
        return (Type)dsTaint.getTaint();
        // ---------- Original Method ----------
        //initGenericTypes();
        //return Types.getType(genericReturnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.860 -0400", hash_original_method = "4122EC91CDDE6FFD9DA08F5ADAF8DB5D", hash_generated_method = "76CB015679956E09C37594E1610D38E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Annotation[] getDeclaredAnnotations() {
        Annotation[] varC17A9D109C2F23B123FCE14BCDF22667_169043195 = (getDeclaredAnnotations(declaringClass, slot));
        return (Annotation[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getDeclaredAnnotations(declaringClass, slot);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.860 -0400", hash_original_method = "BD3C661F4197C5A0A0AE31F0699A32C5", hash_generated_method = "FF49EFB75248C7D88D6A9B1A64B1BD15")
    static Annotation[] getDeclaredAnnotations(Class<?> declaringClass, int slot) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.860 -0400", hash_original_method = "C04F97610183E33B13FB9B4273375B6D", hash_generated_method = "2C2C06A5829D2F716A111CA67C595C0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        dsTaint.addTaint(annotationType.dsTaint);
        {
            throw new NullPointerException("annotationType == null");
        } //End block
        A var5916D8A05D9FACE17C9DF14466E6D186_1528583553 = (getAnnotation(declaringClass, slot, annotationType));
        return (A)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (annotationType == null) {
            //throw new NullPointerException("annotationType == null");
        //}
        //return getAnnotation(declaringClass, slot, annotationType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.860 -0400", hash_original_method = "C4BBAD45B2B34A1D1F18CA240E0A5303", hash_generated_method = "5B5FFDB35F0BD2CDC481D11AE71987FE")
    static <A extends Annotation> A getAnnotation(
            Class<?> declaringClass, int slot, Class<A> annotationType) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.860 -0400", hash_original_method = "D8B142EB73E138FF5927E6AE1DAD56D2", hash_generated_method = "43014F0CFE997DDA66742D790AAEB7D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(annotationType.dsTaint);
        {
            throw new NullPointerException("annotationType == null");
        } //End block
        boolean varB3780DB5BBCCEE48C62CDF997A07D42D_531111587 = (isAnnotationPresent(declaringClass, slot, annotationType));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (annotationType == null) {
            //throw new NullPointerException("annotationType == null");
        //}
        //return isAnnotationPresent(declaringClass, slot, annotationType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.860 -0400", hash_original_method = "B27804BB128191FC86404E3EF5E631CD", hash_generated_method = "7CA93D2585988926EEE893E6591517A0")
    static boolean isAnnotationPresent(
            Class<?> declaringClass, int slot, Class<? extends Annotation> annotationType) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
        //DSFIXME:  CODE0009: Possible callback target function detected
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.860 -0400", hash_original_method = "A33FB39CB64C1B7C3BBB588CC3F72925", hash_generated_method = "8C7A6A57A598959B1606649CF15F688C")
    static Annotation[][] noAnnotations(int size) {
        Annotation[][] annotations = new Annotation[size][];
        for (int i = 0; i < size; i++) {
            annotations[i] = NO_ANNOTATIONS;
        }
        return annotations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.860 -0400", hash_original_method = "72FC508AEB582DBA9794440813C3A8B1", hash_generated_method = "455D5AEB878B2021512612233A4F598F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Annotation[][] getParameterAnnotations() {
        Annotation[][] parameterAnnotations;
        parameterAnnotations = getParameterAnnotations(declaringClass, slot);
        {
            Annotation[][] varDD1873AE5C63322151A60A739AADDF06_1739555439 = (noAnnotations(parameterTypes.length));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.860 -0400", hash_original_method = "902FB4D5FA928FFE2E97E0A201CE8947", hash_generated_method = "75BB9147FD7D7B56B48E2FD3F2EBCAAD")
    static Annotation[][] getParameterAnnotations(Class declaringClass, int slot) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.860 -0400", hash_original_method = "47D8C519D80AD7FA8ACDBB9291AF9C1F", hash_generated_method = "595B2393D9F040D9777F24B473AABE70")
    @DSModeled(DSC.SAFE)
    public boolean isVarArgs() {
        int modifiers;
        modifiers = getMethodModifiers(declaringClass, slot);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int modifiers = getMethodModifiers(declaringClass, slot);
        //return (modifiers & Modifier.VARARGS) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.861 -0400", hash_original_method = "F604FBBB689DE54F8A9C0A1F2713AB23", hash_generated_method = "5D01036889A779A56EC36BA8CFB91A08")
    @DSModeled(DSC.SAFE)
    public boolean isBridge() {
        int modifiers;
        modifiers = getMethodModifiers(declaringClass, slot);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int modifiers = getMethodModifiers(declaringClass, slot);
        //return (modifiers & Modifier.BRIDGE) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.861 -0400", hash_original_method = "B698BCB06B0A737FF1A228493D2DEAD0", hash_generated_method = "B63728BE5E86CE54AB4FE0F4D5CA8CED")
    @DSModeled(DSC.SAFE)
    public boolean isSynthetic() {
        int modifiers;
        modifiers = getMethodModifiers(declaringClass, slot);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int modifiers = getMethodModifiers(declaringClass, slot);
        //return (modifiers & Modifier.SYNTHETIC) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.861 -0400", hash_original_method = "3DF570DF2B22E4E433BE61FA4A3252FF", hash_generated_method = "3DF848A9DC12F73B4698063F0FF0984C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getDefaultValue() {
        Object var644613182228D60E61B756314B353991_1168542206 = (getDefaultValue(declaringClass, slot));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getDefaultValue(declaringClass, slot);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.861 -0400", hash_original_method = "01EB45D9363E910A54E557C442527E6E", hash_generated_method = "41080BC2D073C79F571B45F2C797BBAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Object getDefaultValue(Class declaringClass, int slot) {
        dsTaint.addTaint(declaringClass.dsTaint);
        dsTaint.addTaint(slot);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.861 -0400", hash_original_method = "AF56E5F5402F800187126545ABE1F97F", hash_generated_method = "F6483E2D75AFC8EAF84D52A04C6000EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        boolean varA56EFC3BDF27A12659DE2CAD30DABBAC_632728389 = (object instanceof Method && toString().equals(object.toString()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return object instanceof Method && toString().equals(object.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.861 -0400", hash_original_method = "747BEFE9985C4AF4EE3D5630B62185EA", hash_generated_method = "99880D4E2F357F2473F072C752026276")
    @DSModeled(DSC.SAFE)
    public Class<?> getDeclaringClass() {
        return (Class<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return declaringClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.861 -0400", hash_original_method = "0803D161ECCDE8E4916E8597C31C5EAF", hash_generated_method = "4E7825564EF1A76A5F8693543BBCD013")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Class<?>[] getExceptionTypes() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Class<?>[] var8D1A1E052BC746D564CFE0CF254A767C_548056588 = (exceptionTypes.clone());
        return (Class<?>[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (exceptionTypes == null) {
            //return EmptyArray.CLASS;
        //}
        //return exceptionTypes.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.861 -0400", hash_original_method = "D61CFE217686483C8FB69E9FFDF592A9", hash_generated_method = "E6F85F9E9AB88700E6D6301D09C9110F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getModifiers() {
        int varE3C3A4926E4A75C433C82B3799B27F5E_379507840 = (getMethodModifiers(declaringClass, slot));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getMethodModifiers(declaringClass, slot);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.861 -0400", hash_original_method = "A31D200D598E943DCCCB394C8F8F3879", hash_generated_method = "4DE0C99AF3DF040FC5EEEC165C69A477")
    static int getMethodModifiers(Class<?> declaringClass, int slot) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.861 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "F47755EA38582EE7C3877DD72123E9B0")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.861 -0400", hash_original_method = "860AC8CD4E2F5F390A65618A1941DEDE", hash_generated_method = "857F42B664987FD321194EFA8AE495DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Class<?>[] getParameterTypes() {
        Class<?>[] varA5D1C4B2BC221077E7A9B22F667CEDFE_1047226631 = (parameterTypes.clone());
        return (Class<?>[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return parameterTypes.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.861 -0400", hash_original_method = "952CC59854183D9751F85A9597A378CE", hash_generated_method = "B65C04E0BA698112A1BF3C3D88DC207D")
    @DSModeled(DSC.SAFE)
    public Class<?> getReturnType() {
        return (Class<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return returnType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.861 -0400", hash_original_method = "EF5D8B81A9E09E0C38DFC15BA422ECA1", hash_generated_method = "D1C208C113287D5F9A3F4465B3B55A7B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var8EF65A1839C36EED6A25646011513717_2137204730 = (name.hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return name.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.861 -0400", hash_original_method = "4A7D773CBB2CABEB3FBD24437D2F9CE8", hash_generated_method = "9567CC9B35B6747358EFED85C08742CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object invoke(Object receiver, Object... args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        dsTaint.addTaint(receiver.dsTaint);
        dsTaint.addTaint(args.dsTaint);
        {
            args = EmptyArray.OBJECT;
        } //End block
        Object varE7AE536B195BF0A749EC2198B9CB2C6E_699835257 = (invokeNative(receiver, args, declaringClass, parameterTypes, returnType, slot, flag));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (args == null) {
            //args = EmptyArray.OBJECT;
        //}
        //return invokeNative(receiver, args, declaringClass, parameterTypes, returnType, slot, flag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.861 -0400", hash_original_method = "0E030E32F68EF389669F95D53DF2EFAB", hash_generated_method = "A47FC248B0D1BD53FD5C15DB4B80CFB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Object invokeNative(Object obj, Object[] args, Class<?> declaringClass,
            Class<?>[] parameterTypes, Class<?> returnType, int slot, boolean noAccessCheck) throws IllegalAccessException, IllegalArgumentException,
                            InvocationTargetException {
        dsTaint.addTaint(noAccessCheck);
        dsTaint.addTaint(declaringClass.dsTaint);
        dsTaint.addTaint(args.dsTaint);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(slot);
        dsTaint.addTaint(returnType.dsTaint);
        dsTaint.addTaint(parameterTypes.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.861 -0400", hash_original_method = "20379CC138163D24505D982E1BF3267A", hash_generated_method = "01275DA03B646BD2F21C9C40BF0C14C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder result;
        result = new StringBuilder(Modifier.toString(getModifiers()));
        {
            boolean varFD23457D7925EE9ADC9C1D678FE17210_1549313948 = (result.length() != 0);
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
        String varEA70154FDA28CC59402440C6317B57EF_187870066 = (result.toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.862 -0400", hash_original_method = "C4F068AB884B2FBA426F9E4B4EB5335D", hash_generated_method = "8CA5C14A8486C410E2E3CB62B1B39D6A")
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
        String varEA70154FDA28CC59402440C6317B57EF_1470691927 = (result.toString());
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


