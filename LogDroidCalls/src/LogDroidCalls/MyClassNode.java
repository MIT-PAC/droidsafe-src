package LogDroidCalls;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;

import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.LineNumberNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.util.TraceMethodVisitor;

/**
 * <pre>
 * This class process a single class file.
 * Process each method in the class.
 * Look for invoke bytecode instructions that call android system methods.
 * For each android system method instruction do the following
 * If the android system method opcode is invokevirtual/invokeinterface/invokestatic
 *   Add a static method in Proxy class
 *   The static method calls the android system method and then calls Log.d to output
 *   the android system method name and parameter values
 * If the android system method opcode is invokespecial
 *   Insert bytecode that calls Log.d to output the android system method name and
 *   the parameter values.
 * </pre>
 */


public class MyClassNode extends ClassNode {

    // Count of how many Log.d instructions are added to the .class byte-code
    private int class_alterations_count;

    static final String PROXY_CLASS_NAME = "Proxy";

    // Is set from the package name of the first android application .class read.
    // Is used as the package name of the proxy class where all the static methods
    // are written.
    // Note: The component separator is '/' (not '.')
    static private String proxy_pkg_name;

    // MyClassNode process the .class file of an android application and writes
    // java code to proxy_sb.  proxy_file is the File where the contents of
    // proxy_file will be written
    static private File proxy_file;

    // Static StringBuilder. As .class files of the Android app are processed,
    // java code is added to this StringBuilder.
    // Eventually it will contain an entire .java file, which will be written
    // somewhere below android application src/... directory, with the android
    // application's other .java files
    static private StringBuilder proxy_sb;

    // These Strings appear in the Lod.d output
    // Each new Log.d entry added by this class begins with this String,
    // making it easy to use grep on the file Log.d writes to.
    // Indicates that the android method parameter types are output
    static private final String LOGD_GREP_PARAM_TYPES = "~#";
    // Indicates that the android method parameter values are output
    static private final String LOGD_GREP_PARAM_VALUES = "~~";
    // The parameter values output by Log.d are separated by this String.
    static private final String LOGD_PARAM_SEPARATOR = "+\", \"+";

/* UNUSED - for detecting if an android system method is protected
    static private String ANDROID_JARS_FILE_NAME = "_android_jars";
    static private ClassLoader cl_loader;
    static private final String [] ANDROID_JAR_FILES = {
                                                       "/Library/android-sdk-macosx/platforms/android-16/android.jar"
                                                       };
*/
    public MyClassNode() {
        if (proxy_sb == null) {
            proxy_sb = new StringBuilder();
        }
        class_alterations_count = 0;
    }


	// input string is a substring of something that looks like
	//    (ZILjava/util/Lang;[J)V
	//
	// descSymbol has '/' component separators for objects
	// Returned String for an object has '.' component separators for objects
	private String descSymbolToJavaType(final String descSymbol) {
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
		} else if (descSymbol.startsWith("L")) {
			final String str = descSymbol.substring(1, descSymbol.indexOf(";"));
			retval = str.replace('/', '.');
		} else {
			retval = ""; // TODO ERROR
		}

		sb.append(retval);
		for (int k = 0; k < array_dim_count; k++) {
			sb.append("[]");
		}

