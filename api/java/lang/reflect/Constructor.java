package java.lang.reflect;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.lang.annotation.Annotation;

import libcore.util.EmptyArray;

import org.apache.harmony.kernel.vm.StringUtils;
import org.apache.harmony.luni.lang.reflect.GenericSignatureParser;
import org.apache.harmony.luni.lang.reflect.ListOfTypes;
import org.apache.harmony.luni.lang.reflect.Types;






public final class Constructor<T> extends AccessibleObject implements GenericDeclaration, Member {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.935 -0400", hash_original_field = "02CBE457FB1B22631E594CE79672D2F1", hash_generated_field = "A496C5D8F7CD0CB9CA97840555DF2AAA")

    @DSVAModeled
    Class<T> declaringClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.935 -0400", hash_original_field = "11427856321C6E9F5321CA879704C8FE", hash_generated_field = "6A17A418C19B2E2A1B1FDDDFEF7489B2")

    @DSVAModeled
    Class<?>[] parameterTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.935 -0400", hash_original_field = "2CD56E5B83C33F80B2D25820C51596A0", hash_generated_field = "0166CFA676A3372FA7BAE30D743E0654")

    Class<?>[] exceptionTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.935 -0400", hash_original_field = "6BB2E1AD8EE7DCCA935DA6ACF3D7474E", hash_generated_field = "1086E50AEBD292B3AD2410822F2C4F08")

    ListOfTypes genericExceptionTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.935 -0400", hash_original_field = "175F1F0CE81CA486282E77D84F1E1386", hash_generated_field = "8AC26B514C4DE93BC9F36D116E4A4BC6")

    ListOfTypes genericParameterTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.935 -0400", hash_original_field = "898BB6A86E0DA433332CBC4F55D3E967", hash_generated_field = "AEB06F4FE88A2F3FB2B5EFC21C88983B")

    TypeVariable<Constructor<T>>[] formalTypeParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.935 -0400", hash_original_field = "95A2153C74405BE971B467AB79B769A0", hash_generated_field = "89FDBAE6DE2AE55271071C78F774F101")

    private volatile boolean genericTypesAreInitialized = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.935 -0400", hash_original_field = "5E97994ED38A2B2F984F3B2B75012BF8", hash_generated_field = "09F7A5BA4BC6B04AB18035FB41A6CB6C")

