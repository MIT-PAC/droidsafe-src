package droidsafe.eclipse.plugin.core.util;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

import droidsafe.eclipse.plugin.core.Activator;

public class DroidsafePluginUtilities {


  /**
   * Returns the relative path for a fully qualified classname. Adds "src/" before the pathname for
   * the class. Strips away internal class names.
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

  public static void removeAllDroidsafeMarkers(IProject project) {
    Activator.getDefault();
    String markerId = Activator.PLUGIN_ID + ".droidsafemarker";
    IMarker markers[];
    if (project != null) {
      try {
        markers = project.findMarkers(markerId, true, IResource.DEPTH_INFINITE);
        for (IMarker marker : markers) {
          marker.delete();
        }
      } catch (CoreException ex) {
        ex.printStackTrace();
      }
    }
  }

}
