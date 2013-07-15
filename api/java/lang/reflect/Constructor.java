package java.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.lang.annotation.Annotation;
import libcore.util.EmptyArray;
import org.apache.harmony.kernel.vm.StringUtils;
import org.apache.harmony.luni.lang.reflect.GenericSignatureParser;
import org.apache.harmony.luni.lang.reflect.ListOfTypes;
import org.apache.harmony.luni.lang.reflect.Types;

public final class Constructor<T> extends AccessibleObject implements GenericDeclaration, Member {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.950 -0400", hash_original_field = "02CBE457FB1B22631E594CE79672D2F1", hash_generated_field = "A496C5D8F7CD0CB9CA97840555DF2AAA")

    Class<T> declaringClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.951 -0400", hash_original_field = "11427856321C6E9F5321CA879704C8FE", hash_generated_field = "6A17A418C19B2E2A1B1FDDDFEF7489B2")

    Class<?>[] parameterTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.951 -0400", hash_original_field = "2CD56E5B83C33F80B2D25820C51596A0", hash_generated_field = "0166CFA676A3372FA7BAE30D743E0654")

    Class<?>[] exceptionTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.951 -0400", hash_original_field = "6BB2E1AD8EE7DCCA935DA6ACF3D7474E", hash_generated_field = "1086E50AEBD292B3AD2410822F2C4F08")

    ListOfTypes genericExceptionTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.951 -0400", hash_original_field = "175F1F0CE81CA486282E77D84F1E1386", hash_generated_field = "8AC26B514C4DE93BC9F36D116E4A4BC6")

    ListOfTypes genericParameterTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.951 -0400", hash_original_field = "898BB6A86E0DA433332CBC4F55D3E967", hash_generated_field = "AEB06F4FE88A2F3FB2B5EFC21C88983B")

    TypeVariable<Constructor<T>>[] formalTypeParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.951 -0400", hash_original_field = "95A2153C74405BE971B467AB79B769A0", hash_generated_field = "89FDBAE6DE2AE55271071C78F774F101")

    private volatile boolean genericTypesAreInitialized = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.952 -0400", hash_original_field = "5E97994ED38A2B2F984F3B2B75012BF8", hash_generated_field = "09F7A5BA4BC6B04AB18035FB41A6CB6C")

