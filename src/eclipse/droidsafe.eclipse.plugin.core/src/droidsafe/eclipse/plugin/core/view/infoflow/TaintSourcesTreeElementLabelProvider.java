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

package droidsafe.eclipse.plugin.core.view.infoflow;

import java.util.Set;

import org.eclipse.swt.graphics.Image;

import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.eclipse.plugin.core.view.DroidsafeImages;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoTreeElementLabelProvider;
import droidsafe.speclang.model.CallLocationModel;
import droidsafe.speclang.model.MethodArgumentModel;
import droidsafe.speclang.model.MethodModel;

/**
 * Label provider for the tree elements of a taint sources outline view.
 * 
 * @author gilham
 *
 */
public class TaintSourcesTreeElementLabelProvider extends DroidsafeInfoTreeElementLabelProvider {
    /**
     * Returns the label for the tree node to display in the tree outline view.
     * 
     * @param element The element to display in the tree node.
     * @return The text for the node label.
     */
    @Override
    public String getText(Object element) {
        if (element instanceof TreeElement<?, ?>) {
            TreeElement<?, ?> treeElement = (TreeElement<?, ?>) element;
            Object data = treeElement.getData();
            if (data instanceof CallLocationModel) {
                CallLocationModel loc = (CallLocationModel) data;
                return "<call> " + DroidsafePluginUtilities.removeCloneSuffix(loc.toString());
            }
        }
        return super.getText(element);
    }

    @Override
    public String getToolTipText(Object obj) {
        if (obj instanceof TreeElement<?, ?>) {
          TreeElement<?, ?> element = (TreeElement<?, ?>) obj;
          Object data = element.getData();
          if (data instanceof CallLocationModel) {
              CallLocationModel loc = (CallLocationModel) data;
              Set<String> infoKinds = loc.getInfoKinds();
              if (infoKinds != null)
                  return infoKinds.toString();
           }
        }
        return null;
      }

    /**
     * Returns the icon image for the tree node.
     * 
     * @param element The tree node element to display.
     * @return The icon image to display together with the label in the outline view.
     */
    public Image getImage(Object element) {
        if (element instanceof TreeElement<?, ?>) {
            TreeElement<?, ?> treeElement = (TreeElement<?, ?>) element;
            Object data = treeElement.getData();
            if (data instanceof CallLocationModel) {
                return DroidsafeImages.SOURCE_IMAGE;
            }
        }
        return null;
    }

    
}
