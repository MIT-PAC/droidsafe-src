package droidsafe.eclipse.plugin.core.view.callgraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoTreeElementContentProvider;
import droidsafe.eclipse.plugin.core.view.indicator.Utils;

public class CallGraphTreeElementContentProvider extends DroidsafeInfoTreeElementContentProvider {

    protected Map<Object, Object[]> inputToRoots = new HashMap<Object, Object[]>();

    /** The object on which the droidsafe analysis info is to be displayed in the outline view */
    protected CallGraph fInput;

    @Override
    public Object[] getElements(Object input) {
        this.fInput = (CallGraph) input;
        Object[] roots = inputToRoots.get(input);
        if (roots == null) {
            roots = initializeRoots();
            inputToRoots.put(input, roots);
        }
        return roots;
    }

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        this.fViewer = (TreeViewer) viewer;
        this.fInput = (CallGraph) newInput;
    }

    /**
     * Reset the content of this content provider.
     */
    @Override
    protected void reset() {
        inputToRoots.clear();
    }
    /**
     * Populate the tree elements of the info sources outline view. Return the root elements.
     */
    protected Object[] initializeRoots() {
    	getTreeElementMap().clear();
    	List<TreeElement<JsonElement, JsonElement>> roots = new ArrayList<TreeElement<JsonElement, JsonElement>>();
    	Set<JsonElement> rootNodes = fInput.getRoots();
    	boolean calleeBased = fInput.isCalleeBased();
    	for (JsonElement rootElement: rootNodes) {
    		if (!Utils.isEmptyJsonObject(rootElement)) {
    			TreeElement<JsonElement, JsonElement> root = (calleeBased) 
    					? initializeCalleeTree(rootElement)
    					: initializeCallerTree(rootElement);
    			roots.add(root);
    		}
    	}
    	return roots.toArray();
    }

    private TreeElement<JsonElement, JsonElement> initializeCalleeTree(JsonElement jsonElement) {
    	TreeElement<JsonElement, JsonElement> element = new TreeElement<JsonElement, JsonElement>(jsonElement.toString(), jsonElement, JsonElement.class);
    	getTreeElementMap().put(jsonElement, element);
    	JsonArray childrenArray = Utils.getChildrenArray(jsonElement);
    	if (childrenArray != null) {
    		for (int i = 0; i < childrenArray.size(); i++) {
    			JsonElement childElement = childrenArray.get(i);
    			if (!Utils.isEmptyJsonObject(childElement)) {
    				TreeElement<JsonElement, JsonElement> child = initializeCalleeTree(childElement);
    				element.addChild(child);
    			}
    		}
    	}
    	return element;
    }

    private TreeElement<JsonElement, JsonElement> initializeCallerTree(JsonElement jsonElement) {
    	TreeElement<JsonElement, JsonElement> element = new TreeElement<JsonElement, JsonElement>(jsonElement.toString(), jsonElement, JsonElement.class);
    	getTreeElementMap().put(jsonElement, element);
    	Set<JsonElement> callers = CallGraph.callerMap.get(jsonElement);
    	if (callers != null) {
    		for (JsonElement callerElement: callers) {
    			TreeElement<JsonElement, JsonElement> caller = initializeCalleeTree(callerElement);
    			element.addChild(caller);
    		}
    	}
    	return element;
    }

}
