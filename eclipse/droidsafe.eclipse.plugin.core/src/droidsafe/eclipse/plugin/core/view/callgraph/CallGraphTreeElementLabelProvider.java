package droidsafe.eclipse.plugin.core.view.callgraph;

import java.util.Set;

import org.eclipse.swt.graphics.Image;

import com.google.gson.JsonObject;

import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoTreeElementLabelProvider;
import droidsafe.eclipse.plugin.core.view.indicator.IndicatorViewPart;
import droidsafe.eclipse.plugin.core.view.indicator.Utils;
import droidsafe.speclang.model.MethodModel;

public class CallGraphTreeElementLabelProvider extends DroidsafeInfoTreeElementLabelProvider {

	private CallGraphViewPart viewPart;
    
    public CallGraphTreeElementLabelProvider(CallGraphViewPart viewPart) {
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
    			String sig = Utils.getFieldValueAsString(jsonObj, "signature");
    			if (sig != null) {
    				sig = sig.substring(1, sig.length() - 1);
    				return sig;
    			}
    			return DroidsafePluginUtilities.removeCloneSuffix(data.toString());
    		} else if (data instanceof SourceMethodNode) {
    			String sig = ((SourceMethodNode)data).signature;
    			if (sig != null) {
    				sig = sig.substring(1, sig.length() - 1);
    				return sig;
    			}
    		}
    	}
    	return DroidsafePluginUtilities.removeCloneSuffix(element.toString());
    }

    public String getToolTipText(Object element) {
    	if (element instanceof TreeElement<?, ?>) {
    		TreeElement<?, ?> treeElement = (TreeElement<?, ?>) element;
    		Set<MethodModel> methods = viewPart.getMethodModels(treeElement);
    		if (methods.size() > 1) {
                Object data = treeElement.getData();
                if (data instanceof JsonObject)
                	return methods.size() + " contexts";
                if (data instanceof SourceMethodNode)
                	return methods.size() + " calls with contexts";
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
        return null;
    }

    
}
