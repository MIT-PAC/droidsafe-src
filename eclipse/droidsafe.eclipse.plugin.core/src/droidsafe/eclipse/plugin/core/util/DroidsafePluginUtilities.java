package droidsafe.eclipse.plugin.core.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

import droidsafe.eclipse.plugin.core.Activator;
import droidsafe.eclipse.plugin.core.specmodel.CodeLocationModel;
import droidsafe.eclipse.plugin.core.specmodel.HotspotModel;
import droidsafe.eclipse.plugin.core.specmodel.MethodModel;
import droidsafe.eclipse.plugin.core.specmodel.SecuritySpecModel;
import droidsafe.utils.SourceLocationTag;

public class DroidsafePluginUtilities {

  /**
   * Id for the markers to be added to the Android app files.
   */
  public static final String DROIDSAFE_MARKER_ID = Activator.PLUGIN_ID + ".droidsafemarker";

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

  /**
   * Return the terminal classname from a fully specified classname
   * 
   */
  public static String extractClassname(String fullname) {
    return fullname.replaceFirst("^.*[.]", "");
  }

  public static void removeAllDroidsafeMarkers(IProject project) {
    IMarker markers[];
    if (project != null) {
      try {
        markers = project.findMarkers(DROIDSAFE_MARKER_ID, true, IResource.DEPTH_INFINITE);
        for (IMarker marker : markers) {
          marker.delete();
        }
      } catch (CoreException ex) {
        ex.printStackTrace();
      }
    }
  }


  /**
   * Creates eclipse task markers for all input events locations in the selected app.
   * 
   * @param spec The security spec.
   * @param project the Android java project for the application.
   * 
   */
  public static void generateMarkersForSecuritySpecification(IProject project) {
    if (project != null) {
      String projectRootPath = project.getLocation().toOSString();
      SecuritySpecModel spec = SecuritySpecModel.deserializeSpecFromFile(projectRootPath);
      if (spec != null) {
        generateMarkersForSecuritySpecification(spec, project);
      }
    }
  }


  /**
   * Creates eclipse task markers for all input events locations in the selected app.
   * 
   * @param spec The security spec.
   * @param project the Android java project for the application.
   * 
   */
  public static void generateMarkersForSecuritySpecification(SecuritySpecModel spec,
      IProject project) {
    removeAllDroidsafeMarkers(project);
    List<MethodModel> methods = new ArrayList<MethodModel>(spec.getEntryPoints());
    Collections.sort(methods);
    Map<MethodModel, List<MethodModel>> inputEventBlocks = spec.getInputEventBlocks();
    if (inputEventBlocks != null) {
      for (MethodModel inputMethod : inputEventBlocks.keySet()) {
        SourceLocationTag line = inputMethod.getDeclSourceLocation();
        if (line != null) {
          String clz = line.getClz();
          String classPath = DroidsafePluginUtilities.classNamePath(clz);
          IFile file = project.getFile(classPath);
          int lineNbr = line.getLine() - 1;
          if (file.exists()) {
            try {
              addMarkerForMethod(inputMethod, file, inputMethod.getShortSignature(), lineNbr);
              addMarkerForMethod(inputMethod, file, inputMethod.getSignature(), lineNbr);
              if (inputMethod.getReceiver() != null) {
                addMarkerForMethod(inputMethod, file, inputMethod.getReceiver(), lineNbr);
              }
              if (inputMethod.getPermissions() != null) {
                for (String permission : inputMethod.getPermissions()) {
                  String message = "Permission: " + permission;
                  addMarkerForMethod(inputMethod, file, message, lineNbr);
                }
              }
            } catch (CoreException ex) {
              ex.printStackTrace();
            }
          }
        }
        for (MethodModel outputMethod : inputEventBlocks.get(inputMethod)) {
          List<CodeLocationModel> locations = outputMethod.getLines();
          if (locations != null) {
            for (CodeLocationModel location : locations) {
              String clz = location.getClz();
              String classPath = DroidsafePluginUtilities.classNamePath(clz);
              IFile file = project.getFile(classPath);
              int lineNbr = location.getLine();
              if (file.exists()) {
                try {
                  addMarkerForMethod(outputMethod, file, outputMethod.getShortSignature(), lineNbr);
                  addMarkerForMethod(outputMethod, file, outputMethod.getSignature(), lineNbr);
                  if (outputMethod.getPermissions() != null) {
                    for (String permission : outputMethod.getPermissions()) {
                      String message = "Permission: " + permission;
                      addMarkerForMethod(outputMethod, file, message, lineNbr);
                    }
                  }
                  if (outputMethod.getReceiver() != null) {
                    addMarkerForMethod(outputMethod, file, outputMethod.getReceiver(), lineNbr);
                  }
                  List<HotspotModel> hotspots = location.getHotspots();
                  for (HotspotModel hotspot : hotspots) {
                    addMarkerForMethod(outputMethod, file, hotspot.toString(), lineNbr);
                  }
                } catch (CoreException ex) {
                  ex.printStackTrace();
                }
              }
            }
          }
        }
      }
    }
  }

  private static void addMarkerForMethod(MethodModel method, IFile file, String message, int lineNbr)
      throws CoreException {
    IMarker marker = file.createMarker(DROIDSAFE_MARKER_ID);
    marker.setAttribute(IMarker.LINE_NUMBER, lineNbr);
    marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
    marker.setAttribute("methodName", method.getMethodName());
    marker.setAttribute("methodClass", method.getClassName());
    marker.setAttribute(IMarker.MESSAGE, message);
  }

}
