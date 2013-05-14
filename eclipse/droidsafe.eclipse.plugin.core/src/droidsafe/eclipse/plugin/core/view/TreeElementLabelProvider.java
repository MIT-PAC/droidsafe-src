package droidsafe.eclipse.plugin.core.view;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import droidsafe.eclipse.plugin.core.specmodel.DroidsafeMethodModel;
import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.utils.SourceLocationTag;

public class TreeElementLabelProvider extends LabelProvider {


  private static final Image INPUT_METHOD_IMAGE = getImage("android.png");

  private static final Image DEFAULT_IMAGE = PlatformUI.getWorkbench().getSharedImages()
      .getImage(ISharedImages.IMG_OBJ_FOLDER);

  private static final Image SOURCE_LOCATION_IMAGE = PlatformUI.getWorkbench().getSharedImages()
      .getImage(org.eclipse.ui.ide.IDE.SharedImages.IMG_OBJS_TASK_TSK);


  @Override
  public String getText(Object element) {
    if (element instanceof TreeElement<?, ?>) {
      ((TreeElement<?, ?>) element).getName();
    }
    return element.toString();
  }

  @Override
  public Image getImage(Object element) {
    if (element instanceof TreeElement<?, ?>) {
      TreeElement<?, ?> treeElement = (TreeElement<?, ?>) element;
      Object data = treeElement.getData();
      if (data instanceof DroidsafeMethodModel) {
        return INPUT_METHOD_IMAGE;
      } else if (data instanceof SourceLocationTag) {
        return SOURCE_LOCATION_IMAGE;
      }
    }
    return DEFAULT_IMAGE;
  }

  // Helper Method to load the images
  private static Image getImage(String file) {
    Bundle bundle = FrameworkUtil.getBundle(DroidsafeSecSpecLabelProvider.class);
    URL url = FileLocator.find(bundle, new Path("icons/" + file), null);
    ImageDescriptor image = ImageDescriptor.createFromURL(url);
    return image.createImage();
  }
}
