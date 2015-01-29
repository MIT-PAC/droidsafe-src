
import java.io.File;
import java.io.IOException;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/*
 to compile
   javac PkgJar.java

 to run
   java PkgJar <jarfile> // outputs unique package names contained in the jar file
   Or
   java PkgJar <dir>     // outputs unique package names contained in all jar files
                         // contained in directory "dir". Does not search directory
                         // "dir" recursively
 */


class PkgJar {

  private static void process_jarfile(final HashSet<String> hashset,
                                      final File file) throws IOException {

    final String name = file.getName();
    if (name.endsWith(".jar")) {
      final JarFile jarfile = new JarFile(file); // IOException

      for (Enumeration<JarEntry> eml = jarfile.entries(); eml.hasMoreElements(); ) {
        final JarEntry entry = eml.nextElement();
        final String line = entry.toString();
        if (line.endsWith(".class")) {
          
          final String pkg_path = line.substring(0, line.lastIndexOf('/'));
          hashset.add(pkg_path);
        }
      }
    }
  }


  public static void main(String[]args) {
    try {
      final HashSet<String>hashset = new HashSet<String>();

      if (args.length != 1) {
        throw new IOException("Must run this program with one argument.");
      }

      final File file = new File(args[0]);

      if (!file.exists()) {
        throw new IOException(args[0] + " must be a .jar file or a directory."); 
      }

      if (file.isDirectory()) {
        final File dirlist[] = file.listFiles();
        for (int i = 0; i < dirlist.length; i++) {
          final File f = dirlist[i];
          if (!f.isDirectory()) {
            PkgJar.process_jarfile(hashset, f);            
          }
        }

      } else {
        PkgJar.process_jarfile(hashset, file);
      }

      if (hashset.size() == 0) {
        throw new IOException("No package names were found in " + args[0]);
      }

      Object[]array = hashset.toArray();
      for (int i = 0; i < array.length; i++) {
        System.out.println(((String)array[i]).replace('/', '.'));
      }

    } catch (IOException ex) {
      System.err.println(ex.getMessage());
    }
  }
}