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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.258 -0400", hash_original_field = "5E97994ED38A2B2F984F3B2B75012BF8", hash_generated_field = "6B06F56F1EB868ADA8CFFD63973A7E09")

    private int slot;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.259 -0400", hash_original_field = "02CBE457FB1B22631E594CE79672D2F1", hash_generated_field = "EC96049C106D95C970CBF94E8CE21744")

    private Class<?> declaringClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.259 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.259 -0400", hash_original_field = "11427856321C6E9F5321CA879704C8FE", hash_generated_field = "2BEA8A3EFDFBD76D3A4CCA6C3AC7E53C")

    private Class<?>[] parameterTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.259 -0400", hash_original_field = "2CD56E5B83C33F80B2D25820C51596A0", hash_generated_field = "2A0AC8F9632DF82B378D2F01BC74BDF4")

    private Class<?>[] exceptionTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.259 -0400", hash_original_field = "9CD6843F4536590CD86F933708C7371E", hash_generated_field = "052C26419A9A6CDFB48BC17097CACAE9")

    private Class<?> returnType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.259 -0400", hash_original_field = "6BB2E1AD8EE7DCCA935DA6ACF3D7474E", hash_generated_field = "924C48D07F65387E616D3CE31DE5954D")

    private ListOfTypes genericExceptionTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.259 -0400", hash_original_field = "175F1F0CE81CA486282E77D84F1E1386", hash_generated_field = "4E98B7DC70F3037D11B527C2E4899BBD")

    private ListOfTypes genericParameterTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.259 -0400", hash_original_field = "40B35D47678E42F2607E0F522DC3BF6F", hash_generated_field = "32E37E22BB1C76784903951645BC45C1")

    private Type genericReturnType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.259 -0400", hash_original_field = "898BB6A86E0DA433332CBC4F55D3E967", hash_generated_field = "4338B9C9877379FEA81BE0E690FD4B47")

    private TypeVariable<Method>[] formalTypeParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.259 -0400", hash_original_field = "95A2153C74405BE971B467AB79B769A0", hash_generated_field = "89FDBAE6DE2AE55271071C78F774F101")

    private volatile boolean genericTypesAreInitialized = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.277 -0400", hash_original_method = "70F1F77231BFE73E3138A8A58A15C35C", hash_generated_method = "132D7D14805C9BDB2F4DD27DBCF9FCF9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.278 -0400", hash_original_method = "F4B9C750B34D03AFED72DBA84048C99D", hash_generated_method = "A3295A616BA9759E667254D439272654")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.278 -0400", hash_original_method = "0BE83C703D137B5A5A60EFAA17178485", hash_generated_method = "E8F805B2A3FE8E9F2FC17CEAF704CF1B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.285 -0400", hash_original_method = "0F068F731FE610BBACFD836E6A61AACF", hash_generated_method = "C1CE4B41E7A711E5E22D63A983BD5150")
    public TypeVariable<Method>[] getTypeParameters() {
        TypeVariable<Method>[] varB4EAC82CA7396A68D541C85D26508E83_1931923674 = null; //Variable for return #1
        initGenericTypes();
        varB4EAC82CA7396A68D541C85D26508E83_1931923674 = formalTypeParameters.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1931923674.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1931923674;
        // ---------- Original Method ----------
        //initGenericTypes();
        //return formalTypeParameters.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.288 -0400", hash_original_method = "1CDF5107AC443AA5F8C2E1DA9DF559A0", hash_generated_method = "504B74DA261BE1D1E18B3CCC196CFAC2")
    @Override
     String getSignatureAttribute() {
        String varB4EAC82CA7396A68D541C85D26508E83_1345550227 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_795273809 = null; //Variable for return #2
        Object[] annotation;
        annotation = getSignatureAnnotation(declaringClass, slot);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1345550227 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_795273809 = StringUtils.combineStrings(annotation);
        String varA7E53CE21691AB073D9660D615818899_753202435; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_753202435 = varB4EAC82CA7396A68D541C85D26508E83_1345550227;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_753202435 = varB4EAC82CA7396A68D541C85D26508E83_795273809;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_753202435.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_753202435;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.300 -0400", hash_original_method = "060018D8556E7858267AA04DC5F84FE8", hash_generated_method = "CE8745B434E115815174664F2CCFE3D4")
    public String toGenericString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2147030250 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_2147030250 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_2147030250.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2147030250;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.301 -0400", hash_original_method = "A9CCE739D5419EE3EB1324AC76C431BA", hash_generated_method = "60D7A47325B7BA0697E3269F92031418")
    public Type[] getGenericParameterTypes() {
        Type[] varB4EAC82CA7396A68D541C85D26508E83_1637232345 = null; //Variable for return #1
        initGenericTypes();
        varB4EAC82CA7396A68D541C85D26508E83_1637232345 = Types.getClonedTypeArray(genericParameterTypes);
        varB4EAC82CA7396A68D541C85D26508E83_1637232345.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1637232345;
        // ---------- Original Method ----------
        //initGenericTypes();
        //return Types.getClonedTypeArray(genericParameterTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.312 -0400", hash_original_method = "D98F12BC8A74E89DDBE36E53E80FD275", hash_generated_method = "106CD2B2EA63BB5DA5C8A014730508B8")
    public Type[] getGenericExceptionTypes() {
        Type[] varB4EAC82CA7396A68D541C85D26508E83_2020065799 = null; //Variable for return #1
        initGenericTypes();
        varB4EAC82CA7396A68D541C85D26508E83_2020065799 = Types.getClonedTypeArray(genericExceptionTypes);
        varB4EAC82CA7396A68D541C85D26508E83_2020065799.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2020065799;
        // ---------- Original Method ----------
        //initGenericTypes();
        //return Types.getClonedTypeArray(genericExceptionTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.327 -0400", hash_original_method = "83125796E1541F4C47F8F2176AE50053", hash_generated_method = "169837ACB83CB41455F0BCDBB113F3EE")
    public Type getGenericReturnType() {
        Type varB4EAC82CA7396A68D541C85D26508E83_1117231191 = null; //Variable for return #1
        initGenericTypes();
        varB4EAC82CA7396A68D541C85D26508E83_1117231191 = Types.getType(genericReturnType);
        varB4EAC82CA7396A68D541C85D26508E83_1117231191.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1117231191;
        // ---------- Original Method ----------
        //initGenericTypes();
        //return Types.getType(genericReturnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.328 -0400", hash_original_method = "4122EC91CDDE6FFD9DA08F5ADAF8DB5D", hash_generated_method = "6F5E3DD8ED53B8CB96FCF38C2D3AEFDD")
    @Override
    public Annotation[] getDeclaredAnnotations() {
        Annotation[] varB4EAC82CA7396A68D541C85D26508E83_169344106 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_169344106 = getDeclaredAnnotations(declaringClass, slot);
        varB4EAC82CA7396A68D541C85D26508E83_169344106.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_169344106;
        // ---------- Original Method ----------
        //return getDeclaredAnnotations(declaringClass, slot);
    }

    
        static Annotation[] getDeclaredAnnotations(Class<?> declaringClass, int slot) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.329 -0400", hash_original_method = "C04F97610183E33B13FB9B4273375B6D", hash_generated_method = "2E91A9F666CF9D1124062B55A955EA4D")
    @Override
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        A varB4EAC82CA7396A68D541C85D26508E83_846991897 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("annotationType == null");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_846991897 = getAnnotation(declaringClass, slot, annotationType);
        addTaint(annotationType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_846991897.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_846991897;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.329 -0400", hash_original_method = "D8B142EB73E138FF5927E6AE1DAD56D2", hash_generated_method = "AE0829F63D283BAEF2B9E913613C2479")
    @Override
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("annotationType == null");
        } //End block
        boolean varB3780DB5BBCCEE48C62CDF997A07D42D_1574834380 = (isAnnotationPresent(declaringClass, slot, annotationType));
        addTaint(annotationType.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_122328448 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_122328448;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.333 -0400", hash_original_method = "72FC508AEB582DBA9794440813C3A8B1", hash_generated_method = "72518ED766039ED53C7A804B5C278DA1")
    public Annotation[][] getParameterAnnotations() {
        Annotation[][] varB4EAC82CA7396A68D541C85D26508E83_1323612321 = null; //Variable for return #1
        Annotation[][] varB4EAC82CA7396A68D541C85D26508E83_2058471371 = null; //Variable for return #2
        Annotation[][] parameterAnnotations;
        parameterAnnotations = getParameterAnnotations(declaringClass, slot);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1323612321 = noAnnotations(parameterTypes.length);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2058471371 = parameterAnnotations;
        Annotation[][] varA7E53CE21691AB073D9660D615818899_2143991483; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2143991483 = varB4EAC82CA7396A68D541C85D26508E83_1323612321;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2143991483 = varB4EAC82CA7396A68D541C85D26508E83_2058471371;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2143991483.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2143991483;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.334 -0400", hash_original_method = "47D8C519D80AD7FA8ACDBB9291AF9C1F", hash_generated_method = "EC8D2DAF57212C1AECE6F03B088339CA")
    public boolean isVarArgs() {
        int modifiers;
        modifiers = getMethodModifiers(declaringClass, slot);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_628211044 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_628211044;
        // ---------- Original Method ----------
        //int modifiers = getMethodModifiers(declaringClass, slot);
        //return (modifiers & Modifier.VARARGS) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.334 -0400", hash_original_method = "F604FBBB689DE54F8A9C0A1F2713AB23", hash_generated_method = "E38C16648818336E4892DEC592516A89")
    public boolean isBridge() {
        int modifiers;
        modifiers = getMethodModifiers(declaringClass, slot);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_277062875 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_277062875;
        // ---------- Original Method ----------
        //int modifiers = getMethodModifiers(declaringClass, slot);
        //return (modifiers & Modifier.BRIDGE) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.334 -0400", hash_original_method = "B698BCB06B0A737FF1A228493D2DEAD0", hash_generated_method = "A0FD4C7774EAB6C90884CE2AE739798F")
    public boolean isSynthetic() {
        int modifiers;
        modifiers = getMethodModifiers(declaringClass, slot);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1315340004 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1315340004;
        // ---------- Original Method ----------
        //int modifiers = getMethodModifiers(declaringClass, slot);
        //return (modifiers & Modifier.SYNTHETIC) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.345 -0400", hash_original_method = "3DF570DF2B22E4E433BE61FA4A3252FF", hash_generated_method = "4305149888C97D86BC34002B5C8CACA4")
    public Object getDefaultValue() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1729896306 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1729896306 = getDefaultValue(declaringClass, slot);
        varB4EAC82CA7396A68D541C85D26508E83_1729896306.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1729896306;
        // ---------- Original Method ----------
        //return getDefaultValue(declaringClass, slot);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.346 -0400", hash_original_method = "01EB45D9363E910A54E557C442527E6E", hash_generated_method = "12453DE2F22689947CA412DBF05F783C")
    private Object getDefaultValue(Class declaringClass, int slot) {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.347 -0400", hash_original_method = "AF56E5F5402F800187126545ABE1F97F", hash_generated_method = "6FA94F81704073EDF88361ABD7874589")
    @Override
    public boolean equals(Object object) {
        boolean varA56EFC3BDF27A12659DE2CAD30DABBAC_1604094508 = (object instanceof Method && toString().equals(object.toString()));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1839383339 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1839383339;
        // ---------- Original Method ----------
        //return object instanceof Method && toString().equals(object.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.365 -0400", hash_original_method = "747BEFE9985C4AF4EE3D5630B62185EA", hash_generated_method = "35DA843C863DB5D02F00D94F6B3CDC87")
    public Class<?> getDeclaringClass() {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1406739605 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1406739605 = declaringClass;
        varB4EAC82CA7396A68D541C85D26508E83_1406739605.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1406739605;
        // ---------- Original Method ----------
        //return declaringClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.365 -0400", hash_original_method = "0803D161ECCDE8E4916E8597C31C5EAF", hash_generated_method = "FBA5780C923EDC2027BCEA04132C597A")
    public Class<?>[] getExceptionTypes() {
        Class<?>[] varB4EAC82CA7396A68D541C85D26508E83_1514059475 = null; //Variable for return #1
        Class<?>[] varB4EAC82CA7396A68D541C85D26508E83_1034209260 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1514059475 = EmptyArray.CLASS;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1034209260 = exceptionTypes.clone();
        Class<?>[] varA7E53CE21691AB073D9660D615818899_763032297; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_763032297 = varB4EAC82CA7396A68D541C85D26508E83_1514059475;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_763032297 = varB4EAC82CA7396A68D541C85D26508E83_1034209260;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_763032297.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_763032297;
        // ---------- Original Method ----------
        //if (exceptionTypes == null) {
            //return EmptyArray.CLASS;
        //}
        //return exceptionTypes.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.365 -0400", hash_original_method = "D61CFE217686483C8FB69E9FFDF592A9", hash_generated_method = "EB9E44EBAF68890D3ED9F27D16F2F8D0")
    public int getModifiers() {
        int varE3C3A4926E4A75C433C82B3799B27F5E_240624510 = (getMethodModifiers(declaringClass, slot));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_793709489 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_793709489;
        // ---------- Original Method ----------
        //return getMethodModifiers(declaringClass, slot);
    }

    
        static int getMethodModifiers(Class<?> declaringClass, int slot) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.366 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "FE6E21C7E3E1241B0880965398298ECC")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1431242066 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1431242066 = name;
        varB4EAC82CA7396A68D541C85D26508E83_1431242066.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1431242066;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.368 -0400", hash_original_method = "860AC8CD4E2F5F390A65618A1941DEDE", hash_generated_method = "C57FEA46307DF24E84A6A4BD36B03502")
    public Class<?>[] getParameterTypes() {
        Class<?>[] varB4EAC82CA7396A68D541C85D26508E83_75887634 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_75887634 = parameterTypes.clone();
        varB4EAC82CA7396A68D541C85D26508E83_75887634.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_75887634;
        // ---------- Original Method ----------
        //return parameterTypes.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.368 -0400", hash_original_method = "952CC59854183D9751F85A9597A378CE", hash_generated_method = "21273968140865D54528782987A1222A")
    public Class<?> getReturnType() {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1637316147 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1637316147 = returnType;
        varB4EAC82CA7396A68D541C85D26508E83_1637316147.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1637316147;
        // ---------- Original Method ----------
        //return returnType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.368 -0400", hash_original_method = "EF5D8B81A9E09E0C38DFC15BA422ECA1", hash_generated_method = "8F13E9DB477A3430639E40F7038021DA")
    @Override
    public int hashCode() {
        int var8EF65A1839C36EED6A25646011513717_1964275394 = (name.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_851412606 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_851412606;
        // ---------- Original Method ----------
        //return name.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.371 -0400", hash_original_method = "4A7D773CBB2CABEB3FBD24437D2F9CE8", hash_generated_method = "000E54D1F7DD17D6BAF222A136EFF9AA")
    public Object invoke(Object receiver, Object... args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object varB4EAC82CA7396A68D541C85D26508E83_579603432 = null; //Variable for return #1
        {
            args = EmptyArray.OBJECT;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_579603432 = invokeNative(receiver, args, declaringClass, parameterTypes, returnType, slot, flag);
        addTaint(receiver.getTaint());
        addTaint(args[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_579603432.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_579603432;
        // ---------- Original Method ----------
        //if (args == null) {
            //args = EmptyArray.OBJECT;
        //}
        //return invokeNative(receiver, args, declaringClass, parameterTypes, returnType, slot, flag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.376 -0400", hash_original_method = "0E030E32F68EF389669F95D53DF2EFAB", hash_generated_method = "5C866D8DF0795175296282F6D723F5B5")
    private Object invokeNative(Object obj, Object[] args, Class<?> declaringClass,
            Class<?>[] parameterTypes, Class<?> returnType, int slot, boolean noAccessCheck) throws IllegalAccessException, IllegalArgumentException,
                            InvocationTargetException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.390 -0400", hash_original_method = "20379CC138163D24505D982E1BF3267A", hash_generated_method = "57A2E48201FA6BD13412586203C084C0")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1645556593 = null; //Variable for return #1
        StringBuilder result;
        result = new StringBuilder(Modifier.toString(getModifiers()));
        {
            boolean varFD23457D7925EE9ADC9C1D678FE17210_1185969053 = (result.length() != 0);
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
        varB4EAC82CA7396A68D541C85D26508E83_1645556593 = result.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1645556593.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1645556593;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.390 -0400", hash_original_method = "C4F068AB884B2FBA426F9E4B4EB5335D", hash_generated_method = "41350B8DE2194A20493BF9A9963B8999")
    @SuppressWarnings("unused")
    private String getSignature() {
        String varB4EAC82CA7396A68D541C85D26508E83_3423172 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_3423172 = result.toString();
        varB4EAC82CA7396A68D541C85D26508E83_3423172.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_3423172;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.390 -0400", hash_original_field = "6D5C49EE7CEF5783A42FC1C7653D6955", hash_generated_field = "3465881694FBE3BA7144100AF6865EE1")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.390 -0400", hash_original_field = "34D6D6954DE3EDD110F2D639DA598DA0", hash_generated_field = "603764DDDF55C39C182DF3078A4D0CCC")

    private static Annotation[] NO_ANNOTATIONS = new Annotation[0];
}

