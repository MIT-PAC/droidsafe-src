package LogDroidCalls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;

/**
 * Loops thru .class files of a android application.
 * Looks for invokeXXXXXX bytecode instruction that call Android system methods.
 * On finding one the bytecode instruction is replaced.
 * The replacement instruction
 *  o Calls a proxy static java method, that live in file Proxy.java
 *    The proxy java method calls the Android system method
 *  o Calls Log.d to announce the system method being called
 *    and the parameter values of the call.
 */

public class LogDroidCalls {
	private int alterations_count_current_class;
	private int alterations_count_total;

    // Elements of collection: The complete signature of the Android system method
	//       being called.
	//       The components of the package class methodname are separated with
	//       underscore character.
	//
    // For each bytecode Android system call to a pkg.class.method, LogDroidCalls
    // creates a static java method. The java static method then makes the
    // Android system call. The name of the static java method is
	// packagename_classname_methodname with all components of the package name
	// replaced with "_" making the method name legal.
	// Two or more static java methods can have the same package_classname_methodname
	// if their parameter signatures differ.
    private static final HashSet<String> unique_method_names = new HashSet<String>();

	private byte[] classFileToByteArray(final File file) throws IOException {
	    InputStream inStream = null;

	    try {
	      final String path = file.getPath();
	      if (!path.endsWith(".class")) {
	        throw new IOException("File " + path + " must end with .class");
	      }

	      if (!file.isFile()) {
	        throw new IOException("File " + path + " does not exist.");
	      }

	      final long len = file.length();
	      byte[]bytes = new byte[(int)len];

	      inStream = new FileInputStream(file); // FileNotFoundException

	      int offset = 0;
	      int numRead = 0;
	      while(offset < bytes.length
	              &&
	           (numRead = inStream.read(bytes, offset, bytes.length - offset)) >= 0) {  // IOException
	        offset += numRead;
	      }

	      if (offset < bytes.length) {
	        throw new IOException("Could not completely read file " + path);
	      }

	      return bytes;

	    } catch (IOException ex) {
	      throw new IOException ("Failed to convert file:" + file.getPath() + " to a byte array.\n" +
	                              ex.getMessage());
	    } finally {
	      try {
	          if (inStream != null) {
	            inStream.close();
	          }
	      } catch (Exception ex) {
	      }
	    }
    }


	// Return null is nothing is altered
	private byte[] process_class(final File class_file,
	                             final File droid_app_dir,
	                             final File droid_calls_file) throws IOException {
	    final String class_fullpath = class_file.getPath();

	    if (!class_fullpath.endsWith(".class")) {
	        throw new IOException(class_fullpath + " must end with \".class\"");
	    }
	    final byte[] bytes = classFileToByteArray(class_file); // IOException

	    // ClassReader parses a byte array and calls appropriate
	    // visit methods of "a given class visitor"
	    final ClassReader classReader = new ClassReader(bytes);

	    final ClassVisitor classNode_visitor = new MyClassNode();

	    classReader.accept(classNode_visitor, 0); // classReader parses byte array and calls the
	                                              // appropriate visit methods of classNode_visitor
	    // Alter the byte code
	    ((MyClassNode)classNode_visitor).processByteCodeClass(unique_method_names,
	                                                          droid_app_dir,
	                                                          droid_calls_file); // IOException
	    final byte[] bytes_altered;

	    // If no alterations were made to byte-code, set bytes_altered to null
	    alterations_count_current_class = ((MyClassNode)classNode_visitor).get_class_alterations_count();
	    alterations_count_total += alterations_count_current_class;
	    if (alterations_count_current_class == 0) {
	        bytes_altered = null;
	    } else {
	        final ClassWriter classWriter = new ClassWriter(0);
	        final ClassVisitor cw_visitor = classWriter;
	        ((ClassNode)classNode_visitor).accept(cw_visitor); // Makes cw_visitor (ClassWriter)
	                                                           // visit MyClassNode
	        bytes_altered = classWriter.toByteArray();
	    }

	    return bytes_altered;
	}