		return sb.toString();
	}


	// unique_method_names entries look like
	//     compoents_of_package_classname_methodname(ZLjava/lang/String;)V
	// tokens_1 pkgname/class.method  ex:  "android/app/Activity.<init>"
	// tokens_2 the parameters 		  ex:  "(Landroid/os/Bundle;)V"
    private AbstractInsnNode move_android_call_to_proxy_class(final HashSet<String> unique_method_names,
                                                              final int opcode,
                                                              final String pkg_classname_of_method,
                                                              final String invoked_methodname,
                                                              final int line_number,
                                                              final String tokens_1,
                                                              final String tokens_2,
                                                              final MethodNode method_node,
                                                              AbstractInsnNode current_node) {

        // Form String new_methodname - All components are separated with '_'
        // It is the name of the static java method to be created below, if
        // it has not already been created.
        final String new_methodname = pkg_classname_of_method.replace('.', '_') +
                                	  "_" + invoked_methodname;
        final String new_methodname_with_signature = new_methodname + tokens_2;
        if (!unique_method_names.contains(new_methodname_with_signature)) {
            unique_method_names.add(new_methodname_with_signature);

            // ***
            // First append to proxy_sb a static java method
            //
            // Create something like
            // public static void method_name(some.pkg.name.classname p_0, int p_1, char[] p_2, ...)
            int index = tokens_2.lastIndexOf(')');
            final String return_type = descSymbolToJavaType(tokens_2.substring(index + 1));

            proxy_sb.append("  static public ");
            proxy_sb.append(return_type);
            proxy_sb.append(" ");
            proxy_sb.append(new_methodname);

            // ***
            // Create formal parameter section
            boolean add_comma = false;
            final Vector<Boolean> primitive = new Vector<Boolean>();
            proxy_sb.append("(");
            int param_num = 0;
            if (opcode != 184) { // 184 is invokestatic
                proxy_sb.append(pkg_classname_of_method);
                proxy_sb.append(" p_0");
                param_num++;
                primitive.add(true);
                add_comma = true;
            }
            index = 1;

            // The formal parameter type-name should have '.' and not '$'
            // Change $ to .
            // TODO What about escaped '$'
            final String tokens_2_no_dollar_signs = tokens_2.replace('$', '.');

            while (tokens_2_no_dollar_signs.charAt(index) != ')' ) {
                if (add_comma) {
                    proxy_sb.append(", ");
                }
                add_comma = true;
                primitive.add(tokens_2_no_dollar_signs.charAt(index) != '['
                               &&
                               tokens_2_no_dollar_signs.charAt(index) != 'L');

                proxy_sb.append(descSymbolToJavaType(tokens_2_no_dollar_signs.substring(index)));

                while (tokens_2_no_dollar_signs.charAt(index) == '[') {
                    index++;
                }

                if (tokens_2_no_dollar_signs.charAt(index) == 'L') {
                    while(tokens_2_no_dollar_signs.charAt(index) != ';')
                        index++;
                }

                proxy_sb.append(" p_");
                proxy_sb.append(param_num++);

                index++;
            }
            proxy_sb.append(") {\n    ");

            // ***
            // Body of the method

            // If the method returns a value, form
            // "retval = "
            if (!"void".equals(return_type)) {
                proxy_sb.append(return_type);
                proxy_sb.append(" retval = ");
            }

            // Form call the java code to call the android system method that
            // the replaced instruction originally called
            if (opcode == 184) {
                proxy_sb.append(pkg_classname_of_method);
                proxy_sb.append(".");
                proxy_sb.append(invoked_methodname);
            } else {
                proxy_sb.append("p_0.");
                proxy_sb.append(invoked_methodname);
            }
            proxy_sb.append("(");
            add_comma = false;
            if (opcode == 184 && param_num > 0) {  // 184 is invokestatic
                proxy_sb.append("p_0");
                add_comma = true;
            }
            for(int i = 1; i < param_num; i++) {
                if (add_comma) {
                    proxy_sb.append(", ");
                }
                add_comma = true;
                proxy_sb.append("p_");
                proxy_sb.append(i);
            }
            proxy_sb.append(");\n");


            // ***
            // Add Log.d
            // Add line: android.util.log.d("android.app.Activity.onCreate", p_0, ...
            proxy_sb.append("    android.util.Log.d(\"");
            proxy_sb.append(LOGD_GREP_PARAM_VALUES);
            // TODO what about return value

            final String location = this.name + "." + method_node.name +
            					   ":" + line_number;
            proxy_sb.append(location);
            proxy_sb.append(": ");

            // Form second argument to Log.d
            // The type expected for 2nd arg is String
            // The second arg to Log.c is a concatenation of p_0 + p_1...
            //
            // The block below loops through each parameter. If the parameter
            // is not a primitive, then ".toString" is appended to the object.
            // If p_n is a primitive it will be automatically converted to
            // string.

            //      Log.d("tag", "other stuff")
            // add this comma  ^
            proxy_sb.append("\", \"");

            proxy_sb.append(pkg_classname_of_method);
            proxy_sb.append(".");
            proxy_sb.append(invoked_methodname);
            proxy_sb.append("\"+");

            if ((opcode == 184 && param_num < 1) || (opcode != 184 && param_num < 2)) {
                proxy_sb.append("\"(NO PARAMS)\"");
            } else {
                boolean add_plus = false;

                proxy_sb.append("\"(\"+");
                if (opcode == 184 && param_num > 0) {
                    proxy_sb.append("p_0");
                    if (!primitive.elementAt(0)) {
                        proxy_sb.append(".toString()");
                    }
                    add_plus = true;
                }
                for (int k = 1; k < param_num; k++) {
                    if (add_plus) {
                        proxy_sb.append(MyClassNode.LOGD_PARAM_SEPARATOR);
                    }
                    add_plus = true;

                    proxy_sb.append("p_");
                    proxy_sb.append(k);

                    if (!primitive.elementAt(k)) {
                        proxy_sb.append(".toString()");
                    }
                }

                proxy_sb.append("+\")\"");
            }

            proxy_sb.append(");\n");

            if (!"void".equals(return_type)) {
                proxy_sb.append("    return retval;\n");
            }
            proxy_sb.append("  }\n\n");
        }
        // Done with appending to proxy_sb


        // ****
        // Replace the currentNode invokevirtual/invokespecial/invokeinterface/invokestatic instruction

        // Create the invokestatic instruction that replaces the currentNode instruction
        // If opcode of the currentNode is not invokestatic, need to add a first parameter
        // to the descriptor,
        // ie The last argument popped for invokespecial/invokevirtual/invokeinterface
        //    bytecode instruction needs to be the object that is invoking the method.
        //    invokestatic does not need do this.
        //
        // Form descriptor
        // o If opcode is invokespecial/invokevirtual/invokeinterface, insert as the first
        //   param in the descriptor the object invoking the method
        // o If opcode is invokestatic,  use tokens_2 as is
        // Note: token_2 must have '$' if the class is an inner class
        final String tokens_2_with_invoking_obj = (opcode == 184 ?  // 184 is invokestatic
                                                   tokens_2 :
                                                  "(L" + pkg_classname_of_method.replace('.', '/') + ";" +
                                                    tokens_2.substring(1));

        final AbstractInsnNode new_instruc = new MethodInsnNode(184,                 // invokestatic
                                                                proxy_pkg_name + "/" + PROXY_CLASS_NAME,
                                                                new_methodname,      // method name
                                                                tokens_2_with_invoking_obj); // descriptor
        method_node.instructions.insert(current_node, new_instruc);

        // Remove current_node
        method_node.instructions.remove(current_node);

        current_node = new_instruc;

        // Increment global count
        class_alterations_count++;

        return current_node;
    }

   /**
    * The bytecode instruction current_node is invoking an Android system method.
    * The android system method is in superclass of the class containing current_node.
    * The android system method is is private or is in super class
    * So can't put the system call in the Proxy class as usual.
    * Instead, call this method which simply adds a Log.d call that that displays
    * the types of the parameters
    *
    * @param tokens_1 looks like: "android/app/Activity.onCreate"  or  "java/lang/String.getChar"
    * @param tokens_2 looks like: "()V   or   "(Landroid/os/Bundle;)V"
    */
    private AbstractInsnNode insert_logd_before_android_instruction(final MethodNode method_node,
                                                                    AbstractInsnNode current_node,
                                                                    final int line_number,
                                                                    final String tokens_1,
                                                                    final String tokens_2,
                                                                    final boolean first_protected_method) {

        // Insert an invokestatic class to call this class and method
        // each time an android system instruction is located
        final String LOG_CLASS_NAME = "android/util/Log";
        final String LOG_METHOD_NAME = "d";
        final String LOG_DESCRIPTOR = "(Ljava/lang/String;Ljava/lang/String;)I";

        AbstractInsnNode old_instruction;
        AbstractInsnNode new_instruction;

        // ***
        // LDC
        final String location = this.name + "." + method_node.name + ":" + line_number;
        new_instruction = new LdcInsnNode(LOGD_GREP_PARAM_TYPES + location);
        method_node.instructions.insert(current_node, new_instruction);

        // ***
        // LDC
        // Note tokens_2 has '$' when class is inner class
        old_instruction = new_instruction;
        new_instruction = new LdcInsnNode(tokens_1 + tokens_2);
        method_node.instructions.insert(old_instruction, new_instruction);


        // Note: At this point the stack is (only temporarily) 2 slots
        //       larger than the original bytecode. Increase stack size
        //       just one time.
        if (first_protected_method) {
            method_node.maxStack += 4; // Seems like this should be 2
                                       // But 2 causes stack overflow
        }

        // ***
        // INVOKESTATIC Log
        old_instruction = new_instruction;
        new_instruction = new MethodInsnNode(184,   // invokestatic
                                             LOG_CLASS_NAME,
                                             LOG_METHOD_NAME,
                                             LOG_DESCRIPTOR);
        method_node.instructions.insert(old_instruction, new_instruction);

        // ***
        // POP
        old_instruction = new_instruction;
        new_instruction = new InsnNode(87); // 87 is pop
        method_node.instructions.insert(old_instruction, new_instruction);

        class_alterations_count++;

        // Increment to the last of the four instruction that were just created
        for(int i = 0; i < 4; i++) {
            current_node = current_node.getNext();
        }

        return current_node;
    }

