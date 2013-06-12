package java.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.lang.annotation.Annotation;
import libcore.util.EmptyArray;
import org.apache.harmony.kernel.vm.StringUtils;
import org.apache.harmony.luni.lang.reflect.GenericSignatureParser;
import org.apache.harmony.luni.lang.reflect.ListOfTypes;
import org.apache.harmony.luni.lang.reflect.Types;

public final class Constructor<T> extends AccessibleObject implements GenericDeclaration, Member {
    Class<T> declaringClass;
    Class<?>[] parameterTypes;
    Class<?>[] exceptionTypes;
    ListOfTypes genericExceptionTypes;
    ListOfTypes genericParameterTypes;
    TypeVariable<Constructor<T>>[] formalTypeParameters;
    private volatile boolean genericTypesAreInitialized = false;
    int slot;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.820 -0400", hash_original_method = "F22CB981733D75C2BC34BDB791B93657", hash_generated_method = "EFA84DA8CBF8DCF1FD7BF7100FC2FBE7")
    @DSModeled(DSC.SAFE)
    private Constructor() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.820 -0400", hash_original_method = "4E2CA9FC94A5B82D01ACB923AD24E02D", hash_generated_method = "EA58377887638AD58FFA1015D29C0D4A")
    @DSModeled(DSC.SAFE)
    private Constructor(Class<T> declaringClass, Class<?>[] ptypes, Class<?>[] extypes, int slot) {
        dsTaint.addTaint(declaringClass.dsTaint);
        dsTaint.addTaint(extypes.dsTaint);
        dsTaint.addTaint(slot);
        dsTaint.addTaint(ptypes.dsTaint);
        // ---------- Original Method ----------
        //this.declaringClass = declaringClass;
        //this.parameterTypes = ptypes;
        //this.exceptionTypes = extypes;
        //this.slot = slot;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.821 -0400", hash_original_method = "ED32915D16D10FD7E30E61397009B806", hash_generated_method = "2EB55B3AAF649892138CBA590882546B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized void initGenericTypes() {
        {
            String signatureAttribute;
            signatureAttribute = getSignatureAttribute();
            GenericSignatureParser parser;
            parser = new GenericSignatureParser(
                    declaringClass.getClassLoader());
            parser.parseForConstructor(this, signatureAttribute, exceptionTypes);
            formalTypeParameters = parser.formalTypeParameters;
            genericParameterTypes = parser.parameterTypes;
            genericExceptionTypes = parser.exceptionTypes;
            genericTypesAreInitialized = true;
        } //End block
        // ---------- Original Method ----------
        //if (!genericTypesAreInitialized) {
            //String signatureAttribute = getSignatureAttribute();
            //GenericSignatureParser parser = new GenericSignatureParser(
                    //declaringClass.getClassLoader());
            //parser.parseForConstructor(this, signatureAttribute, exceptionTypes);
            //formalTypeParameters = parser.formalTypeParameters;
            //genericParameterTypes = parser.parameterTypes;
            //genericExceptionTypes = parser.exceptionTypes;
            //genericTypesAreInitialized = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.821 -0400", hash_original_method = "C62B79950C859BF71BE9288BB0AB9C37", hash_generated_method = "EF849AF8792B1C211BC6462B96979D93")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     String getSignatureAttribute() {
        Object[] annotation;
        annotation = Method.getSignatureAnnotation(declaringClass, slot);
        String var33705CFE2485E284459211E6CFE410F3_1183757247 = (StringUtils.combineStrings(annotation));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //Object[] annotation = Method.getSignatureAnnotation(declaringClass, slot);
        //if (annotation == null) {
            //return null;
        //}
        //return StringUtils.combineStrings(annotation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.821 -0400", hash_original_method = "085B8CB42A6E3AC80C8A5E5B20AAB41A", hash_generated_method = "073C841B826B8A9C364643B6BFC7FA72")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TypeVariable<Constructor<T>>[] getTypeParameters() {
        initGenericTypes();
        TypeVariable<Constructor<T>>[] var5320BB572BA206FFFB06E56C5FAE64D5_1309721778 = (formalTypeParameters.clone());
        return (TypeVariable<Constructor<T>>[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //initGenericTypes();
        //return formalTypeParameters.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.821 -0400", hash_original_method = "BD69A0542CEC9A8352D572DD82647C37", hash_generated_method = "D7DD8A3C7AA079FE6A9AF7BC0BE1AB34")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toGenericString() {
        StringBuilder sb;
        sb = new StringBuilder(80);
        initGenericTypes();
        int modifier;
        modifier = getModifiers();
        {
            sb.append(Modifier.toString(modifier & ~Modifier.VARARGS)).append(' ');
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
        appendArrayType(sb, getDeclaringClass());
        sb.append('(');
        appendArrayGenericType(sb,
                Types.getClonedTypeArray(genericParameterTypes));
        sb.append(')');
        Type[] genericExceptionTypeArray;
        genericExceptionTypeArray = Types.getClonedTypeArray(genericExceptionTypes);
        {
            sb.append(" throws ");
            appendArrayGenericType(sb, genericExceptionTypeArray);
        } //End block
        String var806458D832AB974D230FEE4CBBDBD390_2045490896 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.821 -0400", hash_original_method = "A9CCE739D5419EE3EB1324AC76C431BA", hash_generated_method = "8E70C6C69E4E70D5EABA7E4795DA842B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Type[] getGenericParameterTypes() {
        initGenericTypes();
        Type[] varCE0399215D6C708DCB4E972B600A112D_874076141 = (Types.getClonedTypeArray(genericParameterTypes));
        return (Type[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //initGenericTypes();
        //return Types.getClonedTypeArray(genericParameterTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.821 -0400", hash_original_method = "D98F12BC8A74E89DDBE36E53E80FD275", hash_generated_method = "052768652EEF8AE7F547EA37A34CD8A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Type[] getGenericExceptionTypes() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        initGenericTypes();
        Type[] var63B58D61A87E534F5FBD3F9F11DC7F51_2111463176 = (Types.getClonedTypeArray(genericExceptionTypes));
        return (Type[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //initGenericTypes();
        //return Types.getClonedTypeArray(genericExceptionTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.821 -0400", hash_original_method = "4F7DC07C64174CDAA43175ECC599103D", hash_generated_method = "B224DCC1CC7330D71229E117AAEF12AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Annotation[] getDeclaredAnnotations() {
        Annotation[] varE1FE5D19F280F6E0CA998563ACD5980D_1728963043 = (Method.getDeclaredAnnotations(declaringClass, slot));
        return (Annotation[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Method.getDeclaredAnnotations(declaringClass, slot);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.821 -0400", hash_original_method = "1A4BA94BF375F0F7A6512272530A6D39", hash_generated_method = "8CD01FCD340B717665621AA2E8E644BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        dsTaint.addTaint(annotationType.dsTaint);
        {
            throw new NullPointerException("annotationType == null");
        } //End block
        A varDAB8AB70D4B18B1281F1244E3DFE03F3_1427442995 = (Method.getAnnotation(declaringClass, slot, annotationType));
        return (A)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (annotationType == null) {
            //throw new NullPointerException("annotationType == null");
        //}
        //return Method.getAnnotation(declaringClass, slot, annotationType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.821 -0400", hash_original_method = "DC6811BC307F5F500FE8FCDF979C7822", hash_generated_method = "FFED48F982764E6439A6259572D42707")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(annotationType.dsTaint);
        {
            throw new NullPointerException("annotationType == null");
        } //End block
        boolean varD013F130A4C3211BC042195803538972_1740337648 = (Method.isAnnotationPresent(declaringClass, slot, annotationType));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (annotationType == null) {
            //throw new NullPointerException("annotationType == null");
        //}
        //return Method.isAnnotationPresent(declaringClass, slot, annotationType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.821 -0400", hash_original_method = "15C5C292A9A80BF83F51CF39D22A468B", hash_generated_method = "F7169C8798DC97F26F02CBA048C5F1D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Annotation[][] getParameterAnnotations() {
        Annotation[][] parameterAnnotations;
        parameterAnnotations = Method.getParameterAnnotations(declaringClass, slot);
        {
            Annotation[][] var784CC79EEFF178B8A49D8504D98DF1A8_1528394708 = (Method.noAnnotations(parameterTypes.length));
        } //End block
        return (Annotation[][])dsTaint.getTaint();
        // ---------- Original Method ----------
        //Annotation[][] parameterAnnotations
                //= Method.getParameterAnnotations(declaringClass, slot);
        //if (parameterAnnotations.length == 0) {
            //return Method.noAnnotations(parameterTypes.length);
        //}
        //return parameterAnnotations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.822 -0400", hash_original_method = "27084EEDAB7B32E40BFE6AC29F04C9B8", hash_generated_method = "BDFF9F2FD834B1A50C92FC694F5CEDC0")
    @DSModeled(DSC.SAFE)
    public boolean isVarArgs() {
        int mods;
        mods = Method.getMethodModifiers(declaringClass, slot);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int mods = Method.getMethodModifiers(declaringClass, slot);
        //return (mods & Modifier.VARARGS) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.822 -0400", hash_original_method = "98AC39075FB2CBC83E161E978A13C606", hash_generated_method = "650B0EE327B6DCF2EA573DB853A5D867")
    @DSModeled(DSC.SAFE)
    public boolean isSynthetic() {
        int mods;
        mods = Method.getMethodModifiers(declaringClass, slot);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int mods = Method.getMethodModifiers(declaringClass, slot);
        //return (mods & Modifier.SYNTHETIC) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.822 -0400", hash_original_method = "B30900BF5B4B7FDD7368A6CB9464E167", hash_generated_method = "640DBAA27021FB9EEF1F3BF4EEF38331")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        boolean varD99B2C8D408359C0C7A2340E6E527A6B_501628694 = (object instanceof Constructor && toString().equals(object.toString()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return object instanceof Constructor && toString().equals(object.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.822 -0400", hash_original_method = "CE10C7360422171346CFCFE4390D0CD4", hash_generated_method = "221DC0CCECA65F16F3C5A2ADB29A350C")
    @DSModeled(DSC.SAFE)
    public Class<T> getDeclaringClass() {
        return (Class<T>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return declaringClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.822 -0400", hash_original_method = "0803D161ECCDE8E4916E8597C31C5EAF", hash_generated_method = "ED05464A6BDB4E8ACD8A6A0CEB0C4708")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Class<?>[] getExceptionTypes() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Class<?>[] var8D1A1E052BC746D564CFE0CF254A767C_10681379 = (exceptionTypes.clone());
        return (Class<?>[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (exceptionTypes == null) {
            //return EmptyArray.CLASS;
        //}
        //return exceptionTypes.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.822 -0400", hash_original_method = "75F84F634C025C373FC5DFC6F2FEAE7E", hash_generated_method = "8445454A176BDC5F401F78838C6D3F26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getModifiers() {
        int var75977E01665708B1BE3D3E419FBDAB0D_1127121300 = (Method.getMethodModifiers(declaringClass, slot));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Method.getMethodModifiers(declaringClass, slot);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.822 -0400", hash_original_method = "64DF6B8C865C11FF9D8C98657107C7C5", hash_generated_method = "458E75514F2656E3FE3B791AA1DA135A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getName() {
        String var9F5D29DD29B137612BFCC319287D61E5_1507178269 = (declaringClass.getName());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return declaringClass.getName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.822 -0400", hash_original_method = "860AC8CD4E2F5F390A65618A1941DEDE", hash_generated_method = "81FE35A12EDF4BCC77228520F0FF97EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Class<?>[] getParameterTypes() {
        Class<?>[] varA5D1C4B2BC221077E7A9B22F667CEDFE_1322475508 = (parameterTypes.clone());
        return (Class<?>[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return parameterTypes.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.822 -0400", hash_original_method = "70A1497759834DE033251D58FB1BC60F", hash_generated_method = "540BE8743BD3B811241603E8AFBAC0A3")
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
        result.append(")V");
        String varEA70154FDA28CC59402440C6317B57EF_1203485980 = (result.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder();
        //result.append('(');
        //for (int i = 0; i < parameterTypes.length; i++) {
            //result.append(getSignature(parameterTypes[i]));
        //}
        //result.append(")V");
        //return result.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.822 -0400", hash_original_method = "B8D03AB769FE0736E7C02030ACA8679C", hash_generated_method = "632F3164F1A197667BE532B910E44494")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var11BB0B014459668EF152ECE9A7A1751A_2113216420 = (declaringClass.getName().hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return declaringClass.getName().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.822 -0400", hash_original_method = "E7355AF509FB0F598B5C977468B592C4", hash_generated_method = "7A535212447ECC7616A1B9D371178E1C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public T newInstance(Object... args) throws InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        dsTaint.addTaint(args.dsTaint);
        T varE841B5DC5620E36AEE9E60A8DDBE49DB_1635321045 = (constructNative (args, declaringClass, parameterTypes, slot, flag));
        return (T)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return constructNative (args, declaringClass, parameterTypes, slot, flag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.822 -0400", hash_original_method = "847A043CD7E53CD248ABB6D5FEBEB21F", hash_generated_method = "B240F20A73EA8C44BED4522A79F8D236")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private T constructNative(Object[] args, Class<T> declaringClass,
            Class<?>[] parameterTypes, int slot,
            boolean noAccessCheck) throws InstantiationException, IllegalAccessException,
            InvocationTargetException {
        dsTaint.addTaint(noAccessCheck);
        dsTaint.addTaint(declaringClass.dsTaint);
        dsTaint.addTaint(args.dsTaint);
        dsTaint.addTaint(slot);
        dsTaint.addTaint(parameterTypes.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.822 -0400", hash_original_method = "4738B09E6DE786765E7966DA89BB1975", hash_generated_method = "3EDFE90759784B476D42AC3E211E1DCF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder result;
        result = new StringBuilder(Modifier.toString(getModifiers()));
        {
            boolean varFD23457D7925EE9ADC9C1D678FE17210_576384612 = (result.length() != 0);
            result.append(' ');
        } //End collapsed parenthetic
        result.append(declaringClass.getName());
        result.append("(");
        result.append(toString(parameterTypes));
        result.append(")");
        {
            result.append(" throws ");
            result.append(toString(exceptionTypes));
        } //End block
        String varEA70154FDA28CC59402440C6317B57EF_1819892870 = (result.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder(Modifier.toString(getModifiers()));
        //if (result.length() != 0)
            //result.append(' ');
        //result.append(declaringClass.getName());
        //result.append("(");
        //result.append(toString(parameterTypes));
        //result.append(")");
        //if (exceptionTypes != null && exceptionTypes.length != 0) {
            //result.append(" throws ");
            //result.append(toString(exceptionTypes));
        //}
        //return result.toString();
    }

    
}


