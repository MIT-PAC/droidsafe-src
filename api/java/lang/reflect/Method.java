package java.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.lang.annotation.Annotation;
import java.util.Comparator;
import libcore.util.EmptyArray;
import org.apache.harmony.kernel.vm.StringUtils;
import org.apache.harmony.luni.lang.reflect.GenericSignatureParser;
import org.apache.harmony.luni.lang.reflect.ListOfTypes;
import org.apache.harmony.luni.lang.reflect.Types;

public final class Method extends AccessibleObject implements GenericDeclaration, Member {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.111 -0400", hash_original_field = "5E97994ED38A2B2F984F3B2B75012BF8", hash_generated_field = "6B06F56F1EB868ADA8CFFD63973A7E09")

    private int slot;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.111 -0400", hash_original_field = "02CBE457FB1B22631E594CE79672D2F1", hash_generated_field = "EC96049C106D95C970CBF94E8CE21744")

    private Class<?> declaringClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.112 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.112 -0400", hash_original_field = "11427856321C6E9F5321CA879704C8FE", hash_generated_field = "2BEA8A3EFDFBD76D3A4CCA6C3AC7E53C")

    private Class<?>[] parameterTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.112 -0400", hash_original_field = "2CD56E5B83C33F80B2D25820C51596A0", hash_generated_field = "2A0AC8F9632DF82B378D2F01BC74BDF4")

    private Class<?>[] exceptionTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.112 -0400", hash_original_field = "9CD6843F4536590CD86F933708C7371E", hash_generated_field = "052C26419A9A6CDFB48BC17097CACAE9")

    private Class<?> returnType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.112 -0400", hash_original_field = "6BB2E1AD8EE7DCCA935DA6ACF3D7474E", hash_generated_field = "924C48D07F65387E616D3CE31DE5954D")

    private ListOfTypes genericExceptionTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.112 -0400", hash_original_field = "175F1F0CE81CA486282E77D84F1E1386", hash_generated_field = "4E98B7DC70F3037D11B527C2E4899BBD")

    private ListOfTypes genericParameterTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.112 -0400", hash_original_field = "40B35D47678E42F2607E0F522DC3BF6F", hash_generated_field = "32E37E22BB1C76784903951645BC45C1")

    private Type genericReturnType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.112 -0400", hash_original_field = "898BB6A86E0DA433332CBC4F55D3E967", hash_generated_field = "4338B9C9877379FEA81BE0E690FD4B47")

    private TypeVariable<Method>[] formalTypeParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.112 -0400", hash_original_field = "95A2153C74405BE971B467AB79B769A0", hash_generated_field = "89FDBAE6DE2AE55271071C78F774F101")