/* UNUSED - for detecting if an android system method is protected
    // Read the file that contains the list of android .jar files
    // The file is in droid_calls_dir
    private Vector<String> read_list_of_android_jar_files(final File droid_calls_dir) throws IOException {

        LineNumberReader reader = null;
        final File file = new File(droid_calls_dir, ANDROID_JARS_FILE_NAME);

        try {
            final Vector<String> jars_list = new Vector<String>();

            final FileReader file_reader = new FileReader(file); // FileNotFoundException
            BufferedReader buff_reader = new BufferedReader(file_reader);
            reader = new LineNumberReader(buff_reader);

            String line;
            while ((line = buff_reader.readLine()) != null) { // IOException
                if (!line.startsWith("#") && line.length() > 0) {
                    jars_list.add(line);
                }
            }

            return jars_list;

        } catch (IOException ex) {
            throw new IOException("Error opening/reading file:" + file.getPath() +
                                   (reader == null ? "" : " line:" + reader.getLineNumber()) + "\n" +
                                   ex.toString());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch(Exception ex) {
            }
        }
    }
*/

/* UNUSED - for detecting if an android system method is protected
    // Called once only to build a class loader that can load android .jar files.
    // This method creates a ClassLoader initialize with a list of android .jar files.
    //
    // The caller can then call Class cls = Class.forName(pkg_name, false, class_loader)
    private ClassLoader build_class_loader(final File droid_calls_dir) throws IOException {

        final int URL_SIZE = 1;
        final List<URL>urls = new ArrayList<URL>(URL_SIZE);

        final Vector<String> android_jar_files = read_list_of_android_jar_files(droid_calls_dir); // IOException

        for (int j_indx = 0; j_indx < android_jar_files.size(); j_indx++) {
            final File jar = new File(android_jar_files.elementAt(j_indx));
        // REPLACED
        // for (int j_indx = 0; j_indx < ANDROID_JAR_FILES.length; j_indx++) {
        //    // foreach(filepath: external file *.JAR)
        //    // With each external file *.JAR do the following block
        //
        //    final File jar = new File(ANDROID_JAR_FILES[j_indx]);
            final JarFile jf = new JarFile(jar);  // IOException
            urls.add(jar.toURI().toURL());        // MalformedURLException
            final Manifest mf = jf.getManifest(); // IOException
            if (mf != null) {
                final String cp = mf.getMainAttributes().getValue("class-path");
                if (cp != null) {
                    for (String cpe : cp.split("\\s+")) {
                        final File lib = new File(jar.getParentFile(), cpe);
                        urls.add(lib.toURI().toURL()); // MalformedURLException
                    }
                }
            }
        } // for loop

        ClassLoader cls_loader = ClassLoader.getSystemClassLoader();
        if (urls.size() > 0) {
            cls_loader = new URLClassLoader(urls.toArray(new URL[urls.size()]),
                                           ClassLoader.getSystemClassLoader());
        }

        return cls_loader;
    }
*/

