package jarmethods;

import org.objectweb.asm.tree.MethodNode;

/**
 * This program outputs a list of methods. Each method that is output
 * goes thru method output_method in this class.
 */


public class Output {

	// CUT AND PASTE FROM LogDroidCalls.MyClassNode
	// input string is a substring of something that looks like
	//    (ZILjava/util/Lang;[J)V
	//
	// descSymbol has '/' component separators for objects
	// Returned String for an object has '.' component separators for objects
	private static String descSymbolToJavaType(final String descSymbol) {
		final String retval;
		final int array_dim_count;
		final String desc;
		final StringBuilder sb = new StringBuilder();

		if (descSymbol.startsWith("[")) {
			int i = 0;
			while ((i < descSymbol.length()) && (descSymbol.charAt(i) == '[')) {
				i++;
			}

			array_dim_count = i;

			desc = descSymbol.substring(i);
		} else {
			desc = descSymbol;
			array_dim_count = 0;
		}

		char first_desc_char = desc.charAt(0);

		if ('Z' == first_desc_char) {
			retval = "boolean";
		} else if ('C' == first_desc_char) {
			retval = "char";
		} else if ('B' == first_desc_char) {
			retval = "byte";
		} else if ('S' == first_desc_char) {
			retval = "short";
		} else if ('I' == first_desc_char) {
			retval = "int";
		} else if ('F' == first_desc_char) {
			retval = "float";
		} else if ('J' == first_desc_char) {
			retval = "long";
		} else if ('D' == first_desc_char) {
			retval = "double";
		} else if ('V' == first_desc_char) {
			retval = "void";
		} else if ('L' == first_desc_char) {
			final String str = desc.substring(1, desc.indexOf(";"));
			retval = str.replace('/', '.');
		} else {
			retval = ""; // TODO ERROR
		}

		sb.append(retval);
		for (int k = 0; k < array_dim_count; k++) {
			sb.append("[]");
		}

        if (false && array_dim_count > 0)
          System.out.printf ("array name = '%s', name = '%s'\n", desc, sb);
		return sb.toString();
	}


	private static String get_return_value_from_desc(final String desc) {
		final String str = desc.substring(desc.lastIndexOf(")") + 1);
		final String ans = descSymbolToJavaType(str);
		return ans;
	}

	private static String collect_parameters(final String desc) {
		int index = 1;
		boolean first_time = true;

		final StringBuffer buf = new StringBuffer();
		while(desc.charAt(index) != ')') {
			final String param = desc.substring(index);
			if (first_time) {
				first_time = false;
			} else {
				buf.append(", ");
			}

			buf.append(descSymbolToJavaType(param));

	        while (desc.charAt(index) == '[') {
	            index++;
	        }

	        if (desc.charAt(index) == 'L') {
	            while(desc.charAt(index) != ';')
	                index++;
	        }

	        index++;
		}

		return buf.toString();
	}

	static void output_method(final String classname, final MethodNode methodnode) {
		final String desc = methodnode.desc;

		final String return_value = get_return_value_from_desc(desc);

		final String params = collect_parameters(desc);

		System.out.println(classname + ": " +
						   return_value + " " +
						   methodnode.name + "(" +
						   params + ")");

	    // " | " + methodnode.signature);
	}

	public static void main(String[] args) {
		final String desc = "ZILjava/util/Lang;[J)V";
		final String ans = descSymbolToJavaType(desc.substring(18));
		System.out.println(ans);
	}
}
