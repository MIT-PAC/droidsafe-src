package droidsafe.eclipse.plugin.core.view;

import java.net.URL;
import java.util.Set;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import droidsafe.speclang.Method;
import droidsafe.utils.SourceLocationTag;

public class SecuritySpecLabelProvider extends LabelProvider {


  private static final Image INPUT_METHOD_IMAGE = getImage("android.png");
  // PlatformUI.getWorkbench().getSharedImages()
  // .getImage(ISharedImages.IMG_OBJ_ELEMENT);
  private static final Image DEFAULT_IMAGE = PlatformUI.getWorkbench().getSharedImages()
      .getImage(ISharedImages.IMG_OBJ_FOLDER);

  private static final Image SOURCE_LOCATION_IMAGE = PlatformUI.getWorkbench().getSharedImages()
      .getImage(org.eclipse.ui.ide.IDE.SharedImages.IMG_OBJS_TASK_TSK);
 
  
  @Override
  public String getText(Object element) {
    if (element instanceof Set) {
      int size = ((Set<?>) element).size();
      return "Whitelist (" + size + ")";
    } else if (element instanceof Method) {
      return ((Method) element).toSignatureString();
    }
    return element.toString();
  }

  @Override
  public Image getImage(Object element) {
    if (element instanceof Method) {
      return INPUT_METHOD_IMAGE;
    } else if (element instanceof SourceLocationTag) {
      return SOURCE_LOCATION_IMAGE;
    }
    return DEFAULT_IMAGE;
  }

  // Helper Method to load the images
  private static Image getImage(String file) {
    Bundle bundle = FrameworkUtil.getBundle(SecuritySpecLabelProvider.class);
    URL url = FileLocator.find(bundle, new Path("icons/" + file), null);
    ImageDescriptor image = ImageDescriptor.createFromURL(url);
    return image.createImage();
  }
}
