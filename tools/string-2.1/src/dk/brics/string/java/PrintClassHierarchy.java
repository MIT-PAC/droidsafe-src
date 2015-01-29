package dk.brics.string.java;

/**
 * Prints all ancestor types of a given class or interface. These types can not always be found in the
 * Sun's javadoc for Java, because some of the types are package private. However, Soot may indeed decide
 * to create a variable of an inaccessible type such as <tt>java.lang.AbstractStringBuilder</tt>. 
 * <p/>
 * This class is not part of the Jimple-&gt;Intermediate translation, but is a tool used to develop it.
 */
public class PrintClassHierarchy {
	public static void printAncestors(Class<?> clazz, String indent) {
		System.out.print(indent);
		System.out.println(clazz.getCanonicalName());
		
		// recurse on supertypes
		String childIndent = indent + "|    ";
		if (clazz.getSuperclass() != null) {
			printAncestors(clazz.getSuperclass(), childIndent);
		}
		for (Class<?> superInterface : clazz.getInterfaces()) {
			printAncestors(superInterface, childIndent);
		}
	}
	
	public static void main(String[] args) {
		printAncestors(StringBuffer.class, "");
		System.out.println();
		printAncestors(StringBuilder.class, "");
		System.out.println();
		printAncestors(String.class, "");
		System.out.println();
		printAncestors(String[].class, "");
		System.out.println();
		printAncestors(int[].class, "");
	}
}
