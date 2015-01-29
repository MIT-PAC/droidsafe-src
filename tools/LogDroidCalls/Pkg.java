import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

// This class collects unique package names

// 1 cd to some source/ dir that containing directories containing
//   primarily android .java files - as apposed to general jkd file.
// 2 find . -name "*.java" -exec grep package {} + > somefile
// 3 java Pkg somefile > some_otherfile
//   - reads somefile
//   - outputs list of unique package names
//   - some_otherfile now contains a list of package names
//   Edit this list into the file of package names that
//   LogDroidCalls reads
//
// Or
// 3 java Pkg somefile >> _packages


class Pkg {

  public static void main (String[]args) {
    try {
      if (args.length != 1) {
        throw new IOException("Must run this program with one argument.");
      }

      final File file = new File(args[0]);
      final FileReader fileReader = new FileReader(file); // FileNotFoundException
      final BufferedReader buffReader = new BufferedReader(fileReader);
      HashSet<String>hashset = new HashSet<String>();

      final String LOOK_FOR = ":package ";
      final int LOOK_FOR_LEN = LOOK_FOR.length();
      String lastPkg = "";
      String line;
      while ((line = buffReader.readLine()) != null) {  // IOException
        final int index = line.indexOf(LOOK_FOR);
        if (index != -1) {
          final int index_2 = line.indexOf(";");
          final String package_name = line.substring(index + LOOK_FOR_LEN,
                                                     index_2);
          // line looks like "com.android.accessorychat"
          if (!package_name.equals(lastPkg)) {
            hashset.add(package_name);
          }
          lastPkg = package_name;
        }
      }
      
    if (hashset.size() == 0) {
      throw new IOException("No package names were found in " + args[0]);
    }

    final Object[]pkg_array = hashset.toArray();

    for (int i = 0; i < pkg_array.length; i++) {
        System.out.println(pkg_array[i]);
    }

    } catch (IOException ex) {
      System.err.println(ex.getMessage());
    }
  }
}