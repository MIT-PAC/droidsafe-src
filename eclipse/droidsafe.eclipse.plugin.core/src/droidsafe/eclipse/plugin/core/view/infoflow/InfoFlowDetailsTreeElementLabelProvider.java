package droidsafe.eclipse.plugin.core.view.infoflow;

import org.eclipse.swt.graphics.Image;

import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.view.DroidsafeImages;
import droidsafe.eclipse.plugin.core.view.MethodInfoTreeElementLabelProvider;
import droidsafe.speclang.model.CallLocationModel;
import droidsafe.speclang.model.MethodArgumentModel;

/**
 * Label provider for the nodes of the info flow outline view.
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
public class InfoFlowDetailsTreeElementLabelProvider extends MethodInfoTreeElementLabelProvider {
    
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
            if (data instanceof String && treeElement.getParent() != null) {
                return "<kinds> " + data;
            } else if (data instanceof CallLocationModel) {
                CallLocationModel loc = (CallLocationModel) data;
                return "<call> " + loc;
            }
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
            if (data instanceof MethodArgumentModel) {
                MethodArgumentModel methArg = (MethodArgumentModel) data;
                if (methArg.isReceiver())
                    return DroidsafeImages.METHOD_RECEIVER_IMAGE;
                return DroidsafeImages.METHOD_ARG_IMAGE;
            } else if (data instanceof String) {
                TreeElement<?, ?> parent = treeElement.getParent();
                if (parent != null) {
                    if (parent.getData() instanceof MethodArgumentModel)
                        return DroidsafeImages.SOURCE_IMAGE;
                    else
                        return DroidsafeImages.SINK_IMAGE;
                }
            } else if (data instanceof CallLocationModel) {
                return DroidsafeImages.SOURCE_IMAGE;
            }
        }
        return null;
    }

}
