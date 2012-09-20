
package jarmethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;

import com.sun.org.apache.bcel.internal.classfile.ClassParser;
import com.sun.org.apache.bcel.internal.classfile.JavaClass;

/**
 * This program takes a single parameter which must be either a .jar file
 * or a .class file
 * If the single parameter is a .jar file, the methods of each class in the jar
 * will be output.
 * If the single paramter is a .class file, the method of that class file will
 * be output.
 *
 * Requires asm-3-3.jar
 * 			asm-tree-3.3.jar
 */
public class JarMethods {

 /**
  * BuildJDK <jarfile> | <classfile>
  */
  public static void main(String[] args) throws IOException {

      System.out.println("Starting at " + new Date());

      final String file_name = args[0];

      JarMethods build = new JarMethods();

      if (file_name.endsWith(".jar")) {
          JarFile jfile = new JarFile(file_name);
          build.translate_classes_of_jar(jfile);
  	  } else if (file_name.endsWith(".class")) {
  		  final File file = new File(file_name);
  		  final byte[]bytes = build.classFileToByteArray(file); // IOException
  		  build.processClassFile(bytes);
  	  } else {
  		  System.out.println("parameter must be either a .jar or .class file");
  	  }

      System.out.println("done at " + new Date());
  }



  private void translate_classes_of_jar(final JarFile jfile) throws java.io.IOException {
    // Map from classname to class so we can find out information about
    // classes we have not yet instrumented.
    Map<String, JavaClass> classmap = new LinkedHashMap<String, JavaClass>();

    try {
      // Collect classes of jar file in classmap
      Enumeration<JarEntry> entries = jfile.entries();
      while (entries.hasMoreElements()) {
        JarEntry entry = entries.nextElement();
        final String entryName = entry.getName();

        if (entryName.startsWith("META-INF") ||
            entryName.endsWith("/") ||
            entryName.endsWith("~") ||
           !entryName.endsWith(".class") ||
            entryName.equals("java/lang/Object.class")) {
          continue;
        }

        // Get the binary for this class
        InputStream is = jfile.getInputStream(entry);
        JavaClass jc = null;
        try {
          ClassParser parser = new ClassParser(is, entryName);
          jc = parser.parse();
        } catch (Exception e) {
          throw new Error ("Failed to parse entry " + entry, e);
        }
        classmap.put(jc.getClassName(), jc);
      } // while

      // Loop thru classes collected in classmap
      for (String classname : classmap.keySet()) {
        try {
            processClassFile(classmap, classname);
        } catch (Throwable e) {
          throw new Error ("Couldn't process" + classname, e);
        }
      }

    } catch (Exception e) {
      throw new Error(e);
    }
  }


  private void processClassFile(byte[] bytes) {
	// ClassReader parses a byte array and calls appropriate
	// visit methods of "a given class visitor"
	final ClassReader classReader = new ClassReader(bytes);

	final ClassVisitor classNode_visitor = new MyClassNode();

	classReader.accept(classNode_visitor, 0); // classReader parses byte array and calls the
	                                          // appropriate visit methods of classNode_visitor
	// Alter the byte code
	((MyClassNode)classNode_visitor).processByteCodeClass();
  }

  private void processClassFile(final Map<String, JavaClass> classmap,
                                final String classname) throws java.io.IOException {

	final JavaClass jc = classmap.get(classname);
	final byte[] bytes = jc.getBytes();

	processClassFile(bytes);
  }

  /**
   * CUT AND PASTE from pac.agent.verifier.MyClassNode
   * 				and LogDroidCalls.LogDroidCalls
   * @param file Return contents of this file as a byte array
   * @return bytes array of the file contents
   * @throws MsgException If file not exist. If file does not end with .class
   */
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
}
