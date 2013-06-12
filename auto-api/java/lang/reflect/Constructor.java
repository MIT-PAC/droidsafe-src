package java.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.639 -0400", hash_original_method = "F22CB981733D75C2BC34BDB791B93657", hash_generated_method = "EFA84DA8CBF8DCF1FD7BF7100FC2FBE7")
    @DSModeled(DSC.SAFE)
    private Constructor() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.649 -0400", hash_original_method = "4E2CA9FC94A5B82D01ACB923AD24E02D", hash_generated_method = "8F32E58D532541E7D4EE27BD42DE8E27")
    @DSModeled(DSC.SAFE)
    private Constructor(Class<T> declaringClass, Class<?>[] ptypes, Class<?>[] extypes, int slot) {
        dsTaint.addTaint(declaringClass.dsTaint);
        dsTaint.addTaint(extypes[0].dsTaint);
        dsTaint.addTaint(slot);
        dsTaint.addTaint(ptypes[0].dsTaint);
        // ---------- Original Method ----------
        //this.declaringClass = declaringClass;
        //this.parameterTypes = ptypes;
        //this.exceptionTypes = extypes;
        //this.slot = slot;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.657 -0400", hash_original_method = "ED32915D16D10FD7E30E61397009B806", hash_generated_method = "2EB55B3AAF649892138CBA590882546B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.668 -0400", hash_original_method = "C62B79950C859BF71BE9288BB0AB9C37", hash_generated_method = "B849BB69629180B612F61E06EBEBB3B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     String getSignatureAttribute() {
        Object[] annotation;
        annotation = Method.getSignatureAnnotation(declaringClass, slot);
        String var33705CFE2485E284459211E6CFE410F3_1164541594 = (StringUtils.combineStrings(annotation));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //Object[] annotation = Method.getSignatureAnnotation(declaringClass, slot);
        //if (annotation == null) {
            //return null;
        //}
        //return StringUtils.combineStrings(annotation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.677 -0400", hash_original_method = "085B8CB42A6E3AC80C8A5E5B20AAB41A", hash_generated_method = "7FFDCD8080DCD122BBD0F3C4B734886D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TypeVariable<Constructor<T>>[] getTypeParameters() {
        initGenericTypes();
        TypeVariable<Constructor<T>>[] var5320BB572BA206FFFB06E56C5FAE64D5_356199991 = (formalTypeParameters.clone());
        return (TypeVariable<Constructor<T>>[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //initGenericTypes();
        //return formalTypeParameters.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.708 -0400", hash_original_method = "BD69A0542CEC9A8352D572DD82647C37", hash_generated_method = "CF3BA6925A6433DB5BB4A0E6BD2EB37A")
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
        String var806458D832AB974D230FEE4CBBDBD390_1914519522 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.718 -0400", hash_original_method = "A9CCE739D5419EE3EB1324AC76C431BA", hash_generated_method = "940A951AF33A778E02479BA47CB7C15A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Type[] getGenericParameterTypes() {
        initGenericTypes();
        Type[] varCE0399215D6C708DCB4E972B600A112D_1351893071 = (Types.getClonedTypeArray(genericParameterTypes));
        return (Type[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //initGenericTypes();
        //return Types.getClonedTypeArray(genericParameterTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.725 -0400", hash_original_method = "D98F12BC8A74E89DDBE36E53E80FD275", hash_generated_method = "A3D7218234E23C22F770FA3EE9DAD315")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Type[] getGenericExceptionTypes() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        initGenericTypes();
        Type[] var63B58D61A87E534F5FBD3F9F11DC7F51_1921311223 = (Types.getClonedTypeArray(genericExceptionTypes));
        return (Type[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //initGenericTypes();
        //return Types.getClonedTypeArray(genericExceptionTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.732 -0400", hash_original_method = "4F7DC07C64174CDAA43175ECC599103D", hash_generated_method = "B0D7B8D5D468E7ECF495F79CBB2CC389")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Annotation[] getDeclaredAnnotations() {
        Annotation[] varE1FE5D19F280F6E0CA998563ACD5980D_947272272 = (Method.getDeclaredAnnotations(declaringClass, slot));
        return (Annotation[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Method.getDeclaredAnnotations(declaringClass, slot);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.742 -0400", hash_original_method = "1A4BA94BF375F0F7A6512272530A6D39", hash_generated_method = "1C7ED0D8C44020A4FB54C3957248B8BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        dsTaint.addTaint(annotationType.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("annotationType == null");
        } //End block
        A varDAB8AB70D4B18B1281F1244E3DFE03F3_1323329625 = (Method.getAnnotation(declaringClass, slot, annotationType));
        return (A)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (annotationType == null) {
            //throw new NullPointerException("annotationType == null");
        //}
        //return Method.getAnnotation(declaringClass, slot, annotationType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.754 -0400", hash_original_method = "DC6811BC307F5F500FE8FCDF979C7822", hash_generated_method = "3090AC024BCDB4A73FB47E23F911C630")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(annotationType.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("annotationType == null");
        } //End block
        boolean varD013F130A4C3211BC042195803538972_1378663740 = (Method.isAnnotationPresent(declaringClass, slot, annotationType));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (annotationType == null) {
            //throw new NullPointerException("annotationType == null");
        //}
        //return Method.isAnnotationPresent(declaringClass, slot, annotationType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.761 -0400", hash_original_method = "15C5C292A9A80BF83F51CF39D22A468B", hash_generated_method = "35037F373841F3250CE4BA844DBEF492")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Annotation[][] getParameterAnnotations() {
        Annotation[][] parameterAnnotations;
        parameterAnnotations = Method.getParameterAnnotations(declaringClass, slot);
        {
            Annotation[][] var784CC79EEFF178B8A49D8504D98DF1A8_1923909794 = (Method.noAnnotations(parameterTypes.length));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.768 -0400", hash_original_method = "27084EEDAB7B32E40BFE6AC29F04C9B8", hash_generated_method = "BDFF9F2FD834B1A50C92FC694F5CEDC0")
    @DSModeled(DSC.SAFE)
    public boolean isVarArgs() {
        int mods;
        mods = Method.getMethodModifiers(declaringClass, slot);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int mods = Method.getMethodModifiers(declaringClass, slot);
        //return (mods & Modifier.VARARGS) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.774 -0400", hash_original_method = "98AC39075FB2CBC83E161E978A13C606", hash_generated_method = "650B0EE327B6DCF2EA573DB853A5D867")
    @DSModeled(DSC.SAFE)
    public boolean isSynthetic() {
        int mods;
        mods = Method.getMethodModifiers(declaringClass, slot);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int mods = Method.getMethodModifiers(declaringClass, slot);
        //return (mods & Modifier.SYNTHETIC) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.781 -0400", hash_original_method = "B30900BF5B4B7FDD7368A6CB9464E167", hash_generated_method = "CC53F48D7799858349BEC5175E3BE2FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        boolean varD99B2C8D408359C0C7A2340E6E527A6B_1234474566 = (object instanceof Constructor && toString().equals(object.toString()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return object instanceof Constructor && toString().equals(object.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.783 -0400", hash_original_method = "CE10C7360422171346CFCFE4390D0CD4", hash_generated_method = "221DC0CCECA65F16F3C5A2ADB29A350C")
    @DSModeled(DSC.SAFE)
    public Class<T> getDeclaringClass() {
        return (Class<T>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return declaringClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.788 -0400", hash_original_method = "0803D161ECCDE8E4916E8597C31C5EAF", hash_generated_method = "012EB7100DA1AE0455526BD53CAAF3F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Class<?>[] getExceptionTypes() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Class<?>[] var8D1A1E052BC746D564CFE0CF254A767C_1925084002 = (exceptionTypes.clone());
        return (Class<?>[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (exceptionTypes == null) {
            //return EmptyArray.CLASS;
        //}
        //return exceptionTypes.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.796 -0400", hash_original_method = "75F84F634C025C373FC5DFC6F2FEAE7E", hash_generated_method = "D254C8E7AAB5138227220045A7BF760F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getModifiers() {
        int var75977E01665708B1BE3D3E419FBDAB0D_964033184 = (Method.getMethodModifiers(declaringClass, slot));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Method.getMethodModifiers(declaringClass, slot);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.803 -0400", hash_original_method = "64DF6B8C865C11FF9D8C98657107C7C5", hash_generated_method = "71D8E973E42974917D79A549BE670CED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getName() {
        String var9F5D29DD29B137612BFCC319287D61E5_1612978281 = (declaringClass.getName());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return declaringClass.getName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.807 -0400", hash_original_method = "860AC8CD4E2F5F390A65618A1941DEDE", hash_generated_method = "401C13631C84313B7FBC2E20D47EFAE0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Class<?>[] getParameterTypes() {
        Class<?>[] varA5D1C4B2BC221077E7A9B22F667CEDFE_988720314 = (parameterTypes.clone());
        return (Class<?>[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return parameterTypes.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.818 -0400", hash_original_method = "70A1497759834DE033251D58FB1BC60F", hash_generated_method = "030F0E9C94086C6B08842F4450E998BC")
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
        String varEA70154FDA28CC59402440C6317B57EF_1445350061 = (result.toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.821 -0400", hash_original_method = "B8D03AB769FE0736E7C02030ACA8679C", hash_generated_method = "15F5191F00CBF68E7A56AED99E9D70C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var11BB0B014459668EF152ECE9A7A1751A_2054991529 = (declaringClass.getName().hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return declaringClass.getName().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.826 -0400", hash_original_method = "E7355AF509FB0F598B5C977468B592C4", hash_generated_method = "597B1EAD1C1203EDF7C389D50FF16477")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public T newInstance(Object... args) throws InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        dsTaint.addTaint(args[0].dsTaint);
        T varE841B5DC5620E36AEE9E60A8DDBE49DB_317915724 = (constructNative (args, declaringClass, parameterTypes, slot, flag));
        return (T)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return constructNative (args, declaringClass, parameterTypes, slot, flag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.833 -0400", hash_original_method = "847A043CD7E53CD248ABB6D5FEBEB21F", hash_generated_method = "6430F4DF6CBA9E090DFF900307B14CAC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private T constructNative(Object[] args, Class<T> declaringClass,
            Class<?>[] parameterTypes, int slot,
            boolean noAccessCheck) throws InstantiationException, IllegalAccessException,
            InvocationTargetException {
        dsTaint.addTaint(noAccessCheck);
        dsTaint.addTaint(declaringClass.dsTaint);
        dsTaint.addTaint(args[0].dsTaint);
        dsTaint.addTaint(slot);
        dsTaint.addTaint(parameterTypes[0].dsTaint);
        return (T)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:09.848 -0400", hash_original_method = "4738B09E6DE786765E7966DA89BB1975", hash_generated_method = "39EEB6585A755C52EDAA66C078F904A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder result;
        result = new StringBuilder(Modifier.toString(getModifiers()));
        {
            boolean varFD23457D7925EE9ADC9C1D678FE17210_232504928 = (result.length() != 0);
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
        String varEA70154FDA28CC59402440C6317B57EF_654922344 = (result.toString());
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


