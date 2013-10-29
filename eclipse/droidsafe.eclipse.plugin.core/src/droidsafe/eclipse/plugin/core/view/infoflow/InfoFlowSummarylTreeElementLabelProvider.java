package droidsafe.eclipse.plugin.core.view.infoflow;

import org.eclipse.swt.graphics.Image;

import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.view.DroidsafeImages;
import droidsafe.eclipse.plugin.core.view.MethodInfoTreeElementLabelProvider;
import droidsafe.speclang.model.MethodArgumentModel;
import droidsafe.speclang.model.MethodModel;
import droidsafe.transforms.objsensclone.ClassCloner;

/**
 * Label provider for the nodes of the info flow outline view.
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
public class InfoFlowSummarylTreeElementLabelProvider extends MethodInfoTreeElementLabelProvider {
    
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
            return ClassCloner.removeClassCloneSuffix(data.toString());
        }
        return super.getText(element);
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
            if (data instanceof MethodModel) {
                MethodModel meth = (MethodModel) data;
                if (meth.isSafe())
                    return DroidsafeImages.SAFE_ANDROID_WITH_INFO_IMAGE;
                return DroidsafeImages.UNSAFE_ANDROID_WITH_INFO_IMAGE;
            } else if (data instanceof String) {
                return DroidsafeImages.INFO_FLOW_IMAGE;
            }
        }
        return null;
    }

}
