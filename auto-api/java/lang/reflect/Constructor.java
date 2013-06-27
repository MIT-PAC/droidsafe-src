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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.010 -0400", hash_original_field = "02CBE457FB1B22631E594CE79672D2F1", hash_generated_field = "A496C5D8F7CD0CB9CA97840555DF2AAA")

    Class<T> declaringClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.011 -0400", hash_original_field = "11427856321C6E9F5321CA879704C8FE", hash_generated_field = "6A17A418C19B2E2A1B1FDDDFEF7489B2")

    Class<?>[] parameterTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.011 -0400", hash_original_field = "2CD56E5B83C33F80B2D25820C51596A0", hash_generated_field = "0166CFA676A3372FA7BAE30D743E0654")

    Class<?>[] exceptionTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.011 -0400", hash_original_field = "6BB2E1AD8EE7DCCA935DA6ACF3D7474E", hash_generated_field = "1086E50AEBD292B3AD2410822F2C4F08")

    ListOfTypes genericExceptionTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.011 -0400", hash_original_field = "175F1F0CE81CA486282E77D84F1E1386", hash_generated_field = "8AC26B514C4DE93BC9F36D116E4A4BC6")

    ListOfTypes genericParameterTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.011 -0400", hash_original_field = "898BB6A86E0DA433332CBC4F55D3E967", hash_generated_field = "AEB06F4FE88A2F3FB2B5EFC21C88983B")

    TypeVariable<Constructor<T>>[] formalTypeParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.012 -0400", hash_original_field = "95A2153C74405BE971B467AB79B769A0", hash_generated_field = "89FDBAE6DE2AE55271071C78F774F101")

    private volatile boolean genericTypesAreInitialized = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.012 -0400", hash_original_field = "5E97994ED38A2B2F984F3B2B75012BF8", hash_generated_field = "09F7A5BA4BC6B04AB18035FB41A6CB6C")

    int slot;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.013 -0400", hash_original_method = "F22CB981733D75C2BC34BDB791B93657", hash_generated_method = "5981B35754AB4E8CEEDEF9BB5EC55BCB")
    private  Constructor() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.018 -0400", hash_original_method = "4E2CA9FC94A5B82D01ACB923AD24E02D", hash_generated_method = "18F52CB63607F7362AB53F7022A29477")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.025 -0400", hash_original_method = "ED32915D16D10FD7E30E61397009B806", hash_generated_method = "0B3675A1C3AAA3E69BD3095A51F3AB7F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.026 -0400", hash_original_method = "C62B79950C859BF71BE9288BB0AB9C37", hash_generated_method = "5D6FD9808F637C9BDC63A49B49F467E0")
    @Override
     String getSignatureAttribute() {
        String varB4EAC82CA7396A68D541C85D26508E83_90224171 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_225950178 = null; //Variable for return #2
        Object[] annotation;
        annotation = Method.getSignatureAnnotation(declaringClass, slot);
        {
            varB4EAC82CA7396A68D541C85D26508E83_90224171 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_225950178 = StringUtils.combineStrings(annotation);
        String varA7E53CE21691AB073D9660D615818899_1600147287; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1600147287 = varB4EAC82CA7396A68D541C85D26508E83_90224171;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1600147287 = varB4EAC82CA7396A68D541C85D26508E83_225950178;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1600147287.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1600147287;
        // ---------- Original Method ----------
        //Object[] annotation = Method.getSignatureAnnotation(declaringClass, slot);
        //if (annotation == null) {
            //return null;
        //}
        //return StringUtils.combineStrings(annotation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.034 -0400", hash_original_method = "085B8CB42A6E3AC80C8A5E5B20AAB41A", hash_generated_method = "C824BB9010E1C7DA06E4397EA4A7B69B")
    public TypeVariable<Constructor<T>>[] getTypeParameters() {
        TypeVariable<Constructor<T>>[] varB4EAC82CA7396A68D541C85D26508E83_1994455749 = null; //Variable for return #1
        initGenericTypes();
        varB4EAC82CA7396A68D541C85D26508E83_1994455749 = formalTypeParameters.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1994455749.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1994455749;
        // ---------- Original Method ----------
        //initGenericTypes();
        //return formalTypeParameters.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.045 -0400", hash_original_method = "BD69A0542CEC9A8352D572DD82647C37", hash_generated_method = "0621A32A0D9F2E8A37B92671E651002E")
    public String toGenericString() {
        String varB4EAC82CA7396A68D541C85D26508E83_531619841 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_531619841 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_531619841.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_531619841;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.046 -0400", hash_original_method = "A9CCE739D5419EE3EB1324AC76C431BA", hash_generated_method = "B850BB6783000A8E7D972CB00E7810B9")
    public Type[] getGenericParameterTypes() {
        Type[] varB4EAC82CA7396A68D541C85D26508E83_2100274195 = null; //Variable for return #1
        initGenericTypes();
        varB4EAC82CA7396A68D541C85D26508E83_2100274195 = Types.getClonedTypeArray(genericParameterTypes);
        varB4EAC82CA7396A68D541C85D26508E83_2100274195.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2100274195;
        // ---------- Original Method ----------
        //initGenericTypes();
        //return Types.getClonedTypeArray(genericParameterTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.046 -0400", hash_original_method = "D98F12BC8A74E89DDBE36E53E80FD275", hash_generated_method = "62815D4667A7ECAD4F684D554960FF7B")
    public Type[] getGenericExceptionTypes() {
        Type[] varB4EAC82CA7396A68D541C85D26508E83_1076623639 = null; //Variable for return #1
        initGenericTypes();
        varB4EAC82CA7396A68D541C85D26508E83_1076623639 = Types.getClonedTypeArray(genericExceptionTypes);
        varB4EAC82CA7396A68D541C85D26508E83_1076623639.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1076623639;
        // ---------- Original Method ----------
        //initGenericTypes();
        //return Types.getClonedTypeArray(genericExceptionTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.056 -0400", hash_original_method = "4F7DC07C64174CDAA43175ECC599103D", hash_generated_method = "02CEF14AAD343E1FB49CA21BDF5B205A")
    @Override
    public Annotation[] getDeclaredAnnotations() {
        Annotation[] varB4EAC82CA7396A68D541C85D26508E83_1423784074 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1423784074 = Method.getDeclaredAnnotations(declaringClass, slot);
        varB4EAC82CA7396A68D541C85D26508E83_1423784074.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1423784074;
        // ---------- Original Method ----------
        //return Method.getDeclaredAnnotations(declaringClass, slot);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.057 -0400", hash_original_method = "1A4BA94BF375F0F7A6512272530A6D39", hash_generated_method = "57871E21753628587B609F521905BB48")
    @Override
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        A varB4EAC82CA7396A68D541C85D26508E83_619544557 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("annotationType == null");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_619544557 = Method.getAnnotation(declaringClass, slot, annotationType);
        addTaint(annotationType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_619544557.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_619544557;
        // ---------- Original Method ----------
        //if (annotationType == null) {
            //throw new NullPointerException("annotationType == null");
        //}
        //return Method.getAnnotation(declaringClass, slot, annotationType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.057 -0400", hash_original_method = "DC6811BC307F5F500FE8FCDF979C7822", hash_generated_method = "35FD90449E548359C73F07AB904FB636")
    @Override
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("annotationType == null");
        } //End block
        boolean varD013F130A4C3211BC042195803538972_1218304684 = (Method.isAnnotationPresent(declaringClass, slot, annotationType));
        addTaint(annotationType.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_415780270 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_415780270;
        // ---------- Original Method ----------
        //if (annotationType == null) {
            //throw new NullPointerException("annotationType == null");
        //}
        //return Method.isAnnotationPresent(declaringClass, slot, annotationType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.058 -0400", hash_original_method = "15C5C292A9A80BF83F51CF39D22A468B", hash_generated_method = "CE5B26301014F3C4D7FED818389879E4")
    public Annotation[][] getParameterAnnotations() {
        Annotation[][] varB4EAC82CA7396A68D541C85D26508E83_1508229443 = null; //Variable for return #1
        Annotation[][] varB4EAC82CA7396A68D541C85D26508E83_938458548 = null; //Variable for return #2
        Annotation[][] parameterAnnotations;
        parameterAnnotations = Method.getParameterAnnotations(declaringClass, slot);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1508229443 = Method.noAnnotations(parameterTypes.length);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_938458548 = parameterAnnotations;
        Annotation[][] varA7E53CE21691AB073D9660D615818899_1674449046; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1674449046 = varB4EAC82CA7396A68D541C85D26508E83_1508229443;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1674449046 = varB4EAC82CA7396A68D541C85D26508E83_938458548;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1674449046.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1674449046;
        // ---------- Original Method ----------
        //Annotation[][] parameterAnnotations
                //= Method.getParameterAnnotations(declaringClass, slot);
        //if (parameterAnnotations.length == 0) {
            //return Method.noAnnotations(parameterTypes.length);
        //}
        //return parameterAnnotations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.059 -0400", hash_original_method = "27084EEDAB7B32E40BFE6AC29F04C9B8", hash_generated_method = "3ED6F544DABF7D36DB54C1C045F88F02")
    public boolean isVarArgs() {
        int mods;
        mods = Method.getMethodModifiers(declaringClass, slot);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1700376394 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1700376394;
        // ---------- Original Method ----------
        //int mods = Method.getMethodModifiers(declaringClass, slot);
        //return (mods & Modifier.VARARGS) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.074 -0400", hash_original_method = "98AC39075FB2CBC83E161E978A13C606", hash_generated_method = "E70AEC9F1843DACCF8D6BEDE306AF7B4")
    public boolean isSynthetic() {
        int mods;
        mods = Method.getMethodModifiers(declaringClass, slot);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_537111737 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_537111737;
        // ---------- Original Method ----------
        //int mods = Method.getMethodModifiers(declaringClass, slot);
        //return (mods & Modifier.SYNTHETIC) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.074 -0400", hash_original_method = "B30900BF5B4B7FDD7368A6CB9464E167", hash_generated_method = "82C71DEFDD05946C75750DF5E1D93FE7")
    @Override
    public boolean equals(Object object) {
        boolean varD99B2C8D408359C0C7A2340E6E527A6B_8070889 = (object instanceof Constructor && toString().equals(object.toString()));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1060107559 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1060107559;
        // ---------- Original Method ----------
        //return object instanceof Constructor && toString().equals(object.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.075 -0400", hash_original_method = "CE10C7360422171346CFCFE4390D0CD4", hash_generated_method = "2546F15091871AE1CDFC39404686EDFC")
    public Class<T> getDeclaringClass() {
        Class<T> varB4EAC82CA7396A68D541C85D26508E83_1579098360 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1579098360 = declaringClass;
        varB4EAC82CA7396A68D541C85D26508E83_1579098360.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1579098360;
        // ---------- Original Method ----------
        //return declaringClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.076 -0400", hash_original_method = "0803D161ECCDE8E4916E8597C31C5EAF", hash_generated_method = "7E95D936AE61FDE89E8BA5D34172936D")
    public Class<?>[] getExceptionTypes() {
        Class<?>[] varB4EAC82CA7396A68D541C85D26508E83_2071252655 = null; //Variable for return #1
        Class<?>[] varB4EAC82CA7396A68D541C85D26508E83_713237588 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_2071252655 = EmptyArray.CLASS;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_713237588 = exceptionTypes.clone();
        Class<?>[] varA7E53CE21691AB073D9660D615818899_518636170; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_518636170 = varB4EAC82CA7396A68D541C85D26508E83_2071252655;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_518636170 = varB4EAC82CA7396A68D541C85D26508E83_713237588;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_518636170.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_518636170;
        // ---------- Original Method ----------
        //if (exceptionTypes == null) {
            //return EmptyArray.CLASS;
        //}
        //return exceptionTypes.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.080 -0400", hash_original_method = "75F84F634C025C373FC5DFC6F2FEAE7E", hash_generated_method = "563CE2931B307C027E68A3A164711CC2")
    public int getModifiers() {
        int var75977E01665708B1BE3D3E419FBDAB0D_286634547 = (Method.getMethodModifiers(declaringClass, slot));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1566313753 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1566313753;
        // ---------- Original Method ----------
        //return Method.getMethodModifiers(declaringClass, slot);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.081 -0400", hash_original_method = "64DF6B8C865C11FF9D8C98657107C7C5", hash_generated_method = "E351801F3FC617910EBF8C39F0FE9FF2")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_359507644 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_359507644 = declaringClass.getName();
        varB4EAC82CA7396A68D541C85D26508E83_359507644.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_359507644;
        // ---------- Original Method ----------
        //return declaringClass.getName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.095 -0400", hash_original_method = "860AC8CD4E2F5F390A65618A1941DEDE", hash_generated_method = "66C5714485A149388C962C6C3289C3BF")
    public Class<?>[] getParameterTypes() {
        Class<?>[] varB4EAC82CA7396A68D541C85D26508E83_2068794296 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2068794296 = parameterTypes.clone();
        varB4EAC82CA7396A68D541C85D26508E83_2068794296.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2068794296;
        // ---------- Original Method ----------
        //return parameterTypes.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.097 -0400", hash_original_method = "70A1497759834DE033251D58FB1BC60F", hash_generated_method = "05BB7F4F7E5CEA13FCA26B1B8751ED44")
    @SuppressWarnings("unused")
    private String getSignature() {
        String varB4EAC82CA7396A68D541C85D26508E83_501928462 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_501928462 = result.toString();
        varB4EAC82CA7396A68D541C85D26508E83_501928462.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_501928462;
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder();
        //result.append('(');
        //for (int i = 0; i < parameterTypes.length; i++) {
            //result.append(getSignature(parameterTypes[i]));
        //}
        //result.append(")V");
        //return result.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.097 -0400", hash_original_method = "B8D03AB769FE0736E7C02030ACA8679C", hash_generated_method = "BB79C6447E98AB75A486259234472A0F")
    @Override
    public int hashCode() {
        int var11BB0B014459668EF152ECE9A7A1751A_1528184716 = (declaringClass.getName().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_776097167 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_776097167;
        // ---------- Original Method ----------
        //return declaringClass.getName().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.098 -0400", hash_original_method = "E7355AF509FB0F598B5C977468B592C4", hash_generated_method = "8868B67FB6C0A9E0E59B9B456CCE357F")
    public T newInstance(Object... args) throws InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        T varB4EAC82CA7396A68D541C85D26508E83_881618900 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_881618900 = constructNative (args, declaringClass, parameterTypes, slot, flag);
        addTaint(args[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_881618900.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_881618900;
        // ---------- Original Method ----------
        //return constructNative (args, declaringClass, parameterTypes, slot, flag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.099 -0400", hash_original_method = "847A043CD7E53CD248ABB6D5FEBEB21F", hash_generated_method = "AB7A646FD776CAA4E845EC2470DC079B")
    private T constructNative(Object[] args, Class<T> declaringClass,
            Class<?>[] parameterTypes, int slot,
            boolean noAccessCheck) throws InstantiationException, IllegalAccessException,
            InvocationTargetException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.105 -0400", hash_original_method = "4738B09E6DE786765E7966DA89BB1975", hash_generated_method = "9E5C09DA3D03CA1652BC88EA6AAECB06")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1887738039 = null; //Variable for return #1
        StringBuilder result;
        result = new StringBuilder(Modifier.toString(getModifiers()));
        {
            boolean varFD23457D7925EE9ADC9C1D678FE17210_1929122318 = (result.length() != 0);
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
        varB4EAC82CA7396A68D541C85D26508E83_1887738039 = result.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1887738039.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1887738039;
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

