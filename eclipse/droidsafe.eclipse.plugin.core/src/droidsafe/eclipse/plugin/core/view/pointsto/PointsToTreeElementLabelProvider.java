package droidsafe.eclipse.plugin.core.view.pointsto;

import org.eclipse.swt.graphics.Image;

import droidsafe.android.app.Project;
import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.view.DroidsafeImages;
import droidsafe.eclipse.plugin.core.view.MethodInfoTreeElementLabelProvider;
import droidsafe.speclang.model.AllocLocationModel;
import droidsafe.speclang.model.CallLocationModel;
import droidsafe.speclang.model.MethodArgumentModel;

/**
 * Label provider for the nodes of the points-to outline view.
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
public class PointsToTreeElementLabelProvider extends MethodInfoTreeElementLabelProvider {

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
            if (data instanceof AllocLocationModel) {
                AllocLocationModel loc = (AllocLocationModel) data;
                if (loc.getFromAPI()) {
                    return "<new> (from API)";
                } else {
                    return "<new> " + loc;
                }
            } else if (data instanceof CallLocationModel) {
                CallLocationModel loc = (CallLocationModel) data;
                return "<call> " + loc;
            }
            return data.toString();
        }
        return element.toString();
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
            if (data instanceof AllocLocationModel) {
                return DroidsafeImages.ALLOC_NODE_IMAGE;
            } else if (data instanceof CallLocationModel) {
                return DroidsafeImages.CODE_LOC_IMAGE;
            } else if (data instanceof MethodArgumentModel) {
                MethodArgumentModel methArg = (MethodArgumentModel) data;
                if (methArg.isReceiver())
                    return DroidsafeImages.METHOD_RECEIVER_IMAGE;
                return DroidsafeImages.METHOD_ARG_IMAGE;
            }
        }
        return null;
    }

}