    int slot;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.952 -0400", hash_original_method = "F22CB981733D75C2BC34BDB791B93657", hash_generated_method = "5981B35754AB4E8CEEDEF9BB5EC55BCB")
	public  Constructor() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.936 -0400", hash_original_method = "4E2CA9FC94A5B82D01ACB923AD24E02D", hash_generated_method = "18F52CB63607F7362AB53F7022A29477")
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.937 -0400", hash_original_method = "ED32915D16D10FD7E30E61397009B806", hash_generated_method = "8C2846F25BB3F03FA2834DBE67122EDE")
    private synchronized void initGenericTypes() {
        if(!genericTypesAreInitialized)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.937 -0400", hash_original_method = "C62B79950C859BF71BE9288BB0AB9C37", hash_generated_method = "9A9E872664AE12E9EA9FFEDBA8C2AF47")
    @Override
     String getSignatureAttribute() {
        Object[] annotation = Method.getSignatureAnnotation(declaringClass, slot);
        if(annotation == null)        
        {
String var540C13E9E156B687226421B24F2DF178_901244536 =             null;
            var540C13E9E156B687226421B24F2DF178_901244536.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_901244536;
        } //End block
String var2F8E51633C4B934C6A6871930033C26B_302838616 =         StringUtils.combineStrings(annotation);
        var2F8E51633C4B934C6A6871930033C26B_302838616.addTaint(taint);
        return var2F8E51633C4B934C6A6871930033C26B_302838616;
        // ---------- Original Method ----------
        //Object[] annotation = Method.getSignatureAnnotation(declaringClass, slot);
        //if (annotation == null) {
            //return null;
        //}
        //return StringUtils.combineStrings(annotation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.938 -0400", hash_original_method = "085B8CB42A6E3AC80C8A5E5B20AAB41A", hash_generated_method = "37BECB9FF6353837DFDE2CE9EE5811BC")
    public TypeVariable<Constructor<T>>[] getTypeParameters() {
        initGenericTypes();
TypeVariable<Constructor<T>>[] var530714F4AE8FC705F00A16C33AA9F354_1868420321 =         formalTypeParameters.clone();
        var530714F4AE8FC705F00A16C33AA9F354_1868420321.addTaint(taint);
        return var530714F4AE8FC705F00A16C33AA9F354_1868420321;
        // ---------- Original Method ----------
        //initGenericTypes();
        //return formalTypeParameters.clone();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.938 -0400", hash_original_method = "BD69A0542CEC9A8352D572DD82647C37", hash_generated_method = "F62405C9BC25B7D38219B2368A8B048A")
    public String toGenericString() {
        StringBuilder sb = new StringBuilder(80);
        initGenericTypes();
        int modifier = getModifiers();
        if(modifier != 0)        
        {
            sb.append(Modifier.toString(modifier & ~Modifier.VARARGS)).append(' ');
        } //End block
        if(formalTypeParameters != null && formalTypeParameters.length > 0)        
        {
            sb.append('<');
for(int i = 0;i < formalTypeParameters.length;i++)
            {
                appendGenericType(sb, formalTypeParameters[i]);
                if(i < formalTypeParameters.length - 1)                
                {
                    sb.append(",");
                } //End block
            } //End block
            sb.append("> ");
        } //End block
        appendArrayType(sb, getDeclaringClass());
        sb.append('(');
        appendArrayGenericType(sb,
                Types.getClonedTypeArray(genericParameterTypes));
        sb.append(')');
        Type[] genericExceptionTypeArray = Types.getClonedTypeArray(genericExceptionTypes);
        if(genericExceptionTypeArray.length > 0)        
        {
            sb.append(" throws ");
            appendArrayGenericType(sb, genericExceptionTypeArray);
        } //End block
String var2460B846747F8B22185AD8BE722266A5_382395424 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_382395424.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_382395424;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.939 -0400", hash_original_method = "A9CCE739D5419EE3EB1324AC76C431BA", hash_generated_method = "4C83FD0B057C846EB9664F10AE1070B6")
    public Type[] getGenericParameterTypes() {
        initGenericTypes();
Type[] var5CB4FE98CE4670BB8FD40D4DEBE96905_1436662945 =         Types.getClonedTypeArray(genericParameterTypes);
        var5CB4FE98CE4670BB8FD40D4DEBE96905_1436662945.addTaint(taint);
        return var5CB4FE98CE4670BB8FD40D4DEBE96905_1436662945;
        // ---------- Original Method ----------
        //initGenericTypes();
        //return Types.getClonedTypeArray(genericParameterTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.940 -0400", hash_original_method = "D98F12BC8A74E89DDBE36E53E80FD275", hash_generated_method = "59C54E235D3441455C7CED6309981423")
    public Type[] getGenericExceptionTypes() {
        initGenericTypes();
Type[] var5B58D007921425E5297F5C75058387B8_167456986 =         Types.getClonedTypeArray(genericExceptionTypes);
        var5B58D007921425E5297F5C75058387B8_167456986.addTaint(taint);
        return var5B58D007921425E5297F5C75058387B8_167456986;
        // ---------- Original Method ----------
        //initGenericTypes();
        //return Types.getClonedTypeArray(genericExceptionTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.940 -0400", hash_original_method = "4F7DC07C64174CDAA43175ECC599103D", hash_generated_method = "8CAC0389E226F888C4AEB7531413A793")
    @Override
    public Annotation[] getDeclaredAnnotations() {
Annotation[] varCEB162A873EFD10835F6CE1FB96D8CB2_791359920 =         Method.getDeclaredAnnotations(declaringClass, slot);
        varCEB162A873EFD10835F6CE1FB96D8CB2_791359920.addTaint(taint);
        return varCEB162A873EFD10835F6CE1FB96D8CB2_791359920;
        // ---------- Original Method ----------
        //return Method.getDeclaredAnnotations(declaringClass, slot);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.941 -0400", hash_original_method = "1A4BA94BF375F0F7A6512272530A6D39", hash_generated_method = "EFFA4E5032510A0BF30E67FE04872295")
    @Override
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        addTaint(annotationType.getTaint());
        if(annotationType == null)        
        {
            NullPointerException varD3565833EFC12BC5822ABFE94D257EDE_1877579624 = new NullPointerException("annotationType == null");
            varD3565833EFC12BC5822ABFE94D257EDE_1877579624.addTaint(taint);
            throw varD3565833EFC12BC5822ABFE94D257EDE_1877579624;
        } //End block
A var5417718CA49F9779F67999A1AA0ED4BB_140290513 =         Method.getAnnotation(declaringClass, slot, annotationType);
        var5417718CA49F9779F67999A1AA0ED4BB_140290513.addTaint(taint);
        return var5417718CA49F9779F67999A1AA0ED4BB_140290513;
        // ---------- Original Method ----------
        //if (annotationType == null) {
            //throw new NullPointerException("annotationType == null");
        //}
        //return Method.getAnnotation(declaringClass, slot, annotationType);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.941 -0400", hash_original_method = "DC6811BC307F5F500FE8FCDF979C7822", hash_generated_method = "B3EFB8571346F8752937B031DFF1F0E9")
    @Override
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        addTaint(annotationType.getTaint());
        if(annotationType == null)        
        {
            NullPointerException varD3565833EFC12BC5822ABFE94D257EDE_731161877 = new NullPointerException("annotationType == null");
            varD3565833EFC12BC5822ABFE94D257EDE_731161877.addTaint(taint);
            throw varD3565833EFC12BC5822ABFE94D257EDE_731161877;
        } //End block
        boolean var89CB16F80799F534D0464C04A07CF9A6_249691898 = (Method.isAnnotationPresent(declaringClass, slot, annotationType));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1095623224 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1095623224;
        // ---------- Original Method ----------
        //if (annotationType == null) {
            //throw new NullPointerException("annotationType == null");
        //}
        //return Method.isAnnotationPresent(declaringClass, slot, annotationType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.942 -0400", hash_original_method = "15C5C292A9A80BF83F51CF39D22A468B", hash_generated_method = "453769F3BE50F4EF3A40628AE6B002B7")
    public Annotation[][] getParameterAnnotations() {
        Annotation[][] parameterAnnotations = Method.getParameterAnnotations(declaringClass, slot);
        if(parameterAnnotations.length == 0)        
        {
Annotation[][] var15C5F2AAEB28119B840E422D93DB09D2_53550667 =             Method.noAnnotations(parameterTypes.length);
            var15C5F2AAEB28119B840E422D93DB09D2_53550667.addTaint(taint);
            return var15C5F2AAEB28119B840E422D93DB09D2_53550667;
        } //End block
Annotation[][] varAD240742A5BFADFDA08547188EAD9960_233613996 =         parameterAnnotations;
        varAD240742A5BFADFDA08547188EAD9960_233613996.addTaint(taint);
        return varAD240742A5BFADFDA08547188EAD9960_233613996;
        // ---------- Original Method ----------
        //Annotation[][] parameterAnnotations
                //= Method.getParameterAnnotations(declaringClass, slot);
        //if (parameterAnnotations.length == 0) {
            //return Method.noAnnotations(parameterTypes.length);
        //}
        //return parameterAnnotations;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.942 -0400", hash_original_method = "27084EEDAB7B32E40BFE6AC29F04C9B8", hash_generated_method = "98FBA915C0E3A5D054347B76FEEE47A6")
    public boolean isVarArgs() {
        int mods = Method.getMethodModifiers(declaringClass, slot);
        boolean var86DAE4C613A84946DC68E64495A528D2_1628244109 = ((mods & Modifier.VARARGS) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_936222438 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_936222438;
        // ---------- Original Method ----------
        //int mods = Method.getMethodModifiers(declaringClass, slot);
        //return (mods & Modifier.VARARGS) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.943 -0400", hash_original_method = "98AC39075FB2CBC83E161E978A13C606", hash_generated_method = "30B5DB24EEDB6B89CC04BA2694A89689")
    public boolean isSynthetic() {
        int mods = Method.getMethodModifiers(declaringClass, slot);
        boolean varBAC0FB6B5CDCE03373AF4C7AA6974822_914542648 = ((mods & Modifier.SYNTHETIC) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1951847209 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1951847209;
        // ---------- Original Method ----------
        //int mods = Method.getMethodModifiers(declaringClass, slot);
        //return (mods & Modifier.SYNTHETIC) != 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.943 -0400", hash_original_method = "B30900BF5B4B7FDD7368A6CB9464E167", hash_generated_method = "9E062098CFF5425D8FF89D2A17FDFB92")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        boolean varEA1FEBC74C07235B6607AFA36D5D2D7F_716710442 = (object instanceof Constructor && toString().equals(object.toString()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1331434184 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1331434184;
        // ---------- Original Method ----------
        //return object instanceof Constructor && toString().equals(object.toString());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.944 -0400", hash_original_method = "CE10C7360422171346CFCFE4390D0CD4", hash_generated_method = "EB064B6FFF79EFE1FDCB563168406E22")
    public Class<T> getDeclaringClass() {
Class<T> var55840ACAE88F5536515BB8E6ADD923C6_998531833 =         declaringClass;
        var55840ACAE88F5536515BB8E6ADD923C6_998531833.addTaint(taint);
        return var55840ACAE88F5536515BB8E6ADD923C6_998531833;
        // ---------- Original Method ----------
        //return declaringClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.944 -0400", hash_original_method = "0803D161ECCDE8E4916E8597C31C5EAF", hash_generated_method = "0372F5F5C406C3C19BE3DB07D148501A")
    public Class<?>[] getExceptionTypes() {
        if(exceptionTypes == null)        
        {
Class<?>[] varE954D1DB65BB4FD70AD6204227C6F506_435476979 =             EmptyArray.CLASS;
            varE954D1DB65BB4FD70AD6204227C6F506_435476979.addTaint(taint);
            return varE954D1DB65BB4FD70AD6204227C6F506_435476979;
        } //End block
Class<?>[] varDA0125CDA48071C4AD5C63141D7B3037_1657630068 =         exceptionTypes.clone();
        varDA0125CDA48071C4AD5C63141D7B3037_1657630068.addTaint(taint);
        return varDA0125CDA48071C4AD5C63141D7B3037_1657630068;
        // ---------- Original Method ----------
        //if (exceptionTypes == null) {
            //return EmptyArray.CLASS;
        //}
        //return exceptionTypes.clone();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.944 -0400", hash_original_method = "75F84F634C025C373FC5DFC6F2FEAE7E", hash_generated_method = "EC7B4007C5946A9992232A8903D7FA28")
    public int getModifiers() {
        int var3D5D6FB7EE785F40601FDFE4E8B5F167_1560415861 = (Method.getMethodModifiers(declaringClass, slot));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_283245934 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_283245934;
        // ---------- Original Method ----------
        //return Method.getMethodModifiers(declaringClass, slot);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.945 -0400", hash_original_method = "64DF6B8C865C11FF9D8C98657107C7C5", hash_generated_method = "52D0D288D520303CA88DDF599D9769AF")
    public String getName() {
String varB4CCF06CFE87AC518D337F45219126F6_395612563 =         declaringClass.getName();
        varB4CCF06CFE87AC518D337F45219126F6_395612563.addTaint(taint);
        return varB4CCF06CFE87AC518D337F45219126F6_395612563;
        // ---------- Original Method ----------
        //return declaringClass.getName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.945 -0400", hash_original_method = "860AC8CD4E2F5F390A65618A1941DEDE", hash_generated_method = "DB204E42C79544FDC3F742263F845B46")
    public Class<?>[] getParameterTypes() {
Class<?>[] var5C3F1AD275E23F393681FEA8A66E0F80_818691122 =         parameterTypes.clone();
        var5C3F1AD275E23F393681FEA8A66E0F80_818691122.addTaint(taint);
        return var5C3F1AD275E23F393681FEA8A66E0F80_818691122;
        // ---------- Original Method ----------
        //return parameterTypes.clone();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.946 -0400", hash_original_method = "70A1497759834DE033251D58FB1BC60F", hash_generated_method = "FC117460764535969726C4A4D1C79B87")
    @SuppressWarnings("unused")
    private String getSignature() {
        StringBuilder result = new StringBuilder();
        result.append('(');
for(int i = 0;i < parameterTypes.length;i++)
        {
            result.append(getSignature(parameterTypes[i]));
        } //End block
        result.append(")V");
String varE65B3A02759122992CB82C0E651AD408_1485784661 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_1485784661.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_1485784661;
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder();
        //result.append('(');
        //for (int i = 0; i < parameterTypes.length; i++) {
            //result.append(getSignature(parameterTypes[i]));
        //}
        //result.append(")V");
        //return result.toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.946 -0400", hash_original_method = "B8D03AB769FE0736E7C02030ACA8679C", hash_generated_method = "75BDD4353513AED8BAE6B7021145B730")
    @Override
    public int hashCode() {
        int var97279D0B088E61DAFBD188BDBD8D2AA4_1164510164 = (declaringClass.getName().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_763776977 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_763776977;
        // ---------- Original Method ----------
        //return declaringClass.getName().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.947 -0400", hash_original_method = "E7355AF509FB0F598B5C977468B592C4", hash_generated_method = "50C76DA21543D2C93B2D607AF013AE9A")
    public T newInstance(Object... args) throws InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        addTaint(args[0].getTaint());
T var21285D308A0AF4A83E6B1D541C321546_517351354 =         constructNative (args, declaringClass, parameterTypes, slot, flag);
        var21285D308A0AF4A83E6B1D541C321546_517351354.addTaint(taint);
        return var21285D308A0AF4A83E6B1D541C321546_517351354;
        // ---------- Original Method ----------
        //return constructNative (args, declaringClass, parameterTypes, slot, flag);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.723 -0400", hash_original_method = "847A043CD7E53CD248ABB6D5FEBEB21F", hash_generated_method = "AB7A646FD776CAA4E845EC2470DC079B")
    private T constructNative(Object[] args, Class<T> declaringClass,
            Class<?>[] parameterTypes, int slot,
            boolean noAccessCheck) throws InstantiationException, IllegalAccessException,
            InvocationTargetException {
    	addTaint(args[0].taint);
    	addTaint(declaringClass.taint);
    	addTaint(parameterTypes[0].taint);
    	addTaint(slot);
    	addTaint(noAccessCheck);
    	return (T)new Object();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.948 -0400", hash_original_method = "4738B09E6DE786765E7966DA89BB1975", hash_generated_method = "DE42C54BF0379E8C3E2F3E6B8AB1F059")
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(Modifier.toString(getModifiers()));
        if(result.length() != 0)        
        result.append(' ');
        result.append(declaringClass.getName());
        result.append("(");
        result.append(toString(parameterTypes));
        result.append(")");
        if(exceptionTypes != null && exceptionTypes.length != 0)        
        {
            result.append(" throws ");
            result.append(toString(exceptionTypes));
        } //End block
String varE65B3A02759122992CB82C0E651AD408_1773048220 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_1773048220.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_1773048220;
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

