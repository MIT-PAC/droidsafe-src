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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.323 -0400", hash_original_field = "5E97994ED38A2B2F984F3B2B75012BF8", hash_generated_field = "6B06F56F1EB868ADA8CFFD63973A7E09")

    private int slot;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.323 -0400", hash_original_field = "02CBE457FB1B22631E594CE79672D2F1", hash_generated_field = "EC96049C106D95C970CBF94E8CE21744")

    private Class<?> declaringClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.323 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.323 -0400", hash_original_field = "11427856321C6E9F5321CA879704C8FE", hash_generated_field = "2BEA8A3EFDFBD76D3A4CCA6C3AC7E53C")

    private Class<?>[] parameterTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.323 -0400", hash_original_field = "2CD56E5B83C33F80B2D25820C51596A0", hash_generated_field = "2A0AC8F9632DF82B378D2F01BC74BDF4")

    private Class<?>[] exceptionTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.323 -0400", hash_original_field = "9CD6843F4536590CD86F933708C7371E", hash_generated_field = "052C26419A9A6CDFB48BC17097CACAE9")

    private Class<?> returnType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.323 -0400", hash_original_field = "6BB2E1AD8EE7DCCA935DA6ACF3D7474E", hash_generated_field = "924C48D07F65387E616D3CE31DE5954D")

    private ListOfTypes genericExceptionTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.323 -0400", hash_original_field = "175F1F0CE81CA486282E77D84F1E1386", hash_generated_field = "4E98B7DC70F3037D11B527C2E4899BBD")

    private ListOfTypes genericParameterTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.323 -0400", hash_original_field = "40B35D47678E42F2607E0F522DC3BF6F", hash_generated_field = "32E37E22BB1C76784903951645BC45C1")

    private Type genericReturnType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.323 -0400", hash_original_field = "898BB6A86E0DA433332CBC4F55D3E967", hash_generated_field = "4338B9C9877379FEA81BE0E690FD4B47")

    private TypeVariable<Method>[] formalTypeParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.323 -0400", hash_original_field = "95A2153C74405BE971B467AB79B769A0", hash_generated_field = "89FDBAE6DE2AE55271071C78F774F101")

    private volatile boolean genericTypesAreInitialized = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.334 -0400", hash_original_method = "70F1F77231BFE73E3138A8A58A15C35C", hash_generated_method = "132D7D14805C9BDB2F4DD27DBCF9FCF9")
      Method(Method orig) {
        this(orig.declaringClass, orig.parameterTypes, orig.exceptionTypes,
                orig.returnType, orig.name, orig.slot);
        {
            this.flag = true;
        } //End block
        addTaint(orig.getTaint());
        // ---------- Original Method ----------
        //if (orig.flag) {
            //this.flag = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.335 -0400", hash_original_method = "F4B9C750B34D03AFED72DBA84048C99D", hash_generated_method = "A3295A616BA9759E667254D439272654")
    private  Method(Class<?> declaring, Class<?>[] paramTypes, Class<?>[] exceptTypes, Class<?> returnType, String name, int slot) {
        this.declaringClass = declaring;
        this.name = name;
        this.slot = slot;
        this.parameterTypes = paramTypes;
        this.exceptionTypes = exceptTypes;
        this.returnType = returnType;
        // ---------- Original Method ----------
        //this.declaringClass = declaring;
        //this.name = name;
        //this.slot = slot;
        //this.parameterTypes = paramTypes;
        //this.exceptionTypes = exceptTypes;
        //this.returnType = returnType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.336 -0400", hash_original_method = "0BE83C703D137B5A5A60EFAA17178485", hash_generated_method = "E8F805B2A3FE8E9F2FC17CEAF704CF1B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.353 -0400", hash_original_method = "0F068F731FE610BBACFD836E6A61AACF", hash_generated_method = "E24D91111B34A20E656F37196F05EF1F")
    public TypeVariable<Method>[] getTypeParameters() {
        TypeVariable<Method>[] varB4EAC82CA7396A68D541C85D26508E83_966339814 = null; //Variable for return #1
        initGenericTypes();
        varB4EAC82CA7396A68D541C85D26508E83_966339814 = formalTypeParameters.clone();
        varB4EAC82CA7396A68D541C85D26508E83_966339814.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_966339814;
        // ---------- Original Method ----------
        //initGenericTypes();
        //return formalTypeParameters.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.354 -0400", hash_original_method = "1CDF5107AC443AA5F8C2E1DA9DF559A0", hash_generated_method = "9CB44076647B4A28122041180EE4096B")
    @Override
     String getSignatureAttribute() {
        String varB4EAC82CA7396A68D541C85D26508E83_572488718 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2076355286 = null; //Variable for return #2
        Object[] annotation;
        annotation = getSignatureAnnotation(declaringClass, slot);
        {
            varB4EAC82CA7396A68D541C85D26508E83_572488718 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2076355286 = StringUtils.combineStrings(annotation);
        String varA7E53CE21691AB073D9660D615818899_725756073; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_725756073 = varB4EAC82CA7396A68D541C85D26508E83_572488718;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_725756073 = varB4EAC82CA7396A68D541C85D26508E83_2076355286;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_725756073.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_725756073;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.355 -0400", hash_original_method = "060018D8556E7858267AA04DC5F84FE8", hash_generated_method = "A62D3E8391A75D9B5C60069EA9947021")
    public String toGenericString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1783947640 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1783947640 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1783947640.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1783947640;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.369 -0400", hash_original_method = "A9CCE739D5419EE3EB1324AC76C431BA", hash_generated_method = "94D130D8409821369E08F4F9DED1F04D")
    public Type[] getGenericParameterTypes() {
        Type[] varB4EAC82CA7396A68D541C85D26508E83_470461776 = null; //Variable for return #1
        initGenericTypes();
        varB4EAC82CA7396A68D541C85D26508E83_470461776 = Types.getClonedTypeArray(genericParameterTypes);
        varB4EAC82CA7396A68D541C85D26508E83_470461776.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_470461776;
        // ---------- Original Method ----------
        //initGenericTypes();
        //return Types.getClonedTypeArray(genericParameterTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.370 -0400", hash_original_method = "D98F12BC8A74E89DDBE36E53E80FD275", hash_generated_method = "9086D122E80DE34D7FF0FCA13480A7BB")
    public Type[] getGenericExceptionTypes() {
        Type[] varB4EAC82CA7396A68D541C85D26508E83_345734289 = null; //Variable for return #1
        initGenericTypes();
        varB4EAC82CA7396A68D541C85D26508E83_345734289 = Types.getClonedTypeArray(genericExceptionTypes);
        varB4EAC82CA7396A68D541C85D26508E83_345734289.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_345734289;
        // ---------- Original Method ----------
        //initGenericTypes();
        //return Types.getClonedTypeArray(genericExceptionTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.370 -0400", hash_original_method = "83125796E1541F4C47F8F2176AE50053", hash_generated_method = "E3C95320C0765EE21F21AAA31BDA7030")
    public Type getGenericReturnType() {
        Type varB4EAC82CA7396A68D541C85D26508E83_73055164 = null; //Variable for return #1
        initGenericTypes();
        varB4EAC82CA7396A68D541C85D26508E83_73055164 = Types.getType(genericReturnType);
        varB4EAC82CA7396A68D541C85D26508E83_73055164.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_73055164;
        // ---------- Original Method ----------
        //initGenericTypes();
        //return Types.getType(genericReturnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.374 -0400", hash_original_method = "4122EC91CDDE6FFD9DA08F5ADAF8DB5D", hash_generated_method = "4DC3F70DF7CECC0429F2CEAAB31F4EAC")
    @Override
    public Annotation[] getDeclaredAnnotations() {
        Annotation[] varB4EAC82CA7396A68D541C85D26508E83_1764547281 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1764547281 = getDeclaredAnnotations(declaringClass, slot);
        varB4EAC82CA7396A68D541C85D26508E83_1764547281.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1764547281;
        // ---------- Original Method ----------
        //return getDeclaredAnnotations(declaringClass, slot);
    }

    
        static Annotation[] getDeclaredAnnotations(Class<?> declaringClass, int slot) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.375 -0400", hash_original_method = "C04F97610183E33B13FB9B4273375B6D", hash_generated_method = "B8590D18719A433A69BDC7FBD6E25833")
    @Override
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        A varB4EAC82CA7396A68D541C85D26508E83_649599846 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("annotationType == null");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_649599846 = getAnnotation(declaringClass, slot, annotationType);
        addTaint(annotationType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_649599846.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_649599846;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.375 -0400", hash_original_method = "D8B142EB73E138FF5927E6AE1DAD56D2", hash_generated_method = "31CA09324DBA32B70914A47D7BFA790E")
    @Override
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("annotationType == null");
        } //End block
        boolean varB3780DB5BBCCEE48C62CDF997A07D42D_1397168425 = (isAnnotationPresent(declaringClass, slot, annotationType));
        addTaint(annotationType.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1955320560 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1955320560;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.396 -0400", hash_original_method = "72FC508AEB582DBA9794440813C3A8B1", hash_generated_method = "68F1A2DD18C1B7A00EA69F79406F1572")
    public Annotation[][] getParameterAnnotations() {
        Annotation[][] varB4EAC82CA7396A68D541C85D26508E83_1011138812 = null; //Variable for return #1
        Annotation[][] varB4EAC82CA7396A68D541C85D26508E83_1811940160 = null; //Variable for return #2
        Annotation[][] parameterAnnotations;
        parameterAnnotations = getParameterAnnotations(declaringClass, slot);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1011138812 = noAnnotations(parameterTypes.length);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1811940160 = parameterAnnotations;
        Annotation[][] varA7E53CE21691AB073D9660D615818899_1706842948; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1706842948 = varB4EAC82CA7396A68D541C85D26508E83_1011138812;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1706842948 = varB4EAC82CA7396A68D541C85D26508E83_1811940160;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1706842948.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1706842948;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.396 -0400", hash_original_method = "47D8C519D80AD7FA8ACDBB9291AF9C1F", hash_generated_method = "6496E233136FC3C0E8DC55ECB30B4E1D")
    public boolean isVarArgs() {
        int modifiers;
        modifiers = getMethodModifiers(declaringClass, slot);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1620783562 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1620783562;
        // ---------- Original Method ----------
        //int modifiers = getMethodModifiers(declaringClass, slot);
        //return (modifiers & Modifier.VARARGS) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.397 -0400", hash_original_method = "F604FBBB689DE54F8A9C0A1F2713AB23", hash_generated_method = "D815CE266EE0F7686EF7B4EC90F673BD")
    public boolean isBridge() {
        int modifiers;
        modifiers = getMethodModifiers(declaringClass, slot);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1313107516 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1313107516;
        // ---------- Original Method ----------
        //int modifiers = getMethodModifiers(declaringClass, slot);
        //return (modifiers & Modifier.BRIDGE) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.397 -0400", hash_original_method = "B698BCB06B0A737FF1A228493D2DEAD0", hash_generated_method = "ADB44925ACAC3B40414C921352D215AA")
    public boolean isSynthetic() {
        int modifiers;
        modifiers = getMethodModifiers(declaringClass, slot);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1901045643 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1901045643;
        // ---------- Original Method ----------
        //int modifiers = getMethodModifiers(declaringClass, slot);
        //return (modifiers & Modifier.SYNTHETIC) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.397 -0400", hash_original_method = "3DF570DF2B22E4E433BE61FA4A3252FF", hash_generated_method = "992BE3A790F3E0D89B3C5D700D96A22A")
    public Object getDefaultValue() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1523847628 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1523847628 = getDefaultValue(declaringClass, slot);
        varB4EAC82CA7396A68D541C85D26508E83_1523847628.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1523847628;
        // ---------- Original Method ----------
        //return getDefaultValue(declaringClass, slot);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.397 -0400", hash_original_method = "01EB45D9363E910A54E557C442527E6E", hash_generated_method = "12453DE2F22689947CA412DBF05F783C")
    private Object getDefaultValue(Class declaringClass, int slot) {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.398 -0400", hash_original_method = "AF56E5F5402F800187126545ABE1F97F", hash_generated_method = "F553FBE566A11892A6D7D0895DEF2C82")
    @Override
    public boolean equals(Object object) {
        boolean varA56EFC3BDF27A12659DE2CAD30DABBAC_1541643457 = (object instanceof Method && toString().equals(object.toString()));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1940511819 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1940511819;
        // ---------- Original Method ----------
        //return object instanceof Method && toString().equals(object.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.398 -0400", hash_original_method = "747BEFE9985C4AF4EE3D5630B62185EA", hash_generated_method = "C49AB3B6D1C490F45E1D831E2932089A")
    public Class<?> getDeclaringClass() {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1187030801 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1187030801 = declaringClass;
        varB4EAC82CA7396A68D541C85D26508E83_1187030801.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1187030801;
        // ---------- Original Method ----------
        //return declaringClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.399 -0400", hash_original_method = "0803D161ECCDE8E4916E8597C31C5EAF", hash_generated_method = "7ADC33671EFA2F5271F77D7859F0031A")
    public Class<?>[] getExceptionTypes() {
        Class<?>[] varB4EAC82CA7396A68D541C85D26508E83_692319787 = null; //Variable for return #1
        Class<?>[] varB4EAC82CA7396A68D541C85D26508E83_220270877 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_692319787 = EmptyArray.CLASS;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_220270877 = exceptionTypes.clone();
        Class<?>[] varA7E53CE21691AB073D9660D615818899_2044091875; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2044091875 = varB4EAC82CA7396A68D541C85D26508E83_692319787;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2044091875 = varB4EAC82CA7396A68D541C85D26508E83_220270877;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2044091875.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2044091875;
        // ---------- Original Method ----------
        //if (exceptionTypes == null) {
            //return EmptyArray.CLASS;
        //}
        //return exceptionTypes.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.399 -0400", hash_original_method = "D61CFE217686483C8FB69E9FFDF592A9", hash_generated_method = "665C32C2B2AFC3004CD1C4C2FFE12923")
    public int getModifiers() {
        int varE3C3A4926E4A75C433C82B3799B27F5E_1239644260 = (getMethodModifiers(declaringClass, slot));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1352884792 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1352884792;
        // ---------- Original Method ----------
        //return getMethodModifiers(declaringClass, slot);
    }

    
        static int getMethodModifiers(Class<?> declaringClass, int slot) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.413 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "E366C18E21E0BE6B8A7ED67E80F9A3F9")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1197792274 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1197792274 = name;
        varB4EAC82CA7396A68D541C85D26508E83_1197792274.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1197792274;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.413 -0400", hash_original_method = "860AC8CD4E2F5F390A65618A1941DEDE", hash_generated_method = "4CC64F4F93263C4E621670133EAD98BB")
    public Class<?>[] getParameterTypes() {
        Class<?>[] varB4EAC82CA7396A68D541C85D26508E83_1895472843 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1895472843 = parameterTypes.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1895472843.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1895472843;
        // ---------- Original Method ----------
        //return parameterTypes.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.415 -0400", hash_original_method = "952CC59854183D9751F85A9597A378CE", hash_generated_method = "6611F9357B917E2EF213E227BB0C142F")
    public Class<?> getReturnType() {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_2091400984 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2091400984 = returnType;
        varB4EAC82CA7396A68D541C85D26508E83_2091400984.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2091400984;
        // ---------- Original Method ----------
        //return returnType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.426 -0400", hash_original_method = "EF5D8B81A9E09E0C38DFC15BA422ECA1", hash_generated_method = "61C9A0FEB2114C9C66EE36D25D86CCBC")
    @Override
    public int hashCode() {
        int var8EF65A1839C36EED6A25646011513717_820698270 = (name.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1950064205 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1950064205;
        // ---------- Original Method ----------
        //return name.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.433 -0400", hash_original_method = "4A7D773CBB2CABEB3FBD24437D2F9CE8", hash_generated_method = "B4D2B8C5B4FDBD338D073BDD37A4961E")
    public Object invoke(Object receiver, Object... args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object varB4EAC82CA7396A68D541C85D26508E83_700655313 = null; //Variable for return #1
        {
            args = EmptyArray.OBJECT;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_700655313 = invokeNative(receiver, args, declaringClass, parameterTypes, returnType, slot, flag);
        addTaint(receiver.getTaint());
        addTaint(args[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_700655313.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_700655313;
        // ---------- Original Method ----------
        //if (args == null) {
            //args = EmptyArray.OBJECT;
        //}
        //return invokeNative(receiver, args, declaringClass, parameterTypes, returnType, slot, flag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.433 -0400", hash_original_method = "0E030E32F68EF389669F95D53DF2EFAB", hash_generated_method = "5C866D8DF0795175296282F6D723F5B5")
    private Object invokeNative(Object obj, Object[] args, Class<?> declaringClass,
            Class<?>[] parameterTypes, Class<?> returnType, int slot, boolean noAccessCheck) throws IllegalAccessException, IllegalArgumentException,
                            InvocationTargetException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.434 -0400", hash_original_method = "20379CC138163D24505D982E1BF3267A", hash_generated_method = "11B6F8DC7D46F6A9B77063805B2BBB52")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_419704599 = null; //Variable for return #1
        StringBuilder result;
        result = new StringBuilder(Modifier.toString(getModifiers()));
        {
            boolean varFD23457D7925EE9ADC9C1D678FE17210_9515061 = (result.length() != 0);
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
        varB4EAC82CA7396A68D541C85D26508E83_419704599 = result.toString();
        varB4EAC82CA7396A68D541C85D26508E83_419704599.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_419704599;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.448 -0400", hash_original_method = "C4F068AB884B2FBA426F9E4B4EB5335D", hash_generated_method = "B147D5AD3A514798956DD0D55ED62A5A")
    @SuppressWarnings("unused")
    private String getSignature() {
        String varB4EAC82CA7396A68D541C85D26508E83_852232745 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_852232745 = result.toString();
        varB4EAC82CA7396A68D541C85D26508E83_852232745.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_852232745;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.449 -0400", hash_original_field = "6D5C49EE7CEF5783A42FC1C7653D6955", hash_generated_field = "3465881694FBE3BA7144100AF6865EE1")

    public static final Comparator<Method> ORDER_BY_SIGNATURE = new Comparator<Method>() {
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
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.449 -0400", hash_original_field = "34D6D6954DE3EDD110F2D639DA598DA0", hash_generated_field = "603764DDDF55C39C182DF3078A4D0CCC")

    private static Annotation[] NO_ANNOTATIONS = new Annotation[0];
}

