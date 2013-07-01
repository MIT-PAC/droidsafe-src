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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.713 -0400", hash_original_field = "02CBE457FB1B22631E594CE79672D2F1", hash_generated_field = "A496C5D8F7CD0CB9CA97840555DF2AAA")

    Class<T> declaringClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.713 -0400", hash_original_field = "11427856321C6E9F5321CA879704C8FE", hash_generated_field = "6A17A418C19B2E2A1B1FDDDFEF7489B2")

    Class<?>[] parameterTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.713 -0400", hash_original_field = "2CD56E5B83C33F80B2D25820C51596A0", hash_generated_field = "0166CFA676A3372FA7BAE30D743E0654")

    Class<?>[] exceptionTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.713 -0400", hash_original_field = "6BB2E1AD8EE7DCCA935DA6ACF3D7474E", hash_generated_field = "1086E50AEBD292B3AD2410822F2C4F08")

    ListOfTypes genericExceptionTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.713 -0400", hash_original_field = "175F1F0CE81CA486282E77D84F1E1386", hash_generated_field = "8AC26B514C4DE93BC9F36D116E4A4BC6")

    ListOfTypes genericParameterTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.713 -0400", hash_original_field = "898BB6A86E0DA433332CBC4F55D3E967", hash_generated_field = "AEB06F4FE88A2F3FB2B5EFC21C88983B")

    TypeVariable<Constructor<T>>[] formalTypeParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.713 -0400", hash_original_field = "95A2153C74405BE971B467AB79B769A0", hash_generated_field = "89FDBAE6DE2AE55271071C78F774F101")

    private volatile boolean genericTypesAreInitialized = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.713 -0400", hash_original_field = "5E97994ED38A2B2F984F3B2B75012BF8", hash_generated_field = "09F7A5BA4BC6B04AB18035FB41A6CB6C")

    int slot;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.713 -0400", hash_original_method = "F22CB981733D75C2BC34BDB791B93657", hash_generated_method = "5981B35754AB4E8CEEDEF9BB5EC55BCB")
    public  Constructor() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.713 -0400", hash_original_method = "4E2CA9FC94A5B82D01ACB923AD24E02D", hash_generated_method = "18F52CB63607F7362AB53F7022A29477")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.714 -0400", hash_original_method = "ED32915D16D10FD7E30E61397009B806", hash_generated_method = "DCD637BC6A4E01795EAD14D3867D32E3")
    private synchronized void initGenericTypes() {
        {
            String signatureAttribute = getSignatureAttribute();
            GenericSignatureParser parser = new GenericSignatureParser(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.714 -0400", hash_original_method = "C62B79950C859BF71BE9288BB0AB9C37", hash_generated_method = "800C20A4E90C2DA84525393D47A622C7")
    @Override
     String getSignatureAttribute() {
        String varB4EAC82CA7396A68D541C85D26508E83_1741091207 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1708183265 = null; //Variable for return #2
        Object[] annotation = Method.getSignatureAnnotation(declaringClass, slot);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1741091207 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1708183265 = StringUtils.combineStrings(annotation);
        String varA7E53CE21691AB073D9660D615818899_277453084; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_277453084 = varB4EAC82CA7396A68D541C85D26508E83_1741091207;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_277453084 = varB4EAC82CA7396A68D541C85D26508E83_1708183265;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_277453084.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_277453084;
        // ---------- Original Method ----------
        //Object[] annotation = Method.getSignatureAnnotation(declaringClass, slot);
        //if (annotation == null) {
            //return null;
        //}
        //return StringUtils.combineStrings(annotation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.714 -0400", hash_original_method = "085B8CB42A6E3AC80C8A5E5B20AAB41A", hash_generated_method = "68098A0B1E4377F3560B9C069B0E5E7E")
    public TypeVariable<Constructor<T>>[] getTypeParameters() {
        TypeVariable<Constructor<T>>[] varB4EAC82CA7396A68D541C85D26508E83_521550663 = null; //Variable for return #1
        initGenericTypes();
        varB4EAC82CA7396A68D541C85D26508E83_521550663 = formalTypeParameters.clone();
        varB4EAC82CA7396A68D541C85D26508E83_521550663.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_521550663;
        // ---------- Original Method ----------
        //initGenericTypes();
        //return formalTypeParameters.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.715 -0400", hash_original_method = "BD69A0542CEC9A8352D572DD82647C37", hash_generated_method = "DCA2D39E246DA6518174C9565B7C147B")
    public String toGenericString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1001654034 = null; //Variable for return #1
        StringBuilder sb = new StringBuilder(80);
        initGenericTypes();
        int modifier = getModifiers();
        {
            sb.append(Modifier.toString(modifier & ~Modifier.VARARGS)).append(' ');
        } //End block
        {
            sb.append('<');
            {
                int i = 0;
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
        Type[] genericExceptionTypeArray = Types.getClonedTypeArray(genericExceptionTypes);
        {
            sb.append(" throws ");
            appendArrayGenericType(sb, genericExceptionTypeArray);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1001654034 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1001654034.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1001654034;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.717 -0400", hash_original_method = "A9CCE739D5419EE3EB1324AC76C431BA", hash_generated_method = "5F2E75F73D6675A14D55C4DC6AFAFE72")
    public Type[] getGenericParameterTypes() {
        Type[] varB4EAC82CA7396A68D541C85D26508E83_2101493907 = null; //Variable for return #1
        initGenericTypes();
        varB4EAC82CA7396A68D541C85D26508E83_2101493907 = Types.getClonedTypeArray(genericParameterTypes);
        varB4EAC82CA7396A68D541C85D26508E83_2101493907.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2101493907;
        // ---------- Original Method ----------
        //initGenericTypes();
        //return Types.getClonedTypeArray(genericParameterTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.718 -0400", hash_original_method = "D98F12BC8A74E89DDBE36E53E80FD275", hash_generated_method = "3F264789F46A1444808E42508D5781A4")
    public Type[] getGenericExceptionTypes() {
        Type[] varB4EAC82CA7396A68D541C85D26508E83_224475357 = null; //Variable for return #1
        initGenericTypes();
        varB4EAC82CA7396A68D541C85D26508E83_224475357 = Types.getClonedTypeArray(genericExceptionTypes);
        varB4EAC82CA7396A68D541C85D26508E83_224475357.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_224475357;
        // ---------- Original Method ----------
        //initGenericTypes();
        //return Types.getClonedTypeArray(genericExceptionTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.718 -0400", hash_original_method = "4F7DC07C64174CDAA43175ECC599103D", hash_generated_method = "31EB3B2F35F4197BFEDE9B695FB45193")
    @Override
    public Annotation[] getDeclaredAnnotations() {
        Annotation[] varB4EAC82CA7396A68D541C85D26508E83_1262429241 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1262429241 = Method.getDeclaredAnnotations(declaringClass, slot);
        varB4EAC82CA7396A68D541C85D26508E83_1262429241.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1262429241;
        // ---------- Original Method ----------
        //return Method.getDeclaredAnnotations(declaringClass, slot);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.719 -0400", hash_original_method = "1A4BA94BF375F0F7A6512272530A6D39", hash_generated_method = "F057D4B208502D8B6D84FDD1375B5869")
    @Override
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        A varB4EAC82CA7396A68D541C85D26508E83_870854493 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("annotationType == null");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_870854493 = Method.getAnnotation(declaringClass, slot, annotationType);
        addTaint(annotationType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_870854493.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_870854493;
        // ---------- Original Method ----------
        //if (annotationType == null) {
            //throw new NullPointerException("annotationType == null");
        //}
        //return Method.getAnnotation(declaringClass, slot, annotationType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.719 -0400", hash_original_method = "DC6811BC307F5F500FE8FCDF979C7822", hash_generated_method = "F40020350A189E67C10CC694AA78CED4")
    @Override
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("annotationType == null");
        } //End block
        boolean varD013F130A4C3211BC042195803538972_649545390 = (Method.isAnnotationPresent(declaringClass, slot, annotationType));
        addTaint(annotationType.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_341609998 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_341609998;
        // ---------- Original Method ----------
        //if (annotationType == null) {
            //throw new NullPointerException("annotationType == null");
        //}
        //return Method.isAnnotationPresent(declaringClass, slot, annotationType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.719 -0400", hash_original_method = "15C5C292A9A80BF83F51CF39D22A468B", hash_generated_method = "7EDB500898282802701AC6279D35F8D3")
    public Annotation[][] getParameterAnnotations() {
        Annotation[][] varB4EAC82CA7396A68D541C85D26508E83_1508809072 = null; //Variable for return #1
        Annotation[][] varB4EAC82CA7396A68D541C85D26508E83_709444778 = null; //Variable for return #2
        Annotation[][] parameterAnnotations = Method.getParameterAnnotations(declaringClass, slot);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1508809072 = Method.noAnnotations(parameterTypes.length);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_709444778 = parameterAnnotations;
        Annotation[][] varA7E53CE21691AB073D9660D615818899_375657096; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_375657096 = varB4EAC82CA7396A68D541C85D26508E83_1508809072;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_375657096 = varB4EAC82CA7396A68D541C85D26508E83_709444778;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_375657096.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_375657096;
        // ---------- Original Method ----------
        //Annotation[][] parameterAnnotations
                //= Method.getParameterAnnotations(declaringClass, slot);
        //if (parameterAnnotations.length == 0) {
            //return Method.noAnnotations(parameterTypes.length);
        //}
        //return parameterAnnotations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.720 -0400", hash_original_method = "27084EEDAB7B32E40BFE6AC29F04C9B8", hash_generated_method = "3AF5D033455CB48C6A5DE8403FE3BC00")
    public boolean isVarArgs() {
        int mods = Method.getMethodModifiers(declaringClass, slot);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2104280388 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2104280388;
        // ---------- Original Method ----------
        //int mods = Method.getMethodModifiers(declaringClass, slot);
        //return (mods & Modifier.VARARGS) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.720 -0400", hash_original_method = "98AC39075FB2CBC83E161E978A13C606", hash_generated_method = "9123A7E73600F776B5C42D06A126E3D1")
    public boolean isSynthetic() {
        int mods = Method.getMethodModifiers(declaringClass, slot);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_605059825 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_605059825;
        // ---------- Original Method ----------
        //int mods = Method.getMethodModifiers(declaringClass, slot);
        //return (mods & Modifier.SYNTHETIC) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.720 -0400", hash_original_method = "B30900BF5B4B7FDD7368A6CB9464E167", hash_generated_method = "D7FDEBDE2AA46977C61B54E5DE5AFC7A")
    @Override
    public boolean equals(Object object) {
        boolean varD99B2C8D408359C0C7A2340E6E527A6B_649697264 = (object instanceof Constructor && toString().equals(object.toString()));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_865639228 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_865639228;
        // ---------- Original Method ----------
        //return object instanceof Constructor && toString().equals(object.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.721 -0400", hash_original_method = "CE10C7360422171346CFCFE4390D0CD4", hash_generated_method = "5856E8F7CE7485FB64D09D81D91FC670")
    public Class<T> getDeclaringClass() {
        Class<T> varB4EAC82CA7396A68D541C85D26508E83_158850683 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_158850683 = declaringClass;
        varB4EAC82CA7396A68D541C85D26508E83_158850683.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_158850683;
        // ---------- Original Method ----------
        //return declaringClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.721 -0400", hash_original_method = "0803D161ECCDE8E4916E8597C31C5EAF", hash_generated_method = "CCEAE1F5BD321AB87CD1DD02B31306A0")
    public Class<?>[] getExceptionTypes() {
        Class<?>[] varB4EAC82CA7396A68D541C85D26508E83_2068567756 = null; //Variable for return #1
        Class<?>[] varB4EAC82CA7396A68D541C85D26508E83_1550000476 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_2068567756 = EmptyArray.CLASS;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1550000476 = exceptionTypes.clone();
        Class<?>[] varA7E53CE21691AB073D9660D615818899_2021647462; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2021647462 = varB4EAC82CA7396A68D541C85D26508E83_2068567756;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2021647462 = varB4EAC82CA7396A68D541C85D26508E83_1550000476;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2021647462.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2021647462;
        // ---------- Original Method ----------
        //if (exceptionTypes == null) {
            //return EmptyArray.CLASS;
        //}
        //return exceptionTypes.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.721 -0400", hash_original_method = "75F84F634C025C373FC5DFC6F2FEAE7E", hash_generated_method = "CC43F42DFAA2D874DE4070BA3664E26E")
    public int getModifiers() {
        int var75977E01665708B1BE3D3E419FBDAB0D_1995072593 = (Method.getMethodModifiers(declaringClass, slot));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1354064825 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1354064825;
        // ---------- Original Method ----------
        //return Method.getMethodModifiers(declaringClass, slot);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.722 -0400", hash_original_method = "64DF6B8C865C11FF9D8C98657107C7C5", hash_generated_method = "35734AAE362955D86B86B857289B49C0")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1126672614 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1126672614 = declaringClass.getName();
        varB4EAC82CA7396A68D541C85D26508E83_1126672614.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1126672614;
        // ---------- Original Method ----------
        //return declaringClass.getName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.722 -0400", hash_original_method = "860AC8CD4E2F5F390A65618A1941DEDE", hash_generated_method = "F474DA5817278A7A75AF79D4E59470AA")
    public Class<?>[] getParameterTypes() {
        Class<?>[] varB4EAC82CA7396A68D541C85D26508E83_833171037 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_833171037 = parameterTypes.clone();
        varB4EAC82CA7396A68D541C85D26508E83_833171037.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_833171037;
        // ---------- Original Method ----------
        //return parameterTypes.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.722 -0400", hash_original_method = "70A1497759834DE033251D58FB1BC60F", hash_generated_method = "D043CDBD3C63311E2D1D6CF33FCDB9E4")
    @SuppressWarnings("unused")
    private String getSignature() {
        String varB4EAC82CA7396A68D541C85D26508E83_889482192 = null; //Variable for return #1
        StringBuilder result = new StringBuilder();
        result.append('(');
        {
            int i = 0;
            {
                result.append(getSignature(parameterTypes[i]));
            } //End block
        } //End collapsed parenthetic
        result.append(")V");
        varB4EAC82CA7396A68D541C85D26508E83_889482192 = result.toString();
        varB4EAC82CA7396A68D541C85D26508E83_889482192.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_889482192;
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder();
        //result.append('(');
        //for (int i = 0; i < parameterTypes.length; i++) {
            //result.append(getSignature(parameterTypes[i]));
        //}
        //result.append(")V");
        //return result.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.723 -0400", hash_original_method = "B8D03AB769FE0736E7C02030ACA8679C", hash_generated_method = "49A2E4B5AD6F784E598BEC2A98F47906")
    @Override
    public int hashCode() {
        int var11BB0B014459668EF152ECE9A7A1751A_1847009694 = (declaringClass.getName().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1407559911 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1407559911;
        // ---------- Original Method ----------
        //return declaringClass.getName().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.723 -0400", hash_original_method = "E7355AF509FB0F598B5C977468B592C4", hash_generated_method = "54BFFFC7D2DAA701588DEC65ACC561E2")
    public T newInstance(Object... args) throws InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        T varB4EAC82CA7396A68D541C85D26508E83_1297772081 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1297772081 = constructNative (args, declaringClass, parameterTypes, slot, flag);
        addTaint(args[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1297772081.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1297772081;
        // ---------- Original Method ----------
        //return constructNative (args, declaringClass, parameterTypes, slot, flag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.723 -0400", hash_original_method = "847A043CD7E53CD248ABB6D5FEBEB21F", hash_generated_method = "AB7A646FD776CAA4E845EC2470DC079B")
    private T constructNative(Object[] args, Class<T> declaringClass,
            Class<?>[] parameterTypes, int slot,
            boolean noAccessCheck) throws InstantiationException, IllegalAccessException,
            InvocationTargetException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    	
    	addTaint(args[0].taint);
    	addTaint(declaringClass.taint);
    	addTaint(parameterTypes[0].taint);
    	addTaint(slot);
    	addTaint(noAccessCheck);
    	return (T)new Object();
    	
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.724 -0400", hash_original_method = "4738B09E6DE786765E7966DA89BB1975", hash_generated_method = "D50BD5F5FCF24233EA69A2029F59404B")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1712526019 = null; //Variable for return #1
        StringBuilder result = new StringBuilder(Modifier.toString(getModifiers()));
        {
            boolean varFD23457D7925EE9ADC9C1D678FE17210_482607054 = (result.length() != 0);
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
        varB4EAC82CA7396A68D541C85D26508E83_1712526019 = result.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1712526019.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1712526019;
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

