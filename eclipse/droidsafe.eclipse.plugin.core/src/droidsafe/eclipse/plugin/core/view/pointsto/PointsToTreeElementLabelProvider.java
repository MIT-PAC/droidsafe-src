package droidsafe.eclipse.plugin.core.view.pointsto;

import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.speclang.model.AllocLocationModel;
import droidsafe.speclang.model.CallLocationModel;

/**
 * Label provider for the nodes of the points-to outline view.
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
public class PointsToTreeElementLabelProvider extends StyledCellLabelProvider {// LabelProvider
    // {

    /** The image for a method receiver node in the points-to outline view */
    private static final Image METHOD_RECEIVER_IMAGE = DroidsafePluginUtilities.getImage("meth-receiver.png");

    /** The image for a method argument node in the points-to outline view */
    private static final Image METHOD_ARG_IMAGE = DroidsafePluginUtilities.getImage("meth-arg.png");

    /** The image for an allocation node in the points-to outline view */
    private static final Image ALLOC_NODE_IMAGE = DroidsafePluginUtilities.getImage("pointsto.png");

    /** The image for a call edge in the points-to outline view */
    private static final Image CALL_EDGE_IMAGE = DroidsafePluginUtilities.getImage("change.png");

//    /** The image for a call edge in the points-to outline view */
//    private static final Image[] METHOD_ARG_IMAGES;
//
//    static {
//        METHOD_ARG_IMAGES = new Image[5];
//        for (int i = 0; i <= 4; i++) {
//            METHOD_ARG_IMAGES[i] = DroidsafePluginUtilities.getImage("meth-arg" + (i + 1) + ".png");
//        }
//    }
    
    /**
     * Returns the label for the tree node to display in the tree outline view.
     * 
     * @param element The element to display in the tree node.
     * @return The text for the node label.
     */
    // @Override
    public String getText(Object element) {
        if (element instanceof TreeElement<?, ?>) {
            TreeElement<?, ?> treeElement = (TreeElement<?, ?>) element;
            Object data = treeElement.getData();
            if (data instanceof AllocLocationModel) {
                AllocLocationModel loc = (AllocLocationModel) data;
                return "<new> " + loc;
            } else if (data instanceof CallLocationModel) {
                CallLocationModel loc = (CallLocationModel) data;
                return "<call> " + loc;
            }
            return data.toString();
        }
        return element.toString();
    }

    @Override
    public String getToolTipText(Object obj) {
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
            if (data instanceof AllocLocationModel) {
                return ALLOC_NODE_IMAGE;
            } else if (data instanceof CallLocationModel) {
                return CALL_EDGE_IMAGE;
            } else if (data instanceof MethodArgumentModel) {
                MethodArgumentModel methArg = (MethodArgumentModel) data;
                if (methArg.isReceiver())
                    return METHOD_RECEIVER_IMAGE;
//                int argIndex = methArg.getArgumentIndex();
//                if (argIndex < METHOD_ARG_IMAGES.length)
//                    return METHOD_ARG_IMAGES[argIndex];
                return METHOD_ARG_IMAGE;
            }
        }
        return null;
    }

    /**
     * The method that provides the desired style for the Tree node label.
     * 
     * @see org.eclipse.jface.viewers.StyledCellLabelProvider#update(org.eclipse.jface.viewers.ViewerCell)
     */
    @Override
    public void update(ViewerCell cell) {
      Object obj = cell.getElement();
      StyledString styledString = new StyledString(getText(obj));
      cell.setText(styledString.toString());
      cell.setStyleRanges(styledString.getStyleRanges());
      cell.setImage(getImage(obj));
      super.update(cell);
    }

}
