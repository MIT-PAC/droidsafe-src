package droidsafe.eclipse.plugin.core.util;

public class DroidsafePluginUtilities {

  
  /**
   * Returns the relative path for a fully qualified classname.
   * Adds "src/" before the pathname for the class. 
   * Strips away internal class names. 
   */
  public static String classNamePath(String className) {
    // change package separator (.) into path separator (/)
    String filename = className.replace(".", "/");
    // Remove any internal classes from the name
    filename = filename.replaceFirst("[$][0-9]+", "");
    if (filename.indexOf("$") > 0) {
      filename = filename.substring(0, filename.indexOf("$"));
    }
    return "src/" + filename + ".java";
  }
}
