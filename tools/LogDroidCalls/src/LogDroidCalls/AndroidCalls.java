package LogDroidCalls;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.HashSet;

/**
 * <pre
 * This class has methods to call
 *   o To determine if a package is an android package
 *   o To determine if a package.class is on a list of exempt
 *     android system classes
 *   o To determine if a package.class.method is on a list of
 *     exempt android system methods
 * </pre>
 */

public class AndroidCalls {

    // ***
    static private String EXEMPT_CLASSES_FILE_NAME = "_exempt_classes";
    static private HashSet<String> exempt_class_names = new HashSet<String>();
    static private boolean exempt_class_names_first_call = true;


    // ***
    static private String EXEMPT_METHODS_FILE_NAME = "_exempt_methods";
    static private HashSet<String> exempt_method_names = new HashSet<String>();
    static private boolean exempt_method_names_first_call = true;


    // ***
	// Read package names from this file
	static private String PKG_FILE_NAME = "_packages";
	// Contains a list of packages name from file PKG_FILE_NAME
	// Each package name looks like "com.android.mailcommon"
	static private HashSet<String> android_pkg_names = new HashSet<String>();
	static private boolean android_pkg_first_call = true;


	static private void read_file(final boolean must_exist,
	                              final File droid_dir,
	                              final String pkg_file_name,
	                              final HashSet<String> hash_set) throws IOException {

		LineNumberReader reader = null;

		try {
		    final File file = new File(droid_dir, pkg_file_name);
		    if (file.isFile()) {
			    final FileReader fileReader = new FileReader(file); // FileNotFoundException
			    final BufferedReader buffReader = new BufferedReader(fileReader);
			    reader = new LineNumberReader(buffReader);

			    String line;
			    while ((line = reader.readLine()) != null) { // IOException
			        line = line.trim();
			        if (!line.startsWith("#") && line.length() > 0) {
			            hash_set.add(line);
			        }
			    }
		    } else if (must_exist) {
		    	throw new IOException("The file does not exist.");
		    }

		} catch (IOException ex) {
		      throw new IOException("reading file " + pkg_file_name +
		                            (reader == null ? "\n" : " line:" + reader.getLineNumber()) + "\n" +
		                             ex.getMessage());
		} finally {
		    try {
				if (reader != null) {
					reader.close();
			    }
		    } catch(Exception ex) {
		    }
		}
	}


	static boolean isAndroidCall(final File droid_calls_dir,
		                         final String pkgname) throws IOException {
	    if (android_pkg_first_call) {
	        android_pkg_first_call = false;
	        read_file(true,  // must exist: throw IOException if the file no exist
	                  droid_calls_dir,
	                  PKG_FILE_NAME,
	                  android_pkg_names); // IOException
	    }

	    final String pkgname_2 = pkgname.replace('/',    // replace this char
	                                             '.');   // replace with this char
	    final boolean retval = android_pkg_names.contains(pkgname_2);
	    return retval;
    }

   /**
    * Caller has determined that the package in which pkg_class_name lives
    * is an android package. If pkg_class_name is listed in file _exempt_classes,
    * then no methods in that class should have a Log.d entry.
    *
    *
    * @param pkg_class_name separators are '.' Looks like "components.of.pkg.classname"
    * @return true if pkg_class_name is listed in file _exempt_class
    */
	static boolean is_class_exempt(final File droid_calls_dir,
	                               final String pkg_class_name) throws IOException {
	    if (exempt_class_names_first_call) {
	        exempt_class_names_first_call = false;
	        read_file(false, // must_exist: no IOException if the file no exist
	                  droid_calls_dir,
	                  EXEMPT_CLASSES_FILE_NAME,
	                  exempt_class_names); // IOException
	    }

	    final boolean retval = (exempt_class_names.size() > 0 ?
	                            exempt_class_names.contains(pkg_class_name) :
	                            false);
	    return retval;
	}


   /**
    * Call has determined that the package in which pkg_class_method_name lives
    * is an android system package. If pkg_class_method_name is listed in file
    * _exempt_methods, then the method should not have a Log.d entry.
    *
	* @param pkg_class_method_name looks like "android/util/Log.d"
	* @return true if pkg_class_method_name is listed in file _exempt_class
    */
	static boolean is_method_exempt(final File droid_calls_dir,
	                                final String pkg_class_method_name) throws IOException {
        if (exempt_method_names_first_call) {
            exempt_method_names_first_call = false;
            read_file(false, // must_exist: no IOException if the file no exist
                      droid_calls_dir,
                      EXEMPT_METHODS_FILE_NAME,
                      exempt_method_names); // IOException
        }

        final boolean retval;
        if (exempt_method_names.size() > 0) {
            final String all_dots = pkg_class_method_name.replace('/', '.');
            retval = exempt_method_names.contains(all_dots);
        } else {
            retval = false;
        }

        return retval;
	}
}
