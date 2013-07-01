package java.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.lang.annotation.Annotation;
import java.util.Hashtable;
import org.apache.harmony.kernel.vm.StringUtils;

public class AccessibleObject implements AnnotatedElement {
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.643 -0400", hash_original_field = "04B8D6DC602542C7D84E76F57842A90E", hash_generated_field = "D3CD6765000979577B5DA559E9F23C55")
	boolean flag = false;

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.643 -0400", hash_original_method = "79E776845C9774BB9614D2D0955EABCF", hash_generated_method = "846450B6CD756FC6E1311C471B3C4B56")
	protected AccessibleObject() {
		// ---------- Original Method ----------
	}

	public static void setAccessible(AccessibleObject[] objects, boolean flag) {
		synchronized (AccessibleObject.class) {
			for (AccessibleObject object : objects) {
				object.flag = flag;
			}
		}
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.644 -0400", hash_original_method = "66D52F3844786BE4BB43647AC248F3A6", hash_generated_method = "95A33A80B780C0E612E35DA78F4A3A7D")
	public boolean isAccessible() {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1040446533 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1040446533;
		// ---------- Original Method ----------
		// return flag;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.644 -0400", hash_original_method = "1000999C704703264C7A249C905DEAE6", hash_generated_method = "D0859DDEC273DE0EC754854BC0CB46EB")
	public void setAccessible(boolean flag) {
		this.flag = flag;
		// ---------- Original Method ----------
		// this.flag = flag;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.645 -0400", hash_original_method = "8CC5FFC4D6878043D8F48CA01CEE9F83", hash_generated_method = "AB5042C1A1624F62F986ED82EF2DA771")
	public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
		if (DroidSafeAndroidRuntime.control)
			throw new UnsupportedOperationException();
		addTaint(annotationType.getTaint());
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1575930949 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1575930949;
		// ---------- Original Method ----------
		// throw new UnsupportedOperationException();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.645 -0400", hash_original_method = "0B7DCEEC0F2643B54E5B168F87B9CE3A", hash_generated_method = "17B2182191539942B289AD17385B4E86")
	public Annotation[] getDeclaredAnnotations() {
		throw new UnsupportedOperationException();
		// ---------- Original Method ----------
		// throw new UnsupportedOperationException();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.646 -0400", hash_original_method = "CDE5472758ACF6CE75A2FF7BF6EF0F38", hash_generated_method = "68EBF5FC1D9DBB7FFE111B5DDB0164D9")
	public Annotation[] getAnnotations() {
		Annotation[] varB4EAC82CA7396A68D541C85D26508E83_790765791 = null; // Variable
																			// for
																			// return
																			// #1
		varB4EAC82CA7396A68D541C85D26508E83_790765791 = getDeclaredAnnotations();
		varB4EAC82CA7396A68D541C85D26508E83_790765791.addTaint(getTaint()); // Add
																			// taint
																			// from
																			// parent
		return varB4EAC82CA7396A68D541C85D26508E83_790765791;
		// ---------- Original Method ----------
		// return getDeclaredAnnotations();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.647 -0400", hash_original_method = "E854D6B6A4F110252592FEF88B9AB0AA", hash_generated_method = "6484E1ACA79C11A5EBE95A65BCF0B2D2")
	public <T extends Annotation> T getAnnotation(Class<T> annotationType) {

		addTaint(annotationType.getTaint());
		throw new UnsupportedOperationException();
		// ---------- Original Method ----------
		// throw new UnsupportedOperationException();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.648 -0400", hash_original_method = "AFCD123A6E616CB6E7A6F8CAEE33C533", hash_generated_method = "0FEFC6BBCB55B7814BFDA4709D25F87A")
	String getSignature(Class<?> clazz) {
		String varB4EAC82CA7396A68D541C85D26508E83_1214179019 = null; // Variable
																		// for
																		// return
																		// #1
		String result = "";
		String nextType = clazz.getName();
		{
			boolean varB0CECCA2B4D7E05F335BC1240FF8707E_257047782 = (trans.containsKey(nextType));
			{
				result = trans.get(nextType);
			} // End block
			{
				{
					boolean var89033C011C3D70F45494D634C893FFF8_1808405108 = (clazz.isArray());
					{
						result = "[" + getSignature(clazz.getComponentType());
					} // End block
					{
						result = "L" + nextType + ";";
					} // End block
				} // End collapsed parenthetic
			} // End block
		} // End collapsed parenthetic
		varB4EAC82CA7396A68D541C85D26508E83_1214179019 = result;
		addTaint(clazz.getTaint());
		varB4EAC82CA7396A68D541C85D26508E83_1214179019.addTaint(getTaint()); // Add
																				// taint
																				// from
																				// parent
		return varB4EAC82CA7396A68D541C85D26508E83_1214179019;
		// ---------- Original Method ----------
		// String result = "";
		// String nextType = clazz.getName();
		// if(trans.containsKey(nextType)) {
		// result = trans.get(nextType);
		// } else {
		// if(clazz.isArray()) {
		// result = "[" + getSignature(clazz.getComponentType());
		// } else {
		// result = "L" + nextType + ";";
		// }
		// }
		// return result;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.649 -0400", hash_original_method = "538B7B8EC3794D6F6E22215297E953DA", hash_generated_method = "8A5C75CFA24BB02BA66C1A9A820BE476")
	String toString(Class<?>[] types) {
		String varB4EAC82CA7396A68D541C85D26508E83_467598021 = null; // Variable
																		// for
																		// return
																		// #1
		StringBuilder result = new StringBuilder();
		{
			result.append(types[0].getName());
			{
				int i = 1;
				{
					result.append(',');
					result.append(types[i].getName());
				} // End block
			} // End collapsed parenthetic
		} // End block
		varB4EAC82CA7396A68D541C85D26508E83_467598021 = result.toString();
		addTaint(types[0].getTaint());
		varB4EAC82CA7396A68D541C85D26508E83_467598021.addTaint(getTaint()); // Add
																			// taint
																			// from
																			// parent
		return varB4EAC82CA7396A68D541C85D26508E83_467598021;
		// ---------- Original Method ----------
		// StringBuilder result = new StringBuilder();
		// if (types.length != 0) {
		// result.append(types[0].getName());
		// for (int i = 1; i < types.length; i++) {
		// result.append(',');
		// result.append(types[i].getName());
		// }
		// }
		// return result.toString();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.650 -0400", hash_original_method = "595C9CE9F234EEA7E3334962F2566B38", hash_generated_method = "8C7DE412FAC138E28DFD12945E23B5A6")
	String getSignatureAttribute() {
		throw new UnsupportedOperationException();
		// ---------- Original Method ----------
		// throw new UnsupportedOperationException();
	}

	static String getClassSignatureAttribute(Class clazz) {
		Object[] annotation = getClassSignatureAnnotation(clazz);
		if (annotation == null) {
			return null;
		}
		return StringUtils.combineStrings(annotation);
	}

	private static Object[] getClassSignatureAnnotation(Class clazz) {
		// DSFIXME: This shouldn't happen!
		Object[] ret = new Object[0];
		ret[0].addTaint(clazz.taint);
		return ret;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.650 -0400", hash_original_method = "96346F5FDCAEE775233825443F323528", hash_generated_method = "000615890F80FAE33A68D29164188749")
	void appendArrayType(StringBuilder sb, Class<?> obj) {
		int dimensions = 0;
		{
			boolean var9993E8A418BE8C4A6D5358EC116C939A_333407103 = (obj.isArray());
			{
				obj = obj.getComponentType();
			} // End block
		} // End collapsed parenthetic
		sb.append(obj.getName());
		{
			int d = 0;
			{
				sb.append("[]");
			} // End block
		} // End collapsed parenthetic
		addTaint(sb.getTaint());
		addTaint(obj.getTaint());
		// ---------- Original Method ----------
		// int dimensions = 0;
		// while (obj.isArray()) {
		// obj = obj.getComponentType();
		// dimensions++;
		// }
		// sb.append(obj.getName());
		// for (int d = 0; d < dimensions; d++) {
		// sb.append("[]");
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.651 -0400", hash_original_method = "4331049DB20FE3D320265414E1BB6DD1", hash_generated_method = "CFEE4DDA4266DC206712540ECC44BA32")
	void appendArrayGenericType(StringBuilder sb, Type[] types) {
		{
			appendGenericType(sb, types[0]);
			{
				int i = 1;
				{
					sb.append(',');
					appendGenericType(sb, types[i]);
				} // End block
			} // End collapsed parenthetic
		} // End block
		addTaint(sb.getTaint());
		addTaint(types[0].getTaint());
		// ---------- Original Method ----------
		// if (types.length > 0) {
		// appendGenericType(sb, types[0]);
		// for (int i = 1; i < types.length; i++) {
		// sb.append(',');
		// appendGenericType(sb, types[i]);
		// }
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.652 -0400", hash_original_method = "8E82FAA48BB361A9859A3C64A69CEBFA", hash_generated_method = "550ED591994CBB44EDFCC2C3D486178D")
	void appendGenericType(StringBuilder sb, Type obj) {
		{
			sb.append(((TypeVariable) obj).getName());
		} // End block
		{
			sb.append(obj.toString());
		} // End block
		{
			Type simplified = ((GenericArrayType) obj).getGenericComponentType();
			appendGenericType(sb, simplified);
			sb.append("[]");
		} // End block
		{
			Class c = ((Class<?>) obj);
			{
				boolean var265EAD67919E0878EDE760B91A2663FE_1155092416 = (c.isArray());
				{
					String as[] = c.getName().split("\\[");
					int len = as.length - 1;
					{
						boolean var4E04E651982B5C19A261D19073E7D31F_2088374322 = (as[len].length() > 1);
						{
							sb.append(as[len].substring(1, as[len].length() - 1));
						} // End block
						{
							char ch = as[len].charAt(0);
							sb.append("int");
							sb.append("byte");
							sb.append("long");
							sb.append("float");
							sb.append("double");
							sb.append("short");
							sb.append("char");
							sb.append("boolean");
							sb.append("void");
						} // End block
					} // End collapsed parenthetic
					{
						int i = 0;
						{
							sb.append("[]");
						} // End block
					} // End collapsed parenthetic
				} // End block
				{
					sb.append(c.getName());
				} // End block
			} // End collapsed parenthetic
		} // End block
		addTaint(sb.getTaint());
		addTaint(obj.getTaint());
		// ---------- Original Method ----------
		// Original Method Too Long, Refer to Original Implementation
	}

	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.652 -0400", hash_original_field = "4738019EF434F24099319565CD5185E5", hash_generated_field = "F7E345322C5DA8049D7465C5406D9B9D")
	static Hashtable<String, String> trans;
	static {
		trans = new Hashtable<String, String>(9);
		trans.put("byte", "B");
		trans.put("char", "C");
		trans.put("short", "S");
		trans.put("int", "I");
		trans.put("long", "J");
		trans.put("float", "F");
		trans.put("double", "D");
		trans.put("void", "V");
		trans.put("boolean", "Z");
	}

}
