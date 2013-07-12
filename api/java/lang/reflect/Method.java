package java.lang.reflect;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.106 -0400", hash_original_field = "5E97994ED38A2B2F984F3B2B75012BF8", hash_generated_field = "6B06F56F1EB868ADA8CFFD63973A7E09")

    private int slot;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.106 -0400", hash_original_field = "02CBE457FB1B22631E594CE79672D2F1", hash_generated_field = "EC96049C106D95C970CBF94E8CE21744")

    private Class<?> declaringClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.106 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.106 -0400", hash_original_field = "11427856321C6E9F5321CA879704C8FE", hash_generated_field = "2BEA8A3EFDFBD76D3A4CCA6C3AC7E53C")

    private Class<?>[] parameterTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.107 -0400", hash_original_field = "2CD56E5B83C33F80B2D25820C51596A0", hash_generated_field = "2A0AC8F9632DF82B378D2F01BC74BDF4")

    private Class<?>[] exceptionTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.107 -0400", hash_original_field = "9CD6843F4536590CD86F933708C7371E", hash_generated_field = "052C26419A9A6CDFB48BC17097CACAE9")

    private Class<?> returnType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.107 -0400", hash_original_field = "6BB2E1AD8EE7DCCA935DA6ACF3D7474E", hash_generated_field = "924C48D07F65387E616D3CE31DE5954D")

    private ListOfTypes genericExceptionTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.107 -0400", hash_original_field = "175F1F0CE81CA486282E77D84F1E1386", hash_generated_field = "4E98B7DC70F3037D11B527C2E4899BBD")

    private ListOfTypes genericParameterTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.107 -0400", hash_original_field = "40B35D47678E42F2607E0F522DC3BF6F", hash_generated_field = "32E37E22BB1C76784903951645BC45C1")

    private Type genericReturnType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.107 -0400", hash_original_field = "898BB6A86E0DA433332CBC4F55D3E967", hash_generated_field = "4338B9C9877379FEA81BE0E690FD4B47")

    private TypeVariable<Method>[] formalTypeParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.107 -0400", hash_original_field = "95A2153C74405BE971B467AB79B769A0", hash_generated_field = "89FDBAE6DE2AE55271071C78F774F101")

    private volatile boolean genericTypesAreInitialized = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.108 -0400", hash_original_method = "70F1F77231BFE73E3138A8A58A15C35C", hash_generated_method = "5EF4B9B8E33D0C3D9148CA2297534CC4")
      Method(Method orig) {
        this(orig.declaringClass, orig.parameterTypes, orig.exceptionTypes,
                orig.returnType, orig.name, orig.slot);
        addTaint(orig.getTaint());
    if(orig.flag)        
        {
            this.flag = true;
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.110 -0400", hash_original_method = "F4B9C750B34D03AFED72DBA84048C99D", hash_generated_method = "A3295A616BA9759E667254D439272654")
    private  Method(Class<?> declaring, Class<?>[] paramTypes, Class<?>[] exceptTypes, Class<?> returnType, String name, int slot) {
        this.declaringClass = declaring;
        this.name = name;
        this.slot = slot;
        this.parameterTypes = paramTypes;
        this.exceptionTypes = exceptTypes;
        this.returnType = returnType;
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.111 -0400", hash_original_method = "0BE83C703D137B5A5A60EFAA17178485", hash_generated_method = "B061F471572EBB6A1BD1322A5027D98C")
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
        } 
        
        
            
            
                    
            
            
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.111 -0400", hash_original_method = "0F068F731FE610BBACFD836E6A61AACF", hash_generated_method = "BE7908664A50B5EA8FF09E3074D5C0EA")
    public TypeVariable<Method>[] getTypeParameters() {
        initGenericTypes();
TypeVariable<Method>[] var530714F4AE8FC705F00A16C33AA9F354_1990933339 =         formalTypeParameters.clone();
        var530714F4AE8FC705F00A16C33AA9F354_1990933339.addTaint(taint);
        return var530714F4AE8FC705F00A16C33AA9F354_1990933339;
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.111 -0400", hash_original_method = "1CDF5107AC443AA5F8C2E1DA9DF559A0", hash_generated_method = "E5373955752E3A1EFFA441C04E264263")
    @Override
     String getSignatureAttribute() {
        Object[] annotation = getSignatureAnnotation(declaringClass, slot);
    if(annotation == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1430336345 =             null;
            var540C13E9E156B687226421B24F2DF178_1430336345.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1430336345;
        } 
String var2F8E51633C4B934C6A6871930033C26B_23568815 =         StringUtils.combineStrings(annotation);
        var2F8E51633C4B934C6A6871930033C26B_23568815.addTaint(taint);
        return var2F8E51633C4B934C6A6871930033C26B_23568815;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    static Object[] getSignatureAnnotation(Class declaringClass, int slot) {
		Object[] ret = new Object[0];
		ret[0].addTaint(declaringClass.taint);
		ret[0].addTaint(slot);
		return ret;
	}

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.112 -0400", hash_original_method = "060018D8556E7858267AA04DC5F84FE8", hash_generated_method = "56616FDFD8D55B4C3FC339DF2F73A847")
    public String toGenericString() {
        StringBuilder sb = new StringBuilder(80);
        initGenericTypes();
        int modifier = getModifiers();
    if(modifier != 0)        
        {
            sb.append(Modifier.toString(modifier & ~(Modifier.BRIDGE +
                    Modifier.VARARGS))).append(' ');
        } 
    if(formalTypeParameters != null && formalTypeParameters.length > 0)        
        {
            sb.append('<');
for(int i = 0;i < formalTypeParameters.length;i++)
            {
                appendGenericType(sb, formalTypeParameters[i]);
    if(i < formalTypeParameters.length - 1)                
                {
                    sb.append(",");
                } 
            } 
            sb.append("> ");
        } 
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
        } 
String var2460B846747F8B22185AD8BE722266A5_581894298 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_581894298.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_581894298;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.113 -0400", hash_original_method = "A9CCE739D5419EE3EB1324AC76C431BA", hash_generated_method = "078A223E2854EB30BBFB4DA5CCFF59DB")
    public Type[] getGenericParameterTypes() {
        initGenericTypes();
Type[] var5CB4FE98CE4670BB8FD40D4DEBE96905_176577702 =         Types.getClonedTypeArray(genericParameterTypes);
        var5CB4FE98CE4670BB8FD40D4DEBE96905_176577702.addTaint(taint);
        return var5CB4FE98CE4670BB8FD40D4DEBE96905_176577702;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.113 -0400", hash_original_method = "D98F12BC8A74E89DDBE36E53E80FD275", hash_generated_method = "70E3C4EA7894FEDD75B6FD5674D23A7E")
    public Type[] getGenericExceptionTypes() {
        initGenericTypes();
Type[] var5B58D007921425E5297F5C75058387B8_1558385086 =         Types.getClonedTypeArray(genericExceptionTypes);
        var5B58D007921425E5297F5C75058387B8_1558385086.addTaint(taint);
        return var5B58D007921425E5297F5C75058387B8_1558385086;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.113 -0400", hash_original_method = "83125796E1541F4C47F8F2176AE50053", hash_generated_method = "E3BC7BCFCB0525F570A42332615D4D34")
    public Type getGenericReturnType() {
        initGenericTypes();
Type varE9CB0FCB175642990439FADF1F4C9275_1884313228 =         Types.getType(genericReturnType);
        varE9CB0FCB175642990439FADF1F4C9275_1884313228.addTaint(taint);
        return varE9CB0FCB175642990439FADF1F4C9275_1884313228;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.114 -0400", hash_original_method = "4122EC91CDDE6FFD9DA08F5ADAF8DB5D", hash_generated_method = "B9E43F0A0B6D78B9BDED5ABAEC7247CD")
    @Override
    public Annotation[] getDeclaredAnnotations() {
Annotation[] varD68AC863F3425367D397905DE25428DB_812822828 =         getDeclaredAnnotations(declaringClass, slot);
        varD68AC863F3425367D397905DE25428DB_812822828.addTaint(taint);
        return varD68AC863F3425367D397905DE25428DB_812822828;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    static Annotation[] getDeclaredAnnotations(Class<?> declaringClass, int slot) {
		Annotation[] ret = new Annotation[0];
		ret[0].addTaint(declaringClass.taint);
		ret[0].addTaint(slot);
		return ret;
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.114 -0400", hash_original_method = "C04F97610183E33B13FB9B4273375B6D", hash_generated_method = "F5B7305070FEA5DEB505B38EA6E58114")
    @Override
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        addTaint(annotationType.getTaint());
    if(annotationType == null)        
        {
            NullPointerException varD3565833EFC12BC5822ABFE94D257EDE_899504714 = new NullPointerException("annotationType == null");
            varD3565833EFC12BC5822ABFE94D257EDE_899504714.addTaint(taint);
            throw varD3565833EFC12BC5822ABFE94D257EDE_899504714;
        } 
A varD37D33C5EE02B81A7F8EF45A88B88039_781281782 =         getAnnotation(declaringClass, slot, annotationType);
        varD37D33C5EE02B81A7F8EF45A88B88039_781281782.addTaint(taint);
        return varD37D33C5EE02B81A7F8EF45A88B88039_781281782;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    static <A extends Annotation> A getAnnotation(Class<?> declaringClass, int slot, Class<A> annotationType) {
		A ret = (A) new Object();
		ret.addTaint(declaringClass.taint);
		ret.addTaint(slot);
		ret.addTaint(annotationType.taint);
		return ret;
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.115 -0400", hash_original_method = "D8B142EB73E138FF5927E6AE1DAD56D2", hash_generated_method = "F808813D51734F8214924C5759B5084D")
    @Override
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        addTaint(annotationType.getTaint());
    if(annotationType == null)        
        {
            NullPointerException varD3565833EFC12BC5822ABFE94D257EDE_1437175526 = new NullPointerException("annotationType == null");
            varD3565833EFC12BC5822ABFE94D257EDE_1437175526.addTaint(taint);
            throw varD3565833EFC12BC5822ABFE94D257EDE_1437175526;
        } 
        boolean var000A6E1BC96B3549B82B47E3D3F09F9E_2062226989 = (isAnnotationPresent(declaringClass, slot, annotationType));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_606484112 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_606484112;
        
        
            
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.116 -0400", hash_original_method = "72FC508AEB582DBA9794440813C3A8B1", hash_generated_method = "1AB10A4D60C9602F2D894748A5F5C283")
    public Annotation[][] getParameterAnnotations() {
        Annotation[][] parameterAnnotations = getParameterAnnotations(declaringClass, slot);
    if(parameterAnnotations.length == 0)        
        {
Annotation[][] var4E66BBCD00A041352E83320D93FA2694_344114813 =             noAnnotations(parameterTypes.length);
            var4E66BBCD00A041352E83320D93FA2694_344114813.addTaint(taint);
            return var4E66BBCD00A041352E83320D93FA2694_344114813;
        } 
Annotation[][] varAD240742A5BFADFDA08547188EAD9960_698807486 =         parameterAnnotations;
        varAD240742A5BFADFDA08547188EAD9960_698807486.addTaint(taint);
        return varAD240742A5BFADFDA08547188EAD9960_698807486;
        
        
                
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    static Annotation[][] getParameterAnnotations(Class declaringClass, int slot) {
		Annotation[][] ret = new Annotation[0][0];
		ret[0][0].addTaint(declaringClass.taint);
		ret[0][0].addTaint(slot);
		return ret;
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.117 -0400", hash_original_method = "47D8C519D80AD7FA8ACDBB9291AF9C1F", hash_generated_method = "2715A1CB2B83C5CC24BEBEE313C4652D")
    public boolean isVarArgs() {
        int modifiers = getMethodModifiers(declaringClass, slot);
        boolean varDB8F7C613030E76ABDF57D1E095E0DA1_1799570845 = ((modifiers & Modifier.VARARGS) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_737781588 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_737781588;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.118 -0400", hash_original_method = "F604FBBB689DE54F8A9C0A1F2713AB23", hash_generated_method = "C7F61F0B60636BF972CA400406970BCE")
    public boolean isBridge() {
        int modifiers = getMethodModifiers(declaringClass, slot);
        boolean var7AC4E48F64EC97F3BA2DCC6913561E32_1678133241 = ((modifiers & Modifier.BRIDGE) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_885288621 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_885288621;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.118 -0400", hash_original_method = "B698BCB06B0A737FF1A228493D2DEAD0", hash_generated_method = "A544A3655B5374372D0A72860FDC12E4")
    public boolean isSynthetic() {
        int modifiers = getMethodModifiers(declaringClass, slot);
        boolean var4121DACD6E958BDDE7E5586D934BDBC5_2104392084 = ((modifiers & Modifier.SYNTHETIC) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_779615711 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_779615711;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.118 -0400", hash_original_method = "3DF570DF2B22E4E433BE61FA4A3252FF", hash_generated_method = "DEE7DB86E87E9EB2D239A2478C957204")
    public Object getDefaultValue() {
Object var2050B6E3550B605C703FF0CF43049C54_1208064688 =         getDefaultValue(declaringClass, slot);
        var2050B6E3550B605C703FF0CF43049C54_1208064688.addTaint(taint);
        return var2050B6E3550B605C703FF0CF43049C54_1208064688;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.884 -0400", hash_original_method = "01EB45D9363E910A54E557C442527E6E", hash_generated_method = "12453DE2F22689947CA412DBF05F783C")
	private Object getDefaultValue(Class declaringClass, int slot) {
		addTaint(declaringClass.taint);
		addTaint(slot);
		return new Object();
	}

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.119 -0400", hash_original_method = "AF56E5F5402F800187126545ABE1F97F", hash_generated_method = "A00B52435476642F10A20DBFE249DB4C")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        boolean varD7F46FF16C07E332D27AC9D839CE4DA6_1784493178 = (object instanceof Method && toString().equals(object.toString()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1757904487 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1757904487;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.119 -0400", hash_original_method = "747BEFE9985C4AF4EE3D5630B62185EA", hash_generated_method = "90ED1DCFE00F03E624FC0FC093115E74")
    public Class<?> getDeclaringClass() {
Class<?> var55840ACAE88F5536515BB8E6ADD923C6_147723102 =         declaringClass;
        var55840ACAE88F5536515BB8E6ADD923C6_147723102.addTaint(taint);
        return var55840ACAE88F5536515BB8E6ADD923C6_147723102;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.120 -0400", hash_original_method = "0803D161ECCDE8E4916E8597C31C5EAF", hash_generated_method = "3BD0B1111B11074361737D7B07034D03")
    public Class<?>[] getExceptionTypes() {
    if(exceptionTypes == null)        
        {
Class<?>[] varE954D1DB65BB4FD70AD6204227C6F506_792857883 =             EmptyArray.CLASS;
            varE954D1DB65BB4FD70AD6204227C6F506_792857883.addTaint(taint);
            return varE954D1DB65BB4FD70AD6204227C6F506_792857883;
        } 
Class<?>[] varDA0125CDA48071C4AD5C63141D7B3037_314662105 =         exceptionTypes.clone();
        varDA0125CDA48071C4AD5C63141D7B3037_314662105.addTaint(taint);
        return varDA0125CDA48071C4AD5C63141D7B3037_314662105;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.120 -0400", hash_original_method = "D61CFE217686483C8FB69E9FFDF592A9", hash_generated_method = "5C7B158B2502CADC2B9DFF7AEC724F1A")
    public int getModifiers() {
        int var1DB99E362433041866339AAFD9E83F4E_1316505593 = (getMethodModifiers(declaringClass, slot));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_536639035 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_536639035;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    static int getMethodModifiers(Class<?> declaringClass, int slot) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1822823721 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1822823721;
	}

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.121 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "1A6DF235882516190E3711BA38564036")
    public String getName() {
String varB017984728AC60AD1F0BF8734F33F15C_706250089 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_706250089.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_706250089;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.121 -0400", hash_original_method = "860AC8CD4E2F5F390A65618A1941DEDE", hash_generated_method = "9CB8026A410C9A9C967B65CB92063F6D")
    public Class<?>[] getParameterTypes() {
Class<?>[] var5C3F1AD275E23F393681FEA8A66E0F80_1038146352 =         parameterTypes.clone();
        var5C3F1AD275E23F393681FEA8A66E0F80_1038146352.addTaint(taint);
        return var5C3F1AD275E23F393681FEA8A66E0F80_1038146352;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.122 -0400", hash_original_method = "952CC59854183D9751F85A9597A378CE", hash_generated_method = "5B7598B98A5E14DF6B14F5BA1C4F3265")
    public Class<?> getReturnType() {
Class<?> varDC9AC92D1699491F328099759E5C37AE_645919604 =         returnType;
        varDC9AC92D1699491F328099759E5C37AE_645919604.addTaint(taint);
        return varDC9AC92D1699491F328099759E5C37AE_645919604;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.122 -0400", hash_original_method = "EF5D8B81A9E09E0C38DFC15BA422ECA1", hash_generated_method = "42A0B25B955996895057E25FEDBFD09E")
    @Override
    public int hashCode() {
        int var5715838B66EDF423F24A871806972EB3_1258443511 = (name.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_837528150 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_837528150;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.123 -0400", hash_original_method = "4A7D773CBB2CABEB3FBD24437D2F9CE8", hash_generated_method = "2E820E6B7473319FF4416DB3AB13DF5E")
    public Object invoke(Object receiver, Object... args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        addTaint(args[0].getTaint());
        addTaint(receiver.getTaint());
    if(args == null)        
        {
            args = EmptyArray.OBJECT;
        } 
Object var928BD79CB12005B507BD2576AE0166BF_255796286 =         invokeNative(receiver, args, declaringClass, parameterTypes, returnType, slot, flag);
        var928BD79CB12005B507BD2576AE0166BF_255796286.addTaint(taint);
        return var928BD79CB12005B507BD2576AE0166BF_255796286;
        
        
            
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.124 -0400", hash_original_method = "20379CC138163D24505D982E1BF3267A", hash_generated_method = "F1E66FF019CE4F3CD8D256B2F52711C2")
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
        } 
String varE65B3A02759122992CB82C0E651AD408_702405903 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_702405903.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_702405903;
        
        
        
            
        
        
        
        
        
        
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.124 -0400", hash_original_method = "C4F068AB884B2FBA426F9E4B4EB5335D", hash_generated_method = "C1B717B37285D014662762DBF01D409B")
    @SuppressWarnings("unused")
    private String getSignature() {
        StringBuilder result = new StringBuilder();
        result.append('(');
for(int i = 0;i < parameterTypes.length;i++)
        {
            result.append(getSignature(parameterTypes[i]));
        } 
        result.append(')');
        result.append(getSignature(returnType));
String varE65B3A02759122992CB82C0E651AD408_1006270343 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_1006270343.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_1006270343;
        
        
        
        
            
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.125 -0400", hash_original_field = "6D5C49EE7CEF5783A42FC1C7653D6955", hash_generated_field = "3465881694FBE3BA7144100AF6865EE1")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.125 -0400", hash_original_field = "34D6D6954DE3EDD110F2D639DA598DA0", hash_generated_field = "D584CD4D5524F6C731424F703C29B84F")

    private static final Annotation[] NO_ANNOTATIONS = new Annotation[0];
    
    public Method() {

	}
    
    
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

