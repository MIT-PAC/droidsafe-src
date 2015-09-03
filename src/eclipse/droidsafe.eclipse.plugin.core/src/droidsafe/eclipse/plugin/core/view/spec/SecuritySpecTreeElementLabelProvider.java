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

package droidsafe.eclipse.plugin.core.view.spec;

import java.net.URL;
import java.util.Set;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.TextStyle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.eclipse.plugin.core.view.DroidsafeImages;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoTreeElementLabelProvider;
import droidsafe.speclang.model.CodeLocationModel;
import droidsafe.speclang.model.HotspotModel;
import droidsafe.speclang.model.MethodModel;
import droidsafe.speclang.model.MethodsToHighlight;
import droidsafe.transforms.objsensclone.ClassCloner;

/**
 * Label provider for the nodes of the Droidsafe outline view.
 * 
 * @author Marcel Becker (becker@kestrel.edu)
 * 
 */
public class SecuritySpecTreeElementLabelProvider extends DroidsafeInfoTreeElementLabelProvider {

  /** Logger for class */
  @SuppressWarnings("unused")
  private static final Logger logger = LoggerFactory.getLogger(SecuritySpecTreeElementLabelProvider.class);

  private boolean useShortSignatureForMethods = true;

  private static Font boldFont;

  static {
    FontData[] fontData = Display.getCurrent().getSystemFont().getFontData();
    FontData[] styleData = new FontData[fontData.length];
    for (int i = 0; i < styleData.length; i++) {
      FontData base = fontData[i];
      styleData[i] = new FontData(base.getName(), base.getHeight(), base.getStyle() | SWT.BOLD);
    }
    boldFont = new Font(Display.getCurrent(), styleData);
  }

  /**
   * Method to set the boolean to control what type of labels should be used for method nodes in the
   * outline. Returns the previous value of the flag so the view will know if it needs to refresh or
   * not.
   * 
   * @param useShortSignature A boolean that tells if the label for methods nodes should use the
   *        short signature (value TRUE) or if it shoul use the long signature (value FALSE).
   * @return The previous value of the flag so we know if a view refresh is required.
   * 
   */
  public boolean setUseShortSignatureForMethods(boolean useShortSignature) {
    boolean oldValue = this.useShortSignatureForMethods;
    this.useShortSignatureForMethods = useShortSignature;
    return oldValue;
  }

  /**
   * Returns the label for the tree node to display in the tree outline view.
   * 
   * @param element The element to display in the tree node.
   * @return The text for the node label.
   */
  // @Override
  public String getText(Object element) {
    if (element instanceof TreeElement<?, ?>) {
      Object data = ((TreeElement<?, ?>) element).getData();
      if (data instanceof MethodModel) {
        MethodModel method = (MethodModel) data;
        if (!useShortSignatureForMethods) {
          return DroidsafePluginUtilities.removeCloneSuffix(method.getSignature());
        } else {
          return DroidsafePluginUtilities.removeCloneSuffix(method.getShortSignature());
        }
      } else if (data instanceof HotspotModel) {
          return "hotspot: argument " + (((HotspotModel)data).getArgumentPosition() + 1);
      }
    }
    return DroidsafePluginUtilities.removeCloneSuffix(element.toString());
  }

