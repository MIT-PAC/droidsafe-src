package java.lang.reflect;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.lang.annotation.Annotation;
import java.util.Comparator;
import libcore.util.EmptyArray;
import org.apache.harmony.kernel.vm.StringUtils;
import org.apache.harmony.luni.lang.reflect.GenericSignatureParser;
import org.apache.harmony.luni.lang.reflect.ListOfTypes;
import org.apache.harmony.luni.lang.reflect.Types;

public final class Method extends AccessibleObject implements GenericDeclaration, Member {
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.870 -0400", hash_original_field = "5E97994ED38A2B2F984F3B2B75012BF8", hash_generated_field = "6B06F56F1EB868ADA8CFFD63973A7E09")
	private int slot;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.870 -0400", hash_original_field = "02CBE457FB1B22631E594CE79672D2F1", hash_generated_field = "EC96049C106D95C970CBF94E8CE21744")
	private Class<?> declaringClass;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.870 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")
	private String name;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.870 -0400", hash_original_field = "11427856321C6E9F5321CA879704C8FE", hash_generated_field = "2BEA8A3EFDFBD76D3A4CCA6C3AC7E53C")
	private Class<?>[] parameterTypes;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.870 -0400", hash_original_field = "2CD56E5B83C33F80B2D25820C51596A0", hash_generated_field = "2A0AC8F9632DF82B378D2F01BC74BDF4")
	private Class<?>[] exceptionTypes;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.870 -0400", hash_original_field = "9CD6843F4536590CD86F933708C7371E", hash_generated_field = "052C26419A9A6CDFB48BC17097CACAE9")
	private Class<?> returnType;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.870 -0400", hash_original_field = "6BB2E1AD8EE7DCCA935DA6ACF3D7474E", hash_generated_field = "924C48D07F65387E616D3CE31DE5954D")
	private ListOfTypes genericExceptionTypes;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.870 -0400", hash_original_field = "175F1F0CE81CA486282E77D84F1E1386", hash_generated_field = "4E98B7DC70F3037D11B527C2E4899BBD")
	private ListOfTypes genericParameterTypes;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.870 -0400", hash_original_field = "40B35D47678E42F2607E0F522DC3BF6F", hash_generated_field = "32E37E22BB1C76784903951645BC45C1")
	private Type genericReturnType;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.870 -0400", hash_original_field = "898BB6A86E0DA433332CBC4F55D3E967", hash_generated_field = "4338B9C9877379FEA81BE0E690FD4B47")
	private TypeVariable<Method>[] formalTypeParameters;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.870 -0400", hash_original_field = "95A2153C74405BE971B467AB79B769A0", hash_generated_field = "89FDBAE6DE2AE55271071C78F774F101")
	private volatile boolean genericTypesAreInitialized = false;

