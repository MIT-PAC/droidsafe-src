/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */

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

public class DroidsafeMarkerResolution extends WorkbenchMarkerResolution {
  @SuppressWarnings("unused")
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
      // marker.delete();
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