  @Override
  public String getToolTipText(Object obj) {
    if (obj instanceof TreeElement<?, ?>) {
      TreeElement<?, ?> element = (TreeElement<?, ?>) obj;
      Object data = element.getData();
      if (data instanceof MethodModel) {
        MethodModel method = (MethodModel) data;
        StringBuffer sb = new StringBuffer();
        if (!useShortSignatureForMethods) {
          sb.append(method.getShortSignature());
        } else {
          sb.append(method.getSignature());
        }

        Set<String> permissions = method.getPermissions();
        if (permissions != null) {
          for (String permission : permissions) {
            sb.append("\n");
            sb.append("Permission: ");
            sb.append(permission);
          }
        }
        if (method.isNative()) {
          sb.append("\nNATIVE METHOD");
        }
        return DroidsafePluginUtilities.removeCloneSuffix(sb.toString());
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
  @Override
  public Image getImage(Object element) {
    if (element instanceof TreeElement<?, ?>) {
      TreeElement<?, ?> treeElement = (TreeElement<?, ?>) element;
      Object data = treeElement.getData();
      // logger.info("Data = {}", data);
      if (data instanceof MethodModel) {
        MethodModel method = (MethodModel) data;
        boolean hasInfoFlow = method.hasInfoFlowInfo();
        if (method.isUnsafe()) {
            if (hasInfoFlow) {
                return DroidsafeImages.UNSAFE_ANDROID_WITH_INFO_IMAGE;
            } else {
                return DroidsafeImages.UNSAFE_ANDROID_IMAGE;
            }
        } else if (hasInfoFlow) {
            return DroidsafeImages.SAFE_ANDROID_WITH_INFO_IMAGE;
        } else {
            return DroidsafeImages.SAFE_ANDROID_IMAGE;
        }
      /*
      } else if (data instanceof CodeLocationModel) {
        CodeLocationModel line = (CodeLocationModel) data;
        if (line.isSafe()) {
          return DroidsafeImages.SAFE_SOURCE_LOCATION_IMAGE;
        } else if (line.isUnsafe()) {
          return DroidsafeImages.UNSAFE_SOURCE_LOCATION_IMAGE;
        } else {
          return DroidsafeImages.UNRESOLVED_SOURCE_LOCATION_IMAGE;
        }
    	return null;
      } else if (data instanceof HotspotModel) {
        return DroidsafeImages.UNSAFE_ANDROID_IMAGE;
      */
      }

    }
    return DroidsafeImages.DEFAULT_IMAGE;
  }

//  /**
//   * A styler to allow the label of the node to be strikeout.
//   */
//  private static StyledString.Styler STRIKEOUT = new StyledString.Styler() {
//    @Override
//    public void applyStyles(TextStyle textStyle) {
//      textStyle.strikeout = true;
//    }
//  };

//  private static final Color RED = Display.getDefault().getSystemColor(SWT.COLOR_RED);
//  private static final Color BLUE = Display.getDefault().getSystemColor(SWT.COLOR_BLUE);

//  /**
//   * A styler to allow the label of the node to be red.
//   */
//  private static StyledString.Styler RED_FOREGROUND = new StyledString.Styler() {
//
//    @Override
//    public void applyStyles(TextStyle textStyle) {
//      textStyle.foreground = RED;
//      textStyle.font = boldFont;
//    }
//  };

//  /**
//   * A styler to allow the label of the node to be blue.
//   */
//  private static StyledString.Styler BLUE_FOREGROUND = new StyledString.Styler() {
//
//    @Override
//    public void applyStyles(TextStyle textStyle) {
//      textStyle.foreground = BLUE;
//      textStyle.font = boldFont;
//    }
//  };

//  /**
//   * A styler to allow the label of the node to be bold.
//   */
//  private static StyledString.Styler BOLD = new StyledString.Styler() {
//
//    @Override
//    public void applyStyles(TextStyle textStyle) {
//      textStyle.font = boldFont;
//    }
//  };

//  /**
//   * The method that provides the desired style for the Tree node label.
//   * 
//   * @see org.eclipse.jface.viewers.StyledCellLabelProvider#update(org.eclipse.jface.viewers.ViewerCell)
//   */
//  @Override
//  public void update(ViewerCell cell) {
//    Object obj = cell.getElement();
//    StyledString styledString = new StyledString(getText(obj));
//
//    if (obj instanceof TreeElement<?, ?>) {
//      TreeElement<?, ?> element = (TreeElement<?, ?>) obj;
//      Object data = element.getData();
//      if (data instanceof MethodModel) {
//        MethodModel method = (MethodModel) data;
//        
//        if (method.isSafe()) {
//          styledString.setStyle(0, styledString.length(), STRIKEOUT);
//          
//        } else if (method.getPermissions() != null && !method.getPermissions().isEmpty()) {
//          styledString.setStyle(0, styledString.length(), RED_FOREGROUND);
//          
//        } else if (method.isNative()) {
//          styledString.setStyle(0, styledString.length(), RED_FOREGROUND);
//          
//        } else if (MethodsToHighlight.shouldHighlightMethd(method)) {
//          styledString.setStyle(0, styledString.length(), BLUE_FOREGROUND);
//          
//        } else if (method.getReceiver() != null && !method.getReceiver().equals("")) {
//          styledString.setStyle(0, styledString.length(), BOLD);
//        }
//      } else if (data instanceof CodeLocationModel && ((CodeLocationModel) data).isSafe()) {
//        styledString.setStyle(0, styledString.length(), STRIKEOUT);
//      }
//
//    }
//    cell.setText(styledString.toString());
//    cell.setStyleRanges(styledString.getStyleRanges());
//    cell.setText(getText(obj));
//    cell.setImage(getImage(obj));
//    super.update(cell);
//  }

}
