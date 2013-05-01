package droidsafe.eclipse.plugin.core.marker;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.views.markers.WorkbenchMarkerResolution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.eclipse.plugin.core.Activator;
import droidsafe.eclipse.plugin.core.popup.actions.GenerateSecuritySpec;

public class DroidsafeMarkerResolution extends WorkbenchMarkerResolution {
  private final static Logger logger = LoggerFactory.getLogger(DroidsafeMarkerResolution.class);
  private final String MARKERTYPE = "droidsafe.eclipse.plugin.core.droidsafemarker";

  private final IMarker originalMarker;
  private final Image resolvedImage;

  public DroidsafeMarkerResolution(final IMarker marker) {
    super();
    this.originalMarker = marker;
    this.resolvedImage =
        ImageDescriptor.createFromURL(
            FileLocator.find(Activator.getDefault().getBundle(), new Path("icons/success.gif"),
                null)).createImage();
  }


  @Override
  public String getDescription() {
    return "Accept this method as safe";
  }

  @Override
  public Image getImage() {
    return this.resolvedImage;

  }

  @Override
  public String getLabel() {
    return "Mark as safe";
  }

  @Override
  public void run(IMarker marker) {
    try {
      //marker.delete();
      marker.setAttribute(IMarker.DONE, true);
    } catch (CoreException ex) {
      ex.printStackTrace();
    }
  }

  @Override
  public IMarker[] findOtherMarkers(IMarker[] markers) {
    List<IMarker> others = new ArrayList<IMarker>();
    for (IMarker marker : markers) {
      if (isValidOther(marker)) {
        others.add(marker);
      }
    }
    return others.toArray(new IMarker[0]);
  }


  public boolean isValidOther(final IMarker marker) {
    // is it the originalMarker, we don't want duplicates!
    if (marker.equals(originalMarker)) {
      return false;
    }
    try {
      // is it in the same file as original marker?
      if (marker.getType().equals(MARKERTYPE)
          && marker.getResource().equals(originalMarker.getResource())
          && marker.getAttribute(IMarker.MESSAGE).equals(
              originalMarker.getAttribute(IMarker.MESSAGE))) {
        return true;
      }
    } catch (CoreException ex) {
      ex.printStackTrace();
    }
    return false;
  }



}