	// droid_call_dir Dir containing _packages file
	private void process_class_file(final File class_file,
	                                final File droid_app_dir,
									final File droid_calls_dir) throws IOException {
	    FileOutputStream outstream = null;

	    try {
	        alterations_count_current_class = 0;

	        // Returns null if nothing was altered
	        final byte[] bytes_altered = process_class(class_file,
	                                                   droid_app_dir,
                  								       droid_calls_dir); // IOException
	        if (bytes_altered == null) {
	            System.out.println("not altered:" + class_file.getPath());

	        } else {
                class_file.delete();
                outstream = new FileOutputStream(class_file); // FileNotFoundException
	            outstream.write(bytes_altered); // IOException

                System.out.println("Inserted " + alterations_count_current_class + " instructions:" +
                                    class_file.getPath());
	        }

	    } catch (IOException ex) {
	        throw new IOException("Error while processing byte code of file:" + class_file.getPath() + "\n" +
	                               ex.toString());
	    } finally {
	      try {
	        if (outstream != null) {
	          outstream.close();
	        }
	      } catch (Exception ex) {
	      }
	    }
	}


	// Search directory android application directory for application class files.
	// droid_app_dir Dir containing _packages file
	private void dir_traverse(final File file,
	                          final File droid_app_dir,
	                          final File droid_calls_dir) throws IOException {

	    if (file.isDirectory()) {
	        final File[] children = file.listFiles();
	    	for(File child : children) {
	        	dir_traverse(child, droid_app_dir, droid_calls_dir);
	    	}
	    }

	    // file is a normal file
	    final String leaf = file.getName();
	    if (leaf.endsWith(".class")) {
	        if (leaf.equals(MyClassNode.PROXY_CLASS_NAME + ".class")) {
	            System.out.println("Not processing bytecode for:" + leaf);
	        } else {
	            process_class_file(file, droid_app_dir, droid_calls_dir); // IOException
	        }
	    }
	}



   /**
	* Are called from target -post-compile of android build.xml.
	* All android app class files have been compiled.<br>
	*
	* <pre>
	* This program processes each .class file byte-code
	* looking for android system call instructions.
	* Each android system call instruction is replaced with
	* a bytecode instruction that calls a static java method.
	* The static java method
	*   o Calls the originally intended android system method
	*   o Call Log.d to show the android system method being called
	*     and to show the value of the parameters
	* </pre>
	*
	* @param argv
	* <pre>
	*    argv[0] path to android app dir. The android app dir contains
	*            bin/  and src/
	*    argv[1] the LogDroidCalls dir. Required because this is where
	*            the _packages file is.
	* </pre>
	*/
	public static void main(final String[]argv) {

	    try {
		    System.out.println("            wkdir:" + System.getProperty("user.dir"));
			System.out.println("      android dir:" + argv[0]);
			System.out.println("LogDroidCalls dir:" + argv[1]);

			if (argv.length < 2) {
			    throw new IOException("LogDroidCalls is being called with no parameter");
			}

			// Need this directory so can locate the android application .class files
			final File android_bin_dir = new File(argv[0], "bin");

			if (!android_bin_dir.exists()) {
			    throw new IOException(android_bin_dir.getPath() +
			                         " does not exist");
			}

			final LogDroidCalls droidCalls = new LogDroidCalls();
			final File droid_app_dir = new File(argv[0]);

			// droid_calls_dir required for to locate _packages file
			final File droid_calls_dir = new File(argv[1]);

			droidCalls.dir_traverse(android_bin_dir,
			                        droid_app_dir,
			                        droid_calls_dir);

			if (droidCalls.alterations_count_total > 0) {
				MyClassNode.createProxyFile(); // IOException
			} else {
			    System.out.println("Did not create file:" +
			                        MyClassNode.PROXY_CLASS_NAME +
			                       ".java - There were no bytecode alterations.");
			}

	    } catch (IOException ex) {
	    	System.out.println("ERROR " + ex.getMessage());
		}
	}

}