    int slot;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.952 -0400", hash_original_method = "F22CB981733D75C2BC34BDB791B93657", hash_generated_method = "5981B35754AB4E8CEEDEF9BB5EC55BCB")
	public  Constructor() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.953 -0400", hash_original_method = "4E2CA9FC94A5B82D01ACB923AD24E02D", hash_generated_method = "18F52CB63607F7362AB53F7022A29477")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.954 -0400", hash_original_method = "ED32915D16D10FD7E30E61397009B806", hash_generated_method = "8C2846F25BB3F03FA2834DBE67122EDE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.955 -0400", hash_original_method = "C62B79950C859BF71BE9288BB0AB9C37", hash_generated_method = "B09D766FE865FFE5EE3E6A8BC5E92686")
    @Override
     String getSignatureAttribute() {
        Object[] annotation = Method.getSignatureAnnotation(declaringClass, slot);
    if(annotation == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1904914411 =             null;
            var540C13E9E156B687226421B24F2DF178_1904914411.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1904914411;
        } //End block
String var2F8E51633C4B934C6A6871930033C26B_1077421858 =         StringUtils.combineStrings(annotation);
        var2F8E51633C4B934C6A6871930033C26B_1077421858.addTaint(taint);
        return var2F8E51633C4B934C6A6871930033C26B_1077421858;
        // ---------- Original Method ----------
        //Object[] annotation = Method.getSignatureAnnotation(declaringClass, slot);
        //if (annotation == null) {
            //return null;
        //}
        //return StringUtils.combineStrings(annotation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.955 -0400", hash_original_method = "085B8CB42A6E3AC80C8A5E5B20AAB41A", hash_generated_method = "58B9EC4E28C438ACF653634B34EA06D0")
    public TypeVariable<Constructor<T>>[] getTypeParameters() {
        initGenericTypes();
TypeVariable<Constructor<T>>[] var530714F4AE8FC705F00A16C33AA9F354_614669536 =         formalTypeParameters.clone();
        var530714F4AE8FC705F00A16C33AA9F354_614669536.addTaint(taint);
        return var530714F4AE8FC705F00A16C33AA9F354_614669536;
        // ---------- Original Method ----------
        //initGenericTypes();
        //return formalTypeParameters.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.956 -0400", hash_original_method = "BD69A0542CEC9A8352D572DD82647C37", hash_generated_method = "C7D65DB3FB486B4F272357690A51A02B")
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
String var2460B846747F8B22185AD8BE722266A5_770365075 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_770365075.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_770365075;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.957 -0400", hash_original_method = "A9CCE739D5419EE3EB1324AC76C431BA", hash_generated_method = "7D387621FA672AD74C064DDEBB9F7E20")
    public Type[] getGenericParameterTypes() {
        initGenericTypes();
Type[] var5CB4FE98CE4670BB8FD40D4DEBE96905_273458394 =         Types.getClonedTypeArray(genericParameterTypes);
        var5CB4FE98CE4670BB8FD40D4DEBE96905_273458394.addTaint(taint);
        return var5CB4FE98CE4670BB8FD40D4DEBE96905_273458394;
        // ---------- Original Method ----------
        //initGenericTypes();
        //return Types.getClonedTypeArray(genericParameterTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.960 -0400", hash_original_method = "D98F12BC8A74E89DDBE36E53E80FD275", hash_generated_method = "CC58CC2D483424EBB5170C4FC6198638")
    public Type[] getGenericExceptionTypes() {
        initGenericTypes();
Type[] var5B58D007921425E5297F5C75058387B8_2141367989 =         Types.getClonedTypeArray(genericExceptionTypes);
        var5B58D007921425E5297F5C75058387B8_2141367989.addTaint(taint);
        return var5B58D007921425E5297F5C75058387B8_2141367989;
        // ---------- Original Method ----------
        //initGenericTypes();
        //return Types.getClonedTypeArray(genericExceptionTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.961 -0400", hash_original_method = "4F7DC07C64174CDAA43175ECC599103D", hash_generated_method = "7BA50723433536653FCC4D80DE9D32D5")
    @Override
    public Annotation[] getDeclaredAnnotations() {
Annotation[] varCEB162A873EFD10835F6CE1FB96D8CB2_636716379 =         Method.getDeclaredAnnotations(declaringClass, slot);
        varCEB162A873EFD10835F6CE1FB96D8CB2_636716379.addTaint(taint);
        return varCEB162A873EFD10835F6CE1FB96D8CB2_636716379;
        // ---------- Original Method ----------
        //return Method.getDeclaredAnnotations(declaringClass, slot);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.961 -0400", hash_original_method = "1A4BA94BF375F0F7A6512272530A6D39", hash_generated_method = "452DF60C0FF6BDFC9A6A80F52C45D7BA")
    @Override
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        addTaint(annotationType.getTaint());
    if(annotationType == null)        
        {
            NullPointerException varD3565833EFC12BC5822ABFE94D257EDE_122882119 = new NullPointerException("annotationType == null");
            varD3565833EFC12BC5822ABFE94D257EDE_122882119.addTaint(taint);
            throw varD3565833EFC12BC5822ABFE94D257EDE_122882119;
        } //End block
A var5417718CA49F9779F67999A1AA0ED4BB_1056788597 =         Method.getAnnotation(declaringClass, slot, annotationType);
        var5417718CA49F9779F67999A1AA0ED4BB_1056788597.addTaint(taint);
        return var5417718CA49F9779F67999A1AA0ED4BB_1056788597;
        // ---------- Original Method ----------
        //if (annotationType == null) {
            //throw new NullPointerException("annotationType == null");
        //}
        //return Method.getAnnotation(declaringClass, slot, annotationType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.962 -0400", hash_original_method = "DC6811BC307F5F500FE8FCDF979C7822", hash_generated_method = "60D576E28A3FE590DBC4EEA49164A29C")
    @Override
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        addTaint(annotationType.getTaint());
    if(annotationType == null)        
        {
            NullPointerException varD3565833EFC12BC5822ABFE94D257EDE_1135763233 = new NullPointerException("annotationType == null");
            varD3565833EFC12BC5822ABFE94D257EDE_1135763233.addTaint(taint);
            throw varD3565833EFC12BC5822ABFE94D257EDE_1135763233;
        } //End block
        boolean var89CB16F80799F534D0464C04A07CF9A6_1015721709 = (Method.isAnnotationPresent(declaringClass, slot, annotationType));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_905869731 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_905869731;
        // ---------- Original Method ----------
        //if (annotationType == null) {
            //throw new NullPointerException("annotationType == null");
        //}
        //return Method.isAnnotationPresent(declaringClass, slot, annotationType);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.962 -0400", hash_original_method = "15C5C292A9A80BF83F51CF39D22A468B", hash_generated_method = "E864497F23F15C64818E87B1C92B8415")
    public Annotation[][] getParameterAnnotations() {
        Annotation[][] parameterAnnotations = Method.getParameterAnnotations(declaringClass, slot);
    if(parameterAnnotations.length == 0)        
        {
Annotation[][] var15C5F2AAEB28119B840E422D93DB09D2_1928347386 =             Method.noAnnotations(parameterTypes.length);
            var15C5F2AAEB28119B840E422D93DB09D2_1928347386.addTaint(taint);
            return var15C5F2AAEB28119B840E422D93DB09D2_1928347386;
        } //End block
Annotation[][] varAD240742A5BFADFDA08547188EAD9960_2129773125 =         parameterAnnotations;
        varAD240742A5BFADFDA08547188EAD9960_2129773125.addTaint(taint);
        return varAD240742A5BFADFDA08547188EAD9960_2129773125;
        // ---------- Original Method ----------
        //Annotation[][] parameterAnnotations
                //= Method.getParameterAnnotations(declaringClass, slot);
        //if (parameterAnnotations.length == 0) {
            //return Method.noAnnotations(parameterTypes.length);
        //}
        //return parameterAnnotations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.963 -0400", hash_original_method = "27084EEDAB7B32E40BFE6AC29F04C9B8", hash_generated_method = "C90F098A98A8282BB8C52A2E00B25DBF")
    public boolean isVarArgs() {
        int mods = Method.getMethodModifiers(declaringClass, slot);
        boolean var86DAE4C613A84946DC68E64495A528D2_1116603657 = ((mods & Modifier.VARARGS) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2018911997 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2018911997;
        // ---------- Original Method ----------
        //int mods = Method.getMethodModifiers(declaringClass, slot);
        //return (mods & Modifier.VARARGS) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.963 -0400", hash_original_method = "98AC39075FB2CBC83E161E978A13C606", hash_generated_method = "6A39ECEDF83E93A10E30DC990F088154")
    public boolean isSynthetic() {
        int mods = Method.getMethodModifiers(declaringClass, slot);
        boolean varBAC0FB6B5CDCE03373AF4C7AA6974822_2056287181 = ((mods & Modifier.SYNTHETIC) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1474285695 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1474285695;
        // ---------- Original Method ----------
        //int mods = Method.getMethodModifiers(declaringClass, slot);
        //return (mods & Modifier.SYNTHETIC) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.964 -0400", hash_original_method = "B30900BF5B4B7FDD7368A6CB9464E167", hash_generated_method = "E495BDC2C40952D33F6D7C4634CEFB63")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        boolean varEA1FEBC74C07235B6607AFA36D5D2D7F_1593207452 = (object instanceof Constructor && toString().equals(object.toString()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_497927371 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_497927371;
        // ---------- Original Method ----------
        //return object instanceof Constructor && toString().equals(object.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.964 -0400", hash_original_method = "CE10C7360422171346CFCFE4390D0CD4", hash_generated_method = "26AA12516BD37D18F3930AE5B9AC3C85")
    public Class<T> getDeclaringClass() {
Class<T> var55840ACAE88F5536515BB8E6ADD923C6_1960450849 =         declaringClass;
        var55840ACAE88F5536515BB8E6ADD923C6_1960450849.addTaint(taint);
        return var55840ACAE88F5536515BB8E6ADD923C6_1960450849;
        // ---------- Original Method ----------
        //return declaringClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.964 -0400", hash_original_method = "0803D161ECCDE8E4916E8597C31C5EAF", hash_generated_method = "A223140361D0B3AA424A451D880DB872")
    public Class<?>[] getExceptionTypes() {
    if(exceptionTypes == null)        
        {
Class<?>[] varE954D1DB65BB4FD70AD6204227C6F506_430049724 =             EmptyArray.CLASS;
            varE954D1DB65BB4FD70AD6204227C6F506_430049724.addTaint(taint);
            return varE954D1DB65BB4FD70AD6204227C6F506_430049724;
        } //End block
Class<?>[] varDA0125CDA48071C4AD5C63141D7B3037_994244087 =         exceptionTypes.clone();
        varDA0125CDA48071C4AD5C63141D7B3037_994244087.addTaint(taint);
        return varDA0125CDA48071C4AD5C63141D7B3037_994244087;
        // ---------- Original Method ----------
        //if (exceptionTypes == null) {
            //return EmptyArray.CLASS;
        //}
        //return exceptionTypes.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.965 -0400", hash_original_method = "75F84F634C025C373FC5DFC6F2FEAE7E", hash_generated_method = "B5BFE895180A114CA44699133F91312A")
    public int getModifiers() {
        int var3D5D6FB7EE785F40601FDFE4E8B5F167_1051745807 = (Method.getMethodModifiers(declaringClass, slot));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_129175643 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_129175643;
        // ---------- Original Method ----------
        //return Method.getMethodModifiers(declaringClass, slot);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.965 -0400", hash_original_method = "64DF6B8C865C11FF9D8C98657107C7C5", hash_generated_method = "FDA978064850BB8383CB8C48FD530D5D")
    public String getName() {
String varB4CCF06CFE87AC518D337F45219126F6_354172290 =         declaringClass.getName();
        varB4CCF06CFE87AC518D337F45219126F6_354172290.addTaint(taint);
        return varB4CCF06CFE87AC518D337F45219126F6_354172290;
        // ---------- Original Method ----------
        //return declaringClass.getName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.965 -0400", hash_original_method = "860AC8CD4E2F5F390A65618A1941DEDE", hash_generated_method = "4C3419949BA389E92273F0F5F15AC508")
    public Class<?>[] getParameterTypes() {
Class<?>[] var5C3F1AD275E23F393681FEA8A66E0F80_1365122307 =         parameterTypes.clone();
        var5C3F1AD275E23F393681FEA8A66E0F80_1365122307.addTaint(taint);
        return var5C3F1AD275E23F393681FEA8A66E0F80_1365122307;
        // ---------- Original Method ----------
        //return parameterTypes.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.966 -0400", hash_original_method = "70A1497759834DE033251D58FB1BC60F", hash_generated_method = "FDE65BA6F2636D91EE14016F143E9185")
    @SuppressWarnings("unused")
    private String getSignature() {
        StringBuilder result = new StringBuilder();
        result.append('(');
for(int i = 0;i < parameterTypes.length;i++)
        {
            result.append(getSignature(parameterTypes[i]));
        } //End block
        result.append(")V");
String varE65B3A02759122992CB82C0E651AD408_212605422 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_212605422.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_212605422;
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder();
        //result.append('(');
        //for (int i = 0; i < parameterTypes.length; i++) {
            //result.append(getSignature(parameterTypes[i]));
        //}
        //result.append(")V");
        //return result.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.966 -0400", hash_original_method = "B8D03AB769FE0736E7C02030ACA8679C", hash_generated_method = "4F388C760941C69E191E0B934716108B")
    @Override
    public int hashCode() {
        int var97279D0B088E61DAFBD188BDBD8D2AA4_1249442860 = (declaringClass.getName().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_349179969 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_349179969;
        // ---------- Original Method ----------
        //return declaringClass.getName().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.966 -0400", hash_original_method = "E7355AF509FB0F598B5C977468B592C4", hash_generated_method = "B5465FC507BD6F452933C6E2694FB6C5")
    public T newInstance(Object... args) throws InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        addTaint(args[0].getTaint());
T var21285D308A0AF4A83E6B1D541C321546_1238813355 =         constructNative (args, declaringClass, parameterTypes, slot, flag);
        var21285D308A0AF4A83E6B1D541C321546_1238813355.addTaint(taint);
        return var21285D308A0AF4A83E6B1D541C321546_1238813355;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.967 -0400", hash_original_method = "4738B09E6DE786765E7966DA89BB1975", hash_generated_method = "CCEC7299AEF728E7AB88BC6389CAD649")
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
String varE65B3A02759122992CB82C0E651AD408_34058575 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_34058575.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_34058575;
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

