package droidsafe.eclipse.plugin.core.view;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.TextStyle;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.eclipse.plugin.core.specmodel.CodeLocationModel;
import droidsafe.eclipse.plugin.core.specmodel.MethodModel;
import droidsafe.eclipse.plugin.core.specmodel.TreeElement;

/**
 * Label provider for the nodes of the Droidsafe outline view.
 * 
 * @author Marcel Becker (becker@kestrel.edu)
 * 
 */
public class TreeElementLabelProvider extends StyledCellLabelProvider {// LabelProvider {

  private static final Logger logger = LoggerFactory.getLogger(TreeElementLabelProvider.class);

  /** The image for the method node in the outline view */
  private static final Image INPUT_METHOD_IMAGE = getImage("android.png");

  /** The image for the unsafe method node in the outline view */
  private static final Image UNSAFE_METHOD_IMAGE = getImage("red-android.png");

  /** The image for whitelist entry in the outline view */
  private static final Image DEFAULT_IMAGE = PlatformUI.getWorkbench().getSharedImages()
      .getImage(ISharedImages.IMG_OBJ_FOLDER);

  /** The image to use for safe code locations */
  private static final Image SAFE_SOURCE_LOCATION_IMAGE = PlatformUI.getWorkbench()
      .getSharedImages().getImage(org.eclipse.ui.ide.IDE.SharedImages.IMG_OBJS_TASK_TSK);

  /** Image for unresolved code locations */
  private static final Image UNRESOLVED_SOURCE_LOCATION_IMAGE = PlatformUI.getWorkbench()
      .getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);

  /** Image for unsafe code locations */
  private static final Image UNSAFE_SOURCE_LOCATION_IMAGE = PlatformUI.getWorkbench()
      .getSharedImages().getImage(ISharedImages.IMG_OBJS_ERROR_TSK);


  // @Override
  public String getText(Object element) {
    if (element instanceof TreeElement<?, ?>) {
      ((TreeElement<?, ?>) element).getName();
    }
    return element.toString();
  }

  // @Override
  public Image getImage(Object element) {
    if (element instanceof TreeElement<?, ?>) {
      TreeElement<?, ?> treeElement = (TreeElement<?, ?>) element;
      Object data = treeElement.getData();
      logger.debug("Data = {}", data);
      if (data instanceof MethodModel) {
        MethodModel method = (MethodModel) data;
        if (method.isUnsafe()) {
          return UNSAFE_METHOD_IMAGE;
        } else {
          return INPUT_METHOD_IMAGE;
        }
      } else if (data instanceof CodeLocationModel) {
        CodeLocationModel line = (CodeLocationModel) data;
        if (line.isSafe()) {
          return SAFE_SOURCE_LOCATION_IMAGE;
        } else if (line.isUnsafe()) {
          return UNSAFE_SOURCE_LOCATION_IMAGE;
        } else {
          return UNRESOLVED_SOURCE_LOCATION_IMAGE;
        }
      }
    }
    return DEFAULT_IMAGE;
  }

  /** A styler to allow the label of the node to be strikeout. */
  private static StyledString.Styler STRIKEOUT = new StyledString.Styler() {
    @Override
    public void applyStyles(TextStyle textStyle) {
      textStyle.strikeout = true;
    }
  };

  @Override
  public void update(ViewerCell cell) {
    Object obj = cell.getElement();
    StyledString styledString = new StyledString(getText(obj));

    if (obj instanceof TreeElement<?, ?>) {
      TreeElement<?, ?> element = (TreeElement<?, ?>) obj;
      Object data = element.getData();
      if (data instanceof MethodModel && ((MethodModel) data).isSafe()) {
        styledString.setStyle(0, styledString.length(), STRIKEOUT);
      } else if (data instanceof CodeLocationModel && ((CodeLocationModel) data).isSafe()) {
        styledString.setStyle(0, styledString.length(), STRIKEOUT);
      }

    }
    cell.setText(styledString.toString());
    cell.setStyleRanges(styledString.getStyleRanges());
    cell.setImage(getImage(obj));
    super.update(cell);
  }

  // Helper Method to load the images
  private static Image getImage(String file) {
    Bundle bundle = FrameworkUtil.getBundle(DroidsafeSecSpecLabelProvider.class);
    URL url = FileLocator.find(bundle, new Path("icons/" + file), null);
    ImageDescriptor image = ImageDescriptor.createFromURL(url);
    return image.createImage();
  }
}