    private volatile boolean genericTypesAreInitialized = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.112 -0400", hash_original_method = "70F1F77231BFE73E3138A8A58A15C35C", hash_generated_method = "5EF4B9B8E33D0C3D9148CA2297534CC4")
      Method(Method orig) {
        this(orig.declaringClass, orig.parameterTypes, orig.exceptionTypes,
                orig.returnType, orig.name, orig.slot);
        addTaint(orig.getTaint());
        if(orig.flag)        
        {
            this.flag = true;
        } //End block
        // ---------- Original Method ----------
        //if (orig.flag) {
            //this.flag = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.114 -0400", hash_original_method = "F4B9C750B34D03AFED72DBA84048C99D", hash_generated_method = "A3295A616BA9759E667254D439272654")
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.114 -0400", hash_original_method = "0BE83C703D137B5A5A60EFAA17178485", hash_generated_method = "B061F471572EBB6A1BD1322A5027D98C")
    private synchronized void initGenericTypes() {
        if(!genericTypesAreInitialized)        
        {
            String signatureAttribute = getSignatureAttribute();
            GenericSignatureParser parser = new GenericSignatureParser(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.115 -0400", hash_original_method = "0F068F731FE610BBACFD836E6A61AACF", hash_generated_method = "A0F5615E32A5EC513455A34F9C1A7B3B")
    public TypeVariable<Method>[] getTypeParameters() {
        initGenericTypes();
TypeVariable<Method>[] var530714F4AE8FC705F00A16C33AA9F354_761256114 =         formalTypeParameters.clone();
        var530714F4AE8FC705F00A16C33AA9F354_761256114.addTaint(taint);
        return var530714F4AE8FC705F00A16C33AA9F354_761256114;
        // ---------- Original Method ----------
        //initGenericTypes();
        //return formalTypeParameters.clone();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.115 -0400", hash_original_method = "1CDF5107AC443AA5F8C2E1DA9DF559A0", hash_generated_method = "A0D67ED9337C81F3DC4D86FA254770C3")
    @Override
     String getSignatureAttribute() {
        Object[] annotation = getSignatureAnnotation(declaringClass, slot);
        if(annotation == null)        
        {
String var540C13E9E156B687226421B24F2DF178_867243218 =             null;
            var540C13E9E156B687226421B24F2DF178_867243218.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_867243218;
        } //End block
String var2F8E51633C4B934C6A6871930033C26B_192298750 =         StringUtils.combineStrings(annotation);
        var2F8E51633C4B934C6A6871930033C26B_192298750.addTaint(taint);
        return var2F8E51633C4B934C6A6871930033C26B_192298750;
        // ---------- Original Method ----------
        //Object[] annotation = getSignatureAnnotation(declaringClass, slot);
        //if (annotation == null) {
            //return null;
        //}
        //return StringUtils.combineStrings(annotation);
    }

    
    @DSModeled(DSC.SAFE)
    static Object[] getSignatureAnnotation(Class declaringClass, int slot) {
		Object[] ret = new Object[0];
		ret[0].addTaint(declaringClass.taint);
		ret[0].addTaint(slot);
		return ret;
	}

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.117 -0400", hash_original_method = "060018D8556E7858267AA04DC5F84FE8", hash_generated_method = "42BB2CFEB68D1EC7847543FD95859006")
    public String toGenericString() {
        StringBuilder sb = new StringBuilder(80);
        initGenericTypes();
        int modifier = getModifiers();
        if(modifier != 0)        
        {
            sb.append(Modifier.toString(modifier & ~(Modifier.BRIDGE +
                    Modifier.VARARGS))).append(' ');
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
        appendGenericType(sb, Types.getType(genericReturnType));
        sb.append(' ');
        appendArrayType(sb, getDeclaringClass());
        sb.append(".").append(getName());
        sb.append('(');
        appendArrayGenericType(sb,
                Types.getClonedTypeArray(genericParameterTypes));
        sb.append(')');
        Type[] genericExceptionTypeArray = Types.getClonedTypeArray(
                genericExceptionTypes);
        if(genericExceptionTypeArray.length > 0)        
        {
            sb.append(" throws ");
            appendArrayGenericType(sb, genericExceptionTypeArray);
        } //End block
String var2460B846747F8B22185AD8BE722266A5_853559711 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_853559711.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_853559711;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.117 -0400", hash_original_method = "A9CCE739D5419EE3EB1324AC76C431BA", hash_generated_method = "764DD15D78CD7E1B5FA1F96C17C0AD3B")
    public Type[] getGenericParameterTypes() {
        initGenericTypes();
Type[] var5CB4FE98CE4670BB8FD40D4DEBE96905_1540034169 =         Types.getClonedTypeArray(genericParameterTypes);
        var5CB4FE98CE4670BB8FD40D4DEBE96905_1540034169.addTaint(taint);
        return var5CB4FE98CE4670BB8FD40D4DEBE96905_1540034169;
        // ---------- Original Method ----------
        //initGenericTypes();
        //return Types.getClonedTypeArray(genericParameterTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.117 -0400", hash_original_method = "D98F12BC8A74E89DDBE36E53E80FD275", hash_generated_method = "A428A35994942F6A97141F5E38FEE37F")
    public Type[] getGenericExceptionTypes() {
        initGenericTypes();
Type[] var5B58D007921425E5297F5C75058387B8_134221316 =         Types.getClonedTypeArray(genericExceptionTypes);
        var5B58D007921425E5297F5C75058387B8_134221316.addTaint(taint);
        return var5B58D007921425E5297F5C75058387B8_134221316;
        // ---------- Original Method ----------
        //initGenericTypes();
        //return Types.getClonedTypeArray(genericExceptionTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.118 -0400", hash_original_method = "83125796E1541F4C47F8F2176AE50053", hash_generated_method = "D9D20CADA77B07A43A1599A4BB0EA8F1")
    public Type getGenericReturnType() {
        initGenericTypes();
Type varE9CB0FCB175642990439FADF1F4C9275_565282846 =         Types.getType(genericReturnType);
        varE9CB0FCB175642990439FADF1F4C9275_565282846.addTaint(taint);
        return varE9CB0FCB175642990439FADF1F4C9275_565282846;
        // ---------- Original Method ----------
        //initGenericTypes();
        //return Types.getType(genericReturnType);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.118 -0400", hash_original_method = "4122EC91CDDE6FFD9DA08F5ADAF8DB5D", hash_generated_method = "DCA9EC5412D94B35750422632F67E89D")
    @Override
    public Annotation[] getDeclaredAnnotations() {
Annotation[] varD68AC863F3425367D397905DE25428DB_1341655915 =         getDeclaredAnnotations(declaringClass, slot);
        varD68AC863F3425367D397905DE25428DB_1341655915.addTaint(taint);
        return varD68AC863F3425367D397905DE25428DB_1341655915;
        // ---------- Original Method ----------
        //return getDeclaredAnnotations(declaringClass, slot);
    }

    
    @DSModeled(DSC.SAFE)
    static Annotation[] getDeclaredAnnotations(Class<?> declaringClass, int slot) {
		Annotation[] ret = new Annotation[0];
		ret[0].addTaint(declaringClass.taint);
		ret[0].addTaint(slot);
		return ret;
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.118 -0400", hash_original_method = "C04F97610183E33B13FB9B4273375B6D", hash_generated_method = "1C787FA354E0C9F896C47EB81A5471B7")
    @Override
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        addTaint(annotationType.getTaint());
        if(annotationType == null)        
        {
            NullPointerException varD3565833EFC12BC5822ABFE94D257EDE_1545342916 = new NullPointerException("annotationType == null");
            varD3565833EFC12BC5822ABFE94D257EDE_1545342916.addTaint(taint);
            throw varD3565833EFC12BC5822ABFE94D257EDE_1545342916;
        } //End block
A varD37D33C5EE02B81A7F8EF45A88B88039_629409244 =         getAnnotation(declaringClass, slot, annotationType);
        varD37D33C5EE02B81A7F8EF45A88B88039_629409244.addTaint(taint);
        return varD37D33C5EE02B81A7F8EF45A88B88039_629409244;
        // ---------- Original Method ----------
        //if (annotationType == null) {
            //throw new NullPointerException("annotationType == null");
        //}
        //return getAnnotation(declaringClass, slot, annotationType);
    }

    
    @DSModeled(DSC.SAFE)
    static <A extends Annotation> A getAnnotation(Class<?> declaringClass, int slot, Class<A> annotationType) {
		A ret = (A) new Object();
		ret.addTaint(declaringClass.taint);
		ret.addTaint(slot);
		ret.addTaint(annotationType.taint);
		return ret;
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.119 -0400", hash_original_method = "D8B142EB73E138FF5927E6AE1DAD56D2", hash_generated_method = "DBF29A58AEAE77921988590CE976282E")
    @Override
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        addTaint(annotationType.getTaint());
        if(annotationType == null)        
        {
            NullPointerException varD3565833EFC12BC5822ABFE94D257EDE_1797046495 = new NullPointerException("annotationType == null");
            varD3565833EFC12BC5822ABFE94D257EDE_1797046495.addTaint(taint);
            throw varD3565833EFC12BC5822ABFE94D257EDE_1797046495;
        } //End block
        boolean var000A6E1BC96B3549B82B47E3D3F09F9E_107425709 = (isAnnotationPresent(declaringClass, slot, annotationType));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_864088786 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_864088786;
        // ---------- Original Method ----------
        //if (annotationType == null) {
            //throw new NullPointerException("annotationType == null");
        //}
        //return isAnnotationPresent(declaringClass, slot, annotationType);
    }

    
    @DSModeled(DSC.SAFE)
    static boolean isAnnotationPresent(Class<?> declaringClass, int slot, Class<? extends Annotation> annotationType) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_770988985 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_770988985;
	}

    
    @DSModeled(DSC.SAFE)
    static Annotation[][] noAnnotations(int size) {
        Annotation[][] annotations = new Annotation[size][];
        for (int i = 0; i < size; i++) {
            annotations[i] = NO_ANNOTATIONS;
        }
        return annotations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.121 -0400", hash_original_method = "72FC508AEB582DBA9794440813C3A8B1", hash_generated_method = "100B060FF71A8EC82F8E4B4330232EF0")
    public Annotation[][] getParameterAnnotations() {
        Annotation[][] parameterAnnotations = getParameterAnnotations(declaringClass, slot);
        if(parameterAnnotations.length == 0)        
        {
Annotation[][] var4E66BBCD00A041352E83320D93FA2694_1668668642 =             noAnnotations(parameterTypes.length);
            var4E66BBCD00A041352E83320D93FA2694_1668668642.addTaint(taint);
            return var4E66BBCD00A041352E83320D93FA2694_1668668642;
        } //End block
Annotation[][] varAD240742A5BFADFDA08547188EAD9960_1940681231 =         parameterAnnotations;
        varAD240742A5BFADFDA08547188EAD9960_1940681231.addTaint(taint);
        return varAD240742A5BFADFDA08547188EAD9960_1940681231;
        // ---------- Original Method ----------
        //Annotation[][] parameterAnnotations
                //= getParameterAnnotations(declaringClass, slot);
        //if (parameterAnnotations.length == 0) {
            //return noAnnotations(parameterTypes.length);
        //}
        //return parameterAnnotations;
    }

    
    @DSModeled(DSC.SAFE)
    static Annotation[][] getParameterAnnotations(Class declaringClass, int slot) {
		Annotation[][] ret = new Annotation[0][0];
		ret[0][0].addTaint(declaringClass.taint);
		ret[0][0].addTaint(slot);
		return ret;
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.122 -0400", hash_original_method = "47D8C519D80AD7FA8ACDBB9291AF9C1F", hash_generated_method = "B7578A5FC3F2FB86BC61616D527AAF37")
    public boolean isVarArgs() {
        int modifiers = getMethodModifiers(declaringClass, slot);
        boolean varDB8F7C613030E76ABDF57D1E095E0DA1_1234217711 = ((modifiers & Modifier.VARARGS) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1443343062 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1443343062;
        // ---------- Original Method ----------
        //int modifiers = getMethodModifiers(declaringClass, slot);
        //return (modifiers & Modifier.VARARGS) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.122 -0400", hash_original_method = "F604FBBB689DE54F8A9C0A1F2713AB23", hash_generated_method = "D32174E1B4C323BC805017AF58FC2FA0")
    public boolean isBridge() {
        int modifiers = getMethodModifiers(declaringClass, slot);
        boolean var7AC4E48F64EC97F3BA2DCC6913561E32_566270711 = ((modifiers & Modifier.BRIDGE) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_604128019 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_604128019;
        // ---------- Original Method ----------
        //int modifiers = getMethodModifiers(declaringClass, slot);
        //return (modifiers & Modifier.BRIDGE) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.123 -0400", hash_original_method = "B698BCB06B0A737FF1A228493D2DEAD0", hash_generated_method = "56F15025FA73FD20F7F1A3FA63828DF2")
    public boolean isSynthetic() {
        int modifiers = getMethodModifiers(declaringClass, slot);
        boolean var4121DACD6E958BDDE7E5586D934BDBC5_209544678 = ((modifiers & Modifier.SYNTHETIC) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_826974058 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_826974058;
        // ---------- Original Method ----------
        //int modifiers = getMethodModifiers(declaringClass, slot);
        //return (modifiers & Modifier.SYNTHETIC) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.123 -0400", hash_original_method = "3DF570DF2B22E4E433BE61FA4A3252FF", hash_generated_method = "9C5F6862F769031FEB6E23674BB7BD38")
    public Object getDefaultValue() {
Object var2050B6E3550B605C703FF0CF43049C54_299126770 =         getDefaultValue(declaringClass, slot);
        var2050B6E3550B605C703FF0CF43049C54_299126770.addTaint(taint);
        return var2050B6E3550B605C703FF0CF43049C54_299126770;
        // ---------- Original Method ----------
        //return getDefaultValue(declaringClass, slot);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.884 -0400", hash_original_method = "01EB45D9363E910A54E557C442527E6E", hash_generated_method = "12453DE2F22689947CA412DBF05F783C")
	private Object getDefaultValue(Class declaringClass, int slot) {
		addTaint(declaringClass.taint);
		addTaint(slot);
		return new Object();
	}

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.123 -0400", hash_original_method = "AF56E5F5402F800187126545ABE1F97F", hash_generated_method = "C8BBA5340257B713151F45834E7D4D13")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        boolean varD7F46FF16C07E332D27AC9D839CE4DA6_263811338 = (object instanceof Method && toString().equals(object.toString()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_61259113 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_61259113;
        // ---------- Original Method ----------
        //return object instanceof Method && toString().equals(object.toString());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.124 -0400", hash_original_method = "747BEFE9985C4AF4EE3D5630B62185EA", hash_generated_method = "52625AE21E0899BD90A3565112F86E50")
    public Class<?> getDeclaringClass() {
Class<?> var55840ACAE88F5536515BB8E6ADD923C6_1894096704 =         declaringClass;
        var55840ACAE88F5536515BB8E6ADD923C6_1894096704.addTaint(taint);
        return var55840ACAE88F5536515BB8E6ADD923C6_1894096704;
        // ---------- Original Method ----------
        //return declaringClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.124 -0400", hash_original_method = "0803D161ECCDE8E4916E8597C31C5EAF", hash_generated_method = "3EB0C623764931E63BE52DC86BABFE8D")
    public Class<?>[] getExceptionTypes() {
        if(exceptionTypes == null)        
        {
Class<?>[] varE954D1DB65BB4FD70AD6204227C6F506_1919395676 =             EmptyArray.CLASS;
            varE954D1DB65BB4FD70AD6204227C6F506_1919395676.addTaint(taint);
            return varE954D1DB65BB4FD70AD6204227C6F506_1919395676;
        } //End block
Class<?>[] varDA0125CDA48071C4AD5C63141D7B3037_1127137059 =         exceptionTypes.clone();
        varDA0125CDA48071C4AD5C63141D7B3037_1127137059.addTaint(taint);
        return varDA0125CDA48071C4AD5C63141D7B3037_1127137059;
        // ---------- Original Method ----------
        //if (exceptionTypes == null) {
            //return EmptyArray.CLASS;
        //}
        //return exceptionTypes.clone();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.124 -0400", hash_original_method = "D61CFE217686483C8FB69E9FFDF592A9", hash_generated_method = "6E478EB4153CFDF8C9EF30EC98244D94")
    public int getModifiers() {
        int var1DB99E362433041866339AAFD9E83F4E_1020416565 = (getMethodModifiers(declaringClass, slot));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1407059598 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1407059598;
        // ---------- Original Method ----------
        //return getMethodModifiers(declaringClass, slot);
    }

    
    @DSModeled(DSC.SAFE)
    static int getMethodModifiers(Class<?> declaringClass, int slot) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1822823721 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1822823721;
	}

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.125 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "8A44B459E72EAF0468F83609D1EFF16C")
    public String getName() {
String varB017984728AC60AD1F0BF8734F33F15C_1445349259 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_1445349259.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_1445349259;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.125 -0400", hash_original_method = "860AC8CD4E2F5F390A65618A1941DEDE", hash_generated_method = "C4EC3CAA2AE33938D94FBF8AEF2AA291")
    public Class<?>[] getParameterTypes() {
Class<?>[] var5C3F1AD275E23F393681FEA8A66E0F80_95340465 =         parameterTypes.clone();
        var5C3F1AD275E23F393681FEA8A66E0F80_95340465.addTaint(taint);
        return var5C3F1AD275E23F393681FEA8A66E0F80_95340465;
        // ---------- Original Method ----------
        //return parameterTypes.clone();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.125 -0400", hash_original_method = "952CC59854183D9751F85A9597A378CE", hash_generated_method = "8301BBBF10052441A735A0B37E30F76C")
    public Class<?> getReturnType() {
Class<?> varDC9AC92D1699491F328099759E5C37AE_2007676233 =         returnType;
        varDC9AC92D1699491F328099759E5C37AE_2007676233.addTaint(taint);
        return varDC9AC92D1699491F328099759E5C37AE_2007676233;
        // ---------- Original Method ----------
        //return returnType;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.126 -0400", hash_original_method = "EF5D8B81A9E09E0C38DFC15BA422ECA1", hash_generated_method = "7F89D5DB5582D921290FCC9031635F2D")
    @Override
    public int hashCode() {
        int var5715838B66EDF423F24A871806972EB3_845793513 = (name.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_524382892 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_524382892;
        // ---------- Original Method ----------
        //return name.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.126 -0400", hash_original_method = "4A7D773CBB2CABEB3FBD24437D2F9CE8", hash_generated_method = "3E88E9D7D2EE8FD41AF42323F36D233B")
    public Object invoke(Object receiver, Object... args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        addTaint(args[0].getTaint());
        addTaint(receiver.getTaint());
        if(args == null)        
        {
            args = EmptyArray.OBJECT;
        } //End block
Object var928BD79CB12005B507BD2576AE0166BF_1517613077 =         invokeNative(receiver, args, declaringClass, parameterTypes, returnType, slot, flag);
        var928BD79CB12005B507BD2576AE0166BF_1517613077.addTaint(taint);
        return var928BD79CB12005B507BD2576AE0166BF_1517613077;
        // ---------- Original Method ----------
        //if (args == null) {
            //args = EmptyArray.OBJECT;
        //}
        //return invokeNative(receiver, args, declaringClass, parameterTypes, returnType, slot, flag);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.898 -0400", hash_original_method = "0E030E32F68EF389669F95D53DF2EFAB", hash_generated_method = "5C866D8DF0795175296282F6D723F5B5")
	private Object invokeNative(Object obj, Object[] args, Class<?> declaringClass, Class<?>[] parameterTypes, Class<?> returnType, int slot, boolean noAccessCheck)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		addTaint(obj.taint);
		addTaint(args[0].taint);
		addTaint(declaringClass.taint);
		addTaint(parameterTypes[0].taint);
		addTaint(returnType.taint);
		addTaint(slot);
		addTaint(noAccessCheck);
		Object ret = new Object();
		return ret;
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.127 -0400", hash_original_method = "20379CC138163D24505D982E1BF3267A", hash_generated_method = "256C72828D8D9F5981AF7BC4A67CB206")
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(Modifier.toString(getModifiers()));
        if(result.length() != 0)        
        result.append(' ');
        result.append(returnType.getName());
        result.append(' ');
        result.append(declaringClass.getName());
        result.append('.');
        result.append(name);
        result.append("(");
        result.append(toString(parameterTypes));
        result.append(")");
        if(exceptionTypes != null && exceptionTypes.length != 0)        
        {
            result.append(" throws ");
            result.append(toString(exceptionTypes));
        } //End block
String varE65B3A02759122992CB82C0E651AD408_1656719205 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_1656719205.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_1656719205;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.127 -0400", hash_original_method = "C4F068AB884B2FBA426F9E4B4EB5335D", hash_generated_method = "712DE136F04A97734533B0B3794726A9")
    @SuppressWarnings("unused")
    private String getSignature() {
        StringBuilder result = new StringBuilder();
        result.append('(');
for(int i = 0;i < parameterTypes.length;i++)
        {
            result.append(getSignature(parameterTypes[i]));
        } //End block
        result.append(')');
        result.append(getSignature(returnType));
String varE65B3A02759122992CB82C0E651AD408_1455360506 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_1455360506.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_1455360506;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.128 -0400", hash_original_field = "6D5C49EE7CEF5783A42FC1C7653D6955", hash_generated_field = "3465881694FBE3BA7144100AF6865EE1")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.128 -0400", hash_original_field = "34D6D6954DE3EDD110F2D639DA598DA0", hash_generated_field = "D584CD4D5524F6C731424F703C29B84F")

    private static final Annotation[] NO_ANNOTATIONS = new Annotation[0];
    // orphaned legacy method
    public Method() {

	}
    
    // orphaned legacy method
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
    
}

