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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.971 -0400", hash_original_field = "02CBE457FB1B22631E594CE79672D2F1", hash_generated_field = "A496C5D8F7CD0CB9CA97840555DF2AAA")

    Class<T> declaringClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.971 -0400", hash_original_field = "11427856321C6E9F5321CA879704C8FE", hash_generated_field = "6A17A418C19B2E2A1B1FDDDFEF7489B2")

    Class<?>[] parameterTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.971 -0400", hash_original_field = "2CD56E5B83C33F80B2D25820C51596A0", hash_generated_field = "0166CFA676A3372FA7BAE30D743E0654")

    Class<?>[] exceptionTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.971 -0400", hash_original_field = "6BB2E1AD8EE7DCCA935DA6ACF3D7474E", hash_generated_field = "1086E50AEBD292B3AD2410822F2C4F08")

    ListOfTypes genericExceptionTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.971 -0400", hash_original_field = "175F1F0CE81CA486282E77D84F1E1386", hash_generated_field = "8AC26B514C4DE93BC9F36D116E4A4BC6")

    ListOfTypes genericParameterTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.972 -0400", hash_original_field = "898BB6A86E0DA433332CBC4F55D3E967", hash_generated_field = "AEB06F4FE88A2F3FB2B5EFC21C88983B")

    TypeVariable<Constructor<T>>[] formalTypeParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.972 -0400", hash_original_field = "95A2153C74405BE971B467AB79B769A0", hash_generated_field = "89FDBAE6DE2AE55271071C78F774F101")

    private volatile boolean genericTypesAreInitialized = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.972 -0400", hash_original_field = "5E97994ED38A2B2F984F3B2B75012BF8", hash_generated_field = "09F7A5BA4BC6B04AB18035FB41A6CB6C")

    int slot;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.972 -0400", hash_original_method = "F22CB981733D75C2BC34BDB791B93657", hash_generated_method = "5981B35754AB4E8CEEDEF9BB5EC55BCB")
    private  Constructor() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.984 -0400", hash_original_method = "4E2CA9FC94A5B82D01ACB923AD24E02D", hash_generated_method = "18F52CB63607F7362AB53F7022A29477")
    private  Constructor(Class<T> declaringClass, Class<?>[] ptypes, Class<?>[] extypes, int slot) {
        this.declaringClass = declaringClass;
        this.parameterTypes = ptypes;
        this.exceptionTypes = extypes;
        this.slot = slot;
        // ---------- Original Method ----------
        //this.declaringClass = declaringClass;
        //this.parameterTypes = ptypes;
        //this.exceptionTypes = extypes;
        //this.slot = slot;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.985 -0400", hash_original_method = "ED32915D16D10FD7E30E61397009B806", hash_generated_method = "0B3675A1C3AAA3E69BD3095A51F3AB7F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.985 -0400", hash_original_method = "C62B79950C859BF71BE9288BB0AB9C37", hash_generated_method = "C8739A69E62FE08D3D6CB063FF197108")
    @Override
     String getSignatureAttribute() {
        String varB4EAC82CA7396A68D541C85D26508E83_895824571 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_462340488 = null; //Variable for return #2
        Object[] annotation;
        annotation = Method.getSignatureAnnotation(declaringClass, slot);
        {
            varB4EAC82CA7396A68D541C85D26508E83_895824571 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_462340488 = StringUtils.combineStrings(annotation);
        String varA7E53CE21691AB073D9660D615818899_65764075; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_65764075 = varB4EAC82CA7396A68D541C85D26508E83_895824571;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_65764075 = varB4EAC82CA7396A68D541C85D26508E83_462340488;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_65764075.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_65764075;
        // ---------- Original Method ----------
        //Object[] annotation = Method.getSignatureAnnotation(declaringClass, slot);
        //if (annotation == null) {
            //return null;
        //}
        //return StringUtils.combineStrings(annotation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.000 -0400", hash_original_method = "085B8CB42A6E3AC80C8A5E5B20AAB41A", hash_generated_method = "396FEF0A6B3CB6796E3CF8F96E6AC471")
    public TypeVariable<Constructor<T>>[] getTypeParameters() {
        TypeVariable<Constructor<T>>[] varB4EAC82CA7396A68D541C85D26508E83_1511682848 = null; //Variable for return #1
        initGenericTypes();
        varB4EAC82CA7396A68D541C85D26508E83_1511682848 = formalTypeParameters.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1511682848.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1511682848;
        // ---------- Original Method ----------
        //initGenericTypes();
        //return formalTypeParameters.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.017 -0400", hash_original_method = "BD69A0542CEC9A8352D572DD82647C37", hash_generated_method = "B0D04F5002AF5D3CE57DAFE1F12A33C4")
    public String toGenericString() {
        String varB4EAC82CA7396A68D541C85D26508E83_196532799 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_196532799 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_196532799.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_196532799;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.017 -0400", hash_original_method = "A9CCE739D5419EE3EB1324AC76C431BA", hash_generated_method = "F8DFABF416E328A1CCC44670F2ECF55F")
    public Type[] getGenericParameterTypes() {
        Type[] varB4EAC82CA7396A68D541C85D26508E83_1580186638 = null; //Variable for return #1
        initGenericTypes();
        varB4EAC82CA7396A68D541C85D26508E83_1580186638 = Types.getClonedTypeArray(genericParameterTypes);
        varB4EAC82CA7396A68D541C85D26508E83_1580186638.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1580186638;
        // ---------- Original Method ----------
        //initGenericTypes();
        //return Types.getClonedTypeArray(genericParameterTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.018 -0400", hash_original_method = "D98F12BC8A74E89DDBE36E53E80FD275", hash_generated_method = "5F9558A57409C4DE41357EDCB1789E31")
    public Type[] getGenericExceptionTypes() {
        Type[] varB4EAC82CA7396A68D541C85D26508E83_1940375527 = null; //Variable for return #1
        initGenericTypes();
        varB4EAC82CA7396A68D541C85D26508E83_1940375527 = Types.getClonedTypeArray(genericExceptionTypes);
        varB4EAC82CA7396A68D541C85D26508E83_1940375527.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1940375527;
        // ---------- Original Method ----------
        //initGenericTypes();
        //return Types.getClonedTypeArray(genericExceptionTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.018 -0400", hash_original_method = "4F7DC07C64174CDAA43175ECC599103D", hash_generated_method = "9AF249F1D4A1617FF585E4070429C826")
    @Override
    public Annotation[] getDeclaredAnnotations() {
        Annotation[] varB4EAC82CA7396A68D541C85D26508E83_1346933046 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1346933046 = Method.getDeclaredAnnotations(declaringClass, slot);
        varB4EAC82CA7396A68D541C85D26508E83_1346933046.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1346933046;
        // ---------- Original Method ----------
        //return Method.getDeclaredAnnotations(declaringClass, slot);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.032 -0400", hash_original_method = "1A4BA94BF375F0F7A6512272530A6D39", hash_generated_method = "FF8BA43515EEE0501D082B6B09B1950E")
    @Override
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        A varB4EAC82CA7396A68D541C85D26508E83_1875089741 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("annotationType == null");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1875089741 = Method.getAnnotation(declaringClass, slot, annotationType);
        addTaint(annotationType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1875089741.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1875089741;
        // ---------- Original Method ----------
        //if (annotationType == null) {
            //throw new NullPointerException("annotationType == null");
        //}
        //return Method.getAnnotation(declaringClass, slot, annotationType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.032 -0400", hash_original_method = "DC6811BC307F5F500FE8FCDF979C7822", hash_generated_method = "1E15B9B701A5CC996C5F5D13F3AA749B")
    @Override
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("annotationType == null");
        } //End block
        boolean varD013F130A4C3211BC042195803538972_1789755057 = (Method.isAnnotationPresent(declaringClass, slot, annotationType));
        addTaint(annotationType.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_351476033 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_351476033;
        // ---------- Original Method ----------
        //if (annotationType == null) {
            //throw new NullPointerException("annotationType == null");
        //}
        //return Method.isAnnotationPresent(declaringClass, slot, annotationType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.033 -0400", hash_original_method = "15C5C292A9A80BF83F51CF39D22A468B", hash_generated_method = "828FC956D86695213F844CC55FC364D6")
    public Annotation[][] getParameterAnnotations() {
        Annotation[][] varB4EAC82CA7396A68D541C85D26508E83_1855035395 = null; //Variable for return #1
        Annotation[][] varB4EAC82CA7396A68D541C85D26508E83_831640298 = null; //Variable for return #2
        Annotation[][] parameterAnnotations;
        parameterAnnotations = Method.getParameterAnnotations(declaringClass, slot);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1855035395 = Method.noAnnotations(parameterTypes.length);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_831640298 = parameterAnnotations;
        Annotation[][] varA7E53CE21691AB073D9660D615818899_369016962; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_369016962 = varB4EAC82CA7396A68D541C85D26508E83_1855035395;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_369016962 = varB4EAC82CA7396A68D541C85D26508E83_831640298;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_369016962.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_369016962;
        // ---------- Original Method ----------
        //Annotation[][] parameterAnnotations
                //= Method.getParameterAnnotations(declaringClass, slot);
        //if (parameterAnnotations.length == 0) {
            //return Method.noAnnotations(parameterTypes.length);
        //}
        //return parameterAnnotations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.047 -0400", hash_original_method = "27084EEDAB7B32E40BFE6AC29F04C9B8", hash_generated_method = "569B3DA12346DC5E3135556EA97B8FD0")
    public boolean isVarArgs() {
        int mods;
        mods = Method.getMethodModifiers(declaringClass, slot);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_930612903 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_930612903;
        // ---------- Original Method ----------
        //int mods = Method.getMethodModifiers(declaringClass, slot);
        //return (mods & Modifier.VARARGS) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.047 -0400", hash_original_method = "98AC39075FB2CBC83E161E978A13C606", hash_generated_method = "74A13C42060BE061A62A551B81131BA7")
    public boolean isSynthetic() {
        int mods;
        mods = Method.getMethodModifiers(declaringClass, slot);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1576198972 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1576198972;
        // ---------- Original Method ----------
        //int mods = Method.getMethodModifiers(declaringClass, slot);
        //return (mods & Modifier.SYNTHETIC) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.051 -0400", hash_original_method = "B30900BF5B4B7FDD7368A6CB9464E167", hash_generated_method = "E64AC31A323BED445D45E4985FCC263F")
    @Override
    public boolean equals(Object object) {
        boolean varD99B2C8D408359C0C7A2340E6E527A6B_1020792894 = (object instanceof Constructor && toString().equals(object.toString()));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1478818422 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1478818422;
        // ---------- Original Method ----------
        //return object instanceof Constructor && toString().equals(object.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.055 -0400", hash_original_method = "CE10C7360422171346CFCFE4390D0CD4", hash_generated_method = "B0855D40EEAE8D571460F1929CC24667")
    public Class<T> getDeclaringClass() {
        Class<T> varB4EAC82CA7396A68D541C85D26508E83_1699419876 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1699419876 = declaringClass;
        varB4EAC82CA7396A68D541C85D26508E83_1699419876.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1699419876;
        // ---------- Original Method ----------
        //return declaringClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.056 -0400", hash_original_method = "0803D161ECCDE8E4916E8597C31C5EAF", hash_generated_method = "290A0238F71119B90E6DA8316D29C5B2")
    public Class<?>[] getExceptionTypes() {
        Class<?>[] varB4EAC82CA7396A68D541C85D26508E83_796336812 = null; //Variable for return #1
        Class<?>[] varB4EAC82CA7396A68D541C85D26508E83_1217088159 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_796336812 = EmptyArray.CLASS;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1217088159 = exceptionTypes.clone();
        Class<?>[] varA7E53CE21691AB073D9660D615818899_2015188314; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2015188314 = varB4EAC82CA7396A68D541C85D26508E83_796336812;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2015188314 = varB4EAC82CA7396A68D541C85D26508E83_1217088159;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2015188314.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2015188314;
        // ---------- Original Method ----------
        //if (exceptionTypes == null) {
            //return EmptyArray.CLASS;
        //}
        //return exceptionTypes.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.073 -0400", hash_original_method = "75F84F634C025C373FC5DFC6F2FEAE7E", hash_generated_method = "C9E389702AAC361C9E7AFE83E963C5AB")
    public int getModifiers() {
        int var75977E01665708B1BE3D3E419FBDAB0D_1955405929 = (Method.getMethodModifiers(declaringClass, slot));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1272495509 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1272495509;
        // ---------- Original Method ----------
        //return Method.getMethodModifiers(declaringClass, slot);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.074 -0400", hash_original_method = "64DF6B8C865C11FF9D8C98657107C7C5", hash_generated_method = "A69CC2B3509F4E1A8A8C7A553A5026E5")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1141327874 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1141327874 = declaringClass.getName();
        varB4EAC82CA7396A68D541C85D26508E83_1141327874.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1141327874;
        // ---------- Original Method ----------
        //return declaringClass.getName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.075 -0400", hash_original_method = "860AC8CD4E2F5F390A65618A1941DEDE", hash_generated_method = "2A03454D9803482418FDACD2A4403116")
    public Class<?>[] getParameterTypes() {
        Class<?>[] varB4EAC82CA7396A68D541C85D26508E83_843483419 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_843483419 = parameterTypes.clone();
        varB4EAC82CA7396A68D541C85D26508E83_843483419.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_843483419;
        // ---------- Original Method ----------
        //return parameterTypes.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.075 -0400", hash_original_method = "70A1497759834DE033251D58FB1BC60F", hash_generated_method = "5ABAF884A7738E373C5BA9BC29B5EAC4")
    @SuppressWarnings("unused")
    private String getSignature() {
        String varB4EAC82CA7396A68D541C85D26508E83_1873180651 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1873180651 = result.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1873180651.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1873180651;
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder();
        //result.append('(');
        //for (int i = 0; i < parameterTypes.length; i++) {
            //result.append(getSignature(parameterTypes[i]));
        //}
        //result.append(")V");
        //return result.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.075 -0400", hash_original_method = "B8D03AB769FE0736E7C02030ACA8679C", hash_generated_method = "766083009C9F7896B074C74FCB55FD5E")
    @Override
    public int hashCode() {
        int var11BB0B014459668EF152ECE9A7A1751A_110336700 = (declaringClass.getName().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1049006449 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1049006449;
        // ---------- Original Method ----------
        //return declaringClass.getName().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.076 -0400", hash_original_method = "E7355AF509FB0F598B5C977468B592C4", hash_generated_method = "2CF0D0135E3CBA08411A2A3AA30F52E4")
    public T newInstance(Object... args) throws InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        T varB4EAC82CA7396A68D541C85D26508E83_74190031 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_74190031 = constructNative (args, declaringClass, parameterTypes, slot, flag);
        addTaint(args[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_74190031.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_74190031;
        // ---------- Original Method ----------
        //return constructNative (args, declaringClass, parameterTypes, slot, flag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.076 -0400", hash_original_method = "847A043CD7E53CD248ABB6D5FEBEB21F", hash_generated_method = "AB7A646FD776CAA4E845EC2470DC079B")
    private T constructNative(Object[] args, Class<T> declaringClass,
            Class<?>[] parameterTypes, int slot,
            boolean noAccessCheck) throws InstantiationException, IllegalAccessException,
            InvocationTargetException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.090 -0400", hash_original_method = "4738B09E6DE786765E7966DA89BB1975", hash_generated_method = "F7488778562F2CBA8583369555A6073E")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_39677910 = null; //Variable for return #1
        StringBuilder result;
        result = new StringBuilder(Modifier.toString(getModifiers()));
        {
            boolean varFD23457D7925EE9ADC9C1D678FE17210_126950732 = (result.length() != 0);
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
        varB4EAC82CA7396A68D541C85D26508E83_39677910 = result.toString();
        varB4EAC82CA7396A68D541C85D26508E83_39677910.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_39677910;
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