/* UNUSED - for detecting if an android system method is protected
    // This method determines if the android method is protected.
    // It loads some android .jar files (only android.jar for now).
    // So that ClassforName can be used to get a Class object.
    // So that the Class object be used to get the method the caller
    // is interested in and determine if that method is protected.
    private boolean is_called_method_protected(final String pkg_class_name_of_superclass,
                                               final String invoked_methodname,
                                               final String tokens_2,
                                               final File droid_calls_dir) throws IOException {

        boolean calling_superclass_protected_method = false;

        try {
            if (cl_loader == null) {
                cl_loader = build_class_loader(droid_calls_dir);
            }
            final Class cls = Class.forName(pkg_class_name_of_superclass,
                                            false,
                                            cl_loader); // ClassNotFoundException

            final Method m[] = cls.getDeclaredMethods();
            for (int i = 0; !calling_superclass_protected_method && i < m.length; i++) {
                // ex: "protected java.lang.Object java.utils.Stack.push(java.lang.Object,int)"
                if (m[i].getName().equals(invoked_methodname)) {
                    final String method_signature = m[i].toString();
                    if (method_signature.startsWith("protected")) {
                        // method_signature looks like: "protected void android.app.Activity.onCreate(android.os.Bundle,int)
                        // tokens[2]        looks like: "(Landroid/os/Bundle;I)V"
                        //
                        // Loop thru the parameters lists of both
                        // method_signature and tokens[2] - if the
                        // params don't match set params_match false
                        boolean params_match = true;
                        int methsig_tkn_count = 0;
                        boolean methsig_reached_end = false;
                        int tkn2_tkn_count = 0;
                        int methsig_index = method_signature.indexOf('(') + 1;
                        int tkn2_index = tokens_2.indexOf('(') + 1;
                        while(params_match && tokens_2.charAt(tkn2_index) != ')') {
                            // ***
                            // Get next token_2 token
                            final String return_type_tkn2 = descSymbolToJavaType(tokens_2.substring(tkn2_index));
                            while(tokens_2.charAt(tkn2_index) == '[') {
                                tkn2_index++;
                            }
                            if (tokens_2.charAt(tkn2_index) == 'L') {
                                while(tokens_2.charAt(tkn2_index) != ';') {
                                    tkn2_index++;
                                }
                            }
                            tkn2_index++;
                            tkn2_tkn_count++;

                            // ***
                            // get next method_signature token
                            if (!methsig_reached_end) {
                                int methsig_nextindex = method_signature.indexOf(',', methsig_index);
                                if (methsig_nextindex == -1) {
                                    methsig_nextindex = method_signature.indexOf(')', methsig_index);
                                    methsig_reached_end = true;
                                }
                                final String return_type_methsig = method_signature.substring(methsig_index, methsig_nextindex);
                                methsig_index = methsig_nextindex + 1;
                                methsig_tkn_count++;

                                // ***
                                // If the two tokens don't match, the methods are not the same
                                if (!return_type_tkn2.equals(return_type_methsig)) {
                                    params_match = false;
                                }
                            }
                        }

                        if (methsig_tkn_count != tkn2_tkn_count) {
                            params_match = false;
                        }

                        calling_superclass_protected_method = params_match;
                    }
                }
            }

            return calling_superclass_protected_method;

        } catch(ClassNotFoundException ex) {
            throw new IOException(ex.toString());
        }
    }
*/

    // Each time a Log.d instruction is added, global class_alterations_count is incremented
	//
	// When this method discovers an Android system call bytecode instruction, and
    // the opcode is invokevirtual, invokeinterface, or invokestatic, then this method
	// o creates a static java method whose name is built by concatenating package name,
	//   class name and method name.
	//   The method is added to Proxy.java file, unless the pkg/class already has
    //   been created.
	//   This created static java method invokes the Anroid system call and also
	//   calls Log.d to display parameter values.
	// o replaces the original Android system call instruction with a bytecode
	//   instruction that invokes the just-created static java method
	//
	// unique_method_names Set The String elements look something like
	//         compoents_of_package_classname_methodname(ZLjava/lang/String;)V
	//         Is used to determine if the static java method already has been created.
	//
    private void process_byte_code_method(final HashSet<String> unique_method_names,
                                          final MethodNode method_node,
                                          final File droid_calls_dir) throws IOException {
        boolean first_protected_method = true;

        int line_number = 0;
	    AbstractInsnNode current_node = method_node.instructions.getFirst();
        while(current_node != null) {
	      final int opcode = current_node.getOpcode();

	      if (current_node instanceof LineNumberNode) {
	    	  final LineNumberNode lnn = (LineNumberNode)current_node;
	    	  line_number = lnn.line;
	      }

	      // invokevirtual, invokespecial, invokestatic, invokeinterface,
	      // 186 - invokedynamic is unused
	      if (opcode >= 182 && opcode <= 185) {
	        TraceMethodVisitor tmv = new TraceMethodVisitor();
	        current_node.accept(tmv);
	        final List<?> l = tmv.getText();
	        String str = "";
	        for (int ii = 0; ii < l.size(); ii++) {
	            final Object o = l.get(ii);
	            str += o.toString().trim(); // + " [" + inst.getOpcode() + "]";
	        }
	        // tokens[0] INVOKESTATIC, INVOKESPECIAL, INVOKEVIRTUAL, INVOKEINTERFACE
	        // tokens[1] "android/app/Activity.<init>"  "android/app/Activity.onCreate, "java/lang/String.getChar"
	        // tokens[2] "()V", "(Landroid/os/Bundle;)V"
	        final String[]tokens = str.split("\\s+");
	        // classname looks like "android/app/Activity"
	        String pkg_classname_of_method = tokens[1].substring(0, tokens[1].indexOf("."));
	        pkg_classname_of_method = pkg_classname_of_method.replace("/", ".");

	        final String tokens_2 = tokens[2];

	        // pkgname looks like "android/app"
	        String pkgname = pkg_classname_of_method.substring(0, pkg_classname_of_method.lastIndexOf("."));
	        pkgname = pkgname.replace("/", ".");

            if (AndroidCalls.isAndroidCall(droid_calls_dir, pkgname) &&  // IOException
               !AndroidCalls.is_class_exempt(droid_calls_dir, pkg_classname_of_method) && // IOException
               !AndroidCalls.is_method_exempt(droid_calls_dir, tokens[1])) { // IOException

	        	// methodname is the simple name of the method being called
	        	final String invoked_methodname = tokens[1].substring(tokens[1].indexOf(".") + 1);

                if (!"<init>".equals(invoked_methodname)) {
                    // If opcode == 183 (invokespecial), then the called method
                    //   o is in superclass of current class
                    //   o or is in current class and is private.
                    //
                    // - In either case the method must be invoked with invokespecial
                    //   and not invokevirtual. This means the call can not be made
                    //   as a java method in the Proxy class, where the compiler
                    //   will produce invokevirtual instructions.
                    // - If the called method was private, it can't be called
                    //   from the Proxy class.
                    // - Plus if the called method was in the super class and
                    //   protected, it can't be called from Proxy.
                    //
                    // THEREFORE: If opcode is 183, insert a Log.d bytecode that
                    // ouputs the method being called and it's parameter types -
                    // instead of: putting the equivalent method call in Proxy
                    // where Log.d can output the paramter values.
                    if (opcode == 183) { // 183 is invokespecial
/* This case is eliminated now. All invokespecial bytecode instructructions are
   now handled by inserting Log.d instruction to output the instructions
   parameter types.

           			// component separaator of superName is '/'
	    			final String pkg_class_name_of_superclass = this.superName.replace('/', '.');


                    // o If opcode is invokespecial and are calling a method in
                    //   superclass with same name and parameters, then can't make
                    //   the call from Proxy class because it will be copiled to
                    //   invokevirtual which will call the child method right
                    //   back, then the Proxy method, then child... stack overflow
                    // o Or are calling a protected method of a superclass.
                    //   Can't make that call from Proxy class because Proxy class
                    //   won't compile (a protected method can be called only
                    //   from its child)
                    if ((opcode == 183   // opcode is invokespecial
                         &&
                        pkg_class_name_of_superclass.equals(pkg_classname_of_method))

                         ||

                        // Or are calling a protected method of a superclass
                        (pkg_class_name_of_superclass.equals(pkg_classname_of_method)
                           &&
                         is_called_method_protected(pkg_class_name_of_superclass,
                                                    invoked_methodname,
                                                    tokens_2,
                                                    droid_calls_dir))) { // IOException
*/
/*
                    if (pkg_class_name_of_superclass.equals(pkg_classname_of_method)
                         &&
                        is_called_method_protected(pkg_class_name_of_superclass,
                                                   invoked_methodname,
                                                   tokens_2,
                                                   droid_calls_dir)) { // IOException
	        	        // The current node is invokoking a method that is an Android
	        	        // system call. But that android system method is in the
	        	        // superclass of the class from where the calls is being
	        	        // made AND the method is protected - So can't put the call
	        	        // in the Proxy class like usual, and so can't have Log.d
	        	        // display the parameter values
*/
	        	        current_node = insert_logd_before_android_instruction(method_node,
                	        	                                              current_node,
                	        	                                              line_number,
                	        	                                              tokens[1],
                	        	                                              tokens_2,
                	        	                                              first_protected_method);
	        	        first_protected_method = false;

	        	    } else {
	        	        // The method being invoked IS callable from the Proxy class,
	        	        // so replace the invoke istruction with a invoke instruction
	        	        // to call a proxy method that then:
	        	        //   o calls the originally intended android system method
	        	        //   o call Log.d to output the android method method being
	        	        //     called and output the parameters values.
	        	        current_node = move_android_call_to_proxy_class(unique_method_names,
                	        	                                        opcode,
                	        	                                        pkg_classname_of_method,
                	        	                                        invoked_methodname,
                	        	                                        line_number,
                	        	                                        tokens[1],
                	        	                                        tokens_2,
                	        	                                        method_node,
                	        	                                        current_node);
	        	    }
                }
	         }
	      }

	      current_node = current_node.getNext();

        } // end loop
    }


    int get_class_alterations_count() {
        return class_alterations_count;
    }


    // From the application directory and package string derive the file
    // to where static java methods will be written.
    //
    // droid_calls_dir The android application directory
    // proxy_pkg_str The package name of the currently-being-processed .class file
    private File derive_proxy_file(final File android_app_dir,
                                   final String proxy_pkg_str) {

        final File android_app_src_dir = new File(android_app_dir, "src");
        final File proxy_dir = new File (android_app_src_dir, proxy_pkg_str);
        File proxy_f = null;
        if (proxy_dir.isDirectory()) {
            final File[] child = proxy_dir.listFiles();
            for (int i = 0; i < child.length && proxy_f == null; i++) {
                if (child[i].getPath().endsWith(".java")) {
                    proxy_f = new File(child[i].getParentFile(), PROXY_CLASS_NAME + ".java");
                }
            }

            /* NO LONGER DO THIS
             * Assume that Proxy.java is our file and class.
             *
            // If /path/to/proxy.java already exists, prepent 'x' chars to both
            // the class name and the java file leaf name that contains that class.
            if (proxy_f != null) {
            	while(proxy_f.exists()) {
            		final String leaf = proxy_f.getName();
            		proxy_f = new File(proxy_f.getParentFile(), "X" + leaf);
            		PROXY_CLASS_NAME = "X" + PROXY_CLASS_NAME;
            	}
            }
            */
        }

        return proxy_f;
    }


    // Process all the methods in the class
    // Insert instruction where needed.
    // Keep count of number of insertions in global class_alterations_count
    public void processByteCodeClass(final HashSet<String> unique_method_names,
                                     final File droid_app_dir,
                                     final File droid_calls_dir) throws IOException {

        // This method is called for each Android application class found in the
        // Android application this.name looks like:
        //           d/vogella/android/temperature/converter/ConvertActivity
        // Deterimine the package part of name.
        // Will create a file to write static methods to. Use the package name
        // as the package name for the created file.
        if (proxy_pkg_name == null) {
            proxy_pkg_name =  name.substring(0, name.lastIndexOf("/"));
            proxy_file = derive_proxy_file(droid_app_dir, proxy_pkg_name);

            proxy_sb.append("package ");
            proxy_sb.append(proxy_pkg_name.replace('/', '.'));
            proxy_sb.append(";\n\n");

            proxy_sb.append("public class ");
            proxy_sb.append(PROXY_CLASS_NAME);
            proxy_sb.append(" {\n\n");
        }

        for (Object method_node_object : this.methods) {
            final MethodNode method_node = (MethodNode)method_node_object;
            process_byte_code_method(unique_method_names, method_node, droid_calls_dir); // IOException
        }
    }


   /**
    * Have completed processing all Android project .class files.
    * This method ouputs the contents of global StringBuilder proxy_sb.
    */
    static public void createProxyFile() throws IOException {

    	FileOutputStream fos = null;

    	try {
    	    // Closes off the top level class block for the java file
	    	proxy_sb.append("\n}\n");

	    	// If proxy file already exists, overwrite it
    	    fos = new FileOutputStream(proxy_file);    // FileNotFoundException
    	    fos.write(proxy_sb.toString().getBytes()); // IOException

    	    System.out.println("Created file:" + proxy_file.getPath());

    	} catch (final IOException ex) {
    		throw new IOException("While creating file:" + proxy_file.getPath() + "\n" +
    							   ex.getMessage());
    	} finally {
    		try {
    			if (fos != null) {
    				fos.close();
    			}
    		}catch (Exception ex) {
    		}
    	}
    }

}