	public Method() {

	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.871 -0400", hash_original_method = "70F1F77231BFE73E3138A8A58A15C35C", hash_generated_method = "132D7D14805C9BDB2F4DD27DBCF9FCF9")
	Method(Method orig) {
		this(orig.declaringClass, orig.parameterTypes, orig.exceptionTypes, orig.returnType, orig.name, orig.slot);
		{
			this.flag = true;
		} 
		addTaint(orig.getTaint());
		
		
		
		
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.871 -0400", hash_original_method = "F4B9C750B34D03AFED72DBA84048C99D", hash_generated_method = "A3295A616BA9759E667254D439272654")
	private Method(Class<?> declaring, Class<?>[] paramTypes, Class<?>[] exceptTypes, Class<?> returnType, String name, int slot) {
		this.declaringClass = declaring;
		this.name = name;
		this.slot = slot;
		this.parameterTypes = paramTypes;
		this.exceptionTypes = exceptTypes;
		this.returnType = returnType;
		
		
		
		
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.871 -0400", hash_original_method = "0BE83C703D137B5A5A60EFAA17178485", hash_generated_method = "F91CDF07DE0CA9C0E4C32DC0CE5572C4")
	private synchronized void initGenericTypes() {
		{
			String signatureAttribute = getSignatureAttribute();
			GenericSignatureParser parser = new GenericSignatureParser(declaringClass.getClassLoader());
			parser.parseForMethod(this, signatureAttribute, exceptionTypes);
			formalTypeParameters = parser.formalTypeParameters;
			genericParameterTypes = parser.parameterTypes;
			genericExceptionTypes = parser.exceptionTypes;
			genericReturnType = parser.returnType;
			genericTypesAreInitialized = true;
		} 
			
			
			
			
			
		
		
		
		
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.872 -0400", hash_original_method = "0F068F731FE610BBACFD836E6A61AACF", hash_generated_method = "539FC46299B1CCB063A69BBF33F91D1C")
	public TypeVariable<Method>[] getTypeParameters() {
		TypeVariable<Method>[] varB4EAC82CA7396A68D541C85D26508E83_549101395 = null; 
																						
																						
																						
		initGenericTypes();
		varB4EAC82CA7396A68D541C85D26508E83_549101395 = formalTypeParameters.clone();
		varB4EAC82CA7396A68D541C85D26508E83_549101395.addTaint(getTaint()); 
																			
																			
																			
		return varB4EAC82CA7396A68D541C85D26508E83_549101395;
		
		
		
	}

	@DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.873 -0400", hash_original_method = "1CDF5107AC443AA5F8C2E1DA9DF559A0", hash_generated_method = "7A7E2BAED3F659C1C4022FBBE469270A")
	@Override
	String getSignatureAttribute() {
		String varB4EAC82CA7396A68D541C85D26508E83_1772093031 = null; 
																		
																		
																		
		String varB4EAC82CA7396A68D541C85D26508E83_1938011327 = null; 
																		
																		
																		
		Object[] annotation = getSignatureAnnotation(declaringClass, slot);
		{
			varB4EAC82CA7396A68D541C85D26508E83_1772093031 = null;
		} 
		varB4EAC82CA7396A68D541C85D26508E83_1938011327 = StringUtils.combineStrings(annotation);
		String varA7E53CE21691AB073D9660D615818899_599099937; 
																
		switch (DroidSafeAndroidRuntime.switchControl) {
		case 1: 
			varA7E53CE21691AB073D9660D615818899_599099937 = varB4EAC82CA7396A68D541C85D26508E83_1772093031;
			break;
		default:
			varA7E53CE21691AB073D9660D615818899_599099937 = varB4EAC82CA7396A68D541C85D26508E83_1938011327;
			break;
		}
		varA7E53CE21691AB073D9660D615818899_599099937.addTaint(getTaint()); 
																			
																			
																			
		return varA7E53CE21691AB073D9660D615818899_599099937;
		
		
		
		
		
		
	}

	@DSModeled(DSC.SAFE)
    static Object[] getSignatureAnnotation(Class declaringClass, int slot) {
		
		Object[] ret = new Object[0];
		ret[0].addTaint(declaringClass.taint);
		ret[0].addTaint(slot);
		return ret;
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.874 -0400", hash_original_method = "060018D8556E7858267AA04DC5F84FE8", hash_generated_method = "BF4CBF93F83843A753547888F08A1174")
	public String toGenericString() {
		String varB4EAC82CA7396A68D541C85D26508E83_451575740 = null; 
																		
																		
																		
		StringBuilder sb = new StringBuilder(80);
		initGenericTypes();
		int modifier = getModifiers();
		{
			sb.append(Modifier.toString(modifier & ~(Modifier.BRIDGE + Modifier.VARARGS))).append(' ');
		} 
		{
			sb.append('<');
			{
				int i = 0;
				{
					appendGenericType(sb, formalTypeParameters[i]);
					{
						sb.append(",");
					} 
				} 
			} 
			sb.append("> ");
		} 
		appendGenericType(sb, Types.getType(genericReturnType));
		sb.append(' ');
		appendArrayType(sb, getDeclaringClass());
		sb.append(".").append(getName());
		sb.append('(');
		appendArrayGenericType(sb, Types.getClonedTypeArray(genericParameterTypes));
		sb.append(')');
		Type[] genericExceptionTypeArray = Types.getClonedTypeArray(genericExceptionTypes);
		{
			sb.append(" throws ");
			appendArrayGenericType(sb, genericExceptionTypeArray);
		} 
		varB4EAC82CA7396A68D541C85D26508E83_451575740 = sb.toString();
		varB4EAC82CA7396A68D541C85D26508E83_451575740.addTaint(getTaint()); 
																			
																			
																			
		return varB4EAC82CA7396A68D541C85D26508E83_451575740;
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.875 -0400", hash_original_method = "A9CCE739D5419EE3EB1324AC76C431BA", hash_generated_method = "EDFFD2E1110516EC64651EA295FFE567")
	public Type[] getGenericParameterTypes() {
		Type[] varB4EAC82CA7396A68D541C85D26508E83_261556399 = null; 
																		
																		
																		
		initGenericTypes();
		varB4EAC82CA7396A68D541C85D26508E83_261556399 = Types.getClonedTypeArray(genericParameterTypes);
		varB4EAC82CA7396A68D541C85D26508E83_261556399.addTaint(getTaint()); 
																			
																			
																			
		return varB4EAC82CA7396A68D541C85D26508E83_261556399;
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.876 -0400", hash_original_method = "D98F12BC8A74E89DDBE36E53E80FD275", hash_generated_method = "C1328DAD59F98B39FB7BD9D1D89DD942")
	public Type[] getGenericExceptionTypes() {
		Type[] varB4EAC82CA7396A68D541C85D26508E83_1772261561 = null; 
																		
																		
																		
		initGenericTypes();
		varB4EAC82CA7396A68D541C85D26508E83_1772261561 = Types.getClonedTypeArray(genericExceptionTypes);
		varB4EAC82CA7396A68D541C85D26508E83_1772261561.addTaint(getTaint()); 
																				
																				
																				
		return varB4EAC82CA7396A68D541C85D26508E83_1772261561;
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.876 -0400", hash_original_method = "83125796E1541F4C47F8F2176AE50053", hash_generated_method = "8A71F2FD809C931507E655203E634838")
	public Type getGenericReturnType() {
		Type varB4EAC82CA7396A68D541C85D26508E83_717249025 = null; 
																	
																	
		initGenericTypes();
		varB4EAC82CA7396A68D541C85D26508E83_717249025 = Types.getType(genericReturnType);
		varB4EAC82CA7396A68D541C85D26508E83_717249025.addTaint(getTaint()); 
																			
																			
																			
		return varB4EAC82CA7396A68D541C85D26508E83_717249025;
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.877 -0400", hash_original_method = "4122EC91CDDE6FFD9DA08F5ADAF8DB5D", hash_generated_method = "A5D745AC890FD3E6910CC741C813E61D")
	@Override
	public Annotation[] getDeclaredAnnotations() {
		Annotation[] varB4EAC82CA7396A68D541C85D26508E83_1362196696 = null; 
																			
																			
																			
		varB4EAC82CA7396A68D541C85D26508E83_1362196696 = getDeclaredAnnotations(declaringClass, slot);
		varB4EAC82CA7396A68D541C85D26508E83_1362196696.addTaint(getTaint()); 
																				
																				
																				
		return varB4EAC82CA7396A68D541C85D26508E83_1362196696;
		
		
	}

	@DSModeled(DSC.SAFE)
    static Annotation[] getDeclaredAnnotations(Class<?> declaringClass, int slot) {
		
		Annotation[] ret = new Annotation[0];
		ret[0].addTaint(declaringClass.taint);
		ret[0].addTaint(slot);
		return ret;
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.878 -0400", hash_original_method = "C04F97610183E33B13FB9B4273375B6D", hash_generated_method = "B5EDD2B76D141843646C1A378C51FF3A")
	@Override
	public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
		A varB4EAC82CA7396A68D541C85D26508E83_1767034432 = null; 
																	
		{
			if (DroidSafeAndroidRuntime.control)
				throw new NullPointerException("annotationType == null");
		} 
		varB4EAC82CA7396A68D541C85D26508E83_1767034432 = getAnnotation(declaringClass, slot, annotationType);
		addTaint(annotationType.getTaint());
		varB4EAC82CA7396A68D541C85D26508E83_1767034432.addTaint(getTaint()); 
																				
																				
																				
		return varB4EAC82CA7396A68D541C85D26508E83_1767034432;
		
		
		
		
		
	}

	@DSModeled(DSC.SAFE)
    static <A extends Annotation> A getAnnotation(Class<?> declaringClass, int slot, Class<A> annotationType) {
		
		A ret = (A) new Object();
		ret.addTaint(declaringClass.taint);
		ret.addTaint(slot);
		ret.addTaint(annotationType.taint);
		return ret;
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.879 -0400", hash_original_method = "D8B142EB73E138FF5927E6AE1DAD56D2", hash_generated_method = "A698F667F7A11E6C8DD57A18ECC08DB6")
	@Override
	public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
		{
			if (DroidSafeAndroidRuntime.control)
				throw new NullPointerException("annotationType == null");
		} 
		boolean varB3780DB5BBCCEE48C62CDF997A07D42D_1053399562 = (isAnnotationPresent(declaringClass, slot, annotationType));
		addTaint(annotationType.getTaint());
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_185686161 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_185686161;
		
		
		
		
		
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

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.880 -0400", hash_original_method = "72FC508AEB582DBA9794440813C3A8B1", hash_generated_method = "A054EBED7583174A774ACFE961B317B1")
	public Annotation[][] getParameterAnnotations() {
		Annotation[][] varB4EAC82CA7396A68D541C85D26508E83_624722259 = null; 
																				
																				
																				
		Annotation[][] varB4EAC82CA7396A68D541C85D26508E83_340551905 = null; 
																				
																				
																				
		Annotation[][] parameterAnnotations = getParameterAnnotations(declaringClass, slot);
		{
			varB4EAC82CA7396A68D541C85D26508E83_624722259 = noAnnotations(parameterTypes.length);
		} 
		varB4EAC82CA7396A68D541C85D26508E83_340551905 = parameterAnnotations;
		Annotation[][] varA7E53CE21691AB073D9660D615818899_2132837393; 
																		
																		
		switch (DroidSafeAndroidRuntime.switchControl) {
		case 1: 
			varA7E53CE21691AB073D9660D615818899_2132837393 = varB4EAC82CA7396A68D541C85D26508E83_624722259;
			break;
		default:
			varA7E53CE21691AB073D9660D615818899_2132837393 = varB4EAC82CA7396A68D541C85D26508E83_340551905;
			break;
		}
		varA7E53CE21691AB073D9660D615818899_2132837393.addTaint(getTaint()); 
																				
																				
																				
		return varA7E53CE21691AB073D9660D615818899_2132837393;
		
		
		
		
		
		
		
	}

	@DSModeled(DSC.SAFE)
    static Annotation[][] getParameterAnnotations(Class declaringClass, int slot) {
		
		Annotation[][] ret = new Annotation[0][0];
		ret[0][0].addTaint(declaringClass.taint);
		ret[0][0].addTaint(slot);
		return ret;
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.881 -0400", hash_original_method = "47D8C519D80AD7FA8ACDBB9291AF9C1F", hash_generated_method = "E9BE26680F70C736524E33F11B3AC066")
	public boolean isVarArgs() {
		int modifiers = getMethodModifiers(declaringClass, slot);
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_529333993 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_529333993;
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.882 -0400", hash_original_method = "F604FBBB689DE54F8A9C0A1F2713AB23", hash_generated_method = "40667C7BE71F31F5A01D535A14096E20")
	public boolean isBridge() {
		int modifiers = getMethodModifiers(declaringClass, slot);
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1285590702 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1285590702;
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.882 -0400", hash_original_method = "B698BCB06B0A737FF1A228493D2DEAD0", hash_generated_method = "E8A5F3ACF5F01E6164097A075E341B08")
	public boolean isSynthetic() {
		int modifiers = getMethodModifiers(declaringClass, slot);
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1645929661 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1645929661;
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.884 -0400", hash_original_method = "3DF570DF2B22E4E433BE61FA4A3252FF", hash_generated_method = "7032A0E0F5A783D37FD5C846013573AC")
	public Object getDefaultValue() {
		Object varB4EAC82CA7396A68D541C85D26508E83_1406205822 = null; 
																		
																		
																		
		varB4EAC82CA7396A68D541C85D26508E83_1406205822 = getDefaultValue(declaringClass, slot);
		varB4EAC82CA7396A68D541C85D26508E83_1406205822.addTaint(getTaint()); 
																				
																				
																				
		return varB4EAC82CA7396A68D541C85D26508E83_1406205822;
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.884 -0400", hash_original_method = "01EB45D9363E910A54E557C442527E6E", hash_generated_method = "12453DE2F22689947CA412DBF05F783C")
	private Object getDefaultValue(Class declaringClass, int slot) {
		
		
		addTaint(declaringClass.taint);
		addTaint(slot);
		return new Object();
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.886 -0400", hash_original_method = "AF56E5F5402F800187126545ABE1F97F", hash_generated_method = "65D0918C91734F73473F7376589CA6EB")
	@Override
	public boolean equals(Object object) {
		boolean varA56EFC3BDF27A12659DE2CAD30DABBAC_1175554883 = (object instanceof Method && toString().equals(object.toString()));
		addTaint(object.getTaint());
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1006608830 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1006608830;
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.890 -0400", hash_original_method = "747BEFE9985C4AF4EE3D5630B62185EA", hash_generated_method = "130E03FB75445799569157231CB02409")
	public Class<?> getDeclaringClass() {
		Class<?> varB4EAC82CA7396A68D541C85D26508E83_2053017153 = null; 
																		
																		
																		
		varB4EAC82CA7396A68D541C85D26508E83_2053017153 = declaringClass;
		varB4EAC82CA7396A68D541C85D26508E83_2053017153.addTaint(getTaint()); 
																				
																				
																				
		return varB4EAC82CA7396A68D541C85D26508E83_2053017153;
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.892 -0400", hash_original_method = "0803D161ECCDE8E4916E8597C31C5EAF", hash_generated_method = "BD858C3EADE6BB4622437392A163E84F")
	public Class<?>[] getExceptionTypes() {
		Class<?>[] varB4EAC82CA7396A68D541C85D26508E83_171480031 = null; 
																			
																			
																			
		Class<?>[] varB4EAC82CA7396A68D541C85D26508E83_843607598 = null; 
																			
																			
																			
		{
			varB4EAC82CA7396A68D541C85D26508E83_171480031 = EmptyArray.CLASS;
		} 
		varB4EAC82CA7396A68D541C85D26508E83_843607598 = exceptionTypes.clone();
		Class<?>[] varA7E53CE21691AB073D9660D615818899_1585097035; 
																	
																	
		switch (DroidSafeAndroidRuntime.switchControl) {
		case 1: 
			varA7E53CE21691AB073D9660D615818899_1585097035 = varB4EAC82CA7396A68D541C85D26508E83_171480031;
			break;
		default:
			varA7E53CE21691AB073D9660D615818899_1585097035 = varB4EAC82CA7396A68D541C85D26508E83_843607598;
			break;
		}
		varA7E53CE21691AB073D9660D615818899_1585097035.addTaint(getTaint()); 
																				
																				
																				
		return varA7E53CE21691AB073D9660D615818899_1585097035;
		
		
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.893 -0400", hash_original_method = "D61CFE217686483C8FB69E9FFDF592A9", hash_generated_method = "A06F19901BE301D7CC579408F32CF719")
	public int getModifiers() {
		int varE3C3A4926E4A75C433C82B3799B27F5E_2095496075 = (getMethodModifiers(declaringClass, slot));
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1701381069 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1701381069;
		
		
	}

	@DSModeled(DSC.SAFE)
    static int getMethodModifiers(Class<?> declaringClass, int slot) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1822823721 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1822823721;
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.894 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "7ED74AFABE04512C4B37DD262C064D15")
	public String getName() {
		String varB4EAC82CA7396A68D541C85D26508E83_802056819 = null; 
																		
																		
																		
		varB4EAC82CA7396A68D541C85D26508E83_802056819 = name;
		varB4EAC82CA7396A68D541C85D26508E83_802056819.addTaint(getTaint()); 
																			
																			
																			
		return varB4EAC82CA7396A68D541C85D26508E83_802056819;
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.895 -0400", hash_original_method = "860AC8CD4E2F5F390A65618A1941DEDE", hash_generated_method = "017D0B0F6BD216227B23172CF563DCA9")
	public Class<?>[] getParameterTypes() {
		Class<?>[] varB4EAC82CA7396A68D541C85D26508E83_798143344 = null; 
																			
																			
																			
		varB4EAC82CA7396A68D541C85D26508E83_798143344 = parameterTypes.clone();
		varB4EAC82CA7396A68D541C85D26508E83_798143344.addTaint(getTaint()); 
																			
																			
																			
		return varB4EAC82CA7396A68D541C85D26508E83_798143344;
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.896 -0400", hash_original_method = "952CC59854183D9751F85A9597A378CE", hash_generated_method = "9B2F560A12D1C6DCD529EA4329D5F5C0")
	public Class<?> getReturnType() {
		Class<?> varB4EAC82CA7396A68D541C85D26508E83_1635565424 = null; 
																		
																		
																		
		varB4EAC82CA7396A68D541C85D26508E83_1635565424 = returnType;
		varB4EAC82CA7396A68D541C85D26508E83_1635565424.addTaint(getTaint()); 
																				
																				
																				
		return varB4EAC82CA7396A68D541C85D26508E83_1635565424;
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.897 -0400", hash_original_method = "EF5D8B81A9E09E0C38DFC15BA422ECA1", hash_generated_method = "CC2358958B4152A3284C8E4C6ACE85D4")
	@Override
	public int hashCode() {
		int var8EF65A1839C36EED6A25646011513717_706864575 = (name.hashCode());
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1359799944 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1359799944;
		
		
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.898 -0400", hash_original_method = "4A7D773CBB2CABEB3FBD24437D2F9CE8", hash_generated_method = "4FF92A424E53FA15E4E3112346FDF6DE")
	public Object invoke(Object receiver, Object... args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Object varB4EAC82CA7396A68D541C85D26508E83_1916148612 = null; 
																		
																		
																		
		{
			args = EmptyArray.OBJECT;
		} 
		varB4EAC82CA7396A68D541C85D26508E83_1916148612 = invokeNative(receiver, args, declaringClass, parameterTypes, returnType, slot, flag);
		addTaint(receiver.getTaint());
		addTaint(args[0].getTaint());
		varB4EAC82CA7396A68D541C85D26508E83_1916148612.addTaint(getTaint()); 
																				
																				
																				
		return varB4EAC82CA7396A68D541C85D26508E83_1916148612;
		
		
		
		
		
		
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

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.899 -0400", hash_original_method = "20379CC138163D24505D982E1BF3267A", hash_generated_method = "647DF041BE31E844A6AA93E85A407B05")
	@Override
	public String toString() {
		String varB4EAC82CA7396A68D541C85D26508E83_949582351 = null; 
																		
																		
																		
		StringBuilder result = new StringBuilder(Modifier.toString(getModifiers()));
		{
			boolean varFD23457D7925EE9ADC9C1D678FE17210_1421435667 = (result.length() != 0);
			result.append(' ');
		} 
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
		} 
		varB4EAC82CA7396A68D541C85D26508E83_949582351 = result.toString();
		varB4EAC82CA7396A68D541C85D26508E83_949582351.addTaint(getTaint()); 
																			
																			
																			
		return varB4EAC82CA7396A68D541C85D26508E83_949582351;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.899 -0400", hash_original_method = "C4F068AB884B2FBA426F9E4B4EB5335D", hash_generated_method = "D79C789793FC0A3EC77E84BA7C52D67E")
	@SuppressWarnings("unused")
	private String getSignature() {
		String varB4EAC82CA7396A68D541C85D26508E83_1072164620 = null; 
																		
																		
																		
		StringBuilder result = new StringBuilder();
		result.append('(');
		{
			int i = 0;
			{
				result.append(getSignature(parameterTypes[i]));
			} 
		} 
		result.append(')');
		result.append(getSignature(returnType));
		varB4EAC82CA7396A68D541C85D26508E83_1072164620 = result.toString();
		varB4EAC82CA7396A68D541C85D26508E83_1072164620.addTaint(getTaint()); 
																				
																				
																				
		return varB4EAC82CA7396A68D541C85D26508E83_1072164620;
		
		
		
		
		
		
		
		
		
	}

	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.900 -0400", hash_original_field = "6D5C49EE7CEF5783A42FC1C7653D6955", hash_generated_field = "3465881694FBE3BA7144100AF6865EE1")
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
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.900 -0400", hash_original_field = "34D6D6954DE3EDD110F2D639DA598DA0", hash_generated_field = "D584CD4D5524F6C731424F703C29B84F")
	private static final Annotation[] NO_ANNOTATIONS = new Annotation[0];

	
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
