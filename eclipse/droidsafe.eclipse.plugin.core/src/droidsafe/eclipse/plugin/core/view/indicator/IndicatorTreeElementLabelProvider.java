package droidsafe.eclipse.plugin.core.view.indicator;

import org.eclipse.swt.graphics.Image;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.eclipse.plugin.core.view.DroidsafeImages;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoTreeElementLabelProvider;
import droidsafe.speclang.model.AllocLocationModel;
import droidsafe.speclang.model.CallLocationModel;
import droidsafe.speclang.model.MethodArgumentModel;

/**
 * Label provider for the nodes of an indicator outline view.
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
public class IndicatorTreeElementLabelProvider extends DroidsafeInfoTreeElementLabelProvider {

    /** The underlying indicator outline view.*/
    private IndicatorViewPart viewPart;
    
    /**
     * Constructs a IndicatorTreeElementLabelProvider with a given indicator
     * outline view.
     */
    public IndicatorTreeElementLabelProvider(IndicatorViewPart viewPart) {
        this.viewPart = viewPart;
    }

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
            if (data instanceof JsonObject) {
                JsonObject jsonObj = (JsonObject) data;
                return viewPart.getLabel(jsonObj);
            }
            return DroidsafePluginUtilities.removeCloneSuffix(data.toString());
        }
        return DroidsafePluginUtilities.removeCloneSuffix(element.toString());
    }

    /**
     * Returns the tool tip for the tree node to display in the tree outline view.
     * 
     * @param element The element to display in the tree node.
     * @return The tool tip text for the node.
     */
    public String getToolTipText(Object element) {
        if (element instanceof TreeElement<?, ?>) {
            TreeElement<?, ?> treeElement = (TreeElement<?, ?>) element;
            Object data = treeElement.getData();
            return (data instanceof JsonElement) ? Utils.toStringPretty((JsonElement)data) : data.toString();
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
