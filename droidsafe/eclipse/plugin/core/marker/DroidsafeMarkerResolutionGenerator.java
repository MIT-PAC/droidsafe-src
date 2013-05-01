package droidsafe.eclipse.plugin.core.marker;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolution2;
import org.eclipse.ui.IMarkerResolutionGenerator2;
import org.eclipse.ui.views.markers.WorkbenchMarkerResolution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.eclipse.plugin.core.Activator;

public class DroidsafeMarkerResolutionGenerator implements IMarkerResolutionGenerator2 {
  private final static Logger logger = LoggerFactory
      .getLogger(DroidsafeMarkerResolutionGenerator.class);

  private static final String MARKER_ID = Activator.getDefault().PLUGIN_ID + ".droidsafemarker";

  @Override
  public IMarkerResolution[] getResolutions(IMarker marker) {
    if (logger.isDebugEnabled()) {
      StringBuffer sb = new StringBuffer();
      try {
        for (String key : marker.getAttributes().keySet()) {
          sb.append("\nAttribute = " + key + " Value = " + marker.getAttribute(key));
        }
      } catch (CoreException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();

      }
      logger.debug(sb.toString());
    }

    List<IMarkerResolution2> resolutions = new ArrayList<IMarkerResolution2>();
    
    //IMarkerResolution2 resolution = new DroidsafeMarkerResolution(marker);
    //resolutions.add(resolution);
    
    IMarkerResolution2 resolution = new SingleMethodResolution(marker);
    resolutions.add(resolution);
    resolution = new AllMethodsResolution(marker);
    resolutions.add(resolution);
    resolution = new ClassResolution(marker);
    resolutions.add(resolution);
    resolution = new FileResolution(marker);
    resolutions.add(resolution);
    
    return resolutions.toArray(new IMarkerResolution[resolutions.size()]);
  }

  @Override
  public boolean hasResolutions(IMarker marker) {
    return true;
  }


  private static class SingleMethodResolution extends WorkbenchMarkerResolution {

    private IMarker marker;

    SingleMethodResolution(IMarker marker) {
      this.marker = marker;
    }

    @Override
    public String getDescription() {
      try {
        return "Mark only this particular occurrence of method "
            + marker.getAttribute("methodName") + " as safe.";
      } catch (CoreException ex) {
        logger.debug("Exception while retrieving attribute name for marker");
      }
      return "Mark only this particular occurrence of this method as safe.";
    }

    @Override
    public Image getImage() {
      return null;
    }

    @Override
    public String getLabel() {
      return "Mark this method as safe";
    }

    @Override
    public void run(IMarker marker) {
      try {
        // marker.delete();
        marker.setAttribute(IMarker.DONE, true);
      } catch (CoreException ex) {
        ex.printStackTrace();
      }

    }

    @Override
    public IMarker[] findOtherMarkers(IMarker[] markers) {
      // TODO Auto-generated method stub
      return null;
    }

  }


  private static class AllMethodsResolution extends WorkbenchMarkerResolution {

    private IMarker marker;

    AllMethodsResolution(IMarker marker) {
      this.marker = marker;
    }

    @Override
    public String getDescription() {
      try {
        return "Mark all occurrences of methods with name " + marker.getAttribute("methodName")
            + " as safe.";
      } catch (CoreException ex) {
        logger.debug("Exception while retrieving attribute name for marker");
      }
      return "Mark all occurrences of this method as safe.";
    }

    @Override
    public Image getImage() {
      return null;
    }

    @Override
    public String getLabel() {
      return "Mark all methods with this name as safe";
    }

    @Override
    public void run(IMarker marker) {
      IMarker markers[];
      try {
        String methodName = marker.getAttribute("methodName").toString();
        IProject project = marker.getResource().getProject();
        if (project != null) {
          markers = project.findMarkers(MARKER_ID, true, IResource.DEPTH_INFINITE);
          for (IMarker mk : markers) {
            if (mk.getAttribute("methodName").equals(methodName))
              mk.setAttribute(IMarker.DONE, true);
          }
        }
        // marker.delete();
        marker.setAttribute(IMarker.DONE, true);
      } catch (CoreException ex) {
        ex.printStackTrace();
      }
    }

    @Override
    public IMarker[] findOtherMarkers(IMarker[] markers) {
      // TODO Auto-generated method stub
      return null;
    }
  }

  private static class ClassResolution extends WorkbenchMarkerResolution {

    private IMarker marker;

    ClassResolution(IMarker marker) {
      this.marker = marker;
    }

    @Override
    public String getDescription() {
      try {
        return "Mark all methods in class " + marker.getAttribute("methodClass") + " as safe.";
      } catch (CoreException ex) {
        logger.debug("Exception while retrieving attribute class for marker");
      }
      return "Mark all methods this class as safe.";
    }

    @Override
    public Image getImage() {
      return null;
    }

    @Override
    public String getLabel() {
      return "Mark all methods in class as safe";
    }

    @Override
    public void run(IMarker marker) {
      IMarker markers[];
      try {
        String className = marker.getAttribute("methodClass").toString();
        IFile file = (IFile) marker.getResource();
        if (file != null) {
          markers = file.findMarkers(MARKER_ID, true, IResource.DEPTH_INFINITE);
          for (IMarker mk : markers) {
            if (mk.getAttribute("methodClass").equals(className))
              mk.setAttribute(IMarker.DONE, true);
          }
        }
        // marker.delete();
        marker.setAttribute(IMarker.DONE, true);
      } catch (CoreException ex) {
        ex.printStackTrace();
      }
    }

    @Override
    public IMarker[] findOtherMarkers(IMarker[] markers) {
      // TODO Auto-generated method stub
      return null;
    }

  }


  private static class FileResolution extends WorkbenchMarkerResolution {

    private IMarker marker;

    FileResolution(IMarker marker) {
      this.marker = marker;
    }

    @Override
    public String getDescription() {
      return "Mark all methods in file " + marker.getResource().getName() + " as safe.";
    }

    @Override
    public Image getImage() {
      return null;
    }

    @Override
    public String getLabel() {
      return "Mark all methods in file as safe";
    }

    @Override
    public void run(IMarker marker) {
      IMarker markers[];
      try {

        IFile file = (IFile) marker.getResource();
        if (file != null) {
          markers = file.findMarkers(MARKER_ID, true, IResource.DEPTH_INFINITE);
          for (IMarker mk : markers) {
            mk.setAttribute(IMarker.DONE, true);
          }
        }
        // marker.delete();
        marker.setAttribute(IMarker.DONE, true);
      } catch (CoreException ex) {
        ex.printStackTrace();
      }
    }

    @Override
    public IMarker[] findOtherMarkers(IMarker[] markers) {
      // TODO Auto-generated method stub
      return null;
    }

  }
}
